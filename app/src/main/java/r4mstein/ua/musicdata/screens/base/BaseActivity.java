package r4mstein.ua.musicdata.screens.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    protected abstract int getLayoutResource();

    protected abstract int getContainerId();

    protected abstract void findUI();

    protected abstract void setupUI();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getLayoutResource() != 0) setContentView(getLayoutResource());
        else throw new RuntimeException("Please write correct implementation of getLayoutResource() method");

        findUI();
        setupUI();
    }

    public void replaceFragment(BaseFragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(getContainerId(), fragment)
                .commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    public void replaceFragmentWithBackStack(BaseFragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(getContainerId(), fragment)
                .addToBackStack(null)
                .commit();
    }
}
