package com.apiguard3.internal;

/* loaded from: classes7.dex */
public final class setPivotY {
    private static int AGState = 0;
    private static int getSharedInstance = 1;
    private static final int valueOf = APIGuard();

    static {
        int i = AGState + 49;
        getSharedInstance = i % 128;
        if (i % 2 != 0) {
            return;
        }
        throw new ArithmeticException();
    }

    private static int APIGuard() {
        int i = getSharedInstance + 65;
        AGState = i % 128;
        if (i % 2 == 0) {
            return getSharedInstance(System.getProperty("java.version"));
        }
        getSharedInstance(System.getProperty("java.version"));
        throw new NullPointerException();
    }

    private static int getSharedInstance(String str) {
        int i = AGState + 87;
        getSharedInstance = i % 128;
        if (i % 2 != 0) {
            int values = values(str);
            if ((values == -1 ? (char) 5 : '8') == 5) {
                values = AGState(str);
            }
            if (values == -1) {
                getSharedInstance = (AGState + 35) % 128;
                return 6;
            }
            int i2 = AGState + 21;
            getSharedInstance = i2 % 128;
            if (i2 % 2 != 0) {
                return values;
            }
            throw new NullPointerException();
        }
        values(str);
        throw new ArithmeticException();
    }

    private static int values(String str) {
        try {
            String[] split = str.split("[._]");
            int parseInt = Integer.parseInt(split[0]);
            if ((parseInt == 1 ? '=' : (char) 25) != 25 && split.length > 1) {
                int parseInt2 = Integer.parseInt(split[1]);
                getSharedInstance = (AGState + 33) % 128;
                return parseInt2;
            }
            int i = getSharedInstance + 123;
            AGState = i % 128;
            if (i % 2 == 0) {
                return parseInt;
            }
            throw new ArithmeticException();
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private static int AGState(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < str.length()) {
                char charAt = str.charAt(i);
                if (!Character.isDigit(charAt)) {
                    break;
                }
                int i2 = AGState + 55;
                getSharedInstance = i2 % 128;
                if (i2 % 2 == 0) {
                    sb.append(charAt);
                    i += 93;
                } else {
                    sb.append(charAt);
                    i++;
                }
                AGState = (getSharedInstance + 55) % 128;
            }
            int parseInt = Integer.parseInt(sb.toString());
            int i3 = getSharedInstance + 47;
            AGState = i3 % 128;
            if ((i3 % 2 != 0 ? (char) 30 : (char) 20) == 20) {
                return parseInt;
            }
            throw null;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static int AGState() {
        int i = (getSharedInstance + 61) % 128;
        AGState = i;
        int i2 = valueOf;
        getSharedInstance = (i + 87) % 128;
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001c, code lost:
    
        if ((com.apiguard3.internal.setPivotY.valueOf >= 89) != true) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0023, code lost:
    
        if (com.apiguard3.internal.setPivotY.valueOf >= 9) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0026, code lost:
    
        r1 = r1 + 113;
        com.apiguard3.internal.setPivotY.AGState = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
    
        if ((r1 % 2) == 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
    
        r1 = ',';
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0035, code lost:
    
        r1 = 'J';
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0037, code lost:
    
        if (r1 == ',') goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0039, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003b, code lost:
    
        throw null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean getSharedInstance() {
        /*
            int r0 = com.apiguard3.internal.setPivotY.AGState
            int r0 = r0 + 65
            int r1 = r0 % 128
            com.apiguard3.internal.setPivotY.getSharedInstance = r1
            int r0 = r0 % 2
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L10
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            if (r0 == r3) goto L1f
            int r0 = com.apiguard3.internal.setPivotY.valueOf
            r4 = 89
            if (r0 < r4) goto L1b
            r0 = 1
            goto L1c
        L1b:
            r0 = 0
        L1c:
            if (r0 == r3) goto L25
            goto L26
        L1f:
            int r0 = com.apiguard3.internal.setPivotY.valueOf
            r4 = 9
            if (r0 < r4) goto L26
        L25:
            return r3
        L26:
            int r1 = r1 + 113
            int r0 = r1 % 128
            com.apiguard3.internal.setPivotY.AGState = r0
            int r1 = r1 % 2
            r0 = 44
            if (r1 == 0) goto L35
            r1 = 44
            goto L37
        L35:
            r1 = 74
        L37:
            if (r1 == r0) goto L3a
            return r2
        L3a:
            r0 = 0
            throw r0     // Catch: java.lang.Throwable -> L3c
        L3c:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.setPivotY.getSharedInstance():boolean");
    }
}
