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


public class OptionsFragment extends Fragment {//implements RadioGroup.OnCheckedChangeListener{

    private Settings OptSettings;
    private boolean onStart;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OptSettings = Settings.getInstance();
        onStart = true;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View parentView = inflater.inflate(R.layout.fragment_options, container, false);

        onStart = true;
        RadioGroup HighPin = parentView.findViewById(R.id.radioHiPinGroup);
        RadioGroup MarkStyle = parentView.findViewById(R.id.radioMarkGroup);

        HighPin.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (!onStart)
                    switch(group.getCheckedRadioButtonId()) {
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
                        default:
                            break;
                    }
            }
        });

        MarkStyle.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (!onStart)
                    switch(group.getCheckedRadioButtonId()) {
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
                        default:
                            break;
                    }
            }
        });

        if (OptSettings.IsPin)
            HighPin.check(R.id.Pin);
        else
            HighPin.check(R.id.Highlight);

        if (OptSettings.DisplayAll)
            MarkStyle.check(R.id.MarkAll);
        else
            MarkStyle.check(R.id.MarkOne);

        onStart = false;

        return parentView;
    }

/*
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        if (!onStart)
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
                default:
                    break;
            }
    }
*/
}




