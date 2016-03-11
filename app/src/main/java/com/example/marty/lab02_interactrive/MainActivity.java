package com.example.marty.lab02_interactrive;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        display(2);
    }

    private void display(int number) {
        TextView quantityTextView = (TextView)findViewById(R.id.quantity_text_view);
        quantityTextView.setText(String.valueOf(number));

        TextView priceTextView = (TextView)findViewById(R.id.price_text_view);
        int price = 5;
        int total = price *number;
        String myString = NumberFormat.getCurrencyInstance().format(total);
        priceTextView.setText(myString);
    }

    public void submitAdd(View view) {
        int Qty = 0;
        TextView quantityTextView = (TextView)findViewById(R.id.quantity_text_view);
        Qty = Integer.parseInt(quantityTextView.getText().toString()) + 1 ;
        quantityTextView.setText(String.valueOf(Qty));


    }

    public void submitSub(View view) {
    }
}
