package com.google.api;

import com.google.api.LabelDescriptor;
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
public final class MonitoredResourceDescriptor extends GeneratedMessageLite<MonitoredResourceDescriptor, Builder> implements MonitoredResourceDescriptorOrBuilder {
    private static final MonitoredResourceDescriptor DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 3;
    public static final int DISPLAY_NAME_FIELD_NUMBER = 2;
    public static final int LABELS_FIELD_NUMBER = 4;
    public static final int LAUNCH_STAGE_FIELD_NUMBER = 7;
    public static final int NAME_FIELD_NUMBER = 5;
    private static volatile Parser<MonitoredResourceDescriptor> PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 1;
    private int launchStage_;
    private String name_ = "";
    private String type_ = "";
    private String displayName_ = "";
    private String description_ = "";
    private Internal.ProtobufList<LabelDescriptor> labels_ = emptyProtobufList();

    private MonitoredResourceDescriptor() {
    }

    @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
    public final String getName() {
        return this.name_;
    }

    @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
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

    @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
    public final String getType() {
        return this.type_;
    }

    @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
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

    @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
    public final String getDisplayName() {
        return this.displayName_;
    }

    @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
    public final ByteString getDisplayNameBytes() {
        return ByteString.copyFromUtf8(this.displayName_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisplayName(String str) {
        this.displayName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDisplayName() {
        this.displayName_ = getDefaultInstance().getDisplayName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDisplayNameBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.displayName_ = byteString.toStringUtf8();
    }

    @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
    public final String getDescription() {
        return this.description_;
    }

    @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
    public final ByteString getDescriptionBytes() {
        return ByteString.copyFromUtf8(this.description_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDescription(String str) {
        this.description_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDescription() {
        this.description_ = getDefaultInstance().getDescription();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDescriptionBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.description_ = byteString.toStringUtf8();
    }

    @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
    public final List<LabelDescriptor> getLabelsList() {
        return this.labels_;
    }

    public final List<? extends LabelDescriptorOrBuilder> getLabelsOrBuilderList() {
        return this.labels_;
    }

    @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
    public final int getLabelsCount() {
        return this.labels_.size();
    }

    @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
    public final LabelDescriptor getLabels(int i) {
        return this.labels_.get(i);
    }

    public final LabelDescriptorOrBuilder getLabelsOrBuilder(int i) {
        return this.labels_.get(i);
    }

    private void ensureLabelsIsMutable() {
        Internal.ProtobufList<LabelDescriptor> protobufList = this.labels_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.labels_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLabels(int i, LabelDescriptor labelDescriptor) {
        ensureLabelsIsMutable();
        this.labels_.set(i, labelDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLabels(LabelDescriptor labelDescriptor) {
        ensureLabelsIsMutable();
        this.labels_.add(labelDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLabels(int i, LabelDescriptor labelDescriptor) {
        ensureLabelsIsMutable();
        this.labels_.add(i, labelDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllLabels(Iterable<? extends LabelDescriptor> iterable) {
        ensureLabelsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.labels_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLabels() {
        this.labels_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeLabels(int i) {
        ensureLabelsIsMutable();
        this.labels_.remove(i);
    }

    @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
    public final int getLaunchStageValue() {
        return this.launchStage_;
    }

    @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
    public final LaunchStage getLaunchStage() {
        LaunchStage forNumber = LaunchStage.forNumber(this.launchStage_);
        return forNumber == null ? LaunchStage.UNRECOGNIZED : forNumber;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLaunchStageValue(int i) {
        this.launchStage_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLaunchStage(LaunchStage launchStage) {
        this.launchStage_ = launchStage.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearLaunchStage() {
        this.launchStage_ = 0;
    }

    public static MonitoredResourceDescriptor parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static MonitoredResourceDescriptor parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MonitoredResourceDescriptor parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MonitoredResourceDescriptor parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MonitoredResourceDescriptor parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MonitoredResourceDescriptor parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MonitoredResourceDescriptor parseFrom(InputStream inputStream) throws IOException {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MonitoredResourceDescriptor parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MonitoredResourceDescriptor parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (MonitoredResourceDescriptor) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MonitoredResourceDescriptor parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MonitoredResourceDescriptor) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MonitoredResourceDescriptor parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MonitoredResourceDescriptor parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MonitoredResourceDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(MonitoredResourceDescriptor monitoredResourceDescriptor) {
        return DEFAULT_INSTANCE.createBuilder(monitoredResourceDescriptor);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<MonitoredResourceDescriptor, Builder> implements MonitoredResourceDescriptorOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(MonitoredResourceDescriptor.DEFAULT_INSTANCE);
        }

        @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
        public final String getName() {
            return ((MonitoredResourceDescriptor) this.instance).getName();
        }

        @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
        public final ByteString getNameBytes() {
            return ((MonitoredResourceDescriptor) this.instance).getNameBytes();
        }

        public final Builder setName(String str) {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).setName(str);
            return this;
        }

        public final Builder clearName() {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).clearName();
            return this;
        }

        public final Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).setNameBytes(byteString);
            return this;
        }

        @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
        public final String getType() {
            return ((MonitoredResourceDescriptor) this.instance).getType();
        }

        @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
        public final ByteString getTypeBytes() {
            return ((MonitoredResourceDescriptor) this.instance).getTypeBytes();
        }

        public final Builder setType(String str) {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).setType(str);
            return this;
        }

        public final Builder clearType() {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).clearType();
            return this;
        }

        public final Builder setTypeBytes(ByteString byteString) {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).setTypeBytes(byteString);
            return this;
        }

        @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
        public final String getDisplayName() {
            return ((MonitoredResourceDescriptor) this.instance).getDisplayName();
        }

        @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
        public final ByteString getDisplayNameBytes() {
            return ((MonitoredResourceDescriptor) this.instance).getDisplayNameBytes();
        }

        public final Builder setDisplayName(String str) {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).setDisplayName(str);
            return this;
        }

        public final Builder clearDisplayName() {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).clearDisplayName();
            return this;
        }

        public final Builder setDisplayNameBytes(ByteString byteString) {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).setDisplayNameBytes(byteString);
            return this;
        }

        @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
        public final String getDescription() {
            return ((MonitoredResourceDescriptor) this.instance).getDescription();
        }

        @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
        public final ByteString getDescriptionBytes() {
            return ((MonitoredResourceDescriptor) this.instance).getDescriptionBytes();
        }

        public final Builder setDescription(String str) {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).setDescription(str);
            return this;
        }

        public final Builder clearDescription() {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).clearDescription();
            return this;
        }

        public final Builder setDescriptionBytes(ByteString byteString) {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).setDescriptionBytes(byteString);
            return this;
        }

        @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
        public final List<LabelDescriptor> getLabelsList() {
            return Collections.unmodifiableList(((MonitoredResourceDescriptor) this.instance).getLabelsList());
        }

        @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
        public final int getLabelsCount() {
            return ((MonitoredResourceDescriptor) this.instance).getLabelsCount();
        }

        @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
        public final LabelDescriptor getLabels(int i) {
            return ((MonitoredResourceDescriptor) this.instance).getLabels(i);
        }

        public final Builder setLabels(int i, LabelDescriptor labelDescriptor) {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).setLabels(i, labelDescriptor);
            return this;
        }

        public final Builder setLabels(int i, LabelDescriptor.Builder builder) {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).setLabels(i, builder.build());
            return this;
        }

        public final Builder addLabels(LabelDescriptor labelDescriptor) {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).addLabels(labelDescriptor);
            return this;
        }

        public final Builder addLabels(int i, LabelDescriptor labelDescriptor) {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).addLabels(i, labelDescriptor);
            return this;
        }

        public final Builder addLabels(LabelDescriptor.Builder builder) {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).addLabels(builder.build());
            return this;
        }

        public final Builder addLabels(int i, LabelDescriptor.Builder builder) {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).addLabels(i, builder.build());
            return this;
        }

        public final Builder addAllLabels(Iterable<? extends LabelDescriptor> iterable) {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).addAllLabels(iterable);
            return this;
        }

        public final Builder clearLabels() {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).clearLabels();
            return this;
        }

        public final Builder removeLabels(int i) {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).removeLabels(i);
            return this;
        }

        @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
        public final int getLaunchStageValue() {
            return ((MonitoredResourceDescriptor) this.instance).getLaunchStageValue();
        }

        public final Builder setLaunchStageValue(int i) {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).setLaunchStageValue(i);
            return this;
        }

        @Override // com.google.api.MonitoredResourceDescriptorOrBuilder
        public final LaunchStage getLaunchStage() {
            return ((MonitoredResourceDescriptor) this.instance).getLaunchStage();
        }

        public final Builder setLaunchStage(LaunchStage launchStage) {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).setLaunchStage(launchStage);
            return this;
        }

        public final Builder clearLaunchStage() {
            copyOnWrite();
            ((MonitoredResourceDescriptor) this.instance).clearLaunchStage();
            return this;
        }
    }

    /* renamed from: com.google.api.MonitoredResourceDescriptor$1  reason: invalid class name */
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
                return new MonitoredResourceDescriptor();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0007\u0006\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\u001b\u0005Ȉ\u0007\f", new Object[]{"type_", "displayName_", "description_", "labels_", LabelDescriptor.class, "name_", "launchStage_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MonitoredResourceDescriptor> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (MonitoredResourceDescriptor.class) {
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
        MonitoredResourceDescriptor monitoredResourceDescriptor = new MonitoredResourceDescriptor();
        DEFAULT_INSTANCE = monitoredResourceDescriptor;
        GeneratedMessageLite.registerDefaultInstance(MonitoredResourceDescriptor.class, monitoredResourceDescriptor);
    }

    public static MonitoredResourceDescriptor getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<MonitoredResourceDescriptor> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
