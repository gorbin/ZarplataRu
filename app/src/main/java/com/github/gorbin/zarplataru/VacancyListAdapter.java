package com.github.gorbin.zarplataru;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class VacancyListAdapter extends ArrayAdapter<Vacancy> {
    private Context context;
    private ArrayList<Vacancy> vacancies = new ArrayList<Vacancy>();
    public static final  String NODATA = "undefined";

    public VacancyListAdapter(Context context, int layoutResourceId, ArrayList<Vacancy> vacancies) {
        super(context, layoutResourceId, vacancies);
        this.context = context;
        this.vacancies = vacancies;
    }

    public void refreshEvents(List<Vacancy> events) {
        this.vacancies.clear();
        this.vacancies.addAll(events);
        notifyDataSetChanged();
    }

    static class ViewHolder {
        public TextView headerTextView;
        public TextView companyTitleTextView;
        public ImageView imageView;
    }

    @Override
    public int getCount() {
        return vacancies.size();
    }

    @Override
    public Vacancy getItem(int i) {
        return vacancies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        View rowView = convertView;
        Context context = parent.getContext();
        if (rowView == null) {

            LayoutInflater inflater = LayoutInflater.from(context);
//            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.recyclerview_item, null, true);
            holder = new ViewHolder();
            holder.headerTextView = (TextView) rowView.findViewById(R.id.headerTextView);
            holder.companyTitleTextView = (TextView) rowView.findViewById(R.id.companyTitleTextView);
            holder.imageView = (ImageView) rowView.findViewById(R.id.logoImageView);
            rowView.setTag(holder);
        } else {
            holder = (ViewHolder) rowView.getTag();
        }
        holder.headerTextView.setText(vacancies.get(position).getHeader());
        if(vacancies.get(position).getCompany() != null) {
            holder.companyTitleTextView.setText(vacancies.get(position).getCompany().getTitle());
        } else {
            holder.companyTitleTextView.setText(NODATA);
        }

        if(vacancies.get(position).getCompany() != null && vacancies.get(position).getCompany().getLogo() != null) {
            Picasso.with(context)
                    .load(vacancies.get(position).getCompany().getLogo().getUrl())
                    .error(R.drawable.logo)
                    .into(holder.imageView);
        } else {
            holder.imageView.setImageResource(R.drawable.logo);
        }

        return rowView;
    }
}

