package com.example.user.binusezyfoody;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class BinusEzyFoodyActivity extends AppCompatActivity {

    CardView btn_myOrder;
    CardView btn_drink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binus_ezy_foody);

        btn_myOrder = (CardView) findViewById(R.id.btn_myOrder);
        btn_drink = (CardView) findViewById(R.id.btn_drink);

        btn_myOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BinusEzyFoodyActivity.this, MyOrderActivity.class);
                intent.putExtra("Number",0);
                startActivity(intent);
            }
        });

        btn_drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BinusEzyFoodyActivity.this , DrinksActivity.class);
                startActivity(intent);
            }
        });



    }


}
