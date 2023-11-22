package com.apiguard3.internal;

import android.graphics.Color;
import android.graphics.PointF;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import kotlin.text.Typography;

/* loaded from: classes3.dex */
public class ConfigInstance {
    private static int analyzeResponse = 0;
    private static int generateHeaders = 1;
    private static long getSharedInstance = -3080455611964624070L;
    long AGState;
    String APIGuard;
    String valueOf;
    ConfigSerializationProxy.values values;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConfigInstance(ConfigSerializationProxy.values valuesVar, ConfigSerializationProxy.AGState aGState, String str, long j) {
        this.values = valuesVar;
        this.APIGuard = aGState.getSharedInstance();
        this.valueOf = str;
        this.AGState = j;
    }

    /* loaded from: classes3.dex */
    public interface ConfigSerializationProxy {

        /* loaded from: classes3.dex */
        public interface AGState {
            String getSharedInstance();
        }

        void AGState(values valuesVar);

        void AGState(ConfigInstance configInstance);

        /* JADX WARN: Enum visitor error
        jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'getSharedInstance' uses external variables
        	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
        	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
        	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
        	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
        	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
        	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
         */
        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes3.dex */
        public static final class values {
            public static final values AGState;
            public static final values APIGuard;
            private static int analyzeResponse = 0;
            private static int generateHeaders = 0;
            public static final values getRequestHeaders;
            public static final values getSharedInstance;
            private static final /* synthetic */ values[] initialize;
            private static int log = 1;
            private static values parseResponseHeaders;
            public static final values valueOf;
            public static final values values;
            private int level;

            static void getSharedInstance() {
                analyzeResponse = 7;
            }

            public static values valueOf(String str) {
                log = (generateHeaders + 105) % 128;
                values valuesVar = (values) Enum.valueOf(values.class, str);
                int i = generateHeaders + 71;
                log = i % 128;
                if ((i % 2 == 0 ? '2' : '-') == '-') {
                    return valuesVar;
                }
                throw new ArithmeticException();
            }

            public static values[] values() {
                log = (generateHeaders + 65) % 128;
                values[] valuesVarArr = (values[]) initialize.clone();
                int i = generateHeaders + 25;
                log = i % 128;
                if ((i % 2 == 0 ? '#' : '0') == '0') {
                    return valuesVarArr;
                }
                throw null;
            }

            static {
                getSharedInstance();
                Object[] objArr = new Object[1];
                AGState(14 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 8 - (Process.myPid() >> 22), "\ufff7\ufff9\u0015\b\u0005\b\b\ufffb\u0001\ufff9\ufff7\ufff8\u0002\u0002", true, KeyEvent.normalizeMetaState(0) + 81, objArr);
                values valuesVar = new values(((String) objArr[0]).intern(), 0, -1);
                getSharedInstance = valuesVar;
                Object[] objArr2 = new Object[1];
                AGState(Color.rgb(0, 0, 0) + 16777231, 4 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), "\u0003\u0003\ufff6\n\u0003\u0005\ufff6\ufffe\ufff6�\ufff6\u0005\u0010\u0003\u0000", true, View.resolveSize(0, 0) + 86, objArr2);
                values valuesVar2 = new values(((String) objArr2[0]).intern(), 1, 0);
                values = valuesVar2;
                Object[] objArr3 = new Object[1];
                AGState(7 - TextUtils.getOffsetAfter("", 0), 5 - (ViewConfiguration.getJumpTapTimeout() >> 16), "�\u0002\u0006\ufff5\u000b\ufffb\u0002", true, 131 - AndroidCharacter.getMirror('0'), objArr3);
                values valuesVar3 = new values(((String) objArr3[0]).intern(), 2, 1);
                AGState = valuesVar3;
                Object[] objArr4 = new Object[1];
                AGState((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 3, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 1, "\ufffe\u0004\ufffb\u0003", true, 83 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), objArr4);
                values valuesVar4 = new values(((String) objArr4[0]).intern(), 3, 2);
                valueOf = valuesVar4;
                Object[] objArr5 = new Object[1];
                AGState(5 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), Color.alpha(0) + 1, "\u0000�\ufffe\ufffb\u000e", false, TextUtils.lastIndexOf("", '0', 0, 0) + 79, objArr5);
                values valuesVar5 = new values(((String) objArr5[0]).intern(), 4, 3);
                APIGuard = valuesVar5;
                Object[] objArr6 = new Object[1];
                AGState(ExpandableListView.getPackedPositionGroup(0L) + 5, (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 5, "￼\ufffa\ufff8\t\u000b", true, 79 - TextUtils.lastIndexOf("", '0', 0), objArr6);
                values valuesVar6 = new values(((String) objArr6[0]).intern(), 5, 4);
                getRequestHeaders = valuesVar6;
                Object[] objArr7 = new Object[1];
                AGState((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 9, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 5, "\uffff\u0012\u0000\ufff4\u000b\uffff\ufff8\t\ufff8", false, TextUtils.indexOf((CharSequence) "", '0', 0) + 85, objArr7);
                values valuesVar7 = new values(((String) objArr7[0]).intern(), 6, Integer.MAX_VALUE);
                parseResponseHeaders = valuesVar7;
                initialize = new values[]{valuesVar, valuesVar2, valuesVar3, valuesVar4, valuesVar5, valuesVar6, valuesVar7};
                log = (generateHeaders + 39) % 128;
            }

            private values(String str, int i, int i2) {
                this.level = i2;
            }

            public final int AGState() {
                int i = log;
                generateHeaders = (i + 7) % 128;
                int i2 = this.level;
                int i3 = i + 15;
                generateHeaders = i3 % 128;
                if ((i3 % 2 != 0 ? 'R' : Typography.quote) == '\"') {
                    return i2;
                }
                throw new NullPointerException();
            }

            public static values AGState(int i) {
                if (i != -1) {
                    if (i == 0) {
                        values valuesVar = values;
                        log = (generateHeaders + 59) % 128;
                        return valuesVar;
                    } else if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                if (i == 4) {
                                    return getRequestHeaders;
                                }
                                values valuesVar2 = parseResponseHeaders;
                                int i2 = log + 11;
                                generateHeaders = i2 % 128;
                                if ((i2 % 2 != 0 ? '-' : (char) 0) != '-') {
                                    return valuesVar2;
                                }
                                throw new NullPointerException();
                            }
                            return APIGuard;
                        }
                        return valueOf;
                    } else {
                        return AGState;
                    }
                }
                return getSharedInstance;
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
                    int r5 = com.apiguard3.internal.ConfigInstance.ConfigSerializationProxy.values.analyzeResponse     // Catch: java.lang.Throwable -> L75
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
                throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.ConfigInstance.ConfigSerializationProxy.values.AGState(int, int, java.lang.String, boolean, int, java.lang.Object[]):void");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConfigInstance(ConfigSerializationProxy.values valuesVar, String str, String str2, long j) {
        this.values = valuesVar;
        this.APIGuard = str;
        this.valueOf = str2;
        this.AGState = j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Object[] objArr = new Object[1];
        AGState("獶뜀ﯷ㾗戋꛰\ueaabⴛ凶閼\ud804ᳲ䂡謧쿹\uf3b7㘏竳뻽", 50261 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), objArr);
        sb.append(((String) objArr[0]).intern());
        sb.append(this.values);
        Object[] objArr2 = new Object[1];
        AGState("猖ཽ讗٠苂ᵜ饭", 31847 - TextUtils.indexOf("", "", 0, 0), objArr2);
        sb.append(((String) objArr2[0]).intern());
        sb.append(this.APIGuard);
        Object[] objArr3 = new Object[1];
        AGState("猖߇髬ⷂꀩ㭖츳", 29917 - (ViewConfiguration.getScrollBarSize() >> 8), objArr3);
        sb.append(((String) objArr3[0]).intern());
        sb.append(this.valueOf);
        sb.append('\'');
        Object[] objArr4 = new Object[1];
        AGState("猖蕉鿨醪ꨛ변뚻켋쇃\udbbc\uec74\ue696", TextUtils.getOffsetAfter("", 0) + 63059, objArr4);
        sb.append(((String) objArr4[0]).intern());
        sb.append(this.AGState);
        sb.append('}');
        String obj = sb.toString();
        generateHeaders = (analyzeResponse + 13) % 128;
        return obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r7 = r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void AGState(java.lang.String r7, int r8, java.lang.Object[] r9) {
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
            long r5 = com.apiguard3.internal.ConfigInstance.getSharedInstance     // Catch: java.lang.Throwable -> L3d
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
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.ConfigInstance.AGState(java.lang.String, int, java.lang.Object[]):void");
    }
}
