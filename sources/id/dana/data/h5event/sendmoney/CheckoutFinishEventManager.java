package id.dana.data.h5event.sendmoney;

import android.content.Context;
import com.alibaba.fastjson.JSONObject;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.analytics.mixpanel.MixPanelDataTracker;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.data.toggle.SplitFacade;
import id.dana.data.util.DateTimeUtil;
import id.dana.domain.account.interactor.SaveLastTransaction;
import id.dana.utils.extension.JSONExtKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b \u0010\u001fJ)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ1\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J1\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0012\u0010\u0014J!\u0010\u0015\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R*\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0007@\u0007X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0018\u0010\u0019\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d"}, d2 = {"Lid/dana/data/h5event/sendmoney/CheckoutFinishEventManager;", "", "Lid/dana/data/toggle/SplitFacade;", "splitFacade", "Lid/dana/data/h5event/sendmoney/CheckoutFinishEntity;", "checkoutFinishEntity", "Lid/dana/domain/account/interactor/SaveLastTransaction;", "saveLastTransaction", "", "addSplitTransactionAttribute", "(Lid/dana/data/toggle/SplitFacade;Lid/dana/data/h5event/sendmoney/CheckoutFinishEntity;Lid/dana/domain/account/interactor/SaveLastTransaction;)V", "Lorg/json/JSONObject;", "getCompleteTransactionData", "(Lid/dana/data/h5event/sendmoney/CheckoutFinishEntity;)Lorg/json/JSONObject;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Lcom/alibaba/fastjson/JSONObject;", "info", "processEvent", "(Landroid/content/Context;Lcom/alibaba/fastjson/JSONObject;Lid/dana/data/toggle/SplitFacade;Lid/dana/domain/account/interactor/SaveLastTransaction;)V", "(Landroid/content/Context;Lid/dana/data/toggle/SplitFacade;Lid/dana/domain/account/interactor/SaveLastTransaction;Lid/dana/data/h5event/sendmoney/CheckoutFinishEntity;)V", "track", "(Landroid/content/Context;Lid/dana/data/h5event/sendmoney/CheckoutFinishEntity;)V", "Lid/dana/data/h5event/sendmoney/CheckoutFinishCallback;", "checkoutFinishCallback", "Lid/dana/data/h5event/sendmoney/CheckoutFinishCallback;", "getCheckoutFinishCallback", "()Lid/dana/data/h5event/sendmoney/CheckoutFinishCallback;", "setCheckoutFinishCallback", "(Lid/dana/data/h5event/sendmoney/CheckoutFinishCallback;)V", "getCheckoutFinishCallback$annotations", "()V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CheckoutFinishEventManager {
    public static final CheckoutFinishEventManager INSTANCE = new CheckoutFinishEventManager();
    private static CheckoutFinishCallback checkoutFinishCallback;

    @JvmStatic
    public static /* synthetic */ void getCheckoutFinishCallback$annotations() {
    }

    private CheckoutFinishEventManager() {
    }

    @JvmName(name = "getCheckoutFinishCallback")
    public static final CheckoutFinishCallback getCheckoutFinishCallback() {
        return checkoutFinishCallback;
    }

    @JvmName(name = "setCheckoutFinishCallback")
    public static final void setCheckoutFinishCallback(CheckoutFinishCallback checkoutFinishCallback2) {
        checkoutFinishCallback = checkoutFinishCallback2;
    }

    @JvmStatic
    public static final void processEvent(Context r3, JSONObject info, SplitFacade splitFacade, SaveLastTransaction saveLastTransaction) {
        Intrinsics.checkNotNullParameter(r3, "");
        Intrinsics.checkNotNullParameter(splitFacade, "");
        Intrinsics.checkNotNullParameter(saveLastTransaction, "");
        Object obj = null;
        try {
            obj = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(info != null ? info.toJSONString() : null, null), (Class<Object>) CheckoutFinishEntity.class);
        } catch (Exception unused) {
        }
        processEvent(r3, splitFacade, saveLastTransaction, (CheckoutFinishEntity) obj);
    }

    @JvmStatic
    public static final void processEvent(Context r4, SplitFacade splitFacade, SaveLastTransaction saveLastTransaction, CheckoutFinishEntity checkoutFinishEntity) {
        Intrinsics.checkNotNullParameter(r4, "");
        Intrinsics.checkNotNullParameter(splitFacade, "");
        Intrinsics.checkNotNullParameter(saveLastTransaction, "");
        CheckoutFinishEventManager checkoutFinishEventManager = INSTANCE;
        Boolean.valueOf(checkoutFinishCallback != null);
        Boolean.valueOf(checkoutFinishEntity != null);
        CheckoutFinishCallback checkoutFinishCallback2 = checkoutFinishCallback;
        if (checkoutFinishCallback2 != null) {
            checkoutFinishCallback2.onCheckoutFinished(checkoutFinishEntity);
        }
        checkoutFinishCallback = null;
        checkoutFinishEventManager.track(r4, checkoutFinishEntity);
        checkoutFinishEventManager.addSplitTransactionAttribute(splitFacade, checkoutFinishEntity, saveLastTransaction);
    }

    private final void track(Context r2, CheckoutFinishEntity checkoutFinishEntity) {
        if (checkoutFinishEntity != null) {
            MixPanelDataTracker.PlaceComponentResult(r2, TrackerDataKey.Event.TRANSACTION_COMPLETE, getCompleteTransactionData(checkoutFinishEntity));
        }
    }

    private final org.json.JSONObject getCompleteTransactionData(CheckoutFinishEntity checkoutFinishEntity) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.put("Transaction Type", checkoutFinishEntity.getTransScenario());
        jSONObject.put(TrackerDataKey.Property.PROCESSING_STATUS, checkoutFinishEntity.getProcessingStatus());
        return jSONObject;
    }

    private final void addSplitTransactionAttribute(SplitFacade splitFacade, CheckoutFinishEntity checkoutFinishEntity, SaveLastTransaction saveLastTransaction) {
        String transType;
        if (checkoutFinishEntity == null || (transType = checkoutFinishEntity.getTransType()) == null) {
            return;
        }
        String currentSplitDateFormat = DateTimeUtil.INSTANCE.getCurrentSplitDateFormat();
        saveLastTransaction.execute(SaveLastTransaction.Params.INSTANCE.lastTransaction(transType, currentSplitDateFormat), new Function1<Boolean, Unit>() { // from class: id.dana.data.h5event.sendmoney.CheckoutFinishEventManager$addSplitTransactionAttribute$1$1
            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                DanaLog.getAuthRequestContext(DanaLogConstants.TAG.CHECKOUT, z ? "Success save last transaction" : "Failed save last transaction");
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.data.h5event.sendmoney.CheckoutFinishEventManager$addSplitTransactionAttribute$1$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                StringBuilder sb = new StringBuilder();
                sb.append(CheckoutFinishEventManager.INSTANCE.getClass().getName());
                sb.append(th.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.CHECKOUT, sb.toString(), th);
            }
        });
        SplitFacade.PlaceComponentResult("last_transaction_type", transType);
        SplitFacade.PlaceComponentResult("last_transaction_date", currentSplitDateFormat);
    }
}
