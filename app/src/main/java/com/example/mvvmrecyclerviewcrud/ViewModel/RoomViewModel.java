package com.example.mvvmrecyclerviewcrud.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.LiveData;

import com.example.mvvmrecyclerviewcrud.models.RoomData;

import java.util.ArrayList;
import java.util.List;

public class RoomViewModel extends ViewModel {
    private MutableLiveData<List<RoomData>> roomDataListLiveData = new MutableLiveData<>();
    private List<RoomData> roomDataList = new ArrayList<>();


    public LiveData<List<RoomData>> getRoomDataListLiveData() {
        return roomDataListLiveData;
    }

    public void addRoomData(RoomData roomData) {
        roomDataList.add(roomData);
        roomDataListLiveData.setValue(roomDataList);
    }

    public void insert(RoomData roomData) {

        roomDataList.add(roomData);
        roomDataListLiveData.setValue(roomDataList);
    }
    public void update(RoomData roomData) {

        int index = roomDataList.indexOf(roomData);
        if (index != -1) {
            roomDataList.set(index, roomData);
            roomDataListLiveData.setValue(roomDataList);
        }
    }


    public void delete(RoomData roomData) {

        roomDataList.remove(roomData);
        roomDataListLiveData.setValue(roomDataList);
    }

}
