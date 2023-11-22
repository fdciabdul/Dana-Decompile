package id.dana;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.alipay.iap.android.common.utils.NetworkUtils;
import id.dana.animation.HomeErrorDialog;
import id.dana.domain.DefaultObserver;
import id.dana.domain.featureconfig.interactor.IsOfflineF2FPay;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.utils.ContextUtil;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.completable.CompletableObserveOn;
import io.reactivex.internal.operators.completable.CompletableSubscribeOn;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;

/* loaded from: classes.dex */
public class ConnectionStatusReceiver extends BroadcastReceiver {
    private HomeErrorDialog PlaceComponentResult;
    private final IsOfflineF2FPay getAuthRequestContext;
    public final SSLPinningRepository sslPinningRepository;
    public final ThreadExecutor threadExecutor;

    static /* synthetic */ boolean access$000(ConnectionStatusReceiver connectionStatusReceiver, Context context) {
        return getAuthRequestContext(context);
    }

    @Inject
    public ConnectionStatusReceiver(ThreadExecutor threadExecutor, SSLPinningRepository sSLPinningRepository, IsOfflineF2FPay isOfflineF2FPay) {
        this.sslPinningRepository = sSLPinningRepository;
        this.getAuthRequestContext = isOfflineF2FPay;
        this.threadExecutor = threadExecutor;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        final boolean isNetworkAvailable = NetworkUtils.isNetworkAvailable(context);
        if (isNetworkAvailable && !this.sslPinningRepository.isSslPinningSuccess().booleanValue()) {
            Completable ignoreElements = this.sslPinningRepository.pinCertificates().ignoreElements();
            Scheduler BuiltInFictitiousFunctionClassFactory = Schedulers.BuiltInFictitiousFunctionClassFactory(this.threadExecutor);
            ObjectHelper.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory, "scheduler is null");
            Completable KClassImpl$Data$declaredNonStaticMembers$2 = RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableSubscribeOn(ignoreElements, BuiltInFictitiousFunctionClassFactory));
            Scheduler BuiltInFictitiousFunctionClassFactory2 = Schedulers.BuiltInFictitiousFunctionClassFactory(this.threadExecutor);
            ObjectHelper.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory2, "scheduler is null");
            RxJavaPlugins.KClassImpl$Data$declaredNonStaticMembers$2(new CompletableObserveOn(KClassImpl$Data$declaredNonStaticMembers$2, BuiltInFictitiousFunctionClassFactory2)).q_();
        }
        this.getAuthRequestContext.execute(new DefaultObserver<Boolean>() { // from class: id.dana.ConnectionStatusReceiver.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                if (Boolean.TRUE.equals((Boolean) obj) || !ConnectionStatusReceiver.access$000(ConnectionStatusReceiver.this, context)) {
                    return;
                }
                if (!isNetworkAvailable) {
                    if (ConnectionStatusReceiver.this.PlaceComponentResult == null) {
                        ConnectionStatusReceiver.this.PlaceComponentResult = new HomeErrorDialog(context);
                        ConnectionStatusReceiver.this.PlaceComponentResult.setCanceledOnTouchOutside(false);
                    }
                    ConnectionStatusReceiver.this.PlaceComponentResult.show();
                } else if (ConnectionStatusReceiver.this.PlaceComponentResult != null) {
                    ConnectionStatusReceiver.this.PlaceComponentResult.dismiss();
                }
            }
        });
    }

    private static boolean getAuthRequestContext(Context context) {
        return (context instanceof Activity) && ContextUtil.BuiltInFictitiousFunctionClassFactory(context);
    }
}
