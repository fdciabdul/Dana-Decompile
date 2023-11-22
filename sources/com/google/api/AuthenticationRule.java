package com.google.api;

import com.google.api.AuthRequirement;
import com.google.api.OAuthRequirements;
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
public final class AuthenticationRule extends GeneratedMessageLite<AuthenticationRule, Builder> implements AuthenticationRuleOrBuilder {
    public static final int ALLOW_WITHOUT_CREDENTIAL_FIELD_NUMBER = 5;
    private static final AuthenticationRule DEFAULT_INSTANCE;
    public static final int OAUTH_FIELD_NUMBER = 2;
    private static volatile Parser<AuthenticationRule> PARSER = null;
    public static final int REQUIREMENTS_FIELD_NUMBER = 7;
    public static final int SELECTOR_FIELD_NUMBER = 1;
    private boolean allowWithoutCredential_;
    private OAuthRequirements oauth_;
    private String selector_ = "";
    private Internal.ProtobufList<AuthRequirement> requirements_ = emptyProtobufList();

    private AuthenticationRule() {
    }

    @Override // com.google.api.AuthenticationRuleOrBuilder
    public final String getSelector() {
        return this.selector_;
    }

    @Override // com.google.api.AuthenticationRuleOrBuilder
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

    @Override // com.google.api.AuthenticationRuleOrBuilder
    public final boolean hasOauth() {
        return this.oauth_ != null;
    }

    @Override // com.google.api.AuthenticationRuleOrBuilder
    public final OAuthRequirements getOauth() {
        OAuthRequirements oAuthRequirements = this.oauth_;
        return oAuthRequirements == null ? OAuthRequirements.getDefaultInstance() : oAuthRequirements;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOauth(OAuthRequirements oAuthRequirements) {
        this.oauth_ = oAuthRequirements;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeOauth(OAuthRequirements oAuthRequirements) {
        OAuthRequirements oAuthRequirements2 = this.oauth_;
        if (oAuthRequirements2 != null && oAuthRequirements2 != OAuthRequirements.getDefaultInstance()) {
            this.oauth_ = OAuthRequirements.newBuilder(this.oauth_).mergeFrom((OAuthRequirements.Builder) oAuthRequirements).buildPartial();
        } else {
            this.oauth_ = oAuthRequirements;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOauth() {
        this.oauth_ = null;
    }

    @Override // com.google.api.AuthenticationRuleOrBuilder
    public final boolean getAllowWithoutCredential() {
        return this.allowWithoutCredential_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAllowWithoutCredential(boolean z) {
        this.allowWithoutCredential_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAllowWithoutCredential() {
        this.allowWithoutCredential_ = false;
    }

    @Override // com.google.api.AuthenticationRuleOrBuilder
    public final List<AuthRequirement> getRequirementsList() {
        return this.requirements_;
    }

    public final List<? extends AuthRequirementOrBuilder> getRequirementsOrBuilderList() {
        return this.requirements_;
    }

    @Override // com.google.api.AuthenticationRuleOrBuilder
    public final int getRequirementsCount() {
        return this.requirements_.size();
    }

    @Override // com.google.api.AuthenticationRuleOrBuilder
    public final AuthRequirement getRequirements(int i) {
        return this.requirements_.get(i);
    }

    public final AuthRequirementOrBuilder getRequirementsOrBuilder(int i) {
        return this.requirements_.get(i);
    }

    private void ensureRequirementsIsMutable() {
        Internal.ProtobufList<AuthRequirement> protobufList = this.requirements_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.requirements_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequirements(int i, AuthRequirement authRequirement) {
        ensureRequirementsIsMutable();
        this.requirements_.set(i, authRequirement);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRequirements(AuthRequirement authRequirement) {
        ensureRequirementsIsMutable();
        this.requirements_.add(authRequirement);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRequirements(int i, AuthRequirement authRequirement) {
        ensureRequirementsIsMutable();
        this.requirements_.add(i, authRequirement);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllRequirements(Iterable<? extends AuthRequirement> iterable) {
        ensureRequirementsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.requirements_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRequirements() {
        this.requirements_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeRequirements(int i) {
        ensureRequirementsIsMutable();
        this.requirements_.remove(i);
    }

    public static AuthenticationRule parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (AuthenticationRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static AuthenticationRule parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AuthenticationRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static AuthenticationRule parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (AuthenticationRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static AuthenticationRule parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AuthenticationRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AuthenticationRule parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (AuthenticationRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AuthenticationRule parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AuthenticationRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static AuthenticationRule parseFrom(InputStream inputStream) throws IOException {
        return (AuthenticationRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthenticationRule parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuthenticationRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AuthenticationRule parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AuthenticationRule) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthenticationRule parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuthenticationRule) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AuthenticationRule parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (AuthenticationRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AuthenticationRule parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuthenticationRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(AuthenticationRule authenticationRule) {
        return DEFAULT_INSTANCE.createBuilder(authenticationRule);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<AuthenticationRule, Builder> implements AuthenticationRuleOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(AuthenticationRule.DEFAULT_INSTANCE);
        }

        @Override // com.google.api.AuthenticationRuleOrBuilder
        public final String getSelector() {
            return ((AuthenticationRule) this.instance).getSelector();
        }

        @Override // com.google.api.AuthenticationRuleOrBuilder
        public final ByteString getSelectorBytes() {
            return ((AuthenticationRule) this.instance).getSelectorBytes();
        }

        public final Builder setSelector(String str) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).setSelector(str);
            return this;
        }

        public final Builder clearSelector() {
            copyOnWrite();
            ((AuthenticationRule) this.instance).clearSelector();
            return this;
        }

        public final Builder setSelectorBytes(ByteString byteString) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).setSelectorBytes(byteString);
            return this;
        }

        @Override // com.google.api.AuthenticationRuleOrBuilder
        public final boolean hasOauth() {
            return ((AuthenticationRule) this.instance).hasOauth();
        }

        @Override // com.google.api.AuthenticationRuleOrBuilder
        public final OAuthRequirements getOauth() {
            return ((AuthenticationRule) this.instance).getOauth();
        }

        public final Builder setOauth(OAuthRequirements oAuthRequirements) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).setOauth(oAuthRequirements);
            return this;
        }

        public final Builder setOauth(OAuthRequirements.Builder builder) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).setOauth(builder.build());
            return this;
        }

        public final Builder mergeOauth(OAuthRequirements oAuthRequirements) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).mergeOauth(oAuthRequirements);
            return this;
        }

        public final Builder clearOauth() {
            copyOnWrite();
            ((AuthenticationRule) this.instance).clearOauth();
            return this;
        }

        @Override // com.google.api.AuthenticationRuleOrBuilder
        public final boolean getAllowWithoutCredential() {
            return ((AuthenticationRule) this.instance).getAllowWithoutCredential();
        }

        public final Builder setAllowWithoutCredential(boolean z) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).setAllowWithoutCredential(z);
            return this;
        }

        public final Builder clearAllowWithoutCredential() {
            copyOnWrite();
            ((AuthenticationRule) this.instance).clearAllowWithoutCredential();
            return this;
        }

        @Override // com.google.api.AuthenticationRuleOrBuilder
        public final List<AuthRequirement> getRequirementsList() {
            return Collections.unmodifiableList(((AuthenticationRule) this.instance).getRequirementsList());
        }

        @Override // com.google.api.AuthenticationRuleOrBuilder
        public final int getRequirementsCount() {
            return ((AuthenticationRule) this.instance).getRequirementsCount();
        }

        @Override // com.google.api.AuthenticationRuleOrBuilder
        public final AuthRequirement getRequirements(int i) {
            return ((AuthenticationRule) this.instance).getRequirements(i);
        }

        public final Builder setRequirements(int i, AuthRequirement authRequirement) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).setRequirements(i, authRequirement);
            return this;
        }

        public final Builder setRequirements(int i, AuthRequirement.Builder builder) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).setRequirements(i, builder.build());
            return this;
        }

        public final Builder addRequirements(AuthRequirement authRequirement) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).addRequirements(authRequirement);
            return this;
        }

        public final Builder addRequirements(int i, AuthRequirement authRequirement) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).addRequirements(i, authRequirement);
            return this;
        }

        public final Builder addRequirements(AuthRequirement.Builder builder) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).addRequirements(builder.build());
            return this;
        }

        public final Builder addRequirements(int i, AuthRequirement.Builder builder) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).addRequirements(i, builder.build());
            return this;
        }

        public final Builder addAllRequirements(Iterable<? extends AuthRequirement> iterable) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).addAllRequirements(iterable);
            return this;
        }

        public final Builder clearRequirements() {
            copyOnWrite();
            ((AuthenticationRule) this.instance).clearRequirements();
            return this;
        }

        public final Builder removeRequirements(int i) {
            copyOnWrite();
            ((AuthenticationRule) this.instance).removeRequirements(i);
            return this;
        }
    }

    /* renamed from: com.google.api.AuthenticationRule$1  reason: invalid class name */
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
                return new AuthenticationRule();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0007\u0004\u0000\u0001\u0000\u0001Ȉ\u0002\t\u0005\u0007\u0007\u001b", new Object[]{"selector_", "oauth_", "allowWithoutCredential_", "requirements_", AuthRequirement.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AuthenticationRule> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (AuthenticationRule.class) {
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
        AuthenticationRule authenticationRule = new AuthenticationRule();
        DEFAULT_INSTANCE = authenticationRule;
        GeneratedMessageLite.registerDefaultInstance(AuthenticationRule.class, authenticationRule);
    }

    public static AuthenticationRule getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AuthenticationRule> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
