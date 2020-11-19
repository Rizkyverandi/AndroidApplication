package com.example.user.binusezyfoody;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    TextView textView_drink;
    String text;
    ElegantNumberButton elegantNumberButton;
    CardView btn_myOrder,btn_more;
    ImageView gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        gambar = (ImageView) findViewById(R.id.gambar);
        textView_drink = (TextView) findViewById(R.id.textView_drink);
        btn_more = (CardView) findViewById(R.id.btn_more);
        btn_myOrder = (CardView) findViewById(R.id.btn_myOrder);
        elegantNumberButton = (ElegantNumberButton) findViewById(R.id.elegantNumberButton);

        text = getIntent().getExtras().getString("Value");
        textView_drink.setText(text);

        if(text.equalsIgnoreCase("Air Mineral"))
        {
            gambar.setImageResource(R.drawable.mineral);
        }else if(text.equalsIgnoreCase("Jus Apel"))
        {
            gambar.setImageResource(R.drawable.jusapel);
        }else if(text.equalsIgnoreCase("Jus Alpukat"))
        {
            gambar.setImageResource(R.drawable.jusalpukat);
        }else if(text.equalsIgnoreCase("Jus Mangga"))
        {
            gambar.setImageResource(R.drawable.jusmangga);
        }




        btn_myOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this , MyOrderActivity.class) ;
                String text = textView_drink.getText().toString();
                int qty = Integer.parseInt(elegantNumberButton.getNumber());
               // int total_harga = qty * 123;
                //intent.putExtra("Total",total_harga);
                intent.putExtra("Number",qty);
                intent.putExtra("Value",text);
                startActivity(intent);
            }
        });

//        elegantNumberButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(OrderActivity.this , MyOrderActivity.class) ;
//                startActivity(intent);
//            }
//        });

        btn_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderActivity.this , DrinksActivity.class) ;
                startActivity(intent);
            }
        });


    }
}
