package zipkin2.internal;

import zipkin2.Endpoint;
import zipkin2.internal.WriteBuffer;
import zipkin2.v1.V1Annotation;
import zipkin2.v1.V1BinaryAnnotation;
import zipkin2.v1.V1Span;

/* loaded from: classes6.dex */
public final class V1SpanWriter implements WriteBuffer.Writer<V1Span> {
    public final String toString() {
        return "Span";
    }

    @Override // zipkin2.internal.WriteBuffer.Writer
    public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(V1Span v1Span, WriteBuffer writeBuffer) {
        BuiltInFictitiousFunctionClassFactory(v1Span, writeBuffer);
    }

    @Override // zipkin2.internal.WriteBuffer.Writer
    public final /* synthetic */ int PlaceComponentResult(V1Span v1Span) {
        return KClassImpl$Data$declaredNonStaticMembers$2(v1Span);
    }

    private static byte[] MyBillsEntityDataFactory(@Nullable Endpoint endpoint) {
        if (endpoint == null) {
            return null;
        }
        byte[] bArr = new byte[V2SpanWriter.KClassImpl$Data$declaredNonStaticMembers$2(endpoint, true)];
        V2SpanWriter.MyBillsEntityDataFactory(endpoint, WriteBuffer.getAuthRequestContext(bArr), true);
        return bArr;
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2, @Nullable byte[] bArr, WriteBuffer writeBuffer) {
        for (int i = 0; i < 8; i++) {
            int charAt = "{\"key\":\"".charAt(i) & 255;
            byte[] bArr2 = writeBuffer.PlaceComponentResult;
            int i2 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i2 + 1;
            bArr2[i2] = (byte) (charAt & 255);
        }
        writeBuffer.getAuthRequestContext(JsonEscaper.PlaceComponentResult(str));
        for (int i3 = 0; i3 < 11; i3++) {
            int charAt2 = "\",\"value\":\"".charAt(i3) & 255;
            byte[] bArr3 = writeBuffer.PlaceComponentResult;
            int i4 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i4 + 1;
            bArr3[i4] = (byte) (charAt2 & 255);
        }
        writeBuffer.getAuthRequestContext(JsonEscaper.PlaceComponentResult(str2));
        byte[] bArr4 = writeBuffer.PlaceComponentResult;
        int i5 = writeBuffer.MyBillsEntityDataFactory;
        writeBuffer.MyBillsEntityDataFactory = i5 + 1;
        bArr4[i5] = 34;
        if (bArr != null) {
            for (int i6 = 0; i6 < 12; i6++) {
                int charAt3 = ",\"endpoint\":".charAt(i6) & 255;
                byte[] bArr5 = writeBuffer.PlaceComponentResult;
                int i7 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i7 + 1;
                bArr5[i7] = (byte) (charAt3 & 255);
            }
            System.arraycopy(bArr, 0, writeBuffer.PlaceComponentResult, writeBuffer.MyBillsEntityDataFactory, bArr.length);
            writeBuffer.MyBillsEntityDataFactory += bArr.length;
        }
        for (int i8 = 0; i8 < 1; i8++) {
            int charAt4 = "}".charAt(i8) & 255;
            byte[] bArr6 = writeBuffer.PlaceComponentResult;
            int i9 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i9 + 1;
            bArr6[i9] = (byte) (charAt4 & 255);
        }
    }

    public static int KClassImpl$Data$declaredNonStaticMembers$2(V1Span v1Span) {
        int i;
        int i2;
        int i3;
        int i4 = v1Span.GetContactSyncConfig != 0 ? 45 : 29;
        if (v1Span.getErrorConfigVersion != 0) {
            i4 += 30;
        }
        int i5 = i4 + 24 + 10;
        if (v1Span.lookAheadTest != null) {
            i5 += JsonEscaper.getAuthRequestContext(v1Span.lookAheadTest);
        }
        if (v1Span.NetworkUserEntityData$$ExternalSyntheticLambda0 != 0) {
            i5 = i5 + 13 + WriteBuffer.BuiltInFictitiousFunctionClassFactory(v1Span.NetworkUserEntityData$$ExternalSyntheticLambda0);
        }
        if (v1Span.KClassImpl$Data$declaredNonStaticMembers$2 != 0) {
            i5 = i5 + 12 + WriteBuffer.BuiltInFictitiousFunctionClassFactory(v1Span.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        int size = v1Span.getAuthRequestContext.size();
        Endpoint endpoint = null;
        if (size > 0) {
            i5 += 17;
            if (size > 1) {
                i5 += size - 1;
            }
            i = 0;
            int i6 = 0;
            while (i6 < size) {
                V1Annotation v1Annotation = v1Span.getAuthRequestContext.get(i6);
                Endpoint endpoint2 = v1Annotation.KClassImpl$Data$declaredNonStaticMembers$2;
                if (endpoint2 == null) {
                    i3 = i;
                    i = 0;
                } else {
                    if (!endpoint2.equals(endpoint)) {
                        i = V2SpanWriter.KClassImpl$Data$declaredNonStaticMembers$2(endpoint2, true);
                        endpoint = endpoint2;
                    }
                    i3 = i;
                }
                i5 += V2SpanWriter.BuiltInFictitiousFunctionClassFactory(v1Annotation.getAuthRequestContext, v1Annotation.PlaceComponentResult, i);
                i6++;
                i = i3;
            }
        } else {
            i = 0;
        }
        int size2 = v1Span.MyBillsEntityDataFactory.size();
        if (size2 > 0) {
            i5 += 23;
            if (size2 > 1) {
                i5 += size2 - 1;
            }
            int i7 = 0;
            while (i7 < size2) {
                V1BinaryAnnotation v1BinaryAnnotation = v1Span.MyBillsEntityDataFactory.get(i7);
                Endpoint endpoint3 = v1BinaryAnnotation.PlaceComponentResult;
                if (endpoint3 == null) {
                    i2 = i;
                    i = 0;
                } else {
                    if (!endpoint3.equals(endpoint)) {
                        i = V2SpanWriter.KClassImpl$Data$declaredNonStaticMembers$2(endpoint3, true);
                        endpoint = endpoint3;
                    }
                    i2 = i;
                }
                if (v1BinaryAnnotation.getAuthRequestContext != null) {
                    int authRequestContext = JsonEscaper.getAuthRequestContext(v1BinaryAnnotation.BuiltInFictitiousFunctionClassFactory) + 21 + JsonEscaper.getAuthRequestContext(v1BinaryAnnotation.getAuthRequestContext);
                    if (i != 0) {
                        authRequestContext = authRequestContext + 12 + i;
                    }
                    i5 += authRequestContext;
                } else {
                    i5 = i5 + 37 + i;
                }
                i7++;
                i = i2;
            }
        }
        if (Boolean.TRUE.equals(v1Span.PlaceComponentResult)) {
            i5 += 13;
        }
        return i5 + 1;
    }

    public static void BuiltInFictitiousFunctionClassFactory(V1Span v1Span, WriteBuffer writeBuffer) {
        Endpoint endpoint;
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        for (int i = 0; i < 12; i++) {
            int charAt = "{\"traceId\":\"".charAt(i) & 255;
            byte[] bArr4 = writeBuffer.PlaceComponentResult;
            int i2 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i2 + 1;
            bArr4[i2] = (byte) (charAt & 255);
        }
        if (v1Span.GetContactSyncConfig != 0) {
            writeBuffer.getAuthRequestContext(v1Span.GetContactSyncConfig);
        }
        writeBuffer.getAuthRequestContext(v1Span.scheduleImpl);
        byte[] bArr5 = writeBuffer.PlaceComponentResult;
        int i3 = writeBuffer.MyBillsEntityDataFactory;
        writeBuffer.MyBillsEntityDataFactory = i3 + 1;
        bArr5[i3] = 34;
        if (v1Span.getErrorConfigVersion != 0) {
            for (int i4 = 0; i4 < 13; i4++) {
                int charAt2 = ",\"parentId\":\"".charAt(i4) & 255;
                byte[] bArr6 = writeBuffer.PlaceComponentResult;
                int i5 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i5 + 1;
                bArr6[i5] = (byte) (charAt2 & 255);
            }
            writeBuffer.getAuthRequestContext(v1Span.getErrorConfigVersion);
            byte[] bArr7 = writeBuffer.PlaceComponentResult;
            int i6 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i6 + 1;
            bArr7[i6] = 34;
        }
        for (int i7 = 0; i7 < 7; i7++) {
            int charAt3 = ",\"id\":\"".charAt(i7) & 255;
            byte[] bArr8 = writeBuffer.PlaceComponentResult;
            int i8 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i8 + 1;
            bArr8[i8] = (byte) (charAt3 & 255);
        }
        writeBuffer.getAuthRequestContext(v1Span.moveToNextValue);
        byte[] bArr9 = writeBuffer.PlaceComponentResult;
        int i9 = writeBuffer.MyBillsEntityDataFactory;
        writeBuffer.MyBillsEntityDataFactory = i9 + 1;
        bArr9[i9] = 34;
        for (int i10 = 0; i10 < 9; i10++) {
            int charAt4 = ",\"name\":\"".charAt(i10) & 255;
            byte[] bArr10 = writeBuffer.PlaceComponentResult;
            int i11 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i11 + 1;
            bArr10[i11] = (byte) (charAt4 & 255);
        }
        if (v1Span.lookAheadTest != null) {
            writeBuffer.getAuthRequestContext(JsonEscaper.PlaceComponentResult(v1Span.lookAheadTest));
        }
        byte[] bArr11 = writeBuffer.PlaceComponentResult;
        int i12 = writeBuffer.MyBillsEntityDataFactory;
        writeBuffer.MyBillsEntityDataFactory = i12 + 1;
        bArr11[i12] = 34;
        if (v1Span.NetworkUserEntityData$$ExternalSyntheticLambda0 != 0) {
            for (int i13 = 0; i13 < 13; i13++) {
                int charAt5 = ",\"timestamp\":".charAt(i13) & 255;
                byte[] bArr12 = writeBuffer.PlaceComponentResult;
                int i14 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i14 + 1;
                bArr12[i14] = (byte) (charAt5 & 255);
            }
            writeBuffer.KClassImpl$Data$declaredNonStaticMembers$2(v1Span.NetworkUserEntityData$$ExternalSyntheticLambda0);
        }
        if (v1Span.KClassImpl$Data$declaredNonStaticMembers$2 != 0) {
            for (int i15 = 0; i15 < 12; i15++) {
                int charAt6 = ",\"duration\":".charAt(i15) & 255;
                byte[] bArr13 = writeBuffer.PlaceComponentResult;
                int i16 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i16 + 1;
                bArr13[i16] = (byte) (charAt6 & 255);
            }
            writeBuffer.KClassImpl$Data$declaredNonStaticMembers$2(v1Span.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        int size = v1Span.getAuthRequestContext.size();
        if (size > 0) {
            for (int i17 = 0; i17 < 16; i17++) {
                int charAt7 = ",\"annotations\":[".charAt(i17) & 255;
                byte[] bArr14 = writeBuffer.PlaceComponentResult;
                int i18 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i18 + 1;
                bArr14[i18] = (byte) (charAt7 & 255);
            }
            int i19 = 0;
            endpoint = null;
            bArr = null;
            while (i19 < size) {
                int i20 = i19 + 1;
                V1Annotation v1Annotation = v1Span.getAuthRequestContext.get(i19);
                Endpoint endpoint2 = v1Annotation.KClassImpl$Data$declaredNonStaticMembers$2;
                if (endpoint2 == null) {
                    bArr3 = bArr;
                    bArr = null;
                } else {
                    if (!endpoint2.equals(endpoint)) {
                        bArr = MyBillsEntityDataFactory(endpoint2);
                        endpoint = endpoint2;
                    }
                    bArr3 = bArr;
                }
                V2SpanWriter.BuiltInFictitiousFunctionClassFactory(v1Annotation.getAuthRequestContext, v1Annotation.PlaceComponentResult, bArr, writeBuffer);
                if (i20 < size) {
                    byte[] bArr15 = writeBuffer.PlaceComponentResult;
                    int i21 = writeBuffer.MyBillsEntityDataFactory;
                    writeBuffer.MyBillsEntityDataFactory = i21 + 1;
                    bArr15[i21] = 44;
                }
                bArr = bArr3;
                i19 = i20;
            }
            byte[] bArr16 = writeBuffer.PlaceComponentResult;
            int i22 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i22 + 1;
            bArr16[i22] = 93;
        } else {
            endpoint = null;
            bArr = null;
        }
        int size2 = v1Span.MyBillsEntityDataFactory.size();
        if (size2 > 0) {
            for (int i23 = 0; i23 < 22; i23++) {
                int charAt8 = ",\"binaryAnnotations\":[".charAt(i23) & 255;
                byte[] bArr17 = writeBuffer.PlaceComponentResult;
                int i24 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i24 + 1;
                bArr17[i24] = (byte) (charAt8 & 255);
            }
            int i25 = 0;
            while (i25 < size2) {
                int i26 = i25 + 1;
                V1BinaryAnnotation v1BinaryAnnotation = v1Span.MyBillsEntityDataFactory.get(i25);
                Endpoint endpoint3 = v1BinaryAnnotation.PlaceComponentResult;
                if (endpoint3 == null) {
                    bArr2 = bArr;
                    bArr = null;
                } else {
                    if (!endpoint3.equals(endpoint)) {
                        bArr = MyBillsEntityDataFactory(endpoint3);
                        endpoint = endpoint3;
                    }
                    bArr2 = bArr;
                }
                if (v1BinaryAnnotation.getAuthRequestContext != null) {
                    KClassImpl$Data$declaredNonStaticMembers$2(v1BinaryAnnotation.BuiltInFictitiousFunctionClassFactory, v1BinaryAnnotation.getAuthRequestContext, bArr, writeBuffer);
                } else {
                    int i27 = 0;
                    for (int i28 = 8; i27 < i28; i28 = 8) {
                        int charAt9 = "{\"key\":\"".charAt(i27) & 255;
                        byte[] bArr18 = writeBuffer.PlaceComponentResult;
                        int i29 = writeBuffer.MyBillsEntityDataFactory;
                        writeBuffer.MyBillsEntityDataFactory = i29 + 1;
                        bArr18[i29] = (byte) (charAt9 & 255);
                        i27++;
                    }
                    String str = v1BinaryAnnotation.BuiltInFictitiousFunctionClassFactory;
                    int length = str.length();
                    for (int i30 = 0; i30 < length; i30++) {
                        int charAt10 = str.charAt(i30) & 255;
                        byte[] bArr19 = writeBuffer.PlaceComponentResult;
                        int i31 = writeBuffer.MyBillsEntityDataFactory;
                        writeBuffer.MyBillsEntityDataFactory = i31 + 1;
                        bArr19[i31] = (byte) (charAt10 & 255);
                    }
                    for (int i32 = 0; i32 < 26; i32++) {
                        int charAt11 = "\",\"value\":true,\"endpoint\":".charAt(i32) & 255;
                        byte[] bArr20 = writeBuffer.PlaceComponentResult;
                        int i33 = writeBuffer.MyBillsEntityDataFactory;
                        writeBuffer.MyBillsEntityDataFactory = i33 + 1;
                        bArr20[i33] = (byte) (charAt11 & 255);
                    }
                    System.arraycopy(bArr, 0, writeBuffer.PlaceComponentResult, writeBuffer.MyBillsEntityDataFactory, bArr.length);
                    writeBuffer.MyBillsEntityDataFactory += bArr.length;
                    byte[] bArr21 = writeBuffer.PlaceComponentResult;
                    int i34 = writeBuffer.MyBillsEntityDataFactory;
                    writeBuffer.MyBillsEntityDataFactory = i34 + 1;
                    bArr21[i34] = 125;
                }
                if (i26 < size2) {
                    byte[] bArr22 = writeBuffer.PlaceComponentResult;
                    int i35 = writeBuffer.MyBillsEntityDataFactory;
                    writeBuffer.MyBillsEntityDataFactory = i35 + 1;
                    bArr22[i35] = 44;
                }
                bArr = bArr2;
                i25 = i26;
            }
            byte[] bArr23 = writeBuffer.PlaceComponentResult;
            int i36 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i36 + 1;
            bArr23[i36] = 93;
        }
        if (Boolean.TRUE.equals(v1Span.PlaceComponentResult)) {
            for (int i37 = 0; i37 < 13; i37++) {
                int charAt12 = ",\"debug\":true".charAt(i37) & 255;
                byte[] bArr24 = writeBuffer.PlaceComponentResult;
                int i38 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i38 + 1;
                bArr24[i38] = (byte) (charAt12 & 255);
            }
        }
        byte[] bArr25 = writeBuffer.PlaceComponentResult;
        int i39 = writeBuffer.MyBillsEntityDataFactory;
        writeBuffer.MyBillsEntityDataFactory = i39 + 1;
        bArr25[i39] = 125;
    }
}
