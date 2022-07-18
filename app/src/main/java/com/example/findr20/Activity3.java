package com.example.findr20;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.FocusFinder;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Activity3 extends AppCompatActivity {

    private final int[] images = {R.drawable.beach, R.drawable.brody_atrium, R.drawable.brody_cafe, R.drawable.brody_terrace, R.drawable.brody_reading_room,
            R.drawable.brody_study_room, R.drawable.hutzler_reading_room, R.drawable.levering_lounge, R.drawable.msel_a_level, R.drawable.msel_b_level,
            R.drawable.msel_c_level, R.drawable.msel_d_level, R.drawable.msel_m_level, R.drawable.msel_study_rooms, R.drawable.mudd_atrium, R.drawable.visualization_studio};

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
            false, 3, false, false, allButComputers, R.drawable.brody_atrium);

    StudySpot mseMLevel = new StudySpot("MSE M-Level", true, true, false, 2,
            2, 800,2600, 0, false,
            false, 3, false, true, allButProjectors, R.drawable.msel_m_level);

    StudySpot mseALevel = new StudySpot("MSE A-Level", true, true, false, 1,
            1, 800,2600, 0, true,
            false, 3, false, false, computersAndWhiteboards, R.drawable.msel_a_level);

    StudySpot mseBLevel = new StudySpot("MSE B-Level", true, true, false, 2,
            1, 800,2600, 1, false,
            false, 2, false, false, noEquipment, R.drawable.msel_b_level);

    StudySpot mseCLevel = new StudySpot("MSE C-Level", true, true, false, 1,
            1, 800,2600, 1, false,
            false, 1, true, false, noEquipment, R.drawable.msel_c_level);

    StudySpot mseDLevel = new StudySpot("MSE D-Level", true, false, false, 1,
            1, 800,2600, 2, false,
            false, 0, true, false, noEquipment, R.drawable.msel_d_level);

    StudySpot visualizationStudio = new StudySpot("A-Level Visualization Studio", true, true, false, 1,
            1, 800,2600, 2, false,
            false, 3, false, false, whiteboardAndProjector, R.drawable.visualization_studio);

    StudySpot mseStudyRooms = new StudySpot("MSE Study Rooms", true, true, false, 1,
            1, 800,2600, 3, false,
            true, 3, true, false, justWhiteboard, R.drawable.msel_study_rooms);

    StudySpot brodyStudyRooms = new StudySpot("Brody Study Rooms", true, true, false, 1,
            1, 800,2600, 3, false,
            true, 3, true, false, whiteboardAndProjector, R.drawable.brody_study_room);

    StudySpot brodyCafe = new StudySpot("Brody Cafe", false, true, true, 0,
            1, 830,1600, 0, false,
            false, 3, false, false, noEquipment, R.drawable.brody_cafe);

    StudySpot brodyTerrace = new StudySpot("Brody Terrace", false, true, false, 0,
            1, 0,2600, 0, false, false, 3, false,
            false, noEquipment, R.drawable.brody_terrace);

    StudySpot leveringLounge = new StudySpot("Levering Lounge", true, true, false, 1,
            3, 730,2400, 0, true, false, 3, false,
            false, justProjector, R.drawable.levering_lounge);

    StudySpot hutReadingRoom = new StudySpot("Hutzler Reading Room", false, false, false, 1,
            3, 0,2600, 0, false, false, 0, false,
            false, justPrinters, R.drawable.hutzler_reading_room);

    StudySpot beach = new StudySpot("The Beach", false, true, false, 0,
            1, 0,2600, 0, false, false, 3, false,
            false, noEquipment, R.drawable.beach);

    StudySpot muddAtrium = new StudySpot("Mudd Atrium", false, true, true, 1,
            3, 0, 2600,0, false, false, 3, false,
            false, noEquipment, R.drawable.mudd_atrium);

    StudySpot brodyReadingRoom = new StudySpot("Brody Reading Room", true, false, false, 1,
            3, 1000,1700, 1, false, true, 0, false,
            false, noEquipment, R.drawable.brody_reading_room);


    StudySpot[] studySpotsList = {brodyAtrium, mseMLevel, mseALevel, mseBLevel, mseCLevel, mseDLevel,
            visualizationStudio, mseStudyRooms, brodyStudyRooms, brodyCafe, brodyTerrace,
            leveringLounge, hutReadingRoom, beach, muddAtrium, brodyReadingRoom};

    private RecyclerView locationsRecView;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        locationsRecView = findViewById(R.id.locationsRecView);

        Findr findr = new Findr();
        findr.setDesiredPrivacy(Activity2.getDesiredPrivacy());
        findr.setDesiredVolume(Activity2.getDesiredVolume());
        findr.setFoodDesired(Activity2.isFoodDesired());
        findr.setEquipmentDesired(Activity2.getEquipmentDesired());

        StudySpot[] top5 = findr.rankSpots();

        ArrayList<Location> locations = new ArrayList<>();
        locations.add(top5[0]);
        locations.add(top5[1]);
        locations.add(top5[2]);
        locations.add(top5[3]);
        locations.add(top5[4]);

        LocationsRecViewAdapter adapter = new LocationsRecViewAdapter(this, images);
        adapter.setLocations(locations);

        locationsRecView.setAdapter(adapter);
        locationsRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


    }

    public class Findr {

        //public double score;
        boolean foodDesired; // want food? if yes = true
        int desiredHygiene; // 0 = no bathroom, 1 = bathroom nearby,
        // 2 = bathroom + hygiene products available
        int desiredSeating; // 0 = no seating, 1 = desk chairs/basic seating,
        // 2 = comfy (lounge) chairs, 3 = couches, extremely comfortable
        int desiredPrivacy; // 0 = no privacy, 1 = desk cubicles, 2 = like 1,
        // but nobody is gonna bother you, 3 = locked doors
        //boolean vendingFoodDesired; // true if you want vending machine snacks
        // boolean wantToRsvp; // do you want to have to reserve it?
        int desiredVolume; // 0 = NO TALKING, 1 = very quiet, whisper only, 2 = convos allowed,
        // 3 = CONVOS WILL BE HAD HERE
        boolean claustrophobicDesired; // do you want to be in an enclosed space?
        //boolean vendingSuppliesDesired; // do you want stationery vending? pencils, pens, etc
        boolean[] equipmentDesired; // {computer, projector, whiteboard, printer}
        int time;

        @RequiresApi(api = Build.VERSION_CODES.O)
        public Findr(){
            time = (LocalTime.now().getHour() * 100) + LocalTime.now().getMinute(); //local time
            if (time < 200) {
                time += 2400;
            }
        }

        public boolean isFoodDesired() {
            return foodDesired;
        }
        public void setFoodDesired(boolean foodDesired) {
            this.foodDesired = foodDesired;
        }
        public int getDesiredHygiene() {
            return desiredHygiene;
        }
        public void setDesiredHygiene(int desiredHygiene) {
            this.desiredHygiene = desiredHygiene;
        }
        public int getDesiredSeating() {
            return desiredSeating;
        }
        public void setDesiredSeating(int desiredSeating) {
            this.desiredSeating = desiredSeating;
        }
        public int getDesiredPrivacy() {
            return desiredPrivacy;
        }
        public void setDesiredPrivacy(int desiredPrivacy) {
            this.desiredPrivacy = desiredPrivacy;
        }
        public int getDesiredVolume() {
            return desiredVolume;
        }
        public void setDesiredVolume(int desiredVolume) {
            this.desiredVolume = desiredVolume;
        }
        public boolean[] getEquipmentDesired() {
            return equipmentDesired;
        }
        public void setEquipmentDesired(boolean[] equipmentDesired) {
            this.equipmentDesired = equipmentDesired;
        }
        public int getTime() {
            return time;
        }

        public double calculateScore(StudySpot studySpot) {

            double Score = 100;

            // if studySpot is closed, returns a score of -1, which automatically removes it from reccs

            if (!((this.time >= studySpot.openTime) && (this.time <= studySpot.closingTime))) {
                return -1;
            } else if (studySpot.closingTime - this.time < 200) {
                Score -= ((double) 1000 / (studySpot.closingTime - this.time));
            }


            //volume score mod
            Score -= 20 * Math.abs(this.desiredVolume - studySpot.getVolume());
            //equipment score mod
            for (int i = 0; i < equipmentDesired.length; i++){
                if (this.equipmentDesired[i] && !studySpot.equipment[i]) {
                    Score -= 35;
                }
            }
            //privacy score mod
            Score -= 17 * Math.abs(this.desiredPrivacy - studySpot.getPrivacy());
            //seating score mod
            Score -= 12 * Math.abs(this.desiredSeating - studySpot.getSeating());
            //food score mod
            if (this.foodDesired) {
                if (!studySpot.isFoodAllowed()){
                    Score -= 30;
                } else {
                    if (studySpot.isVendingFood()) {
                        Score += 13;
                    }
                    if (studySpot.isFoodSold()) {
                        Score += 18;
                    }
                    if (studySpot.isVendingFood() && studySpot.isFoodSold()) {
                        Score+= 7;
                    }
                }
            }
            //rsvp score mod
            if (!studySpot.isRsvp()) {
                Score += 15;
            }
            //jcard score mod
            if (!studySpot.isjCardReq()) {
                Score += 10;
            }
            //hygiene score mod
            if (studySpot.getHygiene() == 0) {
                Score -= 5;
            } else {
                Score += 5 * studySpot.getHygiene();
            }


            return Score;
        }

        public StudySpot[] rankSpots() {

            double[] ranks = new double[studySpotsList.length];

            for (int i = 0; i < ranks.length; i++) {
                ranks[i] = this.calculateScore(studySpotsList[i]);
            }



            double min = ranks[0];
            int index = 0;
            for (int i = 0 ; i < ranks.length; i++) {
                if (min >= ranks[i]) {
                    min = ranks[i];
                    index = i;
                }
            }

            int[] top5_ind = {index, index, index, index, index};

            for (int i = 0; i < ranks.length; i++) {
                if(ranks[i] > ranks[top5_ind[0]]) {
                    top5_ind[0] = i;
                } else if (ranks[i] > ranks[top5_ind[1]]) {
                    top5_ind[1] = i;
                } else if (ranks[i] > ranks[top5_ind[2]]) {
                    top5_ind[2] = i;
                } else if (ranks[i] > ranks[top5_ind[3]]) {
                    top5_ind[3] = i;
                } else if (ranks[i] > ranks[top5_ind[4]]) {
                    top5_ind[4] = i;
                }
            }

            StudySpot[] top5 = new StudySpot[5];

            for (int i = 0; i < top5.length; i++) {
                top5[i] = studySpotsList[top5_ind[i]];
            }

            return top5;
        }


    }
}