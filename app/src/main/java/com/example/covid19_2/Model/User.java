package com.example.covid19_2.Model;

import com.example.covid19_2.R;

import java.util.ArrayList;

public class User implements  IUser{
    private String name;

    public User(String name)
    {
        this.name = name;
    }
    @Override
    public String getString() {
        return name;
    }

    @Override
    public int isValid() {
        int symptomlist[] = {R.string.fever,R.string.body_pain,R.string.runny_nose,R.string.scratchy_throat,R.string.cough,R.string.tierdness};
        boolean flag = false;
        if(name.length()==0)
            return 0;

        for(int i=0;i<symptomlist.length;i++)
        {
            if(name==String.valueOf(symptomlist[i]))
            {
                flag=true;
                break;
            }
        }

        if(flag)
            return 0;

        return 2;
    }
}
