package r4mstein.ua.musicdata.screens.track.info.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import r4mstein.ua.musicdata.R;

public class TagAdapter extends RecyclerView.Adapter<TagAdapter.TagViewHolder> {

    private List<String> mItems = new ArrayList<>();
    private TagClickListener mClickListener;

    @Override
    public TagViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TagViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tag, parent, false));
    }

    @Override
    public void onBindViewHolder(TagViewHolder holder, int position) {
        String tag = mItems.get(position);
        holder.tvTag.setText(tag);
        holder.itemView.setOnClickListener(v -> mClickListener.tagClicked(tag));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void setModels(List<String> models) {
        mItems = models;
        notifyDataSetChanged();
    }

    public void setClickListener(TagClickListener clickListener) {
        mClickListener = clickListener;
    }

    public class TagViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTag;

        public TagViewHolder(View itemView) {
            super(itemView);
            tvTag = itemView.findViewById(R.id.tv_tag_IT);
        }
    }
}
