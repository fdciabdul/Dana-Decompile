package id.dana.contract.deeplink;

import id.dana.contract.deeplink.DeepLinkContract;
import id.dana.contract.deeplink.InitSessionDeepLinkContract;
import id.dana.di.PerActivity;
import id.dana.domain.deeplink.interactor.InitSessionDeepLink;
import id.dana.mapper.DeepLinkPayloadModelMapper;
import javax.inject.Inject;

@PerActivity
/* loaded from: classes8.dex */
public class InitSessionDeepLinkPresenter implements InitSessionDeepLinkContract.Presenter {
    private final DeepLinkPayloadModelMapper BuiltInFictitiousFunctionClassFactory;
    private final DeepLinkContract.View MyBillsEntityDataFactory;
    private final InitSessionDeepLink getAuthRequestContext;

    @Inject
    public InitSessionDeepLinkPresenter(DeepLinkContract.View view, InitSessionDeepLink initSessionDeepLink, DeepLinkPayloadModelMapper deepLinkPayloadModelMapper) {
        this.MyBillsEntityDataFactory = view;
        this.getAuthRequestContext = initSessionDeepLink;
        this.BuiltInFictitiousFunctionClassFactory = deepLinkPayloadModelMapper;
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.getAuthRequestContext.dispose();
    }
}
