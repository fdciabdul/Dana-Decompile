package org.commonmark.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.commonmark.Extension;
import org.commonmark.internal.DocumentParser;
import org.commonmark.internal.InlineParserImpl;
import org.commonmark.node.Block;
import org.commonmark.parser.block.BlockParserFactory;
import org.commonmark.parser.delimiter.DelimiterProcessor;

/* loaded from: classes6.dex */
public class Parser {
    public final List<PostProcessor> KClassImpl$Data$declaredNonStaticMembers$2;
    private final List<DelimiterProcessor> MyBillsEntityDataFactory;
    public final List<BlockParserFactory> PlaceComponentResult;
    private final InlineParserFactory getAuthRequestContext;

    /* loaded from: classes6.dex */
    public interface ParserExtension extends Extension {
        void BuiltInFictitiousFunctionClassFactory(Builder builder);
    }

    public /* synthetic */ Parser(Builder builder, byte b) {
        this(builder);
    }

    private Parser(Builder builder) {
        this.PlaceComponentResult = DocumentParser.PlaceComponentResult(builder.PlaceComponentResult, builder.BuiltInFictitiousFunctionClassFactory);
        this.getAuthRequestContext = builder.KClassImpl$Data$declaredNonStaticMembers$2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = builder.getAuthRequestContext;
        this.MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory;
        MyBillsEntityDataFactory();
    }

    public final InlineParser MyBillsEntityDataFactory() {
        if (this.getAuthRequestContext == null) {
            return new InlineParserImpl(this.MyBillsEntityDataFactory);
        }
        new CustomInlineParserContext(this.MyBillsEntityDataFactory);
        return this.getAuthRequestContext.getAuthRequestContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class CustomInlineParserContext implements InlineParserContext {
        private List<DelimiterProcessor> getAuthRequestContext;

        CustomInlineParserContext(List<DelimiterProcessor> list) {
            this.getAuthRequestContext = list;
        }
    }

    /* loaded from: classes6.dex */
    public static class Builder {
        private Set<Class<? extends Block>> BuiltInFictitiousFunctionClassFactory;
        private InlineParserFactory KClassImpl$Data$declaredNonStaticMembers$2;
        public final List<BlockParserFactory> PlaceComponentResult = new ArrayList();
        public final List<DelimiterProcessor> MyBillsEntityDataFactory = new ArrayList();
        private final List<PostProcessor> getAuthRequestContext = new ArrayList();

        public Builder() {
            Set<Class<? extends Block>> set;
            set = DocumentParser.PlaceComponentResult;
            this.BuiltInFictitiousFunctionClassFactory = set;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        }
    }
}
