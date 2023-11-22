package id.dana.core.ui.util;

import android.view.ViewTreeObserver;
import android.widget.ImageView;
import id.dana.core.ui.util.ImageOss;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/core/ui/util/ImageOss$setOptimizedImage$1;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ImageOss$setOptimizedImage$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ ImageView BuiltInFictitiousFunctionClassFactory;
    final /* synthetic */ ImageOss.EventListener KClassImpl$Data$declaredNonStaticMembers$2;
    final /* synthetic */ String getAuthRequestContext;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        ImageOss.BuiltInFictitiousFunctionClassFactory(ImageOss.INSTANCE, this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory);
        this.BuiltInFictitiousFunctionClassFactory.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
}
