package com.tianli.litemall.tianlilitemall.main;

import com.tianli.litemall.tianlilitemall.base.contract.IBaseContract;

/**
 * @Description:
 * @ClassName: 主页的Main契约类
 * @Author: zhoub@hsyuntai.com
 * @Date: 2018/8/1 12:02
 * *@Copyright: 版权归 tianli 所有 <ModifyLog>
 * @ModifyContent:
 * @Author:
 * @Date: </ModifyLog>
 */
public interface IMainContract {

    interface IMainView extends IBaseContract.IBaseView {
        void showMainData(String data);
    }

    interface IMainPresenter {
        void startTask(String data);
    }

}
