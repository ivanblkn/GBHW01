package com.example.gbhw01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_SetText = findViewById(R.id.btn_SetText);
        final TextView mainTextField = findViewById(R.id.MainTextField);
        final EditText setTextField = findViewById(R.id.setTextField);
        final CheckBox chB_Bold = findViewById(R.id.chB_Bold);
        final CheckBox chB_Italic = findViewById(R.id.chB_Italic);
        final TextView textSwitch = findViewById(R.id.textSwitch);
        final Switch swDemo = findViewById(R.id.SwDemo);

        final RadioGroup RB_gr = findViewById(R.id.orientGroup);

        final RadioButton rb_l = findViewById(R.id.l_orient);
        final RadioButton rb_c = findViewById(R.id.c_orient);
        final RadioButton rb_r = findViewById(R.id.r_orient);

        final ToggleButton tb = findViewById(R.id.EnblSetText);

        final SeekBar sb = findViewById(R.id.seekBar);

        if (swDemo.isChecked()) {
            textSwitch.setText(R.string.swIsOn);
        } else {
            textSwitch.setText(R.string.swIsOff);
        }

        rb_l.setChecked(true);

        button_SetText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainTextField.setText(setTextField.getText().toString());
            }
        });

        chB_Bold.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                mainTextField.setTypeface(null,
                        (chB_Italic.isChecked() ? Typeface.ITALIC : Typeface.NORMAL) +
                                (chB_Bold.isChecked() ? Typeface.BOLD : Typeface.NORMAL));

            }
        });
        chB_Italic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainTextField.setTypeface(null,
                        (chB_Italic.isChecked() ? Typeface.ITALIC : Typeface.NORMAL) +
                                (chB_Bold.isChecked() ? Typeface.BOLD : Typeface.NORMAL));
            }
        });

        swDemo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (swDemo.isChecked()) {
                    textSwitch.setText(R.string.swIsOn);
                } else {
                    textSwitch.setText(R.string.swIsOff);
                }
            }
        });

        RB_gr.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.l_orient:
                        mainTextField.setGravity(Gravity.START);
                        break;
                    case R.id.c_orient:
                        mainTextField.setGravity(Gravity.CENTER);
                        break;
                    case R.id.r_orient:
                        mainTextField.setGravity(Gravity.END);
                }
            }
        });
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                setTextField.setEnabled(b);
                button_SetText.setEnabled(b);
            }
        });
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mainTextField.setTextSize(14 + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}