package j$.time;

import j$.time.temporal.TemporalAccessor;
import j$.time.temporal.TemporalQuery;
import j$.util.function.Function;

/* loaded from: classes6.dex */
public final /* synthetic */ class LocalDateTime$$ExternalSyntheticLambda6 implements TemporalQuery, Function {
    @Override // j$.time.temporal.TemporalQuery
    public final Object KClassImpl$Data$declaredNonStaticMembers$2(TemporalAccessor temporalAccessor) {
        return LocalDateTime.from(temporalAccessor);
    }

    @Override // j$.util.function.Function
    /* renamed from: andThen */
    public final /* synthetic */ Function mo3169andThen(Function function) {
        return Function.CC.getAuthRequestContext(this, function);
    }

    @Override // j$.util.function.Function
    public final Object apply(Object obj) {
        return obj;
    }

    @Override // j$.util.function.Function
    public final /* synthetic */ Function compose(Function function) {
        return Function.CC.KClassImpl$Data$declaredNonStaticMembers$2(this, function);
    }
}
