package com.nitol.aust.cse.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btn;
    WebView browser;
    EditText url_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openURL();
    }

    public void openURL(){
        btn = (Button) findViewById(R.id.button);
        url_text =(EditText) findViewById(R.id.editText);
        browser = (WebView) findViewById(R.id.webView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.youtube.com/watch?v=VgC4b9K-gYU";

                browser.getSettings().setLoadsImagesAutomatically(true);
                browser.getSettings().setJavaScriptEnabled(true);
                browser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                browser.loadUrl(url);
                browser.getSettings().getDisplayZoomControls();
            }
        });
    }
}
