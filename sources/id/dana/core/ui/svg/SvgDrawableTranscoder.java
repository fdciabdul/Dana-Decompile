package id.dana.core.ui.svg;

import android.graphics.drawable.PictureDrawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.SimpleResource;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.caverock.androidsvg.SVG;

/* loaded from: classes4.dex */
public class SvgDrawableTranscoder implements ResourceTranscoder<SVG, PictureDrawable> {
    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    public final Resource<PictureDrawable> BuiltInFictitiousFunctionClassFactory(Resource<SVG> resource, Options options) {
        return new SimpleResource(new PictureDrawable(resource.getAuthRequestContext().renderToPicture()));
    }
}
