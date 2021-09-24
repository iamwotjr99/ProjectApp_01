package org.techtown.chattingapp_01;

import android.text.TextWatcher;
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

    private CalendarActivity  context;
    private List<Constructor> mList = new ArrayList<Constructor>();
    public TextWatcher textWatcher;

    public CalendarAdapter(CalendarActivity context, List<Constructor> mList) {
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
        Log.d("mLsit", mList.get(0).getCost());
    }

    public void addItem(Constructor cost, Constructor memo){
        mList.add(cost);
        mList.add(memo);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_cost;
        TextView tv_memo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_cost = (TextView) itemView.findViewById(R.id.textView_title_cost);
            tv_memo = (TextView) itemView.findViewById(R.id.textView_desc_memo);
        }

        public void setItem(Constructor item){
            tv_cost.setText(item.getCost());
            tv_memo.setText(item.getMemo());
        }
    }
}
