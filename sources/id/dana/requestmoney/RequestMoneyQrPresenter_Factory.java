package id.dana.requestmoney;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.domain.account.interactor.GetAvatarUrl;
import id.dana.domain.featureconfig.interactor.CheckBranchDeepLinkFeature;
import id.dana.domain.featureconfig.interactor.GetQrisTcicoConfig;
import id.dana.domain.featureconfig.interactor.GetRequestMoneyInfoFeature;
import id.dana.domain.homeinfo.interactor.GetHomeInfo;
import id.dana.domain.qrbarcode.interactor.GetTransferQr;
import id.dana.mapper.HomeInfoMapper;
import id.dana.requestmoney.RequestMoneyQrContract;
import id.dana.requestmoney.mapper.RequestMoneyInfoModelMapper;
import id.dana.sendmoney_v2.tracker.ApiHitTimer;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class RequestMoneyQrPresenter_Factory implements Factory<RequestMoneyQrPresenter> {
    private final Provider<CheckBranchDeepLinkFeature> BuiltInFictitiousFunctionClassFactory;
    private final Provider<RequestMoneyQrContract.View> DatabaseTableConfigUtil;
    private final Provider<GetAvatarUrl> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ApiHitTimer> MyBillsEntityDataFactory;
    private final Provider<GetRequestMoneyInfoFeature> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Provider<GetQrisTcicoConfig> PlaceComponentResult;
    private final Provider<Context> getAuthRequestContext;
    private final Provider<RequestMoneyInfoModelMapper> getErrorConfigVersion;
    private final Provider<GetTransferQr> lookAheadTest;
    private final Provider<HomeInfoMapper> moveToNextValue;
    private final Provider<GetHomeInfo> scheduleImpl;

    public static RequestMoneyQrPresenter getAuthRequestContext(Context context, GetAvatarUrl getAvatarUrl, GetTransferQr getTransferQr, RequestMoneyQrContract.View view, CheckBranchDeepLinkFeature checkBranchDeepLinkFeature, GetQrisTcicoConfig getQrisTcicoConfig, ApiHitTimer apiHitTimer) {
        return new RequestMoneyQrPresenter(context, getAvatarUrl, getTransferQr, view, checkBranchDeepLinkFeature, getQrisTcicoConfig, apiHitTimer);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        RequestMoneyQrPresenter requestMoneyQrPresenter = new RequestMoneyQrPresenter(this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.lookAheadTest.get(), this.DatabaseTableConfigUtil.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get(), this.MyBillsEntityDataFactory.get());
        RequestMoneyQrPresenter_MembersInjector.MyBillsEntityDataFactory(requestMoneyQrPresenter, this.scheduleImpl.get(), this.moveToNextValue.get());
        RequestMoneyQrPresenter_MembersInjector.KClassImpl$Data$declaredNonStaticMembers$2(requestMoneyQrPresenter, this.NetworkUserEntityData$$ExternalSyntheticLambda0.get(), this.getErrorConfigVersion.get());
        return requestMoneyQrPresenter;
    }
}
