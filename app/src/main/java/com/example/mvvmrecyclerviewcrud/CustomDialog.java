package com.example.mvvmrecyclerviewcrud;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.mvvmrecyclerviewcrud.models.RoomData;

public class CustomDialog extends Dialog{
    private Context context;
    private RoomData roomData;
    private View dialogView;
    private EditText editTextRoomId;
    private Spinner genderSpinner;
    private TimePicker timePicker;
    private RadioButton radioButtonEatMeat;
    private RadioButton radioButtonEatSeafood;
    private CheckBox checkBoxBreakfast;
    private CheckBox checkBoxLunch;
    public CustomDialog(@NonNull Context context) {

        super(context);
        this.context = context;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the dialog's layout and set the dialogView
        dialogView = LayoutInflater.from(context).inflate(R.layout.custom_dialog_layout, null);
        setContentView(R.layout.custom_dialog_layout);

        // Initialize the UI components here after setContentView
//        editTextRoomId = findViewById(R.id.roomIdTextView);
        genderSpinner = findViewById(R.id.genderSpinner);
        timePicker = findViewById(R.id.timePicker);
        radioButtonEatMeat = findViewById(R.id.radioButton1);
        radioButtonEatSeafood = findViewById(R.id.radioButton2);
        checkBoxBreakfast = findViewById(R.id.checkBoxBreakfast);
        checkBoxLunch = findViewById(R.id.checkBoxLunch);

        // You can find and handle the UI components here
        // For example, set click listeners or get values from the UI components
        Button saveButton = findViewById(R.id.buttonSave);
        Button cancelButton = findViewById(R.id.buttonCancel);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Save", Toast.LENGTH_SHORT).show();
                if (onSaveClickListener != null) {
                    onSaveClickListener.onSaveClick(roomData); // Pass the edited data back to the listener
                }
                dismiss();
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

    }

    // Custom listener interface
    public interface OnSaveClickListener {
        void onSaveClick(RoomData roomData);
    }

    private OnSaveClickListener onSaveClickListener;

    public void setOnSaveClickListener(OnSaveClickListener listener) {
        this.onSaveClickListener = listener;
    }

    // Method to set data in the dialog
    public void setData(RoomData roomData) {
        this.roomData = roomData;
        if (roomData != null) {
            // Set the data to the UI components
            editTextRoomId = this.findViewById(R.id.roomIdTextView);
            editTextRoomId.setText(roomData.getRoomId());
            int genderPosition = getGenderPosition(roomData.getGender());
            if (genderPosition != -1) {
                genderSpinner.setSelection(genderPosition);
            }
            setTimePicker(timePicker, roomData.getCheckInTime());
            setFoodPreferenceRadioButton(radioButtonEatMeat, radioButtonEatSeafood, roomData.getFoodPreference());
            checkBoxBreakfast.setChecked(roomData.hasBreakfast());
            checkBoxLunch.setChecked(roomData.hasLunch());
            // Set other data as needed
        }
    }

    // Helper method to get the position of the gender in the spinner
    private int getGenderPosition(String gender) {
        String[] genders = context.getResources().getStringArray(R.array.spinner_items);
        for (int i = 0; i < genders.length; i++) {
            if (genders[i].equals(gender)) {
                return i;
            }
        }
        return -1;
    }

    // Helper method to set time in the TimePicker
    private void setTimePicker(TimePicker timePicker, String timeString) {
        String[] timeParts = timeString.split(":");
        int hour = Integer.parseInt(timeParts[0]);
        int minute = Integer.parseInt(timeParts[1]);

        timePicker.setHour(hour);
        timePicker.setMinute(minute);
    }

    // Helper method to set the selected radio button based on food preference
    private void setFoodPreferenceRadioButton(RadioButton radioButtonEatMeat, RadioButton radioButtonEatSeafood, String foodPreference) {
        if (foodPreference.equals("Eat meat")) {
            radioButtonEatMeat.setChecked(true);
        } else {
            radioButtonEatSeafood.setChecked(true);
        }
    }


}
