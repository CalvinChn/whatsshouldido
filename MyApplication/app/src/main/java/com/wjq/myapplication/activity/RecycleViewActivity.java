package com.wjq.myapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wjq.myapplication.R;
import com.wjq.myapplication.app.MyMsg;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class RecycleViewActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    List adapterDates;

    static class MyHandler extends Handler {
        WeakReference<Activity> mActivityReference;

        MyHandler(Activity activity) {
            mActivityReference = new WeakReference<Activity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            final Activity activity = mActivityReference.get();
            if (activity != null) {
                switch (msg.what) {
                    case MyMsg.FIND_VIEW_FINISH:

                        break;
                    case MyMsg.LOAD_DATE_FINISH:

                        break;
                    case MyMsg.REFRESH_VIEW:

                        break;


                }
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
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
        findView();
        initDates();

    }


    private void findView() {

        mRecyclerView = (RecyclerView) findViewById(R.id.id_rcview);
    }

    private void initDates() {
        adapterDates = new ArrayList<String>();
        String[] strs = new String[]{"Hello world!!", "Yes,as you can see,I'm a android code monkry,and I'm not android engineer.", "Neverming that it's a nice pretty to meet you here."};
        for (int i = 0; i < 100; i++) {
            adapterDates.add(strs[(int) Math.random() * 3] + "");
        }



        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.HORIZONTAL));
        mRecyclerView.setAdapter(new MyBasicAdapter());


    }

    class MyBasicAdapter extends RecyclerView.Adapter<MyBasicAdapter.ViewHolder> {


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }

        class ViewHolder extends RecyclerView.ViewHolder{
            TextView tv;
            ImageView img;

            public ViewHolder(View view){
                super(view);
                tv = (TextView) view.findViewById(R.id.id_tv);
                img = (ImageView) view.findViewById(R.id.id_img);
            }
        }
    }


}
