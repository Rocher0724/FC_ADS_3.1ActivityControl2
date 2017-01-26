package activitycontrol2.android.com.activitycontrol2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mWebViewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebViewBtn = (Button) findViewById(R.id.webViewBtn);

        mWebViewBtn.setOnClickListener(new ClickListener());

    }




    class ClickListener implements View.OnClickListener {
        Intent intent = null;
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.webViewBtn:
                    intent = new Intent(MainActivity.this, BrowserActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }
}
