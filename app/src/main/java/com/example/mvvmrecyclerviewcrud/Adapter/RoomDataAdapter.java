package com.example.mvvmrecyclerviewcrud.Adapter;

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

import com.example.mvvmrecyclerviewcrud.R;
import com.example.mvvmrecyclerviewcrud.ViewModel.RoomViewModel;
import com.example.mvvmrecyclerviewcrud.models.RoomData;

import java.util.List;

public class RoomDataAdapter extends RecyclerView.Adapter<RoomDataAdapter.ViewHolder> {
    private List<RoomData> dataList;
    private RoomViewModel roomViewModel;
    public RoomDataAdapter(RoomViewModel roomViewModel, LifecycleOwner lifecycleOwner) {
        this.roomViewModel = roomViewModel;
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
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RoomData roomData = dataList.get(position);

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
