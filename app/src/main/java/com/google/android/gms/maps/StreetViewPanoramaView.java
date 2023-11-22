package com.google.android.gms.maps;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.common.base.Ascii;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes7.dex */
public class StreetViewPanoramaView extends FrameLayout {
    public static final byte[] $$a = {93, 18, 67, -65, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 143;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {116, -27, -60, 115, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int PlaceComponentResult = 51;
    private final zzat zza;

    public StreetViewPanoramaView(Context context) {
        super((Context) Preconditions.checkNotNull(context, "context must not be null"));
        this.zza = new zzat(this, context, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r7, short r8, byte r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 * 4
            int r9 = 16 - r9
            int r7 = r7 + 105
            byte[] r0 = com.google.android.gms.maps.StreetViewPanoramaView.KClassImpl$Data$declaredNonStaticMembers$2
            int r8 = r8 * 15
            int r8 = 18 - r8
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L18
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            goto L34
        L18:
            r3 = 0
        L19:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            int r8 = r8 + 1
            if (r4 != r9) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2a:
            r3 = r0[r8]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L34:
            int r8 = r8 + r7
            int r7 = r8 + 2
            r8 = r9
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.StreetViewPanoramaView.a(short, short, byte, java.lang.Object[]):void");
    }

    private static void b(short s, byte b, byte b2, Object[] objArr) {
        int i = (b2 * 4) + 75;
        int i2 = b + 4;
        int i3 = (s * 3) + 42;
        byte[] bArr = $$a;
        byte[] bArr2 = new byte[i3];
        int i4 = -1;
        int i5 = i3 - 1;
        if (bArr == null) {
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = -1;
            i = (i + i5) - 7;
            i5 = i5;
            i2 = i2;
        }
        while (true) {
            int i6 = i2 + 1;
            int i7 = i4 + 1;
            bArr2[i7] = (byte) i;
            if (i7 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            byte b3 = bArr[i6];
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = i7;
            i = (i + b3) - 7;
            i5 = i5;
            i2 = i6;
        }
    }

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        Preconditions.checkNotNull(onStreetViewPanoramaReadyCallback, "callback must not be null");
        Preconditions.checkMainThread("getStreetViewPanoramaAsync() must be called on the main thread");
        this.zza.zza(onStreetViewPanoramaReadyCallback);
    }

    public final void onCreate(Bundle bundle) {
        try {
            byte b = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]);
            byte b2 = (byte) (b - 1);
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1);
            byte b4 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]);
            Object[] objArr2 = new Object[1];
            a(b3, b4, (byte) (b4 - 1), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - Color.green(0), Color.alpha(0) + 4, (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)));
                    byte b5 = (byte) ($$a[35] - 1);
                    byte b6 = $$a[4];
                    Object[] objArr4 = new Object[1];
                    b(b5, b6, (byte) (b6 + 1), objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0', 0, 0) + 930, 35 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-1276305091, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 910, Color.green(0) + 18, (char) (ViewConfiguration.getFadingEdgeLength() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
                StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
                try {
                    this.zza.onCreate(bundle);
                    if (this.zza.getDelegate() == null) {
                        DeferredLifecycleHelper.showGooglePlayUnavailableMessage(this);
                    }
                } finally {
                    StrictMode.setThreadPolicy(threadPolicy);
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

    public void onDestroy() {
        this.zza.onDestroy();
    }

    public final void onLowMemory() {
        this.zza.onLowMemory();
    }

    public final void onPause() {
        this.zza.onPause();
    }

    public void onResume() {
        this.zza.onResume();
    }

    public final void onSaveInstanceState(Bundle bundle) {
        this.zza.onSaveInstanceState(bundle);
    }

    public void onStart() {
        this.zza.onStart();
    }

    public void onStop() {
        this.zza.onStop();
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeSet) {
        super((Context) Preconditions.checkNotNull(context, "context must not be null"), attributeSet);
        this.zza = new zzat(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeSet, int i) {
        super((Context) Preconditions.checkNotNull(context, "context must not be null"), attributeSet, i);
        this.zza = new zzat(this, context, null);
    }

    public StreetViewPanoramaView(Context context, StreetViewPanoramaOptions streetViewPanoramaOptions) {
        super((Context) Preconditions.checkNotNull(context, "context must not be null"));
        this.zza = new zzat(this, context, streetViewPanoramaOptions);
    }
}
