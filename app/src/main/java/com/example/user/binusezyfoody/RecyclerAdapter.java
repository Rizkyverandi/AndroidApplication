package com.example.user.binusezyfoody;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by USER on 07/11/2020.
 */

public  class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private ArrayList<DrinkList> mDrinkList;
    private onItemClickListener mListener;

    public interface onItemClickListener{
        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(onItemClickListener listener )
    {
        mListener = listener;
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder{

        public ImageView img;
        public TextView txt1;
        public TextView txt2;
        public CardView delete;

        public ViewHolder(View itemView, final onItemClickListener listener) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.pics);
            txt1 = (TextView) itemView.findViewById(R.id.name_drink);
            txt2 = (TextView) itemView.findViewById(R.id.item_name);
            delete = (CardView) itemView.findViewById(R.id.btn_delete);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null)
                    {
                        int position = getAdapterPosition();
                        if(position!= RecyclerView.NO_POSITION)
                        {
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });

        }

    }



    public RecyclerAdapter(ArrayList<DrinkList> drinkList){
        mDrinkList = drinkList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_custom,parent,false);
        ViewHolder vh = new ViewHolder(v,mListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DrinkList currItem = mDrinkList.get(position);
        holder.img.setImageResource(currItem.getImgId());
        holder.txt1.setText(currItem.getDrink_name());
        holder.txt2.setText(currItem.getQty());

    }


    @Override
    public int getItemCount() {
        return mDrinkList.size();
    }

}

