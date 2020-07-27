package com.example.bookapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

private Context mContext ;

ArrayList<String> titkeArrayList;
private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mContext = MainActivity.this;

        titkeArrayList = new ArrayList<>();

        titkeArrayList.add(Constants.WHAT_IS_JAVA);
        titkeArrayList.add(Constants.HISTORY_OF_JAVA);
        titkeArrayList.add(Constants.FEATURES_OF_JAVA);
        titkeArrayList.add(Constants.C_VS_JAVA);
        titkeArrayList.add(Constants.HELLO_JAVA_PROGRAM);
        titkeArrayList.add(Constants.PROGRAM_INTERNAL);
        titkeArrayList.add(Constants.HOW_TO_SET_PATH);
        titkeArrayList.add(Constants.JDK_JRE_AND_JVM);
        titkeArrayList.add(Constants.INTERNAL_DETAIL_OF_JVM);
        titkeArrayList.add(Constants.JAVA_VARIABLES);
        titkeArrayList.add(Constants.JAVA_DATA_TYPES);
        titkeArrayList.add(Constants.UNICODE_SYSTEM);
        titkeArrayList.add(Constants.OPERATORS);


        mRecyclerView = findViewById(R.id.title_layout_recycler_View);
       mRecyclerView.setHasFixedSize(true);
       mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


       TitleAdapter adapter = new TitleAdapter(mContext, titkeArrayList, new CustomItemClickListener() {
           @Override
           public void onItemClick(View v, int position) {


               Intent desIntent = new Intent(mContext , DescriptionActivity.class);

               desIntent.putExtra("titles",titkeArrayList.get(position));

               startActivity(desIntent);




               Toast.makeText(mContext, "clicked "+titkeArrayList.get(position), Toast.LENGTH_SHORT).show();
               
           }
       });



    mRecyclerView.setAdapter(adapter);

    }
}
