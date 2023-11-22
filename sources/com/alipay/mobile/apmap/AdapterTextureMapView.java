package com.alipay.mobile.apmap;

import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.mobile.apmap.util.AdapterUtil;
import com.alipay.mobile.apmap.util.DynamicMapView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.common.base.Ascii;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes6.dex */
public class AdapterTextureMapView extends DynamicMapView {

    /* renamed from: a */
    private MapView f7096a;
    private AdapterAMap b;
    public static final byte[] $$a = {116, -27, -60, 115, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 114;
    public static final byte[] getAuthRequestContext = {2, -87, 98, TarHeader.LF_FIFO, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 122;

    /* JADX WARN: Removed duplicated region for block: B:20:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002b -> B:23:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(short r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 + 4
            byte[] r0 = com.alipay.mobile.apmap.AdapterTextureMapView.getAuthRequestContext
            int r7 = r7 * 2
            int r7 = r7 + 16
            int r8 = 106 - r8
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L35
        L19:
            r3 = 0
        L1a:
            int r6 = r6 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            r3 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L35:
            int r6 = -r6
            int r9 = r9 + r6
            int r6 = r9 + 2
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
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.apmap.AdapterTextureMapView.d(short, int, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002d -> B:23:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void e(byte r7, int r8, byte r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 * 3
            int r9 = 42 - r9
            int r8 = r8 * 4
            int r8 = r8 + 75
            int r7 = r7 * 4
            int r7 = 3 - r7
            byte[] r0 = com.alipay.mobile.apmap.AdapterTextureMapView.$$a
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            goto L37
        L1b:
            r3 = 0
        L1c:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            int r7 = r7 + 1
            r1[r3] = r5
            if (r4 != r9) goto L2d
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2d:
            r3 = r0[r7]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L37:
            int r9 = r9 + r7
            int r7 = r9 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r8
            r8 = r7
            r7 = r6
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.apmap.AdapterTextureMapView.e(byte, int, byte, java.lang.Object[]):void");
    }

    public AdapterTextureMapView(Context context) {
        super(context);
        this.b = null;
    }

    public AdapterTextureMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = null;
    }

    public AdapterTextureMapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = null;
    }

    private void a(Context context) {
        MapView mapView = new MapView(context);
        this.f7096a = mapView;
        addView(mapView);
    }

    @Override // com.alipay.mobile.apmap.util.DynamicMapView
    public void onCreateMapView(Context context, AttributeSet attributeSet, int i) {
        if (AdapterUtil.isGoogleMapSdk()) {
            a(context);
        }
    }

    public void initMap(final OnAdapterMapReadyCallback onAdapterMapReadyCallback) {
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7096a.getMapAsync(new OnMapReadyCallback() { // from class: com.alipay.mobile.apmap.AdapterTextureMapView.1
                {
                    AdapterTextureMapView.this = this;
                }

                @Override // com.google.android.gms.maps.OnMapReadyCallback
                public void onMapReady(GoogleMap googleMap) {
                    AdapterTextureMapView.this.a(googleMap, onAdapterMapReadyCallback);
                }
            });
        } else if (onAdapterMapReadyCallback != null) {
            onAdapterMapReadyCallback.onAdapterMapReady(this.b);
        }
    }

    public void a(GoogleMap googleMap, OnAdapterMapReadyCallback onAdapterMapReadyCallback) {
        RVLogger.d("AdapterTextureMapView", "initMap  doOnMapReady");
        googleMap.setMapType(1);
        AdapterAMap adapterAMap = new AdapterAMap(googleMap);
        this.b = adapterAMap;
        if (onAdapterMapReadyCallback != null) {
            onAdapterMapReadyCallback.onAdapterMapReady(adapterAMap);
        }
    }

    public AdapterAMap getMap() {
        return this.b;
    }

    public void onCreate(Bundle bundle) {
        try {
            byte b = (byte) (getAuthRequestContext[8] + 1);
            byte b2 = (byte) (getAuthRequestContext[5] - 1);
            Object[] objArr = new Object[1];
            d(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (-getAuthRequestContext[5]);
            Object[] objArr2 = new Object[1];
            d(b3, (byte) (b3 + 1), getAuthRequestContext[5], objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarSize() >> 8) + 494, 4 - (ViewConfiguration.getFadingEdgeLength() >> 16), (char) (ViewConfiguration.getJumpTapTimeout() >> 16));
                    byte b4 = (byte) ($$a[35] - 1);
                    byte b5 = b4;
                    Object[] objArr4 = new Object[1];
                    e(b4, b5, b5, objArr4);
                    obj = cls2.getMethod((String) objArr4[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj);
                }
                Object[] objArr5 = (Object[]) ((Method) obj).invoke(null, objArr3);
                int i = ((int[]) objArr5[1])[0];
                if (((int[]) objArr5[0])[0] != i) {
                    long j = ((r1 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), 36 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-744047968, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), View.resolveSize(0, 0) + 18, (char) KeyEvent.getDeadChar(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                if (AdapterUtil.isGoogleMapSdk()) {
                    this.f7096a.onCreate(bundle);
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

    public void onResume() {
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7096a.onResume();
        }
    }

    public void onPause() {
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7096a.onPause();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7096a.onSaveInstanceState(bundle);
        }
    }

    public void onDestroy() {
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7096a.onDestroy();
        }
    }

    public int getAdapterChildCount() {
        if (AdapterUtil.isGoogleMapSdk()) {
            return this.f7096a.getChildCount();
        }
        return 0;
    }

    public View getAdapterChildAt(int i) {
        if (AdapterUtil.isGoogleMapSdk()) {
            return this.f7096a.getChildAt(i);
        }
        return null;
    }

    public void addAdapterView(View view, ViewGroup.LayoutParams layoutParams) {
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7096a.addView(view, layoutParams);
        }
    }

    public void removeAdapterView(View view) {
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7096a.removeView(view);
        }
    }
}
