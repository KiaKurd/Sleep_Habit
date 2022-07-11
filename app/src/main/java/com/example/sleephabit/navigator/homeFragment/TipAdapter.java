package com.example.sleephabit.navigator.homeFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sleephabit.R;
import com.example.sleephabit.model.Tag;
import com.example.sleephabit.model.TipsDescription;

import java.util.List;

public class TipAdapter extends RecyclerView.Adapter<TipAdapter.Viewholder> {


    private List<Tag> tagModelArray;
    private List<TipsDescription> tdArray;

    // Constructor
    public TipAdapter(List<Tag> tagModelArray, List<TipsDescription> tdModelArray){
        this.tagModelArray = tagModelArray;
        this.tdArray = tdModelArray;
    }

    @NonNull
    @Override
    public TipAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  TipAdapter.Viewholder holder, int position){
        // to set data to textview of each card layout
        Tag tag = tagModelArray.get(position);
        TipsDescription td = tdArray.get(position);

        holder.tagTV.setText(tag.getTag());
        holder.descriptionTV.setText(td.getDescription());
    }

    @Override
    public int getItemCount() {
        // this method is used for showing number
        // of card items in recycler view.
        return tagModelArray.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{

       private  TextView tagTV, descriptionTV;

        public Viewholder(@NonNull View itemView){
            super(itemView);
            tagTV = itemView.findViewById(R.id.tipsTag);
            descriptionTV = itemView.findViewById(R.id.tipsDescription);
        }
    }
}
