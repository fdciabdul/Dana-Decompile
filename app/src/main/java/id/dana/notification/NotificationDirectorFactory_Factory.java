package id.dana.notification;

import dagger.internal.Factory;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class NotificationDirectorFactory_Factory implements Factory<NotificationDirectorFactory> {
    private final Provider<DynamicUrlWrapper> MyBillsEntityDataFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new NotificationDirectorFactory(this.MyBillsEntityDataFactory.get());
    }
}
