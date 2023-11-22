package id.dana.di.component;

import android.content.Context;
import dagger.internal.Preconditions;
import id.dana.di.modules.AutoCompleteBankModule;
import id.dana.di.modules.AutoCompleteBankModule_ProvideAutoCompleteBankPresenterFactory;
import id.dana.di.modules.AutoCompleteBankModule_ProvideAutoCompleteBankViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import id.dana.domain.withdraw.interactor.GetAvailableBanks;
import id.dana.richview.bank.AutoCompleteBankPresenter;
import id.dana.richview.bank.AutoCompleteBankView;
import id.dana.richview.bank.AutoCompleteBankView_MembersInjector;
import id.dana.sendmoney.mapper.BankModelMapper;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper;
import id.dana.sendmoney.mapper.TransferConfigModelMapper;
import id.dana.utils.concurrent.ThreadExecutor;

/* loaded from: classes8.dex */
public final class DaggerAutoCompleteBankComponent {
    private DaggerAutoCompleteBankComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes8.dex */
    public static final class Builder {
        public ApplicationComponent MyBillsEntityDataFactory;
        public AutoCompleteBankModule getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes8.dex */
    public static final class AutoCompleteBankComponentImpl implements AutoCompleteBankComponent {
        private final AutoCompleteBankComponentImpl MyBillsEntityDataFactory;
        private final ApplicationComponent PlaceComponentResult;
        private final AutoCompleteBankModule getAuthRequestContext;

        public /* synthetic */ AutoCompleteBankComponentImpl(AutoCompleteBankModule autoCompleteBankModule, ApplicationComponent applicationComponent, byte b) {
            this(autoCompleteBankModule, applicationComponent);
        }

        private AutoCompleteBankComponentImpl(AutoCompleteBankModule autoCompleteBankModule, ApplicationComponent applicationComponent) {
            this.MyBillsEntityDataFactory = this;
            this.getAuthRequestContext = autoCompleteBankModule;
            this.PlaceComponentResult = applicationComponent;
        }

        @Override // id.dana.di.component.AutoCompleteBankComponent
        public final void PlaceComponentResult(AutoCompleteBankView autoCompleteBankView) {
            AutoCompleteBankView_MembersInjector.getAuthRequestContext(autoCompleteBankView, AutoCompleteBankModule_ProvideAutoCompleteBankPresenterFactory.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext, new AutoCompleteBankPresenter((Context) Preconditions.PlaceComponentResult(this.PlaceComponentResult.moveToNextValue()), new BankModelMapper(), new GetAvailableBanks((ThreadExecutor) Preconditions.PlaceComponentResult(this.PlaceComponentResult.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.PlaceComponentResult.isAuto()), (SendMoneyRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.BaseSocialFeedContract$Presenter())), AutoCompleteBankModule_ProvideAutoCompleteBankViewFactory.MyBillsEntityDataFactory(this.getAuthRequestContext), new TransferConfigModelMapper(new CurrencyAmountModelMapper()))));
        }
    }
}
