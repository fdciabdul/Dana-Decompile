package com.google.rpc;

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
public final class DebugInfo extends GeneratedMessageLite<DebugInfo, Builder> implements DebugInfoOrBuilder {
    private static final DebugInfo DEFAULT_INSTANCE;
    public static final int DETAIL_FIELD_NUMBER = 2;
    private static volatile Parser<DebugInfo> PARSER = null;
    public static final int STACK_ENTRIES_FIELD_NUMBER = 1;
    private Internal.ProtobufList<String> stackEntries_ = GeneratedMessageLite.emptyProtobufList();
    private String detail_ = "";

    private DebugInfo() {
    }

    @Override // com.google.rpc.DebugInfoOrBuilder
    public final List<String> getStackEntriesList() {
        return this.stackEntries_;
    }

    @Override // com.google.rpc.DebugInfoOrBuilder
    public final int getStackEntriesCount() {
        return this.stackEntries_.size();
    }

    @Override // com.google.rpc.DebugInfoOrBuilder
    public final String getStackEntries(int i) {
        return this.stackEntries_.get(i);
    }

    @Override // com.google.rpc.DebugInfoOrBuilder
    public final ByteString getStackEntriesBytes(int i) {
        return ByteString.copyFromUtf8(this.stackEntries_.get(i));
    }

    private void ensureStackEntriesIsMutable() {
        Internal.ProtobufList<String> protobufList = this.stackEntries_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.stackEntries_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStackEntries(int i, String str) {
        ensureStackEntriesIsMutable();
        this.stackEntries_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addStackEntries(String str) {
        ensureStackEntriesIsMutable();
        this.stackEntries_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllStackEntries(Iterable<String> iterable) {
        ensureStackEntriesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.stackEntries_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStackEntries() {
        this.stackEntries_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addStackEntriesBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        ensureStackEntriesIsMutable();
        this.stackEntries_.add(byteString.toStringUtf8());
    }

    @Override // com.google.rpc.DebugInfoOrBuilder
    public final String getDetail() {
        return this.detail_;
    }

    @Override // com.google.rpc.DebugInfoOrBuilder
    public final ByteString getDetailBytes() {
        return ByteString.copyFromUtf8(this.detail_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDetail(String str) {
        this.detail_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDetail() {
        this.detail_ = getDefaultInstance().getDetail();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDetailBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.detail_ = byteString.toStringUtf8();
    }

    public static DebugInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (DebugInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static DebugInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (DebugInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static DebugInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (DebugInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static DebugInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (DebugInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static DebugInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (DebugInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static DebugInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (DebugInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static DebugInfo parseFrom(InputStream inputStream) throws IOException {
        return (DebugInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DebugInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (DebugInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DebugInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (DebugInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static DebugInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (DebugInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DebugInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (DebugInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static DebugInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (DebugInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(DebugInfo debugInfo) {
        return DEFAULT_INSTANCE.createBuilder(debugInfo);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<DebugInfo, Builder> implements DebugInfoOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(DebugInfo.DEFAULT_INSTANCE);
        }

        @Override // com.google.rpc.DebugInfoOrBuilder
        public final List<String> getStackEntriesList() {
            return Collections.unmodifiableList(((DebugInfo) this.instance).getStackEntriesList());
        }

        @Override // com.google.rpc.DebugInfoOrBuilder
        public final int getStackEntriesCount() {
            return ((DebugInfo) this.instance).getStackEntriesCount();
        }

        @Override // com.google.rpc.DebugInfoOrBuilder
        public final String getStackEntries(int i) {
            return ((DebugInfo) this.instance).getStackEntries(i);
        }

        @Override // com.google.rpc.DebugInfoOrBuilder
        public final ByteString getStackEntriesBytes(int i) {
            return ((DebugInfo) this.instance).getStackEntriesBytes(i);
        }

        public final Builder setStackEntries(int i, String str) {
            copyOnWrite();
            ((DebugInfo) this.instance).setStackEntries(i, str);
            return this;
        }

        public final Builder addStackEntries(String str) {
            copyOnWrite();
            ((DebugInfo) this.instance).addStackEntries(str);
            return this;
        }

        public final Builder addAllStackEntries(Iterable<String> iterable) {
            copyOnWrite();
            ((DebugInfo) this.instance).addAllStackEntries(iterable);
            return this;
        }

        public final Builder clearStackEntries() {
            copyOnWrite();
            ((DebugInfo) this.instance).clearStackEntries();
            return this;
        }

        public final Builder addStackEntriesBytes(ByteString byteString) {
            copyOnWrite();
            ((DebugInfo) this.instance).addStackEntriesBytes(byteString);
            return this;
        }

        @Override // com.google.rpc.DebugInfoOrBuilder
        public final String getDetail() {
            return ((DebugInfo) this.instance).getDetail();
        }

        @Override // com.google.rpc.DebugInfoOrBuilder
        public final ByteString getDetailBytes() {
            return ((DebugInfo) this.instance).getDetailBytes();
        }

        public final Builder setDetail(String str) {
            copyOnWrite();
            ((DebugInfo) this.instance).setDetail(str);
            return this;
        }

        public final Builder clearDetail() {
            copyOnWrite();
            ((DebugInfo) this.instance).clearDetail();
            return this;
        }

        public final Builder setDetailBytes(ByteString byteString) {
            copyOnWrite();
            ((DebugInfo) this.instance).setDetailBytes(byteString);
            return this;
        }
    }

    /* renamed from: com.google.rpc.DebugInfo$1  reason: invalid class name */
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
                return new DebugInfo();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ț\u0002Ȉ", new Object[]{"stackEntries_", "detail_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<DebugInfo> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (DebugInfo.class) {
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
        DebugInfo debugInfo = new DebugInfo();
        DEFAULT_INSTANCE = debugInfo;
        GeneratedMessageLite.registerDefaultInstance(DebugInfo.class, debugInfo);
    }

    public static DebugInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<DebugInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
