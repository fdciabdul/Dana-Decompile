package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import androidx.core.provider.FontsContractCompat;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.data.constant.BranchLinkConstant;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class TypefaceCompatUtil {
    private TypefaceCompatUtil() {
    }

    public static File BuiltInFictitiousFunctionClassFactory(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(".font");
        sb.append(Process.myPid());
        sb.append("-");
        sb.append(Process.myTid());
        sb.append("-");
        String obj = sb.toString();
        for (int i = 0; i < 100; i++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(obj);
            sb2.append(i);
            File file = new File(cacheDir, sb2.toString());
            if (file.createNewFile()) {
                return file;
            }
        }
        return null;
    }

    private static ByteBuffer MyBillsEntityDataFactory(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                FileChannel channel = fileInputStream.getChannel();
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                fileInputStream.close();
                return map;
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public static ByteBuffer PlaceComponentResult(Context context, CancellationSignal cancellationSignal, Uri uri) {
        try {
            ParcelFileDescriptor PlaceComponentResult = Api19Impl.PlaceComponentResult(context.getContentResolver(), uri, BranchLinkConstant.PayloadKey.REFERRAL, cancellationSignal);
            if (PlaceComponentResult == null) {
                if (PlaceComponentResult != null) {
                    PlaceComponentResult.close();
                }
                return null;
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(PlaceComponentResult.getFileDescriptor());
                try {
                    FileChannel channel = fileInputStream.getChannel();
                    MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                    fileInputStream.close();
                    if (PlaceComponentResult != null) {
                        PlaceComponentResult.close();
                    }
                    return map;
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public static ByteBuffer KClassImpl$Data$declaredNonStaticMembers$2(Context context, Resources resources, int i) {
        File BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(context);
        if (BuiltInFictitiousFunctionClassFactory == null) {
            return null;
        }
        try {
            if (BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, resources, i)) {
                return MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
            }
            return null;
        } finally {
            BuiltInFictitiousFunctionClassFactory.delete();
        }
    }

    public static boolean PlaceComponentResult(File file, InputStream inputStream) {
        FileOutputStream fileOutputStream;
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file, false);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read != -1) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            MyBillsEntityDataFactory(fileOutputStream);
                            StrictMode.setThreadPolicy(allowThreadDiskWrites);
                            return true;
                        }
                    }
                } catch (IOException e) {
                    e = e;
                    fileOutputStream2 = fileOutputStream;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Error copying resource contents to temp file: ");
                    sb.append(e.getMessage());
                    InstrumentInjector.log_e("TypefaceCompatUtil", sb.toString());
                    MyBillsEntityDataFactory(fileOutputStream2);
                    StrictMode.setThreadPolicy(allowThreadDiskWrites);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    MyBillsEntityDataFactory(fileOutputStream);
                    StrictMode.setThreadPolicy(allowThreadDiskWrites);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    public static boolean BuiltInFictitiousFunctionClassFactory(File file, Resources resources, int i) {
        InputStream inputStream;
        try {
            inputStream = resources.openRawResource(i);
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            boolean PlaceComponentResult = PlaceComponentResult(file, inputStream);
            MyBillsEntityDataFactory(inputStream);
            return PlaceComponentResult;
        } catch (Throwable th2) {
            th = th2;
            MyBillsEntityDataFactory(inputStream);
            throw th;
        }
    }

    public static void MyBillsEntityDataFactory(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static Map<Uri, ByteBuffer> getAuthRequestContext(Context context, FontsContractCompat.FontInfo[] fontInfoArr, CancellationSignal cancellationSignal) {
        HashMap hashMap = new HashMap();
        for (FontsContractCompat.FontInfo fontInfo : fontInfoArr) {
            if (fontInfo.KClassImpl$Data$declaredNonStaticMembers$2() == 0) {
                Uri PlaceComponentResult = fontInfo.PlaceComponentResult();
                if (!hashMap.containsKey(PlaceComponentResult)) {
                    hashMap.put(PlaceComponentResult, PlaceComponentResult(context, cancellationSignal, PlaceComponentResult));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api19Impl {
        private Api19Impl() {
        }

        static ParcelFileDescriptor PlaceComponentResult(ContentResolver contentResolver, Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
            return contentResolver.openFileDescriptor(uri, str, cancellationSignal);
        }
    }
}
