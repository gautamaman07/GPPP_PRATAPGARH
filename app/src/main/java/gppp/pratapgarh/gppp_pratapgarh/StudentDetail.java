package gppp.pratapgarh.gppp_pratapgarh;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class StudentDetail extends AppCompatActivity {
WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Loading..");


        webview=(WebView)findViewById(R.id.webView);
        webview.setWebViewClient(new WebViewClient()
        {
            //ctrl+o


            @Override
            public void onPageFinished(WebView view, String url) {
                progressDialog.dismiss();
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                progressDialog.show();
            }
        });
        webview.loadUrl("http://bteup.ac.in/webapp/Studentlogin.aspx");

        //please enable Internet

        //tp enable java script setting
        WebSettings webSettings=webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if (webview.canGoBack()) {
            webview.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
