package id.dana.data.registration.source;

import dagger.Lazy;
import id.dana.data.AbstractEntityDataFactory;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B%\b\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\t"}, d2 = {"Lid/dana/data/registration/source/RegistrationEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/registration/source/RegistrationEntityData;", "", "source", "createData", "(Ljava/lang/String;)Lid/dana/data/registration/source/RegistrationEntityData;", "Ldagger/Lazy;", "local", "Ldagger/Lazy;", "network", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RegistrationEntityDataFactory extends AbstractEntityDataFactory<RegistrationEntityData> {
    private final Lazy<RegistrationEntityData> local;
    private final Lazy<RegistrationEntityData> network;

    @Inject
    public RegistrationEntityDataFactory(Lazy<RegistrationEntityData> lazy, Lazy<RegistrationEntityData> lazy2) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        this.network = lazy;
        this.local = lazy2;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final RegistrationEntityData createData2(String source) {
        Intrinsics.checkNotNullParameter(source, "");
        if (Intrinsics.areEqual("local", source)) {
            RegistrationEntityData registrationEntityData = this.local.get();
            Intrinsics.checkNotNullExpressionValue(registrationEntityData, "");
            return registrationEntityData;
        }
        RegistrationEntityData registrationEntityData2 = this.network.get();
        Intrinsics.checkNotNullExpressionValue(registrationEntityData2, "");
        return registrationEntityData2;
    }
}
