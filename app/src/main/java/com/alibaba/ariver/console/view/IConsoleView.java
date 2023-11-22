package com.alibaba.ariver.console.view;

import android.view.View;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes6.dex */
public interface IConsoleView {
    void destroy();

    View getView();

    void sendMsg(String str, JSONObject jSONObject);
}
