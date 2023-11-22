package id.dana.contract.sendmoney;

import android.app.Activity;
import id.dana.R;
import id.dana.utils.CustomToastUtil;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/contract/sendmoney/QueryPrefixErrorHandler;", "", "Landroid/app/Activity;", "p0", "Lio/reactivex/Observable;", "", "MyBillsEntityDataFactory", "(Landroid/app/Activity;)Lio/reactivex/Observable;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QueryPrefixErrorHandler {
    public static final QueryPrefixErrorHandler INSTANCE = new QueryPrefixErrorHandler();

    private QueryPrefixErrorHandler() {
    }

    @JvmStatic
    public static final Observable<Long> MyBillsEntityDataFactory(Activity p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        CustomToastUtil.PlaceComponentResult(p0, R.drawable.res_0x7f08065e_networkuserentitydata_externalsyntheticlambda1, R.drawable.bg_rounded_toast_failed, p0.getString(R.string.failed_query_prefix), 80, 60, true, null, 256);
        Observable<Long> subscribeOn = Observable.timer(500L, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribeOn(AndroidSchedulers.PlaceComponentResult());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "");
        return subscribeOn;
    }
}
