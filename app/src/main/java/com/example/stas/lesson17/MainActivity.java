package com.example.stas.lesson17;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnCreate;
    Button btnClear;
    EditText etname;
    RadioGroup rgGravity;
    LinearLayout Lisainfo;
    RadioButton rbLeft;
    RadioButton rbCenter;
    RadioButton rbRight;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        Lisainfo = (LinearLayout) findViewById(R.id.Lisainfo);
        rgGravity = (RadioGroup) findViewById(R.id.rgGravity);
        etname = (EditText) findViewById(R.id.etname);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnCreate = (Button) findViewById(R.id.btnCreate);
        rbLeft = (RadioButton) findViewById(R.id.rbLeft);
        rbCenter = (RadioButton) findViewById(R.id.rbCenter);
        rbRight = (RadioButton) findViewById(R.id.rbRight);

        btnCreate.setOnClickListener(this);
        btnClear.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        menu.add("1");
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCreate:
                LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                int btnGravity = Gravity.LEFT;


                switch (rgGravity.getCheckedRadioButtonId()) {
                    case R.id.rbLeft:
                        btnGravity = Gravity.LEFT;
                        break;
                    case R.id.rbCenter:
                        btnGravity = Gravity.CENTER_HORIZONTAL;
                        break;
                    case R.id.rbRight:
                        btnGravity = Gravity.RIGHT;
                        break;
                }
                lParams.gravity = btnGravity;
                Button btnNew = new Button(this);
                btnNew.setText(etname.getText().toString());
                Lisainfo.addView(btnNew,lParams);
                break;
            case R.id.btnClear:
                Lisainfo.removeAllViews();
                Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
                break;

        }

    }
}
