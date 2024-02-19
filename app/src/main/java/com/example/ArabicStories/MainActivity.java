package com.example.ArabicStories;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.androidproject1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

   static ArrayList<String> titles = new ArrayList<>();
   static ArrayList<Integer> stories = new ArrayList<>();
   static ArrayList<String> added_stories = new ArrayList<>();
    ListView list;
    static ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titles.addAll(Arrays.asList("الرجل العجوز في القرية","الصديق الحقيقي", "الطلبة الأربعة الأذكياء",
              "الصديقان والدب","بطاطا، بيضة أم قهوة؟","الثعلب والعنب","الانعكاسات"));
        stories.addAll(Arrays.asList(R.raw.txt1,R.raw.txt2,R.raw.txt3,R.raw.txt4,
                R.raw.txt5,R.raw.txt6,R.raw.txt7));

        list=findViewById(R.id.list);
        adapter=new ArrayAdapter(this,
                R.layout.costum_item,R.id.tv_item,titles);
        list.setAdapter(adapter);



        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){

                Intent intent = new Intent(MainActivity.this, StoryView.class);
                if(i<=6)
                {

                    Scanner scan = new Scanner(getResources().openRawResource(stories.get(i)));
                    String allText = "";
                    while (scan.hasNextLine()) {
                        String line = scan.nextLine();
                        allText += line + "\n";
                    }
                    scan.close();

                    intent.putExtra("content", allText);
                }

                else
                {
                    intent.putExtra("content",added_stories.get(i-7));
                }

                intent.putExtra("name", titles.get(i));
                startActivity(intent);
            }
        });



        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                int removed_item = i;

                if (removed_item>6)
                {
                    new AlertDialog.Builder(MainActivity.this).setIcon(android.R.drawable.ic_dialog_alert)
                            .setTitle("تحذير").setMessage("هل تريد حذف تلك القصة؟")
                            .setPositiveButton("نعم", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    titles.remove(removed_item);
                                    added_stories.remove(removed_item-7);
                                    adapter.notifyDataSetChanged();
                                }
                            })
                            .setNegativeButton("لا", null)
                            .show();
                }
                return true;
            }
        });



        ImageView iv_plus=findViewById(R.id.iv_plus);
        iv_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(MainActivity.this,Activity_add.class);
                startActivity(intent2);
            }
        });


    }
}