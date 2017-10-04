package r4mstein.ua.musicdata.screens.splash;

import android.content.Intent;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import r4mstein.ua.musicdata.R;
import r4mstein.ua.musicdata.screens.base.BaseActivity;
import r4mstein.ua.musicdata.screens.main.MainActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_splash;
    }

    @Override
    protected int getContainerId() {
        return 0;
    }

    @Override
    protected void findUI() {

    }

    @Override
    protected void setupUI() {
        Observable.timer(1, TimeUnit.SECONDS)
                .subscribe(aLong -> goToMainScreen());
    }

    private void goToMainScreen() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
