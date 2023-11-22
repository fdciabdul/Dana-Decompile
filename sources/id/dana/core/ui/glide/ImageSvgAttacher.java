package id.dana.core.ui.glide;

import android.content.Context;
import android.widget.ImageView;
import id.dana.core.ui.glide.BaseImageAttacher;
import id.dana.core.ui.svg.SvgLoader;

/* loaded from: classes4.dex */
public class ImageSvgAttacher extends UrlImageAttacher {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ImageSvgAttacher(String str, BaseImageAttacher.AdditionalData additionalData) {
        super(str, additionalData);
    }

    @Override // id.dana.core.ui.glide.ImageAttacherStrategy
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Context context, ImageView imageView) {
        SvgLoader.Builder KClassImpl$Data$declaredNonStaticMembers$2 = SvgLoader.KClassImpl$Data$declaredNonStaticMembers$2(context);
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = MyBillsEntityDataFactory();
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult();
        if (getAuthRequestContext() != null) {
            KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue = getAuthRequestContext();
        }
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = imageView;
        new SvgLoader(KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0);
    }
}
