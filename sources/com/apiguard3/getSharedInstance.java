package com.apiguard3;

import android.graphics.Color;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.apiguard3.domain.Config;
import com.apiguard3.internal.ConfigInstance;
import com.apiguard3.internal.UriFilter$UrlMatcherSpec;
import com.apiguard3.internal.readResolve;
import com.apiguard3.internal.setBackgroundTintBlendMode;
import com.apiguard3.internal.writeReplace;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class getSharedInstance implements Callable {
    private static int getRequestHeaders = 0;
    private static int initialize = 1;
    private static int[] values = {-466089324, 75241581, -169685224, 889266342, -1519095433, 1048911978, 354342127, -162021775, 777929719, -1149967891, -1837194244, 136079169, -2031361648, 329693697, 494273991, -868481399, 1454847277, -1873109760};
    private Object AGState$4ad913bb;
    private final Object APIGuard$1a4bb38;
    private String getSharedInstance;
    private final Object valueOf$384309d8;

    public getSharedInstance(Object obj, Object obj2, Object obj3) {
        this.AGState$4ad913bb = obj;
        this.APIGuard$1a4bb38 = obj2;
        this.valueOf$384309d8 = obj3;
        try {
            ((Class) com.apiguard3.internal.AGState.values(2441 - ((Process.getThreadPriority(0) + 20) >> 6), 31 - TextUtils.indexOf((CharSequence) "", '0'), (char) (46225 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)))).getMethod("valueOf", Callable.class).invoke(obj2, this);
            try {
                this.getSharedInstance = ((Config) ((Class) com.apiguard3.internal.AGState.values((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 2441, 32 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (char) (View.resolveSize(0, 0) + 46225))).getMethod("AGState", null).invoke(obj2, null)).onInitializationFailure();
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

    public final boolean valueOf(Map<String, String> map, String str, byte[] bArr) {
        initialize = (getRequestHeaders + 73) % 128;
        try {
            boolean booleanValue = ((Boolean) ((Class) com.apiguard3.internal.AGState.values((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 2441, KeyEvent.keyCodeFromString("") + 32, (char) (TextUtils.lastIndexOf("", '0', 0, 0) + 46226))).getMethod("AGState", String.class).invoke(this.APIGuard$1a4bb38, str)).booleanValue();
            if ((booleanValue ? '\b' : '1') == '\b') {
                values(map, str, bArr);
                valueOf(map);
                getSharedInstance(map, bArr);
                getRequestHeaders = (initialize + 43) % 128;
            } else {
                readResolve.valueOf(ConfigInstance.ConfigSerializationProxy.values.valueOf, writeReplace.AGState.APIGuard);
            }
            int i = getRequestHeaders + 109;
            initialize = i % 128;
            if (i % 2 != 0) {
                return booleanValue;
            }
            throw new ArithmeticException();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    private void values(Map<String, String> map, String str, byte[] bArr) {
        int i = getRequestHeaders + 35;
        initialize = i % 128;
        if ((i % 2 == 0 ? ',' : (char) 6) == 6) {
            Object obj = this.AGState$4ad913bb;
            if (obj != null) {
                try {
                    ((Class) com.apiguard3.internal.AGState.values((ViewConfiguration.getTapTimeout() >> 16) + 2575, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 38, (char) (59159 - View.resolveSizeAndState(0, 0, 0)))).getMethod("getSharedInstance", Map.class, String.class, byte[].class).invoke(obj, map, str, bArr);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
            int i2 = getRequestHeaders + 107;
            initialize = i2 % 128;
            if (i2 % 2 != 0) {
                return;
            }
            throw new NullPointerException();
        }
        throw new NullPointerException();
    }

    private void valueOf(Map<String, String> map) {
        getRequestHeaders = (initialize + 93) % 128;
        try {
            try {
                String str = (String) ((Class) com.apiguard3.internal.AGState.values((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 1892, (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 24, (char) View.resolveSize(0, 0))).getMethod("valueOf", null).invoke(((Class) com.apiguard3.internal.AGState.values(1892 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), TextUtils.getTrimmedLength("") + 25, (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("getSharedInstance", null).invoke(null, null), null);
                if ((str != null) && !str.isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.getSharedInstance);
                    Object[] objArr = new Object[1];
                    values(new int[]{1475274833, 1251158003}, (ViewConfiguration.getEdgeSlop() >> 16) + 1, objArr);
                    sb.append(((String) objArr[0]).intern());
                    map.put(sb.toString(), str);
                }
                int i = getRequestHeaders + 107;
                initialize = i % 128;
                if (i % 2 != 0) {
                    return;
                }
                throw new ArithmeticException();
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

    private void getSharedInstance(Map<String, String> map, byte[] bArr) {
        getRequestHeaders = (initialize + 81) % 128;
        try {
            int i = UriFilter$UrlMatcherSpec.valueOf.valueOf;
            Object[] objArr = new Object[1];
            values(new int[]{960403082, 1354036038, -707040420, -1148910175, -120786506, 1587440882, -882959027, 693297585, 255185517, 1109901704}, 17 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), objArr);
            String intern = ((String) objArr[0]).intern();
            ConfigInstance.ConfigSerializationProxy.values valuesVar = ConfigInstance.ConfigSerializationProxy.values.getSharedInstance;
            Object[] objArr2 = new Object[1];
            values(new int[]{960403082, 1354036038, -707040420, -1148910175, -120786506, 1587440882, -900494594, -76375006, -1568057524, -1680270333, -727405814, 967760062, 1221293161, -447469467}, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 26, objArr2);
            readResolve.valueOf(i, intern, ((String) objArr2[0]).intern());
            try {
                try {
                    ((Class) com.apiguard3.internal.AGState.values(4715 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 38, (char) (25417 - (ViewConfiguration.getPressedStateDuration() >> 16)))).getMethod("values", Map.class, byte[].class).invoke(this.valueOf$384309d8, map, bArr);
                    int i2 = UriFilter$UrlMatcherSpec.valueOf.AGState;
                    Object[] objArr3 = new Object[1];
                    values(new int[]{960403082, 1354036038, -707040420, -1148910175, -120786506, 1587440882, -882959027, 693297585, 255185517, 1109901704}, 18 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), objArr3);
                    String intern2 = ((String) objArr3[0]).intern();
                    ConfigInstance.ConfigSerializationProxy.values valuesVar2 = ConfigInstance.ConfigSerializationProxy.values.getSharedInstance;
                    Object[] objArr4 = new Object[1];
                    values(new int[]{960403082, 1354036038, -707040420, -1148910175, -120786506, 1587440882, -900494594, -76375006, -1568057524, -1680270333, -727405814, 967760062, -2135380262, -667625658, 1147433846, 241910925, 1330400069, 2004971517, 1837802193, 1235254445}, TextUtils.indexOf("", "", 0) + 37, objArr4);
                    readResolve.valueOf(i2, intern2, ((String) objArr4[0]).intern());
                    int i3 = initialize + 117;
                    getRequestHeaders = i3 % 128;
                    if (!(i3 % 2 != 0)) {
                        return;
                    }
                    throw null;
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            } catch (Throwable unused) {
                readResolve.valueOf(ConfigInstance.ConfigSerializationProxy.values.getSharedInstance, writeReplace.getSharedInstance.BuildConfig);
            }
        } catch (Throwable unused2) {
        }
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws Exception {
        initialize = (getRequestHeaders + 99) % 128;
        try {
            this.getSharedInstance = ((Config) ((Class) com.apiguard3.internal.AGState.values((ViewConfiguration.getWindowTouchSlop() >> 8) + 2441, 32 - Color.alpha(0), (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 46226))).getMethod("AGState", null).invoke(this.APIGuard$1a4bb38, null)).onInitializationFailure();
            initialize = (getRequestHeaders + 25) % 128;
            return null;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    private static void values(int[] iArr, int i, Object[] objArr) {
        String str;
        synchronized (setBackgroundTintBlendMode.getSharedInstance) {
            char[] cArr = new char[4];
            char[] cArr2 = new char[iArr.length << 1];
            int[] iArr2 = (int[]) values.clone();
            setBackgroundTintBlendMode.valueOf = 0;
            while (setBackgroundTintBlendMode.valueOf < iArr.length) {
                cArr[0] = (char) (iArr[setBackgroundTintBlendMode.valueOf] >> 16);
                cArr[1] = (char) iArr[setBackgroundTintBlendMode.valueOf];
                cArr[2] = (char) (iArr[setBackgroundTintBlendMode.valueOf + 1] >> 16);
                cArr[3] = (char) iArr[setBackgroundTintBlendMode.valueOf + 1];
                setBackgroundTintBlendMode.values = (cArr[0] << 16) + cArr[1];
                setBackgroundTintBlendMode.AGState = (cArr[2] << 16) + cArr[3];
                setBackgroundTintBlendMode.values(iArr2);
                for (int i2 = 0; i2 < 16; i2++) {
                    int i3 = setBackgroundTintBlendMode.values ^ iArr2[i2];
                    setBackgroundTintBlendMode.values = i3;
                    setBackgroundTintBlendMode.AGState = setBackgroundTintBlendMode.valueOf(i3) ^ setBackgroundTintBlendMode.AGState;
                    int i4 = setBackgroundTintBlendMode.values;
                    setBackgroundTintBlendMode.values = setBackgroundTintBlendMode.AGState;
                    setBackgroundTintBlendMode.AGState = i4;
                }
                int i5 = setBackgroundTintBlendMode.values;
                setBackgroundTintBlendMode.values = setBackgroundTintBlendMode.AGState;
                setBackgroundTintBlendMode.AGState = i5;
                setBackgroundTintBlendMode.AGState = i5 ^ iArr2[16];
                setBackgroundTintBlendMode.values ^= iArr2[17];
                int i6 = setBackgroundTintBlendMode.values;
                int i7 = setBackgroundTintBlendMode.AGState;
                cArr[0] = (char) (setBackgroundTintBlendMode.values >>> 16);
                cArr[1] = (char) setBackgroundTintBlendMode.values;
                cArr[2] = (char) (setBackgroundTintBlendMode.AGState >>> 16);
                cArr[3] = (char) setBackgroundTintBlendMode.AGState;
                setBackgroundTintBlendMode.values(iArr2);
                cArr2[setBackgroundTintBlendMode.valueOf << 1] = cArr[0];
                cArr2[(setBackgroundTintBlendMode.valueOf << 1) + 1] = cArr[1];
                cArr2[(setBackgroundTintBlendMode.valueOf << 1) + 2] = cArr[2];
                cArr2[(setBackgroundTintBlendMode.valueOf << 1) + 3] = cArr[3];
                setBackgroundTintBlendMode.valueOf += 2;
            }
            str = new String(cArr2, 0, i);
        }
        objArr[0] = str;
    }
}
