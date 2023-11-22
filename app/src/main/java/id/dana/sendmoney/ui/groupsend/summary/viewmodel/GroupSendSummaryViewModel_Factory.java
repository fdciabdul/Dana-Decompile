package id.dana.sendmoney.ui.groupsend.summary.viewmodel;

import dagger.internal.Factory;
import id.dana.domain.recentrecipient.interactor.GetGroupFavoriteValue;
import id.dana.domain.recentrecipient.interactor.SaveRecentGroup;
import id.dana.sendmoney.domain.groupsend.interactor.ConfirmSendMoneyGroup;
import id.dana.sendmoney.domain.groupsend.interactor.GetDefaultAvatarGroup;
import id.dana.sendmoney.domain.groupsend.interactor.GetEditMemberSwitch;
import id.dana.sendmoney.domain.groupsend.interactor.GetGroupSendDetail;
import id.dana.sendmoney.domain.groupsend.interactor.InitSendMoneyGroup;
import id.dana.sendmoney.domain.groupsend.interactor.SaveDefaultAvatarGroup;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GroupSendSummaryViewModel_Factory implements Factory<GroupSendSummaryViewModel> {
    private final Provider<GetGroupSendDetail> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetGroupFavoriteValue> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetDefaultAvatarGroup> MyBillsEntityDataFactory;
    private final Provider<ConfirmSendMoneyGroup> PlaceComponentResult;
    private final Provider<GetEditMemberSwitch> getAuthRequestContext;
    private final Provider<SaveRecentGroup> getErrorConfigVersion;
    private final Provider<InitSendMoneyGroup> lookAheadTest;
    private final Provider<SaveDefaultAvatarGroup> moveToNextValue;

    private GroupSendSummaryViewModel_Factory(Provider<GetDefaultAvatarGroup> provider, Provider<SaveDefaultAvatarGroup> provider2, Provider<ConfirmSendMoneyGroup> provider3, Provider<InitSendMoneyGroup> provider4, Provider<GetEditMemberSwitch> provider5, Provider<GetGroupSendDetail> provider6, Provider<SaveRecentGroup> provider7, Provider<GetGroupFavoriteValue> provider8) {
        this.MyBillsEntityDataFactory = provider;
        this.moveToNextValue = provider2;
        this.PlaceComponentResult = provider3;
        this.lookAheadTest = provider4;
        this.getAuthRequestContext = provider5;
        this.BuiltInFictitiousFunctionClassFactory = provider6;
        this.getErrorConfigVersion = provider7;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider8;
    }

    public static GroupSendSummaryViewModel_Factory PlaceComponentResult(Provider<GetDefaultAvatarGroup> provider, Provider<SaveDefaultAvatarGroup> provider2, Provider<ConfirmSendMoneyGroup> provider3, Provider<InitSendMoneyGroup> provider4, Provider<GetEditMemberSwitch> provider5, Provider<GetGroupSendDetail> provider6, Provider<SaveRecentGroup> provider7, Provider<GetGroupFavoriteValue> provider8) {
        return new GroupSendSummaryViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GroupSendSummaryViewModel(this.MyBillsEntityDataFactory.get(), this.moveToNextValue.get(), this.PlaceComponentResult.get(), this.lookAheadTest.get(), this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.getErrorConfigVersion.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
