package com.example.multlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.daimajia.swipe.util.Attributes;
import com.example.multlistview.recycler.dao.ChildData;
import com.example.multlistview.recycler.dao.GroupData;
import com.example.multlistview.recycler.view.DragExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity{

    private DragExpandableListView elv;
    private List<GroupData> listGroup;//组名称
    private Map<GroupData, List<ChildData>> childs;//组内成员的集合
    private PatientExpandableAdapter adapter;
//    private MyListView elv;
//    private ListViewAdapter  elvAdapter;
//    private List<String> mList;
    private TextView mTextView;
    private boolean isEditMode;
//    private CartDataObserver mCartDataObserver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
        loadData();
    }



    private void initView() {

        elv = (DragExpandableListView)findViewById(R.id.elv);
        mTextView = (TextView)findViewById(R.id.tool_bar);
        listGroup = new ArrayList<>();
        childs = new HashMap<>();
        adapter = new PatientExpandableAdapter(listGroup,childs,this);
        adapter.setMode(Attributes.Mode.Single);
        elv.setAdapter(adapter);
//        mCartDataObserver = new CartDataObserver();
//        elvAdapter.registerDataSetObserver(mCartDataObserver);
//        listGroup = new ArrayList<>();

//        elv.setAdapter(adapter);
//        elv.setChildDivider(new ColorDrawable(Color.BLUE));



    }

    private void initListener() {


    }
    private void loadData() {

        //一级组1待诊断，2我的，0.标题
        //二级组0，人，1未分组2，可删分组
        List<ChildData> ch0 = new ArrayList<>();
        List<ChildData> ch = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ch.add(new ChildData(i,0,"白求恩"+i,false,0));
        }
        List<ChildData> ch1 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ch1.add(new ChildData(10*i,0,"可删分组"+i,false,1));
        }
        ch1.add(new ChildData(40,0,"添加分组",false,2));

        for (int i = 0; i < 5; i++) {
            GroupData groupData = new GroupData(2 + 5 * i, "301医院"+i, false,ch0 , 0);
            listGroup.add(groupData);//标题
            GroupData groupData1 = new GroupData(5 * i, "待诊"+i, false, ch, 1);
            listGroup.add(groupData1);//待诊断
            GroupData groupData2 = new GroupData(1 + 5 * i, "我的"+i, false, ch1, 2);
            listGroup.add(groupData2);//我的
            childs.put(groupData,ch0);
            childs.put(groupData1,ch);
            childs.put(groupData2,ch1);
        }

        adapter.notifyDataSetChanged();

    }

    public void getEditMode(boolean isEditMode) {
        this.isEditMode = isEditMode;

    }

    public void click(View view) {
        switch (view.getId()) {
            case R.id.tool_bar:
                if ("完成".equals(mTextView.getText())) {
                    mTextView.setText("编辑");
                    isEditMode = false;
                    adapter.closeAllItems();
//                    for (int i = 0; i < mList.size(); i++) {
//                        Integer  = elvAdapter.adapter.map.get(i);
//                    }
//                    mOnEditMode.isEditMode(false);
//              、      elvAdapter.closeAllItems();

                }else{
                    mTextView.setText("完成");
                    isEditMode = true;
//                    PatientExpandableAdapter adapter = elvAdapter.adapter;
//                    for (int i = 0; i <adapter.listGroup.size() ; i++) {
//                        elvAdapter.adapter.openItem(adapter.childs.get(adapter.listGroup.get(i)).size()-1);
//                    }

                }
                adapter.switchEditMode();
                break;
        }
    }



    //    private class CartDataObserver extends DataSetObservable{
//    @Override
//    public void notifyChanged() {
//        super.notifyChanged();
//
//    }
//}
}
