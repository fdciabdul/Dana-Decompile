package com.alibaba.ariver.remotedebug.view;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.common.utils.DisplayUtils;
import com.alibaba.ariver.remotedebug.core.RemoteDebugViewProxy;

/* loaded from: classes6.dex */
public class DefaultRemoteDebugViewProxyImpl implements RemoteDebugViewProxy {
    @Override // com.alibaba.ariver.remotedebug.core.RemoteDebugViewProxy
    public IDebugInfoPanelView createDebugInfoPanelView(Context context, App app) {
        return new RemoteDebugInfoPanelView(context);
    }

    @Override // com.alibaba.ariver.remotedebug.core.RemoteDebugViewProxy
    public IDebugStateView createDebugStateView(Context context, App app) {
        return new RemoteDebugStateView(context);
    }

    @Override // com.alibaba.ariver.remotedebug.core.RemoteDebugViewProxy
    public void addDebugInfoPanelToUI(Activity activity, App app, IDebugInfoPanelView iDebugInfoPanelView) {
        int titleAndStatusBarHeight = DisplayUtils.getTitleAndStatusBarHeight(activity);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        layoutParams.rightMargin = 20;
        int i = titleAndStatusBarHeight + 20;
        layoutParams.topMargin = i;
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        iDebugInfoPanelView.setMoveRange(0, i, viewGroup.getWidth(), viewGroup.getHeight());
        viewGroup.addView(iDebugInfoPanelView.getView(), layoutParams);
    }

    @Override // com.alibaba.ariver.remotedebug.core.RemoteDebugViewProxy
    public void addDebugStateViewToUI(Activity activity, App app, IDebugStateView iDebugStateView) {
        ((ViewGroup) activity.findViewById(16908290)).addView(iDebugStateView.getView(), -1, -1);
    }
}
