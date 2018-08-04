package com.tianli.litemall.tianlilitemall.vlayout;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.OnePlusNLayoutHelper;
import com.alibaba.android.vlayout.layout.StickyLayoutHelper;
import com.tianli.litemall.tianlilitemall.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhoubo30110 on 2018/8/3.
 */

public class OneDragNActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private OnePlusNLayoutHelper onePlusNLayoutHelper;
    private DelegateRecyclerAdapter mRecyclerAdapter;
    private List<DelegateAdapter.Adapter> mAdapters;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onedrag);

        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setItemCount(4);
        linearLayoutHelper.setPadding(20, 20, 20, 20);
        linearLayoutHelper.setMargin(20, 20, 20, 20);
        linearLayoutHelper.setAspectRatio(6);
        //设置下边距
        linearLayoutHelper.setMarginBottom(10);

        linearLayoutHelper.setDividerHeight(10);
        List<String> mList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            mList.add("条目   " + i);
        }

        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(3);

        gridLayoutHelper.setItemCount(36);
        gridLayoutHelper.setPadding(5,5,5,5);
        gridLayoutHelper.setMargin(20,20,20,20);
        gridLayoutHelper.setAspectRatio(6);
        gridLayoutHelper.setWeights(new float[]{50,20,30});
        gridLayoutHelper.setVGap(20);
        gridLayoutHelper.setHGap(20);
        gridLayoutHelper.setAutoExpand(true);

        OnePlusNLayoutHelper onePlusNLayoutHelper = new OnePlusNLayoutHelper();
        onePlusNLayoutHelper.setColWeights(new float[]{50,50});
        onePlusNLayoutHelper.setPadding(20,20,20,20);
        onePlusNLayoutHelper.setBgColor(Color.WHITE);
        onePlusNLayoutHelper.setAspectRatio(3);

        StickyLayoutHelper stickyLayoutHelper = new StickyLayoutHelper();
        stickyLayoutHelper.setBgColor(Color.WHITE);
        stickyLayoutHelper.setStickyStart(true);//吸附在顶部
        stickyLayoutHelper.setOffset(30);
        stickyLayoutHelper.setMargin(120,20,120,20);
        stickyLayoutHelper.setPadding(100,20,20,20);
        stickyLayoutHelper.setMarginBottom(20);

        mAdapters = new ArrayList<>();

        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(this);

        //横向或者纵向LayoutHelper
        DelegateRecyclerAdapter lineRecycleAdapter = new DelegateRecyclerAdapter(this, linearLayoutHelper, 20, "");
        //表格类型的布局
        DelegateRecyclerAdapter gridRecycleAdapter = new DelegateRecyclerAdapter(this,gridLayoutHelper,10,"");
        //设置一拖N的布局
        DelegateRecyclerAdapter onePlusNAdapter = new DelegateRecyclerAdapter(this,onePlusNLayoutHelper,5,"数据暂时写死在代码里面了");
        //吸边布局
        DelegateRecyclerAdapter stickyAdapter = new DelegateRecyclerAdapter(this,stickyLayoutHelper,5,"数据暂时写死在代码里面了");


        DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager);

        //绑定到适配器上
        mAdapters.add(stickyAdapter);
        mAdapters.add(lineRecycleAdapter);
        mAdapters.add(gridRecycleAdapter);
        mAdapters.add(onePlusNAdapter);

        delegateAdapter.addAdapters(mAdapters);

        recyclerView.setLayoutManager(virtualLayoutManager);
        //设置自己的Adapter
        recyclerView.setAdapter(delegateAdapter);
        //initViewData();
    }

    protected void initViewData() {


        VirtualLayoutManager virtualManager = new VirtualLayoutManager(this);
        recyclerView.setLayoutManager(virtualManager);
        DelegateAdapter adapter = new DelegateAdapter(virtualManager, true);
        adapter.addAdapter(initAdapter());

        LinearLayoutHelper layoutHelper = new LinearLayoutHelper();
        layoutHelper.setItemCount(10);
        layoutHelper.setPadding(20, 20, 20, 20);
        layoutHelper.setMargin(20, 20, 20, 20);
        layoutHelper.setAspectRatio(6);
        //设置下边距
        layoutHelper.setMarginBottom(10);

        layoutHelper.setDividerHeight(20);

        DelegateAdapter delegateAdapter = new DelegateAdapter(virtualManager);
//        delegateAdapter.addAdapter();
        recyclerView.setAdapter(adapter);
    }

    //这个DelagateAdapter很特殊 除了适配之外，还会承载Helper的功能
    private DelegateAdapter.Adapter initAdapter() {
        OnePlusNLayoutHelper onePlusNLayoutHelper = new OnePlusNLayoutHelper();

        onePlusNLayoutHelper.setColWeights(new float[]{50, 50});
        onePlusNLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        onePlusNLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        onePlusNLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色
        onePlusNLayoutHelper.setAspectRatio(3);// 设置设置布局内每行布局的宽与高的比

        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(4);
        gridLayoutHelper.setItemCount(25);
        mRecyclerAdapter = new DelegateRecyclerAdapter(this, onePlusNLayoutHelper, 20, "你比");
        return mRecyclerAdapter;
    }

    private class DelegateRecyclerAdapter extends DelegateAdapter.Adapter {

        private Context context;
        private LayoutHelper helper;
        private LayoutInflater inflater;
        private String name;
        private int count;

        public DelegateRecyclerAdapter(Context context, LayoutHelper helper, int count, String name) {
            this.context = context;
            this.helper = helper;
            this.inflater = LayoutInflater.from(context);
            this.count = count;
            this.name = name;
        }

        //遵循LayoutHelper的规范
        @Override
        public LayoutHelper onCreateLayoutHelper() {
            return helper;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.virtual_item, parent, false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((MyHolder) holder).name.setText("位置" + position);
            // 为了展示效果,设置不同位置的背景色
            if (position > 10) {
                holder.itemView.setBackgroundColor(0x66cc0000);
            } else if (position % 2 == 0) {
                holder.itemView.setBackgroundColor(0xaa22ff22);
            } else {
                holder.itemView.setBackgroundColor(0xccff22ff);
            }
        }

        @Override
        public int getItemCount() {
            return count;
        }

        private class MyHolder extends RecyclerView.ViewHolder {

            private TextView name;

            public MyHolder(View itemView) {
                super(itemView);
                name = (TextView) itemView.findViewById(R.id.tv_show);
            }
        }

    }


}
