package id.dana.wallet_v3.vouchersandtickets.presenter;

import id.dana.domain.pocket.model.AssetStatus;
import id.dana.domain.wallet_v3.interactor.GetUserPocketWalletAsset;
import id.dana.domain.wallet_v3.model.UserPocketAssetListModel;
import id.dana.domain.wallet_v3.model.UserPocketAssetModel;
import id.dana.wallet_v3.mapper.UserPocketAssetsMapperKt;
import id.dana.wallet_v3.model.VoucherAndTicketCardModel;
import id.dana.wallet_v3.vouchersandtickets.presenter.VoucherAndTicketExpiredListContract;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0019\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\tR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0001@\u0001X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018"}, d2 = {"Lid/dana/wallet_v3/vouchersandtickets/presenter/VoucherAndTicketExpiredListPresenter;", "Lid/dana/wallet_v3/vouchersandtickets/presenter/VoucherAndTicketExpiredListContract$Presenter;", "", "", "assetType", "", "getExpiredVoucherAndTicket", "(Ljava/util/List;)V", "hideLoading", "()V", "onDestroy", "showLoading", "Lid/dana/domain/wallet_v3/interactor/GetUserPocketWalletAsset;", "getUserPocketWalletAsset", "Lid/dana/domain/wallet_v3/interactor/GetUserPocketWalletAsset;", "Lid/dana/wallet_v3/vouchersandtickets/presenter/VoucherAndTicketExpiredListContract$View;", "view", "Lid/dana/wallet_v3/vouchersandtickets/presenter/VoucherAndTicketExpiredListContract$View;", "", "voucherAndTicketPageNumber", "I", "getVoucherAndTicketPageNumber$app_productionRelease", "()I", "setVoucherAndTicketPageNumber$app_productionRelease", "(I)V", "<init>", "(Lid/dana/wallet_v3/vouchersandtickets/presenter/VoucherAndTicketExpiredListContract$View;Lid/dana/domain/wallet_v3/interactor/GetUserPocketWalletAsset;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class VoucherAndTicketExpiredListPresenter implements VoucherAndTicketExpiredListContract.Presenter {
    private static final int FIRST_PAGE = 1;
    private static final int PAGE_SIZE = 10;
    private final GetUserPocketWalletAsset getUserPocketWalletAsset;
    private final VoucherAndTicketExpiredListContract.View view;
    private int voucherAndTicketPageNumber;

    @Inject
    public VoucherAndTicketExpiredListPresenter(VoucherAndTicketExpiredListContract.View view, GetUserPocketWalletAsset getUserPocketWalletAsset) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getUserPocketWalletAsset, "");
        this.view = view;
        this.getUserPocketWalletAsset = getUserPocketWalletAsset;
        this.voucherAndTicketPageNumber = 1;
    }

    @JvmName(name = "getVoucherAndTicketPageNumber$app_productionRelease")
    /* renamed from: getVoucherAndTicketPageNumber$app_productionRelease  reason: from getter */
    public final int getVoucherAndTicketPageNumber() {
        return this.voucherAndTicketPageNumber;
    }

    @JvmName(name = "setVoucherAndTicketPageNumber$app_productionRelease")
    public final void setVoucherAndTicketPageNumber$app_productionRelease(int i) {
        this.voucherAndTicketPageNumber = i;
    }

    @Override // id.dana.wallet_v3.vouchersandtickets.presenter.VoucherAndTicketExpiredListContract.Presenter
    public final void getExpiredVoucherAndTicket(List<String> assetType) {
        Intrinsics.checkNotNullParameter(assetType, "");
        showLoading();
        this.getUserPocketWalletAsset.execute(new GetUserPocketWalletAsset.Param(this.voucherAndTicketPageNumber, 10, CollectionsKt.listOf((Object[]) new AssetStatus[]{AssetStatus.REDEEMED, AssetStatus.EXPIRED}), assetType, null), new Function1<UserPocketAssetListModel<UserPocketAssetModel>, Unit>() { // from class: id.dana.wallet_v3.vouchersandtickets.presenter.VoucherAndTicketExpiredListPresenter$getExpiredVoucherAndTicket$1
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
                VoucherAndTicketExpiredListContract.View view;
                VoucherAndTicketExpiredListContract.View view2;
                Intrinsics.checkNotNullParameter(userPocketAssetListModel, "");
                VoucherAndTicketExpiredListPresenter.this.hideLoading();
                if (!userPocketAssetListModel.getPockets().isEmpty() || VoucherAndTicketExpiredListPresenter.this.getVoucherAndTicketPageNumber() != 1) {
                    view = VoucherAndTicketExpiredListPresenter.this.view;
                    view.onSuccessGetExpiredVoucherAndTicket(UserPocketAssetsMapperKt.toNewPocketQueryListModel(userPocketAssetListModel, new Function1<UserPocketAssetModel, VoucherAndTicketCardModel>() { // from class: id.dana.wallet_v3.vouchersandtickets.presenter.VoucherAndTicketExpiredListPresenter$getExpiredVoucherAndTicket$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public final VoucherAndTicketCardModel invoke(UserPocketAssetModel userPocketAssetModel) {
                            Intrinsics.checkNotNullParameter(userPocketAssetModel, "");
                            return UserPocketAssetsMapperKt.toVoucherAndTicketCardModel(userPocketAssetModel, true);
                        }
                    }));
                    VoucherAndTicketExpiredListPresenter voucherAndTicketExpiredListPresenter = VoucherAndTicketExpiredListPresenter.this;
                    voucherAndTicketExpiredListPresenter.setVoucherAndTicketPageNumber$app_productionRelease(voucherAndTicketExpiredListPresenter.getVoucherAndTicketPageNumber() + 1);
                    return;
                }
                view2 = VoucherAndTicketExpiredListPresenter.this.view;
                view2.onEmptyGetExpiredVoucherAndTicket();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.vouchersandtickets.presenter.VoucherAndTicketExpiredListPresenter$getExpiredVoucherAndTicket$2
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
                VoucherAndTicketExpiredListContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                VoucherAndTicketExpiredListPresenter.this.hideLoading();
                view = VoucherAndTicketExpiredListPresenter.this.view;
                view.onErrorGetExpiredVoucherAndTicket();
            }
        });
    }

    private final void showLoading() {
        if (this.voucherAndTicketPageNumber == 1) {
            this.view.showLoadingShimmer();
        } else {
            this.view.showLoadingSpinnerAtBottomOfRecyclerView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideLoading() {
        if (this.voucherAndTicketPageNumber == 1) {
            this.view.dismissLoadingShimmer();
        } else {
            this.view.dismissLoadingSpinnerAtBottomOfRecyclerView();
        }
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.getUserPocketWalletAsset.dispose();
    }
}
