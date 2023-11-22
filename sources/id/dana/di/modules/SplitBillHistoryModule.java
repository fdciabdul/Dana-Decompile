package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.splitbill.SplitBillHistoryContract;
import id.dana.splitbill.SplitBillHistoryPresenter;

@Module
/* loaded from: classes4.dex */
public class SplitBillHistoryModule {
    private final SplitBillHistoryContract.View getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public SplitBillHistoryContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(SplitBillHistoryPresenter splitBillHistoryPresenter) {
        return splitBillHistoryPresenter;
    }

    public SplitBillHistoryModule(SplitBillHistoryContract.View view) {
        this.getAuthRequestContext = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public SplitBillHistoryContract.View MyBillsEntityDataFactory() {
        return this.getAuthRequestContext;
    }
}
