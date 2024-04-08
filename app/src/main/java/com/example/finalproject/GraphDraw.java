package com.example.finalproject;
/** @file GraphDraw.java
 *
 *  @course CS2511
 *  @term Fall 2023
 *
 *  Testing file for graph related tests
 *
 *  @author Will Class
 *
 *  @date 08 Dec 2023
 *
 *  @version 1.0 */
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GraphDraw extends AppCompatActivity {
    private GraphDrawView graphView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_draw);

        // Find the Button by its ID
        Button breathSearchButton = findViewById(R.id.Breath_First_bt);
        Button depthSearchButton = findViewById(R.id.DepthFirst_bt);

        // Find your custom view by its ID
        graphView = findViewById(R.id.GraphDrawingView);

        // Set an OnClickListener to handle the button click event
        breathSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the custom function in your custom view
                graphView.startBreathFirstSearch();
            }
        });
        depthSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the custom function in your custom view
                graphView.startDepthFirstSearch();
            }
        });

    }
    /** Button method for closing graphDrawView
     */
    public void onPress_GoTo(View view) {
        finish();
    }

    public void onPress_BFS(View view) {

    }

}