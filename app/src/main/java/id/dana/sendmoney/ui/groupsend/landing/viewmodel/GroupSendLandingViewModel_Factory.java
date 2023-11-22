package id.dana.sendmoney.ui.groupsend.landing.viewmodel;

import dagger.internal.Factory;
import id.dana.sendmoney.domain.groupsend.interactor.GetBottomSheetOnBoardingFlow;
import id.dana.sendmoney.domain.groupsend.interactor.GetGroupSendMaxGroup;
import id.dana.sendmoney.domain.groupsend.interactor.GetGroupSendQuery;
import id.dana.sendmoney.domain.groupsend.interactor.GetGroupSendScenarios;
import id.dana.sendmoney.domain.groupsend.interactor.SaveDisplayBottomSheetOnBoardingFlow;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GroupSendLandingViewModel_Factory implements Factory<GroupSendLandingViewModel> {
    private final Provider<GetGroupSendMaxGroup> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetGroupSendScenarios> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetGroupSendQuery> MyBillsEntityDataFactory;
    private final Provider<GetBottomSheetOnBoardingFlow> PlaceComponentResult;
    private final Provider<SaveDisplayBottomSheetOnBoardingFlow> getAuthRequestContext;

    private GroupSendLandingViewModel_Factory(Provider<GetGroupSendScenarios> provider, Provider<GetBottomSheetOnBoardingFlow> provider2, Provider<SaveDisplayBottomSheetOnBoardingFlow> provider3, Provider<GetGroupSendMaxGroup> provider4, Provider<GetGroupSendQuery> provider5) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.PlaceComponentResult = provider2;
        this.getAuthRequestContext = provider3;
        this.BuiltInFictitiousFunctionClassFactory = provider4;
        this.MyBillsEntityDataFactory = provider5;
    }

    public static GroupSendLandingViewModel_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<GetGroupSendScenarios> provider, Provider<GetBottomSheetOnBoardingFlow> provider2, Provider<SaveDisplayBottomSheetOnBoardingFlow> provider3, Provider<GetGroupSendMaxGroup> provider4, Provider<GetGroupSendQuery> provider5) {
        return new GroupSendLandingViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GroupSendLandingViewModel(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.get(), this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get());
    }
}
