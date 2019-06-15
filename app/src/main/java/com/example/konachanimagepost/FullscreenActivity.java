package com.example.konachanimagepost;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.AlertDialogLayout;
import android.support.v7.widget.DialogTitle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity {


    ArrayList<ImageSrc> list;
    Post_adapter post_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        list = new ArrayList<ImageSrc>();
        ListView lv = (ListView) findViewById(R.id.lvImage);
        list.add(new ImageSrc("id", 12345678, "tags", "Link source", 1024, "File Url", "Score", "Samle File", 1024, 768));
        post_adapter = new Post_adapter(this, R.layout.item_post, list);
        lv.setAdapter(post_adapter);
        Button btn = (Button) findViewById(R.id.btnAdd);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new GetUrl().execute("http://konachan.com/post.json?limit=10&page=1");
            }
        });
    }

    public void addImage(String json) {
        try {
            Moshi moshi = new Moshi.Builder().build();
            Type type = Types.newParameterizedType(List.class, ImageSrc.class);
            final JsonAdapter<List<ImageSrc>> listJsonAdapter = moshi.adapter(type);
            list.addAll((ArrayList<ImageSrc>) listJsonAdapter.fromJson(json));
            post_adapter.notifyDataSetChanged();
        } catch (IOException e) {
            Log.d("AddImage IO", "addImage: " + e.getMessage());
        }

    }

    class GetUrl extends AsyncTask<String, String, String> {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();

        @Override
        protected String doInBackground(String... strings) {
            Request.Builder builder = new Request.Builder();
            builder.url(strings[0]);
            Request request = builder.build();
            try {
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            if (!s.equals("")) {
                addImage(s.replace("\\", ""));
                Log.d("onPostExecute", "onPostExecute: " + s);
            } else {
                Log.d(GetUrl.class.getName(), "onPostExecute: " + "Null");
            }
            super.onPostExecute(s);
        }
    }


}
