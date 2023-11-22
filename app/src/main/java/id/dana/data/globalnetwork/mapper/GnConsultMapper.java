package id.dana.data.globalnetwork.mapper;

import id.dana.data.globalnetwork.model.GnConsultResult;
import id.dana.domain.globalnetwork.model.GnConsultInfo;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/globalnetwork/mapper/GnConsultMapper;", "", "Lid/dana/data/globalnetwork/model/GnConsultResult;", "gnConsultResult", "Lid/dana/domain/globalnetwork/model/GnConsultInfo;", "transform", "(Lid/dana/data/globalnetwork/model/GnConsultResult;)Lid/dana/domain/globalnetwork/model/GnConsultInfo;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GnConsultMapper {
    @Inject
    public GnConsultMapper() {
    }

    public final GnConsultInfo transform(GnConsultResult gnConsultResult) {
        Intrinsics.checkNotNullParameter(gnConsultResult, "");
        GnConsultInfo gnConsultInfo = new GnConsultInfo(null, null, null, 7, null);
        gnConsultInfo.setResult(gnConsultResult.getResult());
        gnConsultInfo.setSdkResponseHeader(gnConsultResult.getSdkResponseHeader());
        gnConsultInfo.setSdkResponseData(gnConsultResult.getSdkResponseData());
        gnConsultInfo.setSuccess(gnConsultResult.success);
        return gnConsultInfo;
    }
}
