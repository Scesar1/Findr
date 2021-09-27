package com.example.findr20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Activity3 extends AppCompatActivity {

    boolean[] equipment = new boolean[4]; // {computers, projectors, whiteboards, printers}
    boolean[] noEquipment = {/*computers*/ false, /*projectors*/ false, /*whiteboards*/ false, /*printers*/ false};
    boolean[] justWhiteboard = {false, false, true, false};
    boolean[] whiteboardAndProjector = {false, true, true, false};
    boolean[] whiteboardAndPrinters = {false, false, true, true};
    boolean[] allButProjectors = {true, false, true, true};
    boolean[] justPrinters = {false, false, false, true};
    boolean[] computersAndWhiteboards = {true, false, true, false};
    boolean[] justProjector = {false, true, false, false}; //projector/monitor/tv
    boolean[] allButComputers = {false, true, true, true};

    StudySpot brodyAtrium = new StudySpot("Brody Atrium", true, true, true, 2,
            2, 800,2600, 0, false,
            false, 3, false, false, allButComputers);

    StudySpot mseMLevel = new StudySpot("MSE M-Level", true, true, false, 2,
            2, 800,2600, 0, false,
            false, 3, false, true, allButProjectors);

    StudySpot mseALevel = new StudySpot("MSE A-Level", true, true, false, 1,
            1, 800,2600, 0, true,
            false, 3, false, false, computersAndWhiteboards);

    StudySpot mseBLevel = new StudySpot("MSE B-Level", true, true, false, 2,
            1, 800,2600, 1, false,
            false, 2, false, false, noEquipment);

    StudySpot mseCLevel = new StudySpot("MSE C-Level", true, true, false, 1,
            1, 800,2600, 1, false,
            false, 1, true, false, noEquipment);

    StudySpot mseDLevel = new StudySpot("MSE D-Level", true, false, false, 1,
            1, 800,2600, 2, false,
            false, 0, true, false, noEquipment);

    StudySpot visualizationStudio = new StudySpot("A-Level Visualization Studio", true, true, false, 1,
            1, 800,2600, 2, false,
            false, 3, false, false, whiteboardAndProjector);

    StudySpot mseStudyRooms = new StudySpot("MSE Study Rooms", true, true, false, 1,
            1, 800,2600, 3, false,
            true, 3, true, false, justWhiteboard);

    StudySpot brodyStudyRooms = new StudySpot("Brody Study Rooms", true, true, false, 1,
            1, 800,2600, 3, false,
            true, 3, true, false, whiteboardAndProjector);

    StudySpot brodyCafe = new StudySpot("Brody Cafe", false, true, true, 0,
            1, 830,1600, 0, false,
            false, 3, false, false, noEquipment);

    StudySpot brodyTerrace = new StudySpot("Brody Terrace", false, true, false, 0,
            1, 0,2600, 0, false, false, 3, false,
            false, noEquipment);

    StudySpot leveringLounge = new StudySpot("Levering Lounge", true, true, false, 1,
            3, 730,2400, 0, true, false, 3, false,
            false, justProjector);

    StudySpot hutReadingRoom = new StudySpot("Hutzler Reading Room", false, false, false, 1,
            3, 0,2600, 0, false, false, 0, false,
            false, justPrinters);

    StudySpot beach = new StudySpot("The Beach", false, true, false, 0,
            1, 0,2600, 0, false, false, 3, false,
            false, noEquipment);

    StudySpot muddAtrium = new StudySpot("Mudd Atrium", false, true, true, 1,
            3, 0, 2600,0, false, false, 3, false,
            false, noEquipment);

    StudySpot brodyReadingRoom = new StudySpot("Brody Reading Room", true, false, false, 1,
            3, 1000,1700, 1, false, true, 0, false,
            false, noEquipment);


    StudySpot[] studySpotsList = {brodyAtrium, mseMLevel, mseALevel, mseBLevel, mseCLevel, mseDLevel,
            visualizationStudio, mseStudyRooms, brodyStudyRooms, brodyCafe, brodyTerrace,
            leveringLounge, hutReadingRoom, beach, muddAtrium, brodyReadingRoom};

    private RecyclerView locationsRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        locationsRecView = findViewById(R.id.locationsRecView);

        ArrayList<Location> locations = new ArrayList<>();
        locations.add(brodyAtrium);
        locations.add(brodyCafe);
        locations.add(brodyTerrace);
        locations.add(brodyReadingRoom);
        locations.add(brodyStudyRooms);

        LocationsRecViewAdapter adapter = new LocationsRecViewAdapter(this);
        adapter.setLocations(locations);

        locationsRecView.setAdapter(adapter);
        locationsRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    }
}