package com.example.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int DEFAULT_TEXT_SIZE = 16;

    private EditText mEditText;
    private TextView mTextView;
    private SeekBar mSeekBar;
    private TextView mScaleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText) findViewById(R.id.text_edit);
        mTextView = (TextView) findViewById(R.id.text_text);
        mScaleTextView = (TextView) findViewById(R.id.scale_text);
        mSeekBar = (SeekBar) findViewById(R.id.seekBar);

        // 문자 변경시 호출 되는 콜백
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mTextView.setText(s);
            }
        });

        // SeekBar 변경 콜백
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // 배율
                mScaleTextView.setText("배율 : " + (progress + 1) + "배");

                // 글자 확대
                mTextView.setTextSize(DEFAULT_TEXT_SIZE * progress + DEFAULT_TEXT_SIZE);
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
