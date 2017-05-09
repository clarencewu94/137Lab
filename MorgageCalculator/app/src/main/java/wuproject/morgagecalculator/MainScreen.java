package wuproject.morgagecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainScreen extends AppCompatActivity {

    private static final String Home_Value = "Home Value";
    private static final String Interest_Rate = " Interest Rate";

    //Amount being inserted
    private double HomeInput;//user input
    private double InterestInput;
    //Accepts User Input
    private EditText HomeInput; //user input for Home Payment
    private EditText DownInput; //user input for Down Payment

    private EditText InterestRate; // custom rate

    //amount of terms
    private EditText FirstTerm; // 15 yr monthly
    private EditText SecondTerm; // 20 yr monthly
    private EditText ThirdTerm;  // 25 yr monthly
    private EditText FourthTerm; //30 yr monthly
    private EditText FifthTerm;  //35 yr montly
    //declaring the amount of terms


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        if ( savedInstanceState == null ) // the app just started running
        {
            HomeInput = 0.0; // initialize the loan amount to zero
        } // end if
        else // app is being restored from memory, not executed from scratch
        {
            // initialize the loan amount to saved amount
            HomeInput = savedInstanceState.getDouble(Home_Value);

            // initialize the custom rate to saved interest rate

        } // end else

        Interest_Rate = (TextView) findViewById(R.id.InterestRate);
        loanEditText = (EditText) findViewById(R.id.loanEditText);


    }

    // calculate monthly payment
    private double formula(double loan, double rate, int term)
    {
        double c = rate/100/12.;
        double n = term *12 ;
        return loan * (c * Math.pow(1 + c, n )) / ( Math.pow(1 + c,n)-1);
    }

    private void updateMonthlyPayment()
    {
        // calculate monthly payment
        double FirstTerm =
                formula(HomeInput,InterestRate, 15 );
        double SecondTerm =
                formula(HomeInput,InterestRate, 20 );
        double ThirdTerm =
                formula(HomeInput,InterestRate, 25 );
        double ForthTerm =
                formula(HomeInput,InterestRate, 30 );
        double FifthTerm =
                formula(HomeInput,InterestRate, 35 );
        // 10, 15 and 30 yr monthly payment EditTexts
        FirstTerm.setText("$" + String.format("%.0f", FirstTerm));
        SecondTerm.setText("$" + String.format("%.0f", SecondTerm));
        ThirdTerm.setText("$" + String.format("%.0f", ThirdTerm));
        ForthTerm.setText("$" + String.format("%.0f", ForthTerm));
        FifthTerm.setText("$" + String.format("%.0f", FifthTerm));
    }




}
