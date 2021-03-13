package com.example.multinumbers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.multinumbers.databinding.ActivityMainBinding;
import com.example.multinumbers.databinding.ActivityStartGameBinding;
public class MainActivity extends AppCompatActivity {
    static int resource = R.raw.spring;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(!Media.getIns().isAccept())
        {
            Media.getIns().setMedia(resource, getApplicationContext());
        }
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        if(Translate.getTrr().isTr())
        {
             binding.Game.setText("لعبة ضرب الأعداد");
             binding.start.setText("أبدأ اللعبة");
             binding.setting.setText("خيارات اللعبة");
        }
        else
        {
            binding.Game.setText("MultiNumber Game");
            binding.start.setText("start Game");
            binding.setting.setText("Option");
        }
        binding.start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent In = new Intent(getApplicationContext(),startGame.class);
                startActivity(In);
            }
        });

        binding.setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent In = new Intent(getApplicationContext(),setting_Game.class);
                startActivity(In);
                finish();
            }
        });
     }

    @Override
    public void onBackPressed() {
        Media.getIns().off();
        super.onBackPressed();
    }
}