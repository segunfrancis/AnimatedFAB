package com.android.computer.animatedfab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import com.android.computer.animatedfab.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding bi;
    boolean isRotate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_main);

        bi.fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRotate = ViewAnimation.rotateFab(v, !isRotate);
                if (isRotate) {
                    ViewAnimation.showIn(bi.fabCamera);
                    ViewAnimation.showIn(bi.fabMic);
                    ViewAnimation.showIn(bi.fabPhone);
                } else {
                    ViewAnimation.showOut(bi.fabCamera);
                    ViewAnimation.showOut(bi.fabMic);
                    ViewAnimation.showOut(bi.fabPhone);
                }
            }
        });

        ViewAnimation.init(bi.fabCamera);
        ViewAnimation.init(bi.fabMic);
        ViewAnimation.init(bi.fabPhone);

        bi.fabCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, 12);
            }
        });

        bi.fabMic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent micIntent = new Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION);
                startActivity(micIntent);
            }
        });

        bi.fabPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                startActivity(phoneIntent);
            }
        });
    }
}
