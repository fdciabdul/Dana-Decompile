package id.dana.sendmoney.ui.groupsend.recipient.viewmodel;

import dagger.internal.Factory;
import id.dana.sendmoney.domain.groupsend.interactor.GetBottomSheetOnBoardingFlow;
import id.dana.sendmoney.domain.groupsend.interactor.GetContactInjectionConfig;
import id.dana.sendmoney.domain.groupsend.interactor.GetGroupSendMaxParticipant;
import id.dana.sendmoney.domain.groupsend.interactor.GetPhoneNumber;
import id.dana.sendmoney.domain.groupsend.interactor.GetUserInfo;
import id.dana.sendmoney.domain.groupsend.interactor.InitSendMoneyGroup;
import id.dana.sendmoney.domain.groupsend.interactor.InjectDanaContact;
import id.dana.sendmoney.domain.groupsend.interactor.ModifyGroupParticipants;
import id.dana.sendmoney.domain.groupsend.interactor.SaveDisplayBottomSheetOnBoardingFlow;
import id.dana.sendmoney.ui.groupsend.recipient.mapper.UserContactMapper;
import id.dana.sync_engine.domain.interactor.GetContactsUseCase;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GroupRecipientViewModel_Factory implements Factory<GroupRecipientViewModel> {
    private final Provider<GetContactInjectionConfig> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetContactsUseCase> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetBottomSheetOnBoardingFlow> MyBillsEntityDataFactory;
    private final Provider<ModifyGroupParticipants> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<UserContactMapper> NetworkUserEntityData$$ExternalSyntheticLambda1;
    private final Provider<GetGroupSendMaxParticipant> PlaceComponentResult;
    private final Provider<GetPhoneNumber> getAuthRequestContext;
    private final Provider<InjectDanaContact> getErrorConfigVersion;
    private final Provider<SaveDisplayBottomSheetOnBoardingFlow> lookAheadTest;
    private final Provider<GetUserInfo> moveToNextValue;
    private final Provider<InitSendMoneyGroup> scheduleImpl;

    private GroupRecipientViewModel_Factory(Provider<GetGroupSendMaxParticipant> provider, Provider<GetContactsUseCase> provider2, Provider<UserContactMapper> provider3, Provider<SaveDisplayBottomSheetOnBoardingFlow> provider4, Provider<GetBottomSheetOnBoardingFlow> provider5, Provider<GetUserInfo> provider6, Provider<GetPhoneNumber> provider7, Provider<GetContactInjectionConfig> provider8, Provider<InjectDanaContact> provider9, Provider<ModifyGroupParticipants> provider10, Provider<InitSendMoneyGroup> provider11) {
        this.PlaceComponentResult = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = provider3;
        this.lookAheadTest = provider4;
        this.MyBillsEntityDataFactory = provider5;
        this.moveToNextValue = provider6;
        this.getAuthRequestContext = provider7;
        this.BuiltInFictitiousFunctionClassFactory = provider8;
        this.getErrorConfigVersion = provider9;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = provider10;
        this.scheduleImpl = provider11;
    }

    public static GroupRecipientViewModel_Factory BuiltInFictitiousFunctionClassFactory(Provider<GetGroupSendMaxParticipant> provider, Provider<GetContactsUseCase> provider2, Provider<UserContactMapper> provider3, Provider<SaveDisplayBottomSheetOnBoardingFlow> provider4, Provider<GetBottomSheetOnBoardingFlow> provider5, Provider<GetUserInfo> provider6, Provider<GetPhoneNumber> provider7, Provider<GetContactInjectionConfig> provider8, Provider<InjectDanaContact> provider9, Provider<ModifyGroupParticipants> provider10, Provider<InitSendMoneyGroup> provider11) {
        return new GroupRecipientViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GroupRecipientViewModel(this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda1.get(), this.lookAheadTest.get(), this.MyBillsEntityDataFactory.get(), this.moveToNextValue.get(), this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.getErrorConfigVersion.get(), this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.scheduleImpl.get());
    }
}
