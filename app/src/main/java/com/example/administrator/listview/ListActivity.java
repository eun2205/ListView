package com.example.administrator.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    EditText inputView;
    ListView listView;
    TextView messageView;
    ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        inputView = (EditText) findViewById(R.id.edit_input);
        listView = (ListView) findViewById(R.id.listView);
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<String>());
        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                public void onItemClick (AdapterView < ? > parent, View view,int position, long id){
                    String text = (String) listView.getItemAtPosition(position);
                    messageView.setText(text);
            }
        });
        initData();
    }

    public void initData() {
        String[] items = getResources().getStringArray(R.array.list_item);
        for (String s : items) {
            mAdapter.add(s);
        }
    }
}
