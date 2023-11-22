package com.apiguard3.internal;

import android.graphics.Color;
import android.os.Handler;
import android.os.Process;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.wireless.security.SecExceptionCode;
import com.apiguard3.internal.ConfigInstance;
import com.apiguard3.internal.writeReplace;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class sdf implements ConfigInstance.ConfigSerializationProxy {
    private static int analyzeResponse = 0;
    private static int checkCertificates = 1;
    private static int getSharedInstance;
    private static long initialize;
    private static final Map<ConfigInstance.ConfigSerializationProxy.values, Integer> values;
    Handler AGState;
    volatile RB<SLE> APIGuard;
    private File generateHeaders;
    private volatile boolean getRequestHeaders;
    private ConfigInstance.ConfigSerializationProxy.values parseResponseHeaders;
    final Runnable valueOf;

    static void valueOf() {
        initialize = 7019129139273989171L;
    }

    static /* synthetic */ int values() {
        int i = analyzeResponse + 115;
        checkCertificates = i % 128;
        if ((i % 2 == 0 ? '_' : (char) 11) == 11) {
            return getSharedInstance;
        }
        throw new ArithmeticException();
    }

    static /* synthetic */ boolean values(sdf sdfVar) {
        int i = analyzeResponse + 35;
        checkCertificates = i % 128;
        char c = i % 2 == 0 ? ',' : (char) 29;
        boolean z = sdfVar.getRequestHeaders;
        if (c == ',') {
            throw null;
        }
        analyzeResponse = (checkCertificates + 111) % 128;
        return z;
    }

    static {
        valueOf();
        View.MeasureSpec.makeMeasureSpec(0, 0);
        getSharedInstance = 5000;
        values = Collections.unmodifiableMap(new HashMap<ConfigInstance.ConfigSerializationProxy.values, Integer>() { // from class: com.apiguard3.internal.sdf.2
            {
                put(ConfigInstance.ConfigSerializationProxy.values.getSharedInstance, 20);
                put(ConfigInstance.ConfigSerializationProxy.values.values, 20);
                put(ConfigInstance.ConfigSerializationProxy.values.AGState, 30);
                put(ConfigInstance.ConfigSerializationProxy.values.valueOf, 40);
                put(ConfigInstance.ConfigSerializationProxy.values.APIGuard, 40);
                put(ConfigInstance.ConfigSerializationProxy.values.getRequestHeaders, 50);
            }
        });
        analyzeResponse = (checkCertificates + 109) % 128;
    }

    private sdf(String str) {
        this.parseResponseHeaders = ConfigInstance.ConfigSerializationProxy.values.values;
        this.getRequestHeaders = false;
        Runnable runnable = new Runnable() { // from class: com.apiguard3.internal.sdf.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (sdf.this) {
                    sdf.this.getSharedInstance();
                    if (!sdf.values(sdf.this)) {
                        sdf.this.AGState.postDelayed(sdf.this.valueOf, sdf.values());
                    }
                }
            }
        };
        this.valueOf = runnable;
        this.APIGuard = new RB<>(20);
        Handler sharedInstance = KernelPayloadInstance.getSharedInstance();
        this.AGState = sharedInstance;
        sharedInstance.postDelayed(runnable, getSharedInstance);
        try {
            this.generateHeaders = (File) ((Class) AGState.values(2203 - Color.red(0), (ViewConfiguration.getJumpTapTimeout() >> 16) + 24, (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)))).getMethod("APIGuard", String.class).invoke(null, str);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public sdf() {
        /*
            r3 = this;
            int r0 = android.view.ViewConfiguration.getScrollBarSize()
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            int r0 = r0 >> 8
            int r0 = r0 + r1
            java.lang.String r1 = "㬚퇸㭻ⶬ鰟鵸搟榒쮺㴲甕砮\udaf1ఝ䖃䬠\ue910"
            APIGuard(r1, r0, r2)
            r0 = 0
            r0 = r2[r0]
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = r0.intern()
            r3.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.sdf.<init>():void");
    }

    @Override // com.apiguard3.internal.ConfigInstance.ConfigSerializationProxy
    public final void AGState(ConfigInstance.ConfigSerializationProxy.values valuesVar) {
        checkCertificates = (analyzeResponse + 91) % 128;
        if (valuesVar != null) {
            if ((!valuesVar.equals(this.parseResponseHeaders) ? '(' : (char) 21) != 21) {
                int i = checkCertificates + 113;
                analyzeResponse = i % 128;
                if ((i % 2 != 0 ? '1' : (char) 30) != '1') {
                    AGState(values.get(valuesVar).intValue());
                    this.parseResponseHeaders = valuesVar;
                    return;
                }
                AGState(values.get(valuesVar).intValue());
                this.parseResponseHeaders = valuesVar;
                throw new ArithmeticException();
            }
        }
    }

    @Override // com.apiguard3.internal.ConfigInstance.ConfigSerializationProxy
    public final void AGState(final ConfigInstance configInstance) {
        int i = checkCertificates + 53;
        analyzeResponse = i % 128;
        if ((i % 2 != 0 ? '7' : '2') == '7') {
            throw new ArithmeticException();
        }
        if ((!this.getRequestHeaders ? (char) 31 : '(') == 31) {
            int i2 = analyzeResponse + 7;
            checkCertificates = i2 % 128;
            if (i2 % 2 == 0) {
                ConfigInstance.ConfigSerializationProxy.values valuesVar = configInstance.values;
                throw null;
            } else if (configInstance.values.compareTo(this.parseResponseHeaders) <= 0) {
                this.AGState.post(new Runnable() { // from class: com.apiguard3.internal.sdf.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        String str = configInstance.APIGuard;
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        synchronized (this) {
                            sdf.this.APIGuard.APIGuard(new SLE(str, configInstance.AGState));
                            if (sdf.this.APIGuard.values() >= 3) {
                                sdf.this.getSharedInstance();
                            }
                        }
                    }
                });
                return;
            }
        }
        analyzeResponse = (checkCertificates + 99) % 128;
    }

    public final List<Pair<String, Number>> APIGuard(boolean z) {
        RB rb;
        synchronized (this) {
            ArrayList arrayList = new ArrayList();
            if (!this.APIGuard.valueOf()) {
                analyzeResponse = (checkCertificates + 81) % 128;
                arrayList.addAll(APIGuard(this.APIGuard));
                this.APIGuard.AGState();
            }
            if (!this.generateHeaders.exists()) {
                checkCertificates = (analyzeResponse + 13) % 128;
                return arrayList;
            }
            try {
                try {
                    rb = (RB) ((Class) AGState.values(2203 - (Process.myPid() >> 22), TextUtils.getOffsetBefore("", 0) + 24, (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)))).getMethod("getSharedInstance", File.class).invoke(null, this.generateHeaders);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                readResolve.getSharedInstance(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.APIGuard.am, th2.toString());
            }
            if (rb != null) {
                if ((rb.valueOf() ? 'L' : '!') != 'L') {
                    arrayList.addAll(APIGuard(rb));
                    try {
                        Boolean bool = (Boolean) ((Class) AGState.values(2203 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), 24 - TextUtils.indexOf("", ""), (char) TextUtils.getOffsetBefore("", 0))).getMethod("AGState", File.class).invoke(null, this.generateHeaders);
                        int i = checkCertificates + 39;
                        analyzeResponse = i % 128;
                        int i2 = i % 2;
                        return arrayList;
                    } catch (Throwable th3) {
                        Throwable cause2 = th3.getCause();
                        if (cause2 != null) {
                            throw cause2;
                        }
                        throw th3;
                    }
                }
            }
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void APIGuard() {
        synchronized (this) {
            int i = analyzeResponse + 71;
            checkCertificates = i % 128;
            if (!(i % 2 != 0)) {
                getSharedInstance();
                throw null;
            } else {
                getSharedInstance();
                checkCertificates = (analyzeResponse + 69) % 128;
            }
        }
    }

    public final void AGState() {
        synchronized (this) {
            analyzeResponse = (checkCertificates + 93) % 128;
            if (this.getRequestHeaders) {
                return;
            }
            if (!this.APIGuard.valueOf()) {
                int i = checkCertificates + 59;
                analyzeResponse = i % 128;
                if (i % 2 != 0) {
                    getSharedInstance();
                    throw new ArithmeticException();
                }
                getSharedInstance();
            }
            this.AGState.removeCallbacks(this.valueOf);
            this.getRequestHeaders = true;
            checkCertificates = (analyzeResponse + 93) % 128;
        }
    }

    private void AGState(int i) {
        synchronized (this) {
            int i2 = checkCertificates + 71;
            analyzeResponse = i2 % 128;
            if (!(i2 % 2 == 0)) {
                this.APIGuard.AGState(i);
                throw new NullPointerException();
            } else {
                this.APIGuard.AGState(i);
                analyzeResponse = (checkCertificates + 11) % 128;
            }
        }
    }

    private static List<Pair<String, Number>> APIGuard(RB<SLE> rb) {
        ArrayList arrayList = new ArrayList();
        checkCertificates = (analyzeResponse + 49) % 128;
        for (SLE sle : rb.getSharedInstance()) {
            arrayList.add(new Pair(sle.f7413id, sle.timeStamp));
        }
        analyzeResponse = (checkCertificates + 17) % 128;
        return arrayList;
    }

    final void getSharedInstance() {
        RB rb;
        int i = analyzeResponse;
        checkCertificates = (i + 95) % 128;
        if (this.generateHeaders != null) {
            int i2 = i + 67;
            checkCertificates = i2 % 128;
            if (i2 % 2 == 0) {
                this.APIGuard.valueOf();
                throw null;
            }
            if ((!this.APIGuard.valueOf() ? (char) 28 : '_') == 28) {
                int intValue = values.get(this.parseResponseHeaders).intValue();
                try {
                    try {
                        rb = (RB) ((Class) AGState.values((ViewConfiguration.getWindowTouchSlop() >> 8) + SecExceptionCode.SEC_ERROR_LBSRISK_NO_MEMORY, (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 24, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("getSharedInstance", File.class).invoke(null, this.generateHeaders);
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } catch (Exception unused) {
                    rb = null;
                }
                if (rb == null) {
                    rb = new RB(intValue);
                } else {
                    rb.AGState(intValue);
                    analyzeResponse = (checkCertificates + 37) % 128;
                }
                Iterator<SLE> it = this.APIGuard.getSharedInstance().iterator();
                while ((!it.hasNext()) != true) {
                    rb.APIGuard(it.next());
                }
                this.APIGuard.AGState();
                try {
                    Boolean bool = (Boolean) ((Class) AGState.values(2202 - ((byte) KeyEvent.getModifierMetaStateMask()), 24 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (char) Color.blue(0))).getMethod("getSharedInstance", File.class, Object.class).invoke(null, this.generateHeaders, rb);
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            }
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
            long r1 = com.apiguard3.internal.sdf.initialize     // Catch: java.lang.Throwable -> L4a
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
            long r6 = com.apiguard3.internal.sdf.initialize     // Catch: java.lang.Throwable -> L4a
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
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.sdf.APIGuard(java.lang.String, int, java.lang.Object[]):void");
    }
}
