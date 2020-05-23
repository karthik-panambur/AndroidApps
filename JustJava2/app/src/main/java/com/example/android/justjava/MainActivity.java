
/**
 * IMPORTANT: Make sure you are using the correct package name. 
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

//import android.support.v7.app.AppCompatActivity;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    private int quantity = 2;
    private int price = 5;
    private String emailSubject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    private String createOrderSummary(int price){
        CheckBox wcTopping = (CheckBox) findViewById(R.id.topping_whipped_cream);
        CheckBox cTopping = (CheckBox) findViewById(R.id.topping_chocolate);
        EditText name = (EditText)findViewById(R.id.name);
        emailSubject = "JustJava order for " + name.getText().toString();
        String Toppings = "Add whipped cream? " + wcTopping.isChecked() + "\nAdd chocolate topping? " + cTopping.isChecked();
        String summary = "Name: " + name.getText().toString() +"\n";
               summary += Toppings + "\n";
               summary += "Quantity: " + quantity+"\n";
               summary += "Total: " + price + "\n";
               summary += "Thank you!";
        return summary;
    }
    public void submitOrder(View view) {
        CheckBox wcTopping = (CheckBox) findViewById(R.id.topping_whipped_cream);
        CheckBox cTopping = (CheckBox) findViewById(R.id.topping_chocolate);
        if(wcTopping.isChecked())
            price+=1;
        if(cTopping.isChecked())
            price+=2;
        //displayMessage(createOrderSummary(quantity*price));
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_TEXT,createOrderSummary(quantity*price));
        intent.putExtra(Intent.EXTRA_SUBJECT,emailSubject);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void increment(View view){
        if(quantity + 1 > 100) {
            Context context = getApplicationContext();
            CharSequence text = "Order Quantity should be less than 100";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            return;
        }
        quantity += 1;
        display(quantity);
    }


    public void decrement(View view){
        if(quantity - 1 < 1) {
            Context context = getApplicationContext();
            CharSequence text = "Order quantity should be more than 0";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            return;
        }
        quantity -= 1;
        display(quantity);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(number  + "");
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        /*TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(message);*/
    }

}