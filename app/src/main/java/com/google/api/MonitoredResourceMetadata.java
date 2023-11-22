package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import com.google.protobuf.Struct;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes7.dex */
public final class MonitoredResourceMetadata extends GeneratedMessageLite<MonitoredResourceMetadata, Builder> implements MonitoredResourceMetadataOrBuilder {
    private static final MonitoredResourceMetadata DEFAULT_INSTANCE;
    private static volatile Parser<MonitoredResourceMetadata> PARSER = null;
    public static final int SYSTEM_LABELS_FIELD_NUMBER = 1;
    public static final int USER_LABELS_FIELD_NUMBER = 2;
    private Struct systemLabels_;
    private MapFieldLite<String, String> userLabels_ = MapFieldLite.emptyMapField();

    private MonitoredResourceMetadata() {
    }

    @Override // com.google.api.MonitoredResourceMetadataOrBuilder
    public final boolean hasSystemLabels() {
        return this.systemLabels_ != null;
    }

    @Override // com.google.api.MonitoredResourceMetadataOrBuilder
    public final Struct getSystemLabels() {
        Struct struct = this.systemLabels_;
        return struct == null ? Struct.getDefaultInstance() : struct;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSystemLabels(Struct struct) {
        this.systemLabels_ = struct;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSystemLabels(Struct struct) {
        Struct struct2 = this.systemLabels_;
        if (struct2 != null && struct2 != Struct.getDefaultInstance()) {
            this.systemLabels_ = Struct.newBuilder(this.systemLabels_).mergeFrom((Struct.Builder) struct).buildPartial();
        } else {
            this.systemLabels_ = struct;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSystemLabels() {
        this.systemLabels_ = null;
    }

    /* loaded from: classes7.dex */
    static final class UserLabelsDefaultEntryHolder {
        static final MapEntryLite<String, String> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.STRING, "");

        private UserLabelsDefaultEntryHolder() {
        }
    }

    private MapFieldLite<String, String> internalGetUserLabels() {
        return this.userLabels_;
    }

    private MapFieldLite<String, String> internalGetMutableUserLabels() {
        if (!this.userLabels_.isMutable()) {
            this.userLabels_ = this.userLabels_.mutableCopy();
        }
        return this.userLabels_;
    }

    @Override // com.google.api.MonitoredResourceMetadataOrBuilder
    public final int getUserLabelsCount() {
        return internalGetUserLabels().size();
    }

    @Override // com.google.api.MonitoredResourceMetadataOrBuilder
    public final boolean containsUserLabels(String str) {
        return internalGetUserLabels().containsKey(str);
    }

    @Override // com.google.api.MonitoredResourceMetadataOrBuilder
    @Deprecated
    public final Map<String, String> getUserLabels() {
        return getUserLabelsMap();
    }

    @Override // com.google.api.MonitoredResourceMetadataOrBuilder
    public final Map<String, String> getUserLabelsMap() {
        return Collections.unmodifiableMap(internalGetUserLabels());
    }

    @Override // com.google.api.MonitoredResourceMetadataOrBuilder
    public final String getUserLabelsOrDefault(String str, String str2) {
        MapFieldLite<String, String> internalGetUserLabels = internalGetUserLabels();
        return internalGetUserLabels.containsKey(str) ? internalGetUserLabels.get(str) : str2;
    }

    @Override // com.google.api.MonitoredResourceMetadataOrBuilder
    public final String getUserLabelsOrThrow(String str) {
        MapFieldLite<String, String> internalGetUserLabels = internalGetUserLabels();
        if (!internalGetUserLabels.containsKey(str)) {
            throw new IllegalArgumentException();
        }
        return internalGetUserLabels.get(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getMutableUserLabelsMap() {
        return internalGetMutableUserLabels();
    }

    public static MonitoredResourceMetadata parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (MonitoredResourceMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static MonitoredResourceMetadata parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MonitoredResourceMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static MonitoredResourceMetadata parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (MonitoredResourceMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static MonitoredResourceMetadata parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MonitoredResourceMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static MonitoredResourceMetadata parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (MonitoredResourceMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static MonitoredResourceMetadata parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (MonitoredResourceMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static MonitoredResourceMetadata parseFrom(InputStream inputStream) throws IOException {
        return (MonitoredResourceMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MonitoredResourceMetadata parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MonitoredResourceMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MonitoredResourceMetadata parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (MonitoredResourceMetadata) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static MonitoredResourceMetadata parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MonitoredResourceMetadata) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static MonitoredResourceMetadata parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (MonitoredResourceMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static MonitoredResourceMetadata parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (MonitoredResourceMetadata) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(MonitoredResourceMetadata monitoredResourceMetadata) {
        return DEFAULT_INSTANCE.createBuilder(monitoredResourceMetadata);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<MonitoredResourceMetadata, Builder> implements MonitoredResourceMetadataOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(MonitoredResourceMetadata.DEFAULT_INSTANCE);
        }

        @Override // com.google.api.MonitoredResourceMetadataOrBuilder
        public final boolean hasSystemLabels() {
            return ((MonitoredResourceMetadata) this.instance).hasSystemLabels();
        }

        @Override // com.google.api.MonitoredResourceMetadataOrBuilder
        public final Struct getSystemLabels() {
            return ((MonitoredResourceMetadata) this.instance).getSystemLabels();
        }

        public final Builder setSystemLabels(Struct struct) {
            copyOnWrite();
            ((MonitoredResourceMetadata) this.instance).setSystemLabels(struct);
            return this;
        }

        public final Builder setSystemLabels(Struct.Builder builder) {
            copyOnWrite();
            ((MonitoredResourceMetadata) this.instance).setSystemLabels(builder.build());
            return this;
        }

        public final Builder mergeSystemLabels(Struct struct) {
            copyOnWrite();
            ((MonitoredResourceMetadata) this.instance).mergeSystemLabels(struct);
            return this;
        }

        public final Builder clearSystemLabels() {
            copyOnWrite();
            ((MonitoredResourceMetadata) this.instance).clearSystemLabels();
            return this;
        }

        @Override // com.google.api.MonitoredResourceMetadataOrBuilder
        public final int getUserLabelsCount() {
            return ((MonitoredResourceMetadata) this.instance).getUserLabelsMap().size();
        }

        @Override // com.google.api.MonitoredResourceMetadataOrBuilder
        public final boolean containsUserLabels(String str) {
            return ((MonitoredResourceMetadata) this.instance).getUserLabelsMap().containsKey(str);
        }

        public final Builder clearUserLabels() {
            copyOnWrite();
            ((MonitoredResourceMetadata) this.instance).getMutableUserLabelsMap().clear();
            return this;
        }

        public final Builder removeUserLabels(String str) {
            copyOnWrite();
            ((MonitoredResourceMetadata) this.instance).getMutableUserLabelsMap().remove(str);
            return this;
        }

        @Override // com.google.api.MonitoredResourceMetadataOrBuilder
        @Deprecated
        public final Map<String, String> getUserLabels() {
            return getUserLabelsMap();
        }

        @Override // com.google.api.MonitoredResourceMetadataOrBuilder
        public final Map<String, String> getUserLabelsMap() {
            return Collections.unmodifiableMap(((MonitoredResourceMetadata) this.instance).getUserLabelsMap());
        }

        @Override // com.google.api.MonitoredResourceMetadataOrBuilder
        public final String getUserLabelsOrDefault(String str, String str2) {
            Map<String, String> userLabelsMap = ((MonitoredResourceMetadata) this.instance).getUserLabelsMap();
            return userLabelsMap.containsKey(str) ? userLabelsMap.get(str) : str2;
        }

        @Override // com.google.api.MonitoredResourceMetadataOrBuilder
        public final String getUserLabelsOrThrow(String str) {
            Map<String, String> userLabelsMap = ((MonitoredResourceMetadata) this.instance).getUserLabelsMap();
            if (!userLabelsMap.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return userLabelsMap.get(str);
        }

        public final Builder putUserLabels(String str, String str2) {
            copyOnWrite();
            ((MonitoredResourceMetadata) this.instance).getMutableUserLabelsMap().put(str, str2);
            return this;
        }

        public final Builder putAllUserLabels(Map<String, String> map) {
            copyOnWrite();
            ((MonitoredResourceMetadata) this.instance).getMutableUserLabelsMap().putAll(map);
            return this;
        }
    }

    /* renamed from: com.google.api.MonitoredResourceMetadata$1  reason: invalid class name */
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
                return new MonitoredResourceMetadata();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0001\u0000\u0000\u0001\t\u00022", new Object[]{"systemLabels_", "userLabels_", UserLabelsDefaultEntryHolder.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<MonitoredResourceMetadata> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (MonitoredResourceMetadata.class) {
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
        MonitoredResourceMetadata monitoredResourceMetadata = new MonitoredResourceMetadata();
        DEFAULT_INSTANCE = monitoredResourceMetadata;
        GeneratedMessageLite.registerDefaultInstance(MonitoredResourceMetadata.class, monitoredResourceMetadata);
    }

    public static MonitoredResourceMetadata getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<MonitoredResourceMetadata> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
