package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.android.gms.common.internal.Preconditions;
import com.google.common.base.Ascii;
import id.dana.onboarding.splash.LauncherActivity;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes.dex */
public class LifecycleCallback {
    protected final LifecycleFragment mLifecycleFragment;
    public static final byte[] $$a = {Ascii.EM, 60, 112, -12, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 27;
    public static final byte[] getAuthRequestContext = {Ascii.ESC, -74, -29, -66, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 11;

    public LifecycleCallback(LifecycleFragment lifecycleFragment) {
        this.mLifecycleFragment = lifecycleFragment;
    }

    private static void a(short s, short s2, short s3, Object[] objArr) {
        int i = 18 - (s * 15);
        int i2 = (s2 * 2) + 16;
        int i3 = 106 - s3;
        byte[] bArr = getAuthRequestContext;
        byte[] bArr2 = new byte[i2];
        int i4 = -1;
        int i5 = i2 - 1;
        if (bArr == null) {
            i3 = i5 + i + 2;
            i = i;
            i5 = i5;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = -1;
        }
        while (true) {
            int i6 = i4 + 1;
            bArr2[i6] = (byte) i3;
            int i7 = i + 1;
            if (i6 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i3 = i3 + bArr[i7] + 2;
            i = i7;
            i5 = i5;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = i6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r8, int r9, byte r10, java.lang.Object[] r11) {
        /*
            int r8 = r8 * 3
            int r8 = 75 - r8
            int r10 = r10 + 4
            int r9 = r9 * 3
            int r9 = 42 - r9
            byte[] r0 = com.google.android.gms.common.api.internal.LifecycleCallback.$$a
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L18
            r8 = r9
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r11
            r11 = r10
            goto L35
        L18:
            r3 = 0
        L19:
            byte r4 = (byte) r8
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r9) goto L28
            java.lang.String r8 = new java.lang.String
            r8.<init>(r1, r2)
            r11[r2] = r8
            return
        L28:
            int r10 = r10 + 1
            r3 = r0[r10]
            r6 = r9
            r9 = r8
            r8 = r6
            r7 = r11
            r11 = r10
            r10 = r3
            r3 = r1
            r1 = r0
            r0 = r7
        L35:
            int r9 = r9 + r10
            int r9 = r9 + (-7)
            r10 = r11
            r11 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            r6 = r9
            r9 = r8
            r8 = r6
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.LifecycleCallback.b(short, int, byte, java.lang.Object[]):void");
    }

    private static LifecycleFragment getChimeraLifecycleFragmentImpl(LifecycleActivity lifecycleActivity) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    public static LifecycleFragment getFragment(Activity activity) {
        return getFragment(new LifecycleActivity(activity));
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public Activity getActivity() {
        Activity lifecycleActivity = this.mLifecycleFragment.getLifecycleActivity();
        Preconditions.checkNotNull(lifecycleActivity);
        return lifecycleActivity;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onCreate(Bundle bundle) {
        try {
            byte b = (byte) (getAuthRequestContext[5] + 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (-getAuthRequestContext[5]);
            Object[] objArr2 = new Object[1];
            a(b3, (byte) (b3 - 1), (byte) (-getAuthRequestContext[5]), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - View.resolveSizeAndState(0, 0, 0), 3 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) Drawable.resolveOpacity(0, 0));
                    byte b4 = (byte) ($$a[35] - 1);
                    Object[] objArr4 = new Object[1];
                    b(b4, b4, $$a[4], objArr4);
                    obj = cls2.getMethod((String) objArr4[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj);
                }
                Object[] objArr5 = (Object[]) ((Method) obj).invoke(null, objArr3);
                int i = ((int[]) objArr5[1])[0];
                if (((int[]) objArr5[0])[0] == i) {
                    return;
                }
                long j = ((r1 ^ i) & 4294967295L) | 42949672960L;
                try {
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.getSize(0), 36 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                    }
                    Object invoke = ((Method) obj2).invoke(null, null);
                    try {
                        Object[] objArr6 = {2061657151, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                        Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                        if (obj3 == null) {
                            obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 17, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
    }

    public void onResume() {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public static LifecycleFragment getFragment(ContextWrapper contextWrapper) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static LifecycleFragment getFragment(LifecycleActivity lifecycleActivity) {
        if (lifecycleActivity.zzd()) {
            return zzd.zzc(lifecycleActivity.zzb());
        }
        if (lifecycleActivity.zzc()) {
            return zzb.zzc(lifecycleActivity.zza());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }
}
