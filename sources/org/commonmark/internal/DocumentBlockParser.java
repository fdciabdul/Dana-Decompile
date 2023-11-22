package org.commonmark.internal;

import org.commonmark.node.Block;
import org.commonmark.node.Document;
import org.commonmark.parser.block.AbstractBlockParser;
import org.commonmark.parser.block.BlockContinue;
import org.commonmark.parser.block.ParserState;

/* loaded from: classes6.dex */
public class DocumentBlockParser extends AbstractBlockParser {
    public final Document BuiltInFictitiousFunctionClassFactory = new Document();

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public final void PlaceComponentResult(CharSequence charSequence) {
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public final boolean PlaceComponentResult() {
        return true;
    }

    @Override // org.commonmark.parser.block.AbstractBlockParser, org.commonmark.parser.block.BlockParser
    public final boolean PlaceComponentResult(Block block) {
        return true;
    }

    @Override // org.commonmark.parser.block.BlockParser
    public final BlockContinue PlaceComponentResult(ParserState parserState) {
        return BlockContinue.BuiltInFictitiousFunctionClassFactory(parserState.MyBillsEntityDataFactory());
    }

    @Override // org.commonmark.parser.block.BlockParser
    public final /* bridge */ /* synthetic */ Block MyBillsEntityDataFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }
}
