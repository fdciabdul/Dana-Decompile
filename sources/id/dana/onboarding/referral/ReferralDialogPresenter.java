package id.dana.onboarding.referral;

import dagger.Lazy;
import id.dana.di.PerActivity;
import id.dana.domain.referral.interactor.CheckDialogDailyLimit;
import id.dana.domain.referral.interactor.GetReferralEngagementDialog;
import id.dana.domain.referral.interactor.SaveReferralDialogDailyLimit;
import id.dana.domain.referral.interactor.SaveReferralEngagementDialogCache;
import id.dana.domain.referral.model.ReferralEngagementDialog;
import id.dana.onboarding.referral.ReferralDialogContract;
import id.dana.onboarding.referral.mapper.ReferralEnagementDialogModelMapperKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001BO\b\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00150\r\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\r\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\r\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\r\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0006R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00120\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00140\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000fR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000f"}, d2 = {"Lid/dana/onboarding/referral/ReferralDialogPresenter;", "Lid/dana/onboarding/referral/ReferralDialogContract$Presenter;", "", "p0", "", "PlaceComponentResult", "(J)V", "onDestroy", "()V", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "getAuthRequestContext", "Ldagger/Lazy;", "Lid/dana/domain/referral/interactor/CheckDialogDailyLimit;", "Ldagger/Lazy;", "Lid/dana/domain/referral/interactor/GetReferralEngagementDialog;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/domain/referral/interactor/SaveReferralDialogDailyLimit;", "MyBillsEntityDataFactory", "Lid/dana/domain/referral/interactor/SaveReferralEngagementDialogCache;", "Lid/dana/onboarding/referral/ReferralDialogContract$View;", "p1", "p2", "p3", "p4", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes5.dex */
public final class ReferralDialogPresenter implements ReferralDialogContract.Presenter {
    private final Lazy<GetReferralEngagementDialog> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Lazy<CheckDialogDailyLimit> PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy<SaveReferralDialogDailyLimit> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Lazy<ReferralDialogContract.View> MyBillsEntityDataFactory;
    private final Lazy<SaveReferralEngagementDialogCache> getAuthRequestContext;

    @Inject
    public ReferralDialogPresenter(Lazy<ReferralDialogContract.View> lazy, Lazy<GetReferralEngagementDialog> lazy2, Lazy<SaveReferralEngagementDialogCache> lazy3, Lazy<SaveReferralDialogDailyLimit> lazy4, Lazy<CheckDialogDailyLimit> lazy5) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        Intrinsics.checkNotNullParameter(lazy4, "");
        Intrinsics.checkNotNullParameter(lazy5, "");
        this.MyBillsEntityDataFactory = lazy;
        this.BuiltInFictitiousFunctionClassFactory = lazy2;
        this.getAuthRequestContext = lazy3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy4;
        this.PlaceComponentResult = lazy5;
    }

    @Override // id.dana.onboarding.referral.ReferralDialogContract.Presenter
    public final void PlaceComponentResult(final long p0) {
        this.PlaceComponentResult.get().execute(new CheckDialogDailyLimit.Params(p0), new Function1<Boolean, Unit>() { // from class: id.dana.onboarding.referral.ReferralDialogPresenter$getDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                Lazy lazy;
                if (!z) {
                    lazy = ReferralDialogPresenter.this.MyBillsEntityDataFactory;
                    ((ReferralDialogContract.View) lazy.get()).getAuthRequestContext();
                    return;
                }
                r3.BuiltInFictitiousFunctionClassFactory.get().execute(new GetReferralEngagementDialog.Param(p0), new Function1<ReferralEngagementDialog, Unit>() { // from class: id.dana.onboarding.referral.ReferralDialogPresenter$getReferralDialog$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(ReferralEngagementDialog referralEngagementDialog) {
                        invoke2(referralEngagementDialog);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(ReferralEngagementDialog referralEngagementDialog) {
                        Lazy lazy2;
                        Intrinsics.checkNotNullParameter(referralEngagementDialog, "");
                        lazy2 = ReferralDialogPresenter.this.MyBillsEntityDataFactory;
                        ((ReferralDialogContract.View) lazy2.get()).MyBillsEntityDataFactory(ReferralEnagementDialogModelMapperKt.BuiltInFictitiousFunctionClassFactory(referralEngagementDialog));
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.onboarding.referral.ReferralDialogPresenter$getReferralDialog$2
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
                        Lazy lazy2;
                        Intrinsics.checkNotNullParameter(th, "");
                        String message = th.getMessage();
                        DanaLog.BuiltInFictitiousFunctionClassFactory("GetReferralEngagementDialog", message != null ? message : "", th);
                        lazy2 = ReferralDialogPresenter.this.MyBillsEntityDataFactory;
                        ((ReferralDialogContract.View) lazy2.get()).getAuthRequestContext();
                    }
                });
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.onboarding.referral.ReferralDialogPresenter$getDialog$2
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
                Lazy lazy;
                Intrinsics.checkNotNullParameter(th, "");
                String message = th.getMessage();
                DanaLog.BuiltInFictitiousFunctionClassFactory("CheckDialogDailyLimit", message != null ? message : "", th);
                lazy = ReferralDialogPresenter.this.MyBillsEntityDataFactory;
                ((ReferralDialogContract.View) lazy.get()).getAuthRequestContext();
            }
        });
    }

    @Override // id.dana.onboarding.referral.ReferralDialogContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getAuthRequestContext.get().execute(new SaveReferralEngagementDialogCache.Param(p0, false, 0L), new Function1<Boolean, Unit>() { // from class: id.dana.onboarding.referral.ReferralDialogPresenter$saveReferralEngagementDialogCache$1
            public final void invoke(boolean z) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.onboarding.referral.ReferralDialogPresenter$saveReferralEngagementDialogCache$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                String message = th.getMessage();
                DanaLog.BuiltInFictitiousFunctionClassFactory("SaveReferralEngagementDialogCache", message != null ? message : "", th);
            }
        });
    }

    @Override // id.dana.onboarding.referral.ReferralDialogContract.Presenter
    public final void getAuthRequestContext(long p0) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().execute(new SaveReferralDialogDailyLimit.Param(p0), new Function1<Boolean, Unit>() { // from class: id.dana.onboarding.referral.ReferralDialogPresenter$saveReferralEngagementDialogDailyLimit$1
            public final void invoke(boolean z) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.onboarding.referral.ReferralDialogPresenter$saveReferralEngagementDialogDailyLimit$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                String message = th.getMessage();
                DanaLog.BuiltInFictitiousFunctionClassFactory("SaveReferralDialogDailyLimit", message != null ? message : "", th);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.get().dispose();
        this.getAuthRequestContext.get().dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().dispose();
    }
}
