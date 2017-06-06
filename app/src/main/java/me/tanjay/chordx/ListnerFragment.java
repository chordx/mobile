package me.tanjay.chordx;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListnerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListnerFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View view;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public ListnerFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ListnerFragment newInstance() {
        ListnerFragment fragment = new ListnerFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_listner, container, false);
        final Button btn = (Button) view.findViewById(R.id.listning);
        btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    btn.setBackground(getActivity().getDrawable(R.drawable.round_button_pressed));
                }else if(event.getAction() == MotionEvent.ACTION_UP) {
                    btn.setBackground(getActivity().getDrawable(R.drawable.round_button));

                }
                return true;
            }

        });


        // Inflate the layout for this fragment
        return view;
    }

}
