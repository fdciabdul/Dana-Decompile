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
public final class RequestMetadata extends GeneratedMessageLite<RequestMetadata, Builder> implements RequestMetadataOrBuilder {
    public static final int CALLER_IP_FIELD_NUMBER = 1;
    public static final int CALLER_SUPPLIED_USER_AGENT_FIELD_NUMBER = 2;
    private static final RequestMetadata DEFAULT_INSTANCE;
    private static volatile Parser<RequestMetadata> PARSER;
    private String callerIp_ = "";
    private String callerSuppliedUserAgent_ = "";

    private RequestMetadata() {
    }

    @Override // com.google.cloud.audit.RequestMetadataOrBuilder
    public final String getCallerIp() {
        return this.callerIp_;
    }

    @Override // com.google.cloud.audit.RequestMetadataOrBuilder
    public final ByteString getCallerIpBytes() {
        return ByteString.copyFromUtf8(this.callerIp_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCallerIp(String str) {
        this.callerIp_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCallerIp() {
        this.callerIp_ = getDefaultInstance().getCallerIp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCallerIpBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.callerIp_ = byteString.toStringUtf8();
    }

    @Override // com.google.cloud.audit.RequestMetadataOrBuilder
    public final String getCallerSuppliedUserAgent() {
        return this.callerSuppliedUserAgent_;
    }

    @Override // com.google.cloud.audit.RequestMetadataOrBuilder
    public final ByteString getCallerSuppliedUserAgentBytes() {
        return ByteString.copyFromUtf8(this.callerSuppliedUserAgent_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCallerSuppliedUserAgent(String str) {
        this.callerSuppliedUserAgent_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCallerSuppliedUserAgent() {
        this.callerSuppliedUserAgent_ = getDefaultInstance().getCallerSuppliedUserAgent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCallerSuppliedUserAgentBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.callerSuppliedUserAgent_ = byteString.toStringUtf8();
    }

    public static RequestMetadata parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (RequestMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static RequestMetadata parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RequestMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static RequestMetadata parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (RequestMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static RequestMetadata parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RequestMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static RequestMetadata parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (RequestMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RequestMetadata parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RequestMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static RequestMetadata parseFrom(InputStream inputStream) throws IOException {
        return (RequestMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RequestMetadata parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RequestMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RequestMetadata parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (RequestMetadata) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RequestMetadata parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RequestMetadata) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RequestMetadata parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (RequestMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static RequestMetadata parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RequestMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(RequestMetadata requestMetadata) {
        return DEFAULT_INSTANCE.createBuilder(requestMetadata);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<RequestMetadata, Builder> implements RequestMetadataOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(RequestMetadata.DEFAULT_INSTANCE);
        }

        @Override // com.google.cloud.audit.RequestMetadataOrBuilder
        public final String getCallerIp() {
            return ((RequestMetadata) this.instance).getCallerIp();
        }

        @Override // com.google.cloud.audit.RequestMetadataOrBuilder
        public final ByteString getCallerIpBytes() {
            return ((RequestMetadata) this.instance).getCallerIpBytes();
        }

        public final Builder setCallerIp(String str) {
            copyOnWrite();
            ((RequestMetadata) this.instance).setCallerIp(str);
            return this;
        }

        public final Builder clearCallerIp() {
            copyOnWrite();
            ((RequestMetadata) this.instance).clearCallerIp();
            return this;
        }

        public final Builder setCallerIpBytes(ByteString byteString) {
            copyOnWrite();
            ((RequestMetadata) this.instance).setCallerIpBytes(byteString);
            return this;
        }

        @Override // com.google.cloud.audit.RequestMetadataOrBuilder
        public final String getCallerSuppliedUserAgent() {
            return ((RequestMetadata) this.instance).getCallerSuppliedUserAgent();
        }

        @Override // com.google.cloud.audit.RequestMetadataOrBuilder
        public final ByteString getCallerSuppliedUserAgentBytes() {
            return ((RequestMetadata) this.instance).getCallerSuppliedUserAgentBytes();
        }

        public final Builder setCallerSuppliedUserAgent(String str) {
            copyOnWrite();
            ((RequestMetadata) this.instance).setCallerSuppliedUserAgent(str);
            return this;
        }

        public final Builder clearCallerSuppliedUserAgent() {
            copyOnWrite();
            ((RequestMetadata) this.instance).clearCallerSuppliedUserAgent();
            return this;
        }

        public final Builder setCallerSuppliedUserAgentBytes(ByteString byteString) {
            copyOnWrite();
            ((RequestMetadata) this.instance).setCallerSuppliedUserAgentBytes(byteString);
            return this;
        }
    }

    /* renamed from: com.google.cloud.audit.RequestMetadata$1  reason: invalid class name */
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
                return new RequestMetadata();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"callerIp_", "callerSuppliedUserAgent_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RequestMetadata> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (RequestMetadata.class) {
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
        RequestMetadata requestMetadata = new RequestMetadata();
        DEFAULT_INSTANCE = requestMetadata;
        GeneratedMessageLite.registerDefaultInstance(RequestMetadata.class, requestMetadata);
    }

    public static RequestMetadata getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<RequestMetadata> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
