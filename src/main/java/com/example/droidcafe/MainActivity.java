package com.example.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public int donutCount = 0;
    public int gelatCount = 0;
    public int iogurtCount = 0;

    public MainActivity(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
    }
    public void donutSuma(){
        donutCount++;
    }
    public void gelatSuma(){
        gelatCount++;
    }
    public void iogurtSuma(){
        iogurtCount++;
    }
    public String getCounts(){
        String torna = "Succesfully: " + String.valueOf(donutCount) + " donuts, " + String.valueOf(gelatCount) + " ice creams and "
                + String.valueOf(iogurtCount) + " frozen yogurtitos.";
        return torna;
    }


    /**
     * Shows a message that the donut image was clicked. <<< Hem afegit els strings de l'anunciat
     * per evitar que ens doni error
     */
    public void showDonutOrder(View view) {
        showFoodOrder(getString(R.string.donut_order_message));
        donutSuma();
    }
    /**
     * Shows a message that the ice cream sandwich image was clicked.
     */
    public void showIceCreamOrder(View view) {
        showFoodOrder(getString(R.string.ice_cream_order_message));
        gelatSuma();
    }
    /**
     * Shows a message that the froyo image was clicked.
     */
    public void showFroyoOrder(View view) {
        showFoodOrder(getString(R.string.froyo_order_message));
        iogurtSuma();
    }

    /*
    Aquí baix diu que showFoodOrder execute displayToast, que mostra es toast.
     */
    /**
     * Displays a toast message for the food order
     * and starts the OrderActivity activity.
     * @parammessage Message to display.
     */
    public void showFoodOrder(String message) { displayToast(message);
        Intent intent = new Intent(this,OrderActivity.class);//Nou INTENT per canviar aquesta classe a OrderActivity.
        startActivity(intent);
    }
    public void displayToast(String message) { Toast.makeText(getApplicationContext(),
            message,
            Toast.LENGTH_SHORT).show();
    }
}