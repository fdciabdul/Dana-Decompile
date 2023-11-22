package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.AndroidMemoryReading;
import com.google.firebase.perf.v1.CpuMetricReading;
import com.google.firebase.perf.v1.GaugeMetadata;
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

/* loaded from: classes.dex */
public final class GaugeMetric extends GeneratedMessageLite<GaugeMetric, Builder> implements GaugeMetricOrBuilder {
    public static final int ANDROID_MEMORY_READINGS_FIELD_NUMBER = 4;
    public static final int CPU_METRIC_READINGS_FIELD_NUMBER = 2;
    private static final GaugeMetric DEFAULT_INSTANCE;
    public static final int GAUGE_METADATA_FIELD_NUMBER = 3;
    private static volatile Parser<GaugeMetric> PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 1;
    private int bitField0_;
    private GaugeMetadata gaugeMetadata_;
    private String sessionId_ = "";
    private Internal.ProtobufList<CpuMetricReading> cpuMetricReadings_ = emptyProtobufList();
    private Internal.ProtobufList<AndroidMemoryReading> androidMemoryReadings_ = emptyProtobufList();

    private GaugeMetric() {
    }

    @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
    public final boolean hasSessionId() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
    public final String getSessionId() {
        return this.sessionId_;
    }

    @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
    public final ByteString getSessionIdBytes() {
        return ByteString.copyFromUtf8(this.sessionId_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSessionId(String str) {
        this.bitField0_ |= 1;
        this.sessionId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSessionId() {
        this.bitField0_ &= -2;
        this.sessionId_ = getDefaultInstance().getSessionId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSessionIdBytes(ByteString byteString) {
        this.sessionId_ = byteString.toStringUtf8();
        this.bitField0_ |= 1;
    }

    @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
    public final boolean hasGaugeMetadata() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
    public final GaugeMetadata getGaugeMetadata() {
        GaugeMetadata gaugeMetadata = this.gaugeMetadata_;
        return gaugeMetadata == null ? GaugeMetadata.getDefaultInstance() : gaugeMetadata;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGaugeMetadata(GaugeMetadata gaugeMetadata) {
        this.gaugeMetadata_ = gaugeMetadata;
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeGaugeMetadata(GaugeMetadata gaugeMetadata) {
        GaugeMetadata gaugeMetadata2 = this.gaugeMetadata_;
        if (gaugeMetadata2 != null && gaugeMetadata2 != GaugeMetadata.getDefaultInstance()) {
            this.gaugeMetadata_ = GaugeMetadata.newBuilder(this.gaugeMetadata_).mergeFrom((GaugeMetadata.Builder) gaugeMetadata).buildPartial();
        } else {
            this.gaugeMetadata_ = gaugeMetadata;
        }
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearGaugeMetadata() {
        this.gaugeMetadata_ = null;
        this.bitField0_ &= -3;
    }

    @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
    public final List<CpuMetricReading> getCpuMetricReadingsList() {
        return this.cpuMetricReadings_;
    }

    public final List<? extends CpuMetricReadingOrBuilder> getCpuMetricReadingsOrBuilderList() {
        return this.cpuMetricReadings_;
    }

    @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
    public final int getCpuMetricReadingsCount() {
        return this.cpuMetricReadings_.size();
    }

    @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
    public final CpuMetricReading getCpuMetricReadings(int i) {
        return this.cpuMetricReadings_.get(i);
    }

    public final CpuMetricReadingOrBuilder getCpuMetricReadingsOrBuilder(int i) {
        return this.cpuMetricReadings_.get(i);
    }

    private void ensureCpuMetricReadingsIsMutable() {
        Internal.ProtobufList<CpuMetricReading> protobufList = this.cpuMetricReadings_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.cpuMetricReadings_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCpuMetricReadings(int i, CpuMetricReading cpuMetricReading) {
        ensureCpuMetricReadingsIsMutable();
        this.cpuMetricReadings_.set(i, cpuMetricReading);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCpuMetricReadings(CpuMetricReading cpuMetricReading) {
        ensureCpuMetricReadingsIsMutable();
        this.cpuMetricReadings_.add(cpuMetricReading);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCpuMetricReadings(int i, CpuMetricReading cpuMetricReading) {
        ensureCpuMetricReadingsIsMutable();
        this.cpuMetricReadings_.add(i, cpuMetricReading);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllCpuMetricReadings(Iterable<? extends CpuMetricReading> iterable) {
        ensureCpuMetricReadingsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.cpuMetricReadings_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCpuMetricReadings() {
        this.cpuMetricReadings_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeCpuMetricReadings(int i) {
        ensureCpuMetricReadingsIsMutable();
        this.cpuMetricReadings_.remove(i);
    }

    @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
    public final List<AndroidMemoryReading> getAndroidMemoryReadingsList() {
        return this.androidMemoryReadings_;
    }

    public final List<? extends AndroidMemoryReadingOrBuilder> getAndroidMemoryReadingsOrBuilderList() {
        return this.androidMemoryReadings_;
    }

    @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
    public final int getAndroidMemoryReadingsCount() {
        return this.androidMemoryReadings_.size();
    }

    @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
    public final AndroidMemoryReading getAndroidMemoryReadings(int i) {
        return this.androidMemoryReadings_.get(i);
    }

    public final AndroidMemoryReadingOrBuilder getAndroidMemoryReadingsOrBuilder(int i) {
        return this.androidMemoryReadings_.get(i);
    }

    private void ensureAndroidMemoryReadingsIsMutable() {
        Internal.ProtobufList<AndroidMemoryReading> protobufList = this.androidMemoryReadings_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.androidMemoryReadings_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAndroidMemoryReadings(int i, AndroidMemoryReading androidMemoryReading) {
        ensureAndroidMemoryReadingsIsMutable();
        this.androidMemoryReadings_.set(i, androidMemoryReading);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAndroidMemoryReadings(AndroidMemoryReading androidMemoryReading) {
        ensureAndroidMemoryReadingsIsMutable();
        this.androidMemoryReadings_.add(androidMemoryReading);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAndroidMemoryReadings(int i, AndroidMemoryReading androidMemoryReading) {
        ensureAndroidMemoryReadingsIsMutable();
        this.androidMemoryReadings_.add(i, androidMemoryReading);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllAndroidMemoryReadings(Iterable<? extends AndroidMemoryReading> iterable) {
        ensureAndroidMemoryReadingsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.androidMemoryReadings_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAndroidMemoryReadings() {
        this.androidMemoryReadings_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAndroidMemoryReadings(int i) {
        ensureAndroidMemoryReadingsIsMutable();
        this.androidMemoryReadings_.remove(i);
    }

    public static GaugeMetric parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (GaugeMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static GaugeMetric parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (GaugeMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GaugeMetric parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (GaugeMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static GaugeMetric parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (GaugeMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static GaugeMetric parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (GaugeMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static GaugeMetric parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (GaugeMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static GaugeMetric parseFrom(InputStream inputStream) throws IOException {
        return (GaugeMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GaugeMetric parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GaugeMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GaugeMetric parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (GaugeMetric) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static GaugeMetric parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GaugeMetric) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GaugeMetric parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (GaugeMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static GaugeMetric parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GaugeMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(GaugeMetric gaugeMetric) {
        return DEFAULT_INSTANCE.createBuilder(gaugeMetric);
    }

    /* loaded from: classes.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<GaugeMetric, Builder> implements GaugeMetricOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(GaugeMetric.DEFAULT_INSTANCE);
        }

        @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
        public final boolean hasSessionId() {
            return ((GaugeMetric) this.instance).hasSessionId();
        }

        @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
        public final String getSessionId() {
            return ((GaugeMetric) this.instance).getSessionId();
        }

        @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
        public final ByteString getSessionIdBytes() {
            return ((GaugeMetric) this.instance).getSessionIdBytes();
        }

        public final Builder setSessionId(String str) {
            copyOnWrite();
            ((GaugeMetric) this.instance).setSessionId(str);
            return this;
        }

        public final Builder clearSessionId() {
            copyOnWrite();
            ((GaugeMetric) this.instance).clearSessionId();
            return this;
        }

        public final Builder setSessionIdBytes(ByteString byteString) {
            copyOnWrite();
            ((GaugeMetric) this.instance).setSessionIdBytes(byteString);
            return this;
        }

        @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
        public final boolean hasGaugeMetadata() {
            return ((GaugeMetric) this.instance).hasGaugeMetadata();
        }

        @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
        public final GaugeMetadata getGaugeMetadata() {
            return ((GaugeMetric) this.instance).getGaugeMetadata();
        }

        public final Builder setGaugeMetadata(GaugeMetadata gaugeMetadata) {
            copyOnWrite();
            ((GaugeMetric) this.instance).setGaugeMetadata(gaugeMetadata);
            return this;
        }

        public final Builder setGaugeMetadata(GaugeMetadata.Builder builder) {
            copyOnWrite();
            ((GaugeMetric) this.instance).setGaugeMetadata(builder.build());
            return this;
        }

        public final Builder mergeGaugeMetadata(GaugeMetadata gaugeMetadata) {
            copyOnWrite();
            ((GaugeMetric) this.instance).mergeGaugeMetadata(gaugeMetadata);
            return this;
        }

        public final Builder clearGaugeMetadata() {
            copyOnWrite();
            ((GaugeMetric) this.instance).clearGaugeMetadata();
            return this;
        }

        @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
        public final List<CpuMetricReading> getCpuMetricReadingsList() {
            return Collections.unmodifiableList(((GaugeMetric) this.instance).getCpuMetricReadingsList());
        }

        @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
        public final int getCpuMetricReadingsCount() {
            return ((GaugeMetric) this.instance).getCpuMetricReadingsCount();
        }

        @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
        public final CpuMetricReading getCpuMetricReadings(int i) {
            return ((GaugeMetric) this.instance).getCpuMetricReadings(i);
        }

        public final Builder setCpuMetricReadings(int i, CpuMetricReading cpuMetricReading) {
            copyOnWrite();
            ((GaugeMetric) this.instance).setCpuMetricReadings(i, cpuMetricReading);
            return this;
        }

        public final Builder setCpuMetricReadings(int i, CpuMetricReading.Builder builder) {
            copyOnWrite();
            ((GaugeMetric) this.instance).setCpuMetricReadings(i, builder.build());
            return this;
        }

        public final Builder addCpuMetricReadings(CpuMetricReading cpuMetricReading) {
            copyOnWrite();
            ((GaugeMetric) this.instance).addCpuMetricReadings(cpuMetricReading);
            return this;
        }

        public final Builder addCpuMetricReadings(int i, CpuMetricReading cpuMetricReading) {
            copyOnWrite();
            ((GaugeMetric) this.instance).addCpuMetricReadings(i, cpuMetricReading);
            return this;
        }

        public final Builder addCpuMetricReadings(CpuMetricReading.Builder builder) {
            copyOnWrite();
            ((GaugeMetric) this.instance).addCpuMetricReadings(builder.build());
            return this;
        }

        public final Builder addCpuMetricReadings(int i, CpuMetricReading.Builder builder) {
            copyOnWrite();
            ((GaugeMetric) this.instance).addCpuMetricReadings(i, builder.build());
            return this;
        }

        public final Builder addAllCpuMetricReadings(Iterable<? extends CpuMetricReading> iterable) {
            copyOnWrite();
            ((GaugeMetric) this.instance).addAllCpuMetricReadings(iterable);
            return this;
        }

        public final Builder clearCpuMetricReadings() {
            copyOnWrite();
            ((GaugeMetric) this.instance).clearCpuMetricReadings();
            return this;
        }

        public final Builder removeCpuMetricReadings(int i) {
            copyOnWrite();
            ((GaugeMetric) this.instance).removeCpuMetricReadings(i);
            return this;
        }

        @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
        public final List<AndroidMemoryReading> getAndroidMemoryReadingsList() {
            return Collections.unmodifiableList(((GaugeMetric) this.instance).getAndroidMemoryReadingsList());
        }

        @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
        public final int getAndroidMemoryReadingsCount() {
            return ((GaugeMetric) this.instance).getAndroidMemoryReadingsCount();
        }

        @Override // com.google.firebase.perf.v1.GaugeMetricOrBuilder
        public final AndroidMemoryReading getAndroidMemoryReadings(int i) {
            return ((GaugeMetric) this.instance).getAndroidMemoryReadings(i);
        }

        public final Builder setAndroidMemoryReadings(int i, AndroidMemoryReading androidMemoryReading) {
            copyOnWrite();
            ((GaugeMetric) this.instance).setAndroidMemoryReadings(i, androidMemoryReading);
            return this;
        }

        public final Builder setAndroidMemoryReadings(int i, AndroidMemoryReading.Builder builder) {
            copyOnWrite();
            ((GaugeMetric) this.instance).setAndroidMemoryReadings(i, builder.build());
            return this;
        }

        public final Builder addAndroidMemoryReadings(AndroidMemoryReading androidMemoryReading) {
            copyOnWrite();
            ((GaugeMetric) this.instance).addAndroidMemoryReadings(androidMemoryReading);
            return this;
        }

        public final Builder addAndroidMemoryReadings(int i, AndroidMemoryReading androidMemoryReading) {
            copyOnWrite();
            ((GaugeMetric) this.instance).addAndroidMemoryReadings(i, androidMemoryReading);
            return this;
        }

        public final Builder addAndroidMemoryReadings(AndroidMemoryReading.Builder builder) {
            copyOnWrite();
            ((GaugeMetric) this.instance).addAndroidMemoryReadings(builder.build());
            return this;
        }

        public final Builder addAndroidMemoryReadings(int i, AndroidMemoryReading.Builder builder) {
            copyOnWrite();
            ((GaugeMetric) this.instance).addAndroidMemoryReadings(i, builder.build());
            return this;
        }

        public final Builder addAllAndroidMemoryReadings(Iterable<? extends AndroidMemoryReading> iterable) {
            copyOnWrite();
            ((GaugeMetric) this.instance).addAllAndroidMemoryReadings(iterable);
            return this;
        }

        public final Builder clearAndroidMemoryReadings() {
            copyOnWrite();
            ((GaugeMetric) this.instance).clearAndroidMemoryReadings();
            return this;
        }

        public final Builder removeAndroidMemoryReadings(int i) {
            copyOnWrite();
            ((GaugeMetric) this.instance).removeAndroidMemoryReadings(i);
            return this;
        }
    }

    /* renamed from: com.google.firebase.perf.v1.GaugeMetric$1  reason: invalid class name */
    /* loaded from: classes.dex */
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
                return new GaugeMetric();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဉ\u0001\u0004\u001b", new Object[]{"bitField0_", "sessionId_", "cpuMetricReadings_", CpuMetricReading.class, "gaugeMetadata_", "androidMemoryReadings_", AndroidMemoryReading.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<GaugeMetric> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (GaugeMetric.class) {
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
        GaugeMetric gaugeMetric = new GaugeMetric();
        DEFAULT_INSTANCE = gaugeMetric;
        GeneratedMessageLite.registerDefaultInstance(GaugeMetric.class, gaugeMetric);
    }

    public static GaugeMetric getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<GaugeMetric> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
