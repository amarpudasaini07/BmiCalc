package com.bmicalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etweight,etheight;
    private Button btncalc;
    private TextView tvresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etweight=findViewById(R.id.etweight);
        etheight=findViewById(R.id.etheight);
        btncalc=findViewById(R.id.btncalc);
        tvresult=findViewById(R.id.tvresult);


        btncalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isEmpty()){
                    float height = Float.parseFloat(etheight.getText().toString());
                    float weight = Float.parseFloat(etweight.getText().toString());
                    calc bmi=new calc(height,weight);
                    float result=bmi.result();
                    tvresult.setText(Float.toString(result));
                    float value=Float.parseFloat(tvresult.getText().toString());
                    if (value<18.5){
                        Toast.makeText(MainActivity.this, "Under Weight", Toast.LENGTH_SHORT).show();
                    }
                    else if (value>18.5 && value<24.9){
                        Toast.makeText(MainActivity.this, "Normal Weight", Toast.LENGTH_SHORT).show();
                    }
                    else if (value>24.9 && value<29.9){
                        Toast.makeText(MainActivity.this, "Over Weight", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Obesity", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }

    private boolean isEmpty() {
        if (TextUtils.isEmpty(etheight.getText().toString())) {
            etheight.setError("Please enter height");
            etheight.requestFocus();
            return true;
        } else if (TextUtils.isEmpty(etweight.getText().toString())) {
            etweight.setError("Please enter weight");
            etweight.requestFocus();
            return true;
        } else return false;
    }
}
