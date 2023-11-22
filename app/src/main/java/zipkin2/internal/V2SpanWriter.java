package zipkin2.internal;

import java.util.Iterator;
import java.util.Map;
import zipkin2.Annotation;
import zipkin2.Endpoint;
import zipkin2.Span;
import zipkin2.internal.WriteBuffer;

/* loaded from: classes6.dex */
public final class V2SpanWriter implements WriteBuffer.Writer<Span> {
    public final String toString() {
        return "Span";
    }

    @Override // zipkin2.internal.WriteBuffer.Writer
    public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Span span, WriteBuffer writeBuffer) {
        Span span2 = span;
        for (int i = 0; i < 12; i++) {
            int charAt = "{\"traceId\":\"".charAt(i) & 255;
            byte[] bArr = writeBuffer.PlaceComponentResult;
            int i2 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i2 + 1;
            bArr[i2] = (byte) (charAt & 255);
        }
        String traceId = span2.traceId();
        int length = traceId.length();
        for (int i3 = 0; i3 < length; i3++) {
            int charAt2 = traceId.charAt(i3) & 255;
            byte[] bArr2 = writeBuffer.PlaceComponentResult;
            int i4 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i4 + 1;
            bArr2[i4] = (byte) (charAt2 & 255);
        }
        byte[] bArr3 = writeBuffer.PlaceComponentResult;
        int i5 = writeBuffer.MyBillsEntityDataFactory;
        writeBuffer.MyBillsEntityDataFactory = i5 + 1;
        bArr3[i5] = 34;
        if (span2.parentId() != null) {
            for (int i6 = 0; i6 < 13; i6++) {
                int charAt3 = ",\"parentId\":\"".charAt(i6) & 255;
                byte[] bArr4 = writeBuffer.PlaceComponentResult;
                int i7 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i7 + 1;
                bArr4[i7] = (byte) (charAt3 & 255);
            }
            String parentId = span2.parentId();
            int length2 = parentId.length();
            for (int i8 = 0; i8 < length2; i8++) {
                int charAt4 = parentId.charAt(i8) & 255;
                byte[] bArr5 = writeBuffer.PlaceComponentResult;
                int i9 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i9 + 1;
                bArr5[i9] = (byte) (charAt4 & 255);
            }
            byte[] bArr6 = writeBuffer.PlaceComponentResult;
            int i10 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i10 + 1;
            bArr6[i10] = 34;
        }
        for (int i11 = 0; i11 < 7; i11++) {
            int charAt5 = ",\"id\":\"".charAt(i11) & 255;
            byte[] bArr7 = writeBuffer.PlaceComponentResult;
            int i12 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i12 + 1;
            bArr7[i12] = (byte) (charAt5 & 255);
        }
        String id2 = span2.id();
        int length3 = id2.length();
        for (int i13 = 0; i13 < length3; i13++) {
            int charAt6 = id2.charAt(i13) & 255;
            byte[] bArr8 = writeBuffer.PlaceComponentResult;
            int i14 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i14 + 1;
            bArr8[i14] = (byte) (charAt6 & 255);
        }
        byte[] bArr9 = writeBuffer.PlaceComponentResult;
        int i15 = writeBuffer.MyBillsEntityDataFactory;
        writeBuffer.MyBillsEntityDataFactory = i15 + 1;
        bArr9[i15] = 34;
        if (span2.kind() != null) {
            for (int i16 = 0; i16 < 9; i16++) {
                int charAt7 = ",\"kind\":\"".charAt(i16) & 255;
                byte[] bArr10 = writeBuffer.PlaceComponentResult;
                int i17 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i17 + 1;
                bArr10[i17] = (byte) (charAt7 & 255);
            }
            String obj = span2.kind().toString();
            int length4 = obj.length();
            for (int i18 = 0; i18 < length4; i18++) {
                int charAt8 = obj.charAt(i18) & 255;
                byte[] bArr11 = writeBuffer.PlaceComponentResult;
                int i19 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i19 + 1;
                bArr11[i19] = (byte) (charAt8 & 255);
            }
            byte[] bArr12 = writeBuffer.PlaceComponentResult;
            int i20 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i20 + 1;
            bArr12[i20] = 34;
        }
        if (span2.name() != null) {
            for (int i21 = 0; i21 < 9; i21++) {
                int charAt9 = ",\"name\":\"".charAt(i21) & 255;
                byte[] bArr13 = writeBuffer.PlaceComponentResult;
                int i22 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i22 + 1;
                bArr13[i22] = (byte) (charAt9 & 255);
            }
            writeBuffer.getAuthRequestContext(JsonEscaper.PlaceComponentResult(span2.name()));
            byte[] bArr14 = writeBuffer.PlaceComponentResult;
            int i23 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i23 + 1;
            bArr14[i23] = 34;
        }
        if (span2.timestampAsLong() != 0) {
            for (int i24 = 0; i24 < 13; i24++) {
                int charAt10 = ",\"timestamp\":".charAt(i24) & 255;
                byte[] bArr15 = writeBuffer.PlaceComponentResult;
                int i25 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i25 + 1;
                bArr15[i25] = (byte) (charAt10 & 255);
            }
            writeBuffer.KClassImpl$Data$declaredNonStaticMembers$2(span2.timestampAsLong());
        }
        if (span2.durationAsLong() != 0) {
            for (int i26 = 0; i26 < 12; i26++) {
                int charAt11 = ",\"duration\":".charAt(i26) & 255;
                byte[] bArr16 = writeBuffer.PlaceComponentResult;
                int i27 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i27 + 1;
                bArr16[i27] = (byte) (charAt11 & 255);
            }
            writeBuffer.KClassImpl$Data$declaredNonStaticMembers$2(span2.durationAsLong());
        }
        if (span2.localEndpoint() != null) {
            for (int i28 = 0; i28 < 17; i28++) {
                int charAt12 = ",\"localEndpoint\":".charAt(i28) & 255;
                byte[] bArr17 = writeBuffer.PlaceComponentResult;
                int i29 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i29 + 1;
                bArr17[i29] = (byte) (charAt12 & 255);
            }
            MyBillsEntityDataFactory(span2.localEndpoint(), writeBuffer, false);
        }
        if (span2.remoteEndpoint() != null) {
            for (int i30 = 0; i30 < 18; i30++) {
                int charAt13 = ",\"remoteEndpoint\":".charAt(i30) & 255;
                byte[] bArr18 = writeBuffer.PlaceComponentResult;
                int i31 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i31 + 1;
                bArr18[i31] = (byte) (charAt13 & 255);
            }
            MyBillsEntityDataFactory(span2.remoteEndpoint(), writeBuffer, false);
        }
        if (!span2.annotations().isEmpty()) {
            for (int i32 = 0; i32 < 15; i32++) {
                int charAt14 = ",\"annotations\":".charAt(i32) & 255;
                byte[] bArr19 = writeBuffer.PlaceComponentResult;
                int i33 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i33 + 1;
                bArr19[i33] = (byte) (charAt14 & 255);
            }
            byte[] bArr20 = writeBuffer.PlaceComponentResult;
            int i34 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i34 + 1;
            bArr20[i34] = 91;
            int size = span2.annotations().size();
            int i35 = 0;
            while (i35 < size) {
                int i36 = i35 + 1;
                Annotation annotation = span2.annotations().get(i35);
                BuiltInFictitiousFunctionClassFactory(annotation.timestamp(), annotation.value(), null, writeBuffer);
                if (i36 < size) {
                    byte[] bArr21 = writeBuffer.PlaceComponentResult;
                    int i37 = writeBuffer.MyBillsEntityDataFactory;
                    writeBuffer.MyBillsEntityDataFactory = i37 + 1;
                    bArr21[i37] = 44;
                }
                i35 = i36;
            }
            byte[] bArr22 = writeBuffer.PlaceComponentResult;
            int i38 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i38 + 1;
            bArr22[i38] = 93;
        }
        if (!span2.tags().isEmpty()) {
            for (int i39 = 0; i39 < 9; i39++) {
                int charAt15 = ",\"tags\":{".charAt(i39) & 255;
                byte[] bArr23 = writeBuffer.PlaceComponentResult;
                int i40 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i40 + 1;
                bArr23[i40] = (byte) (charAt15 & 255);
            }
            Iterator<Map.Entry<String, String>> it = span2.tags().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                byte[] bArr24 = writeBuffer.PlaceComponentResult;
                int i41 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i41 + 1;
                bArr24[i41] = 34;
                writeBuffer.getAuthRequestContext(JsonEscaper.PlaceComponentResult(next.getKey()));
                for (int i42 = 0; i42 < 3; i42++) {
                    int charAt16 = "\":\"".charAt(i42) & 255;
                    byte[] bArr25 = writeBuffer.PlaceComponentResult;
                    int i43 = writeBuffer.MyBillsEntityDataFactory;
                    writeBuffer.MyBillsEntityDataFactory = i43 + 1;
                    bArr25[i43] = (byte) (charAt16 & 255);
                }
                writeBuffer.getAuthRequestContext(JsonEscaper.PlaceComponentResult(next.getValue()));
                byte[] bArr26 = writeBuffer.PlaceComponentResult;
                int i44 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i44 + 1;
                bArr26[i44] = 34;
                if (it.hasNext()) {
                    byte[] bArr27 = writeBuffer.PlaceComponentResult;
                    int i45 = writeBuffer.MyBillsEntityDataFactory;
                    writeBuffer.MyBillsEntityDataFactory = i45 + 1;
                    bArr27[i45] = 44;
                }
            }
            byte[] bArr28 = writeBuffer.PlaceComponentResult;
            int i46 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i46 + 1;
            bArr28[i46] = 125;
        }
        if (Boolean.TRUE.equals(span2.debug())) {
            for (int i47 = 0; i47 < 13; i47++) {
                int charAt17 = ",\"debug\":true".charAt(i47) & 255;
                byte[] bArr29 = writeBuffer.PlaceComponentResult;
                int i48 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i48 + 1;
                bArr29[i48] = (byte) (charAt17 & 255);
            }
        }
        if (Boolean.TRUE.equals(span2.shared())) {
            for (int i49 = 0; i49 < 14; i49++) {
                int charAt18 = ",\"shared\":true".charAt(i49) & 255;
                byte[] bArr30 = writeBuffer.PlaceComponentResult;
                int i50 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i50 + 1;
                bArr30[i50] = (byte) (charAt18 & 255);
            }
        }
        byte[] bArr31 = writeBuffer.PlaceComponentResult;
        int i51 = writeBuffer.MyBillsEntityDataFactory;
        writeBuffer.MyBillsEntityDataFactory = i51 + 1;
        bArr31[i51] = 125;
    }

    @Override // zipkin2.internal.WriteBuffer.Writer
    public final /* synthetic */ int PlaceComponentResult(Span span) {
        return KClassImpl$Data$declaredNonStaticMembers$2(span);
    }

    public static int KClassImpl$Data$declaredNonStaticMembers$2(Span span) {
        int length = span.traceId().length() + 13;
        if (span.parentId() != null) {
            length += 30;
        }
        int i = length + 24;
        if (span.kind() != null) {
            i = i + 10 + span.kind().name().length();
        }
        if (span.name() != null) {
            i = i + 10 + JsonEscaper.getAuthRequestContext(span.name());
        }
        if (span.timestampAsLong() != 0) {
            i = i + 13 + WriteBuffer.BuiltInFictitiousFunctionClassFactory(span.timestampAsLong());
        }
        if (span.durationAsLong() != 0) {
            i = i + 12 + WriteBuffer.BuiltInFictitiousFunctionClassFactory(span.durationAsLong());
        }
        if (span.localEndpoint() != null) {
            i = i + 17 + KClassImpl$Data$declaredNonStaticMembers$2(span.localEndpoint(), false);
        }
        if (span.remoteEndpoint() != null) {
            i = i + 18 + KClassImpl$Data$declaredNonStaticMembers$2(span.remoteEndpoint(), false);
        }
        if (!span.annotations().isEmpty()) {
            i += 17;
            int size = span.annotations().size();
            if (size > 1) {
                i += size - 1;
            }
            for (int i2 = 0; i2 < size; i2++) {
                Annotation annotation = span.annotations().get(i2);
                i += WriteBuffer.BuiltInFictitiousFunctionClassFactory(annotation.timestamp()) + 25 + JsonEscaper.getAuthRequestContext(annotation.value());
            }
        }
        if (!span.tags().isEmpty()) {
            i += 10;
            int size2 = span.tags().size();
            if (size2 > 1) {
                i += size2 - 1;
            }
            for (Map.Entry<String, String> entry : span.tags().entrySet()) {
                i = i + 5 + JsonEscaper.getAuthRequestContext(entry.getKey()) + JsonEscaper.getAuthRequestContext(entry.getValue());
            }
        }
        if (Boolean.TRUE.equals(span.debug())) {
            i += 13;
        }
        if (Boolean.TRUE.equals(span.shared())) {
            i += 14;
        }
        return i + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int KClassImpl$Data$declaredNonStaticMembers$2(Endpoint endpoint, boolean z) {
        String serviceName = endpoint.serviceName();
        if (serviceName == null && z) {
            serviceName = "";
        }
        int authRequestContext = serviceName != null ? JsonEscaper.getAuthRequestContext(serviceName) + 17 : 1;
        if (endpoint.ipv4() != null) {
            if (authRequestContext != 1) {
                authRequestContext++;
            }
            authRequestContext = authRequestContext + 9 + endpoint.ipv4().length();
        }
        if (endpoint.ipv6() != null) {
            if (authRequestContext != 1) {
                authRequestContext++;
            }
            authRequestContext = authRequestContext + 9 + endpoint.ipv6().length();
        }
        int portAsInt = endpoint.portAsInt();
        if (portAsInt != 0) {
            if (authRequestContext != 1) {
                authRequestContext++;
            }
            authRequestContext = authRequestContext + 7 + WriteBuffer.BuiltInFictitiousFunctionClassFactory(portAsInt);
        }
        return authRequestContext + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int BuiltInFictitiousFunctionClassFactory(long j, String str, int i) {
        int BuiltInFictitiousFunctionClassFactory = WriteBuffer.BuiltInFictitiousFunctionClassFactory(j) + 25 + JsonEscaper.getAuthRequestContext(str);
        return i != 0 ? BuiltInFictitiousFunctionClassFactory + 12 + i : BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void BuiltInFictitiousFunctionClassFactory(long j, String str, @Nullable byte[] bArr, WriteBuffer writeBuffer) {
        for (int i = 0; i < 13; i++) {
            int charAt = "{\"timestamp\":".charAt(i) & 255;
            byte[] bArr2 = writeBuffer.PlaceComponentResult;
            int i2 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i2 + 1;
            bArr2[i2] = (byte) (charAt & 255);
        }
        writeBuffer.KClassImpl$Data$declaredNonStaticMembers$2(j);
        for (int i3 = 0; i3 < 10; i3++) {
            int charAt2 = ",\"value\":\"".charAt(i3) & 255;
            byte[] bArr3 = writeBuffer.PlaceComponentResult;
            int i4 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i4 + 1;
            bArr3[i4] = (byte) (charAt2 & 255);
        }
        writeBuffer.getAuthRequestContext(JsonEscaper.PlaceComponentResult(str));
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
        byte[] bArr6 = writeBuffer.PlaceComponentResult;
        int i8 = writeBuffer.MyBillsEntityDataFactory;
        writeBuffer.MyBillsEntityDataFactory = i8 + 1;
        bArr6[i8] = 125;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void MyBillsEntityDataFactory(Endpoint endpoint, WriteBuffer writeBuffer, boolean z) {
        boolean z2;
        byte[] bArr = writeBuffer.PlaceComponentResult;
        int i = writeBuffer.MyBillsEntityDataFactory;
        writeBuffer.MyBillsEntityDataFactory = i + 1;
        bArr[i] = 123;
        String serviceName = endpoint.serviceName();
        if (serviceName == null && z) {
            serviceName = "";
        }
        boolean z3 = true;
        if (serviceName != null) {
            for (int i2 = 0; i2 < 15; i2++) {
                int charAt = "\"serviceName\":\"".charAt(i2) & 255;
                byte[] bArr2 = writeBuffer.PlaceComponentResult;
                int i3 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i3 + 1;
                bArr2[i3] = (byte) (charAt & 255);
            }
            writeBuffer.getAuthRequestContext(JsonEscaper.PlaceComponentResult(serviceName));
            byte[] bArr3 = writeBuffer.PlaceComponentResult;
            int i4 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i4 + 1;
            bArr3[i4] = 34;
            z2 = true;
        } else {
            z2 = false;
        }
        if (endpoint.ipv4() != null) {
            if (z2) {
                byte[] bArr4 = writeBuffer.PlaceComponentResult;
                int i5 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i5 + 1;
                bArr4[i5] = 44;
            }
            for (int i6 = 0; i6 < 8; i6++) {
                int charAt2 = "\"ipv4\":\"".charAt(i6) & 255;
                byte[] bArr5 = writeBuffer.PlaceComponentResult;
                int i7 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i7 + 1;
                bArr5[i7] = (byte) (charAt2 & 255);
            }
            String ipv4 = endpoint.ipv4();
            int length = ipv4.length();
            for (int i8 = 0; i8 < length; i8++) {
                int charAt3 = ipv4.charAt(i8) & 255;
                byte[] bArr6 = writeBuffer.PlaceComponentResult;
                int i9 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i9 + 1;
                bArr6[i9] = (byte) (charAt3 & 255);
            }
            byte[] bArr7 = writeBuffer.PlaceComponentResult;
            int i10 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i10 + 1;
            bArr7[i10] = 34;
            z2 = true;
        }
        if (endpoint.ipv6() != null) {
            if (z2) {
                byte[] bArr8 = writeBuffer.PlaceComponentResult;
                int i11 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i11 + 1;
                bArr8[i11] = 44;
            }
            for (int i12 = 0; i12 < 8; i12++) {
                int charAt4 = "\"ipv6\":\"".charAt(i12) & 255;
                byte[] bArr9 = writeBuffer.PlaceComponentResult;
                int i13 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i13 + 1;
                bArr9[i13] = (byte) (charAt4 & 255);
            }
            String ipv6 = endpoint.ipv6();
            int length2 = ipv6.length();
            for (int i14 = 0; i14 < length2; i14++) {
                int charAt5 = ipv6.charAt(i14) & 255;
                byte[] bArr10 = writeBuffer.PlaceComponentResult;
                int i15 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i15 + 1;
                bArr10[i15] = (byte) (charAt5 & 255);
            }
            byte[] bArr11 = writeBuffer.PlaceComponentResult;
            int i16 = writeBuffer.MyBillsEntityDataFactory;
            writeBuffer.MyBillsEntityDataFactory = i16 + 1;
            bArr11[i16] = 34;
        } else {
            z3 = z2;
        }
        int portAsInt = endpoint.portAsInt();
        if (portAsInt != 0) {
            if (z3) {
                byte[] bArr12 = writeBuffer.PlaceComponentResult;
                int i17 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i17 + 1;
                bArr12[i17] = 44;
            }
            for (int i18 = 0; i18 < 7; i18++) {
                int charAt6 = "\"port\":".charAt(i18) & 255;
                byte[] bArr13 = writeBuffer.PlaceComponentResult;
                int i19 = writeBuffer.MyBillsEntityDataFactory;
                writeBuffer.MyBillsEntityDataFactory = i19 + 1;
                bArr13[i19] = (byte) (charAt6 & 255);
            }
            writeBuffer.KClassImpl$Data$declaredNonStaticMembers$2(portAsInt);
        }
        byte[] bArr14 = writeBuffer.PlaceComponentResult;
        int i20 = writeBuffer.MyBillsEntityDataFactory;
        writeBuffer.MyBillsEntityDataFactory = i20 + 1;
        bArr14[i20] = 125;
    }
}
