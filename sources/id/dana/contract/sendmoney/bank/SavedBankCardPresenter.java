package id.dana.contract.sendmoney.bank;

import id.dana.contract.sendmoney.bank.SavedBankCardContract;
import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.recentbank.interactor.GetMaxSavedBank;
import id.dana.domain.recentbank.interactor.GetRecentBank;
import id.dana.domain.recentbank.interactor.SearchRecentBank;
import id.dana.domain.recentbank.model.RecentBank;
import id.dana.sendmoney.mapper.RecentBankModelMapper;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes4.dex */
public class SavedBankCardPresenter implements SavedBankCardContract.Presenter {
    private final SearchRecentBank BuiltInFictitiousFunctionClassFactory;
    private final GetMaxSavedBank KClassImpl$Data$declaredNonStaticMembers$2;
    final SavedBankCardContract.View MyBillsEntityDataFactory;
    private final GetRecentBank PlaceComponentResult;
    private final RecentBankModelMapper getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit BuiltInFictitiousFunctionClassFactory() {
        return null;
    }

    @Inject
    public SavedBankCardPresenter(SavedBankCardContract.View view, GetRecentBank getRecentBank, GetMaxSavedBank getMaxSavedBank, SearchRecentBank searchRecentBank, RecentBankModelMapper recentBankModelMapper) {
        this.MyBillsEntityDataFactory = view;
        this.PlaceComponentResult = getRecentBank;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getMaxSavedBank;
        this.BuiltInFictitiousFunctionClassFactory = searchRecentBank;
        this.getAuthRequestContext = recentBankModelMapper;
    }

    @Override // id.dana.contract.sendmoney.bank.SavedBankCardContract.Presenter
    public final void PlaceComponentResult() {
        this.PlaceComponentResult.execute(new DefaultObserver<List<RecentBank>>() { // from class: id.dana.contract.sendmoney.bank.SavedBankCardPresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                SavedBankCardContract.View view = SavedBankCardPresenter.this.MyBillsEntityDataFactory;
                RecentBankModelMapper unused = SavedBankCardPresenter.this.getAuthRequestContext;
                view.BuiltInFictitiousFunctionClassFactory(RecentBankModelMapper.PlaceComponentResult((List) obj));
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                SavedBankCardPresenter.this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
            }
        });
    }

    @Override // id.dana.contract.sendmoney.bank.SavedBankCardContract.Presenter
    public final void MyBillsEntityDataFactory(String str) {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.BuiltInFictitiousFunctionClassFactory.execute(new DefaultObserver<List<RecentBank>>() { // from class: id.dana.contract.sendmoney.bank.SavedBankCardPresenter.2
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                SavedBankCardContract.View view = SavedBankCardPresenter.this.MyBillsEntityDataFactory;
                RecentBankModelMapper unused = SavedBankCardPresenter.this.getAuthRequestContext;
                view.getAuthRequestContext(RecentBankModelMapper.PlaceComponentResult((List) obj));
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                SavedBankCardPresenter.this.MyBillsEntityDataFactory.getAuthRequestContext();
            }
        }, SearchRecentBank.Params.forSaveRecentBank(str));
    }

    @Override // id.dana.contract.sendmoney.bank.SavedBankCardContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.PlaceComponentResult.execute(new DefaultObserver<List<RecentBank>>() { // from class: id.dana.contract.sendmoney.bank.SavedBankCardPresenter.3
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                SavedBankCardContract.View view = SavedBankCardPresenter.this.MyBillsEntityDataFactory;
                RecentBankModelMapper unused = SavedBankCardPresenter.this.getAuthRequestContext;
                view.PlaceComponentResult(RecentBankModelMapper.PlaceComponentResult((List) obj));
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                SavedBankCardPresenter.this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        });
    }

    @Override // id.dana.contract.sendmoney.bank.SavedBankCardContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.contract.sendmoney.bank.SavedBankCardPresenter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SavedBankCardPresenter.this.MyBillsEntityDataFactory.getAuthRequestContext(((Integer) obj).intValue());
                return null;
            }
        }, new Function1() { // from class: id.dana.contract.sendmoney.bank.SavedBankCardPresenter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Throwable th = (Throwable) obj;
                return SavedBankCardPresenter.BuiltInFictitiousFunctionClassFactory();
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.PlaceComponentResult.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
    }
}
