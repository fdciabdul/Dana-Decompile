package id.dana;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import dagger.Lazy;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.constants.ErrorCode;
import id.dana.contract.deeplink.DeeplinkSaveDataManager;
import id.dana.contract.payasset.SceneType;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.domain.payasset.interactor.QueryPayMethod;
import id.dana.domain.payasset.model.QueryPayMethodResponse;
import id.dana.utils.session.SessionExpiredManager;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
public class DanaLocalBroadcastReceiver extends BroadcastReceiver {
    private final Lazy<QueryPayMethod> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Lazy<DeviceInformationProvider> MyBillsEntityDataFactory;
    private final Lazy<SessionExpiredManager> getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit lambda$onReceive$0(QueryPayMethodResponse queryPayMethodResponse) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit lambda$onReceive$1(Throwable th) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit lambda$onReceive$2(QueryPayMethodResponse queryPayMethodResponse) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Unit lambda$onReceive$3(Throwable th) {
        return null;
    }

    @Inject
    public DanaLocalBroadcastReceiver(Lazy<DeviceInformationProvider> lazy, Lazy<QueryPayMethod> lazy2, Lazy<SessionExpiredManager> lazy3) {
        this.MyBillsEntityDataFactory = lazy;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy2;
        this.getAuthRequestContext = lazy3;
    }

    public static void registerLocalBroadCastRecevier(Context context, DanaLocalBroadcastReceiver danaLocalBroadcastReceiver) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("id.dana.splash");
        intentFilter.addAction("IAPAppContainer_cardChannelHasChange");
        LocalBroadcastManager.getInstance(context).registerReceiver(danaLocalBroadcastReceiver, intentFilter);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        if ("IAPAppContainer_cardChannelHasChange".equals(intent.getAction())) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.get().execute(QueryPayMethod.Params.INSTANCE.forF2FPayUtdid(this.MyBillsEntityDataFactory.get().generateDeviceId(context), true), new Function1() { // from class: id.dana.DanaLocalBroadcastReceiver$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DanaLocalBroadcastReceiver.lambda$onReceive$0((QueryPayMethodResponse) obj);
                }
            }, new Function1() { // from class: id.dana.DanaLocalBroadcastReceiver$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DanaLocalBroadcastReceiver.lambda$onReceive$1((Throwable) obj);
                }
            });
            this.KClassImpl$Data$declaredNonStaticMembers$2.get().execute(QueryPayMethod.Params.INSTANCE.forQueryAsset(this.MyBillsEntityDataFactory.get().generateDeviceId(context), SceneType.ASSETS, true), new Function1() { // from class: id.dana.DanaLocalBroadcastReceiver$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DanaLocalBroadcastReceiver.lambda$onReceive$2((QueryPayMethodResponse) obj);
                }
            }, new Function1() { // from class: id.dana.DanaLocalBroadcastReceiver$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DanaLocalBroadcastReceiver.lambda$onReceive$3((Throwable) obj);
                }
            });
        }
        if (!"id.dana.splash".equals(intent.getAction())) {
            if ("SUSPENDED".equals(intent.getAction())) {
                this.getAuthRequestContext.get().BuiltInFictitiousFunctionClassFactory(ErrorCode.ACCESS_TOKEN_NOT_ACTIVE);
                return;
            } else if ("FROZEN".equals(intent.getAction())) {
                this.getAuthRequestContext.get().BuiltInFictitiousFunctionClassFactory("AE15112158065208");
                return;
            } else {
                return;
            }
        }
        String str = DeeplinkSaveDataManager.MyBillsEntityDataFactory().PlaceComponentResult;
        if (str == null) {
            str = "";
        }
        String str2 = DeeplinkSaveDataManager.MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory;
        if (str2 == null) {
            str2 = "";
        }
        if (str.isEmpty() && str2.isEmpty()) {
            DeeplinkSaveDataManager.MyBillsEntityDataFactory().NetworkUserEntityData$$ExternalSyntheticLambda0();
        } else {
            DeeplinkSaveDataManager.MyBillsEntityDataFactory().moveToNextValue = Boolean.TRUE;
            DeeplinkSaveDataManager.MyBillsEntityDataFactory().NetworkUserEntityData$$ExternalSyntheticLambda0 = Boolean.FALSE;
        }
        final SessionExpiredManager sessionExpiredManager = this.getAuthRequestContext.get();
        synchronized (SessionExpiredManager.class) {
            Activity activity = sessionExpiredManager.BuiltInFictitiousFunctionClassFactory.get().BuiltInFictitiousFunctionClassFactory.get();
            if (!sessionExpiredManager.getAuthRequestContext() && !SessionExpiredManager.getAuthRequestContext(activity) && activity != null) {
                CustomDialog.Builder builder = new CustomDialog.Builder(activity);
                CustomDialog.Builder builder2 = builder;
                builder.SubSequence = sessionExpiredManager.MyBillsEntityDataFactory.get().getString(R.string.session_expired_title);
                CustomDialog.Builder builder3 = builder;
                builder.GetContactSyncConfig = sessionExpiredManager.MyBillsEntityDataFactory.get().getString(R.string.session_expired_desc);
                CustomDialog.Builder PlaceComponentResult = builder.KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false);
                String string = sessionExpiredManager.MyBillsEntityDataFactory.get().getString(R.string.session_expired_button);
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.utils.session.SessionExpiredManager$$ExternalSyntheticLambda6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SessionExpiredManager sessionExpiredManager2 = SessionExpiredManager.this;
                        sessionExpiredManager2.getAuthRequestContext.dismiss();
                        sessionExpiredManager2.MyBillsEntityDataFactory();
                    }
                };
                CustomDialog.Builder builder4 = PlaceComponentResult;
                PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda6 = string;
                PlaceComponentResult.getSupportButtonTintMode = onClickListener;
                sessionExpiredManager.getAuthRequestContext = PlaceComponentResult.BuiltInFictitiousFunctionClassFactory();
                if (!activity.isFinishing()) {
                    sessionExpiredManager.getAuthRequestContext.show();
                }
                sessionExpiredManager.KClassImpl$Data$declaredNonStaticMembers$2.get().getAuthRequestContext(new Function0() { // from class: id.dana.utils.session.SessionExpiredManager$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                }, new Function1() { // from class: id.dana.utils.session.SessionExpiredManager$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit unit;
                        Throwable th = (Throwable) obj;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                });
                sessionExpiredManager.PlaceComponentResult.getAuthRequestContext(Observable.timer(3L, TimeUnit.SECONDS, Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new Consumer() { // from class: id.dana.utils.session.SessionExpiredManager$$ExternalSyntheticLambda7
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        SessionExpiredManager sessionExpiredManager2 = SessionExpiredManager.this;
                        Long l = (Long) obj;
                        sessionExpiredManager2.getAuthRequestContext.dismiss();
                        sessionExpiredManager2.MyBillsEntityDataFactory();
                    }
                }));
            }
        }
    }
}
