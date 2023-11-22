package com.alibaba.ariver.remotedebug.view;

import android.view.View;

/* loaded from: classes2.dex */
public interface IDebugInfoPanelView {
    View getView();

    void setActionEventListener(ActionEventListener actionEventListener);

    void setExitText(String str);

    void setMoveRange(int i, int i2, int i3, int i4);

    void setShown(boolean z);

    void setStateConnectFailed();

    void setStateConnected();

    void setStateConnecting();

    void setStateText(String str);
}
