package id.dana.feeds.data.config.source.split;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.data.toggle.SplitFacade;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class SplitFeedsConfigEntityData_Factory implements Factory<SplitFeedsConfigEntityData> {
    private final Provider<SplitFacade> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SplitFeedsConfigEntityData(DoubleCheck.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2));
    }
}
