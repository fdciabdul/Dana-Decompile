package com.google.firebase.perf.v1;

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

/* loaded from: classes7.dex */
public final class NetworkConnectionInfo extends GeneratedMessageLite<NetworkConnectionInfo, Builder> implements NetworkConnectionInfoOrBuilder {
    private static final NetworkConnectionInfo DEFAULT_INSTANCE;
    public static final int MOBILE_SUBTYPE_FIELD_NUMBER = 2;
    public static final int NETWORK_TYPE_FIELD_NUMBER = 1;
    private static volatile Parser<NetworkConnectionInfo> PARSER;
    private int bitField0_;
    private int mobileSubtype_;
    private int networkType_ = -1;

    private NetworkConnectionInfo() {
    }

    /* loaded from: classes7.dex */
    public enum NetworkType implements Internal.EnumLite {
        NONE(-1),
        MOBILE(0),
        WIFI(1),
        MOBILE_MMS(2),
        MOBILE_SUPL(3),
        MOBILE_DUN(4),
        MOBILE_HIPRI(5),
        WIMAX(6),
        BLUETOOTH(7),
        DUMMY(8),
        ETHERNET(9),
        MOBILE_FOTA(10),
        MOBILE_IMS(11),
        MOBILE_CBS(12),
        WIFI_P2P(13),
        MOBILE_IA(14),
        MOBILE_EMERGENCY(15),
        PROXY(16),
        VPN(17);

        public static final int BLUETOOTH_VALUE = 7;
        public static final int DUMMY_VALUE = 8;
        public static final int ETHERNET_VALUE = 9;
        public static final int MOBILE_CBS_VALUE = 12;
        public static final int MOBILE_DUN_VALUE = 4;
        public static final int MOBILE_EMERGENCY_VALUE = 15;
        public static final int MOBILE_FOTA_VALUE = 10;
        public static final int MOBILE_HIPRI_VALUE = 5;
        public static final int MOBILE_IA_VALUE = 14;
        public static final int MOBILE_IMS_VALUE = 11;
        public static final int MOBILE_MMS_VALUE = 2;
        public static final int MOBILE_SUPL_VALUE = 3;
        public static final int MOBILE_VALUE = 0;
        public static final int NONE_VALUE = -1;
        public static final int PROXY_VALUE = 16;
        public static final int VPN_VALUE = 17;
        public static final int WIFI_P2P_VALUE = 13;
        public static final int WIFI_VALUE = 1;
        public static final int WIMAX_VALUE = 6;
        private static final Internal.EnumLiteMap<NetworkType> internalValueMap = new Internal.EnumLiteMap<NetworkType>() { // from class: com.google.firebase.perf.v1.NetworkConnectionInfo.NetworkType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public NetworkType findValueByNumber(int i) {
                return NetworkType.forNumber(i);
            }
        };
        private final int value;

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static NetworkType valueOf(int i) {
            return forNumber(i);
        }

        public static NetworkType forNumber(int i) {
            switch (i) {
                case -1:
                    return NONE;
                case 0:
                    return MOBILE;
                case 1:
                    return WIFI;
                case 2:
                    return MOBILE_MMS;
                case 3:
                    return MOBILE_SUPL;
                case 4:
                    return MOBILE_DUN;
                case 5:
                    return MOBILE_HIPRI;
                case 6:
                    return WIMAX;
                case 7:
                    return BLUETOOTH;
                case 8:
                    return DUMMY;
                case 9:
                    return ETHERNET;
                case 10:
                    return MOBILE_FOTA;
                case 11:
                    return MOBILE_IMS;
                case 12:
                    return MOBILE_CBS;
                case 13:
                    return WIFI_P2P;
                case 14:
                    return MOBILE_IA;
                case 15:
                    return MOBILE_EMERGENCY;
                case 16:
                    return PROXY;
                case 17:
                    return VPN;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<NetworkType> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return NetworkTypeVerifier.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes7.dex */
        public static final class NetworkTypeVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new NetworkTypeVerifier();

            private NetworkTypeVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public final boolean isInRange(int i) {
                return NetworkType.forNumber(i) != null;
            }
        }

        NetworkType(int i) {
            this.value = i;
        }
    }

    /* loaded from: classes7.dex */
    public enum MobileSubtype implements Internal.EnumLite {
        UNKNOWN_MOBILE_SUBTYPE(0),
        GPRS(1),
        EDGE(2),
        UMTS(3),
        CDMA(4),
        EVDO_0(5),
        EVDO_A(6),
        RTT(7),
        HSDPA(8),
        HSUPA(9),
        HSPA(10),
        IDEN(11),
        EVDO_B(12),
        LTE(13),
        EHRPD(14),
        HSPAP(15),
        GSM(16),
        TD_SCDMA(17),
        IWLAN(18),
        LTE_CA(19),
        COMBINED(100);

        public static final int CDMA_VALUE = 4;
        public static final int COMBINED_VALUE = 100;
        public static final int EDGE_VALUE = 2;
        public static final int EHRPD_VALUE = 14;
        public static final int EVDO_0_VALUE = 5;
        public static final int EVDO_A_VALUE = 6;
        public static final int EVDO_B_VALUE = 12;
        public static final int GPRS_VALUE = 1;
        public static final int GSM_VALUE = 16;
        public static final int HSDPA_VALUE = 8;
        public static final int HSPAP_VALUE = 15;
        public static final int HSPA_VALUE = 10;
        public static final int HSUPA_VALUE = 9;
        public static final int IDEN_VALUE = 11;
        public static final int IWLAN_VALUE = 18;
        public static final int LTE_CA_VALUE = 19;
        public static final int LTE_VALUE = 13;
        public static final int RTT_VALUE = 7;
        public static final int TD_SCDMA_VALUE = 17;
        public static final int UMTS_VALUE = 3;
        public static final int UNKNOWN_MOBILE_SUBTYPE_VALUE = 0;
        private static final Internal.EnumLiteMap<MobileSubtype> internalValueMap = new Internal.EnumLiteMap<MobileSubtype>() { // from class: com.google.firebase.perf.v1.NetworkConnectionInfo.MobileSubtype.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public MobileSubtype findValueByNumber(int i) {
                return MobileSubtype.forNumber(i);
            }
        };
        private final int value;

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static MobileSubtype valueOf(int i) {
            return forNumber(i);
        }

        public static MobileSubtype forNumber(int i) {
            if (i != 100) {
                switch (i) {
                    case 0:
                        return UNKNOWN_MOBILE_SUBTYPE;
                    case 1:
                        return GPRS;
                    case 2:
                        return EDGE;
                    case 3:
                        return UMTS;
                    case 4:
                        return CDMA;
                    case 5:
                        return EVDO_0;
                    case 6:
                        return EVDO_A;
                    case 7:
                        return RTT;
                    case 8:
                        return HSDPA;
                    case 9:
                        return HSUPA;
                    case 10:
                        return HSPA;
                    case 11:
                        return IDEN;
                    case 12:
                        return EVDO_B;
                    case 13:
                        return LTE;
                    case 14:
                        return EHRPD;
                    case 15:
                        return HSPAP;
                    case 16:
                        return GSM;
                    case 17:
                        return TD_SCDMA;
                    case 18:
                        return IWLAN;
                    case 19:
                        return LTE_CA;
                    default:
                        return null;
                }
            }
            return COMBINED;
        }

        public static Internal.EnumLiteMap<MobileSubtype> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return MobileSubtypeVerifier.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes7.dex */
        public static final class MobileSubtypeVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new MobileSubtypeVerifier();

            private MobileSubtypeVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public final boolean isInRange(int i) {
                return MobileSubtype.forNumber(i) != null;
            }
        }

        MobileSubtype(int i) {
            this.value = i;
        }
    }

    @Override // com.google.firebase.perf.v1.NetworkConnectionInfoOrBuilder
    public final boolean hasNetworkType() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.firebase.perf.v1.NetworkConnectionInfoOrBuilder
    public final NetworkType getNetworkType() {
        NetworkType forNumber = NetworkType.forNumber(this.networkType_);
        return forNumber == null ? NetworkType.NONE : forNumber;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNetworkType(NetworkType networkType) {
        this.networkType_ = networkType.getNumber();
        this.bitField0_ |= 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNetworkType() {
        this.bitField0_ &= -2;
        this.networkType_ = -1;
    }

    @Override // com.google.firebase.perf.v1.NetworkConnectionInfoOrBuilder
    public final boolean hasMobileSubtype() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // com.google.firebase.perf.v1.NetworkConnectionInfoOrBuilder
    public final MobileSubtype getMobileSubtype() {
        MobileSubtype forNumber = MobileSubtype.forNumber(this.mobileSubtype_);
        return forNumber == null ? MobileSubtype.UNKNOWN_MOBILE_SUBTYPE : forNumber;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMobileSubtype(MobileSubtype mobileSubtype) {
        this.mobileSubtype_ = mobileSubtype.getNumber();
        this.bitField0_ |= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMobileSubtype() {
        this.bitField0_ &= -3;
        this.mobileSubtype_ = 0;
    }

    public static NetworkConnectionInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (NetworkConnectionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static NetworkConnectionInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (NetworkConnectionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static NetworkConnectionInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (NetworkConnectionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static NetworkConnectionInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (NetworkConnectionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static NetworkConnectionInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (NetworkConnectionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static NetworkConnectionInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (NetworkConnectionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static NetworkConnectionInfo parseFrom(InputStream inputStream) throws IOException {
        return (NetworkConnectionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NetworkConnectionInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (NetworkConnectionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NetworkConnectionInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (NetworkConnectionInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static NetworkConnectionInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (NetworkConnectionInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NetworkConnectionInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (NetworkConnectionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static NetworkConnectionInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (NetworkConnectionInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static Builder newBuilder(NetworkConnectionInfo networkConnectionInfo) {
        return DEFAULT_INSTANCE.createBuilder(networkConnectionInfo);
    }

    /* loaded from: classes7.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<NetworkConnectionInfo, Builder> implements NetworkConnectionInfoOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
            super(NetworkConnectionInfo.DEFAULT_INSTANCE);
        }

        @Override // com.google.firebase.perf.v1.NetworkConnectionInfoOrBuilder
        public final boolean hasNetworkType() {
            return ((NetworkConnectionInfo) this.instance).hasNetworkType();
        }

        @Override // com.google.firebase.perf.v1.NetworkConnectionInfoOrBuilder
        public final NetworkType getNetworkType() {
            return ((NetworkConnectionInfo) this.instance).getNetworkType();
        }

        public final Builder setNetworkType(NetworkType networkType) {
            copyOnWrite();
            ((NetworkConnectionInfo) this.instance).setNetworkType(networkType);
            return this;
        }

        public final Builder clearNetworkType() {
            copyOnWrite();
            ((NetworkConnectionInfo) this.instance).clearNetworkType();
            return this;
        }

        @Override // com.google.firebase.perf.v1.NetworkConnectionInfoOrBuilder
        public final boolean hasMobileSubtype() {
            return ((NetworkConnectionInfo) this.instance).hasMobileSubtype();
        }

        @Override // com.google.firebase.perf.v1.NetworkConnectionInfoOrBuilder
        public final MobileSubtype getMobileSubtype() {
            return ((NetworkConnectionInfo) this.instance).getMobileSubtype();
        }

        public final Builder setMobileSubtype(MobileSubtype mobileSubtype) {
            copyOnWrite();
            ((NetworkConnectionInfo) this.instance).setMobileSubtype(mobileSubtype);
            return this;
        }

        public final Builder clearMobileSubtype() {
            copyOnWrite();
            ((NetworkConnectionInfo) this.instance).clearMobileSubtype();
            return this;
        }
    }

    /* renamed from: com.google.firebase.perf.v1.NetworkConnectionInfo$1  reason: invalid class name */
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
                return new NetworkConnectionInfo();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001", new Object[]{"bitField0_", "networkType_", NetworkType.internalGetVerifier(), "mobileSubtype_", MobileSubtype.internalGetVerifier()});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<NetworkConnectionInfo> parser2 = PARSER;
                if (parser2 == null) {
                    synchronized (NetworkConnectionInfo.class) {
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
        NetworkConnectionInfo networkConnectionInfo = new NetworkConnectionInfo();
        DEFAULT_INSTANCE = networkConnectionInfo;
        GeneratedMessageLite.registerDefaultInstance(NetworkConnectionInfo.class, networkConnectionInfo);
    }

    public static NetworkConnectionInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Parser<NetworkConnectionInfo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }
}
