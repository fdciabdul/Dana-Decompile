package id.dana.data.expresspurchase.source.local;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.config.source.split.DefaultJsonPath;
import id.dana.data.expresspurchase.model.ExpressPurchaseConfigResult;
import id.dana.data.expresspurchase.model.ServiceEmasConfigResult;
import id.dana.data.expresspurchase.source.ExpressPurchaseEntityData;
import id.dana.data.foundation.utils.JsonUtil;
import id.dana.data.storage.Serializer;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b&\u0010'J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J-\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ%\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0005J-\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\rJ%\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001f\u0010\u001c\u001a\u0006*\u00020\u00070\u00078CX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001f\u0010%\u001a\u0006*\u00020\u00070\u00078CX\u0083\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0019\u001a\u0004\b$\u0010\u001b"}, d2 = {"Lid/dana/data/expresspurchase/source/local/LocalExpressPurchaseEntityData;", "Lid/dana/data/expresspurchase/source/ExpressPurchaseEntityData;", "Lio/reactivex/Observable;", "Lid/dana/data/expresspurchase/model/ExpressPurchaseConfigResult;", "getBottomSheetExpressPurchaseConfig", "()Lio/reactivex/Observable;", "getBottomSheetExpressPurchaseGoldConfig", "", "refUserId", "addonId", "type", "", "getLastOfferCancelAction", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "getLastOfferSucceedAction", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/expresspurchase/model/ServiceEmasConfigResult;", "getServiceEmasConfig", "", "saveLastOfferCancelAction", "saveLastOfferSucceedAction", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "expressPurchaseConfigFromAsset$delegate", "Lkotlin/Lazy;", "getExpressPurchaseConfigFromAsset", "()Ljava/lang/String;", "expressPurchaseConfigFromAsset", "Lid/dana/data/expresspurchase/source/local/ExpressPurchasePreference;", "expressPurchasePreference", "Lid/dana/data/expresspurchase/source/local/ExpressPurchasePreference;", "Lid/dana/data/storage/Serializer;", "serializer", "Lid/dana/data/storage/Serializer;", "serviceEmasConfigFromAsset$delegate", "getServiceEmasConfigFromAsset", "serviceEmasConfigFromAsset", "<init>", "(Landroid/content/Context;Lid/dana/data/storage/Serializer;Lid/dana/data/expresspurchase/source/local/ExpressPurchasePreference;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocalExpressPurchaseEntityData implements ExpressPurchaseEntityData {
    private final Context context;

    /* renamed from: expressPurchaseConfigFromAsset$delegate  reason: from kotlin metadata */
    private final Lazy expressPurchaseConfigFromAsset;
    private final ExpressPurchasePreference expressPurchasePreference;
    private final Serializer serializer;

    /* renamed from: serviceEmasConfigFromAsset$delegate  reason: from kotlin metadata */
    private final Lazy serviceEmasConfigFromAsset;

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final /* synthetic */ Observable getBottomSheetExpressPurchasePaylaterConfig() {
        return ExpressPurchaseEntityData.CC.$default$getBottomSheetExpressPurchasePaylaterConfig(this);
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final /* synthetic */ Observable getExpressPurchase(String str, String str2) {
        return ExpressPurchaseEntityData.CC.$default$getExpressPurchase(this, str, str2);
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final /* synthetic */ Observable getQuickBuyDeals(String str, String str2, String str3) {
        return ExpressPurchaseEntityData.CC.$default$getQuickBuyDeals(this, str, str2, str3);
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final /* synthetic */ Observable getQuickBuyGold(String str, String str2, String str3, Map map, String str4, String str5, String str6, String str7) {
        return ExpressPurchaseEntityData.CC.$default$getQuickBuyGold(this, str, str2, str3, map, str4, str5, str6, str7);
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final /* synthetic */ Observable getQuickBuyInsurance(String str, String str2, String str3, Map map) {
        return ExpressPurchaseEntityData.CC.$default$getQuickBuyInsurance(this, str, str2, str3, map);
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final /* synthetic */ Observable orderQueryByCondition(String str, List list) {
        return ExpressPurchaseEntityData.CC.$default$orderQueryByCondition(this, str, list);
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final /* synthetic */ Observable validateBundleProduct(String str, String str2, String str3, String str4, String str5, String str6) {
        return ExpressPurchaseEntityData.CC.$default$validateBundleProduct(this, str, str2, str3, str4, str5, str6);
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final /* synthetic */ Observable validateGoldProduct(String str, List list, Map map) {
        return ExpressPurchaseEntityData.CC.$default$validateGoldProduct(this, str, list, map);
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final /* synthetic */ Observable validateStandaloneProduct(String str, String str2) {
        return ExpressPurchaseEntityData.CC.$default$validateStandaloneProduct(this, str, str2);
    }

    @Inject
    public LocalExpressPurchaseEntityData(Context context, Serializer serializer, ExpressPurchasePreference expressPurchasePreference) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(serializer, "");
        Intrinsics.checkNotNullParameter(expressPurchasePreference, "");
        this.context = context;
        this.serializer = serializer;
        this.expressPurchasePreference = expressPurchasePreference;
        this.expressPurchaseConfigFromAsset = LazyKt.lazy(new Function0<String>() { // from class: id.dana.data.expresspurchase.source.local.LocalExpressPurchaseEntityData$expressPurchaseConfigFromAsset$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Context context2;
                context2 = LocalExpressPurchaseEntityData.this.context;
                return JsonUtil.PlaceComponentResult(context2, DefaultJsonPath.DEFAULT_EXPRESS_PURCHASE_CONFIG);
            }
        });
        this.serviceEmasConfigFromAsset = LazyKt.lazy(new Function0<String>() { // from class: id.dana.data.expresspurchase.source.local.LocalExpressPurchaseEntityData$serviceEmasConfigFromAsset$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                Context context2;
                context2 = LocalExpressPurchaseEntityData.this.context;
                return JsonUtil.PlaceComponentResult(context2, DefaultJsonPath.DEFAULT_SERVICE_EMAS_CONFIG);
            }
        });
    }

    @JvmName(name = "getExpressPurchaseConfigFromAsset")
    private final String getExpressPurchaseConfigFromAsset() {
        return (String) this.expressPurchaseConfigFromAsset.getValue();
    }

    @JvmName(name = "getServiceEmasConfigFromAsset")
    private final String getServiceEmasConfigFromAsset() {
        return (String) this.serviceEmasConfigFromAsset.getValue();
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final Observable<ExpressPurchaseConfigResult> getBottomSheetExpressPurchaseConfig() {
        Observable<ExpressPurchaseConfigResult> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.expresspurchase.source.local.LocalExpressPurchaseEntityData$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ExpressPurchaseConfigResult m1243getBottomSheetExpressPurchaseConfig$lambda0;
                m1243getBottomSheetExpressPurchaseConfig$lambda0 = LocalExpressPurchaseEntityData.m1243getBottomSheetExpressPurchaseConfig$lambda0(LocalExpressPurchaseEntityData.this);
                return m1243getBottomSheetExpressPurchaseConfig$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBottomSheetExpressPurchaseConfig$lambda-0  reason: not valid java name */
    public static final ExpressPurchaseConfigResult m1243getBottomSheetExpressPurchaseConfig$lambda0(LocalExpressPurchaseEntityData localExpressPurchaseEntityData) {
        Intrinsics.checkNotNullParameter(localExpressPurchaseEntityData, "");
        return (ExpressPurchaseConfigResult) localExpressPurchaseEntityData.serializer.deserialize(localExpressPurchaseEntityData.getExpressPurchaseConfigFromAsset(), ExpressPurchaseConfigResult.class);
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final Observable<ExpressPurchaseConfigResult> getBottomSheetExpressPurchaseGoldConfig() {
        Observable<ExpressPurchaseConfigResult> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.expresspurchase.source.local.LocalExpressPurchaseEntityData$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ExpressPurchaseConfigResult m1244getBottomSheetExpressPurchaseGoldConfig$lambda1;
                m1244getBottomSheetExpressPurchaseGoldConfig$lambda1 = LocalExpressPurchaseEntityData.m1244getBottomSheetExpressPurchaseGoldConfig$lambda1(LocalExpressPurchaseEntityData.this);
                return m1244getBottomSheetExpressPurchaseGoldConfig$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBottomSheetExpressPurchaseGoldConfig$lambda-1  reason: not valid java name */
    public static final ExpressPurchaseConfigResult m1244getBottomSheetExpressPurchaseGoldConfig$lambda1(LocalExpressPurchaseEntityData localExpressPurchaseEntityData) {
        Intrinsics.checkNotNullParameter(localExpressPurchaseEntityData, "");
        return (ExpressPurchaseConfigResult) localExpressPurchaseEntityData.serializer.deserialize(localExpressPurchaseEntityData.getExpressPurchaseConfigFromAsset(), ExpressPurchaseConfigResult.class);
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final Observable<ServiceEmasConfigResult> getServiceEmasConfig() {
        Observable<ServiceEmasConfigResult> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.expresspurchase.source.local.LocalExpressPurchaseEntityData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ServiceEmasConfigResult m1245getServiceEmasConfig$lambda2;
                m1245getServiceEmasConfig$lambda2 = LocalExpressPurchaseEntityData.m1245getServiceEmasConfig$lambda2(LocalExpressPurchaseEntityData.this);
                return m1245getServiceEmasConfig$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getServiceEmasConfig$lambda-2  reason: not valid java name */
    public static final ServiceEmasConfigResult m1245getServiceEmasConfig$lambda2(LocalExpressPurchaseEntityData localExpressPurchaseEntityData) {
        Intrinsics.checkNotNullParameter(localExpressPurchaseEntityData, "");
        return (ServiceEmasConfigResult) localExpressPurchaseEntityData.serializer.deserialize(localExpressPurchaseEntityData.getServiceEmasConfigFromAsset(), ServiceEmasConfigResult.class);
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final Observable<Long> getLastOfferCancelAction(String refUserId, String addonId, String type) {
        Intrinsics.checkNotNullParameter(refUserId, "");
        Intrinsics.checkNotNullParameter(addonId, "");
        Intrinsics.checkNotNullParameter(type, "");
        Observable<Long> just = Observable.just(Long.valueOf(this.expressPurchasePreference.getLastOfferCancelAction(refUserId, addonId, type)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final Observable<Long> getLastOfferSucceedAction(String refUserId, String addonId) {
        Intrinsics.checkNotNullParameter(refUserId, "");
        Intrinsics.checkNotNullParameter(addonId, "");
        Observable<Long> just = Observable.just(Long.valueOf(this.expressPurchasePreference.getLastOfferSucceedAction(refUserId, addonId)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final Observable<Boolean> saveLastOfferCancelAction(String refUserId, String addonId, String type) {
        Intrinsics.checkNotNullParameter(refUserId, "");
        Intrinsics.checkNotNullParameter(addonId, "");
        Intrinsics.checkNotNullParameter(type, "");
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.expressPurchasePreference.saveLastOfferCancelAction(refUserId, addonId, type)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseEntityData
    public final Observable<Boolean> saveLastOfferSucceedAction(String refUserId, String addonId) {
        Intrinsics.checkNotNullParameter(refUserId, "");
        Intrinsics.checkNotNullParameter(addonId, "");
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.expressPurchasePreference.saveLastOfferSucceedAction(refUserId, addonId)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }
}
