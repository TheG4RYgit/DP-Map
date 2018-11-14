package dpmapteam.dpmap;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class addFragment extends Application {



    private static addFragment cInstance = null;

    @Override
    public void onCreate() {
        super.onCreate();
        //set singleton
        temp_class.hall = hall_spinner.getArguments().getChar()
        int tmep_room_number = getArguments().getString(ARG_PARAM2);
        if()
        Class temp_class = new Class();



        cInstance = this;


        public static addFragment getInstance(){
            return cInstance;
        }

    }

}
