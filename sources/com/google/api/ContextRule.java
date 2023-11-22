package com.google.api;

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
public final class ContextRule extends GeneratedMessageLite<ContextRule, Builder> implements ContextRuleOrBuilder {
    public static final int ALLOWED_REQUEST_EXTENSIONS_FIELD_NUMBER = 4;
    public static final int ALLOWED_RESPONSE_EXTENSIONS_FIELD_NUMBER = 5;
    private static final ContextRule DEFAULT_INSTANCE;
    private static volatile Parser<ContextRule> PARSER = null;
    public static final int PROVIDED_FIELD_NUMBER = 3;
    public static final int REQUESTED_FIELD_NUMBER = 2;
    public static final int SELECTOR_FIELD_NUMBER = 1;
    private String selector_ = "";
    private Internal.ProtobufList<String> requested_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<String> provided_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<String> allowedRequestExtensions_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<String> allowedResponseExtensions_ = GeneratedMessageLite.emptyProtobufList();

    private ContextRule() {
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public final String getSelector() {
        return this.selector_;
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public final ByteString getSelectorBytes() {
        return ByteString.copyFromUtf8(this.selector_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelector(String str) {
        this.selector_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSelector() {
        this.selector_ = getDefaultInstance().getSelector();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelectorBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.selector_ = byteString.toStringUtf8();
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public final List<String> getRequestedList() {
        return this.requested_;
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public final int getRequestedCount() {
        return this.requested_.size();
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public final String getRequested(int i) {
        return this.requested_.get(i);
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public final ByteString getRequestedBytes(int i) {
        return ByteString.copyFromUtf8(this.requested_.get(i));
    }

    private void ensureRequestedIsMutable() {
        Internal.ProtobufList<String> protobufList = this.requested_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.requested_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequested(int i, String str) {
        ensureRequestedIsMutable();
        this.requested_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRequested(String str) {
        ensureRequestedIsMutable();
        this.requested_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllRequested(Iterable<String> iterable) {
        ensureRequestedIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.requested_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRequested() {
        this.requested_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRequestedBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        ensureRequestedIsMutable();
        this.requested_.add(byteString.toStringUtf8());
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public final List<String> getProvidedList() {
        return this.provided_;
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public final int getProvidedCount() {
        return this.provided_.size();
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public final String getProvided(int i) {
        return this.provided_.get(i);
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public final ByteString getProvidedBytes(int i) {
        return ByteString.copyFromUtf8(this.provided_.get(i));
    }

    private void ensureProvidedIsMutable() {
        Internal.ProtobufList<String> protobufList = this.provided_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.provided_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProvided(int i, String str) {
        ensureProvidedIsMutable();
        this.provided_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addProvided(String str) {
        ensureProvidedIsMutable();
        this.provided_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllProvided(Iterable<String> iterable) {
        ensureProvidedIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.provided_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProvided() {
        this.provided_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addProvidedBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        ensureProvidedIsMutable();
        this.provided_.add(byteString.toStringUtf8());
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public final List<String> getAllowedRequestExtensionsList() {
        return this.allowedRequestExtensions_;
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public final int getAllowedRequestExtensionsCount() {
        return this.allowedRequestExtensions_.size();
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public final String getAllowedRequestExtensions(int i) {
        return this.allowedRequestExtensions_.get(i);
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public final ByteString getAllowedRequestExtensionsBytes(int i) {
        return ByteString.copyFromUtf8(this.allowedRequestExtensions_.get(i));
    }

    private void ensureAllowedRequestExtensionsIsMutable() {
        Internal.ProtobufList<String> protobufList = this.allowedRequestExtensions_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.allowedRequestExtensions_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAllowedRequestExtensions(int i, String str) {
        ensureAllowedRequestExtensionsIsMutable();
        this.allowedRequestExtensions_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllowedRequestExtensions(String str) {
        ensureAllowedRequestExtensionsIsMutable();
        this.allowedRequestExtensions_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllAllowedRequestExtensions(Iterable<String> iterable) {
        ensureAllowedRequestExtensionsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.allowedRequestExtensions_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAllowedRequestExtensions() {
        this.allowedRequestExtensions_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllowedRequestExtensionsBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        ensureAllowedRequestExtensionsIsMutable();
        this.allowedRequestExtensions_.add(byteString.toStringUtf8());
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public final List<String> getAllowedResponseExtensionsList() {
        return this.allowedResponseExtensions_;
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public final int getAllowedResponseExtensionsCount() {
        return this.allowedResponseExtensions_.size();
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public final String getAllowedResponseExtensions(int i) {
        return this.allowedResponseExtensions_.get(i);
    }

    @Override // com.google.api.ContextRuleOrBuilder
    public final ByteString getAllowedResponseExtensionsBytes(int i) {
        return ByteString.copyFromUtf8(this.allowedResponseExtensions_.get(i));
    }

    private void ensureAllowedResponseExtensionsIsMutable() {
        Internal.ProtobufList<String> protobufList = this.allowedResponseExtensions_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.allowedResponseExtensions_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAllowedResponseExtensions(int i, String str) {
        ensureAllowedResponseExtensionsIsMutable();
        this.allowedResponseExtensions_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllowedResponseExtensions(String str) {
        ensureAllowedResponseExtensionsIsMutable();
        this.allowedResponseExtensions_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllAllowedResponseExtensions(Iterable<String> iterable) {
        ensureAllowedResponseExtensionsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.allowedResponseExtensions_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAllowedResponseExtensions() {
        this.allowedResponseExtensions_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllowedResponseExtensionsBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        ensureAllowedResponseExtensionsIsMutable();
        this.allowedResponseExtensions_.add(byteString.toStringUtf8());
    }

    public static ContextRule parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ContextRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static ContextRule parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ContextRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ContextRule parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ContextRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ContextRule parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ContextRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ContextRule parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ContextRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ContextRule parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ContextRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ContextRule parseFrom(InputStream inputStream) throws IOException {
        return (ContextRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ContextRule parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ContextRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ContextRule parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ContextRule) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ContextRule parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ContextRule) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ContextRule parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ContextRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ContextRule parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ContextRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(ContextRule contextRule) {
        return DEFAULT_INSTANCE.createBuilder(contextRule);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<ContextRule, Builder> implements ContextRuleOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(ContextRule.DEFAULT_INSTANCE);
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public final String getSelector() {
            return ((ContextRule) this.instance).getSelector();
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public final ByteString getSelectorBytes() {
            return ((ContextRule) this.instance).getSelectorBytes();
        }

        public final Builder setSelector(String str) {
            copyOnWrite();
            ((ContextRule) this.instance).setSelector(str);
            return this;
        }

        public final Builder clearSelector() {
            copyOnWrite();
            ((ContextRule) this.instance).clearSelector();
            return this;
        }

        public final Builder setSelectorBytes(ByteString byteString) {
            copyOnWrite();
            ((ContextRule) this.instance).setSelectorBytes(byteString);
            return this;
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public final List<String> getRequestedList() {
            return Collections.unmodifiableList(((ContextRule) this.instance).getRequestedList());
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public final int getRequestedCount() {
            return ((ContextRule) this.instance).getRequestedCount();
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public final String getRequested(int i) {
            return ((ContextRule) this.instance).getRequested(i);
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public final ByteString getRequestedBytes(int i) {
            return ((ContextRule) this.instance).getRequestedBytes(i);
        }

        public final Builder setRequested(int i, String str) {
            copyOnWrite();
            ((ContextRule) this.instance).setRequested(i, str);
            return this;
        }

        public final Builder addRequested(String str) {
            copyOnWrite();
            ((ContextRule) this.instance).addRequested(str);
            return this;
        }

        public final Builder addAllRequested(Iterable<String> iterable) {
            copyOnWrite();
            ((ContextRule) this.instance).addAllRequested(iterable);
            return this;
        }

        public final Builder clearRequested() {
            copyOnWrite();
            ((ContextRule) this.instance).clearRequested();
            return this;
        }

        public final Builder addRequestedBytes(ByteString byteString) {
            copyOnWrite();
            ((ContextRule) this.instance).addRequestedBytes(byteString);
            return this;
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public final List<String> getProvidedList() {
            return Collections.unmodifiableList(((ContextRule) this.instance).getProvidedList());
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public final int getProvidedCount() {
            return ((ContextRule) this.instance).getProvidedCount();
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public final String getProvided(int i) {
            return ((ContextRule) this.instance).getProvided(i);
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public final ByteString getProvidedBytes(int i) {
            return ((ContextRule) this.instance).getProvidedBytes(i);
        }

        public final Builder setProvided(int i, String str) {
            copyOnWrite();
            ((ContextRule) this.instance).setProvided(i, str);
            return this;
        }

        public final Builder addProvided(String str) {
            copyOnWrite();
            ((ContextRule) this.instance).addProvided(str);
            return this;
        }

        public final Builder addAllProvided(Iterable<String> iterable) {
            copyOnWrite();
            ((ContextRule) this.instance).addAllProvided(iterable);
            return this;
        }

        public final Builder clearProvided() {
            copyOnWrite();
            ((ContextRule) this.instance).clearProvided();
            return this;
        }

        public final Builder addProvidedBytes(ByteString byteString) {
            copyOnWrite();
            ((ContextRule) this.instance).addProvidedBytes(byteString);
            return this;
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public final List<String> getAllowedRequestExtensionsList() {
            return Collections.unmodifiableList(((ContextRule) this.instance).getAllowedRequestExtensionsList());
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public final int getAllowedRequestExtensionsCount() {
            return ((ContextRule) this.instance).getAllowedRequestExtensionsCount();
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public final String getAllowedRequestExtensions(int i) {
            return ((ContextRule) this.instance).getAllowedRequestExtensions(i);
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public final ByteString getAllowedRequestExtensionsBytes(int i) {
            return ((ContextRule) this.instance).getAllowedRequestExtensionsBytes(i);
        }

        public final Builder setAllowedRequestExtensions(int i, String str) {
            copyOnWrite();
            ((ContextRule) this.instance).setAllowedRequestExtensions(i, str);
            return this;
        }

        public final Builder addAllowedRequestExtensions(String str) {
            copyOnWrite();
            ((ContextRule) this.instance).addAllowedRequestExtensions(str);
            return this;
        }

        public final Builder addAllAllowedRequestExtensions(Iterable<String> iterable) {
            copyOnWrite();
            ((ContextRule) this.instance).addAllAllowedRequestExtensions(iterable);
            return this;
        }

        public final Builder clearAllowedRequestExtensions() {
            copyOnWrite();
            ((ContextRule) this.instance).clearAllowedRequestExtensions();
            return this;
        }

        public final Builder addAllowedRequestExtensionsBytes(ByteString byteString) {
            copyOnWrite();
            ((ContextRule) this.instance).addAllowedRequestExtensionsBytes(byteString);
            return this;
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public final List<String> getAllowedResponseExtensionsList() {
            return Collections.unmodifiableList(((ContextRule) this.instance).getAllowedResponseExtensionsList());
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public final int getAllowedResponseExtensionsCount() {
            return ((ContextRule) this.instance).getAllowedResponseExtensionsCount();
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public final String getAllowedResponseExtensions(int i) {
            return ((ContextRule) this.instance).getAllowedResponseExtensions(i);
        }

        @Override // com.google.api.ContextRuleOrBuilder
        public final ByteString getAllowedResponseExtensionsBytes(int i) {
            return ((ContextRule) this.instance).getAllowedResponseExtensionsBytes(i);
        }

        public final Builder setAllowedResponseExtensions(int i, String str) {
            copyOnWrite();
            ((ContextRule) this.instance).setAllowedResponseExtensions(i, str);
            return this;
        }

        public final Builder addAllowedResponseExtensions(String str) {
            copyOnWrite();
            ((ContextRule) this.instance).addAllowedResponseExtensions(str);
            return this;
        }

        public final Builder addAllAllowedResponseExtensions(Iterable<String> iterable) {
            copyOnWrite();
            ((ContextRule) this.instance).addAllAllowedResponseExtensions(iterable);
            return this;
        }

        public final Builder clearAllowedResponseExtensions() {
            copyOnWrite();
            ((ContextRule) this.instance).clearAllowedResponseExtensions();
            return this;
        }

        public final Builder addAllowedResponseExtensionsBytes(ByteString byteString) {
            copyOnWrite();
            ((ContextRule) this.instance).addAllowedResponseExtensionsBytes(byteString);
            return this;
        }
    }

    /* renamed from: com.google.api.ContextRule$1  reason: invalid class name */
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
                return new ContextRule();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0004\u0000\u0001Ȉ\u0002Ț\u0003Ț\u0004Ț\u0005Ț", new Object[]{"selector_", "requested_", "provided_", "allowedRequestExtensions_", "allowedResponseExtensions_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ContextRule> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (ContextRule.class) {
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
        ContextRule contextRule = new ContextRule();
        DEFAULT_INSTANCE = contextRule;
        GeneratedMessageLite.registerDefaultInstance(ContextRule.class, contextRule);
    }

    public static ContextRule getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<ContextRule> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
