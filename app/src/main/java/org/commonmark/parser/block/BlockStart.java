package org.commonmark.parser.block;

import org.commonmark.internal.BlockStartImpl;

/* loaded from: classes6.dex */
public abstract class BlockStart {
    public static BlockStart KClassImpl$Data$declaredNonStaticMembers$2() {
        return null;
    }

    public abstract BlockStart KClassImpl$Data$declaredNonStaticMembers$2(int i);

    public abstract BlockStart PlaceComponentResult(int i);

    public abstract BlockStart getAuthRequestContext();

    public static BlockStart BuiltInFictitiousFunctionClassFactory(BlockParser... blockParserArr) {
        return new BlockStartImpl(blockParserArr);
    }
}
