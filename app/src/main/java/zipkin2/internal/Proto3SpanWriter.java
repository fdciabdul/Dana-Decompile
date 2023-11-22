package zipkin2.internal;

import java.util.List;
import zipkin2.Span;
import zipkin2.internal.Proto3ZipkinFields;
import zipkin2.internal.WriteBuffer;

/* loaded from: classes6.dex */
public final class Proto3SpanWriter implements WriteBuffer.Writer<Span> {
    static final byte[] BuiltInFictitiousFunctionClassFactory = new byte[0];

    public final String toString() {
        return "Span";
    }

    @Override // zipkin2.internal.WriteBuffer.Writer
    public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Span span, WriteBuffer writeBuffer) {
        Proto3ZipkinFields.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(writeBuffer, span);
    }

    @Override // zipkin2.internal.WriteBuffer.Writer
    public final /* synthetic */ int PlaceComponentResult(Span span) {
        Span span2 = span;
        Proto3ZipkinFields.SpanField spanField = Proto3ZipkinFields.BuiltInFictitiousFunctionClassFactory;
        if (span2 == null) {
            return 0;
        }
        return Proto3Fields.MyBillsEntityDataFactory(spanField.BuiltInFictitiousFunctionClassFactory(span2));
    }

    public static int KClassImpl$Data$declaredNonStaticMembers$2(Span span) {
        Proto3ZipkinFields.SpanField spanField = Proto3ZipkinFields.BuiltInFictitiousFunctionClassFactory;
        if (span == null) {
            return 0;
        }
        return Proto3Fields.MyBillsEntityDataFactory(spanField.BuiltInFictitiousFunctionClassFactory(span));
    }

    public static byte[] PlaceComponentResult(List<Span> list) {
        int size = list.size();
        if (size == 0) {
            return BuiltInFictitiousFunctionClassFactory;
        }
        if (size == 1) {
            return PlaceComponentResult2(list.get(0));
        }
        int[] iArr = new int[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Proto3ZipkinFields.SpanField spanField = Proto3ZipkinFields.BuiltInFictitiousFunctionClassFactory;
            int PlaceComponentResult = Proto3ZipkinFields.SpanField.PlaceComponentResult(list.get(i2));
            iArr[i2] = PlaceComponentResult;
            i += Proto3Fields.MyBillsEntityDataFactory(PlaceComponentResult);
        }
        byte[] bArr = new byte[i];
        WriteBuffer authRequestContext = WriteBuffer.getAuthRequestContext(bArr);
        for (int i3 = 0; i3 < size; i3++) {
            Span span = list.get(i3);
            int i4 = iArr[i3];
            int i5 = Proto3ZipkinFields.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
            byte[] bArr2 = authRequestContext.PlaceComponentResult;
            int i6 = authRequestContext.MyBillsEntityDataFactory;
            authRequestContext.MyBillsEntityDataFactory = i6 + 1;
            bArr2[i6] = (byte) (i5 & 255);
            authRequestContext.MyBillsEntityDataFactory(i4);
            Proto3ZipkinFields.SpanField spanField2 = Proto3ZipkinFields.BuiltInFictitiousFunctionClassFactory;
            Proto3ZipkinFields.SpanField.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, span);
        }
        return bArr;
    }

    /* renamed from: PlaceComponentResult */
    public static byte[] PlaceComponentResult2(Span span) {
        Proto3ZipkinFields.SpanField spanField = Proto3ZipkinFields.BuiltInFictitiousFunctionClassFactory;
        int PlaceComponentResult = Proto3ZipkinFields.SpanField.PlaceComponentResult(span);
        byte[] bArr = new byte[Proto3Fields.MyBillsEntityDataFactory(PlaceComponentResult)];
        WriteBuffer authRequestContext = WriteBuffer.getAuthRequestContext(bArr);
        int i = Proto3ZipkinFields.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
        byte[] bArr2 = authRequestContext.PlaceComponentResult;
        int i2 = authRequestContext.MyBillsEntityDataFactory;
        authRequestContext.MyBillsEntityDataFactory = i2 + 1;
        bArr2[i2] = (byte) (i & 255);
        authRequestContext.MyBillsEntityDataFactory(PlaceComponentResult);
        Proto3ZipkinFields.SpanField spanField2 = Proto3ZipkinFields.BuiltInFictitiousFunctionClassFactory;
        Proto3ZipkinFields.SpanField.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, span);
        return bArr;
    }

    public static int MyBillsEntityDataFactory(List<Span> list, byte[] bArr, int i) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        WriteBuffer BuiltInFictitiousFunctionClassFactory2 = WriteBuffer.BuiltInFictitiousFunctionClassFactory(bArr, i);
        for (int i2 = 0; i2 < size; i2++) {
            Proto3ZipkinFields.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory2, list.get(i2));
        }
        return BuiltInFictitiousFunctionClassFactory2.MyBillsEntityDataFactory - i;
    }
}
