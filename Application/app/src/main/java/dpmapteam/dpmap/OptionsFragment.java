package dpmapteam.dpmap;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class OptionsFragment extends Fragment {

    private Settings OptSettings;

    public void onRadioButtonClicked(View v)  {
        //this will tell you when an option is selected.
        boolean checked = ((RadioButton) v).isChecked();

        switch(v.getId())
        {
            case R.id.Highlight:
                if(checked)
                    OptSettings.IsPin = false;
                break;
            case R.id.Pin:
                if(checked)
                    OptSettings.IsPin = true;
                break;
            case R.id.MarkOne:
                if(checked)
                    OptSettings.DisplayAll = false;
                break;
            case R.id.MarkAll:
                if(checked)
                    OptSettings.DisplayAll = true;
                break;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OptSettings = Settings.getInstance();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View parentView = inflater.inflate(R.layout.fragment_options, container, false);

        RadioGroup HighPin = parentView.findViewById(R.id.radioHiPinGroup);
        RadioGroup MarkStyle = parentView.findViewById(R.id.radioMarkGroup);

        RadioButton pinopt = parentView.findViewById(R.id.Pin);
        pinopt.setOnClickListener();

        if (OptSettings.IsPin)
            HighPin.check(R.id.Pin);
        else
            HighPin.check(R.id.Highlight);

        if (OptSettings.DisplayAll)
            MarkStyle.check(R.id.MarkOne);
        else
            MarkStyle.check(R.id.MarkOne);

        return parentView;
    }

}




