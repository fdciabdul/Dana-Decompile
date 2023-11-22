package id.dana.social.utils;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class FeedUtils_Factory implements Factory<FeedUtils> {
    private final Provider<Context> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeedUtils(this.getAuthRequestContext.get());
    }
}
