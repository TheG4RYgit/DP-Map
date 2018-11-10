package dpmapteam.dpmap;

import java.util.ArrayList;

public class ClassList {
    private static ClassList CLInst = null;
    public ArrayList<Class> list;

    private ClassList(){}

    public static ClassList getInstance()
    {
        if (CLInst == null)
        {
            CLInst = new ClassList();
        }
        return CLInst;
    }
}
