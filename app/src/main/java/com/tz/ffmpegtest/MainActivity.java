package com.tz.ffmpegtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private Button protocol;
    private Button format;
    private Button codec;
    private Button filter;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.sample_text);
        protocol = findViewById(R.id.protocol);
        format = findViewById(R.id.format);
        codec = findViewById(R.id.codec);
        filter = findViewById(R.id.filter);

        protocol.setOnClickListener(this);
        format.setOnClickListener(this);
        codec.setOnClickListener(this);
        filter.setOnClickListener(this);

        tv.setText(stringFromJNI());
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    public native String urlprotocolinfo();

    public native String avformatinfo();

    public native String avcodecinfo();

    public native String avfilterinfo();

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.protocol:
                tv.setText(urlprotocolinfo());
                break;
            case R.id.format:
                tv.setText(avformatinfo());
                break;
            case R.id.codec:
                tv.setText(avcodecinfo());
                break;
            case R.id.filter:
                tv.setText(avfilterinfo());
                break;
            default:
                break;
        }

    }
}
