package com.irfanrosandi.masjidmap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class CustomListAdapter extends ArrayAdapter<String> {

    public CustomListAdapter(Context context, String[] judul) {
        super(context, R.layout.custom_listrow, judul);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater myLayoutInflater = LayoutInflater.from(getContext());
        View myCustomView = myLayoutInflater.inflate(R.layout.custom_listrow, parent, false);

        String myListItem = getItem(position);
        TextView myTextView = (TextView) myCustomView.findViewById(R.id.tvJudul);
        ImageView myImageView = (ImageView) myCustomView.findViewById(R.id.ivThumbnail);

        myTextView.setText(myListItem);
        myImageView.setImageResource(R.drawable.avatar);
        return myCustomView;
    }
}
