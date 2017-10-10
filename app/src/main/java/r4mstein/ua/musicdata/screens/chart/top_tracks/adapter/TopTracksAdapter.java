package r4mstein.ua.musicdata.screens.chart.top_tracks.adapter;

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
import r4mstein.ua.musicdata.data.models.TopTracksModel;

public class TopTracksAdapter extends RecyclerView.Adapter<TopTracksAdapter.TopTracksViewHolder> {

    private List<TopTracksModel> mModelList = new ArrayList<>();
    private Context mContext;
    private TopTracksClickListener mClickListener;

    public TopTracksAdapter(Context context) {
        mContext = context;
    }

    @Override
    public TopTracksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TopTracksViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_top_tracks, parent, false));
    }

    @Override
    public void onBindViewHolder(TopTracksViewHolder holder, int position) {
        TopTracksModel model = mModelList.get(position);

        Glide.with(mContext)
                .load(model.getPhotoURL())
                .error(R.drawable.bg)
                .placeholder(R.drawable.bg)
                .into(holder.ivPhoto);

        holder.tvTrack.setText(model.getTrack());
        holder.tvName.setText(model.getName());

        holder.itemView.setOnClickListener(v -> mClickListener.itemClicked(model.getTrack(), model.getName()));
    }

    @Override
    public int getItemCount() {
        return mModelList.size();
    }

    public void setModels(List<TopTracksModel> models) {
        mModelList = models;
        notifyDataSetChanged();
    }

    public void addModels(List<TopTracksModel> models) {
        mModelList.addAll(models);
        notifyDataSetChanged();
    }

    public void setClickListener(TopTracksClickListener clickListener) {
        mClickListener = clickListener;
    }

    public class TopTracksViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivPhoto;
        private TextView tvName;
        private TextView tvTrack;

        public TopTracksViewHolder(View itemView) {
            super(itemView);

            ivPhoto = itemView.findViewById(R.id.iv_ITT);
            tvName = itemView.findViewById(R.id.tv_name_ITT);
            tvTrack = itemView.findViewById(R.id.tv_track_ITT);
        }
    }
}
