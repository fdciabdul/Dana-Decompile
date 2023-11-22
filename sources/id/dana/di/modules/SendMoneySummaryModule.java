package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.sendmoney.namecheck.SendMoneySummaryContract;
import id.dana.sendmoney.namecheck.SendMoneySummaryPresenter;

@Module
/* loaded from: classes4.dex */
public class SendMoneySummaryModule {
    private final SendMoneySummaryContract.View getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public SendMoneySummaryContract.Presenter getAuthRequestContext(SendMoneySummaryPresenter sendMoneySummaryPresenter) {
        return sendMoneySummaryPresenter;
    }

    public SendMoneySummaryModule(SendMoneySummaryContract.View view) {
        this.getAuthRequestContext = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public SendMoneySummaryContract.View BuiltInFictitiousFunctionClassFactory() {
        return this.getAuthRequestContext;
    }
}
