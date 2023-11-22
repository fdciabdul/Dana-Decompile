package com.bumptech.glide;

import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.NoTransition;
import com.bumptech.glide.request.transition.TransitionFactory;

/* loaded from: classes3.dex */
public abstract class TransitionOptions<CHILD extends TransitionOptions<CHILD, TranscodeType>, TranscodeType> implements Cloneable {
    TransitionFactory<? super TranscodeType> KClassImpl$Data$declaredNonStaticMembers$2 = NoTransition.KClassImpl$Data$declaredNonStaticMembers$2();

    /* renamed from: PlaceComponentResult  reason: merged with bridge method [inline-methods] */
    public final CHILD clone() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
