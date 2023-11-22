package com.alibaba.griver.core.proxy;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ui.titlebar.TitleBar;
import com.alibaba.ariver.app.proxy.RVScreenOrientationProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* loaded from: classes6.dex */
public class GriverScreenOrientationProxyImpl implements RVScreenOrientationProxy {
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
        if (requestedOrientation != -1) {
            if (requestedOrientation != 0) {
                if (requestedOrientation != 1) {
                    return null;
                }
                return "portrait";
            }
            return "landscape";
        }
        return "auto";
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
        char c;
        StringBuilder sb = new StringBuilder();
        sb.append("setScreenOrientation ");
        sb.append(str);
        sb.append(" for activity: ");
        sb.append(activity);
        RVLogger.d("AriverInt:DefaultScreenOrientationProxyImpl", sb.toString());
        if (str == null) {
            return false;
        }
        str.hashCode();
        int hashCode = str.hashCode();
        if (hashCode == 3005871) {
            if (str.equals("auto")) {
                c = 0;
            }
            c = 65535;
        } else if (hashCode != 729267099) {
            if (hashCode == 1430647483 && str.equals("landscape")) {
                c = 2;
            }
            c = 65535;
        } else {
            if (str.equals("portrait")) {
                c = 1;
            }
            c = 65535;
        }
        if (c == 0) {
            if (activity.getRequestedOrientation() != -1) {
                activity.setRequestedOrientation(-1);
                if (page != null) {
                    a(page, true);
                }
            }
            return true;
        } else if (c == 1) {
            if (activity.getRequestedOrientation() != 1) {
                activity.setRequestedOrientation(1);
                if (page != null) {
                    a(page, true);
                }
            }
            return true;
        } else if (c != 2) {
            return false;
        } else {
            if (activity.getRequestedOrientation() != 0) {
                activity.setRequestedOrientation(0);
                if (page != null) {
                    a(page, false);
                }
            }
            return true;
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
