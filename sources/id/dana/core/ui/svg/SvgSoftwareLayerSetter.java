package id.dana.core.ui.svg;

import android.graphics.drawable.PictureDrawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.bumptech.glide.request.target.Target;

/* loaded from: classes4.dex */
public class SvgSoftwareLayerSetter implements RequestListener<PictureDrawable> {
    int BuiltInFictitiousFunctionClassFactory;

    @Override // com.bumptech.glide.request.RequestListener
    public /* synthetic */ boolean onResourceReady(PictureDrawable pictureDrawable, Object obj, Target<PictureDrawable> target, DataSource dataSource, boolean z) {
        return getAuthRequestContext(target);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SvgSoftwareLayerSetter(int i) {
        this.BuiltInFictitiousFunctionClassFactory = i;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public boolean onLoadFailed(GlideException glideException, Object obj, Target<PictureDrawable> target, boolean z) {
        ((ImageViewTarget) target).PlaceComponentResult().setLayerType(0, null);
        return false;
    }

    private boolean getAuthRequestContext(Target<PictureDrawable> target) {
        ((ImageViewTarget) target).PlaceComponentResult().setLayerType(this.BuiltInFictitiousFunctionClassFactory, null);
        return false;
    }
}
