package com.apiguard3.internal;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import kotlin.text.Typography;

/* loaded from: classes3.dex */
public final class UrlMatcherConfig {

    /* loaded from: classes3.dex */
    public static final class APIGuard {
        private static int APIGuard = 77;
        private static boolean valueOf;
        private static int values;

        static /* synthetic */ boolean AGState() {
            int i = (values + 49) % 128;
            APIGuard = i;
            boolean z = valueOf;
            int i2 = i + 9;
            values = i2 % 128;
            if ((i2 % 2 != 0 ? '7' : Typography.greater) != '7') {
                return z;
            }
            throw null;
        }

        public static void getSharedInstance(boolean z) {
            int i = APIGuard + 5;
            values = i % 128;
            boolean z2 = i % 2 != 0;
            valueOf = z;
            if (!z2) {
                return;
            }
            throw new ArithmeticException();
        }
    }

    /* loaded from: classes3.dex */
    public static final class getSharedInstance {
        private static long AGState = 0;
        private static long APIGuard = 0;
        private static short[] APIGuard$Callback = null;
        private static int analyzeResponse = 0;
        private static boolean generateHeaders = false;
        private static byte[] getRequestHeaders = null;
        private static long getSharedInstance = 0;
        private static int initialize = 0;
        private static int log = 1;
        private static int parseResponseHeaders;
        private static int updateKernel;
        private static long valueOf;
        private static long values;

        static void getSharedInstance() {
            parseResponseHeaders = 2008553499;
            initialize = -2091450943;
            getRequestHeaders = new byte[]{-7, 63, -54, 33, -51, -5, -2, -7, 63, 5, -12, -56, 63, 5, -12, -56, 63, -54, 33, -51, -5, -2, -7, 63, 5, -12, -56, 63, -54, 33, -51, 4, 61, 0, 0, 0};
            analyzeResponse = 37;
        }

        static {
            getSharedInstance();
            KeyEvent.getDeadChar(0, 0);
            ExpandableListView.getPackedPositionChild(0L);
            ViewConfiguration.getWindowTouchSlop();
            SystemClock.currentThreadTimeMillis();
            View.combineMeasuredStates(0, 0);
            ViewConfiguration.getScrollBarSize();
            Drawable.resolveOpacity(0, 0);
            TextUtils.indexOf((CharSequence) "", '0');
            ExpandableListView.getPackedPositionForChild(0, 0);
            CdmaCellLocation.convertQuartSecToDecDegrees(0);
            TextUtils.getTrimmedLength("");
            TextUtils.lastIndexOf("", '0', 0);
            KeyEvent.getModifierMetaStateMask();
            MotionEvent.axisFromString("");
            TextUtils.indexOf("", "");
            values = 0L;
            AGState = 0L;
            valueOf = 0L;
            getSharedInstance = 0L;
            APIGuard = 0L;
            generateHeaders = true;
            log = (updateKernel + 57) % 128;
        }

        public static void valueOf(long j) {
            synchronized (getSharedInstance.class) {
                updateKernel = (log + 111) % 128;
                if ((!APIGuard.AGState()) != true) {
                    values = j;
                }
                int i = updateKernel + 101;
                log = i % 128;
                if (!(i % 2 != 0)) {
                    throw new ArithmeticException();
                }
            }
        }

        public static void values(long j) {
            synchronized (getSharedInstance.class) {
                updateKernel = (log + 83) % 128;
                if ((APIGuard.AGState() ? '9' : (char) 11) == '9') {
                    int i = updateKernel + 19;
                    log = i % 128;
                    if ((i % 2 == 0 ? '5' : 'O') != '5') {
                        valueOf += j;
                        AGState++;
                    } else {
                        valueOf *= j;
                        AGState *= 1;
                    }
                }
                int i2 = updateKernel + 21;
                log = i2 % 128;
                if (!(i2 % 2 != 0)) {
                    throw null;
                }
            }
        }

        public static String APIGuard() {
            synchronized (getSharedInstance.class) {
                log = (updateKernel + 117) % 128;
                if (!APIGuard.AGState()) {
                    int i = (log + 33) % 128;
                    updateKernel = i;
                    int i2 = i + 101;
                    log = i2 % 128;
                    if (i2 % 2 != 0) {
                        return null;
                    }
                    throw null;
                }
                StringBuilder sb = new StringBuilder();
                try {
                    if (!(AGState != 0)) {
                        Object[] objArr = new Object[1];
                        APIGuard((short) ((-1) - ImageFormat.getBitsPerPixel(0)), (byte) (1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), (-2008553499) - (Process.myTid() >> 22), 2091451058 - ExpandableListView.getPackedPositionChild(0L), (-29) - (ViewConfiguration.getFadingEdgeLength() >> 16), objArr);
                        sb.append(String.format(((String) objArr[0]).intern(), Long.valueOf(values)));
                    } else {
                        Object[] objArr2 = new Object[1];
                        APIGuard((short) (TextUtils.lastIndexOf("", '0', 0) + 1), (byte) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1), (-2008553492) - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 2091451060 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (-21) - Drawable.resolveOpacity(0, 0), objArr2);
                        sb.append(String.format(((String) objArr2[0]).intern(), Long.valueOf(values), Long.valueOf(valueOf / AGState), Long.valueOf(AGState)));
                        valueOf = 0L;
                        AGState = 0L;
                        updateKernel = (log + 25) % 128;
                    }
                    values = 0L;
                    if (!(getSharedInstance == 0) && APIGuard != 0) {
                        Object[] objArr3 = new Object[1];
                        APIGuard((short) TextUtils.getOffsetBefore("", 0), (byte) (ViewConfiguration.getWindowTouchSlop() >> 8), (-2008553477) - Color.green(0), 2091450987 - Color.argb(0, 0, 0, 0), (-25) - (ViewConfiguration.getScrollBarSize() >> 8), objArr3);
                        sb.append(String.format(((String) objArr3[0]).intern(), Long.valueOf(APIGuard - getSharedInstance), Long.valueOf(APIGuard)));
                        getSharedInstance = 0L;
                        APIGuard = 0L;
                    }
                } catch (Throwable unused) {
                }
                String obj = sb.toString();
                int i3 = updateKernel + 109;
                log = i3 % 128;
                if (i3 % 2 != 0) {
                    return obj;
                }
                throw new NullPointerException();
            }
        }

        public static void AGState() {
            synchronized (getSharedInstance.class) {
                log = (updateKernel + 41) % 128;
                getSharedInstance = System.currentTimeMillis();
                updateKernel = (log + 55) % 128;
            }
        }

        public static void valueOf() {
            synchronized (getSharedInstance.class) {
                int i = updateKernel + 117;
                log = i % 128;
                if (i % 2 != 0) {
                    if ((generateHeaders ? (char) 22 : '-') != '-') {
                        APIGuard = System.currentTimeMillis();
                        updateKernel = (log + 59) % 128;
                    }
                    generateHeaders = false;
                } else {
                    throw null;
                }
            }
        }

        private static void APIGuard(short s, byte b, int i, int i2, int i3, Object[] objArr) {
            String obj;
            synchronized (setBackground.AGState) {
                StringBuilder sb = new StringBuilder();
                int i4 = analyzeResponse;
                int i5 = i3 + i4;
                int i6 = i5 == -1 ? 1 : 0;
                if (i6 != 0) {
                    byte[] bArr = getRequestHeaders;
                    if (bArr != null) {
                        i5 = (byte) (bArr[parseResponseHeaders + i] + i4);
                    } else {
                        i5 = (short) (APIGuard$Callback[parseResponseHeaders + i] + i4);
                    }
                }
                if (i5 > 0) {
                    setBackground.values = ((i + i5) - 2) + parseResponseHeaders + i6;
                    setBackground.APIGuard = (char) (i2 + initialize);
                    sb.append(setBackground.APIGuard);
                    setBackground.getSharedInstance = setBackground.APIGuard;
                    setBackground.valueOf = 1;
                    while (setBackground.valueOf < i5) {
                        byte[] bArr2 = getRequestHeaders;
                        if (bArr2 != null) {
                            int i7 = setBackground.values;
                            setBackground.values = i7 - 1;
                            setBackground.APIGuard = (char) (setBackground.getSharedInstance + (((byte) (bArr2[i7] + s)) ^ b));
                        } else {
                            short[] sArr = APIGuard$Callback;
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
}
