package com.Final_Project_MAP.phongbt193051;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class QRScanActivity extends AppCompatActivity {

    ImageButton attendanceButton;
    TextView classesSample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        attendanceButton = findViewById(R.id.attendanceButton);
        classesSample = findViewById(R.id.classes_sample);

        attendanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator intentIntegrator = new IntentIntegrator(QRScanActivity.this);
                intentIntegrator.setOrientationLocked(false);
                intentIntegrator.setPrompt("Scan a QR Code");
                intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE);
                intentIntegrator.initiateScan();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (intentResult != null) {
            String contents = intentResult.getContents();
            if (contents != null) {
                classesSample.setText(contents);

                // Kiểm tra xem nội dung có phải là một đường link hay không
                if (isUrl(contents)) {
                    // Nếu là đường link, mở trình duyệt với đường link đó
                    openUrl(contents);
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    // Phương thức kiểm tra xem một chuỗi có phải là đường link hay không
    private boolean isUrl(String text) {
        return text.startsWith("http://") || text.startsWith("https://");
    }

    // Phương thức mở trình duyệt với một đường link
    private void openUrl(String url) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }
}