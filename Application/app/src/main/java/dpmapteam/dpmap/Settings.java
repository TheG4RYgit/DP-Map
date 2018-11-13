package dpmapteam.dpmap;

import android.view.View;
import android.widget.CheckBox;

import java.util.ArrayList;

public class Settings {
    private static Settings SettingsInstance = null;
    public boolean IsPin;
    public boolean DisplayAll;
    ArrayList<String> OptionList = new ArrayList<String>();



    private Settings()
    {
        IsPin = false;
        DisplayAll = false;
    }

    public static Settings getInstance()
    {
        if (SettingsInstance == null)
        {
            SettingsInstance = new Settings();
        }
        return SettingsInstance;
    }

   /**
    public void selectOption(view View)
    {
        boolean checked = ((CheckBox) android.view.View).isChecked();
            switch (android.view.View.getId())
            {
                case : R.id.HighPin1:
                {


                    OptionList.add("Highlight");
                    if(checked)
                    {
                        OptionList.remove("Pin")
                    }
                }
                case : R.id.HighPin2:
                {


                    OptionList.add("Pin");
                    if(checked)
                    {
                        OptionList.remove("Highlight")
                    }
                }
                case : R.id.HighPin3:
                {


                    OptionList.add("All at once");
                    if(checked)
                    {
                        OptionList.remove("One at a time")
                    }
                }
                case : R.id.HighPin4:
                {


                    OptionList.add("One at a time");
                    if(checked)
                    {
                        OptionList.remove("All at once")
                    }
                }
            }
    }
    */
}
