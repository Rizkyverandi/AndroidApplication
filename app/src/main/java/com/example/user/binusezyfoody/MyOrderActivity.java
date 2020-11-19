package com.example.user.binusezyfoody;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyOrderActivity extends AppCompatActivity {
    private RecyclerView mRecyclervView;
    private RecyclerAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    final ArrayList<DrinkList> drinkLists = new ArrayList<>();
    ListView listView;
    TextView total_harga,tv_total;
    String text , values;
    Button btn_pay;
    int gbr,qty,i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);
        init();
    }

      public void init()
    {
        btn_pay = (Button) findViewById(R.id.btn_pay);
        tv_total = (TextView) findViewById(R.id.tv_total);
        qty = getIntent().getExtras().getInt("Number");
        int total = qty * 123;
        listView = (ListView) findViewById(R.id.list_item);
        total_harga = (TextView) findViewById(R.id.total_harga);


        if(qty==0 )
        {
            tv_total.setVisibility(View.INVISIBLE);
            btn_pay.setVisibility(View.INVISIBLE);
            total_harga.setText("Cart Anda Kosong");
            listView.setVisibility(View.INVISIBLE);

        }
        else {
            text = getIntent().getExtras().getString("Value");
            values = "Rp.123" + " x " + qty;
            final String tmpTotal = "Rp." + Integer.toString(total);
            total_harga.setText(tmpTotal);

            btn_pay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MyOrderActivity.this, OrderCompleteActivity.class);
                    intent.putExtra("Value", values);
                    intent.putExtra("Total", tmpTotal);
                    startActivity(intent);
                }
            });

            if (text.equalsIgnoreCase("Air Mineral")) {
                gbr = (R.drawable.mineral);
            } else if (text.equalsIgnoreCase("Jus Apel")) {
                gbr = (R.drawable.jusapel);
            } else if (text.equalsIgnoreCase("Jus Alpukat")) {
                gbr = (R.drawable.jusalpukat);
            } else if (text.equalsIgnoreCase("Jus Mangga")) {
                gbr = (R.drawable.jusmangga);
            }
            drinkLists.add(new DrinkList(text,"Rp.123 x "+Integer.toString(qty),gbr));

            mRecyclervView = (RecyclerView) findViewById(R.id.list_item_recycler);
            mRecyclervView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(this);
            mAdapter = new RecyclerAdapter(drinkLists);




            mRecyclervView.setLayoutManager(mLayoutManager);
            mRecyclervView.setAdapter(mAdapter);




//            int images[] = {gbr};
//            String names[] = {text};
//            int wqty[] = {qty};
//
//
//            //drinklist.add(new DrinkList(text,qty,gbr));
//            ArrAdapter adapter = new ArrAdapter(this, names,wqty,images);
//            listView.setAdapter(adapter);


            // item.add(values);
//        do {
//            if (!item.isEmpty()) {
//                item.add(values);
//                stop = true;
//                //temp[i] = 1;
//            } else
//                i++;
//        }while(stop == true);

            // ListAdapter listAdapter = new ListAdapter(getApplicationContext(),text,gbr);
//            MyAdapter adapter = new MyAdapter(this,item );
//            listView.setAdapter(adapter);
//            List<HashMap<String,String>> list = new ArrayList<>();
//            HashMap<String,String> hashMap = new HashMap<>();
//            hashMap.put("text",text);
//            hashMap.put("gambar",gbr+"");
//            list.add(hashMap);
//            String[] from = {"text","gambar"};
//            int[]  to = {R.id.name_drink,R.id.pics};
//            SimpleAdapter simpleAdapter = new SimpleAdapter(this,list,R.layout.list_custom,from,to);
//            listView.setAdapter(simpleAdapter);

        }
    }

}
