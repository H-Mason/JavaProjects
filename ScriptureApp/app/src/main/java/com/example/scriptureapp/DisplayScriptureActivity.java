package com.example.scriptureapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayScriptureActivity extends AppCompatActivity {
    String book = "";
    String chapter = "";
    String verse = "";
    public String scripture = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_scripture);


        Intent intent = getIntent();

        book = intent.getStringExtra(MainActivity.EXTRA_BOOK);
        chapter = intent.getStringExtra(MainActivity.EXTRA_CHAPTER);
        verse = intent.getStringExtra(MainActivity.EXTRA_VERSE);
        scripture = book + " " + chapter + ":" + verse;
        TextView textView = findViewById(R.id.finalScripture);
        textView.setText(scripture);
        Log.e("onCreate", "Received intent with " + book + " " + chapter + ":" + verse);
    }
    public void onSave(View view) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("Book", book);
        editor.putString("Chapter", chapter);
        editor.putString("Verse", verse);
        editor.apply();

        Context context = getApplicationContext();
        CharSequence message = "Scripture saved";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }
}

