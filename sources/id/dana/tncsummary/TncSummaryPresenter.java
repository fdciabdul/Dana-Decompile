package id.dana.tncsummary;

import dagger.Lazy;
import id.dana.data.content.SpaceCode;
import id.dana.domain.DefaultObserver;
import id.dana.domain.tncsummary.interactor.GetSummaryTncConfigWithSpaceCode;
import id.dana.domain.tncsummary.model.TermsConditionsResponse;
import id.dana.domain.useragreement.interactor.ConsultAgreementOnlyParamSpaceCodes;
import id.dana.domain.useragreement.interactor.RecordAgreementOnlyAgreementKey;
import id.dana.domain.useragreement.model.ConsultAgreementResponse;
import id.dana.tncsummary.TncSummaryContract;
import id.dana.tncsummary.constant.UserConsentSplitConfigConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
public class TncSummaryPresenter implements TncSummaryContract.Presenter {
    private final Lazy<RecordAgreementOnlyAgreementKey> BuiltInFictitiousFunctionClassFactory;
    private final Lazy<GetSummaryTncConfigWithSpaceCode> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Lazy<ConsultAgreementOnlyParamSpaceCodes> PlaceComponentResult;
    final Lazy<TncSummaryContract.View> getAuthRequestContext;

    @Inject
    public TncSummaryPresenter(Lazy<TncSummaryContract.View> lazy, Lazy<GetSummaryTncConfigWithSpaceCode> lazy2, Lazy<ConsultAgreementOnlyParamSpaceCodes> lazy3, Lazy<RecordAgreementOnlyAgreementKey> lazy4) {
        this.getAuthRequestContext = lazy;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy2;
        this.PlaceComponentResult = lazy3;
        this.BuiltInFictitiousFunctionClassFactory = lazy4;
    }

    @Override // id.dana.tncsummary.TncSummaryContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().execute(new DefaultObserver<TermsConditionsResponse>() { // from class: id.dana.tncsummary.TncSummaryPresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                TermsConditionsResponse termsConditionsResponse = (TermsConditionsResponse) obj;
                if (termsConditionsResponse.getEnable() == null || termsConditionsResponse.getSpaceCode() == null || !termsConditionsResponse.getEnable().booleanValue()) {
                    ((TncSummaryContract.View) TncSummaryPresenter.this.getAuthRequestContext.get()).KClassImpl$Data$declaredNonStaticMembers$2(null);
                    return;
                }
                List<String> list = termsConditionsResponse.getSpaceCode().get(UserConsentSplitConfigConstant.TNC_FULL.getValue());
                if (list == null || list.isEmpty()) {
                    ((TncSummaryContract.View) TncSummaryPresenter.this.getAuthRequestContext.get()).KClassImpl$Data$declaredNonStaticMembers$2(null);
                } else {
                    TncSummaryPresenter.this.getAuthRequestContext(list);
                }
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                ((TncSummaryContract.View) TncSummaryPresenter.this.getAuthRequestContext.get()).KClassImpl$Data$declaredNonStaticMembers$2(null);
            }
        });
    }

    @Override // id.dana.tncsummary.TncSummaryContract.Presenter
    public final void getAuthRequestContext() {
        getAuthRequestContext(new ArrayList(Collections.singletonList(SpaceCode.KYB_TNC)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAuthRequestContext(List<String> list) {
        this.PlaceComponentResult.get().execute(new ConsultAgreementOnlyParamSpaceCodes.Params(list, null), new Function1() { // from class: id.dana.tncsummary.TncSummaryPresenter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                TncSummaryPresenter tncSummaryPresenter = TncSummaryPresenter.this;
                ConsultAgreementResponse consultAgreementResponse = (ConsultAgreementResponse) obj;
                if (consultAgreementResponse.getAgreementInfos() != null && consultAgreementResponse.getNeedUserAgreement()) {
                    tncSummaryPresenter.getAuthRequestContext.get().KClassImpl$Data$declaredNonStaticMembers$2(consultAgreementResponse.getAgreementInfos());
                } else {
                    tncSummaryPresenter.getAuthRequestContext.get().KClassImpl$Data$declaredNonStaticMembers$2(null);
                }
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.tncsummary.TncSummaryPresenter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Throwable th = (Throwable) obj;
                TncSummaryPresenter.this.getAuthRequestContext.get().KClassImpl$Data$declaredNonStaticMembers$2(null);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // id.dana.tncsummary.TncSummaryContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(List<String> list) {
        this.BuiltInFictitiousFunctionClassFactory.get().execute(new RecordAgreementOnlyAgreementKey.Params(list, true), new Function1() { // from class: id.dana.tncsummary.TncSummaryPresenter$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                TncSummaryPresenter.this.getAuthRequestContext.get().PlaceComponentResult(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }
        }, new Function1() { // from class: id.dana.tncsummary.TncSummaryPresenter$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Throwable th = (Throwable) obj;
                TncSummaryPresenter.this.getAuthRequestContext.get().PlaceComponentResult(false);
                return Unit.INSTANCE;
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().dispose();
        this.PlaceComponentResult.get().dispose();
        this.BuiltInFictitiousFunctionClassFactory.get().dispose();
    }
}
