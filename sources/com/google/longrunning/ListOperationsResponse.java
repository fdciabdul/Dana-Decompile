package com.google.longrunning;

import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessageLite;
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
public final class ListOperationsResponse extends GeneratedMessageLite<ListOperationsResponse, Builder> implements ListOperationsResponseOrBuilder {
    private static final ListOperationsResponse DEFAULT_INSTANCE;
    public static final int NEXT_PAGE_TOKEN_FIELD_NUMBER = 2;
    public static final int OPERATIONS_FIELD_NUMBER = 1;
    private static volatile Parser<ListOperationsResponse> PARSER;
    private Internal.ProtobufList<Operation> operations_ = emptyProtobufList();
    private String nextPageToken_ = "";

    private ListOperationsResponse() {
    }

    @Override // com.google.longrunning.ListOperationsResponseOrBuilder
    public final List<Operation> getOperationsList() {
        return this.operations_;
    }

    public final List<? extends OperationOrBuilder> getOperationsOrBuilderList() {
        return this.operations_;
    }

    @Override // com.google.longrunning.ListOperationsResponseOrBuilder
    public final int getOperationsCount() {
        return this.operations_.size();
    }

    @Override // com.google.longrunning.ListOperationsResponseOrBuilder
    public final Operation getOperations(int i) {
        return this.operations_.get(i);
    }

    public final OperationOrBuilder getOperationsOrBuilder(int i) {
        return this.operations_.get(i);
    }

    private void ensureOperationsIsMutable() {
        Internal.ProtobufList<Operation> protobufList = this.operations_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.operations_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOperations(int i, Operation operation) {
        ensureOperationsIsMutable();
        this.operations_.set(i, operation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOperations(Operation operation) {
        ensureOperationsIsMutable();
        this.operations_.add(operation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOperations(int i, Operation operation) {
        ensureOperationsIsMutable();
        this.operations_.add(i, operation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllOperations(Iterable<? extends Operation> iterable) {
        ensureOperationsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.operations_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOperations() {
        this.operations_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeOperations(int i) {
        ensureOperationsIsMutable();
        this.operations_.remove(i);
    }

    @Override // com.google.longrunning.ListOperationsResponseOrBuilder
    public final String getNextPageToken() {
        return this.nextPageToken_;
    }

    @Override // com.google.longrunning.ListOperationsResponseOrBuilder
    public final ByteString getNextPageTokenBytes() {
        return ByteString.copyFromUtf8(this.nextPageToken_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNextPageToken(String str) {
        this.nextPageToken_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNextPageToken() {
        this.nextPageToken_ = getDefaultInstance().getNextPageToken();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNextPageTokenBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.nextPageToken_ = byteString.toStringUtf8();
    }

    public static ListOperationsResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ListOperationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static ListOperationsResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ListOperationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ListOperationsResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ListOperationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ListOperationsResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ListOperationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ListOperationsResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ListOperationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ListOperationsResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ListOperationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ListOperationsResponse parseFrom(InputStream inputStream) throws IOException {
        return (ListOperationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ListOperationsResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ListOperationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListOperationsResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ListOperationsResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ListOperationsResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ListOperationsResponse) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListOperationsResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ListOperationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ListOperationsResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ListOperationsResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(ListOperationsResponse listOperationsResponse) {
        return DEFAULT_INSTANCE.createBuilder(listOperationsResponse);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<ListOperationsResponse, Builder> implements ListOperationsResponseOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(ListOperationsResponse.DEFAULT_INSTANCE);
        }

        @Override // com.google.longrunning.ListOperationsResponseOrBuilder
        public final List<Operation> getOperationsList() {
            return Collections.unmodifiableList(((ListOperationsResponse) this.instance).getOperationsList());
        }

        @Override // com.google.longrunning.ListOperationsResponseOrBuilder
        public final int getOperationsCount() {
            return ((ListOperationsResponse) this.instance).getOperationsCount();
        }

        @Override // com.google.longrunning.ListOperationsResponseOrBuilder
        public final Operation getOperations(int i) {
            return ((ListOperationsResponse) this.instance).getOperations(i);
        }

        public final Builder setOperations(int i, Operation operation) {
            copyOnWrite();
            ((ListOperationsResponse) this.instance).setOperations(i, operation);
            return this;
        }

        public final Builder setOperations(int i, Operation.Builder builder) {
            copyOnWrite();
            ((ListOperationsResponse) this.instance).setOperations(i, builder.build());
            return this;
        }

        public final Builder addOperations(Operation operation) {
            copyOnWrite();
            ((ListOperationsResponse) this.instance).addOperations(operation);
            return this;
        }

        public final Builder addOperations(int i, Operation operation) {
            copyOnWrite();
            ((ListOperationsResponse) this.instance).addOperations(i, operation);
            return this;
        }

        public final Builder addOperations(Operation.Builder builder) {
            copyOnWrite();
            ((ListOperationsResponse) this.instance).addOperations(builder.build());
            return this;
        }

        public final Builder addOperations(int i, Operation.Builder builder) {
            copyOnWrite();
            ((ListOperationsResponse) this.instance).addOperations(i, builder.build());
            return this;
        }

        public final Builder addAllOperations(Iterable<? extends Operation> iterable) {
            copyOnWrite();
            ((ListOperationsResponse) this.instance).addAllOperations(iterable);
            return this;
        }

        public final Builder clearOperations() {
            copyOnWrite();
            ((ListOperationsResponse) this.instance).clearOperations();
            return this;
        }

        public final Builder removeOperations(int i) {
            copyOnWrite();
            ((ListOperationsResponse) this.instance).removeOperations(i);
            return this;
        }

        @Override // com.google.longrunning.ListOperationsResponseOrBuilder
        public final String getNextPageToken() {
            return ((ListOperationsResponse) this.instance).getNextPageToken();
        }

        @Override // com.google.longrunning.ListOperationsResponseOrBuilder
        public final ByteString getNextPageTokenBytes() {
            return ((ListOperationsResponse) this.instance).getNextPageTokenBytes();
        }

        public final Builder setNextPageToken(String str) {
            copyOnWrite();
            ((ListOperationsResponse) this.instance).setNextPageToken(str);
            return this;
        }

        public final Builder clearNextPageToken() {
            copyOnWrite();
            ((ListOperationsResponse) this.instance).clearNextPageToken();
            return this;
        }

        public final Builder setNextPageTokenBytes(ByteString byteString) {
            copyOnWrite();
            ((ListOperationsResponse) this.instance).setNextPageTokenBytes(byteString);
            return this;
        }
    }

    /* renamed from: com.google.longrunning.ListOperationsResponse$1  reason: invalid class name */
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
                return new ListOperationsResponse();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002Ȉ", new Object[]{"operations_", Operation.class, "nextPageToken_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ListOperationsResponse> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (ListOperationsResponse.class) {
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
        ListOperationsResponse listOperationsResponse = new ListOperationsResponse();
        DEFAULT_INSTANCE = listOperationsResponse;
        GeneratedMessageLite.registerDefaultInstance(ListOperationsResponse.class, listOperationsResponse);
    }

    public static ListOperationsResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<ListOperationsResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
