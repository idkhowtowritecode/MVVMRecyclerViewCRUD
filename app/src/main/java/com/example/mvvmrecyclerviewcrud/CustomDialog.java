package com.example.mvvmrecyclerviewcrud;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

public class CustomDialog extends Dialog{
    private Context context;
    public CustomDialog(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialog_layout);

        // You can find and handle the UI components here
        // For example, set click listeners or get values from the UI components
    }
}
