package com.alipay.mobile.embedview.mapbiz.core.controller;

import android.content.Context;
import android.graphics.Color;
import android.os.Process;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.JSONObject;
import com.alipay.mobile.embedview.callback.H5JsCallback;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import com.alipay.zoloz.toyger.blob.BlobStatic;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes6.dex */
public class RouteSearchController extends H5MapController {
    public static final byte[] $$a = {SignedBytes.MAX_POWER_OF_TWO, 34, -50, 73, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = BlobStatic.MONITOR_IMAGE_WIDTH;
    public static final byte[] PlaceComponentResult = {Ascii.EM, 60, 112, -12, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int getAuthRequestContext = 140;

    /* renamed from: a */
    private RouteSearchHelper f7167a;

    /* JADX WARN: Removed duplicated region for block: B:20:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0027 -> B:23:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.alipay.mobile.embedview.mapbiz.core.controller.RouteSearchController.PlaceComponentResult
            int r6 = r6 + 105
            int r7 = r7 * 2
            int r7 = r7 + 16
            int r8 = r8 * 15
            int r8 = 19 - r8
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L32
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r7) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L32:
            int r6 = r6 + r8
            int r6 = r6 + 2
            int r8 = r9 + 1
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.embedview.mapbiz.core.controller.RouteSearchController.b(int, int, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002b -> B:23:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 3
            int r8 = r8 + 75
            int r7 = r7 * 4
            int r7 = r7 + 42
            byte[] r0 = com.alipay.mobile.embedview.mapbiz.core.controller.RouteSearchController.$$a
            int r6 = r6 + 4
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L36
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r6 = r6 + 1
            int r3 = r3 + 1
            if (r3 != r7) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L36:
            int r6 = -r6
            int r9 = r9 + r6
            int r6 = r9 + (-7)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.embedview.mapbiz.core.controller.RouteSearchController.c(int, short, byte, java.lang.Object[]):void");
    }

    public RouteSearchController(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
    }

    public void onCreate() {
        try {
            byte b = (byte) (-PlaceComponentResult[5]);
            byte b2 = (byte) (b - 1);
            Object[] objArr = new Object[1];
            b(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (PlaceComponentResult[5] + 1);
            Object[] objArr2 = new Object[1];
            b(b3, b3, (byte) (-PlaceComponentResult[5]), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(493 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), ExpandableListView.getPackedPositionChild(0L) + 5, (char) Color.alpha(0));
                    byte b4 = $$a[35];
                    byte b5 = (byte) (b4 + 1);
                    Object[] objArr4 = new Object[1];
                    c(b4, b5, b5, objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.red(0), 35 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-325244632, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0', 0), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 18, (char) (Process.getGidForName("") + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                RouteSearchHelper routeSearchHelper = this.f7167a;
                if (routeSearchHelper != null) {
                    routeSearchHelper.setEnv(this.mMapContainer.getContext(), this.mMapContainer.getMap(), null, null);
                }
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

    public void showRoute(JSONObject jSONObject, H5JsCallback h5JsCallback) {
        boolean z = this.mMapContainer.debuggable;
        try {
            Context context = this.mMapContainer.getContext();
            if (context != null) {
                if (this.f7167a == null) {
                    this.f7167a = new RouteSearchHelper(this.mMapContainer);
                }
                this.f7167a.setEnv(context, this.mMapContainer.getMap(), jSONObject, h5JsCallback);
                this.f7167a.showRoute(this.mMapContainer.getAppId());
            }
        } catch (Exception unused) {
        }
    }

    public void clearRoute(H5JsCallback h5JsCallback) {
        RouteSearchHelper routeSearchHelper = this.f7167a;
        if (routeSearchHelper != null) {
            routeSearchHelper.clearRoute();
            this.f7167a = null;
        }
        if (h5JsCallback != null) {
            h5JsCallback.sendSuccess();
        }
    }

    public void restoreRoute() {
        RouteSearchHelper routeSearchHelper = this.f7167a;
        if (routeSearchHelper != null) {
            routeSearchHelper.restoreRoute();
        }
    }
}
