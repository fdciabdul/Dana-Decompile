package id.dana.data.errorconfig.network;

import android.content.Context;
import com.alibaba.fastjson.parser.JSONLexer;
import id.dana.data.errorconfig.ErrorConfigEntityData;
import id.dana.data.errorconfig.ErrorConfigKey;
import id.dana.data.errorconfig.local.ErrorConfigPreferences;
import id.dana.data.foundation.amcs.AMCSManager;
import id.dana.data.foundation.h5app.utils.FileDownloader;
import id.dana.data.model.ErrorConfigAmcsResult;
import id.dana.data.storage.Serializer;
import id.dana.util.permission.Permission;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import io.reactivex.observers.DefaultObserver;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.inject.Inject;
import javax.inject.Singleton;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import okio.Okio;
import retrofit2.Response;

@Singleton
/* loaded from: classes2.dex */
public class NetworkErrorConfigEntityData implements ErrorConfigEntityData {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static char KClassImpl$Data$declaredNonStaticMembers$2 = 42065;
    private static char[] MyBillsEntityDataFactory = {37290, 37289, 37292, 37280, 37288, 37283, 37457, 37462, 37309, 37460, 37281, 37456, 37286, 37264, 37463, 37461};
    private static int PlaceComponentResult = 1;
    private final Context context;
    private boolean downloading;
    private ErrorConfigAmcsResult errorConfigAmcsResult;
    private final ErrorConfigPreferences errorConfigPreferences;
    private final Serializer serializer;

    static /* synthetic */ ErrorConfigAmcsResult access$000(NetworkErrorConfigEntityData networkErrorConfigEntityData) {
        int i = PlaceComponentResult + 27;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        ErrorConfigAmcsResult errorConfigAmcsResult = networkErrorConfigEntityData.errorConfigAmcsResult;
        int i3 = PlaceComponentResult + 57;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        if ((i3 % 2 != 0 ? '.' : (char) 4) != 4) {
            int i4 = 77 / 0;
            return errorConfigAmcsResult;
        }
        return errorConfigAmcsResult;
    }

    static /* synthetic */ ErrorConfigPreferences access$100(NetworkErrorConfigEntityData networkErrorConfigEntityData) {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 97;
            PlaceComponentResult = i % 128;
            boolean z = i % 2 == 0;
            ErrorConfigPreferences errorConfigPreferences = networkErrorConfigEntityData.errorConfigPreferences;
            if (z) {
                int i2 = 26 / 0;
            }
            return errorConfigPreferences;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public NetworkErrorConfigEntityData(Context context, Serializer serializer, AMCSManager aMCSManager, ErrorConfigPreferences errorConfigPreferences) {
        this.errorConfigPreferences = errorConfigPreferences;
        if (!aMCSManager.MyBillsEntityDataFactory()) {
            aMCSManager.MyBillsEntityDataFactory(context, "prod");
            int i = PlaceComponentResult + 53;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
        }
        try {
            this.serializer = serializer;
            this.context = context;
            int i3 = BuiltInFictitiousFunctionClassFactory + 21;
            PlaceComponentResult = i3 % 128;
            if (!(i3 % 2 == 0)) {
                return;
            }
            int i4 = 79 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    private void downloadConfig(String str, final int i) {
        int i2 = BuiltInFictitiousFunctionClassFactory + 9;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
        if (Permission.KClassImpl$Data$declaredNonStaticMembers$2(this.context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            try {
                this.downloading = true;
                try {
                    new FileDownloader(str).KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory().flatMap(new Function() { // from class: id.dana.data.errorconfig.network.NetworkErrorConfigEntityData$$ExternalSyntheticLambda0
                        @Override // io.reactivex.functions.Function
                        public final Object apply(Object obj) {
                            return NetworkErrorConfigEntityData.this.m1211xdd78aad3(i, (Response) obj);
                        }
                    }).subscribeOn(Schedulers.MyBillsEntityDataFactory()).observeOn(AndroidSchedulers.PlaceComponentResult()).doFinally(new Action() { // from class: id.dana.data.errorconfig.network.NetworkErrorConfigEntityData$$ExternalSyntheticLambda1
                        @Override // io.reactivex.functions.Action
                        public final void run() {
                            NetworkErrorConfigEntityData.this.m1212xd1082f14();
                        }
                    }).subscribe(new DefaultObserver<File>() { // from class: id.dana.data.errorconfig.network.NetworkErrorConfigEntityData.1
                        @Override // io.reactivex.Observer
                        public /* synthetic */ void onNext(Object obj) {
                            ((File) obj).getAbsolutePath();
                        }

                        @Override // io.reactivex.Observer
                        public void onError(Throwable th) {
                            th.toString();
                        }

                        @Override // io.reactivex.Observer
                        public void onComplete() {
                            NetworkErrorConfigEntityData.access$100(NetworkErrorConfigEntityData.this).saveErrorConfigVersion(NetworkErrorConfigEntityData.access$000(NetworkErrorConfigEntityData.this).getVersion());
                        }
                    });
                    int i4 = BuiltInFictitiousFunctionClassFactory + 95;
                    PlaceComponentResult = i4 % 128;
                    int i5 = i4 % 2;
                } catch (MalformedURLException unused) {
                }
            } catch (Exception e) {
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$downloadConfig$1$id-dana-data-errorconfig-network-NetworkErrorConfigEntityData  reason: not valid java name */
    public /* synthetic */ ObservableSource m1211xdd78aad3(final int i, final Response response) throws Exception {
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.errorconfig.network.NetworkErrorConfigEntityData$$ExternalSyntheticLambda2
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                NetworkErrorConfigEntityData.this.m1210xe9e92692(response, i, observableEmitter);
            }
        });
        int i2 = PlaceComponentResult + 97;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        if (!(i2 % 2 != 0)) {
            return create;
        }
        int i3 = 17 / 0;
        return create;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$downloadConfig$0$id-dana-data-errorconfig-network-NetworkErrorConfigEntityData  reason: not valid java name */
    public /* synthetic */ void m1210xe9e92692(Response response, int i, ObservableEmitter observableEmitter) throws Exception {
        int i2 = BuiltInFictitiousFunctionClassFactory + 69;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
        try {
            observableEmitter.onNext(processDownloadEmitter(response, i));
            observableEmitter.onComplete();
            int i4 = BuiltInFictitiousFunctionClassFactory + 29;
            PlaceComponentResult = i4 % 128;
            int i5 = i4 % 2;
        } catch (IOException e) {
            observableEmitter.onError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$downloadConfig$2$id-dana-data-errorconfig-network-NetworkErrorConfigEntityData  reason: not valid java name */
    public /* synthetic */ void m1212xd1082f14() throws Exception {
        int i = BuiltInFictitiousFunctionClassFactory + 47;
        PlaceComponentResult = i % 128;
        if ((i % 2 == 0 ? JSONLexer.EOI : 'S') != 'S') {
            try {
                this.downloading = false;
            } catch (Exception e) {
                throw e;
            }
        } else {
            this.downloading = false;
        }
        int i2 = PlaceComponentResult + 107;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        int i3 = i2 % 2;
    }

    private File processDownloadEmitter(Response<ResponseBody> response, int i) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(ErrorConfigKey.FILE_NAME_PREFIX);
        sb.append(i);
        String obj = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("/");
        sb2.append(obj);
        File file = new File(generateFileNameWithCustomPath(sb2.toString()));
        BufferedSink BuiltInFictitiousFunctionClassFactory2 = Okio.BuiltInFictitiousFunctionClassFactory(Okio.MyBillsEntityDataFactory(file));
        if (!(response.KClassImpl$Data$declaredNonStaticMembers$2 == null)) {
            int i2 = BuiltInFictitiousFunctionClassFactory + 21;
            PlaceComponentResult = i2 % 128;
            if (!(i2 % 2 == 0)) {
                BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory(response.KClassImpl$Data$declaredNonStaticMembers$2.source());
            } else {
                BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory(response.KClassImpl$Data$declaredNonStaticMembers$2.source());
                int i3 = 40 / 0;
            }
        }
        try {
            BuiltInFictitiousFunctionClassFactory2.close();
            return file;
        } catch (Exception e) {
            throw e;
        }
    }

    private String generateFileNameWithCustomPath(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.context.getFilesDir());
        sb.append(File.separator);
        sb.append(str);
        sb.append(".json");
        String obj = sb.toString();
        int i = BuiltInFictitiousFunctionClassFactory + 81;
        PlaceComponentResult = i % 128;
        if (i % 2 != 0) {
            return obj;
        }
        int i2 = 21 / 0;
        return obj;
    }

    @Override // id.dana.data.errorconfig.ErrorConfigEntityData
    public String getErrorMessageByKey(String str, ErrorConfigAmcsResult errorConfigAmcsResult) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x004b, code lost:
    
        if (r2 != 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
    
        if ((r0.length() != 0) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005b, code lost:
    
        r7.errorConfigAmcsResult = (id.dana.data.model.ErrorConfigAmcsResult) r7.serializer.deserialize(r0.toString(), id.dana.data.model.ErrorConfigAmcsResult.class);
        r0 = r7.errorConfigPreferences.getErrorConfigVersion();
        r2 = r7.errorConfigAmcsResult;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0073, code lost:
    
        if (r2 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0076, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0077, code lost:
    
        if (r1 == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007d, code lost:
    
        if (r0 >= r2.getVersion()) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007f, code lost:
    
        r0 = id.dana.data.errorconfig.network.NetworkErrorConfigEntityData.BuiltInFictitiousFunctionClassFactory + 101;
        id.dana.data.errorconfig.network.NetworkErrorConfigEntityData.PlaceComponentResult = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008b, code lost:
    
        if (r7.downloading != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008d, code lost:
    
        downloadConfig(r7.errorConfigAmcsResult.getUrl(), r7.errorConfigAmcsResult.getVersion());
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b3 A[RETURN] */
    @Override // id.dana.data.errorconfig.ErrorConfigEntityData
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public id.dana.data.model.ErrorConfigAmcsResult getErrorConfigAmcs() {
        /*
            r7 = this;
            com.iap.ac.config.lite.ConfigCenter r0 = com.iap.ac.config.lite.ConfigCenter.getInstance()
            r1 = 20
            char[] r2 = new char[r1]
            r2 = {x00b4: FILL_ARRAY_DATA , data: [0, 2, 5, 9, 14, 8, 1, 12, 4, 12, 11, 0, 9, 12, 3, 0, 9, 2, 0, 8} // fill-array
            r3 = 0
            java.lang.String r4 = ""
            int r4 = android.text.TextUtils.getCapsMode(r4, r3, r3)
            int r4 = r4 + 112
            byte r4 = (byte) r4
            int r5 = android.view.ViewConfiguration.getEdgeSlop()
            int r5 = r5 >> 16
            int r5 = r5 + r1
            r1 = 1
            java.lang.Object[] r6 = new java.lang.Object[r1]
            a(r2, r4, r5, r6)
            r2 = r6[r3]
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r2 = r2.intern()
            org.json.JSONObject r0 = r0.getJSONConfig(r2)
            r2 = 49
            if (r0 == 0) goto L35
            r4 = 98
            goto L37
        L35:
            r4 = 49
        L37:
            r5 = 0
            if (r4 == r2) goto L9d
            int r2 = id.dana.data.errorconfig.network.NetworkErrorConfigEntityData.BuiltInFictitiousFunctionClassFactory
            int r2 = r2 + 83
            int r4 = r2 % 128
            id.dana.data.errorconfig.network.NetworkErrorConfigEntityData.PlaceComponentResult = r4
            int r2 = r2 % 2
            if (r2 != 0) goto L50
            int r2 = r0.length()
            int r4 = r5.length     // Catch: java.lang.Throwable -> L4e
            if (r2 == 0) goto L9d
            goto L5b
        L4e:
            r0 = move-exception
            throw r0
        L50:
            int r2 = r0.length()
            if (r2 == 0) goto L58
            r2 = 1
            goto L59
        L58:
            r2 = 0
        L59:
            if (r2 == 0) goto L9d
        L5b:
            id.dana.data.storage.Serializer r2 = r7.serializer
            java.lang.String r0 = r0.toString()
            java.lang.Class<id.dana.data.model.ErrorConfigAmcsResult> r4 = id.dana.data.model.ErrorConfigAmcsResult.class
            java.lang.Object r0 = r2.deserialize(r0, r4)
            id.dana.data.model.ErrorConfigAmcsResult r0 = (id.dana.data.model.ErrorConfigAmcsResult) r0
            r7.errorConfigAmcsResult = r0
            id.dana.data.errorconfig.local.ErrorConfigPreferences r0 = r7.errorConfigPreferences
            int r0 = r0.getErrorConfigVersion()
            id.dana.data.model.ErrorConfigAmcsResult r2 = r7.errorConfigAmcsResult
            if (r2 == 0) goto L76
            goto L77
        L76:
            r1 = 0
        L77:
            if (r1 == 0) goto L9f
            int r1 = r2.getVersion()
            if (r0 >= r1) goto L9f
            int r0 = id.dana.data.errorconfig.network.NetworkErrorConfigEntityData.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 101
            int r1 = r0 % 128
            id.dana.data.errorconfig.network.NetworkErrorConfigEntityData.PlaceComponentResult = r1
            int r0 = r0 % 2
            boolean r0 = r7.downloading
            if (r0 != 0) goto L9f
            id.dana.data.model.ErrorConfigAmcsResult r0 = r7.errorConfigAmcsResult
            java.lang.String r0 = r0.getUrl()
            id.dana.data.model.ErrorConfigAmcsResult r1 = r7.errorConfigAmcsResult
            int r1 = r1.getVersion()
            r7.downloadConfig(r0, r1)
            goto L9f
        L9d:
            r7.errorConfigAmcsResult = r5
        L9f:
            id.dana.data.model.ErrorConfigAmcsResult r0 = r7.errorConfigAmcsResult
            int r1 = id.dana.data.errorconfig.network.NetworkErrorConfigEntityData.BuiltInFictitiousFunctionClassFactory
            int r1 = r1 + 115
            int r2 = r1 % 128
            id.dana.data.errorconfig.network.NetworkErrorConfigEntityData.PlaceComponentResult = r2
            int r1 = r1 % 2
            if (r1 != 0) goto Lb3
            r1 = 63
            int r1 = r1 / r3
            return r0
        Lb1:
            r0 = move-exception
            throw r0
        Lb3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.errorconfig.network.NetworkErrorConfigEntityData.getErrorConfigAmcs():id.dana.data.model.ErrorConfigAmcsResult");
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x008d, code lost:
    
        if ((r0.MyBillsEntityDataFactory == r0.PlaceComponentResult ? 22 : '\t') != '\t') goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a9, code lost:
    
        if ((r0.MyBillsEntityDataFactory == r0.PlaceComponentResult ? 3 : '#') != '#') goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ab, code lost:
    
        r3[r0.getAuthRequestContext] = (char) (r0.MyBillsEntityDataFactory - r11);
        r3[r0.getAuthRequestContext + 1] = (char) (r0.PlaceComponentResult - r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00be, code lost:
    
        r0.BuiltInFictitiousFunctionClassFactory = r0.MyBillsEntityDataFactory / r2;
        r0.scheduleImpl = r0.MyBillsEntityDataFactory % r2;
        r0.KClassImpl$Data$declaredNonStaticMembers$2 = r0.PlaceComponentResult / r2;
        r0.lookAheadTest = r0.PlaceComponentResult % r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d6, code lost:
    
        if (r0.scheduleImpl != r0.lookAheadTest) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d8, code lost:
    
        r0.BuiltInFictitiousFunctionClassFactory = ((r0.BuiltInFictitiousFunctionClassFactory + r2) - 1) % r2;
        r0.KClassImpl$Data$declaredNonStaticMembers$2 = ((r0.KClassImpl$Data$declaredNonStaticMembers$2 + r2) - 1) % r2;
        r7 = (r0.BuiltInFictitiousFunctionClassFactory * r2) + r0.scheduleImpl;
        r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r2) + r0.lookAheadTest;
        r3[r0.getAuthRequestContext] = r1[r7];
        r3[r0.getAuthRequestContext + 1] = r1[r8];
        r7 = id.dana.data.errorconfig.network.NetworkErrorConfigEntityData.$11 + 111;
        id.dana.data.errorconfig.network.NetworkErrorConfigEntityData.$10 = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0112, code lost:
    
        if (r0.BuiltInFictitiousFunctionClassFactory != r0.KClassImpl$Data$declaredNonStaticMembers$2) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0114, code lost:
    
        r7 = '+';
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0117, code lost:
    
        r7 = kotlin.text.Typography.quote;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0119, code lost:
    
        if (r7 == '\"') goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x011b, code lost:
    
        r0.scheduleImpl = ((r0.scheduleImpl + r2) - 1) % r2;
        r0.lookAheadTest = ((r0.lookAheadTest + r2) - 1) % r2;
        r7 = (r0.BuiltInFictitiousFunctionClassFactory * r2) + r0.scheduleImpl;
        r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r2) + r0.lookAheadTest;
        r3[r0.getAuthRequestContext] = r1[r7];
        r3[r0.getAuthRequestContext + 1] = r1[r8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0145, code lost:
    
        r7 = (r0.BuiltInFictitiousFunctionClassFactory * r2) + r0.lookAheadTest;
        r8 = (r0.KClassImpl$Data$declaredNonStaticMembers$2 * r2) + r0.scheduleImpl;
        r3[r0.getAuthRequestContext] = r1[r7];
        r3[r0.getAuthRequestContext + 1] = r1[r8];
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0168, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0169, code lost:
    
        throw r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(char[] r10, byte r11, int r12, java.lang.Object[] r13) {
        /*
            Method dump skipped, instructions count: 385
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.errorconfig.network.NetworkErrorConfigEntityData.a(char[], byte, int, java.lang.Object[]):void");
    }
}
