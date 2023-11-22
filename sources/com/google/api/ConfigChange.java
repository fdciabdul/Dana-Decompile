package com.google.api;

import com.google.api.Advice;
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
public final class ConfigChange extends GeneratedMessageLite<ConfigChange, Builder> implements ConfigChangeOrBuilder {
    public static final int ADVICES_FIELD_NUMBER = 5;
    public static final int CHANGE_TYPE_FIELD_NUMBER = 4;
    private static final ConfigChange DEFAULT_INSTANCE;
    public static final int ELEMENT_FIELD_NUMBER = 1;
    public static final int NEW_VALUE_FIELD_NUMBER = 3;
    public static final int OLD_VALUE_FIELD_NUMBER = 2;
    private static volatile Parser<ConfigChange> PARSER;
    private int changeType_;
    private String element_ = "";
    private String oldValue_ = "";
    private String newValue_ = "";
    private Internal.ProtobufList<Advice> advices_ = emptyProtobufList();

    private ConfigChange() {
    }

    @Override // com.google.api.ConfigChangeOrBuilder
    public final String getElement() {
        return this.element_;
    }

    @Override // com.google.api.ConfigChangeOrBuilder
    public final ByteString getElementBytes() {
        return ByteString.copyFromUtf8(this.element_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setElement(String str) {
        this.element_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearElement() {
        this.element_ = getDefaultInstance().getElement();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setElementBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.element_ = byteString.toStringUtf8();
    }

    @Override // com.google.api.ConfigChangeOrBuilder
    public final String getOldValue() {
        return this.oldValue_;
    }

    @Override // com.google.api.ConfigChangeOrBuilder
    public final ByteString getOldValueBytes() {
        return ByteString.copyFromUtf8(this.oldValue_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOldValue(String str) {
        this.oldValue_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOldValue() {
        this.oldValue_ = getDefaultInstance().getOldValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOldValueBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.oldValue_ = byteString.toStringUtf8();
    }

    @Override // com.google.api.ConfigChangeOrBuilder
    public final String getNewValue() {
        return this.newValue_;
    }

    @Override // com.google.api.ConfigChangeOrBuilder
    public final ByteString getNewValueBytes() {
        return ByteString.copyFromUtf8(this.newValue_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNewValue(String str) {
        this.newValue_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNewValue() {
        this.newValue_ = getDefaultInstance().getNewValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNewValueBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.newValue_ = byteString.toStringUtf8();
    }

    @Override // com.google.api.ConfigChangeOrBuilder
    public final int getChangeTypeValue() {
        return this.changeType_;
    }

    @Override // com.google.api.ConfigChangeOrBuilder
    public final ChangeType getChangeType() {
        ChangeType forNumber = ChangeType.forNumber(this.changeType_);
        return forNumber == null ? ChangeType.UNRECOGNIZED : forNumber;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChangeTypeValue(int i) {
        this.changeType_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChangeType(ChangeType changeType) {
        this.changeType_ = changeType.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearChangeType() {
        this.changeType_ = 0;
    }

    @Override // com.google.api.ConfigChangeOrBuilder
    public final List<Advice> getAdvicesList() {
        return this.advices_;
    }

    public final List<? extends AdviceOrBuilder> getAdvicesOrBuilderList() {
        return this.advices_;
    }

    @Override // com.google.api.ConfigChangeOrBuilder
    public final int getAdvicesCount() {
        return this.advices_.size();
    }

    @Override // com.google.api.ConfigChangeOrBuilder
    public final Advice getAdvices(int i) {
        return this.advices_.get(i);
    }

    public final AdviceOrBuilder getAdvicesOrBuilder(int i) {
        return this.advices_.get(i);
    }

    private void ensureAdvicesIsMutable() {
        Internal.ProtobufList<Advice> protobufList = this.advices_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.advices_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAdvices(int i, Advice advice) {
        ensureAdvicesIsMutable();
        this.advices_.set(i, advice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAdvices(Advice advice) {
        ensureAdvicesIsMutable();
        this.advices_.add(advice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAdvices(int i, Advice advice) {
        ensureAdvicesIsMutable();
        this.advices_.add(i, advice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllAdvices(Iterable<? extends Advice> iterable) {
        ensureAdvicesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.advices_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAdvices() {
        this.advices_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAdvices(int i) {
        ensureAdvicesIsMutable();
        this.advices_.remove(i);
    }

    public static ConfigChange parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ConfigChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static ConfigChange parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ConfigChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ConfigChange parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ConfigChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ConfigChange parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ConfigChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ConfigChange parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ConfigChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ConfigChange parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ConfigChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ConfigChange parseFrom(InputStream inputStream) throws IOException {
        return (ConfigChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ConfigChange parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ConfigChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ConfigChange parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ConfigChange) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ConfigChange parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ConfigChange) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ConfigChange parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ConfigChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ConfigChange parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ConfigChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(ConfigChange configChange) {
        return DEFAULT_INSTANCE.createBuilder(configChange);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<ConfigChange, Builder> implements ConfigChangeOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(ConfigChange.DEFAULT_INSTANCE);
        }

        @Override // com.google.api.ConfigChangeOrBuilder
        public final String getElement() {
            return ((ConfigChange) this.instance).getElement();
        }

        @Override // com.google.api.ConfigChangeOrBuilder
        public final ByteString getElementBytes() {
            return ((ConfigChange) this.instance).getElementBytes();
        }

        public final Builder setElement(String str) {
            copyOnWrite();
            ((ConfigChange) this.instance).setElement(str);
            return this;
        }

        public final Builder clearElement() {
            copyOnWrite();
            ((ConfigChange) this.instance).clearElement();
            return this;
        }

        public final Builder setElementBytes(ByteString byteString) {
            copyOnWrite();
            ((ConfigChange) this.instance).setElementBytes(byteString);
            return this;
        }

        @Override // com.google.api.ConfigChangeOrBuilder
        public final String getOldValue() {
            return ((ConfigChange) this.instance).getOldValue();
        }

        @Override // com.google.api.ConfigChangeOrBuilder
        public final ByteString getOldValueBytes() {
            return ((ConfigChange) this.instance).getOldValueBytes();
        }

        public final Builder setOldValue(String str) {
            copyOnWrite();
            ((ConfigChange) this.instance).setOldValue(str);
            return this;
        }

        public final Builder clearOldValue() {
            copyOnWrite();
            ((ConfigChange) this.instance).clearOldValue();
            return this;
        }

        public final Builder setOldValueBytes(ByteString byteString) {
            copyOnWrite();
            ((ConfigChange) this.instance).setOldValueBytes(byteString);
            return this;
        }

        @Override // com.google.api.ConfigChangeOrBuilder
        public final String getNewValue() {
            return ((ConfigChange) this.instance).getNewValue();
        }

        @Override // com.google.api.ConfigChangeOrBuilder
        public final ByteString getNewValueBytes() {
            return ((ConfigChange) this.instance).getNewValueBytes();
        }

        public final Builder setNewValue(String str) {
            copyOnWrite();
            ((ConfigChange) this.instance).setNewValue(str);
            return this;
        }

        public final Builder clearNewValue() {
            copyOnWrite();
            ((ConfigChange) this.instance).clearNewValue();
            return this;
        }

        public final Builder setNewValueBytes(ByteString byteString) {
            copyOnWrite();
            ((ConfigChange) this.instance).setNewValueBytes(byteString);
            return this;
        }

        @Override // com.google.api.ConfigChangeOrBuilder
        public final int getChangeTypeValue() {
            return ((ConfigChange) this.instance).getChangeTypeValue();
        }

        public final Builder setChangeTypeValue(int i) {
            copyOnWrite();
            ((ConfigChange) this.instance).setChangeTypeValue(i);
            return this;
        }

        @Override // com.google.api.ConfigChangeOrBuilder
        public final ChangeType getChangeType() {
            return ((ConfigChange) this.instance).getChangeType();
        }

        public final Builder setChangeType(ChangeType changeType) {
            copyOnWrite();
            ((ConfigChange) this.instance).setChangeType(changeType);
            return this;
        }

        public final Builder clearChangeType() {
            copyOnWrite();
            ((ConfigChange) this.instance).clearChangeType();
            return this;
        }

        @Override // com.google.api.ConfigChangeOrBuilder
        public final List<Advice> getAdvicesList() {
            return Collections.unmodifiableList(((ConfigChange) this.instance).getAdvicesList());
        }

        @Override // com.google.api.ConfigChangeOrBuilder
        public final int getAdvicesCount() {
            return ((ConfigChange) this.instance).getAdvicesCount();
        }

        @Override // com.google.api.ConfigChangeOrBuilder
        public final Advice getAdvices(int i) {
            return ((ConfigChange) this.instance).getAdvices(i);
        }

        public final Builder setAdvices(int i, Advice advice) {
            copyOnWrite();
            ((ConfigChange) this.instance).setAdvices(i, advice);
            return this;
        }

        public final Builder setAdvices(int i, Advice.Builder builder) {
            copyOnWrite();
            ((ConfigChange) this.instance).setAdvices(i, builder.build());
            return this;
        }

        public final Builder addAdvices(Advice advice) {
            copyOnWrite();
            ((ConfigChange) this.instance).addAdvices(advice);
            return this;
        }

        public final Builder addAdvices(int i, Advice advice) {
            copyOnWrite();
            ((ConfigChange) this.instance).addAdvices(i, advice);
            return this;
        }

        public final Builder addAdvices(Advice.Builder builder) {
            copyOnWrite();
            ((ConfigChange) this.instance).addAdvices(builder.build());
            return this;
        }

        public final Builder addAdvices(int i, Advice.Builder builder) {
            copyOnWrite();
            ((ConfigChange) this.instance).addAdvices(i, builder.build());
            return this;
        }

        public final Builder addAllAdvices(Iterable<? extends Advice> iterable) {
            copyOnWrite();
            ((ConfigChange) this.instance).addAllAdvices(iterable);
            return this;
        }

        public final Builder clearAdvices() {
            copyOnWrite();
            ((ConfigChange) this.instance).clearAdvices();
            return this;
        }

        public final Builder removeAdvices(int i) {
            copyOnWrite();
            ((ConfigChange) this.instance).removeAdvices(i);
            return this;
        }
    }

    /* renamed from: com.google.api.ConfigChange$1  reason: invalid class name */
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
                return new ConfigChange();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\f\u0005\u001b", new Object[]{"element_", "oldValue_", "newValue_", "changeType_", "advices_", Advice.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ConfigChange> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (ConfigChange.class) {
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
        ConfigChange configChange = new ConfigChange();
        DEFAULT_INSTANCE = configChange;
        GeneratedMessageLite.registerDefaultInstance(ConfigChange.class, configChange);
    }

    public static ConfigChange getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<ConfigChange> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
