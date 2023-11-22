package com.bumptech.glide.request.transition;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: classes7.dex */
public abstract class BitmapContainerTransitionFactory<R> implements TransitionFactory<R> {
    private final TransitionFactory<Drawable> MyBillsEntityDataFactory;

    protected abstract Bitmap PlaceComponentResult(R r);

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public final Transition<R> KClassImpl$Data$declaredNonStaticMembers$2(DataSource dataSource, boolean z) {
        return new BitmapGlideAnimation(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(dataSource, z));
    }

    /* loaded from: classes7.dex */
    final class BitmapGlideAnimation implements Transition<R> {
        private final Transition<Drawable> getAuthRequestContext;

        BitmapGlideAnimation(Transition<Drawable> transition) {
            this.getAuthRequestContext = transition;
        }

        @Override // com.bumptech.glide.request.transition.Transition
        public final boolean MyBillsEntityDataFactory(R r, Transition.ViewAdapter viewAdapter) {
            return this.getAuthRequestContext.MyBillsEntityDataFactory(new BitmapDrawable(viewAdapter.PlaceComponentResult().getResources(), BitmapContainerTransitionFactory.this.PlaceComponentResult(r)), viewAdapter);
        }
    }
}
