package com.google.api;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
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
public final class Monitoring extends GeneratedMessageLite<Monitoring, Builder> implements MonitoringOrBuilder {
    public static final int CONSUMER_DESTINATIONS_FIELD_NUMBER = 2;
    private static final Monitoring DEFAULT_INSTANCE;
    private static volatile Parser<Monitoring> PARSER = null;
    public static final int PRODUCER_DESTINATIONS_FIELD_NUMBER = 1;
    private Internal.ProtobufList<MonitoringDestination> producerDestinations_ = emptyProtobufList();
    private Internal.ProtobufList<MonitoringDestination> consumerDestinations_ = emptyProtobufList();

    /* loaded from: classes7.dex */
    public interface MonitoringDestinationOrBuilder extends MessageLiteOrBuilder {
        String getMetrics(int i);

        ByteString getMetricsBytes(int i);

        int getMetricsCount();

        List<String> getMetricsList();

        String getMonitoredResource();

        ByteString getMonitoredResourceBytes();
    }

    private Monitoring() {
    }

    /* loaded from: classes7.dex */
    public static final class MonitoringDestination extends GeneratedMessageLite<MonitoringDestination, Builder> implements MonitoringDestinationOrBuilder {
        private static final MonitoringDestination DEFAULT_INSTANCE;
        public static final int METRICS_FIELD_NUMBER = 2;
        public static final int MONITORED_RESOURCE_FIELD_NUMBER = 1;
        private static volatile Parser<MonitoringDestination> PARSER;
        private String monitoredResource_ = "";
        private Internal.ProtobufList<String> metrics_ = GeneratedMessageLite.emptyProtobufList();

        private MonitoringDestination() {
        }

        @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
        public final String getMonitoredResource() {
            return this.monitoredResource_;
        }

        @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
        public final ByteString getMonitoredResourceBytes() {
            return ByteString.copyFromUtf8(this.monitoredResource_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMonitoredResource(String str) {
            this.monitoredResource_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMonitoredResource() {
            this.monitoredResource_ = getDefaultInstance().getMonitoredResource();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMonitoredResourceBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.monitoredResource_ = byteString.toStringUtf8();
        }

        @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
        public final List<String> getMetricsList() {
            return this.metrics_;
        }

        @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
        public final int getMetricsCount() {
            return this.metrics_.size();
        }

        @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
        public final String getMetrics(int i) {
            return this.metrics_.get(i);
        }

        @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
        public final ByteString getMetricsBytes(int i) {
            return ByteString.copyFromUtf8(this.metrics_.get(i));
        }

        private void ensureMetricsIsMutable() {
            Internal.ProtobufList<String> protobufList = this.metrics_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.metrics_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMetrics(int i, String str) {
            ensureMetricsIsMutable();
            this.metrics_.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addMetrics(String str) {
            ensureMetricsIsMutable();
            this.metrics_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllMetrics(Iterable<String> iterable) {
            ensureMetricsIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.metrics_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMetrics() {
            this.metrics_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addMetricsBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            ensureMetricsIsMutable();
            this.metrics_.add(byteString.toStringUtf8());
        }

        public static MonitoringDestination parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (MonitoringDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static MonitoringDestination parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MonitoringDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static MonitoringDestination parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (MonitoringDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static MonitoringDestination parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MonitoringDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static MonitoringDestination parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (MonitoringDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static MonitoringDestination parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (MonitoringDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static MonitoringDestination parseFrom(InputStream inputStream) throws IOException {
            return (MonitoringDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MonitoringDestination parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MonitoringDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MonitoringDestination parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (MonitoringDestination) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static MonitoringDestination parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MonitoringDestination) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static MonitoringDestination parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (MonitoringDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static MonitoringDestination parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (MonitoringDestination) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(MonitoringDestination monitoringDestination) {
            return DEFAULT_INSTANCE.createBuilder(monitoringDestination);
        }

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<MonitoringDestination, Builder> implements MonitoringDestinationOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(MonitoringDestination.DEFAULT_INSTANCE);
            }

            @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
            public final String getMonitoredResource() {
                return ((MonitoringDestination) this.instance).getMonitoredResource();
            }

            @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
            public final ByteString getMonitoredResourceBytes() {
                return ((MonitoringDestination) this.instance).getMonitoredResourceBytes();
            }

            public final Builder setMonitoredResource(String str) {
                copyOnWrite();
                ((MonitoringDestination) this.instance).setMonitoredResource(str);
                return this;
            }

            public final Builder clearMonitoredResource() {
                copyOnWrite();
                ((MonitoringDestination) this.instance).clearMonitoredResource();
                return this;
            }

            public final Builder setMonitoredResourceBytes(ByteString byteString) {
                copyOnWrite();
                ((MonitoringDestination) this.instance).setMonitoredResourceBytes(byteString);
                return this;
            }

            @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
            public final List<String> getMetricsList() {
                return Collections.unmodifiableList(((MonitoringDestination) this.instance).getMetricsList());
            }

            @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
            public final int getMetricsCount() {
                return ((MonitoringDestination) this.instance).getMetricsCount();
            }

            @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
            public final String getMetrics(int i) {
                return ((MonitoringDestination) this.instance).getMetrics(i);
            }

            @Override // com.google.api.Monitoring.MonitoringDestinationOrBuilder
            public final ByteString getMetricsBytes(int i) {
                return ((MonitoringDestination) this.instance).getMetricsBytes(i);
            }

            public final Builder setMetrics(int i, String str) {
                copyOnWrite();
                ((MonitoringDestination) this.instance).setMetrics(i, str);
                return this;
            }

            public final Builder addMetrics(String str) {
                copyOnWrite();
                ((MonitoringDestination) this.instance).addMetrics(str);
                return this;
            }

            public final Builder addAllMetrics(Iterable<String> iterable) {
                copyOnWrite();
                ((MonitoringDestination) this.instance).addAllMetrics(iterable);
                return this;
            }

            public final Builder clearMetrics() {
                copyOnWrite();
                ((MonitoringDestination) this.instance).clearMetrics();
                return this;
            }

            public final Builder addMetricsBytes(ByteString byteString) {
                copyOnWrite();
                ((MonitoringDestination) this.instance).addMetricsBytes(byteString);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new MonitoringDestination();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002Ț", new Object[]{"monitoredResource_", "metrics_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<MonitoringDestination> parser2 = PARSER;
                    if (parser2 == null) {
                        synchronized (MonitoringDestination.class) {
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
            MonitoringDestination monitoringDestination = new MonitoringDestination();
            DEFAULT_INSTANCE = monitoringDestination;
            GeneratedMessageLite.registerDefaultInstance(MonitoringDestination.class, monitoringDestination);
        }

        public static MonitoringDestination getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MonitoringDestination> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: com.google.api.Monitoring$1  reason: invalid class name */
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

    @Override // com.google.api.MonitoringOrBuilder
    public final List<MonitoringDestination> getProducerDestinationsList() {
        return this.producerDestinations_;
    }

    public final List<? extends MonitoringDestinationOrBuilder> getProducerDestinationsOrBuilderList() {
        return this.producerDestinations_;
    }

    @Override // com.google.api.MonitoringOrBuilder
    public final int getProducerDestinationsCount() {
        return this.producerDestinations_.size();
    }

    @Override // com.google.api.MonitoringOrBuilder
    public final MonitoringDestination getProducerDestinations(int i) {
        return this.producerDestinations_.get(i);
    }

    public final MonitoringDestinationOrBuilder getProducerDestinationsOrBuilder(int i) {
        return this.producerDestinations_.get(i);
    }

    private void ensureProducerDestinationsIsMutable() {
        Internal.ProtobufList<MonitoringDestination> protobufList = this.producerDestinations_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.producerDestinations_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProducerDestinations(int i, MonitoringDestination monitoringDestination) {
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.set(i, monitoringDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addProducerDestinations(MonitoringDestination monitoringDestination) {
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.add(monitoringDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addProducerDestinations(int i, MonitoringDestination monitoringDestination) {
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.add(i, monitoringDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllProducerDestinations(Iterable<? extends MonitoringDestination> iterable) {
        ensureProducerDestinationsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.producerDestinations_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearProducerDestinations() {
        this.producerDestinations_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeProducerDestinations(int i) {
        ensureProducerDestinationsIsMutable();
        this.producerDestinations_.remove(i);
    }

    @Override // com.google.api.MonitoringOrBuilder
    public final List<MonitoringDestination> getConsumerDestinationsList() {
        return this.consumerDestinations_;
    }

    public final List<? extends MonitoringDestinationOrBuilder> getConsumerDestinationsOrBuilderList() {
        return this.consumerDestinations_;
    }

    @Override // com.google.api.MonitoringOrBuilder
    public final int getConsumerDestinationsCount() {
        return this.consumerDestinations_.size();
    }

    @Override // com.google.api.MonitoringOrBuilder
    public final MonitoringDestination getConsumerDestinations(int i) {
        return this.consumerDestinations_.get(i);
    }

    public final MonitoringDestinationOrBuilder getConsumerDestinationsOrBuilder(int i) {
        return this.consumerDestinations_.get(i);
    }

    private void ensureConsumerDestinationsIsMutable() {
        Internal.ProtobufList<MonitoringDestination> protobufList = this.consumerDestinations_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.consumerDestinations_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setConsumerDestinations(int i, MonitoringDestination monitoringDestination) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.set(i, monitoringDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addConsumerDestinations(MonitoringDestination monitoringDestination) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.add(monitoringDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addConsumerDestinations(int i, MonitoringDestination monitoringDestination) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.add(i, monitoringDestination);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllConsumerDestinations(Iterable<? extends MonitoringDestination> iterable) {
        ensureConsumerDestinationsIsMutable();
        AbstractMessageLite.addAll((Iterable) iterable, (List) this.consumerDestinations_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearConsumerDestinations() {
        this.consumerDestinations_ = emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeConsumerDestinations(int i) {
        ensureConsumerDestinationsIsMutable();
        this.consumerDestinations_.remove(i);
    }

    public static Monitoring parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Monitoring) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Monitoring parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Monitoring) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Monitoring parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Monitoring) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Monitoring parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Monitoring) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Monitoring parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Monitoring) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Monitoring parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Monitoring) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Monitoring parseFrom(InputStream inputStream) throws IOException {
        return (Monitoring) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Monitoring parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Monitoring) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Monitoring parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Monitoring) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Monitoring parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Monitoring) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Monitoring parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Monitoring) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Monitoring parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Monitoring) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(Monitoring monitoring) {
        return DEFAULT_INSTANCE.createBuilder(monitoring);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Monitoring, Builder> implements MonitoringOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(Monitoring.DEFAULT_INSTANCE);
        }

        @Override // com.google.api.MonitoringOrBuilder
        public final List<MonitoringDestination> getProducerDestinationsList() {
            return Collections.unmodifiableList(((Monitoring) this.instance).getProducerDestinationsList());
        }

        @Override // com.google.api.MonitoringOrBuilder
        public final int getProducerDestinationsCount() {
            return ((Monitoring) this.instance).getProducerDestinationsCount();
        }

        @Override // com.google.api.MonitoringOrBuilder
        public final MonitoringDestination getProducerDestinations(int i) {
            return ((Monitoring) this.instance).getProducerDestinations(i);
        }

        public final Builder setProducerDestinations(int i, MonitoringDestination monitoringDestination) {
            copyOnWrite();
            ((Monitoring) this.instance).setProducerDestinations(i, monitoringDestination);
            return this;
        }

        public final Builder setProducerDestinations(int i, MonitoringDestination.Builder builder) {
            copyOnWrite();
            ((Monitoring) this.instance).setProducerDestinations(i, builder.build());
            return this;
        }

        public final Builder addProducerDestinations(MonitoringDestination monitoringDestination) {
            copyOnWrite();
            ((Monitoring) this.instance).addProducerDestinations(monitoringDestination);
            return this;
        }

        public final Builder addProducerDestinations(int i, MonitoringDestination monitoringDestination) {
            copyOnWrite();
            ((Monitoring) this.instance).addProducerDestinations(i, monitoringDestination);
            return this;
        }

        public final Builder addProducerDestinations(MonitoringDestination.Builder builder) {
            copyOnWrite();
            ((Monitoring) this.instance).addProducerDestinations(builder.build());
            return this;
        }

        public final Builder addProducerDestinations(int i, MonitoringDestination.Builder builder) {
            copyOnWrite();
            ((Monitoring) this.instance).addProducerDestinations(i, builder.build());
            return this;
        }

        public final Builder addAllProducerDestinations(Iterable<? extends MonitoringDestination> iterable) {
            copyOnWrite();
            ((Monitoring) this.instance).addAllProducerDestinations(iterable);
            return this;
        }

        public final Builder clearProducerDestinations() {
            copyOnWrite();
            ((Monitoring) this.instance).clearProducerDestinations();
            return this;
        }

        public final Builder removeProducerDestinations(int i) {
            copyOnWrite();
            ((Monitoring) this.instance).removeProducerDestinations(i);
            return this;
        }

        @Override // com.google.api.MonitoringOrBuilder
        public final List<MonitoringDestination> getConsumerDestinationsList() {
            return Collections.unmodifiableList(((Monitoring) this.instance).getConsumerDestinationsList());
        }

        @Override // com.google.api.MonitoringOrBuilder
        public final int getConsumerDestinationsCount() {
            return ((Monitoring) this.instance).getConsumerDestinationsCount();
        }

        @Override // com.google.api.MonitoringOrBuilder
        public final MonitoringDestination getConsumerDestinations(int i) {
            return ((Monitoring) this.instance).getConsumerDestinations(i);
        }

        public final Builder setConsumerDestinations(int i, MonitoringDestination monitoringDestination) {
            copyOnWrite();
            ((Monitoring) this.instance).setConsumerDestinations(i, monitoringDestination);
            return this;
        }

        public final Builder setConsumerDestinations(int i, MonitoringDestination.Builder builder) {
            copyOnWrite();
            ((Monitoring) this.instance).setConsumerDestinations(i, builder.build());
            return this;
        }

        public final Builder addConsumerDestinations(MonitoringDestination monitoringDestination) {
            copyOnWrite();
            ((Monitoring) this.instance).addConsumerDestinations(monitoringDestination);
            return this;
        }

        public final Builder addConsumerDestinations(int i, MonitoringDestination monitoringDestination) {
            copyOnWrite();
            ((Monitoring) this.instance).addConsumerDestinations(i, monitoringDestination);
            return this;
        }

        public final Builder addConsumerDestinations(MonitoringDestination.Builder builder) {
            copyOnWrite();
            ((Monitoring) this.instance).addConsumerDestinations(builder.build());
            return this;
        }

        public final Builder addConsumerDestinations(int i, MonitoringDestination.Builder builder) {
            copyOnWrite();
            ((Monitoring) this.instance).addConsumerDestinations(i, builder.build());
            return this;
        }

        public final Builder addAllConsumerDestinations(Iterable<? extends MonitoringDestination> iterable) {
            copyOnWrite();
            ((Monitoring) this.instance).addAllConsumerDestinations(iterable);
            return this;
        }

        public final Builder clearConsumerDestinations() {
            copyOnWrite();
            ((Monitoring) this.instance).clearConsumerDestinations();
            return this;
        }

        public final Builder removeConsumerDestinations(int i) {
            copyOnWrite();
            ((Monitoring) this.instance).removeConsumerDestinations(i);
            return this;
        }
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser parser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Monitoring();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002\u001b", new Object[]{"producerDestinations_", MonitoringDestination.class, "consumerDestinations_", MonitoringDestination.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Monitoring> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (Monitoring.class) {
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
        Monitoring monitoring = new Monitoring();
        DEFAULT_INSTANCE = monitoring;
        GeneratedMessageLite.registerDefaultInstance(Monitoring.class, monitoring);
    }

    public static Monitoring getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<Monitoring> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
