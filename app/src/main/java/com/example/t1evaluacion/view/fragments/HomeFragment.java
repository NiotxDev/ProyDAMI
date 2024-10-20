package com.example.t1evaluacion.view.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.t1evaluacion.Model.Picture;
import com.example.t1evaluacion.R;
import com.example.t1evaluacion.adapter.PictureAdapterRecyclerView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        showToolbar("Home", false, view);

        RecyclerView pictureRecycler = (RecyclerView) view.findViewById(R.id.pictureRecyclerView);

        LinearLayoutManager linerLayoutManager = new LinearLayoutManager(getContext());
        linerLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        pictureRecycler.setLayoutManager(linerLayoutManager);
        PictureAdapterRecyclerView pictureAdapterRecyclerView =
                new PictureAdapterRecyclerView(buildPictures(), R.layout.cardview_picture, getActivity());

        pictureRecycler.setAdapter(pictureAdapterRecyclerView);
        return view;
    }

    public ArrayList<Picture> buildPictures() {
        ArrayList<Picture> pictures = new ArrayList<>();

        pictures.add(new Picture("https://www.bareinternational.cl/wp-content/uploads/sites/4/2022/04/Untitled-design-2-300x200.png",
                "Pizza Pepperoni", "10-12 minutos", "9.5/10 Me Gusta"));

        pictures.add(new Picture("https://www.lavanguardia.com/files/og_thumbnail/files/fp/uploads/2021/03/30/6063031b90a87.r_d.1083-871-0.jpeg",
                "Pizza Cuatro Quesos", "10-12 minutos.", "8.5/10 Me Gusta"));

        pictures.add(new Picture("https://www.recetasdesbieta.com/wp-content/uploads/2018/09/Como-hacer-pizza-casera-rapida-con-masa-de-pizza-sin-repos-1.jpg",
                "Pizza Napolitana", "10-12 minutos.", "7/10 Me Gusta"));

        pictures.add(new Picture("https://myplate-prod.azureedge.us/sites/default/files/styles/recipe_525_x_350_/public/2022-08/QuickAndEasyPizza_527x323.jpg?itok=MR3STXhe",
                "Pizza Diávola", "12-14 minutos.", "8/10 Me Gusta"));

        pictures.add(new Picture("https://s3-eu-west-1.amazonaws.com/verema/images/valoraciones/0011/7628/Pizza-Margarita.png?1366124625",
                "Pizza Barbacoa", "12-15 minutos.", "9/10 Me Gusta"));

        pictures.add(new Picture("https://media.scoolinary.app/blog/images/2021/04/pizza-napolitana-scooinary.jpg",
                "Pizza Hawaiana", "10-13 minutos.", "7/10 Me Gusta"));

        return pictures;

    }

    private void showToolbar(String title, boolean upButton, View view) {

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}