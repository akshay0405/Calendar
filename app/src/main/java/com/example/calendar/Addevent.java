package com.example.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Addevent extends AppCompatActivity {
EditText e1,e2;
Button btn;
Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addevent);
        final Long date=getIntent().getLongExtra("Date",1062018);
        e1=(EditText)findViewById(R.id.title1);
        e2=findViewById(R.id.desc);
        btn=findViewById(R.id.btn);
                btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title=e1.getText().toString();
                String desc=e2.getText().toString();
                Db_handler db_handler=new Db_handler(context);
                db_handler.insertevent(date,desc,title);

            }
        });
    }
}
