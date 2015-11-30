package com.wjq.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.wjq.myapplication.activity.ImgMainActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        startNewThread("第1条 耗时500", 1, 500);
        startNewThread("第2条 耗时2000", 1, 2000);
        startNewThread("第3条 耗时1000", 1, 1000);
        startNewThread("第4条 耗时42000", 1, 4000);
        startNewThread("第5条 耗时3000", 1, 3000);


    }


    private void startNewThread(final String msg, final int id, final int sleepTime) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(sleepTime);
                    Log.i(msg, "this time I'll show you the thread id");
                    Log.i(msg, "thread id = "+Thread.currentThread().getId());


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();


    }

    public void mainClick(View view) {


        switch (view.getId()) {
            case R.id.button00:
                startActivity(new Intent(MainActivity.this, ImgMainActivity.class));

                break;

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
