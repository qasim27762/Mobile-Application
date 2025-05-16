package com.example.assignment2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CountryAdapter extends BaseAdapter {
    private Context context;
    private List<Country> countries;

    public CountryAdapter(Context context, List<Country> countries) {
        this.context = context;
        this.countries = countries;
    }

    @Override
    public int getCount() {
        return countries.size();
    }

    @Override
    public Object getItem(int position) {
        return countries.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false);
        }

        ImageView flagImageView = convertView.findViewById(R.id.flagImageView);
        TextView nameTextView = convertView.findViewById(R.id.nameTextView);

        Country country = countries.get(position);
        flagImageView.setImageResource(country.getFlagResId());
        nameTextView.setText(country.getName());

        return convertView;
    }
}
