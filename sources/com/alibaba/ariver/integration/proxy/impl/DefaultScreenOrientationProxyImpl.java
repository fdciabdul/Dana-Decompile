package com.alibaba.ariver.integration.proxy.impl;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ui.titlebar.TitleBar;
import com.alibaba.ariver.app.proxy.RVScreenOrientationProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* loaded from: classes6.dex */
public class DefaultScreenOrientationProxyImpl implements RVScreenOrientationProxy {
    @Override // com.alibaba.ariver.app.proxy.RVScreenOrientationProxy
    public String getScreenOrientation(Activity activity) {
        if (activity == null) {
            return null;
        }
        String a2 = a(activity);
        return a2 == null ? a((Context) activity) : a2;
    }

    private static String a(Activity activity) {
        int requestedOrientation = activity.getRequestedOrientation();
        if (requestedOrientation != 0) {
            if (requestedOrientation != 1) {
                return null;
            }
            return "portrait";
        }
        return "landscape";
    }

    private static String a(Context context) {
        int i = context.getResources().getConfiguration().orientation;
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return "landscape";
        }
        return "portrait";
    }

    @Override // com.alibaba.ariver.app.proxy.RVScreenOrientationProxy
    public boolean setScreenOrientation(Activity activity, String str, Page page) {
        StringBuilder sb = new StringBuilder();
        sb.append("setScreenOrientation ");
        sb.append(str);
        sb.append(" for activity: ");
        sb.append(activity);
        RVLogger.d("AriverInt:DefaultScreenOrientationProxyImpl", sb.toString());
        str.hashCode();
        if (str.equals("portrait")) {
            if (activity.getRequestedOrientation() != 1) {
                activity.setRequestedOrientation(1);
                Window window = activity.getWindow();
                if (window != null) {
                    window.clearFlags(1024);
                    window.addFlags(2048);
                }
                if (page != null) {
                    a(page, true);
                }
            }
            return true;
        } else if (str.equals("landscape")) {
            if (activity.getRequestedOrientation() != 0) {
                activity.setRequestedOrientation(0);
                Window window2 = activity.getWindow();
                if (window2 != null) {
                    window2.clearFlags(2048);
                    window2.addFlags(1024);
                }
                if (page != null) {
                    a(page, false);
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private void a(Page page, boolean z) {
        TitleBar titleBar;
        if (page == null || page.getPageContext() == null || (titleBar = page.getPageContext().getTitleBar()) == null) {
            return;
        }
        View content = titleBar.getContent();
        if (content != null) {
            content.setVisibility(z ? 0 : 8);
        }
        View divider = titleBar.getDivider();
        if (divider != null) {
            divider.setVisibility(z ? 0 : 8);
        }
    }
}
