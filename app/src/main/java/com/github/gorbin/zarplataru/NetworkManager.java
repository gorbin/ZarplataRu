package com.github.gorbin.zarplataru;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class NetworkManager {
    public static final int LIMIT = 30;
    public static final int CITY_ID = 54;
    private int count = 0;

    private static NetworkManager mInstance = null;

    private ArrayList<Vacancy> vacancies = new ArrayList<Vacancy>();

    private NetworkListener networkListener = null;

    public interface NetworkListener {
        void onDone(ArrayList<Vacancy> vacancies);
        void onError(String tag);
    }

    public void setNetworkListener(NetworkListener doneListener) {
        this.networkListener = doneListener;
    }


    private NetworkManager(){
    }

    public static NetworkManager getInstance(){
        if(mInstance == null)
        {
            mInstance = new NetworkManager();
        }
        return mInstance;
    }

    public void requestVacancies(Context context, String url){

        RequestQueue queue = Volley.newRequestQueue(context);

        if(url != "") {
            JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {
                    // context1.findViewById(R.id.progressBar1).setVisibility(View.GONE);
                    try {
                        ArrayList<Vacancy> vacanciesFromJSON = new ArrayList<Vacancy>();
                        JSONObject meta = response.getJSONObject("metadata");
                        JSONObject resultset = meta.getJSONObject("resultset");
                        count = resultset.getInt("count");
                        JSONArray jsonVacancies = response.getJSONArray("vacancies");
                        Gson gson = new Gson();
                        vacanciesFromJSON = gson.fromJson(jsonVacancies.toString(), new TypeToken<ArrayList<Vacancy>>() {
                        }.getType());
                        vacancies.addAll(vacanciesFromJSON);
                        networkListener.onDone(vacancies);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        networkListener.onError(e.toString());
                    }
                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    networkListener.onError(error.toString());
                }
            });

            queue.add(stringRequest);
        }
    }

    public String createURL(int offset) {
        String url = "";
        if(count == 0 || count > offset) {
            url = "http://www.zarplata.ru/api/v1/vacancies/?limit=" + LIMIT + "&offset=" + offset;
            if (CITY_ID > 0 && CITY_ID < 89)
                url += "&geo_id=" + CITY_ID;
        }
        return url;
    }
}
