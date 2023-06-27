package com.example.project1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView shopingrecycleview;
    FloatingActionButton floatingactionbtnupdatedata;
    ArrayList<ShopingModel> storecustomerdata=new ArrayList<>();
    ArrayList<apimodel> apimodellist=new ArrayList<>();
    ShopingAdapter adapter;
    String url="https://jsonplaceholder.typicode.com/photos";
//    String url="https://dummyjson.com/products/1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shopingrecycleview=findViewById(R.id.shopingrecycleview);
        floatingactionbtnupdatedata=findViewById(R.id.floatingactionbtnupdatedata);
        shopingrecycleview.setLayoutManager(new LinearLayoutManager(this));
//        shopingrecycleview.setLayoutManager(new GridLayoutManager(this, 2));


        //api fetching code
        getdata();
        setFloatingactionbtnupdatedata();


        adapter = new ShopingAdapter( this,apimodellist);
        shopingrecycleview.setAdapter(adapter);
        ItemTouchHelper itemTouchHelper=new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(shopingrecycleview);




    }


    public void getdata()
    {
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> {
                    try {
                        Log.e("api", "onErrorResponse: " + response.toString());
                        JSONArray array=new JSONArray(response);
                        for (int i=0;i<=5;i++)
                        {
                            JSONObject singleobject=array.getJSONObject(i);
                            apimodel singlemodel=new apimodel(
                                    singleobject.getString("id"),
                                    singleobject.getString("title"),
                                    singleobject.getString("thumbnailUrl")
                            );
                            apimodellist.add(singlemodel);
                        }
                        Log.e("api", "onResponse: " +storecustomerdata.size()
                        );
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.e("api", "response: " + e.getMessage());
                    }
                }, error -> Log.e("api", "onErrorResponse: " + error.getLocalizedMessage()));

        queue.add(stringRequest);
    }


//    delete operation


    ItemTouchHelper.SimpleCallback simpleCallback=new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            int position=viewHolder.getAdapterPosition();
            switch (direction)
            {
                case ItemTouchHelper.LEFT:
                    apimodellist.remove(position);
                    adapter.notifyItemRemoved(position);
                    // Toast.makeText(MainActivity.this, "delete success", Toast.LENGTH_SHORT).show();
                    break;
                case ItemTouchHelper.RIGHT:
                    apimodellist.remove(position);
                    break;
            }
        }
    };


    public void setFloatingactionbtnupdatedata()
    {
        floatingactionbtnupdatedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog=new Dialog()
            }
        });
    }


}