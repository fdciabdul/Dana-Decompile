package com.apiguard3.internal;

import android.graphics.PointF;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.view.View;
import android.view.ViewConfiguration;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
import javax.security.auth.Destroyable;

/* loaded from: classes7.dex */
public final class setContentView implements Destroyable {
    private static int AGState = 1834990327;
    private static int APIGuard = 1470907427;
    private static short[] analyzeResponse = null;
    private static int getRequestHeaders = 0;
    private static int parseResponseHeaders = 1;
    private unregisterForContextMenu getSharedInstance;
    private byte[] values;
    private static byte[] generateHeaders = {-35, -44, -28, 43, -100, Ascii.RS, -104, -32, Ascii.US, -119, 42, -106, -22, -37, 32, -117, -32, -40, -31, -44, -28, -20, -46, 6, 93, 74, 104, 91, 92, 95, 108, 95, -94, 5, 115, 97, 90, 81, 100, 105, -97, 10, 111, 92, 89, 102, 113, 0, 0};
    private static int valueOf = 70;

    /* JADX INFO: Access modifiers changed from: package-private */
    public setContentView(byte[] bArr, unregisterForContextMenu unregisterforcontextmenu) {
        if (unregisterforcontextmenu == null) {
            Object[] objArr = new Object[1];
            getSharedInstance((short) (35 - View.MeasureSpec.getMode(0)), (byte) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) - 1834990328, (-1470907358) - (ViewConfiguration.getJumpTapTimeout() >> 16), View.MeasureSpec.getMode(0) - 45, objArr);
            throw new IllegalArgumentException(((String) objArr[0]).intern());
        }
        this.values = unregisterforcontextmenu.values(bArr);
        this.getSharedInstance = unregisterforcontextmenu;
    }

    @Override // javax.security.auth.Destroyable
    public final void destroy() {
        synchronized (this) {
            int i = (parseResponseHeaders + 9) % 128;
            getRequestHeaders = i;
            byte[] bArr = this.values;
            if ((bArr != null ? 'X' : 'b') == 'X') {
                int i2 = i + 97;
                parseResponseHeaders = i2 % 128;
                int i3 = i2 % 2;
                Arrays.fill(bArr, (byte) 0);
                this.values = null;
            }
            if (this.getSharedInstance != null) {
                this.getSharedInstance = null;
            }
        }
    }

    @Override // javax.security.auth.Destroyable
    public final boolean isDestroyed() {
        synchronized (this) {
            int i = (parseResponseHeaders + 19) % 128;
            getRequestHeaders = i;
            if (this.getSharedInstance == null) {
                int i2 = i + 43;
                parseResponseHeaders = i2 % 128;
                return !(i2 % 2 == 0);
            }
            return false;
        }
    }

    private void valueOf() {
        parseResponseHeaders = (getRequestHeaders + 7) % 128;
        if (isDestroyed()) {
            Object[] objArr = new Object[1];
            getSharedInstance((short) ((-94) - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))), (byte) (ViewConfiguration.getTapTimeout() >> 16), (ViewConfiguration.getTouchSlop() >> 8) - 1834990303, (-1470907348) - (ViewConfiguration.getJumpTapTimeout() >> 16), (ViewConfiguration.getLongPressTimeout() >> 16) - 46, objArr);
            throw new IllegalStateException(((String) objArr[0]).intern());
        }
        int i = parseResponseHeaders + 103;
        getRequestHeaders = i % 128;
        if (i % 2 != 0) {
            throw new NullPointerException();
        }
    }

    public final String values() {
        String sharedInstance;
        synchronized (this) {
            parseResponseHeaders = (getRequestHeaders + 55) % 128;
            valueOf();
            sharedInstance = UrlMatcher.getSharedInstance(this.getSharedInstance.APIGuard(this.values));
            int i = parseResponseHeaders + 65;
            getRequestHeaders = i % 128;
            if (!(i % 2 == 0)) {
                throw new ArithmeticException();
            }
        }
        return sharedInstance;
    }

    public static setContentView AGState(String str) {
        int i = getRequestHeaders + 49;
        parseResponseHeaders = i % 128;
        if ((i % 2 == 0 ? '8' : '*') == '*') {
            return onOptionsItemSelected.getSharedInstance(str);
        }
        onOptionsItemSelected.getSharedInstance(str);
        throw new NullPointerException();
    }

    public static setContentView getSharedInstance(char... cArr) {
        parseResponseHeaders = (getRequestHeaders + 87) % 128;
        setContentView valueOf2 = onOptionsItemSelected.valueOf(cArr);
        int i = getRequestHeaders + 103;
        parseResponseHeaders = i % 128;
        if (!(i % 2 == 0)) {
            return valueOf2;
        }
        throw new ArithmeticException();
    }

    public static setContentView values(long j) {
        int i = getRequestHeaders + 107;
        parseResponseHeaders = i % 128;
        boolean z = i % 2 != 0;
        String valueOf2 = String.valueOf(j);
        if (z) {
            return onOptionsItemSelected.getSharedInstance(valueOf2);
        }
        onOptionsItemSelected.getSharedInstance(valueOf2);
        throw null;
    }

    private static void getSharedInstance(short s, byte b, int i, int i2, int i3, Object[] objArr) {
        String obj;
        synchronized (setBackground.AGState) {
            StringBuilder sb = new StringBuilder();
            int i4 = valueOf;
            int i5 = i3 + i4;
            int i6 = i5 == -1 ? 1 : 0;
            if (i6 != 0) {
                byte[] bArr = generateHeaders;
                if (bArr != null) {
                    i5 = (byte) (bArr[AGState + i] + i4);
                } else {
                    i5 = (short) (analyzeResponse[AGState + i] + i4);
                }
            }
            if (i5 > 0) {
                setBackground.values = ((i + i5) - 2) + AGState + i6;
                setBackground.APIGuard = (char) (i2 + APIGuard);
                sb.append(setBackground.APIGuard);
                setBackground.getSharedInstance = setBackground.APIGuard;
                setBackground.valueOf = 1;
                while (setBackground.valueOf < i5) {
                    byte[] bArr2 = generateHeaders;
                    if (bArr2 != null) {
                        int i7 = setBackground.values;
                        setBackground.values = i7 - 1;
                        setBackground.APIGuard = (char) (setBackground.getSharedInstance + (((byte) (bArr2[i7] + s)) ^ b));
                    } else {
                        short[] sArr = analyzeResponse;
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
