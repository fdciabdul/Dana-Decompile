package com.alipay.multimedia.adjuster.utils;

import java.util.BitSet;

/* loaded from: classes7.dex */
public class UrlFixer {
    private static int $10 = 0;
    private static int $11 = 1;
    private static short[] BuiltInFictitiousFunctionClassFactory = null;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int MyBillsEntityDataFactory = 0;
    private static int PlaceComponentResult = 0;
    static BitSet allowedChars = null;
    private static byte[] getAuthRequestContext = null;
    private static int getErrorConfigVersion = 1;
    private static int moveToNextValue;

    static void PlaceComponentResult() {
        KClassImpl$Data$declaredNonStaticMembers$2 = 1257195727;
        MyBillsEntityDataFactory = 1850581725;
        getAuthRequestContext = new byte[]{42, 126, 34, 87, 74};
        PlaceComponentResult = -648300124;
    }

    static {
        PlaceComponentResult();
        allowedChars = new BitSet() { // from class: com.alipay.multimedia.adjuster.utils.UrlFixer.1
            {
                for (int i = 0; i < 85; i++) {
                    set(":/?#[]@!$&'()*+,;=abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-._~%".charAt(i));
                }
            }
        };
        try {
            int i = moveToNextValue + 117;
            getErrorConfigVersion = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003c, code lost:
    
        if (r6 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0050, code lost:
    
        if ((!com.alipay.multimedia.adjuster.utils.UrlFixer.allowedChars.get(r4)) != true) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0052, code lost:
    
        r5 = com.alipay.multimedia.adjuster.utils.UrlFixer.moveToNextValue + 85;
        com.alipay.multimedia.adjuster.utils.UrlFixer.getErrorConfigVersion = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
    
        if ((r5 % 2) != 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
    
        r0.append(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0063, code lost:
    
        r4 = 13 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0067, code lost:
    
        r0.append(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006b, code lost:
    
        r4 = java.lang.Character.toString(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0074, code lost:
    
        r5 = new java.lang.Object[1];
        a(android.widget.ExpandableListView.getPackedPositionType(0) + 1816858309, (-81) - android.view.View.resolveSize(0, 0), (short) (43 - (android.os.SystemClock.currentThreadTimeMillis() > (-1) ? 1 : (android.os.SystemClock.currentThreadTimeMillis() == (-1) ? 0 : -1))), (android.os.Process.myTid() >> 22) - 614656493, (byte) android.view.KeyEvent.getDeadChar(0, 0), r5);
        r0.append(java.net.URLEncoder.encode(r4, ((java.lang.String) r5[0]).intern()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b1, code lost:
    
        r0.append(r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String fixUrl(java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.multimedia.adjuster.utils.UrlFixer.fixUrl(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r13, int r14, short r15, int r16, byte r17, java.lang.Object[] r18) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.multimedia.adjuster.utils.UrlFixer.a(int, int, short, int, byte, java.lang.Object[]):void");
    }
}
