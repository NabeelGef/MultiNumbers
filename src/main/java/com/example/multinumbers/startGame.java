package com.example.multinumbers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.multinumbers.databinding.ActivityStartGameBinding;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
public class startGame extends AppCompatActivity {
    int o = 0;
    int one, two;
    Counter clock = new Counter();
    int val;
    int counter,count;
    boolean clicked = false ,stop = false;
    static int val3;
    ActivityStartGameBinding binding;
    private Adapter adapter;
    private ArrayList<creatImage> create;
    presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_start_game);
        final Randomly randomly = new Randomly();
        if(Levels.getInstance().isEasy())
        {
            randomly.set(11);
            counter = 10;
        }
        else if(Levels.getInstance().isMed())
        {
            randomly.set(21);
            counter = 20;
        }
        else
        {
            randomly.set(51);
            counter = 30;
        }
        create = new ArrayList<>();
        presenter = new presenter();
        one = randomly.getRand();
        binding.oneDigit.setText("" + one);
        two = randomly.getRand();
        binding.twoDigit.setText("" + two);
        clock = ViewModelProviders.of(this).get(Counter.class);
        clock.mutableLiveData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.count.setText(String.valueOf(integer));
            }
        });
        clock.mutableLiveData2.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean)
                {
                    if (o == 6) {
                        System.out.println("in LiveData");
                        binding.count.setText(""+counter);
                        clock.mute();
                        if(Translate.getTrr().isTr()) {
                            binding.score.setText("العلامة = " + val3);
                            binding.rest.setText("المحاولة من جديد لكسب النقاط ! ");
                        }
                        else
                        {
                            binding.score.setText("Mark = " + val3);
                            binding.rest.setText("Try again to earn points");
                        }
                        binding.rest.setBackgroundColor(Color.GREEN);
                        clicked = false;
                    }
                        if (Translate.getTrr().isTr()) {
                            binding.test.setText("للأسف غلط !");
                        } else {
                            binding.test.setText("sorry wrong !");
                        }
                        create.add(new creatImage("", false));
                        adapter = new Adapter(getApplicationContext(), create);
                        binding.recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
                        binding.recycler.setAdapter(adapter);
                        o++;
                        binding.input.getText().clear();
                        if(o!=7)
                            clock.ONClock(counter);
                    if(Translate.getTrr().isTr())
                    {
                        Toast.makeText(getApplicationContext(), "الجواب الصحيح هو  " + one * two, Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "the answer is : " + one * two, Toast.LENGTH_SHORT).show();
                    }
                    one = randomly.getRand();
                    binding.oneDigit.setText("" + one);
                    two = randomly.getRand();
                    binding.twoDigit.setText("" + two);
                }
            }
        });
            clock.ONClock(counter);
        if(Translate.getTrr().isTr())
        {
            binding.soulation.setText("تأكيد الجواب");
            binding.input.setHint("أدخل الرقم");
        }
        else
        {
            binding.soulation.setText("Confirm answer");
            binding.input.setHint("Enter The Number");
        }
        binding.soulation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.input.getText().toString().isEmpty()) {
                    if(Translate.getTrr().isTr())
                    {
                        Toast.makeText(getApplicationContext(), " انت لم تدخل اي رقم بعد ", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), " you don't any number yet! ", Toast.LENGTH_SHORT).show();
                    }
                }
                else if (o > 6)
                {
                    if(Translate.getTrr().isTr())
                    {
                        Toast.makeText(getApplicationContext(), "انتهت اللعبة ", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), " GameOver ", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    clock.OFFClock(counter);
                    val = Integer.parseInt(binding.input.getText().toString());
                    if (presenter.proccess(one,two,val) && o <= 6) {
                            if(Translate.getTrr().isTr())
                            {
                                binding.test.setText("برافو صح !");
                            }
                            else
                            {
                                binding.test.setText("Good!!");
                            }
                         if (o == 6) {
                              binding.count.setText(""+counter);
                              clock.mute();
                             if(Translate.getTrr().isTr()) {
                                 binding.score.setText("العلامة = " + val3);
                                 binding.rest.setText("المحاولة من جديد لكسب النقاط ! ");
                             }
                             else
                             {
                                 binding.score.setText("Mark = " + val3);
                                 binding.rest.setText("Try again to earn points");
                             }
                            binding.rest.setBackgroundColor(Color.GREEN);
                             clicked = false;
                        }

                        create.add(new creatImage("",true));
                        adapter = new Adapter(getApplicationContext(),create);
                        binding.recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
                        binding.recycler.setAdapter(adapter);
                        o++;
                        val3=presenter.counter(val3);
                        binding.input.getText().clear();
                    } else if (!presenter.proccess(one,two,val) && o <= 6) {
                        if(Translate.getTrr().isTr())
                        {
                            binding.test.setText("للأسف غلط !");
                        }
                        else
                        {
                            binding.test.setText("sorry wrong !");
                        }
                         if (o == 6) {
                             if(Translate.getTrr().isTr()) {
                                 binding.score.setText("العلامة = " + val3);
                                 binding.rest.setText("المحاولة من جديد لكسب النقاط ! ");
                             }
                             else
                             {
                                 binding.score.setText("Mark = " + val3);
                                 binding.rest.setText("Try again to earn points");
                             }
                             binding.rest.setBackgroundColor(Color.GREEN);

                         }
                        create.add(new creatImage("",false));
                        adapter = new Adapter(getApplicationContext(),create);
                        binding.recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
                        binding.recycler.setAdapter(adapter);
                        o++;
                        binding.input.getText().clear();
                        if(Translate.getTrr().isTr())
                        {
                            Toast.makeText(getApplicationContext(), "الجواب الصحيح هو  " + one * two, Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "the answer is : " + one * two, Toast.LENGTH_SHORT).show();
                        }
                    }
                    one = randomly.getRand();
                    binding.oneDigit.setText("" + one);
                    two = randomly.getRand();
                    binding.twoDigit.setText("" + two);
                }
            }
        });
        binding.rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent In = new Intent(getApplicationContext(), startGame.class);
                startActivity(In);
                finish();

            }
        });
        }
        @Override
        public  void onBackPressed(){
        val3 = 0;
       // clock.mute();
        super.onBackPressed();
        }
    }