package id.dana.lib.gcontainer.app.bridge.share;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.fastjson.JSONObject;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.lib.gcontainer.R;
import id.dana.lib.gcontainer.app.bridge.downloadfile.IDownloadListener;
import id.dana.lib.gcontainer.app.bridge.downloadfile.base.AbstractDownloadFileManager;
import id.dana.util.media.FileUtil;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0015\u001a\u00020\u00148\u0007¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/share/ShareFileManager;", "Lid/dana/lib/gcontainer/app/bridge/downloadfile/base/AbstractDownloadFileManager;", "", "errorType", "Lcom/alibaba/fastjson/JSONObject;", "getResult", "(Ljava/lang/String;)Lcom/alibaba/fastjson/JSONObject;", "Ljava/io/File;", "imageFile", "mimeType", "", "onDownloadSuccess", "(Ljava/io/File;Ljava/lang/String;)V", "Landroid/net/Uri;", "uri", "openChooserDialog", "(Landroid/net/Uri;)V", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "Landroid/app/Activity;", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "getBridgeCallback", "()Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "Lid/dana/lib/gcontainer/app/bridge/downloadfile/IDownloadListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Landroid/app/Activity;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lid/dana/lib/gcontainer/app/bridge/downloadfile/IDownloadListener;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class ShareFileManager extends AbstractDownloadFileManager {
    private final Activity activity;
    private final BridgeCallback bridgeCallback;

    @JvmName(name = "getBridgeCallback")
    public final BridgeCallback getBridgeCallback() {
        return this.bridgeCallback;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareFileManager(Activity activity, BridgeCallback bridgeCallback, IDownloadListener iDownloadListener) {
        super(activity, bridgeCallback, iDownloadListener);
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(iDownloadListener, "");
        this.activity = activity;
        this.bridgeCallback = bridgeCallback;
    }

    @Override // id.dana.lib.gcontainer.app.bridge.downloadfile.base.AbstractDownloadFileManager
    public final void onDownloadSuccess(File imageFile, String mimeType) {
        Intrinsics.checkNotNullParameter(imageFile, "");
        Intrinsics.checkNotNullParameter(mimeType, "");
        Uri PlaceComponentResult = FileUtil.PlaceComponentResult(this.activity, imageFile);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        openChooserDialog(PlaceComponentResult);
    }

    private final void openChooserDialog(Uri uri) {
        Intent addFlags = new Intent("android.intent.action.SEND").setType("image/jpeg").putExtra("android.intent.extra.STREAM", uri).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(1);
        Intrinsics.checkNotNullExpressionValue(addFlags, "");
        try {
            Activity activity = this.activity;
            activity.startActivity(Intent.createChooser(addFlags, activity.getString(R.string.share_via)));
            this.bridgeCallback.sendJSONResponse(getResult("SUCCESS"));
        } catch (ActivityNotFoundException unused) {
            this.bridgeCallback.sendJSONResponse(getResult("NO_APP_SUPPORTED_ERROR"));
        }
    }

    private final JSONObject getResult(String errorType) {
        if (Intrinsics.areEqual(errorType, "SUCCESS")) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put((JSONObject) "success", (String) Boolean.TRUE);
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = jSONObject2;
        jSONObject3.put((JSONObject) "success", (String) Boolean.FALSE);
        jSONObject3.put((JSONObject) "error", Intrinsics.areEqual(errorType, "NO_APP_SUPPORTED_ERROR") ? "002" : "001");
        return jSONObject2;
    }
}
