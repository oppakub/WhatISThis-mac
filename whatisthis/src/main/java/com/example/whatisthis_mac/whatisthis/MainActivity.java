package com.example.whatisthis_mac.whatisthis;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    private ImageView imgAnimal;
    private RadioGroup radAnswer;
    private String strAnswer;
    private Question objQuestion;
    private MyAlertDialog objMyAlertDialog;
    private int intTime = 1 , intUserChoose , intUserScore;
    private MediaPlayer objMediaPlayerButton , objMediaPlayerRadioButton;
    private int intUserChooseArray[] , intUserScoreArray[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        intUserScoreArray = new int[5];
        intUserChooseArray = new int[5];
        setValueTrueAnswer();

        objQuestion = new Question();
        objQuestion.setOnQuestionChangeListener(new Question.OnQuestionChangeListener() {
            @Override
            public void onQuestionChangeListener(Question question) {
                switch (question.getIntQuestion()) {
                    case 1:
                        imgAnimal.setImageResource(R.drawable.cow);
                        break;
                    case 2:
                        imgAnimal.setImageResource(R.drawable.horse);
                        break;
                    case 3:
                        imgAnimal.setImageResource(R.drawable.pig);
                        break;
                    case 4:
                        imgAnimal.setImageResource(R.drawable.sheep);
                        break;
                    default:
                        break;
                }
            }
        });
        radAnswer.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radCow:
                        strAnswer = "Cow";
                        intUserChoose = 1;
                        break;
                    case R.id.radHorse:
                        strAnswer = "Horse";
                        intUserChoose = 2;
                        break;
                    case R.id.radPig:
                        strAnswer = "Pig";
                        intUserChoose = 3;
                        break;
                    case R.id.radSheep:
                        strAnswer = "Sheep";
                        intUserChoose = 4;
                        break;
                    default:
                        strAnswer = null;
                        break;
                }
                soundRadioButton();
                ToaseMessage();
            }
        });

    }

    private void setValueTrueAnswer() {
        intUserScoreArray[1] = 1;
        intUserScoreArray[2] = 2;
        intUserScoreArray[3] = 3;
        intUserScoreArray[4] = 4;
    }

    private void initWidget() {
        imgAnimal = (ImageView) findViewById(R.id.imgAnimal);
        radAnswer = (RadioGroup) findViewById(R.id.radAnswer);
    }

    public void ClickAnswer(View view) {
           checkChooseAnswer();

    } // end of ClickAnswer

    private void checkChooseAnswer() {
        if(strAnswer != null) {
            Log.d("oppa", "strAnswer = " + strAnswer);
            checkScore();
            setValueToQuestion();
        } else {
            Log.d("oppa", "Please select one choice");
            //show dialog
            objMyAlertDialog = new MyAlertDialog();
            objMyAlertDialog.NoChooseEveryThing(MainActivity.this);
        }
        soundButton();
    }

    private void checkScore() {
        intUserChooseArray[intTime] = intUserChoose;
        Log.d("oppa", "intUserChooseArray[" + String.valueOf(intTime) + "] = " + intUserChoose);
        if (intUserChooseArray[intTime] == intUserScoreArray[intTime]) {
            intUserScore++;
        }
        Log.d("oppa", "intUserScore = " + String.valueOf(intUserScore));
    }
    private void setValueToQuestion() {
        if(intTime == 4) {
           // intTime = 0;
            Intent objIntent = new Intent(MainActivity.this, ShowAnswer.class);
            objIntent.putExtra("Score", intUserScore);
            startActivity(objIntent);
            finish();
        }
        intTime++;
        objQuestion.setIntQuestion(intTime);
    }

    private void soundButton() {
        objMediaPlayerButton = MediaPlayer.create(getBaseContext(), R.raw.effect_btn_shut);
        objMediaPlayerButton.start();
    }

    private void soundRadioButton() {
        objMediaPlayerRadioButton = MediaPlayer.create(getBaseContext(), R.raw.effect_btn_long);
        objMediaPlayerRadioButton.start();
    }

    private void ToaseMessage() {
        Toast.makeText(MainActivity.this, "Are you sure your answer is " + strAnswer, Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
