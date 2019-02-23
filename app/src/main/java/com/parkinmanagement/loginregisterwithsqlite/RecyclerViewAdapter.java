package com.parkinmanagement.loginregisterwithsqlite;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>  {

    String[] values;
    Context context1;

    public RecyclerViewAdapter(Context context2,String[] values2){

        values = values2;

        context1 = context2;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textView;

        public ViewHolder(View v){

            super(v);

            textView = (TextView) v.findViewById(R.id.textview1);
        }
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        View view1 = LayoutInflater.from(context1).inflate(R.layout.recycler_view_items,parent,false);

        ViewHolder viewHolder1 = new ViewHolder(view1);

        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(ViewHolder Vholder, final int position){

        Vholder.textView.setText(values[position]);

        Vholder.textView.setBackgroundColor(Color.WHITE);

        Vholder.textView.setTextColor(Color.BLACK);

        Vholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context1, values[position], Toast.LENGTH_LONG).show();


//                if(values[position].equals("Vehicle"))
//                {
//                    Intent intent = new Intent(context1,LoginActivity.class);
//                    context1.startActivity(intent);
//                }
                 if(values[position].equals("Security"))
                {
                    Intent intent = new Intent(context1,SecurityActivity.class);
                    context1.startActivity(intent);
                }
//                else if(values[position].equals("Guest"))
//                {
//
//                }

            }
        });
    }

    @Override
    public int getItemCount(){

        return values.length;
    }
}