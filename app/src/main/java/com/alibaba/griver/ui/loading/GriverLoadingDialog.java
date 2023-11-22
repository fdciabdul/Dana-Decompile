package com.alibaba.griver.ui.loading;

import android.app.Dialog;
import android.content.Context;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.ui.R;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes6.dex */
public class GriverLoadingDialog extends Dialog {
    public static final byte[] $$a = {116, -27, -60, 115, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 44;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {SignedBytes.MAX_POWER_OF_TWO, 34, -50, 73, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int getAuthRequestContext = 72;

    /* renamed from: a  reason: collision with root package name */
    private ProgressBar f6720a;
    private TextView b;
    private String c;
    private Context d;

    private static void e(short s, int i, short s2, Object[] objArr) {
        byte[] bArr = BuiltInFictitiousFunctionClassFactory;
        int i2 = (s * 3) + 16;
        int i3 = s2 + 105;
        int i4 = 18 - (i * 15);
        byte[] bArr2 = new byte[i2];
        int i5 = -1;
        int i6 = i2 - 1;
        if (bArr == null) {
            i3 = i6 + i4 + 2;
            i6 = i6;
            i4 = i4;
        }
        while (true) {
            i5++;
            bArr2[i5] = (byte) i3;
            int i7 = i4 + 1;
            if (i5 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i3 = i3 + bArr[i7] + 2;
            i6 = i6;
            i4 = i7;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void f(byte r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 + 4
            int r8 = r8 * 4
            int r8 = 75 - r8
            byte[] r0 = com.alibaba.griver.ui.loading.GriverLoadingDialog.$$a
            int r7 = r7 * 4
            int r7 = 42 - r7
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L15
            r4 = r8
            r3 = 0
            r8 = r7
            goto L2c
        L15:
            r3 = 0
        L16:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r6 = r6 + 1
            int r3 = r3 + 1
            if (r3 != r7) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            r4 = r0[r6]
            r5 = r8
            r8 = r7
            r7 = r5
        L2c:
            int r7 = r7 + r4
            int r7 = r7 + (-7)
            r5 = r8
            r8 = r7
            r7 = r5
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.loading.GriverLoadingDialog.f(byte, int, short, java.lang.Object[]):void");
    }

    public GriverLoadingDialog(Context context) {
        this(context, R.style.griver_loading_style);
    }

    public GriverLoadingDialog(Context context, int i) {
        super(context, i);
        this.d = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        try {
            byte b = (byte) (BuiltInFictitiousFunctionClassFactory[5] + 1);
            Object[] objArr = new Object[1];
            e(b, b, (byte) (-BuiltInFictitiousFunctionClassFactory[5]), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) (BuiltInFictitiousFunctionClassFactory[5] + 1);
            byte b3 = (byte) (-BuiltInFictitiousFunctionClassFactory[5]);
            Object[] objArr2 = new Object[1];
            e(b2, b3, (byte) (b3 - 1), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollDefaultDelay() >> 16) + 494, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 3, (char) TextUtils.indexOf("", ""));
                    byte b4 = $$a[4];
                    byte b5 = (byte) (b4 + 1);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), TextUtils.lastIndexOf("", '0') + 36, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-700042159, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - ((byte) KeyEvent.getModifierMetaStateMask()), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 18, (char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                View inflate = LayoutInflater.from(this.d).inflate(R.layout.griver_ui_loading_dialog, (ViewGroup) null);
                this.f6720a = (ProgressBar) inflate.findViewById(R.id.h5_loading_progress);
                this.b = (TextView) inflate.findViewById(R.id.h5_loading_message);
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.alpha = 0.99f;
                getWindow().setAttributes(attributes);
                setContentView(inflate);
                this.f6720a.setVisibility(0);
                setCancelable(true);
                setOnCancelListener(null);
                this.f6720a.setIndeterminate(false);
                setCanceledOnTouchOutside(false);
                a();
                super.onCreate(bundle);
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

    public void setMessage(String str) {
        this.c = str;
        if (this.b != null) {
            a();
        }
    }

    private void a() {
        this.b.setText(this.c);
        if (TextUtils.isEmpty(this.c)) {
            this.b.setVisibility(8);
        } else {
            this.b.setVisibility(0);
        }
    }
}
