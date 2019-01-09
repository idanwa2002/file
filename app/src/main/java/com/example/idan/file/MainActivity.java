package com.example.idan.file;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    String str;
    TextView textView;
    EditText editText;
    InputStream is;
    String file = "file.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView= (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
    }


    public void in(View view) {
        str = editText.getText().toString();
        try {
            FileOutputStream f = openFileOutput(file, Context.MODE_PRIVATE);
            OutputStreamWriter o = new OutputStreamWriter(f);
            BufferedWriter bw = new BufferedWriter(o);
            bw.write(str);
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void out(View view) {
        try {
            is = openFileInput(file);
            InputStreamReader t = new InputStreamReader(is);
            BufferedReader r = new BufferedReader(t);
            StringBuffer b = new StringBuffer();
            while ((str = r.readLine()) != null)
                b.append(str + "\n");
            is.close();
            textView.setText(b);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}