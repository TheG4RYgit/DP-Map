package dpmapteam.dpmap;

public class Settings {
    private static Settings SettingsInstance = null;
    public boolean IsPin;
    public boolean DisplayAll;

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
}
