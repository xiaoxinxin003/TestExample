package com.example.yang.testexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] data = {"Apple", "Orange", "Pear", "Cherry", "Banana", "Pitch",
            "Water", "Bread", "Han", "Europe", "China", "Japan", "India", "Thailand" ,
            "Orange", "Pear", "Cherry", "Banana", "Pitch",
            "Water", "Bread", "Han", "Europe", "China", "Japan", "India", "Thailand"};
    private CustomListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mListView = (CustomListView) findViewById(R.id.list_view);
        mListView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d("my-log", "call onTouch");
                if(event.getAction() == MotionEvent.ACTION_UP){
//                    Log.d("my-log", "listview process touch event ");
//                    mListView.requestDisallowInterceptTouchEvent(false);
                }else{
//                    mListView.requestDisallowInterceptTouchEvent(true);
//                    Log.d("my-log", "scroll intercept touch event");
                }
                return false;
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "you clicked item " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
