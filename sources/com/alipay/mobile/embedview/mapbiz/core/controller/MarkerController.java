package com.alipay.mobile.embedview.mapbiz.core.controller;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.alibaba.griver.map.R;
import com.alipay.mobile.apmap.AdapterAMap;
import com.alipay.mobile.apmap.AdapterTextureMapView;
import com.alipay.mobile.apmap.model.AdapterBitmapDescriptorFactory;
import com.alipay.mobile.apmap.model.AdapterCameraPosition;
import com.alipay.mobile.apmap.model.AdapterLatLng;
import com.alipay.mobile.apmap.model.AdapterMarker;
import com.alipay.mobile.apmap.model.AdapterMarkerOptions;
import com.alipay.mobile.embedview.callback.H5DataCallback;
import com.alipay.mobile.embedview.mapbiz.core.H5MapMarker;
import com.alipay.mobile.embedview.mapbiz.data.CustomCallout;
import com.alipay.mobile.embedview.mapbiz.data.FixedPoint;
import com.alipay.mobile.embedview.mapbiz.data.Marker;
import com.alipay.mobile.embedview.mapbiz.data.RichTextInfo;
import com.alipay.mobile.embedview.mapbiz.marker.MarkerStyle;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import com.alipay.mobile.embedview.mapbiz.utils.H5MapUtils;
import com.alipay.mobile.zebra.Zebra;
import com.alipay.mobile.zebra.ZebraLoader;
import com.alipay.mobile.zebra.data.ZebraData;
import com.alipay.mobile.zebra.layout.ZebraLayout;
import com.alipay.mobile.zebra.utils.ZebraUtils;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.onboarding.splash.LauncherActivity;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes6.dex */
public class MarkerController extends H5MapController {
    public static final byte[] $$a = {104, -68, 0, 44, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 116;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {121, 107, -47, -24, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int PlaceComponentResult = 202;

    /* renamed from: a */
    private int f7160a;
    private int b;
    private AdapterAMap.OnAdapterMarkerClickListener c;
    private AdapterAMap.OnAdapterInfoWindowClickListener d;
    public final ConcurrentHashMap<String, H5MapMarker> h5MapMarkers;

    private float a(double d) {
        if (d < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            d = 0.0d;
        } else if (d > 1.0d) {
            d = 1.0d;
        }
        return (float) d;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002d -> B:23:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void e(byte r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 + 105
            int r7 = r7 * 15
            int r7 = 18 - r7
            byte[] r0 = com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController.KClassImpl$Data$declaredNonStaticMembers$2
            int r6 = r6 * 3
            int r6 = 16 - r6
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r8 = r7
            r3 = r1
            r4 = 0
            r7 = r6
            r1 = r0
            r0 = r9
            r9 = r8
            goto L36
        L1b:
            r3 = 0
        L1c:
            int r7 = r7 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L2d
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2d:
            r3 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L36:
            int r8 = r8 + r6
            int r8 = r8 + 2
            r6 = r7
            r7 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController.e(byte, byte, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002d -> B:23:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void f(byte r7, int r8, int r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 * 4
            int r8 = r8 + 42
            int r9 = r9 * 3
            int r9 = 4 - r9
            byte[] r0 = com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController.$$a
            int r7 = r7 * 3
            int r7 = 75 - r7
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L1a
            r7 = r8
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L36
        L1a:
            r3 = 0
            r6 = r9
            r9 = r7
        L1d:
            r7 = r6
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r8) goto L2d
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2d:
            r3 = r0[r7]
            r6 = r10
            r10 = r7
            r7 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L36:
            int r8 = -r8
            int r9 = r9 + r8
            int r9 = r9 + (-7)
            int r8 = r10 + 1
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r8
            r8 = r7
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController.f(byte, int, int, java.lang.Object[]):void");
    }

    public MarkerController(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
        this.h5MapMarkers = new ConcurrentHashMap<>();
        this.c = new AdapterAMap.OnAdapterMarkerClickListener() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController.5
            {
                MarkerController.this = this;
            }

            @Override // com.alipay.mobile.apmap.AdapterAMap.OnAdapterMarkerClickListener
            public boolean onMarkerClick(AdapterMarker adapterMarker) {
                Marker markerData = H5MapMarker.getMarkerData(adapterMarker);
                if (markerData == null || MarkerController.this.mMapContainer.getH5Page() == null) {
                    return true;
                }
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onMarkerClick ");
                    sb.append(JSON.toJSONString(markerData));
                    sb.append(" title = ");
                    sb.append(adapterMarker.getTitle());
                    sb.append(" snip = ");
                    sb.append(adapterMarker.getSnippet());
                    RVLogger.d("MarkerController", sb.toString());
                } catch (Exception e) {
                    RVLogger.e("MarkerController", e);
                }
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                AdapterLatLng position = adapterMarker.getPosition();
                if (position != null) {
                    jSONObject2.put("latitude", (Object) Double.valueOf(position.getLatitude()));
                    jSONObject2.put("longitude", (Object) Double.valueOf(position.getLongitude()));
                }
                jSONObject2.put("markerId", (Object) (markerData.f7175id == null ? "" : markerData.f7175id));
                jSONObject2.put(LottieParams.KEY_ELEMENT_ID, (Object) MarkerController.this.mMapContainer.getElementId());
                jSONObject.put("data", (Object) jSONObject2);
                if (MarkerController.this.mMapContainer.getExtraJsCallback() != null) {
                    MarkerController.this.mMapContainer.getExtraJsCallback().sendToWeb(MarkerController.this.mMapContainer.isCubeContainer() ? "markerTap" : "nbcomponent.map.bindmarkertap", jSONObject);
                }
                if (markerData.label == null && (markerData.title != null || (markerData.callout != null && markerData.callout.content != null))) {
                    adapterMarker.showInfoWindow();
                }
                if (markerData.customCallout != null && markerData.customCallout.canShowOnTap && markerData.customCallout.hasDescription()) {
                    adapterMarker.showInfoWindow();
                }
                return true;
            }
        };
        this.d = new AdapterAMap.OnAdapterInfoWindowClickListener() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController.6
            {
                MarkerController.this = this;
            }

            @Override // com.alipay.mobile.apmap.AdapterAMap.OnAdapterInfoWindowClickListener
            public void onInfoWindowClick(AdapterMarker adapterMarker) {
                Marker markerData = H5MapMarker.getMarkerData(adapterMarker);
                if (markerData == null || MarkerController.this.mMapContainer.getH5Page() == null) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("onInfoWindowClick ");
                sb.append(markerData.f7175id);
                RVLogger.d("MarkerController", sb.toString());
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                AdapterLatLng position = adapterMarker.getPosition();
                if (position != null) {
                    jSONObject2.put("latitude", (Object) Double.valueOf(position.getLatitude()));
                    jSONObject2.put("longitude", (Object) Double.valueOf(position.getLongitude()));
                }
                jSONObject2.put("markerId", (Object) (markerData.f7175id == null ? "" : markerData.f7175id));
                jSONObject2.put(LottieParams.KEY_ELEMENT_ID, (Object) MarkerController.this.mMapContainer.getElementId());
                jSONObject.put("data", (Object) jSONObject2);
                if (MarkerController.this.mMapContainer.getExtraJsCallback() != null) {
                    MarkerController.this.mMapContainer.getExtraJsCallback().sendToWeb(MarkerController.this.mMapContainer.isCubeContainer() ? "calloutTap" : "nbcomponent.map.bindcallouttap", jSONObject);
                }
            }
        };
    }

    public void onCreate() {
        try {
            byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1);
            Object[] objArr = new Object[1];
            e(b, b, (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1);
            byte b3 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]);
            Object[] objArr2 = new Object[1];
            e(b2, b3, (byte) (b3 - 1), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + 494, 4 - KeyEvent.normalizeMetaState(0), (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())));
                    byte b4 = $$a[2];
                    byte b5 = b4;
                    Object[] objArr4 = new Object[1];
                    f(b4, b5, b5, objArr4);
                    obj = cls2.getMethod((String) objArr4[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj);
                }
                Object[] objArr5 = (Object[]) ((Method) obj).invoke(null, objArr3);
                int i = ((int[]) objArr5[1])[0];
                if (((int[]) objArr5[0])[0] != i) {
                    long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getPressedStateDuration() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - TextUtils.indexOf("", ""), (char) ((-16777216) - Color.rgb(0, 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {990095223, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((Process.getThreadPriority(0) + 20) >> 6) + 911, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 17, (char) Color.green(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj3);
                            }
                            ((Method) obj3).invoke(invoke, objArr6);
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 == null) {
                            throw th2;
                        }
                        throw cause2;
                    }
                }
                this.mMapContainer.configController.getMaxMarkerCount();
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 == null) {
                    throw th3;
                }
                throw cause3;
            }
        } catch (Throwable th4) {
            Throwable cause4 = th4.getCause();
            if (cause4 == null) {
                throw th4;
            }
            throw cause4;
        }
    }

    public AdapterMarker findAdapterMarkerById(String str) {
        H5MapMarker h5MapMarker;
        if (TextUtils.isEmpty(str) || (h5MapMarker = this.h5MapMarkers.get(str)) == null) {
            return null;
        }
        return h5MapMarker.markerContext;
    }

    public H5MapMarker findH5MapMarkerById(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        H5MapMarker h5MapMarker = this.h5MapMarkers.get(str);
        return h5MapMarker != null ? h5MapMarker : this.mMapContainer.markerClusterController.findRootH5MapMarkerById(str);
    }

    public void updateComponentsForMarkers(List<Marker> list) {
        if (list == null || list.size() == 0) {
            clear();
            return;
        }
        AdapterAMap map = this.mMapContainer.getMap();
        if (map == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        int size = list.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            Marker marker = list.get(i);
            if (marker != null) {
                if (!TextUtils.isEmpty(marker.f7175id)) {
                    if (this.h5MapMarkers.containsKey(marker.f7175id)) {
                        hashMap.put(marker.f7175id, marker);
                    } else {
                        hashMap2.put(marker.f7175id, marker);
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("$_$");
                    sb.append(i);
                    hashMap2.put(sb.toString(), marker);
                }
                if (marker.customCallout != null) {
                    if (marker.customCallout.isShow == 1 && !z) {
                        marker.customCallout.canShowOnLoad = true;
                        z = true;
                    } else {
                        marker.customCallout.canShowOnLoad = false;
                    }
                }
            }
        }
        for (Map.Entry<String, H5MapMarker> entry : this.h5MapMarkers.entrySet()) {
            String key = entry.getKey();
            if (!hashMap.containsKey(key) && !hashMap2.containsKey(key)) {
                H5MapMarker value = entry.getValue();
                value.markerContext.remove();
                hashMap3.put(key, value.marker);
            }
        }
        HashMap hashMap4 = new HashMap();
        for (Map.Entry entry2 : hashMap.entrySet()) {
            String str = (String) entry2.getKey();
            Marker marker2 = (Marker) entry2.getValue();
            H5MapMarker h5MapMarker = this.h5MapMarkers.get(str);
            if (h5MapMarker != null) {
                h5MapMarker.marker = marker2;
                hashMap4.put(str, h5MapMarker);
                updateMarker(h5MapMarker);
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("updateComponentsForMarkers update marker error: ");
                sb2.append(str);
                RVLogger.e(H5MapContainer.TAG, sb2.toString());
            }
        }
        this.h5MapMarkers.clear();
        this.h5MapMarkers.putAll(hashMap4);
        if (hashMap2.size() != 0) {
            setMarkers(map, new ArrayList(hashMap2.values()));
        }
        onMarkersChanged();
        onCameraChanged(map.getCameraPosition(), false);
    }

    public void onMarkersChanged() {
        this.mMapContainer.markerClusterController.onMarkersChanged();
    }

    public List<Marker> checkMarkers(List<Marker> list, boolean z) {
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            int maxMarkerCount = this.mMapContainer.configController.getMaxMarkerCount();
            if (maxMarkerCount > 0 && size > maxMarkerCount) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.mMapContainer.getAppId());
                sb.append(" markers is overflow ");
                sb.append(maxMarkerCount);
                sb.append(",");
                sb.append(size);
                RVLogger.d(H5MapContainer.TAG, sb.toString());
                list = list.subList(0, maxMarkerCount);
            }
            if (!z) {
                this.mMapContainer.reportController.reportMarkerLimit(size);
            }
        }
        return list;
    }

    public boolean removeMarker(Marker marker) {
        H5MapMarker h5MapMarker;
        if (marker == null || TextUtils.isEmpty(marker.f7175id) || (h5MapMarker = this.h5MapMarkers.get(marker.f7175id)) == null) {
            return false;
        }
        if (h5MapMarker.markerContext != null) {
            h5MapMarker.markerContext.remove();
        }
        this.h5MapMarkers.remove(h5MapMarker);
        h5MapMarker.onRemove();
        return true;
    }

    public boolean updateMarker(Marker marker) {
        H5MapMarker h5MapMarker;
        if (marker == null || TextUtils.isEmpty(marker.f7175id) || (h5MapMarker = this.h5MapMarkers.get(marker.f7175id)) == null) {
            return false;
        }
        h5MapMarker.marker = marker;
        updateMarker(h5MapMarker);
        return true;
    }

    public void updateMarker(final H5MapMarker h5MapMarker) {
        Bitmap iconWithString;
        Context context = this.mMapContainer.getContext();
        if (context == null) {
            return;
        }
        AdapterMarker adapterMarker = h5MapMarker.markerContext;
        final Marker marker = h5MapMarker.marker;
        Marker marker2 = (Marker) adapterMarker.getObject();
        if (this.mMapContainer.configController.isCheckMarkerToken() && marker2 != null && marker2.isSame(marker)) {
            if (this.mMapContainer.debuggable) {
                StringBuilder sb = new StringBuilder();
                sb.append("updateMarker same data: ");
                sb.append(h5MapMarker.f7140id);
                RVLogger.d(H5MapContainer.TAG, sb.toString());
                return;
            }
            return;
        }
        AdapterTextureMapView mapView = this.mMapContainer.getMapView();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("updateMarker begin id = ");
        sb2.append(marker.f7175id);
        RVLogger.d(H5MapContainer.TAG, sb2.toString());
        adapterMarker.setObject(marker);
        if (marker.fixedPoint == null) {
            adapterMarker.setPosition(new AdapterLatLng(mapView, marker.latitude, marker.longitude));
        }
        adapterMarker.setSnippet(a(marker));
        adapterMarker.setTitle(marker.title);
        h5MapMarker.onUpdate();
        final long obtainMarkerToken = h5MapMarker.obtainMarkerToken();
        if (marker.iconLayout != null && this.mMapContainer.configController.isMapDSLEnabled()) {
            this.mMapContainer.layoutController.applyLayoutParams(marker.iconLayout, new AnonymousClass1(h5MapMarker, obtainMarkerToken, context));
        } else if (marker.style != null) {
            MarkerStyle fromJSONObject = MarkerStyle.fromJSONObject(marker.style, this.mMapContainer);
            if (fromJSONObject != null) {
                fromJSONObject.getBitmap(new MarkerStyle.Callback() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController.2
                    {
                        MarkerController.this = this;
                    }

                    @Override // com.alipay.mobile.embedview.mapbiz.marker.MarkerStyle.Callback
                    public boolean call(Bitmap bitmap, int i) {
                        if (MarkerController.this.mMapContainer.configController.isCheckMarkerToken() && h5MapMarker.isMarkerTokenInvalid(obtainMarkerToken)) {
                            return true;
                        }
                        if (i == 0 || i == 1) {
                            MarkerController.this.a(h5MapMarker, bitmap);
                            return false;
                        }
                        return false;
                    }
                });
            }
        } else if (!TextUtils.isEmpty(marker.iconPath)) {
            this.mMapContainer.resourceLoader.loadImage(marker.iconPath, new ZebraLoader.OnLoadImageCallback() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController.3
                {
                    MarkerController.this = this;
                }

                @Override // com.alipay.mobile.zebra.ZebraLoader.OnLoadImageCallback
                public void onComplete(Bitmap bitmap) {
                    if (MarkerController.this.mMapContainer.configController.isCheckMarkerToken() && h5MapMarker.isMarkerTokenInvalid(obtainMarkerToken)) {
                        return;
                    }
                    if (!TextUtils.isEmpty(marker.iconAppendStr)) {
                        bitmap = H5MapUtils.getIconWithString(MarkerController.this.mMapContainer.getContext(), marker.iconAppendStr, marker.iconAppendStrColor, bitmap);
                    }
                    MarkerController.this.a(h5MapMarker, bitmap);
                }
            });
        } else {
            if (TextUtils.isEmpty(marker.iconAppendStr)) {
                iconWithString = BitmapFactory.decodeResource(context.getResources(), R.drawable.griver_map_marker);
            } else {
                iconWithString = H5MapUtils.getIconWithString(context, marker.iconAppendStr, marker.iconAppendStrColor, null);
            }
            a(h5MapMarker, iconWithString);
        }
    }

    /* renamed from: com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController$1 */
    /* loaded from: classes6.dex */
    public class AnonymousClass1 implements H5DataCallback<String> {
        final /* synthetic */ Context val$ctx;
        final /* synthetic */ H5MapMarker val$h5MapMarker;
        final /* synthetic */ long val$markerToken;

        AnonymousClass1(H5MapMarker h5MapMarker, long j, Context context) {
            MarkerController.this = r1;
            this.val$h5MapMarker = h5MapMarker;
            this.val$markerToken = j;
            this.val$ctx = context;
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x006d  */
        /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
        @Override // com.alipay.mobile.embedview.callback.H5DataCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void callback(java.lang.String r6) {
            /*
                r5 = this;
                com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController r0 = com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController.this
                com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer r0 = r0.mMapContainer
                com.alipay.mobile.embedview.mapbiz.core.controller.ConfigController r0 = r0.configController
                boolean r0 = r0.isCheckMarkerToken()
                if (r0 == 0) goto L17
                com.alipay.mobile.embedview.mapbiz.core.H5MapMarker r0 = r5.val$h5MapMarker
                long r1 = r5.val$markerToken
                boolean r0 = r0.isMarkerTokenInvalid(r1)
                if (r0 == 0) goto L17
                return
            L17:
                boolean r0 = android.text.TextUtils.isEmpty(r6)
                java.lang.String r1 = "H5EmbedMapView"
                r2 = 1
                if (r0 == 0) goto L31
                java.lang.String r6 = "update marker dsl is empty"
                com.alibaba.ariver.kernel.common.utils.RVLogger.e(r1, r6)
                com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController r6 = com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController.this
                com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer r6 = r6.mMapContainer
                com.alipay.mobile.embedview.mapbiz.core.controller.ReportController r6 = r6.reportController
                r0 = 0
                r6.reportRenderDSL(r0, r2)
                return
            L31:
                com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController r0 = com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController.this
                com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer r0 = r0.mMapContainer
                com.alipay.mobile.embedview.mapbiz.core.controller.ConfigController r0 = r0.configController
                boolean r0 = r0.isMapDSLCacheEnabled()
                r0 = r0 ^ r2
                if (r0 != 0) goto L6a
                com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController r3 = com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController.this
                com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer r3 = r3.mMapContainer
                com.alipay.mobile.embedview.mapbiz.core.controller.CacheController r3 = r3.cacheController
                android.graphics.Bitmap r3 = r3.getCacheOfDSL(r6)
                if (r3 == 0) goto L6b
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r4 = "updateMarker use cache: "
                r2.append(r4)
                com.alipay.mobile.embedview.mapbiz.core.H5MapMarker r4 = r5.val$h5MapMarker
                java.lang.String r4 = r4.f7140id
                r2.append(r4)
                java.lang.String r2 = r2.toString()
                com.alibaba.ariver.kernel.common.utils.RVLogger.d(r1, r2)
                com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController r1 = com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController.this
                com.alipay.mobile.embedview.mapbiz.core.H5MapMarker r2 = r5.val$h5MapMarker
                com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController.access$000(r1, r2, r3)
            L6a:
                r2 = r0
            L6b:
                if (r2 == 0) goto L96
                java.util.concurrent.atomic.AtomicLong r0 = new java.util.concurrent.atomic.AtomicLong
                long r1 = java.lang.System.currentTimeMillis()
                r0.<init>(r1)
                com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController$1$1 r1 = new com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController$1$1
                r1.<init>(r0, r6)
                com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController r0 = com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController.this
                com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer r0 = r0.mMapContainer
                com.alipay.mobile.embedview.mapbiz.core.controller.LayoutController r0 = r0.layoutController
                com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController r2 = com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController.this
                com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer r2 = r2.mMapContainer
                com.alipay.mobile.embedview.mapbiz.core.controller.ConfigController r2 = r2.configController
                boolean r2 = r2.isMapDSLAsync()
                com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController r3 = com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController.this
                com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer r3 = r3.mMapContainer
                com.alipay.mobile.embedview.mapbiz.core.controller.LayoutController r3 = r3.layoutController
                com.alipay.mobile.zebra.core.ZebraOption r3 = r3.markerOption
                r0.parseLayoutData(r2, r6, r3, r1)
            L96:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController.AnonymousClass1.callback(java.lang.String):void");
        }

        /* renamed from: com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController$1$1 */
        /* loaded from: classes6.dex */
        public class C00711 implements H5DataCallback<ZebraData<? extends ZebraLayout>> {
            final /* synthetic */ String val$dsl;
            final /* synthetic */ AtomicLong val$parseBeginTag;

            C00711(AtomicLong atomicLong, String str) {
                AnonymousClass1.this = r1;
                this.val$parseBeginTag = atomicLong;
                this.val$dsl = str;
            }

            @Override // com.alipay.mobile.embedview.callback.H5DataCallback
            public void callback(ZebraData<? extends ZebraLayout> zebraData) {
                if (MarkerController.this.mMapContainer.configController.isCheckMarkerToken() && AnonymousClass1.this.val$h5MapMarker.isMarkerTokenInvalid(AnonymousClass1.this.val$markerToken)) {
                    return;
                }
                if (zebraData == null) {
                    RVLogger.e(H5MapContainer.TAG, "update marker dsl parse result nothing");
                    MarkerController.this.mMapContainer.reportController.reportRenderDSL(false, 1);
                    return;
                }
                AtomicLong atomicLong = new AtomicLong(System.currentTimeMillis());
                MarkerController.this.mMapContainer.reportController.reportDSLTime(1, atomicLong.get() - this.val$parseBeginTag.get());
                final AtomicLong atomicLong2 = new AtomicLong(0L);
                if (Zebra.render(AnonymousClass1.this.val$ctx, zebraData, MarkerController.this.mMapContainer.resourceLoader, new Zebra.OnLoadCallback() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController.1.1.1
                    {
                        C00711.this = this;
                    }

                    @Override // com.alipay.mobile.zebra.Zebra.OnLoadCallback
                    public void onLoad(View view, ZebraData<? extends ZebraLayout> zebraData2, ZebraLayout<? extends ZebraData> zebraLayout) {
                        if (MarkerController.this.mMapContainer.configController.isCheckMarkerToken() && AnonymousClass1.this.val$h5MapMarker.isMarkerTokenInvalid(AnonymousClass1.this.val$markerToken)) {
                            return;
                        }
                        MarkerController.this.mMapContainer.reportController.reportDSLTime(3, new AtomicLong(System.currentTimeMillis()).get() - atomicLong2.get());
                        boolean canUpdate = Zebra.canUpdate(view);
                        if (canUpdate) {
                            Zebra.bindOnUpdateCallback(view, new Zebra.OnUpdateCallback() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController.1.1.1.1
                                {
                                    C00721.this = this;
                                }

                                @Override // com.alipay.mobile.zebra.Zebra.OnUpdateCallback
                                public void onUpdate(View view2, ZebraData<? extends ZebraLayout> zebraData3, ZebraLayout<? extends ZebraData> zebraLayout2) {
                                    Bitmap snapshot;
                                    if ((MarkerController.this.mMapContainer.configController.isCheckMarkerToken() && AnonymousClass1.this.val$h5MapMarker.isMarkerTokenInvalid(AnonymousClass1.this.val$markerToken)) || (snapshot = ZebraUtils.snapshot(Zebra.getRootView(view2))) == null) {
                                        return;
                                    }
                                    MarkerController.this.a(AnonymousClass1.this.val$h5MapMarker, snapshot);
                                    if (MarkerController.this.mMapContainer.configController.isMapDSLCacheEnabled() && Zebra.isAllReady(view2)) {
                                        if (MarkerController.this.mMapContainer.debuggable) {
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("MarkerController#udpateMarker: put image to cache for ");
                                            sb.append(AnonymousClass1.this.val$h5MapMarker.f7140id);
                                            RVLogger.d(H5MapContainer.TAG, sb.toString());
                                        }
                                        MarkerController.this.mMapContainer.cacheController.putCacheOfDSL(C00711.this.val$dsl, snapshot);
                                    }
                                }
                            });
                        }
                        Bitmap snapshot = ZebraUtils.snapshot(view);
                        if (snapshot != null) {
                            MarkerController.this.a(AnonymousClass1.this.val$h5MapMarker, snapshot);
                            if (!canUpdate && MarkerController.this.mMapContainer.configController.isMapDSLCacheEnabled() && Zebra.isAllReady(view)) {
                                if (MarkerController.this.mMapContainer.debuggable) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("MarkerController#udpateMarker: put image to cache for ");
                                    sb.append(AnonymousClass1.this.val$h5MapMarker.f7140id);
                                    RVLogger.d(H5MapContainer.TAG, sb.toString());
                                }
                                MarkerController.this.mMapContainer.cacheController.putCacheOfDSL(C00711.this.val$dsl, snapshot);
                            }
                        }
                    }
                }) == null) {
                    RVLogger.e(H5MapContainer.TAG, "update marker dsl render result nothing");
                    MarkerController.this.mMapContainer.reportController.reportRenderDSL(false, 1);
                    return;
                }
                MarkerController.this.mMapContainer.reportController.reportRenderDSL(true, 1);
                atomicLong2.set(System.currentTimeMillis());
                MarkerController.this.mMapContainer.reportController.reportDSLTime(2, atomicLong2.get() - atomicLong.get());
            }
        }
    }

    private String a(Marker marker) {
        if (marker.callout != null && !TextUtils.isEmpty(marker.callout.content)) {
            return marker.callout.content;
        }
        CustomCallout customCallout = marker.customCallout;
        return "";
    }

    public void a(final H5MapMarker h5MapMarker, Bitmap bitmap) {
        if (h5MapMarker == null || bitmap == null || bitmap.isRecycled()) {
            return;
        }
        final AdapterMarker adapterMarker = h5MapMarker.markerContext;
        final Marker marker = h5MapMarker.marker;
        int convertDp = (int) this.mMapContainer.metricsController.convertDp(marker.width);
        int convertDp2 = (int) this.mMapContainer.metricsController.convertDp(marker.height);
        if (marker.iconLayout == null && marker.style == null && TextUtils.isEmpty(marker.iconAppendStr)) {
            bitmap = H5MapUtils.resizeBitmap(bitmap, convertDp, convertDp2);
        } else {
            convertDp = bitmap.getWidth();
            convertDp2 = bitmap.getHeight();
        }
        if (marker.rotate != 0) {
            bitmap = H5MapUtils.rotateBitmap(bitmap, marker.rotate);
        }
        if (marker.alpha != 1.0d) {
            bitmap = H5MapUtils.alphaBitmap(bitmap, (int) (marker.alpha * 255.0d));
        }
        final AdapterTextureMapView mapView = this.mMapContainer.getMapView();
        if (marker.label != null) {
            MarkerStyle.fromLabel(marker.label, this.mMapContainer, bitmap).getBitmap(new MarkerStyle.Callback() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController.4
                {
                    MarkerController.this = this;
                }

                @Override // com.alipay.mobile.embedview.mapbiz.marker.MarkerStyle.Callback
                public boolean call(Bitmap bitmap2, int i) {
                    if (i == 0) {
                        adapterMarker.setIcon(AdapterBitmapDescriptorFactory.fromBitmap(mapView, bitmap2));
                        h5MapMarker.onIconSuccess();
                        MarkerController.this.a(adapterMarker, marker, bitmap2.getWidth(), bitmap2.getHeight());
                        adapterMarker.hideInfoWindow();
                        return false;
                    }
                    return false;
                }
            });
            return;
        }
        adapterMarker.setIcon(AdapterBitmapDescriptorFactory.fromBitmap(mapView, bitmap));
        h5MapMarker.onIconSuccess();
        a(adapterMarker, marker, convertDp, convertDp2);
        a(adapterMarker, marker);
    }

    private void a(AdapterMarker adapterMarker, Marker marker) {
        boolean a2 = a(marker.customCallout, marker.customCallout != null && marker.customCallout.isShow == 1 && marker.customCallout.canShowOnLoad);
        if (this.mMapContainer.debuggable) {
            StringBuilder sb = new StringBuilder();
            sb.append("updateMarker id = ");
            sb.append(marker.f7175id);
            sb.append(" isShowInfoWindow = ");
            sb.append(a2);
            RVLogger.d(H5MapContainer.TAG, sb.toString());
        }
        if (a2) {
            adapterMarker.showInfoWindow();
        } else {
            adapterMarker.hideInfoWindow();
        }
    }

    public void clear() {
        Iterator<Map.Entry<String, H5MapMarker>> it = this.h5MapMarkers.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().markerContext.remove();
        }
        this.h5MapMarkers.clear();
        this.mMapContainer.markerClusterController.clearClusterRootMarkers();
    }

    public void setMarkers(AdapterAMap adapterAMap, List<Marker> list) {
        Context context;
        if (list == null || (context = this.mMapContainer.getContext()) == null) {
            return;
        }
        Iterator<Marker> it = list.iterator();
        while (it.hasNext()) {
            setMarker(context, adapterAMap, it.next());
        }
        adapterAMap.setOnMarkerClickListener(this.c);
        adapterAMap.setOnInfoWindowClickListener(this.d);
    }

    public AdapterMarker setMarker(Context context, final AdapterAMap adapterAMap, final Marker marker) {
        Bitmap iconWithString;
        if (marker == null) {
            return null;
        }
        AdapterMarkerOptions anchor = new AdapterMarkerOptions(adapterAMap).icon(AdapterBitmapDescriptorFactory.fromResource(adapterAMap, R.drawable.griver_map_marker)).title(marker.title).snippet(a(marker)).zIndex(marker.markerLevel).position(new AdapterLatLng(adapterAMap, marker.latitude, marker.longitude)).anchor(a(marker.anchorX), a(marker.anchorY));
        AdapterLatLng positionFromAnimCache = this.mMapContainer.markerAnimController.getPositionFromAnimCache(marker.f7175id);
        if (positionFromAnimCache != null) {
            anchor.position(positionFromAnimCache);
        }
        AdapterMarker addMarker = adapterAMap.addMarker(anchor);
        addMarker.setObject(marker);
        final H5MapMarker h5MapMarker = new H5MapMarker(marker, addMarker);
        h5MapMarker.debuggable = this.mMapContainer.debuggable;
        h5MapMarker.onCreate();
        this.h5MapMarkers.put(h5MapMarker.f7140id, h5MapMarker);
        final long obtainMarkerToken = h5MapMarker.obtainMarkerToken();
        if (marker.iconLayout != null && this.mMapContainer.configController.isMapDSLEnabled()) {
            this.mMapContainer.layoutController.applyLayoutParams(marker.iconLayout, new AnonymousClass7(h5MapMarker, obtainMarkerToken, adapterAMap, context));
        } else if (marker.style != null) {
            MarkerStyle fromJSONObject = MarkerStyle.fromJSONObject(marker.style, this.mMapContainer);
            if (fromJSONObject != null) {
                fromJSONObject.getBitmap(new MarkerStyle.Callback() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController.8
                    {
                        MarkerController.this = this;
                    }

                    @Override // com.alipay.mobile.embedview.mapbiz.marker.MarkerStyle.Callback
                    public boolean call(Bitmap bitmap, int i) {
                        if (MarkerController.this.mMapContainer.configController.isCheckMarkerToken() && h5MapMarker.isMarkerTokenInvalid(obtainMarkerToken)) {
                            return true;
                        }
                        if (i == 0) {
                            MarkerController.this.a(adapterAMap, h5MapMarker, bitmap);
                            return false;
                        } else if (i == 1) {
                            MarkerController.this.a(adapterAMap, h5MapMarker, bitmap);
                            return false;
                        } else {
                            return false;
                        }
                    }
                });
            }
        } else if (!TextUtils.isEmpty(marker.iconPath)) {
            this.mMapContainer.resourceLoader.loadImage(marker.iconPath, new ZebraLoader.OnLoadImageCallback() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController.9
                {
                    MarkerController.this = this;
                }

                @Override // com.alipay.mobile.zebra.ZebraLoader.OnLoadImageCallback
                public void onComplete(Bitmap bitmap) {
                    if (MarkerController.this.mMapContainer.configController.isCheckMarkerToken() && h5MapMarker.isMarkerTokenInvalid(obtainMarkerToken)) {
                        return;
                    }
                    if (bitmap != null) {
                        if (!TextUtils.isEmpty(marker.iconAppendStr)) {
                            bitmap = H5MapUtils.getIconWithString(MarkerController.this.mMapContainer.getContext(), marker.iconAppendStr, marker.iconAppendStrColor, bitmap);
                        }
                        if (bitmap != null) {
                            MarkerController.this.a(adapterAMap, h5MapMarker, bitmap);
                            return;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("marker icon bitmap is null for ");
                        sb.append(marker.iconPath);
                        RVLogger.e(H5MapContainer.TAG, sb.toString());
                        MarkerController.this.mMapContainer.reportController.reportParamError(1);
                        return;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("marker icon error: ");
                    sb2.append(marker.iconPath);
                    RVLogger.e(H5MapContainer.TAG, sb2.toString());
                    MarkerController.this.mMapContainer.reportController.reportParamError(1);
                }
            });
        } else {
            if (TextUtils.isEmpty(marker.iconAppendStr)) {
                iconWithString = BitmapFactory.decodeResource(context.getResources(), R.drawable.griver_map_marker);
            } else {
                iconWithString = H5MapUtils.getIconWithString(context, marker.iconAppendStr, marker.iconAppendStrColor, null);
            }
            a(adapterAMap, h5MapMarker, iconWithString);
        }
        return addMarker;
    }

    /* renamed from: com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController$7 */
    /* loaded from: classes6.dex */
    public class AnonymousClass7 implements H5DataCallback<String> {
        final /* synthetic */ AdapterAMap val$aMap;
        final /* synthetic */ Context val$context;
        final /* synthetic */ H5MapMarker val$h5MapMarker;
        final /* synthetic */ long val$markerToken;

        AnonymousClass7(H5MapMarker h5MapMarker, long j, AdapterAMap adapterAMap, Context context) {
            MarkerController.this = r1;
            this.val$h5MapMarker = h5MapMarker;
            this.val$markerToken = j;
            this.val$aMap = adapterAMap;
            this.val$context = context;
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
        @Override // com.alipay.mobile.embedview.callback.H5DataCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void callback(java.lang.String r6) {
            /*
                r5 = this;
                com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController r0 = com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController.this
                com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer r0 = r0.mMapContainer
                com.alipay.mobile.embedview.mapbiz.core.controller.ConfigController r0 = r0.configController
                boolean r0 = r0.isCheckMarkerToken()
                if (r0 == 0) goto L17
                com.alipay.mobile.embedview.mapbiz.core.H5MapMarker r0 = r5.val$h5MapMarker
                long r1 = r5.val$markerToken
                boolean r0 = r0.isMarkerTokenInvalid(r1)
                if (r0 == 0) goto L17
                return
            L17:
                boolean r0 = android.text.TextUtils.isEmpty(r6)
                java.lang.String r1 = "H5EmbedMapView"
                r2 = 1
                if (r0 == 0) goto L30
                java.lang.String r6 = "set marker dsl is empty"
                com.alibaba.ariver.kernel.common.utils.RVLogger.e(r1, r6)
                com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController r6 = com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController.this
                com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer r6 = r6.mMapContainer
                com.alipay.mobile.embedview.mapbiz.core.controller.ReportController r6 = r6.reportController
                r0 = 0
                r6.reportRenderDSL(r0, r2)
                return
            L30:
                com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController r0 = com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController.this
                com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer r0 = r0.mMapContainer
                com.alipay.mobile.embedview.mapbiz.core.controller.ConfigController r0 = r0.configController
                boolean r0 = r0.isMapDSLCacheEnabled()
                r0 = r0 ^ r2
                if (r0 != 0) goto L6b
                com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController r3 = com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController.this
                com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer r3 = r3.mMapContainer
                com.alipay.mobile.embedview.mapbiz.core.controller.CacheController r3 = r3.cacheController
                android.graphics.Bitmap r3 = r3.getCacheOfDSL(r6)
                if (r3 == 0) goto L6c
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r4 = "setMarker use cache: "
                r2.append(r4)
                com.alipay.mobile.embedview.mapbiz.core.H5MapMarker r4 = r5.val$h5MapMarker
                java.lang.String r4 = r4.f7140id
                r2.append(r4)
                java.lang.String r2 = r2.toString()
                com.alibaba.ariver.kernel.common.utils.RVLogger.d(r1, r2)
                com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController r1 = com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController.this
                com.alipay.mobile.apmap.AdapterAMap r2 = r5.val$aMap
                com.alipay.mobile.embedview.mapbiz.core.H5MapMarker r4 = r5.val$h5MapMarker
                com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController.access$200(r1, r2, r4, r3)
            L6b:
                r2 = r0
            L6c:
                if (r2 == 0) goto L97
                java.util.concurrent.atomic.AtomicLong r0 = new java.util.concurrent.atomic.AtomicLong
                long r1 = java.lang.System.currentTimeMillis()
                r0.<init>(r1)
                com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController$7$1 r1 = new com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController$7$1
                r1.<init>(r0, r6)
                com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController r0 = com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController.this
                com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer r0 = r0.mMapContainer
                com.alipay.mobile.embedview.mapbiz.core.controller.LayoutController r0 = r0.layoutController
                com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController r2 = com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController.this
                com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer r2 = r2.mMapContainer
                com.alipay.mobile.embedview.mapbiz.core.controller.ConfigController r2 = r2.configController
                boolean r2 = r2.isMapDSLAsync()
                com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController r3 = com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController.this
                com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer r3 = r3.mMapContainer
                com.alipay.mobile.embedview.mapbiz.core.controller.LayoutController r3 = r3.layoutController
                com.alipay.mobile.zebra.core.ZebraOption r3 = r3.markerOption
                r0.parseLayoutData(r2, r6, r3, r1)
            L97:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController.AnonymousClass7.callback(java.lang.String):void");
        }

        /* renamed from: com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController$7$1 */
        /* loaded from: classes6.dex */
        public class AnonymousClass1 implements H5DataCallback<ZebraData<? extends ZebraLayout>> {
            final /* synthetic */ String val$dsl;
            final /* synthetic */ AtomicLong val$parseBeginTag;

            AnonymousClass1(AtomicLong atomicLong, String str) {
                AnonymousClass7.this = r1;
                this.val$parseBeginTag = atomicLong;
                this.val$dsl = str;
            }

            @Override // com.alipay.mobile.embedview.callback.H5DataCallback
            public void callback(ZebraData<? extends ZebraLayout> zebraData) {
                if (MarkerController.this.mMapContainer.configController.isCheckMarkerToken() && AnonymousClass7.this.val$h5MapMarker.isMarkerTokenInvalid(AnonymousClass7.this.val$markerToken)) {
                    return;
                }
                if (zebraData == null) {
                    RVLogger.e(H5MapContainer.TAG, "set marker dsl parse result nothing");
                    MarkerController.this.mMapContainer.reportController.reportRenderDSL(false, 1);
                    return;
                }
                AtomicLong atomicLong = new AtomicLong(System.currentTimeMillis());
                MarkerController.this.mMapContainer.reportController.reportDSLTime(1, atomicLong.get() - this.val$parseBeginTag.get());
                final AtomicLong atomicLong2 = new AtomicLong(0L);
                if (Zebra.render(AnonymousClass7.this.val$context, zebraData, MarkerController.this.mMapContainer.resourceLoader, new Zebra.OnLoadCallback() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController.7.1.1
                    {
                        AnonymousClass1.this = this;
                    }

                    @Override // com.alipay.mobile.zebra.Zebra.OnLoadCallback
                    public void onLoad(final View view, ZebraData<? extends ZebraLayout> zebraData2, ZebraLayout<? extends ZebraData> zebraLayout) {
                        if (MarkerController.this.mMapContainer.configController.isCheckMarkerToken() && AnonymousClass7.this.val$h5MapMarker.isMarkerTokenInvalid(AnonymousClass7.this.val$markerToken)) {
                            return;
                        }
                        MarkerController.this.mMapContainer.reportController.reportDSLTime(3, new AtomicLong(System.currentTimeMillis()).get() - atomicLong2.get());
                        boolean canUpdate = Zebra.canUpdate(view);
                        if (canUpdate) {
                            Zebra.bindOnUpdateCallback(view, new Zebra.OnUpdateCallback() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController.7.1.1.1
                                {
                                    C00741.this = this;
                                }

                                @Override // com.alipay.mobile.zebra.Zebra.OnUpdateCallback
                                public void onUpdate(View view2, ZebraData<? extends ZebraLayout> zebraData3, ZebraLayout<? extends ZebraData> zebraLayout2) {
                                    Bitmap snapshot;
                                    if ((MarkerController.this.mMapContainer.configController.isCheckMarkerToken() && AnonymousClass7.this.val$h5MapMarker.isMarkerTokenInvalid(AnonymousClass7.this.val$markerToken)) || (snapshot = ZebraUtils.snapshot(Zebra.getRootView(view2))) == null) {
                                        return;
                                    }
                                    MarkerController.this.a(AnonymousClass7.this.val$aMap, AnonymousClass7.this.val$h5MapMarker, snapshot);
                                    if (MarkerController.this.mMapContainer.configController.isMapDSLCacheEnabled() && Zebra.isAllReady(view)) {
                                        if (MarkerController.this.mMapContainer.debuggable) {
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("MarkerController#setMarker: put image to cache for ");
                                            sb.append(AnonymousClass7.this.val$h5MapMarker.f7140id);
                                            RVLogger.d(H5MapContainer.TAG, sb.toString());
                                        }
                                        MarkerController.this.mMapContainer.cacheController.putCacheOfDSL(AnonymousClass1.this.val$dsl, snapshot);
                                    }
                                }
                            });
                        }
                        Bitmap snapshot = ZebraUtils.snapshot(view);
                        if (snapshot != null) {
                            MarkerController.this.a(AnonymousClass7.this.val$aMap, AnonymousClass7.this.val$h5MapMarker, snapshot);
                            if (!canUpdate && MarkerController.this.mMapContainer.configController.isMapDSLCacheEnabled() && Zebra.isAllReady(view)) {
                                if (MarkerController.this.mMapContainer.debuggable) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("MarkerController#setMarker: put image to cache for ");
                                    sb.append(AnonymousClass7.this.val$h5MapMarker.f7140id);
                                    RVLogger.d(H5MapContainer.TAG, sb.toString());
                                }
                                MarkerController.this.mMapContainer.cacheController.putCacheOfDSL(AnonymousClass1.this.val$dsl, snapshot);
                                return;
                            }
                            return;
                        }
                        RVLogger.e(H5MapContainer.TAG, "snapshot bitmap is null");
                    }
                }) == null) {
                    RVLogger.e(H5MapContainer.TAG, "set marker dsl render result nothing");
                    MarkerController.this.mMapContainer.reportController.reportRenderDSL(false, 1);
                    return;
                }
                MarkerController.this.mMapContainer.reportController.reportRenderDSL(true, 1);
                atomicLong2.set(System.currentTimeMillis());
                MarkerController.this.mMapContainer.reportController.reportDSLTime(2, atomicLong2.get() - atomicLong.get());
            }
        }
    }

    public void a(final AdapterAMap adapterAMap, final H5MapMarker h5MapMarker, Bitmap bitmap) {
        synchronized (this) {
            if (h5MapMarker == null) {
                return;
            }
            if (bitmap != null) {
                if (!TextUtils.isEmpty(h5MapMarker.f7140id)) {
                    if (this.h5MapMarkers.containsKey(h5MapMarker.f7140id) || this.mMapContainer.markerClusterController.findRootH5MapMarkerById(h5MapMarker.f7140id) != null) {
                        final Marker marker = h5MapMarker.marker;
                        final AdapterMarker adapterMarker = h5MapMarker.markerContext;
                        int convertDp = (int) this.mMapContainer.metricsController.convertDp(marker.width);
                        int convertDp2 = (int) this.mMapContainer.metricsController.convertDp(marker.height);
                        if (marker.iconLayout == null && marker.style == null && TextUtils.isEmpty(marker.iconAppendStr)) {
                            bitmap = H5MapUtils.resizeBitmap(bitmap, convertDp, convertDp2);
                        } else {
                            convertDp = bitmap.getWidth();
                            convertDp2 = bitmap.getHeight();
                        }
                        if (marker.rotate != 0) {
                            bitmap = H5MapUtils.rotateBitmap(bitmap, marker.rotate);
                        }
                        if (marker.alpha != 1.0d) {
                            bitmap = H5MapUtils.alphaBitmap(bitmap, (int) (marker.alpha * 255.0d));
                        }
                        if (marker.label != null) {
                            MarkerStyle.fromLabel(marker.label, this.mMapContainer, bitmap).getBitmap(new MarkerStyle.Callback() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.MarkerController.10
                                {
                                    MarkerController.this = this;
                                }

                                @Override // com.alipay.mobile.embedview.mapbiz.marker.MarkerStyle.Callback
                                public boolean call(Bitmap bitmap2, int i) {
                                    if (i == 0) {
                                        adapterMarker.setIcon(AdapterBitmapDescriptorFactory.fromBitmap(adapterAMap, bitmap2));
                                        h5MapMarker.onIconSuccess();
                                        MarkerController.this.a(adapterMarker, marker, bitmap2.getWidth(), bitmap2.getHeight());
                                        adapterMarker.hideInfoWindow();
                                        return false;
                                    }
                                    return false;
                                }
                            });
                        } else {
                            adapterMarker.setIcon(AdapterBitmapDescriptorFactory.fromBitmap(adapterAMap, bitmap));
                            h5MapMarker.onIconSuccess();
                            a(adapterMarker, marker, convertDp, convertDp2);
                            CustomCallout customCallout = marker.customCallout;
                            if (customCallout != null) {
                                boolean z = true;
                                if (customCallout.isShow != 1 || !customCallout.canShowOnLoad) {
                                    z = false;
                                }
                                if (a(customCallout, z)) {
                                    adapterMarker.showInfoWindow();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void a(AdapterMarker adapterMarker, Marker marker, int i, int i2) {
        if (marker.fixedPoint != null) {
            FixedPoint fixedPoint = new FixedPoint();
            fixedPoint.originX = (int) this.mMapContainer.metricsController.convertDp(marker.fixedPoint.originX);
            fixedPoint.originY = (int) this.mMapContainer.metricsController.convertDp(marker.fixedPoint.originY);
            double d = i;
            double d2 = marker.anchorX;
            Double.isNaN(d);
            int i3 = (int) (d * d2);
            double d3 = i2;
            double d4 = marker.anchorY;
            Double.isNaN(d3);
            a(fixedPoint, i3, (int) (d3 * d4));
            adapterMarker.setPositionByPixels(fixedPoint.originX, fixedPoint.originY);
        }
    }

    private void a(FixedPoint fixedPoint, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append("clipFixPoint originX = ");
        sb.append(fixedPoint.originX);
        sb.append(" originY =");
        sb.append(fixedPoint.originY);
        sb.append(" markerWidth = ");
        sb.append(i);
        sb.append(" markerHeight");
        sb.append(i2);
        RVLogger.d(H5MapContainer.TAG, sb.toString());
        if (fixedPoint.originX <= i) {
            fixedPoint.originX = i;
        }
        if (fixedPoint.originY <= i2) {
            fixedPoint.originY = i2;
        }
        AdapterTextureMapView mapView = this.mMapContainer.getMapView();
        int measuredWidth = mapView.getMeasuredWidth();
        int measuredHeight = mapView.getMeasuredHeight();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("clipFixPoint viewWidth = ");
        sb2.append(measuredWidth);
        sb2.append(" viewHeight =");
        sb2.append(measuredHeight);
        RVLogger.d(H5MapContainer.TAG, sb2.toString());
        if (measuredWidth != 0 && measuredHeight != 0) {
            this.f7160a = measuredWidth;
            this.b = measuredHeight;
        }
        int i3 = fixedPoint.originX;
        int i4 = this.f7160a;
        if (i3 >= i4) {
            fixedPoint.originX = i4 - i;
        }
        int i5 = fixedPoint.originY;
        int i6 = this.b;
        if (i5 >= i6) {
            fixedPoint.originY = i6 - 5;
        }
    }

    private boolean a(CustomCallout customCallout, boolean z) {
        boolean z2 = false;
        if (customCallout != null && z) {
            if (customCallout.layout != null && (customCallout.layout.src != null || customCallout.layout.data != null)) {
                return true;
            }
            if (customCallout.descList != null && !customCallout.descList.isEmpty()) {
                Iterator<RichTextInfo> it = customCallout.descList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z2 = true;
                        break;
                    }
                    RichTextInfo next = it.next();
                    if (next != null && !TextUtils.isEmpty(next.desc)) {
                        break;
                    }
                }
                return !z2;
            }
        }
        return false;
    }

    public void onCameraChanging(AdapterCameraPosition adapterCameraPosition) {
        synchronized (this) {
            this.mMapContainer.markerClusterController.onCameraChanging(adapterCameraPosition);
        }
    }

    public void onCameraChanged(AdapterCameraPosition adapterCameraPosition, boolean z) {
        synchronized (this) {
            this.mMapContainer.markerClusterController.onCameraChanged(adapterCameraPosition, z);
        }
    }

    public void hideAllInfoWindow() {
        Marker markerData;
        Iterator<Map.Entry<String, H5MapMarker>> it = this.h5MapMarkers.entrySet().iterator();
        while (it.hasNext()) {
            H5MapMarker value = it.next().getValue();
            if (value.markerContext.isInfoWindowShown() && ((markerData = H5MapMarker.getMarkerData(value.markerContext)) == null || markerData.customCallout == null || markerData.customCallout.canShowOnTap)) {
                value.markerContext.hideInfoWindow();
            }
        }
    }
}
