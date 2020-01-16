

package com.game.box.applettaskdemo;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Toast;

import com.game.box.applettaskdemo.utils.DialogUtil;

import androidx.annotation.Nullable;


public class BaseActivity extends Activity {

    private Dialog mDialogLoading;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDialogLoading = DialogUtil.showLoadingDialog(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }


    /**
     * 显示请求网络数据进度条
     */
    public void showLoadingDialog() {
        try {
            if (!isFinishing() && mDialogLoading != null && !mDialogLoading.isShowing()) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            mDialogLoading.show();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 关闭请求网络数据进度条
     */
    public void dismissLoadingDialog() {
        try {
            if (!isFinishing() && mDialogLoading != null && mDialogLoading.isShowing()) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            mDialogLoading.dismiss();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showLongToast(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
    }

    public void showShortToast(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }

    public void showLongToast(int stringRes) {
        showLongToast(getApplicationContext().getString(stringRes));
    }

    public void showShortToast(int stringRes) {
        showShortToast(getApplicationContext().getString(stringRes));
    }
}
