package dpmapteam.dpmap;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class AddFragment extends Fragment implements MyRecyclerViewAdapter.ItemClickListener, AdapterView.OnItemSelectedListener {
    MyRecyclerViewAdapter adapter;
    private ClassList classRooms;
    char hall = 'z';

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        classRooms = ClassList.getInstance();
    }


    //stuff for RecyclerView below.
    //this method is an interface to the Adapter class
    @Override
    public void onItemClick(View view, int position) {
    }
    public void onItemSelected(AdapterView<?> parent, View view,  //for the spinner
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
        CharSequence temp = parent.getItemAtPosition(pos).toString();
        hall = temp.charAt(0);

    }

    public void onNothingSelected(AdapterView<?> parent) {    //for the spinner
        // Another interface callback
    }


    //stuff for RecyclerView above.

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View parentView = inflater.inflate(R.layout.fragment_add, container, false);


        // find id of actual recyclerView layout
        RecyclerView recyclerView = parentView.findViewById(R.id.rv_sidebar);
        //set up a layout manager for it.
        recyclerView.setLayoutManager(new LinearLayoutManager( getActivity().getApplicationContext() ) );
        //this is just an optimization option.
        recyclerView.setHasFixedSize(true);
        //set up our custom adaptor
        adapter = new MyRecyclerViewAdapter(getActivity().getApplicationContext());
        adapter.setClickListener(this);
        //tell recyclerView to use our adaptor.
        recyclerView.setAdapter(adapter);
        //set up spinner
        Spinner spinner = (Spinner) parentView.findViewById(R.id.hall_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> spadapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),
                R.array.class_halls, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        spadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(spadapter);
        spinner.setOnItemSelectedListener(this);

        Button addButton = (Button) parentView.findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                    //get EditText
                    EditText add_text = parentView.findViewById(R.id.roomInput);
                    String temp_room = add_text.getText().toString();
                    //convert to int
                    int room_num = Integer.parseInt(temp_room);
                    //create class and add to back of list
                    if(!(temp_room.isEmpty()) && hall != 'z') {
                        Class temp_class = new Class(hall, room_num);
                        if(VerifyClass(temp_class))
                        {
                            if (!Contains(temp_class)) {
                                classRooms.list.add(temp_class);
                                //hall = 'z';
                                adapter.notifyDataInsertion();
                            }
                            else
                                Toast.makeText(getActivity().getApplicationContext(), "Class is already in list.", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(getActivity().getApplicationContext(), "Unknown Class.", Toast.LENGTH_SHORT).show();
                    }
                    //if nothing is in edit text
                    else{
                       Toast.makeText(getActivity().getApplicationContext(), "Failed to add string.", Toast.LENGTH_SHORT).show();
                    }
            }
        });

        //return the view like we're supposed to.
        return parentView;
    }

    private boolean Contains(Class room)
    {
        for (int i = 0; i < classRooms.list.size(); i++){
            if (classRooms.list.get(i).isEqual(room))
                return true;
        }
        return false;
    }

    private boolean VerifyClass(Class classroom)
    {
        char c = classroom.getHall();
        int room = classroom.getRoom_number();

        switch(c)
        {
            case 'A':
                break;
            case 'B': //140 142 155 157 158 185 190 192
                switch (room)
                {
                    case 140:
                    case 142:
                    case 155:
                    case 157:
                    case 158:
                    case 185:
                    case 190:
                    case 192:
                        return true;
                    default:
                        break;
                }
            case 'C':
            case 'D':
            case 'F':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            default:
                break;
        }
        return false;
    }

}



