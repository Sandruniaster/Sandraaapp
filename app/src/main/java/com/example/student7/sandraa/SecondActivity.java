
package com.example.student7.sandraa;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class SecondActivity extends ActionBarActivity {


    TextView welcome;
    EditText telefon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        welcome = (TextView) findViewById(R.id.welcome);
        telefon = (EditText) findViewById(R.id.telefon);
        Bundle intentExtras = getIntent().getExtras();
        String username = intentExtras.getString("username");
        if (username.equals("kowalski"))
            welcome.setText("Spadaj pało");
        else
            welcome.setText("Cześćććcć " + username + "!");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
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
    public void call(View view) {
        String tel = telefon.getText().toString();
       /* boolean cyfra = true;
        for (int n = 0; n < telefon.getText().length(); n++) {

            if (!Character.isDigit(telefon.getText().charAt(n))) {
                cyfra = false;
                break;
            }
        }
        */
        // if (cyfra == true && telefon.getText().length() == 6) {
        Intent i = new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel: " + tel));
        startActivity(i);
      /*  } else {
         //   Toast.makeText(getApplicationContext(), "To nie jest numer telefonu", Toast.LENGTH_LONG).show();
        } */
    }
}