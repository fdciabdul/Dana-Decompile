package com.google.api;

import com.google.api.DocumentationRule;
import com.google.api.Page;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes7.dex */
public final class Documentation extends GeneratedMessageLite<Documentation, Builder> implements DocumentationOrBuilder {
    private static final Documentation DEFAULT_INSTANCE;
    public static final int DOCUMENTATION_ROOT_URL_FIELD_NUMBER = 4;
    public static final int OVERVIEW_FIELD_NUMBER = 2;
    public static final int PAGES_FIELD_NUMBER = 5;
    private static volatile Parser<Documentation> PARSER = null;
    public static final int RULES_FIELD_NUMBER = 3;
    public static final int SUMMARY_FIELD_NUMBER = 1;
    private String summary_ = "";
    private Internal.ProtobufList<Page> pages_ = emptyProtobufList();
    private Internal.ProtobufList<DocumentationRule> rules_ = emptyProtobufList();
    private String documentationRootUrl_ = "";
    private String overview_ = "";

    private Documentation() {
    }

    @Override // com.google.api.DocumentationOrBuilder
    public final String getSummary() {
        return this.summary_;
    }

    @Override // com.google.api.DocumentationOrBuilder
    public final ByteString getSummaryBytes() {
        return ByteString.copyFromUtf8(this.summary_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSummary(String str) {
        this.summary_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSummary() {
        this.summary_ = getDefaultInstance().getSummary();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSummaryBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.summary_ = byteString.toStringUtf8();
    }

    @Override // com.google.api.DocumentationOrBuilder
    public final List<Page> getPagesList() {
        return this.pages_;
    }

    public final List<? extends PageOrBuilder> getPagesOrBuilderList() {
        return this.pages_;
    }

    @Override // com.google.api.DocumentationOrBuilder
    public final int getPagesCount() {
        return this.pages_.size();
    }

    @Override // com.google.api.DocumentationOrBuilder
    public final Page getPages(int i) {
        return this.pages_.get(i);
    }

    public final PageOrBuilder getPagesOrBuilder(int i) {
        return this.pages_.get(i);
    }

    private void ensurePagesIsMutable() {
        Internal.ProtobufList<Page> protobufList = this.pages_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.pages_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPages(int i, Page page) {
        ensurePagesIsMutable();
        this.pages_.set(i, page);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPages(Page page) {
        ensurePagesIsMutable();
        this.pages_.add(page);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPages(int i, Page page) {
        ensurePagesIsMutable();
        this.pages_.add(i, page);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllPages(Iterable<? extends Page> iterable) {
        ensurePagesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.pages_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPages() {
        this.pages_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removePages(int i) {
        ensurePagesIsMutable();
        this.pages_.remove(i);
    }

    @Override // com.google.api.DocumentationOrBuilder
    public final List<DocumentationRule> getRulesList() {
        return this.rules_;
    }

    public final List<? extends DocumentationRuleOrBuilder> getRulesOrBuilderList() {
        return this.rules_;
    }

    @Override // com.google.api.DocumentationOrBuilder
    public final int getRulesCount() {
        return this.rules_.size();
    }

    @Override // com.google.api.DocumentationOrBuilder
    public final DocumentationRule getRules(int i) {
        return this.rules_.get(i);
    }

    public final DocumentationRuleOrBuilder getRulesOrBuilder(int i) {
        return this.rules_.get(i);
    }

    private void ensureRulesIsMutable() {
        Internal.ProtobufList<DocumentationRule> protobufList = this.rules_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.rules_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRules(int i, DocumentationRule documentationRule) {
        ensureRulesIsMutable();
        this.rules_.set(i, documentationRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRules(DocumentationRule documentationRule) {
        ensureRulesIsMutable();
        this.rules_.add(documentationRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRules(int i, DocumentationRule documentationRule) {
        ensureRulesIsMutable();
        this.rules_.add(i, documentationRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllRules(Iterable<? extends DocumentationRule> iterable) {
        ensureRulesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.rules_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRules() {
        this.rules_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeRules(int i) {
        ensureRulesIsMutable();
        this.rules_.remove(i);
    }

    @Override // com.google.api.DocumentationOrBuilder
    public final String getDocumentationRootUrl() {
        return this.documentationRootUrl_;
    }

    @Override // com.google.api.DocumentationOrBuilder
    public final ByteString getDocumentationRootUrlBytes() {
        return ByteString.copyFromUtf8(this.documentationRootUrl_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDocumentationRootUrl(String str) {
        this.documentationRootUrl_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDocumentationRootUrl() {
        this.documentationRootUrl_ = getDefaultInstance().getDocumentationRootUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDocumentationRootUrlBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.documentationRootUrl_ = byteString.toStringUtf8();
    }

    @Override // com.google.api.DocumentationOrBuilder
    public final String getOverview() {
        return this.overview_;
    }

    @Override // com.google.api.DocumentationOrBuilder
    public final ByteString getOverviewBytes() {
        return ByteString.copyFromUtf8(this.overview_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOverview(String str) {
        this.overview_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOverview() {
        this.overview_ = getDefaultInstance().getOverview();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOverviewBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.overview_ = byteString.toStringUtf8();
    }

    public static Documentation parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Documentation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Documentation parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Documentation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Documentation parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Documentation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Documentation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Documentation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Documentation parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Documentation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Documentation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Documentation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Documentation parseFrom(InputStream inputStream) throws IOException {
        return (Documentation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Documentation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Documentation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Documentation parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Documentation) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Documentation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Documentation) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Documentation parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Documentation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Documentation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Documentation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(Documentation documentation) {
        return DEFAULT_INSTANCE.createBuilder(documentation);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Documentation, Builder> implements DocumentationOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(Documentation.DEFAULT_INSTANCE);
        }

        @Override // com.google.api.DocumentationOrBuilder
        public final String getSummary() {
            return ((Documentation) this.instance).getSummary();
        }

        @Override // com.google.api.DocumentationOrBuilder
        public final ByteString getSummaryBytes() {
            return ((Documentation) this.instance).getSummaryBytes();
        }

        public final Builder setSummary(String str) {
            copyOnWrite();
            ((Documentation) this.instance).setSummary(str);
            return this;
        }

        public final Builder clearSummary() {
            copyOnWrite();
            ((Documentation) this.instance).clearSummary();
            return this;
        }

        public final Builder setSummaryBytes(ByteString byteString) {
            copyOnWrite();
            ((Documentation) this.instance).setSummaryBytes(byteString);
            return this;
        }

        @Override // com.google.api.DocumentationOrBuilder
        public final List<Page> getPagesList() {
            return Collections.unmodifiableList(((Documentation) this.instance).getPagesList());
        }

        @Override // com.google.api.DocumentationOrBuilder
        public final int getPagesCount() {
            return ((Documentation) this.instance).getPagesCount();
        }

        @Override // com.google.api.DocumentationOrBuilder
        public final Page getPages(int i) {
            return ((Documentation) this.instance).getPages(i);
        }

        public final Builder setPages(int i, Page page) {
            copyOnWrite();
            ((Documentation) this.instance).setPages(i, page);
            return this;
        }

        public final Builder setPages(int i, Page.Builder builder) {
            copyOnWrite();
            ((Documentation) this.instance).setPages(i, builder.build());
            return this;
        }

        public final Builder addPages(Page page) {
            copyOnWrite();
            ((Documentation) this.instance).addPages(page);
            return this;
        }

        public final Builder addPages(int i, Page page) {
            copyOnWrite();
            ((Documentation) this.instance).addPages(i, page);
            return this;
        }

        public final Builder addPages(Page.Builder builder) {
            copyOnWrite();
            ((Documentation) this.instance).addPages(builder.build());
            return this;
        }

        public final Builder addPages(int i, Page.Builder builder) {
            copyOnWrite();
            ((Documentation) this.instance).addPages(i, builder.build());
            return this;
        }

        public final Builder addAllPages(Iterable<? extends Page> iterable) {
            copyOnWrite();
            ((Documentation) this.instance).addAllPages(iterable);
            return this;
        }

        public final Builder clearPages() {
            copyOnWrite();
            ((Documentation) this.instance).clearPages();
            return this;
        }

        public final Builder removePages(int i) {
            copyOnWrite();
            ((Documentation) this.instance).removePages(i);
            return this;
        }

        @Override // com.google.api.DocumentationOrBuilder
        public final List<DocumentationRule> getRulesList() {
            return Collections.unmodifiableList(((Documentation) this.instance).getRulesList());
        }

        @Override // com.google.api.DocumentationOrBuilder
        public final int getRulesCount() {
            return ((Documentation) this.instance).getRulesCount();
        }

        @Override // com.google.api.DocumentationOrBuilder
        public final DocumentationRule getRules(int i) {
            return ((Documentation) this.instance).getRules(i);
        }

        public final Builder setRules(int i, DocumentationRule documentationRule) {
            copyOnWrite();
            ((Documentation) this.instance).setRules(i, documentationRule);
            return this;
        }

        public final Builder setRules(int i, DocumentationRule.Builder builder) {
            copyOnWrite();
            ((Documentation) this.instance).setRules(i, builder.build());
            return this;
        }

        public final Builder addRules(DocumentationRule documentationRule) {
            copyOnWrite();
            ((Documentation) this.instance).addRules(documentationRule);
            return this;
        }

        public final Builder addRules(int i, DocumentationRule documentationRule) {
            copyOnWrite();
            ((Documentation) this.instance).addRules(i, documentationRule);
            return this;
        }

        public final Builder addRules(DocumentationRule.Builder builder) {
            copyOnWrite();
            ((Documentation) this.instance).addRules(builder.build());
            return this;
        }

        public final Builder addRules(int i, DocumentationRule.Builder builder) {
            copyOnWrite();
            ((Documentation) this.instance).addRules(i, builder.build());
            return this;
        }

        public final Builder addAllRules(Iterable<? extends DocumentationRule> iterable) {
            copyOnWrite();
            ((Documentation) this.instance).addAllRules(iterable);
            return this;
        }

        public final Builder clearRules() {
            copyOnWrite();
            ((Documentation) this.instance).clearRules();
            return this;
        }

        public final Builder removeRules(int i) {
            copyOnWrite();
            ((Documentation) this.instance).removeRules(i);
            return this;
        }

        @Override // com.google.api.DocumentationOrBuilder
        public final String getDocumentationRootUrl() {
            return ((Documentation) this.instance).getDocumentationRootUrl();
        }

        @Override // com.google.api.DocumentationOrBuilder
        public final ByteString getDocumentationRootUrlBytes() {
            return ((Documentation) this.instance).getDocumentationRootUrlBytes();
        }

        public final Builder setDocumentationRootUrl(String str) {
            copyOnWrite();
            ((Documentation) this.instance).setDocumentationRootUrl(str);
            return this;
        }

        public final Builder clearDocumentationRootUrl() {
            copyOnWrite();
            ((Documentation) this.instance).clearDocumentationRootUrl();
            return this;
        }

        public final Builder setDocumentationRootUrlBytes(ByteString byteString) {
            copyOnWrite();
            ((Documentation) this.instance).setDocumentationRootUrlBytes(byteString);
            return this;
        }

        @Override // com.google.api.DocumentationOrBuilder
        public final String getOverview() {
            return ((Documentation) this.instance).getOverview();
        }

        @Override // com.google.api.DocumentationOrBuilder
        public final ByteString getOverviewBytes() {
            return ((Documentation) this.instance).getOverviewBytes();
        }

        public final Builder setOverview(String str) {
            copyOnWrite();
            ((Documentation) this.instance).setOverview(str);
            return this;
        }

        public final Builder clearOverview() {
            copyOnWrite();
            ((Documentation) this.instance).clearOverview();
            return this;
        }

        public final Builder setOverviewBytes(ByteString byteString) {
            copyOnWrite();
            ((Documentation) this.instance).setOverviewBytes(byteString);
            return this;
        }
    }

    /* renamed from: com.google.api.Documentation$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser parser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Documentation();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0002\u0000\u0001Ȉ\u0002Ȉ\u0003\u001b\u0004Ȉ\u0005\u001b", new Object[]{"summary_", "overview_", "rules_", DocumentationRule.class, "documentationRootUrl_", "pages_", Page.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Documentation> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (Documentation.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                }
                return parser2;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        Documentation documentation = new Documentation();
        DEFAULT_INSTANCE = documentation;
        GeneratedMessageLite.registerDefaultInstance(Documentation.class, documentation);
    }

    public static Documentation getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Documentation> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
