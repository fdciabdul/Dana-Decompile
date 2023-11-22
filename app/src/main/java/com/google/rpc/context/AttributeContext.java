package com.google.rpc.context;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.Struct;
import com.google.protobuf.Timestamp;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public final class AttributeContext extends GeneratedMessageLite<AttributeContext, Builder> implements AttributeContextOrBuilder {
    public static final int API_FIELD_NUMBER = 6;
    private static final AttributeContext DEFAULT_INSTANCE;
    public static final int DESTINATION_FIELD_NUMBER = 2;
    public static final int ORIGIN_FIELD_NUMBER = 7;
    private static volatile Parser<AttributeContext> PARSER = null;
    public static final int REQUEST_FIELD_NUMBER = 3;
    public static final int RESOURCE_FIELD_NUMBER = 5;
    public static final int RESPONSE_FIELD_NUMBER = 4;
    public static final int SOURCE_FIELD_NUMBER = 1;
    private Api api_;
    private Peer destination_;
    private Peer origin_;
    private Request request_;
    private Resource resource_;
    private Response response_;
    private Peer source_;

    /* loaded from: classes7.dex */
    public interface ApiOrBuilder extends MessageLiteOrBuilder {
        String getOperation();

        ByteString getOperationBytes();

        String getProtocol();

        ByteString getProtocolBytes();

        String getService();

        ByteString getServiceBytes();

        String getVersion();

        ByteString getVersionBytes();
    }

    /* loaded from: classes7.dex */
    public interface AuthOrBuilder extends MessageLiteOrBuilder {
        String getAccessLevels(int i);

        ByteString getAccessLevelsBytes(int i);

        int getAccessLevelsCount();

        List<String> getAccessLevelsList();

        String getAudiences(int i);

        ByteString getAudiencesBytes(int i);

        int getAudiencesCount();

        List<String> getAudiencesList();

        Struct getClaims();

        String getPresenter();

        ByteString getPresenterBytes();

        String getPrincipal();

        ByteString getPrincipalBytes();

        boolean hasClaims();
    }

    /* loaded from: classes7.dex */
    public interface PeerOrBuilder extends MessageLiteOrBuilder {
        boolean containsLabels(String str);

        String getIp();

        ByteString getIpBytes();

        @Deprecated
        Map<String, String> getLabels();

        int getLabelsCount();

        Map<String, String> getLabelsMap();

        String getLabelsOrDefault(String str, String str2);

        String getLabelsOrThrow(String str);

        long getPort();

        String getPrincipal();

        ByteString getPrincipalBytes();

        String getRegionCode();

        ByteString getRegionCodeBytes();
    }

    /* loaded from: classes7.dex */
    public interface RequestOrBuilder extends MessageLiteOrBuilder {
        boolean containsHeaders(String str);

        Auth getAuth();

        @Deprecated
        Map<String, String> getHeaders();

        int getHeadersCount();

        Map<String, String> getHeadersMap();

        String getHeadersOrDefault(String str, String str2);

        String getHeadersOrThrow(String str);

        String getHost();

        ByteString getHostBytes();

        String getId();

        ByteString getIdBytes();

        String getMethod();

        ByteString getMethodBytes();

        String getPath();

        ByteString getPathBytes();

        String getProtocol();

        ByteString getProtocolBytes();

        String getQuery();

        ByteString getQueryBytes();

        String getReason();

        ByteString getReasonBytes();

        String getScheme();

        ByteString getSchemeBytes();

        long getSize();

        Timestamp getTime();

        boolean hasAuth();

        boolean hasTime();
    }

    /* loaded from: classes7.dex */
    public interface ResourceOrBuilder extends MessageLiteOrBuilder {
        boolean containsLabels(String str);

        @Deprecated
        Map<String, String> getLabels();

        int getLabelsCount();

        Map<String, String> getLabelsMap();

        String getLabelsOrDefault(String str, String str2);

        String getLabelsOrThrow(String str);

        String getName();

        ByteString getNameBytes();

        String getService();

        ByteString getServiceBytes();

        String getType();

        ByteString getTypeBytes();
    }

    /* loaded from: classes7.dex */
    public interface ResponseOrBuilder extends MessageLiteOrBuilder {
        boolean containsHeaders(String str);

        long getCode();

        @Deprecated
        Map<String, String> getHeaders();

        int getHeadersCount();

        Map<String, String> getHeadersMap();

        String getHeadersOrDefault(String str, String str2);

        String getHeadersOrThrow(String str);

        long getSize();

        Timestamp getTime();

        boolean hasTime();
    }

    private AttributeContext() {
    }

    /* loaded from: classes7.dex */
    public static final class Peer extends GeneratedMessageLite<Peer, Builder> implements PeerOrBuilder {
        private static final Peer DEFAULT_INSTANCE;
        public static final int IP_FIELD_NUMBER = 1;
        public static final int LABELS_FIELD_NUMBER = 6;
        private static volatile Parser<Peer> PARSER = null;
        public static final int PORT_FIELD_NUMBER = 2;
        public static final int PRINCIPAL_FIELD_NUMBER = 7;
        public static final int REGION_CODE_FIELD_NUMBER = 8;
        private long port_;
        private MapFieldLite<String, String> labels_ = MapFieldLite.emptyMapField();
        private String ip_ = "";
        private String principal_ = "";
        private String regionCode_ = "";

        private Peer() {
        }

        @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
        public final String getIp() {
            return this.ip_;
        }

        @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
        public final ByteString getIpBytes() {
            return ByteString.copyFromUtf8(this.ip_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIp(String str) {
            this.ip_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIp() {
            this.ip_ = getDefaultInstance().getIp();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIpBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.ip_ = byteString.toStringUtf8();
        }

        @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
        public final long getPort() {
            return this.port_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPort(long j) {
            this.port_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPort() {
            this.port_ = 0L;
        }

        /* loaded from: classes7.dex */
        static final class LabelsDefaultEntryHolder {
            static final MapEntryLite<String, String> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.STRING, "");

            private LabelsDefaultEntryHolder() {
            }
        }

        private MapFieldLite<String, String> internalGetLabels() {
            return this.labels_;
        }

        private MapFieldLite<String, String> internalGetMutableLabels() {
            if (!this.labels_.isMutable()) {
                this.labels_ = this.labels_.mutableCopy();
            }
            return this.labels_;
        }

        @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
        public final int getLabelsCount() {
            return internalGetLabels().size();
        }

        @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
        public final boolean containsLabels(String str) {
            return internalGetLabels().containsKey(str);
        }

        @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
        @Deprecated
        public final Map<String, String> getLabels() {
            return getLabelsMap();
        }

        @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
        public final Map<String, String> getLabelsMap() {
            return Collections.unmodifiableMap(internalGetLabels());
        }

        @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
        public final String getLabelsOrDefault(String str, String str2) {
            MapFieldLite<String, String> internalGetLabels = internalGetLabels();
            return internalGetLabels.containsKey(str) ? internalGetLabels.get(str) : str2;
        }

        @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
        public final String getLabelsOrThrow(String str) {
            MapFieldLite<String, String> internalGetLabels = internalGetLabels();
            if (!internalGetLabels.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return internalGetLabels.get(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, String> getMutableLabelsMap() {
            return internalGetMutableLabels();
        }

        @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
        public final String getPrincipal() {
            return this.principal_;
        }

        @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
        public final ByteString getPrincipalBytes() {
            return ByteString.copyFromUtf8(this.principal_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPrincipal(String str) {
            this.principal_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPrincipal() {
            this.principal_ = getDefaultInstance().getPrincipal();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPrincipalBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.principal_ = byteString.toStringUtf8();
        }

        @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
        public final String getRegionCode() {
            return this.regionCode_;
        }

        @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
        public final ByteString getRegionCodeBytes() {
            return ByteString.copyFromUtf8(this.regionCode_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRegionCode(String str) {
            this.regionCode_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRegionCode() {
            this.regionCode_ = getDefaultInstance().getRegionCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRegionCodeBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.regionCode_ = byteString.toStringUtf8();
        }

        public static Peer parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Peer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Peer parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Peer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Peer parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Peer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Peer parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Peer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Peer parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Peer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Peer parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Peer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Peer parseFrom(InputStream inputStream) throws IOException {
            return (Peer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Peer parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Peer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Peer parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Peer) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Peer parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Peer) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Peer parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Peer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Peer parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Peer) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Peer peer) {
            return DEFAULT_INSTANCE.createBuilder(peer);
        }

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Peer, Builder> implements PeerOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(Peer.DEFAULT_INSTANCE);
            }

            @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
            public final String getIp() {
                return ((Peer) this.instance).getIp();
            }

            @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
            public final ByteString getIpBytes() {
                return ((Peer) this.instance).getIpBytes();
            }

            public final Builder setIp(String str) {
                copyOnWrite();
                ((Peer) this.instance).setIp(str);
                return this;
            }

            public final Builder clearIp() {
                copyOnWrite();
                ((Peer) this.instance).clearIp();
                return this;
            }

            public final Builder setIpBytes(ByteString byteString) {
                copyOnWrite();
                ((Peer) this.instance).setIpBytes(byteString);
                return this;
            }

            @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
            public final long getPort() {
                return ((Peer) this.instance).getPort();
            }

            public final Builder setPort(long j) {
                copyOnWrite();
                ((Peer) this.instance).setPort(j);
                return this;
            }

            public final Builder clearPort() {
                copyOnWrite();
                ((Peer) this.instance).clearPort();
                return this;
            }

            @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
            public final int getLabelsCount() {
                return ((Peer) this.instance).getLabelsMap().size();
            }

            @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
            public final boolean containsLabels(String str) {
                return ((Peer) this.instance).getLabelsMap().containsKey(str);
            }

            public final Builder clearLabels() {
                copyOnWrite();
                ((Peer) this.instance).getMutableLabelsMap().clear();
                return this;
            }

            public final Builder removeLabels(String str) {
                copyOnWrite();
                ((Peer) this.instance).getMutableLabelsMap().remove(str);
                return this;
            }

            @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
            @Deprecated
            public final Map<String, String> getLabels() {
                return getLabelsMap();
            }

            @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
            public final Map<String, String> getLabelsMap() {
                return Collections.unmodifiableMap(((Peer) this.instance).getLabelsMap());
            }

            @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
            public final String getLabelsOrDefault(String str, String str2) {
                Map<String, String> labelsMap = ((Peer) this.instance).getLabelsMap();
                return labelsMap.containsKey(str) ? labelsMap.get(str) : str2;
            }

            @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
            public final String getLabelsOrThrow(String str) {
                Map<String, String> labelsMap = ((Peer) this.instance).getLabelsMap();
                if (!labelsMap.containsKey(str)) {
                    throw new IllegalArgumentException();
                }
                return labelsMap.get(str);
            }

            public final Builder putLabels(String str, String str2) {
                copyOnWrite();
                ((Peer) this.instance).getMutableLabelsMap().put(str, str2);
                return this;
            }

            public final Builder putAllLabels(Map<String, String> map) {
                copyOnWrite();
                ((Peer) this.instance).getMutableLabelsMap().putAll(map);
                return this;
            }

            @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
            public final String getPrincipal() {
                return ((Peer) this.instance).getPrincipal();
            }

            @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
            public final ByteString getPrincipalBytes() {
                return ((Peer) this.instance).getPrincipalBytes();
            }

            public final Builder setPrincipal(String str) {
                copyOnWrite();
                ((Peer) this.instance).setPrincipal(str);
                return this;
            }

            public final Builder clearPrincipal() {
                copyOnWrite();
                ((Peer) this.instance).clearPrincipal();
                return this;
            }

            public final Builder setPrincipalBytes(ByteString byteString) {
                copyOnWrite();
                ((Peer) this.instance).setPrincipalBytes(byteString);
                return this;
            }

            @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
            public final String getRegionCode() {
                return ((Peer) this.instance).getRegionCode();
            }

            @Override // com.google.rpc.context.AttributeContext.PeerOrBuilder
            public final ByteString getRegionCodeBytes() {
                return ((Peer) this.instance).getRegionCodeBytes();
            }

            public final Builder setRegionCode(String str) {
                copyOnWrite();
                ((Peer) this.instance).setRegionCode(str);
                return this;
            }

            public final Builder clearRegionCode() {
                copyOnWrite();
                ((Peer) this.instance).clearRegionCode();
                return this;
            }

            public final Builder setRegionCodeBytes(ByteString byteString) {
                copyOnWrite();
                ((Peer) this.instance).setRegionCodeBytes(byteString);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Peer();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\b\u0005\u0001\u0000\u0000\u0001Ȉ\u0002\u0002\u00062\u0007Ȉ\bȈ", new Object[]{"ip_", "port_", "labels_", LabelsDefaultEntryHolder.defaultEntry, "principal_", "regionCode_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Peer> parser2 = PARSER;
                    if (parser2 == null) {
                        synchronized (Peer.class) {
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
            Peer peer = new Peer();
            DEFAULT_INSTANCE = peer;
            GeneratedMessageLite.registerDefaultInstance(Peer.class, peer);
        }

        public static Peer getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Peer> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: com.google.rpc.context.AttributeContext$1  reason: invalid class name */
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

    /* loaded from: classes7.dex */
    public static final class Api extends GeneratedMessageLite<Api, Builder> implements ApiOrBuilder {
        private static final Api DEFAULT_INSTANCE;
        public static final int OPERATION_FIELD_NUMBER = 2;
        private static volatile Parser<Api> PARSER = null;
        public static final int PROTOCOL_FIELD_NUMBER = 3;
        public static final int SERVICE_FIELD_NUMBER = 1;
        public static final int VERSION_FIELD_NUMBER = 4;
        private String service_ = "";
        private String operation_ = "";
        private String protocol_ = "";
        private String version_ = "";

        private Api() {
        }

        @Override // com.google.rpc.context.AttributeContext.ApiOrBuilder
        public final String getService() {
            return this.service_;
        }

        @Override // com.google.rpc.context.AttributeContext.ApiOrBuilder
        public final ByteString getServiceBytes() {
            return ByteString.copyFromUtf8(this.service_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setService(String str) {
            this.service_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearService() {
            this.service_ = getDefaultInstance().getService();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setServiceBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.service_ = byteString.toStringUtf8();
        }

        @Override // com.google.rpc.context.AttributeContext.ApiOrBuilder
        public final String getOperation() {
            return this.operation_;
        }

        @Override // com.google.rpc.context.AttributeContext.ApiOrBuilder
        public final ByteString getOperationBytes() {
            return ByteString.copyFromUtf8(this.operation_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOperation(String str) {
            this.operation_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOperation() {
            this.operation_ = getDefaultInstance().getOperation();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOperationBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.operation_ = byteString.toStringUtf8();
        }

        @Override // com.google.rpc.context.AttributeContext.ApiOrBuilder
        public final String getProtocol() {
            return this.protocol_;
        }

        @Override // com.google.rpc.context.AttributeContext.ApiOrBuilder
        public final ByteString getProtocolBytes() {
            return ByteString.copyFromUtf8(this.protocol_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProtocol(String str) {
            this.protocol_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearProtocol() {
            this.protocol_ = getDefaultInstance().getProtocol();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProtocolBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.protocol_ = byteString.toStringUtf8();
        }

        @Override // com.google.rpc.context.AttributeContext.ApiOrBuilder
        public final String getVersion() {
            return this.version_;
        }

        @Override // com.google.rpc.context.AttributeContext.ApiOrBuilder
        public final ByteString getVersionBytes() {
            return ByteString.copyFromUtf8(this.version_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVersion(String str) {
            this.version_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearVersion() {
            this.version_ = getDefaultInstance().getVersion();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVersionBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.version_ = byteString.toStringUtf8();
        }

        public static Api parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Api) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Api parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Api) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Api parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Api) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Api parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Api) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Api parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Api) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Api parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Api) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Api parseFrom(InputStream inputStream) throws IOException {
            return (Api) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Api parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Api) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Api parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Api) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Api parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Api) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Api parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Api) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Api parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Api) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Api api) {
            return DEFAULT_INSTANCE.createBuilder(api);
        }

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Api, Builder> implements ApiOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(Api.DEFAULT_INSTANCE);
            }

            @Override // com.google.rpc.context.AttributeContext.ApiOrBuilder
            public final String getService() {
                return ((Api) this.instance).getService();
            }

            @Override // com.google.rpc.context.AttributeContext.ApiOrBuilder
            public final ByteString getServiceBytes() {
                return ((Api) this.instance).getServiceBytes();
            }

            public final Builder setService(String str) {
                copyOnWrite();
                ((Api) this.instance).setService(str);
                return this;
            }

            public final Builder clearService() {
                copyOnWrite();
                ((Api) this.instance).clearService();
                return this;
            }

            public final Builder setServiceBytes(ByteString byteString) {
                copyOnWrite();
                ((Api) this.instance).setServiceBytes(byteString);
                return this;
            }

            @Override // com.google.rpc.context.AttributeContext.ApiOrBuilder
            public final String getOperation() {
                return ((Api) this.instance).getOperation();
            }

            @Override // com.google.rpc.context.AttributeContext.ApiOrBuilder
            public final ByteString getOperationBytes() {
                return ((Api) this.instance).getOperationBytes();
            }

            public final Builder setOperation(String str) {
                copyOnWrite();
                ((Api) this.instance).setOperation(str);
                return this;
            }

            public final Builder clearOperation() {
                copyOnWrite();
                ((Api) this.instance).clearOperation();
                return this;
            }

            public final Builder setOperationBytes(ByteString byteString) {
                copyOnWrite();
                ((Api) this.instance).setOperationBytes(byteString);
                return this;
            }

            @Override // com.google.rpc.context.AttributeContext.ApiOrBuilder
            public final String getProtocol() {
                return ((Api) this.instance).getProtocol();
            }

            @Override // com.google.rpc.context.AttributeContext.ApiOrBuilder
            public final ByteString getProtocolBytes() {
                return ((Api) this.instance).getProtocolBytes();
            }

            public final Builder setProtocol(String str) {
                copyOnWrite();
                ((Api) this.instance).setProtocol(str);
                return this;
            }

            public final Builder clearProtocol() {
                copyOnWrite();
                ((Api) this.instance).clearProtocol();
                return this;
            }

            public final Builder setProtocolBytes(ByteString byteString) {
                copyOnWrite();
                ((Api) this.instance).setProtocolBytes(byteString);
                return this;
            }

            @Override // com.google.rpc.context.AttributeContext.ApiOrBuilder
            public final String getVersion() {
                return ((Api) this.instance).getVersion();
            }

            @Override // com.google.rpc.context.AttributeContext.ApiOrBuilder
            public final ByteString getVersionBytes() {
                return ((Api) this.instance).getVersionBytes();
            }

            public final Builder setVersion(String str) {
                copyOnWrite();
                ((Api) this.instance).setVersion(str);
                return this;
            }

            public final Builder clearVersion() {
                copyOnWrite();
                ((Api) this.instance).clearVersion();
                return this;
            }

            public final Builder setVersionBytes(ByteString byteString) {
                copyOnWrite();
                ((Api) this.instance).setVersionBytes(byteString);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Api();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ", new Object[]{"service_", "operation_", "protocol_", "version_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Api> parser2 = PARSER;
                    if (parser2 == null) {
                        synchronized (Api.class) {
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
            Api api = new Api();
            DEFAULT_INSTANCE = api;
            GeneratedMessageLite.registerDefaultInstance(Api.class, api);
        }

        public static Api getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Api> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes7.dex */
    public static final class Auth extends GeneratedMessageLite<Auth, Builder> implements AuthOrBuilder {
        public static final int ACCESS_LEVELS_FIELD_NUMBER = 5;
        public static final int AUDIENCES_FIELD_NUMBER = 2;
        public static final int CLAIMS_FIELD_NUMBER = 4;
        private static final Auth DEFAULT_INSTANCE;
        private static volatile Parser<Auth> PARSER = null;
        public static final int PRESENTER_FIELD_NUMBER = 3;
        public static final int PRINCIPAL_FIELD_NUMBER = 1;
        private Struct claims_;
        private String principal_ = "";
        private Internal.ProtobufList<String> audiences_ = GeneratedMessageLite.emptyProtobufList();
        private String presenter_ = "";
        private Internal.ProtobufList<String> accessLevels_ = GeneratedMessageLite.emptyProtobufList();

        private Auth() {
        }

        @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
        public final String getPrincipal() {
            return this.principal_;
        }

        @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
        public final ByteString getPrincipalBytes() {
            return ByteString.copyFromUtf8(this.principal_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPrincipal(String str) {
            this.principal_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPrincipal() {
            this.principal_ = getDefaultInstance().getPrincipal();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPrincipalBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.principal_ = byteString.toStringUtf8();
        }

        @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
        public final List<String> getAudiencesList() {
            return this.audiences_;
        }

        @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
        public final int getAudiencesCount() {
            return this.audiences_.size();
        }

        @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
        public final String getAudiences(int i) {
            return this.audiences_.get(i);
        }

        @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
        public final ByteString getAudiencesBytes(int i) {
            return ByteString.copyFromUtf8(this.audiences_.get(i));
        }

        private void ensureAudiencesIsMutable() {
            Internal.ProtobufList<String> protobufList = this.audiences_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.audiences_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAudiences(int i, String str) {
            ensureAudiencesIsMutable();
            this.audiences_.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAudiences(String str) {
            ensureAudiencesIsMutable();
            this.audiences_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllAudiences(Iterable<String> iterable) {
            ensureAudiencesIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.audiences_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAudiences() {
            this.audiences_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAudiencesBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            ensureAudiencesIsMutable();
            this.audiences_.add(byteString.toStringUtf8());
        }

        @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
        public final String getPresenter() {
            return this.presenter_;
        }

        @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
        public final ByteString getPresenterBytes() {
            return ByteString.copyFromUtf8(this.presenter_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPresenter(String str) {
            this.presenter_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPresenter() {
            this.presenter_ = getDefaultInstance().getPresenter();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPresenterBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.presenter_ = byteString.toStringUtf8();
        }

        @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
        public final boolean hasClaims() {
            return this.claims_ != null;
        }

        @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
        public final Struct getClaims() {
            Struct struct = this.claims_;
            return struct == null ? Struct.getDefaultInstance() : struct;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClaims(Struct struct) {
            this.claims_ = struct;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeClaims(Struct struct) {
            Struct struct2 = this.claims_;
            if (struct2 != null && struct2 != Struct.getDefaultInstance()) {
                this.claims_ = Struct.newBuilder(this.claims_).mergeFrom((Struct.Builder) struct).buildPartial();
            } else {
                this.claims_ = struct;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClaims() {
            this.claims_ = null;
        }

        @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
        public final List<String> getAccessLevelsList() {
            return this.accessLevels_;
        }

        @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
        public final int getAccessLevelsCount() {
            return this.accessLevels_.size();
        }

        @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
        public final String getAccessLevels(int i) {
            return this.accessLevels_.get(i);
        }

        @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
        public final ByteString getAccessLevelsBytes(int i) {
            return ByteString.copyFromUtf8(this.accessLevels_.get(i));
        }

        private void ensureAccessLevelsIsMutable() {
            Internal.ProtobufList<String> protobufList = this.accessLevels_;
            if (protobufList.isModifiable()) {
                return;
            }
            this.accessLevels_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAccessLevels(int i, String str) {
            ensureAccessLevelsIsMutable();
            this.accessLevels_.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAccessLevels(String str) {
            ensureAccessLevelsIsMutable();
            this.accessLevels_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllAccessLevels(Iterable<String> iterable) {
            ensureAccessLevelsIsMutable();
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.accessLevels_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAccessLevels() {
            this.accessLevels_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAccessLevelsBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            ensureAccessLevelsIsMutable();
            this.accessLevels_.add(byteString.toStringUtf8());
        }

        public static Auth parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Auth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Auth parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Auth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Auth parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Auth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Auth parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Auth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Auth parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Auth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Auth parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Auth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Auth parseFrom(InputStream inputStream) throws IOException {
            return (Auth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Auth parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Auth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Auth parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Auth) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Auth parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Auth) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Auth parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Auth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Auth parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Auth) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Auth auth) {
            return DEFAULT_INSTANCE.createBuilder(auth);
        }

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Auth, Builder> implements AuthOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(Auth.DEFAULT_INSTANCE);
            }

            @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
            public final String getPrincipal() {
                return ((Auth) this.instance).getPrincipal();
            }

            @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
            public final ByteString getPrincipalBytes() {
                return ((Auth) this.instance).getPrincipalBytes();
            }

            public final Builder setPrincipal(String str) {
                copyOnWrite();
                ((Auth) this.instance).setPrincipal(str);
                return this;
            }

            public final Builder clearPrincipal() {
                copyOnWrite();
                ((Auth) this.instance).clearPrincipal();
                return this;
            }

            public final Builder setPrincipalBytes(ByteString byteString) {
                copyOnWrite();
                ((Auth) this.instance).setPrincipalBytes(byteString);
                return this;
            }

            @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
            public final List<String> getAudiencesList() {
                return Collections.unmodifiableList(((Auth) this.instance).getAudiencesList());
            }

            @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
            public final int getAudiencesCount() {
                return ((Auth) this.instance).getAudiencesCount();
            }

            @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
            public final String getAudiences(int i) {
                return ((Auth) this.instance).getAudiences(i);
            }

            @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
            public final ByteString getAudiencesBytes(int i) {
                return ((Auth) this.instance).getAudiencesBytes(i);
            }

            public final Builder setAudiences(int i, String str) {
                copyOnWrite();
                ((Auth) this.instance).setAudiences(i, str);
                return this;
            }

            public final Builder addAudiences(String str) {
                copyOnWrite();
                ((Auth) this.instance).addAudiences(str);
                return this;
            }

            public final Builder addAllAudiences(Iterable<String> iterable) {
                copyOnWrite();
                ((Auth) this.instance).addAllAudiences(iterable);
                return this;
            }

            public final Builder clearAudiences() {
                copyOnWrite();
                ((Auth) this.instance).clearAudiences();
                return this;
            }

            public final Builder addAudiencesBytes(ByteString byteString) {
                copyOnWrite();
                ((Auth) this.instance).addAudiencesBytes(byteString);
                return this;
            }

            @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
            public final String getPresenter() {
                return ((Auth) this.instance).getPresenter();
            }

            @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
            public final ByteString getPresenterBytes() {
                return ((Auth) this.instance).getPresenterBytes();
            }

            public final Builder setPresenter(String str) {
                copyOnWrite();
                ((Auth) this.instance).setPresenter(str);
                return this;
            }

            public final Builder clearPresenter() {
                copyOnWrite();
                ((Auth) this.instance).clearPresenter();
                return this;
            }

            public final Builder setPresenterBytes(ByteString byteString) {
                copyOnWrite();
                ((Auth) this.instance).setPresenterBytes(byteString);
                return this;
            }

            @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
            public final boolean hasClaims() {
                return ((Auth) this.instance).hasClaims();
            }

            @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
            public final Struct getClaims() {
                return ((Auth) this.instance).getClaims();
            }

            public final Builder setClaims(Struct struct) {
                copyOnWrite();
                ((Auth) this.instance).setClaims(struct);
                return this;
            }

            public final Builder setClaims(Struct.Builder builder) {
                copyOnWrite();
                ((Auth) this.instance).setClaims(builder.build());
                return this;
            }

            public final Builder mergeClaims(Struct struct) {
                copyOnWrite();
                ((Auth) this.instance).mergeClaims(struct);
                return this;
            }

            public final Builder clearClaims() {
                copyOnWrite();
                ((Auth) this.instance).clearClaims();
                return this;
            }

            @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
            public final List<String> getAccessLevelsList() {
                return Collections.unmodifiableList(((Auth) this.instance).getAccessLevelsList());
            }

            @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
            public final int getAccessLevelsCount() {
                return ((Auth) this.instance).getAccessLevelsCount();
            }

            @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
            public final String getAccessLevels(int i) {
                return ((Auth) this.instance).getAccessLevels(i);
            }

            @Override // com.google.rpc.context.AttributeContext.AuthOrBuilder
            public final ByteString getAccessLevelsBytes(int i) {
                return ((Auth) this.instance).getAccessLevelsBytes(i);
            }

            public final Builder setAccessLevels(int i, String str) {
                copyOnWrite();
                ((Auth) this.instance).setAccessLevels(i, str);
                return this;
            }

            public final Builder addAccessLevels(String str) {
                copyOnWrite();
                ((Auth) this.instance).addAccessLevels(str);
                return this;
            }

            public final Builder addAllAccessLevels(Iterable<String> iterable) {
                copyOnWrite();
                ((Auth) this.instance).addAllAccessLevels(iterable);
                return this;
            }

            public final Builder clearAccessLevels() {
                copyOnWrite();
                ((Auth) this.instance).clearAccessLevels();
                return this;
            }

            public final Builder addAccessLevelsBytes(ByteString byteString) {
                copyOnWrite();
                ((Auth) this.instance).addAccessLevelsBytes(byteString);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Auth();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0002\u0000\u0001Ȉ\u0002Ț\u0003Ȉ\u0004\t\u0005Ț", new Object[]{"principal_", "audiences_", "presenter_", "claims_", "accessLevels_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Auth> parser2 = PARSER;
                    if (parser2 == null) {
                        synchronized (Auth.class) {
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
            Auth auth = new Auth();
            DEFAULT_INSTANCE = auth;
            GeneratedMessageLite.registerDefaultInstance(Auth.class, auth);
        }

        public static Auth getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Auth> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes7.dex */
    public static final class Request extends GeneratedMessageLite<Request, Builder> implements RequestOrBuilder {
        public static final int AUTH_FIELD_NUMBER = 13;
        private static final Request DEFAULT_INSTANCE;
        public static final int HEADERS_FIELD_NUMBER = 3;
        public static final int HOST_FIELD_NUMBER = 5;
        public static final int ID_FIELD_NUMBER = 1;
        public static final int METHOD_FIELD_NUMBER = 2;
        private static volatile Parser<Request> PARSER = null;
        public static final int PATH_FIELD_NUMBER = 4;
        public static final int PROTOCOL_FIELD_NUMBER = 11;
        public static final int QUERY_FIELD_NUMBER = 7;
        public static final int REASON_FIELD_NUMBER = 12;
        public static final int SCHEME_FIELD_NUMBER = 6;
        public static final int SIZE_FIELD_NUMBER = 10;
        public static final int TIME_FIELD_NUMBER = 9;
        private Auth auth_;
        private long size_;
        private Timestamp time_;
        private MapFieldLite<String, String> headers_ = MapFieldLite.emptyMapField();
        private String id_ = "";
        private String method_ = "";
        private String path_ = "";
        private String host_ = "";
        private String scheme_ = "";
        private String query_ = "";
        private String protocol_ = "";
        private String reason_ = "";

        private Request() {
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public final String getId() {
            return this.id_;
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public final ByteString getIdBytes() {
            return ByteString.copyFromUtf8(this.id_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setId(String str) {
            this.id_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearId() {
            this.id_ = getDefaultInstance().getId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.id_ = byteString.toStringUtf8();
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public final String getMethod() {
            return this.method_;
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public final ByteString getMethodBytes() {
            return ByteString.copyFromUtf8(this.method_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMethod(String str) {
            this.method_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMethod() {
            this.method_ = getDefaultInstance().getMethod();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMethodBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.method_ = byteString.toStringUtf8();
        }

        /* loaded from: classes7.dex */
        static final class HeadersDefaultEntryHolder {
            static final MapEntryLite<String, String> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.STRING, "");

            private HeadersDefaultEntryHolder() {
            }
        }

        private MapFieldLite<String, String> internalGetHeaders() {
            return this.headers_;
        }

        private MapFieldLite<String, String> internalGetMutableHeaders() {
            if (!this.headers_.isMutable()) {
                this.headers_ = this.headers_.mutableCopy();
            }
            return this.headers_;
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public final int getHeadersCount() {
            return internalGetHeaders().size();
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public final boolean containsHeaders(String str) {
            return internalGetHeaders().containsKey(str);
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        @Deprecated
        public final Map<String, String> getHeaders() {
            return getHeadersMap();
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public final Map<String, String> getHeadersMap() {
            return Collections.unmodifiableMap(internalGetHeaders());
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public final String getHeadersOrDefault(String str, String str2) {
            MapFieldLite<String, String> internalGetHeaders = internalGetHeaders();
            return internalGetHeaders.containsKey(str) ? internalGetHeaders.get(str) : str2;
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public final String getHeadersOrThrow(String str) {
            MapFieldLite<String, String> internalGetHeaders = internalGetHeaders();
            if (!internalGetHeaders.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return internalGetHeaders.get(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, String> getMutableHeadersMap() {
            return internalGetMutableHeaders();
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public final String getPath() {
            return this.path_;
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public final ByteString getPathBytes() {
            return ByteString.copyFromUtf8(this.path_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPath(String str) {
            this.path_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPath() {
            this.path_ = getDefaultInstance().getPath();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPathBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.path_ = byteString.toStringUtf8();
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public final String getHost() {
            return this.host_;
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public final ByteString getHostBytes() {
            return ByteString.copyFromUtf8(this.host_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHost(String str) {
            this.host_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHost() {
            this.host_ = getDefaultInstance().getHost();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHostBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.host_ = byteString.toStringUtf8();
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public final String getScheme() {
            return this.scheme_;
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public final ByteString getSchemeBytes() {
            return ByteString.copyFromUtf8(this.scheme_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setScheme(String str) {
            this.scheme_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearScheme() {
            this.scheme_ = getDefaultInstance().getScheme();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSchemeBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.scheme_ = byteString.toStringUtf8();
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public final String getQuery() {
            return this.query_;
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public final ByteString getQueryBytes() {
            return ByteString.copyFromUtf8(this.query_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setQuery(String str) {
            this.query_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearQuery() {
            this.query_ = getDefaultInstance().getQuery();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setQueryBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.query_ = byteString.toStringUtf8();
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public final boolean hasTime() {
            return this.time_ != null;
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public final Timestamp getTime() {
            Timestamp timestamp = this.time_;
            return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTime(Timestamp timestamp) {
            this.time_ = timestamp;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeTime(Timestamp timestamp) {
            Timestamp timestamp2 = this.time_;
            if (timestamp2 != null && timestamp2 != Timestamp.getDefaultInstance()) {
                this.time_ = Timestamp.newBuilder(this.time_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
            } else {
                this.time_ = timestamp;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTime() {
            this.time_ = null;
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public final long getSize() {
            return this.size_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSize(long j) {
            this.size_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSize() {
            this.size_ = 0L;
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public final String getProtocol() {
            return this.protocol_;
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public final ByteString getProtocolBytes() {
            return ByteString.copyFromUtf8(this.protocol_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProtocol(String str) {
            this.protocol_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearProtocol() {
            this.protocol_ = getDefaultInstance().getProtocol();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProtocolBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.protocol_ = byteString.toStringUtf8();
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public final String getReason() {
            return this.reason_;
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public final ByteString getReasonBytes() {
            return ByteString.copyFromUtf8(this.reason_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReason(String str) {
            this.reason_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearReason() {
            this.reason_ = getDefaultInstance().getReason();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setReasonBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.reason_ = byteString.toStringUtf8();
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public final boolean hasAuth() {
            return this.auth_ != null;
        }

        @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
        public final Auth getAuth() {
            Auth auth = this.auth_;
            return auth == null ? Auth.getDefaultInstance() : auth;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAuth(Auth auth) {
            this.auth_ = auth;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeAuth(Auth auth) {
            Auth auth2 = this.auth_;
            if (auth2 != null && auth2 != Auth.getDefaultInstance()) {
                this.auth_ = Auth.newBuilder(this.auth_).mergeFrom((Auth.Builder) auth).buildPartial();
            } else {
                this.auth_ = auth;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAuth() {
            this.auth_ = null;
        }

        public static Request parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Request) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Request parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Request) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Request parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Request) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Request parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Request) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Request parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Request) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Request parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Request) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Request parseFrom(InputStream inputStream) throws IOException {
            return (Request) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Request parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Request) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Request parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Request) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Request parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Request) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Request parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Request) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Request parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Request) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Request request) {
            return DEFAULT_INSTANCE.createBuilder(request);
        }

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Request, Builder> implements RequestOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(Request.DEFAULT_INSTANCE);
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public final String getId() {
                return ((Request) this.instance).getId();
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public final ByteString getIdBytes() {
                return ((Request) this.instance).getIdBytes();
            }

            public final Builder setId(String str) {
                copyOnWrite();
                ((Request) this.instance).setId(str);
                return this;
            }

            public final Builder clearId() {
                copyOnWrite();
                ((Request) this.instance).clearId();
                return this;
            }

            public final Builder setIdBytes(ByteString byteString) {
                copyOnWrite();
                ((Request) this.instance).setIdBytes(byteString);
                return this;
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public final String getMethod() {
                return ((Request) this.instance).getMethod();
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public final ByteString getMethodBytes() {
                return ((Request) this.instance).getMethodBytes();
            }

            public final Builder setMethod(String str) {
                copyOnWrite();
                ((Request) this.instance).setMethod(str);
                return this;
            }

            public final Builder clearMethod() {
                copyOnWrite();
                ((Request) this.instance).clearMethod();
                return this;
            }

            public final Builder setMethodBytes(ByteString byteString) {
                copyOnWrite();
                ((Request) this.instance).setMethodBytes(byteString);
                return this;
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public final int getHeadersCount() {
                return ((Request) this.instance).getHeadersMap().size();
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public final boolean containsHeaders(String str) {
                return ((Request) this.instance).getHeadersMap().containsKey(str);
            }

            public final Builder clearHeaders() {
                copyOnWrite();
                ((Request) this.instance).getMutableHeadersMap().clear();
                return this;
            }

            public final Builder removeHeaders(String str) {
                copyOnWrite();
                ((Request) this.instance).getMutableHeadersMap().remove(str);
                return this;
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            @Deprecated
            public final Map<String, String> getHeaders() {
                return getHeadersMap();
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public final Map<String, String> getHeadersMap() {
                return Collections.unmodifiableMap(((Request) this.instance).getHeadersMap());
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public final String getHeadersOrDefault(String str, String str2) {
                Map<String, String> headersMap = ((Request) this.instance).getHeadersMap();
                return headersMap.containsKey(str) ? headersMap.get(str) : str2;
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public final String getHeadersOrThrow(String str) {
                Map<String, String> headersMap = ((Request) this.instance).getHeadersMap();
                if (!headersMap.containsKey(str)) {
                    throw new IllegalArgumentException();
                }
                return headersMap.get(str);
            }

            public final Builder putHeaders(String str, String str2) {
                copyOnWrite();
                ((Request) this.instance).getMutableHeadersMap().put(str, str2);
                return this;
            }

            public final Builder putAllHeaders(Map<String, String> map) {
                copyOnWrite();
                ((Request) this.instance).getMutableHeadersMap().putAll(map);
                return this;
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public final String getPath() {
                return ((Request) this.instance).getPath();
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public final ByteString getPathBytes() {
                return ((Request) this.instance).getPathBytes();
            }

            public final Builder setPath(String str) {
                copyOnWrite();
                ((Request) this.instance).setPath(str);
                return this;
            }

            public final Builder clearPath() {
                copyOnWrite();
                ((Request) this.instance).clearPath();
                return this;
            }

            public final Builder setPathBytes(ByteString byteString) {
                copyOnWrite();
                ((Request) this.instance).setPathBytes(byteString);
                return this;
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public final String getHost() {
                return ((Request) this.instance).getHost();
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public final ByteString getHostBytes() {
                return ((Request) this.instance).getHostBytes();
            }

            public final Builder setHost(String str) {
                copyOnWrite();
                ((Request) this.instance).setHost(str);
                return this;
            }

            public final Builder clearHost() {
                copyOnWrite();
                ((Request) this.instance).clearHost();
                return this;
            }

            public final Builder setHostBytes(ByteString byteString) {
                copyOnWrite();
                ((Request) this.instance).setHostBytes(byteString);
                return this;
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public final String getScheme() {
                return ((Request) this.instance).getScheme();
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public final ByteString getSchemeBytes() {
                return ((Request) this.instance).getSchemeBytes();
            }

            public final Builder setScheme(String str) {
                copyOnWrite();
                ((Request) this.instance).setScheme(str);
                return this;
            }

            public final Builder clearScheme() {
                copyOnWrite();
                ((Request) this.instance).clearScheme();
                return this;
            }

            public final Builder setSchemeBytes(ByteString byteString) {
                copyOnWrite();
                ((Request) this.instance).setSchemeBytes(byteString);
                return this;
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public final String getQuery() {
                return ((Request) this.instance).getQuery();
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public final ByteString getQueryBytes() {
                return ((Request) this.instance).getQueryBytes();
            }

            public final Builder setQuery(String str) {
                copyOnWrite();
                ((Request) this.instance).setQuery(str);
                return this;
            }

            public final Builder clearQuery() {
                copyOnWrite();
                ((Request) this.instance).clearQuery();
                return this;
            }

            public final Builder setQueryBytes(ByteString byteString) {
                copyOnWrite();
                ((Request) this.instance).setQueryBytes(byteString);
                return this;
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public final boolean hasTime() {
                return ((Request) this.instance).hasTime();
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public final Timestamp getTime() {
                return ((Request) this.instance).getTime();
            }

            public final Builder setTime(Timestamp timestamp) {
                copyOnWrite();
                ((Request) this.instance).setTime(timestamp);
                return this;
            }

            public final Builder setTime(Timestamp.Builder builder) {
                copyOnWrite();
                ((Request) this.instance).setTime(builder.build());
                return this;
            }

            public final Builder mergeTime(Timestamp timestamp) {
                copyOnWrite();
                ((Request) this.instance).mergeTime(timestamp);
                return this;
            }

            public final Builder clearTime() {
                copyOnWrite();
                ((Request) this.instance).clearTime();
                return this;
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public final long getSize() {
                return ((Request) this.instance).getSize();
            }

            public final Builder setSize(long j) {
                copyOnWrite();
                ((Request) this.instance).setSize(j);
                return this;
            }

            public final Builder clearSize() {
                copyOnWrite();
                ((Request) this.instance).clearSize();
                return this;
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public final String getProtocol() {
                return ((Request) this.instance).getProtocol();
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public final ByteString getProtocolBytes() {
                return ((Request) this.instance).getProtocolBytes();
            }

            public final Builder setProtocol(String str) {
                copyOnWrite();
                ((Request) this.instance).setProtocol(str);
                return this;
            }

            public final Builder clearProtocol() {
                copyOnWrite();
                ((Request) this.instance).clearProtocol();
                return this;
            }

            public final Builder setProtocolBytes(ByteString byteString) {
                copyOnWrite();
                ((Request) this.instance).setProtocolBytes(byteString);
                return this;
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public final String getReason() {
                return ((Request) this.instance).getReason();
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public final ByteString getReasonBytes() {
                return ((Request) this.instance).getReasonBytes();
            }

            public final Builder setReason(String str) {
                copyOnWrite();
                ((Request) this.instance).setReason(str);
                return this;
            }

            public final Builder clearReason() {
                copyOnWrite();
                ((Request) this.instance).clearReason();
                return this;
            }

            public final Builder setReasonBytes(ByteString byteString) {
                copyOnWrite();
                ((Request) this.instance).setReasonBytes(byteString);
                return this;
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public final boolean hasAuth() {
                return ((Request) this.instance).hasAuth();
            }

            @Override // com.google.rpc.context.AttributeContext.RequestOrBuilder
            public final Auth getAuth() {
                return ((Request) this.instance).getAuth();
            }

            public final Builder setAuth(Auth auth) {
                copyOnWrite();
                ((Request) this.instance).setAuth(auth);
                return this;
            }

            public final Builder setAuth(Auth.Builder builder) {
                copyOnWrite();
                ((Request) this.instance).setAuth(builder.build());
                return this;
            }

            public final Builder mergeAuth(Auth auth) {
                copyOnWrite();
                ((Request) this.instance).mergeAuth(auth);
                return this;
            }

            public final Builder clearAuth() {
                copyOnWrite();
                ((Request) this.instance).clearAuth();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Request();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\f\u0000\u0000\u0001\r\f\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u00032\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007Ȉ\t\t\n\u0002\u000bȈ\fȈ\r\t", new Object[]{"id_", "method_", "headers_", HeadersDefaultEntryHolder.defaultEntry, "path_", "host_", "scheme_", "query_", "time_", "size_", "protocol_", "reason_", "auth_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Request> parser2 = PARSER;
                    if (parser2 == null) {
                        synchronized (Request.class) {
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
            Request request = new Request();
            DEFAULT_INSTANCE = request;
            GeneratedMessageLite.registerDefaultInstance(Request.class, request);
        }

        public static Request getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Request> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes7.dex */
    public static final class Response extends GeneratedMessageLite<Response, Builder> implements ResponseOrBuilder {
        public static final int CODE_FIELD_NUMBER = 1;
        private static final Response DEFAULT_INSTANCE;
        public static final int HEADERS_FIELD_NUMBER = 3;
        private static volatile Parser<Response> PARSER = null;
        public static final int SIZE_FIELD_NUMBER = 2;
        public static final int TIME_FIELD_NUMBER = 4;
        private long code_;
        private MapFieldLite<String, String> headers_ = MapFieldLite.emptyMapField();
        private long size_;
        private Timestamp time_;

        private Response() {
        }

        @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
        public final long getCode() {
            return this.code_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCode(long j) {
            this.code_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCode() {
            this.code_ = 0L;
        }

        @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
        public final long getSize() {
            return this.size_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSize(long j) {
            this.size_ = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSize() {
            this.size_ = 0L;
        }

        /* loaded from: classes7.dex */
        static final class HeadersDefaultEntryHolder {
            static final MapEntryLite<String, String> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.STRING, "");

            private HeadersDefaultEntryHolder() {
            }
        }

        private MapFieldLite<String, String> internalGetHeaders() {
            return this.headers_;
        }

        private MapFieldLite<String, String> internalGetMutableHeaders() {
            if (!this.headers_.isMutable()) {
                this.headers_ = this.headers_.mutableCopy();
            }
            return this.headers_;
        }

        @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
        public final int getHeadersCount() {
            return internalGetHeaders().size();
        }

        @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
        public final boolean containsHeaders(String str) {
            return internalGetHeaders().containsKey(str);
        }

        @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
        @Deprecated
        public final Map<String, String> getHeaders() {
            return getHeadersMap();
        }

        @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
        public final Map<String, String> getHeadersMap() {
            return Collections.unmodifiableMap(internalGetHeaders());
        }

        @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
        public final String getHeadersOrDefault(String str, String str2) {
            MapFieldLite<String, String> internalGetHeaders = internalGetHeaders();
            return internalGetHeaders.containsKey(str) ? internalGetHeaders.get(str) : str2;
        }

        @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
        public final String getHeadersOrThrow(String str) {
            MapFieldLite<String, String> internalGetHeaders = internalGetHeaders();
            if (!internalGetHeaders.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return internalGetHeaders.get(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, String> getMutableHeadersMap() {
            return internalGetMutableHeaders();
        }

        @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
        public final boolean hasTime() {
            return this.time_ != null;
        }

        @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
        public final Timestamp getTime() {
            Timestamp timestamp = this.time_;
            return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTime(Timestamp timestamp) {
            this.time_ = timestamp;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeTime(Timestamp timestamp) {
            Timestamp timestamp2 = this.time_;
            if (timestamp2 != null && timestamp2 != Timestamp.getDefaultInstance()) {
                this.time_ = Timestamp.newBuilder(this.time_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
            } else {
                this.time_ = timestamp;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTime() {
            this.time_ = null;
        }

        public static Response parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Response) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Response parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Response) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Response parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Response) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Response parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Response) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Response parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Response) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Response parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Response) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Response parseFrom(InputStream inputStream) throws IOException {
            return (Response) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Response parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Response) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Response parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Response) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Response parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Response) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Response parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Response) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Response parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Response) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Response response) {
            return DEFAULT_INSTANCE.createBuilder(response);
        }

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Response, Builder> implements ResponseOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(Response.DEFAULT_INSTANCE);
            }

            @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
            public final long getCode() {
                return ((Response) this.instance).getCode();
            }

            public final Builder setCode(long j) {
                copyOnWrite();
                ((Response) this.instance).setCode(j);
                return this;
            }

            public final Builder clearCode() {
                copyOnWrite();
                ((Response) this.instance).clearCode();
                return this;
            }

            @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
            public final long getSize() {
                return ((Response) this.instance).getSize();
            }

            public final Builder setSize(long j) {
                copyOnWrite();
                ((Response) this.instance).setSize(j);
                return this;
            }

            public final Builder clearSize() {
                copyOnWrite();
                ((Response) this.instance).clearSize();
                return this;
            }

            @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
            public final int getHeadersCount() {
                return ((Response) this.instance).getHeadersMap().size();
            }

            @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
            public final boolean containsHeaders(String str) {
                return ((Response) this.instance).getHeadersMap().containsKey(str);
            }

            public final Builder clearHeaders() {
                copyOnWrite();
                ((Response) this.instance).getMutableHeadersMap().clear();
                return this;
            }

            public final Builder removeHeaders(String str) {
                copyOnWrite();
                ((Response) this.instance).getMutableHeadersMap().remove(str);
                return this;
            }

            @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
            @Deprecated
            public final Map<String, String> getHeaders() {
                return getHeadersMap();
            }

            @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
            public final Map<String, String> getHeadersMap() {
                return Collections.unmodifiableMap(((Response) this.instance).getHeadersMap());
            }

            @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
            public final String getHeadersOrDefault(String str, String str2) {
                Map<String, String> headersMap = ((Response) this.instance).getHeadersMap();
                return headersMap.containsKey(str) ? headersMap.get(str) : str2;
            }

            @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
            public final String getHeadersOrThrow(String str) {
                Map<String, String> headersMap = ((Response) this.instance).getHeadersMap();
                if (!headersMap.containsKey(str)) {
                    throw new IllegalArgumentException();
                }
                return headersMap.get(str);
            }

            public final Builder putHeaders(String str, String str2) {
                copyOnWrite();
                ((Response) this.instance).getMutableHeadersMap().put(str, str2);
                return this;
            }

            public final Builder putAllHeaders(Map<String, String> map) {
                copyOnWrite();
                ((Response) this.instance).getMutableHeadersMap().putAll(map);
                return this;
            }

            @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
            public final boolean hasTime() {
                return ((Response) this.instance).hasTime();
            }

            @Override // com.google.rpc.context.AttributeContext.ResponseOrBuilder
            public final Timestamp getTime() {
                return ((Response) this.instance).getTime();
            }

            public final Builder setTime(Timestamp timestamp) {
                copyOnWrite();
                ((Response) this.instance).setTime(timestamp);
                return this;
            }

            public final Builder setTime(Timestamp.Builder builder) {
                copyOnWrite();
                ((Response) this.instance).setTime(builder.build());
                return this;
            }

            public final Builder mergeTime(Timestamp timestamp) {
                copyOnWrite();
                ((Response) this.instance).mergeTime(timestamp);
                return this;
            }

            public final Builder clearTime() {
                copyOnWrite();
                ((Response) this.instance).clearTime();
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Response();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0001\u0000\u0000\u0001\u0002\u0002\u0002\u00032\u0004\t", new Object[]{"code_", "size_", "headers_", HeadersDefaultEntryHolder.defaultEntry, "time_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Response> parser2 = PARSER;
                    if (parser2 == null) {
                        synchronized (Response.class) {
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
            Response response = new Response();
            DEFAULT_INSTANCE = response;
            GeneratedMessageLite.registerDefaultInstance(Response.class, response);
        }

        public static Response getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Response> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes7.dex */
    public static final class Resource extends GeneratedMessageLite<Resource, Builder> implements ResourceOrBuilder {
        private static final Resource DEFAULT_INSTANCE;
        public static final int LABELS_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 2;
        private static volatile Parser<Resource> PARSER = null;
        public static final int SERVICE_FIELD_NUMBER = 1;
        public static final int TYPE_FIELD_NUMBER = 3;
        private MapFieldLite<String, String> labels_ = MapFieldLite.emptyMapField();
        private String service_ = "";
        private String name_ = "";
        private String type_ = "";

        private Resource() {
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public final String getService() {
            return this.service_;
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public final ByteString getServiceBytes() {
            return ByteString.copyFromUtf8(this.service_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setService(String str) {
            this.service_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearService() {
            this.service_ = getDefaultInstance().getService();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setServiceBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.service_ = byteString.toStringUtf8();
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public final String getName() {
            return this.name_;
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
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

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public final String getType() {
            return this.type_;
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
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

        /* loaded from: classes7.dex */
        static final class LabelsDefaultEntryHolder {
            static final MapEntryLite<String, String> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.STRING, "");

            private LabelsDefaultEntryHolder() {
            }
        }

        private MapFieldLite<String, String> internalGetLabels() {
            return this.labels_;
        }

        private MapFieldLite<String, String> internalGetMutableLabels() {
            if (!this.labels_.isMutable()) {
                this.labels_ = this.labels_.mutableCopy();
            }
            return this.labels_;
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public final int getLabelsCount() {
            return internalGetLabels().size();
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public final boolean containsLabels(String str) {
            return internalGetLabels().containsKey(str);
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        @Deprecated
        public final Map<String, String> getLabels() {
            return getLabelsMap();
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public final Map<String, String> getLabelsMap() {
            return Collections.unmodifiableMap(internalGetLabels());
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public final String getLabelsOrDefault(String str, String str2) {
            MapFieldLite<String, String> internalGetLabels = internalGetLabels();
            return internalGetLabels.containsKey(str) ? internalGetLabels.get(str) : str2;
        }

        @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
        public final String getLabelsOrThrow(String str) {
            MapFieldLite<String, String> internalGetLabels = internalGetLabels();
            if (!internalGetLabels.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return internalGetLabels.get(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, String> getMutableLabelsMap() {
            return internalGetMutableLabels();
        }

        public static Resource parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Resource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Resource parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Resource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Resource parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Resource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Resource parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Resource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Resource parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Resource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Resource parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Resource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Resource parseFrom(InputStream inputStream) throws IOException {
            return (Resource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Resource parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Resource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Resource parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Resource) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Resource parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Resource) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Resource parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Resource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Resource parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Resource) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Resource resource) {
            return DEFAULT_INSTANCE.createBuilder(resource);
        }

        /* loaded from: classes7.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Resource, Builder> implements ResourceOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            private Builder() {
                super(Resource.DEFAULT_INSTANCE);
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public final String getService() {
                return ((Resource) this.instance).getService();
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public final ByteString getServiceBytes() {
                return ((Resource) this.instance).getServiceBytes();
            }

            public final Builder setService(String str) {
                copyOnWrite();
                ((Resource) this.instance).setService(str);
                return this;
            }

            public final Builder clearService() {
                copyOnWrite();
                ((Resource) this.instance).clearService();
                return this;
            }

            public final Builder setServiceBytes(ByteString byteString) {
                copyOnWrite();
                ((Resource) this.instance).setServiceBytes(byteString);
                return this;
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public final String getName() {
                return ((Resource) this.instance).getName();
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public final ByteString getNameBytes() {
                return ((Resource) this.instance).getNameBytes();
            }

            public final Builder setName(String str) {
                copyOnWrite();
                ((Resource) this.instance).setName(str);
                return this;
            }

            public final Builder clearName() {
                copyOnWrite();
                ((Resource) this.instance).clearName();
                return this;
            }

            public final Builder setNameBytes(ByteString byteString) {
                copyOnWrite();
                ((Resource) this.instance).setNameBytes(byteString);
                return this;
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public final String getType() {
                return ((Resource) this.instance).getType();
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public final ByteString getTypeBytes() {
                return ((Resource) this.instance).getTypeBytes();
            }

            public final Builder setType(String str) {
                copyOnWrite();
                ((Resource) this.instance).setType(str);
                return this;
            }

            public final Builder clearType() {
                copyOnWrite();
                ((Resource) this.instance).clearType();
                return this;
            }

            public final Builder setTypeBytes(ByteString byteString) {
                copyOnWrite();
                ((Resource) this.instance).setTypeBytes(byteString);
                return this;
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public final int getLabelsCount() {
                return ((Resource) this.instance).getLabelsMap().size();
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public final boolean containsLabels(String str) {
                return ((Resource) this.instance).getLabelsMap().containsKey(str);
            }

            public final Builder clearLabels() {
                copyOnWrite();
                ((Resource) this.instance).getMutableLabelsMap().clear();
                return this;
            }

            public final Builder removeLabels(String str) {
                copyOnWrite();
                ((Resource) this.instance).getMutableLabelsMap().remove(str);
                return this;
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            @Deprecated
            public final Map<String, String> getLabels() {
                return getLabelsMap();
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public final Map<String, String> getLabelsMap() {
                return Collections.unmodifiableMap(((Resource) this.instance).getLabelsMap());
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public final String getLabelsOrDefault(String str, String str2) {
                Map<String, String> labelsMap = ((Resource) this.instance).getLabelsMap();
                return labelsMap.containsKey(str) ? labelsMap.get(str) : str2;
            }

            @Override // com.google.rpc.context.AttributeContext.ResourceOrBuilder
            public final String getLabelsOrThrow(String str) {
                Map<String, String> labelsMap = ((Resource) this.instance).getLabelsMap();
                if (!labelsMap.containsKey(str)) {
                    throw new IllegalArgumentException();
                }
                return labelsMap.get(str);
            }

            public final Builder putLabels(String str, String str2) {
                copyOnWrite();
                ((Resource) this.instance).getMutableLabelsMap().put(str, str2);
                return this;
            }

            public final Builder putAllLabels(Map<String, String> map) {
                copyOnWrite();
                ((Resource) this.instance).getMutableLabelsMap().putAll(map);
                return this;
            }
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Resource();
                case 2:
                    return new Builder(anonymousClass1);
                case 3:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u00042", new Object[]{"service_", "name_", "type_", "labels_", LabelsDefaultEntryHolder.defaultEntry});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Resource> parser2 = PARSER;
                    if (parser2 == null) {
                        synchronized (Resource.class) {
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
            Resource resource = new Resource();
            DEFAULT_INSTANCE = resource;
            GeneratedMessageLite.registerDefaultInstance(Resource.class, resource);
        }

        public static Resource getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Resource> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public final boolean hasOrigin() {
        return this.origin_ != null;
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public final Peer getOrigin() {
        Peer peer = this.origin_;
        return peer == null ? Peer.getDefaultInstance() : peer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOrigin(Peer peer) {
        this.origin_ = peer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeOrigin(Peer peer) {
        Peer peer2 = this.origin_;
        if (peer2 != null && peer2 != Peer.getDefaultInstance()) {
            this.origin_ = Peer.newBuilder(this.origin_).mergeFrom((Peer.Builder) peer).buildPartial();
        } else {
            this.origin_ = peer;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOrigin() {
        this.origin_ = null;
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public final boolean hasSource() {
        return this.source_ != null;
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public final Peer getSource() {
        Peer peer = this.source_;
        return peer == null ? Peer.getDefaultInstance() : peer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSource(Peer peer) {
        this.source_ = peer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSource(Peer peer) {
        Peer peer2 = this.source_;
        if (peer2 != null && peer2 != Peer.getDefaultInstance()) {
            this.source_ = Peer.newBuilder(this.source_).mergeFrom((Peer.Builder) peer).buildPartial();
        } else {
            this.source_ = peer;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSource() {
        this.source_ = null;
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public final boolean hasDestination() {
        return this.destination_ != null;
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public final Peer getDestination() {
        Peer peer = this.destination_;
        return peer == null ? Peer.getDefaultInstance() : peer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDestination(Peer peer) {
        this.destination_ = peer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeDestination(Peer peer) {
        Peer peer2 = this.destination_;
        if (peer2 != null && peer2 != Peer.getDefaultInstance()) {
            this.destination_ = Peer.newBuilder(this.destination_).mergeFrom((Peer.Builder) peer).buildPartial();
        } else {
            this.destination_ = peer;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDestination() {
        this.destination_ = null;
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public final boolean hasRequest() {
        return this.request_ != null;
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public final Request getRequest() {
        Request request = this.request_;
        return request == null ? Request.getDefaultInstance() : request;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequest(Request request) {
        this.request_ = request;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeRequest(Request request) {
        Request request2 = this.request_;
        if (request2 != null && request2 != Request.getDefaultInstance()) {
            this.request_ = Request.newBuilder(this.request_).mergeFrom((Request.Builder) request).buildPartial();
        } else {
            this.request_ = request;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRequest() {
        this.request_ = null;
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public final boolean hasResponse() {
        return this.response_ != null;
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public final Response getResponse() {
        Response response = this.response_;
        return response == null ? Response.getDefaultInstance() : response;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResponse(Response response) {
        this.response_ = response;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeResponse(Response response) {
        Response response2 = this.response_;
        if (response2 != null && response2 != Response.getDefaultInstance()) {
            this.response_ = Response.newBuilder(this.response_).mergeFrom((Response.Builder) response).buildPartial();
        } else {
            this.response_ = response;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResponse() {
        this.response_ = null;
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public final boolean hasResource() {
        return this.resource_ != null;
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public final Resource getResource() {
        Resource resource = this.resource_;
        return resource == null ? Resource.getDefaultInstance() : resource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResource(Resource resource) {
        this.resource_ = resource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeResource(Resource resource) {
        Resource resource2 = this.resource_;
        if (resource2 != null && resource2 != Resource.getDefaultInstance()) {
            this.resource_ = Resource.newBuilder(this.resource_).mergeFrom((Resource.Builder) resource).buildPartial();
        } else {
            this.resource_ = resource;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResource() {
        this.resource_ = null;
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public final boolean hasApi() {
        return this.api_ != null;
    }

    @Override // com.google.rpc.context.AttributeContextOrBuilder
    public final Api getApi() {
        Api api = this.api_;
        return api == null ? Api.getDefaultInstance() : api;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setApi(Api api) {
        this.api_ = api;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeApi(Api api) {
        Api api2 = this.api_;
        if (api2 != null && api2 != Api.getDefaultInstance()) {
            this.api_ = Api.newBuilder(this.api_).mergeFrom((Api.Builder) api).buildPartial();
        } else {
            this.api_ = api;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearApi() {
        this.api_ = null;
    }

    public static AttributeContext parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (AttributeContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static AttributeContext parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AttributeContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static AttributeContext parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (AttributeContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static AttributeContext parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AttributeContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AttributeContext parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (AttributeContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AttributeContext parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AttributeContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static AttributeContext parseFrom(InputStream inputStream) throws IOException {
        return (AttributeContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AttributeContext parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AttributeContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AttributeContext parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AttributeContext) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AttributeContext parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AttributeContext) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AttributeContext parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (AttributeContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AttributeContext parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AttributeContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(AttributeContext attributeContext) {
        return DEFAULT_INSTANCE.createBuilder(attributeContext);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<AttributeContext, Builder> implements AttributeContextOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(AttributeContext.DEFAULT_INSTANCE);
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public final boolean hasOrigin() {
            return ((AttributeContext) this.instance).hasOrigin();
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public final Peer getOrigin() {
            return ((AttributeContext) this.instance).getOrigin();
        }

        public final Builder setOrigin(Peer peer) {
            copyOnWrite();
            ((AttributeContext) this.instance).setOrigin(peer);
            return this;
        }

        public final Builder setOrigin(Peer.Builder builder) {
            copyOnWrite();
            ((AttributeContext) this.instance).setOrigin(builder.build());
            return this;
        }

        public final Builder mergeOrigin(Peer peer) {
            copyOnWrite();
            ((AttributeContext) this.instance).mergeOrigin(peer);
            return this;
        }

        public final Builder clearOrigin() {
            copyOnWrite();
            ((AttributeContext) this.instance).clearOrigin();
            return this;
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public final boolean hasSource() {
            return ((AttributeContext) this.instance).hasSource();
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public final Peer getSource() {
            return ((AttributeContext) this.instance).getSource();
        }

        public final Builder setSource(Peer peer) {
            copyOnWrite();
            ((AttributeContext) this.instance).setSource(peer);
            return this;
        }

        public final Builder setSource(Peer.Builder builder) {
            copyOnWrite();
            ((AttributeContext) this.instance).setSource(builder.build());
            return this;
        }

        public final Builder mergeSource(Peer peer) {
            copyOnWrite();
            ((AttributeContext) this.instance).mergeSource(peer);
            return this;
        }

        public final Builder clearSource() {
            copyOnWrite();
            ((AttributeContext) this.instance).clearSource();
            return this;
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public final boolean hasDestination() {
            return ((AttributeContext) this.instance).hasDestination();
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public final Peer getDestination() {
            return ((AttributeContext) this.instance).getDestination();
        }

        public final Builder setDestination(Peer peer) {
            copyOnWrite();
            ((AttributeContext) this.instance).setDestination(peer);
            return this;
        }

        public final Builder setDestination(Peer.Builder builder) {
            copyOnWrite();
            ((AttributeContext) this.instance).setDestination(builder.build());
            return this;
        }

        public final Builder mergeDestination(Peer peer) {
            copyOnWrite();
            ((AttributeContext) this.instance).mergeDestination(peer);
            return this;
        }

        public final Builder clearDestination() {
            copyOnWrite();
            ((AttributeContext) this.instance).clearDestination();
            return this;
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public final boolean hasRequest() {
            return ((AttributeContext) this.instance).hasRequest();
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public final Request getRequest() {
            return ((AttributeContext) this.instance).getRequest();
        }

        public final Builder setRequest(Request request) {
            copyOnWrite();
            ((AttributeContext) this.instance).setRequest(request);
            return this;
        }

        public final Builder setRequest(Request.Builder builder) {
            copyOnWrite();
            ((AttributeContext) this.instance).setRequest(builder.build());
            return this;
        }

        public final Builder mergeRequest(Request request) {
            copyOnWrite();
            ((AttributeContext) this.instance).mergeRequest(request);
            return this;
        }

        public final Builder clearRequest() {
            copyOnWrite();
            ((AttributeContext) this.instance).clearRequest();
            return this;
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public final boolean hasResponse() {
            return ((AttributeContext) this.instance).hasResponse();
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public final Response getResponse() {
            return ((AttributeContext) this.instance).getResponse();
        }

        public final Builder setResponse(Response response) {
            copyOnWrite();
            ((AttributeContext) this.instance).setResponse(response);
            return this;
        }

        public final Builder setResponse(Response.Builder builder) {
            copyOnWrite();
            ((AttributeContext) this.instance).setResponse(builder.build());
            return this;
        }

        public final Builder mergeResponse(Response response) {
            copyOnWrite();
            ((AttributeContext) this.instance).mergeResponse(response);
            return this;
        }

        public final Builder clearResponse() {
            copyOnWrite();
            ((AttributeContext) this.instance).clearResponse();
            return this;
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public final boolean hasResource() {
            return ((AttributeContext) this.instance).hasResource();
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public final Resource getResource() {
            return ((AttributeContext) this.instance).getResource();
        }

        public final Builder setResource(Resource resource) {
            copyOnWrite();
            ((AttributeContext) this.instance).setResource(resource);
            return this;
        }

        public final Builder setResource(Resource.Builder builder) {
            copyOnWrite();
            ((AttributeContext) this.instance).setResource(builder.build());
            return this;
        }

        public final Builder mergeResource(Resource resource) {
            copyOnWrite();
            ((AttributeContext) this.instance).mergeResource(resource);
            return this;
        }

        public final Builder clearResource() {
            copyOnWrite();
            ((AttributeContext) this.instance).clearResource();
            return this;
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public final boolean hasApi() {
            return ((AttributeContext) this.instance).hasApi();
        }

        @Override // com.google.rpc.context.AttributeContextOrBuilder
        public final Api getApi() {
            return ((AttributeContext) this.instance).getApi();
        }

        public final Builder setApi(Api api) {
            copyOnWrite();
            ((AttributeContext) this.instance).setApi(api);
            return this;
        }

        public final Builder setApi(Api.Builder builder) {
            copyOnWrite();
            ((AttributeContext) this.instance).setApi(builder.build());
            return this;
        }

        public final Builder mergeApi(Api api) {
            copyOnWrite();
            ((AttributeContext) this.instance).mergeApi(api);
            return this;
        }

        public final Builder clearApi() {
            copyOnWrite();
            ((AttributeContext) this.instance).clearApi();
            return this;
        }
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        Parser parser;
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new AttributeContext();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001\t\u0002\t\u0003\t\u0004\t\u0005\t\u0006\t\u0007\t", new Object[]{"source_", "destination_", "request_", "response_", "resource_", "api_", "origin_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AttributeContext> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (AttributeContext.class) {
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
        AttributeContext attributeContext = new AttributeContext();
        DEFAULT_INSTANCE = attributeContext;
        GeneratedMessageLite.registerDefaultInstance(AttributeContext.class, attributeContext);
    }

    public static AttributeContext getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<AttributeContext> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
