package id.dana.wallet_v3.loyalty.presenter;

import com.zoloz.android.phone.zdoc.service.ZdocRecordService;
import id.dana.base.AbstractContractKt;
import id.dana.domain.account.interactor.GetKycLevel;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.pocket.interactor.GetLoyaltyToken;
import id.dana.domain.pocket.model.AssetStatus;
import id.dana.domain.pocket.model.LoyaltyToken;
import id.dana.domain.wallet_v3.interactor.GetUserPocketWalletAsset;
import id.dana.domain.wallet_v3.model.AssetType;
import id.dana.domain.wallet_v3.model.UserPocketAssetListModel;
import id.dana.domain.wallet_v3.model.UserPocketAssetModel;
import id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletContract;
import id.dana.wallet_v3.mapper.UserPocketAssetsMapperKt;
import id.dana.wallet_v3.model.LoyaltyCardModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c"}, d2 = {"Lid/dana/wallet_v3/loyalty/presenter/LoyaltyWalletPresenter;", "Lid/dana/wallet_v3/loyalty/presenter/LoyaltyWalletContract$Presenter;", "", "fetchLoyaltyAccessTokenAndKycLevel", "()V", "getKycLevel", "", "isNeedResetPagination", "getLoyaltyCardAssets", "(Z)V", "onDestroy", "Lid/dana/domain/account/interactor/GetKycLevel;", "Lid/dana/domain/account/interactor/GetKycLevel;", "Lid/dana/domain/pocket/interactor/GetLoyaltyToken;", "getLoyaltyAccessToken", "Lid/dana/domain/pocket/interactor/GetLoyaltyToken;", "Lid/dana/domain/wallet_v3/interactor/GetUserPocketWalletAsset;", "getLoyaltyAssetList", "Lid/dana/domain/wallet_v3/interactor/GetUserPocketWalletAsset;", "", ZdocRecordService.PAGE_NUMBER, "I", "getPageNumber", "()I", "setPageNumber", "(I)V", "Lid/dana/wallet_v3/loyalty/presenter/LoyaltyWalletContract$View;", "view", "Lid/dana/wallet_v3/loyalty/presenter/LoyaltyWalletContract$View;", "<init>", "(Lid/dana/domain/account/interactor/GetKycLevel;Lid/dana/domain/pocket/interactor/GetLoyaltyToken;Lid/dana/domain/wallet_v3/interactor/GetUserPocketWalletAsset;Lid/dana/wallet_v3/loyalty/presenter/LoyaltyWalletContract$View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LoyaltyWalletPresenter implements LoyaltyWalletContract.Presenter {
    private final GetKycLevel getKycLevel;
    private final GetLoyaltyToken getLoyaltyAccessToken;
    private final GetUserPocketWalletAsset getLoyaltyAssetList;
    private int pageNumber;
    private final LoyaltyWalletContract.View view;

    @Inject
    public LoyaltyWalletPresenter(GetKycLevel getKycLevel, GetLoyaltyToken getLoyaltyToken, GetUserPocketWalletAsset getUserPocketWalletAsset, LoyaltyWalletContract.View view) {
        Intrinsics.checkNotNullParameter(getKycLevel, "");
        Intrinsics.checkNotNullParameter(getLoyaltyToken, "");
        Intrinsics.checkNotNullParameter(getUserPocketWalletAsset, "");
        Intrinsics.checkNotNullParameter(view, "");
        this.getKycLevel = getKycLevel;
        this.getLoyaltyAccessToken = getLoyaltyToken;
        this.getLoyaltyAssetList = getUserPocketWalletAsset;
        this.view = view;
    }

    @JvmName(name = "getPageNumber")
    public final int getPageNumber() {
        return this.pageNumber;
    }

    @JvmName(name = "setPageNumber")
    public final void setPageNumber(int i) {
        this.pageNumber = i;
    }

    @Override // id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletContract.Presenter
    public final void fetchLoyaltyAccessTokenAndKycLevel() {
        this.getLoyaltyAccessToken.execute(NoParams.INSTANCE, new Function1<LoyaltyToken, Unit>() { // from class: id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletPresenter$fetchLoyaltyAccessTokenAndKycLevel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(LoyaltyToken loyaltyToken) {
                invoke2(loyaltyToken);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(LoyaltyToken loyaltyToken) {
                LoyaltyWalletContract.View view;
                Intrinsics.checkNotNullParameter(loyaltyToken, "");
                view = LoyaltyWalletPresenter.this.view;
                view.onGetLoyaltyAccessToken(loyaltyToken.getAccessToken());
                LoyaltyWalletPresenter.this.getKycLevel();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletPresenter$fetchLoyaltyAccessTokenAndKycLevel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                LoyaltyWalletContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = LoyaltyWalletPresenter.this.view;
                view.onErrorGetLoyaltyAccessToken();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getKycLevel() {
        this.getKycLevel.execute(NoParams.INSTANCE, new Function1<String, Unit>() { // from class: id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletPresenter$getKycLevel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                LoyaltyWalletContract.View view;
                boolean z = false;
                if (str != null) {
                    if (str.length() == 0) {
                        z = true;
                    }
                }
                if (z) {
                    str = "KYC0";
                }
                view = LoyaltyWalletPresenter.this.view;
                view.onGetKycLevel(str);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletPresenter$getKycLevel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                LoyaltyWalletContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = LoyaltyWalletPresenter.this.view;
                view.onErrorKycLevel();
            }
        });
    }

    @Override // id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletContract.Presenter
    public final void getLoyaltyCardAssets(boolean isNeedResetPagination) {
        this.view.onLoadingGetLoyaltyAsset();
        if (isNeedResetPagination) {
            this.pageNumber = 1;
        }
        this.getLoyaltyAssetList.execute(new GetUserPocketWalletAsset.Param(this.pageNumber, 10, CollectionsKt.listOf(AssetStatus.INIT), CollectionsKt.listOf(AssetType.LOYALTY.getAsset()), null), new Function1<UserPocketAssetListModel<UserPocketAssetModel>, Unit>() { // from class: id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletPresenter$getLoyaltyCardAssets$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(UserPocketAssetListModel<UserPocketAssetModel> userPocketAssetListModel) {
                invoke2(userPocketAssetListModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(UserPocketAssetListModel<UserPocketAssetModel> userPocketAssetListModel) {
                LoyaltyWalletContract.View view;
                LoyaltyWalletContract.View view2;
                Intrinsics.checkNotNullParameter(userPocketAssetListModel, "");
                view = LoyaltyWalletPresenter.this.view;
                view.onDismissLoadingGetLoyaltyAsset();
                view2 = LoyaltyWalletPresenter.this.view;
                view2.onSuccessGetLoyaltyAsset(UserPocketAssetsMapperKt.toNewPocketQueryListModel(userPocketAssetListModel, new Function1<UserPocketAssetModel, LoyaltyCardModel>() { // from class: id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletPresenter$getLoyaltyCardAssets$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final LoyaltyCardModel invoke(UserPocketAssetModel userPocketAssetModel) {
                        Intrinsics.checkNotNullParameter(userPocketAssetModel, "");
                        return UserPocketAssetsMapperKt.toLoyaltyCardModel(userPocketAssetModel, false);
                    }
                }), LoyaltyWalletPresenter.this.getPageNumber());
                LoyaltyWalletPresenter loyaltyWalletPresenter = LoyaltyWalletPresenter.this;
                loyaltyWalletPresenter.setPageNumber(loyaltyWalletPresenter.getPageNumber() + 1);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.loyalty.presenter.LoyaltyWalletPresenter$getLoyaltyCardAssets$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                LoyaltyWalletContract.View view;
                LoyaltyWalletContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view = LoyaltyWalletPresenter.this.view;
                view.onDismissLoadingGetLoyaltyAsset();
                view2 = LoyaltyWalletPresenter.this.view;
                view2.onErrorGetLoyaltyAsset();
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        AbstractContractKt.AbstractPresenter.CC.BuiltInFictitiousFunctionClassFactory();
        this.getLoyaltyAccessToken.dispose();
        this.getLoyaltyAssetList.dispose();
        this.getKycLevel.dispose();
    }
}
