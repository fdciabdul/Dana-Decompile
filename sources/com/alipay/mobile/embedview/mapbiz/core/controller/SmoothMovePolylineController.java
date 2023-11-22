package com.alipay.mobile.embedview.mapbiz.core.controller;

import android.os.Handler;
import android.os.Looper;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.alipay.mobile.apmap.AdapterAMap;
import com.alipay.mobile.apmap.model.AdapterLatLng;
import com.alipay.mobile.embedview.callback.H5JsCallback;
import com.alipay.mobile.embedview.mapbiz.core.H5AnimationThread;
import com.alipay.mobile.embedview.mapbiz.core.H5MapPolyline;
import com.alipay.mobile.embedview.mapbiz.data.Point;
import com.alipay.mobile.embedview.mapbiz.data.SmoothMovePolyline;
import com.alipay.mobile.embedview.mapbiz.line.MovableLine;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import com.alipay.mobile.embedview.mapbiz.utils.H5MapUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes6.dex */
public class SmoothMovePolylineController extends H5MapController {

    /* renamed from: a */
    private final Object f7171a;
    private SmoothMovePolyline b;
    private volatile H5MapPolyline c;
    private volatile boolean d;
    private volatile Handler e;

    public SmoothMovePolylineController(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
        this.f7171a = new Object();
    }

    public void smoothMovePolyline(JSONObject jSONObject, H5JsCallback h5JsCallback) {
        H5JsCallback h5JsCallback2;
        try {
            final SmoothMovePolyline smoothMovePolyline = (SmoothMovePolyline) JSON.toJavaObject(jSONObject, SmoothMovePolyline.class);
            if ("stop".equals(smoothMovePolyline.action)) {
                stopSmoothMovePolyline();
                h5JsCallback.sendSuccess();
                return;
            }
            if (this.b != null) {
                stopSmoothMovePolyline();
            }
            List<Point> obtainPoints = smoothMovePolyline.obtainPoints();
            if (obtainPoints != null) {
                try {
                    if (obtainPoints.size() >= 2) {
                        final AdapterAMap map = this.mMapContainer.getMap();
                        if (map != null && !map.is2dMapSdk()) {
                            List<AdapterLatLng> latLangPoints = Point.toLatLangPoints(map, obtainPoints);
                            boolean isMapAnimationUseThread = this.mMapContainer.configController.isMapAnimationUseThread();
                            int i = isMapAnimationUseThread ? 40 : 16;
                            double d = smoothMovePolyline.duration > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? smoothMovePolyline.duration : 5000.0d;
                            double d2 = i;
                            Double.isNaN(d2);
                            int i2 = (int) (d / d2);
                            final double calculateDistance = H5MapUtils.calculateDistance(latLangPoints);
                            double d3 = i2;
                            Double.isNaN(d3);
                            final double d4 = calculateDistance / d3;
                            final AtomicInteger atomicInteger = new AtomicInteger();
                            final MovableLine movableLine = new MovableLine(latLangPoints);
                            final AtomicLong atomicLong = new AtomicLong();
                            final int i3 = i;
                            int i4 = i;
                            Runnable runnable = new Runnable() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.SmoothMovePolylineController.1
                                {
                                    SmoothMovePolylineController.this = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        synchronized (SmoothMovePolylineController.this.f7171a) {
                                            if (SmoothMovePolylineController.this.d) {
                                                return;
                                            }
                                            if (atomicInteger.get() == 0) {
                                                atomicLong.set(System.currentTimeMillis());
                                            }
                                            double andAdd = atomicInteger.getAndAdd(1);
                                            double d5 = d4;
                                            movableLine.move(d5);
                                            Double.isNaN(andAdd);
                                            if (andAdd * d5 < calculateDistance) {
                                                SmoothMovePolylineController.this.updateContext(map, movableLine.getCurrentLine());
                                                if (SmoothMovePolylineController.this.e != null) {
                                                    SmoothMovePolylineController.this.e.postDelayed(this, i3);
                                                }
                                            } else {
                                                SmoothMovePolylineController.this.stopSmoothMovePolyline(false);
                                                double currentTimeMillis = System.currentTimeMillis() - atomicLong.get();
                                                Double.isNaN(currentTimeMillis);
                                                Double.isNaN(r3);
                                                Double.isNaN(r3);
                                                SmoothMovePolylineController.this.mMapContainer.reportController.reportDelayRate("smoothMovePolyline", (currentTimeMillis - r3) / r3);
                                                if (SmoothMovePolylineController.this.mMapContainer.getH5Page() != null) {
                                                    SmoothMovePolylineController.this.a(smoothMovePolyline);
                                                }
                                            }
                                        }
                                    } catch (Throwable th) {
                                        RVLogger.e(H5MapContainer.TAG, th);
                                        SmoothMovePolylineController.this.mMapContainer.reportController.reportException("SmoothMovePolylineController#run", th.getMessage());
                                    }
                                }
                            };
                            this.b = smoothMovePolyline;
                            this.d = false;
                            this.e = new Handler(isMapAnimationUseThread ? H5AnimationThread.getInstance().getLooper() : Looper.getMainLooper());
                            this.e.postDelayed(runnable, i4);
                            h5JsCallback.sendSuccess();
                            return;
                        }
                        this.mMapContainer.polylineController.addPolyline(map, smoothMovePolyline.toPolyline());
                        h5JsCallback.sendSuccess();
                        return;
                    }
                } catch (Throwable th) {
                    th = th;
                    h5JsCallback2 = h5JsCallback;
                    RVLogger.e(H5MapContainer.TAG, th);
                    h5JsCallback2.sendError(3, "unknown");
                    this.mMapContainer.reportController.reportException("SmoothMovePolylineController#smoothMovePolyline", th.getMessage());
                }
            }
            h5JsCallback2 = h5JsCallback;
            try {
                h5JsCallback2.sendError(2, "error param");
            } catch (Throwable th2) {
                th = th2;
                RVLogger.e(H5MapContainer.TAG, th);
                h5JsCallback2.sendError(3, "unknown");
                this.mMapContainer.reportController.reportException("SmoothMovePolylineController#smoothMovePolyline", th.getMessage());
            }
        } catch (Throwable th3) {
            th = th3;
            h5JsCallback2 = h5JsCallback;
        }
    }

    public void stopSmoothMovePolyline() {
        stopSmoothMovePolyline(true);
    }

    public void stopSmoothMovePolyline(boolean z) {
        if (this.b != null) {
            try {
                synchronized (this.f7171a) {
                    stopMove(z);
                    if (this.c != null) {
                        this.mMapContainer.polylineController.add(this.c);
                        this.c = null;
                    }
                }
            } catch (Throwable th) {
                RVLogger.e(H5MapContainer.TAG, th);
                this.mMapContainer.reportController.reportException("SmoothMovePolylineController#stopSmoothMovePolyline", th.getMessage());
            }
            this.b = null;
        }
    }

    public void updateContext(AdapterAMap adapterAMap, List<AdapterLatLng> list) {
        if (this.c != null) {
            this.c.setPoints(list);
        } else {
            this.c = this.mMapContainer.polylineController.addPolyline(adapterAMap, this.b.toPolyline(list));
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
        updateContext(this.mMapContainer.getMap(), Point.toLatLangPoints(this.mMapContainer.getMap(), this.b.obtainPoints()));
    }

    public void a(SmoothMovePolyline smoothMovePolyline) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("polylineId", (Object) smoothMovePolyline.polylineId);
        jSONObject2.put(LottieParams.KEY_ELEMENT_ID, (Object) this.mMapContainer.getElementId());
        jSONObject.put("data", (Object) jSONObject2);
        if (this.mMapContainer.getExtraJsCallback() != null) {
            this.mMapContainer.getExtraJsCallback().sendToWeb(this.mMapContainer.isCubeContainer() ? "polylineMoveEnd" : "nbcomponent.map.bindpolylinemoveend", jSONObject);
        }
    }
}
