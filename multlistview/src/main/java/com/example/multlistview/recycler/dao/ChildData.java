package com.example.multlistview.recycler.dao;

/**
 * <p>  <p/>
 * Created by zw on 17/3/25 15:51.
 */

public class ChildData {
    private int childId;
    private int groupId;
    private String childName;
    private boolean isChildSelect;
    private int childType;
//    private boolean isEditMode;


    public ChildData(int childId, int groupId, String childName, boolean isChildSelect, int childType) {
        this.childId = childId;
        this.groupId = groupId;
        this.childName = childName;
        this.isChildSelect = isChildSelect;
        this.childType = childType;
    }

    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public boolean isChildSelect() {
        return isChildSelect;
    }

    public void setChildSelect(boolean childSelect) {
        isChildSelect = childSelect;
    }

    public int getChildType() {
        return childType;
    }

    public void setChildType(int childType) {
        this.childType = childType;
    }
}
