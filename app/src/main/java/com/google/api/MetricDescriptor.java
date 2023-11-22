package com.google.api;

import com.google.api.LabelDescriptor;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Duration;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes7.dex */
public final class MetricDescriptor extends GeneratedMessageLite<MetricDescriptor, Builder> implements MetricDescriptorOrBuilder {
    private static final MetricDescriptor DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 6;
    public static final int DISPLAY_NAME_FIELD_NUMBER = 7;
    public static final int LABELS_FIELD_NUMBER = 2;
    public static final int LAUNCH_STAGE_FIELD_NUMBER = 12;
    public static final int METADATA_FIELD_NUMBER = 10;
    public static final int METRIC_KIND_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<MetricDescriptor> PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 8;
    public static final int UNIT_FIELD_NUMBER = 5;
    public static final int VALUE_TYPE_FIELD_NUMBER = 4;
    private int launchStage_;
    private MetricDescriptorMetadata metadata_;
    private int metricKind_;
    private int valueType_;
    private String name_ = "";
    private String type_ = "";
    private Internal.ProtobufList<LabelDescriptor> labels_ = emptyProtobufList();
    private String unit_ = "";
    private String description_ = "";
    private String displayName_ = "";

    /* loaded from: classes7.dex */
    public interface MetricDescriptorMetadataOrBuilder extends MessageLiteOrBuilder {
        Duration getIngestDelay();

        @Deprecated
        LaunchStage getLaunchStage();

        @Deprecated
        int getLaunchStageValue();

        Duration getSamplePeriod();

        boolean hasIngestDelay();

        boolean hasSamplePeriod();
    }

    private MetricDescriptor() {
    }

    /* loaded from: classes7.dex */
    public enum MetricKind implements Internal.EnumLite {
        METRIC_KIND_UNSPECIFIED(0),
        GAUGE(1),
        DELTA(2),
        CUMULATIVE(3),
        UNRECOGNIZED(-1);

        public static final int CUMULATIVE_VALUE = 3;
        public static final int DELTA_VALUE = 2;
        public static final int GAUGE_VALUE = 1;
        public static final int METRIC_KIND_UNSPECIFIED_VALUE = 0;
        private static final Internal.EnumLiteMap<MetricKind> internalValueMap = new Internal.EnumLiteMap<MetricKind>() { // from class: com.google.api.MetricDescriptor.MetricKind.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public MetricKind findValueByNumber(int i) {
                return MetricKind.forNumber(i);
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
        public static MetricKind valueOf(int i) {
            return forNumber(i);
        }

        public static MetricKind forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return null;
                        }
                        return CUMULATIVE;
                    }
                    return DELTA;
                }
                return GAUGE;
            }
            return METRIC_KIND_UNSPECIFIED;
        }

        public static Internal.EnumLiteMap<MetricKind> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return MetricKindVerifier.INSTANCE;
        }

        /* loaded from: classes7.dex */
        static final class MetricKindVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new MetricKindVerifier();

            private MetricKindVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public final boolean isInRange(int i) {
                return MetricKind.forNumber(i) != null;
            }
        }

        MetricKind(int i) {
            this.value = i;
        }
    }

    /* loaded from: classes7.dex */
    public enum ValueType implements Internal.EnumLite {
        VALUE_TYPE_UNSPECIFIED(0),
        BOOL(1),
        INT64(2),
        DOUBLE(3),
        STRING(4),
        DISTRIBUTION(5),
        MONEY(6),
        UNRECOGNIZED(-1);

        public static final int BOOL_VALUE = 1;
        public static final int DISTRIBUTION_VALUE = 5;
        public static final int DOUBLE_VALUE = 3;
        public static final int INT64_VALUE = 2;
        public static final int MONEY_VALUE = 6;
        public static final int STRING_VALUE = 4;
        public static final int VALUE_TYPE_UNSPECIFIED_VALUE = 0;
        private static final Internal.EnumLiteMap<ValueType> internalValueMap = new Internal.EnumLiteMap<ValueType>() { // from class: com.google.api.MetricDescriptor.ValueType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ValueType findValueByNumber(int i) {
                return ValueType.forNumber(i);
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
        public static ValueType valueOf(int i) {
            return forNumber(i);
        }

        public static ValueType forNumber(int i) {
            switch (i) {
                case 0:
                    return VALUE_TYPE_UNSPECIFIED;
                case 1:
                    return BOOL;
                case 2:
                    return INT64;
                case 3:
                    return DOUBLE;
                case 4:
                    return STRING;
                case 5:
                    return DISTRIBUTION;
                case 6:
                    return MONEY;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<ValueType> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return ValueTypeVerifier.INSTANCE;
        }

        /* loaded from: classes7.dex */
        static final class ValueTypeVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new ValueTypeVerifier();

            private ValueTypeVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public final boolean isInRange(int i) {
                return ValueType.forNumber(i) != null;
            }
        }

        ValueType(int i) {
            this.value = i;
        }
    }

    /* loaded from: classes7.dex */
    public static final class MetricDescriptorMetadata extends GeneratedMessageLite<MetricDescriptorMetadata, Builder> implements MetricDescriptorMetadataOrBuilder {
        private static final MetricDescriptorMetadata DEFAULT_INSTANCE;
        public static final int INGEST_DELAY_FIELD_NUMBER = 3;
        public static final int LAUNCH_STAGE_FIELD_NUMBER = 1;
        private static volatile Parser<MetricDescriptorMetadata> PARSER = null;
        public static final int SAMPLE_PERIOD_FIELD_NUMBER = 2;
        private Duration ingestDelay_;
        private int launchStage_;
        private Duration samplePeriod_;

        private MetricDescriptorMetadata() {
        }

        @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
        @Deprecated
        public final int getLaunchStageValue() {
            return this.launchStage_;
        }

        @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
        @Deprecated
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

        @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
        public final boolean hasSamplePeriod() {
            return this.samplePeriod_ != null;
        }

        @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
        public final Duration getSamplePeriod() {
            Duration duration = this.samplePeriod_;
            return duration == null ? Duration.getDefaultInstance() : duration;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSamplePeriod(Duration duration) {
            this.samplePeriod_ = duration;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSamplePeriod(Duration duration) {
            Duration duration2 = this.samplePeriod_;
            if (duration2 != null && duration2 != Duration.getDefaultInstance()) {
                this.samplePeriod_ = Duration.newBuilder(this.samplePeriod_).mergeFrom((Duration.Builder) duration).buildPartial();
            } else {
                this.samplePeriod_ = duration;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSamplePeriod() {
            this.samplePeriod_ = null;
        }

        @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
        public final boolean hasIngestDelay() {
            return this.ingestDelay_ != null;
        }

        @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
        public final Duration getIngestDelay() {
            Duration duration = this.ingestDelay_;
            return duration == null ? Duration.getDefaultInstance() : duration;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIngestDelay(Duration duration) {
            this.ingestDelay_ = duration;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeIngestDelay(Duration duration) {
            Duration duration2 = this.ingestDelay_;
            if (duration2 != null && duration2 != Duration.getDefaultInstance()) {
                this.ingestDelay_ = Duration.newBuilder(this.ingestDelay_).mergeFrom((Duration.Builder) duration).buildPartial();
            } else {
                this.ingestDelay_ = duration;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIngestDelay() {
            this.ingestDelay_ = null;
        }

        public static MetricDescriptorMetadata parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static MetricDescriptorMetadata parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static MetricDescriptorMetadata parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static MetricDescriptorMetadata parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static MetricDescriptorMetadata parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static MetricDescriptorMetadata parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static MetricDescriptorMetadata parseFrom(InputStream inputStream) throws IOException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MetricDescriptorMetadata parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MetricDescriptorMetadata parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MetricDescriptorMetadata) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MetricDescriptorMetadata parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MetricDescriptorMetadata) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MetricDescriptorMetadata parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static MetricDescriptorMetadata parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MetricDescriptorMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(MetricDescriptorMetadata metricDescriptorMetadata) {
            return DEFAULT_INSTANCE.createBuilder(metricDescriptorMetadata);
        }

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<MetricDescriptorMetadata, Builder> implements MetricDescriptorMetadataOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(MetricDescriptorMetadata.DEFAULT_INSTANCE);
            }

            @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
            @Deprecated
            public final int getLaunchStageValue() {
                return ((MetricDescriptorMetadata) this.instance).getLaunchStageValue();
            }

            @Deprecated
            public final Builder setLaunchStageValue(int i) {
                copyOnWrite();
                ((MetricDescriptorMetadata) this.instance).setLaunchStageValue(i);
                return this;
            }

            @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
            @Deprecated
            public final LaunchStage getLaunchStage() {
                return ((MetricDescriptorMetadata) this.instance).getLaunchStage();
            }

            @Deprecated
            public final Builder setLaunchStage(LaunchStage launchStage) {
                copyOnWrite();
                ((MetricDescriptorMetadata) this.instance).setLaunchStage(launchStage);
                return this;
            }

            @Deprecated
            public final Builder clearLaunchStage() {
                copyOnWrite();
                ((MetricDescriptorMetadata) this.instance).clearLaunchStage();
                return this;
            }

            @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
            public final boolean hasSamplePeriod() {
                return ((MetricDescriptorMetadata) this.instance).hasSamplePeriod();
            }

            @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
            public final Duration getSamplePeriod() {
                return ((MetricDescriptorMetadata) this.instance).getSamplePeriod();
            }

            public final Builder setSamplePeriod(Duration duration) {
                copyOnWrite();
                ((MetricDescriptorMetadata) this.instance).setSamplePeriod(duration);
                return this;
            }

            public final Builder setSamplePeriod(Duration.Builder builder) {
                copyOnWrite();
                ((MetricDescriptorMetadata) this.instance).setSamplePeriod(builder.build());
                return this;
            }

            public final Builder mergeSamplePeriod(Duration duration) {
                copyOnWrite();
                ((MetricDescriptorMetadata) this.instance).mergeSamplePeriod(duration);
                return this;
            }

            public final Builder clearSamplePeriod() {
                copyOnWrite();
                ((MetricDescriptorMetadata) this.instance).clearSamplePeriod();
                return this;
            }

            @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
            public final boolean hasIngestDelay() {
                return ((MetricDescriptorMetadata) this.instance).hasIngestDelay();
            }

            @Override // com.google.api.MetricDescriptor.MetricDescriptorMetadataOrBuilder
            public final Duration getIngestDelay() {
                return ((MetricDescriptorMetadata) this.instance).getIngestDelay();
            }

            public final Builder setIngestDelay(Duration duration) {
                copyOnWrite();
                ((MetricDescriptorMetadata) this.instance).setIngestDelay(duration);
                return this;
            }

            public final Builder setIngestDelay(Duration.Builder builder) {
                copyOnWrite();
                ((MetricDescriptorMetadata) this.instance).setIngestDelay(builder.build());
                return this;
            }

            public final Builder mergeIngestDelay(Duration duration) {
                copyOnWrite();
                ((MetricDescriptorMetadata) this.instance).mergeIngestDelay(duration);
                return this;
            }

            public final Builder clearIngestDelay() {
                copyOnWrite();
                ((MetricDescriptorMetadata) this.instance).clearIngestDelay();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new MetricDescriptorMetadata();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\t\u0003\t", new Object[]{"launchStage_", "samplePeriod_", "ingestDelay_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<MetricDescriptorMetadata> parser2 = PARSER;
                    if (parser2 == null) {
                        synchronized (MetricDescriptorMetadata.class) {
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
            MetricDescriptorMetadata metricDescriptorMetadata = new MetricDescriptorMetadata();
            DEFAULT_INSTANCE = metricDescriptorMetadata;
            GeneratedMessageLite.registerDefaultInstance(MetricDescriptorMetadata.class, metricDescriptorMetadata);
        }

        public static MetricDescriptorMetadata getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MetricDescriptorMetadata> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: com.google.api.MetricDescriptor$1  reason: invalid class name */
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

    @Override // com.google.api.MetricDescriptorOrBuilder
    public final String getName() {
        return this.name_;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
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

    @Override // com.google.api.MetricDescriptorOrBuilder
    public final String getType() {
        return this.type_;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
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

    @Override // com.google.api.MetricDescriptorOrBuilder
    public final List<LabelDescriptor> getLabelsList() {
        return this.labels_;
    }

    public final List<? extends LabelDescriptorOrBuilder> getLabelsOrBuilderList() {
        return this.labels_;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public final int getLabelsCount() {
        return this.labels_.size();
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
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

    @Override // com.google.api.MetricDescriptorOrBuilder
    public final int getMetricKindValue() {
        return this.metricKind_;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public final MetricKind getMetricKind() {
        MetricKind forNumber = MetricKind.forNumber(this.metricKind_);
        return forNumber == null ? MetricKind.UNRECOGNIZED : forNumber;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetricKindValue(int i) {
        this.metricKind_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetricKind(MetricKind metricKind) {
        this.metricKind_ = metricKind.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMetricKind() {
        this.metricKind_ = 0;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public final int getValueTypeValue() {
        return this.valueType_;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public final ValueType getValueType() {
        ValueType forNumber = ValueType.forNumber(this.valueType_);
        return forNumber == null ? ValueType.UNRECOGNIZED : forNumber;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValueTypeValue(int i) {
        this.valueType_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValueType(ValueType valueType) {
        this.valueType_ = valueType.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearValueType() {
        this.valueType_ = 0;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public final String getUnit() {
        return this.unit_;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public final ByteString getUnitBytes() {
        return ByteString.copyFromUtf8(this.unit_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUnit(String str) {
        this.unit_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearUnit() {
        this.unit_ = getDefaultInstance().getUnit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUnitBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.unit_ = byteString.toStringUtf8();
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public final String getDescription() {
        return this.description_;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
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

    @Override // com.google.api.MetricDescriptorOrBuilder
    public final String getDisplayName() {
        return this.displayName_;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
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

    @Override // com.google.api.MetricDescriptorOrBuilder
    public final boolean hasMetadata() {
        return this.metadata_ != null;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public final MetricDescriptorMetadata getMetadata() {
        MetricDescriptorMetadata metricDescriptorMetadata = this.metadata_;
        return metricDescriptorMetadata == null ? MetricDescriptorMetadata.getDefaultInstance() : metricDescriptorMetadata;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMetadata(MetricDescriptorMetadata metricDescriptorMetadata) {
        this.metadata_ = metricDescriptorMetadata;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeMetadata(MetricDescriptorMetadata metricDescriptorMetadata) {
        MetricDescriptorMetadata metricDescriptorMetadata2 = this.metadata_;
        if (metricDescriptorMetadata2 != null && metricDescriptorMetadata2 != MetricDescriptorMetadata.getDefaultInstance()) {
            this.metadata_ = MetricDescriptorMetadata.newBuilder(this.metadata_).mergeFrom((MetricDescriptorMetadata.Builder) metricDescriptorMetadata).buildPartial();
        } else {
            this.metadata_ = metricDescriptorMetadata;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMetadata() {
        this.metadata_ = null;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
    public final int getLaunchStageValue() {
        return this.launchStage_;
    }

    @Override // com.google.api.MetricDescriptorOrBuilder
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

    public static MetricDescriptor parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static MetricDescriptor parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MetricDescriptor parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MetricDescriptor parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MetricDescriptor parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MetricDescriptor parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MetricDescriptor parseFrom(InputStream inputStream) throws IOException {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MetricDescriptor parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MetricDescriptor parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (MetricDescriptor) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MetricDescriptor parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MetricDescriptor) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MetricDescriptor parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MetricDescriptor parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MetricDescriptor) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(MetricDescriptor metricDescriptor) {
        return DEFAULT_INSTANCE.createBuilder(metricDescriptor);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<MetricDescriptor, Builder> implements MetricDescriptorOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(MetricDescriptor.DEFAULT_INSTANCE);
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public final String getName() {
            return ((MetricDescriptor) this.instance).getName();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public final ByteString getNameBytes() {
            return ((MetricDescriptor) this.instance).getNameBytes();
        }

        public final Builder setName(String str) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setName(str);
            return this;
        }

        public final Builder clearName() {
            copyOnWrite();
            ((MetricDescriptor) this.instance).clearName();
            return this;
        }

        public final Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setNameBytes(byteString);
            return this;
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public final String getType() {
            return ((MetricDescriptor) this.instance).getType();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public final ByteString getTypeBytes() {
            return ((MetricDescriptor) this.instance).getTypeBytes();
        }

        public final Builder setType(String str) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setType(str);
            return this;
        }

        public final Builder clearType() {
            copyOnWrite();
            ((MetricDescriptor) this.instance).clearType();
            return this;
        }

        public final Builder setTypeBytes(ByteString byteString) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setTypeBytes(byteString);
            return this;
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public final List<LabelDescriptor> getLabelsList() {
            return Collections.unmodifiableList(((MetricDescriptor) this.instance).getLabelsList());
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public final int getLabelsCount() {
            return ((MetricDescriptor) this.instance).getLabelsCount();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public final LabelDescriptor getLabels(int i) {
            return ((MetricDescriptor) this.instance).getLabels(i);
        }

        public final Builder setLabels(int i, LabelDescriptor labelDescriptor) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setLabels(i, labelDescriptor);
            return this;
        }

        public final Builder setLabels(int i, LabelDescriptor.Builder builder) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setLabels(i, builder.build());
            return this;
        }

        public final Builder addLabels(LabelDescriptor labelDescriptor) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).addLabels(labelDescriptor);
            return this;
        }

        public final Builder addLabels(int i, LabelDescriptor labelDescriptor) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).addLabels(i, labelDescriptor);
            return this;
        }

        public final Builder addLabels(LabelDescriptor.Builder builder) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).addLabels(builder.build());
            return this;
        }

        public final Builder addLabels(int i, LabelDescriptor.Builder builder) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).addLabels(i, builder.build());
            return this;
        }

        public final Builder addAllLabels(Iterable<? extends LabelDescriptor> iterable) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).addAllLabels(iterable);
            return this;
        }

        public final Builder clearLabels() {
            copyOnWrite();
            ((MetricDescriptor) this.instance).clearLabels();
            return this;
        }

        public final Builder removeLabels(int i) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).removeLabels(i);
            return this;
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public final int getMetricKindValue() {
            return ((MetricDescriptor) this.instance).getMetricKindValue();
        }

        public final Builder setMetricKindValue(int i) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setMetricKindValue(i);
            return this;
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public final MetricKind getMetricKind() {
            return ((MetricDescriptor) this.instance).getMetricKind();
        }

        public final Builder setMetricKind(MetricKind metricKind) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setMetricKind(metricKind);
            return this;
        }

        public final Builder clearMetricKind() {
            copyOnWrite();
            ((MetricDescriptor) this.instance).clearMetricKind();
            return this;
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public final int getValueTypeValue() {
            return ((MetricDescriptor) this.instance).getValueTypeValue();
        }

        public final Builder setValueTypeValue(int i) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setValueTypeValue(i);
            return this;
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public final ValueType getValueType() {
            return ((MetricDescriptor) this.instance).getValueType();
        }

        public final Builder setValueType(ValueType valueType) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setValueType(valueType);
            return this;
        }

        public final Builder clearValueType() {
            copyOnWrite();
            ((MetricDescriptor) this.instance).clearValueType();
            return this;
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public final String getUnit() {
            return ((MetricDescriptor) this.instance).getUnit();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public final ByteString getUnitBytes() {
            return ((MetricDescriptor) this.instance).getUnitBytes();
        }

        public final Builder setUnit(String str) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setUnit(str);
            return this;
        }

        public final Builder clearUnit() {
            copyOnWrite();
            ((MetricDescriptor) this.instance).clearUnit();
            return this;
        }

        public final Builder setUnitBytes(ByteString byteString) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setUnitBytes(byteString);
            return this;
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public final String getDescription() {
            return ((MetricDescriptor) this.instance).getDescription();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public final ByteString getDescriptionBytes() {
            return ((MetricDescriptor) this.instance).getDescriptionBytes();
        }

        public final Builder setDescription(String str) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setDescription(str);
            return this;
        }

        public final Builder clearDescription() {
            copyOnWrite();
            ((MetricDescriptor) this.instance).clearDescription();
            return this;
        }

        public final Builder setDescriptionBytes(ByteString byteString) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setDescriptionBytes(byteString);
            return this;
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public final String getDisplayName() {
            return ((MetricDescriptor) this.instance).getDisplayName();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public final ByteString getDisplayNameBytes() {
            return ((MetricDescriptor) this.instance).getDisplayNameBytes();
        }

        public final Builder setDisplayName(String str) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setDisplayName(str);
            return this;
        }

        public final Builder clearDisplayName() {
            copyOnWrite();
            ((MetricDescriptor) this.instance).clearDisplayName();
            return this;
        }

        public final Builder setDisplayNameBytes(ByteString byteString) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setDisplayNameBytes(byteString);
            return this;
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public final boolean hasMetadata() {
            return ((MetricDescriptor) this.instance).hasMetadata();
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public final MetricDescriptorMetadata getMetadata() {
            return ((MetricDescriptor) this.instance).getMetadata();
        }

        public final Builder setMetadata(MetricDescriptorMetadata metricDescriptorMetadata) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setMetadata(metricDescriptorMetadata);
            return this;
        }

        public final Builder setMetadata(MetricDescriptorMetadata.Builder builder) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setMetadata(builder.build());
            return this;
        }

        public final Builder mergeMetadata(MetricDescriptorMetadata metricDescriptorMetadata) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).mergeMetadata(metricDescriptorMetadata);
            return this;
        }

        public final Builder clearMetadata() {
            copyOnWrite();
            ((MetricDescriptor) this.instance).clearMetadata();
            return this;
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public final int getLaunchStageValue() {
            return ((MetricDescriptor) this.instance).getLaunchStageValue();
        }

        public final Builder setLaunchStageValue(int i) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setLaunchStageValue(i);
            return this;
        }

        @Override // com.google.api.MetricDescriptorOrBuilder
        public final LaunchStage getLaunchStage() {
            return ((MetricDescriptor) this.instance).getLaunchStage();
        }

        public final Builder setLaunchStage(LaunchStage launchStage) {
            copyOnWrite();
            ((MetricDescriptor) this.instance).setLaunchStage(launchStage);
            return this;
        }

        public final Builder clearLaunchStage() {
            copyOnWrite();
            ((MetricDescriptor) this.instance).clearLaunchStage();
            return this;
        }
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser parser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new MetricDescriptor();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\n\u0000\u0000\u0001\f\n\u0000\u0001\u0000\u0001Ȉ\u0002\u001b\u0003\f\u0004\f\u0005Ȉ\u0006Ȉ\u0007Ȉ\bȈ\n\t\f\f", new Object[]{"name_", "labels_", LabelDescriptor.class, "metricKind_", "valueType_", "unit_", "description_", "displayName_", "type_", "metadata_", "launchStage_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MetricDescriptor> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (MetricDescriptor.class) {
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
        MetricDescriptor metricDescriptor = new MetricDescriptor();
        DEFAULT_INSTANCE = metricDescriptor;
        GeneratedMessageLite.registerDefaultInstance(MetricDescriptor.class, metricDescriptor);
    }

    public static MetricDescriptor getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<MetricDescriptor> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
