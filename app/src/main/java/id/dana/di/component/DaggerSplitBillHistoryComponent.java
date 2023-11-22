package id.dana.di.component;

import dagger.internal.Preconditions;
import id.dana.di.modules.SplitBillHistoryModule;
import id.dana.di.modules.SplitBillHistoryModule_ProvidePresenterFactory;
import id.dana.di.modules.SplitBillHistoryModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.account.interactor.GetAccount;
import id.dana.domain.splitbill.interactor.GetSplitBillHistories;
import id.dana.domain.splitbill.repository.SplitBillRepository;
import id.dana.splitbill.SplitBillHistoryPresenter;
import id.dana.splitbill.mapper.SplitBillPayerToPayerModelMapper;
import id.dana.splitbill.view.SplitBillHistoryView;
import id.dana.splitbill.view.SplitBillHistoryView_MembersInjector;
import id.dana.utils.concurrent.ThreadExecutor;

/* loaded from: classes4.dex */
public final class DaggerSplitBillHistoryComponent {
    private DaggerSplitBillHistoryComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        public SplitBillHistoryModule PlaceComponentResult;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class SplitBillHistoryComponentImpl implements SplitBillHistoryComponent {
        private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        private final SplitBillHistoryModule PlaceComponentResult;
        private final SplitBillHistoryComponentImpl getAuthRequestContext;

        public /* synthetic */ SplitBillHistoryComponentImpl(SplitBillHistoryModule splitBillHistoryModule, ApplicationComponent applicationComponent, byte b) {
            this(splitBillHistoryModule, applicationComponent);
        }

        private SplitBillHistoryComponentImpl(SplitBillHistoryModule splitBillHistoryModule, ApplicationComponent applicationComponent) {
            this.getAuthRequestContext = this;
            this.PlaceComponentResult = splitBillHistoryModule;
            this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
        }

        @Override // id.dana.di.component.SplitBillHistoryComponent
        public final void PlaceComponentResult(SplitBillHistoryView splitBillHistoryView) {
            SplitBillHistoryView_MembersInjector.MyBillsEntityDataFactory(splitBillHistoryView, SplitBillHistoryModule_ProvidePresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, new SplitBillHistoryPresenter(SplitBillHistoryModule_ProvideViewFactory.getAuthRequestContext(this.PlaceComponentResult), new GetSplitBillHistories((ThreadExecutor) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.isAuto()), (SplitBillRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.ConcurrentKt())), new GetAccount((ThreadExecutor) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.isAuto()), (AccountRepository) Preconditions.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory())))));
            SplitBillHistoryView_MembersInjector.MyBillsEntityDataFactory(splitBillHistoryView, new SplitBillPayerToPayerModelMapper());
        }
    }
}
