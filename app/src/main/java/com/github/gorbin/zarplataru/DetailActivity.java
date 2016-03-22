package com.github.gorbin.zarplataru;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_view);
        Vacancy vacancy = new Vacancy();
        if(getIntent().getExtras() != null) {
            vacancy = getIntent().getExtras().getParcelable(MainActivity.DETAIL_INTENT);
        }

        TextView header = (TextView) findViewById(R.id.header);
        if (vacancy != null) {
            header.setText(vacancy.getHeader());
        }

        TextView company = (TextView) findViewById(R.id.company);
        String companyAndAddDate = "";
        if (vacancy != null && vacancy.getCompany() != null) {
            companyAndAddDate = vacancy.getCompany().getTitle()+", ";
        }
        if (vacancy != null) {
            companyAndAddDate += vacancy.getAdd_date();
        }
        company.setText(companyAndAddDate);


        TextView salary = (TextView) findViewById(R.id.salary);
        if (vacancy != null) {
            salary.setText(getResources().getString(R.string.salary, vacancy.getSalary()));
        }

        TextView schedule = (TextView) findViewById(R.id.schedule);
        if (vacancy != null && vacancy.getSchedule() != null) {
            schedule.setText(vacancy.getSchedule().getTitle());
        }
        TextView education = (TextView) findViewById(R.id.education);
        if (vacancy != null && vacancy.getEducation() != null) {
            education.setText(vacancy.getEducation().getTitle());
        }
        TextView working_type = (TextView) findViewById(R.id.work_type);
        if (vacancy != null && vacancy.getWorking_type() != null) {
            working_type.setText(vacancy.getWorking_type().getTitle());
        }
        TextView expirience_lenght = (TextView) findViewById(R.id.expirience);
        if (vacancy != null && vacancy.getExpirience_lenght() != null) {
            expirience_lenght.setText(vacancy.getExpirience_lenght().getTitle());
        }
        TextView description = (TextView) findViewById(R.id.description);
        if (vacancy != null) {
            description.setText(Html.fromHtml(vacancy.getDescription()));
        }

    }

}
