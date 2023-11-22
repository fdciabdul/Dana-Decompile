package id.dana.contract.deeplink.path;

import android.app.Activity;
import android.content.Intent;
import id.dana.social.view.activity.ChangeUsernameActivity;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ,\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0087\u0002¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/contract/deeplink/path/FeatureUpdateUsername;", "", "Landroid/app/Activity;", "p0", "", "", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/app/Activity;Ljava/util/Map;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FeatureUpdateUsername {
    public static final FeatureUpdateUsername INSTANCE = new FeatureUpdateUsername();

    private FeatureUpdateUsername() {
    }

    @JvmStatic
    public static final void BuiltInFictitiousFunctionClassFactory(Activity p0, Map<String, String> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        p0.startActivity(new Intent(p0, ChangeUsernameActivity.class).putExtra(ChangeUsernameActivity.PARAM_FROM_DEEPLINK, true));
    }
}
