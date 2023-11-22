package com.google.rpc;

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
public final class RequestInfo extends GeneratedMessageLite<RequestInfo, Builder> implements RequestInfoOrBuilder {
    private static final RequestInfo DEFAULT_INSTANCE;
    private static volatile Parser<RequestInfo> PARSER = null;
    public static final int REQUEST_ID_FIELD_NUMBER = 1;
    public static final int SERVING_DATA_FIELD_NUMBER = 2;
    private String requestId_ = "";
    private String servingData_ = "";

    private RequestInfo() {
    }

    @Override // com.google.rpc.RequestInfoOrBuilder
    public final String getRequestId() {
        return this.requestId_;
    }

    @Override // com.google.rpc.RequestInfoOrBuilder
    public final ByteString getRequestIdBytes() {
        return ByteString.copyFromUtf8(this.requestId_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestId(String str) {
        this.requestId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRequestId() {
        this.requestId_ = getDefaultInstance().getRequestId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestIdBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.requestId_ = byteString.toStringUtf8();
    }

    @Override // com.google.rpc.RequestInfoOrBuilder
    public final String getServingData() {
        return this.servingData_;
    }

    @Override // com.google.rpc.RequestInfoOrBuilder
    public final ByteString getServingDataBytes() {
        return ByteString.copyFromUtf8(this.servingData_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServingData(String str) {
        this.servingData_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearServingData() {
        this.servingData_ = getDefaultInstance().getServingData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setServingDataBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.servingData_ = byteString.toStringUtf8();
    }

    public static RequestInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (RequestInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static RequestInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RequestInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static RequestInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (RequestInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static RequestInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RequestInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static RequestInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (RequestInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RequestInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RequestInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static RequestInfo parseFrom(InputStream inputStream) throws IOException {
        return (RequestInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RequestInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RequestInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RequestInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (RequestInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RequestInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RequestInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RequestInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (RequestInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static RequestInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RequestInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(RequestInfo requestInfo) {
        return DEFAULT_INSTANCE.createBuilder(requestInfo);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<RequestInfo, Builder> implements RequestInfoOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(RequestInfo.DEFAULT_INSTANCE);
        }

        @Override // com.google.rpc.RequestInfoOrBuilder
        public final String getRequestId() {
            return ((RequestInfo) this.instance).getRequestId();
        }

        @Override // com.google.rpc.RequestInfoOrBuilder
        public final ByteString getRequestIdBytes() {
            return ((RequestInfo) this.instance).getRequestIdBytes();
        }

        public final Builder setRequestId(String str) {
            copyOnWrite();
            ((RequestInfo) this.instance).setRequestId(str);
            return this;
        }

        public final Builder clearRequestId() {
            copyOnWrite();
            ((RequestInfo) this.instance).clearRequestId();
            return this;
        }

        public final Builder setRequestIdBytes(ByteString byteString) {
            copyOnWrite();
            ((RequestInfo) this.instance).setRequestIdBytes(byteString);
            return this;
        }

        @Override // com.google.rpc.RequestInfoOrBuilder
        public final String getServingData() {
            return ((RequestInfo) this.instance).getServingData();
        }

        @Override // com.google.rpc.RequestInfoOrBuilder
        public final ByteString getServingDataBytes() {
            return ((RequestInfo) this.instance).getServingDataBytes();
        }

        public final Builder setServingData(String str) {
            copyOnWrite();
            ((RequestInfo) this.instance).setServingData(str);
            return this;
        }

        public final Builder clearServingData() {
            copyOnWrite();
            ((RequestInfo) this.instance).clearServingData();
            return this;
        }

        public final Builder setServingDataBytes(ByteString byteString) {
            copyOnWrite();
            ((RequestInfo) this.instance).setServingDataBytes(byteString);
            return this;
        }
    }

    /* renamed from: com.google.rpc.RequestInfo$1  reason: invalid class name */
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
                return new RequestInfo();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"requestId_", "servingData_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RequestInfo> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (RequestInfo.class) {
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
        RequestInfo requestInfo = new RequestInfo();
        DEFAULT_INSTANCE = requestInfo;
        GeneratedMessageLite.registerDefaultInstance(RequestInfo.class, requestInfo);
    }

    public static RequestInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<RequestInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
