package id.dana.ipg;

import id.dana.contract.deeplink.path.IpgRegistrationPayload;
import id.dana.domain.DefaultObserver;
import id.dana.domain.ipg.IpgRegistrationUrl;
import id.dana.domain.ipg.interactor.GetIpgClickedAgree;
import id.dana.domain.ipg.interactor.GetIpgRegistrationUrl;
import id.dana.domain.ipg.interactor.SaveIpgClickedAgree;
import id.dana.ipg.IpgGuideContract;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0019\u0012\u0006\u0010\n\u001a\u00020\u0013\u0012\u0006\u0010\u001b\u001a\u00020\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u0011¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u000f\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0014R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u000b\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0018R\u0011\u0010\b\u001a\u00020\u0019X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u001a"}, d2 = {"Lid/dana/ipg/IpgGuidePresenter;", "Lid/dana/ipg/IpgGuideContract$Presenter;", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)V", "Lid/dana/contract/deeplink/path/IpgRegistrationPayload;", "getAuthRequestContext", "()Lid/dana/contract/deeplink/path/IpgRegistrationPayload;", "p1", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;)V", "onDestroy", "()V", "PlaceComponentResult", "(Lid/dana/contract/deeplink/path/IpgRegistrationPayload;)V", "Lid/dana/domain/ipg/interactor/GetIpgRegistrationUrl;", "Lid/dana/domain/ipg/interactor/GetIpgRegistrationUrl;", "Lid/dana/domain/ipg/interactor/GetIpgClickedAgree;", "Lid/dana/domain/ipg/interactor/GetIpgClickedAgree;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/contract/deeplink/path/IpgRegistrationPayload;", "Lid/dana/domain/ipg/interactor/SaveIpgClickedAgree;", "Lid/dana/domain/ipg/interactor/SaveIpgClickedAgree;", "Lid/dana/ipg/IpgGuideContract$View;", "Lid/dana/ipg/IpgGuideContract$View;", "p2", "p3", "<init>", "(Lid/dana/ipg/IpgGuideContract$View;Lid/dana/domain/ipg/interactor/GetIpgClickedAgree;Lid/dana/domain/ipg/interactor/SaveIpgClickedAgree;Lid/dana/domain/ipg/interactor/GetIpgRegistrationUrl;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class IpgGuidePresenter implements IpgGuideContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final IpgGuideContract.View getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private IpgRegistrationPayload BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final GetIpgClickedAgree KClassImpl$Data$declaredNonStaticMembers$2;
    private final GetIpgRegistrationUrl PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final SaveIpgClickedAgree MyBillsEntityDataFactory;

    @Inject
    public IpgGuidePresenter(IpgGuideContract.View view, GetIpgClickedAgree getIpgClickedAgree, SaveIpgClickedAgree saveIpgClickedAgree, GetIpgRegistrationUrl getIpgRegistrationUrl) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getIpgClickedAgree, "");
        Intrinsics.checkNotNullParameter(saveIpgClickedAgree, "");
        Intrinsics.checkNotNullParameter(getIpgRegistrationUrl, "");
        this.getAuthRequestContext = view;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getIpgClickedAgree;
        this.MyBillsEntityDataFactory = saveIpgClickedAgree;
        this.PlaceComponentResult = getIpgRegistrationUrl;
    }

    @Override // id.dana.ipg.IpgGuideContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getAuthRequestContext.showProgress();
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(new DefaultObserver<Boolean>() { // from class: id.dana.ipg.IpgGuidePresenter$checkHasAgreedToTncBefore$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                boolean booleanValue = ((Boolean) obj).booleanValue();
                IpgGuidePresenter.this.getAuthRequestContext.dismissProgress();
                IpgGuidePresenter.this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(booleanValue);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                Intrinsics.checkNotNullParameter(p02, "");
                super.onError(p02);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.IPG_REGISTRATION_TAG, String.valueOf(p02.getMessage()), p02);
                IpgGuidePresenter.this.getAuthRequestContext.dismissProgress();
                IpgGuidePresenter.this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(false);
            }
        }, new GetIpgClickedAgree.Params(p0));
    }

    @Override // id.dana.ipg.IpgGuideContract.Presenter
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final IpgRegistrationPayload getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.ipg.IpgGuideContract.Presenter
    public final void PlaceComponentResult(IpgRegistrationPayload p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.BuiltInFictitiousFunctionClassFactory = p0;
    }

    @Override // id.dana.ipg.IpgGuideContract.Presenter
    public final void getAuthRequestContext(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.MyBillsEntityDataFactory.execute(new DefaultObserver<Boolean>() { // from class: id.dana.ipg.IpgGuidePresenter$saveAgreeToTnc$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                super.onNext(Boolean.valueOf(((Boolean) obj).booleanValue()));
                IpgGuideContract.View view = IpgGuidePresenter.this.getAuthRequestContext;
            }
        }, new SaveIpgClickedAgree.Params(p0, p1));
    }

    @Override // id.dana.ipg.IpgGuideContract.Presenter
    public final void MyBillsEntityDataFactory(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.getAuthRequestContext.showProgress();
        this.PlaceComponentResult.execute(new DefaultObserver<IpgRegistrationUrl>() { // from class: id.dana.ipg.IpgGuidePresenter$getRedirectUrlForIpgRegistration$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                IpgRegistrationUrl ipgRegistrationUrl = (IpgRegistrationUrl) obj;
                Intrinsics.checkNotNullParameter(ipgRegistrationUrl, "");
                IpgGuidePresenter.this.getAuthRequestContext.dismissProgress();
                IpgGuidePresenter.this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(ipgRegistrationUrl);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p02) {
                Intrinsics.checkNotNullParameter(p02, "");
                super.onError(p02);
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.IPG_REGISTRATION_TAG, String.valueOf(p02.getMessage()), p02);
                IpgGuidePresenter.this.getAuthRequestContext.dismissProgress();
                IpgGuidePresenter.this.getAuthRequestContext.PlaceComponentResult();
            }
        }, new GetIpgRegistrationUrl.Params(p0, p1));
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.MyBillsEntityDataFactory.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.PlaceComponentResult.dispose();
    }
}
