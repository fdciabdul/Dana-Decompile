package com.iap.ac.android.container.adapter.griver.event;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.griver.api.common.page.GriverAppEvent;
import com.iap.ac.android.common.container.event.IContainerListener;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.container.adapter.griver.constant.GriverAdapterKeys;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class AppEventHandler implements GriverAppEvent {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, IContainerListener> f7556a = new HashMap();
    private static List<IContainerListener> b = new ArrayList();

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    public static void addContainerListener(String str, IContainerListener iContainerListener) {
        if (iContainerListener != null) {
            f7556a.put(str, iContainerListener);
        }
    }

    public static void addContainerListener(IContainerListener iContainerListener) {
        if (iContainerListener == null || b.contains(iContainerListener)) {
            return;
        }
        b.add(iContainerListener);
    }

    public static void removeContainerListener(IContainerListener iContainerListener) {
        if (iContainerListener != null) {
            b.remove(iContainerListener);
        }
    }

    @Override // com.alibaba.griver.api.common.page.GriverAppEvent
    public void onAppStart(App app) {
        ACLog.d("AppEventHandler", "onAppStart");
        Bundle startParams = app.getStartParams();
        if (startParams == null) {
            ACLog.d("AppEventHandler", "onAppExit bundle is null");
            return;
        }
        List<IContainerListener> list = b;
        if (list != null) {
            Iterator<IContainerListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onContainerCreated(app.getStartParams());
            }
        }
        String string = startParams.getString(GriverAdapterKeys.PARAM_PAGE_ID);
        if (TextUtils.isEmpty(string)) {
            ACLog.d("AppEventHandler", "onAppExit pageId is empty");
            return;
        }
        IContainerListener iContainerListener = f7556a.get(string);
        if (iContainerListener != null) {
            iContainerListener.onContainerCreated(app.getStartParams());
        }
    }

    @Override // com.alibaba.griver.api.common.page.GriverAppEvent
    public void onAppExit(App app) {
        ACLog.d("AppEventHandler", "onAppExit");
        Bundle startParams = app.getStartParams();
        if (startParams == null) {
            ACLog.d("AppEventHandler", "onAppExit bundle is null");
            return;
        }
        Iterator<IContainerListener> it = b.iterator();
        while (it.hasNext()) {
            it.next().onContainerDestroyed(app.getStartParams());
        }
        String string = startParams.getString(GriverAdapterKeys.PARAM_PAGE_ID);
        if (TextUtils.isEmpty(string)) {
            ACLog.d("AppEventHandler", "onAppExit pageId is empty");
            return;
        }
        IContainerListener remove = f7556a.remove(string);
        if (remove != null) {
            remove.onContainerDestroyed(app.getStartParams());
        }
    }
}
