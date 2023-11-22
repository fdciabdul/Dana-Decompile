package id.dana.utils.handpick;

import android.app.Activity;
import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0003\u001a\u00020\u00068WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/utils/handpick/ActivityFacade;", "Lid/dana/utils/handpick/ContextFacade;", "Landroid/app/Activity;", "MyBillsEntityDataFactory", "Landroid/app/Activity;", "getAuthRequestContext", "Landroid/content/Context;", "PlaceComponentResult", "()Landroid/content/Context;", "p0", "<init>", "(Landroid/app/Activity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ActivityFacade implements ContextFacade {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Activity getAuthRequestContext;

    public ActivityFacade(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
        this.getAuthRequestContext = activity;
    }

    @Override // id.dana.utils.handpick.ContextFacade
    @JvmName(name = "PlaceComponentResult")
    public final Context PlaceComponentResult() {
        return this.getAuthRequestContext;
    }
}
