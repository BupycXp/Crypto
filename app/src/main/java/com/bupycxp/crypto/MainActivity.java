package com.bupycxp.crypto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {

    Button button;
    Button button2;
    EditText edittext_data, edittext_step, edittext_result;
    Toast toast;
    String temp, result;
    char[] latc = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    char[] rusch = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
            'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};
    String lat = "abcdefghijklmnopqrstuvwxyz";
    String rus = "абвгдежзийклмнопрстуфхцчшщъыьэюя";

    Integer posChar, step;
    Integer i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = "";
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        edittext_data = (EditText) findViewById(R.id.editText_data);
        edittext_step = (EditText) findViewById(R.id.editText_step);
        edittext_result = (EditText) findViewById(R.id.editText_result);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button:
                        temp = edittext_data.getText().toString();
                        temp = temp.toLowerCase();
                        for (i = 0; i <= temp.length() - 1; i++) {
                            if (((temp.charAt(i)) >= 65 && (temp.charAt(i)) <= 90) || ((temp.charAt(i)) >= 97 && (temp.charAt(i)) <= 122)) {
                                step = 26 - parseInt(edittext_step.getText().toString());
                                if (lat.indexOf(temp.charAt(i)) - step < 0) {
                                    posChar = 26 + lat.indexOf(temp.charAt(i)) - step;
                                } else {
                                    posChar = lat.indexOf(temp.charAt(i)) - step;
                                }
                                result = result + String.copyValueOf(latc, posChar, 1);

                            } else if (((temp.charAt(i)) >= 1040 && (temp.charAt(i)) <= 1071) || ((temp.charAt(i)) >= 1072 && (temp.charAt(i)) <= 1103)) {
                                step = 32 - parseInt(edittext_step.getText().toString());
                                if (rus.indexOf(temp.charAt(i)) - step < 0) {
                                    posChar = 32 + rus.indexOf(temp.charAt(i)) - step;
                                } else {
                                    posChar = rus.indexOf(temp.charAt(i)) - step;
                                }
                                result = result + String.copyValueOf(rusch, posChar, 1);
                            } else {
                                result = result + temp.charAt(i);
                            }
                        }
                        edittext_result.setText(result);
                        result = "";
                        toast = Toast.makeText(MainActivity.this, temp, toast.LENGTH_SHORT);
                        toast.show();
                        break;

                    case R.id.button2:
                        toast = Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT);
                        toast.show();
                        temp = edittext_data.getText().toString();
                        temp = temp.toLowerCase();
                        step = parseInt(edittext_step.getText().toString());
                        for (i = 0; i <= temp.length() - 1; i++) {
                            if (((temp.charAt(i)) >= 65 && (temp.charAt(i)) <= 90) || ((temp.charAt(i)) >= 97 && (temp.charAt(i)) <= 122)) {
                                if (lat.indexOf(temp.charAt(i)) - step < 0) {
                                    posChar = 26 + lat.indexOf(temp.charAt(i)) - step;
                                } else {
                                    posChar = lat.indexOf(temp.charAt(i)) - step;
                                }
                                result = result + String.copyValueOf(latc, posChar, 1);

                            } else if (((temp.charAt(i)) >= 1040 && (temp.charAt(i)) <= 1071) || ((temp.charAt(i)) >= 1072 && (temp.charAt(i)) <= 1103)) {
                                if (rus.indexOf(temp.charAt(i)) - step < 0) {
                                    posChar = 32 + rus.indexOf(temp.charAt(i)) - step;
                                } else {
                                    posChar = rus.indexOf(temp.charAt(i)) - step;
                                }
                                result = result + String.copyValueOf(rusch, posChar, 1);
                            } else {
                                result = result + temp.charAt(i);
                            }
                        }
                        edittext_result.setText(result);
                        result = "";

                        break;
                }
            }
        };

        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
    }


}

