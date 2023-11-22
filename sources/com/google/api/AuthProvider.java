package com.google.api;

import com.google.api.JwtLocation;
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
public final class AuthProvider extends GeneratedMessageLite<AuthProvider, Builder> implements AuthProviderOrBuilder {
    public static final int AUDIENCES_FIELD_NUMBER = 4;
    public static final int AUTHORIZATION_URL_FIELD_NUMBER = 5;
    private static final AuthProvider DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int ISSUER_FIELD_NUMBER = 2;
    public static final int JWKS_URI_FIELD_NUMBER = 3;
    public static final int JWT_LOCATIONS_FIELD_NUMBER = 6;
    private static volatile Parser<AuthProvider> PARSER;
    private String id_ = "";
    private String issuer_ = "";
    private String jwksUri_ = "";
    private String audiences_ = "";
    private String authorizationUrl_ = "";
    private Internal.ProtobufList<JwtLocation> jwtLocations_ = emptyProtobufList();

    private AuthProvider() {
    }

    @Override // com.google.api.AuthProviderOrBuilder
    public final String getId() {
        return this.id_;
    }

    @Override // com.google.api.AuthProviderOrBuilder
    public final ByteString getIdBytes() {
        return ByteString.copyFromUtf8(this.id_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setId(String str) {
        this.id_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIdBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.id_ = byteString.toStringUtf8();
    }

    @Override // com.google.api.AuthProviderOrBuilder
    public final String getIssuer() {
        return this.issuer_;
    }

    @Override // com.google.api.AuthProviderOrBuilder
    public final ByteString getIssuerBytes() {
        return ByteString.copyFromUtf8(this.issuer_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIssuer(String str) {
        this.issuer_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIssuer() {
        this.issuer_ = getDefaultInstance().getIssuer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIssuerBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.issuer_ = byteString.toStringUtf8();
    }

    @Override // com.google.api.AuthProviderOrBuilder
    public final String getJwksUri() {
        return this.jwksUri_;
    }

    @Override // com.google.api.AuthProviderOrBuilder
    public final ByteString getJwksUriBytes() {
        return ByteString.copyFromUtf8(this.jwksUri_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJwksUri(String str) {
        this.jwksUri_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearJwksUri() {
        this.jwksUri_ = getDefaultInstance().getJwksUri();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJwksUriBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.jwksUri_ = byteString.toStringUtf8();
    }

    @Override // com.google.api.AuthProviderOrBuilder
    public final String getAudiences() {
        return this.audiences_;
    }

    @Override // com.google.api.AuthProviderOrBuilder
    public final ByteString getAudiencesBytes() {
        return ByteString.copyFromUtf8(this.audiences_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudiences(String str) {
        this.audiences_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAudiences() {
        this.audiences_ = getDefaultInstance().getAudiences();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudiencesBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.audiences_ = byteString.toStringUtf8();
    }

    @Override // com.google.api.AuthProviderOrBuilder
    public final String getAuthorizationUrl() {
        return this.authorizationUrl_;
    }

    @Override // com.google.api.AuthProviderOrBuilder
    public final ByteString getAuthorizationUrlBytes() {
        return ByteString.copyFromUtf8(this.authorizationUrl_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAuthorizationUrl(String str) {
        this.authorizationUrl_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAuthorizationUrl() {
        this.authorizationUrl_ = getDefaultInstance().getAuthorizationUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAuthorizationUrlBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.authorizationUrl_ = byteString.toStringUtf8();
    }

    @Override // com.google.api.AuthProviderOrBuilder
    public final List<JwtLocation> getJwtLocationsList() {
        return this.jwtLocations_;
    }

    public final List<? extends JwtLocationOrBuilder> getJwtLocationsOrBuilderList() {
        return this.jwtLocations_;
    }

    @Override // com.google.api.AuthProviderOrBuilder
    public final int getJwtLocationsCount() {
        return this.jwtLocations_.size();
    }

    @Override // com.google.api.AuthProviderOrBuilder
    public final JwtLocation getJwtLocations(int i) {
        return this.jwtLocations_.get(i);
    }

    public final JwtLocationOrBuilder getJwtLocationsOrBuilder(int i) {
        return this.jwtLocations_.get(i);
    }

    private void ensureJwtLocationsIsMutable() {
        Internal.ProtobufList<JwtLocation> protobufList = this.jwtLocations_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.jwtLocations_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJwtLocations(int i, JwtLocation jwtLocation) {
        ensureJwtLocationsIsMutable();
        this.jwtLocations_.set(i, jwtLocation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addJwtLocations(JwtLocation jwtLocation) {
        ensureJwtLocationsIsMutable();
        this.jwtLocations_.add(jwtLocation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addJwtLocations(int i, JwtLocation jwtLocation) {
        ensureJwtLocationsIsMutable();
        this.jwtLocations_.add(i, jwtLocation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllJwtLocations(Iterable<? extends JwtLocation> iterable) {
        ensureJwtLocationsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.jwtLocations_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearJwtLocations() {
        this.jwtLocations_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeJwtLocations(int i) {
        ensureJwtLocationsIsMutable();
        this.jwtLocations_.remove(i);
    }

    public static AuthProvider parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (AuthProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static AuthProvider parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AuthProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static AuthProvider parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (AuthProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static AuthProvider parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AuthProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AuthProvider parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (AuthProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AuthProvider parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AuthProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static AuthProvider parseFrom(InputStream inputStream) throws IOException {
        return (AuthProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthProvider parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuthProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AuthProvider parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AuthProvider) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthProvider parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuthProvider) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AuthProvider parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (AuthProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AuthProvider parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuthProvider) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(AuthProvider authProvider) {
        return DEFAULT_INSTANCE.createBuilder(authProvider);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<AuthProvider, Builder> implements AuthProviderOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(AuthProvider.DEFAULT_INSTANCE);
        }

        @Override // com.google.api.AuthProviderOrBuilder
        public final String getId() {
            return ((AuthProvider) this.instance).getId();
        }

        @Override // com.google.api.AuthProviderOrBuilder
        public final ByteString getIdBytes() {
            return ((AuthProvider) this.instance).getIdBytes();
        }

        public final Builder setId(String str) {
            copyOnWrite();
            ((AuthProvider) this.instance).setId(str);
            return this;
        }

        public final Builder clearId() {
            copyOnWrite();
            ((AuthProvider) this.instance).clearId();
            return this;
        }

        public final Builder setIdBytes(ByteString byteString) {
            copyOnWrite();
            ((AuthProvider) this.instance).setIdBytes(byteString);
            return this;
        }

        @Override // com.google.api.AuthProviderOrBuilder
        public final String getIssuer() {
            return ((AuthProvider) this.instance).getIssuer();
        }

        @Override // com.google.api.AuthProviderOrBuilder
        public final ByteString getIssuerBytes() {
            return ((AuthProvider) this.instance).getIssuerBytes();
        }

        public final Builder setIssuer(String str) {
            copyOnWrite();
            ((AuthProvider) this.instance).setIssuer(str);
            return this;
        }

        public final Builder clearIssuer() {
            copyOnWrite();
            ((AuthProvider) this.instance).clearIssuer();
            return this;
        }

        public final Builder setIssuerBytes(ByteString byteString) {
            copyOnWrite();
            ((AuthProvider) this.instance).setIssuerBytes(byteString);
            return this;
        }

        @Override // com.google.api.AuthProviderOrBuilder
        public final String getJwksUri() {
            return ((AuthProvider) this.instance).getJwksUri();
        }

        @Override // com.google.api.AuthProviderOrBuilder
        public final ByteString getJwksUriBytes() {
            return ((AuthProvider) this.instance).getJwksUriBytes();
        }

        public final Builder setJwksUri(String str) {
            copyOnWrite();
            ((AuthProvider) this.instance).setJwksUri(str);
            return this;
        }

        public final Builder clearJwksUri() {
            copyOnWrite();
            ((AuthProvider) this.instance).clearJwksUri();
            return this;
        }

        public final Builder setJwksUriBytes(ByteString byteString) {
            copyOnWrite();
            ((AuthProvider) this.instance).setJwksUriBytes(byteString);
            return this;
        }

        @Override // com.google.api.AuthProviderOrBuilder
        public final String getAudiences() {
            return ((AuthProvider) this.instance).getAudiences();
        }

        @Override // com.google.api.AuthProviderOrBuilder
        public final ByteString getAudiencesBytes() {
            return ((AuthProvider) this.instance).getAudiencesBytes();
        }

        public final Builder setAudiences(String str) {
            copyOnWrite();
            ((AuthProvider) this.instance).setAudiences(str);
            return this;
        }

        public final Builder clearAudiences() {
            copyOnWrite();
            ((AuthProvider) this.instance).clearAudiences();
            return this;
        }

        public final Builder setAudiencesBytes(ByteString byteString) {
            copyOnWrite();
            ((AuthProvider) this.instance).setAudiencesBytes(byteString);
            return this;
        }

        @Override // com.google.api.AuthProviderOrBuilder
        public final String getAuthorizationUrl() {
            return ((AuthProvider) this.instance).getAuthorizationUrl();
        }

        @Override // com.google.api.AuthProviderOrBuilder
        public final ByteString getAuthorizationUrlBytes() {
            return ((AuthProvider) this.instance).getAuthorizationUrlBytes();
        }

        public final Builder setAuthorizationUrl(String str) {
            copyOnWrite();
            ((AuthProvider) this.instance).setAuthorizationUrl(str);
            return this;
        }

        public final Builder clearAuthorizationUrl() {
            copyOnWrite();
            ((AuthProvider) this.instance).clearAuthorizationUrl();
            return this;
        }

        public final Builder setAuthorizationUrlBytes(ByteString byteString) {
            copyOnWrite();
            ((AuthProvider) this.instance).setAuthorizationUrlBytes(byteString);
            return this;
        }

        @Override // com.google.api.AuthProviderOrBuilder
        public final List<JwtLocation> getJwtLocationsList() {
            return Collections.unmodifiableList(((AuthProvider) this.instance).getJwtLocationsList());
        }

        @Override // com.google.api.AuthProviderOrBuilder
        public final int getJwtLocationsCount() {
            return ((AuthProvider) this.instance).getJwtLocationsCount();
        }

        @Override // com.google.api.AuthProviderOrBuilder
        public final JwtLocation getJwtLocations(int i) {
            return ((AuthProvider) this.instance).getJwtLocations(i);
        }

        public final Builder setJwtLocations(int i, JwtLocation jwtLocation) {
            copyOnWrite();
            ((AuthProvider) this.instance).setJwtLocations(i, jwtLocation);
            return this;
        }

        public final Builder setJwtLocations(int i, JwtLocation.Builder builder) {
            copyOnWrite();
            ((AuthProvider) this.instance).setJwtLocations(i, builder.build());
            return this;
        }

        public final Builder addJwtLocations(JwtLocation jwtLocation) {
            copyOnWrite();
            ((AuthProvider) this.instance).addJwtLocations(jwtLocation);
            return this;
        }

        public final Builder addJwtLocations(int i, JwtLocation jwtLocation) {
            copyOnWrite();
            ((AuthProvider) this.instance).addJwtLocations(i, jwtLocation);
            return this;
        }

        public final Builder addJwtLocations(JwtLocation.Builder builder) {
            copyOnWrite();
            ((AuthProvider) this.instance).addJwtLocations(builder.build());
            return this;
        }

        public final Builder addJwtLocations(int i, JwtLocation.Builder builder) {
            copyOnWrite();
            ((AuthProvider) this.instance).addJwtLocations(i, builder.build());
            return this;
        }

        public final Builder addAllJwtLocations(Iterable<? extends JwtLocation> iterable) {
            copyOnWrite();
            ((AuthProvider) this.instance).addAllJwtLocations(iterable);
            return this;
        }

        public final Builder clearJwtLocations() {
            copyOnWrite();
            ((AuthProvider) this.instance).clearJwtLocations();
            return this;
        }

        public final Builder removeJwtLocations(int i) {
            copyOnWrite();
            ((AuthProvider) this.instance).removeJwtLocations(i);
            return this;
        }
    }

    /* renamed from: com.google.api.AuthProvider$1  reason: invalid class name */
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
                return new AuthProvider();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006\u001b", new Object[]{"id_", "issuer_", "jwksUri_", "audiences_", "authorizationUrl_", "jwtLocations_", JwtLocation.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AuthProvider> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (AuthProvider.class) {
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
        AuthProvider authProvider = new AuthProvider();
        DEFAULT_INSTANCE = authProvider;
        GeneratedMessageLite.registerDefaultInstance(AuthProvider.class, authProvider);
    }

    public static AuthProvider getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AuthProvider> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
