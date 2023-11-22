package com.google.api;

import com.google.api.HttpRule;
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
public final class Http extends GeneratedMessageLite<Http, Builder> implements HttpOrBuilder {
    private static final Http DEFAULT_INSTANCE;
    public static final int FULLY_DECODE_RESERVED_EXPANSION_FIELD_NUMBER = 2;
    private static volatile Parser<Http> PARSER = null;
    public static final int RULES_FIELD_NUMBER = 1;
    private boolean fullyDecodeReservedExpansion_;
    private Internal.ProtobufList<HttpRule> rules_ = emptyProtobufList();

    private Http() {
    }

    @Override // com.google.api.HttpOrBuilder
    public final List<HttpRule> getRulesList() {
        return this.rules_;
    }

    public final List<? extends HttpRuleOrBuilder> getRulesOrBuilderList() {
        return this.rules_;
    }

    @Override // com.google.api.HttpOrBuilder
    public final int getRulesCount() {
        return this.rules_.size();
    }

    @Override // com.google.api.HttpOrBuilder
    public final HttpRule getRules(int i) {
        return this.rules_.get(i);
    }

    public final HttpRuleOrBuilder getRulesOrBuilder(int i) {
        return this.rules_.get(i);
    }

    private void ensureRulesIsMutable() {
        Internal.ProtobufList<HttpRule> protobufList = this.rules_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.rules_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRules(int i, HttpRule httpRule) {
        ensureRulesIsMutable();
        this.rules_.set(i, httpRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRules(HttpRule httpRule) {
        ensureRulesIsMutable();
        this.rules_.add(httpRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRules(int i, HttpRule httpRule) {
        ensureRulesIsMutable();
        this.rules_.add(i, httpRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllRules(Iterable<? extends HttpRule> iterable) {
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

    @Override // com.google.api.HttpOrBuilder
    public final boolean getFullyDecodeReservedExpansion() {
        return this.fullyDecodeReservedExpansion_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFullyDecodeReservedExpansion(boolean z) {
        this.fullyDecodeReservedExpansion_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFullyDecodeReservedExpansion() {
        this.fullyDecodeReservedExpansion_ = false;
    }

    public static Http parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Http) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Http parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Http) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Http parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Http) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Http parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Http) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Http parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Http) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Http parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Http) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Http parseFrom(InputStream inputStream) throws IOException {
        return (Http) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Http parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Http) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Http parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Http) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Http parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Http) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Http parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Http) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Http parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Http) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(Http http) {
        return DEFAULT_INSTANCE.createBuilder(http);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Http, Builder> implements HttpOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(Http.DEFAULT_INSTANCE);
        }

        @Override // com.google.api.HttpOrBuilder
        public final List<HttpRule> getRulesList() {
            return Collections.unmodifiableList(((Http) this.instance).getRulesList());
        }

        @Override // com.google.api.HttpOrBuilder
        public final int getRulesCount() {
            return ((Http) this.instance).getRulesCount();
        }

        @Override // com.google.api.HttpOrBuilder
        public final HttpRule getRules(int i) {
            return ((Http) this.instance).getRules(i);
        }

        public final Builder setRules(int i, HttpRule httpRule) {
            copyOnWrite();
            ((Http) this.instance).setRules(i, httpRule);
            return this;
        }

        public final Builder setRules(int i, HttpRule.Builder builder) {
            copyOnWrite();
            ((Http) this.instance).setRules(i, builder.build());
            return this;
        }

        public final Builder addRules(HttpRule httpRule) {
            copyOnWrite();
            ((Http) this.instance).addRules(httpRule);
            return this;
        }

        public final Builder addRules(int i, HttpRule httpRule) {
            copyOnWrite();
            ((Http) this.instance).addRules(i, httpRule);
            return this;
        }

        public final Builder addRules(HttpRule.Builder builder) {
            copyOnWrite();
            ((Http) this.instance).addRules(builder.build());
            return this;
        }

        public final Builder addRules(int i, HttpRule.Builder builder) {
            copyOnWrite();
            ((Http) this.instance).addRules(i, builder.build());
            return this;
        }

        public final Builder addAllRules(Iterable<? extends HttpRule> iterable) {
            copyOnWrite();
            ((Http) this.instance).addAllRules(iterable);
            return this;
        }

        public final Builder clearRules() {
            copyOnWrite();
            ((Http) this.instance).clearRules();
            return this;
        }

        public final Builder removeRules(int i) {
            copyOnWrite();
            ((Http) this.instance).removeRules(i);
            return this;
        }

        @Override // com.google.api.HttpOrBuilder
        public final boolean getFullyDecodeReservedExpansion() {
            return ((Http) this.instance).getFullyDecodeReservedExpansion();
        }

        public final Builder setFullyDecodeReservedExpansion(boolean z) {
            copyOnWrite();
            ((Http) this.instance).setFullyDecodeReservedExpansion(z);
            return this;
        }

        public final Builder clearFullyDecodeReservedExpansion() {
            copyOnWrite();
            ((Http) this.instance).clearFullyDecodeReservedExpansion();
            return this;
        }
    }

    /* renamed from: com.google.api.Http$1  reason: invalid class name */
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
                return new Http();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u0007", new Object[]{"rules_", HttpRule.class, "fullyDecodeReservedExpansion_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Http> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (Http.class) {
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
        Http http = new Http();
        DEFAULT_INSTANCE = http;
        GeneratedMessageLite.registerDefaultInstance(Http.class, http);
    }

    public static Http getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Http> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
