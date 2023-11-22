package id.dana.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.util.Preconditions;
import androidx.documentfile.provider.DocumentFile;
import com.anggrayudi.storage.file.DocumentFileCompat;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.sharepay.SharePayManager;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.permission.PermissionHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes2.dex */
public class FileUtil {
    private FileUtil() {
    }

    public static File PlaceComponentResult(Context context, String str, Bitmap bitmap) {
        return getAuthRequestContext(BuiltInFictitiousFunctionClassFactory(context, str), bitmap);
    }

    public static File getAuthRequestContext(String str, Bitmap bitmap) {
        File file = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            File file2 = new File(str);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                return file2;
            } catch (IOException unused) {
                file = file2;
                return file;
            }
        } catch (IOException unused2) {
        }
    }

    private static String BuiltInFictitiousFunctionClassFactory(Context context, String str) {
        File MyBillsEntityDataFactory = MyBillsEntityDataFactory(context);
        if (MyBillsEntityDataFactory.exists() || MyBillsEntityDataFactory.mkdirs()) {
            StringBuilder sb = new StringBuilder();
            sb.append(MyBillsEntityDataFactory.getPath());
            sb.append(File.separator);
            sb.append(str);
            sb.append(".png");
            return sb.toString();
        }
        return null;
    }

    public static File MyBillsEntityDataFactory(Context context) {
        if (PermissionHelper.MyBillsEntityDataFactory(context, "android.permission.WRITE_EXTERNAL_STORAGE") && getAuthRequestContext()) {
            if (Build.VERSION.SDK_INT >= 29) {
                return new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), TrackerKey.DanaBalanceRecipientTypeProperty.DANA);
            }
            return new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), TrackerKey.DanaBalanceRecipientTypeProperty.DANA);
        }
        return new File(context.getFilesDir(), TrackerKey.DanaBalanceRecipientTypeProperty.DANA);
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Bitmap bitmap, Context context) {
        File authRequestContext = getAuthRequestContext(BuiltInFictitiousFunctionClassFactory(context, "danasharepay"), bitmap);
        if (authRequestContext != null) {
            MediaScannerConnection.scanFile(context, new String[]{authRequestContext.getAbsolutePath()}, null, new MediaScannerConnection.OnScanCompletedListener() { // from class: id.dana.utils.FileUtil$$ExternalSyntheticLambda0
                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public final void onScanCompleted(String str, Uri uri) {
                    FileUtil.KClassImpl$Data$declaredNonStaticMembers$2(str, uri);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(String str, Uri uri) {
        if (uri == null && str != null) {
            uri = Uri.fromFile(new File(str));
        }
        SharePayManager.getAuthRequestContext().KClassImpl$Data$declaredNonStaticMembers$2 = uri;
    }

    private static boolean getAuthRequestContext() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static File PlaceComponentResult(Context context) {
        if (getAuthRequestContext()) {
            File[] authRequestContext = ContextCompat.getAuthRequestContext(context, Environment.DIRECTORY_PICTURES);
            if (authRequestContext.length > 0) {
                return authRequestContext[0];
            }
            return context.getFilesDir();
        }
        return context.getFilesDir();
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0080, code lost:
    
        if (r5 == null) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.File BuiltInFictitiousFunctionClassFactory(android.content.Context r4, android.net.Uri r5) {
        /*
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.lang.String r1 = "yyyyMMdd_HHmmss_SSSS"
            r0.<init>(r1)
            java.util.Date r1 = new java.util.Date
            r1.<init>()
            java.lang.String r0 = r0.format(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "JPEG_"
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = "_"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r0 = BuiltInFictitiousFunctionClassFactory(r4, r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 0
            if (r1 == 0) goto L32
            return r2
        L32:
            java.io.File r1 = new java.io.File
            r1.<init>(r0)
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L7f
            java.io.InputStream r4 = r4.openInputStream(r5)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L7f
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L6a
            r5.<init>(r1)     // Catch: java.lang.Throwable -> L6a
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L67
            if (r4 == 0) goto L56
        L4a:
            int r2 = r4.read(r0)     // Catch: java.lang.Throwable -> L67
            r3 = -1
            if (r2 == r3) goto L56
            r3 = 0
            r5.write(r0, r3, r2)     // Catch: java.lang.Throwable -> L67
            goto L4a
        L56:
            r5.close()     // Catch: java.lang.Throwable -> L67
            if (r4 == 0) goto L63
            r4.close()     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L61
            goto L63
        L5f:
            r4 = move-exception
            goto L79
        L61:
            goto L80
        L63:
            r5.close()     // Catch: java.io.IOException -> L83
            goto L83
        L67:
            r0 = move-exception
            r2 = r5
            goto L6c
        L6a:
            r5 = move-exception
            r0 = r5
        L6c:
            if (r4 == 0) goto L76
            r4.close()     // Catch: java.lang.Throwable -> L72
            goto L76
        L72:
            r4 = move-exception
            r0.addSuppressed(r4)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L7f
        L76:
            throw r0     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L7f
        L77:
            r4 = move-exception
            r5 = r2
        L79:
            if (r5 == 0) goto L7e
            r5.close()     // Catch: java.io.IOException -> L7e
        L7e:
            throw r4
        L7f:
            r5 = r2
        L80:
            if (r5 == 0) goto L83
            goto L63
        L83:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.utils.FileUtil.BuiltInFictitiousFunctionClassFactory(android.content.Context, android.net.Uri):java.io.File");
    }

    public static Bitmap getAuthRequestContext(View view, int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Drawable background = view.getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(-1);
        }
        view.draw(canvas);
        return createBitmap;
    }

    public static void getAuthRequestContext(Context context, String str) {
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(context, "context is required");
        Preconditions.MyBillsEntityDataFactory(TextUtils.isEmpty(str), "file path is required");
        try {
            if (OSUtil.NetworkUserEntityData$$ExternalSyntheticLambda1()) {
                Files.delete(Paths.get(str, new String[0]));
                return;
            }
            File file = new File(str);
            if (!file.exists() || file.delete()) {
                return;
            }
            context.deleteFile(file.getName());
        } catch (IOException | RuntimeException e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory("FileUtil", e.getMessage());
        }
    }

    public static void MyBillsEntityDataFactory(Context context, Uri uri) {
        if (uri != null) {
            DocumentFile authRequestContext = DocumentFileCompat.getAuthRequestContext(context, uri);
            if (authRequestContext != null) {
                authRequestContext.MyBillsEntityDataFactory();
            }
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", uri));
        }
    }

    public static void getAuthRequestContext(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (!file2.delete()) {
                    DanaLog.BuiltInFictitiousFunctionClassFactory("FileUtil", "Failed Delete File");
                }
            }
        }
        if (file.delete()) {
            return;
        }
        DanaLog.BuiltInFictitiousFunctionClassFactory("FileUtil", "Failed Delete Folder");
    }

    public static File MyBillsEntityDataFactory(Context context, String str, String str2) {
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(format);
        sb.append("_");
        try {
            return File.createTempFile(sb.toString(), str2, PlaceComponentResult(context));
        } catch (IOException e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory("FileUtil", e.getMessage());
            return null;
        }
    }

    public static Uri BuiltInFictitiousFunctionClassFactory(Context context, File file) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getPackageName());
            sb.append(".provider");
            return FileProvider.getUriForFile(context, sb.toString(), file);
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory("FileUtil", e.getMessage());
            return null;
        }
    }

    public static File MyBillsEntityDataFactory(Context context, String str) {
        File BuiltInFictitiousFunctionClassFactory = str == null ? null : BuiltInFictitiousFunctionClassFactory(context, Uri.parse(str));
        if (BuiltInFictitiousFunctionClassFactory != null) {
            try {
                if (BuiltInFictitiousFunctionClassFactory.isFile()) {
                    return ImageResize.BuiltInFictitiousFunctionClassFactory(context, BuiltInFictitiousFunctionClassFactory);
                }
            } catch (IOException unused) {
            }
        }
        return null;
    }
}
