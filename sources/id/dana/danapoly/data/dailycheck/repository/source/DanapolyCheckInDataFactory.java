package id.dana.danapoly.data.dailycheck.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/danapoly/data/dailycheck/repository/source/DanapolyCheckInDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/danapoly/data/dailycheck/repository/source/DanapolyCheckInData;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/danapoly/data/dailycheck/repository/source/DanapolyCheckInData;", "p0", "<init>", "(Lid/dana/danapoly/data/dailycheck/repository/source/DanapolyCheckInData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanapolyCheckInDataFactory extends AbstractEntityDataFactory<DanapolyCheckInData> {
    public final DanapolyCheckInData KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public DanapolyCheckInDataFactory(DanapolyCheckInData danapolyCheckInData) {
        Intrinsics.checkNotNullParameter(danapolyCheckInData, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danapolyCheckInData;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    public final /* bridge */ /* synthetic */ DanapolyCheckInData createData(String str) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
