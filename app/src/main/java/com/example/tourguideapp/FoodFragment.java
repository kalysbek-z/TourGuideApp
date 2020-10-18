package com.example.tourguideapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class FoodFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        int[] Images = {R.drawable.ginza_kojyu_food, R.drawable.ishikawa_food, R.drawable.leffervescence_food, R.drawable.sukiyabashi_jiro_food, R.drawable.sushi_yoshitake_food};
        String[] Names = getResources().getStringArray(R.array.RestaurantName);
        String[] Descriptions = getResources().getStringArray(R.array.RestaurantDescription);
        String[] Addresses = getResources().getStringArray(R.array.RestaurantAddress);
        String[] Phones = getResources().getStringArray(R.array.RestaurantPhone);
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