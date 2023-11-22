package id.dana.lib.gcontainer.app.extension.toolbar;

import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.ContextCompat;
import com.alibaba.griver.api.ui.titlebar.GriverBackButtonStyleExtension;
import id.dana.lib.gcontainer.GContainer;
import id.dana.lib.gcontainer.extension.ViewExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004"}, d2 = {"Lid/dana/lib/gcontainer/app/extension/toolbar/BackButtonExtension;", "Lcom/alibaba/griver/api/ui/titlebar/GriverBackButtonStyleExtension;", "", "getContent", "()Ljava/lang/String;", "Landroid/graphics/drawable/Drawable;", "getIconDrawable", "()Landroid/graphics/drawable/Drawable;", "getType", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class BackButtonExtension implements GriverBackButtonStyleExtension {
    @Override // com.alibaba.griver.api.ui.titlebar.GriverButtonStyleExtension
    public final String getContent() {
        return GContainer.getToolbarStyle().getBackButton().getText();
    }

    @Override // com.alibaba.griver.api.ui.titlebar.GriverButtonStyleExtension
    public final String getType() {
        if (GContainer.getToolbarStyle().getBackButton().getIcon() != 0) {
            return "icon";
        }
        String text = GContainer.getToolbarStyle().getBackButton().getText();
        if (text == null || text.length() == 0) {
            return null;
        }
        return "text";
    }

    @Override // com.alibaba.griver.api.ui.titlebar.GriverButtonStyleExtension
    public final Drawable getIconDrawable() {
        Drawable BuiltInFictitiousFunctionClassFactory;
        if (Intrinsics.areEqual(getType(), "icon")) {
            BuiltInFictitiousFunctionClassFactory = ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(GContainer.getApplicationContext(), GContainer.getToolbarStyle().getBackButton().getIcon());
            if (GContainer.getToolbarStyle().getBackButton().getColor() != 0) {
                ViewExtKt.applyTint(BuiltInFictitiousFunctionClassFactory, ContextCompat.BuiltInFictitiousFunctionClassFactory(GContainer.getApplicationContext(), GContainer.getToolbarStyle().getBackButton().getColor()));
                return BuiltInFictitiousFunctionClassFactory;
            }
            return BuiltInFictitiousFunctionClassFactory;
        }
        return null;
    }
}
