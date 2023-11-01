package com.example.market_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener{

    //1- AdapterView
    RecyclerView recyclerView;
    //2-Data Source
    List<Item> itemList;

    //3- Adapter
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        itemList = new ArrayList<>();
        Item item1 = new Item(R.drawable.fruits,"Fruits",
                "Fresh Fruits from the Garden");
        Item item2 = new Item(R.drawable.vegetables,"Vegetables",
                "Fresh Vegetables from Garden");
        Item item3 = new Item(R.drawable.bred,"Bread",
                "Bread, Wheat & Beans");
        Item item4 = new Item(R.drawable.beverage,"Beverages",
                "Juices, Coffee & Soda");
        Item item5 = new Item(R.drawable.milk,
                "Milk","Milk, Shakes and Yogurt");
        Item item6 = new Item(R.drawable.snack,"Snacks",
                "Tasty Snacks Samosa,Pakori,Gulab Jamun etc ");

        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);
        itemList.add(item6);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);


        myAdapter = new MyAdapter(itemList);
        recyclerView.setAdapter(myAdapter);

        myAdapter.setClickListener(this);
    }

    @Override
    public void onCLick(View v, int pos) {
        Toast.makeText(this, "You Choose "+ itemList.get(pos).getItemName(),
                Toast.LENGTH_SHORT).show();
    }
}