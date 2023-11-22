package com.alipay.mobile.embedview.mapbiz.core.controller;

import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.embedview.mapbiz.core.H5ReplayEvent;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes6.dex */
public class ReplayController extends H5MapController {

    /* renamed from: a */
    private Page f7166a;
    private Queue<H5ReplayEvent> b;
    private int c;

    static /* synthetic */ int access$010(ReplayController replayController) {
        int i = replayController.c;
        replayController.c = i - 1;
        return i;
    }

    public ReplayController(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
        this.b = new ConcurrentLinkedQueue();
        this.c = 0;
    }

    public Page getPage() {
        return this.f7166a;
    }

    public void setPage(Page page) {
        this.f7166a = page;
    }

    public int getQueueSize() {
        return this.c;
    }

    public void handleEvent(H5ReplayEvent h5ReplayEvent) {
        if (h5ReplayEvent.isUrgent() || (this.mMapContainer.renderController.isReady() && this.c <= 0)) {
            play(h5ReplayEvent);
            return;
        }
        RVLogger.d(H5MapContainer.TAG, "ReplayController#handleEvent: queue up");
        this.b.offer(h5ReplayEvent);
        this.c++;
        if (this.b.size() >= 20 || this.mMapContainer.renderController.isReady()) {
            play();
        }
    }

    public void play() {
        if (this.c <= 0) {
            return;
        }
        this.mMapContainer.mainHandler.postDelayed(new Runnable() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.ReplayController.1
            {
                ReplayController.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (ReplayController.this.c > 0) {
                    ReplayController.access$010(ReplayController.this);
                    ReplayController replayController = ReplayController.this;
                    replayController.play((H5ReplayEvent) replayController.b.poll());
                    if (ReplayController.this.c <= 0 || !ReplayController.this.mMapContainer.renderController.isReady()) {
                        return;
                    }
                    ReplayController.this.mMapContainer.mainHandler.postDelayed(this, 16L);
                }
            }
        }, 16L);
    }

    public void play(H5ReplayEvent h5ReplayEvent) {
        if (h5ReplayEvent == null) {
            return;
        }
        if (this.mMapContainer.debuggable) {
            StringBuilder sb = new StringBuilder();
            sb.append("ReplayController#play: ");
            sb.append(h5ReplayEvent);
            RVLogger.d(H5MapContainer.TAG, sb.toString());
        }
        int type = h5ReplayEvent.getType();
        if (type == 1) {
            this.mMapContainer.renderController.doReceivedRender(h5ReplayEvent.getData(), h5ReplayEvent.getCallback());
        } else if (type == 2) {
            this.mMapContainer.mapAPIController.onReceivedMessage(h5ReplayEvent.getAction(), h5ReplayEvent.getData(), h5ReplayEvent.getCallback(), this.f7166a);
        }
    }

    public void onDestroy() {
        if (this.c != 0) {
            this.c = 0;
            this.b.clear();
            if (this.mMapContainer.debuggable) {
                RVLogger.e(H5MapContainer.TAG, "ReplayController#onDestroy: there are some events not be played");
            }
        }
    }
}
