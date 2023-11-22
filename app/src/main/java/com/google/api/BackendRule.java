package com.google.api;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.iap.ac.android.acs.plugin.utils.AuthCodeUtil;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public final class BackendRule extends GeneratedMessageLite<BackendRule, Builder> implements BackendRuleOrBuilder {
    public static final int ADDRESS_FIELD_NUMBER = 2;
    public static final int DEADLINE_FIELD_NUMBER = 3;
    private static final BackendRule DEFAULT_INSTANCE;
    public static final int DISABLE_AUTH_FIELD_NUMBER = 8;
    public static final int JWT_AUDIENCE_FIELD_NUMBER = 7;
    public static final int MIN_DEADLINE_FIELD_NUMBER = 4;
    public static final int OPERATION_DEADLINE_FIELD_NUMBER = 5;
    private static volatile Parser<BackendRule> PARSER = null;
    public static final int PATH_TRANSLATION_FIELD_NUMBER = 6;
    public static final int PROTOCOL_FIELD_NUMBER = 9;
    public static final int SELECTOR_FIELD_NUMBER = 1;
    private Object authentication_;
    private double deadline_;
    private double minDeadline_;
    private double operationDeadline_;
    private int pathTranslation_;
    private int authenticationCase_ = 0;
    private String selector_ = "";
    private String address_ = "";
    private String protocol_ = "";

    private BackendRule() {
    }

    /* loaded from: classes7.dex */
    public enum PathTranslation implements Internal.EnumLite {
        PATH_TRANSLATION_UNSPECIFIED(0),
        CONSTANT_ADDRESS(1),
        APPEND_PATH_TO_ADDRESS(2),
        UNRECOGNIZED(-1);

        public static final int APPEND_PATH_TO_ADDRESS_VALUE = 2;
        public static final int CONSTANT_ADDRESS_VALUE = 1;
        public static final int PATH_TRANSLATION_UNSPECIFIED_VALUE = 0;
        private static final Internal.EnumLiteMap<PathTranslation> internalValueMap = new Internal.EnumLiteMap<PathTranslation>() { // from class: com.google.api.BackendRule.PathTranslation.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public PathTranslation findValueByNumber(int i) {
                return PathTranslation.forNumber(i);
            }
        };
        private final int value;

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) {
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
            return this.value;
        }

        @Deprecated
        public static PathTranslation valueOf(int i) {
            return forNumber(i);
        }

        public static PathTranslation forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return APPEND_PATH_TO_ADDRESS;
                }
                return CONSTANT_ADDRESS;
            }
            return PATH_TRANSLATION_UNSPECIFIED;
        }

        public static Internal.EnumLiteMap<PathTranslation> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return PathTranslationVerifier.INSTANCE;
        }

        /* loaded from: classes7.dex */
        static final class PathTranslationVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new PathTranslationVerifier();

            private PathTranslationVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public final boolean isInRange(int i) {
                return PathTranslation.forNumber(i) != null;
            }
        }

        PathTranslation(int i) {
            this.value = i;
        }
    }

    /* loaded from: classes7.dex */
    public enum AuthenticationCase {
        JWT_AUDIENCE(7),
        DISABLE_AUTH(8),
        AUTHENTICATION_NOT_SET(0);

        private final int value;

        AuthenticationCase(int i) {
            this.value = i;
        }

        @Deprecated
        public static AuthenticationCase valueOf(int i) {
            return forNumber(i);
        }

        public static AuthenticationCase forNumber(int i) {
            if (i != 0) {
                if (i != 7) {
                    if (i != 8) {
                        return null;
                    }
                    return DISABLE_AUTH;
                }
                return JWT_AUDIENCE;
            }
            return AUTHENTICATION_NOT_SET;
        }

        public final int getNumber() {
            return this.value;
        }
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public final AuthenticationCase getAuthenticationCase() {
        return AuthenticationCase.forNumber(this.authenticationCase_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAuthentication() {
        this.authenticationCase_ = 0;
        this.authentication_ = null;
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public final String getSelector() {
        return this.selector_;
    }

    @Override // com.google.api.BackendRuleOrBuilder
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

    @Override // com.google.api.BackendRuleOrBuilder
    public final String getAddress() {
        return this.address_;
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public final ByteString getAddressBytes() {
        return ByteString.copyFromUtf8(this.address_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAddress(String str) {
        this.address_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAddress() {
        this.address_ = getDefaultInstance().getAddress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAddressBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.address_ = byteString.toStringUtf8();
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public final double getDeadline() {
        return this.deadline_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDeadline(double d) {
        this.deadline_ = d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDeadline() {
        this.deadline_ = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public final double getMinDeadline() {
        return this.minDeadline_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMinDeadline(double d) {
        this.minDeadline_ = d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMinDeadline() {
        this.minDeadline_ = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public final double getOperationDeadline() {
        return this.operationDeadline_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOperationDeadline(double d) {
        this.operationDeadline_ = d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOperationDeadline() {
        this.operationDeadline_ = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public final int getPathTranslationValue() {
        return this.pathTranslation_;
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public final PathTranslation getPathTranslation() {
        PathTranslation forNumber = PathTranslation.forNumber(this.pathTranslation_);
        return forNumber == null ? PathTranslation.UNRECOGNIZED : forNumber;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPathTranslationValue(int i) {
        this.pathTranslation_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPathTranslation(PathTranslation pathTranslation) {
        this.pathTranslation_ = pathTranslation.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPathTranslation() {
        this.pathTranslation_ = 0;
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public final String getJwtAudience() {
        return this.authenticationCase_ == 7 ? (String) this.authentication_ : "";
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public final ByteString getJwtAudienceBytes() {
        return ByteString.copyFromUtf8(this.authenticationCase_ == 7 ? (String) this.authentication_ : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJwtAudience(String str) {
        this.authenticationCase_ = 7;
        this.authentication_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearJwtAudience() {
        if (this.authenticationCase_ == 7) {
            this.authenticationCase_ = 0;
            this.authentication_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJwtAudienceBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.authentication_ = byteString.toStringUtf8();
        this.authenticationCase_ = 7;
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public final boolean getDisableAuth() {
        if (this.authenticationCase_ == 8) {
            return ((Boolean) this.authentication_).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisableAuth(boolean z) {
        this.authenticationCase_ = 8;
        this.authentication_ = Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDisableAuth() {
        if (this.authenticationCase_ == 8) {
            this.authenticationCase_ = 0;
            this.authentication_ = null;
        }
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public final String getProtocol() {
        return this.protocol_;
    }

    @Override // com.google.api.BackendRuleOrBuilder
    public final ByteString getProtocolBytes() {
        return ByteString.copyFromUtf8(this.protocol_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProtocol(String str) {
        this.protocol_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProtocol() {
        this.protocol_ = getDefaultInstance().getProtocol();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProtocolBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.protocol_ = byteString.toStringUtf8();
    }

    public static BackendRule parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (BackendRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static BackendRule parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BackendRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static BackendRule parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (BackendRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static BackendRule parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BackendRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static BackendRule parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (BackendRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static BackendRule parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BackendRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static BackendRule parseFrom(InputStream inputStream) throws IOException {
        return (BackendRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BackendRule parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BackendRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BackendRule parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (BackendRule) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static BackendRule parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BackendRule) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BackendRule parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (BackendRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static BackendRule parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BackendRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(BackendRule backendRule) {
        return DEFAULT_INSTANCE.createBuilder(backendRule);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<BackendRule, Builder> implements BackendRuleOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(BackendRule.DEFAULT_INSTANCE);
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public final AuthenticationCase getAuthenticationCase() {
            return ((BackendRule) this.instance).getAuthenticationCase();
        }

        public final Builder clearAuthentication() {
            copyOnWrite();
            ((BackendRule) this.instance).clearAuthentication();
            return this;
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public final String getSelector() {
            return ((BackendRule) this.instance).getSelector();
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public final ByteString getSelectorBytes() {
            return ((BackendRule) this.instance).getSelectorBytes();
        }

        public final Builder setSelector(String str) {
            copyOnWrite();
            ((BackendRule) this.instance).setSelector(str);
            return this;
        }

        public final Builder clearSelector() {
            copyOnWrite();
            ((BackendRule) this.instance).clearSelector();
            return this;
        }

        public final Builder setSelectorBytes(ByteString byteString) {
            copyOnWrite();
            ((BackendRule) this.instance).setSelectorBytes(byteString);
            return this;
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public final String getAddress() {
            return ((BackendRule) this.instance).getAddress();
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public final ByteString getAddressBytes() {
            return ((BackendRule) this.instance).getAddressBytes();
        }

        public final Builder setAddress(String str) {
            copyOnWrite();
            ((BackendRule) this.instance).setAddress(str);
            return this;
        }

        public final Builder clearAddress() {
            copyOnWrite();
            ((BackendRule) this.instance).clearAddress();
            return this;
        }

        public final Builder setAddressBytes(ByteString byteString) {
            copyOnWrite();
            ((BackendRule) this.instance).setAddressBytes(byteString);
            return this;
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public final double getDeadline() {
            return ((BackendRule) this.instance).getDeadline();
        }

        public final Builder setDeadline(double d) {
            copyOnWrite();
            ((BackendRule) this.instance).setDeadline(d);
            return this;
        }

        public final Builder clearDeadline() {
            copyOnWrite();
            ((BackendRule) this.instance).clearDeadline();
            return this;
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public final double getMinDeadline() {
            return ((BackendRule) this.instance).getMinDeadline();
        }

        public final Builder setMinDeadline(double d) {
            copyOnWrite();
            ((BackendRule) this.instance).setMinDeadline(d);
            return this;
        }

        public final Builder clearMinDeadline() {
            copyOnWrite();
            ((BackendRule) this.instance).clearMinDeadline();
            return this;
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public final double getOperationDeadline() {
            return ((BackendRule) this.instance).getOperationDeadline();
        }

        public final Builder setOperationDeadline(double d) {
            copyOnWrite();
            ((BackendRule) this.instance).setOperationDeadline(d);
            return this;
        }

        public final Builder clearOperationDeadline() {
            copyOnWrite();
            ((BackendRule) this.instance).clearOperationDeadline();
            return this;
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public final int getPathTranslationValue() {
            return ((BackendRule) this.instance).getPathTranslationValue();
        }

        public final Builder setPathTranslationValue(int i) {
            copyOnWrite();
            ((BackendRule) this.instance).setPathTranslationValue(i);
            return this;
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public final PathTranslation getPathTranslation() {
            return ((BackendRule) this.instance).getPathTranslation();
        }

        public final Builder setPathTranslation(PathTranslation pathTranslation) {
            copyOnWrite();
            ((BackendRule) this.instance).setPathTranslation(pathTranslation);
            return this;
        }

        public final Builder clearPathTranslation() {
            copyOnWrite();
            ((BackendRule) this.instance).clearPathTranslation();
            return this;
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public final String getJwtAudience() {
            return ((BackendRule) this.instance).getJwtAudience();
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public final ByteString getJwtAudienceBytes() {
            return ((BackendRule) this.instance).getJwtAudienceBytes();
        }

        public final Builder setJwtAudience(String str) {
            copyOnWrite();
            ((BackendRule) this.instance).setJwtAudience(str);
            return this;
        }

        public final Builder clearJwtAudience() {
            copyOnWrite();
            ((BackendRule) this.instance).clearJwtAudience();
            return this;
        }

        public final Builder setJwtAudienceBytes(ByteString byteString) {
            copyOnWrite();
            ((BackendRule) this.instance).setJwtAudienceBytes(byteString);
            return this;
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public final boolean getDisableAuth() {
            return ((BackendRule) this.instance).getDisableAuth();
        }

        public final Builder setDisableAuth(boolean z) {
            copyOnWrite();
            ((BackendRule) this.instance).setDisableAuth(z);
            return this;
        }

        public final Builder clearDisableAuth() {
            copyOnWrite();
            ((BackendRule) this.instance).clearDisableAuth();
            return this;
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public final String getProtocol() {
            return ((BackendRule) this.instance).getProtocol();
        }

        @Override // com.google.api.BackendRuleOrBuilder
        public final ByteString getProtocolBytes() {
            return ((BackendRule) this.instance).getProtocolBytes();
        }

        public final Builder setProtocol(String str) {
            copyOnWrite();
            ((BackendRule) this.instance).setProtocol(str);
            return this;
        }

        public final Builder clearProtocol() {
            copyOnWrite();
            ((BackendRule) this.instance).clearProtocol();
            return this;
        }

        public final Builder setProtocolBytes(ByteString byteString) {
            copyOnWrite();
            ((BackendRule) this.instance).setProtocolBytes(byteString);
            return this;
        }
    }

    /* renamed from: com.google.api.BackendRule$1  reason: invalid class name */
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
                return new BackendRule();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\t\u0001\u0000\u0001\t\t\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0000\u0004\u0000\u0005\u0000\u0006\f\u0007Ȼ\u0000\b:\u0000\tȈ", new Object[]{AuthCodeUtil.SP_KEY_PREF, "authenticationCase_", "selector_", "address_", "deadline_", "minDeadline_", "operationDeadline_", "pathTranslation_", "protocol_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<BackendRule> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (BackendRule.class) {
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
        BackendRule backendRule = new BackendRule();
        DEFAULT_INSTANCE = backendRule;
        GeneratedMessageLite.registerDefaultInstance(BackendRule.class, backendRule);
    }

    public static BackendRule getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<BackendRule> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
