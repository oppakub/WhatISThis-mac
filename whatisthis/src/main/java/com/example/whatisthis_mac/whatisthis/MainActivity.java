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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
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
        } else {
            Log.d("oppa", "Please select one choice");
        }
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
