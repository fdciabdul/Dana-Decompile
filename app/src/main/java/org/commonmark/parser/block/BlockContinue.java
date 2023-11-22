package org.commonmark.parser.block;

import org.commonmark.internal.BlockContinueImpl;

/* loaded from: classes6.dex */
public class BlockContinue {
    public static BlockContinue MyBillsEntityDataFactory() {
        return null;
    }

    public static BlockContinue BuiltInFictitiousFunctionClassFactory(int i) {
        return new BlockContinueImpl(i, -1, false);
    }

    public static BlockContinue getAuthRequestContext(int i) {
        return new BlockContinueImpl(-1, i, false);
    }

    public static BlockContinue KClassImpl$Data$declaredNonStaticMembers$2() {
        return new BlockContinueImpl(-1, -1, true);
    }
}
