package com.apiguard3.internal;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;

/* loaded from: classes7.dex */
public final class MatchConfig$Match implements unregisterForContextMenu {
    private static int AGState = 0;
    private static int getSharedInstance = 1;
    private static MatchConfig$Match valueOf;
    public static final byte[] MyBillsEntityDataFactory = {94, Ascii.EM, -44, 73, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int BuiltInFictitiousFunctionClassFactory = 244;

    /* JADX WARN: Removed duplicated region for block: B:23:0x00ce A[Catch: all -> 0x010c, TRY_LEAVE, TryCatch #2 {all -> 0x010c, blocks: (B:17:0x007b, B:21:0x00c7, B:23:0x00ce, B:27:0x00f8), top: B:39:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f6  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00fa -> B:29:0x00ff). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.apiguard3.internal.cs<java.lang.Boolean> valueOf(final android.content.Context r18, java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.MatchConfig$Match.valueOf(android.content.Context, java.lang.String):com.apiguard3.internal.cs");
    }

    private MatchConfig$Match() {
    }

    public static MatchConfig$Match values() {
        MatchConfig$Match matchConfig$Match;
        synchronized (MatchConfig$Match.class) {
            getSharedInstance = (AGState + 69) % 128;
            if (valueOf == null) {
                valueOf = new MatchConfig$Match();
                getSharedInstance = (AGState + 65) % 128;
            }
            matchConfig$Match = valueOf;
        }
        return matchConfig$Match;
    }

    @Override // com.apiguard3.internal.unregisterForContextMenu
    public final byte[] values(byte[] bArr) {
        int i = getSharedInstance + 13;
        int i2 = i % 128;
        AGState = i2;
        if ((i % 2 != 0 ? (char) 18 : 'Q') == 18) {
            throw new ArithmeticException();
        }
        int i3 = i2 + 5;
        getSharedInstance = i3 % 128;
        if (i3 % 2 != 0) {
            return bArr;
        }
        throw new ArithmeticException();
    }

    @Override // com.apiguard3.internal.unregisterForContextMenu
    public final byte[] APIGuard(byte[] bArr) {
        int i = (getSharedInstance + 57) % 128;
        AGState = i;
        getSharedInstance = (i + 115) % 128;
        return bArr;
    }
}
