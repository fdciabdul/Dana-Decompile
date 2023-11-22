package com.alibaba.ariver.v8worker.extension;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.point.app.AppLeaveHintPoint;
import com.alibaba.ariver.app.api.point.app.AppPausePoint;
import com.alibaba.ariver.app.api.point.app.AppResumePoint;
import com.alibaba.ariver.app.api.point.page.PageEnterPoint;
import com.alibaba.ariver.app.api.point.page.PageExitPoint;
import com.alibaba.ariver.app.api.point.page.PagePausePoint;
import com.alibaba.ariver.app.api.point.page.PageResumePoint;
import com.alibaba.ariver.app.api.point.view.TitleBarCloseClickPoint;
import com.alibaba.ariver.v8worker.V8Worker;

/* loaded from: classes6.dex */
public class V8WorkerExtension implements AppLeaveHintPoint, AppPausePoint, AppResumePoint, PageEnterPoint, PageExitPoint, PagePausePoint, PageResumePoint, TitleBarCloseClickPoint {
    private V8Worker mV8Worker;

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    public V8WorkerExtension(V8Worker v8Worker) {
        this.mV8Worker = v8Worker;
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppPausePoint
    public void onAppPause(App app) {
        V8Worker v8Worker = this.mV8Worker;
        if (v8Worker != null) {
            v8Worker.onSessionPause();
        }
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppResumePoint
    public void onAppResume(App app) {
        V8Worker v8Worker = this.mV8Worker;
        if (v8Worker != null) {
            v8Worker.onSessionResume();
        }
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageExitPoint
    public void onPageExit(Page page) {
        V8Worker v8Worker = this.mV8Worker;
        if (v8Worker != null) {
            v8Worker.onPageClose(page);
        }
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageEnterPoint
    public void onPageEnter(Page page) {
        V8Worker v8Worker = this.mV8Worker;
        if (v8Worker != null) {
            v8Worker.onPageCreate(page);
        }
    }

    @Override // com.alibaba.ariver.app.api.point.page.PagePausePoint
    public void onPagePause(Page page) {
        V8Worker v8Worker = this.mV8Worker;
        if (v8Worker != null) {
            v8Worker.onPagePause(page);
        }
    }

    @Override // com.alibaba.ariver.app.api.point.page.PageResumePoint
    public void onPageResume(Page page) {
        V8Worker v8Worker = this.mV8Worker;
        if (v8Worker != null) {
            v8Worker.onPageResume(page);
        }
    }

    @Override // com.alibaba.ariver.app.api.point.app.AppLeaveHintPoint
    public void onAppLeaveHint(App app) {
        V8Worker v8Worker = this.mV8Worker;
        if (v8Worker != null) {
            v8Worker.onSessionLeaveHint();
        }
    }

    @Override // com.alibaba.ariver.app.api.point.view.TitleBarCloseClickPoint
    public void onCloseClick() {
        this.mV8Worker.onSessionTitleBarClose();
    }
}
