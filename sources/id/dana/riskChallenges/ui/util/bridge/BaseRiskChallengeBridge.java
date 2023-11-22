package id.dana.riskChallenges.ui.util.bridge;

import android.content.Intent;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import id.dana.lib.gcontainer.app.bridge.core.BaseBridge;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\r\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\r\u0010\u000eR\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u000f"}, d2 = {"Lid/dana/riskChallenges/ui/util/bridge/BaseRiskChallengeBridge;", "Lid/dana/lib/gcontainer/app/bridge/core/BaseBridge;", "", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "", "onActivityResult", "(IILandroid/content/Intent;)V", "Landroidx/activity/result/ActivityResultCallback;", "Landroidx/activity/result/ActivityResult;", "callback", "registerForActivityResult", "(Landroidx/activity/result/ActivityResultCallback;)V", "Landroidx/activity/result/ActivityResultCallback;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public class BaseRiskChallengeBridge extends BaseBridge {
    private ActivityResultCallback<ActivityResult> callback;

    public final void registerForActivityResult(ActivityResultCallback<ActivityResult> callback) {
        Intrinsics.checkNotNullParameter(callback, "");
        this.callback = callback;
    }

    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        ActivityResultCallback<ActivityResult> activityResultCallback = this.callback;
        if (activityResultCallback != null) {
            activityResultCallback.onActivityResult(new ActivityResult(resultCode, data));
        }
    }
}
