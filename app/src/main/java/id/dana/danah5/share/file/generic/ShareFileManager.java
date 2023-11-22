package id.dana.danah5.share.file.generic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import id.dana.danah5.share.constant.StringDefaultValue;
import id.dana.danah5.share.file.ShareFileResultType;
import id.dana.lib.gcontainer.GContainer;
import id.dana.lib.gcontainer.app.bridge.downloadfile.IDownloadListener;
import id.dana.util.a.a;
import id.dana.util.media.FileUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import io.reactivex.observers.DisposableObserver;
import java.io.File;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes2.dex */
public class ShareFileManager {
    private static final String TAG = "ShareFileManager";
    private Activity activity;
    private BridgeCallback bridgeCallback;
    private ShareFileEntity entity;
    private IDownloadListener iDownloadListener;

    public ShareFileManager(BridgeCallback bridgeCallback, Activity activity, IDownloadListener iDownloadListener) {
        this.bridgeCallback = bridgeCallback;
        this.activity = activity;
        this.iDownloadListener = iDownloadListener;
    }

    public void processEvent() {
        if (this.entity == null) {
            sendGeneralError();
        } else if (FileUtil.getAuthRequestContext() <= this.entity.getMinStorageAvailable()) {
            this.bridgeCallback.sendJSONResponse(ShareFileResultFactory.getResult(ShareFileResultType.STORAGE_RUNNING_OUT_ERROR));
        } else {
            processDownload(this.entity);
        }
    }

    private void processDownload(ShareFileEntity shareFileEntity) {
        File MyBillsEntityDataFactory;
        String str;
        MyBillsEntityDataFactory = a.MyBillsEntityDataFactory(getContext().getFilesDir(), "/DANA/");
        if (!MyBillsEntityDataFactory.exists()) {
            FileUtil.getAuthRequestContext(MyBillsEntityDataFactory.getAbsolutePath());
        }
        try {
            String str2 = "";
            if (shareFileEntity.getFilePath() != null) {
                str2 = shareFileEntity.getExtension(shareFileEntity.getFilePath());
                str = shareFileEntity.getFilePath();
            } else if (shareFileEntity.getSource() != null) {
                str2 = shareFileEntity.getExtension(shareFileEntity.getSource());
                str = shareFileEntity.getSource();
            } else {
                str = "";
            }
            String fileName = shareFileEntity.getFileName();
            Context context = getContext();
            StringBuilder sb = new StringBuilder();
            sb.append(fileName);
            sb.append(str2);
            this.iDownloadListener.download(str, FileUtil.BuiltInFictitiousFunctionClassFactory(context, sb.toString()).getPath(), shareFileEntity.getFileType()).subscribe(new DisposableObserver<File>() { // from class: id.dana.danah5.share.file.generic.ShareFileManager.1
                {
                    ShareFileManager.this = this;
                }

                @Override // io.reactivex.Observer
                public void onNext(File file) {
                    ShareFileManager.this.shareImage(file);
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    DanaLog.BuiltInFictitiousFunctionClassFactory(ShareFileManager.TAG, "processDownload", th);
                    ShareFileManager.this.sendGeneralError();
                }

                @Override // io.reactivex.Observer
                public void onComplete() {
                    dispose();
                }
            });
        } catch (IllegalStateException e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(TAG, "processDownload", e);
            this.bridgeCallback.sendJSONResponse(ShareFileResultFactory.getResult("GENERAL_ERROR"));
        }
    }

    public void sendGeneralError() {
        this.bridgeCallback.sendJSONResponse(ShareFileResultFactory.getResult("GENERAL_ERROR"));
    }

    private Context getContext() {
        return GContainer.getApplicationContext();
    }

    public void shareImage(File file) {
        openChooserDialog(FileUtil.PlaceComponentResult(getContext(), file));
    }

    private void openChooserDialog(Uri uri) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setFlags(1);
        intent.putExtra("android.intent.extra.STREAM", uri);
        intent.setType("image/*");
        if (!this.activity.getBaseContext().getPackageManager().queryIntentActivities(intent, 0).isEmpty()) {
            this.activity.startActivity(Intent.createChooser(intent, StringDefaultValue.SHARE_TITLE));
            this.bridgeCallback.sendJSONResponse(ShareFileResultFactory.getResult("SUCCESS"));
            return;
        }
        this.bridgeCallback.sendJSONResponse(ShareFileResultFactory.getResult("NO_APP_SUPPORTED_ERROR"));
    }

    public void setInfo(ShareFileEntity shareFileEntity) {
        this.entity = shareFileEntity;
    }
}
