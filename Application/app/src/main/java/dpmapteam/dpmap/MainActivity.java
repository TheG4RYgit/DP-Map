package dpmapteam.dpmap;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                Fragment sbrfrag = new SidebarFragment();
                getSupportFragmentManager().popBackStack();
                getSupportFragmentManager().beginTransaction().replace(R.id.sbr_fragment_frame, sbrfrag,
                        sbrfrag.getClass().getSimpleName()).addToBackStack(null).commit();
            }
        });
    }

}
