package r4mstein.ua.musicdata.screens.artist.top_tracks.adapter;

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
import r4mstein.ua.musicdata.data.models.ArtistTracksModel;

public class ArtistTracksAdapter extends RecyclerView.Adapter<ArtistTracksAdapter.ArtistTracksViewHolder> {

    private List<ArtistTracksModel> mModelList = new ArrayList<>();
    private Context mContext;
    private ArtistTracksClickListener mListener;

    public ArtistTracksAdapter(Context context) {
        mContext = context;
    }

    @Override
    public ArtistTracksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ArtistTracksViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_artist_tracks, parent, false));
    }

    @Override
    public void onBindViewHolder(ArtistTracksViewHolder holder, int position) {
        ArtistTracksModel model = mModelList.get(position);

        Glide.with(mContext)
                .load(model.getPhotoURL())
                .error(R.drawable.bg)
                .placeholder(R.drawable.bg)
                .into(holder.ivPhoto);

        holder.tvTrack.setText(model.getTrack());
        holder.tvPlayCount.setText(String.format("Play count: %s", model.getPlayCount()));
        holder.tvRank.setText(String.format("Rank: %s", model.getRank()));

        holder.itemView.setOnClickListener(v -> mListener.itemClicked(model.getTrack()));
    }

    @Override
    public int getItemCount() {
        return mModelList.size();
    }

    public void setModels(List<ArtistTracksModel> models) {
        mModelList = models;
        notifyDataSetChanged();
    }

    public void addModels(List<ArtistTracksModel> models) {
        mModelList.addAll(models);
        notifyDataSetChanged();
    }

    public void setListener(ArtistTracksClickListener listener) {
        mListener = listener;
    }

    public class ArtistTracksViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivPhoto;
        private TextView tvRank;
        private TextView tvPlayCount;
        private TextView tvTrack;

        public ArtistTracksViewHolder(View itemView) {
            super(itemView);

            ivPhoto = itemView.findViewById(R.id.iv_IAT);
            tvRank = itemView.findViewById(R.id.tv_rank_IAT);
            tvPlayCount = itemView.findViewById(R.id.tv_play_count_IAT);
            tvTrack = itemView.findViewById(R.id.tv_track_IAT);
        }
    }
}
