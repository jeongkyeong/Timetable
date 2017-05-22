package myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editPW = (EditText) findViewById(R.id.edit_pw);

    }
    public void onClick(View view)
    {
        EditText editID = (EditText) findViewById(R.id.edit_id);
        String id=editID.getText().toString();
        Intent intent = new Intent(this,SubActivity.class);
        intent.putExtra("ID", id);
        startActivity(intent);
    }
}

