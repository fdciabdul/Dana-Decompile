package com.airbnb.lottie;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final /* synthetic */ class LottieCompositionFactory$$ExternalSyntheticLambda1 implements Callable {
    public final /* synthetic */ int KClassImpl$Data$declaredNonStaticMembers$2;
    public final /* synthetic */ WeakReference MyBillsEntityDataFactory;
    public final /* synthetic */ String PlaceComponentResult;
    public final /* synthetic */ Context getAuthRequestContext;

    public /* synthetic */ LottieCompositionFactory$$ExternalSyntheticLambda1(WeakReference weakReference, Context context, int i, String str) {
        this.MyBillsEntityDataFactory = weakReference;
        this.getAuthRequestContext = context;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.PlaceComponentResult = str;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return LottieCompositionFactory.PlaceComponentResult(this.MyBillsEntityDataFactory, this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult);
    }
}
