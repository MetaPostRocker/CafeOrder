package com.example.cafeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextTextName);
        editTextPass = findViewById(R.id.editTextPassword);
    }

    @SuppressLint("ShowToast")
    public void onClickMakeOrder(View view) {
        Intent intent  = new Intent(this, MakeOrderActivity.class);
        String username = editTextName.getText().toString().trim();
        String password = editTextPass.getText().toString().trim();
        if (!username.isEmpty() && !password.isEmpty()) {
            intent.putExtra("userName", username);
            intent.putExtra("userPass", password);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Fill in all fields", Toast.LENGTH_SHORT).show();
        }
    }
}