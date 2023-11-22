package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.splitbill.SplitBillDetailContract;
import id.dana.splitbill.SplitBillDetailPresenter;

@Module
/* loaded from: classes4.dex */
public class SplitBillDetailModule {
    private final SplitBillDetailContract.View KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public SplitBillDetailContract.Presenter MyBillsEntityDataFactory(SplitBillDetailPresenter splitBillDetailPresenter) {
        return splitBillDetailPresenter;
    }

    public SplitBillDetailModule(SplitBillDetailContract.View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public SplitBillDetailContract.View MyBillsEntityDataFactory() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
