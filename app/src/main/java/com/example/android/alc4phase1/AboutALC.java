package com.example.android.alc4phase1;

import android.net.http.SslError;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutALC extends AppCompatActivity {

    // Declare the url variable string
    private String webUrl;
    // Declare the WebView Object
    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);

        // Set the url variable string
        webUrl = "https://andela.com/alc/";
        myWebView = findViewById(R.id.webview);

        /*
         * Set WebViewClient to ensure that the links clicked by users
         * loads in the Webview.
         */
        WebViewClient myWebViewClient = new WebViewClient() {
            // handle onReceivedSslError method
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }
        };
        myWebView.setWebViewClient(myWebViewClient);

        /*
         * Manage the web page settings
         */
        WebSettings webSettings = myWebView.getSettings();
        // Enable JavaScript (use only when necessary to avoid XSS vulnerability)
        webSettings.setJavaScriptEnabled(true);

        // Load the web page in the WebView
        myWebView.loadUrl(webUrl);

    }
}
