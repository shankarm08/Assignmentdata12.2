package com.wedddingapp.shankar.assignment122;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//Creating class extending AppCompatActivity and implementing OnClickListener.
public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    //Creating SharedPreference and SharedPreference Editor references.
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    //Creating references for elements used in layout.
    Button saveBtn,showBtn;
    EditText nameET,ageET,phoneET,cityET;

    @Override
    //onCreate method.
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);    //Setting the content view.

        //Setting references with their IDs.
        saveBtn=(Button)findViewById(R.id.save_btn);
        showBtn=(Button)findViewById(R.id.show_btn);
        nameET=(EditText)findViewById(R.id.name_et);
        ageET=(EditText)findViewById(R.id.age_et);
        phoneET=(EditText)findViewById(R.id.phone_et);
        cityET=(EditText)findViewById(R.id.city_et);

        //Setting onClick Listeners to the Buttons.
        saveBtn.setOnClickListener(this);
        showBtn.setOnClickListener(this);

        //Creating object of SharedPreferences and editor.
        sharedPreferences=getApplicationContext().getSharedPreferences("myPref",MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }

    @Override
    //Method to handle onClick event.
    public void onClick(View v)
    {
        //Checking which button is Clicked.
        if(v.getId()==R.id.save_btn)
        {
            //Checking if all information is filled or not.
            if(!nameET.getText().toString().isEmpty() &&
                    !ageET.getText().toString().isEmpty() &&
                    !phoneET.getText().toString().isEmpty() &&
                    !cityET.getText().toString().isEmpty())
            {
                editor.putString("name",nameET.getText().toString());
                editor.putString("age",ageET.getText().toString());
                editor.putString("phone",phoneET.getText().toString());
                editor.putString("city",cityET.getText().toString());
                editor.commit();
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Please, Fill All Details",Toast.LENGTH_SHORT).show();
                //Displaying Toast.
            }
        }
        else if(v.getId()==R.id.show_btn)
        {
            if(!nameET.getText().toString().isEmpty() &&
                    !ageET.getText().toString().isEmpty() &&
                    !phoneET.getText().toString().isEmpty() &&
                    !cityET.getText().toString().isEmpty())
            {
                Toast.makeText(getApplicationContext(),"Name : "+sharedPreferences.getString("name","")+"\n"+
                        "Age : "+sharedPreferences.getString("age","")+"\n"+
                        "Phone : "+sharedPreferences.getString("phone","")+"\n"+
                        "City : "+sharedPreferences.getString("city",""),Toast.LENGTH_SHORT).show();
                //Displaying Toast of information of person.
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Please, Fill All Details",Toast.LENGTH_SHORT).show();
                //Displaying Toast.
            }
        }
    }
}
