package com.google.rpc;

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
public final class Status extends GeneratedMessageLite<Status, Builder> implements StatusOrBuilder {
    public static final int CODE_FIELD_NUMBER = 1;
    private static final Status DEFAULT_INSTANCE;
    public static final int DETAILS_FIELD_NUMBER = 3;
    public static final int MESSAGE_FIELD_NUMBER = 2;
    private static volatile Parser<Status> PARSER;
    private int code_;
    private String message_ = "";
    private Internal.ProtobufList<Any> details_ = emptyProtobufList();

    private Status() {
    }

    @Override // com.google.rpc.StatusOrBuilder
    public final int getCode() {
        return this.code_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCode(int i) {
        this.code_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCode() {
        this.code_ = 0;
    }

    @Override // com.google.rpc.StatusOrBuilder
    public final String getMessage() {
        return this.message_;
    }

    @Override // com.google.rpc.StatusOrBuilder
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

    @Override // com.google.rpc.StatusOrBuilder
    public final List<Any> getDetailsList() {
        return this.details_;
    }

    public final List<? extends AnyOrBuilder> getDetailsOrBuilderList() {
        return this.details_;
    }

    @Override // com.google.rpc.StatusOrBuilder
    public final int getDetailsCount() {
        return this.details_.size();
    }

    @Override // com.google.rpc.StatusOrBuilder
    public final Any getDetails(int i) {
        return this.details_.get(i);
    }

    public final AnyOrBuilder getDetailsOrBuilder(int i) {
        return this.details_.get(i);
    }

    private void ensureDetailsIsMutable() {
        Internal.ProtobufList<Any> protobufList = this.details_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.details_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDetails(int i, Any any) {
        ensureDetailsIsMutable();
        this.details_.set(i, any);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDetails(Any any) {
        ensureDetailsIsMutable();
        this.details_.add(any);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addDetails(int i, Any any) {
        ensureDetailsIsMutable();
        this.details_.add(i, any);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllDetails(Iterable<? extends Any> iterable) {
        ensureDetailsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.details_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDetails() {
        this.details_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeDetails(int i) {
        ensureDetailsIsMutable();
        this.details_.remove(i);
    }

    public static Status parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Status) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Status parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Status) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Status parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Status) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Status parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Status) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Status parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Status) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Status parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Status) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Status parseFrom(InputStream inputStream) throws IOException {
        return (Status) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Status parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Status) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Status parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Status) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Status parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Status) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Status parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Status) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Status parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Status) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(Status status) {
        return DEFAULT_INSTANCE.createBuilder(status);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Status, Builder> implements StatusOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(Status.DEFAULT_INSTANCE);
        }

        @Override // com.google.rpc.StatusOrBuilder
        public final int getCode() {
            return ((Status) this.instance).getCode();
        }

        public final Builder setCode(int i) {
            copyOnWrite();
            ((Status) this.instance).setCode(i);
            return this;
        }

        public final Builder clearCode() {
            copyOnWrite();
            ((Status) this.instance).clearCode();
            return this;
        }

        @Override // com.google.rpc.StatusOrBuilder
        public final String getMessage() {
            return ((Status) this.instance).getMessage();
        }

        @Override // com.google.rpc.StatusOrBuilder
        public final ByteString getMessageBytes() {
            return ((Status) this.instance).getMessageBytes();
        }

        public final Builder setMessage(String str) {
            copyOnWrite();
            ((Status) this.instance).setMessage(str);
            return this;
        }

        public final Builder clearMessage() {
            copyOnWrite();
            ((Status) this.instance).clearMessage();
            return this;
        }

        public final Builder setMessageBytes(ByteString byteString) {
            copyOnWrite();
            ((Status) this.instance).setMessageBytes(byteString);
            return this;
        }

        @Override // com.google.rpc.StatusOrBuilder
        public final List<Any> getDetailsList() {
            return Collections.unmodifiableList(((Status) this.instance).getDetailsList());
        }

        @Override // com.google.rpc.StatusOrBuilder
        public final int getDetailsCount() {
            return ((Status) this.instance).getDetailsCount();
        }

        @Override // com.google.rpc.StatusOrBuilder
        public final Any getDetails(int i) {
            return ((Status) this.instance).getDetails(i);
        }

        public final Builder setDetails(int i, Any any) {
            copyOnWrite();
            ((Status) this.instance).setDetails(i, any);
            return this;
        }

        public final Builder setDetails(int i, Any.Builder builder) {
            copyOnWrite();
            ((Status) this.instance).setDetails(i, builder.build());
            return this;
        }

        public final Builder addDetails(Any any) {
            copyOnWrite();
            ((Status) this.instance).addDetails(any);
            return this;
        }

        public final Builder addDetails(int i, Any any) {
            copyOnWrite();
            ((Status) this.instance).addDetails(i, any);
            return this;
        }

        public final Builder addDetails(Any.Builder builder) {
            copyOnWrite();
            ((Status) this.instance).addDetails(builder.build());
            return this;
        }

        public final Builder addDetails(int i, Any.Builder builder) {
            copyOnWrite();
            ((Status) this.instance).addDetails(i, builder.build());
            return this;
        }

        public final Builder addAllDetails(Iterable<? extends Any> iterable) {
            copyOnWrite();
            ((Status) this.instance).addAllDetails(iterable);
            return this;
        }

        public final Builder clearDetails() {
            copyOnWrite();
            ((Status) this.instance).clearDetails();
            return this;
        }

        public final Builder removeDetails(int i) {
            copyOnWrite();
            ((Status) this.instance).removeDetails(i);
            return this;
        }
    }

    /* renamed from: com.google.rpc.Status$1  reason: invalid class name */
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
                return new Status();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u0004\u0002Ȉ\u0003\u001b", new Object[]{"code_", "message_", "details_", Any.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Status> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (Status.class) {
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
        Status status = new Status();
        DEFAULT_INSTANCE = status;
        GeneratedMessageLite.registerDefaultInstance(Status.class, status);
    }

    public static Status getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Status> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
