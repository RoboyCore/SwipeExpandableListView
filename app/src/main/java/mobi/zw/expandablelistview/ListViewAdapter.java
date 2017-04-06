package mobi.zw.expandablelistview;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * <p>  <p/>
 * Created by zw on 17/3/24 09:47.
 */

public class ListViewAdapter extends BaseAdapter {
    private List<String> mList;
    private Context mContext;
    private LayoutInflater mInflater;
    private boolean isEditMode;//是否编辑模式

    private DragExpandableListView elv;
    private List<String> listGroup;//组名称
    private Map<String, List<String>> childs;//组内成员的集合
     PatientExpandableAdapter adapter;
    private DragExpandableListView mExpandableListView;

    public ListViewAdapter(List<String> list, Context context) {
        mList = list;
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }
    public void switchEditMode(){
        isEditMode = !isEditMode;
        adapter.notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.expandable_lv,null);
            holder = new ViewHolder();
            TextView title = (TextView) convertView.findViewById(R.id.title);
            mExpandableListView = (DragExpandableListView) convertView.findViewById(R.id.elv);
            holder.mItems.put(0,title);
            holder.mItems.put(1, mExpandableListView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
        }
        if (position != 0) {
            ((TextView) holder.mItems.get(0)).setText("北京市协和医院");
        }
        listGroup = new ArrayList<>();
        childs = new HashMap<>();
        adapter = new PatientExpandableAdapter(listGroup, childs, mContext);
        ((DragExpandableListView) holder.mItems.get(1)).setAdapter(adapter);

//        if (isEditMode) {
////          adapter.switchEditMode();
//            adapter.isEditMode = true;
//        }
//        else {
//            adapter.isEditMode = false;
//        }
        init();
        return convertView;
    }

    private void init() {

            //孩子的点击事件
        mExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                @Override
                public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                    Toast.makeText(mContext, groupPosition + "这是孩子" + childPosition, Toast.LENGTH_SHORT).show();
                    List<String> cs = childs.get(listGroup.get(groupPosition));
                    cs.add(cs.get(childPosition) + new Random().nextInt(1000000));
                    adapter.notifyDataSetChanged();
                    return true;
                }
            });
        listGroup.add("待诊");
        ArrayList<String> list0 = new ArrayList<>();
        list0.add("白求恩");
        list0.add("王树国");
        childs.put("待诊",list0);
        ArrayList<String> list1 = new ArrayList<>();
        listGroup.add("全部");
        list1.add("普通病组");
        list1.add("疑难病组");
        list1.add("高危病组");
        list1.add("未分组");
        list1.add("添加分组");
        childs.put("全部", list1);
        adapter.notifyDataSetChanged();


    }

    static class ViewHolder{
        private SparseArray<View> mItems;

        public ViewHolder() {
            mItems = new SparseArray<>();
        }
    }
}
