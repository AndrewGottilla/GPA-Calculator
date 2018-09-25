package com.example.andrewgodzilla.gpa_calculator;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;


import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    // declare all fields from activity_main
    View main;

    EditText et_gpa1;
    EditText et_gpa2;
    EditText et_gpa3;
    EditText et_gpa4;
    EditText et_gpa5;

    TextView tv_gpa1;
    TextView tv_gpa2;
    TextView tv_gpa3;
    TextView tv_gpa4;
    TextView tv_gpa5;
    TextView tv_gpa_calced;

    Button btn_compute;

    // btn_switch for button functionality
    boolean btn_switch = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main=(View)findViewById(R.id.main);

        // Initialize all EditViews
        et_gpa1=(EditText)findViewById(R.id.et_g1);
        et_gpa2=(EditText)findViewById(R.id.et_g2);
        et_gpa3=(EditText)findViewById(R.id.et_g3);
        et_gpa4=(EditText)findViewById(R.id.et_g4);
        et_gpa5=(EditText)findViewById(R.id.et_g5);

        // Initialize all TextViews
        tv_gpa1=(TextView)findViewById(R.id.tv_gpa1);
        tv_gpa2=(TextView)findViewById(R.id.tv_gpa2);
        tv_gpa3=(TextView)findViewById(R.id.tv_gpa3);
        tv_gpa4=(TextView)findViewById(R.id.tv_gpa4);
        tv_gpa5=(TextView)findViewById(R.id.tv_gpa5);
        tv_gpa_calced=(TextView) findViewById(R.id.tv_gpa_calced);

        // Initialize Button
        btn_compute=(Button)findViewById(R.id.btn_calculate);
    }


    public void calculateGPA(View view) {
        if (btn_switch) {
            // Test boolean will be true if any EditText is blank
            boolean test1 = et_gpa1.getText().toString().matches("");
            boolean test2 = et_gpa2.getText().toString().matches("");
            boolean test3 = et_gpa3.getText().toString().matches("");
            boolean test4 = et_gpa4.getText().toString().matches("");
            boolean test5 = et_gpa5.getText().toString().matches("");
            double avgGrade, avgGPA = 0, GPA;

            // to format output when having repeating decimal
            NumberFormat nf = NumberFormat.getInstance();

            // If any EditText is blank, then error, else run operations
            if (test1 || test2 || test3 || test4 || test5) {
                tv_gpa_calced.setText(R.string.err_blank);
            }
            else {
                // Grab values from EditText fields and calculate average
                // GPA will store GPA sent back from getGPA function
                // getGPA(int) will return actual GPA based on grade
                // show all GPA alongside grades next to EditText fields (for clarity)

                int gpa1 = Integer.parseInt(et_gpa1.getText().toString());
                GPA = getGPA(gpa1);
                avgGPA += GPA;
                tv_gpa1.setText(String.valueOf(GPA + " : " + gpa1));

                int gpa2 = Integer.parseInt(et_gpa2.getText().toString());
                GPA = getGPA(gpa2);
                avgGPA += GPA;
                tv_gpa2.setText(String.valueOf(GPA + " : " + gpa2));

                int gpa3 = Integer.parseInt(et_gpa3.getText().toString());
                GPA = getGPA(gpa3);
                avgGPA += GPA;
                tv_gpa3.setText(String.valueOf(GPA + " : " + gpa3));

                int gpa4 = Integer.parseInt(et_gpa4.getText().toString());
                GPA = getGPA(gpa4);
                avgGPA += GPA;
                tv_gpa4.setText(String.valueOf(GPA + " : " + gpa4));

                int gpa5 = Integer.parseInt(et_gpa5.getText().toString());
                GPA = getGPA(gpa5);
                avgGPA += GPA;
                tv_gpa5.setText(String.valueOf(GPA + " : " + gpa5));

                // Calculate averages
                avgGPA /= 5;
                avgGrade = ((gpa1 + gpa2 + gpa3 + gpa4 + gpa5) / 5);

                // Display average
                tv_gpa_calced.setText(String.valueOf(nf.format(avgGPA) + " : " + nf.format(avgGrade)));

                changeBackground(avgGrade);

                btn_switch = false;
                btn_compute.setText(R.string.btn_state2);
            }// end else
        }// ends if (btn_switch)
        else
        {
            btn_switch = true;

            // Clear EditText
            et_gpa1.setText("");
            et_gpa2.setText("");
            et_gpa3.setText("");
            et_gpa4.setText("");
            et_gpa5.setText("");

            // Clear TextViews
            tv_gpa1.setText(R.string.tv_default);
            tv_gpa2.setText(R.string.tv_default);
            tv_gpa3.setText(R.string.tv_default);
            tv_gpa4.setText(R.string.tv_default);
            tv_gpa5.setText(R.string.tv_default);

            tv_gpa_calced.setText(R.string.tv_default);

            main.setBackgroundColor(0xFFFFFFFF);

            btn_compute.setText(R.string.btn_state1);
        }// ends (btn_switch) else
    }

    public double getGPA(int grade)
    {
        // return GPA based on grade
        if (grade < 65)
            return 0;
        else if (grade < 67)
            return 1;
        else if (grade < 70)
            return 1.3;
        else if (grade < 73)
            return 1.7;
        else if (grade < 77)
            return 2.0;
        else if (grade < 80)
            return 2.3;
        else if (grade < 83)
            return 2.7;
        else if (grade < 87)
            return 3.0;
        else if (grade < 90)
            return 3.3;
        else if (grade < 93)
            return 3.7;
        else
            return 4.0;
    }

    public void changeBackground(double avg) {
        /* IDE formatted the if statements like this
        if (avg < 60) {
            mainView.setBackgroundColor(0xFFFF0000);
        } else if (avg < 80) {
            mainView.setBackgroundColor(0xFFFFFF00);
        } else {
            mainView.setBackgroundColor(0xFF00FF00);
        }
        */

        if (avg < 60)
            main.setBackgroundColor(0xFFFF0000);
        else if (avg < 80)
            main.setBackgroundColor(0xFFFFFF00);
        else
            main.setBackgroundColor(0xFF00FF00);
    }
}
