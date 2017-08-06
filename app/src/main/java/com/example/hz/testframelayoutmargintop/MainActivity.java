package com.example.hz.testframelayoutmargintop;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.del_data_tv).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                delSubDirData();
            }
        });

        findViewById(R.id.del_other_data_tv).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                delOtherAppSubDirData();
            }
        });
    }

    private void delSubDirData() {
        DataCleanManager.cleanApplicationData(getApplicationContext(), null);
        Log.d("hz-", "delSubDirData end");
    }

    private void delOtherAppSubDirData() {
        DataCleanOtherApp.cleanApplicationData(getApplicationContext(), null);
        Log.d("hz-", "delSubDirData other end");
    }

}

