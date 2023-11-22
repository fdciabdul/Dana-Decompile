package id.dana.data.holdlogin.v2.entity.source;

import android.content.Context;
import id.dana.analytics.mixpanel.MixPanelEvent;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.data.foundation.RpcException;
import id.dana.data.holdlogin.HoldLoginFailTrackerModel;
import id.dana.data.holdlogin.HoldLoginSuccessTrackerModel;
import id.dana.data.holdlogin.HoldLoginUtils;
import id.dana.data.login.source.network.HoldLoginException;
import id.dana.network.exception.NetworkException;
import id.dana.utils.jacoco.ExcludeFromJacocoGeneratedReport;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0013¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ%\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\b\u001a\u00020\u000e*\u00020\u0011H\u0017¢\u0006\u0004\b\b\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0017"}, d2 = {"Lid/dana/data/holdlogin/v2/entity/source/ImplSharedHoldLoginNetwork;", "Lid/dana/data/holdlogin/v2/entity/source/SharedHoldLoginNetwork;", "Lid/dana/data/holdlogin/HoldLoginFailTrackerModel;", "p0", "", "PlaceComponentResult", "(Lid/dana/data/holdlogin/HoldLoginFailTrackerModel;)V", "Lid/dana/data/holdlogin/HoldLoginSuccessTrackerModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/data/holdlogin/HoldLoginSuccessTrackerModel;)V", "", "", "", "p1", "", "getAuthRequestContext", "(Ljava/lang/Throwable;Ljava/util/List;)Z", "Lio/reactivex/disposables/Disposable;", "(Lio/reactivex/disposables/Disposable;)Z", "Landroid/content/Context;", "Landroid/content/Context;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ImplSharedHoldLoginNetwork implements SharedHoldLoginNetwork {
    final CompositeDisposable PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public ImplSharedHoldLoginNetwork(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.PlaceComponentResult = new CompositeDisposable();
    }

    @ExcludeFromJacocoGeneratedReport
    public final boolean BuiltInFictitiousFunctionClassFactory(Disposable disposable) {
        Intrinsics.checkNotNullParameter(disposable, "");
        return this.PlaceComponentResult.getAuthRequestContext(disposable);
    }

    public final void BuiltInFictitiousFunctionClassFactory(HoldLoginSuccessTrackerModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p0, "");
        MixPanelEvent.Builder authRequestContext = MixPanelEvent.Builder.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = "Login";
        MixPanelEvent.Builder MyBillsEntityDataFactory = authRequestContext.MyBillsEntityDataFactory(new Pair[]{TuplesKt.to("$user_id", p0.GetContactSyncConfig), TuplesKt.to("Login Type", p0.getErrorConfigVersion), TuplesKt.to(TrackerDataKey.LoginProperties.HOLD_LOGIN_VERSION, Integer.valueOf(p0.getAuthRequestContext)), TuplesKt.to("Is Success", Boolean.valueOf(p0.BuiltInFictitiousFunctionClassFactory)), TuplesKt.to("Operation Type", p0.scheduleImpl), TuplesKt.to(TrackerDataKey.Property.REQUESTER_OPERATION_TYPE, p0.moveToNextValue), TuplesKt.to(TrackerDataKey.Property.SESSION_ID_BEFORE, CollectionsKt.joinToString$default(p0.DatabaseTableConfigUtil, ", ", null, null, 0, null, null, 62, null)), TuplesKt.to(TrackerDataKey.Property.SESSION_ID_AFTER, p0.lookAheadTest), TuplesKt.to(TrackerDataKey.Property.SESSION_ID_IN_COOKIEMANAGER, CollectionsKt.joinToString$default(p0.initRecordTimeStamp, ", ", null, null, 0, null, null, 62, null)), TuplesKt.to(TrackerDataKey.Property.HOLD_LOGIN_PROCESS_DURATION, Long.valueOf(p0.KClassImpl$Data$declaredNonStaticMembers$2)), TuplesKt.to(TrackerDataKey.Property.RETRIES, Integer.valueOf(p0.NetworkUserEntityData$$ExternalSyntheticLambda0)), TuplesKt.to(TrackerDataKey.Property.ENABLE_QUEUE_POOL_TIME_LIMIT, Boolean.valueOf(p0.MyBillsEntityDataFactory)), TuplesKt.to(TrackerDataKey.Property.ENABLE_REWRITE_SESSION, Boolean.valueOf(p0.PlaceComponentResult))});
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        new MixPanelEvent(MyBillsEntityDataFactory, (byte) 0).PlaceComponentResult();
    }

    public final void PlaceComponentResult(HoldLoginFailTrackerModel p0) {
        String errorCode;
        String message;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p0, "");
        MixPanelEvent.Builder authRequestContext = MixPanelEvent.Builder.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = "Login";
        Pair<String, Object>[] pairArr = new Pair[12];
        byte b = 0;
        pairArr[0] = TuplesKt.to("$user_id", p0.NetworkUserEntityData$$ExternalSyntheticLambda2);
        pairArr[1] = TuplesKt.to("Login Type", p0.NetworkUserEntityData$$ExternalSyntheticLambda0);
        pairArr[2] = TuplesKt.to(TrackerDataKey.LoginProperties.HOLD_LOGIN_VERSION, Integer.valueOf(p0.PlaceComponentResult));
        pairArr[3] = TuplesKt.to("Is Success", Boolean.FALSE);
        Throwable th = p0.lookAheadTest;
        if (th instanceof RpcException) {
            errorCode = ((RpcException) th).code;
        } else {
            errorCode = th instanceof NetworkException ? ((NetworkException) th).getErrorCode() : null;
        }
        pairArr[4] = TuplesKt.to("errorCode", errorCode);
        Throwable th2 = p0.lookAheadTest;
        if (th2 instanceof RpcException) {
            message = ((RpcException) th2).msg;
            if (message == null) {
                message = HoldLoginFailTrackerModel.MyBillsEntityDataFactory(th2);
            }
        } else if (th2 instanceof NetworkException) {
            message = th2.getMessage();
            if (message == null) {
                message = ((NetworkException) th2).getLocalizedMessage();
            }
            if (message == null) {
                message = HoldLoginFailTrackerModel.MyBillsEntityDataFactory(th2);
            }
        } else {
            message = th2.getMessage();
            if (message == null) {
                message = th2.getLocalizedMessage();
            }
            if (message == null) {
                message = HoldLoginFailTrackerModel.MyBillsEntityDataFactory(th2);
            }
        }
        pairArr[5] = TuplesKt.to("errorMessage", message);
        pairArr[6] = TuplesKt.to("Operation Type", p0.scheduleImpl);
        pairArr[7] = TuplesKt.to(TrackerDataKey.Property.REQUESTER_OPERATION_TYPE, p0.getErrorConfigVersion);
        pairArr[8] = TuplesKt.to(TrackerDataKey.Property.HOLD_LOGIN_PROCESS_DURATION, Long.valueOf(p0.BuiltInFictitiousFunctionClassFactory));
        pairArr[9] = TuplesKt.to(TrackerDataKey.Property.RETRIES, Integer.valueOf(p0.moveToNextValue));
        pairArr[10] = TuplesKt.to(TrackerDataKey.Property.ENABLE_QUEUE_POOL_TIME_LIMIT, Boolean.valueOf(p0.KClassImpl$Data$declaredNonStaticMembers$2));
        pairArr[11] = TuplesKt.to(TrackerDataKey.Property.ENABLE_REWRITE_SESSION, Boolean.valueOf(p0.MyBillsEntityDataFactory));
        MixPanelEvent.Builder MyBillsEntityDataFactory = authRequestContext.MyBillsEntityDataFactory(pairArr);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        new MixPanelEvent(MyBillsEntityDataFactory, b).PlaceComponentResult();
        if (p0.lookAheadTest instanceof HoldLoginException) {
            HoldLoginUtils.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }

    public static boolean getAuthRequestContext(Throwable p0, List<String> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (!(p0 instanceof NetworkException)) {
            if (p0 instanceof RpcException) {
                List<String> list = p1;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        if (Intrinsics.areEqual((String) it.next(), ((RpcException) p0).code)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        List<String> list2 = p1;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                if (Intrinsics.areEqual((String) it2.next(), ((NetworkException) p0).getErrorCode())) {
                    return true;
                }
            }
        }
        return false;
    }
}
