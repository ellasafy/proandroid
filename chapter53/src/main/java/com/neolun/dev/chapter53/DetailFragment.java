package com.neolun.dev.chapter53;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.neolun.dev.proandroid.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DetailFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private int mIndex = 0;

    private OnFragmentInteractionListener mListener;


    public static DetailFragment newInstance(int index) {
        Log.v(MainActivity.TAG, "in DetailFragment new Instance " + index);

        Bundle args = new Bundle();

        DetailFragment fragment = new DetailFragment();

        args.putInt("index",index);

        fragment.setArguments(args);
        return fragment;
    }

    public static DetailFragment newInstance(Bundle bundle) {
        int index = bundle.getInt("index",0);
        return newInstance(index);
    }


    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle myBundle) {
        Log.v(MainActivity.TAG, " in DetailFragment onCreate ");

        if (myBundle != null) {
            for(String key : myBundle.keySet()) {
                Log.v(MainActivity.TAG, " " + key);
            }
        } else {
            Log.v(MainActivity.TAG, " myBundle is null");
        }


        super.onCreate(myBundle);

        mIndex = getArguments().getInt("index",0);
    }

    public int getShownIndex() {
        return mIndex;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.v(MainActivity.TAG, " in DetailFragment onCreateView.container= " + container);

        View v = inflater.inflate(R.layout.details, container,false);

        TextView text1 = (TextView)v.findViewById(R.id.text1);
        text1.setText(Shakespeare.DIALOGUE[mIndex]);

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
