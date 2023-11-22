package com.apiguard3.url_matcher;

import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import com.apiguard3.internal.ConfigInstance;
import com.apiguard3.internal.readResolve;
import com.apiguard3.internal.writeReplace;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;

/* loaded from: classes7.dex */
public class MatchesConfig {
    private static int APIGuard = 0;
    private static int valueOf = 1;
    private List<MatchConfig> AGState;
    private Matches values;

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'AGState' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class Matches {
        public static final Matches AGState;
        public static final Matches APIGuard;
        private static int analyzeResponse = 0;
        private static long generateHeaders = 0;
        private static final /* synthetic */ Matches[] getSharedInstance;
        private static int parseResponseHeaders = 1;
        public static final Matches valueOf;
        public static final Matches values;

        static void valueOf() {
            generateHeaders = 3504142128149441013L;
        }

        private Matches(String str, int i) {
        }

        public static Matches valueOf(String str) {
            parseResponseHeaders = (analyzeResponse + 121) % 128;
            Matches matches = (Matches) Enum.valueOf(Matches.class, str);
            analyzeResponse = (parseResponseHeaders + 63) % 128;
            return matches;
        }

        public static Matches[] values() {
            parseResponseHeaders = (analyzeResponse + 43) % 128;
            Matches[] matchesArr = (Matches[]) getSharedInstance.clone();
            parseResponseHeaders = (analyzeResponse + 99) % 128;
            return matchesArr;
        }

        static {
            valueOf();
            Object[] objArr = new Object[1];
            AGState("⦴콚\ue47f", (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 59106, objArr);
            Matches matches = new Matches(((String) objArr[0]).intern(), 0);
            AGState = matches;
            Object[] objArr2 = new Object[1];
            AGState("⦴度잖", 30494 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), objArr2);
            Matches matches2 = new Matches(((String) objArr2[0]).intern(), 1);
            APIGuard = matches2;
            Object[] objArr3 = new Object[1];
            AGState("⦻췗\ue161蓷", 58477 - TextUtils.getOffsetAfter("", 0), objArr3);
            Matches matches3 = new Matches(((String) objArr3[0]).intern(), 2);
            valueOf = matches3;
            Object[] objArr4 = new Object[1];
            AGState("⦴\ue878ꨪ注⺱\ue173ꌩ旧", Color.red(0) + 49603, objArr4);
            Matches matches4 = new Matches(((String) objArr4[0]).intern(), 3);
            values = matches4;
            getSharedInstance = new Matches[]{matches, matches2, matches3, matches4};
            int i = parseResponseHeaders + 31;
            analyzeResponse = i % 128;
            if (i % 2 != 0) {
                throw null;
            }
        }

        public static Matches values(String str) {
            char c = 65535;
            switch (str.hashCode()) {
                case 64897:
                    Object[] objArr = new Object[1];
                    AGState("⦴콚\ue47f", 59107 - (ViewConfiguration.getKeyRepeatDelay() >> 16), objArr);
                    if (str.equals(((String) objArr[0]).intern())) {
                        analyzeResponse = (parseResponseHeaders + 25) % 128;
                        c = 0;
                        break;
                    }
                    break;
                case 64972:
                    Object[] objArr2 = new Object[1];
                    AGState("⦴度잖", 30493 - View.getDefaultSize(0, 0), objArr2);
                    if ((str.equals(((String) objArr2[0]).intern()) ? '#' : 'N') == '#') {
                        c = 1;
                        break;
                    }
                    break;
                case 2402104:
                    Object[] objArr3 = new Object[1];
                    AGState("⦻췗\ue161蓷", (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 58476, objArr3);
                    if (str.equals(((String) objArr3[0]).intern())) {
                        c = 2;
                        break;
                    }
                    break;
                case 452152962:
                    Object[] objArr4 = new Object[1];
                    AGState("⦴\ue878ꨪ注⺱\ue173ꌩ旧", 49603 - (ViewConfiguration.getScrollBarSize() >> 8), objArr4);
                    if (str.equals(((String) objArr4[0]).intern())) {
                        analyzeResponse = (parseResponseHeaders + 21) % 128;
                        c = 3;
                        break;
                    }
                    break;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        if (c == 3) {
                            return values;
                        }
                        readResolve.valueOf(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.APIGuard.clearCallback);
                        return values;
                    }
                    return valueOf;
                }
                return APIGuard;
            }
            return AGState;
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
                long r5 = com.apiguard3.url_matcher.MatchesConfig.Matches.generateHeaders     // Catch: java.lang.Throwable -> L3d
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
            throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.url_matcher.MatchesConfig.Matches.AGState(java.lang.String, int, java.lang.Object[]):void");
        }
    }

    public MatchesConfig() {
        this.values = Matches.values;
        this.AGState = new ArrayList();
    }

    public MatchesConfig(JSONArray jSONArray) {
        this.values = Matches.values;
        this.AGState = new ArrayList();
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        String str = (String) jSONArray.opt(0);
        if (str == null || str.isEmpty()) {
            this.values = Matches.values;
        } else {
            this.values = Matches.values(str);
        }
        if (this.values == Matches.values) {
            this.AGState = Collections.emptyList();
            return;
        }
        for (int i = 1; i < jSONArray.length(); i++) {
            JSONArray jSONArray2 = (JSONArray) jSONArray.opt(i);
            if (jSONArray2 != null) {
                this.AGState.add(new MatchConfig(jSONArray2));
            }
        }
    }

    public boolean equals(Object obj) {
        int i = valueOf + 85;
        APIGuard = i % 128;
        if (i % 2 != 0) {
            throw new NullPointerException();
        } else if (this == obj) {
            return true;
        } else {
            if ((obj != null ? '%' : '.') == '%') {
                if (!(getClass() != obj.getClass())) {
                    MatchesConfig matchesConfig = (MatchesConfig) obj;
                    if (this.values.equals(matchesConfig.values)) {
                        APIGuard = (valueOf + 21) % 128;
                        if (this.AGState.equals(matchesConfig.AGState)) {
                            return true;
                        }
                    }
                    valueOf = (APIGuard + 107) % 128;
                }
            }
            return false;
        }
    }

    public int hashCode() {
        APIGuard = (valueOf + 27) % 128;
        int hashCode = this.values.hashCode();
        int hashCode2 = this.AGState.hashCode();
        APIGuard = (valueOf + 59) % 128;
        return ((hashCode + 527) * 31) + hashCode2;
    }

    public List<MatchConfig> AGState() {
        int i = (APIGuard + 25) % 128;
        valueOf = i;
        List<MatchConfig> list = this.AGState;
        APIGuard = (i + 55) % 128;
        return list;
    }

    public Matches valueOf() {
        int i = (APIGuard + 85) % 128;
        valueOf = i;
        Matches matches = this.values;
        APIGuard = (i + 81) % 128;
        return matches;
    }
}
