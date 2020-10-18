package com.example.tourguideapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import com.bumptech.glide.Glide;

public class ContentAdapter extends ArrayAdapter<Content> {

    boolean isVisible = false;

    public ContentAdapter(Context context, ArrayList<Content> contents) {
        super(context, 0, contents);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_view, parent, false);
        }

        final Content currentContent = getItem(position);

        //
        // Title
        //
        ImageView placeImage = (ImageView) listItemView.findViewById(R.id.image);
        placeImage.setImageResource(currentContent.getImageResId());


        final TextView titleTextView = (TextView) listItemView.findViewById(R.id.title);
        titleTextView.setText(currentContent.getPlaceName());
        //
        // Description
        //
        final ImageView des_icon = (ImageView) listItemView.findViewById(R.id.info_icon);

        final TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.info);
        descriptionTextView.setText(currentContent.getDescription());
        //
        // Address
        //
        final ImageView add_icon = (ImageView) listItemView.findViewById(R.id.location_icon);

        final TextView addressTextView = (TextView) listItemView.findViewById(R.id.address);
        addressTextView.setText(currentContent.getAddress());
        addressTextView.setPaintFlags(addressTextView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        addressTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:0,0?q=" + currentContent.getAddress()));
                getContext().startActivity(intent);
            }
        });
        //
        // Phone number
        //
        final ImageView phone_icon = (ImageView) listItemView.findViewById(R.id.phone_icon);

        final TextView phoneNumTextView = (TextView) listItemView.findViewById(R.id.phone_number);
        phoneNumTextView.setText(currentContent.getPhoneNumber());
        phoneNumTextView.setPaintFlags(phoneNumTextView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        phoneNumTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + currentContent.getPhoneNumber()));
                getContext().startActivity(intent);
            }
        });
        //
        // arrow icon
        //
        final ImageView arrowdown = (ImageView) listItemView.findViewById(R.id.arrowdown);
        arrowdown.setVisibility(View.VISIBLE);

        final ImageView arrowup = (ImageView) listItemView.findViewById(R.id.arrowup);
        arrowup.setVisibility(View.GONE);

        final LinearLayout contentLayout = (LinearLayout) listItemView.findViewById(R.id.info_container);
        contentLayout.setVisibility(View.GONE);

        final RelativeLayout titleContainer = (RelativeLayout) listItemView.findViewById(R.id.title_container);
        titleContainer.setVisibility(View.VISIBLE);

        final LinearLayout allContainer = (LinearLayout) listItemView.findViewById(R.id.container);

        arrowdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contentLayout.setVisibility(View.VISIBLE);
                isVisible = true;
                arrowdown.setVisibility(View.GONE);
                arrowup.setVisibility(View.VISIBLE);
            }
        });

        arrowup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contentLayout.setVisibility(View.GONE);
                isVisible = false;
                arrowdown.setVisibility(View.VISIBLE);
                arrowup.setVisibility(View.GONE);
            }
        });

        titleContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contentLayout.setVisibility(isVisible ? View.GONE : View.VISIBLE);
                arrowdown.setVisibility(isVisible ? View.VISIBLE : View.GONE);
                arrowup.setVisibility(isVisible ? View.GONE : View.VISIBLE);
                isVisible = isVisible ? false : true;
            }
        });

        placeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contentLayout.setVisibility(isVisible ? View.GONE : View.VISIBLE);
                arrowdown.setVisibility(isVisible ? View.VISIBLE : View.GONE);
                arrowup.setVisibility(isVisible ? View.GONE : View.VISIBLE);
                isVisible = isVisible ? false : true;
            }
        });

        return listItemView;
    }
}
