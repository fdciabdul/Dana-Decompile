package zipkin2.internal;

import java.util.List;
import zipkin2.Endpoint;
import zipkin2.Span;
import zipkin2.internal.WriteBuffer;
import zipkin2.v1.V1Annotation;
import zipkin2.v1.V1BinaryAnnotation;
import zipkin2.v1.V1Span;
import zipkin2.v1.V2SpanConverter;

/* loaded from: classes6.dex */
public final class V1ThriftSpanWriter implements WriteBuffer.Writer<Span> {
    final V2SpanConverter initRecordTimeStamp = V2SpanConverter.BuiltInFictitiousFunctionClassFactory();
    static final ThriftField scheduleImpl = new ThriftField((byte) 10, 1);
    static final ThriftField NetworkUserEntityData$$ExternalSyntheticLambda1 = new ThriftField((byte) 10, 12);
    static final ThriftField getErrorConfigVersion = new ThriftField((byte) 11, 3);
    static final ThriftField lookAheadTest = new ThriftField((byte) 10, 4);
    static final ThriftField NetworkUserEntityData$$ExternalSyntheticLambda0 = new ThriftField((byte) 10, 5);
    static final ThriftField PlaceComponentResult = new ThriftField((byte) 15, 6);
    static final ThriftField getAuthRequestContext = new ThriftField((byte) 15, 8);
    static final ThriftField KClassImpl$Data$declaredNonStaticMembers$2 = new ThriftField((byte) 2, 9);
    static final ThriftField moveToNextValue = new ThriftField((byte) 10, 10);
    static final ThriftField MyBillsEntityDataFactory = new ThriftField((byte) 10, 11);
    static final byte[] BuiltInFictitiousFunctionClassFactory = new byte[0];

    public final String toString() {
        return "Span";
    }

    @Override // zipkin2.internal.WriteBuffer.Writer
    /* renamed from: MyBillsEntityDataFactory  reason: merged with bridge method [inline-methods] */
    public final int PlaceComponentResult(Span span) {
        int BuiltInFictitiousFunctionClassFactory2;
        V1Span authRequestContext = this.initRecordTimeStamp.getAuthRequestContext(span);
        int authRequestContext2 = span.localEndpoint() != null ? ThriftEndpointCodec.getAuthRequestContext(span.localEndpoint()) : 0;
        int i = authRequestContext.GetContactSyncConfig != 0 ? 22 : 11;
        if (authRequestContext.getErrorConfigVersion != 0) {
            i += 11;
        }
        int i2 = i + 11 + 7;
        if (span.name() != null) {
            i2 += WriteBuffer.BuiltInFictitiousFunctionClassFactory(span.name());
        }
        int i3 = i2 + 8;
        int size = authRequestContext.getAuthRequestContext.size();
        for (int i4 = 0; i4 < size; i4++) {
            i3 += ThriftAnnotationWriter.getAuthRequestContext(WriteBuffer.BuiltInFictitiousFunctionClassFactory(authRequestContext.getAuthRequestContext.get(i4).PlaceComponentResult), authRequestContext2);
        }
        int i5 = i3 + 8;
        int size2 = authRequestContext.MyBillsEntityDataFactory.size();
        for (int i6 = 0; i6 < size2; i6++) {
            V1BinaryAnnotation v1BinaryAnnotation = authRequestContext.MyBillsEntityDataFactory.get(i6);
            int BuiltInFictitiousFunctionClassFactory3 = WriteBuffer.BuiltInFictitiousFunctionClassFactory(v1BinaryAnnotation.BuiltInFictitiousFunctionClassFactory);
            if (v1BinaryAnnotation.getAuthRequestContext != null) {
                BuiltInFictitiousFunctionClassFactory2 = ThriftBinaryAnnotationWriter.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory3, WriteBuffer.BuiltInFictitiousFunctionClassFactory(v1BinaryAnnotation.getAuthRequestContext), authRequestContext2);
            } else {
                BuiltInFictitiousFunctionClassFactory2 = ThriftBinaryAnnotationWriter.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory3, 1, ThriftEndpointCodec.getAuthRequestContext(v1BinaryAnnotation.PlaceComponentResult));
            }
            i5 += BuiltInFictitiousFunctionClassFactory2;
        }
        if (authRequestContext.PlaceComponentResult != null) {
            i5 += 4;
        }
        if (authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0 != 0) {
            i5 += 11;
        }
        if (authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 != 0) {
            i5 += 11;
        }
        return i5 + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // zipkin2.internal.WriteBuffer.Writer
    public void KClassImpl$Data$declaredNonStaticMembers$2(Span span, WriteBuffer writeBuffer) {
        V1Span authRequestContext = this.initRecordTimeStamp.getAuthRequestContext(span);
        byte[] BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(span.localEndpoint());
        scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2(writeBuffer);
        ThriftCodec.PlaceComponentResult(writeBuffer, authRequestContext.scheduleImpl);
        getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2(writeBuffer);
        ThriftCodec.MyBillsEntityDataFactory(writeBuffer, span.name() != null ? span.name() : "");
        lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2(writeBuffer);
        ThriftCodec.PlaceComponentResult(writeBuffer, authRequestContext.moveToNextValue);
        if (authRequestContext.getErrorConfigVersion != 0) {
            NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2(writeBuffer);
            ThriftCodec.PlaceComponentResult(writeBuffer, authRequestContext.getErrorConfigVersion);
        }
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(writeBuffer);
        PlaceComponentResult(writeBuffer, authRequestContext, BuiltInFictitiousFunctionClassFactory2);
        getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(writeBuffer);
        KClassImpl$Data$declaredNonStaticMembers$2(writeBuffer, authRequestContext, BuiltInFictitiousFunctionClassFactory2);
        if (authRequestContext.PlaceComponentResult != null) {
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(writeBuffer);
            boolean booleanValue = authRequestContext.PlaceComponentResult.booleanValue();
            byte[] bArr = writeBuffer.PlaceComponentResult;
            int i = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i + 1;
            bArr[i] = (byte) (booleanValue & 255);
        }
        if (authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0 != 0) {
            moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2(writeBuffer);
            ThriftCodec.PlaceComponentResult(writeBuffer, authRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda0);
        }
        if (authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 != 0) {
            MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(writeBuffer);
            ThriftCodec.PlaceComponentResult(writeBuffer, authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        if (authRequestContext.GetContactSyncConfig != 0) {
            NetworkUserEntityData$$ExternalSyntheticLambda1.KClassImpl$Data$declaredNonStaticMembers$2(writeBuffer);
            ThriftCodec.PlaceComponentResult(writeBuffer, authRequestContext.GetContactSyncConfig);
        }
        byte[] bArr2 = writeBuffer.PlaceComponentResult;
        int i2 = writeBuffer.MyBillsEntityDataFactory;
        writeBuffer.MyBillsEntityDataFactory = i2 + 1;
        bArr2[i2] = 0;
    }

    public final byte[] KClassImpl$Data$declaredNonStaticMembers$2(List<Span> list) {
        if (list.size() == 0) {
            return BuiltInFictitiousFunctionClassFactory;
        }
        byte[] bArr = new byte[ThriftCodec.MyBillsEntityDataFactory(this, list)];
        ThriftCodec.BuiltInFictitiousFunctionClassFactory(this, list, WriteBuffer.getAuthRequestContext(bArr));
        return bArr;
    }

    /* renamed from: PlaceComponentResult  reason: avoid collision after fix types in other method */
    public final byte[] PlaceComponentResult2(Span span) {
        byte[] bArr = new byte[PlaceComponentResult(span)];
        KClassImpl$Data$declaredNonStaticMembers$2(span, WriteBuffer.getAuthRequestContext(bArr));
        return bArr;
    }

    private static byte[] BuiltInFictitiousFunctionClassFactory(@Nullable Endpoint endpoint) {
        if (endpoint == null) {
            return null;
        }
        byte[] bArr = new byte[ThriftEndpointCodec.getAuthRequestContext(endpoint)];
        ThriftEndpointCodec.BuiltInFictitiousFunctionClassFactory(endpoint, WriteBuffer.getAuthRequestContext(bArr));
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class ThriftAnnotationWriter {
        static final ThriftField BuiltInFictitiousFunctionClassFactory = new ThriftField((byte) 10, 1);
        static final ThriftField getAuthRequestContext = new ThriftField((byte) 11, 2);
        static final ThriftField KClassImpl$Data$declaredNonStaticMembers$2 = new ThriftField((byte) 12, 3);

        static int getAuthRequestContext(int i, int i2) {
            int i3 = i + 7 + 11;
            if (i2 > 0) {
                i3 += i2 + 3;
            }
            return i3 + 1;
        }

        ThriftAnnotationWriter() {
        }

        static void PlaceComponentResult(long j, String str, byte[] bArr, WriteBuffer writeBuffer) {
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(writeBuffer);
            ThriftCodec.PlaceComponentResult(writeBuffer, j);
            getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(writeBuffer);
            ThriftCodec.MyBillsEntityDataFactory(writeBuffer, str);
            if (bArr != null) {
                KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(writeBuffer);
                System.arraycopy(bArr, 0, writeBuffer.PlaceComponentResult, writeBuffer.MyBillsEntityDataFactory, bArr.length);
                writeBuffer.MyBillsEntityDataFactory += bArr.length;
            }
            byte[] bArr2 = writeBuffer.PlaceComponentResult;
            int i = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i + 1;
            bArr2[i] = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class ThriftBinaryAnnotationWriter {
        static final ThriftField BuiltInFictitiousFunctionClassFactory = new ThriftField((byte) 11, 1);
        static final ThriftField MyBillsEntityDataFactory = new ThriftField((byte) 11, 2);
        static final ThriftField KClassImpl$Data$declaredNonStaticMembers$2 = new ThriftField((byte) 8, 3);
        static final ThriftField getAuthRequestContext = new ThriftField((byte) 12, 4);

        static int BuiltInFictitiousFunctionClassFactory(int i, int i2, int i3) {
            int i4 = i + 7 + 0 + i2 + 7 + 7;
            if (i3 > 0) {
                i4 += i3 + 3;
            }
            return i4 + 1;
        }

        ThriftBinaryAnnotationWriter() {
        }

        static void MyBillsEntityDataFactory(String str, String str2, byte[] bArr, WriteBuffer writeBuffer) {
            int i;
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(writeBuffer);
            ThriftCodec.MyBillsEntityDataFactory(writeBuffer, str);
            MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(writeBuffer);
            if (str2 != null) {
                i = 6;
                ThriftCodec.KClassImpl$Data$declaredNonStaticMembers$2(writeBuffer, WriteBuffer.BuiltInFictitiousFunctionClassFactory(str2));
                writeBuffer.getAuthRequestContext(str2);
            } else {
                ThriftCodec.KClassImpl$Data$declaredNonStaticMembers$2(writeBuffer, 1);
                byte[] bArr2 = writeBuffer.PlaceComponentResult;
                int i2 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i2 + 1;
                bArr2[i2] = 1;
                i = 0;
            }
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(writeBuffer);
            ThriftCodec.KClassImpl$Data$declaredNonStaticMembers$2(writeBuffer, i);
            if (bArr != null) {
                getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(writeBuffer);
                System.arraycopy(bArr, 0, writeBuffer.PlaceComponentResult, writeBuffer.MyBillsEntityDataFactory, bArr.length);
                writeBuffer.MyBillsEntityDataFactory += bArr.length;
            }
            byte[] bArr3 = writeBuffer.PlaceComponentResult;
            int i3 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i3 + 1;
            bArr3[i3] = 0;
        }
    }

    private static void PlaceComponentResult(WriteBuffer writeBuffer, V1Span v1Span, byte[] bArr) {
        int size = v1Span.getAuthRequestContext.size();
        ThriftCodec.PlaceComponentResult(writeBuffer, size);
        for (int i = 0; i < size; i++) {
            V1Annotation v1Annotation = v1Span.getAuthRequestContext.get(i);
            ThriftAnnotationWriter.PlaceComponentResult(v1Annotation.getAuthRequestContext, v1Annotation.PlaceComponentResult, bArr, writeBuffer);
        }
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(WriteBuffer writeBuffer, V1Span v1Span, byte[] bArr) {
        int size = v1Span.MyBillsEntityDataFactory.size();
        ThriftCodec.PlaceComponentResult(writeBuffer, size);
        for (int i = 0; i < size; i++) {
            V1BinaryAnnotation v1BinaryAnnotation = v1Span.MyBillsEntityDataFactory.get(i);
            ThriftBinaryAnnotationWriter.MyBillsEntityDataFactory(v1BinaryAnnotation.BuiltInFictitiousFunctionClassFactory, v1BinaryAnnotation.getAuthRequestContext, v1BinaryAnnotation.getAuthRequestContext != null ? bArr : BuiltInFictitiousFunctionClassFactory(v1BinaryAnnotation.PlaceComponentResult), writeBuffer);
        }
    }
}
