package com.alibaba.ariver.remotedebug.view;

import android.view.View;

/* loaded from: classes2.dex */
public interface IDebugStateView {
    View getView();

    void setActionEventListener(ActionEventListener actionEventListener);

    void setExitText(String str);

    void setShown(boolean z);

    void setStateText(String str);
}
