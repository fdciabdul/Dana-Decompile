package id.dana.contract.deeplink.generation;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.deeplink.generation.GenerateDeepLinkContract;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes2.dex */
public class GenerateDeepLinkModule {
    private GenerateDeepLinkContract.TransferView KClassImpl$Data$declaredNonStaticMembers$2;
    private GenerateDeepLinkContract.ProfileView MyBillsEntityDataFactory;
    private GenerateDeepLinkContract.SplitBillView getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public GenerateDeepLinkContract.ProfilePresenter KClassImpl$Data$declaredNonStaticMembers$2(ProfileQrDeepLinkPresenter profileQrDeepLinkPresenter) {
        return profileQrDeepLinkPresenter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public GenerateDeepLinkContract.SplitBillPresenter MyBillsEntityDataFactory(SplitBillQrDeepLinkPresenter splitBillQrDeepLinkPresenter) {
        return splitBillQrDeepLinkPresenter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public GenerateDeepLinkContract.TransferPresenter PlaceComponentResult(TransferQrDeepLinkPresenter transferQrDeepLinkPresenter) {
        return transferQrDeepLinkPresenter;
    }

    public GenerateDeepLinkModule(GenerateDeepLinkContract.ProfileView profileView) {
        this.MyBillsEntityDataFactory = profileView;
    }

    public GenerateDeepLinkModule(GenerateDeepLinkContract.ProfileView profileView, GenerateDeepLinkContract.TransferView transferView) {
        this(profileView);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = transferView;
    }

    public GenerateDeepLinkModule(GenerateDeepLinkContract.SplitBillView splitBillView) {
        this.getAuthRequestContext = splitBillView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public GenerateDeepLinkContract.ProfileView KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public GenerateDeepLinkContract.TransferView getAuthRequestContext() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public GenerateDeepLinkContract.SplitBillView MyBillsEntityDataFactory() {
        return this.getAuthRequestContext;
    }
}
