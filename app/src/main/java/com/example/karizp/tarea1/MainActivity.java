package com.example.karizp.tarea1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private boolean isDolar;
    private float cambio=570;


    public void onRadioButtonClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.RadioBtnColones:
                if (checked) {
                    isDolar=false;
                    break;
                }
            case R.id.RadioBtnDolar:
                if (checked)
                {
                    isDolar=true;
                    break;
                }

        }
    }

    public void onButtonClick(View view)
    {
        float monto;
        EditText et = (EditText)findViewById(R.id.txtFieldNumber);
        monto =Float.parseFloat(et.getText().toString());

        if(isDolar) {
            monto=monto/cambio;
        }else {
            monto=monto*cambio;
        }


        Toast resultado = Toast.makeText(getApplicationContext(),"El resultado es: "+monto,Toast.LENGTH_LONG);
        resultado.setGravity(Gravity.CENTER,0,0);
        resultado.show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
