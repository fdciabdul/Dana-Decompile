package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.Option;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes7.dex */
public final class Method extends GeneratedMessageLite<Method, Builder> implements MethodOrBuilder {
    private static final Method DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 6;
    private static volatile Parser<Method> PARSER = null;
    public static final int REQUEST_STREAMING_FIELD_NUMBER = 3;
    public static final int REQUEST_TYPE_URL_FIELD_NUMBER = 2;
    public static final int RESPONSE_STREAMING_FIELD_NUMBER = 5;
    public static final int RESPONSE_TYPE_URL_FIELD_NUMBER = 4;
    public static final int SYNTAX_FIELD_NUMBER = 7;
    private boolean requestStreaming_;
    private boolean responseStreaming_;
    private int syntax_;
    private String name_ = "";
    private String requestTypeUrl_ = "";
    private String responseTypeUrl_ = "";
    private Internal.ProtobufList<Option> options_ = emptyProtobufList();

    private Method() {
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public final String getName() {
        return this.name_;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public final ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.name_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public final String getRequestTypeUrl() {
        return this.requestTypeUrl_;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public final ByteString getRequestTypeUrlBytes() {
        return ByteString.copyFromUtf8(this.requestTypeUrl_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestTypeUrl(String str) {
        this.requestTypeUrl_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRequestTypeUrl() {
        this.requestTypeUrl_ = getDefaultInstance().getRequestTypeUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestTypeUrlBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.requestTypeUrl_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public final boolean getRequestStreaming() {
        return this.requestStreaming_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestStreaming(boolean z) {
        this.requestStreaming_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRequestStreaming() {
        this.requestStreaming_ = false;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public final String getResponseTypeUrl() {
        return this.responseTypeUrl_;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public final ByteString getResponseTypeUrlBytes() {
        return ByteString.copyFromUtf8(this.responseTypeUrl_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResponseTypeUrl(String str) {
        this.responseTypeUrl_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResponseTypeUrl() {
        this.responseTypeUrl_ = getDefaultInstance().getResponseTypeUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResponseTypeUrlBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.responseTypeUrl_ = byteString.toStringUtf8();
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public final boolean getResponseStreaming() {
        return this.responseStreaming_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResponseStreaming(boolean z) {
        this.responseStreaming_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResponseStreaming() {
        this.responseStreaming_ = false;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public final List<Option> getOptionsList() {
        return this.options_;
    }

    public final List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public final int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public final Option getOptions(int i) {
        return this.options_.get(i);
    }

    public final OptionOrBuilder getOptionsOrBuilder(int i) {
        return this.options_.get(i);
    }

    private void ensureOptionsIsMutable() {
        Internal.ProtobufList<Option> protobufList = this.options_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.options_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOptions(int i, Option option) {
        ensureOptionsIsMutable();
        this.options_.set(i, option);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOptions(Option option) {
        ensureOptionsIsMutable();
        this.options_.add(option);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOptions(int i, Option option) {
        ensureOptionsIsMutable();
        this.options_.add(i, option);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllOptions(Iterable<? extends Option> iterable) {
        ensureOptionsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.options_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOptions() {
        this.options_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeOptions(int i) {
        ensureOptionsIsMutable();
        this.options_.remove(i);
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public final int getSyntaxValue() {
        return this.syntax_;
    }

    @Override // com.google.protobuf.MethodOrBuilder
    public final Syntax getSyntax() {
        Syntax forNumber = Syntax.forNumber(this.syntax_);
        return forNumber == null ? Syntax.UNRECOGNIZED : forNumber;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSyntaxValue(int i) {
        this.syntax_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSyntax(Syntax syntax) {
        this.syntax_ = syntax.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSyntax() {
        this.syntax_ = 0;
    }

    public static Method parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Method) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Method parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Method) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Method parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Method) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Method parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Method) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Method parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Method) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Method parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Method) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Method parseFrom(InputStream inputStream) throws IOException {
        return (Method) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Method parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Method) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Method parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Method) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Method parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Method) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Method parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Method) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Method parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Method) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(Method method) {
        return DEFAULT_INSTANCE.createBuilder(method);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Method, Builder> implements MethodOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(Method.DEFAULT_INSTANCE);
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public final String getName() {
            return ((Method) this.instance).getName();
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public final ByteString getNameBytes() {
            return ((Method) this.instance).getNameBytes();
        }

        public final Builder setName(String str) {
            copyOnWrite();
            ((Method) this.instance).setName(str);
            return this;
        }

        public final Builder clearName() {
            copyOnWrite();
            ((Method) this.instance).clearName();
            return this;
        }

        public final Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            ((Method) this.instance).setNameBytes(byteString);
            return this;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public final String getRequestTypeUrl() {
            return ((Method) this.instance).getRequestTypeUrl();
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public final ByteString getRequestTypeUrlBytes() {
            return ((Method) this.instance).getRequestTypeUrlBytes();
        }

        public final Builder setRequestTypeUrl(String str) {
            copyOnWrite();
            ((Method) this.instance).setRequestTypeUrl(str);
            return this;
        }

        public final Builder clearRequestTypeUrl() {
            copyOnWrite();
            ((Method) this.instance).clearRequestTypeUrl();
            return this;
        }

        public final Builder setRequestTypeUrlBytes(ByteString byteString) {
            copyOnWrite();
            ((Method) this.instance).setRequestTypeUrlBytes(byteString);
            return this;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public final boolean getRequestStreaming() {
            return ((Method) this.instance).getRequestStreaming();
        }

        public final Builder setRequestStreaming(boolean z) {
            copyOnWrite();
            ((Method) this.instance).setRequestStreaming(z);
            return this;
        }

        public final Builder clearRequestStreaming() {
            copyOnWrite();
            ((Method) this.instance).clearRequestStreaming();
            return this;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public final String getResponseTypeUrl() {
            return ((Method) this.instance).getResponseTypeUrl();
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public final ByteString getResponseTypeUrlBytes() {
            return ((Method) this.instance).getResponseTypeUrlBytes();
        }

        public final Builder setResponseTypeUrl(String str) {
            copyOnWrite();
            ((Method) this.instance).setResponseTypeUrl(str);
            return this;
        }

        public final Builder clearResponseTypeUrl() {
            copyOnWrite();
            ((Method) this.instance).clearResponseTypeUrl();
            return this;
        }

        public final Builder setResponseTypeUrlBytes(ByteString byteString) {
            copyOnWrite();
            ((Method) this.instance).setResponseTypeUrlBytes(byteString);
            return this;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public final boolean getResponseStreaming() {
            return ((Method) this.instance).getResponseStreaming();
        }

        public final Builder setResponseStreaming(boolean z) {
            copyOnWrite();
            ((Method) this.instance).setResponseStreaming(z);
            return this;
        }

        public final Builder clearResponseStreaming() {
            copyOnWrite();
            ((Method) this.instance).clearResponseStreaming();
            return this;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public final List<Option> getOptionsList() {
            return Collections.unmodifiableList(((Method) this.instance).getOptionsList());
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public final int getOptionsCount() {
            return ((Method) this.instance).getOptionsCount();
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public final Option getOptions(int i) {
            return ((Method) this.instance).getOptions(i);
        }

        public final Builder setOptions(int i, Option option) {
            copyOnWrite();
            ((Method) this.instance).setOptions(i, option);
            return this;
        }

        public final Builder setOptions(int i, Option.Builder builder) {
            copyOnWrite();
            ((Method) this.instance).setOptions(i, builder.build());
            return this;
        }

        public final Builder addOptions(Option option) {
            copyOnWrite();
            ((Method) this.instance).addOptions(option);
            return this;
        }

        public final Builder addOptions(int i, Option option) {
            copyOnWrite();
            ((Method) this.instance).addOptions(i, option);
            return this;
        }

        public final Builder addOptions(Option.Builder builder) {
            copyOnWrite();
            ((Method) this.instance).addOptions(builder.build());
            return this;
        }

        public final Builder addOptions(int i, Option.Builder builder) {
            copyOnWrite();
            ((Method) this.instance).addOptions(i, builder.build());
            return this;
        }

        public final Builder addAllOptions(Iterable<? extends Option> iterable) {
            copyOnWrite();
            ((Method) this.instance).addAllOptions(iterable);
            return this;
        }

        public final Builder clearOptions() {
            copyOnWrite();
            ((Method) this.instance).clearOptions();
            return this;
        }

        public final Builder removeOptions(int i) {
            copyOnWrite();
            ((Method) this.instance).removeOptions(i);
            return this;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public final int getSyntaxValue() {
            return ((Method) this.instance).getSyntaxValue();
        }

        public final Builder setSyntaxValue(int i) {
            copyOnWrite();
            ((Method) this.instance).setSyntaxValue(i);
            return this;
        }

        @Override // com.google.protobuf.MethodOrBuilder
        public final Syntax getSyntax() {
            return ((Method) this.instance).getSyntax();
        }

        public final Builder setSyntax(Syntax syntax) {
            copyOnWrite();
            ((Method) this.instance).setSyntax(syntax);
            return this;
        }

        public final Builder clearSyntax() {
            copyOnWrite();
            ((Method) this.instance).clearSyntax();
            return this;
        }
    }

    /* renamed from: com.google.protobuf.Method$1  reason: invalid class name */
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
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser parser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Method();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u0007\u0004Ȉ\u0005\u0007\u0006\u001b\u0007\f", new Object[]{"name_", "requestTypeUrl_", "requestStreaming_", "responseTypeUrl_", "responseStreaming_", "options_", Option.class, "syntax_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Method> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (Method.class) {
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
        Method method = new Method();
        DEFAULT_INSTANCE = method;
        GeneratedMessageLite.registerDefaultInstance(Method.class, method);
    }

    public static Method getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Method> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
