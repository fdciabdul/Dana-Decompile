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
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.mobile.apmap.util.AdapterUtil;
import com.alipay.mobile.apmap.util.DynamicMapView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes6.dex */
public class AdapterMapView extends DynamicMapView {

    /* renamed from: a */
    private MapView f7094a;
    private AdapterAMap b;
    public static final byte[] $$a = {SignedBytes.MAX_POWER_OF_TWO, 19, 79, -17, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 30;
    public static final byte[] PlaceComponentResult = {122, TarHeader.LF_CONTIG, -29, -99, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int MyBillsEntityDataFactory = 17;

    /* JADX WARN: Removed duplicated region for block: B:20:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0029 -> B:23:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void I(int r7, byte r8, int r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = com.alipay.mobile.apmap.AdapterMapView.PlaceComponentResult
            int r8 = r8 + 105
            int r7 = r7 * 2
            int r7 = r7 + 16
            int r9 = r9 * 15
            int r9 = 18 - r9
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L32
        L17:
            r3 = 0
        L18:
            int r9 = r9 + 1
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r7) goto L29
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L29:
            r3 = r0[r9]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L32:
            int r8 = -r8
            int r9 = r9 + r8
            int r8 = r9 + 2
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.apmap.AdapterMapView.I(int, byte, int, java.lang.Object[]):void");
    }

    private static void J(short s, int i, int i2, Object[] objArr) {
        int i3 = 4 - (i * 2);
        int i4 = (i2 * 2) + 75;
        byte[] bArr = $$a;
        int i5 = 42 - (s * 2);
        byte[] bArr2 = new byte[i5];
        int i6 = -1;
        int i7 = i5 - 1;
        if (bArr == null) {
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i6 = -1;
            i4 = (i4 + (-i7)) - 7;
            i7 = i7;
            i3++;
        }
        while (true) {
            int i8 = i6 + 1;
            bArr2[i8] = (byte) i4;
            if (i8 == i7) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            byte b = bArr[i3];
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i6 = i8;
            i4 = (i4 + (-b)) - 7;
            i7 = i7;
            i3++;
        }
    }

    public AdapterMapView(Context context) {
        super(context);
        this.b = null;
    }

    public AdapterMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = null;
    }

    public AdapterMapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = null;
    }

    private void a(Context context) {
        MapView mapView = new MapView(context);
        this.f7094a = mapView;
        addView(mapView);
    }

    @Override // com.alipay.mobile.apmap.util.DynamicMapView
    public void onCreateMapView(Context context, AttributeSet attributeSet, int i) {
        if (AdapterUtil.isGoogleMapSdk()) {
            a(context);
        }
    }

    public void initMap(final OnAdapterMapReadyCallback onAdapterMapReadyCallback) {
        RVLogger.d("AdapterMapView", "initMap........");
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7094a.getMapAsync(new OnMapReadyCallback() { // from class: com.alipay.mobile.apmap.AdapterMapView.1
                {
                    AdapterMapView.this = this;
                }

                @Override // com.google.android.gms.maps.OnMapReadyCallback
                public void onMapReady(GoogleMap googleMap) {
                    RVLogger.d("AdapterMapView", "doOnMapReady");
                    AdapterMapView.this.a(googleMap, onAdapterMapReadyCallback);
                }
            });
        } else if (onAdapterMapReadyCallback != null) {
            onAdapterMapReadyCallback.onAdapterMapReady(this.b);
        }
    }

    public void a(GoogleMap googleMap, OnAdapterMapReadyCallback onAdapterMapReadyCallback) {
        googleMap.setMapType(1);
        AdapterAMap adapterAMap = new AdapterAMap(googleMap);
        this.b = adapterAMap;
        if (onAdapterMapReadyCallback != null) {
            onAdapterMapReadyCallback.onAdapterMapReady(adapterAMap);
        }
    }

    public AdapterAMap getMap(OnAdapterMapReadyCallback onAdapterMapReadyCallback) {
        RVLogger.d("AdapterMapView", "getMap........");
        if (AdapterUtil.isGoogleMapSdk()) {
            if (this.b == null) {
                initMap(onAdapterMapReadyCallback);
            }
            return this.b;
        }
        return this.b;
    }

    public void onCreate(Bundle bundle) {
        try {
            byte b = (byte) (PlaceComponentResult[5] - 1);
            byte b2 = PlaceComponentResult[5];
            Object[] objArr = new Object[1];
            I(b, b2, (byte) (b2 - 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (PlaceComponentResult[5] - 1);
            Object[] objArr2 = new Object[1];
            I(b3, b3, PlaceComponentResult[5], objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 493, 4 - (Process.myPid() >> 22), (char) (Process.myTid() >> 22));
                    byte b4 = (byte) ($$a[4] - 1);
                    byte b5 = b4;
                    Object[] objArr4 = new Object[1];
                    J(b4, b5, b5, objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - TextUtils.lastIndexOf("", '0', 0), 35 - View.combineMeasuredStates(0, 0), (char) View.combineMeasuredStates(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {312343073, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (KeyEvent.getMaxKeyCode() >> 16), TextUtils.getOffsetAfter("", 0) + 18, (char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                    this.f7094a.onCreate(bundle);
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
            this.f7094a.onResume();
        }
    }

    public void onPause() {
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7094a.onPause();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7094a.onSaveInstanceState(bundle);
        }
    }

    public void onDestroy() {
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7094a.onDestroy();
        }
    }

    public void removeAdapterView(View view) {
        if (AdapterUtil.isGoogleMapSdk()) {
            this.f7094a.removeView(view);
        }
    }
}
