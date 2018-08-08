package com.example.asus.franchiseez;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

public class RegisterUserActivity extends AppCompatActivity {

    ImageView laki,wanita;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        laki = (ImageView) findViewById(R.id.laki);
        wanita = (ImageView) findViewById(R.id.wanita);

        laki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wanita.setBackgroundResource(R.drawable.shape_jeniskelamin);
                laki.setBackgroundResource(R.drawable.shape_jeniskelamin_klik);
                wanita.setPadding(0,getPixelValue(getApplicationContext(),10),0,getPixelValue(getApplicationContext(),10));
                laki.setPadding(0,getPixelValue(getApplicationContext(),10),0,getPixelValue(getApplicationContext(),10));
            }
        });

        wanita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                laki.setBackgroundResource(R.drawable.shape_jeniskelamin);
                wanita.setBackgroundResource(R.drawable.shape_jeniskelamin_klik);
                wanita.setPadding(0,getPixelValue(getApplicationContext(),10),0,getPixelValue(getApplicationContext(),10));
                laki.setPadding(0,getPixelValue(getApplicationContext(),10),0,getPixelValue(getApplicationContext(),10));
            }
        });


    }

    public static int getPixelValue(Context context, int dimenId) {
        Resources resources = context.getResources();
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dimenId,
                resources.getDisplayMetrics()
        );
    }

}
