package id.dana.contract.deeplink.path;

import android.app.Activity;
import android.content.Intent;
import id.dana.merchantmanagement.view.MerchantManagementActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/contract/deeplink/path/FeatureMerchantBinding;", "", "Landroid/app/Activity;", "p0", "<init>", "(Landroid/app/Activity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FeatureMerchantBinding {
    public FeatureMerchantBinding(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
        activity.startActivity(new Intent(activity, MerchantManagementActivity.class));
    }
}
