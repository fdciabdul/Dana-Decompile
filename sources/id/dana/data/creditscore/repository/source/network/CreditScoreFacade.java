package id.dana.data.creditscore.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.data.creditscore.repository.source.network.request.InsertDeviceScoringDataRequest;
import id.dana.data.creditscore.repository.source.network.response.InsertDeviceScoringDataResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/creditscore/repository/source/network/CreditScoreFacade;", "", "Lid/dana/data/creditscore/repository/source/network/request/InsertDeviceScoringDataRequest;", "request", "Lid/dana/data/creditscore/repository/source/network/response/InsertDeviceScoringDataResult;", "insertDeviceScoringData", "(Lid/dana/data/creditscore/repository/source/network/request/InsertDeviceScoringDataRequest;)Lid/dana/data/creditscore/repository/source/network/response/InsertDeviceScoringDataResult;", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface CreditScoreFacade {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.BuiltInFictitiousFunctionClassFactory;

    @OperationType("id.dana.devicefingerprintprod.scoringdata.insert")
    @SignCheck
    InsertDeviceScoringDataResult insertDeviceScoringData(InsertDeviceScoringDataRequest request);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/creditscore/repository/source/network/CreditScoreFacade$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion BuiltInFictitiousFunctionClassFactory = new Companion();

        private Companion() {
        }
    }
}
