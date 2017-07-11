package com.example.asus_pc.addanddelete;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView list_item;
    private ArrayList<String> list;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
       getdata();

    }

    private void initView() {
        list_item = (ListView) findViewById(R.id.list_item);
        list = new ArrayList<String>();
        adapter = new MyAdapter(MainActivity.this,list);
        list_item.setAdapter(adapter);
        registerForContextMenu(list_item);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0,1,0,"删除");
        menu.add(0,2,0,"添加");
        menu.add(0,3,0,"修改");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public void onContextMenuClosed(Menu menu) {
        super.onContextMenuClosed(menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
       AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        final int position1 = info.position;

        switch (item.getItemId()){
            case 1:
          list.remove(position1);
                adapter.notifyDataSetChanged();

            break;
            case  2:
                for (int i=0; i<7;i++){
                    list.add("这是添加的" + i);
                    adapter.notifyDataSetChanged();
                }






        }


        return super.onContextItemSelected(item);
    }

    public  void getdata(){
        for (int i=0;i<10;i++){
          list.add("这是第"+i+"条数据");

        }


    }
}
