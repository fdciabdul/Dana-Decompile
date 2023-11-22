package id.dana.bank.contract;

import id.dana.bank.contract.BankListContract;
import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.requestmoney.interactor.GetTopFeaturedBanks;
import id.dana.domain.sendmoney.model.TransferInit;
import id.dana.domain.withdraw.interactor.GetAvailableBanks;
import id.dana.sendmoney.mapper.BankModelMapper;
import id.dana.sendmoney.model.BankModel;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u0014\u0012\u0006\u0010\u001d\u001a\u00020\u0010¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0005\u0010\u000bR$\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0011\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0019X\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u001a"}, d2 = {"Lid/dana/bank/contract/BankListPresenter;", "Lid/dana/bank/contract/BankListContract$Presenter;", "Lid/dana/domain/sendmoney/model/TransferInit;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/domain/sendmoney/model/TransferInit;)V", "MyBillsEntityDataFactory", "()V", "onDestroy", "", "(Ljava/lang/String;)V", "Ljava/util/ArrayList;", "Lid/dana/sendmoney/model/BankModel;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "Lid/dana/sendmoney/mapper/BankModelMapper;", "PlaceComponentResult", "Lid/dana/sendmoney/mapper/BankModelMapper;", "getAuthRequestContext", "Lid/dana/domain/withdraw/interactor/GetAvailableBanks;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/withdraw/interactor/GetAvailableBanks;", "Lid/dana/domain/requestmoney/interactor/GetTopFeaturedBanks;", "Lid/dana/domain/requestmoney/interactor/GetTopFeaturedBanks;", "Lid/dana/bank/contract/BankListContract$View;", "Lid/dana/bank/contract/BankListContract$View;", "p1", "p2", "p3", "<init>", "(Lid/dana/bank/contract/BankListContract$View;Lid/dana/domain/requestmoney/interactor/GetTopFeaturedBanks;Lid/dana/domain/withdraw/interactor/GetAvailableBanks;Lid/dana/sendmoney/mapper/BankModelMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BankListPresenter implements BankListContract.Presenter {
    private final ArrayList<BankModel> BuiltInFictitiousFunctionClassFactory;
    private final GetAvailableBanks KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final GetTopFeaturedBanks PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final BankModelMapper getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final BankListContract.View MyBillsEntityDataFactory;

    @Inject
    public BankListPresenter(BankListContract.View view, GetTopFeaturedBanks getTopFeaturedBanks, GetAvailableBanks getAvailableBanks, BankModelMapper bankModelMapper) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getTopFeaturedBanks, "");
        Intrinsics.checkNotNullParameter(getAvailableBanks, "");
        Intrinsics.checkNotNullParameter(bankModelMapper, "");
        this.MyBillsEntityDataFactory = view;
        this.PlaceComponentResult = getTopFeaturedBanks;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getAvailableBanks;
        this.getAuthRequestContext = bankModelMapper;
        this.BuiltInFictitiousFunctionClassFactory = new ArrayList<>();
    }

    @Override // id.dana.bank.contract.BankListContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.MyBillsEntityDataFactory.showProgress();
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(new DefaultObserver<TransferInit>() { // from class: id.dana.bank.contract.BankListPresenter$getFeaturedAllBanks$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                BankModelMapper bankModelMapper;
                ArrayList arrayList;
                TransferInit transferInit = (TransferInit) obj;
                Intrinsics.checkNotNullParameter(transferInit, "");
                BankListPresenter.this.MyBillsEntityDataFactory.dismissProgress();
                bankModelMapper = BankListPresenter.this.getAuthRequestContext;
                List<BankModel> apply = bankModelMapper.apply(transferInit);
                BankListPresenter bankListPresenter = BankListPresenter.this;
                List<BankModel> list = apply;
                BankListContract.View view = bankListPresenter.MyBillsEntityDataFactory;
                Intrinsics.checkNotNullExpressionValue(list, "");
                List<? extends BankModel> sortedWith = CollectionsKt.sortedWith(list, new Comparator() { // from class: id.dana.bank.contract.BankListPresenter$getFeaturedAllBanks$1$onNext$lambda-2$$inlined$sortedBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((BankModel) t).scheduleImpl, ((BankModel) t2).scheduleImpl);
                    }
                });
                arrayList = bankListPresenter.BuiltInFictitiousFunctionClassFactory;
                arrayList.addAll(sortedWith);
                view.MyBillsEntityDataFactory(sortedWith);
                bankListPresenter.PlaceComponentResult.execute(NoParams.INSTANCE, new BankListPresenter$getTopBanks$1(bankListPresenter, list), BankListPresenter$getTopBanks$2.INSTANCE);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                BankListPresenter.this.MyBillsEntityDataFactory.dismissProgress();
                BankListContract.View view = BankListPresenter.this.MyBillsEntityDataFactory;
                String message = p0.getMessage();
                view.KClassImpl$Data$declaredNonStaticMembers$2(message != null ? message : "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.REQUEST_MONEY_TAG, p0.getMessage(), p0);
            }
        });
    }

    @Override // id.dana.bank.contract.BankListContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ArrayList arrayList = new ArrayList();
        ArrayList<BankModel> arrayList2 = this.BuiltInFictitiousFunctionClassFactory;
        ArrayList arrayList3 = new ArrayList();
        Iterator<T> it = arrayList2.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String str = ((BankModel) next).scheduleImpl;
            if (str != null && StringsKt.contains((CharSequence) str, (CharSequence) p0, true)) {
                z = true;
            }
            if (z) {
                arrayList3.add(next);
            }
        }
        ArrayList arrayList4 = arrayList3;
        ArrayList<BankModel> arrayList5 = this.BuiltInFictitiousFunctionClassFactory;
        ArrayList arrayList6 = new ArrayList();
        for (Object obj : arrayList5) {
            String str2 = ((BankModel) obj).NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (str2 != null && StringsKt.contains((CharSequence) str2, (CharSequence) p0, true)) {
                arrayList6.add(obj);
            }
        }
        arrayList.addAll(CollectionsKt.union(arrayList4, arrayList6));
        this.MyBillsEntityDataFactory.PlaceComponentResult(arrayList);
    }

    @Override // id.dana.bank.contract.BankListContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(TransferInit p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.MyBillsEntityDataFactory.showProgress();
        List<BankModel> apply = this.getAuthRequestContext.apply(p0);
        BankListContract.View view = this.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(apply, "");
        List<? extends BankModel> sortedWith = CollectionsKt.sortedWith(apply, new Comparator() { // from class: id.dana.bank.contract.BankListPresenter$getBankListFromTransferInit$lambda-4$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((BankModel) t).scheduleImpl, ((BankModel) t2).scheduleImpl);
            }
        });
        this.BuiltInFictitiousFunctionClassFactory.addAll(sortedWith);
        view.MyBillsEntityDataFactory(sortedWith);
        this.MyBillsEntityDataFactory.dismissProgress();
        this.PlaceComponentResult.execute(NoParams.INSTANCE, new BankListPresenter$getTopBanks$1(this, apply), BankListPresenter$getTopBanks$2.INSTANCE);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.PlaceComponentResult.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
    }
}
