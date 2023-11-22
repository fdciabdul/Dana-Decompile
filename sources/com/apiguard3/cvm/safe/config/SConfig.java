package com.apiguard3.cvm.safe.config;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.apiguard3.internal.ConfigInstance;
import com.apiguard3.internal.readResolve;
import com.apiguard3.internal.setBackgroundTintList;
import com.apiguard3.internal.writeReplace;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.Typography;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class SConfig implements Serializable {
    public static final String AGState;
    private static char[] APIGuard = null;
    private static int getRequestHeaders = 1;
    private static long getSharedInstance = 0;
    private static final long serialVersionUID = 7438889113625161744L;
    private static int valueOf;
    private static long values;
    private String fraudQueryHeaderKeyName;
    private List<AnalysesEntry> endpointAnalyzed = new ArrayList();
    private List<ScoredEntry> endpointScored = new ArrayList();
    private volatile boolean foregroundEvent = false;
    private volatile boolean backgroundEvent = false;
    private volatile boolean focusChangedEvent = false;
    private volatile boolean textChangedEvent = false;
    private volatile boolean touchEvent = false;
    private volatile boolean keyEvent = false;

    static {
        initialize();
        TextUtils.indexOf((CharSequence) "", '0', 0);
        ViewConfiguration.getPressedStateDuration();
        KeyEvent.getModifierMetaStateMask();
        ViewConfiguration.getTapTimeout();
        ViewConfiguration.getFadingEdgeLength();
        ViewConfiguration.getJumpTapTimeout();
        Color.blue(0);
        SystemClock.elapsedRealtime();
        Color.alpha(0);
        ImageFormat.getBitsPerPixel(0);
        KeyEvent.getModifierMetaStateMask();
        Color.alpha(0);
        View.getDefaultSize(0, 0);
        ViewConfiguration.getFadingEdgeLength();
        View.MeasureSpec.getSize(0);
        Color.red(0);
        ExpandableListView.getPackedPositionGroup(0L);
        TextUtils.indexOf("", "", 0);
        KeyEvent.getMaxKeyCode();
        ImageFormat.getBitsPerPixel(0);
        ViewConfiguration.getWindowTouchSlop();
        ViewConfiguration.getGlobalActionKeyTimeout();
        ViewConfiguration.getKeyRepeatDelay();
        int offsetBefore = TextUtils.getOffsetBefore("", 0);
        Object[] objArr = new Object[1];
        valueOf(offsetBefore + 94, 9 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (ViewConfiguration.getTouchSlop() >> 8), objArr);
        AGState = ((String) objArr[0]).intern();
        getRequestHeaders = (valueOf + 95) % 128;
    }

    static void initialize() {
        getSharedInstance = 1874993875020998547L;
        APIGuard = new char[]{'f', 59361, 53063, 46796, 40488, 34190, 27911, 21856, 15594, 9298, 3062, 62260, 55941, 49683, 43631, 37359, 31099, 24742, 18479, 12199, 5917, 65378, 59079, 'e', 59389, 53058, 46793, 40483, 34230, 27932, 21873, 15577, 9285, 3039, 62269, 55965, 49677, 43631, 37369, 'e', 59389, 53058, 46793, 40483, 34230, 27932, 21873, 15563, 9288, 3025, 62243, 55937, 49683, 'f', 59388, 53076, 46812, 40491, 34221, 27933, 21872, 15606, 9295, 3067, 62247, 55937, 49689, 43646, 32316, 39358, 45334, 51333, 57415, 64511, 4955, 11043, 17079, 23046, 30098, 36188, 42202, 48218, 54316, 61345, 61477, 6061, 16130, 18059, 28277, 30155, 40277, 42289, 52391, 54286, 'a', 59363, 53057, 46740, 40490, 34222, 27930, 21870, 15606};
        values = -600003254875918412L;
    }

    private SConfig() {
    }

    public static SConfig APIGuard(JSONObject jSONObject) {
        SConfig sConfig = new SConfig();
        try {
            Object[] objArr = new Object[1];
            valueOf(TextUtils.getTrimmedLength(""), 23 - ExpandableListView.getPackedPositionGroup(0L), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16), objArr);
            sConfig.fraudQueryHeaderKeyName = jSONObject.optString(((String) objArr[0]).intern());
            Object[] objArr2 = new Object[1];
            values("\uefd5鄳ሪ錒ᐇ锉ᘘ霜ᡫ", 32503 - (ViewConfiguration.getWindowTouchSlop() >> 8), objArr2);
            JSONObject optJSONObject = jSONObject.optJSONObject(((String) objArr2[0]).intern());
            Object[] objArr3 = new Object[1];
            valueOf(Color.argb(0, 0, 0, 0) + 23, (Process.myTid() >> 22) + 16, (char) (Color.rgb(0, 0, 0) + 16777216), objArr3);
            AGState(optJSONObject.optJSONArray(((String) objArr3[0]).intern()), sConfig.endpointAnalyzed);
            Object[] objArr4 = new Object[1];
            valueOf(39 - (ViewConfiguration.getScrollBarSize() >> 8), TextUtils.getOffsetBefore("", 0) + 14, (char) (Process.myPid() >> 22), objArr4);
            APIGuard(optJSONObject.optJSONArray(((String) objArr4[0]).intern()), sConfig.endpointScored);
            Object[] objArr5 = new Object[1];
            valueOf(Color.argb(0, 0, 0, 0) + 53, (ViewConfiguration.getJumpTapTimeout() >> 16) + 15, (char) Color.blue(0), objArr5);
            sConfig.foregroundEvent = jSONObject.optBoolean(((String) objArr5[0]).intern());
            Object[] objArr6 = new Object[1];
            values("\uefd6⧠掽뵀\uf707ハ䫥蒲\ude72᠍凣殅ꖭｫ㤦", Color.red(0) + 50741, objArr6);
            sConfig.backgroundEvent = jSONObject.optBoolean(((String) objArr6[0]).intern());
            Object[] objArr7 = new Object[1];
            values("\uefd2ﱆ죭픖ꆳ跦驲暞猲彖⯳㡯ҭᄻ\ufd47짩혐", 5021 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), objArr7);
            sConfig.focusChangedEvent = jSONObject.optBoolean(((String) objArr7[0]).intern());
            Object[] objArr8 = new Object[1];
            valueOf(68 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), 15 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) ((ViewConfiguration.getKeyRepeatDelay() >> 16) + 32328), objArr8);
            sConfig.textChangedEvent = jSONObject.optBoolean(((String) objArr8[0]).intern());
            Object[] objArr9 = new Object[1];
            valueOf(AndroidCharacter.getMirror('0') + Typography.dollar, 10 - TextUtils.getCapsMode("", 0, 0), (char) (61520 - ((byte) KeyEvent.getModifierMetaStateMask())), objArr9);
            sConfig.touchEvent = jSONObject.optBoolean(((String) objArr9[0]).intern());
            Object[] objArr10 = new Object[1];
            values("\uefdf큀郯兂ᆆ툄銼匷", 16273 - (Process.myTid() >> 22), objArr10);
            sConfig.keyEvent = jSONObject.optBoolean(((String) objArr10[0]).intern());
            getRequestHeaders = (valueOf + 25) % 128;
        } catch (Throwable th) {
            readResolve.getSharedInstance(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.APIGuard.setVerticalScrollbarThumbDrawable, th.getMessage());
        }
        int i = valueOf + 47;
        getRequestHeaders = i % 128;
        if (!(i % 2 == 0)) {
            return sConfig;
        }
        throw new ArithmeticException();
    }

    private static void AGState(JSONArray jSONArray, List<AnalysesEntry> list) {
        int i = getRequestHeaders + 71;
        valueOf = i % 128;
        if ((i % 2 != 0 ? (char) 3 : 'Q') == 3) {
            throw new ArithmeticException();
        }
        if ((jSONArray != null ? (char) 20 : '*') != '*') {
            if (jSONArray.length() > 0) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    int i3 = valueOf + 69;
                    getRequestHeaders = i3 % 128;
                    if (i3 % 2 == 0) {
                        jSONArray.getJSONObject(i2);
                        throw new NullPointerException();
                        break;
                    }
                    try {
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        if (jSONObject != null) {
                            Object[] objArr = new Object[1];
                            values("\uefc1㲯䤊闟ꉱ컍᮶⠎璎腫", ImageFormat.getBitsPerPixel(0) + 54122, objArr);
                            String string = jSONObject.getString(((String) objArr[0]).intern());
                            if (!TextUtils.isEmpty(string)) {
                                list.add(new AnalysesEntry(string));
                            }
                        }
                    } catch (JSONException e) {
                        readResolve.getSharedInstance(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.APIGuard.setHorizontalScrollbarTrackDrawable, e.toString());
                    }
                    readResolve.getSharedInstance(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.APIGuard.setHorizontalScrollbarTrackDrawable, e.toString());
                }
                return;
            }
        }
        readResolve.valueOf(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.APIGuard.onContextItemSelected);
    }

    private static void APIGuard(JSONArray jSONArray, List<ScoredEntry> list) {
        if ((jSONArray != null ? 'E' : 'H') != 'H') {
            int i = valueOf + 103;
            getRequestHeaders = i % 128;
            if ((i % 2 == 0 ? '2' : Typography.dollar) == '$') {
                if (jSONArray.length() > 0) {
                    int i2 = 0;
                    while (i2 < jSONArray.length()) {
                        int i3 = valueOf + 9;
                        getRequestHeaders = i3 % 128;
                        if ((i3 % 2 == 0 ? '\'' : '\b') == '\b') {
                            try {
                                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                                if (!(jSONObject == null)) {
                                    Object[] objArr = new Object[1];
                                    values("\uefc1㲯䤊闟ꉱ컍᮶⠎璎腫", 54121 - Color.argb(0, 0, 0, 0), objArr);
                                    String string = jSONObject.getString(((String) objArr[0]).intern());
                                    if (!TextUtils.isEmpty(string)) {
                                        list.add(new ScoredEntry(string));
                                    }
                                }
                            } catch (JSONException e) {
                                readResolve.getSharedInstance(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.APIGuard.setVerticalScrollbarPosition, e.toString());
                            }
                            i2++;
                            valueOf = (getRequestHeaders + 77) % 128;
                        } else {
                            jSONArray.getJSONObject(i2);
                            throw new ArithmeticException();
                            break;
                        }
                        readResolve.getSharedInstance(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.APIGuard.setVerticalScrollbarPosition, e.toString());
                        i2++;
                        valueOf = (getRequestHeaders + 77) % 128;
                    }
                    return;
                }
            } else {
                jSONArray.length();
                throw new ArithmeticException();
            }
        }
        readResolve.valueOf(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.APIGuard.setVerticalScrollbarTrackDrawable);
    }

    public List<AnalysesEntry> AGState() {
        int i = (valueOf + 27) % 128;
        getRequestHeaders = i;
        List<AnalysesEntry> list = this.endpointAnalyzed;
        int i2 = i + 105;
        valueOf = i2 % 128;
        if (!(i2 % 2 != 0)) {
            return list;
        }
        throw new NullPointerException();
    }

    public List<ScoredEntry> valueOf() {
        int i = valueOf + 89;
        getRequestHeaders = i % 128;
        if ((i % 2 == 0 ? ':' : '9') == '9') {
            return this.endpointScored;
        }
        throw new ArithmeticException();
    }

    public String getSharedInstance() {
        int i = (getRequestHeaders + 3) % 128;
        valueOf = i;
        String str = this.fraudQueryHeaderKeyName;
        getRequestHeaders = (i + 67) % 128;
        return str;
    }

    public boolean values() {
        valueOf = (getRequestHeaders + 13) % 128;
        boolean z = this.foregroundEvent;
        getRequestHeaders = (valueOf + 47) % 128;
        return z;
    }

    public boolean APIGuard() {
        getRequestHeaders = (valueOf + 75) % 128;
        boolean z = this.backgroundEvent;
        getRequestHeaders = (valueOf + 125) % 128;
        return z;
    }

    public boolean getRequestHeaders() {
        int i = valueOf + 101;
        getRequestHeaders = i % 128;
        if ((i % 2 == 0 ? ';' : '\t') != '\t') {
            throw null;
        }
        boolean z = this.focusChangedEvent;
        valueOf = (getRequestHeaders + 51) % 128;
        return z;
    }

    public boolean analyzeResponse() {
        getRequestHeaders = (valueOf + 113) % 128;
        boolean z = this.textChangedEvent;
        int i = getRequestHeaders + 103;
        valueOf = i % 128;
        if (i % 2 == 0) {
            return z;
        }
        throw new NullPointerException();
    }

    public boolean parseResponseHeaders() {
        getRequestHeaders = (valueOf + 31) % 128;
        boolean z = this.touchEvent;
        getRequestHeaders = (valueOf + 91) % 128;
        return z;
    }

    public boolean generateHeaders() {
        getRequestHeaders = (valueOf + 39) % 128;
        boolean z = this.keyEvent;
        int i = valueOf + 119;
        getRequestHeaders = i % 128;
        if (i % 2 != 0) {
            return z;
        }
        throw null;
    }

    private static void valueOf(int i, int i2, char c, Object[] objArr) {
        String str;
        synchronized (setBackgroundTintList.AGState) {
            char[] cArr = new char[i2];
            setBackgroundTintList.getSharedInstance = 0;
            while (setBackgroundTintList.getSharedInstance < i2) {
                cArr[setBackgroundTintList.getSharedInstance] = (char) ((APIGuard[setBackgroundTintList.getSharedInstance + i] ^ (setBackgroundTintList.getSharedInstance * getSharedInstance)) ^ c);
                setBackgroundTintList.getSharedInstance++;
            }
            str = new String(cArr);
        }
        objArr[0] = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r7 = r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void values(java.lang.String r7, int r8, java.lang.Object[] r9) {
        /*
            if (r7 == 0) goto L6
            char[] r7 = r7.toCharArray()
        L6:
            char[] r7 = (char[]) r7
            java.lang.Object r0 = com.apiguard3.internal.setForeground.valueOf
            monitor-enter(r0)
            com.apiguard3.internal.setForeground.APIGuard = r8     // Catch: java.lang.Throwable -> L3d
            int r8 = r7.length     // Catch: java.lang.Throwable -> L3d
            char[] r8 = new char[r8]     // Catch: java.lang.Throwable -> L3d
            r1 = 0
            com.apiguard3.internal.setForeground.values = r1     // Catch: java.lang.Throwable -> L3d
        L13:
            int r2 = com.apiguard3.internal.setForeground.values     // Catch: java.lang.Throwable -> L3d
            int r3 = r7.length     // Catch: java.lang.Throwable -> L3d
            if (r2 >= r3) goto L34
            int r2 = com.apiguard3.internal.setForeground.values     // Catch: java.lang.Throwable -> L3d
            int r3 = com.apiguard3.internal.setForeground.values     // Catch: java.lang.Throwable -> L3d
            char r3 = r7[r3]     // Catch: java.lang.Throwable -> L3d
            int r4 = com.apiguard3.internal.setForeground.values     // Catch: java.lang.Throwable -> L3d
            int r5 = com.apiguard3.internal.setForeground.APIGuard     // Catch: java.lang.Throwable -> L3d
            int r4 = r4 * r5
            r3 = r3 ^ r4
            long r3 = (long) r3     // Catch: java.lang.Throwable -> L3d
            long r5 = com.apiguard3.cvm.safe.config.SConfig.values     // Catch: java.lang.Throwable -> L3d
            long r3 = r3 ^ r5
            int r4 = (int) r3     // Catch: java.lang.Throwable -> L3d
            char r3 = (char) r4     // Catch: java.lang.Throwable -> L3d
            r8[r2] = r3     // Catch: java.lang.Throwable -> L3d
            int r2 = com.apiguard3.internal.setForeground.values     // Catch: java.lang.Throwable -> L3d
            int r2 = r2 + 1
            com.apiguard3.internal.setForeground.values = r2     // Catch: java.lang.Throwable -> L3d
            goto L13
        L34:
            java.lang.String r7 = new java.lang.String     // Catch: java.lang.Throwable -> L3d
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L3d
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3d
            r9[r1] = r7
            return
        L3d:
            r7 = move-exception
            monitor-exit(r0)
            goto L41
        L40:
            throw r7
        L41:
            goto L40
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.cvm.safe.config.SConfig.values(java.lang.String, int, java.lang.Object[]):void");
    }
}
