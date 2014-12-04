package com.example.student7.sandraa;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.student7.sandraa.adapter.PersonListAdapter;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;



@EActivity(R.layout.activity_my)
public class MyActivity extends ActionBarActivity {

    @ViewById
    ListView list;

    @Bean
    PersonListAdapter adapter;

    @AfterViews
    void init() {
//        String[] values = new String[] {"A", "B", "C", "D", "E", "F", "G", "H"};

//      ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, values);

        list.setAdapter(adapter);
    }

    @ViewById(R.id.username)

    public EditText username;

    /*
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_my);
            username = (EditText) findViewById(R.id.ername);

        }

   */

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.my, menu);
            return true;
        }

    public void loginClicked(View view) {
      Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("username", username.getText().toString());
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @ItemClick(R.id.list)
    void listItemClicked(String item) {
    Toast.makeText(this, item, Toast.LENGTH_SHORT).show();

    }

}

