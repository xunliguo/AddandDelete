package com.example.asus_pc.addanddelete;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ASUS-PC on 2017/5/11.
 */

public class MyAdapter extends BaseAdapter{
    private Context context;
    private ArrayList<String> list;
     private  ViewHolder holder;
    public MyAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
           holder=new ViewHolder();
        convertView= View.inflate(context,R.layout.item,null);
         holder.text= (TextView) convertView.findViewById(R.id.text);
         convertView.setTag(holder);

        }else{
         holder= (ViewHolder) convertView.getTag();

        }
        holder.text.setText(list.get(position));
        return convertView;

    }
    static  class ViewHolder {
        TextView text;


    }
}
