package onepieceanimation.myandroidhello.com.onepieceanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView onepiece;
    private TextView result;
    private Runnable mRunnable;
    private AnimationDrawable animation;
    private String[] characters;
    private ImageView imageResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        characters = new String[]{"luffy","zoro","sanji","nami","shanks","mihawk","law","franky"};

        result = (TextView) findViewById(R.id.textViewResultId);

        onepiece = (ImageView) findViewById(R.id.imageViewOnePieceId);
        imageResult = (ImageView) findViewById(R.id.imageView);
        onepiece.setBackgroundResource(R.drawable.animation_bg);
        animation = (AnimationDrawable) onepiece.getBackground();

        onepiece.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                // Reset all views:
                result.setText(" ");
                imageResult.setBackgroundResource(R.drawable.crew);

                animation.start();
                getResult();
                return true;
            }
        });

    }

    public void getResult(){

        mRunnable = new Runnable() {
            @Override
            public void run() {
                final int i = (int) (Math.random() * characters.length);
                result.setText(characters[i].toUpperCase());
                animation.stop();
                animation.setVisible(true,true);
                updateImage(characters[i]);
            }
        };

        Handler mHandler = new Handler();
        mHandler.postDelayed(mRunnable, 5000);
    }

    public void updateImage(String name){

        if(name.equals("luffy")){
            imageResult.setBackgroundResource(R.drawable.luffy);
        }else if(name.equals("zoro")){
            imageResult.setBackgroundResource(R.drawable.zoro);
        }else if(name.equals("nami")){
            imageResult.setBackgroundResource(R.drawable.nami);
        }else if(name.equals("mihawk")){
            imageResult.setBackgroundResource(R.drawable.mihawk);
        }else if(name.equals("sanji")){
            imageResult.setBackgroundResource(R.drawable.sanji);
        }else if(name.equals("franky")){
            imageResult.setBackgroundResource(R.drawable.franky);
        }else if(name.equals("law")){
            imageResult.setBackgroundResource(R.drawable.law);
        }else if(name.equals("shanks")){
            imageResult.setBackgroundResource(R.drawable.shanks);
        }
    }
}
