package id.dana.data.util.download;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.webkit.URLUtil;
import id.dana.data.foundation.h5app.utils.FileDownloader;
import id.dana.utils.exception.CallableReturnNullError;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.MalformedURLException;
import java.util.concurrent.Callable;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import okio.Okio;
import retrofit2.Response;

/* loaded from: classes2.dex */
public final class DownloadUtil {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ExtensionFileType {
        public static final String JPG = ".jpg";
        public static final String PDF = ".pdf";
        public static final String PNG = ".png";
    }

    private DownloadUtil() {
    }

    public static Observable<File> downloadFile(String str, String str2, String str3) throws MalformedURLException {
        if (URLUtil.isValidUrl(str)) {
            FileDownloader fileDownloader = new FileDownloader(str);
            str3.hashCode();
            char c = 65535;
            int hashCode = str3.hashCode();
            if (hashCode != 1475827) {
                if (hashCode != 1481220) {
                    if (hashCode == 1481531 && str3.equals(".png")) {
                        c = 2;
                    }
                } else if (str3.equals(".pdf")) {
                    c = 1;
                }
            } else if (str3.equals(".jpg")) {
                c = 0;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c == 2) {
                        return downloadImage(fileDownloader, str2, Bitmap.CompressFormat.PNG);
                    }
                    return downloadPDF(fileDownloader, str2);
                }
                return downloadPDF(fileDownloader, str2);
            }
            return downloadImage(fileDownloader, str2, Bitmap.CompressFormat.JPEG);
        }
        return downloadFileFromUri(str);
    }

    private static Observable<File> downloadFileFromUri(final String str) {
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.util.download.DownloadUtil$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DownloadUtil.lambda$downloadFileFromUri$2(str);
            }
        });
    }

    public static /* synthetic */ File lambda$downloadFileFromUri$2(String str) throws Exception {
        File file = new File(str);
        if (file.exists()) {
            return file;
        }
        throw new CallableReturnNullError("DownloadUtil#downloadFileFromUri");
    }

    public static ObservableSource<File> decodeResponse(final InputStream inputStream, final String str, final Bitmap.CompressFormat compressFormat) {
        return Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.util.download.DownloadUtil$$ExternalSyntheticLambda0
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                DownloadUtil.lambda$decodeResponse$3(inputStream, str, compressFormat, observableEmitter);
            }
        });
    }

    public static /* synthetic */ void lambda$decodeResponse$3(InputStream inputStream, String str, Bitmap.CompressFormat compressFormat, ObservableEmitter observableEmitter) throws Exception {
        try {
            saveToInternalStorage(BitmapFactory.decodeStream(inputStream), str, compressFormat, observableEmitter);
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.DOWNLOAD_UTIL_TAG, "decodeResponse", e);
            observableEmitter.onError(e);
        }
    }

    public static Observable<File> createTemporaryFile(final Response<ResponseBody> response, final String str) {
        return Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.util.download.DownloadUtil$$ExternalSyntheticLambda3
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                DownloadUtil.lambda$createTemporaryFile$4(str, response, observableEmitter);
            }
        });
    }

    public static /* synthetic */ void lambda$createTemporaryFile$4(String str, Response response, ObservableEmitter observableEmitter) throws Exception {
        try {
            File file = new File(str);
            BufferedSink BuiltInFictitiousFunctionClassFactory = Okio.BuiltInFictitiousFunctionClassFactory(Okio.MyBillsEntityDataFactory(file));
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(((ResponseBody) response.KClassImpl$Data$declaredNonStaticMembers$2).source());
            BuiltInFictitiousFunctionClassFactory.close();
            observableEmitter.onNext(file);
            observableEmitter.onComplete();
        } catch (IOException e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.DOWNLOAD_UTIL_TAG, "createTemporaryFile", e);
            observableEmitter.onError(e);
        }
    }

    private static void saveToInternalStorage(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, ObservableEmitter<File> observableEmitter) {
        try {
            File file = new File(str);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(compressFormat, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            observableEmitter.onNext(file);
        } catch (IOException e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.DOWNLOAD_UTIL_TAG, "saveToInternalStorage", e);
            observableEmitter.onError(e);
        }
    }

    private static Observable<File> downloadImage(FileDownloader fileDownloader, final String str, final Bitmap.CompressFormat compressFormat) {
        return fileDownloader.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory().flatMap(new Function() { // from class: id.dana.data.util.download.DownloadUtil$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource decodeResponse;
                decodeResponse = DownloadUtil.decodeResponse(((ResponseBody) ((Response) obj).KClassImpl$Data$declaredNonStaticMembers$2).byteStream(), str, compressFormat);
                return decodeResponse;
            }
        }).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(Schedulers.MyBillsEntityDataFactory());
    }

    private static Observable<File> downloadPDF(FileDownloader fileDownloader, final String str) {
        return fileDownloader.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory().flatMap(new Function() { // from class: id.dana.data.util.download.DownloadUtil$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource createTemporaryFile;
                createTemporaryFile = DownloadUtil.createTemporaryFile((Response) obj, str);
                return createTemporaryFile;
            }
        }).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(Schedulers.MyBillsEntityDataFactory());
    }
}
