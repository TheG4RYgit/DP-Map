package dpmapteam.dpmap;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;



public class OptionsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
   //     return super.onCreateView(inflater, container, savedInstanceState);


        View thisView = inflater.inflate(R.layout.fragment_options, container, false);

        CheckBox ifCheck = thisView.findViewById(R.id.HighPin1);

        return thisView;

    }




}

//get function for OnCreateView