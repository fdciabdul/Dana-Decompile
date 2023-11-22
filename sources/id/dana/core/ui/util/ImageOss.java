package id.dana.core.ui.util;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.alibaba.griver.image.framework.api.APImageFormat;
import id.dana.core.ui.R;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/core/ui/util/ImageOss;", "", "", "p0", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)Z", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "", "getAuthRequestContext", "[Ljava/lang/String;", "<init>", "()V", "EventListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ImageOss {
    public static final ImageOss INSTANCE = new ImageOss();
    private static final String[] getAuthRequestContext = {APImageFormat.SUFFIX_JPG, APImageFormat.SUFFIX_PNG, "bmp", APImageFormat.SUFFIX_GIF, APImageFormat.SUFFIX_WEBP, "tiff"};

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\bf\u0018\u00002\u00020\u0001ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/core/ui/util/ImageOss$EventListener;", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public interface EventListener {
    }

    private ImageOss() {
    }

    private static boolean PlaceComponentResult(String p0) {
        if (p0 != null && MyBillsEntityDataFactory(p0)) {
            String substring = p0.substring(StringsKt.lastIndexOf$default((CharSequence) p0, '.', 0, false, 6, (Object) null) + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "");
            if (!TextUtils.isEmpty(substring) && KClassImpl$Data$declaredNonStaticMembers$2(substring)) {
                return true;
            }
        }
        return false;
    }

    private static boolean MyBillsEntityDataFactory(String p0) {
        String str = p0;
        return (!StringsKt.contains$default((CharSequence) str, (CharSequence) ".", false, 2, (Object) null) || StringsKt.indexOf$default((CharSequence) str, '.', 0, false, 6, (Object) null) == 0 || StringsKt.lastIndexOf$default((CharSequence) str, '.', 0, false, 6, (Object) null) == p0.length() - 1) ? false : true;
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        String[] strArr = getAuthRequestContext;
        return CollectionsKt.listOf(Arrays.copyOf(strArr, strArr.length)).contains(p0);
    }

    public static final /* synthetic */ String BuiltInFictitiousFunctionClassFactory(ImageOss imageOss, String str, ImageView imageView) {
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        int width = imageView.getWidth();
        Intrinsics.checkNotNullParameter(context, "");
        if (width <= 0 || width > 4096 || !PlaceComponentResult(str)) {
            return str;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = context.getString(R.string.image_oss_width_param);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String format = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(width)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String string2 = context.getString(R.string.image_oss_resize_url_format);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        String format2 = String.format(string2, Arrays.copyOf(new Object[]{str, format}, 2));
        Intrinsics.checkNotNullExpressionValue(format2, "");
        return format2;
    }
}
