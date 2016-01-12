package com.example.tacademy.samplebasicwidget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    TextView textView2;
    CheckBox alarmCheckeddView;
    RadioGroup groupView;
    boolean isForced = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.btn_change);
        textView = (TextView) findViewById(R.id.textView2);
        textView2 = (TextView) findViewById(R.id.textView);
        textView.setSelected(true);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = getResources().getString(R.string.text_html);
                textView.setText(R.string.text_test);
                textView2.setText(Html.fromHtml(message));
            }
        });

        alarmCheckeddView = (CheckBox) findViewById(R.id.check_alarm);

        alarmCheckeddView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isForced) {
                    Toast.makeText(MainActivity.this, "checked changed :" + isChecked, Toast.LENGTH_SHORT).show();
                }
            }
        });

        groupView = (RadioGroup)findViewById(R.id.group_sex);

        groupView.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

            }
        });

    }
    public void onButtonTwoClick(View view){
        boolean isChecked = alarmCheckeddView.isChecked();
        Toast.makeText(this, "alarm check: "+ isChecked,Toast.LENGTH_SHORT).show();
        isForced = true;
        alarmCheckeddView.setChecked(!isChecked);
        isForced = false;
    }

    private void showSelectedRadio(int id){
        switch(id){
            case R.id.radio_m:
                Toast.makeText(this, "male" ,Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_f:
                Toast.makeText(this, "female" ,Toast.LENGTH_SHORT).show();
                break;
        }

    }


}
