package com.w311ang.nearbyshare_forwarder;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Toast;
import android.content.ActivityNotFoundException;

public class ShareActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
		//Toast.makeText(getApplication(), "hi.", Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_share);

        // 获取原始的分享Intent
        Intent originalIntent = new Intent(getIntent());

        // 修改Intent的action和package，以便启动Nearby Share
        originalIntent.setAction("com.google.android.gms.SHARE_NEARBY");
        originalIntent.setPackage("com.google.android.gms");
		originalIntent.setComponent(null);

        // 尝试启动Nearby Share
        try {
            startActivity(originalIntent);
			finish();
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "无法找到Nearby Share来分享内容", Toast.LENGTH_SHORT).show();
        }
    }
}

