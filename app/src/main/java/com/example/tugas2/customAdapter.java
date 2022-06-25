package com.example.tugas2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class customAdapter extends BaseAdapter {

    Context c;
    List<DataModel> data;
    LayoutInflater inflater;
    ArrayList id, nama, pass;

    public customAdapter(Context c, List data) {
        this.c = c;
        this.data = data;
        inflater = LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.mylv, null);
        TextView tv = (TextView) view.findViewById(R.id.textView);
        tv.setText(String.valueOf(data.get(i)));
        return view;
    }
}
