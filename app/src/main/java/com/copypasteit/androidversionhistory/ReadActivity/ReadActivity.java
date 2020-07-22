package com.copypasteit.androidversionhistory.ReadActivity;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;


import com.copypasteit.androidversionhistory.MainActivity.MainActivity;
import com.copypasteit.androidversionhistory.R;

import com.copypasteit.androidversionhistory.main.data.remote.ApiUtils;
import com.copypasteit.androidversionhistory.main.model.Post;
import com.startapp.android.publish.adsCommon.StartAppAd;
import com.startapp.android.publish.adsCommon.StartAppSDK;
import com.startapp.android.publish.adsCommon.VideoListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReadActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    CustomAdapter adapter;
    ProgressDialog pd;
    List<Post> modelList = new ArrayList<>();


    private StartAppAd startAppAd = new StartAppAd(this);
    SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //for startapps ads
        StartAppSDK.init(this, "203356447", true);
        startAppAd.loadAd(StartAppAd.AdMode.REWARDED_VIDEO);
        startAppAd.setVideoListener(new VideoListener() {
            @Override
            public void onVideoCompleted() {
                // Grant user with the reward
            }
        });

        setContentView(R.layout.activity_read);


        recyclerView = findViewById(R.id.recyclerview_id);
        refreshLayout = findViewById(R.id.swipe_container);
        pd = new ProgressDialog(this);

        recyclerView.setHasFixedSize(true);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new CustomAdapter(ReadActivity.this, modelList);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        //for swiftshift
        // SwipeRefreshLayout
        sweeprefresh();


        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        android.net.NetworkInfo wifi = cm
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        android.net.NetworkInfo datac = cm
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if ((wifi != null & datac != null) && (wifi.isConnected() | datac.isConnected())) {
            //connection is avlilable
        }else{
            //no connection
            showAlertDialog();
        }

        //for share prefarance data
        //Initializing our superheroes list

//        SharedPreferences sharedPreferences = getSharedPreferences("Data", MODE_PRIVATE);
//        String  post_title  = sharedPreferences.getString("post_title","Not Available");
//        String  post_author  = sharedPreferences.getString("post_author","Not Available");
//        String  post_details  = sharedPreferences.getString("post_details","Not Available");
//        String  post_category  = sharedPreferences.getString("post_category","Not Available");
//        String  post_date  = sharedPreferences.getString("post_date","Not Available");
        //showAlertDialog();
        getData();
        //deleteData(23);
        //serchData("");

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ReadActivity.this, MainActivity.class);
        startActivity(intent);
        StartAppAd.onBackPressed(this);
        finish();
    }

    private void sweeprefresh()
    {
        refreshLayout.setColorSchemeResources(R.color.colorPrimary,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
                refreshLayout.setRefreshing(false);
            }
        });
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ReadActivity.this);
        builder.setTitle("Error");
        builder.setMessage("No Network Connection").setCancelable(false)
                .setIcon(R.drawable.ic_error)
                ;
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.appbar_menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_rateus:

                return true;

            case R.id.menu_about:
                //do something
                LinearLayout item_contact = (LinearLayout) findViewById(R.id.contect_id);
                //for diaglog show
                Dialog myDialog  = new Dialog(ReadActivity.this);
                myDialog.setContentView(R.layout.dialog_contact);
                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                myDialog.show();

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void getData() {
        //set title progress diaglog
//        pd.setTitle("Loading Data...");
//        //for show progress diaglog
//        pd.show();

        Call<List<Post>> userList = ApiUtils.getAPIService().getpost();
        userList.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                List<Post> posts = response.body();
                adapter.setData(posts);
                recyclerView.setAdapter(adapter);

                //pd.dismiss();
                //show data


            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }



}
