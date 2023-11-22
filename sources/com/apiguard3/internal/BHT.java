package com.apiguard3.internal;

import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.apiguard3.internal.ConfigInstance;
import com.apiguard3.internal.writeReplace;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes3.dex */
public final class BHT extends HandlerThread {
    private static ReentrantReadWriteLock AGState = null;
    private static ReentrantReadWriteLock.WriteLock APIGuard = null;
    private static int analyzeResponse = 0;
    private static int getRequestHeaders = 1;
    private static BHT getSharedInstance;
    private static ReentrantReadWriteLock.ReadLock valueOf;
    private static int[] values;

    static void values() {
        values = new int[]{-1019783951, -599470224, 1529337132, -1305499048, -1901572814, 12376562, -1677623073, -921516739, -305596299, -156385439, 177103145, 159497762, -2052563228, 814201798, -1379160976, -709909338, 68108269, 2055116409};
    }

    static {
        values();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        AGState = reentrantReadWriteLock;
        valueOf = reentrantReadWriteLock.readLock();
        APIGuard = AGState.writeLock();
        int i = analyzeResponse + 3;
        getRequestHeaders = i % 128;
        if ((i % 2 == 0 ? '%' : 'K') != '%') {
            return;
        }
        throw new NullPointerException();
    }

    public static void valueOf() {
        analyzeResponse = (getRequestHeaders + 45) % 128;
        try {
            APIGuard.lock();
            if (getSharedInstance == null) {
                Object[] objArr = new Object[1];
                AGState(new int[]{-485355910, -1287539617, 467230345, -1325268801, -615637476, -444672536, 168614413, -1593550389, 786962975, -665294961, 1896384282, -523602898, -1378587685, -1753975981}, 24 - TextUtils.indexOf((CharSequence) "", '0'), objArr);
                BHT bht = new BHT(((String) objArr[0]).intern());
                getSharedInstance = bht;
                bht.start();
                getRequestHeaders = (analyzeResponse + 63) % 128;
            }
        } finally {
            APIGuard.unlock();
        }
    }

    private BHT(String str) {
        super(str);
    }

    private static BHT AGState() {
        int i = analyzeResponse + 33;
        getRequestHeaders = i % 128;
        try {
            if (!(i % 2 == 0)) {
                valueOf.lock();
                return getSharedInstance;
            }
            valueOf.lock();
            throw new NullPointerException();
        } finally {
            valueOf.unlock();
        }
    }

    public static Handler APIGuard() {
        getSharedInstance getsharedinstance = new getSharedInstance(AGState().getLooper(), "");
        int i = analyzeResponse + 51;
        getRequestHeaders = i % 128;
        if ((i % 2 == 0 ? '1' : (char) 17) == 17) {
            return getsharedinstance;
        }
        throw null;
    }

    private static Handler getSharedInstance(String str) {
        getSharedInstance getsharedinstance = new getSharedInstance(AGState().getLooper(), str);
        int i = analyzeResponse + 123;
        getRequestHeaders = i % 128;
        if (i % 2 != 0) {
            return getsharedinstance;
        }
        throw new NullPointerException();
    }

    public static boolean APIGuard(String str, Runnable runnable) {
        analyzeResponse = (getRequestHeaders + 111) % 128;
        boolean z = false;
        if (valueOf.tryLock()) {
            try {
                if ((getSharedInstance != null ? '\n' : '\r') != '\n') {
                    ConfigInstance.ConfigSerializationProxy.values valuesVar = ConfigInstance.ConfigSerializationProxy.values.getSharedInstance;
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    Object[] objArr = new Object[1];
                    AGState(new int[]{-1229583674, 1259634361, 1833939171, -2033882398, -2133083798, 479795449, 1847250289, -611170967, -560615184, 274477929, -1250529321, 481802358}, (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 22, objArr);
                    sb.append(((String) objArr[0]).intern());
                    readResolve.values(valuesVar, sb.toString());
                } else {
                    int i = analyzeResponse + 101;
                    getRequestHeaders = i % 128;
                    if ((i % 2 != 0 ? 'c' : (char) 21) != 'c') {
                        getSharedInstance(str).post(runnable);
                        throw null;
                    }
                    z = getSharedInstance(str).post(runnable);
                }
            } finally {
                valueOf.unlock();
            }
        } else {
            ConfigInstance.ConfigSerializationProxy.values valuesVar2 = ConfigInstance.ConfigSerializationProxy.values.getSharedInstance;
            StringBuilder sb2 = new StringBuilder();
            Object[] objArr2 = new Object[1];
            AGState(new int[]{-1348721714, 349252748, 1681184106, 1335576833, 1104755574, -2109679437, 1778952208, 461211655, -928462363, 1683156458, -425878364, 1415290922, 713103095, 816020632}, 24 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), objArr2);
            sb2.append(((String) objArr2[0]).intern());
            sb2.append(str);
            readResolve.values(valuesVar2, sb2.toString());
            analyzeResponse = (getRequestHeaders + 21) % 128;
        }
        return z;
    }

    public static void getSharedInstance() {
        analyzeResponse = (getRequestHeaders + 55) % 128;
        try {
            APIGuard.lock();
            if (!(getSharedInstance == null)) {
                getRequestHeaders = (analyzeResponse + 5) % 128;
                if ((Build.VERSION.SDK_INT >= 18 ? '\r' : '\\') != '\\') {
                    getSharedInstance.quitSafely();
                } else {
                    getSharedInstance.quit();
                }
                try {
                    getSharedInstance.join();
                    getSharedInstance = null;
                } catch (InterruptedException unused) {
                }
            }
            APIGuard.unlock();
            getRequestHeaders = (analyzeResponse + 21) % 128;
        } catch (Throwable th) {
            APIGuard.unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class getSharedInstance extends Handler {
        private static int APIGuard = 1;
        private static int[] valueOf = {-1270969221, 1272846810, 1314675943, -957537619, -692200284, 319706891, -23971536, 783797486, 822634034, -886256481, -876116560, 57769126, 1214853099, -1570013916, -732748797, -661423562, 1606540077, -1058291010};
        private static int values;
        private final String AGState;

        getSharedInstance(Looper looper, String str) {
            super(looper);
            this.AGState = str;
        }

        @Override // android.os.Handler
        public final void dispatchMessage(Message message) {
            int i = values + 123;
            APIGuard = i % 128;
            try {
                if (!(i % 2 == 0)) {
                    super.dispatchMessage(message);
                } else {
                    super.dispatchMessage(message);
                    throw null;
                }
            } catch (Exception e) {
                ConfigInstance.ConfigSerializationProxy.values valuesVar = ConfigInstance.ConfigSerializationProxy.values.values;
                writeReplace.APIGuard aPIGuard = writeReplace.APIGuard.setOnScrollChangeListener;
                StringBuilder sb = new StringBuilder();
                Object[] objArr = new Object[1];
                valueOf(new int[]{1487203584, -2054091089, 1622883940, 1404179701}, TextUtils.indexOf((CharSequence) "", '0', 0) + 7, objArr);
                sb.append(((String) objArr[0]).intern());
                sb.append(this.AGState);
                Object[] objArr2 = new Object[1];
                valueOf(new int[]{-1496229780, -1848046875}, TextUtils.indexOf("", "", 0, 0) + 1, objArr2);
                sb.append(((String) objArr2[0]).intern());
                try {
                    sb.append((String) ((Class) AGState.values(6574 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), TextUtils.indexOf("", "", 0) + 35, (char) (Color.red(0) + 1941))).getMethod("values", Throwable.class).invoke(null, e));
                    readResolve.getSharedInstance(valuesVar, aPIGuard, sb.toString());
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            }
        }

        private static void valueOf(int[] iArr, int i, Object[] objArr) {
            String str;
            synchronized (setBackgroundTintBlendMode.getSharedInstance) {
                char[] cArr = new char[4];
                char[] cArr2 = new char[iArr.length << 1];
                int[] iArr2 = (int[]) valueOf.clone();
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

    private static void AGState(int[] iArr, int i, Object[] objArr) {
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
