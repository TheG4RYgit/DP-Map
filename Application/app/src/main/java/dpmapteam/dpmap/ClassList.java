package dpmapteam.dpmap;

import java.util.ArrayList;

public class ClassList {
    private static ClassList CLInst = null;
    public ArrayList<Class> list;
    public int selectedClass;
    private ClassList(){
        selectedClass = -1; //to signify no class selected
        list = new ArrayList<Class>();
    }

    public static ClassList getInstance()
    {
        if (CLInst == null)
        {
            CLInst = new ClassList();
        }
        return CLInst;
    }
}
