package com.example.calendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageView add;
CalendarView calendarView;
    List<Datalist> datalist,datalist1;
    ListView listView;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendarView=(CalendarView)findViewById(R.id.calendarView);
        datalist=new ArrayList<>();
       listView=(ListView)findViewById(R.id.eventlist);

        MyListAdapter adapter=new MyListAdapter(this,R.layout.list_row,datalist);
        listView.setAdapter(adapter);
        add=(ImageView)findViewById(R.id.addevent);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Addevent.class);
                startActivity(i);
                i.putExtra("Date",calendarView.getDate());
            }
        });
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date=Integer.toString(year)+Integer.toString(month)+Integer.toString(dayOfMonth);
                Long date1=Long.parseLong(date);

                updateui(date1);
            }
        });


    }

    private void updateui(Long date1) {

        Db_handler db_handler=new Db_handler(this);

        datalist1=db_handler.Getevent(date1);
        MyListAdapter adapter=new MyListAdapter(this,R.layout.list_row,datalist1);
        listView.setAdapter(adapter);


}}
