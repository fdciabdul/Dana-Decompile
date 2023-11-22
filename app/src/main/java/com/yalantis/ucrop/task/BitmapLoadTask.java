package com.yalantis.ucrop.task;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.yalantis.ucrop.callback.BitmapLoadCallback;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import com.yalantis.ucrop.util.FileUtils;
import id.dana.data.constant.BranchLinkConstant;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;

/* loaded from: classes8.dex */
public class BitmapLoadTask extends AsyncTask<Void, Void, BitmapWorkerResult> {
    private Uri BuiltInFictitiousFunctionClassFactory;
    private final BitmapLoadCallback KClassImpl$Data$declaredNonStaticMembers$2;
    private Uri MyBillsEntityDataFactory;
    private final Context PlaceComponentResult;
    private final int getAuthRequestContext;
    private final int getErrorConfigVersion;

    @Override // android.os.AsyncTask
    protected /* synthetic */ BitmapWorkerResult doInBackground(Void[] voidArr) {
        return MyBillsEntityDataFactory();
    }

    @Override // android.os.AsyncTask
    protected /* synthetic */ void onPostExecute(BitmapWorkerResult bitmapWorkerResult) {
        BitmapWorkerResult bitmapWorkerResult2 = bitmapWorkerResult;
        if (bitmapWorkerResult2.getAuthRequestContext == null) {
            BitmapLoadCallback bitmapLoadCallback = this.KClassImpl$Data$declaredNonStaticMembers$2;
            Bitmap bitmap = bitmapWorkerResult2.BuiltInFictitiousFunctionClassFactory;
            ExifInfo exifInfo = bitmapWorkerResult2.KClassImpl$Data$declaredNonStaticMembers$2;
            String path = this.MyBillsEntityDataFactory.getPath();
            Uri uri = this.BuiltInFictitiousFunctionClassFactory;
            bitmapLoadCallback.BuiltInFictitiousFunctionClassFactory(bitmap, exifInfo, path, uri == null ? null : uri.getPath());
            return;
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(bitmapWorkerResult2.getAuthRequestContext);
    }

    /* loaded from: classes8.dex */
    public static class BitmapWorkerResult {
        Bitmap BuiltInFictitiousFunctionClassFactory;
        ExifInfo KClassImpl$Data$declaredNonStaticMembers$2;
        Exception getAuthRequestContext;

        public BitmapWorkerResult(Bitmap bitmap, ExifInfo exifInfo) {
            this.BuiltInFictitiousFunctionClassFactory = bitmap;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = exifInfo;
        }

        public BitmapWorkerResult(Exception exc) {
            this.getAuthRequestContext = exc;
        }
    }

    public BitmapLoadTask(Context context, Uri uri, Uri uri2, int i, int i2, BitmapLoadCallback bitmapLoadCallback) {
        this.PlaceComponentResult = context;
        this.MyBillsEntityDataFactory = uri;
        this.BuiltInFictitiousFunctionClassFactory = uri2;
        this.getErrorConfigVersion = i;
        this.getAuthRequestContext = i2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = bitmapLoadCallback;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.io.OutputStream, java.io.Closeable, java.io.FileOutputStream] */
    private BitmapWorkerResult MyBillsEntityDataFactory() {
        Throwable th;
        Sink sink;
        Response response;
        Throwable th2;
        InputStream inputStream;
        Uri uri = this.MyBillsEntityDataFactory;
        if (uri == null) {
            return new BitmapWorkerResult(new NullPointerException("Input Uri cannot be null"));
        }
        try {
            String scheme = uri.getScheme();
            StringBuilder sb = new StringBuilder();
            sb.append("Uri scheme: ");
            sb.append(scheme);
            InstrumentInjector.log_d("BitmapWorkerTask", sb.toString());
            boolean z = false;
            Sink sink2 = null;
            if (SemanticAttributes.FaasTriggerValues.HTTP.equals(scheme) || "https".equals(scheme)) {
                try {
                    Uri uri2 = this.MyBillsEntityDataFactory;
                    Uri uri3 = this.BuiltInFictitiousFunctionClassFactory;
                    InstrumentInjector.log_d("BitmapWorkerTask", "downloadFile");
                    if (uri3 == null) {
                        throw new NullPointerException("Output Uri is null - cannot download image");
                    }
                    OkHttpClient okHttpClient = new OkHttpClient();
                    try {
                        Response execute = FirebasePerfOkHttpClient.execute(okHttpClient.newCall(new Request.Builder().url(uri2.toString()).build()));
                        try {
                            BufferedSource source = execute.body().source();
                            try {
                                OutputStream openOutputStream = this.PlaceComponentResult.getContentResolver().openOutputStream(uri3);
                                if (openOutputStream != null) {
                                    Sink MyBillsEntityDataFactory = Okio.MyBillsEntityDataFactory(openOutputStream);
                                    try {
                                        source.PlaceComponentResult(MyBillsEntityDataFactory);
                                        BitmapLoadUtils.getAuthRequestContext(source);
                                        BitmapLoadUtils.getAuthRequestContext(MyBillsEntityDataFactory);
                                        if (execute != null) {
                                            BitmapLoadUtils.getAuthRequestContext(execute.body());
                                        }
                                        okHttpClient.dispatcher().cancelAll();
                                        this.MyBillsEntityDataFactory = this.BuiltInFictitiousFunctionClassFactory;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        sink2 = MyBillsEntityDataFactory;
                                        response = execute;
                                        sink = sink2;
                                        sink2 = source;
                                        BitmapLoadUtils.getAuthRequestContext(sink2);
                                        BitmapLoadUtils.getAuthRequestContext(sink);
                                        if (response != null) {
                                            BitmapLoadUtils.getAuthRequestContext(response.body());
                                        }
                                        okHttpClient.dispatcher().cancelAll();
                                        this.MyBillsEntityDataFactory = this.BuiltInFictitiousFunctionClassFactory;
                                        throw th;
                                    }
                                } else {
                                    throw new NullPointerException("OutputStream for given output Uri is null");
                                }
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            response = execute;
                            sink = null;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        sink = null;
                        response = null;
                    }
                } catch (IOException | NullPointerException e) {
                    InstrumentInjector.log_e("BitmapWorkerTask", "Downloading failed", e);
                    throw e;
                }
            } else if (!"content".equals(scheme)) {
                if (!"file".equals(scheme)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Invalid Uri scheme ");
                    sb2.append(scheme);
                    InstrumentInjector.log_e("BitmapWorkerTask", sb2.toString());
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Invalid Uri scheme");
                    sb3.append(scheme);
                    throw new IllegalArgumentException(sb3.toString());
                }
            } else {
                String BuiltInFictitiousFunctionClassFactory = ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, "android.permission.READ_EXTERNAL_STORAGE") == 0 ? FileUtils.BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult, this.MyBillsEntityDataFactory) : null;
                if (!TextUtils.isEmpty(BuiltInFictitiousFunctionClassFactory) && new File(BuiltInFictitiousFunctionClassFactory).exists()) {
                    this.MyBillsEntityDataFactory = Uri.fromFile(new File(BuiltInFictitiousFunctionClassFactory));
                } else {
                    try {
                        Uri uri4 = this.MyBillsEntityDataFactory;
                        Uri uri5 = this.BuiltInFictitiousFunctionClassFactory;
                        InstrumentInjector.log_d("BitmapWorkerTask", "copyFile");
                        if (uri5 == null) {
                            throw new NullPointerException("Output Uri is null - cannot copy image");
                        }
                        try {
                            inputStream = this.PlaceComponentResult.getContentResolver().openInputStream(uri4);
                            try {
                                ?? fileOutputStream = new FileOutputStream(new File(uri5.getPath()));
                                try {
                                    if (inputStream == null) {
                                        throw new NullPointerException("InputStream for given input Uri is null");
                                    }
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int read = inputStream.read(bArr);
                                        if (read <= 0) {
                                            break;
                                        }
                                        fileOutputStream.write(bArr, 0, read);
                                    }
                                    BitmapLoadUtils.getAuthRequestContext((Closeable) fileOutputStream);
                                    BitmapLoadUtils.getAuthRequestContext(inputStream);
                                    this.MyBillsEntityDataFactory = this.BuiltInFictitiousFunctionClassFactory;
                                } catch (Throwable th7) {
                                    th2 = th7;
                                    sink2 = fileOutputStream;
                                    BitmapLoadUtils.getAuthRequestContext(sink2);
                                    BitmapLoadUtils.getAuthRequestContext(inputStream);
                                    this.MyBillsEntityDataFactory = this.BuiltInFictitiousFunctionClassFactory;
                                    throw th2;
                                }
                            } catch (Throwable th8) {
                                th2 = th8;
                            }
                        } catch (Throwable th9) {
                            th2 = th9;
                            inputStream = null;
                        }
                    } catch (IOException | NullPointerException e2) {
                        InstrumentInjector.log_e("BitmapWorkerTask", "Copying failed", e2);
                        throw e2;
                    }
                }
            }
            try {
                ParcelFileDescriptor openFileDescriptor = this.PlaceComponentResult.getContentResolver().openFileDescriptor(this.MyBillsEntityDataFactory, BranchLinkConstant.PayloadKey.REFERRAL);
                if (openFileDescriptor != null) {
                    FileDescriptor fileDescriptor = openFileDescriptor.getFileDescriptor();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
                    if (options.outWidth == -1 || options.outHeight == -1) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Bounds for bitmap could not be retrieved from the Uri: [");
                        sb4.append(this.MyBillsEntityDataFactory);
                        sb4.append("]");
                        return new BitmapWorkerResult(new IllegalArgumentException(sb4.toString()));
                    }
                    options.inSampleSize = BitmapLoadUtils.KClassImpl$Data$declaredNonStaticMembers$2(options, this.getErrorConfigVersion, this.getAuthRequestContext);
                    options.inJustDecodeBounds = false;
                    Bitmap bitmap = null;
                    while (!z) {
                        try {
                            bitmap = BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
                            z = true;
                        } catch (OutOfMemoryError e3) {
                            InstrumentInjector.log_e("BitmapWorkerTask", "doInBackground: BitmapFactory.decodeFileDescriptor: ", e3);
                            options.inSampleSize *= 2;
                        }
                    }
                    if (bitmap == null) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("Bitmap could not be decoded from the Uri: [");
                        sb5.append(this.MyBillsEntityDataFactory);
                        sb5.append("]");
                        return new BitmapWorkerResult(new IllegalArgumentException(sb5.toString()));
                    }
                    if (Build.VERSION.SDK_INT >= 16) {
                        BitmapLoadUtils.getAuthRequestContext(openFileDescriptor);
                    }
                    int KClassImpl$Data$declaredNonStaticMembers$2 = BitmapLoadUtils.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult, this.MyBillsEntityDataFactory);
                    int authRequestContext = BitmapLoadUtils.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2);
                    int PlaceComponentResult = BitmapLoadUtils.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2);
                    ExifInfo exifInfo = new ExifInfo(KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext, PlaceComponentResult);
                    Matrix matrix = new Matrix();
                    if (authRequestContext != 0) {
                        matrix.preRotate(authRequestContext);
                    }
                    if (PlaceComponentResult != 1) {
                        matrix.postScale(PlaceComponentResult, 1.0f);
                    }
                    if (!matrix.isIdentity()) {
                        return new BitmapWorkerResult(BitmapLoadUtils.getAuthRequestContext(bitmap, matrix), exifInfo);
                    }
                    return new BitmapWorkerResult(bitmap, exifInfo);
                }
                StringBuilder sb6 = new StringBuilder();
                sb6.append("ParcelFileDescriptor was null for given Uri: [");
                sb6.append(this.MyBillsEntityDataFactory);
                sb6.append("]");
                return new BitmapWorkerResult(new NullPointerException(sb6.toString()));
            } catch (FileNotFoundException e4) {
                return new BitmapWorkerResult(e4);
            }
        } catch (IOException | NullPointerException e5) {
            return new BitmapWorkerResult(e5);
        }
    }
}
