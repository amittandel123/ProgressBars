package com.tandel.amit.progressbars;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView,tv2;
    private Button btn;
    private int progressStatus = 0;
    private Handler handler = new Handler();
    private ProgressBar pb1, pb2, pb3, pb_circ1,pb_circ2,pb_circ3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        pb1 = (ProgressBar) findViewById(R.id.progressBar_1);
        pb2 = (ProgressBar) findViewById(R.id.progressBar_2);
        pb3 = (ProgressBar) findViewById(R.id.progressBar_6);
        pb_circ1 = (ProgressBar)findViewById(R.id.progressBar_3);
        pb_circ2 = (ProgressBar)findViewById(R.id.progressBar_4);
        pb_circ3 = (ProgressBar)findViewById(R.id.progressBar_5);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressStatus = 0;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (progressStatus < 100) {
                            progressStatus += 1;
                            try {
                                Thread.sleep(20);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    pb1.setProgress(progressStatus);
                                    pb2.setProgress(progressStatus);
                                    pb3.setProgress(progressStatus);
                                    pb_circ1.setProgress(progressStatus);
                                    pb_circ2.setProgress(progressStatus);
                                    pb_circ3.setProgress(progressStatus);
                                    textView.setText(progressStatus + "");
                                    tv2.setText(progressStatus + "%");
                                }
                            });
                        }
                    }
                }).start();
            }
        });
    }
}
