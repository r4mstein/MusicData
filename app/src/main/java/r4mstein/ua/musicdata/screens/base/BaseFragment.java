package r4mstein.ua.musicdata.screens.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment<A extends BaseActivity> extends Fragment {

    protected A mActivity;

    protected abstract int getLayoutResource();

    protected abstract void findUI(View rootView);

    protected abstract void setupUI();

    @SuppressWarnings("unchecked")
    protected A getActivityGeneric() {
        return (A) getActivity();
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mActivity = (A) context;
        } catch (ClassCastException e) {
            throw new RuntimeException("This fragment should have BaseActivity instance");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayoutResource(), container, false);

        findUI(rootView);
        setupUI();

        return rootView;
    }
}
