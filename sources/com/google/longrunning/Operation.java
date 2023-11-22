package com.google.longrunning;

import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.rpc.Status;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes7.dex */
public final class Operation extends GeneratedMessageLite<Operation, Builder> implements OperationOrBuilder {
    private static final Operation DEFAULT_INSTANCE;
    public static final int DONE_FIELD_NUMBER = 3;
    public static final int ERROR_FIELD_NUMBER = 4;
    public static final int METADATA_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<Operation> PARSER = null;
    public static final int RESPONSE_FIELD_NUMBER = 5;
    private boolean done_;
    private Any metadata_;
    private Object result_;
    private int resultCase_ = 0;
    private String name_ = "";

    private Operation() {
    }

    /* loaded from: classes7.dex */
    public enum ResultCase {
        ERROR(4),
        RESPONSE(5),
        RESULT_NOT_SET(0);

        private final int value;

        ResultCase(int i) {
            this.value = i;
        }

        @Deprecated
        public static ResultCase valueOf(int i) {
            return forNumber(i);
        }

        public static ResultCase forNumber(int i) {
            if (i != 0) {
                if (i != 4) {
                    if (i != 5) {
                        return null;
                    }
                    return RESPONSE;
                }
                return ERROR;
            }
            return RESULT_NOT_SET;
        }

        public final int getNumber() {
            return this.value;
        }
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public final ResultCase getResultCase() {
        return ResultCase.forNumber(this.resultCase_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResult() {
        this.resultCase_ = 0;
        this.result_ = null;
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public final String getName() {
        return this.name_;
    }

    @Override // com.google.longrunning.OperationOrBuilder
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

    @Override // com.google.longrunning.OperationOrBuilder
    public final boolean hasMetadata() {
        return this.metadata_ != null;
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public final Any getMetadata() {
        Any any = this.metadata_;
        return any == null ? Any.getDefaultInstance() : any;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetadata(Any any) {
        this.metadata_ = any;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeMetadata(Any any) {
        Any any2 = this.metadata_;
        if (any2 != null && any2 != Any.getDefaultInstance()) {
            this.metadata_ = Any.newBuilder(this.metadata_).mergeFrom((Any.Builder) any).buildPartial();
        } else {
            this.metadata_ = any;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMetadata() {
        this.metadata_ = null;
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public final boolean getDone() {
        return this.done_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDone(boolean z) {
        this.done_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDone() {
        this.done_ = false;
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public final boolean hasError() {
        return this.resultCase_ == 4;
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public final Status getError() {
        if (this.resultCase_ == 4) {
            return (Status) this.result_;
        }
        return Status.getDefaultInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setError(Status status) {
        this.result_ = status;
        this.resultCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeError(Status status) {
        if (this.resultCase_ == 4 && this.result_ != Status.getDefaultInstance()) {
            this.result_ = Status.newBuilder((Status) this.result_).mergeFrom((Status.Builder) status).buildPartial();
        } else {
            this.result_ = status;
        }
        this.resultCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearError() {
        if (this.resultCase_ == 4) {
            this.resultCase_ = 0;
            this.result_ = null;
        }
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public final boolean hasResponse() {
        return this.resultCase_ == 5;
    }

    @Override // com.google.longrunning.OperationOrBuilder
    public final Any getResponse() {
        if (this.resultCase_ == 5) {
            return (Any) this.result_;
        }
        return Any.getDefaultInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResponse(Any any) {
        this.result_ = any;
        this.resultCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeResponse(Any any) {
        if (this.resultCase_ == 5 && this.result_ != Any.getDefaultInstance()) {
            this.result_ = Any.newBuilder((Any) this.result_).mergeFrom((Any.Builder) any).buildPartial();
        } else {
            this.result_ = any;
        }
        this.resultCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResponse() {
        if (this.resultCase_ == 5) {
            this.resultCase_ = 0;
            this.result_ = null;
        }
    }

    public static Operation parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Operation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Operation parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Operation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Operation parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Operation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Operation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Operation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Operation parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Operation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Operation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Operation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Operation parseFrom(InputStream inputStream) throws IOException {
        return (Operation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Operation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Operation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Operation parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Operation) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Operation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Operation) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Operation parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Operation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Operation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Operation) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(Operation operation) {
        return DEFAULT_INSTANCE.createBuilder(operation);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Operation, Builder> implements OperationOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(Operation.DEFAULT_INSTANCE);
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public final ResultCase getResultCase() {
            return ((Operation) this.instance).getResultCase();
        }

        public final Builder clearResult() {
            copyOnWrite();
            ((Operation) this.instance).clearResult();
            return this;
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public final String getName() {
            return ((Operation) this.instance).getName();
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public final ByteString getNameBytes() {
            return ((Operation) this.instance).getNameBytes();
        }

        public final Builder setName(String str) {
            copyOnWrite();
            ((Operation) this.instance).setName(str);
            return this;
        }

        public final Builder clearName() {
            copyOnWrite();
            ((Operation) this.instance).clearName();
            return this;
        }

        public final Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            ((Operation) this.instance).setNameBytes(byteString);
            return this;
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public final boolean hasMetadata() {
            return ((Operation) this.instance).hasMetadata();
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public final Any getMetadata() {
            return ((Operation) this.instance).getMetadata();
        }

        public final Builder setMetadata(Any any) {
            copyOnWrite();
            ((Operation) this.instance).setMetadata(any);
            return this;
        }

        public final Builder setMetadata(Any.Builder builder) {
            copyOnWrite();
            ((Operation) this.instance).setMetadata(builder.build());
            return this;
        }

        public final Builder mergeMetadata(Any any) {
            copyOnWrite();
            ((Operation) this.instance).mergeMetadata(any);
            return this;
        }

        public final Builder clearMetadata() {
            copyOnWrite();
            ((Operation) this.instance).clearMetadata();
            return this;
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public final boolean getDone() {
            return ((Operation) this.instance).getDone();
        }

        public final Builder setDone(boolean z) {
            copyOnWrite();
            ((Operation) this.instance).setDone(z);
            return this;
        }

        public final Builder clearDone() {
            copyOnWrite();
            ((Operation) this.instance).clearDone();
            return this;
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public final boolean hasError() {
            return ((Operation) this.instance).hasError();
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public final Status getError() {
            return ((Operation) this.instance).getError();
        }

        public final Builder setError(Status status) {
            copyOnWrite();
            ((Operation) this.instance).setError(status);
            return this;
        }

        public final Builder setError(Status.Builder builder) {
            copyOnWrite();
            ((Operation) this.instance).setError(builder.build());
            return this;
        }

        public final Builder mergeError(Status status) {
            copyOnWrite();
            ((Operation) this.instance).mergeError(status);
            return this;
        }

        public final Builder clearError() {
            copyOnWrite();
            ((Operation) this.instance).clearError();
            return this;
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public final boolean hasResponse() {
            return ((Operation) this.instance).hasResponse();
        }

        @Override // com.google.longrunning.OperationOrBuilder
        public final Any getResponse() {
            return ((Operation) this.instance).getResponse();
        }

        public final Builder setResponse(Any any) {
            copyOnWrite();
            ((Operation) this.instance).setResponse(any);
            return this;
        }

        public final Builder setResponse(Any.Builder builder) {
            copyOnWrite();
            ((Operation) this.instance).setResponse(builder.build());
            return this;
        }

        public final Builder mergeResponse(Any any) {
            copyOnWrite();
            ((Operation) this.instance).mergeResponse(any);
            return this;
        }

        public final Builder clearResponse() {
            copyOnWrite();
            ((Operation) this.instance).clearResponse();
            return this;
        }
    }

    /* renamed from: com.google.longrunning.Operation$1  reason: invalid class name */
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
                return new Operation();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0001\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002\t\u0003\u0007\u0004<\u0000\u0005<\u0000", new Object[]{"result_", "resultCase_", "name_", "metadata_", "done_", Status.class, Any.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Operation> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (Operation.class) {
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
        Operation operation = new Operation();
        DEFAULT_INSTANCE = operation;
        GeneratedMessageLite.registerDefaultInstance(Operation.class, operation);
    }

    public static Operation getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Operation> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
