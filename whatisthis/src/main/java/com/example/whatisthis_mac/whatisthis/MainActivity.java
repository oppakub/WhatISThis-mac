package com.example.whatisthis_mac.whatisthis;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;


public class MainActivity extends ActionBarActivity {
    private ImageView imgAnimal;
    private RadioGroup radAnswer;
    private String strAnswer;
    private MyAlertDialog objMyAlert;
    private Question objQuestion;
    private MyAlertDialog objMyAlertDialog;
    private int intTime = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
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
                        break;
                    case R.id.radHorse:
                        strAnswer = "Horse";
                        break;
                    case R.id.radPig:
                        strAnswer = "Pig";
                        break;
                    case R.id.radSheep:
                        strAnswer = "Sheep";
                        break;
                    default:
                        strAnswer = null;
                        break;
                }
            }
        });

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
            setValueToQuestion();
        } else {
            Log.d("oppa", "Please select one choice");
            //show dialog
            objMyAlertDialog = new MyAlertDialog();
            objMyAlertDialog.NoChooseEveryThing(MainActivity.this);
        }
    }

    private void setValueToQuestion() {
        if(intTime == 4) {
            intTime = 0;
        }
        intTime++;
        objQuestion.setIntQuestion(intTime);
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
