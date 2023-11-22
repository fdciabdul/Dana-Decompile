package com.apiguard3.internal;

/* loaded from: classes3.dex */
public final class setForegroundTintBlendMode {
    private static int AGState = 1;
    public static int APIGuard;
    public static final Object getSharedInstance = new Object();
    public static int valueOf;
    private static int values;

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0037, code lost:
    
        if (((r16 >> r6) + 0 == ((long) r19)) != true) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
    
        if (((r16 >>> r6) & 1) == r19) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0046, code lost:
    
        if (r7 < 4) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0048, code lost:
    
        r12 = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004b, code lost:
    
        r12 = '@';
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004d, code lost:
    
        if (r12 == '@') goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004f, code lost:
    
        if (r8 >= r3) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0051, code lost:
    
        r11 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0052, code lost:
    
        if (r11 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0054, code lost:
    
        r4[r7] = r18[r6];
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005b, code lost:
    
        r9 = r9 + 1;
        com.apiguard3.internal.setForegroundTintBlendMode.AGState = r9 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0063, code lost:
    
        if ((r9 % 2) != 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0065, code lost:
    
        r4[r8] = r18[r6];
        r8 = r8 + 18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006c, code lost:
    
        r4[r8] = r18[r6];
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0072, code lost:
    
        r6 = r6 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static char[] APIGuard(long r16, char[] r18, int r19) {
        /*
            r0 = r18
            r1 = r19
            int r2 = com.apiguard3.internal.setForegroundTintBlendMode.AGState
            int r3 = r2 + 71
            int r3 = r3 % 128
            com.apiguard3.internal.setForegroundTintBlendMode.values = r3
            int r3 = r0.length
            char[] r4 = new char[r3]
            int r2 = r2 + 79
            int r2 = r2 % 128
            com.apiguard3.internal.setForegroundTintBlendMode.values = r2
            r2 = 4
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 4
        L1a:
            int r9 = r0.length
            if (r6 >= r9) goto L75
            int r9 = com.apiguard3.internal.setForegroundTintBlendMode.values
            int r10 = r9 + 103
            int r11 = r10 % 128
            com.apiguard3.internal.setForegroundTintBlendMode.AGState = r11
            int r10 = r10 % 2
            r11 = 1
            if (r10 != 0) goto L3a
            long r12 = r16 >> r6
            r14 = 0
            long r12 = r12 + r14
            long r14 = (long) r1
            int r10 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r10 != 0) goto L36
            r10 = 1
            goto L37
        L36:
            r10 = 0
        L37:
            if (r10 == r11) goto L44
            goto L4f
        L3a:
            long r12 = r16 >>> r6
            r14 = 1
            long r12 = r12 & r14
            long r14 = (long) r1
            int r10 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r10 != 0) goto L4f
        L44:
            r10 = 64
            if (r7 < r2) goto L4b
            r12 = 15
            goto L4d
        L4b:
            r12 = 64
        L4d:
            if (r12 == r10) goto L54
        L4f:
            if (r8 >= r3) goto L52
            r11 = 0
        L52:
            if (r11 == 0) goto L5b
        L54:
            char r9 = r0[r6]
            r4[r7] = r9
            int r7 = r7 + 1
            goto L72
        L5b:
            int r9 = r9 + 1
            int r10 = r9 % 128
            com.apiguard3.internal.setForegroundTintBlendMode.AGState = r10
            int r9 = r9 % 2
            if (r9 != 0) goto L6c
            char r9 = r0[r6]
            r4[r8] = r9
            int r8 = r8 + 18
            goto L72
        L6c:
            char r9 = r0[r6]
            r4[r8] = r9
            int r8 = r8 + 1
        L72:
            int r6 = r6 + 1
            goto L1a
        L75:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.setForegroundTintBlendMode.APIGuard(long, char[], int):char[]");
    }

    static {
        int i = values + 45;
        AGState = i % 128;
        if (i % 2 != 0) {
            return;
        }
        throw null;
    }
}
