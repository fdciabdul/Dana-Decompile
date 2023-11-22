package id.dana.promoquest.views;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class QuestView_Factory implements Factory<QuestView> {
    private final Provider<Context> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new QuestView(this.PlaceComponentResult.get());
    }
}
