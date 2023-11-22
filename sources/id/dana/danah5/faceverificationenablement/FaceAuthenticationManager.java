package id.dana.danah5.faceverificationenablement;

import android.app.Activity;
import android.content.Intent;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.danah5.bioutility.BioUtilityBridge;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J$\u0010\r\u001a\u00020\u00032\u001a\u0010\u000e\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00030\u000fH&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0017À\u0006\u0001"}, d2 = {"Lid/dana/danah5/faceverificationenablement/FaceAuthenticationManager;", "", "launchFaceAuth", "", IpcMessageConstants.EXTRA_EVENT, "", "source", BioUtilityBridge.SECURITY_ID, "faceAuthNew", "", "setActivity", AkuEventParamsKey.KEY_ACTIVITY, "Landroid/app/Activity;", "setActivityResult", "activityResult", "Lkotlin/Function2;", "Landroid/content/Intent;", "", "setBridgeCallback", "bridgeCallback", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "tokenTransferAccount", "token", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface FaceAuthenticationManager {
    void launchFaceAuth(String eventName, String source, String securityId, boolean faceAuthNew);

    void setActivity(Activity activity);

    void setActivityResult(Function2<? super Intent, ? super Integer, Unit> activityResult);

    void setBridgeCallback(BridgeCallback bridgeCallback);

    void tokenTransferAccount(String token);

    /* renamed from: id.dana.danah5.faceverificationenablement.FaceAuthenticationManager$-CC  reason: invalid class name */
    /* loaded from: classes2.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void launchFaceAuth$default(FaceAuthenticationManager faceAuthenticationManager, String str, String str2, String str3, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: launchFaceAuth");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                str3 = "";
            }
            if ((i & 8) != 0) {
                z = true;
            }
            faceAuthenticationManager.launchFaceAuth(str, str2, str3, z);
        }
    }
}
