package com.example.zsuzsi.quizapp;

import android.graphics.Color;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import static android.graphics.Color.GREEN;

public class MainActivity extends AppCompatActivity {
    private Button submit_button, correct_button;
    private EditText answer1_field;
    private CheckBox violin_checkbox, viola_checkbox, chello_chekbox, doublebass_checkbox, piano_checkbox;
    private EditText answer3_field;
    private CheckBox continue_playing_to_the_end_checkbox, repeat_from_beginning_to_the_end_checkbox, jump_to_the_end_checkbox;
    private CheckBox strings_checkbox, woodwinds_checkbox, brass_checkbox, percussion_checkbox;
    private CheckBox africa_checkbox, australia_checkbox, india_checkbox, indonesia_checkbox;
    private CheckBox joseph_haydn_checkbox, w_amadeus_mozart_checkbox, ludwig_van_beethoven_checkbox, antonio_vivaldi_checkbox, richard_strauss_checkbox;
    private EditText answer2_field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setProperties();
        setEvents();
    }

    private void setProperties() {
        // EditTexts
        answer1_field = (EditText) findViewById(R.id.answer1_field);
        answer3_field = (EditText) findViewById(R.id.answer3_field);
        answer2_field = (EditText) findViewById(R.id.answer2_field);

        // Checkboxes
        violin_checkbox = (CheckBox) findViewById(R.id.violin_checkbox);
        viola_checkbox = (CheckBox) findViewById(R.id.viola_checkbox);
        chello_chekbox = (CheckBox) findViewById(R.id.chello_checkbox);
        doublebass_checkbox = (CheckBox) findViewById(R.id.doublebass_checkbox);
        piano_checkbox = (CheckBox) findViewById(R.id.piano_checkbox);
        continue_playing_to_the_end_checkbox = (CheckBox) findViewById(R.id.continue_playing_to_the_end_checkbox);
        repeat_from_beginning_to_the_end_checkbox = (CheckBox) findViewById(R.id.repeat_from_beginning_to_the_end_checkbox);
        jump_to_the_end_checkbox = (CheckBox) findViewById(R.id.jump_to_the_end_checkbox);
        strings_checkbox = (CheckBox) findViewById(R.id.strings_checkbox);
        woodwinds_checkbox = (CheckBox) findViewById(R.id.woodwinds_checkbox);
        brass_checkbox = (CheckBox) findViewById(R.id.brass_checkbox);
        percussion_checkbox = (CheckBox) findViewById(R.id.perussion_checkbox);
        africa_checkbox = (CheckBox) findViewById(R.id.africa_checkbox);
        australia_checkbox = (CheckBox) findViewById(R.id.australia_checkbox);
        india_checkbox = (CheckBox) findViewById(R.id.india_checkbox);
        indonesia_checkbox = (CheckBox) findViewById(R.id.indonesia_checkbox);
        joseph_haydn_checkbox = (CheckBox) findViewById(R.id.joseph_haydn_checkbox);
        w_amadeus_mozart_checkbox = (CheckBox) findViewById(R.id.w_amadeus_mozart_checkbox);
        ludwig_van_beethoven_checkbox = (CheckBox) findViewById(R.id.ludwig_van_beethoven_checkbox);
        antonio_vivaldi_checkbox = (CheckBox) findViewById(R.id.antonio_vivaldi_checkbox);
        richard_strauss_checkbox = (CheckBox) findViewById(R.id.richard_strauss_checkbox);


        // Buttons
        submit_button = (Button) findViewById(R.id.submit_button);
        correct_button = (Button) findViewById(R.id.correct_button);
    }

    private void setEvents() {
        submit_button.setOnClickListener(submitButtonClick);
        correct_button.setOnClickListener(fillCorrectAnswers);
    }

    View.OnClickListener fillCorrectAnswers = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            answer1_field.setText("Oboa");

            violin_checkbox.setChecked(false);
            viola_checkbox.setChecked(false);
            chello_chekbox.setChecked(false);
            doublebass_checkbox.setChecked(true);
            piano_checkbox.setChecked(true);

            answer3_field.setText("88");

            continue_playing_to_the_end_checkbox.setChecked(false);
            repeat_from_beginning_to_the_end_checkbox.setChecked(true);
            jump_to_the_end_checkbox.setChecked(false);

            strings_checkbox.setChecked(false);
            woodwinds_checkbox.setChecked(true);
            brass_checkbox.setChecked(false);
            percussion_checkbox.setChecked(false);

            africa_checkbox.setChecked(false);
            australia_checkbox.setChecked(true);
            india_checkbox.setChecked(false);
            indonesia_checkbox.setChecked(false);

            joseph_haydn_checkbox.setChecked(true);
            w_amadeus_mozart_checkbox.setChecked(true);
            ludwig_van_beethoven_checkbox.setChecked(true);
            antonio_vivaldi_checkbox.setChecked(false);
            richard_strauss_checkbox.setChecked(false);

            answer2_field.setText("Hungarian");


        }
    };

    View.OnClickListener submitButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int correct_answers = 0;

            System.out.println("============ " + answer1_field.getText());
            if (answer1_field.getText().toString().equals("Oboa")) {
                correct_answers += 1;
                answer1_field.setTextColor(GREEN);
            } else {
                answer1_field.setTextColor(Color.RED);
            }

            if (answer3_field.getText().toString().equals("88")) {
                correct_answers += 1;
                answer3_field.setTextColor(GREEN);
            } else {
                answer3_field.setTextColor(Color.RED);
            }

            if (answer2_field.getText().toString().equals("Hungarian")) {
                correct_answers += 1;
                answer2_field.setTextColor(GREEN);
            } else {
                answer2_field.setTextColor(Color.RED);
            }

            if (!violin_checkbox.isChecked() && !viola_checkbox.isChecked() &&
                    !chello_chekbox.isChecked() && doublebass_checkbox.isChecked() &&
                    piano_checkbox.isChecked()) {
                correct_answers += 1;
                doublebass_checkbox.setTextColor(GREEN);
                piano_checkbox.setTextColor(GREEN);
            } else {
                if (violin_checkbox.isChecked()) violin_checkbox.setTextColor(Color.RED);
                if (viola_checkbox.isChecked()) viola_checkbox.setTextColor(Color.RED);
                if (chello_chekbox.isChecked()) chello_chekbox.setTextColor(Color.RED);
                if (doublebass_checkbox.isChecked()) doublebass_checkbox.setTextColor(GREEN);
                if (piano_checkbox.isChecked()) piano_checkbox.setTextColor(GREEN);
            }

            if (!continue_playing_to_the_end_checkbox.isChecked() && repeat_from_beginning_to_the_end_checkbox.isChecked()
                    && !jump_to_the_end_checkbox.isChecked()) {

                correct_answers += 1;
                repeat_from_beginning_to_the_end_checkbox.setTextColor(GREEN);

            } else {
                if (continue_playing_to_the_end_checkbox.isChecked())
                    continue_playing_to_the_end_checkbox.setTextColor(Color.RED);
                if (repeat_from_beginning_to_the_end_checkbox.isChecked())
                    repeat_from_beginning_to_the_end_checkbox.setTextColor(Color.GREEN);
                if (jump_to_the_end_checkbox.isChecked())
                    jump_to_the_end_checkbox.setTextColor(Color.RED);

            }

            if (!strings_checkbox.isChecked() && woodwinds_checkbox.isChecked() && !brass_checkbox.isChecked() &&
                    !percussion_checkbox.isChecked()) {


                correct_answers += 1;
                woodwinds_checkbox.setTextColor(GREEN);
            } else {
                if (strings_checkbox.isChecked()) strings_checkbox.setTextColor(Color.RED);
                if (woodwinds_checkbox.isChecked()) woodwinds_checkbox.setTextColor(Color.GREEN);
                if (brass_checkbox.isChecked()) brass_checkbox.setTextColor(Color.RED);
                if (percussion_checkbox.isChecked()) percussion_checkbox.setTextColor(Color.RED);
            }

            if (!africa_checkbox.isChecked() && australia_checkbox.isChecked() && !india_checkbox.isChecked() &&
                    !indonesia_checkbox.isChecked()) {


                correct_answers += 1;
                australia_checkbox.setTextColor(GREEN);
            } else {
                if (africa_checkbox.isChecked()) africa_checkbox.setTextColor(Color.RED);
                if (australia_checkbox.isChecked()) australia_checkbox.setTextColor(Color.GREEN);
                if (india_checkbox.isChecked()) india_checkbox.setTextColor(Color.RED);
                if (indonesia_checkbox.isChecked()) indonesia_checkbox.setTextColor(Color.RED);

            }

            if (joseph_haydn_checkbox.isChecked() && w_amadeus_mozart_checkbox.isChecked() && ludwig_van_beethoven_checkbox.isChecked() &&
                    !antonio_vivaldi_checkbox.isChecked() && !richard_strauss_checkbox.isChecked()) {


                correct_answers += 1;
                joseph_haydn_checkbox.setTextColor(GREEN);
                w_amadeus_mozart_checkbox.setTextColor(GREEN);
                ludwig_van_beethoven_checkbox.setTextColor(GREEN);
            } else {
                if (joseph_haydn_checkbox.isChecked())
                    joseph_haydn_checkbox.setTextColor(Color.GREEN);
                if (w_amadeus_mozart_checkbox.isChecked())
                    w_amadeus_mozart_checkbox.setTextColor(Color.GREEN);
                if (ludwig_van_beethoven_checkbox.isChecked())
                    ludwig_van_beethoven_checkbox.setTextColor(Color.GREEN);
                if (antonio_vivaldi_checkbox.isChecked())
                    antonio_vivaldi_checkbox.setTextColor(Color.RED);
                if (richard_strauss_checkbox.isChecked())
                    richard_strauss_checkbox.setTextColor(Color.RED);
            }


            System.out.println("======== RESULTS: " + correct_answers);
            Toast.makeText(getApplicationContext(), "Your results: " + "8/" + correct_answers, Toast.LENGTH_SHORT).show();


        }
    };
}