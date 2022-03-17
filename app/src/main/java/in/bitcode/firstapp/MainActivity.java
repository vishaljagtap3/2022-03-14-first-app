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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout linearLayout;
    private TextView txtTitle, txtClear;
    private EditText edtUsername, edtPassword;
    private Button btnSignIn, btnAddImage, btnRemoveImage;

    ArrayList<ImageView> imageViews = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        linearLayout = findViewById(R.id.container);
        txtTitle = findViewById(R.id.txtTitle);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        txtClear = findViewById(R.id.txtClear);
        btnAddImage = findViewById(R.id.btnAddImage);
        btnRemoveImage = findViewById(R.id.btnRemoveImage);

        btnAddImage.setOnClickListener(new BtnAddImageClickListener());

        btnRemoveImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(imageViews.size() == 0) {
                    return;
                }

                linearLayout.removeView(
                        imageViews.get( imageViews.size() -1 )
                );
                imageViews.remove(imageViews.size()-1);
            }
        });

        View.OnClickListener onClickListener = new MyViewClickListener();

        txtClear.setOnClickListener(this);
        btnSignIn.setOnClickListener(this);

        /*txtClear.setOnClickListener(onClickListener);
        btnSignIn.setOnClickListener(onClickListener);*/

        /*btnSignIn.setOnClickListener(new BtnSignInClickListener());
        txtClear.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        edtUsername.setText("");
                        edtPassword.setText("");
                    }
                }
        );*/

        //btnSignIn.setOnTouchListener(new BtnSignInTouchListener());
        //btnSignIn.setOnKeyListener(new BtnSignKeyListener());

        //initUi();
    }

    private class BtnAddImageClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            ImageView img = new ImageView(MainActivity.this);
            img.setLayoutParams(
                    new ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT
                    )
            );
            img.setImageResource(R.drawable.app_icon);

            linearLayout.addView(img);

            imageViews.add(img);
        }
    }

    @Override
    public void onClick(View view) {
        if(view == txtClear) {
            edtUsername.setText("");
            edtPassword.setText("");
        }

        if(view.getId() == R.id.btnSignIn) {
            if(edtUsername.getText().toString().equals("bitcode") && edtPassword.getText().toString().equals("bitcode")) {
                txtTitle.setText("Success");
            }
            else {
                txtTitle.setText("Failed");
            }
        }
    }

    private class MyViewClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this, "view clicked", Toast.LENGTH_LONG)
                    .show();
            if(view == txtClear) {
                edtUsername.setText("");
                edtPassword.setText("");
            }

            if(view.getId() == R.id.btnSignIn) {
                if(edtUsername.getText().toString().equals("bitcode") && edtPassword.getText().toString().equals("bitcode")) {
                    txtTitle.setText("Success");
                }
                else {
                    txtTitle.setText("Failed");
                }
            }
        }
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