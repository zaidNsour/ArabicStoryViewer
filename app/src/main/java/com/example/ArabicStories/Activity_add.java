package com.example.ArabicStories;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.androidproject1.R;

public class Activity_add extends AppCompatActivity {

    int story_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        EditText et_add_title=findViewById(R.id.et_add_title);
        EditText et_add_content=findViewById(R.id.et_add_content);
        ImageView iv_yes=findViewById(R.id.iv_yes);

        iv_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivity.added_stories.add(String.valueOf(et_add_content.getText()));
                MainActivity.titles.add(String.valueOf(et_add_title.getText()));
                MainActivity.adapter.notifyDataSetChanged();
                finish();

                /*SharedPreferences share=getApplicationContext().
                        getSharedPreferences("com.example.androidproject1", Context.MODE_PRIVATE);
                HashSet<String> set =new HashSet(MainActivity.added_stories);
                share.edit().putStringSet("added_story",set).apply();*/

            }
        });

    }
}