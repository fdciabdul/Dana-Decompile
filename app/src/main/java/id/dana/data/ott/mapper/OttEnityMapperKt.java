package id.dana.data.ott.mapper;

import id.dana.data.ott.OttVerifyEntity;
import id.dana.domain.ott.OttVerifyResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/ott/OttVerifyEntity;", "Lid/dana/domain/ott/OttVerifyResult;", "getAuthRequestContext", "(Lid/dana/data/ott/OttVerifyEntity;)Lid/dana/domain/ott/OttVerifyResult;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OttEnityMapperKt {
    public static final OttVerifyResult getAuthRequestContext(OttVerifyEntity ottVerifyEntity) {
        Intrinsics.checkNotNullParameter(ottVerifyEntity, "");
        return new OttVerifyResult(ottVerifyEntity.getUserId(), ottVerifyEntity.getMerchantId(), ottVerifyEntity.getNeedLogout(), ottVerifyEntity.getMobileNo());
    }
}
