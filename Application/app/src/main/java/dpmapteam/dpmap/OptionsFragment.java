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


public class OptionsFragment extends Fragment implements RadioGroup.OnCheckedChangeListener{

    private Settings OptSettings;


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


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch(group.getCheckedRadioButtonId())
        {
            case R.id.Highlight:
                OptSettings.IsPin = false;
                break;
            case R.id.Pin:
                OptSettings.IsPin = true;
                break;
            case R.id.MarkOne:
                OptSettings.DisplayAll = false;
                break;
            case R.id.MarkAll:
                OptSettings.DisplayAll = true;
                break;
        }
    }

}




