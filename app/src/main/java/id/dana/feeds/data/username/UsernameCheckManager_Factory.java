package id.dana.feeds.data.username;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class UsernameCheckManager_Factory implements Factory<UsernameCheckManager> {
    private final Provider<Context> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new UsernameCheckManager(this.getAuthRequestContext.get());
    }
}
