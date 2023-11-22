package com.airbnb.lottie;

import android.content.Context;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final /* synthetic */ class LottieCompositionFactory$$ExternalSyntheticLambda2 implements Callable {
    public final /* synthetic */ Context KClassImpl$Data$declaredNonStaticMembers$2;
    public final /* synthetic */ String MyBillsEntityDataFactory;
    public final /* synthetic */ String getAuthRequestContext;

    public /* synthetic */ LottieCompositionFactory$$ExternalSyntheticLambda2(Context context, String str, String str2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.MyBillsEntityDataFactory = str;
        this.getAuthRequestContext = str2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return LottieCompositionFactory.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory, this.getAuthRequestContext);
    }
}
