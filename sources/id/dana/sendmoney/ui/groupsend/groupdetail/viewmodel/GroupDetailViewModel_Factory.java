package id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel;

import dagger.internal.Factory;
import id.dana.domain.recentbank.interactor.SaveRecentBank;
import id.dana.domain.recentcontact.interactor.SaveRecentContact;
import id.dana.domain.recentrecipient.interactor.GetFavoriteAccountCount;
import id.dana.domain.recentrecipient.interactor.GetGroupFavoriteValue;
import id.dana.domain.recentrecipient.interactor.GetLeastTransactionFavoriteAccount;
import id.dana.domain.recentrecipient.interactor.GetMaxFavoriteAccount;
import id.dana.domain.recentrecipient.interactor.RemoveRecentGroup;
import id.dana.domain.recentrecipient.interactor.SaveRecentGroup;
import id.dana.sendmoney.domain.groupsend.interactor.DeleteGroup;
import id.dana.sendmoney.domain.groupsend.interactor.GetGroupSendDetail;
import id.dana.sendmoney.domain.groupsend.interactor.ModifyGroupImage;
import id.dana.sendmoney.domain.groupsend.interactor.ModifyGroupName;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GroupDetailViewModel_Factory implements Factory<GroupDetailViewModel> {
    private final Provider<GetGroupFavoriteValue> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetGroupSendDetail> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetFavoriteAccountCount> MyBillsEntityDataFactory;
    private final Provider<RemoveRecentGroup> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<SaveRecentContact> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Provider<SaveRecentGroup> NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final Provider<DeleteGroup> PlaceComponentResult;
    private final Provider<GetLeastTransactionFavoriteAccount> getAuthRequestContext;
    private final Provider<ModifyGroupName> getErrorConfigVersion;
    private final Provider<GetMaxFavoriteAccount> lookAheadTest;
    private final Provider<ModifyGroupImage> moveToNextValue;
    private final Provider<SaveRecentBank> scheduleImpl;

    private GroupDetailViewModel_Factory(Provider<GetGroupSendDetail> provider, Provider<DeleteGroup> provider2, Provider<ModifyGroupName> provider3, Provider<ModifyGroupImage> provider4, Provider<RemoveRecentGroup> provider5, Provider<GetGroupFavoriteValue> provider6, Provider<GetFavoriteAccountCount> provider7, Provider<GetMaxFavoriteAccount> provider8, Provider<GetLeastTransactionFavoriteAccount> provider9, Provider<SaveRecentGroup> provider10, Provider<SaveRecentBank> provider11, Provider<SaveRecentContact> provider12) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.PlaceComponentResult = provider2;
        this.getErrorConfigVersion = provider3;
        this.moveToNextValue = provider4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider5;
        this.BuiltInFictitiousFunctionClassFactory = provider6;
        this.MyBillsEntityDataFactory = provider7;
        this.lookAheadTest = provider8;
        this.getAuthRequestContext = provider9;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = provider10;
        this.scheduleImpl = provider11;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = provider12;
    }

    public static GroupDetailViewModel_Factory getAuthRequestContext(Provider<GetGroupSendDetail> provider, Provider<DeleteGroup> provider2, Provider<ModifyGroupName> provider3, Provider<ModifyGroupImage> provider4, Provider<RemoveRecentGroup> provider5, Provider<GetGroupFavoriteValue> provider6, Provider<GetFavoriteAccountCount> provider7, Provider<GetMaxFavoriteAccount> provider8, Provider<GetLeastTransactionFavoriteAccount> provider9, Provider<SaveRecentGroup> provider10, Provider<SaveRecentBank> provider11, Provider<SaveRecentContact> provider12) {
        return new GroupDetailViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GroupDetailViewModel(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.PlaceComponentResult.get(), this.getErrorConfigVersion.get(), this.moveToNextValue.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get(), this.lookAheadTest.get(), this.getAuthRequestContext.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda2.get(), this.scheduleImpl.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda1.get());
    }
}
