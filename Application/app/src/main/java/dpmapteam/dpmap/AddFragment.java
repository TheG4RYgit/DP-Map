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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddFragment extends Fragment implements MyRecyclerViewAdapter.ItemClickListener {
    MyRecyclerViewAdapter adapter;
    private ClassList classRooms;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        classRooms = ClassList.getInstance();
    }


    //stuff for RecyclerView below.
    //this method is an interface to the Adapter class
    @Override
    public void onItemClick(View view, int position) {
        //this bit is just to make sure it works.
        if (isAdded())
            Toast.makeText(getActivity().getApplicationContext(), "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();

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

        Button addButton = (Button) parentView.findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                    //get EditText
                    EditText add_text = parentView.findViewById(R.id.roomInput);
                    String temp_room = add_text.getText().toString();
                    //set hall
                    char hall_letter = temp_room.charAt(0);
                    String room_txt;
                    //set room 1 num a time string
                    char tempc = temp_room.charAt(1);
                    room_txt = String.valueOf(tempc);
                    tempc = temp_room.charAt(2);
                    room_txt = room_txt + String.valueOf(tempc);
                    tempc = temp_room.charAt(3);
                    room_txt = room_txt + String.valueOf(tempc);
                    //convert to int
                    int room_num = Integer.parseInt(room_txt);
                    //create class and add to back of list
                    if(!room_txt.isEmpty()) {
                        Class temp_class = new Class(hall_letter, room_num);
                        classRooms.list.add(temp_class);
                        adapter.notifyDataInsertion();
                    }
                    //if nothing is in edit text
                    else{
                       Toast.makeText(getActivity().getApplicationContext(), "failed to add string.", Toast.LENGTH_SHORT).show();
                    }
            }
        });

        //return the view like we're supposed to.
        return parentView;
    }

}



