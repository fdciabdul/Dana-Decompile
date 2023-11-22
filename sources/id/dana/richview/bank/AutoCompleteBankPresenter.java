package id.dana.richview.bank;

import android.content.Context;
import id.dana.domain.DefaultObserver;
import id.dana.domain.sendmoney.model.TransferInit;
import id.dana.domain.withdraw.interactor.GetAvailableBanks;
import id.dana.richview.bank.AutoCompleteBankContract;
import id.dana.sendmoney.mapper.BankModelMapper;
import id.dana.sendmoney.mapper.TransferConfigModelMapper;
import id.dana.utils.ErrorUtil;
import javax.inject.Inject;

/* loaded from: classes9.dex */
public class AutoCompleteBankPresenter implements AutoCompleteBankContract.Presenter {
    private final TransferConfigModelMapper BuiltInFictitiousFunctionClassFactory;
    private final BankModelMapper KClassImpl$Data$declaredNonStaticMembers$2;
    private final GetAvailableBanks MyBillsEntityDataFactory;
    private final AutoCompleteBankContract.View PlaceComponentResult;
    private final Context getAuthRequestContext;

    @Inject
    public AutoCompleteBankPresenter(Context context, BankModelMapper bankModelMapper, GetAvailableBanks getAvailableBanks, AutoCompleteBankContract.View view, TransferConfigModelMapper transferConfigModelMapper) {
        this.getAuthRequestContext = context;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = bankModelMapper;
        this.MyBillsEntityDataFactory = getAvailableBanks;
        this.PlaceComponentResult = view;
        this.BuiltInFictitiousFunctionClassFactory = transferConfigModelMapper;
    }

    @Override // id.dana.richview.bank.AutoCompleteBankContract.Presenter
    public final void PlaceComponentResult() {
        this.MyBillsEntityDataFactory.execute(new DefaultObserver<TransferInit>() { // from class: id.dana.richview.bank.AutoCompleteBankPresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                TransferInit transferInit = (TransferInit) obj;
                AutoCompleteBankPresenter.this.PlaceComponentResult.onGetAvailableBanksSuccess(AutoCompleteBankPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2.apply(transferInit));
                if (AutoCompleteBankPresenter.this.BuiltInFictitiousFunctionClassFactory.apply(transferInit) != null) {
                    AutoCompleteBankPresenter.this.PlaceComponentResult.onGetSenderNameSuccess(AutoCompleteBankPresenter.this.BuiltInFictitiousFunctionClassFactory.apply(transferInit).BuiltInFictitiousFunctionClassFactory());
                }
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                AutoCompleteBankPresenter.this.PlaceComponentResult.onGetAvailableBanksFail(ErrorUtil.PlaceComponentResult(th, AutoCompleteBankPresenter.this.getAuthRequestContext));
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.MyBillsEntityDataFactory.dispose();
    }
}
