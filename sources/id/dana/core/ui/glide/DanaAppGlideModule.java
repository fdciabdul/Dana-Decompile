package id.dana.core.ui.glide;

import android.content.Context;
import android.graphics.drawable.PictureDrawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.module.AppGlideModule;
import com.caverock.androidsvg.SVG;
import id.dana.core.ui.svg.SvgDecoder;
import id.dana.core.ui.svg.SvgDrawableTranscoder;
import java.io.InputStream;

/* loaded from: classes4.dex */
public class DanaAppGlideModule extends AppGlideModule {
    @Override // com.bumptech.glide.module.AppGlideModule
    public final boolean MyBillsEntityDataFactory() {
        return false;
    }

    @Override // com.bumptech.glide.module.LibraryGlideModule, com.bumptech.glide.module.RegistersComponents
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Context context, Glide glide, Registry registry) {
        registry.BuiltInFictitiousFunctionClassFactory(SVG.class, PictureDrawable.class, new SvgDrawableTranscoder()).BuiltInFictitiousFunctionClassFactory("legacy_append", InputStream.class, SVG.class, new SvgDecoder());
    }
}
