package id.dana.contract.shortener;

import android.content.Context;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class RestoreUrlView_Factory implements Factory<RestoreUrlView> {
    private final Provider<Context> PlaceComponentResult;

    private RestoreUrlView_Factory(Provider<Context> provider) {
        this.PlaceComponentResult = provider;
    }

    public static RestoreUrlView_Factory MyBillsEntityDataFactory(Provider<Context> provider) {
        return new RestoreUrlView_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new RestoreUrlView(DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult));
    }
}
