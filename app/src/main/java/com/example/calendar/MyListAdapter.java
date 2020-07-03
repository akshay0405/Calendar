package com.example.calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;



import java.util.List;

public class MyListAdapter extends ArrayAdapter<Datalist> {
   List<Datalist> datalistList;
    Context context;
    int resource;



    public MyListAdapter(@NonNull Context context, int resource, List<Datalist> datalistList) {
        super(context, resource,datalistList);
        this.context=context;
        this.resource=resource;
        this.datalistList = datalistList;

    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(resource,null,false);
        ImageView imageView=view.findViewById(R.id.image_event);
        TextView heading=view.findViewById(R.id.title_event);
        TextView desc=view.findViewById(R.id.description);
        Datalist data=datalistList.get(position);
       // imageView.setImageDrawable(context.getResources().getDrawable(data.getImage()));
        heading.setText(data.getHeading());
        desc.setText(data.getDescription());


      return view;
    }
}
