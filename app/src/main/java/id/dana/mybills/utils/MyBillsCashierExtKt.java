package id.dana.mybills.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import id.dana.analytics.tracker.TrackerKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/content/Context;", "p0", "", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;Ljava/lang/String;)V"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class MyBillsCashierExtKt {
    public static final void KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intent className = new Intent("android.intent.action.VIEW").setClassName(context.getPackageName(), "id.dana.pay.PayActivity");
        Intrinsics.checkNotNullExpressionValue(className, "");
        Bundle bundle = new Bundle();
        bundle.putString("redirect_url", str);
        bundle.putBoolean("open_cashier", true);
        className.putExtra("source", TrackerKey.SourceType.MY_BILLS);
        className.putExtra("data", bundle);
        context.startActivity(className);
    }
}
