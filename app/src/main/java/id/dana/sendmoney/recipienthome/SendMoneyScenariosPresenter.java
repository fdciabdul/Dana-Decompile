package id.dana.sendmoney.recipienthome;

import android.content.Context;
import id.dana.di.PerActivity;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.sendmoney.interactor.GetSendMoneyScenarios;
import id.dana.mapper.SendMoneyScenariosMapper;
import id.dana.sendmoney.recipienthome.SendMoneyScenariosContract;
import id.dana.utils.ErrorUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@PerActivity
/* loaded from: classes5.dex */
public class SendMoneyScenariosPresenter implements SendMoneyScenariosContract.Presenter {
    final SendMoneyScenariosContract.View BuiltInFictitiousFunctionClassFactory;
    final SendMoneyScenariosMapper MyBillsEntityDataFactory;
    Context PlaceComponentResult;
    private final GetSendMoneyScenarios getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public SendMoneyScenariosPresenter(SendMoneyScenariosContract.View view, GetSendMoneyScenarios getSendMoneyScenarios, SendMoneyScenariosMapper sendMoneyScenariosMapper, Context context) {
        this.BuiltInFictitiousFunctionClassFactory = view;
        this.getAuthRequestContext = getSendMoneyScenarios;
        this.MyBillsEntityDataFactory = sendMoneyScenariosMapper;
        this.PlaceComponentResult = context;
    }

    @Override // id.dana.sendmoney.recipienthome.SendMoneyScenariosContract.Presenter
    public final void PlaceComponentResult() {
        this.getAuthRequestContext.execute(NoParams.INSTANCE, new Function1() { // from class: id.dana.sendmoney.recipienthome.SendMoneyScenariosPresenter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SendMoneyScenariosPresenter sendMoneyScenariosPresenter = SendMoneyScenariosPresenter.this;
                sendMoneyScenariosPresenter.BuiltInFictitiousFunctionClassFactory.dismissProgress();
                sendMoneyScenariosPresenter.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(sendMoneyScenariosPresenter.MyBillsEntityDataFactory.apply((List) obj));
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.sendmoney.recipienthome.SendMoneyScenariosPresenter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SendMoneyScenariosPresenter sendMoneyScenariosPresenter = SendMoneyScenariosPresenter.this;
                Throwable th = (Throwable) obj;
                sendMoneyScenariosPresenter.BuiltInFictitiousFunctionClassFactory.dismissProgress();
                sendMoneyScenariosPresenter.BuiltInFictitiousFunctionClassFactory.onError(ErrorUtil.PlaceComponentResult(th, sendMoneyScenariosPresenter.PlaceComponentResult));
                StringBuilder sb = new StringBuilder();
                sb.append(sendMoneyScenariosPresenter.getClass().getName());
                sb.append(", on Error: ");
                sb.append(th);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.SEND_MONEY_TAG, sb.toString());
                return Unit.INSTANCE;
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.getAuthRequestContext.dispose();
    }
}
