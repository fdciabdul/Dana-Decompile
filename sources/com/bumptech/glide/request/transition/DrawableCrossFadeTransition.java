package com.bumptech.glide.request.transition;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: classes7.dex */
public class DrawableCrossFadeTransition implements Transition<Drawable> {
    private final boolean BuiltInFictitiousFunctionClassFactory;
    private final int KClassImpl$Data$declaredNonStaticMembers$2;

    public DrawableCrossFadeTransition(int i, boolean z) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.BuiltInFictitiousFunctionClassFactory = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.bumptech.glide.request.transition.Transition
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
    public boolean MyBillsEntityDataFactory(Drawable drawable, Transition.ViewAdapter viewAdapter) {
        Drawable BuiltInFictitiousFunctionClassFactory = viewAdapter.BuiltInFictitiousFunctionClassFactory();
        if (BuiltInFictitiousFunctionClassFactory == null) {
            BuiltInFictitiousFunctionClassFactory = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{BuiltInFictitiousFunctionClassFactory, drawable});
        transitionDrawable.setCrossFadeEnabled(this.BuiltInFictitiousFunctionClassFactory);
        transitionDrawable.startTransition(this.KClassImpl$Data$declaredNonStaticMembers$2);
        viewAdapter.MyBillsEntityDataFactory(transitionDrawable);
        return true;
    }
}
