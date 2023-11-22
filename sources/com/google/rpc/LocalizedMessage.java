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
public final class LocalizedMessage extends GeneratedMessageLite<LocalizedMessage, Builder> implements LocalizedMessageOrBuilder {
    private static final LocalizedMessage DEFAULT_INSTANCE;
    public static final int LOCALE_FIELD_NUMBER = 1;
    public static final int MESSAGE_FIELD_NUMBER = 2;
    private static volatile Parser<LocalizedMessage> PARSER;
    private String locale_ = "";
    private String message_ = "";

    private LocalizedMessage() {
    }

    @Override // com.google.rpc.LocalizedMessageOrBuilder
    public final String getLocale() {
        return this.locale_;
    }

    @Override // com.google.rpc.LocalizedMessageOrBuilder
    public final ByteString getLocaleBytes() {
        return ByteString.copyFromUtf8(this.locale_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLocale(String str) {
        this.locale_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLocale() {
        this.locale_ = getDefaultInstance().getLocale();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLocaleBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.locale_ = byteString.toStringUtf8();
    }

    @Override // com.google.rpc.LocalizedMessageOrBuilder
    public final String getMessage() {
        return this.message_;
    }

    @Override // com.google.rpc.LocalizedMessageOrBuilder
    public final ByteString getMessageBytes() {
        return ByteString.copyFromUtf8(this.message_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessage(String str) {
        this.message_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMessage() {
        this.message_ = getDefaultInstance().getMessage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMessageBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.message_ = byteString.toStringUtf8();
    }

    public static LocalizedMessage parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (LocalizedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static LocalizedMessage parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LocalizedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static LocalizedMessage parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (LocalizedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static LocalizedMessage parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LocalizedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static LocalizedMessage parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (LocalizedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static LocalizedMessage parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (LocalizedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static LocalizedMessage parseFrom(InputStream inputStream) throws IOException {
        return (LocalizedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LocalizedMessage parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LocalizedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static LocalizedMessage parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (LocalizedMessage) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static LocalizedMessage parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LocalizedMessage) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static LocalizedMessage parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (LocalizedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static LocalizedMessage parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (LocalizedMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(LocalizedMessage localizedMessage) {
        return DEFAULT_INSTANCE.createBuilder(localizedMessage);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<LocalizedMessage, Builder> implements LocalizedMessageOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(LocalizedMessage.DEFAULT_INSTANCE);
        }

        @Override // com.google.rpc.LocalizedMessageOrBuilder
        public final String getLocale() {
            return ((LocalizedMessage) this.instance).getLocale();
        }

        @Override // com.google.rpc.LocalizedMessageOrBuilder
        public final ByteString getLocaleBytes() {
            return ((LocalizedMessage) this.instance).getLocaleBytes();
        }

        public final Builder setLocale(String str) {
            copyOnWrite();
            ((LocalizedMessage) this.instance).setLocale(str);
            return this;
        }

        public final Builder clearLocale() {
            copyOnWrite();
            ((LocalizedMessage) this.instance).clearLocale();
            return this;
        }

        public final Builder setLocaleBytes(ByteString byteString) {
            copyOnWrite();
            ((LocalizedMessage) this.instance).setLocaleBytes(byteString);
            return this;
        }

        @Override // com.google.rpc.LocalizedMessageOrBuilder
        public final String getMessage() {
            return ((LocalizedMessage) this.instance).getMessage();
        }

        @Override // com.google.rpc.LocalizedMessageOrBuilder
        public final ByteString getMessageBytes() {
            return ((LocalizedMessage) this.instance).getMessageBytes();
        }

        public final Builder setMessage(String str) {
            copyOnWrite();
            ((LocalizedMessage) this.instance).setMessage(str);
            return this;
        }

        public final Builder clearMessage() {
            copyOnWrite();
            ((LocalizedMessage) this.instance).clearMessage();
            return this;
        }

        public final Builder setMessageBytes(ByteString byteString) {
            copyOnWrite();
            ((LocalizedMessage) this.instance).setMessageBytes(byteString);
            return this;
        }
    }

    /* renamed from: com.google.rpc.LocalizedMessage$1  reason: invalid class name */
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
                return new LocalizedMessage();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"locale_", "message_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<LocalizedMessage> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (LocalizedMessage.class) {
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
        LocalizedMessage localizedMessage = new LocalizedMessage();
        DEFAULT_INSTANCE = localizedMessage;
        GeneratedMessageLite.registerDefaultInstance(LocalizedMessage.class, localizedMessage);
    }

    public static LocalizedMessage getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<LocalizedMessage> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
