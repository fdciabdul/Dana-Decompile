package id.zelory.compressor;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes6.dex */
public class ImageUtil {
    private ImageUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File getAuthRequestContext(File file, int i, int i2, Bitmap.CompressFormat compressFormat, int i3, String str) throws IOException {
        FileOutputStream fileOutputStream;
        File parentFile = new File(str).getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            fileOutputStream = new FileOutputStream(str);
        } catch (Throwable th) {
            th = th;
            fileOutputStream = null;
        }
        try {
            BuiltInFictitiousFunctionClassFactory(file, i, i2).compress(compressFormat, i3, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return new File(str);
        } catch (Throwable th2) {
            th = th2;
            if (fileOutputStream != null) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
            throw th;
        }
    }

    public static Bitmap BuiltInFictitiousFunctionClassFactory(File file, int i, int i2) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        options.inSampleSize = KClassImpl$Data$declaredNonStaticMembers$2(options, i, i2);
        options.inJustDecodeBounds = false;
        Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        int attributeInt = new ExifInterface(file.getAbsolutePath()).getAttributeInt("Orientation", 0);
        Matrix matrix = new Matrix();
        if (attributeInt == 6) {
            matrix.postRotate(90.0f);
        } else if (attributeInt == 3) {
            matrix.postRotate(180.0f);
        } else if (attributeInt == 8) {
            matrix.postRotate(270.0f);
        }
        return Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true);
    }

    private static int KClassImpl$Data$declaredNonStaticMembers$2(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            int i6 = i3 / 2;
            int i7 = i4 / 2;
            while (i6 / i5 >= i2 && i7 / i5 >= i) {
                i5 *= 2;
            }
        }
        return i5;
    }
}
