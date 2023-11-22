package androidx.transition;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import java.lang.reflect.Field;

/* loaded from: classes6.dex */
class ImageViewUtils {
    private static boolean KClassImpl$Data$declaredNonStaticMembers$2 = true;
    private static boolean MyBillsEntityDataFactory = false;
    private static Field PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void MyBillsEntityDataFactory(ImageView imageView, Matrix matrix) {
        if (Build.VERSION.SDK_INT >= 29) {
            imageView.animateTransform(matrix);
        } else if (matrix == null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable != null) {
                int width = imageView.getWidth();
                int paddingLeft = imageView.getPaddingLeft();
                drawable.setBounds(0, 0, (width - paddingLeft) - imageView.getPaddingRight(), (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom());
                imageView.invalidate();
            }
        } else if (Build.VERSION.SDK_INT < 21) {
            Drawable drawable2 = imageView.getDrawable();
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight());
                if (!MyBillsEntityDataFactory) {
                    try {
                        Field declaredField = ImageView.class.getDeclaredField("mDrawMatrix");
                        PlaceComponentResult = declaredField;
                        declaredField.setAccessible(true);
                    } catch (NoSuchFieldException unused) {
                    }
                    MyBillsEntityDataFactory = true;
                }
                Field field = PlaceComponentResult;
                Matrix matrix2 = null;
                if (field != null) {
                    try {
                        Matrix matrix3 = (Matrix) field.get(imageView);
                        if (matrix3 == null) {
                            try {
                                matrix2 = new Matrix();
                                PlaceComponentResult.set(imageView, matrix2);
                            } catch (IllegalAccessException unused2) {
                            }
                        }
                        matrix2 = matrix3;
                    } catch (IllegalAccessException unused3) {
                    }
                }
                if (matrix2 != null) {
                    matrix2.set(matrix);
                }
                imageView.invalidate();
            }
        } else if (KClassImpl$Data$declaredNonStaticMembers$2) {
            try {
                imageView.animateTransform(matrix);
            } catch (NoSuchMethodError unused4) {
                KClassImpl$Data$declaredNonStaticMembers$2 = false;
            }
        }
    }

    private ImageViewUtils() {
    }
}
