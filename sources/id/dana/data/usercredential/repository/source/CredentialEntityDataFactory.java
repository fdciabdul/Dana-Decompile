package id.dana.data.usercredential.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.usercredential.repository.CredentialEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004"}, d2 = {"Lid/dana/data/usercredential/repository/source/CredentialEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/usercredential/repository/CredentialEntityData;", "PlaceComponentResult", "Lid/dana/data/usercredential/repository/CredentialEntityData;", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "p0", "p1", "<init>", "(Lid/dana/data/usercredential/repository/CredentialEntityData;Lid/dana/data/usercredential/repository/CredentialEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CredentialEntityDataFactory extends AbstractEntityDataFactory<CredentialEntityData> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final CredentialEntityData KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final CredentialEntityData PlaceComponentResult;

    @Inject
    public CredentialEntityDataFactory(CredentialEntityData credentialEntityData, CredentialEntityData credentialEntityData2) {
        Intrinsics.checkNotNullParameter(credentialEntityData, "");
        Intrinsics.checkNotNullParameter(credentialEntityData2, "");
        this.PlaceComponentResult = credentialEntityData;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = credentialEntityData2;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    public final /* synthetic */ CredentialEntityData createData(String str) {
        return Intrinsics.areEqual(str, "network") ? this.PlaceComponentResult : this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
