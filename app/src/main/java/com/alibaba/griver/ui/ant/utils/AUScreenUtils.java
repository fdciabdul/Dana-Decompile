package com.alibaba.griver.ui.ant.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.ui.R;
import com.alibaba.griver.ui.ant.api.AUViewInterface;
import com.google.common.base.Ascii;
import java.util.HashMap;

/* loaded from: classes6.dex */
public class AUScreenUtils {

    /* renamed from: a  reason: collision with root package name */
    private static String f6700a = "";
    private static Boolean b;
    public static final byte[] getAuthRequestContext = {40, 6, -7, -65, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 4, -13, 35, -31, Ascii.NAK, 0, -6, Ascii.EM, -28, 19, 0, 0, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -31, Ascii.NAK, 0, -6, Ascii.EM, -28, 19, 0, 0, 34, -37, 9, -6, 10, -7, -4, 4, -13, TarHeader.LF_CHR, -39, 13, -16, 2, 39, -17, -10, 10};
    public static final int PlaceComponentResult = 236;
    private static HashMap<String, Boolean> c = new HashMap<>();

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0021 -> B:11:0x0028). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(int r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.alibaba.griver.ui.ant.utils.AUScreenUtils.getAuthRequestContext
            int r8 = r8 + 4
            int r7 = r7 + 99
            int r6 = r6 + 12
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L13
            r4 = r7
            r3 = 0
            r7 = r6
            goto L28
        L13:
            r3 = 0
        L14:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L21
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L21:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r5
        L28:
            int r4 = -r4
            int r6 = r6 + r4
            int r6 = r6 + 2
            int r8 = r8 + 1
            r5 = r7
            r7 = r6
            r6 = r5
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.ant.utils.AUScreenUtils.d(int, short, byte, java.lang.Object[]):void");
    }

    public static void setWhiteListAP(String str, Object obj) {
        if (obj == null || !obj.getClass().getName().equals("com.alipay.android.phone.home.widget.HomeWidgetGroup")) {
            return;
        }
        if ("emptyList".equals(str)) {
            str = "";
        }
        f6700a = str;
    }

    public static boolean checkApFlag(Context context, AttributeSet attributeSet, AUViewInterface aUViewInterface) {
        String str;
        if (b == null) {
            b = Boolean.valueOf(Float.compare(AUScreenAdaptTool.getAPDensity(context), AUScreenAdaptTool.getDensity(context)) == 0);
        }
        Boolean bool = b;
        if ((bool == null || !bool.booleanValue()) && !TextUtils.isEmpty(f6700a) && f6700a.contains(context.getClass().getName())) {
            if (aUViewInterface instanceof View) {
                ViewParent parent = ((View) aUViewInterface).getParent();
                if (aUViewInterface.isAP() == null && (parent instanceof AUViewInterface)) {
                    aUViewInterface.setAP(((AUViewInterface) parent).isAP());
                }
            }
            if (attributeSet != null) {
                str = String.valueOf(attributeSet.hashCode());
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.griverAUScreenAdapt);
                if (obtainStyledAttributes.hasValue(R.styleable.griverAUScreenAdapt_isAP) && aUViewInterface != null) {
                    aUViewInterface.setAP(Boolean.valueOf(obtainStyledAttributes.getBoolean(R.styleable.griverAUScreenAdapt_isAP, false)));
                } else if (c.containsKey(str)) {
                    return c.get(str).booleanValue();
                } else {
                    try {
                        char c2 = 16;
                        char c3 = 2;
                        Object[] objArr = new Object[1];
                        d(getAuthRequestContext[16], (byte) (-getAuthRequestContext[2]), (byte) (getAuthRequestContext[23] - 1), objArr);
                        Class<?> cls = Class.forName((String) objArr[0]);
                        byte b2 = (byte) (-getAuthRequestContext[15]);
                        byte b3 = getAuthRequestContext[21];
                        Object[] objArr2 = new Object[1];
                        d(b2, b3, b3, objArr2);
                        Object invoke = cls.getMethod((String) objArr2[0], null).invoke(null, null);
                        try {
                            Object[] objArr3 = new Object[1];
                            d(getAuthRequestContext[16], (byte) (-getAuthRequestContext[2]), (byte) (getAuthRequestContext[23] - 1), objArr3);
                            Class<?> cls2 = Class.forName((String) objArr3[0]);
                            byte b4 = (byte) (-getAuthRequestContext[15]);
                            byte b5 = getAuthRequestContext[16];
                            Object[] objArr4 = new Object[1];
                            d(b4, b5, (byte) (b5 | 8), objArr4);
                            Object[] objArr5 = (Object[]) cls2.getMethod((String) objArr4[0], null).invoke(invoke, null);
                            int length = objArr5.length;
                            int i = 0;
                            while (i < length) {
                                Object obj = objArr5[i];
                                try {
                                    Object[] objArr6 = new Object[1];
                                    d(getAuthRequestContext[7], (byte) (-getAuthRequestContext[c3]), getAuthRequestContext[76], objArr6);
                                    Class<?> cls3 = Class.forName((String) objArr6[0]);
                                    Object[] objArr7 = new Object[1];
                                    d(getAuthRequestContext[21], getAuthRequestContext[c2], (byte) (-getAuthRequestContext[3]), objArr7);
                                    if (TextUtils.equals((CharSequence) cls3.getMethod((String) objArr7[0], null).invoke(obj, null), "com.alipay.android.phone.discovery.o2ohome.O2oWidgetGroup")) {
                                        c.put(str, Boolean.FALSE);
                                        return false;
                                    }
                                    i++;
                                    c2 = 16;
                                    c3 = 2;
                                } catch (Throwable th) {
                                    Throwable cause = th.getCause();
                                    if (cause != null) {
                                        throw cause;
                                    }
                                    throw th;
                                }
                            }
                        } catch (Throwable th2) {
                            Throwable cause2 = th2.getCause();
                            if (cause2 != null) {
                                throw cause2;
                            }
                            throw th2;
                        }
                    } catch (Throwable th3) {
                        Throwable cause3 = th3.getCause();
                        if (cause3 != null) {
                            throw cause3;
                        }
                        throw th3;
                    }
                }
                obtainStyledAttributes.recycle();
            } else {
                str = "";
            }
            if (aUViewInterface != null && aUViewInterface.isAP() != null) {
                return aUViewInterface.isAP().booleanValue();
            }
            if (!TextUtils.isEmpty(str)) {
                c.put(str, Boolean.TRUE);
            }
            return true;
        }
        return false;
    }
}
