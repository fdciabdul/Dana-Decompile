package id.dana.feeds.data.mapper;

import com.google.gson.Gson;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ActivityItemEntityMapper_Factory implements Factory<ActivityItemEntityMapper> {
    private final Provider<Gson> MyBillsEntityDataFactory;

    private ActivityItemEntityMapper_Factory(Provider<Gson> provider) {
        this.MyBillsEntityDataFactory = provider;
    }

    public static ActivityItemEntityMapper_Factory PlaceComponentResult(Provider<Gson> provider) {
        return new ActivityItemEntityMapper_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ActivityItemEntityMapper(this.MyBillsEntityDataFactory.get());
    }
}
