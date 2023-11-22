package id.dana.utils.permission;

import com.anggrayudi.storage.permission.ActivityPermissionRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "", "BuiltInFictitiousFunctionClassFactory", "(Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;)V"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ActivityPermissionRequestKt {
    public static final void BuiltInFictitiousFunctionClassFactory(ActivityPermissionRequest activityPermissionRequest) {
        Intrinsics.checkNotNullParameter(activityPermissionRequest, "");
        try {
            activityPermissionRequest.check();
        } catch (IllegalStateException unused) {
        }
    }
}
