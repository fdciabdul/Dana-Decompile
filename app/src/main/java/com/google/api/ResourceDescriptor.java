package com.google.api;

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
public final class ResourceDescriptor extends GeneratedMessageLite<ResourceDescriptor, Builder> implements ResourceDescriptorOrBuilder {
    private static final ResourceDescriptor DEFAULT_INSTANCE;
    public static final int HISTORY_FIELD_NUMBER = 4;
    public static final int NAME_FIELD_FIELD_NUMBER = 3;
    private static volatile Parser<ResourceDescriptor> PARSER = null;
    public static final int PATTERN_FIELD_NUMBER = 2;
    public static final int PLURAL_FIELD_NUMBER = 5;
    public static final int SINGULAR_FIELD_NUMBER = 6;
    public static final int TYPE_FIELD_NUMBER = 1;
    private int history_;
    private String type_ = "";
    private Internal.ProtobufList<String> pattern_ = GeneratedMessageLite.emptyProtobufList();
    private String nameField_ = "";
    private String plural_ = "";
    private String singular_ = "";

    private ResourceDescriptor() {
    }

    /* loaded from: classes7.dex */
    public enum History implements Internal.EnumLite {
        HISTORY_UNSPECIFIED(0),
        ORIGINALLY_SINGLE_PATTERN(1),
        FUTURE_MULTI_PATTERN(2),
        UNRECOGNIZED(-1);

        public static final int FUTURE_MULTI_PATTERN_VALUE = 2;
        public static final int HISTORY_UNSPECIFIED_VALUE = 0;
        public static final int ORIGINALLY_SINGLE_PATTERN_VALUE = 1;
        private static final Internal.EnumLiteMap<History> internalValueMap = new Internal.EnumLiteMap<History>() { // from class: com.google.api.ResourceDescriptor.History.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public History findValueByNumber(int i) {
                return History.forNumber(i);
            }
        };
        private final int value;

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this == UNRECOGNIZED) {
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
            return this.value;
        }

        @Deprecated
        public static History valueOf(int i) {
            return forNumber(i);
        }

        public static History forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return FUTURE_MULTI_PATTERN;
                }
                return ORIGINALLY_SINGLE_PATTERN;
            }
            return HISTORY_UNSPECIFIED;
        }

        public static Internal.EnumLiteMap<History> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return HistoryVerifier.INSTANCE;
        }

        /* loaded from: classes7.dex */
        static final class HistoryVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new HistoryVerifier();

            private HistoryVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public final boolean isInRange(int i) {
                return History.forNumber(i) != null;
            }
        }

        History(int i) {
            this.value = i;
        }
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public final String getType() {
        return this.type_;
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public final ByteString getTypeBytes() {
        return ByteString.copyFromUtf8(this.type_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setType(String str) {
        this.type_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearType() {
        this.type_ = getDefaultInstance().getType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypeBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.type_ = byteString.toStringUtf8();
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public final List<String> getPatternList() {
        return this.pattern_;
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public final int getPatternCount() {
        return this.pattern_.size();
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public final String getPattern(int i) {
        return this.pattern_.get(i);
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public final ByteString getPatternBytes(int i) {
        return ByteString.copyFromUtf8(this.pattern_.get(i));
    }

    private void ensurePatternIsMutable() {
        Internal.ProtobufList<String> protobufList = this.pattern_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.pattern_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPattern(int i, String str) {
        ensurePatternIsMutable();
        this.pattern_.set(i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPattern(String str) {
        ensurePatternIsMutable();
        this.pattern_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllPattern(Iterable<String> iterable) {
        ensurePatternIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.pattern_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPattern() {
        this.pattern_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPatternBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        ensurePatternIsMutable();
        this.pattern_.add(byteString.toStringUtf8());
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public final String getNameField() {
        return this.nameField_;
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public final ByteString getNameFieldBytes() {
        return ByteString.copyFromUtf8(this.nameField_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameField(String str) {
        this.nameField_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNameField() {
        this.nameField_ = getDefaultInstance().getNameField();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameFieldBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.nameField_ = byteString.toStringUtf8();
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public final int getHistoryValue() {
        return this.history_;
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public final History getHistory() {
        History forNumber = History.forNumber(this.history_);
        return forNumber == null ? History.UNRECOGNIZED : forNumber;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHistoryValue(int i) {
        this.history_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHistory(History history) {
        this.history_ = history.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearHistory() {
        this.history_ = 0;
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public final String getPlural() {
        return this.plural_;
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public final ByteString getPluralBytes() {
        return ByteString.copyFromUtf8(this.plural_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlural(String str) {
        this.plural_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPlural() {
        this.plural_ = getDefaultInstance().getPlural();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPluralBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.plural_ = byteString.toStringUtf8();
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public final String getSingular() {
        return this.singular_;
    }

    @Override // com.google.api.ResourceDescriptorOrBuilder
    public final ByteString getSingularBytes() {
        return ByteString.copyFromUtf8(this.singular_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSingular(String str) {
        this.singular_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSingular() {
        this.singular_ = getDefaultInstance().getSingular();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSingularBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.singular_ = byteString.toStringUtf8();
    }

    public static ResourceDescriptor parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ResourceDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static ResourceDescriptor parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ResourceDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ResourceDescriptor parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ResourceDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ResourceDescriptor parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ResourceDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ResourceDescriptor parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ResourceDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ResourceDescriptor parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ResourceDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ResourceDescriptor parseFrom(InputStream inputStream) throws IOException {
        return (ResourceDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ResourceDescriptor parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ResourceDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ResourceDescriptor parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ResourceDescriptor) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ResourceDescriptor parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ResourceDescriptor) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ResourceDescriptor parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ResourceDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ResourceDescriptor parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ResourceDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(ResourceDescriptor resourceDescriptor) {
        return DEFAULT_INSTANCE.createBuilder(resourceDescriptor);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<ResourceDescriptor, Builder> implements ResourceDescriptorOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(ResourceDescriptor.DEFAULT_INSTANCE);
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public final String getType() {
            return ((ResourceDescriptor) this.instance).getType();
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public final ByteString getTypeBytes() {
            return ((ResourceDescriptor) this.instance).getTypeBytes();
        }

        public final Builder setType(String str) {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).setType(str);
            return this;
        }

        public final Builder clearType() {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).clearType();
            return this;
        }

        public final Builder setTypeBytes(ByteString byteString) {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).setTypeBytes(byteString);
            return this;
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public final List<String> getPatternList() {
            return Collections.unmodifiableList(((ResourceDescriptor) this.instance).getPatternList());
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public final int getPatternCount() {
            return ((ResourceDescriptor) this.instance).getPatternCount();
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public final String getPattern(int i) {
            return ((ResourceDescriptor) this.instance).getPattern(i);
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public final ByteString getPatternBytes(int i) {
            return ((ResourceDescriptor) this.instance).getPatternBytes(i);
        }

        public final Builder setPattern(int i, String str) {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).setPattern(i, str);
            return this;
        }

        public final Builder addPattern(String str) {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).addPattern(str);
            return this;
        }

        public final Builder addAllPattern(Iterable<String> iterable) {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).addAllPattern(iterable);
            return this;
        }

        public final Builder clearPattern() {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).clearPattern();
            return this;
        }

        public final Builder addPatternBytes(ByteString byteString) {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).addPatternBytes(byteString);
            return this;
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public final String getNameField() {
            return ((ResourceDescriptor) this.instance).getNameField();
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public final ByteString getNameFieldBytes() {
            return ((ResourceDescriptor) this.instance).getNameFieldBytes();
        }

        public final Builder setNameField(String str) {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).setNameField(str);
            return this;
        }

        public final Builder clearNameField() {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).clearNameField();
            return this;
        }

        public final Builder setNameFieldBytes(ByteString byteString) {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).setNameFieldBytes(byteString);
            return this;
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public final int getHistoryValue() {
            return ((ResourceDescriptor) this.instance).getHistoryValue();
        }

        public final Builder setHistoryValue(int i) {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).setHistoryValue(i);
            return this;
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public final History getHistory() {
            return ((ResourceDescriptor) this.instance).getHistory();
        }

        public final Builder setHistory(History history) {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).setHistory(history);
            return this;
        }

        public final Builder clearHistory() {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).clearHistory();
            return this;
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public final String getPlural() {
            return ((ResourceDescriptor) this.instance).getPlural();
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public final ByteString getPluralBytes() {
            return ((ResourceDescriptor) this.instance).getPluralBytes();
        }

        public final Builder setPlural(String str) {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).setPlural(str);
            return this;
        }

        public final Builder clearPlural() {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).clearPlural();
            return this;
        }

        public final Builder setPluralBytes(ByteString byteString) {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).setPluralBytes(byteString);
            return this;
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public final String getSingular() {
            return ((ResourceDescriptor) this.instance).getSingular();
        }

        @Override // com.google.api.ResourceDescriptorOrBuilder
        public final ByteString getSingularBytes() {
            return ((ResourceDescriptor) this.instance).getSingularBytes();
        }

        public final Builder setSingular(String str) {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).setSingular(str);
            return this;
        }

        public final Builder clearSingular() {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).clearSingular();
            return this;
        }

        public final Builder setSingularBytes(ByteString byteString) {
            copyOnWrite();
            ((ResourceDescriptor) this.instance).setSingularBytes(byteString);
            return this;
        }
    }

    /* renamed from: com.google.api.ResourceDescriptor$1  reason: invalid class name */
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
                return new ResourceDescriptor();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0001\u0000\u0001Ȉ\u0002Ț\u0003Ȉ\u0004\f\u0005Ȉ\u0006Ȉ", new Object[]{"type_", "pattern_", "nameField_", "history_", "plural_", "singular_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ResourceDescriptor> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (ResourceDescriptor.class) {
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
        ResourceDescriptor resourceDescriptor = new ResourceDescriptor();
        DEFAULT_INSTANCE = resourceDescriptor;
        GeneratedMessageLite.registerDefaultInstance(ResourceDescriptor.class, resourceDescriptor);
    }

    public static ResourceDescriptor getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<ResourceDescriptor> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
