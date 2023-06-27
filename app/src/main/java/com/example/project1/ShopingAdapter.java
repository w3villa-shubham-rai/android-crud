package com.example.project1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ShopingAdapter extends RecyclerView.Adapter<ShopingAdapter.viewholder> {

    Context context;
//    ArrayList<ShopingModel>storecustomerdata;
    ArrayList<apimodel> apimodellist;


    public ShopingAdapter(Context context, ArrayList<apimodel> apimodellist ) {
        this.context = context;
        this.apimodellist = apimodellist;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        layout to view genrate
       View v= LayoutInflater.from(context).inflate(R.layout.shoping_layout,parent,false);
       viewholder viewholder1=new viewholder(v);
       return viewholder1;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
//    holder.user_img.setImageResource(storecustomerdata.get(position).img);
//    holder.textView_id.setText(storecustomerdata.get(position).id);
//    holder.textView_tittle.setText(storecustomerdata.get(position).tittle);
//        holder.textView_tittle(apimodellist.get(position).img1);
        String imageUrl = apimodellist.get(position).img1;
        Glide.with(context)
                .load(imageUrl)
                .into(holder.user_img);

        holder.textView_id.setText(apimodellist.get(position).id1);
        holder.textView_tittle.setText(apimodellist.get(position).tittle1);
    }

    @Override
    public int getItemCount() {
        return apimodellist.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{


//    help the holder and onBinddata.
        ImageView user_img;
        TextView textView_id,textView_tittle;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            textView_id=itemView.findViewById(R.id.textView_id);
            user_img=itemView.findViewById(R.id.user_img);
            textView_tittle=itemView.findViewById(R.id.textView_tittle);

        }
    }
}
