package com.tianli.litemall.tianlilitemall.netimpl;

/**
 * Created by zhoubo30110 on 2018/8/5.
 */

public final class NetRequest {

    private INetRequestStrategy netRequestStrategy;

    public void setNetProxy(INetRequestStrategy iNetProxy) {
        this.netRequestStrategy = iNetProxy;
    }

    public void post(String urt) {
        netRequestStrategy.post(urt);
    }

    public interface INetRequestStrategy {
        void post(String proxy);

        void get();

        void delete();

        void put();
    }
}
