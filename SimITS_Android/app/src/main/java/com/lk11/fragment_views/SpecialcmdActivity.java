package com.lk11.fragment_views;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;

import com.lk11.simits.R;

import java.util.ArrayList;

public class SpecialcmdActivity extends Fragment {

    private View rootView;

    private EnabledGroup realTime1Group;
    private EnabledGroup realTime2Group;
    private EnabledGroup timeTickLeftGroup;
    private EnabledGroup ppcControlGroup;
    private EnabledGroup spillBackGroup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootview = inflater.inflate(R.layout.activity_specialcmd,container, false);
        rootView = rootview;

        onInitialize();
        return rootview;
    }

    private void onInitialize(){
        setRealTime1Group();
        setRealTime2Group();
        setTimeTickLeftGroup();

        setPPCControl();
        setSpillBack();
    }

    private void setRealTime1Group(){
        realTime1Group = new EnabledGroup();

        CheckBox realTimeCheck = (CheckBox)rootView.findViewById(R.id.realTime1_Checkbox_Specialcmd);
        realTime1Group.setEnabledCheckbox(realTimeCheck);

        EditText realTimeEdit = (EditText)rootView.findViewById(R.id.realTime1_Edit_Specialcmd);
        realTime1Group.addView(realTimeEdit);
    }

    private void setRealTime2Group(){
        realTime2Group = new EnabledGroup();

        CheckBox realTimeCheck = (CheckBox)rootView.findViewById(R.id.realTime2_Checkbox_Specialcmd);
        realTime2Group.setEnabledCheckbox(realTimeCheck);

        EditText realTimeEdit = (EditText)rootView.findViewById(R.id.realTime2_Edit_Specialcmd);
        realTime2Group.addView(realTimeEdit);
    }

    private void setTimeTickLeftGroup(){
        timeTickLeftGroup = new EnabledGroup();

        CheckBox timeTickLeftCheck = (CheckBox)rootView.findViewById(R.id.timetickleft_Checkbox_Specialcmd);
        timeTickLeftGroup.setEnabledCheckbox(timeTickLeftCheck);

        EditText timeTickLeftEdit = (EditText)rootView.findViewById(R.id.timetickleft_Edit_Specialcmd);
        timeTickLeftGroup.addView(timeTickLeftEdit);
    }

    private void setPPCControl(){
        ppcControlGroup = new EnabledGroup();

        CheckBox ppcCtrCheck = (CheckBox)rootView.findViewById(R.id.ppcCtr_Checkbox_Specialcmd);
        ppcControlGroup.setEnabledCheckbox(ppcCtrCheck);

        Spinner ppcCtrSpinner = (Spinner)rootView.findViewById(R.id.ppcCtr_Spinner_Specialcmd);
        ppcControlGroup.addView(ppcCtrSpinner);

        EditText ppcCtrEdit;
        ppcCtrEdit = (EditText)rootView.findViewById(R.id.ppcCtr1_Edit_Specialcmd);
        ppcControlGroup.addView(ppcCtrEdit);
        ppcCtrEdit = (EditText)rootView.findViewById(R.id.ppcCtr2_Edit_Specialcmd);
        ppcControlGroup.addView(ppcCtrEdit);
    }

    private void setSpillBack(){
        spillBackGroup = new EnabledGroup();

        CheckBox spillBackCheck = (CheckBox)rootView.findViewById(R.id.spillBack_Checkbox_Specialcmd);
        spillBackGroup.setEnabledCheckbox(spillBackCheck);

        Spinner spillBackSpinner = (Spinner)rootView.findViewById(R.id.spillBack_Spinner_Specialcmd);
        spillBackGroup.addView(spillBackSpinner);

        EditText spillBackEdit;
        spillBackEdit = (EditText)rootView.findViewById(R.id.spillBack1_Edit_Specialcmd);
        spillBackGroup.addView(spillBackEdit);
        spillBackEdit = (EditText)rootView.findViewById(R.id.spillBack2_Edit_Specialcmd);
        spillBackGroup.addView(spillBackEdit);
    }

    class EnabledGroup {

        private ArrayList<View> arrayList;
        private CheckBox enabledCheckbox = null;

        public EnabledGroup(){
            arrayList = new ArrayList<View>();
        }

        public void setEnabledCheckbox(CheckBox checkbox){
            this.enabledCheckbox = checkbox;
            setEnabled(enabledCheckbox.isChecked());
            this.enabledCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                    setEnabled(isChecked);
                }
            });
        }

        public void addView(View obj){
            arrayList.add(obj);
            if (enabledCheckbox != null) {
                obj.setEnabled(enabledCheckbox.isChecked());
            }
        }

        private void setEnabled(boolean isChecked){
            for(int i=0; i < arrayList.size(); i++){
                arrayList.get(i).setEnabled(isChecked);
            }
        }

    }

}
