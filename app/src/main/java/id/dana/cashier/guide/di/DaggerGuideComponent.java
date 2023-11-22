package id.dana.cashier.guide.di;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.cashier.domain.CashierRepository;
import id.dana.cashier.domain.interactor.GetCdpGuide;
import id.dana.cashier.guide.bottomsheet.CashierGuideDialogFragment;
import id.dana.cashier.guide.bottomsheet.CashierGuideDialogFragment_MembersInjector;
import id.dana.cashier.guide.contract.GuideContract;
import id.dana.cashier.guide.contract.GuidePresenter;
import id.dana.di.component.ApplicationComponent;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerGuideComponent {
    private DaggerGuideComponent() {
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public ApplicationComponent BuiltInFictitiousFunctionClassFactory;
        public GuideModule MyBillsEntityDataFactory;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class GuideComponentImpl implements GuideComponent {
        private final ApplicationComponent KClassImpl$Data$declaredNonStaticMembers$2;
        private final GuideComponentImpl MyBillsEntityDataFactory;
        private Provider<GuideContract.View> PlaceComponentResult;
        private final GuideModule getAuthRequestContext;

        public /* synthetic */ GuideComponentImpl(GuideModule guideModule, ApplicationComponent applicationComponent, byte b) {
            this(guideModule, applicationComponent);
        }

        private GuideComponentImpl(GuideModule guideModule, ApplicationComponent applicationComponent) {
            this.MyBillsEntityDataFactory = this;
            this.getAuthRequestContext = guideModule;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = applicationComponent;
            this.PlaceComponentResult = DoubleCheck.getAuthRequestContext(GuideModule_ProvideGuideViewFactory.KClassImpl$Data$declaredNonStaticMembers$2(guideModule));
        }

        @Override // id.dana.cashier.guide.di.GuideComponent
        public final void PlaceComponentResult(CashierGuideDialogFragment cashierGuideDialogFragment) {
            CashierGuideDialogFragment_MembersInjector.getAuthRequestContext(cashierGuideDialogFragment, GuideModule_ProvideGuidePresenterPresenterFactory.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, new GuidePresenter(this.PlaceComponentResult.get(), new GetCdpGuide((CashierRepository) Preconditions.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest())))));
        }
    }
}
