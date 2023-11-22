package id.dana.nearbyme.merchantdetail.viewcomponent;

import id.dana.domain.DefaultObserver;
import id.dana.domain.account.Account;
import id.dana.domain.account.interactor.GetAccount;
import id.dana.domain.nearbyme.interactor.GetMerchantReviewSummary;
import id.dana.domain.nearbyme.interactor.GetReviewCoachmark;
import id.dana.domain.nearbyme.interactor.SetReviewCoachmark;
import id.dana.domain.nearbyme.interactor.merchantreview.ConsultMerchantReview;
import id.dana.domain.nearbyme.interactor.merchantreview.GetReviewableMerchantForm;
import id.dana.domain.nearbyme.model.MerchantConsult;
import id.dana.domain.nearbyme.model.MerchantReviewSummary;
import id.dana.nearbyme.mapper.MerchantConsultReviewMapper;
import id.dana.nearbyme.merchantdetail.mapper.MerchantAverageRatingMapper;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingContract;
import id.dana.nearbyme.merchantreview.model.MerchantConsultReviewModel;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001BQ\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020$\u0012\u0006\u0010\b\u001a\u00020\u0011\u0012\u0006\u0010&\u001a\u00020\u0017\u0012\u0006\u0010'\u001a\u00020\u0013\u0012\u0006\u0010(\u001a\u00020\u0015\u0012\u0006\u0010)\u001a\u00020 \u0012\u0006\u0010*\u001a\u00020\u001a\u0012\u0006\u0010+\u001a\u00020\u001d\u0012\u0006\u0010,\u001a\u00020\u000f¢\u0006\u0004\b-\u0010.J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0005\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0004R\u0014\u0010\f\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0010R\u0014\u0010\r\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0014R\u0014\u0010\t\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0018\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0011\u0010!\u001a\u00020$X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010%"}, d2 = {"Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantAverageRatingPresenter;", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantAverageRatingContract$Presenter;", "", "MyBillsEntityDataFactory", "()V", "BuiltInFictitiousFunctionClassFactory", "", "p0", "p1", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;)V", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "onDestroy", "Lid/dana/domain/nearbyme/interactor/merchantreview/ConsultMerchantReview;", "Lid/dana/domain/nearbyme/interactor/merchantreview/ConsultMerchantReview;", "Lid/dana/domain/account/interactor/GetAccount;", "Lid/dana/domain/account/interactor/GetAccount;", "Lid/dana/domain/nearbyme/interactor/GetMerchantReviewSummary;", "Lid/dana/domain/nearbyme/interactor/GetMerchantReviewSummary;", "Lid/dana/domain/nearbyme/interactor/GetReviewCoachmark;", "Lid/dana/domain/nearbyme/interactor/GetReviewCoachmark;", "Lid/dana/domain/nearbyme/interactor/merchantreview/GetReviewableMerchantForm;", "lookAheadTest", "Lid/dana/domain/nearbyme/interactor/merchantreview/GetReviewableMerchantForm;", "Lid/dana/nearbyme/merchantdetail/mapper/MerchantAverageRatingMapper;", "moveToNextValue", "Lid/dana/nearbyme/merchantdetail/mapper/MerchantAverageRatingMapper;", "Lid/dana/nearbyme/mapper/MerchantConsultReviewMapper;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/nearbyme/mapper/MerchantConsultReviewMapper;", "Lid/dana/domain/nearbyme/interactor/SetReviewCoachmark;", "getErrorConfigVersion", "Lid/dana/domain/nearbyme/interactor/SetReviewCoachmark;", "scheduleImpl", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantAverageRatingContract$View;", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantAverageRatingContract$View;", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "<init>", "(Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantAverageRatingContract$View;Lid/dana/domain/account/interactor/GetAccount;Lid/dana/domain/nearbyme/interactor/merchantreview/GetReviewableMerchantForm;Lid/dana/domain/nearbyme/interactor/GetMerchantReviewSummary;Lid/dana/domain/nearbyme/interactor/GetReviewCoachmark;Lid/dana/domain/nearbyme/interactor/SetReviewCoachmark;Lid/dana/nearbyme/merchantdetail/mapper/MerchantAverageRatingMapper;Lid/dana/nearbyme/mapper/MerchantConsultReviewMapper;Lid/dana/domain/nearbyme/interactor/merchantreview/ConsultMerchantReview;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantAverageRatingPresenter implements MerchantAverageRatingContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final MerchantAverageRatingContract.View getErrorConfigVersion;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final GetMerchantReviewSummary MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final GetReviewCoachmark getAuthRequestContext;
    private final MerchantConsultReviewMapper NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final ConsultMerchantReview PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final GetAccount KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final SetReviewCoachmark scheduleImpl;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final GetReviewableMerchantForm BuiltInFictitiousFunctionClassFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final MerchantAverageRatingMapper lookAheadTest;

    @Inject
    public MerchantAverageRatingPresenter(MerchantAverageRatingContract.View view, GetAccount getAccount, GetReviewableMerchantForm getReviewableMerchantForm, GetMerchantReviewSummary getMerchantReviewSummary, GetReviewCoachmark getReviewCoachmark, SetReviewCoachmark setReviewCoachmark, MerchantAverageRatingMapper merchantAverageRatingMapper, MerchantConsultReviewMapper merchantConsultReviewMapper, ConsultMerchantReview consultMerchantReview) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getAccount, "");
        Intrinsics.checkNotNullParameter(getReviewableMerchantForm, "");
        Intrinsics.checkNotNullParameter(getMerchantReviewSummary, "");
        Intrinsics.checkNotNullParameter(getReviewCoachmark, "");
        Intrinsics.checkNotNullParameter(setReviewCoachmark, "");
        Intrinsics.checkNotNullParameter(merchantAverageRatingMapper, "");
        Intrinsics.checkNotNullParameter(merchantConsultReviewMapper, "");
        Intrinsics.checkNotNullParameter(consultMerchantReview, "");
        this.getErrorConfigVersion = view;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getAccount;
        this.BuiltInFictitiousFunctionClassFactory = getReviewableMerchantForm;
        this.MyBillsEntityDataFactory = getMerchantReviewSummary;
        this.getAuthRequestContext = getReviewCoachmark;
        this.scheduleImpl = setReviewCoachmark;
        this.lookAheadTest = merchantAverageRatingMapper;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = merchantConsultReviewMapper;
        this.PlaceComponentResult = consultMerchantReview;
    }

    @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingContract.Presenter
    public final void getAuthRequestContext(String p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.getErrorConfigVersion.showProgress();
        this.MyBillsEntityDataFactory.execute(new GetMerchantReviewSummary.Param(p0, p1), new Function1<MerchantReviewSummary, Unit>() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingPresenter$getMerchantAverageRating$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(MerchantReviewSummary merchantReviewSummary) {
                invoke2(merchantReviewSummary);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(MerchantReviewSummary merchantReviewSummary) {
                MerchantAverageRatingMapper unused;
                Intrinsics.checkNotNullParameter(merchantReviewSummary, "");
                MerchantAverageRatingContract.View view = MerchantAverageRatingPresenter.this.getErrorConfigVersion;
                unused = MerchantAverageRatingPresenter.this.lookAheadTest;
                view.BuiltInFictitiousFunctionClassFactory(MerchantAverageRatingMapper.KClassImpl$Data$declaredNonStaticMembers$2(merchantReviewSummary));
            }
        }, new Function1<Exception, Unit>() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingPresenter$getMerchantAverageRating$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Exception exc) {
                Intrinsics.checkNotNullParameter(exc, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.NEARBY_EXCEPTION, exc.getMessage(), exc);
                MerchantAverageRatingPresenter.this.getErrorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2();
            }
        });
    }

    @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.BuiltInFictitiousFunctionClassFactory.execute(new GetReviewableMerchantForm.Param(p0, true), new Function1<MerchantConsult, Unit>() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingPresenter$getMerchantReviewForm$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(MerchantConsult merchantConsult) {
                invoke2(merchantConsult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(MerchantConsult merchantConsult) {
                MerchantConsultReviewMapper merchantConsultReviewMapper;
                Intrinsics.checkNotNullParameter(merchantConsult, "");
                MerchantAverageRatingContract.View view = MerchantAverageRatingPresenter.this.getErrorConfigVersion;
                merchantConsultReviewMapper = MerchantAverageRatingPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                MerchantConsultReviewModel apply = merchantConsultReviewMapper.apply(merchantConsult);
                Intrinsics.checkNotNullExpressionValue(apply, "");
                view.KClassImpl$Data$declaredNonStaticMembers$2(apply);
            }
        }, new Function1<Exception, Unit>() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingPresenter$getMerchantReviewForm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Exception exc) {
                Intrinsics.checkNotNullParameter(exc, "");
                MerchantAverageRatingPresenter.this.getErrorConfigVersion.getAuthRequestContext();
            }
        });
    }

    @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.getAuthRequestContext.execute(Unit.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingPresenter$getUserReviewCoachmarkVisiblity$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                MerchantAverageRatingPresenter.this.getErrorConfigVersion.MyBillsEntityDataFactory(z);
            }
        }, new Function1<Exception, Unit>() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingPresenter$getUserReviewCoachmarkVisiblity$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Exception exc) {
                Intrinsics.checkNotNullParameter(exc, "");
                MerchantAverageRatingPresenter.this.getErrorConfigVersion.MyBillsEntityDataFactory(false);
            }
        });
    }

    @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.scheduleImpl.execute(new SetReviewCoachmark.Params(false), new Function1<Exception, Unit>() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingPresenter$disableUserReviewCoachmarkVisiblity$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Exception exc) {
                Intrinsics.checkNotNullParameter(exc, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.NEARBY_EXCEPTION, exc.getMessage(), exc);
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.MyBillsEntityDataFactory.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
        this.scheduleImpl.dispose();
        this.getAuthRequestContext.dispose();
    }

    @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.MyBillsEntityDataFactory.dispose();
        this.BuiltInFictitiousFunctionClassFactory.dispose();
    }

    @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingContract.Presenter
    public final void PlaceComponentResult() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.execute(new DefaultObserver<Account>() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingPresenter$getUserAccount$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                Account account = (Account) obj;
                Intrinsics.checkNotNullParameter(account, "");
                MerchantAverageRatingPresenter.this.getErrorConfigVersion.getAuthRequestContext(account);
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                MerchantAverageRatingPresenter.this.getErrorConfigVersion.getAuthRequestContext((Account) null);
            }
        });
    }

    @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingContract.Presenter
    public final void getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.PlaceComponentResult.execute(new ConsultMerchantReview.Param(p0, 0, 0, 6, null), new Function1<MerchantConsult, Unit>() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingPresenter$getMerchantConsult$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(MerchantConsult merchantConsult) {
                invoke2(merchantConsult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(MerchantConsult merchantConsult) {
                MerchantConsultReviewMapper merchantConsultReviewMapper;
                Intrinsics.checkNotNullParameter(merchantConsult, "");
                MerchantAverageRatingContract.View view = MerchantAverageRatingPresenter.this.getErrorConfigVersion;
                merchantConsultReviewMapper = MerchantAverageRatingPresenter.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                MerchantConsultReviewModel apply = merchantConsultReviewMapper.apply(merchantConsult);
                Intrinsics.checkNotNullExpressionValue(apply, "");
                view.getAuthRequestContext(apply);
            }
        }, new Function1<Exception, Unit>() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingPresenter$getMerchantConsult$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Exception exc) {
                Intrinsics.checkNotNullParameter(exc, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.NEARBY_EXCEPTION, exc.getMessage(), exc);
            }
        });
    }
}
