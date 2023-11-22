package id.dana.challenge.verifypush;

import android.os.Handler;
import android.os.Looper;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import id.dana.challenge.ChallengeScenarioListener;
import id.dana.utils.PhoneCall;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/challenge/verifypush/VerifyPushChallengeFragment$phonePermission$1;", "Lcom/anggrayudi/storage/permission/PermissionCallback;", "Lcom/anggrayudi/storage/permission/PermissionResult;", "p0", "", "p1", "", "onPermissionsChecked", "(Lcom/anggrayudi/storage/permission/PermissionResult;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class VerifyPushChallengeFragment$phonePermission$1 implements PermissionCallback {
    final /* synthetic */ VerifyPushChallengeFragment getAuthRequestContext;

    @Override // com.anggrayudi.storage.permission.PermissionCallback
    public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
        PermissionCallback.CC.getAuthRequestContext(permissionRequest);
    }

    @Override // com.anggrayudi.storage.permission.PermissionCallback
    public final /* synthetic */ void onShouldRedirectToSystemSettings(List list) {
        PermissionCallback.CC.BuiltInFictitiousFunctionClassFactory(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public VerifyPushChallengeFragment$phonePermission$1(VerifyPushChallengeFragment verifyPushChallengeFragment) {
        this.getAuthRequestContext = verifyPushChallengeFragment;
    }

    @Override // com.anggrayudi.storage.permission.PermissionCallback
    public final void onPermissionsChecked(PermissionResult p0, boolean p1) {
        boolean z;
        Intrinsics.checkNotNullParameter(p0, "");
        if (p0.MyBillsEntityDataFactory()) {
            PhoneCall.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext.getBaseActivity(), "1500445", true);
            z = this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory;
            if (z) {
                Handler handler = new Handler(Looper.getMainLooper());
                final VerifyPushChallengeFragment verifyPushChallengeFragment = this.getAuthRequestContext;
                handler.postDelayed(new Runnable() { // from class: id.dana.challenge.verifypush.VerifyPushChallengeFragment$phonePermission$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        VerifyPushChallengeFragment$phonePermission$1.BuiltInFictitiousFunctionClassFactory(VerifyPushChallengeFragment.this);
                    }
                }, 3000L);
            }
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(VerifyPushChallengeFragment verifyPushChallengeFragment) {
        ChallengeScenarioListener challengeScenarioListener;
        Intrinsics.checkNotNullParameter(verifyPushChallengeFragment, "");
        challengeScenarioListener = verifyPushChallengeFragment.NetworkUserEntityData$$ExternalSyntheticLambda8;
        if (challengeScenarioListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            challengeScenarioListener = null;
        }
        challengeScenarioListener.closeChallengeSession();
    }
}
