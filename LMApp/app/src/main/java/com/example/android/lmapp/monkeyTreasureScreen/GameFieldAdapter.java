package com.example.android.lmapp.monkeyTreasureScreen;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.lmapp.R;


public class GameFieldAdapter extends RecyclerView.Adapter<GameFieldAdapter.ViewHolder>{
    private ViewHolder.clickListener clickListener;
    private boolean winCondition;
    private int currentPos=41-1;
    private int possibleLeft = currentPos-1;
    private int possibleRight = currentPos+1;
    private int possibleUp = currentPos-9;
    private int possibleDown= currentPos+9;
    GameFieldAdapter(ViewHolder.clickListener listener){ clickListener = listener;}
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tile,parent,false);
        return new ViewHolder(view, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MonkeyTreasureTile item = data[position];
        if (item.isTreasure()) holder.tileView.setImageResource(R.drawable.chest);
        else {
            if (item.isOccupied()) holder.tileView.setImageResource(R.drawable.monkey);
            else {if(!item.visited) holder.tileView.setImageResource(R.drawable.unknown);
            else  holder.tileView.setImageResource(R.drawable.visited);}
        }
        holder.tileView.setOnClickListener(v->{
            int clickposition = holder.getAdapterPosition();
            Log.d("Data",data[clickposition].isSkorpio()+" "+data[clickposition].isViper());
            if (clickposition==possibleUp || clickposition==possibleDown || clickposition==possibleRight || clickposition==possibleLeft){
                if(data[clickposition].isTreasure()){
                    winCondition=true;
                    holder.itemlistener.makeMessage(winCondition);
                } else{
                    if(!data[clickposition].isSkorpio() && !data[clickposition].isViper()){
                        data[currentPos].occupied=false;
                        data[currentPos].visited=true;
                        data[clickposition].occupied=true;
                        notifyDataSetChanged();
                        resetPositionts(clickposition);
                    }
                    else if(data[clickposition].isViper()){
                        holder.tileView.setImageResource(R.drawable.viper);
                        winCondition=false;
                        holder.itemlistener.makeMessage(winCondition);}
                    else {
                        holder.tileView.setImageResource(R.drawable.skorpion);
                        winCondition=false;
                        holder.itemlistener.makeMessage(winCondition);
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    static class ViewHolder extends  RecyclerView.ViewHolder{
        ImageView tileView;
        clickListener itemlistener;
        public ViewHolder(View itemView, clickListener listener){
            super(itemView);
            tileView = itemView.findViewById(R.id.tileImage);
            itemlistener = listener;
        }
        interface clickListener{
            void makeMessage(boolean condition);
        }
    }
    MonkeyTreasureTile [] data = new MonkeyTreasureTile[1];
    void setData( MonkeyTreasureTile [] set){
        data = set;
        notifyDataSetChanged();
    }
    void resetPositionts(int current){
        currentPos=current;
        possibleLeft = currentPos-1;
        possibleRight = currentPos+1;
        possibleUp = currentPos-9;
        possibleDown= currentPos+9;
    }
}
