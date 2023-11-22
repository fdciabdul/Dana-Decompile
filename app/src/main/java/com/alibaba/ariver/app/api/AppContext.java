package com.alibaba.ariver.app.api;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes2.dex */
public interface AppContext {
    void createTabBar(Page page);

    void destroy();

    void exitPage(Page page, boolean z);

    Intent getActivityStartIntent();

    Context getContext();

    boolean isTaskRoot();

    boolean moveToBackground();

    boolean pushPage(Page page);

    void start(Page page);
}
