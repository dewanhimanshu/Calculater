package com.example.hrc.calculater;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    Button btn[] = new Button[10];
    Button op[] = new Button[4];
    Button reset;
    Button submit;
    TextView v;
    StringBuilder CurrentValue = new StringBuilder();
    CharSequence result;

    int pre = 0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn[0] = (Button)findViewById(R.id.button0);
        btn[1] = (Button)findViewById(R.id.button1);
        btn[2] = (Button)findViewById(R.id.button2);
        btn[3] = (Button)findViewById(R.id.button3);
        btn[4] = (Button)findViewById(R.id.button4);
        btn[5] = (Button)findViewById(R.id.button5);
        btn[6] = (Button)findViewById(R.id.button6);
        btn[7] = (Button)findViewById(R.id.button7);
        btn[8] = (Button)findViewById(R.id.button8);
        btn[9] = (Button)findViewById(R.id.button9);
        op[0] = (Button)findViewById(R.id.plus);
        op[1] = (Button)findViewById(R.id.divide);
        op[2] = (Button)findViewById(R.id.minus);
        op[3] = (Button)findViewById(R.id.mul);
        reset = (Button)findViewById(R.id.reset);
        submit = (Button)findViewById(R.id.submit);
        v = (TextView)findViewById(R.id.textView);


        for(int i=0;i<10;i++)
        {


            final int finalI = i;
            btn[i].setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    //btn[finalI].getText().toString()
                    CharSequence Screen = v.getText();
                     Screen = Screen + btn[finalI].getText().toString();
                     v.setText(Screen);
                }
            });

            }
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence x = v.getText();
                String y = x.toString();
                y = y.concat("+0");
                y = "0+"+y;  
                char a []  =y.toString().toCharArray();
                int result=0;
                String number1 = new String();
                number1 = "0";
                String number2 = new String();
                number2 = "0";
                String FinalAns = new String();
                for(int i=0;i<a.length;i++)
                {

                    if(a[i]=='+')
                    {
                       String ans = String.valueOf((Integer.parseInt(number2) + Integer.parseInt(number1)));
                       number1 = new String(ans);
                       v.setText(number1);
                       number2 = new String();


                    }
                    else if(a[i]=='-')
                    {

                        String ans = String.valueOf((Integer.parseInt(number2) - Integer.parseInt(number1)));
                        number1 = new String(ans);
                        v.setText(number1);
                        number2 = new String();

                    }
                    else if(a[i]=='/')
                    {
                        String ans = String.valueOf((Integer.parseInt(number2) / Integer.parseInt(number1)));
                        number1 = new String(ans);
                        v.setText(number1);
                        number2 = new String();

                    }
                    else if(a[i]=='*')
                    {
                        String ans = String.valueOf((Integer.parseInt(number2) * Integer.parseInt(number1)));
                        number1 = new String(ans);
                        v.setText(number1);
                        number2 = new String();

                    }
                    else
                    {
                        number2  = number2.concat(String.valueOf(a[i]));
                }

            }}
        });

        for(int i=0;i<4;i++)
        {
            final int finalI = i;
            op[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    result = v.getText();
                    CharSequence text = op[finalI].getText();
                    String finalr="";
                    finalr += result.toString()+text.toString();
                    v.setText(finalr);
//                    CharSequence Screen = v.getText();
//                    Screen = Screen.toString() + btn[finalI].getText();
//                    v.setText(Screen.toString());

                }
            });
        }


        reset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    result = "";
                    v.setText(result);
                    pre = 0;
                }
            });


        }

}
