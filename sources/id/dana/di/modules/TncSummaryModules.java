package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.tncsummary.TncSummaryContract;
import id.dana.tncsummary.TncSummaryPresenter;

@Module
/* loaded from: classes2.dex */
public class TncSummaryModules {
    private TncSummaryContract.View getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public TncSummaryContract.Presenter PlaceComponentResult(TncSummaryPresenter tncSummaryPresenter) {
        return tncSummaryPresenter;
    }

    public TncSummaryModules(TncSummaryContract.View view) {
        this.getAuthRequestContext = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public TncSummaryContract.View MyBillsEntityDataFactory() {
        return this.getAuthRequestContext;
    }
}
