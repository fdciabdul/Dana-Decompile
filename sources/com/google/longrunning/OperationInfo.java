package com.google.longrunning;

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
public final class OperationInfo extends GeneratedMessageLite<OperationInfo, Builder> implements OperationInfoOrBuilder {
    private static final OperationInfo DEFAULT_INSTANCE;
    public static final int METADATA_TYPE_FIELD_NUMBER = 2;
    private static volatile Parser<OperationInfo> PARSER = null;
    public static final int RESPONSE_TYPE_FIELD_NUMBER = 1;
    private String responseType_ = "";
    private String metadataType_ = "";

    private OperationInfo() {
    }

    @Override // com.google.longrunning.OperationInfoOrBuilder
    public final String getResponseType() {
        return this.responseType_;
    }

    @Override // com.google.longrunning.OperationInfoOrBuilder
    public final ByteString getResponseTypeBytes() {
        return ByteString.copyFromUtf8(this.responseType_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResponseType(String str) {
        this.responseType_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResponseType() {
        this.responseType_ = getDefaultInstance().getResponseType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResponseTypeBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.responseType_ = byteString.toStringUtf8();
    }

    @Override // com.google.longrunning.OperationInfoOrBuilder
    public final String getMetadataType() {
        return this.metadataType_;
    }

    @Override // com.google.longrunning.OperationInfoOrBuilder
    public final ByteString getMetadataTypeBytes() {
        return ByteString.copyFromUtf8(this.metadataType_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetadataType(String str) {
        this.metadataType_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMetadataType() {
        this.metadataType_ = getDefaultInstance().getMetadataType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetadataTypeBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.metadataType_ = byteString.toStringUtf8();
    }

    public static OperationInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (OperationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static OperationInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (OperationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static OperationInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (OperationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static OperationInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (OperationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static OperationInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (OperationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static OperationInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (OperationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static OperationInfo parseFrom(InputStream inputStream) throws IOException {
        return (OperationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OperationInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (OperationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static OperationInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (OperationInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static OperationInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (OperationInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static OperationInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (OperationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static OperationInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (OperationInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(OperationInfo operationInfo) {
        return DEFAULT_INSTANCE.createBuilder(operationInfo);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<OperationInfo, Builder> implements OperationInfoOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(OperationInfo.DEFAULT_INSTANCE);
        }

        @Override // com.google.longrunning.OperationInfoOrBuilder
        public final String getResponseType() {
            return ((OperationInfo) this.instance).getResponseType();
        }

        @Override // com.google.longrunning.OperationInfoOrBuilder
        public final ByteString getResponseTypeBytes() {
            return ((OperationInfo) this.instance).getResponseTypeBytes();
        }

        public final Builder setResponseType(String str) {
            copyOnWrite();
            ((OperationInfo) this.instance).setResponseType(str);
            return this;
        }

        public final Builder clearResponseType() {
            copyOnWrite();
            ((OperationInfo) this.instance).clearResponseType();
            return this;
        }

        public final Builder setResponseTypeBytes(ByteString byteString) {
            copyOnWrite();
            ((OperationInfo) this.instance).setResponseTypeBytes(byteString);
            return this;
        }

        @Override // com.google.longrunning.OperationInfoOrBuilder
        public final String getMetadataType() {
            return ((OperationInfo) this.instance).getMetadataType();
        }

        @Override // com.google.longrunning.OperationInfoOrBuilder
        public final ByteString getMetadataTypeBytes() {
            return ((OperationInfo) this.instance).getMetadataTypeBytes();
        }

        public final Builder setMetadataType(String str) {
            copyOnWrite();
            ((OperationInfo) this.instance).setMetadataType(str);
            return this;
        }

        public final Builder clearMetadataType() {
            copyOnWrite();
            ((OperationInfo) this.instance).clearMetadataType();
            return this;
        }

        public final Builder setMetadataTypeBytes(ByteString byteString) {
            copyOnWrite();
            ((OperationInfo) this.instance).setMetadataTypeBytes(byteString);
            return this;
        }
    }

    /* renamed from: com.google.longrunning.OperationInfo$1  reason: invalid class name */
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
                return new OperationInfo();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"responseType_", "metadataType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<OperationInfo> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (OperationInfo.class) {
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
        OperationInfo operationInfo = new OperationInfo();
        DEFAULT_INSTANCE = operationInfo;
        GeneratedMessageLite.registerDefaultInstance(OperationInfo.class, operationInfo);
    }

    public static OperationInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<OperationInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
