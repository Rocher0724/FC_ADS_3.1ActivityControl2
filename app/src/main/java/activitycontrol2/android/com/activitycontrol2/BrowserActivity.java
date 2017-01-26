package activitycontrol2.android.com.activitycontrol2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BrowserActivity extends AppCompatActivity {

    WebView webView;
    Button mGoBtn, mBackBtn;
    EditText mUrlEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        webView = (WebView) findViewById(R.id.webView);
        mGoBtn = (Button) findViewById(R.id.goBtn);
        mBackBtn = (Button) findViewById(R.id.backBtn);
        mUrlEt = (EditText) findViewById(R.id.urlEt);

        mGoBtn.setOnClickListener(new ClickListener());
        mBackBtn.setOnClickListener(new ClickListener());

        // 속도향상을 위해서 적었으나 상관있나 체크 필요. 느리다한사람도 있었고 강사님은 빠르다고 알고있었음.
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);

        //자바스크립트 사용하도록 설정. - 필수설정
        webView.getSettings().setJavaScriptEnabled(true);

        // zoom 사용 설정 - 선택적
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);


        // 웹뷰 클라이언트를 지정  - 크롬
        webView.setWebViewClient(new WebViewClient());
//        webView.setWebChromeClient(new WebChromeClient());


    }


    class ClickListener implements View.OnClickListener {
        //        Intent intent = null;
        String value = "";

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.goBtn:
                    value = mUrlEt.getText().toString();
                    webView.loadUrl(value);
                    break;
                case R.id.backBtn:
                    if (webView.canGoBack()) {
                        webView.goBack();
                    } else {
                        Toast.makeText(BrowserActivity.this, " 뒤로 갈 수 없습니다. ", Toast.LENGTH_SHORT).show();
                        break;

                    }
            }
        }
    }
}
