package com.apiguard3.url_matcher;

import android.graphics.Color;
import android.media.AudioTrack;
import android.os.Process;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import java.io.Serializable;
import kotlin.text.Typography;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class UrlMatcher implements Serializable {
    private static int AGState = 1;
    private static final long serialVersionUID = -8578215390633979422L;
    private static int valueOf = 51;
    private static int values;
    private String domain;
    private String path;
    private String port;
    private String queryString;
    private String scheme;

    public UrlMatcher(JSONObject jSONObject) {
        Object[] objArr = new Object[1];
        AGState(Process.getGidForName("") + 5, (ViewConfiguration.getFadingEdgeLength() >> 16) + 3, "\t\ufff6\u0005�", true, View.MeasureSpec.getMode(0) + 158, objArr);
        if (jSONObject.has(((String) objArr[0]).intern())) {
            Object[] objArr2 = new Object[1];
            AGState(TextUtils.getCapsMode("", 0, 0) + 4, (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 3, "\t\ufff6\u0005�", true, 158 - (ViewConfiguration.getTapTimeout() >> 16), objArr2);
            this.path = jSONObject.optJSONArray(((String) objArr2[0]).intern()).toString();
        }
        Object[] objArr3 = new Object[1];
        AGState(5 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), 4 - View.MeasureSpec.makeMeasureSpec(0, 0), "\uffff\ufffe\u0001\u0003", false, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 164, objArr3);
        if (jSONObject.has(((String) objArr3[0]).intern())) {
            Object[] objArr4 = new Object[1];
            AGState(4 - Color.alpha(0), 3 - MotionEvent.axisFromString(""), "\uffff\ufffe\u0001\u0003", false, 164 - (Process.myTid() >> 22), objArr4);
            this.port = jSONObject.optJSONArray(((String) objArr4[0]).intern()).toString();
        }
        Object[] objArr5 = new Object[1];
        AGState((-16777210) - Color.rgb(0, 0, 0), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 3, "\u0000\ufffb\u000b�\u0005�", true, 156 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), objArr5);
        if (jSONObject.has(((String) objArr5[0]).intern())) {
            Object[] objArr6 = new Object[1];
            AGState((ViewConfiguration.getPressedStateDuration() >> 16) + 6, View.MeasureSpec.getMode(0) + 3, "\u0000\ufffb\u000b�\u0005�", true, (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 154, objArr6);
            this.scheme = jSONObject.optJSONArray(((String) objArr6[0]).intern()).toString();
        }
        Object[] objArr7 = new Object[1];
        AGState(View.getDefaultSize(0, 0) + 11, 1 - (ViewConfiguration.getEdgeSlop() >> 16), "\ufffb\u0005\t\ufff9\u0006\r\uffe7\b\u0006�\u0002", false, 159 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), objArr7);
        if (jSONObject.has(((String) objArr7[0]).intern())) {
            Object[] objArr8 = new Object[1];
            AGState(10 - TextUtils.lastIndexOf("", '0'), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 1, "\ufffb\u0005\t\ufff9\u0006\r\uffe7\b\u0006�\u0002", false, (-16777057) - Color.rgb(0, 0, 0), objArr8);
            this.queryString = jSONObject.optJSONArray(((String) objArr8[0]).intern()).toString();
        }
        Object[] objArr9 = new Object[1];
        AGState(MotionEvent.axisFromString("") + 7, 5 - (ViewConfiguration.getScrollDefaultDelay() >> 16), "\u0000\ufff8\u0004\u0006\ufffb\u0005", true, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 156, objArr9);
        if (jSONObject.has(((String) objArr9[0]).intern())) {
            Object[] objArr10 = new Object[1];
            AGState((-16777210) - Color.rgb(0, 0, 0), 5 - View.resolveSize(0, 0), "\u0000\ufff8\u0004\u0006\ufffb\u0005", true, 156 - Gravity.getAbsoluteGravity(0, 0), objArr10);
            this.domain = jSONObject.optJSONArray(((String) objArr10[0]).intern()).toString();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            AGState = (values + 115) % 128;
            return true;
        }
        if (obj != null) {
            int i = values + 47;
            AGState = i % 128;
            if (i % 2 == 0) {
                throw new NullPointerException();
            }
            if ((getClass() != obj.getClass() ? '(' : (char) 15) != '(') {
                UrlMatcher urlMatcher = (UrlMatcher) obj;
                if ((TextUtils.equals(this.path, urlMatcher.path) ? '\'' : 'K') == '\'') {
                    AGState = (values + 1) % 128;
                    if (TextUtils.equals(this.port, urlMatcher.port)) {
                        int i2 = AGState + 51;
                        values = i2 % 128;
                        if (i2 % 2 != 0) {
                            TextUtils.equals(this.scheme, urlMatcher.scheme);
                            throw new NullPointerException();
                        } else if (TextUtils.equals(this.scheme, urlMatcher.scheme)) {
                            if ((TextUtils.equals(this.queryString, urlMatcher.queryString) ? Typography.dollar : '\\') != '\\' && TextUtils.equals(this.domain, urlMatcher.domain)) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        AGState = (values + 7) % 128;
        String str = this.path;
        int i = 0;
        int hashCode3 = str == null ? 0 : str.hashCode();
        String str2 = this.port;
        if (str2 == null) {
            values = (AGState + 15) % 128;
            hashCode = 0;
        } else {
            hashCode = str2.hashCode();
        }
        String str3 = this.scheme;
        if (str3 == null) {
            AGState = (values + 23) % 128;
            hashCode2 = 0;
        } else {
            hashCode2 = str3.hashCode();
        }
        String str4 = this.queryString;
        int hashCode4 = (str4 == null ? 'I' : '9') != 'I' ? str4.hashCode() : 0;
        String str5 = this.domain;
        if (!(str5 != null)) {
            values = (AGState + 75) % 128;
        } else {
            i = str5.hashCode();
            AGState = (values + 5) % 128;
        }
        return ((((((((hashCode3 + 527) * 31) + hashCode) * 31) + hashCode2) * 31) + hashCode4) * 31) + i;
    }

    public String values() {
        int i = values + 15;
        AGState = i % 128;
        if ((i % 2 == 0 ? 'T' : '4') == '4') {
            return this.scheme;
        }
        throw null;
    }

    public String AGState() {
        int i = values + 65;
        AGState = i % 128;
        if ((i % 2 == 0 ? ']' : '8') != ']') {
            return this.path;
        }
        throw new ArithmeticException();
    }

    public String valueOf() {
        int i = values + 49;
        AGState = i % 128;
        if ((i % 2 == 0 ? 'c' : (char) 11) != 'c') {
            return this.port;
        }
        throw new ArithmeticException();
    }

    public String getSharedInstance() {
        int i = (AGState + 19) % 128;
        values = i;
        String str = this.queryString;
        int i2 = i + 123;
        AGState = i2 % 128;
        if (i2 % 2 != 0) {
            return str;
        }
        throw null;
    }

    public String APIGuard() {
        int i = (AGState + 123) % 128;
        values = i;
        String str = this.domain;
        int i2 = i + 65;
        AGState = i2 % 128;
        if ((i2 % 2 == 0 ? '_' : (char) 1) != '_') {
            return str;
        }
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r8 = r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void AGState(int r6, int r7, java.lang.String r8, boolean r9, int r10, java.lang.Object[] r11) {
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
            int r5 = com.apiguard3.url_matcher.UrlMatcher.valueOf     // Catch: java.lang.Throwable -> L75
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
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.url_matcher.UrlMatcher.AGState(int, int, java.lang.String, boolean, int, java.lang.Object[]):void");
    }
}
