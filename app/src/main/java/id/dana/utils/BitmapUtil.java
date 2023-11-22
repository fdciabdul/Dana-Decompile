package id.dana.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.zelory.compressor.Compressor;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public final class BitmapUtil {
    private static final String MyBillsEntityDataFactory = "BitmapUtil";

    private BitmapUtil() {
    }

    public static String BuiltInFictitiousFunctionClassFactory(Uri uri, ContentResolver contentResolver, Matrix matrix) {
        InputStream inputStream;
        if (uri == null) {
            return "";
        }
        try {
            inputStream = contentResolver.openInputStream(uri);
        } catch (IOException e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory, e.getMessage());
            inputStream = null;
        }
        if (inputStream == null) {
            return "";
        }
        Bitmap KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(BitmapFactory.decodeStream(inputStream), 320000L);
        return MyBillsEntityDataFactory(Bitmap.createBitmap(KClassImpl$Data$declaredNonStaticMembers$2, 0, 0, KClassImpl$Data$declaredNonStaticMembers$2.getWidth(), KClassImpl$Data$declaredNonStaticMembers$2.getHeight(), matrix, true), 100);
    }

    public static String MyBillsEntityDataFactory(Bitmap bitmap, int i) {
        if (bitmap == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory, e.getMessage());
        }
        return Base64.encodeToString(byteArray, 2);
    }

    @Nullable
    public static Bitmap BuiltInFictitiousFunctionClassFactory(String str) {
        if (!TextUtils.isEmpty(str) && FileFactory.MyBillsEntityDataFactory(str).isFile()) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        }
        return null;
    }

    public static Bitmap KClassImpl$Data$declaredNonStaticMembers$2(Bitmap bitmap, long j) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int width2 = bitmap.getWidth() * bitmap.getHeight();
        if (j > 0) {
            long j2 = j / 2;
            if (width2 <= j2) {
                return bitmap;
            }
            double d = j2;
            double d2 = width2;
            Double.isNaN(d);
            Double.isNaN(d2);
            double sqrt = Math.sqrt(d / d2);
            double d3 = width;
            Double.isNaN(d3);
            width = (int) Math.floor(d3 * sqrt);
            double d4 = height;
            Double.isNaN(d4);
            height = (int) Math.floor(d4 * sqrt);
        }
        return Bitmap.createScaledBitmap(bitmap, width, height, true);
    }

    public static Bitmap PlaceComponentResult(Uri uri, Context context) {
        try {
            return MediaStore.Images.Media.getBitmap(context.getContentResolver(), uri);
        } catch (IOException unused) {
            return null;
        }
    }

    public static int PlaceComponentResult(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray().length;
    }

    public static Bitmap getAuthRequestContext(String str) {
        byte[] decode = Base64.decode(str, 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public static Bitmap KClassImpl$Data$declaredNonStaticMembers$2(Context context, Uri uri, int i, int i2) throws IOException {
        File BuiltInFictitiousFunctionClassFactory = FileUtil.BuiltInFictitiousFunctionClassFactory(context, uri);
        Compressor compressor = new Compressor(context);
        compressor.BuiltInFictitiousFunctionClassFactory = i;
        compressor.getAuthRequestContext = i2;
        Bitmap BuiltInFictitiousFunctionClassFactory2 = id.zelory.compressor.ImageUtil.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, compressor.BuiltInFictitiousFunctionClassFactory, compressor.getAuthRequestContext);
        float width = BuiltInFictitiousFunctionClassFactory2.getWidth() / BuiltInFictitiousFunctionClassFactory2.getHeight();
        if (width != 1.0f) {
            return width > 1.0f ? Bitmap.createScaledBitmap(BuiltInFictitiousFunctionClassFactory2, i, (int) (i / width), true) : BuiltInFictitiousFunctionClassFactory2;
        }
        int min = Math.min(i, i2);
        return Bitmap.createScaledBitmap(BuiltInFictitiousFunctionClassFactory2, min, min, true);
    }

    public static void MyBillsEntityDataFactory(Bitmap bitmap, File file) {
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, new FileOutputStream(file));
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory, e.getMessage());
        }
    }

    /* loaded from: classes9.dex */
    static class FileFactory {
        private FileFactory() {
        }

        public static File MyBillsEntityDataFactory(String str) {
            return new File(str);
        }
    }

    public static String PlaceComponentResult(String str) {
        Bitmap bitmap = null;
        if (!TextUtils.isEmpty(str) && FileFactory.MyBillsEntityDataFactory(str).isFile()) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            options.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeFile(str, options);
        }
        return MyBillsEntityDataFactory(bitmap, 100);
    }

    public static Uri KClassImpl$Data$declaredNonStaticMembers$2(Context context, Bitmap bitmap) {
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, new ByteArrayOutputStream());
        ContentResolver contentResolver = context.getContentResolver();
        StringBuilder sb = new StringBuilder();
        sb.append("IMG_");
        sb.append(Calendar.getInstance().getTime());
        return Uri.parse(MediaStore.Images.Media.insertImage(contentResolver, bitmap, sb.toString(), (String) null));
    }
}
