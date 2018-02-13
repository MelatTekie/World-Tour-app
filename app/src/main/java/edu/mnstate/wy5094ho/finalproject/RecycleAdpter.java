package edu.mnstate.wy5094ho.finalproject;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

/**
 * Created by wy5094ho on 12/11/2017.
 */

class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    public TextView discrip;
    public ImageView photo;

    private itemClickList itemClickListener;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        discrip = (TextView) itemView.findViewById(R.id.txtdes);
        photo = (ImageView)itemView.findViewById(R.id.melat);

        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    public void setItemClickListener(itemClickList itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view, getAdapterPosition(), false);

    }

    @Override
    public boolean onLongClick(View view) {
        itemClickListener.onClick(view, getAdapterPosition(), true);
        return true;
    }
}

    public class RecycleAdpter extends RecyclerView.Adapter<RecyclerViewHolder> {
        private List<String> listData = new ArrayList<>();
        private List<Integer>image = new ArrayList<>();
        private Context context;

        public RecycleAdpter(List<Integer>image,List<String>listData, Context context){
            this.listData = listData;
            this.image = image;
            this.context = context;
        }

        @Override
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View itemViem = inflater.inflate(R.layout.layout_item_rv,parent,false);

            return new RecyclerViewHolder(itemViem);
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {
            holder.discrip.setText(listData.get(position));
            holder.photo.setImageResource(image.get(position));

            holder.setItemClickListener(new itemClickList() {
                @Override
                public void onClick(View view, int position, boolean isLongClick) {
                    if(isLongClick)
                        Toast.makeText(context,"Long Click: " + listData.get(position),Toast.LENGTH_SHORT).show();
                    else
                        if(listData.get(position).equals("Visit Peru")) {
                            Intent intent = new Intent(context,visitperu.class);
                            context.startActivity(intent);
                        }
                        else if (listData.get(position).equals("Visit Brazil")){
                            Intent intent = new Intent(context,visitbraz.class);
                            context.startActivity(intent);
                        }
                        else if (listData.get(position).equals("Visit SouthAfrica")){
                            Intent intent = new Intent(context,visitso.class);
                            context.startActivity(intent);
                        }
                        else if (listData.get(position).equals("Visit Egypt")){
                            Intent intent = new Intent(context,visiteg.class);
                            context.startActivity(intent);
                        }
                    else if (listData.get(position).equals("Visit India")){
                            Intent intent = new Intent(context,visitind.class);
                            context.startActivity(intent);
                        }
                    else if (listData.get(position).equals("Visit China")){
                            Intent intent = new Intent(context,visistchi.class);
                            context.startActivity(intent);
                        }
                        else if (listData.get(position).equals("Visit Australia")){
                            Intent intent = new Intent(context,visitAust.class);
                            context.startActivity(intent);
                        }

                }
            });

        }

        @Override
        public int getItemCount() {
            return listData.size();
        }
    }
