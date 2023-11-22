package id.dana.core.ui.glide;

import android.content.Context;
import android.graphics.drawable.PictureDrawable;
import android.widget.ImageView;
import com.bumptech.glide.request.RequestListener;
import id.dana.core.ui.svg.SvgLoader;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class SvgShimmerAttacher extends ShimmerAttacher<PictureDrawable> {
    public SvgShimmerAttacher(String str) {
        super(str);
    }

    @Override // id.dana.core.ui.glide.ShimmerAttacher
    protected final void PlaceComponentResult(Context context, ImageView imageView) {
        SvgLoader.Builder KClassImpl$Data$declaredNonStaticMembers$2 = SvgLoader.KClassImpl$Data$declaredNonStaticMembers$2(context);
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = MyBillsEntityDataFactory();
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult();
        RequestListener<PictureDrawable> KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2();
        if (KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext == null) {
            KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = new ArrayList();
        }
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.add(KClassImpl$Data$declaredNonStaticMembers$22);
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = imageView;
        new SvgLoader(KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0);
    }
}
