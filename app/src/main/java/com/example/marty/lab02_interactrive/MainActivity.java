package com.example.marty.lab02_interactrive;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int mQuantity = 0;
    private int mPrice = 5;
    private final String mNT$ = "NT$";
    private StringBuilder mTotalPriceMessage = new StringBuilder(mNT$);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {

        displayTotalPrice();

    }

    private void displayTotalPrice() {

        TextView priceTextView = (TextView)findViewById(R.id.price_text_view);
        int total = mPrice * mQuantity;
        int startIndex = mNT$.length();
        int endIndex =  mTotalPriceMessage.length();
        mTotalPriceMessage.delete(startIndex, endIndex).append(total);
       // String myString = NumberFormat.getCurrencyInstance().format(total);
        priceTextView.setText(mTotalPriceMessage);
        String myString2 = "Thank You!";
        if(mQuantity == 0) {
            myString2 = "Free";
        }
        TextView okTextView = (TextView)findViewById(R.id.ok_text_view);
        okTextView.setText(myString2);



    }

    private void displayMsg() {

        TextView priceTextView = (TextView)findViewById(R.id.price_text_view);
        priceTextView.setText("");
        TextView okTextView = (TextView)findViewById(R.id.ok_text_view);
        okTextView.setText("");
    }

    private void displayQuantity() {

        TextView quantityTextView =  (TextView)findViewById(R.id.quantity_text_view);
        quantityTextView.setText(String.valueOf(mQuantity));
    }

    public void submitAdd(View view) {

       ++mQuantity;
       displayQuantity();
        displayMsg();

    }

    @NonNull
    private int getQuanitty() {
        TextView quantityTextView = (TextView)findViewById(R.id.quantity_text_view);
        String quantityString = quantityTextView.getText().toString();
        return Integer.parseInt(quantityString);

    }

    public void submitSub(View view) {

        if(mQuantity > 0) {
            --mQuantity;
            displayQuantity();
            displayMsg();
        }

    }
}
