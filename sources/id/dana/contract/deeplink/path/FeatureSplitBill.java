package id.dana.contract.deeplink.path;

import id.dana.domain.featureconfig.interactor.GetRequestMoneyInfoFeature;
import id.dana.domain.featureconfig.interactor.GetSplitBillConfig;
import id.dana.requestmoney.mapper.RequestMoneyInfoModelMapper;
import id.dana.requestmoney.model.RequestMoneyInfoModel;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0011B!\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\n"}, d2 = {"Lid/dana/contract/deeplink/path/FeatureSplitBill;", "", "Lid/dana/domain/featureconfig/interactor/GetRequestMoneyInfoFeature;", "getAuthRequestContext", "Lid/dana/domain/featureconfig/interactor/GetRequestMoneyInfoFeature;", "PlaceComponentResult", "Lid/dana/domain/featureconfig/interactor/GetSplitBillConfig;", "Lid/dana/domain/featureconfig/interactor/GetSplitBillConfig;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/requestmoney/mapper/RequestMoneyInfoModelMapper;", "Lid/dana/requestmoney/mapper/RequestMoneyInfoModelMapper;", "MyBillsEntityDataFactory", "p0", "p1", "p2", "<init>", "(Lid/dana/domain/featureconfig/interactor/GetSplitBillConfig;Lid/dana/domain/featureconfig/interactor/GetRequestMoneyInfoFeature;Lid/dana/requestmoney/mapper/RequestMoneyInfoModelMapper;)V", "Callback"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FeatureSplitBill {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final RequestMoneyInfoModelMapper MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final GetSplitBillConfig KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final GetRequestMoneyInfoFeature PlaceComponentResult;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/contract/deeplink/path/FeatureSplitBill$Callback;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "Lid/dana/requestmoney/model/RequestMoneyInfoModel;", "p0", "", "p1", "", "p2", "MyBillsEntityDataFactory", "(Lid/dana/requestmoney/model/RequestMoneyInfoModel;JI)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface Callback {
        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory(RequestMoneyInfoModel p0, long p1, int p2);
    }

    @Inject
    public FeatureSplitBill(GetSplitBillConfig getSplitBillConfig, GetRequestMoneyInfoFeature getRequestMoneyInfoFeature, RequestMoneyInfoModelMapper requestMoneyInfoModelMapper) {
        Intrinsics.checkNotNullParameter(getSplitBillConfig, "");
        Intrinsics.checkNotNullParameter(getRequestMoneyInfoFeature, "");
        Intrinsics.checkNotNullParameter(requestMoneyInfoModelMapper, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getSplitBillConfig;
        this.PlaceComponentResult = getRequestMoneyInfoFeature;
        this.MyBillsEntityDataFactory = requestMoneyInfoModelMapper;
    }
}
