package id.dana.core.ui.glide;

import android.content.Context;
import android.widget.ImageView;
import id.dana.core.ui.svg.SvgLoader;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/core/ui/glide/ImageAttacher;", "", "Landroid/content/Context;", "p0", "", "p1", "", "p2", "Landroid/widget/ImageView;", "p3", "", "PlaceComponentResult", "(Landroid/content/Context;Ljava/lang/String;ILandroid/widget/ImageView;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ImageAttacher {
    public static final ImageAttacher INSTANCE = new ImageAttacher();

    private ImageAttacher() {
    }

    @JvmStatic
    public static final void PlaceComponentResult(Context p0, String p1, int p2, ImageView p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p3, "");
        if (SvgLoader.getAuthRequestContext(p1)) {
            SvgLoader.Builder KClassImpl$Data$declaredNonStaticMembers$2 = SvgLoader.KClassImpl$Data$declaredNonStaticMembers$2(p0);
            KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = p1;
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = p2;
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = p3;
            new SvgLoader(KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0);
            return;
        }
        GlideApp.getAuthRequestContext(p0).PlaceComponentResult(p1).getErrorConfigVersion(p2).PlaceComponentResult(p2).MyBillsEntityDataFactory(p3);
    }
}
