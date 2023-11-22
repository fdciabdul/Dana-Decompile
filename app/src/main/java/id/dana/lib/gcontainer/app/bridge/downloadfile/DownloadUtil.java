package id.dana.lib.gcontainer.app.bridge.downloadfile;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.webkit.URLUtil;
import id.dana.lib.gcontainer.app.bridge.downloadfile.network.FileDownloader;
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
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import okio.Okio;
import retrofit2.Response;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001(B\t\b\u0002¢\u0006\u0004\b&\u0010'J-\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ1\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\u0016\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J1\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ)\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ7\u0010$\u001a\u00020#2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u000e\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0!H\u0002¢\u0006\u0004\b$\u0010%"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/downloadfile/DownloadUtil;", "", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;", "responseBodyResponse", "", "fullFilePath", "Lio/reactivex/Observable;", "Ljava/io/File;", "createTemporaryFile", "(Lretrofit2/Response;Ljava/lang/String;)Lio/reactivex/Observable;", "Ljava/io/InputStream;", "inputStream", "Landroid/graphics/Bitmap$CompressFormat;", "format", "Lio/reactivex/ObservableSource;", "decodeResponse", "(Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/Bitmap$CompressFormat;)Lio/reactivex/ObservableSource;", "url", "fileExtension", "downloadFile", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "path", "downloadFileFromUri", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/lib/gcontainer/app/bridge/downloadfile/network/FileDownloader;", "fileDownloader", "downloadImage", "(Lid/dana/lib/gcontainer/app/bridge/downloadfile/network/FileDownloader;Ljava/lang/String;Landroid/graphics/Bitmap$CompressFormat;)Lio/reactivex/Observable;", "downloadPDF", "(Lid/dana/lib/gcontainer/app/bridge/downloadfile/network/FileDownloader;Ljava/lang/String;)Lio/reactivex/Observable;", "Landroid/graphics/Bitmap;", "bitmap", "Lio/reactivex/ObservableEmitter;", "emitter", "", "saveToInternalStorage", "(Landroid/graphics/Bitmap;Ljava/lang/String;Landroid/graphics/Bitmap$CompressFormat;Lio/reactivex/ObservableEmitter;)V", "<init>", "()V", "ExtensionFileType"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class DownloadUtil {
    public static final DownloadUtil INSTANCE = new DownloadUtil();

    private DownloadUtil() {
    }

    public final Observable<File> downloadFile(String url, String fullFilePath, String fileExtension) {
        Intrinsics.checkNotNullParameter(url, "");
        Intrinsics.checkNotNullParameter(fullFilePath, "");
        Intrinsics.checkNotNullParameter(fileExtension, "");
        if (URLUtil.isValidUrl(url)) {
            FileDownloader fileDownloader = new FileDownloader(url);
            int hashCode = fileExtension.hashCode();
            if (hashCode != 1475827) {
                if (hashCode != 1481220) {
                    if (hashCode == 1481531 && fileExtension.equals(".png")) {
                        return downloadImage(fileDownloader, fullFilePath, Bitmap.CompressFormat.PNG);
                    }
                } else if (fileExtension.equals(".pdf")) {
                    return downloadPDF(fileDownloader, fullFilePath);
                }
            } else if (fileExtension.equals(".jpg")) {
                return downloadImage(fileDownloader, fullFilePath, Bitmap.CompressFormat.JPEG);
            }
            return downloadPDF(fileDownloader, fullFilePath);
        }
        return downloadFileFromUri(url);
    }

    private final Observable<File> downloadImage(FileDownloader fileDownloader, final String fullFilePath, final Bitmap.CompressFormat format) {
        Observable<R> flatMap;
        Observable subscribeOn;
        Observable<Response<ResponseBody>> downloadFile = fileDownloader.downloadFile();
        if (downloadFile == null || (flatMap = downloadFile.flatMap(new Function() { // from class: id.dana.lib.gcontainer.app.bridge.downloadfile.DownloadUtil$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2653downloadImage$lambda0;
                m2653downloadImage$lambda0 = DownloadUtil.m2653downloadImage$lambda0(fullFilePath, format, (Response) obj);
                return m2653downloadImage$lambda0;
            }
        })) == 0 || (subscribeOn = flatMap.subscribeOn(Schedulers.MyBillsEntityDataFactory())) == null) {
            return null;
        }
        return subscribeOn.observeOn(Schedulers.MyBillsEntityDataFactory());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: downloadImage$lambda-0  reason: not valid java name */
    public static final ObservableSource m2653downloadImage$lambda0(String str, Bitmap.CompressFormat compressFormat, Response response) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(compressFormat, "");
        Intrinsics.checkNotNullParameter(response, "");
        DownloadUtil downloadUtil = INSTANCE;
        ResponseBody responseBody = (ResponseBody) response.KClassImpl$Data$declaredNonStaticMembers$2;
        return downloadUtil.decodeResponse(responseBody == null ? null : responseBody.byteStream(), str, compressFormat);
    }

    private final Observable<File> downloadPDF(FileDownloader fileDownloader, final String fullFilePath) {
        Observable<R> flatMap;
        Observable subscribeOn;
        Observable<Response<ResponseBody>> downloadFile = fileDownloader.downloadFile();
        if (downloadFile == null || (flatMap = downloadFile.flatMap(new Function() { // from class: id.dana.lib.gcontainer.app.bridge.downloadfile.DownloadUtil$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2654downloadPDF$lambda1;
                m2654downloadPDF$lambda1 = DownloadUtil.m2654downloadPDF$lambda1(fullFilePath, (Response) obj);
                return m2654downloadPDF$lambda1;
            }
        })) == 0 || (subscribeOn = flatMap.subscribeOn(Schedulers.MyBillsEntityDataFactory())) == null) {
            return null;
        }
        return subscribeOn.observeOn(Schedulers.MyBillsEntityDataFactory());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: downloadPDF$lambda-1  reason: not valid java name */
    public static final ObservableSource m2654downloadPDF$lambda1(String str, Response response) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(response, "");
        return INSTANCE.createTemporaryFile(response, str);
    }

    private final Observable<File> downloadFileFromUri(final String path) {
        Observable<File> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.lib.gcontainer.app.bridge.downloadfile.DownloadUtil$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                File m2652downloadFileFromUri$lambda2;
                m2652downloadFileFromUri$lambda2 = DownloadUtil.m2652downloadFileFromUri$lambda2(path);
                return m2652downloadFileFromUri$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: downloadFileFromUri$lambda-2  reason: not valid java name */
    public static final File m2652downloadFileFromUri$lambda2(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        File file = new File(str);
        if (file.exists()) {
            return file;
        }
        return null;
    }

    private final ObservableSource<File> decodeResponse(final InputStream inputStream, final String fullFilePath, final Bitmap.CompressFormat format) {
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.lib.gcontainer.app.bridge.downloadfile.DownloadUtil$$ExternalSyntheticLambda3
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                DownloadUtil.m2651decodeResponse$lambda3(inputStream, fullFilePath, format, observableEmitter);
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "");
        return create;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: decodeResponse$lambda-3  reason: not valid java name */
    public static final void m2651decodeResponse$lambda3(InputStream inputStream, String str, Bitmap.CompressFormat compressFormat, ObservableEmitter observableEmitter) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(compressFormat, "");
        Intrinsics.checkNotNullParameter(observableEmitter, "");
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
            DownloadUtil downloadUtil = INSTANCE;
            Intrinsics.checkNotNullExpressionValue(decodeStream, "");
            downloadUtil.saveToInternalStorage(decodeStream, str, compressFormat, observableEmitter);
        } catch (Exception e) {
            observableEmitter.onError(e);
        }
    }

    private final Observable<File> createTemporaryFile(final Response<ResponseBody> responseBodyResponse, final String fullFilePath) {
        Observable<File> create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.lib.gcontainer.app.bridge.downloadfile.DownloadUtil$$ExternalSyntheticLambda0
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                DownloadUtil.m2650createTemporaryFile$lambda4(fullFilePath, responseBodyResponse, observableEmitter);
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "");
        return create;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createTemporaryFile$lambda-4  reason: not valid java name */
    public static final void m2650createTemporaryFile$lambda4(String str, Response response, ObservableEmitter observableEmitter) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(response, "");
        Intrinsics.checkNotNullParameter(observableEmitter, "");
        try {
            File file = new File(str);
            BufferedSink BuiltInFictitiousFunctionClassFactory = Okio.BuiltInFictitiousFunctionClassFactory(Okio.MyBillsEntityDataFactory(file));
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
            ResponseBody responseBody = (ResponseBody) response.KClassImpl$Data$declaredNonStaticMembers$2;
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(responseBody == null ? null : responseBody.source());
            BuiltInFictitiousFunctionClassFactory.close();
            observableEmitter.onNext(file);
            observableEmitter.onComplete();
        } catch (IOException e) {
            observableEmitter.onError(e);
        }
    }

    private final void saveToInternalStorage(Bitmap bitmap, String fullFilePath, Bitmap.CompressFormat format, ObservableEmitter<File> emitter) {
        try {
            File file = new File(fullFilePath);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(format, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            emitter.onNext(file);
        } catch (IOException e) {
            emitter.onError(e);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/downloadfile/DownloadUtil$ExtensionFileType;", "", "Companion"}, k = 1, mv = {1, 5, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes2.dex */
    public @interface ExtensionFileType {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final String JPG = ".jpg";
        public static final String PDF = ".pdf";
        public static final String PNG = ".png";

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/downloadfile/DownloadUtil$ExtensionFileType$Companion;", "", "", "JPG", "Ljava/lang/String;", "PDF", "PNG", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final String JPG = ".jpg";
            public static final String PDF = ".pdf";
            public static final String PNG = ".png";

            private Companion() {
            }
        }
    }
}
