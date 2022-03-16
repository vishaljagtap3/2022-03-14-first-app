package in.bitcode.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private TextView txtTitle;
    private EditText edtUsername, edtPassword;
    private Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        txtTitle = findViewById(R.id.txtTitle);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnSignIn = findViewById(R.id.btnSignIn);

        btnSignIn.setOnClickListener(new BtnSignInClickListener());

        //btnSignIn.setOnTouchListener(new BtnSignInTouchListener());
        //btnSignIn.setOnKeyListener(new BtnSignKeyListener());

        //initUi();
    }

    private class BtnSignInClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if(edtUsername.getText().toString().equals("bitcode") && edtPassword.getText().toString().equals("bitcode")) {
                txtTitle.setText("Success");
            }
            else {
                txtTitle.setText("Failed");
            }
        }
    }

    private class BtnSignInTouchListener implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return false;
        }
    }

    private class BtnSignKeyListener implements View.OnKeyListener {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            return false;
        }
    }

    private void initUi() {
        linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.CENTER);
        linearLayout.setLayoutParams(
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                )
        );

        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        txtTitle = new TextView(this);
        txtTitle.setGravity(Gravity.CENTER_HORIZONTAL);
        txtTitle.setTextSize(25);
        //txtTitle.setText("BitCode");
        txtTitle.setText(R.string.company);
        txtTitle.setLayoutParams(layoutParams);
        linearLayout.addView(txtTitle);

        edtUsername = new EditText(this);
        edtUsername.setLayoutParams(layoutParams);
        linearLayout.addView(edtUsername);

        edtPassword = new EditText(this);
        edtPassword.setLayoutParams(layoutParams);
        linearLayout.addView(edtPassword);

        btnSignIn = new Button(this);
        btnSignIn.setText("Sign In");
        btnSignIn.setLayoutParams(layoutParams);
        linearLayout.addView(btnSignIn);

        setContentView(linearLayout);
    }
}