package com.alibaba.ariver.remotedebug.core;

import android.app.Activity;
import android.content.Context;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.ariver.remotedebug.view.IDebugInfoPanelView;
import com.alibaba.ariver.remotedebug.view.IDebugStateView;

@DefaultImpl("com.alibaba.ariver.remotedebug.view.DefaultRemoteDebugViewProxyImpl")
/* loaded from: classes2.dex */
public interface RemoteDebugViewProxy extends Proxiable {
    void addDebugInfoPanelToUI(Activity activity, App app, IDebugInfoPanelView iDebugInfoPanelView);

    void addDebugStateViewToUI(Activity activity, App app, IDebugStateView iDebugStateView);

    IDebugInfoPanelView createDebugInfoPanelView(Context context, App app);

    IDebugStateView createDebugStateView(Context context, App app);
}
