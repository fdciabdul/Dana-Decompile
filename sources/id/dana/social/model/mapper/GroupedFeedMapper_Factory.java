package id.dana.social.model.mapper;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class GroupedFeedMapper_Factory implements Factory<GroupedFeedMapper> {
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<FeedModelMapper> getAuthRequestContext;

    private GroupedFeedMapper_Factory(Provider<Context> provider, Provider<FeedModelMapper> provider2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.getAuthRequestContext = provider2;
    }

    public static GroupedFeedMapper_Factory PlaceComponentResult(Provider<Context> provider, Provider<FeedModelMapper> provider2) {
        return new GroupedFeedMapper_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GroupedFeedMapper(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get());
    }
}
