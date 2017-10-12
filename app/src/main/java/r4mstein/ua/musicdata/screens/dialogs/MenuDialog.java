package r4mstein.ua.musicdata.screens.dialogs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import r4mstein.ua.musicdata.R;

import static r4mstein.ua.musicdata.utils.Constants.MENU_DIALOG_ALBUMS_VISIBILITY;
import static r4mstein.ua.musicdata.utils.Constants.MENU_DIALOG_HEADER;
import static r4mstein.ua.musicdata.utils.Constants.MENU_DIALOG_INFO;
import static r4mstein.ua.musicdata.utils.Constants.MENU_DIALOG_SIMILAR;
import static r4mstein.ua.musicdata.utils.Constants.MENU_DIALOG_TRACKS_VISIBILITY;

public class MenuDialog extends DialogFragment {

    private TextView tvHeader;
    private TextView tvInfo;
    private TextView tvAlbums;
    private TextView tvTracks;
    private TextView tvSimilar;

    private MenuDialogListener mListener;

    public static MenuDialog newInstance(String header, String info, String similar,
                                         int albumsVisibility, int tracksVisibility) {
        MenuDialog dialog = new MenuDialog();

        Bundle bundle = new Bundle();
        bundle.putString(MENU_DIALOG_HEADER, header);
        bundle.putString(MENU_DIALOG_INFO, info);
        bundle.putString(MENU_DIALOG_SIMILAR, similar);
        bundle.putInt(MENU_DIALOG_ALBUMS_VISIBILITY, albumsVisibility);
        bundle.putInt(MENU_DIALOG_TRACKS_VISIBILITY, tracksVisibility);
        dialog.setArguments(bundle);

        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_menu, container, false);

        setupDialogProperties(view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initVariables(view);
        setClickListeners(view);
        setupViews(getArguments().getInt(MENU_DIALOG_ALBUMS_VISIBILITY),
                getArguments().getInt(MENU_DIALOG_TRACKS_VISIBILITY));
    }

    private void setupViews(int albumsVisibility, int tracksVisibility) {
        tvHeader.setText(getArguments().getString(MENU_DIALOG_HEADER));
        tvInfo.setText(getArguments().getString(MENU_DIALOG_INFO));
        tvSimilar.setText(getArguments().getString(MENU_DIALOG_SIMILAR));
        tvAlbums.setVisibility(albumsVisibility);
        tvTracks.setVisibility(tracksVisibility);
    }

    private void setupDialogProperties(View view) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        getDialog().setCanceledOnTouchOutside(false);
        getDialog().setOnShowListener(dialog -> revealShow(view, true));
        getDialog().setOnKeyListener((dialog, keyCode, event) -> {
            if (keyCode == KeyEvent.KEYCODE_BACK){
                revealShow(view, false);
                return true;
            }
            return false;
        });
    }

    private void initVariables(View view) {
        tvHeader = view.findViewById(R.id.tv_header_DM);
        tvInfo = view.findViewById(R.id.tv_info_DM);
        tvAlbums = view.findViewById(R.id.tv_albums_DM);
        tvTracks = view.findViewById(R.id.tv_tracks_DM);
        tvSimilar = view.findViewById(R.id.tv_similar_DM);
    }

    private void setClickListeners(View view) {
        tvInfo.setOnClickListener(v -> {
            revealShow(view, false);
            mListener.infoClicked();
        });

        tvAlbums.setOnClickListener(v -> {
            revealShow(view, false);
            mListener.albumsClicked();
        });

        tvTracks.setOnClickListener(v -> {
            revealShow(view, false);
            mListener.tracksClicked();
        });

        tvSimilar.setOnClickListener(v -> {
            revealShow(view, false);
            mListener.similarClicked();
        });
    }

    private void revealShow(View rootView, boolean reveal) {
        final View view = rootView.findViewById(R.id.cv_container_DM);

        int width = view.getWidth();
        int height = view.getHeight();
        float maxRadius = (float) Math.sqrt(width * width / 4 + height * height / 4);

        if(reveal){
            Animator revealAnimator = ViewAnimationUtils.createCircularReveal(view,
                    width / 2, height / 2, 0, maxRadius);
            view.setVisibility(View.VISIBLE);
            revealAnimator.start();
        } else {
            Animator anim = ViewAnimationUtils.createCircularReveal(view, width / 2, height / 2, maxRadius, 0);

            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    dismiss();
                }
            });

            anim.start();
        }
    }

    public void setListener(MenuDialogListener listener) {
        mListener = listener;
    }
}
