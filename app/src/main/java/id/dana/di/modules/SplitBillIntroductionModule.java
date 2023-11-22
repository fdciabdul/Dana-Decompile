package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.splitbill.SplitBillIntroductionContract;
import id.dana.splitbill.SplitBillIntroductionPresenter;

@Module
/* loaded from: classes4.dex */
public class SplitBillIntroductionModule {
    private SplitBillIntroductionContract.View PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public SplitBillIntroductionContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(SplitBillIntroductionPresenter splitBillIntroductionPresenter) {
        return splitBillIntroductionPresenter;
    }

    public SplitBillIntroductionModule(SplitBillIntroductionContract.View view) {
        this.PlaceComponentResult = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public SplitBillIntroductionContract.View PlaceComponentResult() {
        return this.PlaceComponentResult;
    }
}
