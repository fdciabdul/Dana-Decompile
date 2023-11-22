package id.dana.contract.sendmoney;

import id.dana.contract.sendmoney.PayMethodContract;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.card.interactor.GetDefaultCard;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.sendmoney.interactor.CheckTransferX2PFeature;
import id.dana.domain.sendmoney.interactor.GetSendMoneyOption;
import id.dana.domain.sendmoney.model.SendMoneyInit;
import id.dana.domain.sendmoney.model.TransferInit;
import id.dana.sendmoney.mapper.ContactPayMethodMapper;
import id.dana.sendmoney.mapper.TransferMethod;
import id.dana.sendmoney.mapper.TransferMethodMapper;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@PerActivity
/* loaded from: classes4.dex */
public class PayMethodPresenter implements PayMethodContract.Presenter {
    private final GetDefaultCard BuiltInFictitiousFunctionClassFactory;
    private final ContactPayMethodMapper KClassImpl$Data$declaredNonStaticMembers$2;
    private final GetSendMoneyOption MyBillsEntityDataFactory;
    final PayMethodContract.View PlaceComponentResult;
    CheckTransferX2PFeature getAuthRequestContext;
    private final TransferMethodMapper scheduleImpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public PayMethodPresenter(ContactPayMethodMapper contactPayMethodMapper, GetDefaultCard getDefaultCard, PayMethodContract.View view, TransferMethodMapper transferMethodMapper, GetSendMoneyOption getSendMoneyOption) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = contactPayMethodMapper;
        this.MyBillsEntityDataFactory = getSendMoneyOption;
        this.PlaceComponentResult = view;
        this.scheduleImpl = transferMethodMapper;
        this.BuiltInFictitiousFunctionClassFactory = getDefaultCard;
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.MyBillsEntityDataFactory.dispose();
        this.getAuthRequestContext.dispose();
    }

    private static boolean MyBillsEntityDataFactory(String str, boolean z) {
        return "BALANCE".equals(str) && !z;
    }

    @Override // id.dana.contract.sendmoney.PayMethodContract.Presenter
    public final void PlaceComponentResult(final String str, final TransferInit transferInit) {
        this.getAuthRequestContext.execute(new DefaultObserver<Boolean>() { // from class: id.dana.contract.sendmoney.PayMethodPresenter.2
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                PayMethodPresenter.KClassImpl$Data$declaredNonStaticMembers$2(PayMethodPresenter.this, str, ((Boolean) obj).booleanValue(), transferInit);
            }
        });
    }

    @Override // id.dana.contract.sendmoney.PayMethodContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.BuiltInFictitiousFunctionClassFactory.execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.contract.sendmoney.PayMethodPresenter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                PayMethodPresenter.this.PlaceComponentResult.onGetDefaultCardSuccess((String) obj);
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.contract.sendmoney.PayMethodPresenter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Throwable th = (Throwable) obj;
                PayMethodPresenter.this.PlaceComponentResult.onGetDefaultCardError();
                return Unit.INSTANCE;
            }
        });
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(PayMethodPresenter payMethodPresenter, String str, boolean z, TransferInit transferInit) {
        TransferMethod transferMethod;
        payMethodPresenter.PlaceComponentResult.showProgress();
        if (MyBillsEntityDataFactory(str, z)) {
            payMethodPresenter.PlaceComponentResult.showProgress();
            payMethodPresenter.MyBillsEntityDataFactory.execute(new DefaultObserver<SendMoneyInit>() { // from class: id.dana.contract.sendmoney.PayMethodPresenter.1
                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public /* synthetic */ void onNext(Object obj) {
                    SendMoneyInit sendMoneyInit = (SendMoneyInit) obj;
                    PayMethodPresenter.this.PlaceComponentResult.onGetPayMethodListSuccess(PayMethodPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2.apply(sendMoneyInit), sendMoneyInit.getKyc().getLevel());
                    PayMethodPresenter.this.PlaceComponentResult.dismissProgress();
                }

                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public void onError(Throwable th) {
                    PayMethodPresenter.this.PlaceComponentResult.onGetPayMethodError();
                    PayMethodPresenter.this.PlaceComponentResult.dismissProgress();
                    super.onError(th);
                }
            });
            return;
        }
        Iterator<TransferMethod> it = payMethodPresenter.scheduleImpl.apply(transferInit).iterator();
        while (true) {
            if (!it.hasNext()) {
                transferMethod = null;
                break;
            }
            transferMethod = it.next();
            if (str.equals(transferMethod.MyBillsEntityDataFactory)) {
                break;
            }
        }
        if (transferMethod != null) {
            payMethodPresenter.PlaceComponentResult.onGetPayMethodListSuccess(transferMethod.getAuthRequestContext, transferInit.getKyc());
        } else {
            payMethodPresenter.PlaceComponentResult.onGetPayMethodError();
        }
        payMethodPresenter.PlaceComponentResult.dismissProgress();
    }
}
