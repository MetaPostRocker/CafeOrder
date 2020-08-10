package com.example.cafeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MakeOrderActivity extends AppCompatActivity {

    private TextView textViewHello;
    private TextView textViewAdditional;
    private Spinner spinnerCoffee;
    private Spinner spinnerTea;
    private String drink;
    private CheckBox sugar;
    private CheckBox milk;
    private CheckBox lemon;
    private String name;
    private String pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_order);
        textViewHello = findViewById(R.id.textViewHello);
        textViewAdditional = findViewById(R.id.textViewAdditional);
        spinnerCoffee = findViewById(R.id.spinnerCoffee);
        spinnerTea = findViewById(R.id.spinnerTea);
        sugar = findViewById(R.id.checkBoxSugar);
        milk = findViewById(R.id.checkBoxMilk);
        lemon = findViewById(R.id.checkBoxLemon);
        Intent intent = getIntent();
        name = intent.getStringExtra("userName");
        pass = intent.getStringExtra("userPass");
        textViewHello.setText(String.format(getString(R.string.choose_drink_hello), name));
        textViewAdditional.setText(String.format(getString(R.string.additional), getString(R.string.tea)));
        drink = getString(R.string.tea);
    }

    public void changeDrink(View view) {
        RadioButton radioButton = (RadioButton) view;
        if (radioButton.getId() == R.id.radioButtonTea) {
            textViewAdditional.setText(String.format(getString(R.string.additional), getString(R.string.tea)));
            spinnerTea.setVisibility(View.VISIBLE);
            spinnerCoffee.setVisibility(View.INVISIBLE);
            drink = getString(R.string.tea);
        } else {
            textViewAdditional.setText(String.format(getString(R.string.additional), getString(R.string.coffee)));
            spinnerTea.setVisibility(View.INVISIBLE);
            spinnerCoffee.setVisibility(View.VISIBLE);
            drink = getString(R.string.coffee);
        }
    }

    public void finishOrder(View view) {
        StringBuilder additions = new StringBuilder();
        if (sugar.isChecked()) {
            additions.append(getString(R.string.sugar));
        }
        if (milk.isChecked()) {
            if (additions.length() != 0) {
                additions.append(", ");
            }
            additions.append(getString(R.string.milk));
        }
        if (lemon.isChecked()) {
            if (additions.length() != 0) {
                additions.append(", ");
            }
            additions.append(getString(R.string.lemon));
        }
        String drinkType;
        if (drink.equals(getString(R.string.tea))) {
            drinkType = spinnerTea.getSelectedItem().toString();
        } else {
            drinkType = spinnerCoffee.getSelectedItem().toString();
        }
        String order = String.format("Name: %s\nPassword: %s\nDrink: %s\nType: %s\nAdd: %s\n", name, pass, drink, drinkType, additions.toString());
        Intent intent = new Intent(this, FinalOrderDisplayActivity.class);
        intent.putExtra("order", order);
        startActivity(intent);
    }


}