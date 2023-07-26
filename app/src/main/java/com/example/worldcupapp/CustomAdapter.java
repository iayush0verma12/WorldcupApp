package com.example.worldcupapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter <CountryModelClass>{
   private ArrayList<CountryModelClass> countryArrayList;
   Context context;

   public CustomAdapter(ArrayList<CountryModelClass> data, Context context){
       super(context,R.layout.item_list_layout,data);
       this.countryArrayList=data;
       this.context=context;
   }
   // view Lookup cache
    private static class ViewHolder{
       TextView txtCountry;
       TextView txtCupWins;
       ImageView flagImg;
   }

   //View Lookup Cache

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        CountryModelClass dataModel = getItem(position);
        //check if an existing view is being reused, otherwise inflate a view
        ViewHolder viewHolder;

        final View result;
        if(convertView==null) {
            viewHolder = new ViewHolder();


            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.item_list_layout,
                    parent,
                    false);
            viewHolder.txtCountry = (TextView) convertView.findViewById(R.id.country_name);
            viewHolder.txtCupWins = (TextView) convertView.findViewById(R.id.cup_win_desc);
            viewHolder.flagImg = (ImageView) convertView.findViewById(R.id.imageView);
            result = convertView;
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        viewHolder.txtCountry.setText(dataModel.getCountry_name());
        viewHolder.txtCupWins.setText(dataModel.getCup_win_count());
        viewHolder.flagImg.setImageResource(dataModel.getFlag_img());

        return convertView;

    }
}
