package com.example.findr20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class Activity2 extends AppCompatActivity {

    private Button submit;
    private CheckBox checkBoxComputers, checkBoxProjectors, checkBoxWhiteboards, checkBoxPrinters;
    private RadioGroup rgVolume, rgFood, rgPrivacy;

    boolean[] selectedEquipment;
    boolean[] noEquipment = {/*computers*/ false, /*projectors*/ false, /*whiteboards*/ false, /*printers*/ false};
    boolean[] justWhiteboard = {false, false, true, false};
    boolean[] whiteboardAndProjector = {false, true, true, false};
    boolean[] whiteboardAndPrinters = {false, false, true, true};
    boolean[] allButProjectors = {true, false, true, true};
    boolean[] justPrinters = {false, false, false, true};
    boolean[] computersAndWhiteboards = {true, false, true, false};
    boolean[] justProjector = {false, true, false, false}; //projector/monitor/tv
    boolean[] allButComputers = {false, true, true, true};
    boolean[] justComputers = {true, false, false ,false};

    private ArrayList<Boolean> equipment = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        submit = findViewById(R.id.buttonSubmit);
        checkBoxComputers = findViewById(R.id.checkboxComputer);
        checkBoxProjectors = findViewById(R.id.checkboxProjector);
        checkBoxWhiteboards = findViewById(R.id.checkboxWhiteboards);
        checkBoxPrinters = findViewById(R.id.checkboxPrinters);
        rgVolume = findViewById(R.id.rgVolume);
        rgFood = findViewById(R.id.rgFood);
        rgPrivacy = findViewById(R.id.rgPrivacy);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity3();
                selectedEquipment = compareEquipmentList(equipment);
                for(int i = 0; i < selectedEquipment.length; i++) {
                    System.out.println(Arrays.toString(selectedEquipment));
                }
            }
        });

        //Equipment Checkbox code
        equipment.add(false);
        equipment.add(false);
        equipment.add(false);
        equipment.add(false);

        checkBoxComputers.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    equipment.set(0, true);
                } else {
                    equipment.set(0, false);
                }
            }
        });

        checkBoxProjectors.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    equipment.set(1, true);
                } else {
                    equipment.set(1, false);
                }
            }
        });

        checkBoxWhiteboards.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    equipment.set(2, true);
                } else {
                    equipment.set(2, false);
                }
            }
        });

        checkBoxPrinters.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    equipment.set(3, true);
                } else {
                    equipment.set(3, false);
                }
            }
        });

        rgVolume.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rbNoVolume:
                        Toast.makeText(Activity2.this, "No Volume", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbVolume1:
                        Toast.makeText(Activity2.this, "Volume 1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbVolume2:
                        Toast.makeText(Activity2.this, "Volume 2", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbVolume3:
                        Toast.makeText(Activity2.this, "Volume 3", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });

        rgFood.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rbNo:
                        Toast.makeText(Activity2.this, "No", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbYes:
                        Toast.makeText(Activity2.this, "Yes", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });

        rgPrivacy.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rbNoPrivacy:
                        Toast.makeText(Activity2.this, "No Privacy", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbPrivacy1:
                        Toast.makeText(Activity2.this, "Privacy 1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbPrivacy2:
                        Toast.makeText(Activity2.this, "Privacy 2", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbPrivacy3:
                        Toast.makeText(Activity2.this, "Privacy 3", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });




    }
    public void openActivity3() {
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }

    public boolean[] compareEquipmentList(ArrayList<Boolean> equipment) {
        if (Arrays.asList(noEquipment).equals(equipment)) {
            return noEquipment;
        }
        if (Arrays.asList(justWhiteboard).equals(equipment)) {
            return justWhiteboard;
        }
        if (Arrays.asList(justPrinters).equals(equipment)) {
            return justPrinters;
        }
        if (Arrays.asList(justComputers).equals(equipment)) {
            return justComputers;
        }
        if (Arrays.asList(justProjector).equals(equipment)) {
            return justProjector;
        }
        if (Arrays.asList(whiteboardAndPrinters).equals(equipment)) {
            return whiteboardAndPrinters;
        }
        if (Arrays.asList(whiteboardAndProjector).equals(equipment)) {
            return whiteboardAndProjector;
        }
        if (Arrays.asList(allButProjectors).equals(equipment)) {
            return allButProjectors;
        }
        if (Arrays.asList(computersAndWhiteboards).equals(equipment)) {
            return computersAndWhiteboards;
        }
        if (Arrays.asList(allButComputers).equals(equipment)) {
            return allButComputers;
        }
        boolean[] equipmentArr = {equipment.get(0), equipment.get(1), equipment.get(2), equipment.get(3)};
        return equipmentArr;
    }
}