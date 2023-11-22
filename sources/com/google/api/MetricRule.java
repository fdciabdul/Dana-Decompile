package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes7.dex */
public final class MetricRule extends GeneratedMessageLite<MetricRule, Builder> implements MetricRuleOrBuilder {
    private static final MetricRule DEFAULT_INSTANCE;
    public static final int METRIC_COSTS_FIELD_NUMBER = 2;
    private static volatile Parser<MetricRule> PARSER = null;
    public static final int SELECTOR_FIELD_NUMBER = 1;
    private MapFieldLite<String, Long> metricCosts_ = MapFieldLite.emptyMapField();
    private String selector_ = "";

    private MetricRule() {
    }

    @Override // com.google.api.MetricRuleOrBuilder
    public final String getSelector() {
        return this.selector_;
    }

    @Override // com.google.api.MetricRuleOrBuilder
    public final ByteString getSelectorBytes() {
        return ByteString.copyFromUtf8(this.selector_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelector(String str) {
        this.selector_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSelector() {
        this.selector_ = getDefaultInstance().getSelector();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSelectorBytes(ByteString byteString) {
        checkByteStringIsUtf8(byteString);
        this.selector_ = byteString.toStringUtf8();
    }

    /* loaded from: classes7.dex */
    static final class MetricCostsDefaultEntryHolder {
        static final MapEntryLite<String, Long> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.INT64, 0L);

        private MetricCostsDefaultEntryHolder() {
        }
    }

    private MapFieldLite<String, Long> internalGetMetricCosts() {
        return this.metricCosts_;
    }

    private MapFieldLite<String, Long> internalGetMutableMetricCosts() {
        if (!this.metricCosts_.isMutable()) {
            this.metricCosts_ = this.metricCosts_.mutableCopy();
        }
        return this.metricCosts_;
    }

    @Override // com.google.api.MetricRuleOrBuilder
    public final int getMetricCostsCount() {
        return internalGetMetricCosts().size();
    }

    @Override // com.google.api.MetricRuleOrBuilder
    public final boolean containsMetricCosts(String str) {
        return internalGetMetricCosts().containsKey(str);
    }

    @Override // com.google.api.MetricRuleOrBuilder
    @Deprecated
    public final Map<String, Long> getMetricCosts() {
        return getMetricCostsMap();
    }

    @Override // com.google.api.MetricRuleOrBuilder
    public final Map<String, Long> getMetricCostsMap() {
        return Collections.unmodifiableMap(internalGetMetricCosts());
    }

    @Override // com.google.api.MetricRuleOrBuilder
    public final long getMetricCostsOrDefault(String str, long j) {
        MapFieldLite<String, Long> internalGetMetricCosts = internalGetMetricCosts();
        return internalGetMetricCosts.containsKey(str) ? internalGetMetricCosts.get(str).longValue() : j;
    }

    @Override // com.google.api.MetricRuleOrBuilder
    public final long getMetricCostsOrThrow(String str) {
        MapFieldLite<String, Long> internalGetMetricCosts = internalGetMetricCosts();
        if (!internalGetMetricCosts.containsKey(str)) {
            throw new IllegalArgumentException();
        }
        return internalGetMetricCosts.get(str).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Long> getMutableMetricCostsMap() {
        return internalGetMutableMetricCosts();
    }

    public static MetricRule parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (MetricRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static MetricRule parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MetricRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MetricRule parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (MetricRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MetricRule parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MetricRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MetricRule parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (MetricRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MetricRule parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MetricRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MetricRule parseFrom(InputStream inputStream) throws IOException {
        return (MetricRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MetricRule parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MetricRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MetricRule parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (MetricRule) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MetricRule parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MetricRule) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MetricRule parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (MetricRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MetricRule parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MetricRule) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(MetricRule metricRule) {
        return DEFAULT_INSTANCE.createBuilder(metricRule);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<MetricRule, Builder> implements MetricRuleOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(MetricRule.DEFAULT_INSTANCE);
        }

        @Override // com.google.api.MetricRuleOrBuilder
        public final String getSelector() {
            return ((MetricRule) this.instance).getSelector();
        }

        @Override // com.google.api.MetricRuleOrBuilder
        public final ByteString getSelectorBytes() {
            return ((MetricRule) this.instance).getSelectorBytes();
        }

        public final Builder setSelector(String str) {
            copyOnWrite();
            ((MetricRule) this.instance).setSelector(str);
            return this;
        }

        public final Builder clearSelector() {
            copyOnWrite();
            ((MetricRule) this.instance).clearSelector();
            return this;
        }

        public final Builder setSelectorBytes(ByteString byteString) {
            copyOnWrite();
            ((MetricRule) this.instance).setSelectorBytes(byteString);
            return this;
        }

        @Override // com.google.api.MetricRuleOrBuilder
        public final int getMetricCostsCount() {
            return ((MetricRule) this.instance).getMetricCostsMap().size();
        }

        @Override // com.google.api.MetricRuleOrBuilder
        public final boolean containsMetricCosts(String str) {
            return ((MetricRule) this.instance).getMetricCostsMap().containsKey(str);
        }

        public final Builder clearMetricCosts() {
            copyOnWrite();
            ((MetricRule) this.instance).getMutableMetricCostsMap().clear();
            return this;
        }

        public final Builder removeMetricCosts(String str) {
            copyOnWrite();
            ((MetricRule) this.instance).getMutableMetricCostsMap().remove(str);
            return this;
        }

        @Override // com.google.api.MetricRuleOrBuilder
        @Deprecated
        public final Map<String, Long> getMetricCosts() {
            return getMetricCostsMap();
        }

        @Override // com.google.api.MetricRuleOrBuilder
        public final Map<String, Long> getMetricCostsMap() {
            return Collections.unmodifiableMap(((MetricRule) this.instance).getMetricCostsMap());
        }

        @Override // com.google.api.MetricRuleOrBuilder
        public final long getMetricCostsOrDefault(String str, long j) {
            Map<String, Long> metricCostsMap = ((MetricRule) this.instance).getMetricCostsMap();
            return metricCostsMap.containsKey(str) ? metricCostsMap.get(str).longValue() : j;
        }

        @Override // com.google.api.MetricRuleOrBuilder
        public final long getMetricCostsOrThrow(String str) {
            Map<String, Long> metricCostsMap = ((MetricRule) this.instance).getMetricCostsMap();
            if (!metricCostsMap.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return metricCostsMap.get(str).longValue();
        }

        public final Builder putMetricCosts(String str, long j) {
            copyOnWrite();
            ((MetricRule) this.instance).getMutableMetricCostsMap().put(str, Long.valueOf(j));
            return this;
        }

        public final Builder putAllMetricCosts(Map<String, Long> map) {
            copyOnWrite();
            ((MetricRule) this.instance).getMutableMetricCostsMap().putAll(map);
            return this;
        }
    }

    /* renamed from: com.google.api.MetricRule$1  reason: invalid class name */
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
                return new MetricRule();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0001\u0000\u0000\u0001Ȉ\u00022", new Object[]{"selector_", "metricCosts_", MetricCostsDefaultEntryHolder.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MetricRule> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (MetricRule.class) {
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
        MetricRule metricRule = new MetricRule();
        DEFAULT_INSTANCE = metricRule;
        GeneratedMessageLite.registerDefaultInstance(MetricRule.class, metricRule);
    }

    public static MetricRule getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<MetricRule> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
