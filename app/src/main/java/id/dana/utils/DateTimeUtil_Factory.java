package id.dana.utils;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class DateTimeUtil_Factory implements Factory<DateTimeUtil> {
    private final Provider<Context> getAuthRequestContext;

    private DateTimeUtil_Factory(Provider<Context> provider) {
        this.getAuthRequestContext = provider;
    }

    public static DateTimeUtil_Factory PlaceComponentResult(Provider<Context> provider) {
        return new DateTimeUtil_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DateTimeUtil(this.getAuthRequestContext.get());
    }
}
