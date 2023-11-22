package id.dana.cancelsurvey.presenter;

import android.content.Context;
import id.dana.R;
import id.dana.cancelsurvey.mapper.CancelSurveyPresenterMapperKt;
import id.dana.cancelsurvey.model.BottomSheetCancelReasonModel;
import id.dana.cancelsurvey.model.CancelReasonModel;
import id.dana.cancelsurvey.presenter.CancelSurveyContract;
import id.dana.domain.cancelsurvey.interactor.ConsultCancelSurveyReason;
import id.dana.domain.cancelsurvey.interactor.SubmitCancelSurveyReason;
import id.dana.domain.cancelsurvey.model.CancellationSurveyReason;
import id.dana.utils.ResourceUtils;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\f\u0012\u0006\u0010\u0018\u001a\u00020\u0012¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u0002*\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\n\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\r\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0010\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/cancelsurvey/presenter/CancelSurveyPresenter;", "Lid/dana/cancelsurvey/presenter/CancelSurveyContract$Presenter;", "", "p0", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;)V", "onDestroy", "()V", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Ljava/lang/String;", "Lid/dana/domain/cancelsurvey/interactor/ConsultCancelSurveyReason;", "getAuthRequestContext", "Lid/dana/domain/cancelsurvey/interactor/ConsultCancelSurveyReason;", "Landroid/content/Context;", "PlaceComponentResult", "Landroid/content/Context;", "Lid/dana/domain/cancelsurvey/interactor/SubmitCancelSurveyReason;", "Lid/dana/domain/cancelsurvey/interactor/SubmitCancelSurveyReason;", "Lid/dana/cancelsurvey/presenter/CancelSurveyContract$View;", "MyBillsEntityDataFactory", "Lid/dana/cancelsurvey/presenter/CancelSurveyContract$View;", "p2", "p3", "<init>", "(Landroid/content/Context;Lid/dana/cancelsurvey/presenter/CancelSurveyContract$View;Lid/dana/domain/cancelsurvey/interactor/ConsultCancelSurveyReason;Lid/dana/domain/cancelsurvey/interactor/SubmitCancelSurveyReason;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CancelSurveyPresenter implements CancelSurveyContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final SubmitCancelSurveyReason PlaceComponentResult;
    public final CancelSurveyContract.View MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Context getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final ConsultCancelSurveyReason BuiltInFictitiousFunctionClassFactory;

    @Inject
    public CancelSurveyPresenter(Context context, CancelSurveyContract.View view, ConsultCancelSurveyReason consultCancelSurveyReason, SubmitCancelSurveyReason submitCancelSurveyReason) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(consultCancelSurveyReason, "");
        Intrinsics.checkNotNullParameter(submitCancelSurveyReason, "");
        this.getAuthRequestContext = context;
        this.MyBillsEntityDataFactory = view;
        this.BuiltInFictitiousFunctionClassFactory = consultCancelSurveyReason;
        this.PlaceComponentResult = submitCancelSurveyReason;
    }

    @Override // id.dana.cancelsurvey.presenter.CancelSurveyContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(final String p0, final String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        this.BuiltInFictitiousFunctionClassFactory.execute(ConsultCancelSurveyReason.Params.INSTANCE.createParamsFromExpressPurchase(p0, p1), new Function1<CancellationSurveyReason, Unit>() { // from class: id.dana.cancelsurvey.presenter.CancelSurveyPresenter$consultCancelSurvey$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CancellationSurveyReason cancellationSurveyReason) {
                invoke2(cancellationSurveyReason);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CancellationSurveyReason cancellationSurveyReason) {
                CancelSurveyContract.View view;
                CancelSurveyContract.View view2;
                Intrinsics.checkNotNullParameter(cancellationSurveyReason, "");
                if (!cancellationSurveyReason.getEnable()) {
                    view = CancelSurveyPresenter.this.MyBillsEntityDataFactory;
                    view.MyBillsEntityDataFactory();
                    return;
                }
                List authRequestContext = CancelSurveyPresenter.getAuthRequestContext(CancelSurveyPresenter.this, cancellationSurveyReason);
                view2 = CancelSurveyPresenter.this.MyBillsEntityDataFactory;
                view2.KClassImpl$Data$declaredNonStaticMembers$2(CancelSurveyPresenter.getAuthRequestContext(CancelSurveyPresenter.this, p0, p1, cancellationSurveyReason, authRequestContext));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.cancelsurvey.presenter.CancelSurveyPresenter$consultCancelSurvey$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                CancelSurveyContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.CANCEL_SURVEY_PRESENTER, th.getLocalizedMessage());
                view = CancelSurveyPresenter.this.MyBillsEntityDataFactory;
                view.MyBillsEntityDataFactory();
            }
        });
    }

    private final String BuiltInFictitiousFunctionClassFactory(String str) {
        Context context = this.getAuthRequestContext;
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        return ResourceUtils.PlaceComponentResult(context, lowerCase, str);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
        this.PlaceComponentResult.dispose();
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(CancelSurveyPresenter cancelSurveyPresenter, CancelReasonModel cancelReasonModel) {
        if (Intrinsics.areEqual(cancelReasonModel.PlaceComponentResult, cancelSurveyPresenter.getAuthRequestContext.getString(R.string.cancel_survey_others))) {
            String string = cancelSurveyPresenter.getAuthRequestContext.getString(R.string.cancel_survey_other_prefix_reason_code_with_dynamic_reason, cancelReasonModel.KClassImpl$Data$declaredNonStaticMembers$2);
            Intrinsics.checkNotNullExpressionValue(string, "");
            Intrinsics.checkNotNullParameter(string, "");
            cancelReasonModel.KClassImpl$Data$declaredNonStaticMembers$2 = string;
        }
    }

    public static final /* synthetic */ BottomSheetCancelReasonModel getAuthRequestContext(CancelSurveyPresenter cancelSurveyPresenter, String str, String str2, CancellationSurveyReason cancellationSurveyReason, List list) {
        String BuiltInFictitiousFunctionClassFactory = cancelSurveyPresenter.BuiltInFictitiousFunctionClassFactory(cancellationSurveyReason.getHeaderLabel());
        List unmodifiableList = Collections.unmodifiableList(list);
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "");
        return new BottomSheetCancelReasonModel(str, str2, BuiltInFictitiousFunctionClassFactory, unmodifiableList, cancelSurveyPresenter.BuiltInFictitiousFunctionClassFactory(cancellationSurveyReason.getCtaLabel()));
    }

    public static final /* synthetic */ List getAuthRequestContext(CancelSurveyPresenter cancelSurveyPresenter, CancellationSurveyReason cancellationSurveyReason) {
        List<CancelReasonModel> MyBillsEntityDataFactory = CancelSurveyPresenterMapperKt.MyBillsEntityDataFactory(cancellationSurveyReason.getReasons());
        String string = cancelSurveyPresenter.getAuthRequestContext.getString(R.string.cancel_survey_others);
        Intrinsics.checkNotNullExpressionValue(string, "");
        MyBillsEntityDataFactory.add(new CancelReasonModel("", string, false, true, 4, null));
        return MyBillsEntityDataFactory;
    }
}
