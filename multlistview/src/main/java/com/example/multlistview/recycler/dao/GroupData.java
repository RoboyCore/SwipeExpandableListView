package com.example.multlistview.recycler.dao;

import java.util.List;

/**
 * <p>  <p/>
 * Created by zw on 17/3/25 15:51.
 */

public class GroupData {
    private int groupId;
    private String groupName;
    private boolean isGroupSelect;
    private List<ChildData> children;
    private int groupType;

    public GroupData(int groupId, String groupName, boolean isGroupSelect, List<ChildData> children, int groupType) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.isGroupSelect = isGroupSelect;
        this.children = children;
        this.groupType = groupType;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public boolean isGroupSelect() {
        return isGroupSelect;
    }

    public void setGroupSelect(boolean groupSelect) {
        isGroupSelect = groupSelect;
    }

    public List<ChildData> getChildren() {
        return children;
    }

    public void setChildren(List<ChildData> children) {
        this.children = children;
    }

    public int getGroupType() {
        return groupType;
    }

    public void setGroupType(int groupType) {
        this.groupType = groupType;
    }
}
