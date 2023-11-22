package id.dana.wallet_v3.payment.presenter;

import dagger.Lazy;
import id.dana.base.AbstractContractKt;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.wallet_v3.interactor.GetBottomSheetServices;
import id.dana.domain.wallet_v3.interactor.GetUserPaymentWalletAsset;
import id.dana.domain.wallet_v3.model.CardAssetType;
import id.dana.domain.wallet_v3.model.UserAssetInfosModel;
import id.dana.mapper.ThirdPartyServicesMapper;
import id.dana.model.ThirdPartyService;
import id.dana.wallet_v3.mapper.UserPaymentAssetsMapperKt;
import id.dana.wallet_v3.model.PaymentCardModel;
import id.dana.wallet_v3.payment.presenter.PaymentWalletDetailContract;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B5\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\f\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u001d\u0010\n\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/wallet_v3/payment/presenter/PaymentWalletDetailPresenter;", "Lid/dana/wallet_v3/payment/presenter/PaymentWalletDetailContract$Presenter;", "", "getPaymentAssets", "()V", "getPaymentServices", "onDestroy", "", "Lid/dana/domain/wallet_v3/model/UserAssetInfosModel;", "assetInfos", "onGetPaymentCardsSuccess", "(Ljava/util/List;)V", "Ldagger/Lazy;", "Lid/dana/domain/wallet_v3/interactor/GetBottomSheetServices;", "getBottomSheetServices", "Ldagger/Lazy;", "Lid/dana/domain/wallet_v3/interactor/GetUserPaymentWalletAsset;", "getUserPaymentWalletAsset", "Lid/dana/mapper/ThirdPartyServicesMapper;", "mapper", "Lid/dana/mapper/ThirdPartyServicesMapper;", "Lid/dana/wallet_v3/payment/presenter/PaymentWalletDetailContract$View;", "view", "Lid/dana/wallet_v3/payment/presenter/PaymentWalletDetailContract$View;", "<init>", "(Lid/dana/wallet_v3/payment/presenter/PaymentWalletDetailContract$View;Ldagger/Lazy;Ldagger/Lazy;Lid/dana/mapper/ThirdPartyServicesMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PaymentWalletDetailPresenter implements PaymentWalletDetailContract.Presenter {
    private final Lazy<GetBottomSheetServices> getBottomSheetServices;
    private final Lazy<GetUserPaymentWalletAsset> getUserPaymentWalletAsset;
    private final ThirdPartyServicesMapper mapper;
    private final PaymentWalletDetailContract.View view;

    @Inject
    public PaymentWalletDetailPresenter(PaymentWalletDetailContract.View view, Lazy<GetUserPaymentWalletAsset> lazy, Lazy<GetBottomSheetServices> lazy2, ThirdPartyServicesMapper thirdPartyServicesMapper) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(thirdPartyServicesMapper, "");
        this.view = view;
        this.getUserPaymentWalletAsset = lazy;
        this.getBottomSheetServices = lazy2;
        this.mapper = thirdPartyServicesMapper;
    }

    @Override // id.dana.wallet_v3.payment.presenter.PaymentWalletDetailContract.Presenter
    public final void getPaymentAssets() {
        List listOf = CollectionsKt.listOf((Object[]) new String[]{CardAssetType.BALANCE.getAsset(), CardAssetType.CREDIT_CARD.getAsset(), CardAssetType.DEBIT_CARD.getAsset(), CardAssetType.PAYLATER.getAsset()});
        GetUserPaymentWalletAsset getUserPaymentWalletAsset = this.getUserPaymentWalletAsset.get();
        Intrinsics.checkNotNullExpressionValue(getUserPaymentWalletAsset, "");
        BaseUseCase.execute$default(getUserPaymentWalletAsset, new GetUserPaymentWalletAsset.Param(listOf), new Function1<Pair<? extends List<? extends UserAssetInfosModel>, ? extends Map<String, ? extends String>>, Unit>() { // from class: id.dana.wallet_v3.payment.presenter.PaymentWalletDetailPresenter$getPaymentAssets$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Pair<? extends List<? extends UserAssetInfosModel>, ? extends Map<String, ? extends String>> pair) {
                invoke2((Pair<? extends List<UserAssetInfosModel>, ? extends Map<String, String>>) pair);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<? extends List<UserAssetInfosModel>, ? extends Map<String, String>> pair) {
                Intrinsics.checkNotNullParameter(pair, "");
                PaymentWalletDetailPresenter.this.onGetPaymentCardsSuccess(pair.component1());
            }
        }, null, 4, null);
    }

    @Override // id.dana.wallet_v3.payment.presenter.PaymentWalletDetailContract.Presenter
    public final void getPaymentServices() {
        this.getBottomSheetServices.get().execute(1, new Function1<List<? extends ThirdPartyServiceResponse>, Unit>() { // from class: id.dana.wallet_v3.payment.presenter.PaymentWalletDetailPresenter$getPaymentServices$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends ThirdPartyServiceResponse> list) {
                invoke2((List<ThirdPartyServiceResponse>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<ThirdPartyServiceResponse> list) {
                PaymentWalletDetailContract.View view;
                ThirdPartyServicesMapper unused;
                Intrinsics.checkNotNullParameter(list, "");
                unused = PaymentWalletDetailPresenter.this.mapper;
                List<ThirdPartyService> mutableList = CollectionsKt.toMutableList((Collection) ThirdPartyServicesMapper.KClassImpl$Data$declaredNonStaticMembers$2(list));
                view = PaymentWalletDetailPresenter.this.view;
                view.onSuccessGetPaymentServices(mutableList);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.payment.presenter.PaymentWalletDetailPresenter$getPaymentServices$2
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
                PaymentWalletDetailContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = PaymentWalletDetailPresenter.this.view;
                view.onErrorGetPaymentServices();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public final void onGetPaymentCardsSuccess(List<UserAssetInfosModel> assetInfos) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = assetInfos.iterator();
        while (it.hasNext()) {
            PaymentCardModel paymentCardModel = UserPaymentAssetsMapperKt.toPaymentCardModel((UserAssetInfosModel) it.next());
            if (paymentCardModel != null) {
                arrayList.add(paymentCardModel);
            }
        }
        List<? extends PaymentCardModel> mutableList = CollectionsKt.toMutableList((Collection) CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: id.dana.wallet_v3.payment.presenter.PaymentWalletDetailPresenter$onGetPaymentCardsSuccess$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((PaymentCardModel) t).getCardName(), ((PaymentCardModel) t2).getCardName());
            }
        }));
        int i = 1;
        if (mutableList.isEmpty()) {
            PaymentWalletDetailContract.View view = this.view;
            mutableList.add(new PaymentCardModel.EmptyCard(r2, i, r2));
            view.onGetPaymentAsset(mutableList);
            return;
        }
        if (mutableList.size() == 1) {
            PaymentCardModel paymentCardModel2 = (PaymentCardModel) CollectionsKt.firstOrNull((List) mutableList);
            if (Intrinsics.areEqual(paymentCardModel2 != null ? paymentCardModel2.getAssetType() : 0, CardAssetType.BALANCE.getAsset())) {
                this.view.onGetPaymentAsset(UserPaymentAssetsMapperKt.reorderAssetEmptyPlaceholderToFirst(mutableList));
                return;
            }
        }
        this.view.onGetPaymentAsset(UserPaymentAssetsMapperKt.reorderAssetBalanceToFirst(mutableList));
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        AbstractContractKt.AbstractPresenter.CC.BuiltInFictitiousFunctionClassFactory();
        this.getUserPaymentWalletAsset.get().dispose();
        this.getBottomSheetServices.get().dispose();
    }
}
