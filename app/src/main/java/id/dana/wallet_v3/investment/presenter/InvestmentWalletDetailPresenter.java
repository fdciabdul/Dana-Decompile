package id.dana.wallet_v3.investment.presenter;

import dagger.Lazy;
import id.dana.base.AbstractContractKt;
import id.dana.domain.wallet_v3.interactor.GetUserPaymentWalletAsset;
import id.dana.domain.wallet_v3.model.CardAssetType;
import id.dana.domain.wallet_v3.model.UserAssetInfosModel;
import id.dana.wallet_v3.investment.presenter.InvestmentWalletDetailContract;
import id.dana.wallet_v3.mapper.UserPaymentAssetsMapperKt;
import id.dana.wallet_v3.model.InvestmentCardModel;
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

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u001d\u0010\t\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000e"}, d2 = {"Lid/dana/wallet_v3/investment/presenter/InvestmentWalletDetailPresenter;", "Lid/dana/wallet_v3/investment/presenter/InvestmentWalletDetailContract$Presenter;", "", "getInvestmentAsset", "()V", "onDestroy", "", "Lid/dana/domain/wallet_v3/model/UserAssetInfosModel;", "assetInfos", "onGetInvestmentCardsSuccess", "(Ljava/util/List;)V", "Ldagger/Lazy;", "Lid/dana/domain/wallet_v3/interactor/GetUserPaymentWalletAsset;", "getUserInvestmentWalletAsset", "Ldagger/Lazy;", "Lid/dana/wallet_v3/investment/presenter/InvestmentWalletDetailContract$View;", "view", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InvestmentWalletDetailPresenter implements InvestmentWalletDetailContract.Presenter {
    private final Lazy<GetUserPaymentWalletAsset> getUserInvestmentWalletAsset;
    private final Lazy<InvestmentWalletDetailContract.View> view;

    @Inject
    public InvestmentWalletDetailPresenter(Lazy<InvestmentWalletDetailContract.View> lazy, Lazy<GetUserPaymentWalletAsset> lazy2) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        this.view = lazy;
        this.getUserInvestmentWalletAsset = lazy2;
    }

    @Override // id.dana.wallet_v3.investment.presenter.InvestmentWalletDetailContract.Presenter
    public final void getInvestmentAsset() {
        this.getUserInvestmentWalletAsset.get().execute(new GetUserPaymentWalletAsset.Param(CollectionsKt.listOf((Object[]) new String[]{CardAssetType.EMAS.getAsset(), CardAssetType.DANA_PLUS.getAsset(), CardAssetType.GOALS.getAsset()})), new Function1<Pair<? extends List<? extends UserAssetInfosModel>, ? extends Map<String, ? extends String>>, Unit>() { // from class: id.dana.wallet_v3.investment.presenter.InvestmentWalletDetailPresenter$getInvestmentAsset$1
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
                InvestmentWalletDetailPresenter.this.onGetInvestmentCardsSuccess(pair.component1());
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.wallet_v3.investment.presenter.InvestmentWalletDetailPresenter$getInvestmentAsset$2
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
                lazy = InvestmentWalletDetailPresenter.this.view;
                ((InvestmentWalletDetailContract.View) lazy.get()).onErrorGetInvestmentAsset();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    public final void onGetInvestmentCardsSuccess(List<UserAssetInfosModel> assetInfos) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = assetInfos.iterator();
        while (it.hasNext()) {
            InvestmentCardModel financialCardModel = UserPaymentAssetsMapperKt.toFinancialCardModel((UserAssetInfosModel) it.next());
            if (financialCardModel != null) {
                arrayList.add(financialCardModel);
            }
        }
        List<? extends InvestmentCardModel> mutableList = CollectionsKt.toMutableList((Collection) CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: id.dana.wallet_v3.investment.presenter.InvestmentWalletDetailPresenter$onGetInvestmentCardsSuccess$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((InvestmentCardModel) t).getCardName(), ((InvestmentCardModel) t2).getCardName());
            }
        }));
        if (mutableList.isEmpty()) {
            InvestmentWalletDetailContract.View view = this.view.get();
            ?? r3 = 0;
            mutableList.add(new InvestmentCardModel.EmptyInvestmentCard(r3, 1, r3));
            view.onSuccessGetInvestmentAsset(mutableList);
            return;
        }
        this.view.get().onSuccessGetInvestmentAsset(UserPaymentAssetsMapperKt.reorderAssetDanaPlusToFirst(CollectionsKt.toMutableList((Collection) mutableList)));
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        AbstractContractKt.AbstractPresenter.CC.BuiltInFictitiousFunctionClassFactory();
        this.getUserInvestmentWalletAsset.get().dispose();
    }
}
