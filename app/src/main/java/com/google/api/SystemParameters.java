package com.google.api;

import com.google.api.SystemParameterRule;
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
public final class SystemParameters extends GeneratedMessageLite<SystemParameters, Builder> implements SystemParametersOrBuilder {
    private static final SystemParameters DEFAULT_INSTANCE;
    private static volatile Parser<SystemParameters> PARSER = null;
    public static final int RULES_FIELD_NUMBER = 1;
    private Internal.ProtobufList<SystemParameterRule> rules_ = emptyProtobufList();

    private SystemParameters() {
    }

    @Override // com.google.api.SystemParametersOrBuilder
    public final List<SystemParameterRule> getRulesList() {
        return this.rules_;
    }

    public final List<? extends SystemParameterRuleOrBuilder> getRulesOrBuilderList() {
        return this.rules_;
    }

    @Override // com.google.api.SystemParametersOrBuilder
    public final int getRulesCount() {
        return this.rules_.size();
    }

    @Override // com.google.api.SystemParametersOrBuilder
    public final SystemParameterRule getRules(int i) {
        return this.rules_.get(i);
    }

    public final SystemParameterRuleOrBuilder getRulesOrBuilder(int i) {
        return this.rules_.get(i);
    }

    private void ensureRulesIsMutable() {
        Internal.ProtobufList<SystemParameterRule> protobufList = this.rules_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.rules_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRules(int i, SystemParameterRule systemParameterRule) {
        ensureRulesIsMutable();
        this.rules_.set(i, systemParameterRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRules(SystemParameterRule systemParameterRule) {
        ensureRulesIsMutable();
        this.rules_.add(systemParameterRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRules(int i, SystemParameterRule systemParameterRule) {
        ensureRulesIsMutable();
        this.rules_.add(i, systemParameterRule);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllRules(Iterable<? extends SystemParameterRule> iterable) {
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

    public static SystemParameters parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (SystemParameters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static SystemParameters parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (SystemParameters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static SystemParameters parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (SystemParameters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static SystemParameters parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (SystemParameters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static SystemParameters parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (SystemParameters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static SystemParameters parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (SystemParameters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static SystemParameters parseFrom(InputStream inputStream) throws IOException {
        return (SystemParameters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SystemParameters parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SystemParameters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SystemParameters parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (SystemParameters) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static SystemParameters parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SystemParameters) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static SystemParameters parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (SystemParameters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static SystemParameters parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (SystemParameters) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(SystemParameters systemParameters) {
        return DEFAULT_INSTANCE.createBuilder(systemParameters);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<SystemParameters, Builder> implements SystemParametersOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(SystemParameters.DEFAULT_INSTANCE);
        }

        @Override // com.google.api.SystemParametersOrBuilder
        public final List<SystemParameterRule> getRulesList() {
            return Collections.unmodifiableList(((SystemParameters) this.instance).getRulesList());
        }

        @Override // com.google.api.SystemParametersOrBuilder
        public final int getRulesCount() {
            return ((SystemParameters) this.instance).getRulesCount();
        }

        @Override // com.google.api.SystemParametersOrBuilder
        public final SystemParameterRule getRules(int i) {
            return ((SystemParameters) this.instance).getRules(i);
        }

        public final Builder setRules(int i, SystemParameterRule systemParameterRule) {
            copyOnWrite();
            ((SystemParameters) this.instance).setRules(i, systemParameterRule);
            return this;
        }

        public final Builder setRules(int i, SystemParameterRule.Builder builder) {
            copyOnWrite();
            ((SystemParameters) this.instance).setRules(i, builder.build());
            return this;
        }

        public final Builder addRules(SystemParameterRule systemParameterRule) {
            copyOnWrite();
            ((SystemParameters) this.instance).addRules(systemParameterRule);
            return this;
        }

        public final Builder addRules(int i, SystemParameterRule systemParameterRule) {
            copyOnWrite();
            ((SystemParameters) this.instance).addRules(i, systemParameterRule);
            return this;
        }

        public final Builder addRules(SystemParameterRule.Builder builder) {
            copyOnWrite();
            ((SystemParameters) this.instance).addRules(builder.build());
            return this;
        }

        public final Builder addRules(int i, SystemParameterRule.Builder builder) {
            copyOnWrite();
            ((SystemParameters) this.instance).addRules(i, builder.build());
            return this;
        }

        public final Builder addAllRules(Iterable<? extends SystemParameterRule> iterable) {
            copyOnWrite();
            ((SystemParameters) this.instance).addAllRules(iterable);
            return this;
        }

        public final Builder clearRules() {
            copyOnWrite();
            ((SystemParameters) this.instance).clearRules();
            return this;
        }

        public final Builder removeRules(int i) {
            copyOnWrite();
            ((SystemParameters) this.instance).removeRules(i);
            return this;
        }
    }

    /* renamed from: com.google.api.SystemParameters$1  reason: invalid class name */
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
                return new SystemParameters();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"rules_", SystemParameterRule.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<SystemParameters> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (SystemParameters.class) {
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
        SystemParameters systemParameters = new SystemParameters();
        DEFAULT_INSTANCE = systemParameters;
        GeneratedMessageLite.registerDefaultInstance(SystemParameters.class, systemParameters);
    }

    public static SystemParameters getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<SystemParameters> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
