package id.dana.explore.data.userpersonalization.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.explore.data.userpersonalization.UserPersonalizationEntityData;
import id.dana.explore.data.userpersonalization.source.local.LocalUserPersonalizationEntityData;
import id.dana.explore.data.userpersonalization.source.network.NetworkUserPersonalizationEntityData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0005\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\bR\u0014\u0010\u0005\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/explore/data/userpersonalization/source/UserPersonalizationEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/explore/data/userpersonalization/UserPersonalizationEntityData;", "", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Lid/dana/explore/data/userpersonalization/UserPersonalizationEntityData;", "Lid/dana/explore/data/userpersonalization/source/local/LocalUserPersonalizationEntityData;", "Lid/dana/explore/data/userpersonalization/source/local/LocalUserPersonalizationEntityData;", "PlaceComponentResult", "Lid/dana/explore/data/userpersonalization/source/network/NetworkUserPersonalizationEntityData;", "getAuthRequestContext", "Lid/dana/explore/data/userpersonalization/source/network/NetworkUserPersonalizationEntityData;", "p1", "<init>", "(Lid/dana/explore/data/userpersonalization/source/network/NetworkUserPersonalizationEntityData;Lid/dana/explore/data/userpersonalization/source/local/LocalUserPersonalizationEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UserPersonalizationEntityDataFactory extends AbstractEntityDataFactory<UserPersonalizationEntityData> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final LocalUserPersonalizationEntityData PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final NetworkUserPersonalizationEntityData KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public UserPersonalizationEntityDataFactory(NetworkUserPersonalizationEntityData networkUserPersonalizationEntityData, LocalUserPersonalizationEntityData localUserPersonalizationEntityData) {
        Intrinsics.checkNotNullParameter(networkUserPersonalizationEntityData, "");
        Intrinsics.checkNotNullParameter(localUserPersonalizationEntityData, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = networkUserPersonalizationEntityData;
        this.PlaceComponentResult = localUserPersonalizationEntityData;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
    public final UserPersonalizationEntityData createData2(String p0) {
        if (Intrinsics.areEqual(p0, "local")) {
            return this.PlaceComponentResult;
        }
        Intrinsics.areEqual(p0, "network");
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
