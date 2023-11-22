package id.dana.component.extension;

import android.content.Context;
import android.os.Handler;
import android.widget.ImageView;
import com.afollestad.materialdialogs.MaterialDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\b"}, d2 = {"Landroid/widget/ImageView;", "", "p0", "", "getAuthRequestContext", "(Landroid/widget/ImageView;I)V", "Lcom/afollestad/materialdialogs/MaterialDialog;", "", "(Lcom/afollestad/materialdialogs/MaterialDialog;J)V"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes4.dex */
public final class ViewExtKt {
    public static final void getAuthRequestContext(ImageView imageView, int i) {
        Intrinsics.checkNotNullParameter(imageView, "");
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        imageView.setImageDrawable(ContextExtKt.KClassImpl$Data$declaredNonStaticMembers$2(context, i));
    }

    public static final void getAuthRequestContext(final MaterialDialog materialDialog, long j) {
        Intrinsics.checkNotNullParameter(materialDialog, "");
        materialDialog.show();
        if (j > 0) {
            new Handler().postDelayed(new Runnable() { // from class: id.dana.component.extension.ViewExtKt$show$1
                @Override // java.lang.Runnable
                public final void run() {
                    if (ContextExtKt.BuiltInFictitiousFunctionClassFactory(MaterialDialog.this.getContext())) {
                        MaterialDialog.this.dismiss();
                    }
                }
            }, j);
        }
    }
}
