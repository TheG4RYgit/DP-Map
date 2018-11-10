package dpmapteam.dpmap;

import android.content.Context;
import android.os.Bundle;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("dpmapteam.dpmap", appContext.getPackageName());

    }
}
public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creating a spinner for the hall
        Spinner class_spinner = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<Spinner> spinAdaprer = new ArrayAdapter<Spinner>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.class_halls));
        spinAdaprer.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        class_spinner.setAdapter(spinAdaprer);
    }
}
public class Class{//class for classes
    //properties
    private char hall;
    private int room_number;
    //constuctor
    public Class(char hall, int room_number) {
        this.hall = hall;
        this.room_number = room_number;
    }

    public char getHall() {
        return hall;
    }

    public int getRoom_number() {
        return room_number;
    }


}
