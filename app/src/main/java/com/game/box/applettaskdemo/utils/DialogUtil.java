package com.game.box.applettaskdemo.utils;

import android.app.Dialog;
import android.content.Context;


/*
 * Copyright (C) 2018
 * 版权所有
 *
 * 功能描述：Dialog工具类
 */
public class DialogUtil {

    /**
     * 进度条
     */
    public static Dialog showLoadingDialog(Context context) {
        Dialog dialog = new Dialog(context, com.game.box.ydlibrary.R.style.DialogStyle);
        dialog.setContentView(com.game.box.ydlibrary.R.layout.dialog_progress_loading);
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }

}
