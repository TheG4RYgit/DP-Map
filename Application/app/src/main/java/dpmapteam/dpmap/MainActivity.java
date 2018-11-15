package dpmapteam.dpmap;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private boolean SidebarWasOpen = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ClassList CList;
        CList = ClassList.getInstance();
        Settings opt;
        opt = Settings.getInstance();

        ImageButton AddButton = (ImageButton) findViewById(R.id.addbut);
        AddButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SidebarWasOpen = false;
                Fragment addfrag = new AddFragment();
                getSupportFragmentManager().popBackStack();
                getSupportFragmentManager().beginTransaction().replace(R.id.add_fragment_frame, addfrag,
                        addfrag.getClass().getSimpleName()).addToBackStack(null).commit();
            }
        });
        ImageButton OptionsButton = (ImageButton) findViewById(R.id.setbut);
        OptionsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SidebarWasOpen = false;
                Fragment optfrag = new OptionsFragment();
                getSupportFragmentManager().popBackStack();
                getSupportFragmentManager().beginTransaction().replace(R.id.opt_fragment_frame, optfrag,
                        optfrag.getClass().getSimpleName()).addToBackStack(null).commit();
            }
        });
        ImageButton RemoveButton = (ImageButton) findViewById(R.id.rmvbut);
        RemoveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SidebarWasOpen = false;
                Fragment rmvfrag = new RemoveFragment();
                getSupportFragmentManager().popBackStack();
                getSupportFragmentManager().beginTransaction().replace(R.id.rmv_fragment_frame, rmvfrag,
                        rmvfrag.getClass().getSimpleName()).addToBackStack(null).commit();
            }
        });
        ImageButton SidebarButton = (ImageButton) findViewById(R.id.hambut);
        SidebarButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
               if (!SidebarWasOpen) {
                   SidebarWasOpen = true;
                    Fragment sbrfrag = new SidebarFragment();
                    getSupportFragmentManager().popBackStack();
                    getSupportFragmentManager().beginTransaction().replace(R.id.sbr_fragment_frame, sbrfrag,
                            sbrfrag.getClass().getSimpleName()).addToBackStack(null).commit();
               }
               else {
                   SidebarWasOpen = false;
                   onBackPressed();
               }
            }
        });

        //debug code
        //CList.list.add(new Class('B', 185));
        //CList.list.add(new Class('B', 190));
        //CList.selectedClass = 1;
        //opt.DisplayAll = true;
        FrameLayout CLayout = (FrameLayout) findViewById(R.id.MapLayout);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                                                    FrameLayout.LayoutParams.MATCH_PARENT,
                                                    FrameLayout.LayoutParams.MATCH_PARENT);
        Resources res = getResources();
        if (opt.DisplayAll)
        {
            for (int i = 0; i < CList.list.size(); i++)
            {
                int room = CList.list.get(i).getRoom_number();
                char block = CList.list.get(i).getHall();
                ImageView temp = new ImageView(this);
                int resID;
                String name;
                if (opt.IsPin)
                {
                    name = Character.toLowerCase(block) + Integer.toString(room) + "pin";
                    resID = res.getIdentifier(name, "drawable", getPackageName());
                }
                else
                {
                    name = Character.toLowerCase(block) + Integer.toString(room) + "hi";
                    resID = res.getIdentifier(name, "drawable", getPackageName());
                }
                temp.setImageResource(resID);
                CLayout.addView(temp, params);
            }
        }
        else if ((CList.list.size() != 0) && (CList.selectedClass != -1))
        {
            int room = CList.list.get(CList.selectedClass).getRoom_number();
            char block = CList.list.get(CList.selectedClass).getHall();
            ImageView temp = new ImageView(this);
            int resID;
            String name;
            if (opt.IsPin)
            {
                name = Character.toLowerCase(block) + Integer.toString(room) + "pin";
                resID = res.getIdentifier(name, "drawable", getPackageName());
            }
            else
            {
                name = Character.toLowerCase(block) + Integer.toString(room) + "hi";
                resID = res.getIdentifier(name, "drawable", getPackageName());
            }
            temp.setImageResource(resID);
            CLayout.addView(temp, params);
        }
    }
    public void onBackPressed()
    {
        super.onBackPressed();
        setContentView(R.layout.activity_main);

        ImageButton AddButton = (ImageButton) findViewById(R.id.addbut);
        AddButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Fragment addfrag = new AddFragment();
                getSupportFragmentManager().popBackStack();
                getSupportFragmentManager().beginTransaction().replace(R.id.add_fragment_frame, addfrag,
                        addfrag.getClass().getSimpleName()).addToBackStack(null).commit();
            }
        });
        ImageButton OptionsButton = (ImageButton) findViewById(R.id.setbut);
        OptionsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Fragment optfrag = new OptionsFragment();
                getSupportFragmentManager().popBackStack();
                getSupportFragmentManager().beginTransaction().replace(R.id.opt_fragment_frame, optfrag,
                        optfrag.getClass().getSimpleName()).addToBackStack(null).commit();
            }
        });
        ImageButton RemoveButton = (ImageButton) findViewById(R.id.rmvbut);
        RemoveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Fragment rmvfrag = new RemoveFragment();
                getSupportFragmentManager().popBackStack();
                getSupportFragmentManager().beginTransaction().replace(R.id.rmv_fragment_frame, rmvfrag,
                        rmvfrag.getClass().getSimpleName()).addToBackStack(null).commit();
            }
        });
        ImageButton SidebarButton = (ImageButton) findViewById(R.id.hambut);
        SidebarButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!SidebarWasOpen) {
                    SidebarWasOpen = true;
                    Fragment sbrfrag = new SidebarFragment();
                    getSupportFragmentManager().popBackStack();
                    getSupportFragmentManager().beginTransaction().replace(R.id.sbr_fragment_frame, sbrfrag,
                            sbrfrag.getClass().getSimpleName()).addToBackStack(null).commit();
                }
                else {
                    SidebarWasOpen = false;
                    onBackPressed();
                }
            }
        });

        ClassList CList = ClassList.getInstance();
        Settings opt = Settings.getInstance();
        CList.selectedClass = 0;
        FrameLayout CLayout = (FrameLayout) findViewById(R.id.MapLayout);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT);
        CLayout.removeAllViewsInLayout();
        Resources res = getResources();
        if (opt.DisplayAll)
        {
            for (int i = 0; i < CList.list.size(); i++)
            {
                int room = CList.list.get(i).getRoom_number();
                char block = CList.list.get(i).getHall();
                ImageView temp = new ImageView(this);
                int resID;
                String name;
                if (opt.IsPin)
                {
                    name = Character.toLowerCase(block) + Integer.toString(room) + "pin";
                    resID = res.getIdentifier(name, "drawable", getPackageName());
                }
                else
                {
                    name = Character.toLowerCase(block) + Integer.toString(room) + "hi";
                    resID = res.getIdentifier(name, "drawable", getPackageName());
                }
                temp.setImageResource(resID);
                CLayout.addView(temp, params);
            }
        }
        else if ((CList.list.size() != 0) && (CList.selectedClass != -1)) {
            int room = CList.list.get(CList.selectedClass).getRoom_number();
            char block = CList.list.get(CList.selectedClass).getHall();
            ImageView temp = new ImageView(this);
            int resID;
            String name;
            if (opt.IsPin) {
                name = Character.toLowerCase(block) + Integer.toString(room) + "pin";
                resID = res.getIdentifier(name, "drawable", getPackageName());
            } else {
                name = Character.toLowerCase(block) + Integer.toString(room) + "hi";
                resID = res.getIdentifier(name, "drawable", getPackageName());
            }
            temp.setImageResource(resID);
            CLayout.addView(temp, params);
        }
    }
}
