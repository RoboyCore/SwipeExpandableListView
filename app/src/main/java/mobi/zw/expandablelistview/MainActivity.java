package mobi.zw.expandablelistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

//    private DragExpandableListView elv;
//    private List<String> listGroup;//组名称
//    private Map<String, List<String>> childs;//组内成员的集合
//    private PatientExpandableAdapter adapter;
    private MyListView mListView;
    private ListViewAdapter  mListViewAdapter;
    private List<String> mList;
    private TextView mTextView;
    private boolean isEditMode;
//    private CartDataObserver mCartDataObserver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        loadData();
    }


    private void initView() {

        mListView = (MyListView)findViewById(R.id.lv);
        mTextView = (TextView)findViewById(R.id.tool_bar);
        mList = new ArrayList<>();
        mListViewAdapter = new ListViewAdapter(mList,this);
        mListView.setAdapter(mListViewAdapter);
//        mCartDataObserver = new CartDataObserver();
//        mListViewAdapter.registerDataSetObserver(mCartDataObserver);
//        listGroup = new ArrayList<>();
//        childs = new HashMap<>();

//        elv.setAdapter(adapter);
//        elv.setChildDivider(new ColorDrawable(Color.BLUE));



    }

    private void loadData() {
        mList.add("0");
        mList.add("1");
        mList.add("2");
        mList.add("3");
        mList.add("4");
        mList.add("5");
        mListViewAdapter.notifyDataSetChanged();

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
                    mListViewAdapter.adapter.closeAllItems();
//                    for (int i = 0; i < mList.size(); i++) {
//                        Integer  = mListViewAdapter.adapter.map.get(i);
//                    }
//                    mOnEditMode.isEditMode(false);
//              、      mListViewAdapter.closeAllItems();

                }else{
                    mTextView.setText("完成");
                    isEditMode = true;
//                    PatientExpandableAdapter adapter = mListViewAdapter.adapter;
//                    for (int i = 0; i <adapter.listGroup.size() ; i++) {
//                        mListViewAdapter.adapter.openItem(adapter.childs.get(adapter.listGroup.get(i)).size()-1);
//                    }

                }
                mListViewAdapter.adapter.switchEditMode();
                mListViewAdapter.switchEditMode();
                mListViewAdapter.adapter.notifyDataSetChanged();
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
