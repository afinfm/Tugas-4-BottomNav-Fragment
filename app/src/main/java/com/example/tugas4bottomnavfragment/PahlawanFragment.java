package com.example.tugas4bottomnavfragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.tugas4bottomnavfragment.rv.*;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PahlawanFragment extends Fragment {

    private RecyclerView rvPahlawan;
    private ArrayList<com.example.tugas4bottomnavfragment.rv.pahlawanModel> listPahlawan = new ArrayList<>();

    public PahlawanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pahlawan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvPahlawan = view.findViewById(R.id.rv_target);
        rvPahlawan.setHasFixedSize(true);
        listPahlawan.addAll(com.example.tugas4bottomnavfragment.rv.pahlawanData.getHeroList());

        showRecyclerList();
    }

    private void showRecyclerList()  {
        rvPahlawan.setLayoutManager(new LinearLayoutManager(getActivity()));
        pahlawanAdapter pahlawanAdapter = new pahlawanAdapter(com.example.tugas4bottomnavfragment.rv.pahlawanData.getHeroList(), getActivity());
        pahlawanAdapter.setPahlawanModels(listPahlawan);
        rvPahlawan.setAdapter(pahlawanAdapter);


    }

}
