package com.apiguard3.internal;

import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.fastjson.parser.JSONLexer;
import com.apiguard3.APIGuard;
import com.apiguard3.internal.ConfigInstance;
import com.apiguard3.internal.KernelPayloadInstance;
import id.dana.cashier.view.InputCardNumberView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public final class dpi {
    private static int APIGuard$Callback = 1;
    private static char analyzeResponse;
    private static char getRequestHeaders;
    private static final dpi getSharedInstance;
    private static char initialize;
    private static char log;
    private static int updateKernel;
    private ConfigInstance.ConfigSerializationProxy.values AGState;
    private KernelPayloadInstance.KernelPayloadSerializationProxy APIGuard;
    private sc generateHeaders;
    private volatile boolean parseResponseHeaders;
    private sdf valueOf;
    private Map<String, ConfigInstance.ConfigSerializationProxy> values = new HashMap();

    static void valueOf() {
        analyzeResponse = (char) 16337;
        log = (char) 5167;
        getRequestHeaders = (char) 18610;
        initialize = (char) 9314;
    }

    static /* synthetic */ KernelPayloadInstance.KernelPayloadSerializationProxy AGState(dpi dpiVar) {
        int i = updateKernel;
        APIGuard$Callback = (i + 13) % 128;
        KernelPayloadInstance.KernelPayloadSerializationProxy kernelPayloadSerializationProxy = dpiVar.APIGuard;
        int i2 = i + 81;
        APIGuard$Callback = i2 % 128;
        if (i2 % 2 != 0) {
            return kernelPayloadSerializationProxy;
        }
        throw new NullPointerException();
    }

    static /* synthetic */ void AGState(dpi dpiVar, int i) {
        updateKernel = (APIGuard$Callback + 57) % 128;
        dpiVar.APIGuard(i);
        int i2 = updateKernel + 77;
        APIGuard$Callback = i2 % 128;
        if ((i2 % 2 == 0 ? '\n' : InputCardNumberView.DIVIDER) != '\n') {
            return;
        }
        throw new ArithmeticException();
    }

    static /* synthetic */ sc APIGuard(dpi dpiVar) {
        int i = APIGuard$Callback;
        updateKernel = (i + 43) % 128;
        sc scVar = dpiVar.generateHeaders;
        int i2 = i + 99;
        updateKernel = i2 % 128;
        if (i2 % 2 != 0) {
            throw new ArithmeticException();
        }
        return scVar;
    }

    static /* synthetic */ sc APIGuard(dpi dpiVar, sc scVar) {
        int i = APIGuard$Callback + 115;
        updateKernel = i % 128;
        char c = i % 2 != 0 ? '`' : ')';
        dpiVar.generateHeaders = scVar;
        if (c == ')') {
            return scVar;
        }
        throw new NullPointerException();
    }

    static /* synthetic */ KernelPayloadInstance.KernelPayloadSerializationProxy getSharedInstance(dpi dpiVar, KernelPayloadInstance.KernelPayloadSerializationProxy kernelPayloadSerializationProxy) {
        int i = (APIGuard$Callback + 23) % 128;
        updateKernel = i;
        dpiVar.APIGuard = kernelPayloadSerializationProxy;
        int i2 = i + 57;
        APIGuard$Callback = i2 % 128;
        if (i2 % 2 != 0) {
            return kernelPayloadSerializationProxy;
        }
        throw null;
    }

    static /* synthetic */ sdf getSharedInstance(dpi dpiVar) {
        int i = updateKernel;
        APIGuard$Callback = (i + 43) % 128;
        sdf sdfVar = dpiVar.valueOf;
        int i2 = i + 49;
        APIGuard$Callback = i2 % 128;
        if ((i2 % 2 == 0 ? (char) 18 : '1') != 18) {
            return sdfVar;
        }
        throw new ArithmeticException();
    }

    static /* synthetic */ sdf getSharedInstance(dpi dpiVar, sdf sdfVar) {
        int i = updateKernel;
        APIGuard$Callback = (i + 53) % 128;
        dpiVar.valueOf = sdfVar;
        int i2 = i + 23;
        APIGuard$Callback = i2 % 128;
        if (i2 % 2 != 0) {
            return sdfVar;
        }
        throw new NullPointerException();
    }

    static /* synthetic */ void values(dpi dpiVar, Map map) {
        updateKernel = (APIGuard$Callback + 123) % 128;
        dpiVar.AGState(map);
        updateKernel = (APIGuard$Callback + 121) % 128;
    }

    static {
        valueOf();
        TextUtils.indexOf("", "", 0, 0);
        ViewConfiguration.getKeyRepeatTimeout();
        Process.getElapsedCpuTime();
        getSharedInstance = new dpi();
        int i = updateKernel + 105;
        APIGuard$Callback = i % 128;
        if ((i % 2 == 0 ? '.' : ']') != '.') {
            return;
        }
        throw new NullPointerException();
    }

    public static dpi AGState() {
        int i = APIGuard$Callback + 97;
        updateKernel = i % 128;
        if ((i % 2 != 0 ? (char) 5 : '\f') != 5) {
            return getSharedInstance;
        }
        throw new NullPointerException();
    }

    private dpi() {
        TextUtils.indexOf("", "", 0, 0);
        this.AGState = ConfigInstance.ConfigSerializationProxy.values.values;
        this.parseResponseHeaders = false;
        readResolve.values(APIGuard());
    }

    public final void values(final APIGuard.Callback callback) {
        synchronized (this) {
            updateKernel = (APIGuard$Callback + 87) % 128;
            if (this.parseResponseHeaders) {
                return;
            }
            this.parseResponseHeaders = true;
            KernelPayloadInstance.getSharedInstance().post(new Runnable() { // from class: com.apiguard3.internal.dpi.3
                private static char AGState = 4;
                private static char[] getSharedInstance = {13806, 13817, 13795, 13819, 13808, 13800, 13816, 13807, 13814, 13823, 13815, 13809, 13811, 13801, 13820, 13810};
                private static int parseResponseHeaders = 1;
                private static int valueOf;

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        dpi.AGState(dpi.this, dpi.values());
                        HashMap hashMap = new HashMap();
                        dpi.APIGuard(dpi.this, new sc(callback));
                        Object[] objArr = new Object[1];
                        values(7 - MotionEvent.axisFromString(""), (byte) (TextUtils.lastIndexOf("", '0', 0, 0) + 82), "\u0002\u0000㙇㙇\u0007\u0002\u0003\t", objArr);
                        hashMap.put(((String) objArr[0]).intern(), dpi.APIGuard(dpi.this));
                        dpi.getSharedInstance(dpi.this, new KernelPayloadInstance.KernelPayloadSerializationProxy());
                        dpi.AGState(dpi.this).getSharedInstance();
                        Object[] objArr2 = new Object[1];
                        values(8 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (byte) (View.combineMeasuredStates(0, 0) + 98), "\u0001\b\t\n\u000b\n\u0001\u0004㙅", objArr2);
                        hashMap.put(((String) objArr2[0]).intern(), dpi.AGState(dpi.this));
                        dpi.getSharedInstance(dpi.this, new sdf());
                        Object[] objArr3 = new Object[1];
                        values(9 - ((byte) KeyEvent.getModifierMetaStateMask()), (byte) (ExpandableListView.getPackedPositionChild(0L) + 71), "\u000f\r\t\n\u000e\u0001\f\u0001\n\u000b", objArr3);
                        hashMap.put(((String) objArr3[0]).intern(), dpi.getSharedInstance(dpi.this));
                        dpi.values(dpi.this, hashMap);
                    } catch (Throwable th) {
                        try {
                            if (((Boolean) ((Class) AGState.values(6573 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), View.MeasureSpec.getSize(0) + 35, (char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 1941))).getMethod("getSharedInstance", null).invoke(null, null)).booleanValue()) {
                                throw th;
                            }
                            int i = parseResponseHeaders + 39;
                            valueOf = i % 128;
                            if ((i % 2 != 0 ? (char) 25 : '0') == '0') {
                                return;
                            }
                            throw new NullPointerException();
                        } catch (Throwable th2) {
                            Throwable cause = th2.getCause();
                            if (cause == null) {
                                throw th2;
                            }
                            throw cause;
                        }
                    }
                }

                /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
                
                    r14 = r14;
                 */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                private static void values(int r12, byte r13, java.lang.String r14, java.lang.Object[] r15) {
                    /*
                        Method dump skipped, instructions count: 257
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.dpi.AnonymousClass3.values(int, byte, java.lang.String, java.lang.Object[]):void");
                }
            });
            updateKernel = (APIGuard$Callback + 49) % 128;
        }
    }

    private void AGState(Map<String, ConfigInstance.ConfigSerializationProxy> map) {
        synchronized (this) {
            int i = APIGuard$Callback + 27;
            updateKernel = i % 128;
            if (i % 2 != 0) {
                this.values.putAll(map);
                throw new ArithmeticException();
            }
            this.values.putAll(map);
            int i2 = APIGuard$Callback + 39;
            updateKernel = i2 % 128;
            if ((i2 % 2 == 0 ? '[' : (char) 1) != '[') {
                throw new ArithmeticException();
            }
        }
    }

    public final ConfigInstance.ConfigSerializationProxy values(String str) {
        ConfigInstance.ConfigSerializationProxy configSerializationProxy;
        synchronized (this) {
            int i = APIGuard$Callback + 67;
            updateKernel = i % 128;
            if (!(i % 2 == 0)) {
                throw null;
            } else if (str != null) {
                configSerializationProxy = this.values.get(str);
                APIGuard$Callback = (updateKernel + 93) % 128;
            } else {
                Object[] objArr = new Object[1];
                valueOf("\uf13e珕U㍥︽櫃\uec47ᓍौ罦③僜㣺ⴏ缽︨櫀\ue1ac龞늋通겢菱嫈໑㐹겯⑁\uec47ᓍ귖珦巺錬䒻틪졠\uf8ad③僜㣺ⴏ", 42 - (Process.myTid() >> 22), objArr);
                throw new IllegalArgumentException(((String) objArr[0]).intern());
            }
        }
        return configSerializationProxy;
    }

    public final ConfigInstance.ConfigSerializationProxy.values APIGuard() {
        ConfigInstance.ConfigSerializationProxy.values valuesVar;
        synchronized (this) {
            int i = updateKernel;
            int i2 = i + 95;
            APIGuard$Callback = i2 % 128;
            if (i2 % 2 == 0) {
                throw null;
            }
            valuesVar = this.AGState;
            APIGuard$Callback = (i + 15) % 128;
        }
        return valuesVar;
    }

    public final void AGState(ConfigInstance.ConfigSerializationProxy.values valuesVar) {
        synchronized (this) {
            updateKernel = (APIGuard$Callback + 115) % 128;
            if (valuesVar == null) {
                return;
            }
            this.AGState = valuesVar;
            readResolve.values(valuesVar);
            AGState(valuesVar.AGState());
            Iterator<ConfigInstance.ConfigSerializationProxy> it = this.values.values().iterator();
            int i = updateKernel + 55;
            APIGuard$Callback = i % 128;
            int i2 = i % 2;
            while (it.hasNext()) {
                APIGuard$Callback = (updateKernel + 61) % 128;
                it.next().AGState(valuesVar);
            }
        }
    }

    private static void AGState(int i) {
        updateKernel = (APIGuard$Callback + 123) % 128;
        Object[] objArr = new Object[1];
        valueOf("肇蒵⾫㸻芗\uf058粄ꆾ⾫㸻မ\ue9a1", (ViewConfiguration.getScrollDefaultDelay() >> 16) + 11, objArr);
        try {
            ((Class) AGState.values(2309 - TextUtils.lastIndexOf("", '0'), KeyEvent.normalizeMetaState(0) + 23, (char) (14343 - ExpandableListView.getPackedPositionGroup(0L)))).getMethod("valueOf", String.class, Integer.TYPE).invoke(null, ((String) objArr[0]).intern(), Integer.valueOf(i));
            int i2 = APIGuard$Callback + 99;
            updateKernel = i2 % 128;
            if ((i2 % 2 != 0 ? 'I' : JSONLexer.EOI) != 'I') {
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
    }

    static int values() {
        int i = APIGuard$Callback + 65;
        updateKernel = i % 128;
        if (!(i % 2 != 0)) {
            Object[] objArr = new Object[1];
            valueOf("肇蒵⾫㸻芗\uf058粄ꆾ⾫㸻မ\ue9a1", (ViewConfiguration.getPressedStateDuration() >> 16) + 11, objArr);
            try {
                return ((Integer) ((Class) AGState.values(2310 - View.getDefaultSize(0, 0), 22 - TextUtils.lastIndexOf("", '0'), (char) ((Process.myPid() >> 22) + 14343))).getMethod("getSharedInstance", String.class, Integer.TYPE).invoke(null, ((String) objArr[0]).intern(), Integer.valueOf(ConfigInstance.ConfigSerializationProxy.values.values.AGState()))).intValue();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
        Object[] objArr2 = new Object[1];
        valueOf("肇蒵⾫㸻芗\uf058粄ꆾ⾫㸻မ\ue9a1", 106 % (ViewConfiguration.getPressedStateDuration() + 12), objArr2);
        try {
            return ((Integer) ((Class) AGState.values(2310 - View.getDefaultSize(0, 0), 23 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (char) (ExpandableListView.getPackedPositionGroup(0L) + 14343))).getMethod("getSharedInstance", String.class, Integer.TYPE).invoke(null, ((String) objArr2[0]).intern(), Integer.valueOf(ConfigInstance.ConfigSerializationProxy.values.values.AGState()))).intValue();
        } catch (Throwable th2) {
            Throwable cause2 = th2.getCause();
            if (cause2 != null) {
                throw cause2;
            }
            throw th2;
        }
    }

    public final void values(com.apiguard3.AGState aGState) {
        synchronized (this) {
            updateKernel = (APIGuard$Callback + 17) % 128;
            if (aGState.equals(com.apiguard3.AGState.APIGuardStateReady)) {
                int i = updateKernel + 37;
                APIGuard$Callback = i % 128;
                if (!(i % 2 != 0)) {
                    throw new NullPointerException();
                }
                KernelPayloadInstance.KernelPayloadSerializationProxy kernelPayloadSerializationProxy = this.APIGuard;
                if (kernelPayloadSerializationProxy != null) {
                    kernelPayloadSerializationProxy.APIGuard();
                }
                sdf sdfVar = this.valueOf;
                if (sdfVar != null) {
                    APIGuard$Callback = (updateKernel + 53) % 128;
                    sdfVar.AGState();
                }
            }
        }
    }

    public final void getSharedInstance() {
        synchronized (this) {
            int i = (APIGuard$Callback + 57) % 128;
            updateKernel = i;
            sdf sdfVar = this.valueOf;
            if (!(sdfVar == null)) {
                int i2 = i + 125;
                APIGuard$Callback = i2 % 128;
                if ((i2 % 2 == 0 ? ':' : (char) 1) != 1) {
                    sdfVar.APIGuard();
                    throw new NullPointerException();
                }
                sdfVar.APIGuard();
            }
            APIGuard$Callback = (updateKernel + 101) % 128;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void values(ConfigInstance configInstance) {
        synchronized (this) {
            APIGuard$Callback = (updateKernel + 83) % 128;
            Iterator<ConfigInstance.ConfigSerializationProxy> it = this.values.values().iterator();
            int i = APIGuard$Callback + 95;
            updateKernel = i % 128;
            int i2 = i % 2;
            while ((!it.hasNext()) == false) {
                it.next().AGState(configInstance);
            }
        }
    }

    private void APIGuard(int i) {
        APIGuard$Callback = (updateKernel + 69) % 128;
        AGState(ConfigInstance.ConfigSerializationProxy.values.AGState(i));
        int i2 = updateKernel + 67;
        APIGuard$Callback = i2 % 128;
        if (!(i2 % 2 == 0)) {
            return;
        }
        throw null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r13 = r13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void valueOf(java.lang.String r13, int r14, java.lang.Object[] r15) {
        /*
            if (r13 == 0) goto L6
            char[] r13 = r13.toCharArray()
        L6:
            char[] r13 = (char[]) r13
            java.lang.Object r0 = com.apiguard3.internal.setBackgroundDrawable.getSharedInstance
            monitor-enter(r0)
            int r1 = r13.length     // Catch: java.lang.Throwable -> L7a
            char[] r1 = new char[r1]     // Catch: java.lang.Throwable -> L7a
            r2 = 0
            com.apiguard3.internal.setBackgroundDrawable.valueOf = r2     // Catch: java.lang.Throwable -> L7a
            r3 = 2
            char[] r4 = new char[r3]     // Catch: java.lang.Throwable -> L7a
        L14:
            int r5 = com.apiguard3.internal.setBackgroundDrawable.valueOf     // Catch: java.lang.Throwable -> L7a
            int r6 = r13.length     // Catch: java.lang.Throwable -> L7a
            if (r5 >= r6) goto L71
            int r5 = com.apiguard3.internal.setBackgroundDrawable.valueOf     // Catch: java.lang.Throwable -> L7a
            char r5 = r13[r5]     // Catch: java.lang.Throwable -> L7a
            r4[r2] = r5     // Catch: java.lang.Throwable -> L7a
            int r5 = com.apiguard3.internal.setBackgroundDrawable.valueOf     // Catch: java.lang.Throwable -> L7a
            r6 = 1
            int r5 = r5 + r6
            char r5 = r13[r5]     // Catch: java.lang.Throwable -> L7a
            r4[r6] = r5     // Catch: java.lang.Throwable -> L7a
            r5 = 58224(0xe370, float:8.1589E-41)
            r7 = 0
        L2b:
            r8 = 16
            if (r7 >= r8) goto L5e
            char r8 = r4[r6]     // Catch: java.lang.Throwable -> L7a
            char r9 = r4[r2]     // Catch: java.lang.Throwable -> L7a
            int r10 = r9 + r5
            int r11 = r9 << 4
            char r12 = com.apiguard3.internal.dpi.analyzeResponse     // Catch: java.lang.Throwable -> L7a
            int r11 = r11 + r12
            r10 = r10 ^ r11
            int r11 = r9 >>> 5
            char r12 = com.apiguard3.internal.dpi.log     // Catch: java.lang.Throwable -> L7a
            int r11 = r11 + r12
            r10 = r10 ^ r11
            int r8 = r8 - r10
            char r8 = (char) r8     // Catch: java.lang.Throwable -> L7a
            r4[r6] = r8     // Catch: java.lang.Throwable -> L7a
            char r10 = com.apiguard3.internal.dpi.getRequestHeaders     // Catch: java.lang.Throwable -> L7a
            int r11 = r8 >>> 5
            char r12 = com.apiguard3.internal.dpi.initialize     // Catch: java.lang.Throwable -> L7a
            int r11 = r11 + r12
            int r12 = r8 + r5
            int r8 = r8 << 4
            int r8 = r8 + r10
            r8 = r8 ^ r12
            r8 = r8 ^ r11
            int r9 = r9 - r8
            char r8 = (char) r9     // Catch: java.lang.Throwable -> L7a
            r4[r2] = r8     // Catch: java.lang.Throwable -> L7a
            r8 = 40503(0x9e37, float:5.6757E-41)
            int r5 = r5 - r8
            int r7 = r7 + 1
            goto L2b
        L5e:
            int r5 = com.apiguard3.internal.setBackgroundDrawable.valueOf     // Catch: java.lang.Throwable -> L7a
            char r7 = r4[r2]     // Catch: java.lang.Throwable -> L7a
            r1[r5] = r7     // Catch: java.lang.Throwable -> L7a
            int r5 = com.apiguard3.internal.setBackgroundDrawable.valueOf     // Catch: java.lang.Throwable -> L7a
            int r5 = r5 + r6
            char r6 = r4[r6]     // Catch: java.lang.Throwable -> L7a
            r1[r5] = r6     // Catch: java.lang.Throwable -> L7a
            int r5 = com.apiguard3.internal.setBackgroundDrawable.valueOf     // Catch: java.lang.Throwable -> L7a
            int r5 = r5 + r3
            com.apiguard3.internal.setBackgroundDrawable.valueOf = r5     // Catch: java.lang.Throwable -> L7a
            goto L14
        L71:
            java.lang.String r13 = new java.lang.String     // Catch: java.lang.Throwable -> L7a
            r13.<init>(r1, r2, r14)     // Catch: java.lang.Throwable -> L7a
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7a
            r15[r2] = r13
            return
        L7a:
            r13 = move-exception
            monitor-exit(r0)
            goto L7e
        L7d:
            throw r13
        L7e:
            goto L7d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.dpi.valueOf(java.lang.String, int, java.lang.Object[]):void");
    }
}
