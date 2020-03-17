package com.example.oosd.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.oosd.R;
import com.example.oosd.model.Number;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private int mResource;
    private List<Number> mNumbers;

    public RecyclerViewAdapter(Context mContext, int mResource, List<Number> mNumbers) {
        this.mContext = mContext;
        this.mResource = mResource;
        this.mNumbers = mNumbers;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(mResource, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Number number = mNumbers.get(position);

        holder.number = number;
        holder.numberTextView.setText(number.number);
        holder.typeTextView.setText(number.type);
    }

    @Override
    public int getItemCount() {
        return mNumbers.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView numberTextView;
        private TextView typeTextView;

        private Number number;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.numberTextView = itemView.findViewById(R.id.item_number_text_view);
            this.typeTextView = itemView.findViewById(R.id.item_type_text_view);
        }
    }
}
