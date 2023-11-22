package com.google.rpc;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes7.dex */
public final class ErrorInfo extends GeneratedMessageLite<ErrorInfo, Builder> implements ErrorInfoOrBuilder {
    private static final ErrorInfo DEFAULT_INSTANCE;
    public static final int DOMAIN_FIELD_NUMBER = 2;
    public static final int METADATA_FIELD_NUMBER = 3;
    private static volatile Parser<ErrorInfo> PARSER = null;
    public static final int REASON_FIELD_NUMBER = 1;
    private MapFieldLite<String, String> metadata_ = MapFieldLite.emptyMapField();
    private String reason_ = "";
    private String domain_ = "";

    private ErrorInfo() {
    }

    @Override // com.google.rpc.ErrorInfoOrBuilder
    public final String getReason() {
        return this.reason_;
    }

    @Override // com.google.rpc.ErrorInfoOrBuilder
    public final ByteString getReasonBytes() {
        return ByteString.copyFromUtf8(this.reason_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReason(String str) {
        this.reason_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearReason() {
        this.reason_ = getDefaultInstance().getReason();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setReasonBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.reason_ = byteString.toStringUtf8();
    }

    @Override // com.google.rpc.ErrorInfoOrBuilder
    public final String getDomain() {
        return this.domain_;
    }

    @Override // com.google.rpc.ErrorInfoOrBuilder
    public final ByteString getDomainBytes() {
        return ByteString.copyFromUtf8(this.domain_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDomain(String str) {
        this.domain_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDomain() {
        this.domain_ = getDefaultInstance().getDomain();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDomainBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.domain_ = byteString.toStringUtf8();
    }

    /* loaded from: classes7.dex */
    static final class MetadataDefaultEntryHolder {
        static final MapEntryLite<String, String> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.STRING, "");

        private MetadataDefaultEntryHolder() {
        }
    }

    private MapFieldLite<String, String> internalGetMetadata() {
        return this.metadata_;
    }

    private MapFieldLite<String, String> internalGetMutableMetadata() {
        if (!this.metadata_.isMutable()) {
            this.metadata_ = this.metadata_.mutableCopy();
        }
        return this.metadata_;
    }

    @Override // com.google.rpc.ErrorInfoOrBuilder
    public final int getMetadataCount() {
        return internalGetMetadata().size();
    }

    @Override // com.google.rpc.ErrorInfoOrBuilder
    public final boolean containsMetadata(String str) {
        return internalGetMetadata().containsKey(str);
    }

    @Override // com.google.rpc.ErrorInfoOrBuilder
    @Deprecated
    public final Map<String, String> getMetadata() {
        return getMetadataMap();
    }

    @Override // com.google.rpc.ErrorInfoOrBuilder
    public final Map<String, String> getMetadataMap() {
        return Collections.unmodifiableMap(internalGetMetadata());
    }

    @Override // com.google.rpc.ErrorInfoOrBuilder
    public final String getMetadataOrDefault(String str, String str2) {
        MapFieldLite<String, String> internalGetMetadata = internalGetMetadata();
        return internalGetMetadata.containsKey(str) ? internalGetMetadata.get(str) : str2;
    }

    @Override // com.google.rpc.ErrorInfoOrBuilder
    public final String getMetadataOrThrow(String str) {
        MapFieldLite<String, String> internalGetMetadata = internalGetMetadata();
        if (!internalGetMetadata.containsKey(str)) {
            throw new IllegalArgumentException();
        }
        return internalGetMetadata.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getMutableMetadataMap() {
        return internalGetMutableMetadata();
    }

    public static ErrorInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static ErrorInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ErrorInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ErrorInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ErrorInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ErrorInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ErrorInfo parseFrom(InputStream inputStream) throws IOException {
        return (ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ErrorInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ErrorInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ErrorInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ErrorInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ErrorInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ErrorInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ErrorInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ErrorInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(ErrorInfo errorInfo) {
        return DEFAULT_INSTANCE.createBuilder(errorInfo);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<ErrorInfo, Builder> implements ErrorInfoOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(ErrorInfo.DEFAULT_INSTANCE);
        }

        @Override // com.google.rpc.ErrorInfoOrBuilder
        public final String getReason() {
            return ((ErrorInfo) this.instance).getReason();
        }

        @Override // com.google.rpc.ErrorInfoOrBuilder
        public final ByteString getReasonBytes() {
            return ((ErrorInfo) this.instance).getReasonBytes();
        }

        public final Builder setReason(String str) {
            copyOnWrite();
            ((ErrorInfo) this.instance).setReason(str);
            return this;
        }

        public final Builder clearReason() {
            copyOnWrite();
            ((ErrorInfo) this.instance).clearReason();
            return this;
        }

        public final Builder setReasonBytes(ByteString byteString) {
            copyOnWrite();
            ((ErrorInfo) this.instance).setReasonBytes(byteString);
            return this;
        }

        @Override // com.google.rpc.ErrorInfoOrBuilder
        public final String getDomain() {
            return ((ErrorInfo) this.instance).getDomain();
        }

        @Override // com.google.rpc.ErrorInfoOrBuilder
        public final ByteString getDomainBytes() {
            return ((ErrorInfo) this.instance).getDomainBytes();
        }

        public final Builder setDomain(String str) {
            copyOnWrite();
            ((ErrorInfo) this.instance).setDomain(str);
            return this;
        }

        public final Builder clearDomain() {
            copyOnWrite();
            ((ErrorInfo) this.instance).clearDomain();
            return this;
        }

        public final Builder setDomainBytes(ByteString byteString) {
            copyOnWrite();
            ((ErrorInfo) this.instance).setDomainBytes(byteString);
            return this;
        }

        @Override // com.google.rpc.ErrorInfoOrBuilder
        public final int getMetadataCount() {
            return ((ErrorInfo) this.instance).getMetadataMap().size();
        }

        @Override // com.google.rpc.ErrorInfoOrBuilder
        public final boolean containsMetadata(String str) {
            return ((ErrorInfo) this.instance).getMetadataMap().containsKey(str);
        }

        public final Builder clearMetadata() {
            copyOnWrite();
            ((ErrorInfo) this.instance).getMutableMetadataMap().clear();
            return this;
        }

        public final Builder removeMetadata(String str) {
            copyOnWrite();
            ((ErrorInfo) this.instance).getMutableMetadataMap().remove(str);
            return this;
        }

        @Override // com.google.rpc.ErrorInfoOrBuilder
        @Deprecated
        public final Map<String, String> getMetadata() {
            return getMetadataMap();
        }

        @Override // com.google.rpc.ErrorInfoOrBuilder
        public final Map<String, String> getMetadataMap() {
            return Collections.unmodifiableMap(((ErrorInfo) this.instance).getMetadataMap());
        }

        @Override // com.google.rpc.ErrorInfoOrBuilder
        public final String getMetadataOrDefault(String str, String str2) {
            Map<String, String> metadataMap = ((ErrorInfo) this.instance).getMetadataMap();
            return metadataMap.containsKey(str) ? metadataMap.get(str) : str2;
        }

        @Override // com.google.rpc.ErrorInfoOrBuilder
        public final String getMetadataOrThrow(String str) {
            Map<String, String> metadataMap = ((ErrorInfo) this.instance).getMetadataMap();
            if (!metadataMap.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return metadataMap.get(str);
        }

        public final Builder putMetadata(String str, String str2) {
            copyOnWrite();
            ((ErrorInfo) this.instance).getMutableMetadataMap().put(str, str2);
            return this;
        }

        public final Builder putAllMetadata(Map<String, String> map) {
            copyOnWrite();
            ((ErrorInfo) this.instance).getMutableMetadataMap().putAll(map);
            return this;
        }
    }

    /* renamed from: com.google.rpc.ErrorInfo$1  reason: invalid class name */
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
                return new ErrorInfo();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u00032", new Object[]{"reason_", "domain_", "metadata_", MetadataDefaultEntryHolder.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ErrorInfo> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (ErrorInfo.class) {
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
        ErrorInfo errorInfo = new ErrorInfo();
        DEFAULT_INSTANCE = errorInfo;
        GeneratedMessageLite.registerDefaultInstance(ErrorInfo.class, errorInfo);
    }

    public static ErrorInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<ErrorInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
