package id.dana.lazada;

import android.net.Uri;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.data.constant.UrlParam;
import id.dana.domain.DefaultObserver;
import id.dana.domain.authcode.AuthCodeResult;
import id.dana.domain.authcode.interactor.GetAuthCode;
import id.dana.domain.lazada.LazadaRegistrationUrl;
import id.dana.domain.lazada.interactor.GetLazadaClickedAgree;
import id.dana.domain.lazada.interactor.GetLazadaRegistrationUrl;
import id.dana.domain.lazada.interactor.SaveLazadaClickedAgree;
import id.dana.lazada.LazadaGuideContract;
import id.dana.lazada.model.MiniAppParamsModel;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
public class LazadaGuidePresenter implements LazadaGuideContract.Presenter {
    LazadaGuideContract.View BuiltInFictitiousFunctionClassFactory;
    final DeviceInformationProvider KClassImpl$Data$declaredNonStaticMembers$2;
    private final GetAuthCode MyBillsEntityDataFactory;
    private final SaveLazadaClickedAgree NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final GetLazadaClickedAgree PlaceComponentResult;
    private final GetLazadaRegistrationUrl getAuthRequestContext;

    @Inject
    public LazadaGuidePresenter(LazadaGuideContract.View view, GetLazadaClickedAgree getLazadaClickedAgree, SaveLazadaClickedAgree saveLazadaClickedAgree, GetLazadaRegistrationUrl getLazadaRegistrationUrl, GetAuthCode getAuthCode, DeviceInformationProvider deviceInformationProvider) {
        this.BuiltInFictitiousFunctionClassFactory = view;
        this.PlaceComponentResult = getLazadaClickedAgree;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = saveLazadaClickedAgree;
        this.getAuthRequestContext = getLazadaRegistrationUrl;
        this.MyBillsEntityDataFactory = getAuthCode;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = deviceInformationProvider;
    }

    @Override // id.dana.lazada.LazadaGuideContract.Presenter
    public final void getAuthRequestContext() {
        this.BuiltInFictitiousFunctionClassFactory.showProgress();
        this.PlaceComponentResult.execute(new DefaultObserver<Boolean>() { // from class: id.dana.lazada.LazadaGuidePresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                LazadaGuidePresenter.this.BuiltInFictitiousFunctionClassFactory.dismissProgress();
                LazadaGuidePresenter.this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(((Boolean) obj).booleanValue());
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                LazadaGuidePresenter.this.BuiltInFictitiousFunctionClassFactory.dismissProgress();
                LazadaGuidePresenter.this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(false);
            }
        });
    }

    @Override // id.dana.lazada.LazadaGuideContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.execute(new DefaultObserver<Boolean>() { // from class: id.dana.lazada.LazadaGuidePresenter.2
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                super.onNext((Boolean) obj);
                LazadaGuideContract.View unused = LazadaGuidePresenter.this.BuiltInFictitiousFunctionClassFactory;
            }
        });
    }

    @Override // id.dana.lazada.LazadaGuideContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String str, String str2) {
        this.BuiltInFictitiousFunctionClassFactory.showProgress();
        this.getAuthRequestContext.execute(new DefaultObserver<LazadaRegistrationUrl>() { // from class: id.dana.lazada.LazadaGuidePresenter.3
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                LazadaGuidePresenter.this.BuiltInFictitiousFunctionClassFactory.dismissProgress();
                LazadaGuidePresenter.this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory((LazadaRegistrationUrl) obj);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                LazadaGuidePresenter.this.BuiltInFictitiousFunctionClassFactory.dismissProgress();
                LazadaGuidePresenter.this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(th.getMessage());
            }
        }, GetLazadaRegistrationUrl.Params.forGetURL(str, str2));
    }

    @Override // id.dana.lazada.LazadaGuideContract.Presenter
    public final void getAuthRequestContext(final MiniAppParamsModel miniAppParamsModel) {
        if (miniAppParamsModel.getKClassImpl$Data$declaredNonStaticMembers$2()) {
            this.BuiltInFictitiousFunctionClassFactory.showProgress();
            this.MyBillsEntityDataFactory.execute(GetAuthCode.Params.forGetAuthCode(miniAppParamsModel.PlaceComponentResult, miniAppParamsModel.MyBillsEntityDataFactory, miniAppParamsModel.getAuthRequestContext, true), new Function1() { // from class: id.dana.lazada.LazadaGuidePresenter$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    LazadaGuidePresenter lazadaGuidePresenter = LazadaGuidePresenter.this;
                    String str = miniAppParamsModel.PlaceComponentResult;
                    String obj2 = Uri.parse(str).buildUpon().appendQueryParameter("authCode", ((AuthCodeResult) obj).getAuthCode()).appendQueryParameter(UrlParam.REQUEST_ID, lazadaGuidePresenter.KClassImpl$Data$declaredNonStaticMembers$2.getDeviceUUID()).build().toString();
                    lazadaGuidePresenter.BuiltInFictitiousFunctionClassFactory.dismissProgress();
                    lazadaGuidePresenter.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(obj2);
                    return null;
                }
            }, new Function1() { // from class: id.dana.lazada.LazadaGuidePresenter$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    LazadaGuidePresenter lazadaGuidePresenter = LazadaGuidePresenter.this;
                    lazadaGuidePresenter.BuiltInFictitiousFunctionClassFactory.dismissProgress();
                    lazadaGuidePresenter.BuiltInFictitiousFunctionClassFactory.onError(((Throwable) obj).getMessage());
                    return null;
                }
            });
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(miniAppParamsModel.PlaceComponentResult);
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.PlaceComponentResult.dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.dispose();
        this.getAuthRequestContext.dispose();
        this.MyBillsEntityDataFactory.dispose();
    }
}
