package id.dana.cardbinding.di.module;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.cardbinding.tracker.CardBindingAnalyticTracker;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class CardBindingAnalyticModule_ProvideCardBindingAnalyticTrackerFactory implements Factory<CardBindingAnalyticTracker> {
    private final Provider<Context> BuiltInFictitiousFunctionClassFactory;
    private final CardBindingAnalyticModule MyBillsEntityDataFactory;

    public static CardBindingAnalyticTracker PlaceComponentResult(CardBindingAnalyticModule cardBindingAnalyticModule, Context context) {
        return (CardBindingAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(cardBindingAnalyticModule.MyBillsEntityDataFactory(context));
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (CardBindingAnalyticTracker) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.get()));
    }
}
