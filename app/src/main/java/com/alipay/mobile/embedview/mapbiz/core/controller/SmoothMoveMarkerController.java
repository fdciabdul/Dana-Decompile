package com.alipay.mobile.embedview.mapbiz.core.controller;

import android.os.Handler;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.alipay.mobile.apmap.model.AdapterMarker;
import com.alipay.mobile.embedview.mapbiz.data.Point;
import com.alipay.mobile.embedview.mapbiz.data.SmoothMoveMarker;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import java.util.List;

/* loaded from: classes6.dex */
public class SmoothMoveMarkerController extends H5MapController {

    /* renamed from: a */
    private final Object f7170a;
    private SmoothMoveMarker b;
    private AdapterMarker c;
    private volatile boolean d;
    private volatile Handler e;

    public SmoothMoveMarkerController(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
        this.f7170a = new Object();
    }

    public boolean isMoving() {
        return this.b != null;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:166:0x013c
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public void smoothMoveMarker(com.alibaba.fastjson.JSONObject r20, com.alipay.mobile.embedview.callback.H5JsCallback r21) {
        /*
            Method dump skipped, instructions count: 362
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.embedview.mapbiz.core.controller.SmoothMoveMarkerController.smoothMoveMarker(com.alibaba.fastjson.JSONObject, com.alipay.mobile.embedview.callback.H5JsCallback):void");
    }

    public void stopSmoothMoveMarker() {
        stopSmoothMoveMarker(true);
    }

    public void stopSmoothMoveMarker(boolean z) {
        if (this.b != null) {
            try {
                synchronized (this.f7170a) {
                    stopMove(z);
                }
            } catch (Throwable th) {
                RVLogger.e(H5MapContainer.TAG, th);
                this.mMapContainer.reportController.reportException("SmoothMoveMarkerController#stopSmoothMovePolyline", th.getMessage());
            }
            this.b = null;
        }
    }

    public void stopMove(boolean z) {
        if (!this.d) {
            this.d = true;
            if (this.e != null) {
                this.e.removeCallbacksAndMessages(null);
                this.e = null;
            }
            if (z && this.mMapContainer.configController.isMapNotifyEndWhenStop()) {
                a(this.b);
            }
        }
        if (this.c == null) {
            return;
        }
        if (this.b.hideMarker) {
            this.c.setVisible(true);
        }
        List<Point> obtainPoints = this.b.obtainPoints();
        if (obtainPoints != null && obtainPoints.size() > 0) {
            try {
                this.c.setPosition(obtainPoints.get(obtainPoints.size() - 1).getLatLng(this.c));
            } catch (Throwable th) {
                RVLogger.e(H5MapContainer.TAG, th);
            }
        }
        this.c = null;
    }

    public void a(SmoothMoveMarker smoothMoveMarker) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("markerId", (Object) smoothMoveMarker.markerId);
        jSONObject2.put(LottieParams.KEY_ELEMENT_ID, (Object) this.mMapContainer.getElementId());
        jSONObject.put("data", (Object) jSONObject2);
        if (this.mMapContainer.getExtraJsCallback() != null) {
            this.mMapContainer.getExtraJsCallback().sendToWeb(this.mMapContainer.isCubeContainer() ? "markerMoveEnd" : "nbcomponent.map.bindmarkermoveend", jSONObject);
        }
    }
}
