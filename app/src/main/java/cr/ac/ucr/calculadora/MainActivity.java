package cr.ac.ucr.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private int conteo=0;
    private double numero1, numero2, resultado;
    private String simbolo="", operacion="";
    //private char[] operacion;

    TextView txt_calculo;
    TextView txt_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_calculo = findViewById(R.id.txtCalculo);
        txt_resultado = findViewById(R.id.txtResultado);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_uno:
                insertarNumero(1);
                break;
            case R.id.btn_dos:
                insertarNumero(2);
                break;
            case R.id.btn_tres:
                insertarNumero(3);
                break;
            case R.id.btn_cuatro:
                insertarNumero(4);
                break;
            case R.id.btn_cinco:
                insertarNumero(5);
                break;
            case R.id.btn_seis:
                insertarNumero(6);
                break;
            case R.id.btn_siete:
                insertarNumero(7);
                break;
            case R.id.btn_ocho:
                insertarNumero(8);
                break;
            case R.id.btn_nueve:
                insertarNumero(9);
                break;
            case R.id.btn_cero:
                insertarNumero(0);
                break;
            case R.id.btn_punto:
                insertarSimbolo(".");
                break;
            case R.id.btn_limpiar:
                limpiar();
                break;
            case R.id.btn_limpiar2:
                limpiar();
                break;
            case R.id.btn_porcentaje:
                insertarSimbolo("%");
                break;
            case R.id.btn_division:
                insertarSimbolo("/");
                break;
            case R.id.btn_borrar:
                borrar();
                break;
            case R.id.btn_multiplicacion:
                insertarSimbolo("*");
                break;
            case R.id.btn_resta:
                insertarSimbolo("-");
                break;
            case R.id.btn_suma:
                insertarSimbolo("+");
                break;
            case R.id.btn_resultado:
                calculo();
                break;
            default:
                break;
        }
    }

    public void insertarNumero(int numero_digitado){
        //this.str_numero.concat(""+numero_digitado);
        this.operacion = operacion+numero_digitado;

        txt_calculo.setText(this.operacion);
    }

    public void insertarSimbolo(String simbolo_digitado){
        String ultimo_caracter = operacion.substring(operacion.length()-1);

        if(ultimo_caracter.equals("1") || ultimo_caracter.equals("2") || ultimo_caracter.equals("3") || ultimo_caracter.equals("4") || ultimo_caracter.equals("5") ||
                ultimo_caracter.equals("6") || ultimo_caracter.equals("7") || ultimo_caracter.equals("8") || ultimo_caracter.equals("9") || ultimo_caracter.equals("0")){
            this.simbolo = simbolo_digitado;
            this.operacion = operacion + simbolo;

            txt_calculo.setText(this.operacion);
        }
    }

    public void calculo(){
        String numero_s = "", numero_c, tipo = "";

        for (int i=0; i<this.operacion.length(); i++){
            numero_c = String.valueOf(this.operacion.charAt(i));

            if(numero_c.equals("1") || numero_c.equals("2") || numero_c.equals("3") || numero_c.equals("4") || numero_c.equals("5") || numero_c.equals("6") || numero_c.equals("7")
            || numero_c.equals("8") || numero_c.equals("9") || numero_c.equals("0") || numero_c.equals(".")){
                numero_s = numero_s + numero_c;
            }
            if(numero_c.equals("/") || numero_c.equals("*") || numero_c.equals("-") || numero_c.equals("+") || numero_c.equals("%")){
                this.conteo++;
                this.numero1 = Double.parseDouble(numero_s);
                tipo = numero_c;

                numero_s = "";
            }
            if(numero_c.equals(this.operacion.substring(this.operacion.length()-1))){
                this.numero2 = Double.parseDouble(numero_s);
            }
        }

        if(conteo<2){
            switch (tipo) {
                case "/":
                    this.resultado = this.numero1 / this.numero2;
                    break;

                case "*":
                    this.resultado = this.numero1 * this.numero2;
                    break;

                case "-":
                    this.resultado = this.numero1 - this.numero2;
                    break;

                case "+":
                    this.resultado = this.numero1 + this.numero2;
                    break;

                case "%":
                    this.resultado = this.numero1 % this.numero2;
                    break;
                default:
                    break;
            }
            txt_resultado.setText(String.valueOf(this.resultado));
        }else{
            txt_resultado.setText("Uyy kieto! Haz operaciones cuentapollos");
        }

    }

    public void limpiar(){
        this.operacion="";
        txt_resultado.setText("0");
        txt_calculo.setText("");
        conteo=0;
    }

    public void borrar(){
        conteo=0;

        String n_operacion = "";
        for (int i=0; i<(this.operacion.length()-1); i++){
            n_operacion = n_operacion + String.valueOf(this.operacion.charAt(i));
        }

        this.operacion = n_operacion;
        txt_calculo.setText(this.operacion);
    }
}