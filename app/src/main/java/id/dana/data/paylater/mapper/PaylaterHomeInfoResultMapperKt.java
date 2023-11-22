package id.dana.data.paylater.mapper;

import id.dana.data.paylater.repository.source.network.result.PaylaterHomeInfoResult;
import id.dana.domain.paylater.PaylaterAction;
import id.dana.domain.paylater.model.PaylaterHomeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/paylater/repository/source/network/result/PaylaterHomeInfoResult;", "Lid/dana/domain/paylater/model/PaylaterHomeInfo;", "toPaylaterHomeInfo", "(Lid/dana/data/paylater/repository/source/network/result/PaylaterHomeInfoResult;)Lid/dana/domain/paylater/model/PaylaterHomeInfo;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PaylaterHomeInfoResultMapperKt {
    public static final PaylaterHomeInfo toPaylaterHomeInfo(PaylaterHomeInfoResult paylaterHomeInfoResult) {
        Intrinsics.checkNotNullParameter(paylaterHomeInfoResult, "");
        int partnerId = paylaterHomeInfoResult.getPartnerId();
        String action = paylaterHomeInfoResult.getAction();
        return new PaylaterHomeInfo(partnerId, PaylaterAction.valueOf(action != null ? action : ""));
    }
}
