package id.dana.lib.gcontainer.app.bridge.share.text;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.fastjson.JSONObject;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.lib.gcontainer.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0019"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/share/text/ShareTextManager;", "", "", "resultType", "Lcom/alibaba/fastjson/JSONObject;", "getResult", "(Ljava/lang/String;)Lcom/alibaba/fastjson/JSONObject;", "extraMessage", "title", "", "openChooseDialog", "(Ljava/lang/String;Ljava/lang/String;)V", "processEvent", "()V", "sendUnknownError", "Lid/dana/lib/gcontainer/app/bridge/share/text/ShareTextEntity;", "shareTextEntity", "shareText", "(Lid/dana/lib/gcontainer/app/bridge/share/text/ShareTextEntity;)V", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "Landroid/app/Activity;", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "Lid/dana/lib/gcontainer/app/bridge/share/text/ShareTextEntity;", "<init>", "(Landroid/app/Activity;Lid/dana/lib/gcontainer/app/bridge/share/text/ShareTextEntity;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class ShareTextManager {
    private final Activity activity;
    private final BridgeCallback bridgeCallback;
    private final ShareTextEntity shareTextEntity;

    public ShareTextManager(Activity activity, ShareTextEntity shareTextEntity, BridgeCallback bridgeCallback) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        this.activity = activity;
        this.shareTextEntity = shareTextEntity;
        this.bridgeCallback = bridgeCallback;
    }

    public final void processEvent() {
        ShareTextEntity shareTextEntity = this.shareTextEntity;
        if (shareTextEntity != null) {
            shareText(shareTextEntity);
        } else {
            this.bridgeCallback.sendJSONResponse(getResult("NO_CONTENT_INFO"));
        }
    }

    private final void shareText(ShareTextEntity shareTextEntity) {
        String title;
        String message = shareTextEntity.getMessage();
        if (message == null || message.length() == 0) {
            this.bridgeCallback.sendJSONResponse(getResult("NO_MESSAGE"));
            return;
        }
        String title2 = shareTextEntity.getTitle();
        if (title2 == null || title2.length() == 0) {
            title = this.activity.getString(R.string.share_via);
        } else {
            title = shareTextEntity.getTitle();
        }
        openChooseDialog(shareTextEntity.getMessage(), title);
    }

    private final void openChooseDialog(String extraMessage, String title) {
        Intent addFlags = new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", extraMessage).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        Intrinsics.checkNotNullExpressionValue(addFlags, "");
        try {
            this.activity.startActivity(Intent.createChooser(addFlags, title));
            this.bridgeCallback.sendJSONResponse(getResult("SUCCESS"));
        } catch (ActivityNotFoundException unused) {
            sendUnknownError();
        }
    }

    private final void sendUnknownError() {
        this.bridgeCallback.sendJSONResponse(getResult("UNKNOWN_ERROR"));
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
