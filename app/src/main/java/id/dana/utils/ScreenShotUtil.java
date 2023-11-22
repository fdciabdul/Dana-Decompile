package id.dana.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.griver.image.framework.api.APImageFormat;
import id.dana.util.MediaStoreUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/utils/ScreenShotUtil;", "", "Landroid/view/View;", "p0", "Landroid/graphics/Bitmap;", "PlaceComponentResult", "(Landroid/view/View;)Landroid/graphics/Bitmap;", "", "p1", "p2", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/view/View;II)Landroid/graphics/Bitmap;", "Landroid/content/Context;", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;Landroid/graphics/Bitmap;Ljava/lang/String;)Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ScreenShotUtil {
    public static final ScreenShotUtil INSTANCE = new ScreenShotUtil();

    private ScreenShotUtil() {
    }

    public static Bitmap PlaceComponentResult(View p0) {
        Bitmap createBitmap = Bitmap.createBitmap(p0.getWidth(), p0.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "");
        p0.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public static Bitmap KClassImpl$Data$declaredNonStaticMembers$2(View p0, int p1, int p2) {
        Bitmap createBitmap = Bitmap.createBitmap(p1, p2, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "");
        p0.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public static String BuiltInFictitiousFunctionClassFactory(Context p0, Bitmap p1, String p2) {
        if (TextUtils.equals(Environment.getExternalStorageState(), "mounted")) {
            if (p1 == null) {
                return "003";
            }
            try {
                return MediaStoreUtil.getAuthRequestContext(p0, p2, APImageFormat.SUFFIX_PNG, p1, DanaLogConstants.TAG.STATEMENT) ? "001" : "003";
            } catch (Exception e) {
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.STATEMENT_SCREENSHOT_EXCEPTION, e.getMessage());
                return "002";
            }
        }
        return "002";
    }
}
