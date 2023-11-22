package androidx.browser.browseractions;

import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.content.FileProvider;
import androidx.core.util.AtomicFile;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.util.concurrent.ListenableFuture;
import id.dana.data.constant.BranchLinkConstant;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Deprecated
/* loaded from: classes6.dex */
public final class BrowserServiceFileProvider extends FileProvider {
    static Object sFileCleanupLock = new Object();

    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public final boolean onCreate() {
        return super.onCreate();
    }

    /* loaded from: classes6.dex */
    static class FileCleanupTask extends AsyncTask<Void, Void, Void> {
        private final Context getAuthRequestContext;
        private static final long PlaceComponentResult = TimeUnit.DAYS.toMillis(7);
        private static final long KClassImpl$Data$declaredNonStaticMembers$2 = TimeUnit.DAYS.toMillis(7);
        private static final long BuiltInFictitiousFunctionClassFactory = TimeUnit.DAYS.toMillis(1);

        @Override // android.os.AsyncTask
        protected /* synthetic */ Void doInBackground(Void[] voidArr) {
            return KClassImpl$Data$declaredNonStaticMembers$2();
        }

        FileCleanupTask(Context context) {
            this.getAuthRequestContext = context.getApplicationContext();
        }

        private Void KClassImpl$Data$declaredNonStaticMembers$2() {
            long currentTimeMillis;
            Context context = this.getAuthRequestContext;
            StringBuilder sb = new StringBuilder();
            sb.append(this.getAuthRequestContext.getPackageName());
            sb.append(".image_provider");
            SharedPreferences sharedPreferences = context.getSharedPreferences(sb.toString(), 0);
            if (KClassImpl$Data$declaredNonStaticMembers$2(sharedPreferences)) {
                synchronized (BrowserServiceFileProvider.sFileCleanupLock) {
                    File file = new File(this.getAuthRequestContext.getFilesDir(), "image_provider");
                    if (file.exists()) {
                        File[] listFiles = file.listFiles();
                        long currentTimeMillis2 = System.currentTimeMillis();
                        long j = PlaceComponentResult;
                        boolean z = true;
                        for (File file2 : listFiles) {
                            if (PlaceComponentResult(file2) && file2.lastModified() < currentTimeMillis2 - j && !file2.delete()) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Fail to delete image: ");
                                sb2.append(file2.getAbsoluteFile());
                                InstrumentInjector.log_e("BrowserServiceFP", sb2.toString());
                                z = false;
                            }
                        }
                        if (z) {
                            currentTimeMillis = System.currentTimeMillis();
                        } else {
                            currentTimeMillis = (System.currentTimeMillis() - KClassImpl$Data$declaredNonStaticMembers$2) + BuiltInFictitiousFunctionClassFactory;
                        }
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putLong("last_cleanup_time", currentTimeMillis);
                        edit.apply();
                        return null;
                    }
                    return null;
                }
            }
            return null;
        }

        private static boolean PlaceComponentResult(File file) {
            return file.getName().endsWith("..png");
        }

        private static boolean KClassImpl$Data$declaredNonStaticMembers$2(SharedPreferences sharedPreferences) {
            return System.currentTimeMillis() > sharedPreferences.getLong("last_cleanup_time", System.currentTimeMillis()) + KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }

    /* loaded from: classes6.dex */
    static class FileSaveTask extends AsyncTask<String, Void, Void> {
        private final Context BuiltInFictitiousFunctionClassFactory;
        private final String KClassImpl$Data$declaredNonStaticMembers$2;
        private final Uri MyBillsEntityDataFactory;
        private final Bitmap PlaceComponentResult;
        private final ResolvableFuture<Uri> getAuthRequestContext;

        @Override // android.os.AsyncTask
        protected /* synthetic */ Void doInBackground(String[] strArr) {
            FileOutputStream fileOutputStream;
            File file = new File(this.BuiltInFictitiousFunctionClassFactory.getFilesDir(), "image_provider");
            synchronized (BrowserServiceFileProvider.sFileCleanupLock) {
                if (!file.exists() && !file.mkdir()) {
                    this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(new IOException("Could not create file directory."));
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
                    sb.append(".png");
                    File file2 = new File(file, sb.toString());
                    if (file2.exists()) {
                        this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory);
                    } else {
                        if (Build.VERSION.SDK_INT >= 22) {
                            AtomicFile atomicFile = new AtomicFile(file2);
                            try {
                                fileOutputStream = atomicFile.getAuthRequestContext();
                                try {
                                    this.PlaceComponentResult.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                                    fileOutputStream.close();
                                    if (!AtomicFile.KClassImpl$Data$declaredNonStaticMembers$2(fileOutputStream)) {
                                        InstrumentInjector.log_e("AtomicFile", "Failed to sync file output stream");
                                    }
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e) {
                                        InstrumentInjector.log_e("AtomicFile", "Failed to close file output stream", e);
                                    }
                                    AtomicFile.PlaceComponentResult(atomicFile.MyBillsEntityDataFactory, atomicFile.PlaceComponentResult);
                                    this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory);
                                } catch (IOException e2) {
                                    e = e2;
                                    if (fileOutputStream != null) {
                                        if (!AtomicFile.KClassImpl$Data$declaredNonStaticMembers$2(fileOutputStream)) {
                                            InstrumentInjector.log_e("AtomicFile", "Failed to sync file output stream");
                                        }
                                        try {
                                            fileOutputStream.close();
                                        } catch (IOException e3) {
                                            InstrumentInjector.log_e("AtomicFile", "Failed to close file output stream", e3);
                                        }
                                        if (!atomicFile.MyBillsEntityDataFactory.delete()) {
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append("Failed to delete new file ");
                                            sb2.append(atomicFile.MyBillsEntityDataFactory);
                                            InstrumentInjector.log_e("AtomicFile", sb2.toString());
                                        }
                                    }
                                    this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(e);
                                    file2.setLastModified(System.currentTimeMillis());
                                    return null;
                                }
                            } catch (IOException e4) {
                                e = e4;
                                fileOutputStream = null;
                            }
                        } else {
                            try {
                                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                                this.PlaceComponentResult.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream2);
                                fileOutputStream2.close();
                                this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory);
                            } catch (IOException e5) {
                                this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(e5);
                            }
                        }
                    }
                    file2.setLastModified(System.currentTimeMillis());
                }
            }
            return null;
        }

        @Override // android.os.AsyncTask
        protected /* synthetic */ void onPostExecute(Void r3) {
            new FileCleanupTask(this.BuiltInFictitiousFunctionClassFactory).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
        }

        FileSaveTask(Context context, String str, Bitmap bitmap, Uri uri, ResolvableFuture<Uri> resolvableFuture) {
            this.BuiltInFictitiousFunctionClassFactory = context.getApplicationContext();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
            this.PlaceComponentResult = bitmap;
            this.MyBillsEntityDataFactory = uri;
            this.getAuthRequestContext = resolvableFuture;
        }
    }

    public static ResolvableFuture<Uri> saveBitmap(Context context, Bitmap bitmap, String str, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_");
        sb.append(Integer.toString(i));
        String obj = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("image_provider_images/");
        sb2.append(obj);
        sb2.append(".png");
        String obj2 = sb2.toString();
        Uri.Builder scheme = new Uri.Builder().scheme("content");
        StringBuilder sb3 = new StringBuilder();
        sb3.append(context.getPackageName());
        sb3.append(".image_provider");
        Uri build = scheme.authority(sb3.toString()).path(obj2).build();
        ResolvableFuture<Uri> MyBillsEntityDataFactory = ResolvableFuture.MyBillsEntityDataFactory();
        new FileSaveTask(context, obj, bitmap, build, MyBillsEntityDataFactory).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        return MyBillsEntityDataFactory;
    }

    public static void grantReadPermission(Intent intent, List<Uri> list, Context context) {
        if (list == null || list.size() == 0) {
            return;
        }
        ContentResolver contentResolver = context.getContentResolver();
        intent.addFlags(1);
        ClipData newUri = ClipData.newUri(contentResolver, "image_provider_uris", list.get(0));
        for (int i = 1; i < list.size(); i++) {
            newUri.addItem(new ClipData.Item(list.get(i)));
        }
        intent.setClipData(newUri);
    }

    public static ListenableFuture<Bitmap> loadBitmap(final ContentResolver contentResolver, final Uri uri) {
        final ResolvableFuture MyBillsEntityDataFactory = ResolvableFuture.MyBillsEntityDataFactory();
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() { // from class: androidx.browser.browseractions.BrowserServiceFileProvider.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(uri, BranchLinkConstant.PayloadKey.REFERRAL);
                    if (openFileDescriptor == null) {
                        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(new FileNotFoundException());
                        return;
                    }
                    Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(openFileDescriptor.getFileDescriptor());
                    openFileDescriptor.close();
                    if (decodeFileDescriptor == null) {
                        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(new IOException("File could not be decoded."));
                    } else {
                        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(decodeFileDescriptor);
                    }
                } catch (IOException e) {
                    MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(e);
                }
            }
        });
        return MyBillsEntityDataFactory;
    }
}
