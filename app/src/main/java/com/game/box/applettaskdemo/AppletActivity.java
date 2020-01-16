package com.game.box.applettaskdemo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ListView;
import android.widget.Toast;

import com.game.box.applettaskdemo.adapter.MyAdapter;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.yd.sdk.ApManager;
import com.yd.sdk.bean.DataListBean;
import com.yd.sdk.listener.AppletTaskListener;
import com.yd.sdk.listener.QueryTaskListener;

import java.util.List;


public class AppletActivity extends BaseActivity {

    private ListView recyclerView;
    private MyAdapter taskAdapter;
    private String uid;
    private String appKey;
    private String key;
    private int status;
    private String myCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.game.box.ydlibrary.R.layout.activity_applet);

        uid = "1222";
        appKey = "*EFvr7Zt$GUhP7ep";
        key = "1%G88@0V#8&AjV&CJGzifqw0qXo2Hf^s";
        recyclerView = findViewById(com.game.box.ydlibrary.R.id.applet_task);
        taskAdapter = new MyAdapter();
        recyclerView.setAdapter(taskAdapter);
        taskAdapter.setClickListener(new MyAdapter.IsClickListener() {
            @Override
            public void click(DataListBean adData) {
                status = adData.getStatus();
                myCode = adData.getMycode();
               ApManager.clickAppletTask(AppletActivity.this,adData);
            }
        });

       // request(uid, appKey);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!TextUtils.isEmpty(myCode)){
            requestSuccess(appKey);
            myCode="";
        }

        request(uid,appKey);
    }

    private void request(String uid, String appKey){
        showLoadingDialog();

        ApManager.requestAppletTask(uid, appKey, key, new AppletTaskListener() {
            @Override
            public void onSuccess(List<DataListBean> list) {
                dismissLoadingDialog();
                if (list!=null && list.size()>0){
                    taskAdapter.setList(list, AppletActivity.this);
                    taskAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure() {
                dismissLoadingDialog();
            }
        });

    }

    private void requestSuccess(String appKey) {
        ApManager.requestTaskStatus(appKey, status, myCode, new QueryTaskListener() {
            @Override
            public void onTaskSuccess(int i) {
                Toast.makeText(AppletActivity.this, "恭喜完成小程序体验任务，+" + i, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onTaskFailure() {
                Toast.makeText(AppletActivity.this,"您体验小程序时间不够，请重新体验", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure() {

            }
        });
    }
}
