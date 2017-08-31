package lozada.sindy.calcdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    protected EditText et1,et2;
    private TextView tv3;
    private Spinner spinnerl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 =(EditText)findViewById(R.id.editText);
        et2 =(EditText)findViewById(R.id.editText2);
        tv3 =(TextView)findViewById(R.id.textView3);
        spinnerl = (Spinner)findViewById(R.id.spinner2);

        String []opciones={"sumar","restar","multiplicar","dividir"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opciones);
        spinnerl.setAdapter(adapter);
    }

    public void Sumar(View v){
        try {
            String valor1=et1.getText().toString();
            String valor2=et2.getText().toString();
            int num1 =Integer.parseInt(valor1);
            int num2 =Integer.parseInt(valor2);
            String selec= spinnerl.getSelectedItem().toString();
            if(selec.equals("sumar")){
                int suma=num1+num2;
                String resu=String.valueOf(suma);
                tv3.setText(resu);
            }
            if (selec.equals("restar")){
                int resta=num1-num2;
                String resu=String.valueOf(resta);
                tv3.setText(resu);
            }

            if(selec.equals("multiplicar")){
                float multiplicar=num1*num2;
                String resu=String.valueOf(multiplicar);
                tv3.setText(resu);
            }
            if(selec.equals("dividir")){
                int divi=num1/num2;
                String resu=String.valueOf(divi);
                tv3.setText(resu);
            }

            // int suma=num1+num2;
            // String resultado=String.valueOf(suma);
            // tv3.setText(resultado);


        } catch (NumberFormatException e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this,"NO PUEDE DEJAR LOS CAMPOS SOLICITADOS EN BLANCO", Toast.LENGTH_SHORT).show();
        }
    }
}
