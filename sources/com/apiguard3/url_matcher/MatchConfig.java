package com.apiguard3.url_matcher;

import android.graphics.Color;
import android.os.Process;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.apiguard3.internal.ConfigInstance;
import com.apiguard3.internal.readResolve;
import com.apiguard3.internal.setBackgroundTintList;
import com.apiguard3.internal.writeReplace;
import org.json.JSONArray;

/* loaded from: classes7.dex */
public class MatchConfig {
    private static int analyzeResponse = 1;
    private static char[] getSharedInstance = {'_', 'N', 37056, 8522, 'I'};
    private static long initialize = -6680954477061304177L;
    private static int parseResponseHeaders;
    private Match AGState;
    private boolean APIGuard;
    private boolean valueOf;
    private String values;

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'values' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class Match {
        public static final Match AGState;
        public static final Match APIGuard;
        private static int analyzeResponse = 1;
        private static final /* synthetic */ Match[] generateHeaders;
        private static int getRequestHeaders;
        public static final Match getSharedInstance;
        private static int parseResponseHeaders;
        public static final Match valueOf;
        public static final Match values;

        static void APIGuard() {
            parseResponseHeaders = 79;
        }

        private Match(String str, int i) {
        }

        public static Match valueOf(String str) {
            int i = getRequestHeaders + 71;
            analyzeResponse = i % 128;
            boolean z = i % 2 != 0;
            Match match = (Match) Enum.valueOf(Match.class, str);
            if (!z) {
                throw null;
            }
            int i2 = getRequestHeaders + 53;
            analyzeResponse = i2 % 128;
            if (i2 % 2 == 0) {
                throw null;
            }
            return match;
        }

        public static Match[] values() {
            int i = getRequestHeaders + 109;
            analyzeResponse = i % 128;
            if ((i % 2 == 0 ? 'R' : 'C') != 'R') {
                return (Match[]) generateHeaders.clone();
            }
            Match[] matchArr = (Match[]) generateHeaders.clone();
            throw null;
        }

        static {
            APIGuard();
            Object[] objArr = new Object[1];
            valueOf(TextUtils.indexOf((CharSequence) "", '0', 0) + 3, 1 - TextUtils.indexOf((CharSequence) "", '0', 0), "\ufffb\u0005", false, 157 - View.MeasureSpec.getSize(0), objArr);
            Match match = new Match(((String) objArr[0]).intern(), 0);
            values = match;
            Object[] objArr2 = new Object[1];
            valueOf(AndroidCharacter.getMirror('0') - '&', 6 - TextUtils.indexOf("", "", 0, 0), "\u0004\u0005\u0003\ufff2\u0005\u0004\ufff9\u0005\ufffa\b", true, 158 - View.resolveSize(0, 0), objArr2);
            Match match2 = new Match(((String) objArr2[0]).intern(), 1);
            getSharedInstance = match2;
            Object[] objArr3 = new Object[1];
            valueOf(KeyEvent.getDeadChar(0, 0) + 8, View.getDefaultSize(0, 0) + 4, "\ufff6\ufffe\u0003\b\ufff8\u0004\u0003\t", false, (ViewConfiguration.getEdgeSlop() >> 16) + 154, objArr3);
            Match match3 = new Match(((String) objArr3[0]).intern(), 2);
            APIGuard = match3;
            Object[] objArr4 = new Object[1];
            valueOf(ExpandableListView.getPackedPositionType(0L) + 8, Color.rgb(0, 0, 0) + 16777219, "�\b￼\ufff9\u0002\ufff8\u0007\u000b", false, 156 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), objArr4);
            Match match4 = new Match(((String) objArr4[0]).intern(), 3);
            valueOf = match4;
            Object[] objArr5 = new Object[1];
            valueOf((ViewConfiguration.getEdgeSlop() >> 16) + 7, 7 - (ViewConfiguration.getScrollDefaultDelay() >> 16), "\uffff\u0004\f\ufff7\u0002\uffff\ufffa", false, TextUtils.indexOf((CharSequence) "", '0', 0) + 154, objArr5);
            Match match5 = new Match(((String) objArr5[0]).intern(), 4);
            AGState = match5;
            generateHeaders = new Match[]{match, match2, match3, match4, match5};
            int i = getRequestHeaders + 91;
            analyzeResponse = i % 128;
            if (i % 2 != 0) {
                return;
            }
            throw new NullPointerException();
        }

        public static Match values(String str) {
            int hashCode = str.hashCode();
            char c = 0;
            if (hashCode == -1768228930) {
                Object[] objArr = new Object[1];
                valueOf((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 7, 3 - (ViewConfiguration.getJumpTapTimeout() >> 16), "�\b￼\ufff9\u0002\ufff8\u0007\u000b", false, 155 - TextUtils.indexOf("", "", 0, 0), objArr);
                if (str.equals(((String) objArr[0]).intern())) {
                    getRequestHeaders = (analyzeResponse + 21) % 128;
                    c = 3;
                }
                c = 65535;
            } else if (hashCode == -1069493097) {
                Object[] objArr2 = new Object[1];
                valueOf(10 - ((Process.getThreadPriority(0) + 20) >> 6), (Process.myPid() >> 22) + 6, "\u0004\u0005\u0003\ufff2\u0005\u0004\ufff9\u0005\ufffa\b", true, (ViewConfiguration.getFadingEdgeLength() >> 16) + 158, objArr2);
                if (str.equals(((String) objArr2[0]).intern())) {
                    getRequestHeaders = (analyzeResponse + 69) % 128;
                    c = 1;
                }
                c = 65535;
            } else if (hashCode != 2346) {
                if (hashCode == 215180831) {
                    Object[] objArr3 = new Object[1];
                    valueOf('8' - AndroidCharacter.getMirror('0'), 4 - TextUtils.indexOf("", "", 0), "\ufff6\ufffe\u0003\b\ufff8\u0004\u0003\t", false, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 154, objArr3);
                    if (str.equals(((String) objArr3[0]).intern())) {
                        c = 2;
                    }
                }
                c = 65535;
            } else {
                Object[] objArr4 = new Object[1];
                valueOf(2 - View.getDefaultSize(0, 0), Gravity.getAbsoluteGravity(0, 0) + 2, "\ufffb\u0005", false, (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 157, objArr4);
                if (str.equals(((String) objArr4[0]).intern())) {
                    analyzeResponse = (getRequestHeaders + 47) % 128;
                }
                c = 65535;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        if (c != 3) {
                            readResolve.valueOf(ConfigInstance.ConfigSerializationProxy.values.values, writeReplace.APIGuard.onInitializationSuccess);
                            return AGState;
                        }
                        return valueOf;
                    }
                    return APIGuard;
                }
                return getSharedInstance;
            }
            return values;
        }

        /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        
            r8 = r8;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void valueOf(int r6, int r7, java.lang.String r8, boolean r9, int r10, java.lang.Object[] r11) {
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
                int r5 = com.apiguard3.url_matcher.MatchConfig.Match.parseResponseHeaders     // Catch: java.lang.Throwable -> L75
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
            throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.url_matcher.MatchConfig.Match.valueOf(int, int, java.lang.String, boolean, int, java.lang.Object[]):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatchConfig(JSONArray jSONArray) {
        this.values = "";
        this.AGState = Match.AGState;
        this.APIGuard = false;
        this.valueOf = false;
        String str = (String) jSONArray.opt(0);
        if (str != null) {
            Object[] objArr = new Object[1];
            AGState((char) (TextUtils.lastIndexOf("", '0', 0) + 1), 1 - View.resolveSizeAndState(0, 0, 0), AndroidCharacter.getMirror('0') - '0', objArr);
            String[] split = str.split(((String) objArr[0]).intern());
            String str2 = split[0];
            Object[] objArr2 = new Object[1];
            AGState((char) Color.alpha(0), TextUtils.indexOf("", "", 0) + 3, View.combineMeasuredStates(0, 0) + 1, objArr2);
            this.APIGuard = str2.equals(((String) objArr2[0]).intern());
            String str3 = split[split.length - 1];
            Object[] objArr3 = new Object[1];
            AGState((char) ExpandableListView.getPackedPositionType(0L), 1 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 3, objArr3);
            this.valueOf = str3.equals(((String) objArr3[0]).intern());
            this.AGState = Match.values(split[this.APIGuard ? 1 : 0]);
        }
        String str4 = (String) jSONArray.opt(1);
        if (str4 != null) {
            this.values = this.valueOf ? str4.toLowerCase() : str4;
        }
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj != null && getClass() == obj.getClass()) {
                MatchConfig matchConfig = (MatchConfig) obj;
                if (this.values.equals(matchConfig.values)) {
                    int i = analyzeResponse;
                    parseResponseHeaders = (i + 3) % 128;
                    if (this.AGState == matchConfig.AGState) {
                        int i2 = i + 117;
                        int i3 = i2 % 128;
                        parseResponseHeaders = i3;
                        if ((i2 % 2 != 0 ? 'E' : (char) 31) == 'E') {
                            boolean z = matchConfig.APIGuard;
                            throw null;
                        }
                        if (!(this.APIGuard != matchConfig.APIGuard) && this.valueOf == matchConfig.valueOf) {
                            analyzeResponse = (i3 + 109) % 128;
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        int i4 = analyzeResponse + 115;
        parseResponseHeaders = i4 % 128;
        if (i4 % 2 == 0) {
            return true;
        }
        throw new ArithmeticException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003a, code lost:
    
        if ((r3 % 2 == 0 ? 'U' : 6) != 'U') goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int hashCode() {
        /*
            r7 = this;
            java.lang.String r0 = r7.values
            int r0 = r0.hashCode()
            com.apiguard3.url_matcher.MatchConfig$Match r1 = r7.AGState
            int r1 = r1.hashCode()
            boolean r2 = r7.APIGuard
            r3 = 7
            if (r2 == 0) goto L14
            r2 = 95
            goto L15
        L14:
            r2 = 7
        L15:
            r4 = 1
            r5 = 0
            if (r2 == r3) goto L1b
            r2 = 1
            goto L24
        L1b:
            int r2 = com.apiguard3.url_matcher.MatchConfig.parseResponseHeaders
            int r2 = r2 + 107
            int r2 = r2 % 128
            com.apiguard3.url_matcher.MatchConfig.analyzeResponse = r2
            r2 = 0
        L24:
            boolean r3 = r7.valueOf
            if (r3 == 0) goto L3d
            int r3 = com.apiguard3.url_matcher.MatchConfig.parseResponseHeaders
            int r3 = r3 + 23
            int r6 = r3 % 128
            com.apiguard3.url_matcher.MatchConfig.analyzeResponse = r6
            int r3 = r3 % 2
            r6 = 85
            if (r3 != 0) goto L39
            r3 = 85
            goto L3a
        L39:
            r3 = 6
        L3a:
            if (r3 == r6) goto L3d
            goto L3e
        L3d:
            r4 = 0
        L3e:
            int r0 = r0 + 527
            int r0 = r0 * 31
            int r0 = r0 + r1
            int r0 = r0 * 31
            int r0 = r0 + r2
            int r0 = r0 * 31
            int r0 = r0 + r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.url_matcher.MatchConfig.hashCode():int");
    }

    public String APIGuard() {
        int i = (analyzeResponse + 89) % 128;
        parseResponseHeaders = i;
        String str = this.values;
        int i2 = i + 61;
        analyzeResponse = i2 % 128;
        if (i2 % 2 == 0) {
            throw new ArithmeticException();
        }
        return str;
    }

    public Match getSharedInstance() {
        int i = analyzeResponse;
        parseResponseHeaders = (i + 71) % 128;
        Match match = this.AGState;
        int i2 = i + 123;
        parseResponseHeaders = i2 % 128;
        if (!(i2 % 2 != 0)) {
            return match;
        }
        throw null;
    }

    public Boolean valueOf() {
        int i = analyzeResponse + 53;
        parseResponseHeaders = i % 128;
        if (i % 2 == 0) {
            return Boolean.valueOf(this.APIGuard);
        }
        throw new ArithmeticException();
    }

    public Boolean AGState() {
        int i = parseResponseHeaders;
        analyzeResponse = (i + 65) % 128;
        boolean z = this.valueOf;
        int i2 = i + 25;
        analyzeResponse = i2 % 128;
        if ((i2 % 2 == 0 ? 'R' : '@') != 'R') {
            return Boolean.valueOf(z);
        }
        throw null;
    }

    private static void AGState(char c, int i, int i2, Object[] objArr) {
        String str;
        synchronized (setBackgroundTintList.AGState) {
            char[] cArr = new char[i];
            setBackgroundTintList.getSharedInstance = 0;
            while (setBackgroundTintList.getSharedInstance < i) {
                cArr[setBackgroundTintList.getSharedInstance] = (char) ((getSharedInstance[setBackgroundTintList.getSharedInstance + i2] ^ (setBackgroundTintList.getSharedInstance * initialize)) ^ c);
                setBackgroundTintList.getSharedInstance++;
            }
            str = new String(cArr);
        }
        objArr[0] = str;
    }
}
