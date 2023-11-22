package id.dana.core.ui.glide;

import id.dana.core.ui.glide.BaseImageAttacher;
import id.dana.core.ui.svg.SvgLoader;

/* loaded from: classes4.dex */
public class ShimmerImageAttacherFactory extends ImageAttacherFactory {
    private final int BuiltInFictitiousFunctionClassFactory = 0;

    public ShimmerImageAttacherFactory() {
    }

    public ShimmerImageAttacherFactory(byte b) {
    }

    @Override // id.dana.core.ui.glide.ImageAttacherFactory
    protected final ImageAttacherStrategy PlaceComponentResult(String str, BaseImageAttacher.AdditionalData additionalData) {
        if (SvgLoader.getAuthRequestContext(str)) {
            return new SvgShimmerAttacher(str);
        }
        return new ImageShimmerAttacher(str, this.BuiltInFictitiousFunctionClassFactory, additionalData);
    }
}
