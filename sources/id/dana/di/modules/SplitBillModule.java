package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.splitbill.SplitBillContract;
import id.dana.splitbill.SplitBillPresenter;

@Module
/* loaded from: classes4.dex */
public class SplitBillModule {
    private SplitBillContract.View MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public SplitBillContract.Presenter getAuthRequestContext(SplitBillPresenter splitBillPresenter) {
        return splitBillPresenter;
    }

    public SplitBillModule(SplitBillContract.View view) {
        this.MyBillsEntityDataFactory = view;
    }

    @Provides
    @PerActivity
    public SplitBillContract.View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
