package com.example.user.binusezyfoody;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderCompleteActivity extends AppCompatActivity {

    TextView total_harga1;
    String text , total;
    LinearLayout linearLayout;
    CardView btn_utama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete);

        total_harga1 = (TextView) findViewById(R.id.total_harga1);
        text = getIntent().getExtras().getString("Value");
        total = getIntent().getExtras().getString("Total");
        total_harga1.setText(total);
        String list[] = {text};

        linearLayout = (LinearLayout) findViewById(R.id.linear_list);
        for(String curStr : list)
        {
            TextView item = new TextView(this);
            item.setText(curStr);
            item.setTextSize(20f);
            linearLayout.addView(item);
        }


        btn_utama = (CardView) findViewById(R.id.btn_utama);
        btn_utama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderCompleteActivity.this , BinusEzyFoodyActivity.class);
                startActivity(intent);
            }
        });
    }

}