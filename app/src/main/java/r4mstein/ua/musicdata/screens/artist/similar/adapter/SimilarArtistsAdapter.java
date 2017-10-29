package r4mstein.ua.musicdata.screens.artist.similar.adapter;

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
import r4mstein.ua.musicdata.data.models.ArtistSimilarModel;

public class SimilarArtistsAdapter extends RecyclerView.Adapter<SimilarArtistsAdapter.SimilarArtistsViewHolder> {

    private List<ArtistSimilarModel> mModelList = new ArrayList<>();
    private Context mContext;
    private ArtistSimilarClickListener mClickListener;

    public SimilarArtistsAdapter(Context context) {
        mContext = context;
    }

    @Override
    public SimilarArtistsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SimilarArtistsViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_artist_similar, parent, false));
    }

    @Override
    public void onBindViewHolder(SimilarArtistsViewHolder holder, int position) {
        ArtistSimilarModel model = mModelList.get(position);

        Glide.with(mContext)
                .load(model.getPhotoUrl())
                .error(R.drawable.bg)
                .placeholder(R.drawable.bg)
                .into(holder.ivPhoto);

        holder.tvArtist.setText(model.getArtist());
        holder.tvMatch.setText(String.format("Match %s", model.getMatch()));
        holder.itemView.setOnClickListener(v -> mClickListener.itemClicked(model.getArtist()));
    }

    @Override
    public int getItemCount() {
        return mModelList.size();
    }

    public void setModels(List<ArtistSimilarModel> models) {
        mModelList = models;
        notifyDataSetChanged();
    }

    public void setClickListener(ArtistSimilarClickListener clickListener) {
        mClickListener = clickListener;
    }

    public class SimilarArtistsViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivPhoto;
        private TextView tvMatch;
        private TextView tvArtist;

        public SimilarArtistsViewHolder(View itemView) {
            super(itemView);

            ivPhoto = itemView.findViewById(R.id.iv_IAS);
            tvMatch = itemView.findViewById(R.id.tv_match_IAS);
            tvArtist = itemView.findViewById(R.id.tv_artist_IAS);
        }
    }
}
