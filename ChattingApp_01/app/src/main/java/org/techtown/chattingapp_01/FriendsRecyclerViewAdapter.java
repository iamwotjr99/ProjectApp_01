package org.techtown.chattingapp_01;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FriendsRecyclerViewAdapter extends RecyclerView.Adapter<FriendsRecyclerViewAdapter.
        ViewHolder> {
    private List<Friends> mFriendsList;

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView friendName;
        private ImageView imageFriendProfile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            friendName = itemView.findViewById(R.id.tv_friendName);
            imageFriendProfile = itemView.findViewById(R.id.image_friendProfile);
        }
    }

    public FriendsRecyclerViewAdapter(Context context, List<Friends> friends) {
        mFriendsList = friends;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_friend, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Friends friends = mFriendsList.get(position);
        holder.friendName.setText(friends.getFr_name());
        Uri uri = Uri.parse(friends.getFr_profile());
        holder.imageFriendProfile.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return mFriendsList.size();
    }
}
