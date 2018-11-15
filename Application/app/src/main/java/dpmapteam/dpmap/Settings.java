package dpmapteam.dpmap;

import android.view.View;
import android.widget.CheckBox;

import java.util.ArrayList;

public class Settings {
    private static Settings SettingsInstance = null;
    public boolean IsPin;
    public boolean DisplayAll;
    public boolean SidebarRequestRedraw;
    public boolean SidebarWasOpen;
    public boolean OptionsWasOpen;
    public boolean RemoveRequestRedraw;

    private Settings()
    {
        IsPin = false;
        DisplayAll = false;
        SidebarWasOpen = false;
        SidebarRequestRedraw = false;
        OptionsWasOpen = false;
        RemoveRequestRedraw = false;
    }

    public static Settings getInstance()
    {
        if (SettingsInstance == null)
        {
            SettingsInstance = new Settings();
        }
        return SettingsInstance;
    }
}
