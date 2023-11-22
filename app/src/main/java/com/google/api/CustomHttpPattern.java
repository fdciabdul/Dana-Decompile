package com.google.api;

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
public final class CustomHttpPattern extends GeneratedMessageLite<CustomHttpPattern, Builder> implements CustomHttpPatternOrBuilder {
    private static final CustomHttpPattern DEFAULT_INSTANCE;
    public static final int KIND_FIELD_NUMBER = 1;
    private static volatile Parser<CustomHttpPattern> PARSER = null;
    public static final int PATH_FIELD_NUMBER = 2;
    private String kind_ = "";
    private String path_ = "";

    private CustomHttpPattern() {
    }

    @Override // com.google.api.CustomHttpPatternOrBuilder
    public final String getKind() {
        return this.kind_;
    }

    @Override // com.google.api.CustomHttpPatternOrBuilder
    public final ByteString getKindBytes() {
        return ByteString.copyFromUtf8(this.kind_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKind(String str) {
        this.kind_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKind() {
        this.kind_ = getDefaultInstance().getKind();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKindBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.kind_ = byteString.toStringUtf8();
    }

    @Override // com.google.api.CustomHttpPatternOrBuilder
    public final String getPath() {
        return this.path_;
    }

    @Override // com.google.api.CustomHttpPatternOrBuilder
    public final ByteString getPathBytes() {
        return ByteString.copyFromUtf8(this.path_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPath(String str) {
        this.path_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPath() {
        this.path_ = getDefaultInstance().getPath();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPathBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.path_ = byteString.toStringUtf8();
    }

    public static CustomHttpPattern parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (CustomHttpPattern) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static CustomHttpPattern parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CustomHttpPattern) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static CustomHttpPattern parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (CustomHttpPattern) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static CustomHttpPattern parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CustomHttpPattern) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CustomHttpPattern parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (CustomHttpPattern) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static CustomHttpPattern parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CustomHttpPattern) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static CustomHttpPattern parseFrom(InputStream inputStream) throws IOException {
        return (CustomHttpPattern) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CustomHttpPattern parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CustomHttpPattern) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CustomHttpPattern parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CustomHttpPattern) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static CustomHttpPattern parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CustomHttpPattern) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CustomHttpPattern parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CustomHttpPattern) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static CustomHttpPattern parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CustomHttpPattern) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(CustomHttpPattern customHttpPattern) {
        return DEFAULT_INSTANCE.createBuilder(customHttpPattern);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<CustomHttpPattern, Builder> implements CustomHttpPatternOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(CustomHttpPattern.DEFAULT_INSTANCE);
        }

        @Override // com.google.api.CustomHttpPatternOrBuilder
        public final String getKind() {
            return ((CustomHttpPattern) this.instance).getKind();
        }

        @Override // com.google.api.CustomHttpPatternOrBuilder
        public final ByteString getKindBytes() {
            return ((CustomHttpPattern) this.instance).getKindBytes();
        }

        public final Builder setKind(String str) {
            copyOnWrite();
            ((CustomHttpPattern) this.instance).setKind(str);
            return this;
        }

        public final Builder clearKind() {
            copyOnWrite();
            ((CustomHttpPattern) this.instance).clearKind();
            return this;
        }

        public final Builder setKindBytes(ByteString byteString) {
            copyOnWrite();
            ((CustomHttpPattern) this.instance).setKindBytes(byteString);
            return this;
        }

        @Override // com.google.api.CustomHttpPatternOrBuilder
        public final String getPath() {
            return ((CustomHttpPattern) this.instance).getPath();
        }

        @Override // com.google.api.CustomHttpPatternOrBuilder
        public final ByteString getPathBytes() {
            return ((CustomHttpPattern) this.instance).getPathBytes();
        }

        public final Builder setPath(String str) {
            copyOnWrite();
            ((CustomHttpPattern) this.instance).setPath(str);
            return this;
        }

        public final Builder clearPath() {
            copyOnWrite();
            ((CustomHttpPattern) this.instance).clearPath();
            return this;
        }

        public final Builder setPathBytes(ByteString byteString) {
            copyOnWrite();
            ((CustomHttpPattern) this.instance).setPathBytes(byteString);
            return this;
        }
    }

    /* renamed from: com.google.api.CustomHttpPattern$1  reason: invalid class name */
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
                return new CustomHttpPattern();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"kind_", "path_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<CustomHttpPattern> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (CustomHttpPattern.class) {
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
        CustomHttpPattern customHttpPattern = new CustomHttpPattern();
        DEFAULT_INSTANCE = customHttpPattern;
        GeneratedMessageLite.registerDefaultInstance(CustomHttpPattern.class, customHttpPattern);
    }

    public static CustomHttpPattern getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<CustomHttpPattern> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
