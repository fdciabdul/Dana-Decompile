package com.google.api;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
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
public final class HttpBody extends GeneratedMessageLite<HttpBody, Builder> implements HttpBodyOrBuilder {
    public static final int CONTENT_TYPE_FIELD_NUMBER = 1;
    public static final int DATA_FIELD_NUMBER = 2;
    private static final HttpBody DEFAULT_INSTANCE;
    public static final int EXTENSIONS_FIELD_NUMBER = 3;
    private static volatile Parser<HttpBody> PARSER;
    private String contentType_ = "";
    private ByteString data_ = ByteString.EMPTY;
    private Internal.ProtobufList<Any> extensions_ = emptyProtobufList();

    private HttpBody() {
    }

    @Override // com.google.api.HttpBodyOrBuilder
    public final String getContentType() {
        return this.contentType_;
    }

    @Override // com.google.api.HttpBodyOrBuilder
    public final ByteString getContentTypeBytes() {
        return ByteString.copyFromUtf8(this.contentType_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContentType(String str) {
        this.contentType_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearContentType() {
        this.contentType_ = getDefaultInstance().getContentType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setContentTypeBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.contentType_ = byteString.toStringUtf8();
    }

    @Override // com.google.api.HttpBodyOrBuilder
    public final ByteString getData() {
        return this.data_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setData(ByteString byteString) {
        this.data_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearData() {
        this.data_ = getDefaultInstance().getData();
    }

    @Override // com.google.api.HttpBodyOrBuilder
    public final List<Any> getExtensionsList() {
        return this.extensions_;
    }

    public final List<? extends AnyOrBuilder> getExtensionsOrBuilderList() {
        return this.extensions_;
    }

    @Override // com.google.api.HttpBodyOrBuilder
    public final int getExtensionsCount() {
        return this.extensions_.size();
    }

    @Override // com.google.api.HttpBodyOrBuilder
    public final Any getExtensions(int i) {
        return this.extensions_.get(i);
    }

    public final AnyOrBuilder getExtensionsOrBuilder(int i) {
        return this.extensions_.get(i);
    }

    private void ensureExtensionsIsMutable() {
        Internal.ProtobufList<Any> protobufList = this.extensions_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.extensions_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setExtensions(int i, Any any) {
        ensureExtensionsIsMutable();
        this.extensions_.set(i, any);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addExtensions(Any any) {
        ensureExtensionsIsMutable();
        this.extensions_.add(any);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addExtensions(int i, Any any) {
        ensureExtensionsIsMutable();
        this.extensions_.add(i, any);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllExtensions(Iterable<? extends Any> iterable) {
        ensureExtensionsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.extensions_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearExtensions() {
        this.extensions_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeExtensions(int i) {
        ensureExtensionsIsMutable();
        this.extensions_.remove(i);
    }

    public static HttpBody parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (HttpBody) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static HttpBody parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HttpBody) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static HttpBody parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (HttpBody) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static HttpBody parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HttpBody) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static HttpBody parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (HttpBody) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static HttpBody parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HttpBody) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static HttpBody parseFrom(InputStream inputStream) throws IOException {
        return (HttpBody) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HttpBody parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HttpBody) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HttpBody parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (HttpBody) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static HttpBody parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HttpBody) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HttpBody parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (HttpBody) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static HttpBody parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HttpBody) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(HttpBody httpBody) {
        return DEFAULT_INSTANCE.createBuilder(httpBody);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<HttpBody, Builder> implements HttpBodyOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(HttpBody.DEFAULT_INSTANCE);
        }

        @Override // com.google.api.HttpBodyOrBuilder
        public final String getContentType() {
            return ((HttpBody) this.instance).getContentType();
        }

        @Override // com.google.api.HttpBodyOrBuilder
        public final ByteString getContentTypeBytes() {
            return ((HttpBody) this.instance).getContentTypeBytes();
        }

        public final Builder setContentType(String str) {
            copyOnWrite();
            ((HttpBody) this.instance).setContentType(str);
            return this;
        }

        public final Builder clearContentType() {
            copyOnWrite();
            ((HttpBody) this.instance).clearContentType();
            return this;
        }

        public final Builder setContentTypeBytes(ByteString byteString) {
            copyOnWrite();
            ((HttpBody) this.instance).setContentTypeBytes(byteString);
            return this;
        }

        @Override // com.google.api.HttpBodyOrBuilder
        public final ByteString getData() {
            return ((HttpBody) this.instance).getData();
        }

        public final Builder setData(ByteString byteString) {
            copyOnWrite();
            ((HttpBody) this.instance).setData(byteString);
            return this;
        }

        public final Builder clearData() {
            copyOnWrite();
            ((HttpBody) this.instance).clearData();
            return this;
        }

        @Override // com.google.api.HttpBodyOrBuilder
        public final List<Any> getExtensionsList() {
            return Collections.unmodifiableList(((HttpBody) this.instance).getExtensionsList());
        }

        @Override // com.google.api.HttpBodyOrBuilder
        public final int getExtensionsCount() {
            return ((HttpBody) this.instance).getExtensionsCount();
        }

        @Override // com.google.api.HttpBodyOrBuilder
        public final Any getExtensions(int i) {
            return ((HttpBody) this.instance).getExtensions(i);
        }

        public final Builder setExtensions(int i, Any any) {
            copyOnWrite();
            ((HttpBody) this.instance).setExtensions(i, any);
            return this;
        }

        public final Builder setExtensions(int i, Any.Builder builder) {
            copyOnWrite();
            ((HttpBody) this.instance).setExtensions(i, builder.build());
            return this;
        }

        public final Builder addExtensions(Any any) {
            copyOnWrite();
            ((HttpBody) this.instance).addExtensions(any);
            return this;
        }

        public final Builder addExtensions(int i, Any any) {
            copyOnWrite();
            ((HttpBody) this.instance).addExtensions(i, any);
            return this;
        }

        public final Builder addExtensions(Any.Builder builder) {
            copyOnWrite();
            ((HttpBody) this.instance).addExtensions(builder.build());
            return this;
        }

        public final Builder addExtensions(int i, Any.Builder builder) {
            copyOnWrite();
            ((HttpBody) this.instance).addExtensions(i, builder.build());
            return this;
        }

        public final Builder addAllExtensions(Iterable<? extends Any> iterable) {
            copyOnWrite();
            ((HttpBody) this.instance).addAllExtensions(iterable);
            return this;
        }

        public final Builder clearExtensions() {
            copyOnWrite();
            ((HttpBody) this.instance).clearExtensions();
            return this;
        }

        public final Builder removeExtensions(int i) {
            copyOnWrite();
            ((HttpBody) this.instance).removeExtensions(i);
            return this;
        }
    }

    /* renamed from: com.google.api.HttpBody$1  reason: invalid class name */
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
                return new HttpBody();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȉ\u0002\n\u0003\u001b", new Object[]{"contentType_", "data_", "extensions_", Any.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<HttpBody> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (HttpBody.class) {
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
        HttpBody httpBody = new HttpBody();
        DEFAULT_INSTANCE = httpBody;
        GeneratedMessageLite.registerDefaultInstance(HttpBody.class, httpBody);
    }

    public static HttpBody getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<HttpBody> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
