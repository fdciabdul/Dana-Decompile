package org.commonmark.internal;

import org.commonmark.node.Block;
import org.commonmark.node.ListItem;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.ParserState;

/* loaded from: classes6.dex */
public class ListItemParser extends AbstractBlockParser {
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    private final ListItem MyBillsEntityDataFactory = new ListItem();

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public final boolean PlaceComponentResult() {
        return true;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public final boolean PlaceComponentResult(Block block) {
        return true;
    }

    public ListItemParser(int i) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public final Block MyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public final BlockContinue PlaceComponentResult(ParserState parserState) {
        if (!parserState.lookAheadTest()) {
            if (parserState.BuiltInFictitiousFunctionClassFactory() >= this.KClassImpl$Data$declaredNonStaticMembers$2) {
                return BlockContinue.getAuthRequestContext(parserState.PlaceComponentResult() + this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            return BlockContinue.MyBillsEntityDataFactory();
        } else if (this.MyBillsEntityDataFactory.getErrorConfigVersion == null) {
            return BlockContinue.MyBillsEntityDataFactory();
        } else {
            return BlockContinue.BuiltInFictitiousFunctionClassFactory(parserState.NetworkUserEntityData$$ExternalSyntheticLambda0());
        }
    }
}
