package com.bawei.gsc.gsczxing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;

public class Main2Activity extends AppCompatActivity implements QRCodeView.Delegate {
    private ZXingView mZXingView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mZXingView = findViewById(R.id.zxingview);
        mZXingView.setDelegate(this);
    }
    @Override
    protected void onResume() {
        super.onResume();
        mZXingView.startCamera();
        mZXingView.startSpotAndShowRect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mZXingView.stopCamera();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mZXingView.onDestroy();
        Toast.makeText(Main2Activity.this,11+"",Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onScanQRCodeSuccess(String result) {
        if(result!=null){
            Intent intent=new Intent(Main2Activity.this,ContentActivity.class);
            intent.putExtra("result",result);
            startActivity(intent);
        }
        Toast.makeText(Main2Activity.this,result,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCameraAmbientBrightnessChanged(boolean isDark) {

    }

    @Override
    public void onScanQRCodeOpenCameraError() {

    }
}
