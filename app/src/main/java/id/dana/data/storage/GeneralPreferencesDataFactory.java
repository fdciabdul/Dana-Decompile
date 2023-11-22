package id.dana.data.storage;

import dagger.Lazy;
import id.dana.data.AbstractEntityDataFactory;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/data/storage/GeneralPreferencesDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/storage/GeneralPreferencesData;", "", "source", "createData", "(Ljava/lang/String;)Lid/dana/data/storage/GeneralPreferencesData;", "Ldagger/Lazy;", "Lid/dana/data/storage/LocalGeneralDanaPreferencesData;", "localGeneralDanaPreferencesData", "Ldagger/Lazy;", "<init>", "(Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GeneralPreferencesDataFactory extends AbstractEntityDataFactory<GeneralPreferencesData> {
    private final Lazy<LocalGeneralDanaPreferencesData> localGeneralDanaPreferencesData;

    @Inject
    public GeneralPreferencesDataFactory(Lazy<LocalGeneralDanaPreferencesData> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.localGeneralDanaPreferencesData = lazy;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final GeneralPreferencesData createData2(String source) {
        Intrinsics.checkNotNullParameter(source, "");
        LocalGeneralDanaPreferencesData localGeneralDanaPreferencesData = this.localGeneralDanaPreferencesData.get();
        Intrinsics.checkNotNullExpressionValue(localGeneralDanaPreferencesData, "");
        return localGeneralDanaPreferencesData;
    }
}
