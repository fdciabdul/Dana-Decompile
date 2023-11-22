package com.apiguard3.io;

import android.graphics.Color;
import android.media.AudioTrack;
import android.os.Process;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.apiguard3.internal.AGState;
import com.apiguard3.internal.setBackgroundTintList;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes7.dex */
public final class KernelPayloadInstance implements Serializable {
    private static long AGState = -1424497235143257865L;
    private static char[] APIGuard = {'U', 36996, 8587, 45765, 17303, 54454, 26040, 63151, 34781, 6339, 43510, 15100, 52205, 23783, 60909, 32280, 3860, 41012, 12603, 49703, 21285, 58402, 30038, 1624, 38738, 10366, 47458, 19044, 56171, 27541, 64674, 36251, 7823, 44975, 16567, 53733, 25301, 62429, 34009, 5589, 42749, 14318, 51426};
    private static int analyzeResponse = 1;
    private static final long serialVersionUID = 3128887582760800825L;
    private static int valueOf;
    public transient Map<String, String> getSharedInstance;
    public transient Map<String, String> values;

    private KernelPayloadInstance() {
    }

    public KernelPayloadInstance(Map<String, String> map, Map<String, String> map2) {
        this.getSharedInstance = map;
        this.values = map2;
    }

    protected final Object writeReplace() throws ObjectStreamException {
        KernelPayloadSerializationProxy kernelPayloadSerializationProxy = new KernelPayloadSerializationProxy(this);
        int i = valueOf + 51;
        analyzeResponse = i % 128;
        if (i % 2 != 0) {
            return kernelPayloadSerializationProxy;
        }
        throw new NullPointerException();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Object[] objArr = new Object[1];
        valueOf((char) (TextUtils.lastIndexOf("", '0', 0) + 1), 44 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), KeyEvent.getMaxKeyCode() >> 16, objArr);
        throw new InvalidObjectException(((String) objArr[0]).intern());
    }

    /* loaded from: classes7.dex */
    static final class KernelPayloadSerializationProxy implements Serializable {
        private static int APIGuard = 0;
        private static int getSharedInstance = 1;
        private static final long serialVersionUID = 4032605224111506387L;
        private static long valueOf = -2437617249014166315L;
        private final TreeMap<String, String> maxPayload;
        private final TreeMap<String, String> minPayload;
        private final byte[] shaHash;

        KernelPayloadSerializationProxy(KernelPayloadInstance kernelPayloadInstance) {
            if (kernelPayloadInstance.getSharedInstance != null) {
                this.minPayload = new TreeMap<>(kernelPayloadInstance.getSharedInstance);
            } else {
                this.minPayload = new TreeMap<>();
            }
            if (kernelPayloadInstance.getSharedInstance != null) {
                this.maxPayload = new TreeMap<>(kernelPayloadInstance.values);
            } else {
                this.maxPayload = new TreeMap<>();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.minPayload.toString());
            sb.append(this.maxPayload.toString());
            String obj = sb.toString();
            Object[] objArr = new Object[1];
            APIGuard("䬷䭢獑㿐⛶뼚擩芻硛", (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 1, objArr);
            byte[] bytes = obj.getBytes(Charset.forName(((String) objArr[0]).intern()));
            Object[] objArr2 = new Object[1];
            APIGuard("\u1a8a\u1af9\u0adf䙣鶽ѳ汬証⦲誄儘痂簒맦鶇Ⅰ茑\uec67깞\uec2c힢ოﭲ\udfcfᨃ䟆ނ譲⥎詨偹癩緭뻈", KeyEvent.normalizeMetaState(0) + 1, objArr2);
            String intern = ((String) objArr2[0]).intern();
            Object[] objArr3 = new Object[1];
            APIGuard("䬷䭢獑㿐⛶뼚擩芻硛", (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1, objArr3);
            try {
                this.shaHash = (byte[]) ((Class) AGState.values((Process.myTid() >> 22) + 6573, 36 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (char) ((ViewConfiguration.getPressedStateDuration() >> 16) + 1941))).getMethod("APIGuard", byte[].class, byte[].class).invoke(null, bytes, intern.getBytes(Charset.forName(((String) objArr3[0]).intern())));
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }

        protected final Object readResolve() throws ObjectStreamException {
            StringBuilder sb = new StringBuilder();
            sb.append(this.minPayload.toString());
            sb.append(this.maxPayload.toString());
            String obj = sb.toString();
            Object[] objArr = new Object[1];
            APIGuard("䬷䭢獑㿐⛶뼚擩芻硛", 1 - (ViewConfiguration.getScrollBarSize() >> 8), objArr);
            byte[] bytes = obj.getBytes(Charset.forName(((String) objArr[0]).intern()));
            Object[] objArr2 = new Object[1];
            APIGuard("\u1a8a\u1af9\u0adf䙣鶽ѳ汬証⦲誄儘痂簒맦鶇Ⅰ茑\uec67깞\uec2c힢ოﭲ\udfcfᨃ䟆ނ譲⥎詨偹癩緭뻈", -TextUtils.indexOf((CharSequence) "", '0', 0), objArr2);
            String intern = ((String) objArr2[0]).intern();
            Object[] objArr3 = new Object[1];
            APIGuard("䬷䭢獑㿐⛶뼚擩芻硛", 1 - (ViewConfiguration.getPressedStateDuration() >> 16), objArr3);
            try {
                if (!Arrays.equals((byte[]) ((Class) AGState.values(6573 - ExpandableListView.getPackedPositionType(0L), 35 - TextUtils.getTrimmedLength(""), (char) (1941 - Color.blue(0)))).getMethod("APIGuard", byte[].class, byte[].class).invoke(null, bytes, intern.getBytes(Charset.forName(((String) objArr3[0]).intern()))), this.shaHash)) {
                    getSharedInstance = (APIGuard + 109) % 128;
                    return null;
                }
                KernelPayloadInstance kernelPayloadInstance = new KernelPayloadInstance(this.minPayload, this.maxPayload);
                int i = getSharedInstance + 31;
                APIGuard = i % 128;
                if (i % 2 == 0) {
                    return kernelPayloadInstance;
                }
                throw new NullPointerException();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        
            r8 = r8;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void APIGuard(java.lang.String r8, int r9, java.lang.Object[] r10) {
            /*
                if (r8 == 0) goto L6
                char[] r8 = r8.toCharArray()
            L6:
                char[] r8 = (char[]) r8
                java.lang.Object r0 = com.apiguard3.internal.setForegroundTintBlendMode.getSharedInstance
                monitor-enter(r0)
                long r1 = com.apiguard3.io.KernelPayloadInstance.KernelPayloadSerializationProxy.valueOf     // Catch: java.lang.Throwable -> L4a
                char[] r8 = com.apiguard3.internal.setForegroundTintBlendMode.APIGuard(r1, r8, r9)     // Catch: java.lang.Throwable -> L4a
                r9 = 4
                com.apiguard3.internal.setForegroundTintBlendMode.valueOf = r9     // Catch: java.lang.Throwable -> L4a
            L14:
                int r1 = com.apiguard3.internal.setForegroundTintBlendMode.valueOf     // Catch: java.lang.Throwable -> L4a
                int r2 = r8.length     // Catch: java.lang.Throwable -> L4a
                if (r1 >= r2) goto L3e
                int r1 = com.apiguard3.internal.setForegroundTintBlendMode.valueOf     // Catch: java.lang.Throwable -> L4a
                int r1 = r1 - r9
                com.apiguard3.internal.setForegroundTintBlendMode.APIGuard = r1     // Catch: java.lang.Throwable -> L4a
                int r1 = com.apiguard3.internal.setForegroundTintBlendMode.valueOf     // Catch: java.lang.Throwable -> L4a
                int r2 = com.apiguard3.internal.setForegroundTintBlendMode.valueOf     // Catch: java.lang.Throwable -> L4a
                char r2 = r8[r2]     // Catch: java.lang.Throwable -> L4a
                int r3 = com.apiguard3.internal.setForegroundTintBlendMode.valueOf     // Catch: java.lang.Throwable -> L4a
                int r3 = r3 % r9
                char r3 = r8[r3]     // Catch: java.lang.Throwable -> L4a
                r2 = r2 ^ r3
                long r2 = (long) r2     // Catch: java.lang.Throwable -> L4a
                int r4 = com.apiguard3.internal.setForegroundTintBlendMode.APIGuard     // Catch: java.lang.Throwable -> L4a
                long r4 = (long) r4     // Catch: java.lang.Throwable -> L4a
                long r6 = com.apiguard3.io.KernelPayloadInstance.KernelPayloadSerializationProxy.valueOf     // Catch: java.lang.Throwable -> L4a
                long r4 = r4 * r6
                long r2 = r2 ^ r4
                int r3 = (int) r2     // Catch: java.lang.Throwable -> L4a
                char r2 = (char) r3     // Catch: java.lang.Throwable -> L4a
                r8[r1] = r2     // Catch: java.lang.Throwable -> L4a
                int r1 = com.apiguard3.internal.setForegroundTintBlendMode.valueOf     // Catch: java.lang.Throwable -> L4a
                int r1 = r1 + 1
                com.apiguard3.internal.setForegroundTintBlendMode.valueOf = r1     // Catch: java.lang.Throwable -> L4a
                goto L14
            L3e:
                java.lang.String r1 = new java.lang.String     // Catch: java.lang.Throwable -> L4a
                int r2 = r8.length     // Catch: java.lang.Throwable -> L4a
                int r2 = r2 - r9
                r1.<init>(r8, r9, r2)     // Catch: java.lang.Throwable -> L4a
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L4a
                r8 = 0
                r10[r8] = r1
                return
            L4a:
                r8 = move-exception
                monitor-exit(r0)
                goto L4e
            L4d:
                throw r8
            L4e:
                goto L4d
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.io.KernelPayloadInstance.KernelPayloadSerializationProxy.APIGuard(java.lang.String, int, java.lang.Object[]):void");
        }
    }

    private static void valueOf(char c, int i, int i2, Object[] objArr) {
        String str;
        synchronized (setBackgroundTintList.AGState) {
            char[] cArr = new char[i];
            setBackgroundTintList.getSharedInstance = 0;
            while (setBackgroundTintList.getSharedInstance < i) {
                cArr[setBackgroundTintList.getSharedInstance] = (char) ((APIGuard[setBackgroundTintList.getSharedInstance + i2] ^ (setBackgroundTintList.getSharedInstance * AGState)) ^ c);
                setBackgroundTintList.getSharedInstance++;
            }
            str = new String(cArr);
        }
        objArr[0] = str;
    }
}
