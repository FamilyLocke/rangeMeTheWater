package de.dhkarlsruhe.it.sheeshapp.sheeshapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

/**
 * Created by Informatik on 17.11.2017.
 */

public class WelcomeActivity extends AppCompatActivity {

    ImageView image;
    GlideDrawableImageViewTarget imageViewTarget;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        image = findViewById(R.id.imgWelLogo);
        if (image != null) {
            imageViewTarget = new GlideDrawableImageViewTarget(image);
            Glide.with(this).load(R.drawable.smokers).into(imageViewTarget);
            sendViewToBack(image);
        }
    }

    public void openTestMode(View view) {
        this.finish();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        Toast.makeText(this,"TestMode",Toast.LENGTH_SHORT).show();
    }

    public void openSignUp(View view) {
        Intent intent = new Intent(this,SignUpActivity.class);
        startActivity(intent);
        Toast.makeText(this,"SignUp",Toast.LENGTH_SHORT).show();

    }
    public static void sendViewToBack(final View child) {
        final ViewGroup parent = (ViewGroup)child.getParent();
        if (null != parent) {
            parent.removeView(child);
            parent.addView(child, 0);
        }
    }
}