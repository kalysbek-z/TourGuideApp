package com.example.tourguideapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class ParksFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        int[] Images = {R.drawable.todoroki_valley_park, R.drawable.chichibutamakai_park, R.drawable.hamarikyu_park, R.drawable.yoyogi_parkjpg, R.drawable.shinjuku_gyoen};
        String[] Names = getResources().getStringArray(R.array.ParksName);
        String[] Descriptions = getResources().getStringArray(R.array.ParksDescription);
        String[] Addresses = getResources().getStringArray(R.array.ParksAddress);
        String[] Phones = getResources().getStringArray(R.array.ParksPhone);
        ArrayList<Content> placeContent = new ArrayList<>();

        View rootview = inflater.inflate(R.layout.content_list, container, false);

        initialize(Names, Descriptions, Addresses, Phones, Images, placeContent);

        ContentAdapter contentAdapter = new ContentAdapter(getActivity(), placeContent);
        ListView listView = (ListView) rootview.findViewById(R.id.list);
        listView.setAdapter(contentAdapter);

        return rootview;
    }

    private void initialize(String[] Names, String[] Descriptions, String[] Addresses, String[] Phones, int[] Images, ArrayList<Content> placeContent) {
        for (int i = 0; i < Names.length; i++) {
            placeContent.add(new Content(Names[i], Descriptions[i], Addresses[i], Phones[i], Images[i]));
        }
    }
}