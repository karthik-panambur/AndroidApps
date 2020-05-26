package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdaptor extends ArrayAdapter<Word> {

    public WordAdaptor(Context context, ArrayList<Word> word){
        super(context,0,word);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Word word = getItem(position);

        TextView englishText = (TextView) listItemView.findViewById(R.id.english);
        englishText.setText(word.getDefaultTranslation());

        TextView miwokText = (TextView) listItemView.findViewById(R.id.miwok);
        miwokText.setText(word.getMiwokTranslation());

        return listItemView;
    }
}
