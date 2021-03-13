package com.example.multinumbers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context context;
    private List<creatImage> list;

    public Adapter(Context c,List<creatImage> list) {
        this.context=c;
        this.list=list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
             imageView= itemView.findViewById(R.id.stars_one);
        }
    }
    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(context).inflate(R.layout.stars,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        creatImage create = list.get(position);
        if(create.getF())
        holder.imageView.setImageResource(R.drawable.starsyelwo);
        else
            holder.imageView.setImageResource(R.drawable.starsred);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

