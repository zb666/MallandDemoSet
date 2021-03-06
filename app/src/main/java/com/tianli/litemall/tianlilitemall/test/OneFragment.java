package com.tianli.litemall.tianlilitemall.test;

import android.Manifest;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.tbruyelle.rxpermissions2.RxPermissions;
import com.tianli.litemall.tianlilitemall.R;
import com.tianli.litemall.tianlilitemall.activity.OtherActivity;
import com.tianli.litemall.tianlilitemall.base.contract.BasePresenterImpl;
import com.tianli.litemall.tianlilitemall.fragment.BaseFragmentImpl;
import com.tianli.litemall.tianlilitemall.view.MyProgressView;
import com.tianli.litemall.tianlilitemall.vlayout.OneDragNActivity;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

import static android.app.Activity.RESULT_OK;
import static com.tianli.litemall.tianlilitemall.configinit.LiteMall.getApplicationContext;

/**
 * Created by zhoubo30110 on 2018/8/5.
 */

public class OneFragment extends BaseFragmentImpl {
    @BindView(R.id.textView)
    Button textView;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.button3)
    Button button3;
    @BindView(R.id.bt_start_request)
    Button btStartRequest;
    @BindView(R.id.bt_show_dialog)
    Button btShowDialog;
    Button btCancleDialog;

    int REQUEST_CODE_IMAGE = 0x111;
    @BindView(R.id.image_view_album_image)
    ImageView imageViewAlbumImage;

    @BindView(R.id.progressView)
    MyProgressView progressView;

    @Override
    protected BasePresenterImpl createPresenter() {
        return null;
    }

    @Override
    protected int bindLayout() {
        return R.layout.main_fragment_one;
    }

    @Override
    public void initView() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initData() {
        btShowDialog = (Button) findView(R.id.bt_show_dialog);
        btCancleDialog = (Button) findView(R.id.bt_cancle_dialog);
        //这里进行数据的请求操作
        btShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "点击成功", Toast.LENGTH_SHORT).show();
                mParent.showProgressDialog();
            }
        });
        btCancleDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "点击成功", Toast.LENGTH_SHORT).show();
                mParent.cancleProgressDialog();
            }
        });
    }

    @OnClick({R.id.textView, R.id.button, R.id.button2, R.id.button3, R.id.bt_start_request})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.textView:
                startActivity(OneDragNActivity.class);
                break;
            case R.id.button://相册
                RxPermissions repermissiion = new RxPermissions(mParent);
                repermissiion.request(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.READ_PHONE_STATE)
                        .throttleFirst(2000, TimeUnit.MILLISECONDS)
                        .subscribe(new Consumer<Boolean>() {
                            @Override
                            public void accept(@NonNull Boolean aBoolean) throws Exception {
                                Intent i = new Intent(
                                        Intent.ACTION_PICK,
                                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                //设定结果返回
                                startActivity(i);
                            }
                        });

                break;
            case R.id.button2:
                //ImageLoaderUtils.getInstance().showImage(imageViewAlbumImage,"https://img3.doubanio.com//view//celebrity//s_ratio_celebrity//public//p45590.webp");
                mParent.showProgressDialog();
                break;
            case R.id.button3:
                startActivity(OtherActivity.class);
                break;
            case R.id.bt_start_request:

                break;
            default:
                break;
        }
    }

    private void showDialog() {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_IMAGE && resultCode == RESULT_OK) {
            Uri uri = data.getData();
            Cursor cursor = mParent.getContentResolver().query(uri, null, null, null, null);
            if (cursor != null && cursor.moveToFirst()) {
                String path = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA));
            }
        }
    }

}
