package id.dana.di.component;

import android.content.Context;
import dagger.internal.Preconditions;
import id.dana.contract.sendmoney.voucher.ChangeVoucherPresenter_Factory;
import id.dana.di.modules.ChangeVoucherModule;
import id.dana.di.modules.ChangeVoucherModule_ProvidePresenterFactory;
import id.dana.di.modules.ChangeVoucherModule_ProvideViewFactory;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.sendmoney.interactor.GetTransferPrePay;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import id.dana.sendmoney.mapper.CouponPayMethodInfoListModelMapper;
import id.dana.sendmoney.mapper.CouponPayMethodInfoModelMapper;
import id.dana.sendmoney.mapper.CurrencyAmountModelMapper;
import id.dana.sendmoney.mapper.TransferPrepayMapper;
import id.dana.sendmoney.voucher.SummaryVoucherView;
import id.dana.sendmoney.voucher.SummaryVoucherView_MembersInjector;
import id.dana.utils.concurrent.ThreadExecutor;

/* loaded from: classes4.dex */
public final class DaggerChangeVoucherComponent {
    private DaggerChangeVoucherComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ChangeVoucherModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class ChangeVoucherComponentImpl implements ChangeVoucherComponent {
        private final ChangeVoucherModule BuiltInFictitiousFunctionClassFactory;
        private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        private final ChangeVoucherComponentImpl MyBillsEntityDataFactory;

        public /* synthetic */ ChangeVoucherComponentImpl(ChangeVoucherModule changeVoucherModule, ApplicationComponent applicationComponent, byte b) {
            this(changeVoucherModule, applicationComponent);
        }

        private ChangeVoucherComponentImpl(ChangeVoucherModule changeVoucherModule, ApplicationComponent applicationComponent) {
            this.MyBillsEntityDataFactory = this;
            this.BuiltInFictitiousFunctionClassFactory = changeVoucherModule;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
        }

        @Override // id.dana.di.component.ChangeVoucherComponent
        public final void PlaceComponentResult(SummaryVoucherView summaryVoucherView) {
            SummaryVoucherView_MembersInjector.getAuthRequestContext(summaryVoucherView, ChangeVoucherModule_ProvidePresenterFactory.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, ChangeVoucherPresenter_Factory.getAuthRequestContext(new GetTransferPrePay((ThreadExecutor) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.CheckPromoQuestFeature()), (PostExecutionThread) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.isAuto()), (SendMoneyRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.BaseSocialFeedContract$Presenter())), ChangeVoucherModule_ProvideViewFactory.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory), new TransferPrepayMapper(new CurrencyAmountModelMapper(), new CouponPayMethodInfoListModelMapper(new CouponPayMethodInfoModelMapper(new CurrencyAmountModelMapper()))), (Context) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue()))));
        }
    }
}
