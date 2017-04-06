package com.example.multlistview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.swipe.SwipeLayout;
import com.example.multlistview.recycler.dao.ChildData;
import com.example.multlistview.recycler.dao.GroupData;

import java.util.List;
import java.util.Map;

/**
 * <p>  <p/>
 * Created by zw on 17/3/22 13:58.
 */

public class PatientExpandableAdapter extends BaseExpandableSwipeAdapter {
    public List<GroupData> listGroup;
    public Map<GroupData, List<ChildData>> childs;
    private Context mContext;
    private LayoutInflater mInflater;
    public boolean isEditMode;//是否编辑模式
//    public Map<Integer,Integer> map;


    public PatientExpandableAdapter(List<GroupData> listGroup, Map<GroupData, List<ChildData>> childs, Context context) {
        this.listGroup = listGroup;
        this.childs = childs;
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
//        map = new HashMap<>();
    }

    public void switchEditMode(){
        isEditMode = !isEditMode;
        notifyDataSetChanged();
//        notifyDataSetInvalidated();
    }

//    public Map<Integer, Integer> getMap() {
//        return map;
//    }

    @Override
    public int getGroupCount() {
        return listGroup.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childs.get(listGroup.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listGroup.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childs.get(listGroup.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    /**
     * 当父控件被展开
     * @param groupPosition
     */
    @Override
    public void onGroupExpanded(int groupPosition) {
        super.onGroupExpanded(groupPosition);

    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }

    @Override
    public View generateView(int position, ViewGroup parent) {
        return mInflater.inflate(R.layout.activity_patient_list_child_item, null);
    }

    @Override
    public void fillValues(final int childPosition, View convertView, final int groupPosition, boolean isLastChild) {
         final ViewHolderChilds holder ;
        if (true) {
//            convertView = mInflater.inflate(R.layout.activity_patient_list_child_item, null);
            holder = new ViewHolderChilds();

            SwipeLayout swipeLayout = (SwipeLayout) convertView.findViewById(R.id.swipe);
            LinearLayout linearLayout = (LinearLayout) convertView.findViewById(R.id.group_item);
            TextView itemName = (TextView) convertView.findViewById(R.id.group_name);
            ImageView leftDel = (ImageView) convertView.findViewById(R.id.group_del);
            TextView rightArrow = (TextView) convertView.findViewById(R.id.group_move);
            ImageView rightDel = (ImageView) convertView.findViewById(R.id.trash);
            holder.items.put(0,linearLayout);
            holder.items.put(1,itemName);
            holder.items.put(2,leftDel);
            holder.items.put(3,rightArrow);
            holder.items.put(4,swipeLayout);
            holder.items.put(5,rightDel);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolderChilds) convertView.getTag();
        }
        ((TextView) holder.items.get(1)).setText(listGroup.get(groupPosition).getChildren().get(childPosition).getChildName());
        if (isEditMode) {
            holder.items.get(2).setVisibility(View.VISIBLE);
        }else {
            ((SwipeLayout) holder.items.get(4)).close();
            holder.items.get(2).setVisibility(View.INVISIBLE);
        }
        holder.items.get(2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((SwipeLayout) holder.items.get(4)).open();
            }
        });
        ((SwipeLayout) holder.items.get(4)).setSwipeEnabled(true);
        holder.items.get(5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((SwipeLayout) holder.items.get(4)).close();
                holder.items.get(2).setVisibility(View.INVISIBLE);
                String groupname = listGroup.get(groupPosition).getGroupName();
                String childname = childs.get(listGroup.get(groupPosition)).get(childPosition).getChildName();
//                String childname = childs.get(groupname).get(childPosition).getChildName();
                Toast.makeText(mContext, "删除操作"+groupPosition+groupname+childname, Toast.LENGTH_SHORT).show();
                childs.get(listGroup.get(groupPosition)).remove(childPosition);
                notifyDataSetChanged();
            }
        });
//        SwipeLayout layout = (SwipeLayout) holder.items.get(4);

    }



    /**
     * 父控件点哦视图
     * @param groupPosition
     * @param isExpanded
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        final ViewHolderGroup holder;
        if (convertView == null) {
            holder = new ViewHolderGroup();
            switch (getGroupType(groupPosition)) {
                case 1://带争端人员
                case 2://我的
                    convertView = mInflater.inflate(R.layout.group_name, null);
                    break;
                default://0标题
                    convertView = mInflater.inflate(R.layout.group_title, null);
                    break;
            }
            LinearLayout linearLayout = (LinearLayout) convertView.findViewById(R.id.group_item);
            TextView itemName = (TextView) convertView.findViewById(R.id.group_name);
//            ImageView leftDel = (ImageView) convertView.findViewById(R.id.group_del);
            TextView rightArrow = (TextView) convertView.findViewById(R.id.group_move);
//            SwipeLayout swipeLayout = (SwipeLayout) convertView.findViewById(R.id.swipe);

            holder.items.put(0,linearLayout);
            holder.items.put(1,itemName);
//            holder.items.put(2,leftDel);
            holder.items.put(3,rightArrow);
//            holder.items.put(4,swipeLayout);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolderGroup) convertView.getTag();
        }
        if (isExpanded) {// 大组展开时
            Matrix matrix = new Matrix();
            Bitmap bitmapOrg = BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.ic_right_arrow);
            matrix.postRotate(90f);//x旋转的角度
            matrix.postTranslate(bitmapOrg.getWidth(), bitmapOrg.getHeight());
            Bitmap bm = Bitmap.createBitmap(bitmapOrg, 0, 0, bitmapOrg.getWidth(), bitmapOrg.getHeight(), matrix, true);
            //将上面创建的Bitmap转换成Drawable对象，使得其可以使用在ImageView, ImageButton中
            BitmapDrawable bmd = new BitmapDrawable(convertView.getResources(),bm);
             holder.items.get(3).setBackground(bmd);
        } else {
            // 大组合并时
//            holder.items.get(3).setBackgroundResource(R.mipmap.ic_right_arrow);
        }
        ((TextView) holder.items.get(1)).setText(listGroup.get(groupPosition).getGroupName());
//        holder.items.get(2).setVisibility(View.GONE);
//        ((SwipeLayout) holder.items.get(4))
//        ((LinearLayout) holder.items.get(0)).setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                Toast.makeText(mContext, "长按了", Toast.LENGTH_SHORT).show();
//                return true;
//            }
//        });
        return convertView;
    }


    @Override
    public int getGroupType(int groupPosition) {
        return listGroup.get(groupPosition).getGroupType();
    }

    @Override
    public int getGroupTypeCount() {
        return 3;
    }

    //返回是否允许孩子选中
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }




    ///////////////////////////////////////////////////////////////////////////
    // ViewHolder
    ///////////////////////////////////////////////////////////////////////////

    static class ViewHolderGroup {
        private SparseArray<View> items;

         ViewHolderGroup() {
            items = new SparseArray<>();
        }
    }
    static class ViewHolderChilds {
        private SparseArray<View> items;

        ViewHolderChilds() {
            items = new SparseArray<>();
        }
    }

}
