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
import android.widget.Toast;


//if you're adding the sidebar to your fragment you need the
// implements MyRecyclerViewAdapter.ItemClickListener  part of this class declaration.
public class SidebarFragment extends Fragment implements MyRecyclerViewAdapter.ItemClickListener {

    //NEEDED FOR RECYCLERVIEW!******stuff for RecyclerView below.
    MyRecyclerViewAdapter adapter;
    private ClassList classRooms;
    private Settings options;
    //NEEDED FOR RECYCLERVIEW!*****stuff for RecyclerView above.

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        classRooms = ClassList.getInstance();//you will need this line to initialize your instance of the singleton.
        options = Settings.getInstance();
    }

    //NEEDED FOR RECYCLERVIEW!******stuff for RecyclerView below.
    //this method is an interface to the Adapter class
    @Override
    public void onItemClick(View view, int position) {
        //this bit is just to make sure it works.
        //if (isAdded())
          //  Toast.makeText(getActivity().getApplicationContext(), "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
        //this method will tell you what was clicked on in the sidebar.
        classRooms.selectedClass = position;
        options.SidebarRequestRedraw = true;
        options.SidebarWasOpen = false; //this is not true, but necessary to prevent bad recursive behavior.
        getActivity().onBackPressed();
    }
    //NEEDED FOR RECYCLERVIEW!*****stuff for RecyclerView above.




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View parentView = inflater.inflate(R.layout.fragment_sidebar, container, false);

        //NEEDED FOR RECYCLERVIEW!****************stuff for RecyclerView below.
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
        //NEEDED FOR RECYCLERVIEW!*****************stuff for RecyclerView above.

        /*
         *this is a good spot to set up click listeners for your buttons or text boxes and whatnot.
         */

        //return the view like we're supposed to.
        return parentView;
    }

}
