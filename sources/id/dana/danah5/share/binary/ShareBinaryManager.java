package id.dana.danah5.share.binary;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.fastjson.JSONObject;
import id.dana.R;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.utils.BitmapUtil;
import id.dana.utils.android.IntentUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c"}, d2 = {"Lid/dana/danah5/share/binary/ShareBinaryManager;", "", "", "resultType", "Lcom/alibaba/fastjson/JSONObject;", "getResult", "(Ljava/lang/String;)Lcom/alibaba/fastjson/JSONObject;", "Lid/dana/danah5/share/binary/ShareBinaryEntity;", "shareBinaryEntity", "", "processEvent", "(Lid/dana/danah5/share/binary/ShareBinaryEntity;)V", "result", "sendCallback", "(Ljava/lang/String;)V", "Landroid/graphics/Bitmap;", "bitmap", "shareImage", "(Landroid/graphics/Bitmap;)V", "Landroid/content/Intent;", "intent", "showIntentChooser", "(Landroid/content/Intent;)V", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "Landroid/app/Activity;", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "<init>", "(Landroid/app/Activity;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ShareBinaryManager {
    private final Activity activity;
    private final BridgeCallback bridgeCallback;

    public ShareBinaryManager(Activity activity, BridgeCallback bridgeCallback) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        this.activity = activity;
        this.bridgeCallback = bridgeCallback;
    }

    public final void processEvent(ShareBinaryEntity shareBinaryEntity) {
        if (shareBinaryEntity == null) {
            return;
        }
        try {
            String fileContent = shareBinaryEntity.getFileContent();
            if (fileContent == null) {
                fileContent = "";
            }
            Bitmap authRequestContext = BitmapUtil.getAuthRequestContext(fileContent);
            Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
            shareImage(authRequestContext);
            sendCallback("SUCCESS");
        } catch (Exception unused) {
            sendCallback("UNKNOWN_ERROR");
        }
    }

    private final void shareImage(Bitmap bitmap) {
        showIntentChooser(IntentUtil.getAuthRequestContext(BitmapUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.activity, bitmap)));
    }

    private final void showIntentChooser(Intent intent) {
        Activity activity = this.activity;
        activity.startActivity(Intent.createChooser(intent, activity.getResources().getText(R.string.send_to)));
    }

    private final void sendCallback(String result) {
        this.bridgeCallback.sendJSONResponse(getResult(result));
    }

    private final JSONObject getResult(String resultType) {
        String str;
        if (Intrinsics.areEqual(resultType, "SUCCESS")) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put((JSONObject) "success", (String) Boolean.TRUE);
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = jSONObject2;
        jSONObject3.put((JSONObject) "success", (String) Boolean.FALSE);
        if (Intrinsics.areEqual(resultType, "NO_CONTENT_INFO")) {
            str = "002";
        } else {
            str = Intrinsics.areEqual(resultType, "NO_MESSAGE") ? "003" : "001";
        }
        jSONObject3.put((JSONObject) "error", str);
        return jSONObject2;
    }
}
