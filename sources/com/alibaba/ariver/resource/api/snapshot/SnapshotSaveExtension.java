package com.alibaba.ariver.resource.api.snapshot;

import android.os.Bundle;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.point.app.PushWindowPoint;
import com.alibaba.ariver.app.api.point.page.PagePausePoint;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* loaded from: classes6.dex */
public class SnapshotSaveExtension implements PushWindowPoint, PagePausePoint {
    @Override // com.alibaba.ariver.app.api.point.app.PushWindowPoint
    public boolean handlePushWindow(Page page, String str, Bundle bundle, Bundle bundle2) {
        return false;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.app.api.point.page.PagePausePoint
    public void onPagePause(Page page) {
    }

    /* renamed from: com.alibaba.ariver.resource.api.snapshot.SnapshotSaveExtension$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Page val$page;

        AnonymousClass1(Page page) {
            this.val$page = page;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                RVSnapshotUtils.handleSnapshotEvent(this.val$page);
            } catch (Throwable th) {
                RVLogger.w("AriverRes:SnapshotSaveExtension", "handleSnapshotEvent exception!", th);
            }
        }
    }
}
