package com.example.covid19_2.Controller;

import com.example.covid19_2.Model.User;
import com.example.covid19_2.View.IReportView;
//import com.example.covid19_2.View.ReportView;

import java.util.ArrayList;

public class SelectSymptoms implements ISelectSymptoms{
    IReportView viewrepo;

    public SelectSymptoms(IReportView viewrepo)
    {
        this.viewrepo = viewrepo;
    }
    @Override
    public boolean selectedSymptoms(ArrayList<String> symptomList) {
        User user = new User(symptomList.get(0));
        int validkey = user.isValid();
        if(validkey==0)
        {viewrepo.nameError("Please, Enter your Name");return false;}
        else if(validkey==2)
        {viewrepo.nameSuccess("Successfull");return true;}
        return true;
    }
}
