package org.yaml.snakeyaml.parser;

import java.util.AbstractList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.events.CommentEvent;
import org.yaml.snakeyaml.events.DocumentEndEvent;
import org.yaml.snakeyaml.events.DocumentStartEvent;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.events.ImplicitTuple;
import org.yaml.snakeyaml.events.MappingEndEvent;
import org.yaml.snakeyaml.events.MappingStartEvent;
import org.yaml.snakeyaml.events.ScalarEvent;
import org.yaml.snakeyaml.events.SequenceEndEvent;
import org.yaml.snakeyaml.events.StreamEndEvent;
import org.yaml.snakeyaml.events.StreamStartEvent;
import org.yaml.snakeyaml.reader.StreamReader;
import org.yaml.snakeyaml.scanner.Scanner;
import org.yaml.snakeyaml.scanner.ScannerImpl;
import org.yaml.snakeyaml.tokens.BlockEntryToken;
import org.yaml.snakeyaml.tokens.CommentToken;
import org.yaml.snakeyaml.tokens.DirectiveToken;
import org.yaml.snakeyaml.tokens.StreamEndToken;
import org.yaml.snakeyaml.tokens.StreamStartToken;
import org.yaml.snakeyaml.tokens.Token;
import org.yaml.snakeyaml.util.ArrayStack;

/* loaded from: classes6.dex */
public class ParserImpl implements Parser {
    private static final Map<String, String> MyBillsEntityDataFactory;
    private Event BuiltInFictitiousFunctionClassFactory;
    protected final Scanner KClassImpl$Data$declaredNonStaticMembers$2;
    private VersionTagsTuple PlaceComponentResult;
    private final ArrayStack<Mark> getAuthRequestContext;
    private Production moveToNextValue;
    private final ArrayStack<Production> scheduleImpl;

    static {
        HashMap hashMap = new HashMap();
        MyBillsEntityDataFactory = hashMap;
        hashMap.put("!", "!");
        hashMap.put("!!", "tag:yaml.org,2002:");
    }

    public ParserImpl(StreamReader streamReader, LoaderOptions loaderOptions) {
        this(new ScannerImpl(streamReader, loaderOptions));
    }

    private ParserImpl(Scanner scanner) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = scanner;
        this.BuiltInFictitiousFunctionClassFactory = null;
        this.PlaceComponentResult = new VersionTagsTuple(null, new HashMap(MyBillsEntityDataFactory));
        this.scheduleImpl = new ArrayStack<>(100);
        this.getAuthRequestContext = new ArrayStack<>(10);
        this.moveToNextValue = new ParseStreamStart(this, (byte) 0);
    }

    @Override // org.yaml.snakeyaml.parser.Parser
    public final Event PlaceComponentResult() {
        Production production;
        if (this.BuiltInFictitiousFunctionClassFactory == null && (production = this.moveToNextValue) != null) {
            this.BuiltInFictitiousFunctionClassFactory = production.MyBillsEntityDataFactory();
        }
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    /* loaded from: classes6.dex */
    class ParseStreamStart implements Production {
        private ParseStreamStart() {
        }

        /* synthetic */ ParseStreamStart(ParserImpl parserImpl, byte b) {
            this();
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public final Event MyBillsEntityDataFactory() {
            StreamStartToken streamStartToken = (StreamStartToken) ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
            StreamStartEvent streamStartEvent = new StreamStartEvent(streamStartToken.scheduleImpl, streamStartToken.getErrorConfigVersion);
            ParserImpl parserImpl = ParserImpl.this;
            parserImpl.moveToNextValue = new ParseImplicitDocumentStart(parserImpl, (byte) 0);
            return streamStartEvent;
        }
    }

    /* loaded from: classes6.dex */
    class ParseImplicitDocumentStart implements Production {
        private ParseImplicitDocumentStart() {
        }

        /* synthetic */ ParseImplicitDocumentStart(ParserImpl parserImpl, byte b) {
            this();
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public final Event MyBillsEntityDataFactory() {
            byte b = 0;
            if (ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.Comment)) {
                ParserImpl parserImpl = ParserImpl.this;
                parserImpl.moveToNextValue = new ParseImplicitDocumentStart();
                return ParserImpl.PlaceComponentResult((CommentToken) ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext());
            } else if (ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.Directive, Token.ID.DocumentStart, Token.ID.StreamEnd)) {
                return new ParseDocumentStart(ParserImpl.this, b).MyBillsEntityDataFactory();
            } else {
                Mark mark = ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory().scheduleImpl;
                DocumentStartEvent documentStartEvent = new DocumentStartEvent(mark, mark, false, null, null);
                ParserImpl.this.scheduleImpl.getAuthRequestContext.add(new ParseDocumentEnd(ParserImpl.this, b));
                ParserImpl parserImpl2 = ParserImpl.this;
                parserImpl2.moveToNextValue = new ParseBlockNode(parserImpl2, b);
                return documentStartEvent;
            }
        }
    }

    /* loaded from: classes6.dex */
    class ParseDocumentStart implements Production {
        private ParseDocumentStart() {
        }

        /* synthetic */ ParseDocumentStart(ParserImpl parserImpl, byte b) {
            this();
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public final Event MyBillsEntityDataFactory() {
            byte b;
            while (true) {
                b = 0;
                if (!ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.DocumentEnd)) {
                    break;
                }
                ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
            }
            if (!ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.StreamEnd)) {
                Mark mark = ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory().scheduleImpl;
                VersionTagsTuple scheduleImpl = ParserImpl.scheduleImpl(ParserImpl.this);
                while (ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.Comment)) {
                    ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
                }
                if (!ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.StreamEnd)) {
                    if (!ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.DocumentStart)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("expected '<document start>', but found '");
                        sb.append(ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory());
                        sb.append("'");
                        throw new ParserException(null, null, sb.toString(), ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory().scheduleImpl);
                    }
                    DocumentStartEvent documentStartEvent = new DocumentStartEvent(mark, ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext().getErrorConfigVersion, true, scheduleImpl.PlaceComponentResult, scheduleImpl.MyBillsEntityDataFactory);
                    ParserImpl.this.scheduleImpl.getAuthRequestContext.add(new ParseDocumentEnd(ParserImpl.this, b));
                    ParserImpl parserImpl = ParserImpl.this;
                    parserImpl.moveToNextValue = new ParseDocumentContent(parserImpl, b);
                    return documentStartEvent;
                }
            }
            StreamEndToken streamEndToken = (StreamEndToken) ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
            StreamEndEvent streamEndEvent = new StreamEndEvent(streamEndToken.scheduleImpl, streamEndToken.getErrorConfigVersion);
            if (ParserImpl.this.scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2()) {
                if (ParserImpl.this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    ParserImpl.this.moveToNextValue = null;
                    return streamEndEvent;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unexpected end of stream. Marks left: ");
                sb2.append(ParserImpl.this.getAuthRequestContext);
                throw new YAMLException(sb2.toString());
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unexpected end of stream. States left: ");
            sb3.append(ParserImpl.this.scheduleImpl);
            throw new YAMLException(sb3.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class ParseDocumentEnd implements Production {
        private ParseDocumentEnd() {
        }

        /* synthetic */ ParseDocumentEnd(ParserImpl parserImpl, byte b) {
            this();
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public final Event MyBillsEntityDataFactory() {
            Mark mark;
            Mark mark2 = ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory().scheduleImpl;
            boolean z = true;
            byte b = 0;
            if (ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.DocumentEnd)) {
                mark = ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext().getErrorConfigVersion;
            } else {
                mark = mark2;
                z = false;
            }
            DocumentEndEvent documentEndEvent = new DocumentEndEvent(mark2, mark, z);
            ParserImpl parserImpl = ParserImpl.this;
            parserImpl.moveToNextValue = new ParseDocumentStart(parserImpl, b);
            return documentEndEvent;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class ParseDocumentContent implements Production {
        private ParseDocumentContent() {
        }

        /* synthetic */ ParseDocumentContent(ParserImpl parserImpl, byte b) {
            this();
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public final Event MyBillsEntityDataFactory() {
            byte b = 0;
            if (ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.Comment)) {
                ParserImpl parserImpl = ParserImpl.this;
                parserImpl.moveToNextValue = new ParseDocumentContent();
                return ParserImpl.PlaceComponentResult((CommentToken) ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext());
            } else if (ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.Directive, Token.ID.DocumentStart, Token.ID.DocumentEnd, Token.ID.StreamEnd)) {
                Event KClassImpl$Data$declaredNonStaticMembers$2 = ParserImpl.KClassImpl$Data$declaredNonStaticMembers$2(ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory().scheduleImpl);
                ParserImpl parserImpl2 = ParserImpl.this;
                AbstractList abstractList = parserImpl2.scheduleImpl.getAuthRequestContext;
                parserImpl2.moveToNextValue = (Production) abstractList.remove(abstractList.size() - 1);
                return KClassImpl$Data$declaredNonStaticMembers$2;
            } else {
                return new ParseBlockNode(ParserImpl.this, b).MyBillsEntityDataFactory();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class ParseBlockNode implements Production {
        private ParseBlockNode() {
        }

        /* synthetic */ ParseBlockNode(ParserImpl parserImpl, byte b) {
            this();
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public final Event MyBillsEntityDataFactory() {
            return ParserImpl.this.getAuthRequestContext(true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.yaml.snakeyaml.events.Event getAuthRequestContext(boolean r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 696
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.yaml.snakeyaml.parser.ParserImpl.getAuthRequestContext(boolean, boolean):org.yaml.snakeyaml.events.Event");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class ParseBlockSequenceFirstEntry implements Production {
        private ParseBlockSequenceFirstEntry() {
        }

        /* synthetic */ ParseBlockSequenceFirstEntry(ParserImpl parserImpl, byte b) {
            this();
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public final Event MyBillsEntityDataFactory() {
            Token authRequestContext = ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
            ArrayStack arrayStack = ParserImpl.this.getAuthRequestContext;
            arrayStack.getAuthRequestContext.add(authRequestContext.scheduleImpl);
            return new ParseBlockSequenceEntryKey(ParserImpl.this, (byte) 0).MyBillsEntityDataFactory();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class ParseBlockSequenceEntryKey implements Production {
        private ParseBlockSequenceEntryKey() {
        }

        /* synthetic */ ParseBlockSequenceEntryKey(ParserImpl parserImpl, byte b) {
            this();
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public final Event MyBillsEntityDataFactory() {
            if (ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.Comment)) {
                ParserImpl parserImpl = ParserImpl.this;
                parserImpl.moveToNextValue = new ParseBlockSequenceEntryKey();
                return ParserImpl.PlaceComponentResult((CommentToken) ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext());
            } else if (ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.BlockEntry)) {
                return new ParseBlockSequenceEntryValue((BlockEntryToken) ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext()).MyBillsEntityDataFactory();
            } else {
                if (!ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.BlockEnd)) {
                    Token MyBillsEntityDataFactory = ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
                    AbstractList abstractList = ParserImpl.this.getAuthRequestContext.getAuthRequestContext;
                    Mark mark = (Mark) abstractList.remove(abstractList.size() - 1);
                    StringBuilder sb = new StringBuilder();
                    sb.append("expected <block end>, but found '");
                    sb.append(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory());
                    sb.append("'");
                    throw new ParserException("while parsing a block collection", mark, sb.toString(), MyBillsEntityDataFactory.scheduleImpl);
                }
                Token authRequestContext = ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
                SequenceEndEvent sequenceEndEvent = new SequenceEndEvent(authRequestContext.scheduleImpl, authRequestContext.getErrorConfigVersion);
                ParserImpl parserImpl2 = ParserImpl.this;
                AbstractList abstractList2 = parserImpl2.scheduleImpl.getAuthRequestContext;
                parserImpl2.moveToNextValue = (Production) abstractList2.remove(abstractList2.size() - 1);
                AbstractList abstractList3 = ParserImpl.this.getAuthRequestContext.getAuthRequestContext;
                abstractList3.remove(abstractList3.size() - 1);
                return sequenceEndEvent;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class ParseBlockSequenceEntryValue implements Production {
        BlockEntryToken MyBillsEntityDataFactory;

        public ParseBlockSequenceEntryValue(BlockEntryToken blockEntryToken) {
            this.MyBillsEntityDataFactory = blockEntryToken;
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public final Event MyBillsEntityDataFactory() {
            byte b = 0;
            if (ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.Comment)) {
                ParserImpl parserImpl = ParserImpl.this;
                parserImpl.moveToNextValue = new ParseBlockSequenceEntryValue(this.MyBillsEntityDataFactory);
                return ParserImpl.PlaceComponentResult((CommentToken) ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext());
            } else if (!ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.BlockEntry, Token.ID.BlockEnd)) {
                ParserImpl.this.scheduleImpl.getAuthRequestContext.add(new ParseBlockSequenceEntryKey(ParserImpl.this, b));
                return new ParseBlockNode(ParserImpl.this, b).MyBillsEntityDataFactory();
            } else {
                ParserImpl parserImpl2 = ParserImpl.this;
                parserImpl2.moveToNextValue = new ParseBlockSequenceEntryKey(parserImpl2, b);
                return ParserImpl.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.getErrorConfigVersion);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class ParseIndentlessSequenceEntryKey implements Production {
        private ParseIndentlessSequenceEntryKey() {
        }

        /* synthetic */ ParseIndentlessSequenceEntryKey(ParserImpl parserImpl, byte b) {
            this();
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public final Event MyBillsEntityDataFactory() {
            if (ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.Comment)) {
                ParserImpl parserImpl = ParserImpl.this;
                parserImpl.moveToNextValue = new ParseIndentlessSequenceEntryKey();
                return ParserImpl.PlaceComponentResult((CommentToken) ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext());
            } else if (ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.BlockEntry)) {
                return new ParseIndentlessSequenceEntryValue((BlockEntryToken) ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext()).MyBillsEntityDataFactory();
            } else {
                Token MyBillsEntityDataFactory = ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
                SequenceEndEvent sequenceEndEvent = new SequenceEndEvent(MyBillsEntityDataFactory.scheduleImpl, MyBillsEntityDataFactory.getErrorConfigVersion);
                ParserImpl parserImpl2 = ParserImpl.this;
                AbstractList abstractList = parserImpl2.scheduleImpl.getAuthRequestContext;
                parserImpl2.moveToNextValue = (Production) abstractList.remove(abstractList.size() - 1);
                return sequenceEndEvent;
            }
        }
    }

    /* loaded from: classes6.dex */
    class ParseIndentlessSequenceEntryValue implements Production {
        BlockEntryToken getAuthRequestContext;

        public ParseIndentlessSequenceEntryValue(BlockEntryToken blockEntryToken) {
            this.getAuthRequestContext = blockEntryToken;
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public final Event MyBillsEntityDataFactory() {
            byte b = 0;
            if (ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.Comment)) {
                ParserImpl parserImpl = ParserImpl.this;
                parserImpl.moveToNextValue = new ParseIndentlessSequenceEntryValue(this.getAuthRequestContext);
                return ParserImpl.PlaceComponentResult((CommentToken) ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext());
            } else if (!ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.BlockEntry, Token.ID.Key, Token.ID.Value, Token.ID.BlockEnd)) {
                ParserImpl.this.scheduleImpl.getAuthRequestContext.add(new ParseIndentlessSequenceEntryKey(ParserImpl.this, b));
                return new ParseBlockNode(ParserImpl.this, b).MyBillsEntityDataFactory();
            } else {
                ParserImpl parserImpl2 = ParserImpl.this;
                parserImpl2.moveToNextValue = new ParseIndentlessSequenceEntryKey(parserImpl2, b);
                return ParserImpl.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.getErrorConfigVersion);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class ParseBlockMappingFirstKey implements Production {
        private ParseBlockMappingFirstKey() {
        }

        /* synthetic */ ParseBlockMappingFirstKey(ParserImpl parserImpl, byte b) {
            this();
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public final Event MyBillsEntityDataFactory() {
            Token authRequestContext = ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
            ArrayStack arrayStack = ParserImpl.this.getAuthRequestContext;
            arrayStack.getAuthRequestContext.add(authRequestContext.scheduleImpl);
            return new ParseBlockMappingKey(ParserImpl.this, (byte) 0).MyBillsEntityDataFactory();
        }
    }

    /* loaded from: classes6.dex */
    class ParseBlockMappingKey implements Production {
        private ParseBlockMappingKey() {
        }

        /* synthetic */ ParseBlockMappingKey(ParserImpl parserImpl, byte b) {
            this();
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public final Event MyBillsEntityDataFactory() {
            byte b = 0;
            if (ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.Comment)) {
                ParserImpl parserImpl = ParserImpl.this;
                parserImpl.moveToNextValue = new ParseBlockMappingKey();
                return ParserImpl.PlaceComponentResult((CommentToken) ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext());
            } else if (ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.Key)) {
                Token authRequestContext = ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
                if (!ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.Key, Token.ID.Value, Token.ID.BlockEnd)) {
                    ParserImpl.this.scheduleImpl.getAuthRequestContext.add(new ParseBlockMappingValue(ParserImpl.this, b));
                    return ParserImpl.this.getAuthRequestContext(true, true);
                }
                ParserImpl parserImpl2 = ParserImpl.this;
                parserImpl2.moveToNextValue = new ParseBlockMappingValue(parserImpl2, b);
                return ParserImpl.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.getErrorConfigVersion);
            } else if (!ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.BlockEnd)) {
                Token MyBillsEntityDataFactory = ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
                AbstractList abstractList = ParserImpl.this.getAuthRequestContext.getAuthRequestContext;
                Mark mark = (Mark) abstractList.remove(abstractList.size() - 1);
                StringBuilder sb = new StringBuilder();
                sb.append("expected <block end>, but found '");
                sb.append(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory());
                sb.append("'");
                throw new ParserException("while parsing a block mapping", mark, sb.toString(), MyBillsEntityDataFactory.scheduleImpl);
            } else {
                Token authRequestContext2 = ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
                MappingEndEvent mappingEndEvent = new MappingEndEvent(authRequestContext2.scheduleImpl, authRequestContext2.getErrorConfigVersion);
                ParserImpl parserImpl3 = ParserImpl.this;
                AbstractList abstractList2 = parserImpl3.scheduleImpl.getAuthRequestContext;
                parserImpl3.moveToNextValue = (Production) abstractList2.remove(abstractList2.size() - 1);
                AbstractList abstractList3 = ParserImpl.this.getAuthRequestContext.getAuthRequestContext;
                abstractList3.remove(abstractList3.size() - 1);
                return mappingEndEvent;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class ParseBlockMappingValue implements Production {
        private ParseBlockMappingValue() {
        }

        /* synthetic */ ParseBlockMappingValue(ParserImpl parserImpl, byte b) {
            this();
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public final Event MyBillsEntityDataFactory() {
            byte b = 0;
            if (!ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.Value)) {
                if (ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.Scalar)) {
                    ParserImpl.this.scheduleImpl.getAuthRequestContext.add(new ParseBlockMappingKey(ParserImpl.this, b));
                    return ParserImpl.this.getAuthRequestContext(true, true);
                }
                ParserImpl parserImpl = ParserImpl.this;
                parserImpl.moveToNextValue = new ParseBlockMappingKey(parserImpl, b);
                return ParserImpl.KClassImpl$Data$declaredNonStaticMembers$2(ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory().scheduleImpl);
            }
            Token authRequestContext = ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
            if (ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.Comment)) {
                ParserImpl parserImpl2 = ParserImpl.this;
                parserImpl2.moveToNextValue = new ParseBlockMappingValueComment(parserImpl2, b);
                return ParserImpl.this.moveToNextValue.MyBillsEntityDataFactory();
            } else if (!ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.Key, Token.ID.Value, Token.ID.BlockEnd)) {
                ParserImpl.this.scheduleImpl.getAuthRequestContext.add(new ParseBlockMappingKey(ParserImpl.this, b));
                return ParserImpl.this.getAuthRequestContext(true, true);
            } else {
                ParserImpl parserImpl3 = ParserImpl.this;
                parserImpl3.moveToNextValue = new ParseBlockMappingKey(parserImpl3, b);
                return ParserImpl.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.getErrorConfigVersion);
            }
        }
    }

    /* loaded from: classes6.dex */
    class ParseBlockMappingValueComment implements Production {
        List<CommentToken> KClassImpl$Data$declaredNonStaticMembers$2;

        private ParseBlockMappingValueComment() {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedList();
        }

        /* synthetic */ ParseBlockMappingValueComment(ParserImpl parserImpl, byte b) {
            this();
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public final Event MyBillsEntityDataFactory() {
            byte b;
            while (true) {
                b = 0;
                if (!ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.Comment)) {
                    break;
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2.add((CommentToken) ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext());
            }
            if (!ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.Key, Token.ID.Value, Token.ID.BlockEnd)) {
                if (this.KClassImpl$Data$declaredNonStaticMembers$2.isEmpty()) {
                    ParserImpl.this.scheduleImpl.getAuthRequestContext.add(new ParseBlockMappingKey(ParserImpl.this, b));
                    return ParserImpl.this.getAuthRequestContext(true, true);
                }
                return ParserImpl.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.remove(0));
            }
            ParserImpl parserImpl = ParserImpl.this;
            parserImpl.moveToNextValue = new ParseBlockMappingValueCommentList(this.KClassImpl$Data$declaredNonStaticMembers$2);
            return ParserImpl.KClassImpl$Data$declaredNonStaticMembers$2(ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory().scheduleImpl);
        }
    }

    /* loaded from: classes6.dex */
    class ParseBlockMappingValueCommentList implements Production {
        List<CommentToken> PlaceComponentResult;

        public ParseBlockMappingValueCommentList(List<CommentToken> list) {
            this.PlaceComponentResult = list;
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public final Event MyBillsEntityDataFactory() {
            byte b = 0;
            if (!this.PlaceComponentResult.isEmpty()) {
                return ParserImpl.PlaceComponentResult(this.PlaceComponentResult.remove(0));
            }
            return new ParseBlockMappingKey(ParserImpl.this, b).MyBillsEntityDataFactory();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class ParseFlowSequenceFirstEntry implements Production {
        private ParseFlowSequenceFirstEntry() {
        }

        /* synthetic */ ParseFlowSequenceFirstEntry(ParserImpl parserImpl, byte b) {
            this();
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public final Event MyBillsEntityDataFactory() {
            Token authRequestContext = ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
            ArrayStack arrayStack = ParserImpl.this.getAuthRequestContext;
            arrayStack.getAuthRequestContext.add(authRequestContext.scheduleImpl);
            return new ParseFlowSequenceEntry(true).MyBillsEntityDataFactory();
        }
    }

    /* loaded from: classes6.dex */
    class ParseFlowSequenceEntry implements Production {
        private final boolean PlaceComponentResult;

        public ParseFlowSequenceEntry(boolean z) {
            this.PlaceComponentResult = z;
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public final Event MyBillsEntityDataFactory() {
            byte b = 0;
            if (ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.Comment)) {
                ParserImpl parserImpl = ParserImpl.this;
                parserImpl.moveToNextValue = new ParseFlowSequenceEntry(this.PlaceComponentResult);
                return ParserImpl.PlaceComponentResult((CommentToken) ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext());
            }
            if (!ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.FlowSequenceEnd)) {
                if (!this.PlaceComponentResult) {
                    if (ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.FlowEntry)) {
                        ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
                        if (ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.Comment)) {
                            ParserImpl parserImpl2 = ParserImpl.this;
                            parserImpl2.moveToNextValue = new ParseFlowSequenceEntry(true);
                            return ParserImpl.PlaceComponentResult((CommentToken) ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext());
                        }
                    } else {
                        Token MyBillsEntityDataFactory = ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
                        AbstractList abstractList = ParserImpl.this.getAuthRequestContext.getAuthRequestContext;
                        Mark mark = (Mark) abstractList.remove(abstractList.size() - 1);
                        StringBuilder sb = new StringBuilder();
                        sb.append("expected ',' or ']', but got ");
                        sb.append(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory());
                        throw new ParserException("while parsing a flow sequence", mark, sb.toString(), MyBillsEntityDataFactory.scheduleImpl);
                    }
                }
                if (ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.Key)) {
                    Token MyBillsEntityDataFactory2 = ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
                    MappingStartEvent mappingStartEvent = new MappingStartEvent(null, null, true, MyBillsEntityDataFactory2.scheduleImpl, MyBillsEntityDataFactory2.getErrorConfigVersion, DumperOptions.FlowStyle.FLOW);
                    ParserImpl parserImpl3 = ParserImpl.this;
                    parserImpl3.moveToNextValue = new ParseFlowSequenceEntryMappingKey(parserImpl3, b);
                    return mappingStartEvent;
                } else if (!ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.FlowSequenceEnd)) {
                    ParserImpl.this.scheduleImpl.getAuthRequestContext.add(new ParseFlowSequenceEntry(false));
                    return ParserImpl.this.getAuthRequestContext(false, false);
                }
            }
            Token authRequestContext = ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
            SequenceEndEvent sequenceEndEvent = new SequenceEndEvent(authRequestContext.scheduleImpl, authRequestContext.getErrorConfigVersion);
            if (!ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.Comment)) {
                ParserImpl parserImpl4 = ParserImpl.this;
                AbstractList abstractList2 = parserImpl4.scheduleImpl.getAuthRequestContext;
                parserImpl4.moveToNextValue = (Production) abstractList2.remove(abstractList2.size() - 1);
            } else {
                ParserImpl parserImpl5 = ParserImpl.this;
                parserImpl5.moveToNextValue = new ParseFlowEndComment(parserImpl5, b);
            }
            AbstractList abstractList3 = ParserImpl.this.getAuthRequestContext.getAuthRequestContext;
            abstractList3.remove(abstractList3.size() - 1);
            return sequenceEndEvent;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class ParseFlowEndComment implements Production {
        private ParseFlowEndComment() {
        }

        /* synthetic */ ParseFlowEndComment(ParserImpl parserImpl, byte b) {
            this();
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public final Event MyBillsEntityDataFactory() {
            CommentEvent PlaceComponentResult = ParserImpl.PlaceComponentResult((CommentToken) ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext());
            if (!ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.Comment)) {
                ParserImpl parserImpl = ParserImpl.this;
                AbstractList abstractList = parserImpl.scheduleImpl.getAuthRequestContext;
                parserImpl.moveToNextValue = (Production) abstractList.remove(abstractList.size() - 1);
            }
            return PlaceComponentResult;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class ParseFlowSequenceEntryMappingKey implements Production {
        private ParseFlowSequenceEntryMappingKey() {
        }

        /* synthetic */ ParseFlowSequenceEntryMappingKey(ParserImpl parserImpl, byte b) {
            this();
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public final Event MyBillsEntityDataFactory() {
            Token authRequestContext = ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
            byte b = 0;
            if (!ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.Value, Token.ID.FlowEntry, Token.ID.FlowSequenceEnd)) {
                ParserImpl.this.scheduleImpl.getAuthRequestContext.add(new ParseFlowSequenceEntryMappingValue(ParserImpl.this, b));
                return ParserImpl.this.getAuthRequestContext(false, false);
            }
            ParserImpl parserImpl = ParserImpl.this;
            parserImpl.moveToNextValue = new ParseFlowSequenceEntryMappingValue(parserImpl, b);
            return ParserImpl.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.getErrorConfigVersion);
        }
    }

    /* loaded from: classes6.dex */
    class ParseFlowSequenceEntryMappingValue implements Production {
        private ParseFlowSequenceEntryMappingValue() {
        }

        /* synthetic */ ParseFlowSequenceEntryMappingValue(ParserImpl parserImpl, byte b) {
            this();
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public final Event MyBillsEntityDataFactory() {
            byte b = 0;
            if (ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.Value)) {
                Token authRequestContext = ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
                if (!ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.FlowEntry, Token.ID.FlowSequenceEnd)) {
                    ParserImpl.this.scheduleImpl.getAuthRequestContext.add(new ParseFlowSequenceEntryMappingEnd(ParserImpl.this, b));
                    return ParserImpl.this.getAuthRequestContext(false, false);
                }
                ParserImpl parserImpl = ParserImpl.this;
                parserImpl.moveToNextValue = new ParseFlowSequenceEntryMappingEnd(parserImpl, b);
                return ParserImpl.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.getErrorConfigVersion);
            }
            ParserImpl parserImpl2 = ParserImpl.this;
            parserImpl2.moveToNextValue = new ParseFlowSequenceEntryMappingEnd(parserImpl2, b);
            return ParserImpl.KClassImpl$Data$declaredNonStaticMembers$2(ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory().scheduleImpl);
        }
    }

    /* loaded from: classes6.dex */
    class ParseFlowSequenceEntryMappingEnd implements Production {
        private ParseFlowSequenceEntryMappingEnd() {
        }

        /* synthetic */ ParseFlowSequenceEntryMappingEnd(ParserImpl parserImpl, byte b) {
            this();
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public final Event MyBillsEntityDataFactory() {
            ParserImpl parserImpl = ParserImpl.this;
            parserImpl.moveToNextValue = new ParseFlowSequenceEntry(false);
            Token MyBillsEntityDataFactory = ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
            return new MappingEndEvent(MyBillsEntityDataFactory.scheduleImpl, MyBillsEntityDataFactory.getErrorConfigVersion);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class ParseFlowMappingFirstKey implements Production {
        private ParseFlowMappingFirstKey() {
        }

        /* synthetic */ ParseFlowMappingFirstKey(ParserImpl parserImpl, byte b) {
            this();
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public final Event MyBillsEntityDataFactory() {
            Token authRequestContext = ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
            ArrayStack arrayStack = ParserImpl.this.getAuthRequestContext;
            arrayStack.getAuthRequestContext.add(authRequestContext.scheduleImpl);
            return new ParseFlowMappingKey(true).MyBillsEntityDataFactory();
        }
    }

    /* loaded from: classes6.dex */
    class ParseFlowMappingKey implements Production {
        private final boolean getAuthRequestContext;

        public ParseFlowMappingKey(boolean z) {
            this.getAuthRequestContext = z;
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public final Event MyBillsEntityDataFactory() {
            byte b = 0;
            if (ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.Comment)) {
                ParserImpl parserImpl = ParserImpl.this;
                parserImpl.moveToNextValue = new ParseFlowMappingKey(this.getAuthRequestContext);
                return ParserImpl.PlaceComponentResult((CommentToken) ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext());
            }
            if (!ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.FlowMappingEnd)) {
                if (!this.getAuthRequestContext) {
                    if (ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.FlowEntry)) {
                        ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
                        if (ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.Comment)) {
                            ParserImpl parserImpl2 = ParserImpl.this;
                            parserImpl2.moveToNextValue = new ParseFlowMappingKey(true);
                            return ParserImpl.PlaceComponentResult((CommentToken) ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext());
                        }
                    } else {
                        Token MyBillsEntityDataFactory = ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
                        AbstractList abstractList = ParserImpl.this.getAuthRequestContext.getAuthRequestContext;
                        Mark mark = (Mark) abstractList.remove(abstractList.size() - 1);
                        StringBuilder sb = new StringBuilder();
                        sb.append("expected ',' or '}', but got ");
                        sb.append(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory());
                        throw new ParserException("while parsing a flow mapping", mark, sb.toString(), MyBillsEntityDataFactory.scheduleImpl);
                    }
                }
                if (ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.Key)) {
                    Token authRequestContext = ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
                    if (!ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.Value, Token.ID.FlowEntry, Token.ID.FlowMappingEnd)) {
                        ParserImpl.this.scheduleImpl.getAuthRequestContext.add(new ParseFlowMappingValue(ParserImpl.this, b));
                        return ParserImpl.this.getAuthRequestContext(false, false);
                    }
                    ParserImpl parserImpl3 = ParserImpl.this;
                    parserImpl3.moveToNextValue = new ParseFlowMappingValue(parserImpl3, b);
                    return ParserImpl.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.getErrorConfigVersion);
                } else if (!ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.FlowMappingEnd)) {
                    ParserImpl.this.scheduleImpl.getAuthRequestContext.add(new ParseFlowMappingEmptyValue(ParserImpl.this, b));
                    return ParserImpl.this.getAuthRequestContext(false, false);
                }
            }
            Token authRequestContext2 = ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
            MappingEndEvent mappingEndEvent = new MappingEndEvent(authRequestContext2.scheduleImpl, authRequestContext2.getErrorConfigVersion);
            AbstractList abstractList2 = ParserImpl.this.getAuthRequestContext.getAuthRequestContext;
            abstractList2.remove(abstractList2.size() - 1);
            if (!ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.Comment)) {
                ParserImpl parserImpl4 = ParserImpl.this;
                AbstractList abstractList3 = parserImpl4.scheduleImpl.getAuthRequestContext;
                parserImpl4.moveToNextValue = (Production) abstractList3.remove(abstractList3.size() - 1);
            } else {
                ParserImpl parserImpl5 = ParserImpl.this;
                parserImpl5.moveToNextValue = new ParseFlowEndComment(parserImpl5, b);
            }
            return mappingEndEvent;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class ParseFlowMappingValue implements Production {
        private ParseFlowMappingValue() {
        }

        /* synthetic */ ParseFlowMappingValue(ParserImpl parserImpl, byte b) {
            this();
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public final Event MyBillsEntityDataFactory() {
            if (ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.Value)) {
                Token authRequestContext = ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
                if (!ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.FlowEntry, Token.ID.FlowMappingEnd)) {
                    ParserImpl.this.scheduleImpl.getAuthRequestContext.add(new ParseFlowMappingKey(false));
                    return ParserImpl.this.getAuthRequestContext(false, false);
                }
                ParserImpl parserImpl = ParserImpl.this;
                parserImpl.moveToNextValue = new ParseFlowMappingKey(false);
                return ParserImpl.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.getErrorConfigVersion);
            }
            ParserImpl parserImpl2 = ParserImpl.this;
            parserImpl2.moveToNextValue = new ParseFlowMappingKey(false);
            return ParserImpl.KClassImpl$Data$declaredNonStaticMembers$2(ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory().scheduleImpl);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class ParseFlowMappingEmptyValue implements Production {
        private ParseFlowMappingEmptyValue() {
        }

        /* synthetic */ ParseFlowMappingEmptyValue(ParserImpl parserImpl, byte b) {
            this();
        }

        @Override // org.yaml.snakeyaml.parser.Production
        public final Event MyBillsEntityDataFactory() {
            ParserImpl parserImpl = ParserImpl.this;
            parserImpl.moveToNextValue = new ParseFlowMappingKey(false);
            return ParserImpl.KClassImpl$Data$declaredNonStaticMembers$2(ParserImpl.this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory().scheduleImpl);
        }
    }

    static /* synthetic */ Event KClassImpl$Data$declaredNonStaticMembers$2(Mark mark) {
        return new ScalarEvent(null, null, new ImplicitTuple(true, false), "", mark, mark, DumperOptions.ScalarStyle.PLAIN);
    }

    static /* synthetic */ CommentEvent PlaceComponentResult(CommentToken commentToken) {
        Mark mark = commentToken.scheduleImpl;
        Mark mark2 = commentToken.getErrorConfigVersion;
        return new CommentEvent(commentToken.MyBillsEntityDataFactory, commentToken.PlaceComponentResult, mark, mark2);
    }

    static /* synthetic */ VersionTagsTuple scheduleImpl(ParserImpl parserImpl) {
        HashMap hashMap = new HashMap(parserImpl.PlaceComponentResult.MyBillsEntityDataFactory);
        Iterator<String> it = MyBillsEntityDataFactory.keySet().iterator();
        while (it.hasNext()) {
            hashMap.remove(it.next());
        }
        parserImpl.PlaceComponentResult = new VersionTagsTuple(null, hashMap);
        while (parserImpl.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(Token.ID.Directive)) {
            DirectiveToken directiveToken = (DirectiveToken) parserImpl.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
            if (!directiveToken.PlaceComponentResult.equals("YAML")) {
                if (directiveToken.PlaceComponentResult.equals("TAG")) {
                    List<T> list = directiveToken.KClassImpl$Data$declaredNonStaticMembers$2;
                    String str = (String) list.get(0);
                    String str2 = (String) list.get(1);
                    if (hashMap.containsKey(str)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("duplicate tag handle ");
                        sb.append(str);
                        throw new ParserException(null, null, sb.toString(), directiveToken.scheduleImpl);
                    }
                    hashMap.put(str, str2);
                } else {
                    continue;
                }
            } else if (parserImpl.PlaceComponentResult.PlaceComponentResult != null) {
                throw new ParserException(null, null, "found duplicate YAML directive", directiveToken.scheduleImpl);
            } else {
                List<T> list2 = directiveToken.KClassImpl$Data$declaredNonStaticMembers$2;
                if (((Integer) list2.get(0)).intValue() != 1) {
                    throw new ParserException(null, null, "found incompatible YAML document (version 1.* is required)", directiveToken.scheduleImpl);
                }
                if (((Integer) list2.get(1)).intValue() == 0) {
                    parserImpl.PlaceComponentResult = new VersionTagsTuple(DumperOptions.Version.V1_0, hashMap);
                } else {
                    parserImpl.PlaceComponentResult = new VersionTagsTuple(DumperOptions.Version.V1_1, hashMap);
                }
            }
        }
        HashMap hashMap2 = new HashMap();
        if (!hashMap.isEmpty()) {
            hashMap2 = new HashMap(hashMap);
        }
        for (String str3 : MyBillsEntityDataFactory.keySet()) {
            if (!hashMap.containsKey(str3)) {
                hashMap.put(str3, MyBillsEntityDataFactory.get(str3));
            }
        }
        return new VersionTagsTuple(parserImpl.PlaceComponentResult.PlaceComponentResult, hashMap2);
    }

    @Override // org.yaml.snakeyaml.parser.Parser
    public final boolean getAuthRequestContext(Event.ID id2) {
        Production production;
        if (this.BuiltInFictitiousFunctionClassFactory == null && (production = this.moveToNextValue) != null) {
            this.BuiltInFictitiousFunctionClassFactory = production.MyBillsEntityDataFactory();
        }
        Event event = this.BuiltInFictitiousFunctionClassFactory;
        return event != null && event.getAuthRequestContext(id2);
    }

    @Override // org.yaml.snakeyaml.parser.Parser
    public final Event KClassImpl$Data$declaredNonStaticMembers$2() {
        Production production;
        if (this.BuiltInFictitiousFunctionClassFactory == null && (production = this.moveToNextValue) != null) {
            this.BuiltInFictitiousFunctionClassFactory = production.MyBillsEntityDataFactory();
        }
        Event event = this.BuiltInFictitiousFunctionClassFactory;
        this.BuiltInFictitiousFunctionClassFactory = null;
        return event;
    }
}
