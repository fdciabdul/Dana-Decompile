package com.apiguard3.internal;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.fastjson.parser.JSONLexer;
import com.apiguard3.internal.ConfigInstance;
import com.apiguard3.internal.writeReplace;
import id.dana.cashier.view.InputCardNumberView;
import java.util.Collections;
import java.util.List;
import kotlin.text.Typography;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class KernelPayloadInstance extends HandlerThread {
    private static Object AGState = null;
    private static KernelPayloadInstance APIGuard = null;
    private static int generateHeaders = 1;
    private static readObject getSharedInstance;
    private static int valueOf;
    private static int values;

    static void valueOf() {
        valueOf = 65;
    }

    static {
        valueOf();
        AGState = new Object();
        generateHeaders = (values + 57) % 128;
    }

    private KernelPayloadInstance(String str) {
        super(str);
    }

    private static KernelPayloadInstance APIGuard() {
        synchronized (KernelPayloadInstance.class) {
            int i = generateHeaders;
            int i2 = i + 47;
            values = i2 % 128;
            if (i2 % 2 == 0) {
                KernelPayloadInstance kernelPayloadInstance = APIGuard;
                if (kernelPayloadInstance == null) {
                    Object[] objArr = new Object[1];
                    AGState(Color.green(0) + 5, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 3, "\u0015\r\b\u0002ￔ", true, 160 - View.resolveSize(0, 0), objArr);
                    KernelPayloadInstance kernelPayloadInstance2 = new KernelPayloadInstance(((String) objArr[0]).intern());
                    APIGuard = kernelPayloadInstance2;
                    kernelPayloadInstance2.start();
                    return APIGuard;
                }
                int i3 = i + 61;
                values = i3 % 128;
                if ((i3 % 2 != 0 ? 'F' : 'R') != 'F') {
                    return kernelPayloadInstance;
                }
                throw new NullPointerException();
            }
            throw new NullPointerException();
        }
    }

    /* loaded from: classes3.dex */
    public final class KernelPayloadSerializationProxy implements ConfigInstance.ConfigSerializationProxy {
        private static int analyzeResponse = 1;
        private static char[] getRequestHeaders;
        private static int initialize;
        private static long parseResponseHeaders;
        private ConfigInstance.ConfigSerializationProxy.values AGState;
        private int APIGuard;
        private volatile boolean generateHeaders;
        private RB<Pair<String, Number>> getSharedInstance;
        private String valueOf;
        private long values;

        static {
            getRequestHeaders();
            ViewConfiguration.getFadingEdgeLength();
            KeyEvent.getModifierMetaStateMask();
            KeyEvent.getModifierMetaStateMask();
            ViewConfiguration.getKeyRepeatTimeout();
            AudioTrack.getMaxVolume();
            KeyEvent.getDeadChar(0, 0);
            int i = initialize + 57;
            analyzeResponse = i % 128;
            if ((i % 2 == 0 ? JSONLexer.EOI : '\f') == '\f') {
                return;
            }
            throw null;
        }

        static void getRequestHeaders() {
            parseResponseHeaders = 6708955271343632639L;
            getRequestHeaders = new char[]{56670, 11692, 't', 61580, ':'};
        }

        private KernelPayloadSerializationProxy(byte b) {
            this.valueOf = writeReplace.APIGuard.AGState.getSharedInstance();
            this.APIGuard = 0;
            this.values = 0L;
            this.AGState = ConfigInstance.ConfigSerializationProxy.values.values;
            this.generateHeaders = false;
            this.getSharedInstance = new RB<>(20);
            this.AGState = ConfigInstance.ConfigSerializationProxy.values.values;
        }

        public KernelPayloadSerializationProxy() {
            this((byte) 0);
        }

        @Override // com.apiguard3.internal.ConfigInstance.ConfigSerializationProxy
        public final void AGState(ConfigInstance.ConfigSerializationProxy.values valuesVar) {
            int i = analyzeResponse + 5;
            initialize = i % 128;
            boolean z = i % 2 == 0;
            this.AGState = valuesVar;
            if (z) {
                return;
            }
            throw null;
        }

        @Override // com.apiguard3.internal.ConfigInstance.ConfigSerializationProxy
        public final void AGState(ConfigInstance configInstance) {
            if ((!this.generateHeaders ? InputCardNumberView.DIVIDER : 'M') == ' ') {
                analyzeResponse = (initialize + 93) % 128;
                if (configInstance.values.compareTo(this.AGState) <= 0) {
                    values(configInstance.valueOf, configInstance.APIGuard, configInstance.AGState);
                    int i = initialize + 43;
                    analyzeResponse = i % 128;
                    if ((i % 2 == 0 ? (char) 4 : '\b') != 4) {
                        return;
                    }
                    throw new NullPointerException();
                }
            }
            analyzeResponse = (initialize + 11) % 128;
        }

        public final void APIGuard() {
            int i = initialize + 85;
            analyzeResponse = i % 128;
            this.generateHeaders = (i % 2 == 0 ? Typography.dollar : 'M') != 'M';
        }

        public final void getSharedInstance() {
            int i = analyzeResponse + 43;
            initialize = i % 128;
            if (i % 2 == 0) {
                this.generateHeaders = true;
            } else {
                this.generateHeaders = false;
            }
        }

        public final String valueOf() throws JSONException {
            JSONArray jSONArray = new JSONArray();
            for (Pair<String, Number> pair : valueOf(false)) {
                JSONObject jSONObject = new JSONObject();
                Object[] objArr = new Object[1];
                valueOf((char) ((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 56631), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 1, Drawable.resolveOpacity(0, 0), objArr);
                jSONObject.put(((String) objArr[0]).intern(), pair.first);
                Object[] objArr2 = new Object[1];
                valueOf((char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1), 2 - Color.alpha(0), 2 - (ViewConfiguration.getEdgeSlop() >> 16), objArr2);
                jSONObject.put(((String) objArr2[0]).intern(), pair.second);
                jSONArray.put(jSONObject);
                analyzeResponse = (initialize + 59) % 128;
            }
            return jSONArray.toString();
        }

        public final List<Pair<String, Number>> valueOf(boolean z) {
            List<Pair<String, Number>> sharedInstance;
            synchronized (this) {
                initialize = (analyzeResponse + 11) % 128;
                sharedInstance = this.getSharedInstance.getSharedInstance();
                Collections.reverse(sharedInstance);
                if ((z ? '2' : '\'') != '\'') {
                    int i = analyzeResponse + 75;
                    initialize = i % 128;
                    if ((i % 2 != 0 ? (char) 27 : (char) 22) == 27) {
                        this.getSharedInstance.AGState();
                        throw null;
                    }
                    this.getSharedInstance.AGState();
                }
            }
            return sharedInstance;
        }

        public final String AGState() {
            int i = analyzeResponse;
            int i2 = i + 15;
            initialize = i2 % 128;
            if (i2 % 2 != 0) {
                throw null;
            }
            String str = this.valueOf;
            int i3 = i + 119;
            initialize = i3 % 128;
            if ((i3 % 2 != 0 ? InputCardNumberView.DIVIDER : 'D') != ' ') {
                return str;
            }
            throw new ArithmeticException();
        }

        public final int values() {
            int i = (analyzeResponse + 83) % 128;
            initialize = i;
            int i2 = this.APIGuard;
            int i3 = i + 77;
            analyzeResponse = i3 % 128;
            if ((i3 % 2 == 0 ? 'J' : (char) 25) != 'J') {
                return i2;
            }
            throw new ArithmeticException();
        }

        public final long analyzeResponse() {
            int i = (analyzeResponse + 19) % 128;
            initialize = i;
            long j = this.values;
            int i2 = i + 21;
            analyzeResponse = i2 % 128;
            if ((i2 % 2 != 0 ? '#' : (char) 21) == '#') {
                return j;
            }
            throw null;
        }

        private String APIGuard(String str, String str2) {
            Object obj;
            StringBuilder sb = new StringBuilder();
            String str3 = "";
            if ((str2 != null ? '\r' : '\b') != '\r') {
                str2 = "";
            } else {
                analyzeResponse = (initialize + 93) % 128;
            }
            if (TextUtils.isEmpty(str)) {
                str = "";
            } else {
                int generateHeaders = generateHeaders();
                if (str.length() <= generateHeaders) {
                    analyzeResponse = (initialize + 113) % 128;
                } else {
                    str = str.substring(str.length() - generateHeaders);
                }
                initialize = (analyzeResponse + 33) % 128;
            }
            if ((!TextUtils.isEmpty(str)) != false && !TextUtils.isEmpty(str2)) {
                int i = analyzeResponse + 81;
                initialize = i % 128;
                if (i % 2 == 0) {
                    Object[] objArr = new Object[1];
                    valueOf((char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), View.MeasureSpec.getMode(0) + 1, View.resolveSizeAndState(0, 0, 0) + 4, objArr);
                    obj = objArr[0];
                } else {
                    Object[] objArr2 = new Object[1];
                    valueOf((char) (TypedValue.complexToFraction(1, 2.0f, 0.0f) > 1.0f ? 1 : (TypedValue.complexToFraction(1, 2.0f, 0.0f) == 1.0f ? 0 : -1)), 1 - View.MeasureSpec.getMode(0), 4 % View.resolveSizeAndState(0, 1, 0), objArr2);
                    obj = objArr2[1];
                }
                str3 = ((String) obj).intern();
            }
            sb.append(str2);
            sb.append(str3);
            sb.append(str);
            return sb.toString();
        }

        private int generateHeaders() {
            initialize = (analyzeResponse + 33) % 128;
            if ((this.AGState.compareTo(ConfigInstance.ConfigSerializationProxy.values.AGState) >= 0 ? ';' : (char) 6) != ';') {
                return 100;
            }
            int i = analyzeResponse + 29;
            initialize = i % 128;
            return (i % 2 != 0 ? 'S' : (char) 23) != 'S' ? 300 : 7055;
        }

        private void values(String str, String str2, long j) {
            synchronized (this) {
                initialize = (analyzeResponse + 87) % 128;
                String APIGuard = APIGuard(str, str2);
                if (!TextUtils.isEmpty(APIGuard)) {
                    this.getSharedInstance.APIGuard(new Pair<>(APIGuard, Long.valueOf(j)));
                    if ((!str2.equals(this.valueOf)) == false) {
                        this.APIGuard++;
                    } else {
                        this.APIGuard = 1;
                        this.valueOf = str2;
                    }
                    this.values = j;
                }
                int i = initialize + 123;
                analyzeResponse = i % 128;
                if ((i % 2 == 0 ? (char) 23 : (char) 29) != 29) {
                    throw new NullPointerException();
                }
            }
        }

        private static void valueOf(char c, int i, int i2, Object[] objArr) {
            String str;
            synchronized (setBackgroundTintList.AGState) {
                char[] cArr = new char[i];
                setBackgroundTintList.getSharedInstance = 0;
                while (setBackgroundTintList.getSharedInstance < i) {
                    cArr[setBackgroundTintList.getSharedInstance] = (char) ((getRequestHeaders[setBackgroundTintList.getSharedInstance + i2] ^ (setBackgroundTintList.getSharedInstance * parseResponseHeaders)) ^ c);
                    setBackgroundTintList.getSharedInstance++;
                }
                str = new String(cArr);
            }
            objArr[0] = str;
        }
    }

    public static Handler getSharedInstance() {
        readObject readobject;
        synchronized (AGState) {
            if (getSharedInstance == null) {
                getSharedInstance = new readObject(APIGuard().getLooper());
            }
            readobject = getSharedInstance;
        }
        return readobject;
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
            int r5 = com.apiguard3.internal.KernelPayloadInstance.valueOf     // Catch: java.lang.Throwable -> L75
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
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.KernelPayloadInstance.AGState(int, int, java.lang.String, boolean, int, java.lang.Object[]):void");
    }
}
