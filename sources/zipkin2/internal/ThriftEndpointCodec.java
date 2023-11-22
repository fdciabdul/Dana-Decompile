package zipkin2.internal;

import java.util.Locale;
import kotlin.UShort;
import zipkin2.Endpoint;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class ThriftEndpointCodec {
    static final byte[] MyBillsEntityDataFactory = {0, 0, 0, 0};
    static final ThriftField KClassImpl$Data$declaredNonStaticMembers$2 = new ThriftField((byte) 8, 1);
    static final ThriftField BuiltInFictitiousFunctionClassFactory = new ThriftField((byte) 6, 2);
    static final ThriftField PlaceComponentResult = new ThriftField((byte) 11, 3);
    static final ThriftField getAuthRequestContext = new ThriftField((byte) 11, 4);

    ThriftEndpointCodec() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Endpoint BuiltInFictitiousFunctionClassFactory(ReadBuffer readBuffer) {
        Endpoint.Builder newBuilder = Endpoint.newBuilder();
        while (true) {
            ThriftField KClassImpl$Data$declaredNonStaticMembers$22 = ThriftField.KClassImpl$Data$declaredNonStaticMembers$2(readBuffer);
            if (KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult != 0) {
                if (KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2)) {
                    int authRequestContext = readBuffer.getAuthRequestContext();
                    if (authRequestContext != 0) {
                        newBuilder.PlaceComponentResult(new byte[]{(byte) ((authRequestContext >> 24) & 255), (byte) ((authRequestContext >> 16) & 255), (byte) ((authRequestContext >> 8) & 255), (byte) (authRequestContext & 255)});
                    }
                } else if (KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory)) {
                    newBuilder.KClassImpl$Data$declaredNonStaticMembers$2(readBuffer.NetworkUserEntityData$$ExternalSyntheticLambda0() & UShort.MAX_VALUE);
                } else if (KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult)) {
                    String MyBillsEntityDataFactory2 = readBuffer.MyBillsEntityDataFactory(readBuffer.getAuthRequestContext());
                    newBuilder.lookAheadTest = (MyBillsEntityDataFactory2 == null || MyBillsEntityDataFactory2.isEmpty()) ? null : MyBillsEntityDataFactory2.toLowerCase(Locale.ROOT);
                } else if (KClassImpl$Data$declaredNonStaticMembers$22.BuiltInFictitiousFunctionClassFactory(getAuthRequestContext)) {
                    newBuilder.PlaceComponentResult(readBuffer.getAuthRequestContext(readBuffer.getAuthRequestContext()));
                } else {
                    ThriftCodec.BuiltInFictitiousFunctionClassFactory(readBuffer, KClassImpl$Data$declaredNonStaticMembers$22.PlaceComponentResult);
                }
            } else {
                return new Endpoint(newBuilder);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getAuthRequestContext(Endpoint endpoint) {
        String serviceName = endpoint.serviceName();
        int BuiltInFictitiousFunctionClassFactory2 = (serviceName != null ? WriteBuffer.BuiltInFictitiousFunctionClassFactory(serviceName) : 0) + 7 + 12;
        if (endpoint.ipv6() != null) {
            BuiltInFictitiousFunctionClassFactory2 += 23;
        }
        return BuiltInFictitiousFunctionClassFactory2 + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void BuiltInFictitiousFunctionClassFactory(Endpoint endpoint, WriteBuffer writeBuffer) {
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(writeBuffer);
        byte[] ipv4Bytes = endpoint.ipv4Bytes() != null ? endpoint.ipv4Bytes() : MyBillsEntityDataFactory;
        System.arraycopy(ipv4Bytes, 0, writeBuffer.PlaceComponentResult, writeBuffer.MyBillsEntityDataFactory, ipv4Bytes.length);
        writeBuffer.MyBillsEntityDataFactory += ipv4Bytes.length;
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(writeBuffer);
        int portAsInt = endpoint.portAsInt();
        byte[] bArr = writeBuffer.PlaceComponentResult;
        int i = writeBuffer.MyBillsEntityDataFactory;
        writeBuffer.MyBillsEntityDataFactory = i + 1;
        bArr[i] = (byte) ((portAsInt >>> 8) & 255 & 255);
        byte[] bArr2 = writeBuffer.PlaceComponentResult;
        int i2 = writeBuffer.MyBillsEntityDataFactory;
        writeBuffer.MyBillsEntityDataFactory = i2 + 1;
        bArr2[i2] = (byte) (portAsInt & 255 & 255);
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(writeBuffer);
        ThriftCodec.MyBillsEntityDataFactory(writeBuffer, endpoint.serviceName() != null ? endpoint.serviceName() : "");
        byte[] ipv6Bytes = endpoint.ipv6Bytes();
        if (ipv6Bytes != null) {
            getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(writeBuffer);
            ThriftCodec.KClassImpl$Data$declaredNonStaticMembers$2(writeBuffer, 16);
            System.arraycopy(ipv6Bytes, 0, writeBuffer.PlaceComponentResult, writeBuffer.MyBillsEntityDataFactory, ipv6Bytes.length);
            writeBuffer.MyBillsEntityDataFactory += ipv6Bytes.length;
        }
        byte[] bArr3 = writeBuffer.PlaceComponentResult;
        int i3 = writeBuffer.MyBillsEntityDataFactory;
        writeBuffer.MyBillsEntityDataFactory = i3 + 1;
        bArr3[i3] = 0;
    }
}
