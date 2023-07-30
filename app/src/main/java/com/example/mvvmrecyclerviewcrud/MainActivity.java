package com.example.mvvmrecyclerviewcrud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private EditText searchEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        searchEditText = findViewById(R.id.editTextSearch);

        Button buttonToast = findViewById(R.id.toastButton);
        buttonToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // show the dialog
                CustomDialog customDialog = new CustomDialog(MainActivity.this);
                customDialog.show();
            }

        });


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String[] data = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
        List<String> dataList = new ArrayList<>();
        for (String item : data) {
            dataList.add(item);
        }
        adapter = new ItemAdapter(dataList);
        recyclerView.setAdapter(adapter);
    }


}