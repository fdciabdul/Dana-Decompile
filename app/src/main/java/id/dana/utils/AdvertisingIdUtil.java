package id.dana.utils;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/utils/AdvertisingIdUtil;", "", "Landroid/content/Context;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;)Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class AdvertisingIdUtil {
    public static final AdvertisingIdUtil INSTANCE = new AdvertisingIdUtil();

    private AdvertisingIdUtil() {
    }

    @JvmStatic
    public static final String BuiltInFictitiousFunctionClassFactory(final Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Object blockingFirst = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.utils.AdvertisingIdUtil$$ExternalSyntheticLambda0
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                AdvertisingIdUtil.KClassImpl$Data$declaredNonStaticMembers$2(p0, observableEmitter);
            }
        }).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribeOn(Schedulers.MyBillsEntityDataFactory()).blockingFirst("");
        Intrinsics.checkNotNullExpressionValue(blockingFirst, "");
        return (String) blockingFirst;
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Context context, ObservableEmitter observableEmitter) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(observableEmitter, "");
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(UtdIdUtil.PlaceComponentResult());
            sb.append(AdvertisingIdClient.getAdvertisingIdInfo(context).getId());
            observableEmitter.onNext(sb.toString());
        } catch (Exception e) {
            observableEmitter.onError(e);
        }
    }
}
