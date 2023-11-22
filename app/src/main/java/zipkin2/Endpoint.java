package zipkin2;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import zipkin2.internal.HexCodec;
import zipkin2.internal.Nullable;
import zipkin2.internal.RecyclableBuffers;

/* loaded from: classes6.dex */
public final class Endpoint implements Serializable {
    static final int IPV6_PART_COUNT = 8;
    private static final long serialVersionUID = 0;
    final String ipv4;
    final byte[] ipv4Bytes;
    final String ipv6;
    final byte[] ipv6Bytes;
    final int port;
    final String serviceName;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public enum IpFamily {
        Unknown,
        IPv4,
        IPv4Embedded,
        IPv6
    }

    static boolean isValidNumericChar(char c) {
        return c >= '0' && c <= '9';
    }

    static boolean notHex(char c) {
        return (c < '0' || c > '9') && (c < 'a' || c > 'f') && (c < 'A' || c > 'F');
    }

    @Nullable
    public final String serviceName() {
        return this.serviceName;
    }

    @Nullable
    public final String ipv4() {
        return this.ipv4;
    }

    @Nullable
    public final byte[] ipv4Bytes() {
        return this.ipv4Bytes;
    }

    @Nullable
    public final String ipv6() {
        return this.ipv6;
    }

    @Nullable
    public final byte[] ipv6Bytes() {
        return this.ipv6Bytes;
    }

    @Nullable
    public final Integer port() {
        int i = this.port;
        if (i != 0) {
            return Integer.valueOf(i);
        }
        return null;
    }

    public final int portAsInt() {
        return this.port;
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    /* loaded from: classes6.dex */
    public static final class Builder {
        String BuiltInFictitiousFunctionClassFactory;
        int KClassImpl$Data$declaredNonStaticMembers$2;
        byte[] MyBillsEntityDataFactory;
        byte[] PlaceComponentResult;
        String getAuthRequestContext;
        public String lookAheadTest;

        Builder(Endpoint endpoint) {
            this.lookAheadTest = endpoint.serviceName;
            this.BuiltInFictitiousFunctionClassFactory = endpoint.ipv4;
            this.getAuthRequestContext = endpoint.ipv6;
            this.MyBillsEntityDataFactory = endpoint.ipv4Bytes;
            this.PlaceComponentResult = endpoint.ipv6Bytes;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = endpoint.port;
        }

        public final boolean PlaceComponentResult(@Nullable InetAddress inetAddress) {
            if (inetAddress == null) {
                return false;
            }
            if (inetAddress instanceof Inet4Address) {
                this.BuiltInFictitiousFunctionClassFactory = inetAddress.getHostAddress();
                this.MyBillsEntityDataFactory = inetAddress.getAddress();
                return true;
            } else if (inetAddress instanceof Inet6Address) {
                byte[] address = inetAddress.getAddress();
                if (MyBillsEntityDataFactory(address)) {
                    return true;
                }
                this.getAuthRequestContext = Endpoint.writeIpV6(address);
                this.PlaceComponentResult = address;
                return true;
            } else {
                return false;
            }
        }

        public final boolean PlaceComponentResult(byte[] bArr) {
            if (bArr == null) {
                return false;
            }
            if (bArr.length == 4) {
                this.MyBillsEntityDataFactory = bArr;
                char[] BuiltInFictitiousFunctionClassFactory = RecyclableBuffers.BuiltInFictitiousFunctionClassFactory();
                int PlaceComponentResult = PlaceComponentResult(bArr[0] & 255, 0, BuiltInFictitiousFunctionClassFactory);
                BuiltInFictitiousFunctionClassFactory[PlaceComponentResult] = '.';
                int PlaceComponentResult2 = PlaceComponentResult(bArr[1] & 255, PlaceComponentResult + 1, BuiltInFictitiousFunctionClassFactory);
                BuiltInFictitiousFunctionClassFactory[PlaceComponentResult2] = '.';
                int PlaceComponentResult3 = PlaceComponentResult(bArr[2] & 255, PlaceComponentResult2 + 1, BuiltInFictitiousFunctionClassFactory);
                BuiltInFictitiousFunctionClassFactory[PlaceComponentResult3] = '.';
                this.BuiltInFictitiousFunctionClassFactory = new String(BuiltInFictitiousFunctionClassFactory, 0, PlaceComponentResult(bArr[3] & 255, PlaceComponentResult3 + 1, BuiltInFictitiousFunctionClassFactory));
            } else if (bArr.length != 16) {
                return false;
            } else {
                if (!MyBillsEntityDataFactory(bArr)) {
                    this.getAuthRequestContext = Endpoint.writeIpV6(bArr);
                    this.PlaceComponentResult = bArr;
                }
            }
            return true;
        }

        private static int PlaceComponentResult(int i, int i2, char[] cArr) {
            if (i < 10) {
                cArr[i2] = HexCodec.BuiltInFictitiousFunctionClassFactory[i];
                return i2 + 1;
            }
            int i3 = i2 + (i < 100 ? 2 : 3);
            int i4 = i3;
            while (i != 0) {
                i4--;
                cArr[i4] = HexCodec.BuiltInFictitiousFunctionClassFactory[i % 10];
                i /= 10;
            }
            return i3;
        }

        public final boolean BuiltInFictitiousFunctionClassFactory(@Nullable String str) {
            byte[] textToNumericFormatV6;
            if (str != null && !str.isEmpty()) {
                IpFamily detectFamily = Endpoint.detectFamily(str);
                if (detectFamily == IpFamily.IPv4) {
                    this.BuiltInFictitiousFunctionClassFactory = str;
                    this.MyBillsEntityDataFactory = Endpoint.getIpv4Bytes(str);
                } else if (detectFamily == IpFamily.IPv4Embedded) {
                    String substring = str.substring(str.lastIndexOf(58) + 1);
                    this.BuiltInFictitiousFunctionClassFactory = substring;
                    this.MyBillsEntityDataFactory = Endpoint.getIpv4Bytes(substring);
                } else if (detectFamily != IpFamily.IPv6 || (textToNumericFormatV6 = Endpoint.textToNumericFormatV6(str)) == null) {
                    return false;
                } else {
                    this.getAuthRequestContext = Endpoint.writeIpV6(textToNumericFormatV6);
                    this.PlaceComponentResult = textToNumericFormatV6;
                }
                return true;
            }
            return false;
        }

        public final Builder KClassImpl$Data$declaredNonStaticMembers$2(int i) {
            if (i > 65535) {
                StringBuilder sb = new StringBuilder();
                sb.append("invalid port ");
                sb.append(i);
                throw new IllegalArgumentException(sb.toString());
            }
            if (i < 0) {
                i = 0;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
            return this;
        }

        Builder() {
        }

        private boolean MyBillsEntityDataFactory(byte[] bArr) {
            for (int i = 0; i < 10; i++) {
                if (bArr[i] != 0) {
                    return false;
                }
            }
            if ((((bArr[10] & 255) << 8) | (bArr[11] & 255)) != 0) {
                return false;
            }
            byte b = bArr[12];
            byte b2 = bArr[13];
            byte b3 = bArr[14];
            byte b4 = bArr[15];
            if (b == 0 && b2 == 0 && b3 == 0 && b4 == 1) {
                return false;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(b & 255));
            sb.append('.');
            sb.append(b2 & 255);
            sb.append('.');
            sb.append(b3 & 255);
            sb.append('.');
            sb.append(b4 & 255);
            this.BuiltInFictitiousFunctionClassFactory = sb.toString();
            this.MyBillsEntityDataFactory = new byte[]{b, b2, b3, b4};
            return true;
        }
    }

    static IpFamily detectFamily(String str) {
        int length = str.length();
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '.') {
                z2 = true;
            } else if (charAt == ':') {
                if (z2) {
                    return IpFamily.Unknown;
                }
                z = true;
            } else if (notHex(charAt)) {
                return IpFamily.Unknown;
            }
        }
        if (!z) {
            if (z2 && isValidIpV4Address(str, 0, str.length())) {
                return IpFamily.IPv4;
            }
            return IpFamily.Unknown;
        } else if (z2) {
            int lastIndexOf = str.lastIndexOf(58);
            if (!isValidIpV4Address(str, lastIndexOf + 1, str.length())) {
                return IpFamily.Unknown;
            }
            if (lastIndexOf == 1 && str.charAt(0) == ':') {
                return IpFamily.IPv4Embedded;
            }
            if (lastIndexOf != 6 || str.charAt(0) != ':' || str.charAt(1) != ':') {
                return IpFamily.Unknown;
            }
            for (int i2 = 2; i2 < 6; i2++) {
                char charAt2 = str.charAt(i2);
                if (charAt2 != 'f' && charAt2 != 'F' && charAt2 != '0') {
                    return IpFamily.Unknown;
                }
            }
            return IpFamily.IPv4Embedded;
        } else {
            return IpFamily.IPv6;
        }
    }

    static String writeIpV6(byte[] bArr) {
        char[] BuiltInFictitiousFunctionClassFactory = RecyclableBuffers.BuiltInFictitiousFunctionClassFactory();
        boolean z = true;
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < bArr.length; i4 += 2) {
            if (bArr[i4] == 0 && bArr[i4 + 1] == 0) {
                if (i3 < 0) {
                    i3 = i4;
                }
            } else if (i3 >= 0) {
                int i5 = i4 - i3;
                if (i5 > i2) {
                    i2 = i5;
                    i = i3;
                }
                z = false;
                i3 = -1;
            } else {
                z = false;
            }
        }
        if (z) {
            return "::";
        }
        if (i == -1 && i3 != -1) {
            i2 = 16 - i3;
            i = i3;
        }
        int i6 = 0;
        int i7 = 0;
        while (i6 < bArr.length) {
            if (i6 == i) {
                int i8 = i7 + 1;
                BuiltInFictitiousFunctionClassFactory[i7] = ':';
                i6 += i2;
                if (i6 == bArr.length) {
                    i7 = i8 + 1;
                    BuiltInFictitiousFunctionClassFactory[i8] = ':';
                } else {
                    i7 = i8;
                }
            } else {
                if (i6 != 0) {
                    BuiltInFictitiousFunctionClassFactory[i7] = ':';
                    i7++;
                }
                int i9 = i6 + 1;
                byte b = bArr[i6];
                byte b2 = bArr[i9];
                char c = HexCodec.BuiltInFictitiousFunctionClassFactory[(b >> 4) & 15];
                boolean z2 = c == '0';
                if (!z2) {
                    BuiltInFictitiousFunctionClassFactory[i7] = c;
                    i7++;
                }
                char c2 = HexCodec.BuiltInFictitiousFunctionClassFactory[b & 15];
                boolean z3 = z2 && c2 == '0';
                if (!z3) {
                    BuiltInFictitiousFunctionClassFactory[i7] = c2;
                    i7++;
                }
                char c3 = HexCodec.BuiltInFictitiousFunctionClassFactory[(b2 >> 4) & 15];
                if (!z3 || c3 != '0') {
                    BuiltInFictitiousFunctionClassFactory[i7] = c3;
                    i7++;
                }
                BuiltInFictitiousFunctionClassFactory[i7] = HexCodec.BuiltInFictitiousFunctionClassFactory[b2 & 15];
                i7++;
                i6 = i9 + 1;
            }
        }
        return new String(BuiltInFictitiousFunctionClassFactory, 0, i7);
    }

    @Nullable
    static byte[] textToNumericFormatV6(String str) {
        int length;
        int i;
        String[] split = str.split(":", 10);
        if (split.length < 3 || split.length > 9) {
            return null;
        }
        int i2 = -1;
        for (int i3 = 1; i3 < split.length - 1; i3++) {
            if (split[i3].length() == 0) {
                if (i2 >= 0) {
                    return null;
                }
                i2 = i3;
            }
        }
        if (i2 >= 0) {
            i = (split.length - i2) - 1;
            if (split[0].length() == 0) {
                length = i2 - 1;
                if (length != 0) {
                    return null;
                }
            } else {
                length = i2;
            }
            if (split[split.length - 1].length() == 0 && i - 1 != 0) {
                return null;
            }
        } else {
            length = split.length;
            i = 0;
        }
        int i4 = 8 - (length + i);
        if (i2 < 0 ? i4 == 0 : i4 > 0) {
            ByteBuffer allocate = ByteBuffer.allocate(16);
            for (int i5 = 0; i5 < length; i5++) {
                try {
                    allocate.putShort(parseHextet(split[i5]));
                } catch (NumberFormatException unused) {
                    return null;
                }
            }
            for (int i6 = 0; i6 < i4; i6++) {
                allocate.putShort((short) 0);
            }
            while (i > 0) {
                allocate.putShort(parseHextet(split[split.length - i]));
                i--;
            }
            return allocate.array();
        }
        return null;
    }

    static short parseHextet(String str) {
        int parseInt = Integer.parseInt(str, 16);
        if (parseInt <= 65535) {
            return (short) parseInt;
        }
        throw new NumberFormatException();
    }

    static boolean isValidIpV4Address(String str, int i, int i2) {
        int indexOf;
        int i3;
        int indexOf2;
        int i4;
        int indexOf3;
        int i5 = i2 - i;
        return i5 <= 15 && i5 >= 7 && (indexOf = str.indexOf(46, i + 1)) > 0 && isValidIpV4Word(str, i, indexOf) && (indexOf2 = str.indexOf(46, (i3 = indexOf + 2))) > 0 && isValidIpV4Word(str, i3 - 1, indexOf2) && (indexOf3 = str.indexOf(46, (i4 = indexOf2 + 2))) > 0 && isValidIpV4Word(str, i4 - 1, indexOf3) && isValidIpV4Word(str, indexOf3 + 1, i2);
    }

    static boolean isValidIpV4Word(CharSequence charSequence, int i, int i2) {
        char charAt;
        char charAt2;
        int i3 = i2 - i;
        if (i3 > 0 && i3 <= 3 && (charAt = charSequence.charAt(i)) >= '0') {
            if (i3 == 3) {
                char charAt3 = charSequence.charAt(i + 1);
                if (charAt3 >= '0' && (charAt2 = charSequence.charAt(i + 2)) >= '0') {
                    if (charAt <= '1' && charAt3 <= '9' && charAt2 <= '9') {
                        return true;
                    }
                    if (charAt == '2' && charAt3 <= '5') {
                        if (charAt2 <= '5') {
                            return true;
                        }
                        if (charAt3 < '5' && charAt2 <= '9') {
                            return true;
                        }
                    }
                }
                return false;
            } else if (charAt <= '9' && (i3 == 1 || isValidNumericChar(charSequence.charAt(i + 1)))) {
                return true;
            }
        }
        return false;
    }

    public Endpoint(Builder builder) {
        this.serviceName = builder.lookAheadTest;
        this.ipv4 = builder.BuiltInFictitiousFunctionClassFactory;
        this.ipv4Bytes = builder.MyBillsEntityDataFactory;
        this.ipv6 = builder.getAuthRequestContext;
        this.ipv6Bytes = builder.PlaceComponentResult;
        this.port = builder.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    Endpoint(SerializedForm serializedForm) {
        this.serviceName = serializedForm.serviceName;
        this.ipv4 = serializedForm.ipv4;
        this.ipv4Bytes = serializedForm.ipv4Bytes;
        this.ipv6 = serializedForm.ipv6;
        this.ipv6Bytes = serializedForm.ipv6Bytes;
        this.port = serializedForm.port;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Endpoint{serviceName=");
        sb.append(this.serviceName);
        sb.append(", ipv4=");
        sb.append(this.ipv4);
        sb.append(", ipv6=");
        sb.append(this.ipv6);
        sb.append(", port=");
        sb.append(this.port);
        sb.append("}");
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Endpoint) {
            Endpoint endpoint = (Endpoint) obj;
            String str = this.serviceName;
            if (str != null ? str.equals(endpoint.serviceName) : endpoint.serviceName == null) {
                String str2 = this.ipv4;
                if (str2 != null ? str2.equals(endpoint.ipv4) : endpoint.ipv4 == null) {
                    String str3 = this.ipv6;
                    if (str3 != null ? str3.equals(endpoint.ipv6) : endpoint.ipv6 == null) {
                        if (this.port == endpoint.port) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        String str = this.serviceName;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.ipv4;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.ipv6;
        return ((((((hashCode ^ 1000003) * 1000003) ^ hashCode2) * 1000003) ^ (str3 != null ? str3.hashCode() : 0)) * 1000003) ^ this.port;
    }

    final Object writeReplace() throws ObjectStreamException {
        return new SerializedForm(this);
    }

    /* loaded from: classes9.dex */
    static final class SerializedForm implements Serializable {
        static final long serialVersionUID = 0;
        final String ipv4;
        final byte[] ipv4Bytes;
        final String ipv6;
        final byte[] ipv6Bytes;
        final int port;
        final String serviceName;

        SerializedForm(Endpoint endpoint) {
            this.serviceName = endpoint.serviceName;
            this.ipv4 = endpoint.ipv4;
            this.ipv4Bytes = endpoint.ipv4Bytes;
            this.ipv6 = endpoint.ipv6;
            this.ipv6Bytes = endpoint.ipv6Bytes;
            this.port = endpoint.port;
        }

        final Object readResolve() throws ObjectStreamException {
            try {
                return new Endpoint(this);
            } catch (IllegalArgumentException e) {
                throw new StreamCorruptedException(e.getMessage());
            }
        }
    }

    static byte[] getIpv4Bytes(String str) {
        int i;
        byte[] bArr = new byte[4];
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = i2 + 1;
            int charAt = str.charAt(i2) - '0';
            if (i4 != length) {
                int i5 = i4 + 1;
                char charAt2 = str.charAt(i4);
                if (charAt2 != '.') {
                    int i6 = (charAt * 10) + (charAt2 - '0');
                    if (i5 != length) {
                        i4 = i5 + 1;
                        char charAt3 = str.charAt(i5);
                        if (charAt3 != '.') {
                            bArr[i3] = (byte) ((i6 * 10) + (charAt3 - '0'));
                            i2 = i4 + 1;
                            i3++;
                        }
                    } else {
                        i4 = i5;
                    }
                    i = i3 + 1;
                    bArr[i3] = (byte) i6;
                    i2 = i4;
                    i3 = i;
                } else {
                    i4 = i5;
                }
            }
            i = i3 + 1;
            bArr[i3] = (byte) charAt;
            i2 = i4;
            i3 = i;
        }
        return bArr;
    }
}
