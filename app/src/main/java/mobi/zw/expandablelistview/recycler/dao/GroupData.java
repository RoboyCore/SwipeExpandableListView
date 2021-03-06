package mobi.zw.expandablelistview.recycler.dao;

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
}
