package com.github.gorbin.zarplataru;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    public static final String DETAIL_INTENT = "VACANCY";
    public ArrayList<Vacancy> vacancies = new ArrayList<Vacancy>();
    private VacancyListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setOnItemClickListener(this);


        adapter = new VacancyListAdapter(getApplicationContext(), R.layout.activity_main, vacancies);
        listView.setAdapter(adapter);

        listView.setOnScrollListener(new EndlessScrollListener() {
            @Override
            public boolean onLoadMore(int page, int totalItemsCount) {
                if(isOnline()) {
                    String url = NetworkManager.getInstance().createURL(totalItemsCount);
                    if(url != "") {
                        NetworkManager.getInstance().requestVacancies(getApplicationContext(), url);
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    showError(R.string.connection_error);
                    return false;
                }
            }
        });

        NetworkManager.getInstance().setNetworkListener(new NetworkManager.NetworkListener() {
            @Override
            public void onDone(ArrayList<Vacancy> vacancies) {
                setVacancies(vacancies);
                adapter.refreshEvents(vacancies);
            }

            @Override
            public void onError(String tag) {
                Snackbar.make(findViewById(android.R.id.content), tag, Snackbar.LENGTH_LONG).show();
            }
        });

        if(isOnline()) {
            String url = NetworkManager.getInstance().createURL(0);
            if(url != "") {
                NetworkManager.getInstance().requestVacancies(getApplicationContext(), url);
            }
        } else {
            showError(R.string.connection_error);
        }
    }

    public void setVacancies(ArrayList<Vacancy> vacancies){
        this.vacancies = vacancies;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(!vacancies.isEmpty()) {
            Intent intent = new Intent(MainActivity.this,DetailActivity.class);
            intent.putExtra(DETAIL_INTENT, vacancies.get(position));
            startActivity(intent);
        }
    }

    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public void showError(int error){
        Snackbar.make(findViewById(android.R.id.content), error, Snackbar.LENGTH_LONG).setAction(R.string.done, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        }).show();
    }
}
