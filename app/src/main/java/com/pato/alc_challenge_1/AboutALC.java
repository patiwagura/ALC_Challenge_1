package com.pato.alc_challenge_1;

import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutALC extends AppCompatActivity {

    private WebView webView = null;
    private static final String WEB_URL = "https://andela.com/alc/";
    private WebSettings settings = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);

        webView =(WebView)findViewById(R.id.webView_aboutAlc);
        //webView.getSettings().setJavaScriptEnabled(true); //enable javascript

        settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);

        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.setWebViewClient(new MyWebViewClient());
        webView.loadUrl(WEB_URL);

        Log.i("ABOUT_ALC", "About ALC oncreate method");

    }

    private class MyWebViewClient extends WebViewClient{

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            //super.onReceivedSslError(view, handler, error);
            Log.d("Ssl Error:",handler.toString() + "error:" +  error); //log the error.
            handler.proceed(); //ignore ssl errors and continue to load webpage.
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(WEB_URL);
            return true;
        }

    }
}
