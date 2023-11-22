package id.dana.data.foundation.facade;

import android.app.Application;
import com.alipay.iap.android.aplog.core.uploader.UserDiagnostician;
import com.alipay.mobile.common.reach.ReachManager;
import id.dana.data.foundation.amcs.AMCSManager;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;
import reach.IAPReachMsgModel;
import reach.MessageReceiver;

@Singleton
/* loaded from: classes.dex */
public class IAPPushFacade {
    public final AMCSManager BuiltInFictitiousFunctionClassFactory;
    private final Application MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public IAPPushFacade(Application application, AMCSManager aMCSManager) {
        this.MyBillsEntityDataFactory = application;
        this.BuiltInFictitiousFunctionClassFactory = aMCSManager;
    }

    public final Observable<Void> getAuthRequestContext() {
        ReachManager.getInstance().init(this.MyBillsEntityDataFactory);
        final UserDiagnostician createInstance = UserDiagnostician.createInstance(this.MyBillsEntityDataFactory);
        ReachManager.getInstance().registerMsgReceiver("IAPLog", new MessageReceiver() { // from class: id.dana.data.foundation.facade.IAPPushFacade$$ExternalSyntheticLambda1
            @Override // reach.MessageReceiver
            public final void MyBillsEntityDataFactory(IAPReachMsgModel iAPReachMsgModel) {
                IAPPushFacade.BuiltInFictitiousFunctionClassFactory(UserDiagnostician.this, iAPReachMsgModel);
            }
        });
        return Observable.empty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(UserDiagnostician userDiagnostician, IAPReachMsgModel iAPReachMsgModel) {
        try {
            userDiagnostician.processPushMsgInWorkThread(iAPReachMsgModel.BuiltInFictitiousFunctionClassFactory);
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.DIAGNOSTIC_TAG, "processPushMsgInWorkThread error: ", e);
        }
    }
}
