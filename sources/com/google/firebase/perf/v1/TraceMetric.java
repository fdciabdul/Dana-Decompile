package com.google.firebase.perf.v1;

import com.google.firebase.perf.v1.PerfSession;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class TraceMetric extends GeneratedMessageLite<TraceMetric, Builder> implements TraceMetricOrBuilder {
    public static final int CLIENT_START_TIME_US_FIELD_NUMBER = 4;
    public static final int COUNTERS_FIELD_NUMBER = 6;
    public static final int CUSTOM_ATTRIBUTES_FIELD_NUMBER = 8;
    private static final TraceMetric DEFAULT_INSTANCE;
    public static final int DURATION_US_FIELD_NUMBER = 5;
    public static final int IS_AUTO_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<TraceMetric> PARSER = null;
    public static final int PERF_SESSIONS_FIELD_NUMBER = 9;
    public static final int SUBTRACES_FIELD_NUMBER = 7;
    private int bitField0_;
    private long clientStartTimeUs_;
    private long durationUs_;
    private boolean isAuto_;
    private MapFieldLite<String, Long> counters_ = MapFieldLite.emptyMapField();
    private MapFieldLite<String, String> customAttributes_ = MapFieldLite.emptyMapField();
    private String name_ = "";
    private Internal.ProtobufList<TraceMetric> subtraces_ = emptyProtobufList();
    private Internal.ProtobufList<PerfSession> perfSessions_ = emptyProtobufList();

    private TraceMetric() {
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public final boolean hasName() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public final String getName() {
        return this.name_;
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public final ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        this.bitField0_ |= 1;
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.bitField0_ &= -2;
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(ByteString byteString) {
        this.name_ = byteString.toStringUtf8();
        this.bitField0_ |= 1;
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public final boolean hasIsAuto() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public final boolean getIsAuto() {
        return this.isAuto_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIsAuto(boolean z) {
        this.bitField0_ |= 2;
        this.isAuto_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIsAuto() {
        this.bitField0_ &= -3;
        this.isAuto_ = false;
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public final boolean hasClientStartTimeUs() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public final long getClientStartTimeUs() {
        return this.clientStartTimeUs_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClientStartTimeUs(long j) {
        this.bitField0_ |= 4;
        this.clientStartTimeUs_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClientStartTimeUs() {
        this.bitField0_ &= -5;
        this.clientStartTimeUs_ = 0L;
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public final boolean hasDurationUs() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public final long getDurationUs() {
        return this.durationUs_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDurationUs(long j) {
        this.bitField0_ |= 8;
        this.durationUs_ = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDurationUs() {
        this.bitField0_ &= -9;
        this.durationUs_ = 0L;
    }

    /* loaded from: classes.dex */
    static final class CountersDefaultEntryHolder {
        static final MapEntryLite<String, Long> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.INT64, 0L);

        private CountersDefaultEntryHolder() {
        }
    }

    private MapFieldLite<String, Long> internalGetCounters() {
        return this.counters_;
    }

    private MapFieldLite<String, Long> internalGetMutableCounters() {
        if (!this.counters_.isMutable()) {
            this.counters_ = this.counters_.mutableCopy();
        }
        return this.counters_;
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public final int getCountersCount() {
        return internalGetCounters().size();
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public final boolean containsCounters(String str) {
        return internalGetCounters().containsKey(str);
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    @Deprecated
    public final Map<String, Long> getCounters() {
        return getCountersMap();
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public final Map<String, Long> getCountersMap() {
        return Collections.unmodifiableMap(internalGetCounters());
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public final long getCountersOrDefault(String str, long j) {
        MapFieldLite<String, Long> internalGetCounters = internalGetCounters();
        return internalGetCounters.containsKey(str) ? internalGetCounters.get(str).longValue() : j;
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public final long getCountersOrThrow(String str) {
        MapFieldLite<String, Long> internalGetCounters = internalGetCounters();
        if (!internalGetCounters.containsKey(str)) {
            throw new IllegalArgumentException();
        }
        return internalGetCounters.get(str).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Long> getMutableCountersMap() {
        return internalGetMutableCounters();
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public final List<TraceMetric> getSubtracesList() {
        return this.subtraces_;
    }

    public final List<? extends TraceMetricOrBuilder> getSubtracesOrBuilderList() {
        return this.subtraces_;
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public final int getSubtracesCount() {
        return this.subtraces_.size();
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public final TraceMetric getSubtraces(int i) {
        return this.subtraces_.get(i);
    }

    public final TraceMetricOrBuilder getSubtracesOrBuilder(int i) {
        return this.subtraces_.get(i);
    }

    private void ensureSubtracesIsMutable() {
        Internal.ProtobufList<TraceMetric> protobufList = this.subtraces_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.subtraces_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSubtraces(int i, TraceMetric traceMetric) {
        ensureSubtracesIsMutable();
        this.subtraces_.set(i, traceMetric);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSubtraces(TraceMetric traceMetric) {
        ensureSubtracesIsMutable();
        this.subtraces_.add(traceMetric);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSubtraces(int i, TraceMetric traceMetric) {
        ensureSubtracesIsMutable();
        this.subtraces_.add(i, traceMetric);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllSubtraces(Iterable<? extends TraceMetric> iterable) {
        ensureSubtracesIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.subtraces_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSubtraces() {
        this.subtraces_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeSubtraces(int i) {
        ensureSubtracesIsMutable();
        this.subtraces_.remove(i);
    }

    /* loaded from: classes.dex */
    static final class CustomAttributesDefaultEntryHolder {
        static final MapEntryLite<String, String> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.STRING, "");

        private CustomAttributesDefaultEntryHolder() {
        }
    }

    private MapFieldLite<String, String> internalGetCustomAttributes() {
        return this.customAttributes_;
    }

    private MapFieldLite<String, String> internalGetMutableCustomAttributes() {
        if (!this.customAttributes_.isMutable()) {
            this.customAttributes_ = this.customAttributes_.mutableCopy();
        }
        return this.customAttributes_;
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public final int getCustomAttributesCount() {
        return internalGetCustomAttributes().size();
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public final boolean containsCustomAttributes(String str) {
        return internalGetCustomAttributes().containsKey(str);
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    @Deprecated
    public final Map<String, String> getCustomAttributes() {
        return getCustomAttributesMap();
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public final Map<String, String> getCustomAttributesMap() {
        return Collections.unmodifiableMap(internalGetCustomAttributes());
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public final String getCustomAttributesOrDefault(String str, String str2) {
        MapFieldLite<String, String> internalGetCustomAttributes = internalGetCustomAttributes();
        return internalGetCustomAttributes.containsKey(str) ? internalGetCustomAttributes.get(str) : str2;
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public final String getCustomAttributesOrThrow(String str) {
        MapFieldLite<String, String> internalGetCustomAttributes = internalGetCustomAttributes();
        if (!internalGetCustomAttributes.containsKey(str)) {
            throw new IllegalArgumentException();
        }
        return internalGetCustomAttributes.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getMutableCustomAttributesMap() {
        return internalGetMutableCustomAttributes();
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public final List<PerfSession> getPerfSessionsList() {
        return this.perfSessions_;
    }

    public final List<? extends PerfSessionOrBuilder> getPerfSessionsOrBuilderList() {
        return this.perfSessions_;
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public final int getPerfSessionsCount() {
        return this.perfSessions_.size();
    }

    @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
    public final PerfSession getPerfSessions(int i) {
        return this.perfSessions_.get(i);
    }

    public final PerfSessionOrBuilder getPerfSessionsOrBuilder(int i) {
        return this.perfSessions_.get(i);
    }

    private void ensurePerfSessionsIsMutable() {
        Internal.ProtobufList<PerfSession> protobufList = this.perfSessions_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.perfSessions_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPerfSessions(int i, PerfSession perfSession) {
        ensurePerfSessionsIsMutable();
        this.perfSessions_.set(i, perfSession);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPerfSessions(PerfSession perfSession) {
        ensurePerfSessionsIsMutable();
        this.perfSessions_.add(perfSession);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPerfSessions(int i, PerfSession perfSession) {
        ensurePerfSessionsIsMutable();
        this.perfSessions_.add(i, perfSession);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllPerfSessions(Iterable<? extends PerfSession> iterable) {
        ensurePerfSessionsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.perfSessions_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPerfSessions() {
        this.perfSessions_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removePerfSessions(int i) {
        ensurePerfSessionsIsMutable();
        this.perfSessions_.remove(i);
    }

    public static TraceMetric parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (TraceMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static TraceMetric parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TraceMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static TraceMetric parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (TraceMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static TraceMetric parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TraceMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static TraceMetric parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (TraceMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static TraceMetric parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TraceMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static TraceMetric parseFrom(InputStream inputStream) throws IOException {
        return (TraceMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TraceMetric parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TraceMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TraceMetric parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (TraceMetric) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static TraceMetric parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TraceMetric) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static TraceMetric parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (TraceMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static TraceMetric parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (TraceMetric) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(TraceMetric traceMetric) {
        return DEFAULT_INSTANCE.createBuilder(traceMetric);
    }

    /* loaded from: classes.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<TraceMetric, Builder> implements TraceMetricOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(TraceMetric.DEFAULT_INSTANCE);
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public final boolean hasName() {
            return ((TraceMetric) this.instance).hasName();
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public final String getName() {
            return ((TraceMetric) this.instance).getName();
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public final ByteString getNameBytes() {
            return ((TraceMetric) this.instance).getNameBytes();
        }

        public final Builder setName(String str) {
            copyOnWrite();
            ((TraceMetric) this.instance).setName(str);
            return this;
        }

        public final Builder clearName() {
            copyOnWrite();
            ((TraceMetric) this.instance).clearName();
            return this;
        }

        public final Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            ((TraceMetric) this.instance).setNameBytes(byteString);
            return this;
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public final boolean hasIsAuto() {
            return ((TraceMetric) this.instance).hasIsAuto();
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public final boolean getIsAuto() {
            return ((TraceMetric) this.instance).getIsAuto();
        }

        public final Builder setIsAuto(boolean z) {
            copyOnWrite();
            ((TraceMetric) this.instance).setIsAuto(z);
            return this;
        }

        public final Builder clearIsAuto() {
            copyOnWrite();
            ((TraceMetric) this.instance).clearIsAuto();
            return this;
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public final boolean hasClientStartTimeUs() {
            return ((TraceMetric) this.instance).hasClientStartTimeUs();
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public final long getClientStartTimeUs() {
            return ((TraceMetric) this.instance).getClientStartTimeUs();
        }

        public final Builder setClientStartTimeUs(long j) {
            copyOnWrite();
            ((TraceMetric) this.instance).setClientStartTimeUs(j);
            return this;
        }

        public final Builder clearClientStartTimeUs() {
            copyOnWrite();
            ((TraceMetric) this.instance).clearClientStartTimeUs();
            return this;
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public final boolean hasDurationUs() {
            return ((TraceMetric) this.instance).hasDurationUs();
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public final long getDurationUs() {
            return ((TraceMetric) this.instance).getDurationUs();
        }

        public final Builder setDurationUs(long j) {
            copyOnWrite();
            ((TraceMetric) this.instance).setDurationUs(j);
            return this;
        }

        public final Builder clearDurationUs() {
            copyOnWrite();
            ((TraceMetric) this.instance).clearDurationUs();
            return this;
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public final int getCountersCount() {
            return ((TraceMetric) this.instance).getCountersMap().size();
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public final boolean containsCounters(String str) {
            return ((TraceMetric) this.instance).getCountersMap().containsKey(str);
        }

        public final Builder clearCounters() {
            copyOnWrite();
            ((TraceMetric) this.instance).getMutableCountersMap().clear();
            return this;
        }

        public final Builder removeCounters(String str) {
            copyOnWrite();
            ((TraceMetric) this.instance).getMutableCountersMap().remove(str);
            return this;
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        @Deprecated
        public final Map<String, Long> getCounters() {
            return getCountersMap();
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public final Map<String, Long> getCountersMap() {
            return Collections.unmodifiableMap(((TraceMetric) this.instance).getCountersMap());
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public final long getCountersOrDefault(String str, long j) {
            Map<String, Long> countersMap = ((TraceMetric) this.instance).getCountersMap();
            return countersMap.containsKey(str) ? countersMap.get(str).longValue() : j;
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public final long getCountersOrThrow(String str) {
            Map<String, Long> countersMap = ((TraceMetric) this.instance).getCountersMap();
            if (!countersMap.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return countersMap.get(str).longValue();
        }

        public final Builder putCounters(String str, long j) {
            copyOnWrite();
            ((TraceMetric) this.instance).getMutableCountersMap().put(str, Long.valueOf(j));
            return this;
        }

        public final Builder putAllCounters(Map<String, Long> map) {
            copyOnWrite();
            ((TraceMetric) this.instance).getMutableCountersMap().putAll(map);
            return this;
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public final List<TraceMetric> getSubtracesList() {
            return Collections.unmodifiableList(((TraceMetric) this.instance).getSubtracesList());
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public final int getSubtracesCount() {
            return ((TraceMetric) this.instance).getSubtracesCount();
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public final TraceMetric getSubtraces(int i) {
            return ((TraceMetric) this.instance).getSubtraces(i);
        }

        public final Builder setSubtraces(int i, TraceMetric traceMetric) {
            copyOnWrite();
            ((TraceMetric) this.instance).setSubtraces(i, traceMetric);
            return this;
        }

        public final Builder setSubtraces(int i, Builder builder) {
            copyOnWrite();
            ((TraceMetric) this.instance).setSubtraces(i, builder.build());
            return this;
        }

        public final Builder addSubtraces(TraceMetric traceMetric) {
            copyOnWrite();
            ((TraceMetric) this.instance).addSubtraces(traceMetric);
            return this;
        }

        public final Builder addSubtraces(int i, TraceMetric traceMetric) {
            copyOnWrite();
            ((TraceMetric) this.instance).addSubtraces(i, traceMetric);
            return this;
        }

        public final Builder addSubtraces(Builder builder) {
            copyOnWrite();
            ((TraceMetric) this.instance).addSubtraces(builder.build());
            return this;
        }

        public final Builder addSubtraces(int i, Builder builder) {
            copyOnWrite();
            ((TraceMetric) this.instance).addSubtraces(i, builder.build());
            return this;
        }

        public final Builder addAllSubtraces(Iterable<? extends TraceMetric> iterable) {
            copyOnWrite();
            ((TraceMetric) this.instance).addAllSubtraces(iterable);
            return this;
        }

        public final Builder clearSubtraces() {
            copyOnWrite();
            ((TraceMetric) this.instance).clearSubtraces();
            return this;
        }

        public final Builder removeSubtraces(int i) {
            copyOnWrite();
            ((TraceMetric) this.instance).removeSubtraces(i);
            return this;
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public final int getCustomAttributesCount() {
            return ((TraceMetric) this.instance).getCustomAttributesMap().size();
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public final boolean containsCustomAttributes(String str) {
            return ((TraceMetric) this.instance).getCustomAttributesMap().containsKey(str);
        }

        public final Builder clearCustomAttributes() {
            copyOnWrite();
            ((TraceMetric) this.instance).getMutableCustomAttributesMap().clear();
            return this;
        }

        public final Builder removeCustomAttributes(String str) {
            copyOnWrite();
            ((TraceMetric) this.instance).getMutableCustomAttributesMap().remove(str);
            return this;
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        @Deprecated
        public final Map<String, String> getCustomAttributes() {
            return getCustomAttributesMap();
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public final Map<String, String> getCustomAttributesMap() {
            return Collections.unmodifiableMap(((TraceMetric) this.instance).getCustomAttributesMap());
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public final String getCustomAttributesOrDefault(String str, String str2) {
            Map<String, String> customAttributesMap = ((TraceMetric) this.instance).getCustomAttributesMap();
            return customAttributesMap.containsKey(str) ? customAttributesMap.get(str) : str2;
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public final String getCustomAttributesOrThrow(String str) {
            Map<String, String> customAttributesMap = ((TraceMetric) this.instance).getCustomAttributesMap();
            if (!customAttributesMap.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return customAttributesMap.get(str);
        }

        public final Builder putCustomAttributes(String str, String str2) {
            copyOnWrite();
            ((TraceMetric) this.instance).getMutableCustomAttributesMap().put(str, str2);
            return this;
        }

        public final Builder putAllCustomAttributes(Map<String, String> map) {
            copyOnWrite();
            ((TraceMetric) this.instance).getMutableCustomAttributesMap().putAll(map);
            return this;
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public final List<PerfSession> getPerfSessionsList() {
            return Collections.unmodifiableList(((TraceMetric) this.instance).getPerfSessionsList());
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public final int getPerfSessionsCount() {
            return ((TraceMetric) this.instance).getPerfSessionsCount();
        }

        @Override // com.google.firebase.perf.v1.TraceMetricOrBuilder
        public final PerfSession getPerfSessions(int i) {
            return ((TraceMetric) this.instance).getPerfSessions(i);
        }

        public final Builder setPerfSessions(int i, PerfSession perfSession) {
            copyOnWrite();
            ((TraceMetric) this.instance).setPerfSessions(i, perfSession);
            return this;
        }

        public final Builder setPerfSessions(int i, PerfSession.Builder builder) {
            copyOnWrite();
            ((TraceMetric) this.instance).setPerfSessions(i, builder.build());
            return this;
        }

        public final Builder addPerfSessions(PerfSession perfSession) {
            copyOnWrite();
            ((TraceMetric) this.instance).addPerfSessions(perfSession);
            return this;
        }

        public final Builder addPerfSessions(int i, PerfSession perfSession) {
            copyOnWrite();
            ((TraceMetric) this.instance).addPerfSessions(i, perfSession);
            return this;
        }

        public final Builder addPerfSessions(PerfSession.Builder builder) {
            copyOnWrite();
            ((TraceMetric) this.instance).addPerfSessions(builder.build());
            return this;
        }

        public final Builder addPerfSessions(int i, PerfSession.Builder builder) {
            copyOnWrite();
            ((TraceMetric) this.instance).addPerfSessions(i, builder.build());
            return this;
        }

        public final Builder addAllPerfSessions(Iterable<? extends PerfSession> iterable) {
            copyOnWrite();
            ((TraceMetric) this.instance).addAllPerfSessions(iterable);
            return this;
        }

        public final Builder clearPerfSessions() {
            copyOnWrite();
            ((TraceMetric) this.instance).clearPerfSessions();
            return this;
        }

        public final Builder removePerfSessions(int i) {
            copyOnWrite();
            ((TraceMetric) this.instance).removePerfSessions(i);
            return this;
        }
    }

    /* renamed from: com.google.firebase.perf.v1.TraceMetric$1  reason: invalid class name */
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
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new TraceMetric();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0001\b\u0000\u0001\u0001\t\b\u0002\u0002\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0004ဂ\u0002\u0005ဂ\u0003\u00062\u0007\u001b\b2\t\u001b", new Object[]{"bitField0_", "name_", "isAuto_", "clientStartTimeUs_", "durationUs_", "counters_", CountersDefaultEntryHolder.defaultEntry, "subtraces_", TraceMetric.class, "customAttributes_", CustomAttributesDefaultEntryHolder.defaultEntry, "perfSessions_", PerfSession.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<TraceMetric> parser = PARSER;
                if (parser == null) {
                    synchronized (TraceMetric.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        TraceMetric traceMetric = new TraceMetric();
        DEFAULT_INSTANCE = traceMetric;
        GeneratedMessageLite.registerDefaultInstance(TraceMetric.class, traceMetric);
    }

    public static TraceMetric getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<TraceMetric> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
