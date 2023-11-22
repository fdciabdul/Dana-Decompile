package com.apiguard3.internal;

import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewConfiguration;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import kotlin.text.Typography;

/* loaded from: classes7.dex */
public final class UrlMatcher {
    private static int APIGuard = 1;
    private static int getSharedInstance;
    private static int valueOf;

    static {
        valueOf();
        SystemClock.currentThreadTimeMillis();
        TextUtils.lastIndexOf("", '0', 0);
        ViewConfiguration.getWindowTouchSlop();
        APIGuard = (valueOf + 73) % 128;
    }

    static void valueOf() {
        getSharedInstance = 10;
    }

    public static byte[] values(char... cArr) {
        int i = valueOf;
        int i2 = (i + 111) % 128;
        APIGuard = i2;
        if ((cArr == null ? '/' : (char) 25) == '/') {
            int i3 = i + 7;
            APIGuard = i3 % 128;
            if ((i3 % 2 == 0 ? '\b' : '1') != '\b') {
                return null;
            }
            throw null;
        }
        if (!(cArr.length != 0)) {
            int i4 = i2 + 95;
            valueOf = i4 % 128;
            return !(i4 % 2 == 0) ? new byte[1] : new byte[0];
        }
        Object[] objArr = new Object[1];
        APIGuard((-16777211) - Color.rgb(0, 0, 0), 5 - View.combineMeasuredStates(0, 0), "\u0011\u0010\u0002￩\ufff4", false, 78 - (ViewConfiguration.getScrollDefaultDelay() >> 16), objArr);
        return values(Charset.forName(((String) objArr[0]).intern()).encode(CharBuffer.wrap(cArr)));
    }

    public static byte[] AGState(String str) {
        int i = valueOf + 55;
        int i2 = i % 128;
        APIGuard = i2;
        if (i % 2 == 0) {
            throw null;
        }
        if (str == null) {
            valueOf = (i2 + 31) % 128;
            return null;
        } else if (str.isEmpty()) {
            int i3 = APIGuard + 47;
            valueOf = i3 % 128;
            return i3 % 2 != 0 ? new byte[0] : new byte[0];
        } else {
            Object[] objArr = new Object[1];
            APIGuard(TextUtils.indexOf((CharSequence) "", '0', 0) + 6, (ViewConfiguration.getScrollBarSize() >> 8) + 5, "\u0011\u0010\u0002￩\ufff4", false, 78 - Gravity.getAbsoluteGravity(0, 0), objArr);
            byte[] values = values(Charset.forName(((String) objArr[0]).intern()).encode(str));
            valueOf = (APIGuard + 27) % 128;
            return values;
        }
    }

    private static char[] valueOf(byte... bArr) {
        if ((bArr == null ? 'N' : '*') != 'N') {
            if (bArr.length != 0) {
                Object[] objArr = new Object[1];
                APIGuard((ViewConfiguration.getJumpTapTimeout() >> 16) + 5, 5 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), "\u0011\u0010\u0002￩\ufff4", false, View.resolveSizeAndState(0, 0, 0) + 78, objArr);
                CharBuffer decode = Charset.forName(((String) objArr[0]).intern()).decode(ByteBuffer.wrap(bArr));
                char[] cArr = new char[decode.length()];
                decode.get(cArr);
                int i = valueOf + 9;
                APIGuard = i % 128;
                if ((i % 2 == 0 ? '@' : 'V') == 'V') {
                    return cArr;
                }
                throw new ArithmeticException();
            }
            int i2 = APIGuard + 95;
            valueOf = i2 % 128;
            return i2 % 2 != 0 ? new char[1] : new char[0];
        }
        return null;
    }

    public static String getSharedInstance(byte... bArr) {
        APIGuard = (valueOf + 37) % 128;
        char[] valueOf2 = valueOf(bArr);
        if ((valueOf2 == null ? (char) 24 : Typography.less) != 24) {
            return new String(valueOf2);
        }
        APIGuard = (valueOf + 39) % 128;
        return null;
    }

    private static byte[] values(ByteBuffer byteBuffer) {
        APIGuard = (valueOf + 111) % 128;
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        valueOf = (APIGuard + 25) % 128;
        return bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r8 = r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void APIGuard(int r6, int r7, java.lang.String r8, boolean r9, int r10, java.lang.Object[] r11) {
        /*
            if (r8 == 0) goto L6
            char[] r8 = r8.toCharArray()
        L6:
            char[] r8 = (char[]) r8
            java.lang.Object r0 = com.apiguard3.internal.setForegroundTintList.getSharedInstance
            monitor-enter(r0)
            char[] r1 = new char[r6]     // Catch: java.lang.Throwable -> L75
            r2 = 0
            com.apiguard3.internal.setForegroundTintList.APIGuard = r2     // Catch: java.lang.Throwable -> L75
        L10:
            int r3 = com.apiguard3.internal.setForegroundTintList.APIGuard     // Catch: java.lang.Throwable -> L75
            if (r3 >= r6) goto L33
            int r3 = com.apiguard3.internal.setForegroundTintList.APIGuard     // Catch: java.lang.Throwable -> L75
            char r3 = r8[r3]     // Catch: java.lang.Throwable -> L75
            com.apiguard3.internal.setForegroundTintList.values = r3     // Catch: java.lang.Throwable -> L75
            int r3 = com.apiguard3.internal.setForegroundTintList.APIGuard     // Catch: java.lang.Throwable -> L75
            int r4 = com.apiguard3.internal.setForegroundTintList.values     // Catch: java.lang.Throwable -> L75
            int r4 = r4 + r10
            char r4 = (char) r4     // Catch: java.lang.Throwable -> L75
            r1[r3] = r4     // Catch: java.lang.Throwable -> L75
            int r3 = com.apiguard3.internal.setForegroundTintList.APIGuard     // Catch: java.lang.Throwable -> L75
            char r4 = r1[r3]     // Catch: java.lang.Throwable -> L75
            int r5 = com.apiguard3.internal.UrlMatcher.getSharedInstance     // Catch: java.lang.Throwable -> L75
            int r4 = r4 - r5
            char r4 = (char) r4     // Catch: java.lang.Throwable -> L75
            r1[r3] = r4     // Catch: java.lang.Throwable -> L75
            int r3 = com.apiguard3.internal.setForegroundTintList.APIGuard     // Catch: java.lang.Throwable -> L75
            int r3 = r3 + 1
            com.apiguard3.internal.setForegroundTintList.APIGuard = r3     // Catch: java.lang.Throwable -> L75
            goto L10
        L33:
            if (r7 <= 0) goto L4e
            com.apiguard3.internal.setForegroundTintList.AGState = r7     // Catch: java.lang.Throwable -> L75
            char[] r7 = new char[r6]     // Catch: java.lang.Throwable -> L75
            java.lang.System.arraycopy(r1, r2, r7, r2, r6)     // Catch: java.lang.Throwable -> L75
            int r8 = com.apiguard3.internal.setForegroundTintList.AGState     // Catch: java.lang.Throwable -> L75
            int r8 = r6 - r8
            int r10 = com.apiguard3.internal.setForegroundTintList.AGState     // Catch: java.lang.Throwable -> L75
            java.lang.System.arraycopy(r7, r2, r1, r8, r10)     // Catch: java.lang.Throwable -> L75
            int r8 = com.apiguard3.internal.setForegroundTintList.AGState     // Catch: java.lang.Throwable -> L75
            int r10 = com.apiguard3.internal.setForegroundTintList.AGState     // Catch: java.lang.Throwable -> L75
            int r10 = r6 - r10
            java.lang.System.arraycopy(r7, r8, r1, r2, r10)     // Catch: java.lang.Throwable -> L75
        L4e:
            if (r9 == 0) goto L6c
            char[] r7 = new char[r6]     // Catch: java.lang.Throwable -> L75
            com.apiguard3.internal.setForegroundTintList.APIGuard = r2     // Catch: java.lang.Throwable -> L75
        L54:
            int r8 = com.apiguard3.internal.setForegroundTintList.APIGuard     // Catch: java.lang.Throwable -> L75
            if (r8 >= r6) goto L6b
            int r8 = com.apiguard3.internal.setForegroundTintList.APIGuard     // Catch: java.lang.Throwable -> L75
            int r9 = com.apiguard3.internal.setForegroundTintList.APIGuard     // Catch: java.lang.Throwable -> L75
            int r9 = r6 - r9
            int r9 = r9 + (-1)
            char r9 = r1[r9]     // Catch: java.lang.Throwable -> L75
            r7[r8] = r9     // Catch: java.lang.Throwable -> L75
            int r8 = com.apiguard3.internal.setForegroundTintList.APIGuard     // Catch: java.lang.Throwable -> L75
            int r8 = r8 + 1
            com.apiguard3.internal.setForegroundTintList.APIGuard = r8     // Catch: java.lang.Throwable -> L75
            goto L54
        L6b:
            r1 = r7
        L6c:
            java.lang.String r6 = new java.lang.String     // Catch: java.lang.Throwable -> L75
            r6.<init>(r1)     // Catch: java.lang.Throwable -> L75
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L75
            r11[r2] = r6
            return
        L75:
            r6 = move-exception
            monitor-exit(r0)
            goto L79
        L78:
            throw r6
        L79:
            goto L78
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.UrlMatcher.APIGuard(int, int, java.lang.String, boolean, int, java.lang.Object[]):void");
    }
}
