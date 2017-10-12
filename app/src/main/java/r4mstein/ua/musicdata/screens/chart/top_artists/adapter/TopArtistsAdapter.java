package r4mstein.ua.musicdata.screens.chart.top_artists.adapter;

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
import r4mstein.ua.musicdata.data.models.TopArtistsModel;

public class TopArtistsAdapter extends RecyclerView.Adapter<TopArtistsAdapter.TopArtistsViewHolder> {

    private List<TopArtistsModel> mModelList = new ArrayList<>();
    private Context mContext;
    private TopArtistsClickListener mClickListener;

    public TopArtistsAdapter(Context context) {
        mContext = context;
    }

    @Override
    public TopArtistsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TopArtistsViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_top_artists, parent, false));
    }

    @Override
    public void onBindViewHolder(TopArtistsViewHolder holder, int position) {
        TopArtistsModel model = mModelList.get(position);

        Glide.with(mContext)
                .load(model.getPhotoURL())
                .error(R.drawable.bg)
                .placeholder(R.drawable.bg)
                .into(holder.ivPhoto);

        holder.tvName.setText(model.getName());
        holder.itemView.setOnClickListener(view -> mClickListener.itemClicked(model.getName(), position));
    }

    @Override
    public int getItemCount() {
        return mModelList.size();
    }

    public void setModels(List<TopArtistsModel> models) {
        mModelList = models;
        notifyDataSetChanged();
    }

    public void addModels(List<TopArtistsModel> models) {
        mModelList.addAll(models);
        notifyDataSetChanged();
    }

    public void setClickListener(TopArtistsClickListener clickListener) {
        mClickListener = clickListener;
    }

    public class TopArtistsViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivPhoto;
        private TextView tvName;

        public TopArtistsViewHolder(View itemView) {
            super(itemView);

            ivPhoto = itemView.findViewById(R.id.iv_ITA);
            tvName = itemView.findViewById(R.id.tv_name_ITA);
        }
    }
}
