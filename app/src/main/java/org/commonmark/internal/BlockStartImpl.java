package org.commonmark.internal;

import org.commonmark.parser.block.BlockParser;
import org.commonmark.parser.block.BlockStart;

/* loaded from: classes6.dex */
public class BlockStartImpl extends BlockStart {
    final BlockParser[] MyBillsEntityDataFactory;
    int KClassImpl$Data$declaredNonStaticMembers$2 = -1;
    int BuiltInFictitiousFunctionClassFactory = -1;
    private boolean getAuthRequestContext = false;

    public BlockStartImpl(BlockParser... blockParserArr) {
        this.MyBillsEntityDataFactory = blockParserArr;
    }

    public final boolean MyBillsEntityDataFactory() {
        return this.getAuthRequestContext;
    }

    @Override // org.commonmark.parser.block.BlockStart
    public final BlockStart KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        return this;
    }

    @Override // org.commonmark.parser.block.BlockStart
    public final BlockStart PlaceComponentResult(int i) {
        this.BuiltInFictitiousFunctionClassFactory = i;
        return this;
    }

    @Override // org.commonmark.parser.block.BlockStart
    public final BlockStart getAuthRequestContext() {
        this.getAuthRequestContext = true;
        return this;
    }
}
