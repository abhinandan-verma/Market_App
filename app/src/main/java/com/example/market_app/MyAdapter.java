package com.example.market_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Item> itemList;

    private ItemClickListener clickListener;
    public MyAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    public void setClickListener(ItemClickListener myListener){
        this.clickListener = myListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       //responsible for creating new view Holders for your Items

        View itemView = LayoutInflater.
                from(parent.getContext())
                .inflate(R.layout.item_layout,parent,false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    //Binds the data from your dataset to the views within the ViewHolder
        Item item = itemList.get(position);

        holder.title.setText(item.getItemName());
        holder.description.setText(item.getItemDesc());
        holder.imageView.setImageResource(item.getItemImg());
    }

    @Override
    public int getItemCount() {
        //returns the total number of the views within the Item Layout
        return itemList.size();
    }

    public class MyViewHolder extends
            RecyclerView.ViewHolder implements View.OnClickListener{
      ImageView imageView;
      TextView title;
      TextView description;
      public MyViewHolder(@NonNull View itemView){
            super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        title = itemView.findViewById(R.id.title_text);
        description = itemView.findViewById(R.id.description_text);

        itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(clickListener != null){
                clickListener.onCLick(v,getAdapterPosition());
            }
        }
    }
}
