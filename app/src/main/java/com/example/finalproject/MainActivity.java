package com.example.finalproject;
/** @file MainActivity.java
 *
 *  @course CS2511
 *  @term Fall 2023
 *
 *  The front screen activity for the app
 *
 *  @author Will Class
 *
 *  @date 01 Dec 2023
 *
 *  @version 1.0 */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    /** Method for adding a new vertex when submit button is pushed
     *
     * @param view the current view that will be used
     */
    public void onPress_Create(View view) {

    }


// Fuctions below are for opening Graph Draw activity
    /** Button to open new view activity
     */
    public void onPress_Graph_Draw(View view) {
        openGraphDraw();
    }
    /** Method for opening new graph view
     */
    public void openGraphDraw() {
        Intent intent = new Intent(this, GraphDraw.class);
        startActivity(intent);
    }
}