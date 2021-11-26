package com.example.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    MainActivity m = new MainActivity();
    private static final String TAG_ACTIVITY =
            OrderActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Spinner spinner = (Spinner) findViewById(R.id.spinnersito);
        //Ara cream l'aray
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.pedido_Extra, android.R.layout.simple_spinner_item);//ha de ser simple_spinner_item
        //Feim que baixi quan se cliqui
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }
    public void displayToast(String message) { Toast.makeText(getApplicationContext(),
            message,
            Toast.LENGTH_SHORT).show();
    }
    public void onRadioButtonClicked(View view) {
// Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
// Check which radio button was clicked
switch(view.getId()) {
        case R.id.sameday: if
        (checked)
// Same day service
            displayToast(getString(R.string.chosen) +
            getString(R.string.same_day_messenger_service)+"Es curiós nombre de "+ 1);
        break;
        case R.id.nextday: if
        (checked)
// Next day delivery
            displayToast(getString(R.string.chosen) +
            getString(R.string.next_day_ground_delivery));
        break;
        case R.id.pickup: if
        (checked)
// Pick up
            displayToast(getString(R.string.chosen) +
            getString(R.string.pick_up));
        break; default:
        Log.d(TAG_ACTIVITY, getString(R.string.nothing_clicked)); break;
        }
    }

//Mètodes creats quan hem implementat OnItemSelected
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String seleccionat = "Has decidit afegir: " + parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), seleccionat, Toast.LENGTH_SHORT).show();
        if(parent.getItemAtPosition(position) == parent.getItemAtPosition(0)){
            m.donutSuma();
        }else if(parent.getItemAtPosition(position) == parent.getItemAtPosition(1)){
            m.gelatSuma();
        }else{
            m.iogurtSuma();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void showCarrito(View view){
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, m.getCounts(), Toast.LENGTH_SHORT);
        toast.show();
    }
}