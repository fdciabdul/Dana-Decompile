package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.splitbill.SplitBillSectionContract;
import id.dana.splitbill.SplitBillSectionPresenter;

@Module
/* loaded from: classes8.dex */
public class SplitBillSectionModule {
    private final SplitBillSectionContract.View MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public SplitBillSectionContract.Presenter PlaceComponentResult(SplitBillSectionPresenter splitBillSectionPresenter) {
        return splitBillSectionPresenter;
    }

    public SplitBillSectionModule(SplitBillSectionContract.View view) {
        this.MyBillsEntityDataFactory = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public SplitBillSectionContract.View MyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }
}
