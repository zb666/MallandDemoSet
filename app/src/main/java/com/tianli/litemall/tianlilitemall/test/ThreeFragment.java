package com.tianli.litemall.tianlilitemall.test;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tianli.litemall.common_library.interceptor.OkHttpInterceptor;
import com.tianli.litemall.common_library.utils.LogUtil;
import com.tianli.litemall.common_library.utils.ToastUtil;
import com.tianli.litemall.tianlilitemall.R;
import com.tianli.litemall.tianlilitemall.adapter.LoadMoreAdapter;
import com.tianli.litemall.tianlilitemall.base.contract.BasePresenterImpl;
import com.tianli.litemall.tianlilitemall.fragment.BaseFragmentImpl;
import com.tianli.litemall.tianlilitemall.model.DouBanBean;
import com.tianli.litemall.tianlilitemall.netapi.IApiNet;
import com.tianli.litemall.tianlilitemall.view.MyProgressView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhoubo30110 on 2018/8/5.
 */

public class ThreeFragment extends BaseFragmentImpl {


    @BindView(R.id.progressView)
    MyProgressView progressView;
    @BindView(R.id.button4)
    Button button4;
    @BindView(R.id.button5)
    Button button5;
    @BindView(R.id.bt_request)
    Button btRequest;
    @BindView(R.id.recycleview)
    RecyclerView recyclerView;

    Unbinder unbinder;

    private int start = 1;
    private int count = 10;

    private LoadMoreAdapter moreAdapter;

    List<DouBanBean.SubjectsBean> beanList = new ArrayList<>();
    private IApiNet mApiNet;

    @Override
    protected BasePresenterImpl createPresenter() {
        return null;
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_other;
    }

    @Override
    public void initView() {
        String format = String.format("牛逼%s", "10");
        LogUtil.d(format);
    }

    @Override
    public void initData() {
        initLoadMoreListener();
    }

    private void initLoadMoreListener() {
        moreAdapter = new LoadMoreAdapter(R.layout.item_loadmore);
        recyclerView.setAdapter(moreAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mParent));
        moreAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                ToastUtil.showMsg(mParent,"触发了上拉加载更多");
                doRequest(start++, count);
            }
        }, recyclerView);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.button4, R.id.button5, R.id.bt_request})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button4:
                //https://api.douban.com/v2/movie/top250?start=1&count=10
                mParent.showProgressDialog();
                doRequest(start, count);
                break;
            case R.id.button5:
                mParent.cancleProgressDialog();
                break;
            case R.id.bt_request:

                break;
        }
    }

    private void doRequest(final int start, final int count) {
        if (mApiNet == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .addNetworkInterceptor(new OkHttpInterceptor())
                    .build();

            mApiNet = new Retrofit.Builder()
                    .baseUrl("https://api.douban.com/v2/")
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(IApiNet.class);
        }

        mApiNet.getDouban(start, count)
                .enqueue(new Callback<DouBanBean>() {
                    @Override
                    public void onResponse(Call<DouBanBean> call, Response<DouBanBean> response) {
                        LogUtil.d(response.body().toString());
                        DouBanBean douBanBean = response.body();
                        moreAdapter.addData(douBanBean.getSubjects());
                        LogUtil.d("本次数据加载完毕");
                        //本次数据拉取完毕
                        moreAdapter.loadMoreComplete();
                        mParent.cancleProgressDialog(true);
                        if (start == 5) {
                            moreAdapter.loadMoreEnd();
                        }
                    }

                    @Override
                    public void onFailure(Call<DouBanBean> call, Throwable t) {
                        LogUtil.d(t.toString());
                    }
                });
    }

}
