package id.dana.util;

import com.alibaba.griver.bluetooth.altbeacon.beacon.service.RangedBeacon;
import id.dana.RxIAPConnectBus;
import id.dana.globalnetwork.AlipayConnectInitializer;
import id.dana.iapconnectutil.IapConnectState;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a#\u0010\t\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", "p0", "Lkotlin/Function0;", "", "p1", "Lio/reactivex/disposables/Disposable;", "getAuthRequestContext", "(Lkotlin/jvm/functions/Function0;)Lio/reactivex/disposables/Disposable;", "Lid/dana/globalnetwork/AlipayConnectInitializer;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/globalnetwork/AlipayConnectInitializer;Lkotlin/jvm/functions/Function0;)Lio/reactivex/disposables/Disposable;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class IapConnectKtx {
    public static final Disposable KClassImpl$Data$declaredNonStaticMembers$2(AlipayConnectInitializer alipayConnectInitializer, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(alipayConnectInitializer, "");
        Intrinsics.checkNotNullParameter(function0, "");
        Object obj = RxIAPConnectBus.getAuthRequestContext().getErrorConfigVersion.get();
        IapConnectState iapConnectState = (IapConnectState) ((NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? null : NotificationLite.getValue(obj));
        if (!(Intrinsics.areEqual(iapConnectState, IapConnectState.Finished.INSTANCE) ? true : Intrinsics.areEqual(iapConnectState, IapConnectState.Loading.INSTANCE))) {
            alipayConnectInitializer.getAuthRequestContext();
            Disposable subscribe = RxIAPConnectBus.getAuthRequestContext().subscribe(new Consumer() { // from class: id.dana.util.IapConnectKtx$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj2) {
                    IapConnectKtx.KClassImpl$Data$declaredNonStaticMembers$2(Function0.this, (IapConnectState) obj2);
                }
            });
            Intrinsics.checkNotNullExpressionValue(subscribe, "");
            return subscribe;
        }
        Disposable subscribe2 = RxIAPConnectBus.getAuthRequestContext().subscribe(new Consumer() { // from class: id.dana.util.IapConnectKtx$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj2) {
                IapConnectKtx.KClassImpl$Data$declaredNonStaticMembers$2(Function0.this, (IapConnectState) obj2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe2, "");
        return subscribe2;
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(AlipayConnectInitializer alipayConnectInitializer, Function0 function0) {
        Intrinsics.checkNotNullParameter(alipayConnectInitializer, "");
        Intrinsics.checkNotNullParameter(function0, "");
        Object obj = RxIAPConnectBus.getAuthRequestContext().getErrorConfigVersion.get();
        IapConnectState iapConnectState = (IapConnectState) ((NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? null : NotificationLite.getValue(obj));
        if (Intrinsics.areEqual(iapConnectState, IapConnectState.Finished.INSTANCE)) {
            function0.invoke();
        } else if (Intrinsics.areEqual(iapConnectState, IapConnectState.Error.INSTANCE)) {
            alipayConnectInitializer.getAuthRequestContext();
            getAuthRequestContext(function0);
        } else if (Intrinsics.areEqual(iapConnectState, IapConnectState.Loading.INSTANCE)) {
            getAuthRequestContext(function0);
        }
    }

    private static final Disposable getAuthRequestContext(final Function0<Unit> function0) {
        Disposable subscribe = RxIAPConnectBus.getAuthRequestContext().timeout((long) RangedBeacon.DEFAULT_MAX_TRACKING_AGE, TimeUnit.MILLISECONDS).onErrorReturnItem(IapConnectState.Error.INSTANCE).subscribe(new Consumer() { // from class: id.dana.util.IapConnectKtx$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                IapConnectKtx.BuiltInFictitiousFunctionClassFactory(Function0.this, (IapConnectState) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "");
        return subscribe;
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(Function0 function0, IapConnectState iapConnectState) {
        Intrinsics.checkNotNullParameter(function0, "");
        if (Intrinsics.areEqual(iapConnectState, IapConnectState.Finished.INSTANCE)) {
            function0.invoke();
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Function0 function0, IapConnectState iapConnectState) {
        Intrinsics.checkNotNullParameter(function0, "");
        if (Intrinsics.areEqual(iapConnectState, IapConnectState.Finished.INSTANCE)) {
            function0.invoke();
        }
    }
}
