package com.example.administrator.listview;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.listview.data.Person;
import com.example.administrator.listview.widget.PersonView;

public class MainActivity extends AppCompatActivity {

    PersonView personView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       personView = (PersonView) findViewById(R.id.view_person);

        initData();
    }

    public void initData() {
        Drawable photo = ContextCompat.getDrawable(this, R.drawable.sample_0);

        Person p = new Person("ysi", 42, photo);

       personView.setPerson(p);
    }
}
