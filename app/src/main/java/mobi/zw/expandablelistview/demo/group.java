package mobi.zw.expandablelistview.demo;

import java.util.ArrayList;

/**
 * <p>  <p/>
 * Created by zw on 17/3/25 14:57.
 */

public class group {
    private int id;
    /** 是否处于编辑状态 */
    private boolean isEditing;
    /** 组是否被选中 */
    private boolean isGroupSelected;

    /** 名称 */
    private String mName;
    private ArrayList<child> mChildren;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEditing() {
        return isEditing;
    }

    public void setEditing(boolean editing) {
        isEditing = editing;
    }

    public boolean isGroupSelected() {
        return isGroupSelected;
    }

    public void setIsGroupSelected(boolean groupSelected) {
        isGroupSelected = groupSelected;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public void setGroupSelected(boolean groupSelected) {
        isGroupSelected = groupSelected;
    }

    public ArrayList<child> getChildren() {
        return mChildren;
    }

    public void setChildren(ArrayList<child> children) {
        mChildren = children;
    }

    public static class child{
        private int cid;
        /** 是否处于编辑状态 */
        private boolean isEditing;
        /** 组是否被选中 */
        private boolean isChildSelected;

        /** 名称 */
        private String mName;

        public int getCid() {
            return cid;
        }

        public void setCid(int cid) {
            this.cid = cid;
        }

        public boolean isEditing() {
            return isEditing;
        }

        public void setEditing(boolean editing) {
            isEditing = editing;
        }

        public boolean isChildSelected() {
            return isChildSelected;
        }

        public void setChildSelected(boolean childSelected) {
            isChildSelected = childSelected;
        }

        public String getName() {
            return mName;
        }

        public void setName(String name) {
            mName = name;
        }
    }
}
