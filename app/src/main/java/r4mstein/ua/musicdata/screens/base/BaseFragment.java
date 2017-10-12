package r4mstein.ua.musicdata.screens.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import r4mstein.ua.musicdata.screens.dialogs.LoadingDialog;

public abstract class BaseFragment<A extends BaseActivity> extends Fragment {

    protected A mActivity;

    protected abstract int getLayoutResource();

    protected abstract void findUI(View rootView);

    protected abstract void setupUI();

    private LoadingDialog mLoadingDialog;

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

    protected void progressDialogBaseShow() {
        if (mLoadingDialog == null) mLoadingDialog = new LoadingDialog();

        if (!mLoadingDialog.isShowing()) mLoadingDialog.show(
                getActivityGeneric().getSupportFragmentManager(), "progress dialog");
    }

    protected void progressDialogBaseHide() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing() && !mLoadingDialog.isDismiss())
            mLoadingDialog.dismiss();
    }
}
