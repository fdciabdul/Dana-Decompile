package com.alipay.mobile.embedview.mapbiz.core.controller;

import android.content.Context;
import android.graphics.ImageFormat;
import android.media.AudioTrack;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.utils.DensityUtil;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.alipay.android.phone.mobilesdk.socketcraft.api.WSContextConstant;
import com.alipay.mobile.apmap.model.AdapterLatLng;
import com.alipay.mobile.apmap.model.AdapterMarker;
import com.alipay.mobile.embedview.callback.H5DataCallback;
import com.alipay.mobile.embedview.mapbiz.core.H5MapMarker;
import com.alipay.mobile.embedview.mapbiz.data.CustomCallout;
import com.alipay.mobile.embedview.mapbiz.data.Layout;
import com.alipay.mobile.embedview.mapbiz.data.Marker;
import com.alipay.mobile.embedview.mapbiz.data.Panel;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import com.alipay.mobile.embedview.mapbiz.ui.drawable.BubbleDrawable;
import com.alipay.mobile.embedview.mapbiz.utils.H5MapUtils;
import com.alipay.mobile.zebra.Zebra;
import com.alipay.mobile.zebra.ZebraLoader;
import com.alipay.mobile.zebra.ant.AntOption;
import com.alipay.mobile.zebra.core.ZebraOption;
import com.alipay.mobile.zebra.data.ZebraData;
import com.alipay.mobile.zebra.layout.ZebraLayout;
import com.alipay.mobile.zebra.utils.ZebraUtils;
import com.google.common.base.Ascii;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes6.dex */
public class LayoutController extends H5MapController {
    public final ZebraOption antOption;
    public final ZebraOption markerOption;
    public static final byte[] $$a = {123, 85, -72, 69, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = WSContextConstant.HANDSHAKE_RECEIVE_SIZE;
    public static final byte[] getAuthRequestContext = {TarHeader.LF_DIR, 93, -14, -126, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 37;

    /* JADX WARN: Removed duplicated region for block: B:20:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0028 -> B:23:0x002a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r5, byte r6, byte r7, java.lang.Object[] r8) {
        /*
            byte[] r0 = com.alipay.mobile.embedview.mapbiz.core.controller.LayoutController.getAuthRequestContext
            int r7 = r7 * 2
            int r7 = 16 - r7
            int r5 = r5 * 15
            int r5 = r5 + 4
            int r6 = r6 + 105
            byte[] r1 = new byte[r7]
            r2 = -1
            int r7 = r7 + r2
            if (r0 != 0) goto L15
            r3 = r6
            r6 = r5
            goto L2a
        L15:
            r4 = r6
            r6 = r5
            r5 = r4
        L18:
            int r2 = r2 + 1
            byte r3 = (byte) r5
            r1[r2] = r3
            if (r2 != r7) goto L28
            java.lang.String r5 = new java.lang.String
            r6 = 0
            r5.<init>(r1, r6)
            r8[r6] = r5
            return
        L28:
            r3 = r0[r6]
        L2a:
            int r3 = -r3
            int r5 = r5 + r3
            int r5 = r5 + 2
            int r6 = r6 + 1
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.embedview.mapbiz.core.controller.LayoutController.a(int, byte, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0029 -> B:23:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r7, byte r8, int r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = com.alipay.mobile.embedview.mapbiz.core.controller.LayoutController.$$a
            int r8 = r8 * 3
            int r8 = 42 - r8
            int r9 = r9 * 4
            int r9 = r9 + 4
            int r7 = r7 * 4
            int r7 = 75 - r7
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L31
        L19:
            r3 = 0
        L1a:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            if (r4 != r8) goto L29
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L29:
            r3 = r0[r9]
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L31:
            int r9 = -r9
            int r10 = r10 + 1
            int r7 = r7 + r9
            int r7 = r7 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.embedview.mapbiz.core.controller.LayoutController.b(int, byte, int, java.lang.Object[]):void");
    }

    public LayoutController(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
        this.markerOption = new ZebraOption();
        this.antOption = new AntOption();
    }

    public void onCreate() {
        try {
            byte b = getAuthRequestContext[5];
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, (byte) (b2 - 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (getAuthRequestContext[5] - 1);
            byte b4 = b3;
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - ExpandableListView.getPackedPositionType(0L), 3 - ImageFormat.getBitsPerPixel(0), (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1));
                    byte b5 = (byte) ($$a[4] - 1);
                    byte b6 = b5;
                    Object[] objArr4 = new Object[1];
                    b(b5, b6, b6, objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0'), 36 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {322001279, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), 18 - View.resolveSize(0, 0), (char) (MotionEvent.axisFromString("") + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                boolean isMapDSLCamelCompat = this.mMapContainer.configController.isMapDSLCamelCompat();
                this.markerOption.setCompatCamelName(isMapDSLCamelCompat);
                this.antOption.setCompatCamelName(isMapDSLCamelCompat);
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

    public View layoutCustomCallout(Context context, AdapterMarker adapterMarker, CustomCallout customCallout) {
        if (customCallout == null || customCallout.layout == null) {
            return null;
        }
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setBackgroundColor(0);
        applyLayoutParams(customCallout.layout, new AnonymousClass1(context, adapterMarker, frameLayout, customCallout));
        return frameLayout;
    }

    /* renamed from: com.alipay.mobile.embedview.mapbiz.core.controller.LayoutController$1 */
    /* loaded from: classes6.dex */
    public class AnonymousClass1 implements H5DataCallback<String> {
        final /* synthetic */ AdapterMarker val$adapterMarker;
        final /* synthetic */ Context val$context;
        final /* synthetic */ CustomCallout val$customCallout;
        final /* synthetic */ FrameLayout val$view;

        AnonymousClass1(Context context, AdapterMarker adapterMarker, FrameLayout frameLayout, CustomCallout customCallout) {
            LayoutController.this = r1;
            this.val$context = context;
            this.val$adapterMarker = adapterMarker;
            this.val$view = frameLayout;
            this.val$customCallout = customCallout;
        }

        @Override // com.alipay.mobile.embedview.callback.H5DataCallback
        public void callback(String str) {
            if (TextUtils.isEmpty(str)) {
                RVLogger.e(H5MapContainer.TAG, "custom callout dsl is empty");
                LayoutController.this.mMapContainer.reportController.reportRenderDSL(false, 2);
                return;
            }
            final AtomicLong atomicLong = new AtomicLong(System.currentTimeMillis());
            H5DataCallback<ZebraData<? extends ZebraLayout>> h5DataCallback = new H5DataCallback<ZebraData<? extends ZebraLayout>>() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.LayoutController.1.1
                {
                    AnonymousClass1.this = this;
                }

                @Override // com.alipay.mobile.embedview.callback.H5DataCallback
                public void callback(ZebraData<? extends ZebraLayout> zebraData) {
                    int i;
                    int i2;
                    int i3;
                    if (zebraData == null) {
                        RVLogger.e(H5MapContainer.TAG, "custom callout dsl parse result nothing");
                        LayoutController.this.mMapContainer.reportController.reportRenderDSL(false, 2);
                        return;
                    }
                    AtomicLong atomicLong2 = new AtomicLong(System.currentTimeMillis());
                    LayoutController.this.mMapContainer.reportController.reportDSLTime(1, atomicLong2.get() - atomicLong.get());
                    View render = Zebra.render(AnonymousClass1.this.val$context, zebraData, LayoutController.this.mMapContainer.resourceLoader);
                    if (render == null) {
                        RVLogger.e(H5MapContainer.TAG, "custom callout dsl render result nothing");
                        LayoutController.this.mMapContainer.reportController.reportRenderDSL(false, 2);
                        return;
                    }
                    LayoutController.this.mMapContainer.reportController.reportRenderDSL(true, 2);
                    LayoutController.this.mMapContainer.reportController.reportDSLTime(2, new AtomicLong(System.currentTimeMillis()).get() - atomicLong2.get());
                    Zebra.bindOnClickCallback(render, new Zebra.OnClickCallback() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.LayoutController.1.1.1
                        {
                            C00661.this = this;
                        }

                        @Override // com.alipay.mobile.zebra.Zebra.OnClickCallback
                        public void onClick(View view, ZebraData<? extends ZebraLayout> zebraData2, ZebraLayout<? extends ZebraData> zebraLayout) {
                            Marker markerData = H5MapMarker.getMarkerData(AnonymousClass1.this.val$adapterMarker);
                            if (markerData == null || LayoutController.this.mMapContainer.getH5Page() == null) {
                                return;
                            }
                            JSONObject jSONObject = new JSONObject();
                            JSONObject jSONObject2 = new JSONObject();
                            AdapterLatLng position = AnonymousClass1.this.val$adapterMarker.getPosition();
                            if (position != null) {
                                jSONObject2.put("latitude", (Object) Double.valueOf(position.getLatitude()));
                                jSONObject2.put("longitude", (Object) Double.valueOf(position.getLongitude()));
                            }
                            jSONObject2.put("markerId", (Object) (markerData.f7175id == null ? "" : markerData.f7175id));
                            jSONObject2.put(LottieParams.KEY_ELEMENT_ID, (Object) LayoutController.this.mMapContainer.getElementId());
                            if (zebraData2 != null) {
                                jSONObject2.put("layoutId", (Object) zebraData2.getId());
                            }
                            jSONObject.put("data", (Object) jSONObject2);
                            if (LayoutController.this.mMapContainer.getExtraJsCallback() != null) {
                                LayoutController.this.mMapContainer.getExtraJsCallback().sendToWeb(LayoutController.this.mMapContainer.isCubeContainer() ? "calloutTap" : "nbcomponent.map.bindcallouttap", jSONObject);
                            }
                        }
                    });
                    FrameLayout frameLayout = AnonymousClass1.this.val$view;
                    if (AnonymousClass1.this.val$customCallout.layoutBubble == null || !"none".equalsIgnoreCase(AnonymousClass1.this.val$customCallout.layoutBubble.style)) {
                        frameLayout = new FrameLayout(AnonymousClass1.this.val$context);
                        int dip2px = DensityUtil.dip2px(AnonymousClass1.this.val$context, 12.0f);
                        int dip2px2 = DensityUtil.dip2px(AnonymousClass1.this.val$context, 6.0f);
                        int dip2px3 = DensityUtil.dip2px(AnonymousClass1.this.val$context, 8.0f);
                        int dip2px4 = DensityUtil.dip2px(AnonymousClass1.this.val$context, 12.0f);
                        if (AnonymousClass1.this.val$customCallout.layoutBubble != null) {
                            int convertRGBAColor = AnonymousClass1.this.val$customCallout.layoutBubble.bgColor != null ? H5MapUtils.convertRGBAColor(AnonymousClass1.this.val$customCallout.layoutBubble.bgColor) : -1;
                            if (AnonymousClass1.this.val$customCallout.layoutBubble.borderRadius != null) {
                                dip2px = (int) LayoutController.this.mMapContainer.metricsController.convertDp(AnonymousClass1.this.val$customCallout.layoutBubble.borderRadius.doubleValue());
                            }
                            if (AnonymousClass1.this.val$customCallout.layoutBubble.padding != null) {
                                dip2px4 = (int) LayoutController.this.mMapContainer.metricsController.convertDp(AnonymousClass1.this.val$customCallout.layoutBubble.padding.doubleValue());
                            }
                            i3 = convertRGBAColor;
                            i = dip2px;
                            i2 = dip2px4;
                        } else {
                            i = dip2px;
                            i2 = dip2px4;
                            i3 = -1;
                        }
                        BubbleDrawable.setBubbleDrawable(frameLayout, i3, i, dip2px3, 419430400, dip2px2);
                        frameLayout.setPadding(i2, i2, i2, dip2px3 + i2);
                        AnonymousClass1.this.val$view.addView(frameLayout);
                    }
                    frameLayout.addView(render);
                }
            };
            LayoutController layoutController = LayoutController.this;
            layoutController.parseLayoutData(layoutController.mMapContainer.configController.isMapDSLAsync(), str, LayoutController.this.antOption, h5DataCallback);
        }
    }

    public View layoutPanel(Context context, Panel panel) {
        if (panel == null || panel.layout == null) {
            return null;
        }
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setBackgroundColor(0);
        applyLayoutParams(panel.layout, new AnonymousClass2(context, panel, frameLayout));
        return frameLayout;
    }

    /* renamed from: com.alipay.mobile.embedview.mapbiz.core.controller.LayoutController$2 */
    /* loaded from: classes6.dex */
    public class AnonymousClass2 implements H5DataCallback<String> {
        final /* synthetic */ Context val$context;
        final /* synthetic */ Panel val$panel;
        final /* synthetic */ FrameLayout val$view;

        AnonymousClass2(Context context, Panel panel, FrameLayout frameLayout) {
            LayoutController.this = r1;
            this.val$context = context;
            this.val$panel = panel;
            this.val$view = frameLayout;
        }

        @Override // com.alipay.mobile.embedview.callback.H5DataCallback
        public void callback(String str) {
            if (TextUtils.isEmpty(str)) {
                RVLogger.e(H5MapContainer.TAG, "panel dsl is empty");
                LayoutController.this.mMapContainer.reportController.reportRenderDSL(false, 3);
                return;
            }
            final AtomicLong atomicLong = new AtomicLong(System.currentTimeMillis());
            H5DataCallback<ZebraData<? extends ZebraLayout>> h5DataCallback = new H5DataCallback<ZebraData<? extends ZebraLayout>>() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.LayoutController.2.1
                {
                    AnonymousClass2.this = this;
                }

                @Override // com.alipay.mobile.embedview.callback.H5DataCallback
                public void callback(ZebraData<? extends ZebraLayout> zebraData) {
                    if (zebraData == null) {
                        RVLogger.e(H5MapContainer.TAG, "custom callout dsl parse result nothing");
                        LayoutController.this.mMapContainer.reportController.reportRenderDSL(false, 3);
                        return;
                    }
                    AtomicLong atomicLong2 = new AtomicLong(System.currentTimeMillis());
                    LayoutController.this.mMapContainer.reportController.reportDSLTime(1, atomicLong2.get() - atomicLong.get());
                    View render = Zebra.render(AnonymousClass2.this.val$context, zebraData, LayoutController.this.mMapContainer.resourceLoader);
                    if (render == null) {
                        RVLogger.e(H5MapContainer.TAG, "custom callout dsl render result nothing");
                        LayoutController.this.mMapContainer.reportController.reportRenderDSL(false, 3);
                        return;
                    }
                    LayoutController.this.mMapContainer.reportController.reportRenderDSL(true, 3);
                    LayoutController.this.mMapContainer.reportController.reportDSLTime(2, new AtomicLong(System.currentTimeMillis()).get() - atomicLong2.get());
                    Zebra.bindOnClickCallback(render, new Zebra.OnClickCallback() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.LayoutController.2.1.1
                        {
                            AnonymousClass1.this = this;
                        }

                        @Override // com.alipay.mobile.zebra.Zebra.OnClickCallback
                        public void onClick(View view, ZebraData<? extends ZebraLayout> zebraData2, ZebraLayout<? extends ZebraData> zebraLayout) {
                            if (LayoutController.this.mMapContainer.getH5Page() == null) {
                                return;
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append("onPanelClick ");
                            sb.append(AnonymousClass2.this.val$panel.f7176id);
                            RVLogger.d(H5MapContainer.TAG, sb.toString());
                            JSONObject jSONObject = new JSONObject();
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("panelId", (Object) Integer.valueOf(AnonymousClass2.this.val$panel.f7176id));
                            jSONObject2.put(LottieParams.KEY_ELEMENT_ID, (Object) LayoutController.this.mMapContainer.getElementId());
                            if (zebraData2 != null) {
                                jSONObject2.put("layoutId", (Object) zebraData2.getId());
                            }
                            jSONObject.put("data", (Object) jSONObject2);
                            if (LayoutController.this.mMapContainer.getExtraJsCallback() != null) {
                                LayoutController.this.mMapContainer.getExtraJsCallback().sendToWeb(LayoutController.this.mMapContainer.isCubeContainer() ? "panelTap" : "nbcomponent.map.bindpaneltap", jSONObject);
                            }
                        }
                    });
                    AnonymousClass2.this.val$view.addView(render);
                }
            };
            LayoutController layoutController = LayoutController.this;
            layoutController.parseLayoutData(layoutController.mMapContainer.configController.isMapDSLAsync(), str, LayoutController.this.antOption, h5DataCallback);
        }
    }

    public void applyLayoutParams(final Layout layout, final H5DataCallback<String> h5DataCallback) {
        String binaryOfDSL;
        if (layout == null) {
            RVLogger.w(H5MapContainer.TAG, "dsl model is null");
        } else if (layout.data != null) {
            if (h5DataCallback != null) {
                String str = layout.data;
                if (layout.params != null) {
                    str = ZebraUtils.applyLayoutParams(str, layout.params);
                }
                h5DataCallback.callback(str);
            }
        } else if (TextUtils.isEmpty(layout.src)) {
            RVLogger.w(H5MapContainer.TAG, "dsl model src is empty");
            if (h5DataCallback != null) {
                h5DataCallback.callback(null);
            }
        } else {
            final String url = layout.toURL();
            if (this.mMapContainer.configController.isMapDSLCacheEnabled() && (binaryOfDSL = this.mMapContainer.cacheController.getBinaryOfDSL(url)) != null) {
                if (this.mMapContainer.debuggable) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("LayoutController#applyLayoutParams: hit cache -> ");
                    sb.append(url);
                    RVLogger.d(H5MapContainer.TAG, sb.toString());
                }
                h5DataCallback.callback(binaryOfDSL);
                return;
            }
            this.mMapContainer.resourceLoader.loadText(layout.src, new ZebraLoader.OnLoadTextCallback() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.LayoutController.3
                {
                    LayoutController.this = this;
                }

                @Override // com.alipay.mobile.zebra.ZebraLoader.OnLoadTextCallback
                public void onComplete(String str2) {
                    if (str2 != null) {
                        if (h5DataCallback != null) {
                            if (layout.params != null) {
                                str2 = ZebraUtils.applyLayoutParams(str2, layout.params);
                            }
                            if (LayoutController.this.mMapContainer.configController.isMapDSLCacheEnabled()) {
                                LayoutController.this.mMapContainer.cacheController.putBinaryOfDSL(url, str2);
                            }
                            h5DataCallback.callback(str2);
                            return;
                        }
                        return;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("load dsl error for ");
                    sb2.append(layout.src);
                    RVLogger.e(H5MapContainer.TAG, sb2.toString());
                    H5DataCallback h5DataCallback2 = h5DataCallback;
                    if (h5DataCallback2 != null) {
                        h5DataCallback2.callback(null);
                    }
                }
            });
        }
    }

    public void parseLayoutData(boolean z, final String str, final ZebraOption zebraOption, final H5DataCallback<ZebraData<? extends ZebraLayout>> h5DataCallback) {
        Runnable runnable = new Runnable() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.LayoutController.4
            {
                LayoutController.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                final ZebraData<? extends ZebraLayout> parse = Zebra.parse(str, zebraOption);
                if (h5DataCallback != null) {
                    ExecutorUtils.runOnMain(new Runnable() { // from class: com.alipay.mobile.embedview.mapbiz.core.controller.LayoutController.4.1
                        {
                            AnonymousClass4.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            h5DataCallback.callback(parse);
                        }
                    });
                }
            }
        };
        if (z) {
            ExecutorUtils.runNotOnMain(ExecutorType.URGENT, runnable);
        } else {
            runnable.run();
        }
    }
}
