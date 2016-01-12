package com.bupycxp.crypto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static java.lang.Integer.getInteger;
import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText edittext_data, edittext_step, edittext_result;
    Toast toast;
    String temp, result;
    char[] latc = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж'
            , 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш'
            , 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '!', '@', '#', ';', ':', '%', '*', '('
            , ')', '?', '-', '_', '/', '=', '+', '"', '<', '>', 'а'};
    String lat = "abcdefghijklmnopqrstuvwxyzабвгдеёжзийклмнопрстуфхцчшщъыьэюя.,!@#;:%*()?-_ ";
    Integer posChar, step;
    Integer i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = "";
        button = (Button) findViewById(R.id.button);
        edittext_data = (EditText) findViewById(R.id.editText_data);
        edittext_step = (EditText) findViewById(R.id.editText_step);
        edittext_result = (EditText) findViewById(R.id.editText_result);


        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button:
                        step = parseInt(edittext_step.getText().toString());
                        temp = edittext_data.getText().toString();
                        temp = temp.toLowerCase();
                        for (i = 0; i <= temp.length() - 1; i++) {

                            if (lat.indexOf(temp.charAt(i)) - step < 0) {
                                posChar = 27 + lat.indexOf(temp.charAt(i)) - step;
                            } else {
                                if (lat.indexOf(temp.charAt(i)) == 26) {
                                    posChar = 26;
                                } else {
                                    posChar = lat.indexOf(temp.charAt(i)) - step;
                                }
                            }
                            result = result + String.copyValueOf(latc, posChar, 1);
                        }
                        edittext_result.setText(result);
                        result = "";
                        toast = Toast.makeText(MainActivity.this, temp, toast.LENGTH_SHORT);
                        toast.show();
                        break;
                }
            }
        };
        button.setOnClickListener(onClickListener);
    }


}

