package id.dana.data.installedapp.repository;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.installedapp.repository.source.local.LocalInstalledAppEntityData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/data/installedapp/repository/InstalledAppEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/installedapp/repository/InstalledAppEntityData;", "Lid/dana/data/installedapp/repository/source/local/LocalInstalledAppEntityData;", "getAuthRequestContext", "Lid/dana/data/installedapp/repository/source/local/LocalInstalledAppEntityData;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Lid/dana/data/installedapp/repository/source/local/LocalInstalledAppEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InstalledAppEntityDataFactory extends AbstractEntityDataFactory<InstalledAppEntityData> {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final LocalInstalledAppEntityData KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public InstalledAppEntityDataFactory(LocalInstalledAppEntityData localInstalledAppEntityData) {
        Intrinsics.checkNotNullParameter(localInstalledAppEntityData, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = localInstalledAppEntityData;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    public final /* bridge */ /* synthetic */ InstalledAppEntityData createData(String str) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
