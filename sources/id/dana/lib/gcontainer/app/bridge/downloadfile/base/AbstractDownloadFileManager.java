package id.dana.lib.gcontainer.app.bridge.downloadfile.base;

import android.content.Context;
import android.webkit.URLUtil;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.fastjson.JSONObject;
import com.anggrayudi.storage.file.DocumentFileCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import id.dana.lib.gcontainer.app.bridge.downloadfile.IDownloadListener;
import id.dana.lib.logger.DANALog;
import id.dana.promocenter.model.PromoActionType;
import id.dana.util.a.a;
import id.dana.util.media.FileUtil;
import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u001f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ-\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/downloadfile/base/AbstractDownloadFileManager;", "", "Ljava/io/File;", "imageFile", "", "mimeType", "", "onDownloadSuccess", "(Ljava/io/File;Ljava/lang/String;)V", "fileUrl", "fileName", "fileFormat", "processDownload", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "processEvent", "Lcom/alibaba/fastjson/JSONObject;", "sendGeneralError", "()Lcom/alibaba/fastjson/JSONObject;", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "Lid/dana/lib/gcontainer/app/bridge/downloadfile/IDownloadListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lid/dana/lib/gcontainer/app/bridge/downloadfile/IDownloadListener;", "<init>", "(Landroid/content/Context;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lid/dana/lib/gcontainer/app/bridge/downloadfile/IDownloadListener;)V", "Companion"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AbstractDownloadFileManager {
    private static final String TAG = "AbstractDownloadFileManager";
    private final BridgeCallback bridgeCallback;
    private final Context context;
    private final IDownloadListener listener;

    public abstract void onDownloadSuccess(File imageFile, String mimeType);

    public AbstractDownloadFileManager(Context context, BridgeCallback bridgeCallback, IDownloadListener iDownloadListener) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(iDownloadListener, "");
        this.context = context;
        this.bridgeCallback = bridgeCallback;
        this.listener = iDownloadListener;
    }

    public final void processEvent(String fileUrl, String fileName, String fileFormat, String mimeType) {
        Intrinsics.checkNotNullParameter(fileUrl, "");
        Intrinsics.checkNotNullParameter(fileName, "");
        Intrinsics.checkNotNullParameter(fileFormat, "");
        Intrinsics.checkNotNullParameter(mimeType, "");
        if (DocumentFileCompat.BuiltInFictitiousFunctionClassFactory(this.context, PromoActionType.PRIMARY) <= 104857600) {
            sendGeneralError();
        } else {
            processDownload(fileUrl, fileName, fileFormat, mimeType);
        }
    }

    private final void processDownload(String fileUrl, String fileName, String fileFormat, final String mimeType) {
        File MyBillsEntityDataFactory;
        MyBillsEntityDataFactory = a.MyBillsEntityDataFactory(this.context.getFilesDir(), "/DANA/");
        if (!MyBillsEntityDataFactory.exists()) {
            MyBillsEntityDataFactory.mkdirs();
        }
        try {
            File BuiltInFictitiousFunctionClassFactory = FileUtil.BuiltInFictitiousFunctionClassFactory(this.context, Intrinsics.stringPlus(fileName, fileFormat));
            if (!URLUtil.isValidUrl(fileUrl)) {
                onDownloadSuccess(new File(fileUrl), mimeType);
                return;
            }
            IDownloadListener iDownloadListener = this.listener;
            String path = BuiltInFictitiousFunctionClassFactory.getPath();
            if (path == null) {
                return;
            }
            Observable<File> download = iDownloadListener.download(fileUrl, path, mimeType);
            Intrinsics.checkNotNullExpressionValue(download, "");
            download.subscribe(new DisposableObserver<File>(mimeType, this) { // from class: id.dana.lib.gcontainer.app.bridge.downloadfile.base.AbstractDownloadFileManager$processDownload$$inlined$subscribeWithAutoDispose$1
                final /* synthetic */ String $mimeType$inlined;

                @Override // io.reactivex.Observer
                public final void onComplete() {
                    dispose();
                }

                @Override // io.reactivex.Observer
                public final void onNext(File t) {
                    File file = t;
                    AbstractDownloadFileManager abstractDownloadFileManager = AbstractDownloadFileManager.this;
                    Intrinsics.checkNotNullExpressionValue(file, "");
                    abstractDownloadFileManager.onDownloadSuccess(file, this.$mimeType$inlined);
                }

                @Override // io.reactivex.Observer
                public final void onError(Throwable e) {
                    String str;
                    BridgeCallback bridgeCallback;
                    JSONObject sendGeneralError;
                    Intrinsics.checkNotNullParameter(e, "");
                    str = AbstractDownloadFileManager.TAG;
                    DANALog.PlaceComponentResult(str, "processDownload", e);
                    bridgeCallback = AbstractDownloadFileManager.this.bridgeCallback;
                    sendGeneralError = AbstractDownloadFileManager.this.sendGeneralError();
                    bridgeCallback.sendJSONResponse(sendGeneralError);
                    dispose();
                }
            });
        } catch (IllegalStateException e) {
            DANALog.PlaceComponentResult(TAG, "processDownload", e);
            this.bridgeCallback.sendJSONResponse(sendGeneralError());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject sendGeneralError() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = jSONObject;
        jSONObject2.put((JSONObject) "success", (String) Boolean.FALSE);
        jSONObject2.put((JSONObject) "error", "001");
        return jSONObject;
    }
}
