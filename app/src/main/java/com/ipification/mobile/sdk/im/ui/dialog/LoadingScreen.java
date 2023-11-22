package com.ipification.mobile.sdk.im.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import com.ipification.mobile.sdk.android.R;
import com.ipification.mobile.sdk.android.databinding.LoadingDialogBinding;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006R\u0012\u0010\n\u001a\u00020\u0007X\u0086\"¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lcom/ipification/mobile/sdk/im/ui/dialog/LoadingScreen;", "Landroid/app/Dialog;", "Landroid/os/Bundle;", "p0", "", "onCreate", "(Landroid/os/Bundle;)V", "Lcom/ipification/mobile/sdk/android/databinding/LoadingDialogBinding;", "BuiltInFictitiousFunctionClassFactory", "Lcom/ipification/mobile/sdk/android/databinding/LoadingDialogBinding;", "PlaceComponentResult", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class LoadingScreen extends Dialog {
    public static final byte[] $$a = {56, 110, 47, 101, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 176;
    public static final byte[] PlaceComponentResult = {111, 84, 114, 59, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int getAuthRequestContext = 144;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public LoadingDialogBinding PlaceComponentResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingScreen(Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.ipification.mobile.sdk.im.ui.dialog.LoadingScreen.PlaceComponentResult
            int r7 = r7 * 2
            int r7 = r7 + 16
            int r6 = r6 + 105
            int r8 = r8 + 4
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L30
        L15:
            r3 = 0
        L16:
            byte r4 = (byte) r6
            int r8 = r8 + 1
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r7) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            r4 = r0[r8]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L30:
            int r8 = -r8
            int r6 = r6 + r8
            int r6 = r6 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipification.mobile.sdk.im.ui.dialog.LoadingScreen.a(short, int, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 3
            int r7 = r7 + 75
            byte[] r0 = com.ipification.mobile.sdk.im.ui.dialog.LoadingScreen.$$a
            int r8 = r8 * 3
            int r8 = r8 + 4
            int r6 = r6 * 3
            int r6 = 42 - r6
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1d
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L37
        L1d:
            r3 = 0
        L1e:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L2d
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2d:
            r3 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L37:
            int r6 = -r6
            int r9 = r9 + 1
            int r8 = r8 + r6
            int r6 = r8 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipification.mobile.sdk.im.ui.dialog.LoadingScreen.b(short, int, byte, java.lang.Object[]):void");
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle p0) {
        try {
            byte b = PlaceComponentResult[5];
            byte b2 = (byte) (b - 1);
            Object[] objArr = new Object[1];
            a(b, b2, (byte) (b2 | 14), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (PlaceComponentResult[5] - 1);
            Object[] objArr2 = new Object[1];
            a(b3, b3, (byte) (-PlaceComponentResult[5]), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 494, 4 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) (AndroidCharacter.getMirror('0') - '0'));
                    byte b4 = (byte) ($$a[4] - 1);
                    byte b5 = b4;
                    Object[] objArr4 = new Object[1];
                    b(b4, b5, b5, objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.blue(0) + PDF417Common.NUMBER_OF_CODEWORDS, 34 - TextUtils.indexOf((CharSequence) "", '0', 0), (char) View.MeasureSpec.getSize(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {236268506, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.indexOf((CharSequence) "", '0', 0), 18 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) TextUtils.indexOf("", "", 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                super.onCreate(p0);
                requestWindowFeature(1);
                Window window = getWindow();
                if (window != null) {
                    window.setBackgroundDrawable(new ColorDrawable(0));
                }
                View inflate = getLayoutInflater().inflate(R.layout.res_0x7f0d03c4_kclassimpl_data_declarednonstaticmembers_2, (ViewGroup) null, false);
                if (inflate != null) {
                    LoadingDialogBinding loadingDialogBinding = new LoadingDialogBinding((RelativeLayout) inflate);
                    Intrinsics.checkExpressionValueIsNotNull(loadingDialogBinding, "");
                    Intrinsics.checkParameterIsNotNull(loadingDialogBinding, "");
                    this.PlaceComponentResult = loadingDialogBinding;
                    if (loadingDialogBinding != null) {
                        RelativeLayout relativeLayout = loadingDialogBinding.MyBillsEntityDataFactory;
                        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "");
                        setContentView(relativeLayout);
                        setCanceledOnTouchOutside(false);
                        setCancelable(false);
                        return;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    throw null;
                }
                throw new NullPointerException("rootView");
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
}
