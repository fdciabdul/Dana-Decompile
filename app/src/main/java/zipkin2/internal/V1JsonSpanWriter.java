package zipkin2.internal;

import zipkin2.Span;
import zipkin2.internal.WriteBuffer;
import zipkin2.v1.V2SpanConverter;

/* loaded from: classes6.dex */
public final class V1JsonSpanWriter implements WriteBuffer.Writer<Span> {
    public final V2SpanConverter MyBillsEntityDataFactory = V2SpanConverter.BuiltInFictitiousFunctionClassFactory();
    public final V1SpanWriter getAuthRequestContext = new V1SpanWriter();

    @Override // zipkin2.internal.WriteBuffer.Writer
    public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Span span, WriteBuffer writeBuffer) {
        V1SpanWriter.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getAuthRequestContext(span), writeBuffer);
    }

    @Override // zipkin2.internal.WriteBuffer.Writer
    public final /* synthetic */ int PlaceComponentResult(Span span) {
        return V1SpanWriter.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory.getAuthRequestContext(span));
    }
}
