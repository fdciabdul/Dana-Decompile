package id.dana.util.media;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.alipay.mobile.verifyidentity.business.securitycommon.widget.ConvertUtils;
import id.dana.lib.logger.DANALog;
import id.dana.util.a.a;
import id.dana.util.device.OSUtil;
import io.reactivex.functions.Function;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class FileUtil {
    private static final String KClassImpl$Data$declaredNonStaticMembers$2 = "FileUtil";

    private FileUtil() {
    }

    public static long BuiltInFictitiousFunctionClassFactory() {
        return PlaceComponentResult(Environment.getExternalStorageDirectory().getPath());
    }

    public static long getAuthRequestContext() {
        return PlaceComponentResult(Environment.getDataDirectory().getPath());
    }

    private static long PlaceComponentResult(String str) {
        long blockSize;
        long availableBlocks;
        try {
            StatFs PlaceComponentResult = a.PlaceComponentResult(str);
            if (OSUtil.KClassImpl$Data$declaredNonStaticMembers$2()) {
                blockSize = PlaceComponentResult.getBlockSizeLong();
                availableBlocks = PlaceComponentResult.getAvailableBlocksLong();
            } else {
                blockSize = PlaceComponentResult.getBlockSize();
                availableBlocks = PlaceComponentResult.getAvailableBlocks();
            }
            return (blockSize * availableBlocks) / ConvertUtils.MB;
        } catch (IllegalArgumentException unused) {
            return 0L;
        }
    }

    public static boolean getAuthRequestContext(String str) {
        return BuiltInFictitiousFunctionClassFactory(str);
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(String str) {
        File BuiltInFictitiousFunctionClassFactory = a.BuiltInFictitiousFunctionClassFactory(str);
        if (BuiltInFictitiousFunctionClassFactory.isDirectory()) {
            return false;
        }
        BuiltInFictitiousFunctionClassFactory.mkdirs();
        return BuiltInFictitiousFunctionClassFactory.exists();
    }

    public static boolean MyBillsEntityDataFactory(String str) {
        return str != null && a.BuiltInFictitiousFunctionClassFactory(str).exists();
    }

    public static Uri PlaceComponentResult(Context context, File file) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append(".provider");
        return FileProvider.getUriForFile(context, sb.toString(), file);
    }

    public static File getAuthRequestContext(Context context) {
        if (PlaceComponentResult()) {
            File[] authRequestContext = ContextCompat.getAuthRequestContext(context, Environment.DIRECTORY_PICTURES);
            if (authRequestContext.length > 0) {
                return authRequestContext[0];
            }
            return context.getFilesDir();
        }
        return context.getFilesDir();
    }

    private static boolean PlaceComponentResult() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    /* renamed from: id.dana.util.media.FileUtil$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static final class AnonymousClass1 implements Callable<File> {
        final /* synthetic */ Context PlaceComponentResult;

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
        public File call() throws Exception {
            try {
                return File.createTempFile(FileUtil.KClassImpl$Data$declaredNonStaticMembers$2(), ".jpg", FileUtil.getAuthRequestContext(this.PlaceComponentResult));
            } catch (Exception e) {
                DANALog.PlaceComponentResult(FileUtil.KClassImpl$Data$declaredNonStaticMembers$2, "createFileFromUri", e);
                return null;
            }
        }
    }

    /* renamed from: id.dana.util.media.FileUtil$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    static final class AnonymousClass2 implements Function<File, File> {
        final /* synthetic */ Uri KClassImpl$Data$declaredNonStaticMembers$2;
        final /* synthetic */ Context MyBillsEntityDataFactory;

        /* JADX INFO: Access modifiers changed from: private */
        @Override // io.reactivex.functions.Function
        /* renamed from: PlaceComponentResult  reason: merged with bridge method [inline-methods] */
        public File apply(File file) throws Exception {
            FileOutputStream fileOutputStream;
            InputStream inputStream;
            if (file != null) {
                InputStream inputStream2 = null;
                try {
                    inputStream = this.MyBillsEntityDataFactory.getContentResolver().openInputStream(this.KClassImpl$Data$declaredNonStaticMembers$2);
                    try {
                        fileOutputStream = new FileOutputStream(file);
                    } catch (IOException e) {
                        fileOutputStream = null;
                        inputStream2 = inputStream;
                        e = e;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = null;
                    }
                } catch (IOException e2) {
                    e = e2;
                    fileOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                }
                try {
                    FileUtil.KClassImpl$Data$declaredNonStaticMembers$2(inputStream, fileOutputStream);
                } catch (IOException e3) {
                    e = e3;
                    inputStream2 = inputStream;
                    try {
                        DANALog.PlaceComponentResult(FileUtil.KClassImpl$Data$declaredNonStaticMembers$2, "writeTempFile", e);
                        inputStream = inputStream2;
                        FileUtil.getAuthRequestContext(inputStream);
                        FileUtil.getAuthRequestContext(fileOutputStream);
                        return file;
                    } catch (Throwable th3) {
                        th = th3;
                        FileUtil.getAuthRequestContext(inputStream2);
                        FileUtil.getAuthRequestContext(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    inputStream2 = inputStream;
                    FileUtil.getAuthRequestContext(inputStream2);
                    FileUtil.getAuthRequestContext(fileOutputStream);
                    throw th;
                }
                FileUtil.getAuthRequestContext(inputStream);
                FileUtil.getAuthRequestContext(fileOutputStream);
            }
            return file;
        }
    }

    static /* synthetic */ String KClassImpl$Data$declaredNonStaticMembers$2() {
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        StringBuilder sb = new StringBuilder();
        sb.append("JPEG_");
        sb.append(format);
        sb.append("_");
        return sb.toString();
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(InputStream inputStream, FileOutputStream fileOutputStream) throws IOException {
        byte[] bArr = new byte[1024];
        if (inputStream == null) {
            return;
        }
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            }
            fileOutputStream.write(bArr, 0, read);
        }
    }

    static /* synthetic */ void getAuthRequestContext(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                DANALog.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, "writeTempFile", e);
            }
        }
    }

    public static File BuiltInFictitiousFunctionClassFactory(Context context, String str) {
        return a.MyBillsEntityDataFactory(a.MyBillsEntityDataFactory(context.getFilesDir(), "/DANA/"), str);
    }
}
