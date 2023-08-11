package com.example.mvvmrecyclerviewcrud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvvmrecyclerviewcrud.Adapter.RoomDataAdapter;
import com.example.mvvmrecyclerviewcrud.ViewModel.RoomViewModel;
import com.example.mvvmrecyclerviewcrud.models.RoomData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText searchEditText;
    private RoomViewModel roomViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        searchEditText = findViewById(R.id.editTextSearch);

        Button buttonInsert = findViewById(R.id.insertButton);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // show the dialog
                CustomDialog customDialog = new CustomDialog(MainActivity.this);
                customDialog.show();
            }

        });

        roomViewModel = new ViewModelProvider(this).get(RoomViewModel.class);

        // Create some RoomData objects
        RoomData roomData1 = new RoomData("101", "Male", "12:00 PM", "Vegetarian", true, true, false);
        RoomData roomData2 = new RoomData("202", "Female", "02:30 PM", "Vegan", false, true, true);
        RoomData roomData3 = new RoomData("303", "Other", "04:45 PM", "Non-vegetarian", true, false, true);

        // Add the RoomData objects to the RoomViewModel
        roomViewModel.addRoomData(roomData1);
        roomViewModel.addRoomData(roomData2);
        roomViewModel.addRoomData(roomData3);
        RoomDataAdapter adapter = new RoomDataAdapter(roomViewModel, this,this);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // Pass the LifecycleOwner
        recyclerView.setAdapter(adapter);

    }


}