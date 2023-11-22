package com.xiaomi.push;

import com.google.common.base.Ascii;
import java.io.InputStream;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;

/* loaded from: classes8.dex */
public final class b {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int PrepareContext = 1;
    private static int isLayoutRequested;
    private int BuiltInFictitiousFunctionClassFactory;
    private int DatabaseTableConfigUtil;
    private final byte[] KClassImpl$Data$declaredNonStaticMembers$2;
    private final InputStream MyBillsEntityDataFactory;
    private int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private int PlaceComponentResult;
    private int getAuthRequestContext;
    private int getErrorConfigVersion;
    private int lookAheadTest;
    private int moveToNextValue;
    private int scheduleImpl;
    private static char[] GetContactSyncConfig = {39826, 39829, 39843, 39866, 39857};
    private static boolean NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
    private static boolean initRecordTimeStamp = true;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda2 = 909155177;

    private b(InputStream inputStream) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = Integer.MAX_VALUE;
        this.scheduleImpl = 64;
        this.DatabaseTableConfigUtil = 67108864;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new byte[4096];
        this.PlaceComponentResult = 0;
        this.getAuthRequestContext = 0;
        this.MyBillsEntityDataFactory = inputStream;
    }

    private b(byte[] bArr, int i, int i2) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = Integer.MAX_VALUE;
        this.scheduleImpl = 64;
        this.DatabaseTableConfigUtil = 67108864;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = bArr;
        this.PlaceComponentResult = i2 + i;
        this.getAuthRequestContext = i;
        this.MyBillsEntityDataFactory = null;
    }

    public static b BuiltInFictitiousFunctionClassFactory(InputStream inputStream) {
        b bVar = new b(inputStream);
        int i = isLayoutRequested + 85;
        PrepareContext = i % 128;
        int i2 = i % 2;
        return bVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0090, code lost:
    
        if (r11 == null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0098, code lost:
    
        if (r11 == null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x009a, code lost:
    
        r11 = com.xiaomi.push.b.PrepareContext + 51;
        com.xiaomi.push.b.isLayoutRequested = r11 % 128;
        r11 = r11 % 2;
        r11 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a6, code lost:
    
        r11 = r11.read(r9, r10, r8 - r10);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private byte[] BuiltInFictitiousFunctionClassFactory(int r15) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.b.BuiltInFictitiousFunctionClassFactory(int):byte[]");
    }

    private long DatabaseTableConfigUtil() {
        int i = isLayoutRequested + 99;
        PrepareContext = i % 128;
        int i2 = i % 2;
        long scheduleImpl = ((scheduleImpl() & 255) << 8) | (scheduleImpl() & 255) | ((scheduleImpl() & 255) << 16) | ((scheduleImpl() & 255) << 24) | ((scheduleImpl() & 255) << 32) | ((scheduleImpl() & 255) << 40) | ((scheduleImpl() & 255) << 48) | ((scheduleImpl() & 255) << 56);
        int i3 = PrepareContext + 51;
        isLayoutRequested = i3 % 128;
        int i4 = i3 % 2;
        return scheduleImpl;
    }

    private boolean GetContactSyncConfig() {
        boolean z = false;
        if ((this.getAuthRequestContext == this.PlaceComponentResult ? 'Q' : '\b') != '\b') {
            if ((!KClassImpl$Data$declaredNonStaticMembers$2(false) ? (char) 3 : 'D') != 'D') {
                int i = isLayoutRequested + 19;
                PrepareContext = i % 128;
                if (i % 2 != 0) {
                    z = true;
                }
            }
        }
        try {
            int i2 = isLayoutRequested + 63;
            PrepareContext = i2 % 128;
            int i3 = i2 % 2;
            return z;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        if (((r0 >> r1) == r7.NetworkUserEntityData$$ExternalSyntheticLambda0 ? 11 : 'N') != 'N') goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003d, code lost:
    
        if ((r0 + r1) == r7.NetworkUserEntityData$$ExternalSyntheticLambda0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003f, code lost:
    
        if (r8 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0041, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0046, code lost:
    
        throw com.xiaomi.push.d.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0048, code lost:
    
        r7.getErrorConfigVersion = r0 + r1;
        r7.getAuthRequestContext = 0;
        r0 = r7.MyBillsEntityDataFactory;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004f, code lost:
    
        if (r0 != null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0051, code lost:
    
        r0 = com.xiaomi.push.b.PrepareContext + 105;
        com.xiaomi.push.b.isLayoutRequested = r0 % 128;
        r0 = r0 % 2;
        r0 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005d, code lost:
    
        r0 = r0.read(r7.KClassImpl$Data$declaredNonStaticMembers$2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0063, code lost:
    
        r7.PlaceComponentResult = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0065, code lost:
    
        if (r0 == 0) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0067, code lost:
    
        if (r0 < (-1)) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0069, code lost:
    
        if (r0 != (-1)) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006b, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006d, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006e, code lost:
    
        if (r0 == true) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0070, code lost:
    
        r7.PlaceComponentResult = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0072, code lost:
    
        if (r8 != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0074, code lost:
    
        r8 = com.xiaomi.push.b.isLayoutRequested + 101;
        com.xiaomi.push.b.PrepareContext = r8 % 128;
        r8 = r8 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x007e, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0083, code lost:
    
        throw com.xiaomi.push.d.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0084, code lost:
    
        lookAheadTest();
        r8 = (r7.getErrorConfigVersion + r7.PlaceComponentResult) + r7.BuiltInFictitiousFunctionClassFactory;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0091, code lost:
    
        if (r8 > r7.DatabaseTableConfigUtil) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0093, code lost:
    
        r0 = com.xiaomi.push.b.PrepareContext + 97;
        com.xiaomi.push.b.isLayoutRequested = r0 % 128;
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x009e, code lost:
    
        if ((r0 % 2) == 0) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a0, code lost:
    
        r0 = r1.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a3, code lost:
    
        if (r8 < 0) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a5, code lost:
    
        r8 = 'R';
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a8, code lost:
    
        r8 = com.alibaba.fastjson.parser.JSONLexer.EOI;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00aa, code lost:
    
        if (r8 == 26) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00af, code lost:
    
        if (r8 < 0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b1, code lost:
    
        r8 = com.xiaomi.push.b.isLayoutRequested + 33;
        com.xiaomi.push.b.PrepareContext = r8 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00bd, code lost:
    
        if ((r8 % 2) != 0) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00bf, code lost:
    
        r8 = 'P';
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00c2, code lost:
    
        r8 = '@';
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00c4, code lost:
    
        if (r8 == 'P') goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00c6, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00c7, code lost:
    
        r8 = r1.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00c8, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00cf, code lost:
    
        throw com.xiaomi.push.d.h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00d0, code lost:
    
        r8 = new java.lang.StringBuilder();
        r8.append("InputStream#read(byte[]) returned invalid result: ");
        r8.append(r7.PlaceComponentResult);
        r8.append("\nThe InputStream implementation is buggy.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00ed, code lost:
    
        throw new java.lang.IllegalStateException(r8.toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2(boolean r8) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.b.KClassImpl$Data$declaredNonStaticMembers$2(boolean):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001c, code lost:
    
        if ((r5 < 0) == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0022, code lost:
    
        if (r5 >= 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0024, code lost:
    
        r5 = r5 + (r4.getErrorConfigVersion + r4.getAuthRequestContext);
        r0 = r4.NetworkUserEntityData$$ExternalSyntheticLambda0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002c, code lost:
    
        if (r5 > r0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002e, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002f, code lost:
    
        if (r3 != true) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0033, code lost:
    
        r1 = com.xiaomi.push.b.PrepareContext + 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0037, code lost:
    
        com.xiaomi.push.b.isLayoutRequested = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003b, code lost:
    
        r4.NetworkUserEntityData$$ExternalSyntheticLambda0 = r5;
        lookAheadTest();
        r5 = com.xiaomi.push.b.isLayoutRequested + 53;
        com.xiaomi.push.b.PrepareContext = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004c, code lost:
    
        if ((r5 % 2) != 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004e, code lost:
    
        r5 = ';';
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0051, code lost:
    
        r5 = '*';
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
    
        if (r5 == '*') goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0055, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0056, code lost:
    
        r5.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0059, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005c, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005d, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x005e, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0063, code lost:
    
        throw com.xiaomi.push.d.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0068, code lost:
    
        throw com.xiaomi.push.d.b();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int MyBillsEntityDataFactory(int r5) {
        /*
            r4 = this;
            int r0 = com.xiaomi.push.b.PrepareContext     // Catch: java.lang.Exception -> L6b
            int r0 = r0 + 83
            int r1 = r0 % 128
            com.xiaomi.push.b.isLayoutRequested = r1     // Catch: java.lang.Exception -> L6b
            int r0 = r0 % 2
            r1 = 57
            if (r0 == 0) goto L11
            r0 = 57
            goto L13
        L11:
            r0 = 32
        L13:
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L1f
            if (r5 < 0) goto L1b
            r0 = 0
            goto L1c
        L1b:
            r0 = 1
        L1c:
            if (r0 != 0) goto L64
            goto L24
        L1f:
            r0 = 46
            int r0 = r0 / r3
            if (r5 < 0) goto L64
        L24:
            int r0 = r4.getErrorConfigVersion
            int r1 = r4.getAuthRequestContext
            int r0 = r0 + r1
            int r5 = r5 + r0
            int r0 = r4.NetworkUserEntityData$$ExternalSyntheticLambda0
            if (r5 > r0) goto L2f
            r3 = 1
        L2f:
            if (r3 != r2) goto L5f
            int r1 = com.xiaomi.push.b.PrepareContext     // Catch: java.lang.Exception -> L5d
            int r1 = r1 + 5
            int r2 = r1 % 128
            com.xiaomi.push.b.isLayoutRequested = r2     // Catch: java.lang.Exception -> L6b
            int r1 = r1 % 2
            r4.NetworkUserEntityData$$ExternalSyntheticLambda0 = r5
            r4.lookAheadTest()
            int r5 = com.xiaomi.push.b.isLayoutRequested
            int r5 = r5 + 53
            int r1 = r5 % 128
            com.xiaomi.push.b.PrepareContext = r1
            int r5 = r5 % 2
            r1 = 42
            if (r5 != 0) goto L51
            r5 = 59
            goto L53
        L51:
            r5 = 42
        L53:
            if (r5 == r1) goto L5c
            r5 = 0
            r5.hashCode()     // Catch: java.lang.Throwable -> L5a
            return r0
        L5a:
            r5 = move-exception
            throw r5
        L5c:
            return r0
        L5d:
            r5 = move-exception
            throw r5
        L5f:
            com.xiaomi.push.d r5 = com.xiaomi.push.d.a()
            throw r5
        L64:
            com.xiaomi.push.d r5 = com.xiaomi.push.d.b()     // Catch: java.lang.Exception -> L6b
            throw r5     // Catch: java.lang.Exception -> L6b
        L69:
            r5 = move-exception
            throw r5
        L6b:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.b.MyBillsEntityDataFactory(int):int");
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        int BuiltInFictitiousFunctionClassFactory;
        do {
            BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory();
            if (!(BuiltInFictitiousFunctionClassFactory != 0)) {
                break;
            }
            int i = PrepareContext + 95;
            isLayoutRequested = i % 128;
            int i2 = i % 2;
        } while (getAuthRequestContext(BuiltInFictitiousFunctionClassFactory));
        int i3 = PrepareContext + 91;
        isLayoutRequested = i3 % 128;
        if ((i3 % 2 == 0 ? '^' : (char) 1) != '^') {
            int i4 = 91 / 0;
        }
    }

    private long NetworkUserEntityData$$ExternalSyntheticLambda1() {
        int i = isLayoutRequested + 93;
        PrepareContext = i % 128;
        int i2 = i % 2;
        long j = 0;
        int i3 = 0;
        while (i3 < 64) {
            int i4 = isLayoutRequested + 101;
            PrepareContext = i4 % 128;
            int i5 = i4 % 2;
            j |= (r4 & Byte.MAX_VALUE) << i3;
            if (!((scheduleImpl() & 128) != 0)) {
                int i6 = PrepareContext + 99;
                isLayoutRequested = i6 % 128;
                if (i6 % 2 != 0) {
                    Object obj = null;
                    obj.hashCode();
                    return j;
                }
                return j;
            }
            i3 += 7;
            int i7 = PrepareContext + 7;
            isLayoutRequested = i7 % 128;
            int i8 = i7 % 2;
        }
        throw d.c();
    }

    private int NetworkUserEntityData$$ExternalSyntheticLambda2() {
        int i;
        int i2;
        byte scheduleImpl = scheduleImpl();
        if (scheduleImpl >= 0) {
            return scheduleImpl;
        }
        int i3 = scheduleImpl & Byte.MAX_VALUE;
        byte scheduleImpl2 = scheduleImpl();
        if (scheduleImpl2 >= 0) {
            i = scheduleImpl2 << 7;
        } else {
            i3 |= (scheduleImpl2 & Byte.MAX_VALUE) << 7;
            byte scheduleImpl3 = scheduleImpl();
            if (scheduleImpl3 < 0) {
                i3 |= (scheduleImpl3 & Byte.MAX_VALUE) << 14;
                byte scheduleImpl4 = scheduleImpl();
                if (scheduleImpl4 < 0) {
                    byte scheduleImpl5 = scheduleImpl();
                    i2 = i3 | ((scheduleImpl4 & Byte.MAX_VALUE) << 21) | (scheduleImpl5 << Ascii.FS);
                    if ((scheduleImpl5 < 0 ? ':' : '-') == ':') {
                        int i4 = 0;
                        while (true) {
                            if (i4 >= 5) {
                                try {
                                    throw d.c();
                                } catch (Exception e) {
                                    throw e;
                                }
                            }
                            if ((scheduleImpl() >= 0 ? 'D' : '.') == 'D') {
                                try {
                                    int i5 = PrepareContext + 103;
                                    isLayoutRequested = i5 % 128;
                                    int i6 = i5 % 2;
                                    return i2;
                                } catch (Exception e2) {
                                    throw e2;
                                }
                            }
                            i4++;
                        }
                    }
                    int i7 = isLayoutRequested + 25;
                    PrepareContext = i7 % 128;
                    int i8 = i7 % 2;
                    return i2;
                }
                int i9 = isLayoutRequested + 103;
                PrepareContext = i9 % 128;
                int i10 = i9 % 2;
                i = scheduleImpl4 << Ascii.NAK;
                int i11 = PrepareContext + 71;
                isLayoutRequested = i11 % 128;
                int i12 = i11 % 2;
            } else {
                i = scheduleImpl3 << 14;
            }
        }
        i2 = i3 | i;
        int i72 = isLayoutRequested + 25;
        PrepareContext = i72 % 128;
        int i82 = i72 % 2;
        return i2;
    }

    private void PlaceComponentResult(int i) {
        int i2 = isLayoutRequested + 109;
        PrepareContext = i2 % 128;
        if (!(i2 % 2 == 0)) {
            try {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i;
                lookAheadTest();
                return;
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = i;
            lookAheadTest();
            int i3 = 26 / 0;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static b getAuthRequestContext(byte[] bArr, int i, int i2) {
        b bVar = new b(bArr, i, i2);
        int i3 = isLayoutRequested + 35;
        PrepareContext = i3 % 128;
        int i4 = i3 % 2;
        return bVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001c, code lost:
    
        if ((r9 < 0) == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002a, code lost:
    
        if ((r9 >= 0 ? ';' : '/') != '/') goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002c, code lost:
    
        r0 = r8.getErrorConfigVersion;
        r1 = r8.getAuthRequestContext;
        r3 = r8.NetworkUserEntityData$$ExternalSyntheticLambda0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0036, code lost:
    
        if (((r0 + r1) + r9) > r3) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0038, code lost:
    
        r4 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003a, code lost:
    
        r4 = '\b';
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003c, code lost:
    
        if (r4 != 3) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0040, code lost:
    
        r3 = com.xiaomi.push.b.PrepareContext + 33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0045, code lost:
    
        com.xiaomi.push.b.isLayoutRequested = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0047, code lost:
    
        r3 = r3 % 2;
        r3 = r8.PlaceComponentResult;
        r5 = r3 - r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004d, code lost:
    
        if (r9 > r5) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004f, code lost:
    
        r0 = com.xiaomi.push.b.isLayoutRequested + 125;
        com.xiaomi.push.b.PrepareContext = r0 % 128;
        r0 = r0 % 2;
        r8.getAuthRequestContext = r1 + r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005c, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005d, code lost:
    
        r8.getErrorConfigVersion = r0 + r3;
        r8.getAuthRequestContext = 0;
        r8.PlaceComponentResult = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0066, code lost:
    
        if (r5 >= r9) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0068, code lost:
    
        r1 = '+';
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006b, code lost:
    
        r1 = '!';
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x006d, code lost:
    
        if (r1 == '+') goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x006f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0070, code lost:
    
        r0 = r8.MyBillsEntityDataFactory;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0072, code lost:
    
        if (r0 != null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0074, code lost:
    
        r0 = com.xiaomi.push.b.isLayoutRequested + 85;
        com.xiaomi.push.b.PrepareContext = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007e, code lost:
    
        if ((r0 % 2) != 0) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0082, code lost:
    
        r0 = 46 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0086, code lost:
    
        r0 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0088, code lost:
    
        r0 = (int) r0.skip(r9 - r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0090, code lost:
    
        if (r0 <= 0) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0092, code lost:
    
        r5 = r5 + r0;
        r8.getErrorConfigVersion += r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x009d, code lost:
    
        throw com.xiaomi.push.d.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x009e, code lost:
    
        getErrorConfigVersion((r3 - r0) - r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00a7, code lost:
    
        throw com.xiaomi.push.d.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00a8, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a9, code lost:
    
        throw r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00af, code lost:
    
        throw com.xiaomi.push.d.b();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void getErrorConfigVersion(int r9) {
        /*
            Method dump skipped, instructions count: 177
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.b.getErrorConfigVersion(int):void");
    }

    private int initRecordTimeStamp() {
        int i = PrepareContext + 99;
        isLayoutRequested = i % 128;
        int i2 = i % 2;
        int scheduleImpl = (scheduleImpl() & 255) | ((scheduleImpl() & 255) << 8) | ((scheduleImpl() & 255) << 16) | ((scheduleImpl() & 255) << 24);
        try {
            int i3 = isLayoutRequested + 121;
            try {
                PrepareContext = i3 % 128;
                int i4 = i3 % 2;
                return scheduleImpl;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void lookAheadTest() {
        try {
            int i = PrepareContext + 97;
            isLayoutRequested = i % 128;
            int i2 = i % 2;
            int i3 = this.PlaceComponentResult + this.BuiltInFictitiousFunctionClassFactory;
            this.PlaceComponentResult = i3;
            int i4 = this.getErrorConfigVersion + i3;
            int i5 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            try {
                if ((i4 > i5 ? '5' : '[') != '5') {
                    this.BuiltInFictitiousFunctionClassFactory = 0;
                    int i6 = isLayoutRequested + 3;
                    PrepareContext = i6 % 128;
                    if (i6 % 2 != 0) {
                        return;
                    }
                    Object obj = null;
                    obj.hashCode();
                    return;
                }
                int i7 = isLayoutRequested + 37;
                PrepareContext = i7 % 128;
                if (!(i7 % 2 != 0)) {
                    int i8 = i4 >> i5;
                    this.BuiltInFictitiousFunctionClassFactory = i8;
                    this.PlaceComponentResult = i3 + i8;
                    return;
                }
                int i9 = i4 - i5;
                this.BuiltInFictitiousFunctionClassFactory = i9;
                this.PlaceComponentResult = i3 - i9;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0028, code lost:
    
        if ((r5.getAuthRequestContext != r5.PlaceComponentResult) != true) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002c, code lost:
    
        r0 = com.xiaomi.push.b.PrepareContext + 53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0030, code lost:
    
        com.xiaomi.push.b.isLayoutRequested = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0034, code lost:
    
        KClassImpl$Data$declaredNonStaticMembers$2(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0038, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0039, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003b, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001a, code lost:
    
        if ((r5.getAuthRequestContext == r5.PlaceComponentResult) != false) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private byte scheduleImpl() {
        /*
            r5 = this;
            int r0 = com.xiaomi.push.b.PrepareContext
            int r0 = r0 + 51
            int r1 = r0 % 128
            com.xiaomi.push.b.isLayoutRequested = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L1f
            int r0 = r5.getAuthRequestContext
            int r3 = r5.PlaceComponentResult
            r4 = 83
            int r4 = r4 / r1
            if (r0 != r3) goto L19
            r0 = 1
            goto L1a
        L19:
            r0 = 0
        L1a:
            if (r0 == 0) goto L3c
            goto L2a
        L1d:
            r0 = move-exception
            throw r0
        L1f:
            int r0 = r5.getAuthRequestContext
            int r3 = r5.PlaceComponentResult
            if (r0 != r3) goto L27
            r0 = 0
            goto L28
        L27:
            r0 = 1
        L28:
            if (r0 == r2) goto L3c
        L2a:
            int r0 = com.xiaomi.push.b.PrepareContext     // Catch: java.lang.Exception -> L3a
            int r0 = r0 + 53
            int r3 = r0 % 128
            com.xiaomi.push.b.isLayoutRequested = r3     // Catch: java.lang.Exception -> L38
            int r0 = r0 % 2
            r5.KClassImpl$Data$declaredNonStaticMembers$2(r2)
            goto L3c
        L38:
            r0 = move-exception
            throw r0
        L3a:
            r0 = move-exception
            throw r0
        L3c:
            byte[] r0 = r5.KClassImpl$Data$declaredNonStaticMembers$2
            int r2 = r5.getAuthRequestContext
            int r3 = r2 + 1
            r5.getAuthRequestContext = r3
            r0 = r0[r2]
            int r2 = com.xiaomi.push.b.PrepareContext
            int r2 = r2 + 61
            int r3 = r2 % 128
            com.xiaomi.push.b.isLayoutRequested = r3
            int r2 = r2 % 2
            if (r2 == 0) goto L58
            r2 = 75
            int r2 = r2 / r1
            return r0
        L56:
            r0 = move-exception
            throw r0
        L58:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.b.scheduleImpl():byte");
    }

    public final int BuiltInFictitiousFunctionClassFactory() {
        try {
            if ((GetContactSyncConfig() ? 'F' : 'G') == 'F') {
                this.lookAheadTest = 0;
                int i = PrepareContext + 115;
                isLayoutRequested = i % 128;
                if (!(i % 2 == 0)) {
                    int i2 = 70 / 0;
                    return 0;
                }
                return 0;
            }
            int NetworkUserEntityData$$ExternalSyntheticLambda22 = NetworkUserEntityData$$ExternalSyntheticLambda2();
            this.lookAheadTest = NetworkUserEntityData$$ExternalSyntheticLambda22;
            if (NetworkUserEntityData$$ExternalSyntheticLambda22 != 0) {
                int i3 = isLayoutRequested + 125;
                PrepareContext = i3 % 128;
                if (i3 % 2 == 0) {
                    Object obj = null;
                    obj.hashCode();
                    return NetworkUserEntityData$$ExternalSyntheticLambda22;
                }
                return NetworkUserEntityData$$ExternalSyntheticLambda22;
            }
            throw d.d();
        } catch (Exception e) {
            throw e;
        }
    }

    public final a KClassImpl$Data$declaredNonStaticMembers$2() {
        int i = PrepareContext + 39;
        isLayoutRequested = i % 128;
        int i2 = i % 2;
        try {
            int NetworkUserEntityData$$ExternalSyntheticLambda22 = NetworkUserEntityData$$ExternalSyntheticLambda2();
            try {
                int i3 = this.PlaceComponentResult;
                int i4 = this.getAuthRequestContext;
                if ((NetworkUserEntityData$$ExternalSyntheticLambda22 <= i3 - i4 ? '\t' : (char) 1) == '\t') {
                    int i5 = PrepareContext + 57;
                    isLayoutRequested = i5 % 128;
                    int i6 = i5 % 2;
                    if (NetworkUserEntityData$$ExternalSyntheticLambda22 > 0) {
                        int i7 = PrepareContext + 115;
                        isLayoutRequested = i7 % 128;
                        int i8 = i7 % 2;
                        a KClassImpl$Data$declaredNonStaticMembers$2 = a.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, i4, NetworkUserEntityData$$ExternalSyntheticLambda22);
                        this.getAuthRequestContext += NetworkUserEntityData$$ExternalSyntheticLambda22;
                        return KClassImpl$Data$declaredNonStaticMembers$2;
                    }
                }
                return a.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory(NetworkUserEntityData$$ExternalSyntheticLambda22));
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        int i2 = isLayoutRequested + 75;
        PrepareContext = i2 % 128;
        int i3 = i2 % 2;
        if (this.lookAheadTest != i) {
            throw d.e();
        }
        int i4 = isLayoutRequested + 27;
        PrepareContext = i4 % 128;
        if ((i4 % 2 == 0 ? '?' : 'Z') != 'Z') {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0024, code lost:
    
        if ((r6.moveToNextValue < r6.scheduleImpl) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0031, code lost:
    
        if (r1 < r4) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
    
        r1 = com.xiaomi.push.b.isLayoutRequested + 85;
        com.xiaomi.push.b.PrepareContext = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
    
        if ((r1 % 2) != 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003f, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0042, code lost:
    
        r0 = MyBillsEntityDataFactory(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0046, code lost:
    
        if (r1 == true) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0048, code lost:
    
        r6.moveToNextValue++;
        r7.KClassImpl$Data$declaredNonStaticMembers$2(r6);
        KClassImpl$Data$declaredNonStaticMembers$2(0);
        r7 = r6.moveToNextValue - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0056, code lost:
    
        r6.moveToNextValue = r7;
        PlaceComponentResult(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
    
        r6.moveToNextValue += 0;
        r7.KClassImpl$Data$declaredNonStaticMembers$2(r6);
        KClassImpl$Data$declaredNonStaticMembers$2(0);
        r7 = r6.moveToNextValue * 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006c, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0071, code lost:
    
        throw com.xiaomi.push.d.g();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void MyBillsEntityDataFactory(com.xiaomi.push.e r7) {
        /*
            r6 = this;
            int r0 = com.xiaomi.push.b.isLayoutRequested
            int r0 = r0 + 121
            int r1 = r0 % 128
            com.xiaomi.push.b.PrepareContext = r1
            int r0 = r0 % 2
            r1 = 93
            if (r0 != 0) goto L11
            r0 = 93
            goto L13
        L11:
            r0 = 32
        L13:
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L27
            int r0 = r6.NetworkUserEntityData$$ExternalSyntheticLambda2()
            int r1 = r6.moveToNextValue
            int r4 = r6.scheduleImpl
            if (r1 >= r4) goto L23
            r1 = 1
            goto L24
        L23:
            r1 = 0
        L24:
            if (r1 == 0) goto L6d
            goto L33
        L27:
            int r0 = r6.NetworkUserEntityData$$ExternalSyntheticLambda2()
            int r1 = r6.moveToNextValue
            int r4 = r6.scheduleImpl
            r5 = 0
            int r5 = r5.length     // Catch: java.lang.Throwable -> L72
            if (r1 >= r4) goto L6d
        L33:
            int r1 = com.xiaomi.push.b.isLayoutRequested
            int r1 = r1 + 85
            int r4 = r1 % 128
            com.xiaomi.push.b.PrepareContext = r4
            int r1 = r1 % 2
            if (r1 != 0) goto L41
            r1 = 1
            goto L42
        L41:
            r1 = 0
        L42:
            int r0 = r6.MyBillsEntityDataFactory(r0)
            if (r1 == r3) goto L5c
            int r1 = r6.moveToNextValue
            int r1 = r1 + r3
            r6.moveToNextValue = r1
            r7.KClassImpl$Data$declaredNonStaticMembers$2(r6)
            r6.KClassImpl$Data$declaredNonStaticMembers$2(r2)
            int r7 = r6.moveToNextValue
            int r7 = r7 - r3
        L56:
            r6.moveToNextValue = r7
            r6.PlaceComponentResult(r0)
            goto L6c
        L5c:
            int r1 = r6.moveToNextValue
            int r1 = r1 + r2
            r6.moveToNextValue = r1
            r7.KClassImpl$Data$declaredNonStaticMembers$2(r6)
            r6.KClassImpl$Data$declaredNonStaticMembers$2(r2)
            int r7 = r6.moveToNextValue
            int r7 = r7 * 1
            goto L56
        L6c:
            return
        L6d:
            com.xiaomi.push.d r7 = com.xiaomi.push.d.g()
            throw r7
        L72:
            r7 = move-exception
            goto L75
        L74:
            throw r7
        L75:
            goto L74
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.b.MyBillsEntityDataFactory(com.xiaomi.push.e):void");
    }

    public final boolean MyBillsEntityDataFactory() {
        if (!(NetworkUserEntityData$$ExternalSyntheticLambda2() != 0)) {
            int i = PrepareContext + 77;
            isLayoutRequested = i % 128;
            int i2 = i % 2;
            return false;
        }
        int i3 = PrepareContext + 35;
        isLayoutRequested = i3 % 128;
        int i4 = i3 % 2;
        return true;
    }

    public final long PlaceComponentResult() {
        long NetworkUserEntityData$$ExternalSyntheticLambda12;
        int i = PrepareContext + 51;
        isLayoutRequested = i % 128;
        try {
            if ((i % 2 != 0 ? '`' : '4') != '`') {
                NetworkUserEntityData$$ExternalSyntheticLambda12 = NetworkUserEntityData$$ExternalSyntheticLambda1();
            } else {
                NetworkUserEntityData$$ExternalSyntheticLambda12 = NetworkUserEntityData$$ExternalSyntheticLambda1();
                Object[] objArr = null;
                int length = objArr.length;
            }
            int i2 = isLayoutRequested + 99;
            PrepareContext = i2 % 128;
            if (!(i2 % 2 != 0)) {
                int i3 = 65 / 0;
                return NetworkUserEntityData$$ExternalSyntheticLambda12;
            }
            return NetworkUserEntityData$$ExternalSyntheticLambda12;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0033, code lost:
    
        if (r0 > 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0038, code lost:
    
        if (r0 > 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:
    
        r7 = r10.KClassImpl$Data$declaredNonStaticMembers$2;
        r3 = new java.lang.Object[1];
        a((android.media.AudioTrack.getMinVolume() > 0.0f ? 1 : (android.media.AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 127, new byte[]{-123, -124, -125, -126, -127}, null, null, r3);
        r1 = new java.lang.String(r7, r2, r0, ((java.lang.String) r3[0]).intern());
        r10.getAuthRequestContext += r0;
        r0 = com.xiaomi.push.b.isLayoutRequested + 9;
        com.xiaomi.push.b.PrepareContext = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006b, code lost:
    
        if ((r0 % 2) != 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006f, code lost:
    
        r0 = 99 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0070, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0073, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String getAuthRequestContext() {
        /*
            r10 = this;
            int r0 = com.xiaomi.push.b.isLayoutRequested
            int r0 = r0 + 81
            int r1 = r0 % 128
            com.xiaomi.push.b.PrepareContext = r1
            int r0 = r0 % 2
            int r0 = r10.NetworkUserEntityData$$ExternalSyntheticLambda2()
            int r1 = r10.PlaceComponentResult
            int r2 = r10.getAuthRequestContext
            int r1 = r1 - r2
            r3 = 1
            r4 = 0
            if (r0 > r1) goto L19
            r1 = 0
            goto L1a
        L19:
            r1 = 1
        L1a:
            r5 = 5
            r6 = 0
            if (r1 == 0) goto L1f
            goto L74
        L1f:
            int r1 = com.xiaomi.push.b.isLayoutRequested
            int r1 = r1 + 115
            int r7 = r1 % 128
            com.xiaomi.push.b.PrepareContext = r7
            int r1 = r1 % 2
            if (r1 != 0) goto L2d
            r1 = 0
            goto L2e
        L2d:
            r1 = 1
        L2e:
            if (r1 == r3) goto L38
            r6.hashCode()     // Catch: java.lang.Throwable -> L36
            if (r0 <= 0) goto L74
            goto L3a
        L36:
            r0 = move-exception
            throw r0
        L38:
            if (r0 <= 0) goto L74
        L3a:
            java.lang.String r1 = new java.lang.String
            byte[] r7 = r10.KClassImpl$Data$declaredNonStaticMembers$2
            float r8 = android.media.AudioTrack.getMinVolume()
            r9 = 0
            int r8 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            int r8 = r8 + 127
            byte[] r5 = new byte[r5]
            r5 = {x0096: FILL_ARRAY_DATA , data: [-123, -124, -125, -126, -127} // fill-array
            java.lang.Object[] r3 = new java.lang.Object[r3]
            a(r8, r5, r6, r6, r3)
            r3 = r3[r4]
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r3 = r3.intern()
            r1.<init>(r7, r2, r0, r3)
            int r2 = r10.getAuthRequestContext
            int r2 = r2 + r0
            r10.getAuthRequestContext = r2
            int r0 = com.xiaomi.push.b.isLayoutRequested
            int r0 = r0 + 9
            int r2 = r0 % 128
            com.xiaomi.push.b.PrepareContext = r2
            int r0 = r0 % 2
            if (r0 != 0) goto L73
            r0 = 99
            int r0 = r0 / r4
            return r1
        L71:
            r0 = move-exception
            throw r0
        L73:
            return r1
        L74:
            java.lang.String r1 = new java.lang.String
            byte[] r0 = r10.BuiltInFictitiousFunctionClassFactory(r0)
            int r2 = android.view.View.getDefaultSize(r4, r4)
            int r2 = 127 - r2
            byte[] r5 = new byte[r5]
            r5 = {x009e: FILL_ARRAY_DATA , data: [-123, -124, -125, -126, -127} // fill-array
            java.lang.Object[] r3 = new java.lang.Object[r3]
            a(r2, r5, r6, r6, r3)
            r2 = r3[r4]
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r2 = r2.intern()
            r1.<init>(r0, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.b.getAuthRequestContext():java.lang.String");
    }

    public final boolean getAuthRequestContext(int i) {
        try {
            int MyBillsEntityDataFactory = f.MyBillsEntityDataFactory(i);
            if ((MyBillsEntityDataFactory != 0 ? 'T' : 'N') == 'N') {
                moveToNextValue();
                return true;
            }
            if (!(MyBillsEntityDataFactory != 1)) {
                DatabaseTableConfigUtil();
                return true;
            }
            int i2 = PrepareContext + 85;
            isLayoutRequested = i2 % 128;
            int i3 = i2 % 2;
            if (MyBillsEntityDataFactory == 2) {
                getErrorConfigVersion(NetworkUserEntityData$$ExternalSyntheticLambda2());
                return true;
            }
            int i4 = isLayoutRequested + 55;
            PrepareContext = i4 % 128;
            if (i4 % 2 != 0 ? MyBillsEntityDataFactory == 3 : MyBillsEntityDataFactory == 3) {
                NetworkUserEntityData$$ExternalSyntheticLambda0();
                KClassImpl$Data$declaredNonStaticMembers$2(f.BuiltInFictitiousFunctionClassFactory(f.getAuthRequestContext(i), 4));
                return true;
            }
            if (MyBillsEntityDataFactory != 4) {
                int i5 = isLayoutRequested + 27;
                PrepareContext = i5 % 128;
                if ((i5 % 2 == 0 ? '(' : '\f') == '(' ? MyBillsEntityDataFactory != 2 : MyBillsEntityDataFactory != 5) {
                    throw d.f();
                }
                initRecordTimeStamp();
                int i6 = PrepareContext + 27;
                isLayoutRequested = i6 % 128;
                if (i6 % 2 == 0) {
                    return true;
                }
                int i7 = 5 / 0;
                return true;
            }
            return false;
        } catch (Exception e) {
            throw e;
        }
    }

    public final int getErrorConfigVersion() {
        try {
            int i = PrepareContext + 125;
            isLayoutRequested = i % 128;
            if (!(i % 2 != 0)) {
                return NetworkUserEntityData$$ExternalSyntheticLambda2();
            }
            int i2 = 80 / 0;
            return NetworkUserEntityData$$ExternalSyntheticLambda2();
        } catch (Exception e) {
            throw e;
        }
    }

    public final int moveToNextValue() {
        try {
            int i = isLayoutRequested + 95;
            PrepareContext = i % 128;
            int i2 = i % 2;
            int NetworkUserEntityData$$ExternalSyntheticLambda22 = NetworkUserEntityData$$ExternalSyntheticLambda2();
            int i3 = isLayoutRequested + 57;
            PrepareContext = i3 % 128;
            int i4 = i3 % 2;
            return NetworkUserEntityData$$ExternalSyntheticLambda22;
        } catch (Exception e) {
            throw e;
        }
    }

    private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) {
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr2 = GetContactSyncConfig;
        if ((cArr2 != null ? (char) 3 : 'D') != 'D') {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i2 = 0; i2 < length; i2++) {
                cArr3[i2] = (char) (cArr2[i2] ^ 4571606982258105150L);
            }
            cArr2 = cArr3;
        }
        try {
            int i3 = (int) (NetworkUserEntityData$$ExternalSyntheticLambda2 ^ 4571606982258105150L);
            if (initRecordTimeStamp) {
                int i4 = $10 + 23;
                $11 = i4 % 128;
                int i5 = i4 % 2;
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
                char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                    cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i3);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                }
                objArr[0] = new String(cArr4);
                return;
            }
            try {
                if ((NetworkUserEntityData$$ExternalSyntheticLambda1 ? '_' : '8') == '8') {
                    bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
                    char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                    while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                        cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                        bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                    }
                    objArr[0] = new String(cArr5);
                    return;
                }
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
                char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (true) {
                    if ((bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult ? 'I' : 'P') == 'P') {
                        objArr[0] = new String(cArr6);
                        return;
                    }
                    int i6 = $10 + 21;
                    $11 = i6 % 128;
                    int i7 = i6 % 2;
                    cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
