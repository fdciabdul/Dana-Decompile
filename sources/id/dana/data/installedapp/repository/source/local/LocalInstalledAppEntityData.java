package id.dana.data.installedapp.repository.source.local;

import id.dana.data.installedapp.repository.InstalledAppEntityData;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\n"}, d2 = {"Lid/dana/data/installedapp/repository/source/local/LocalInstalledAppEntityData;", "Lid/dana/data/installedapp/repository/InstalledAppEntityData;", "", "p0", "Lio/reactivex/Observable;", "", "getAuthRequestContext", "(Ljava/lang/String;)Lio/reactivex/Observable;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/data/installedapp/repository/source/local/InstalledAppPreference;", "Lid/dana/data/installedapp/repository/source/local/InstalledAppPreference;", "MyBillsEntityDataFactory", "<init>", "(Lid/dana/data/installedapp/repository/source/local/InstalledAppPreference;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocalInstalledAppEntityData implements InstalledAppEntityData {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final InstalledAppPreference MyBillsEntityDataFactory;

    @Inject
    public LocalInstalledAppEntityData(InstalledAppPreference installedAppPreference) {
        Intrinsics.checkNotNullParameter(installedAppPreference, "");
        this.MyBillsEntityDataFactory = installedAppPreference;
    }

    @Override // id.dana.data.installedapp.repository.InstalledAppEntityData
    public final Observable<Boolean> BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.MyBillsEntityDataFactory.getAuthRequestContext(p0)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.installedapp.repository.InstalledAppEntityData
    public final Observable<Boolean> getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<Boolean> just = Observable.just(Boolean.valueOf(!this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(p0)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }
}
