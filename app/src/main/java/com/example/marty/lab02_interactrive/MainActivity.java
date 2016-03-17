package com.example.marty.lab02_interactrive;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int mQuantity = 0;
    private int mPrice = 5;
    private int mToppingPrice = 50;
    private final String mNT$ = "NT$";
    private StringBuilder mTotalPriceMessage = new StringBuilder("NT$" + mToppingPrice);
    private StringBuilder mTotalPriceMessage2 = new StringBuilder("");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayMsg();
    }

    public void submitOrder(View view) {

        displayTotalPrice();

    }

    private void displayTotalPrice() {
        final CheckBox checkBox = (CheckBox) findViewById(R.id.Toppings_CheckBox_view);
        TextView priceTextView = (TextView)findViewById(R.id.price_text_view);
        int total = mToppingPrice * mQuantity ;
        int startIndex = mNT$.length();
        int endIndex =  mTotalPriceMessage.length();
        mTotalPriceMessage.delete(startIndex, endIndex).append(total);

        int start = 0;
        int end = mTotalPriceMessage2.length();
       // String myString = NumberFormat.getCurrencyInstance().format(total);
        mTotalPriceMessage2 = mTotalPriceMessage2.delete(start,end).append("Name:鳴人\n臭豆腐\n加泡菜?"+ (checkBox.isChecked()  ? "true" : "false")
                + (total > 0 ? "\nQuanity:"+ String.valueOf(mQuantity) + "\n"+mTotalPriceMessage : "" ));
        priceTextView.setText(mTotalPriceMessage2);
        String myString2 = "Thank You!";
        if(total == 0) {
            myString2 = "Free";
        }
        TextView okTextView = (TextView)findViewById(R.id.ok_text_view);
        okTextView.setText(myString2);



    }

    private void displayMsg() {
        final CheckBox checkBox = (CheckBox) findViewById(R.id.Toppings_CheckBox_view);
        if (checkBox.isChecked()) {
            mToppingPrice = 50;
        }
        else
            {
                mToppingPrice = 0;
            }
        mTotalPriceMessage = mTotalPriceMessage.delete(0,mTotalPriceMessage.length()).append("NT$" + mToppingPrice);
        TextView priceTextView = (TextView)findViewById(R.id.price_text_view);
        priceTextView.setText(mTotalPriceMessage);
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

    public void clickToppings(View view) {

        final CheckBox checkBox = (CheckBox) findViewById(R.id.Toppings_CheckBox_view);
        if (checkBox.isChecked()) {
            mToppingPrice = 50;
            TextView priceTextView = (TextView)findViewById(R.id.price_text_view);
            int startIndex = mNT$.length();
            int endIndex =  mTotalPriceMessage.length();
            mTotalPriceMessage.delete(startIndex, endIndex).append(mToppingPrice);
            // String myString = NumberFormat.getCurrencyInstance().format(total);
            priceTextView.setText(mTotalPriceMessage);
        }
        else
        {
            mToppingPrice = 0;
            displayMsg();
        }
    }
}
