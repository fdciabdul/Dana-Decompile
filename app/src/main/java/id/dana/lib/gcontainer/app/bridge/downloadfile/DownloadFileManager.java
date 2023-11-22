package id.dana.lib.gcontainer.app.bridge.downloadfile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import androidx.core.content.ContextCompat;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.fastjson.JSONObject;
import com.anggrayudi.storage.FileWrapper;
import com.anggrayudi.storage.file.DocumentFileCompat;
import com.anggrayudi.storage.media.FileDescription;
import com.anggrayudi.storage.media.MediaFile;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.lib.gcontainer.app.bridge.constant.BridgeKey;
import id.dana.lib.gcontainer.app.bridge.downloadfile.base.AbstractDownloadFileManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/downloadfile/DownloadFileManager;", "Lid/dana/lib/gcontainer/app/bridge/downloadfile/base/AbstractDownloadFileManager;", "", "path", "getDownloadDirectory", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/net/Uri;", "imageUri", "", "notifyGallery", "(Landroid/content/Context;Landroid/net/Uri;)V", "Ljava/io/File;", "imageFile", "mimeType", "onDownloadSuccess", "(Ljava/io/File;Ljava/lang/String;)V", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "Landroid/app/Activity;", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "Lid/dana/lib/gcontainer/app/bridge/downloadfile/IDownloadListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Landroid/app/Activity;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lid/dana/lib/gcontainer/app/bridge/downloadfile/IDownloadListener;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class DownloadFileManager extends AbstractDownloadFileManager {
    private final Activity activity;
    private final BridgeCallback bridgeCallback;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public DownloadFileManager(android.app.Activity r3, com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback r4, id.dana.lib.gcontainer.app.bridge.downloadfile.IDownloadListener r5) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            android.content.Context r1 = r3.getApplicationContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r2.<init>(r1, r4, r5)
            r2.activity = r3
            r2.bridgeCallback = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.lib.gcontainer.app.bridge.downloadfile.DownloadFileManager.<init>(android.app.Activity, com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback, id.dana.lib.gcontainer.app.bridge.downloadfile.IDownloadListener):void");
    }

    @Override // id.dana.lib.gcontainer.app.bridge.downloadfile.base.AbstractDownloadFileManager
    public final void onDownloadSuccess(File imageFile, String mimeType) {
        OutputStream PlaceComponentResult;
        Intrinsics.checkNotNullParameter(imageFile, "");
        Intrinsics.checkNotNullParameter(mimeType, "");
        int i = Build.VERSION.SDK_INT;
        Boolean bool = Boolean.FALSE;
        if (i < 29 && ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(this.activity, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            BridgeCallback bridgeCallback = this.bridgeCallback;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put((JSONObject) "success", (String) bool);
            Unit unit = Unit.INSTANCE;
            bridgeCallback.sendJSONResponse(jSONObject);
            return;
        }
        String name = imageFile.getName();
        Intrinsics.checkNotNullExpressionValue(name, "");
        FileWrapper MyBillsEntityDataFactory = DocumentFileCompat.MyBillsEntityDataFactory(this.activity, new FileDescription(name, TrackerKey.DanaBalanceRecipientTypeProperty.DANA, mimeType));
        if (MyBillsEntityDataFactory == null) {
            return;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(imageFile);
            PlaceComponentResult = MyBillsEntityDataFactory.PlaceComponentResult(this.activity);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                } else if (PlaceComponentResult != null) {
                    PlaceComponentResult.write(bArr, 0, read);
                }
            }
            fileInputStream.close();
            if (PlaceComponentResult != null) {
                PlaceComponentResult.flush();
            }
            if (PlaceComponentResult != null) {
                PlaceComponentResult.close();
            }
            imageFile.delete();
            notifyGallery(this.activity, MyBillsEntityDataFactory.PlaceComponentResult());
            BridgeCallback bridgeCallback2 = this.bridgeCallback;
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put((JSONObject) "success", (String) Boolean.TRUE);
            String str = Environment.DIRECTORY_DOWNLOADS;
            Intrinsics.checkNotNullExpressionValue(str, "");
            jSONObject2.put((JSONObject) BridgeKey.FILE_PATH, getDownloadDirectory(str));
            Unit unit2 = Unit.INSTANCE;
            bridgeCallback2.sendJSONResponse(jSONObject2);
        } catch (Exception unused) {
            BridgeCallback bridgeCallback3 = this.bridgeCallback;
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put((JSONObject) "success", (String) bool);
            Unit unit3 = Unit.INSTANCE;
            bridgeCallback3.sendJSONResponse(jSONObject3);
        }
    }

    private final String getDownloadDirectory(String path) {
        StringBuilder sb = new StringBuilder();
        sb.append("\"");
        sb.append("/");
        sb.append(path);
        sb.append("\"");
        String obj = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    private final void notifyGallery(Context context, Uri imageUri) {
        context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", imageUri));
        if (Build.VERSION.SDK_INT > 28) {
            new MediaFile(context, imageUri).scheduleImpl();
        }
    }
}
