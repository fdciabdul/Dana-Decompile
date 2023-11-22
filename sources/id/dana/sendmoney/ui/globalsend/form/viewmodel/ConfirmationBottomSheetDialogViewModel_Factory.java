package id.dana.sendmoney.ui.globalsend.form.viewmodel;

import dagger.internal.Factory;
import id.dana.sendmoney.domain.globalsend.interactor.SaveSenderDetail;
import id.dana.sendmoney.domain.groupsend.interactor.GetUserInfo;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class ConfirmationBottomSheetDialogViewModel_Factory implements Factory<ConfirmationBottomSheetDialogViewModel> {
    private final Provider<SaveSenderDetail> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetUserInfo> getAuthRequestContext;

    private ConfirmationBottomSheetDialogViewModel_Factory(Provider<SaveSenderDetail> provider, Provider<GetUserInfo> provider2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.getAuthRequestContext = provider2;
    }

    public static ConfirmationBottomSheetDialogViewModel_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<SaveSenderDetail> provider, Provider<GetUserInfo> provider2) {
        return new ConfirmationBottomSheetDialogViewModel_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ConfirmationBottomSheetDialogViewModel(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get());
    }
}
