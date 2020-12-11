package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static String currentText;
    private static String previewText="0";
    private static Double lastValue=0.0;
    private static Double currentValue= 0.0;
    private static int decimalPlaceDepth = 0;
    //private static Boolean isNegated = false;
    private static Sign sign;
    private EditText btnResult;
    private TextView btnPreview;

    private enum Sign {
        Add,
        Subt,
        Mult,
        Div,
    }

    private double Compute(double a, double b){
        if(sign == null)
            return b;
        switch (sign){
            case Add:
                return a+b;
            case Subt:
                return a-b;
            case Mult:
                return a*b;
            case Div:
                return a/b;
            default:
                return b;
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.buttonNegate:/* // was hard to implement so i avoided it
                if(isNegated){
                    previewText = previewText.replace("-"+String.valueOf(currentValue),"+"+String.valueOf(currentValue));
                }else{
                    previewText = previewText.replace("+"+String.valueOf(currentValue),"-"+String.valueOf(currentValue));
                }
                currentValue *= -1;
                isNegated = !isNegated;*/
                Toast.makeText(MainActivity.this, "Negating didn't implemented yet", Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonDec:
                if(decimalPlaceDepth == 0){
                    decimalPlaceDepth =1;
                    previewText += ".";
                }
                else if(decimalPlaceDepth == 1) {
                    decimalPlaceDepth = 0;
                    previewText = previewText.substring(0,previewText.length()-1);
                }
                break;
            case R.id.buttonCE:
                currentValue = 0.0;
                decimalPlaceDepth = 0;
                for(int i = previewText.length()-1; i>=0;i--){
                    char j = previewText.charAt(i);
                    if(j == '+' || j == '-' || j == 'x' || j == '/'){
                        previewText = previewText.substring(0,i+1);
                        break;
                    }
                    if(i == 0)
                        previewText = "0";
                }
                break;
            case R.id.buttonClear:
                currentValue = 0.0;
                lastValue = 0.0;
                decimalPlaceDepth = 0;
                previewText = "0";
                sign = null;
                break;
            case R.id.buttonErase:
                if (currentValue>0){
                    if(decimalPlaceDepth >1){
                        currentValue = currentValue*Math.pow(10,decimalPlaceDepth-1); //precision handling
                        currentValue= currentValue.intValue()*1.0;
                        currentValue -= currentValue%10;
                        currentValue = currentValue/Math.pow(10,decimalPlaceDepth-1);
                        decimalPlaceDepth--;
                    }else if(decimalPlaceDepth ==1){
                        decimalPlaceDepth--;
                    }else{
                        currentValue -= currentValue%10;
                        currentValue /=10;
                    }
                    previewText = previewText.substring(0,previewText.length()-1);
                }
                break;
            case R.id.button0:
                if(decimalPlaceDepth == 0) {
                    currentValue = currentValue * 10;
                    previewText += previewText.equals("0") ? "" : "0";
                }else{
                    decimalPlaceDepth++;
                    previewText += "0";
                }
                break;
            case R.id.button1:
                if(decimalPlaceDepth == 0) {
                    currentValue = currentValue * 10 + 1;
                    previewText = previewText.equals("0") ? "1" : previewText + "1";
                }else{
                    currentValue = currentValue + (1/(Math.pow(10,decimalPlaceDepth)));
                    previewText += "1";
                    decimalPlaceDepth++;
                }
                break;
            case R.id.button2:
                if(decimalPlaceDepth == 0) {
                    currentValue = currentValue * 10 + 2;
                    previewText = previewText.equals("0") ? "2" : previewText + "2";
                }else{
                    currentValue = currentValue + (2/(Math.pow(10,decimalPlaceDepth)));
                    previewText += "2";
                    decimalPlaceDepth++;
                }
                break;
            case R.id.button3:
                if(decimalPlaceDepth == 0) {
                    currentValue = currentValue * 10 + 3;
                    previewText = previewText.equals("0") ? "3" : previewText + "3";
                }else{
                    currentValue = currentValue + (3/(Math.pow(10,decimalPlaceDepth)));
                    previewText += "3";
                    decimalPlaceDepth++;
                }
                break;
            case R.id.button4:
                if(decimalPlaceDepth == 0) {
                    currentValue = currentValue * 10 + 4;
                    previewText = previewText.equals("0") ? "4" : previewText + "4";
                }else{
                    currentValue = currentValue + (4/(Math.pow(10,decimalPlaceDepth)));
                    previewText += "4";
                    decimalPlaceDepth++;
                }
                break;
            case R.id.button5:
                if(decimalPlaceDepth == 0) {
                    currentValue = currentValue * 10 + 5;
                    previewText = previewText.equals("0") ? "5" : previewText + "5";
                }else{
                    currentValue = currentValue + (5/(Math.pow(10,decimalPlaceDepth)));
                    previewText += "5";
                    decimalPlaceDepth++;
                }
                break;
            case R.id.button6:
                if(decimalPlaceDepth == 0) {
                    currentValue = currentValue * 10 + 6;
                    previewText = previewText.equals("0") ? "6" : previewText + "6";
                }else{
                    currentValue = currentValue + (6/(Math.pow(10,decimalPlaceDepth)));
                    previewText += "6";
                    decimalPlaceDepth++;
                }
                break;
            case R.id.button7:
                if(decimalPlaceDepth == 0) {
                    currentValue = currentValue * 10 + 7;
                    previewText = previewText.equals("0") ? "7" : previewText + "7";
                }else{
                    currentValue = currentValue + (7/(Math.pow(10,decimalPlaceDepth)));
                    previewText += "7";
                    decimalPlaceDepth++;
                }
                break;
            case R.id.button8:
                if(decimalPlaceDepth == 0) {
                    currentValue = currentValue * 10 + 8;
                    previewText = previewText.equals("0") ? "8" : previewText + "8";
                }else{
                    currentValue = currentValue + (8/(Math.pow(10,decimalPlaceDepth)));
                    previewText += "8";
                    decimalPlaceDepth++;
                }
                break;
            case R.id.button9:
                if(decimalPlaceDepth == 0) {
                    currentValue = currentValue * 10 + 9;
                    previewText = previewText.equals("0") ? "9" : previewText + "9";
                }else{
                    currentValue = currentValue + (9/(Math.pow(10,decimalPlaceDepth)));
                    previewText += "9";
                    decimalPlaceDepth++;
                }
                break;

            case R.id.buttonPlus:
                if(sign == null){
                    lastValue = currentValue;
                    currentValue = 0.0;
                    previewText += "+";
                    decimalPlaceDepth = 0;
                }else if(lastValue != 0.0){
                    lastValue = Compute(lastValue,currentValue);
                    currentValue = 0.0;
                    decimalPlaceDepth = 0;
                    previewText = lastValue.toString()+"+";
                }else
                    previewText = previewText.substring(0,previewText.length()-1)+"+";

                sign = Sign.Add;
                break;
            case R.id.buttonMinus:
                if (sign == null) {
                    lastValue = currentValue;
                    currentValue=0.0;
                    previewText += "-";
                    decimalPlaceDepth = 0;
                }else if(lastValue != 0.0){
                    lastValue = Compute(lastValue,currentValue);
                    currentValue = 0.0;
                    decimalPlaceDepth = 0;
                    previewText = lastValue.toString()+"-";
                }else
                    previewText = previewText.substring(0,previewText.length()-1)+"-";

                sign = Sign.Subt;
                break;
            case R.id.buttonMult:
                if(sign == null){
                    lastValue = currentValue;
                    currentValue=0.0;
                    previewText += "x";
                    decimalPlaceDepth = 0;
                }else if(lastValue != 0.0){
                    lastValue = Compute(lastValue,currentValue);
                    currentValue = 0.0;
                    decimalPlaceDepth = 0;
                    previewText = lastValue.toString()+"x";
                }else
                    previewText = previewText.substring(0,previewText.length()-1)+"x";

                sign = Sign.Mult;
                break;
            case R.id.buttonDiv:
                if(sign == null){
                    lastValue = currentValue;
                    currentValue=0.0;
                    previewText += "/";
                    decimalPlaceDepth = 0;
                }else if(lastValue != 0.0){
                    lastValue = Compute(lastValue,currentValue);
                    currentValue = 0.0;
                    decimalPlaceDepth = 0;
                    previewText = lastValue.toString()+"/";
                }else
                    previewText = previewText.substring(0,previewText.length()-1)+"/";

                sign = Sign.Div;
                break;
            case R.id.buttonEq:
                if(sign == null)
                    return;
                btnResult.setText(String.valueOf(Compute(lastValue,currentValue)));
                btnPreview.setText(previewText+"=");
                currentValue = 0.0;
                lastValue = 0.0;
                decimalPlaceDepth = 0;
                previewText = "0";
                sign = null;
                return;
            default:
                break;
        }
        btnPreview.setText(previewText);
        if(decimalPlaceDepth == 0)
            currentText = String.valueOf(currentValue).replace(".0","");
        else if(decimalPlaceDepth == 1)
            currentText = String.valueOf(currentValue).replace(".0","")+".";
        else
            currentText = String.valueOf(currentValue);
        btnResult.setText(currentText);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitButtonsAndListeners();

        /*EditText currNumber = findViewById(R.id.Result);
        currNumber.setText("0");
        int intval = Integer.parseInt(currNumber.getText().toString());
        resultText = String.valueOf(intval);*/

    }
    private void InitButtonsAndListeners(){
        btnPreview = findViewById(R.id.Preview);
        btnResult = findViewById(R.id.Result);
        btnResult.setTextIsSelectable(true);

        Button btn0 = findViewById(R.id.button0);
        btn0.setOnClickListener(this);
        Button btn1 = findViewById(R.id.button1);
        btn1.setOnClickListener(this);
        Button btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(this);
        Button btn3 = findViewById(R.id.button3);
        btn3.setOnClickListener(this);
        Button btn4 = findViewById(R.id.button4);
        btn4.setOnClickListener(this);
        Button btn5 = findViewById(R.id.button5);
        btn5.setOnClickListener(this);
        Button btn6 = findViewById(R.id.button6);
        btn6.setOnClickListener(this);
        Button btn7 = findViewById(R.id.button7);
        btn7.setOnClickListener(this);
        Button btn8 = findViewById(R.id.button8);
        btn8.setOnClickListener(this);
        Button btn9 = findViewById(R.id.button9);
        btn9.setOnClickListener(this);

        Button btnEq = findViewById(R.id.buttonEq);
        btnEq.setOnClickListener(this);
        Button btnNegate = findViewById(R.id.buttonNegate);
        btnNegate.setOnClickListener(this);
        Button btnDec = findViewById(R.id.buttonDec);
        btnDec.setOnClickListener(this);
        Button btnPlus = findViewById(R.id.buttonPlus);
        btnPlus.setOnClickListener(this);
        Button btnMinus = findViewById(R.id.buttonMinus);
        btnMinus.setOnClickListener(this);
        Button btnDiv = findViewById(R.id.buttonDiv);
        btnDiv.setOnClickListener(this);
        Button btnMult = findViewById(R.id.buttonMult);
        btnMult.setOnClickListener(this);

        Button btnErase = findViewById(R.id.buttonErase);
        btnErase.setOnClickListener(this);
        Button btnClear = findViewById(R.id.buttonClear);
        btnClear.setOnClickListener(this);
        Button btnCE = findViewById(R.id.buttonCE);
        btnCE.setOnClickListener(this);
    }
}