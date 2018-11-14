package dpmapteam.dpmap;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    public ClassList mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    MyRecyclerViewAdapter(Context context) {
        mData = ClassList.getInstance();
        if (mData.list == null)
            mData.list = new ArrayList<Class>();
        this.mInflater = LayoutInflater.from(context);
    }

    public void notifyDataInsertion () {
        notifyItemInserted(mData.list.size());
    }

    public void notifyDataRemoval (int position) {
        notifyItemRemoved(position);
    }

    // inflates the row layout from xml when needed
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.rv_row, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //get position of class in list.
        Class classAddress = mData.list.get(position);

        //build string to put in recyclerView
        String temp = "";
        temp += classAddress.getHall();
        temp += Integer.toString(classAddress.getRoom_number());

        //add text to entry in recyclerView
        holder.myTextView.setText(temp);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        if (mData.list.isEmpty())
            return 0;

        return mData.list.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView myTextView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.tv_row);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null)
                mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    Class getItem(int id) {
        return mData.list.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener listen) {
        this.mClickListener = listen;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}