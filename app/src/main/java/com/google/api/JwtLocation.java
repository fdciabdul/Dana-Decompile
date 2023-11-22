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
public final class JwtLocation extends GeneratedMessageLite<JwtLocation, Builder> implements JwtLocationOrBuilder {
    private static final JwtLocation DEFAULT_INSTANCE;
    public static final int HEADER_FIELD_NUMBER = 1;
    private static volatile Parser<JwtLocation> PARSER = null;
    public static final int QUERY_FIELD_NUMBER = 2;
    public static final int VALUE_PREFIX_FIELD_NUMBER = 3;
    private Object in_;
    private int inCase_ = 0;
    private String valuePrefix_ = "";

    private JwtLocation() {
    }

    /* loaded from: classes7.dex */
    public enum InCase {
        HEADER(1),
        QUERY(2),
        IN_NOT_SET(0);

        private final int value;

        InCase(int i) {
            this.value = i;
        }

        @Deprecated
        public static InCase valueOf(int i) {
            return forNumber(i);
        }

        public static InCase forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return QUERY;
                }
                return HEADER;
            }
            return IN_NOT_SET;
        }

        public final int getNumber() {
            return this.value;
        }
    }

    @Override // com.google.api.JwtLocationOrBuilder
    public final InCase getInCase() {
        return InCase.forNumber(this.inCase_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIn() {
        this.inCase_ = 0;
        this.in_ = null;
    }

    @Override // com.google.api.JwtLocationOrBuilder
    public final String getHeader() {
        return this.inCase_ == 1 ? (String) this.in_ : "";
    }

    @Override // com.google.api.JwtLocationOrBuilder
    public final ByteString getHeaderBytes() {
        return ByteString.copyFromUtf8(this.inCase_ == 1 ? (String) this.in_ : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeader(String str) {
        this.inCase_ = 1;
        this.in_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHeader() {
        if (this.inCase_ == 1) {
            this.inCase_ = 0;
            this.in_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHeaderBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.in_ = byteString.toStringUtf8();
        this.inCase_ = 1;
    }

    @Override // com.google.api.JwtLocationOrBuilder
    public final String getQuery() {
        return this.inCase_ == 2 ? (String) this.in_ : "";
    }

    @Override // com.google.api.JwtLocationOrBuilder
    public final ByteString getQueryBytes() {
        return ByteString.copyFromUtf8(this.inCase_ == 2 ? (String) this.in_ : "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setQuery(String str) {
        this.inCase_ = 2;
        this.in_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearQuery() {
        if (this.inCase_ == 2) {
            this.inCase_ = 0;
            this.in_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setQueryBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.in_ = byteString.toStringUtf8();
        this.inCase_ = 2;
    }

    @Override // com.google.api.JwtLocationOrBuilder
    public final String getValuePrefix() {
        return this.valuePrefix_;
    }

    @Override // com.google.api.JwtLocationOrBuilder
    public final ByteString getValuePrefixBytes() {
        return ByteString.copyFromUtf8(this.valuePrefix_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValuePrefix(String str) {
        this.valuePrefix_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearValuePrefix() {
        this.valuePrefix_ = getDefaultInstance().getValuePrefix();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValuePrefixBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.valuePrefix_ = byteString.toStringUtf8();
    }

    public static JwtLocation parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (JwtLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static JwtLocation parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (JwtLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static JwtLocation parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (JwtLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static JwtLocation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (JwtLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static JwtLocation parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (JwtLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static JwtLocation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (JwtLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static JwtLocation parseFrom(InputStream inputStream) throws IOException {
        return (JwtLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static JwtLocation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (JwtLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static JwtLocation parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (JwtLocation) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static JwtLocation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (JwtLocation) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static JwtLocation parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (JwtLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static JwtLocation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (JwtLocation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(JwtLocation jwtLocation) {
        return DEFAULT_INSTANCE.createBuilder(jwtLocation);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<JwtLocation, Builder> implements JwtLocationOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(JwtLocation.DEFAULT_INSTANCE);
        }

        @Override // com.google.api.JwtLocationOrBuilder
        public final InCase getInCase() {
            return ((JwtLocation) this.instance).getInCase();
        }

        public final Builder clearIn() {
            copyOnWrite();
            ((JwtLocation) this.instance).clearIn();
            return this;
        }

        @Override // com.google.api.JwtLocationOrBuilder
        public final String getHeader() {
            return ((JwtLocation) this.instance).getHeader();
        }

        @Override // com.google.api.JwtLocationOrBuilder
        public final ByteString getHeaderBytes() {
            return ((JwtLocation) this.instance).getHeaderBytes();
        }

        public final Builder setHeader(String str) {
            copyOnWrite();
            ((JwtLocation) this.instance).setHeader(str);
            return this;
        }

        public final Builder clearHeader() {
            copyOnWrite();
            ((JwtLocation) this.instance).clearHeader();
            return this;
        }

        public final Builder setHeaderBytes(ByteString byteString) {
            copyOnWrite();
            ((JwtLocation) this.instance).setHeaderBytes(byteString);
            return this;
        }

        @Override // com.google.api.JwtLocationOrBuilder
        public final String getQuery() {
            return ((JwtLocation) this.instance).getQuery();
        }

        @Override // com.google.api.JwtLocationOrBuilder
        public final ByteString getQueryBytes() {
            return ((JwtLocation) this.instance).getQueryBytes();
        }

        public final Builder setQuery(String str) {
            copyOnWrite();
            ((JwtLocation) this.instance).setQuery(str);
            return this;
        }

        public final Builder clearQuery() {
            copyOnWrite();
            ((JwtLocation) this.instance).clearQuery();
            return this;
        }

        public final Builder setQueryBytes(ByteString byteString) {
            copyOnWrite();
            ((JwtLocation) this.instance).setQueryBytes(byteString);
            return this;
        }

        @Override // com.google.api.JwtLocationOrBuilder
        public final String getValuePrefix() {
            return ((JwtLocation) this.instance).getValuePrefix();
        }

        @Override // com.google.api.JwtLocationOrBuilder
        public final ByteString getValuePrefixBytes() {
            return ((JwtLocation) this.instance).getValuePrefixBytes();
        }

        public final Builder setValuePrefix(String str) {
            copyOnWrite();
            ((JwtLocation) this.instance).setValuePrefix(str);
            return this;
        }

        public final Builder clearValuePrefix() {
            copyOnWrite();
            ((JwtLocation) this.instance).clearValuePrefix();
            return this;
        }

        public final Builder setValuePrefixBytes(ByteString byteString) {
            copyOnWrite();
            ((JwtLocation) this.instance).setValuePrefixBytes(byteString);
            return this;
        }
    }

    /* renamed from: com.google.api.JwtLocation$1  reason: invalid class name */
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
                return new JwtLocation();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȼ\u0000\u0002Ȼ\u0000\u0003Ȉ", new Object[]{"in_", "inCase_", "valuePrefix_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<JwtLocation> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (JwtLocation.class) {
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
        JwtLocation jwtLocation = new JwtLocation();
        DEFAULT_INSTANCE = jwtLocation;
        GeneratedMessageLite.registerDefaultInstance(JwtLocation.class, jwtLocation);
    }

    public static JwtLocation getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<JwtLocation> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
