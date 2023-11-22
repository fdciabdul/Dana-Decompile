package id.dana.danah5.share.file.businessaccount;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import id.dana.danah5.share.constant.StringDefaultValue;
import id.dana.data.foundation.h5app.utils.FileDownloader;
import id.dana.lib.gcontainer.GContainer;
import id.dana.util.a.a;
import id.dana.util.media.FileUtil;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import net.sqlcipher.database.SQLiteDatabase;
import okhttp3.ResponseBody;
import retrofit2.Response;

/* loaded from: classes2.dex */
public class ShareBusinessAccountManager {
    private static final String FILE_NAME_FORMAT = "QR_";
    private static final String IMAGE_FORMAT = ".jpg";
    private static final long MINIMUM_STORAGE_AVAILABLE = 100;
    private final Activity activity;
    private final BridgeCallback bridgeCallback;
    private final ShareBusinessAccountFileEntity shareBusinessAccountFileEntity;

    public ShareBusinessAccountManager(Activity activity, ShareBusinessAccountFileEntity shareBusinessAccountFileEntity, BridgeCallback bridgeCallback) {
        this.activity = activity;
        this.bridgeCallback = bridgeCallback;
        this.shareBusinessAccountFileEntity = shareBusinessAccountFileEntity;
    }

    public void processEvent() {
        if (FileUtil.getAuthRequestContext() <= 100) {
            sendGeneralError();
            return;
        }
        ShareBusinessAccountFileEntity shareBusinessAccountFileEntity = this.shareBusinessAccountFileEntity;
        if (shareBusinessAccountFileEntity != null) {
            processDownload(shareBusinessAccountFileEntity);
        } else {
            sendGeneralError();
        }
    }

    public void sendGeneralError() {
        this.bridgeCallback.sendJSONResponse(ShareBusinessAccountResultFactory.getResult("GENERAL_ERROR"));
    }

    private void processDownload(final ShareBusinessAccountFileEntity shareBusinessAccountFileEntity) {
        try {
            new FileDownloader(shareBusinessAccountFileEntity.getUrl()).KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory().flatMap(new Function() { // from class: id.dana.danah5.share.file.businessaccount.ShareBusinessAccountManager$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return ShareBusinessAccountManager.this.m719x439c9643(shareBusinessAccountFileEntity, (Response) obj);
                }
            }).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new DisposableObserver<Boolean>() { // from class: id.dana.danah5.share.file.businessaccount.ShareBusinessAccountManager.1
                @Override // io.reactivex.Observer
                public void onComplete() {
                }

                {
                    ShareBusinessAccountManager.this = this;
                }

                @Override // io.reactivex.Observer
                public void onNext(Boolean bool) {
                    if (bool.booleanValue()) {
                        ShareBusinessAccountManager.this.shareImage(shareBusinessAccountFileEntity.getBusinessName());
                    }
                }

                @Override // io.reactivex.Observer
                public void onError(Throwable th) {
                    ShareBusinessAccountManager.this.sendGeneralError();
                }
            });
        } catch (MalformedURLException unused) {
            sendGeneralError();
        }
    }

    private ObservableSource<Boolean> decodeResponse(final InputStream inputStream, final String str) {
        return Observable.create(new ObservableOnSubscribe() { // from class: id.dana.danah5.share.file.businessaccount.ShareBusinessAccountManager$$ExternalSyntheticLambda1
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                ShareBusinessAccountManager.this.m718x11897516(inputStream, str, observableEmitter);
            }
        });
    }

    /* renamed from: lambda$decodeResponse$1$id-dana-danah5-share-file-businessaccount-ShareBusinessAccountManager */
    public /* synthetic */ void m718x11897516(InputStream inputStream, String str, ObservableEmitter observableEmitter) throws Exception {
        try {
            saveToInternalStorage(BitmapFactory.decodeStream(inputStream), str, observableEmitter);
        } catch (Exception e) {
            observableEmitter.onError(e);
        }
    }

    public void shareImage(String str) {
        Context context = getContext();
        StringBuilder sb = new StringBuilder();
        sb.append(FILE_NAME_FORMAT);
        sb.append(str);
        sb.append(".jpg");
        openChooserDialog(FileUtil.PlaceComponentResult(getContext(), FileUtil.BuiltInFictitiousFunctionClassFactory(context, sb.toString())));
    }

    private void saveToInternalStorage(Bitmap bitmap, String str, ObservableEmitter<Boolean> observableEmitter) {
        File MyBillsEntityDataFactory;
        MyBillsEntityDataFactory = a.MyBillsEntityDataFactory(getContext().getFilesDir(), "/DANA/");
        if (!MyBillsEntityDataFactory.exists()) {
            FileUtil.getAuthRequestContext(MyBillsEntityDataFactory.getAbsolutePath());
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(FILE_NAME_FORMAT);
            sb.append(str);
            sb.append(".jpg");
            FileOutputStream fileOutputStream = new FileOutputStream(new File(MyBillsEntityDataFactory, sb.toString()));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            observableEmitter.onNext(Boolean.TRUE);
        } catch (IOException unused) {
            sendGeneralError();
        }
    }

    private Context getContext() {
        return GContainer.getApplicationContext();
    }

    private void openChooserDialog(Uri uri) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setFlags(1);
        intent.putExtra("android.intent.extra.STREAM", uri);
        intent.setType("image/jpeg");
        if (!this.activity.getBaseContext().getPackageManager().queryIntentActivities(intent, 0).isEmpty()) {
            this.activity.startActivity(Intent.createChooser(intent, StringDefaultValue.SHARE_TITLE));
            this.bridgeCallback.sendJSONResponse(ShareBusinessAccountResultFactory.getResult("SUCCESS"));
            return;
        }
        this.bridgeCallback.sendJSONResponse(ShareBusinessAccountResultFactory.getResult("NO_APP_SUPPORTED_ERROR"));
    }

    /* renamed from: lambda$processDownload$0$id-dana-danah5-share-file-businessaccount-ShareBusinessAccountManager */
    public /* synthetic */ ObservableSource m719x439c9643(ShareBusinessAccountFileEntity shareBusinessAccountFileEntity, Response response) throws Exception {
        return decodeResponse(((ResponseBody) response.KClassImpl$Data$declaredNonStaticMembers$2).byteStream(), shareBusinessAccountFileEntity.getBusinessName());
    }
}
