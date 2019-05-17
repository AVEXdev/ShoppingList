package com.avexdev.shoppinglist;

import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.support.annotation.NonNull;
import java.util.ArrayList;
import android.view.View;
import android.view.ViewGroup;


public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ShoppingItemViewHolder> {
    private final ArrayList<ListItem> arrayList;
    private final LayoutInflater mInflater;

    ListAdapter(Context context, ArrayList<ListItem> itemList){
        mInflater = LayoutInflater.from(context);
        this.arrayList = itemList;
    }

    @NonNull
    @Override
    public ListAdapter.ShoppingItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.list_items, parent, false);
        return new ShoppingItemViewHolder(mItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ShoppingItemViewHolder holder, int position) {
        String mCurrent = arrayList.get(position).item;
        Boolean mIsChecked = arrayList.get(position).isChecked;
        holder.shoppingItem.setText(mCurrent);
        if(mIsChecked){
            holder.shoppingItem.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        }

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    void removeItem(int position){
        arrayList.remove(position);
        notifyDataSetChanged();
    }

    class ShoppingItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView shoppingItem;
        private boolean isChecked;

        private ShoppingItemViewHolder(View itemView) {
            super(itemView);
            shoppingItem = itemView.findViewById(R.id.textViewItem);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int mPosition = getLayoutPosition();
            if(!isChecked){
                shoppingItem.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                arrayList.get(mPosition).isChecked = true;
                notifyDataSetChanged();
                isChecked = true;
            }else{
                shoppingItem.setPaintFlags(0);
                arrayList.get(mPosition).isChecked = false;
                notifyDataSetChanged();
                isChecked = false;
            }
        }
    }
}
