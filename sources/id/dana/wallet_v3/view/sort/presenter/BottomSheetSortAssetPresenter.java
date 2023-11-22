package id.dana.wallet_v3.view.sort.presenter;

import dagger.Lazy;
import id.dana.animation.HomeTabActivity;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.wallet_v3.interactor.GetVoucherAndTicketOrder;
import id.dana.domain.wallet_v3.interactor.GetWalletSortCategory;
import id.dana.domain.wallet_v3.interactor.SaveVoucherAndTicketOrder;
import id.dana.domain.wallet_v3.model.SortCategory;
import id.dana.wallet_v3.view.sort.mapper.WalletSortMapperKt;
import id.dana.wallet_v3.view.sort.model.SortCategoryModel;
import id.dana.wallet_v3.view.sort.presenter.BottomSheetSortAssetContract;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001BA\b\u0007\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0010\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0010\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0006R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0012R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012"}, d2 = {"Lid/dana/wallet_v3/view/sort/presenter/BottomSheetSortAssetPresenter;", "Lid/dana/wallet_v3/view/sort/presenter/BottomSheetSortAssetContract$Presenter;", "", HomeTabActivity.WALLET_SECTION, "", "getSortOrder", "(Ljava/lang/String;)V", "", "Lid/dana/wallet_v3/view/sort/model/SortCategoryModel;", "orders", "getVoucherAndTicketOrder", "(Ljava/util/List;)V", "onDestroy", "()V", "order", "saveVoucherTicketOrder", "Ldagger/Lazy;", "Lid/dana/domain/wallet_v3/interactor/GetVoucherAndTicketOrder;", "Ldagger/Lazy;", "Lid/dana/domain/wallet_v3/interactor/GetWalletSortCategory;", "getWalletSortCategory", "Lid/dana/domain/wallet_v3/interactor/SaveVoucherAndTicketOrder;", "saveVoucherAndTicketOrder", "Lid/dana/wallet_v3/view/sort/presenter/BottomSheetSortAssetContract$View;", "view", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BottomSheetSortAssetPresenter implements BottomSheetSortAssetContract.Presenter {
    private final Lazy<GetVoucherAndTicketOrder> getVoucherAndTicketOrder;
    private final Lazy<GetWalletSortCategory> getWalletSortCategory;
    private final Lazy<SaveVoucherAndTicketOrder> saveVoucherAndTicketOrder;
    private final Lazy<BottomSheetSortAssetContract.View> view;

    @Inject
    public BottomSheetSortAssetPresenter(Lazy<BottomSheetSortAssetContract.View> lazy, Lazy<GetWalletSortCategory> lazy2, Lazy<SaveVoucherAndTicketOrder> lazy3, Lazy<GetVoucherAndTicketOrder> lazy4) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        Intrinsics.checkNotNullParameter(lazy4, "");
        this.view = lazy;
        this.getWalletSortCategory = lazy2;
        this.saveVoucherAndTicketOrder = lazy3;
        this.getVoucherAndTicketOrder = lazy4;
    }

    @Override // id.dana.wallet_v3.view.sort.presenter.BottomSheetSortAssetContract.Presenter
    public final void getSortOrder(String section) {
        Intrinsics.checkNotNullParameter(section, "");
        this.getWalletSortCategory.get().execute(new GetWalletSortCategory.Params(section), new Function1<List<? extends SortCategory>, Unit>() { // from class: id.dana.wallet_v3.view.sort.presenter.BottomSheetSortAssetPresenter$getSortOrder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends SortCategory> list) {
                invoke2((List<SortCategory>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<SortCategory> list) {
                Lazy lazy;
                Intrinsics.checkNotNullParameter(list, "");
                List<SortCategoryModel> listSortCategoryModel = WalletSortMapperKt.toListSortCategoryModel(list);
                lazy = BottomSheetSortAssetPresenter.this.view;
                ((BottomSheetSortAssetContract.View) lazy.get()).onSuccessGetOrderCategory(listSortCategoryModel);
                BottomSheetSortAssetPresenter.this.getVoucherAndTicketOrder(listSortCategoryModel);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.view.sort.presenter.BottomSheetSortAssetPresenter$getSortOrder$2
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
                Lazy lazy;
                Intrinsics.checkNotNullParameter(th, "");
                lazy = BottomSheetSortAssetPresenter.this.view;
                ((BottomSheetSortAssetContract.View) lazy.get()).onErrorGetOrderCategory();
            }
        });
    }

    @Override // id.dana.wallet_v3.view.sort.presenter.BottomSheetSortAssetContract.Presenter
    public final void saveVoucherTicketOrder(String order) {
        Intrinsics.checkNotNullParameter(order, "");
        SaveVoucherAndTicketOrder saveVoucherAndTicketOrder = this.saveVoucherAndTicketOrder.get();
        Intrinsics.checkNotNullExpressionValue(saveVoucherAndTicketOrder, "");
        BaseUseCase.execute$default(saveVoucherAndTicketOrder, order, new Function1<Unit, Unit>() { // from class: id.dana.wallet_v3.view.sort.presenter.BottomSheetSortAssetPresenter$saveVoucherTicketOrder$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Unit unit) {
                Intrinsics.checkNotNullParameter(unit, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }
        }, null, 4, null);
    }

    @Override // id.dana.wallet_v3.view.sort.presenter.BottomSheetSortAssetContract.Presenter
    public final void getVoucherAndTicketOrder(final List<SortCategoryModel> orders) {
        Intrinsics.checkNotNullParameter(orders, "");
        this.getVoucherAndTicketOrder.get().execute(NoParams.INSTANCE, new Function1<String, Unit>() { // from class: id.dana.wallet_v3.view.sort.presenter.BottomSheetSortAssetPresenter$getVoucherAndTicketOrder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                Object obj;
                Lazy lazy;
                Intrinsics.checkNotNullParameter(str, "");
                if ((!orders.isEmpty()) == true) {
                    Iterator<T> it = orders.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (Intrinsics.areEqual(((SortCategoryModel) obj).getOrder().name(), str)) {
                            break;
                        }
                    }
                    int indexOf = CollectionsKt.indexOf((List<? extends SortCategoryModel>) orders, (SortCategoryModel) obj);
                    lazy = this.view;
                    ((BottomSheetSortAssetContract.View) lazy.get()).onSuccessGetVoucherAndTicketOrder(indexOf, str);
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.view.sort.presenter.BottomSheetSortAssetPresenter$getVoucherAndTicketOrder$2
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
                Lazy lazy;
                Intrinsics.checkNotNullParameter(th, "");
                lazy = BottomSheetSortAssetPresenter.this.view;
                ((BottomSheetSortAssetContract.View) lazy.get()).onErrorGetVoucherAndTicketOrder();
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.getWalletSortCategory.get().dispose();
        this.saveVoucherAndTicketOrder.get().dispose();
        this.getVoucherAndTicketOrder.get().dispose();
    }
}
