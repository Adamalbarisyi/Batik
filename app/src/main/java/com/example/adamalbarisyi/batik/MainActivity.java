package com.example.adamalbarisyi.batik;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvCategory;
    private ArrayList<Batik> list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(BatikData.getListData());
        showRecyclerList();

    }

    private void  showRecyclerList(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        BatikAdapter batikAdapter = new BatikAdapter(this);
        batikAdapter.setListBatik(list);
        rvCategory.setAdapter(batikAdapter);
    }
}
