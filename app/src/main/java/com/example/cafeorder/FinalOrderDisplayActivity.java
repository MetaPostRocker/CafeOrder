package com.example.cafeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FinalOrderDisplayActivity extends AppCompatActivity {

    private TextView order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_order_display);
        order = findViewById(R.id.textViewOrder);
        Intent intent = getIntent();
        order.setText(intent.getStringExtra("order"));
    }
}