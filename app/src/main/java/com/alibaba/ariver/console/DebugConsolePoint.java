package com.alibaba.ariver.console;

import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes2.dex */
public interface DebugConsolePoint extends Extension {
    boolean isDebugPanelExists();

    void removeConsoleView();

    void sendMsgToConsoleView(JSONObject jSONObject);

    void showToggleButton(boolean z);

    void toggleConsoleView();
}
