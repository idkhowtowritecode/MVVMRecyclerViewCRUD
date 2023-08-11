package com.example.mvvmrecyclerviewcrud.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmrecyclerviewcrud.CustomDialog;
import com.example.mvvmrecyclerviewcrud.R;
import com.example.mvvmrecyclerviewcrud.ViewModel.RoomViewModel;
import com.example.mvvmrecyclerviewcrud.models.RoomData;

import java.util.List;

public class RoomDataAdapter extends RecyclerView.Adapter<RoomDataAdapter.ViewHolder> {
    public List<RoomData> dataList;
    public RoomViewModel roomViewModel;
    private Context context;

    public RoomDataAdapter(RoomViewModel roomViewModel, LifecycleOwner lifecycleOwner, Context context) {
        this.roomViewModel = roomViewModel;
        this.context = context;
        roomViewModel.getRoomDataListLiveData().observe(lifecycleOwner, new Observer<List<RoomData>>() {
            @Override
            public void onChanged(List<RoomData> newDataList) {
                dataList = newDataList;
                notifyDataSetChanged();
            }
        });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);


        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RoomData roomData = dataList.get(position);


        holder.roomIdTextView = holder.itemView.findViewById(R.id.textRoomId);
        holder.genderTextView = holder.itemView.findViewById(R.id.textGender);
        holder.checkInTimeTextView = holder.itemView.findViewById(R.id.textCheckInTime);
        holder.foodPreferenceTextView = holder.itemView.findViewById(R.id.textFoodPreference);
        holder.wifiTextView = holder.itemView.findViewById(R.id.textHasWifi);
        holder.breakfastTextView = holder.itemView.findViewById(R.id.textHasBreakfast);
        holder.lunchTextView = holder.itemView.findViewById(R.id.textHasLunch);

        holder.editButton = holder.itemView.findViewById(R.id.buttonEdit);
        holder.deleteButton = holder.itemView.findViewById(R.id.buttonDelete);

        holder.roomIdTextView.setText("Room ID: " + roomData.getRoomId());
        holder.genderTextView.setText("Gender: " + roomData.getGender());
        holder.checkInTimeTextView.setText("Check-in Time: " + roomData.getCheckInTime());
        holder.foodPreferenceTextView.setText("Food Preference: " + roomData.getFoodPreference());
        holder.wifiTextView.setText("Wifi: " + (roomData.hasWifi() ? "Yes" : "No"));
        holder.breakfastTextView.setText("Breakfast: " + (roomData.hasBreakfast() ? "Yes" : "No"));
        holder.lunchTextView.setText("Lunch: " + (roomData.hasLunch() ? "Yes" : "No"));
        // Set other data as needed

        holder.editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Edit Room ID: " + roomData.getRoomId(), Toast.LENGTH_SHORT).show();
                showEditDialog(roomData);
            }
        });
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle button click here for the specific card
                // You can access the RoomData associated with this card using 'roomData'
                // For example, you can display a toast message with some data from the RoomData
                Toast.makeText(view.getContext(), "Delete Room ID: " + roomData.getRoomId(), Toast.LENGTH_SHORT).show();
                roomViewModel.delete(roomData);

            }
        });
    }


    private void showEditDialog(RoomData roomData) {
        CustomDialog customDialog = new CustomDialog(context);


//        customDialog.setOnSaveClickListener(new CustomDialog.OnSaveClickListener() {
//            @Override
//            public void onSaveClick(RoomData updatedRoomData) {
//                // Here, you can handle the save or modify logic for the updatedRoomData
//                // For example, you can update the data in the RoomViewModel or database
//
//                // After saving or modifying, you can update the RecyclerView data
//                RoomDataAdapter.this.notifyDataSetChanged();
//            }
//        });

//        customDialog.setData(roomData);
        customDialog.show();
        customDialog.setData(roomData);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView roomIdTextView;
        TextView genderTextView;
        TextView checkInTimeTextView;
        TextView foodPreferenceTextView;
        TextView wifiTextView;
        TextView breakfastTextView;
        TextView lunchTextView;

        Button editButton,deleteButton;
        // Add references to other views in the card layout as needed

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            roomIdTextView = itemView.findViewById(R.id.textRoomId);
            genderTextView = itemView.findViewById(R.id.textGender);
            checkInTimeTextView = itemView.findViewById(R.id.textCheckInTime);
            foodPreferenceTextView = itemView.findViewById(R.id.textFoodPreference);
            wifiTextView = itemView.findViewById(R.id.textHasWifi);
            breakfastTextView = itemView.findViewById(R.id.textHasBreakfast);
            lunchTextView = itemView.findViewById(R.id.textHasLunch);

            editButton = itemView.findViewById(R.id.buttonEdit);
            deleteButton = itemView.findViewById(R.id.buttonDelete);
        }
    }


}
