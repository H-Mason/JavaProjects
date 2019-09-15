
package com.example.scriptureapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_BOOK = "com.example.scriptureapp.BOOK";
    public static final String EXTRA_CHAPTER = "com.example.scriptureapp.CHAPTER";
    public static final String EXTRA_VERSE = "com.example.scriptureapp.VERSE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buildScripture(View view) {

        EditText editText = (EditText) findViewById(R.id.editText);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        EditText editText3 = (EditText) findViewById(R.id.editText3);
        String book = editText.getText().toString();
        String chapter= editText2.getText().toString();
        String verse = editText3.getText().toString();
        Log.e("buildScripture", "About to create intent with " + book + " " + chapter + ":" + verse);
        Intent intent = new Intent(this, DisplayScriptureActivity.class);
        intent.putExtra(EXTRA_BOOK, book);
        intent.putExtra(EXTRA_CHAPTER, chapter);
        intent.putExtra(EXTRA_VERSE, verse);
        startActivity(intent);
    }
    public void loadScripture(View view) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String book = preferences.getString("Book", "");
        String chapter = preferences.getString("Chapter", "");
        String verse = preferences.getString("Verse", "");
        EditText editText = findViewById(R.id.editText);
        EditText editText2 = findViewById(R.id.editText2);
        EditText editText3 = findViewById(R.id.editText3);
        editText.setText(book, TextView.BufferType.EDITABLE);
        editText2.setText(chapter, TextView.BufferType.EDITABLE);
        editText3.setText(verse, TextView.BufferType.EDITABLE);

    }
}

