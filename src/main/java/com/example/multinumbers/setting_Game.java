package com.example.multinumbers;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.example.multinumbers.databinding.ActivitySettingGameBinding;

public class setting_Game extends AppCompatActivity {
     ActivitySettingGameBinding binding;
     static boolean isClick = true,Arabic=true;
     static int r=R.drawable.soundplus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting__game);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_setting__game);
        binding.sound.setImageResource(r);
        binding.easy.setChecked(Levels.getInstance().isEasy());
        binding.normal.setChecked(Levels.getInstance().isMed());
        binding.hard.setChecked(Levels.getInstance().isHard());
        binding.easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Levels.getInstance().setEasy(true);
                Levels.getInstance().setMed(false) ;
                Levels.getInstance().setHard(false);
                setLevels(Levels.getInstance().isEasy(),Levels.getInstance().isMed(),Levels.getInstance().isHard());
            }
        });
        binding.normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Levels.getInstance().setEasy(false);
                Levels.getInstance().setMed(true) ;
                Levels.getInstance().setHard(false);
                setLevels(Levels.getInstance().isEasy(),Levels.getInstance().isMed(),Levels.getInstance().isHard());
            }
        });
        binding.hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Levels.getInstance().setEasy(false);
                Levels.getInstance().setMed(false) ;
                Levels.getInstance().setHard(true);
                setLevels(Levels.getInstance().isEasy(),Levels.getInstance().isMed(),Levels.getInstance().isHard());          }
        });
        String english = " English" , arabic = "عربي", highlevelEn = "Hard Level",highlevelAr = "مستوى الصعوبة",
                HardEn="Hard",HardAr="صعب" , MediumEn="Medium" , MediumAr = "وسط" , EasyEn="Easy",
                EasyAr= " سهل" ;
        if(Arabic)
        {
            binding.language.setText(arabic);
            binding.hardLevel.setText(highlevelAr);
            binding.hard.setText(HardAr);
            binding.normal.setText(MediumAr);
            binding.easy.setText(EasyAr);
        }
        else
        {
            binding.language.setText(english);
            binding.hardLevel.setText(highlevelEn);
            binding.hard.setText(HardEn);
            binding.normal.setText(MediumEn);
            binding.easy.setText(EasyEn);
        }
        binding.sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 if(isClick)
                 {
                     r=R.drawable.soundminus;
                    binding.sound.setImageResource(r);
                    Media.getIns().off();
                    isClick = false;
                 }
                 else
                 {
                     r = R.drawable.soundplus;
                     binding.sound.setImageResource(r);
                     Media.getIns().on();
                     isClick = true;
                 }
            }
        });
        binding.lang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Arabic)
                {
                    Translate.getTrr().offTr();
                    Arabic=false;
                }
                else
                {
                    System.out.println("please");
                    Translate.getTrr().setTr();
                    Arabic=true;
                }
                Translate.getTrr().print_Tr();
                if(Translate.getTrr().isTr())
                {
                    binding.language.setText(arabic);
                    binding.hardLevel.setText(highlevelAr);
                    binding.hard.setText(HardAr);
                    binding.normal.setText(MediumAr);
                    binding.easy.setText(EasyAr);
                }
                else
                {
                    binding.language.setText(english);
                    binding.hardLevel.setText(highlevelEn);
                    binding.hard.setText(HardEn);
                    binding.normal.setText(MediumEn);
                    binding.easy.setText(EasyEn);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent In = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(In);
        finish();
        super.onBackPressed();
    }
    public void setLevels(boolean easy,boolean meduim , boolean hard)
    {
        binding.easy.setChecked(easy);
        binding.normal.setChecked(meduim);
        binding.hard.setChecked(hard);
    }
}