package id.dana.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.widget.ImageView;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.alipay.mobile.zebra.data.ZebraData;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0007J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0007J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0007J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J6\u0010\u001b\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\nH\u0007J(\u0010!\u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\nH\u0002J\b\u0010\"\u001a\u00020\u0004H\u0007J \u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0007J\u0018\u0010%\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lid/dana/utils/ImageUtil;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "addSuffixToImageUrl", "url", "suffix", "computeSampleSize", "", ZebraData.ATTR_WIDTH, ZebraData.ATTR_HEIGHT, "maxWidth", "maxHeight", "convertBackgroundImageUrlToSlimUrl", "backgroundUrl", "createBitmapFromView", "Landroid/graphics/Bitmap;", "view", "Landroid/view/View;", "createFile", "Ljava/io/File;", "imageOrigin", "privateFilePath", "maxBytes", "", "decodeBitmapFromByteArray", "source", "", SecurityConstants.KEY_OPTIONS, "Landroid/graphics/BitmapFactory$Options;", "orientation", "flipWidthAndHeight", "localImageNamingByDate", "scaleBitmap", "bitmap", "scaledDownImageResult", "setGrayScale", "", "imageView", "Landroid/widget/ImageView;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ImageUtil {
    public static final ImageUtil PlaceComponentResult = new ImageUtil();
    private static final String MyBillsEntityDataFactory = ImageUtil.class.getName();

    private ImageUtil() {
    }

    public static /* synthetic */ Bitmap getAuthRequestContext(byte[] bArr, BitmapFactory.Options options, int i) {
        return KClassImpl$Data$declaredNonStaticMembers$2(bArr, options, i);
    }

    @JvmStatic
    public static Bitmap KClassImpl$Data$declaredNonStaticMembers$2(byte[] bArr, BitmapFactory.Options options, int i) {
        Intrinsics.checkNotNullParameter(bArr, "");
        Intrinsics.checkNotNullParameter(options, "");
        try {
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            if (i == 0 || decodeByteArray == null) {
                return decodeByteArray;
            }
            Matrix matrix = new Matrix();
            matrix.setRotate(i);
            Bitmap createBitmap = Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, true);
            decodeByteArray.recycle();
            return createBitmap;
        } catch (OutOfMemoryError e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory, e.toString());
            return null;
        }
    }

    public static File PlaceComponentResult(Bitmap bitmap, String str, long j) {
        Intrinsics.checkNotNullParameter(bitmap, "");
        Intrinsics.checkNotNullParameter(str, "");
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("IMG_");
        sb2.append(DateTimeUtil.PlaceComponentResult("yyyy_MM_dd_HH_mm_ss_SSS"));
        sb2.append('_');
        sb.append(sb2.toString());
        sb.append('.');
        String lowerCase = Bitmap.CompressFormat.PNG.name().toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        sb.append(lowerCase);
        String obj = sb.toString();
        Bitmap KClassImpl$Data$declaredNonStaticMembers$2 = BitmapUtil.KClassImpl$Data$declaredNonStaticMembers$2(bitmap, j);
        if (!Intrinsics.areEqual(KClassImpl$Data$declaredNonStaticMembers$2, bitmap)) {
            bitmap.recycle();
        }
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        File authRequestContext = FileUtil.getAuthRequestContext(obj, KClassImpl$Data$declaredNonStaticMembers$2);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    public static void BuiltInFictitiousFunctionClassFactory(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "");
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        imageView.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        imageView.setImageAlpha(200);
    }

    @JvmStatic
    public static final String BuiltInFictitiousFunctionClassFactory(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return StringsKt.replace$default(str, ".png", "_slim.png", false, 4, (Object) null);
    }

    @JvmStatic
    public static final String MyBillsEntityDataFactory(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(".png");
        return StringsKt.replace$default(str, ".png", sb.toString(), false, 4, (Object) null);
    }
}
