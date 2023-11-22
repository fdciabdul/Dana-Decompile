package fsimpl;

import android.graphics.Bitmap;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public interface aP {
    int a(int i, ByteBuffer byteBuffer);

    int a(Bitmap bitmap);

    int a(Path path);

    int a(Shader shader);

    int a(Drawable drawable);

    int a(String str);

    int b(Bitmap bitmap);

    int b(Drawable drawable);

    int c(Bitmap bitmap);

    int d(Bitmap bitmap);
}
