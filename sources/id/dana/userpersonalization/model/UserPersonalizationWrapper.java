package id.dana.userpersonalization.model;

import id.dana.explore.domain.userpersonalization.model.UserPersonalizationModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0017\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u0012\u0010\u0005\u001a\u00020\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0012\u0010\t\u001a\u00020\u0006X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/userpersonalization/model/UserPersonalizationWrapper;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "PlaceComponentResult", "Lid/dana/explore/domain/userpersonalization/model/UserPersonalizationModel;", "getAuthRequestContext", "Lid/dana/explore/domain/userpersonalization/model/UserPersonalizationModel;", "MyBillsEntityDataFactory", "p0", "p1", "<init>", "(Lid/dana/explore/domain/userpersonalization/model/UserPersonalizationModel;I)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UserPersonalizationWrapper {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public int PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public UserPersonalizationModel MyBillsEntityDataFactory;

    public UserPersonalizationWrapper(UserPersonalizationModel userPersonalizationModel, int i) {
        Intrinsics.checkNotNullParameter(userPersonalizationModel, "");
        this.MyBillsEntityDataFactory = userPersonalizationModel;
        this.PlaceComponentResult = i;
    }
}
