package raman.in.mindreader;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Interpolator;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class Reveal extends AppCompatActivity {

    private TextView your,likedit;
    private ImageView carddisplay;
    private Button rate;
    private int ans=1;
    private Animation in,out;
    private String TAG = Reveal.class.getSimpleName();
    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reveal);



        mInterstitialAd = new InterstitialAd(this);
        // set the ad unit ID
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_full_screen));
        AdRequest adRequest = new AdRequest.Builder()
                .build();

        mInterstitialAd.loadAd(adRequest);
        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                showInterstitial();
            }
        });



        your = (TextView) findViewById(R.id.yourcard);
        likedit = (TextView) findViewById(R.id.likedit);
        carddisplay = (ImageView) findViewById(R.id.carddisplay);
        rate = (Button) findViewById(R.id.yes);


        Typeface ultra = Typeface.createFromAsset(getAssets(),"fonts/ultra.ttf");
        Typeface abel = Typeface.createFromAsset(getAssets(),"fonts/abel.ttf");

        your.setTypeface(ultra);
        likedit.setTypeface(abel);

        final Animation animShake = AnimationUtils.loadAnimation(this, R.anim.shakeanim);
        carddisplay.startAnimation(animShake);

        in = new AlphaAnimation((float)0.05,(float)1);
        in.setDuration(400);

        Bundle b = getIntent().getExtras();
        String x = b.getString("card");
        ans = Integer.parseInt(x);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                carddisplay.setImageResource(getId(ans));
                carddisplay.startAnimation(in);
            }
        }, 3800);




        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rate.startAnimation(in);
                Uri uri = Uri.parse("market://details?id=" + "raman.in.mindreader");
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                // To count with Play market backstack, After pressing back button,
                // to taken back to our application, we need to add following flags to intent.
                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + "raman.in.mindreader")));
                }

            }
        });

    }

    private int getId(int j){

        if(j==1)
            return R.drawable.c1;
        else if(j==2)
            return R.drawable.c2;
        else if(j==3)
            return R.drawable.c3;
        else if(j==4)
            return R.drawable.c4;
        else if(j==5)
            return R.drawable.c5;
        else if(j==6)
            return R.drawable.c6;
        else if(j==7)
            return R.drawable.c7;
        else if(j==8)
            return R.drawable.c8;
        else if(j==9)
            return R.drawable.c9;
        else if(j==10)
            return R.drawable.c10;
        else if(j==11)
            return R.drawable.c11;
        else if(j==12)
            return R.drawable.c12;
        else if(j==13)
            return R.drawable.c13;
        else if(j==14)
            return R.drawable.c14;
        else if(j==15)
            return R.drawable.c15;
        else if(j==16)
            return R.drawable.c16;
        else if(j==17)
            return R.drawable.c17;
        else if(j==18)
            return R.drawable.c18;
        else if(j==19)
            return R.drawable.c19;
        else if(j==20)
            return R.drawable.c20;
        else if(j==21)
            return R.drawable.c21;
        else if(j==22)
            return R.drawable.c22;
        else if(j==23)
            return R.drawable.c23;
        else if(j==24)
            return R.drawable.c24;
        else if(j==25)
            return R.drawable.c25;
        else if(j==26)
            return R.drawable.c26;
        else if(j==27)
            return R.drawable.c27;
        else if(j==28)
            return R.drawable.c28;
        else if(j==29)
            return R.drawable.c29;
        else if(j==30)
            return R.drawable.c30;
        else if(j==31)
            return R.drawable.c31;
        else if(j==32)
            return R.drawable.c32;
        else if(j==33)
            return R.drawable.c33;
        else if(j==34)
            return R.drawable.c34;
        else if(j==35)
            return R.drawable.c35;
        else if(j==36)
            return R.drawable.c36;
        else if(j==37)
            return R.drawable.c37;
        else if(j==38)
            return R.drawable.c38;
        else if(j==39)
            return R.drawable.c39;
        else if(j==40)
            return R.drawable.c40;
        else if(j==41)
            return R.drawable.c41;
        else if(j==42)
            return R.drawable.c42;
        else if(j==43)
            return R.drawable.c43;
        else if(j==44)
            return R.drawable.c44;
        else if(j==45)
            return R.drawable.c45;
        else if(j==46)
            return R.drawable.c46;
        else if(j==47)
            return R.drawable.c47;
        else if(j==48)
            return R.drawable.c48;
        else if(j==49)
            return R.drawable.c49;
        else if(j==50)
            return R.drawable.c50;
        else if(j==51)
            return R.drawable.c51;
        else if(j==52)
            return R.drawable.c52;

        else return R.drawable.c1;
    }

    @Override public void onBackPressed() { super.onBackPressed();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }


    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

}
