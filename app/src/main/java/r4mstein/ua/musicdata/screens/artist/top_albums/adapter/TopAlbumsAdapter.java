package r4mstein.ua.musicdata.screens.artist.top_albums.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import r4mstein.ua.musicdata.R;
import r4mstein.ua.musicdata.data.models.TopAlbumsModel;

public class TopAlbumsAdapter extends RecyclerView.Adapter<TopAlbumsAdapter.TopAlbumsViewHolder> {

    private List<TopAlbumsModel> mModelList = new ArrayList<>();
    private Context mContext;
    private TopAlbumsClickListener mClickListener;

    public TopAlbumsAdapter(Context context) {
        mContext = context;
    }

    @Override
    public TopAlbumsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TopAlbumsViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_artist_albums, parent, false));
    }

    @Override
    public void onBindViewHolder(TopAlbumsViewHolder holder, int position) {
        TopAlbumsModel item = mModelList.get(position);

        Glide.with(mContext)
                .load(item.getPhotoURL())
                .error(R.drawable.bg)
                .placeholder(R.drawable.bg)
                .into(holder.ivPhoto);

        holder.tvAlbum.setText(item.getAlbum());
        holder.tvCount.setText(String.format("Play count: %s", item.getPlayCount()));

        holder.itemView.setOnClickListener(v -> mClickListener.itemClicked(item.getAlbum()));
    }

    @Override
    public int getItemCount() {
        return mModelList.size();
    }

    public void setModels(List<TopAlbumsModel> models) {
        mModelList = models;
        notifyDataSetChanged();
    }

    public void addModels(List<TopAlbumsModel> models) {
        mModelList.addAll(models);
        notifyDataSetChanged();
    }

    public void setClickListener(TopAlbumsClickListener clickListener) {
        mClickListener = clickListener;
    }

    public class TopAlbumsViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivPhoto;
        private TextView tvCount;
        private TextView tvAlbum;

        public TopAlbumsViewHolder(View itemView) {
            super(itemView);

            ivPhoto = itemView.findViewById(R.id.iv_IAA);
            tvCount = itemView.findViewById(R.id.tv_play_count_IAA);
            tvAlbum = itemView.findViewById(R.id.tv_album_IAA);
        }
    }
}
