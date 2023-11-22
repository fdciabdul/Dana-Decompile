package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;

/* loaded from: classes7.dex */
public class DrawableCrossFadeFactory implements TransitionFactory<Drawable> {
    private final boolean BuiltInFictitiousFunctionClassFactory;
    private final int KClassImpl$Data$declaredNonStaticMembers$2;
    private DrawableCrossFadeTransition MyBillsEntityDataFactory;

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public final Transition<Drawable> KClassImpl$Data$declaredNonStaticMembers$2(DataSource dataSource, boolean z) {
        if (dataSource == DataSource.MEMORY_CACHE) {
            return NoTransition.getAuthRequestContext();
        }
        if (this.MyBillsEntityDataFactory == null) {
            this.MyBillsEntityDataFactory = new DrawableCrossFadeTransition(this.KClassImpl$Data$declaredNonStaticMembers$2, this.BuiltInFictitiousFunctionClassFactory);
        }
        return this.MyBillsEntityDataFactory;
    }

    /* loaded from: classes7.dex */
    public static class Builder {
        private final int MyBillsEntityDataFactory;

        public Builder() {
            this((byte) 0);
        }

        private Builder(byte b) {
            this.MyBillsEntityDataFactory = 300;
        }
    }
}
