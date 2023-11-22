package com.alibaba.griver.device.jsapi.screen;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.point.app.AppDestroyPoint;
import com.alibaba.ariver.app.api.point.biz.SnapshotPoint;
import com.alibaba.ariver.app.api.point.page.PageExitPoint;
import com.alibaba.ariver.app.api.point.page.PagePausePoint;
import com.alibaba.ariver.app.api.point.page.PageResumePoint;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.device.jsapi.screen.ScreenShotObserver;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes6.dex */
public class SnapshotExtension implements AppDestroyPoint, SnapshotPoint, PageExitPoint, PagePausePoint, PageResumePoint {
    private ScreenShotObserver c;

    /* renamed from: a  reason: collision with root package name */
    private final Set<Page> f6518a = new HashSet();
    private final Set<Page> b = new HashSet();
    private LocalBroadcastManager d = LocalBroadcastManager.getInstance(GriverEnv.getApplicationContext());
    private List<BroadcastReceiver> e = new ArrayList();

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppDestroyPoint
    public void onAppDestroy(App app) {
        ScreenShotObserver screenShotObserver = this.c;
        if (screenShotObserver != null) {
            screenShotObserver.release();
            this.c = null;
        }
        Set<Page> set = this.f6518a;
        if (set != null) {
            set.clear();
        }
        Set<Page> set2 = this.b;
        if (set2 != null) {
            set2.clear();
        }
        List<BroadcastReceiver> list = this.e;
        if (list != null) {
            Iterator<BroadcastReceiver> it = list.iterator();
            while (it.hasNext()) {
                this.d.unregisterReceiver(it.next());
            }
            this.e.clear();
        }
    }

    @Override // com.alibaba.ariver.app.api.point.biz.SnapshotPoint
    public void addScreenshotListener(final Page page) {
        if (this.f6518a.contains(page)) {
            return;
        }
        this.f6518a.add(page);
        this.b.add(page);
        if (this.c == null) {
            this.c = new ScreenShotObserver(GriverEnv.getApplicationContext());
        }
        this.c.registerListener(new ScreenShotObserver.H5ScreenShotListener() { // from class: com.alibaba.griver.device.jsapi.screen.SnapshotExtension.1
            @Override // com.alibaba.griver.device.jsapi.screen.ScreenShotObserver.H5ScreenShotListener
            public void onScreenShot() {
                Page activePage = page.getApp().getActivePage();
                if (activePage != null && activePage == page && SnapshotExtension.this.b.contains(page)) {
                    EngineUtils.sendToRender(page.getRender(), "screenshotbyuser", null, null);
                    RVLogger.d("SnapshotExtension", "send screenshotbyuser event");
                }
            }
        });
    }

    @Override // com.alibaba.ariver.app.api.point.biz.SnapshotPoint
    public void registerReceiever(BroadcastReceiver broadcastReceiver) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("embedview.snapshot.complete");
        this.e.add(broadcastReceiver);
        this.d.registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override // com.alibaba.ariver.app.api.point.biz.SnapshotPoint
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        this.e.remove(broadcastReceiver);
        this.d.unregisterReceiver(broadcastReceiver);
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageExitPoint
    public void onPageExit(Page page) {
        this.f6518a.remove(page);
        this.b.remove(page);
    }

    @Override // com.alibaba.ariver.app.api.point.page.PagePausePoint
    public void onPagePause(Page page) {
        this.b.remove(page);
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageResumePoint
    public void onPageResume(Page page) {
        this.b.add(page);
    }
}
