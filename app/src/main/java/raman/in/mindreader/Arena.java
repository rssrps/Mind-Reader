package raman.in.mindreader;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Handler;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Arena extends AppCompatActivity {

    private TextView step,text,page;
    private Button yes;
    private ImageView right,left;
    private Animation in,out,lefttoright,righttoleft;
    private int screen = 1,count18=0,stepcount=1,ans=0;
    private ImageView []card;
    private int [] array,screen1,screen2,screen3;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arena);


        mAdView = (AdView) findViewById(R.id.adViewArena);

        AdRequest adRequest = new AdRequest.Builder()
                .build();

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
            }

            @Override
            public void onAdClosed() {
                //Toast.makeText(getApplicationContext(), "Ad is closed!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
               // Toast.makeText(getApplicationContext(), "Ad failed to load! error code: " + errorCode, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdLeftApplication() {
               // Toast.makeText(getApplicationContext(), "Ad left application!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }
        });

        mAdView.loadAd(adRequest);





        step = (TextView) findViewById(R.id.step);
        text = (TextView) findViewById(R.id.text);
        page = (TextView) findViewById(R.id.page);
        yes =  (Button) findViewById(R.id.yes);

        right = (ImageView) findViewById(R.id.right);
        left = (ImageView) findViewById(R.id.left);

        card = new ImageView[19];
        array = new int[53];

        screen1 = new int[19];
        screen2 = new int[18];
        screen3 = new int[18];

        for (int j=0;j<=18;j++)
         screen1[j]=j;

        for (int j=0;j<=17;j++)
            screen2[j]=j+18;

        for (int j=0;j<=17;j++)
            screen3[j]=j+35;


        card[1] =  (ImageView) findViewById(R.id.c1);
        card[2] =  (ImageView) findViewById(R.id.c2);
        card[3] =  (ImageView) findViewById(R.id.c3);
        card[4] =  (ImageView) findViewById(R.id.c4);
        card[5] =  (ImageView) findViewById(R.id.c5);
        card[6] =  (ImageView) findViewById(R.id.c6);
        card[7] =  (ImageView) findViewById(R.id.c7);
        card[8] =  (ImageView) findViewById(R.id.c8);
        card[9] =  (ImageView) findViewById(R.id.c9);
        card[10] = (ImageView) findViewById(R.id.c10);
        card[11] = (ImageView) findViewById(R.id.c11);
        card[12] = (ImageView) findViewById(R.id.c12);
        card[13] = (ImageView) findViewById(R.id.c13);
        card[14] = (ImageView) findViewById(R.id.c14);
        card[15] = (ImageView) findViewById(R.id.c15);
        card[16] = (ImageView) findViewById(R.id.c16);
        card[17] = (ImageView) findViewById(R.id.c17);
        card[18] = (ImageView) findViewById(R.id.c18);

        Typeface ultra = Typeface.createFromAsset(getAssets(),"fonts/ultra.ttf");
        Typeface abel = Typeface.createFromAsset(getAssets(),"fonts/abel.ttf");

        step.setTypeface(ultra);
        text.setTypeface(abel);
        yes.setTypeface(abel);

        in = new AlphaAnimation((float) 0.1, (float) 1);
        out = new AlphaAnimation((float) 1, (float)0.0);
        in.setDuration(500);
        out.setDuration(1000);

        lefttoright = new TranslateAnimation(-400,0,0,0);
        righttoleft = new TranslateAnimation(400,0,0,0);
        lefttoright.setDuration(150);
        righttoleft.setDuration(150);
        updateUI();

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(int i=1;i<=18;i++){
                    card[i].startAnimation(lefttoright);
                }

                if(screen!=2)
                 left.startAnimation(in);

                if(screen>1)
                    screen--;
                updateUI();
            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(int i=1;i<=18;i++){
                    card[i].startAnimation(righttoleft);
                }

                if(screen!=2)
                 right.startAnimation(in);

                if(screen<3)
                    screen++;
                updateUI();
            }
        });

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                yes.startAnimation(in);
                stepcount++;

                if(stepcount<=4) {
                    step.setText("Step " + stepcount + "/4");
                    step.startAnimation(in);

                    for (int j = 1; j <= 18; j++)
                        card[j].startAnimation(out);

                    if (screen == 1) {
                        for (int j = 1; j <= 17; j++)
                            array[j] = screen2[j];
                        for (int j = 1; j <= 18; j++)
                            array[j + 17] = screen1[j];
                        for (int j = 1; j <= 17; j++)
                            array[j + 35] = screen3[j];
                    } else if (screen == 2) {

                            for (int j = 1; j <= 17; j++)
                                array[j] = screen3[j];
                            for (int j = 1; j <= 17; j++)
                                array[j + 17] = screen2[j];
                            for (int j = 1; j <= 18; j++)
                                array[j + 34] = screen1[j];

                    } else if (screen == 3) {

                            for (int j = 1; j <= 17; j++)
                                array[j] = screen2[j];
                            for (int j = 1; j <= 17; j++)
                                array[j + 17] = screen3[j];
                            for (int j = 1; j <= 18; j++)
                                array[j + 34] = screen1[j];

                    }

                    for (int j = 1; j <= 18; j++)
                        screen1[j] = array[1 + (3 * (j - 1))];
                    for (int j = 1; j <= 17; j++)
                        screen2[j] = array[2 + (3 * (j - 1))];
                    for (int j = 1; j <= 17; j++)
                        screen3[j] = array[3 + (3 * (j - 1))];

                    screen = 1;

                    for (int j = 1; j <= 18; j++)
                        card[j].startAnimation(in);

                    updateUI();

                }

                else {
                    if(screen==1)
                        ans = screen1[9];
                    else if(screen==2)
                        ans = screen2[9];
                    else if(screen==3)
                        ans=screen3[9];

                    Intent i = new Intent(Arena.this,Reveal.class);
                    Bundle bundle = ActivityOptionsCompat.makeCustomAnimation(getApplicationContext(),
                            android.R.anim.fade_in, android.R.anim.fade_out).toBundle();
                    i.putExtra("card",String.valueOf(ans));
                    startActivity(i,bundle);
                    finish();
                }

            }
        });

    }

    private void updateUI(){

        if(screen==1){
            page.setText("Page 1");
            left.setVisibility(View.INVISIBLE);
            right.setVisibility(View.VISIBLE);

            for(int j=1;j<=18;j++)
                card[j].setImageResource(getId(screen1[j]));

        }
        else if(screen==2){
            page.setText("Page 2");
            left.setVisibility(View.VISIBLE);
            right.setVisibility(View.VISIBLE);

            for(int j=1;j<=17;j++)
                card[j].setImageResource(getId(screen2[j]));
            card[18].setImageResource(R.drawable.transparent);
        }
        else if(screen==3){
            page.setText("Page 3");
                left.setVisibility(View.VISIBLE);
                right.setVisibility(View.INVISIBLE);

            for(int j=1;j<=17;j++)
                card[j].setImageResource(getId(screen3[j]));
            card[18].setImageResource(R.drawable.transparent);
        }

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




    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }
}
