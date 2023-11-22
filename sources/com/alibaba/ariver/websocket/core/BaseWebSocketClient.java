package com.alibaba.ariver.websocket.core;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes6.dex */
public abstract class BaseWebSocketClient implements RVWebSocketClient {
    public static final byte[] $$a = {TarHeader.LF_LINK, 16, -25, 45, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 234;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {59, -54, -26, -72, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int PlaceComponentResult = 166;

    /* renamed from: a  reason: collision with root package name */
    private String f6249a;
    private String b;
    private Map<String, String> c;
    private RVWebSocketCallback d;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void e(int r7, byte r8, short r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 15
            int r7 = 18 - r7
            byte[] r0 = com.alibaba.ariver.websocket.core.BaseWebSocketClient.BuiltInFictitiousFunctionClassFactory
            int r8 = r8 * 2
            int r8 = r8 + 16
            int r9 = 106 - r9
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r9
            r4 = 0
            r9 = r8
            r8 = r7
            goto L2e
        L16:
            r3 = 0
        L17:
            int r7 = r7 + 1
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r8) goto L28
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L28:
            r3 = r0[r7]
            r6 = r8
            r8 = r7
            r7 = r9
            r9 = r6
        L2e:
            int r7 = r7 + r3
            int r7 = r7 + 2
            r3 = r4
            r6 = r9
            r9 = r7
            r7 = r8
            r8 = r6
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.websocket.core.BaseWebSocketClient.e(int, byte, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    private static void f(short s, byte b, short s2, Object[] objArr) {
        byte[] bArr = $$a;
        int i = 4 - (s * 3);
        int i2 = 42 - (s2 * 4);
        int i3 = 75 - (b * 4);
        byte[] bArr2 = new byte[i2];
        int i4 = i2 - 1;
        int i5 = 0;
        if (bArr == null) {
            i++;
            i3 = (i + i3) - 7;
        }
        while (true) {
            byte b2 = i3;
            int i6 = i;
            bArr2[i5] = b2;
            if (i5 == i4) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i5++;
            i = i6 + 1;
            i3 = (b2 + bArr[i6]) - 7;
        }
    }

    protected void onCreate() {
        try {
            byte b = (byte) (BuiltInFictitiousFunctionClassFactory[5] + 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            e(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (-BuiltInFictitiousFunctionClassFactory[5]);
            Object[] objArr2 = new Object[1];
            e(b3, (byte) (b3 - 1), (byte) (-BuiltInFictitiousFunctionClassFactory[5]), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 494, Color.red(0) + 4, (char) View.MeasureSpec.getSize(0));
                    byte b4 = (byte) ($$a[35] - 1);
                    byte b5 = b4;
                    Object[] objArr4 = new Object[1];
                    f(b4, b5, b5, objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - TextUtils.indexOf("", ""), (char) KeyEvent.getDeadChar(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-1247139451, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + 911, (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 18, (char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    public BaseWebSocketClient(String str, String str2, Map<String, String> map, RVWebSocketCallback rVWebSocketCallback) {
        onCreate();
        this.f6249a = str;
        this.b = str2;
        this.c = map;
        this.d = rVWebSocketCallback;
    }

    public String getId() {
        return this.f6249a;
    }

    public String getUrl() {
        return this.b;
    }

    public Map<String, String> getHeaders() {
        return this.c;
    }

    public RVWebSocketCallback getCallback() {
        return this.d;
    }
}
