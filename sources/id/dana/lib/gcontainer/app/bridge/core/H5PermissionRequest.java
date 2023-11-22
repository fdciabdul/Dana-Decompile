package id.dana.lib.gcontainer.app.bridge.core;

import android.app.Activity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionReport;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u001b\u0010\t\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/core/H5PermissionRequest;", "Lcom/anggrayudi/storage/permission/PermissionRequest;", "", "check", "()V", "continueToPermissionRequest", "", "Lcom/anggrayudi/storage/permission/PermissionReport;", "reports", "reportResult", "(Ljava/util/List;)V", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "Landroid/app/Activity;", "Lcom/anggrayudi/storage/permission/PermissionCallback;", "callback", "Lcom/anggrayudi/storage/permission/PermissionCallback;", "", "", RequestPermission.PERMISSIONS, "[Ljava/lang/String;", "", RequestPermission.REQUEST_CODE, "I", "<init>", "(Landroid/app/Activity;[Ljava/lang/String;ILcom/anggrayudi/storage/permission/PermissionCallback;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class H5PermissionRequest implements PermissionRequest {
    private final Activity activity;
    private final PermissionCallback callback;
    private final String[] permissions;
    private final int requestCode;

    public H5PermissionRequest(Activity activity, String[] strArr, int i, PermissionCallback permissionCallback) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(strArr, "");
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        this.activity = activity;
        this.permissions = strArr;
        this.requestCode = i;
        this.callback = permissionCallback;
    }

    @Override // com.anggrayudi.storage.permission.PermissionRequest
    public final void check() {
        boolean z;
        String[] strArr = this.permissions;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = true;
                break;
            }
            if (!(ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(this.activity, strArr[i]) == 0)) {
                z = false;
                break;
            }
            i++;
        }
        if (z) {
            PermissionCallback permissionCallback = this.callback;
            String[] strArr2 = this.permissions;
            ArrayList arrayList = new ArrayList(strArr2.length);
            for (String str : strArr2) {
                arrayList.add(new PermissionReport(str, true, false));
            }
            permissionCallback.onPermissionsChecked(new PermissionResult(arrayList), false);
            return;
        }
        this.callback.onDisplayConsentDialog(this);
    }

    @Override // com.anggrayudi.storage.permission.PermissionRequest
    public final void continueToPermissionRequest() {
        for (String str : this.permissions) {
            if (ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(this.activity, str) != 0) {
                ActivityCompat.BuiltInFictitiousFunctionClassFactory(this.activity, this.permissions, this.requestCode);
                return;
            }
        }
        PermissionCallback permissionCallback = this.callback;
        String[] strArr = this.permissions;
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str2 : strArr) {
            arrayList.add(new PermissionReport(str2, true, false));
        }
        permissionCallback.onPermissionsChecked(new PermissionResult(arrayList), false);
    }

    public final void reportResult(List<PermissionReport> reports) {
        Intrinsics.checkNotNullParameter(reports, "");
        ArrayList arrayList = new ArrayList();
        for (Object obj : reports) {
            if (((PermissionReport) obj).getGetAuthRequestContext()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            this.callback.onPermissionsChecked(new PermissionResult(reports), true);
        } else {
            this.callback.onShouldRedirectToSystemSettings(arrayList2);
        }
    }
}
