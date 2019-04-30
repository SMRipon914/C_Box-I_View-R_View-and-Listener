package com.example.check;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

   CheckBox c1,c2,c3;
    Button button;
    TextView textView;

    RecyclerView recyclerView;
    MyAdapter myAdapter;
    int image[]={R.drawable.ic_account_balance_black_24dp,R.drawable.book,R.drawable.ic_account_balance_black_24dp};
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c1=findViewById(R.id.c1);
        c2=findViewById(R.id.c2);
        c3=findViewById(R.id.c3);
        button=findViewById(R.id.b1);


       // textView=findViewById(R.id.t1);
        recyclerView=findViewById(R.id.recyclerView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
               ArrayList<String> arrayList=new ArrayList<>();
                if (c1.isChecked()){
                    arrayList.add(c1.getText().toString());
                } if (c2.isChecked()){
                   arrayList.add(c2.getText().toString());
                }if (c3.isChecked()){
                   arrayList.add(c3.getText().toString());
                }

                myAdapter=new MyAdapter(getApplicationContext(),arrayList,image);
                recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
                recyclerView.setAdapter(myAdapter);
                //textView.setText(stringBuilder);
                c1.setVisibility(View.GONE);
                c2.setVisibility(View.GONE);
                c3.setVisibility(View.GONE);
                button.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.home){
            c1.setVisibility(View.VISIBLE);
            c2.setVisibility(View.VISIBLE);
            c3.setVisibility(View.VISIBLE);
            button.setVisibility(View.VISIBLE);
        }
        return true;
    }
}
