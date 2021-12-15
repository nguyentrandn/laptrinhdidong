package com.example.appxin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class adapterngonngu extends BaseAdapter {
    private Context context;
    private int layout;
    private List<ngonngu> ngonnguList;

    public adapterngonngu(Context context, int layout, List<ngonngu> ngonnguList) {
        this.context = context;
        this.layout = layout;
        this.ngonnguList = ngonnguList;
    }

    @Override
    public int getCount() {
        return ngonnguList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);

        //anh xa
        TextView txtTen = (TextView) view.findViewById(R.id.textviewTen);
        TextView txtMota = (TextView) view.findViewById(R.id.textviewMota);
        ImageView imgview = (ImageView) view.findViewById(R.id.imgview);
        //gan gia tri
        ngonngu NN = ngonnguList.get(i);
        txtTen.setText(NN.getTen());
        txtMota.setText(NN.getMota());
        imgview.setImageResource(NN.getHinhanh());

        return view;
    }
}
