package zhet.tunnel.activity;

import android.app.Activity;
import android.app.NativeActivity;
import android.content.Intent;
import android.os.Bundle;

import zhet.tunnel.R;


public class Main extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run(){
                         startActivity(new Intent(Main.this, NativeActivity.class));
                        finish();
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
