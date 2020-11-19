package com.example.user.binusezyfoody;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.key;
import static android.R.attr.name;

public class DrinksActivity extends AppCompatActivity {
    CardView btn_myOrder,btn_add1,btn_add2,btn_add3,btn_add4;
    TextView name_drink,name_drink2,name_drink3,name_drink4 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        btn_myOrder = (CardView) findViewById(R.id.btn_myOrder);
        btn_add1 = (CardView) findViewById(R.id.btn_add1);
        btn_add2 = (CardView) findViewById(R.id.btn_add2);
        btn_add3 = (CardView) findViewById(R.id.btn_add3);
        btn_add4 = (CardView) findViewById(R.id.btn_add4);

        name_drink = (TextView) findViewById(R.id.mineral);
        name_drink2 = (TextView) findViewById(R.id.apel);
        name_drink3 = (TextView) findViewById(R.id.alpukat);
        name_drink4= (TextView) findViewById(R.id.mangga);



        btn_myOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DrinksActivity.this , MyOrderActivity.class) ;
                intent.putExtra("Number",0);
                startActivity(intent);
            }
        });

        btn_add1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String text = name_drink.getText().toString();
                Intent intent = new Intent(DrinksActivity.this , OrderActivity.class) ;
                intent.putExtra("Value",text);
                startActivity(intent);

            }
        });

        btn_add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = name_drink2.getText().toString();
                Intent intent = new Intent(DrinksActivity.this , OrderActivity.class) ;
                startActivity(intent);
                intent.putExtra("Value",text);
                startActivity(intent);

            }
        });

        btn_add3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = name_drink3.getText().toString();
                Intent intent = new Intent(DrinksActivity.this , OrderActivity.class) ;
                startActivity(intent);
                intent.putExtra("Value",text);
                startActivity(intent);

            }
        });

        btn_add4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = name_drink4.getText().toString();
                Intent intent = new Intent(DrinksActivity.this , OrderActivity.class) ;
                startActivity(intent);
                intent.putExtra("Value",text);
                startActivity(intent);

            }
        });
    }
}
