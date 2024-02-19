package com.example.ArabicStories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidproject1.R;

public class StoryView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_view);


        TextView tv_show=findViewById(R.id.tv_show);
        TextView tv_name=findViewById(R.id.tv_story_name);
        Button btn_back=findViewById(R.id.btn_back);


        Intent intent2=getIntent();
       String story_content= intent2.getStringExtra("content");
       String story_name=intent2.getStringExtra("name");

       tv_show.setText(story_content);
        tv_show.setMovementMethod(new ScrollingMovementMethod());
        tv_name.setText(story_name);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}