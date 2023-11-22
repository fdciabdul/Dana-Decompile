package com.apiguard3.internal;

import android.os.Process;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewConfiguration;
import com.apiguard3.internal.ConfigInstance;
import com.apiguard3.internal.writeReplace;
import java.util.concurrent.Callable;

/* loaded from: classes7.dex */
public class MT<TaskResult> implements Callable<TaskResult> {
    private static int AGState = 1549455237;
    private static int generateHeaders = 1;
    private static int getRequestHeaders = 0;
    private static short[] initialize = null;
    private static int valueOf = -1754197506;
    private Callable<TaskResult> getSharedInstance;
    private String values;
    private static byte[] parseResponseHeaders = {63, -21, -57, 78, 0};
    private static int APIGuard = 107;

    public MT(Callable<TaskResult> callable, String str) {
        this.getSharedInstance = callable;
        this.values = str;
    }

    public final String values() {
        int i = (generateHeaders + 35) % 128;
        getRequestHeaders = i;
        String str = this.values;
        int i2 = i + 73;
        generateHeaders = i2 % 128;
        if ((i2 % 2 == 0 ? ':' : '6') == '6') {
            return str;
        }
        throw new NullPointerException();
    }

    @Override // java.util.concurrent.Callable
    public TaskResult call() throws Exception {
        getRequestHeaders = (generateHeaders + 123) % 128;
        if ((dpi.AGState().APIGuard().compareTo(ConfigInstance.ConfigSerializationProxy.values.valueOf) >= 0 ? (char) 2 : (char) 18) == 2) {
            long currentTimeMillis = System.currentTimeMillis();
            TaskResult call = this.getSharedInstance.call();
            long currentTimeMillis2 = System.currentTimeMillis();
            ConfigInstance.ConfigSerializationProxy.values valuesVar = ConfigInstance.ConfigSerializationProxy.values.valueOf;
            writeReplace.AGState aGState = writeReplace.AGState.getState;
            Object[] objArr = new Object[1];
            getSharedInstance((short) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1), (byte) View.MeasureSpec.getSize(0), (-1549455237) - (ViewConfiguration.getScrollDefaultDelay() >> 16), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 1754197543, (-102) - ((Process.getThreadPriority(0) + 20) >> 6), objArr);
            readResolve.getSharedInstance(valuesVar, aGState, String.format(((String) objArr[0]).intern(), this.values, Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
            generateHeaders = (getRequestHeaders + 1) % 128;
            return call;
        }
        return this.getSharedInstance.call();
    }

    private static void getSharedInstance(short s, byte b, int i, int i2, int i3, Object[] objArr) {
        String obj;
        synchronized (setBackground.AGState) {
            StringBuilder sb = new StringBuilder();
            int i4 = APIGuard;
            int i5 = i3 + i4;
            int i6 = i5 == -1 ? 1 : 0;
            if (i6 != 0) {
                byte[] bArr = parseResponseHeaders;
                if (bArr != null) {
                    i5 = (byte) (bArr[AGState + i] + i4);
                } else {
                    i5 = (short) (initialize[AGState + i] + i4);
                }
            }
            if (i5 > 0) {
                setBackground.values = ((i + i5) - 2) + AGState + i6;
                setBackground.APIGuard = (char) (i2 + valueOf);
                sb.append(setBackground.APIGuard);
                setBackground.getSharedInstance = setBackground.APIGuard;
                setBackground.valueOf = 1;
                while (setBackground.valueOf < i5) {
                    byte[] bArr2 = parseResponseHeaders;
                    if (bArr2 != null) {
                        int i7 = setBackground.values;
                        setBackground.values = i7 - 1;
                        setBackground.APIGuard = (char) (setBackground.getSharedInstance + (((byte) (bArr2[i7] + s)) ^ b));
                    } else {
                        short[] sArr = initialize;
                        int i8 = setBackground.values;
                        setBackground.values = i8 - 1;
                        setBackground.APIGuard = (char) (setBackground.getSharedInstance + (((short) (sArr[i8] + s)) ^ b));
                    }
                    sb.append(setBackground.APIGuard);
                    setBackground.getSharedInstance = setBackground.APIGuard;
                    setBackground.valueOf++;
                }
            }
            obj = sb.toString();
        }
        objArr[0] = obj;
    }
}
