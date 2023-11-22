package id.dana.wallet_v3.vouchersandtickets.presenter;

import dagger.Lazy;
import id.dana.domain.pocket.model.AssetStatus;
import id.dana.domain.wallet_v3.interactor.GetUserPocketWalletAsset;
import id.dana.domain.wallet_v3.interactor.SetPocketUpdate;
import id.dana.domain.wallet_v3.model.PocketUpdateModel;
import id.dana.domain.wallet_v3.model.UserPocketAssetListModel;
import id.dana.domain.wallet_v3.model.UserPocketAssetModel;
import id.dana.wallet_v3.mapper.UserPocketAssetsMapperKt;
import id.dana.wallet_v3.model.VoucherAndTicketCardModel;
import id.dana.wallet_v3.vouchersandtickets.presenter.VouchersAndTicketsDetailContract;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 &2\u00020\u0001:\u0001&B'\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0004\b$\u0010%J5\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR(\u0010\u001d\u001a\u00020\u000e8\u0007@\u0007X\u0086\u000e¢\u0006\u0018\n\u0004\b\u001d\u0010\u001e\u0012\u0004\b#\u0010\r\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\""}, d2 = {"Lid/dana/wallet_v3/vouchersandtickets/presenter/VouchersAndTicketsDetailPresenter;", "Lid/dana/wallet_v3/vouchersandtickets/presenter/VouchersAndTicketsDetailContract$Presenter;", "", "isNeedResetPagination", "fromSortAsset", "", "order", "", "assetTypes", "", "getVoucherAndTicketAsset", "(ZZLjava/lang/String;Ljava/util/List;)V", "onDestroy", "()V", "", "position", "pocketId", "updatePocketAsset", "(ILjava/lang/String;)V", "Lid/dana/domain/wallet_v3/interactor/GetUserPocketWalletAsset;", "getUserPocketWalletAsset", "Lid/dana/domain/wallet_v3/interactor/GetUserPocketWalletAsset;", "Ldagger/Lazy;", "Lid/dana/domain/wallet_v3/interactor/SetPocketUpdate;", "setPocketUpdate", "Ldagger/Lazy;", "Lid/dana/wallet_v3/vouchersandtickets/presenter/VouchersAndTicketsDetailContract$View;", "view", "Lid/dana/wallet_v3/vouchersandtickets/presenter/VouchersAndTicketsDetailContract$View;", "voucherAndTicketPageNumber", "I", "getVoucherAndTicketPageNumber", "()I", "setVoucherAndTicketPageNumber", "(I)V", "getVoucherAndTicketPageNumber$annotations", "<init>", "(Lid/dana/wallet_v3/vouchersandtickets/presenter/VouchersAndTicketsDetailContract$View;Lid/dana/domain/wallet_v3/interactor/GetUserPocketWalletAsset;Ldagger/Lazy;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class VouchersAndTicketsDetailPresenter implements VouchersAndTicketsDetailContract.Presenter {
    public static final int PAGE_SIZE = 10;
    private final GetUserPocketWalletAsset getUserPocketWalletAsset;
    private final Lazy<SetPocketUpdate> setPocketUpdate;
    private final VouchersAndTicketsDetailContract.View view;
    private int voucherAndTicketPageNumber;

    public static /* synthetic */ void getVoucherAndTicketPageNumber$annotations() {
    }

    @Inject
    public VouchersAndTicketsDetailPresenter(VouchersAndTicketsDetailContract.View view, GetUserPocketWalletAsset getUserPocketWalletAsset, Lazy<SetPocketUpdate> lazy) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getUserPocketWalletAsset, "");
        Intrinsics.checkNotNullParameter(lazy, "");
        this.view = view;
        this.getUserPocketWalletAsset = getUserPocketWalletAsset;
        this.setPocketUpdate = lazy;
        this.voucherAndTicketPageNumber = 2;
    }

    @JvmName(name = "getVoucherAndTicketPageNumber")
    public final int getVoucherAndTicketPageNumber() {
        return this.voucherAndTicketPageNumber;
    }

    @JvmName(name = "setVoucherAndTicketPageNumber")
    public final void setVoucherAndTicketPageNumber(int i) {
        this.voucherAndTicketPageNumber = i;
    }

    @Override // id.dana.wallet_v3.vouchersandtickets.presenter.VouchersAndTicketsDetailContract.Presenter
    public final void getVoucherAndTicketAsset(boolean isNeedResetPagination, boolean fromSortAsset, String order, List<String> assetTypes) {
        Intrinsics.checkNotNullParameter(order, "");
        Intrinsics.checkNotNullParameter(assetTypes, "");
        this.view.viewLoadingGetVoucherAndTicketAsset();
        if (fromSortAsset) {
            this.voucherAndTicketPageNumber = 1;
        } else if (isNeedResetPagination) {
            this.voucherAndTicketPageNumber = 2;
        }
        this.getUserPocketWalletAsset.execute(new GetUserPocketWalletAsset.Param(this.voucherAndTicketPageNumber, 10, CollectionsKt.listOf((Object[]) new AssetStatus[]{AssetStatus.INIT, AssetStatus.EXPIRING}), assetTypes, order), new Function1<UserPocketAssetListModel<UserPocketAssetModel>, Unit>() { // from class: id.dana.wallet_v3.vouchersandtickets.presenter.VouchersAndTicketsDetailPresenter$getVoucherAndTicketAsset$1
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
                VouchersAndTicketsDetailContract.View view;
                VouchersAndTicketsDetailContract.View view2;
                Intrinsics.checkNotNullParameter(userPocketAssetListModel, "");
                view = VouchersAndTicketsDetailPresenter.this.view;
                view.dismissLoadingGetVoucherAndTicketAsset();
                view2 = VouchersAndTicketsDetailPresenter.this.view;
                view2.onGetVoucherAndTicketAssetSuccess(UserPocketAssetsMapperKt.toNewPocketQueryListModel(userPocketAssetListModel, new Function1<UserPocketAssetModel, VoucherAndTicketCardModel>() { // from class: id.dana.wallet_v3.vouchersandtickets.presenter.VouchersAndTicketsDetailPresenter$getVoucherAndTicketAsset$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final VoucherAndTicketCardModel invoke(UserPocketAssetModel userPocketAssetModel) {
                        Intrinsics.checkNotNullParameter(userPocketAssetModel, "");
                        return UserPocketAssetsMapperKt.toVoucherAndTicketCardModel(userPocketAssetModel, false);
                    }
                }));
                VouchersAndTicketsDetailPresenter vouchersAndTicketsDetailPresenter = VouchersAndTicketsDetailPresenter.this;
                vouchersAndTicketsDetailPresenter.setVoucherAndTicketPageNumber(vouchersAndTicketsDetailPresenter.getVoucherAndTicketPageNumber() + 1);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.vouchersandtickets.presenter.VouchersAndTicketsDetailPresenter$getVoucherAndTicketAsset$2
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
                VouchersAndTicketsDetailContract.View view;
                VouchersAndTicketsDetailContract.View view2;
                Intrinsics.checkNotNullParameter(th, "");
                view = VouchersAndTicketsDetailPresenter.this.view;
                view.dismissLoadingGetVoucherAndTicketAsset();
                view2 = VouchersAndTicketsDetailPresenter.this.view;
                view2.onGetVoucherAndTicketAssetError();
            }
        });
    }

    @Override // id.dana.wallet_v3.vouchersandtickets.presenter.VouchersAndTicketsDetailContract.Presenter
    public final void updatePocketAsset(final int position, String pocketId) {
        SetPocketUpdate setPocketUpdate = this.setPocketUpdate.get();
        if (pocketId == null) {
            pocketId = "";
        }
        setPocketUpdate.execute(pocketId, new Function1<PocketUpdateModel, Unit>() { // from class: id.dana.wallet_v3.vouchersandtickets.presenter.VouchersAndTicketsDetailPresenter$updatePocketAsset$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(PocketUpdateModel pocketUpdateModel) {
                invoke2(pocketUpdateModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(PocketUpdateModel pocketUpdateModel) {
                VouchersAndTicketsDetailContract.View view;
                VouchersAndTicketsDetailContract.View view2;
                Intrinsics.checkNotNullParameter(pocketUpdateModel, "");
                if (pocketUpdateModel.isSuccess()) {
                    view2 = VouchersAndTicketsDetailPresenter.this.view;
                    view2.onSuccessUpdateVoucherAssets(position);
                    return;
                }
                view = VouchersAndTicketsDetailPresenter.this.view;
                view.onErrorUpdateVoucherAssets();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.vouchersandtickets.presenter.VouchersAndTicketsDetailPresenter$updatePocketAsset$2
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
                VouchersAndTicketsDetailContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = VouchersAndTicketsDetailPresenter.this.view;
                view.onErrorUpdateVoucherAssets();
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.getUserPocketWalletAsset.dispose();
        this.setPocketUpdate.get().dispose();
    }
}
