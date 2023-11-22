package id.dana.requestmoney;

import dagger.MembersInjector;
import id.dana.domain.featureconfig.interactor.GetRequestMoneyInfoFeature;
import id.dana.domain.homeinfo.interactor.GetHomeInfo;
import id.dana.mapper.HomeInfoMapper;
import id.dana.requestmoney.mapper.RequestMoneyInfoModelMapper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class RequestMoneyQrPresenter_MembersInjector implements MembersInjector<RequestMoneyQrPresenter> {
    public static void MyBillsEntityDataFactory(RequestMoneyQrPresenter requestMoneyQrPresenter, GetHomeInfo getHomeInfo, HomeInfoMapper homeInfoMapper) {
        Intrinsics.checkNotNullParameter(getHomeInfo, "");
        Intrinsics.checkNotNullParameter(homeInfoMapper, "");
        requestMoneyQrPresenter.moveToNextValue = getHomeInfo;
        requestMoneyQrPresenter.NetworkUserEntityData$$ExternalSyntheticLambda0 = homeInfoMapper;
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(RequestMoneyQrPresenter requestMoneyQrPresenter, GetRequestMoneyInfoFeature getRequestMoneyInfoFeature, RequestMoneyInfoModelMapper requestMoneyInfoModelMapper) {
        Intrinsics.checkNotNullParameter(getRequestMoneyInfoFeature, "");
        Intrinsics.checkNotNullParameter(requestMoneyInfoModelMapper, "");
        requestMoneyQrPresenter.getErrorConfigVersion = getRequestMoneyInfoFeature;
        requestMoneyQrPresenter.lookAheadTest = requestMoneyInfoModelMapper;
    }
}
