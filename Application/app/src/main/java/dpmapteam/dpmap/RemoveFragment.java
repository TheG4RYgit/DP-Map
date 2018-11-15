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
import android.widget.TextView;
import android.widget.Toast;


public class RemoveFragment extends Fragment implements MyRecyclerViewAdapter.ItemClickListener {

    MyRecyclerViewAdapter adapter;
    private ClassList classRooms;
    private Settings options;
    private int removeIndex;
    private boolean onDeck;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        classRooms = ClassList.getInstance();
        options = Settings.getInstance();
        removeIndex = -1;
        onDeck = false;
    }

    //stuff for RecyclerView below.
    //this method is an interface to the Adapter class
    @Override
    public void onItemClick(View view, int position) {
        //this bit is just to make sure it works.
        if (isAdded())
            Toast.makeText(getActivity().getApplicationContext(), "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();

        removeIndex = position;
        onDeck = true;

        String temp = "Are you sure you want to remove " + adapter.getItem(position).getHall() +
                Integer.toString(adapter.getItem(position).getRoom_number()) + "?";
        TextView remove = getActivity().findViewById(R.id.remove_text);
        remove.setText(temp);
    }


    //stuff for RecyclerView above.

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View parentView = inflater.inflate(R.layout.fragment_remove, container, false);

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


        final TextView removerText = (TextView) parentView.findViewById(R.id.remove_text);
        removerText.setText(R.string.which_room);


        Button removeButton = (Button) parentView.findViewById(R.id.rmvButton);
        removeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (onDeck && removeIndex >= 0)
                {
                    if (removeIndex == classRooms.selectedClass)
                    {
                        classRooms.selectedClass = -1;
                        classRooms.list.remove(removeIndex);
                        adapter.notifyDataRemoval(removeIndex);
                        onDeck = false;
                        removeIndex = -1;
                        removerText.setText(R.string.removed);

                        options.RemoveRequestRedraw = true;
                        getActivity().onBackPressed();
                    }
                    else if (removeIndex > classRooms.selectedClass) {

                        classRooms.selectedClass -= 1;
                        classRooms.list.remove(removeIndex);
                        adapter.notifyDataRemoval(removeIndex);
                        onDeck = false;
                        removeIndex = -1;
                        removerText.setText(R.string.removed);
                    }

                }
                else{
                    Toast.makeText(getActivity().getApplicationContext(), "Please select a class.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button keepButton = (Button) parentView.findViewById(R.id.keepButton);
        keepButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (onDeck || removeIndex >= 0)
                {
                    onDeck = false;
                    removeIndex = -1;
                    removerText.setText(R.string.which_room);
                }
                else{
                    Toast.makeText(getActivity().getApplicationContext(), "Please select a class first.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //return the view like we're supposed to.
        return parentView;
    }

}
