package org.techtown.chattingapp_01;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    private OnItemClickListener mListener = null;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }
    private List<Constructor> mList = new ArrayList<Constructor>();

    public CalendarAdapter(Context context, List<Constructor> mList) {
        this.mList= mList;
    }

    @Override
    public int getItemCount() {
        if(mList != null) {
            return mList.size();
        }
        return 0;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_calendar_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Constructor constructor = mList.get(position);
        holder.tv_cost.setText(constructor.getCost());
        holder.tv_memo.setText(constructor.getMemo());
    }

    public void addItem(Constructor cost, Constructor memo){
        mList.add(cost);
        mList.add(memo);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_cost;
        TextView tv_memo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_cost = (TextView) itemView.findViewById(R.id.textView_title_cost);
            tv_memo = (TextView) itemView.findViewById(R.id.textView_desc_memo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION) {
                        if(mListener != null) {
                            mListener.onItemClick(v, position);
                        }
                    }
                }
            });
        }

        public void setItem(Constructor item){
            tv_cost.setText(item.getCost());
            tv_memo.setText(item.getMemo());
        }
    }
}
