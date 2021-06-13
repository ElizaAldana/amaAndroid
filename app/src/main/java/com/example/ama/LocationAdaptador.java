package com.example.ama;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LocationAdaptador extends BaseAdapter {

    private ArrayList<Location> locations;

    public LocationAdaptador(){
        locations = new ArrayList<>();
    }

    public void addLocation(Location location){
        locations.add(location);
        notifyDataSetChanged();

    }

    public void clear(){
        locations.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return locations.size();
    }

    @Override
    public Object getItem(int position) {
        return locations.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int pos, View row, ViewGroup list) {
        LayoutInflater inflater = LayoutInflater.from(list.getContext());
        View rowView = inflater.inflate(R.layout.renglon,null);

        Location location = locations.get(pos);

        TextView nombreListView = rowView.findViewById(R.id.nombreListView);
        TextView descripcionListView = rowView.findViewById(R.id.descripcionListView);
        ImageView masInfo = rowView.findViewById(R.id.masInfo);

        nombreListView.setText(location.getNombre());
        descripcionListView.setText(location.getDescripcion());

        View.OnClickListener listener = (v) ->{
            Intent i = new Intent(list.getContext(), MapaActivity.class);
            i.putExtra("name", location.getNombre());
            list.getContext().startActivity(i);
        };
        masInfo.setOnClickListener(listener);
        nombreListView.setOnClickListener(listener);
        descripcionListView.setOnClickListener(listener);

        return rowView;
    }
}
