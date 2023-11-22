package com.google.cloud.audit;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public final class AuthorizationInfo extends GeneratedMessageLite<AuthorizationInfo, Builder> implements AuthorizationInfoOrBuilder {
    private static final AuthorizationInfo DEFAULT_INSTANCE;
    public static final int GRANTED_FIELD_NUMBER = 3;
    private static volatile Parser<AuthorizationInfo> PARSER = null;
    public static final int PERMISSION_FIELD_NUMBER = 2;
    public static final int RESOURCE_FIELD_NUMBER = 1;
    private boolean granted_;
    private String resource_ = "";
    private String permission_ = "";

    private AuthorizationInfo() {
    }

    @Override // com.google.cloud.audit.AuthorizationInfoOrBuilder
    public final String getResource() {
        return this.resource_;
    }

    @Override // com.google.cloud.audit.AuthorizationInfoOrBuilder
    public final ByteString getResourceBytes() {
        return ByteString.copyFromUtf8(this.resource_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResource(String str) {
        this.resource_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResource() {
        this.resource_ = getDefaultInstance().getResource();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResourceBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.resource_ = byteString.toStringUtf8();
    }

    @Override // com.google.cloud.audit.AuthorizationInfoOrBuilder
    public final String getPermission() {
        return this.permission_;
    }

    @Override // com.google.cloud.audit.AuthorizationInfoOrBuilder
    public final ByteString getPermissionBytes() {
        return ByteString.copyFromUtf8(this.permission_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPermission(String str) {
        this.permission_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPermission() {
        this.permission_ = getDefaultInstance().getPermission();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPermissionBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.permission_ = byteString.toStringUtf8();
    }

    @Override // com.google.cloud.audit.AuthorizationInfoOrBuilder
    public final boolean getGranted() {
        return this.granted_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGranted(boolean z) {
        this.granted_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGranted() {
        this.granted_ = false;
    }

    public static AuthorizationInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (AuthorizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static AuthorizationInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AuthorizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static AuthorizationInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (AuthorizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static AuthorizationInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AuthorizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AuthorizationInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (AuthorizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AuthorizationInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AuthorizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static AuthorizationInfo parseFrom(InputStream inputStream) throws IOException {
        return (AuthorizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthorizationInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuthorizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AuthorizationInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AuthorizationInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AuthorizationInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuthorizationInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AuthorizationInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (AuthorizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AuthorizationInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuthorizationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(AuthorizationInfo authorizationInfo) {
        return DEFAULT_INSTANCE.createBuilder(authorizationInfo);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<AuthorizationInfo, Builder> implements AuthorizationInfoOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(AuthorizationInfo.DEFAULT_INSTANCE);
        }

        @Override // com.google.cloud.audit.AuthorizationInfoOrBuilder
        public final String getResource() {
            return ((AuthorizationInfo) this.instance).getResource();
        }

        @Override // com.google.cloud.audit.AuthorizationInfoOrBuilder
        public final ByteString getResourceBytes() {
            return ((AuthorizationInfo) this.instance).getResourceBytes();
        }

        public final Builder setResource(String str) {
            copyOnWrite();
            ((AuthorizationInfo) this.instance).setResource(str);
            return this;
        }

        public final Builder clearResource() {
            copyOnWrite();
            ((AuthorizationInfo) this.instance).clearResource();
            return this;
        }

        public final Builder setResourceBytes(ByteString byteString) {
            copyOnWrite();
            ((AuthorizationInfo) this.instance).setResourceBytes(byteString);
            return this;
        }

        @Override // com.google.cloud.audit.AuthorizationInfoOrBuilder
        public final String getPermission() {
            return ((AuthorizationInfo) this.instance).getPermission();
        }

        @Override // com.google.cloud.audit.AuthorizationInfoOrBuilder
        public final ByteString getPermissionBytes() {
            return ((AuthorizationInfo) this.instance).getPermissionBytes();
        }

        public final Builder setPermission(String str) {
            copyOnWrite();
            ((AuthorizationInfo) this.instance).setPermission(str);
            return this;
        }

        public final Builder clearPermission() {
            copyOnWrite();
            ((AuthorizationInfo) this.instance).clearPermission();
            return this;
        }

        public final Builder setPermissionBytes(ByteString byteString) {
            copyOnWrite();
            ((AuthorizationInfo) this.instance).setPermissionBytes(byteString);
            return this;
        }

        @Override // com.google.cloud.audit.AuthorizationInfoOrBuilder
        public final boolean getGranted() {
            return ((AuthorizationInfo) this.instance).getGranted();
        }

        public final Builder setGranted(boolean z) {
            copyOnWrite();
            ((AuthorizationInfo) this.instance).setGranted(z);
            return this;
        }

        public final Builder clearGranted() {
            copyOnWrite();
            ((AuthorizationInfo) this.instance).clearGranted();
            return this;
        }
    }

    /* renamed from: com.google.cloud.audit.AuthorizationInfo$1  reason: invalid class name */
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
                return new AuthorizationInfo();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0007", new Object[]{"resource_", "permission_", "granted_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AuthorizationInfo> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (AuthorizationInfo.class) {
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
        AuthorizationInfo authorizationInfo = new AuthorizationInfo();
        DEFAULT_INSTANCE = authorizationInfo;
        GeneratedMessageLite.registerDefaultInstance(AuthorizationInfo.class, authorizationInfo);
    }

    public static AuthorizationInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AuthorizationInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
