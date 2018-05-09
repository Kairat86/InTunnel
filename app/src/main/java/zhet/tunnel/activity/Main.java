package zhet.tunnel.activity;

import android.app.Activity;
import android.app.NativeActivity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import zhet.tunnel.R;


public class Main extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, getString(R.string.app_id));
        final InterstitialAd ad = new InterstitialAd(this);
        ad.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {
                ad.show();
            }

            @Override
            public void onAdClosed() {
                startActivity(new Intent(Main.this, NativeActivity.class));
                finish();
            }

            @Override
            public void onAdFailedToLoad(int i) {
                startActivity(new Intent(Main.this, NativeActivity.class));
                finish();
            }
        });
        ad.setAdUnitId(getString(R.string.int_id));
        ad.loadAd(new AdRequest.Builder().build());
        //        finish();
    }
}
