package id.dana.social.extension;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.request.BaseRequestOptions;
import id.dana.core.ui.glide.GlideApp;
import id.dana.extension.view.InputExtKt;
import id.dana.utils.ImageResize;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0003\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"loadAvatar", "", "Landroid/widget/ImageView;", "url", "", "placeholderResId", "", "app_productionRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SocialFeedExtKt {
    public static final void BuiltInFictitiousFunctionClassFactory(ImageView imageView, String str, int i) {
        Intrinsics.checkNotNullParameter(imageView, "");
        Intrinsics.checkNotNullParameter(str, "");
        if (imageView.getContext() instanceof Activity) {
            Context context = imageView.getContext();
            if (context == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            }
            if (((Activity) context).isDestroyed()) {
                return;
            }
        }
        GlideApp.getAuthRequestContext(imageView.getContext()).MyBillsEntityDataFactory(InputExtKt.BuiltInFictitiousFunctionClassFactory(str)).BuiltInFictitiousFunctionClassFactory((BaseRequestOptions<?>) ImageResize.getAuthRequestContext()).getErrorConfigVersion(i).PlaceComponentResult(i).MyBillsEntityDataFactory(imageView);
    }
}
