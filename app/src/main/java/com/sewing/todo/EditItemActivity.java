package com.sewing.todo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class EditItemActivity extends AppCompatActivity {

    EditText etEdit;
    Spinner priority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        String update =  getIntent().getStringExtra("item");
        String pri = getIntent().getStringExtra("priority");
        etEdit = (EditText) findViewById(R.id.etEdit);
        etEdit.setText(update);
        etEdit.setSelection(etEdit.getText().length());
        etEdit.requestFocus();
//
        priority = (Spinner) findViewById(R.id.editSpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.priority, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner


        priority.setAdapter(adapter);
        setPriorityDefault(priority, pri);

//        priority.getSelected
    }

    private void setPriorityDefault(Spinner priority, String pri) {
        Log.d("start", "starting");
        if (pri.equals("Low")){
            priority.setSelection(0);
        } else if (pri.equals("Medium")){
            priority.setSelection(1);
        } else {
            priority.setSelection(2);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_item, menu);
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

    public void saveResult(View view){
        //take value of string
        //save it as new value of string in that position
        EditText etEdit = (EditText) findViewById(R.id.etEdit);
        Spinner spinner = (Spinner) findViewById(R.id.editSpinner);
        int position = getIntent().getExtras().getInt("position");
        Intent data = new Intent();
        data.putExtra("update", etEdit.getText().toString());
        data.putExtra("code", 200);
        data.putExtra("priority", spinner.getSelectedItem().toString());
        data.putExtra("position", position);

        setResult(RESULT_OK, data);
        finish();
    }
}
