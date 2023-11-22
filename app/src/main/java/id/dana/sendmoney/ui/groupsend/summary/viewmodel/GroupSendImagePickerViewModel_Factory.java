package id.dana.sendmoney.ui.groupsend.summary.viewmodel;

import dagger.internal.Factory;
import id.dana.sendmoney.domain.groupsend.interactor.UploadGroupAvatar;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GroupSendImagePickerViewModel_Factory implements Factory<GroupSendImagePickerViewModel> {
    private final Provider<UploadGroupAvatar> BuiltInFictitiousFunctionClassFactory;

    private GroupSendImagePickerViewModel_Factory(Provider<UploadGroupAvatar> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static GroupSendImagePickerViewModel_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<UploadGroupAvatar> provider) {
        return new GroupSendImagePickerViewModel_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GroupSendImagePickerViewModel(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
