package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class TintResources extends ResourcesWrapper {
    private final WeakReference<Context> BuiltInFictitiousFunctionClassFactory;

    public TintResources(Context context, Resources resources) {
        super(resources);
        this.BuiltInFictitiousFunctionClassFactory = new WeakReference<>(context);
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        Drawable authRequestContext = getAuthRequestContext(i);
        Context context = this.BuiltInFictitiousFunctionClassFactory.get();
        if (authRequestContext != null && context != null) {
            ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().MyBillsEntityDataFactory(context, i, authRequestContext);
        }
        return authRequestContext;
    }
}
