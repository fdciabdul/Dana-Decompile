package id.dana.onboarding.citcall;

import android.content.Context;
import id.dana.domain.citcall.interactor.GetCitcallOtp;
import id.dana.domain.citcall.interactor.GetCitcallPermissionUseCase;
import id.dana.domain.citcall.model.MiscallConsult;
import id.dana.domain.citcall.model.MiscallResponse;
import id.dana.onboarding.citcall.CitCallContract;
import id.dana.onboarding.citcall.tracker.CitCallTracker;
import id.dana.onboarding.citcall.tracker.CitCallTrackerImpl;
import id.dana.tracker.EventTracker;
import id.dana.tracker.model.TrackOtpModel;
import id.dana.utils.tracker.mixpanel.MixpanelValueUtil;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B1\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\n\u0012\u0006\u0010\u0016\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0014"}, d2 = {"Lid/dana/onboarding/citcall/CitCallPresenter;", "Lid/dana/onboarding/citcall/CitCallContract$Presenter;", "Lid/dana/onboarding/citcall/tracker/CitCallTracker;", "Lid/dana/domain/citcall/model/MiscallConsult;", "p0", "", "PlaceComponentResult", "(Lid/dana/domain/citcall/model/MiscallConsult;)V", "onDestroy", "()V", "Lid/dana/domain/citcall/interactor/GetCitcallOtp;", "Lid/dana/domain/citcall/interactor/GetCitcallOtp;", "getAuthRequestContext", "Lid/dana/domain/citcall/interactor/GetCitcallPermissionUseCase;", "Lid/dana/domain/citcall/interactor/GetCitcallPermissionUseCase;", "MyBillsEntityDataFactory", "Lid/dana/tracker/model/TrackOtpModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/tracker/model/TrackOtpModel;", "Lid/dana/onboarding/citcall/CitCallContract$View;", "Lid/dana/onboarding/citcall/CitCallContract$View;", "p1", "p2", "Landroid/content/Context;", "p3", "Lid/dana/onboarding/citcall/tracker/CitCallTrackerImpl;", "p4", "<init>", "(Lid/dana/onboarding/citcall/CitCallContract$View;Lid/dana/domain/citcall/interactor/GetCitcallOtp;Lid/dana/domain/citcall/interactor/GetCitcallPermissionUseCase;Landroid/content/Context;Lid/dana/onboarding/citcall/tracker/CitCallTrackerImpl;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CitCallPresenter implements CitCallContract.Presenter, CitCallTracker {
    final /* synthetic */ CitCallTrackerImpl BuiltInFictitiousFunctionClassFactory;
    private final TrackOtpModel KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final CitCallContract.View PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final GetCitcallOtp getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final GetCitcallPermissionUseCase MyBillsEntityDataFactory;

    @Inject
    public CitCallPresenter(CitCallContract.View view, GetCitcallOtp getCitcallOtp, GetCitcallPermissionUseCase getCitcallPermissionUseCase, Context context, CitCallTrackerImpl citCallTrackerImpl) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getCitcallOtp, "");
        Intrinsics.checkNotNullParameter(getCitcallPermissionUseCase, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(citCallTrackerImpl, "");
        this.PlaceComponentResult = view;
        this.getAuthRequestContext = getCitcallOtp;
        this.MyBillsEntityDataFactory = getCitcallPermissionUseCase;
        this.BuiltInFictitiousFunctionClassFactory = citCallTrackerImpl;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new TrackOtpModel(context, "Registration");
    }

    public final void PlaceComponentResult(MiscallConsult p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.PlaceComponentResult.showProgress();
        this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
        this.getAuthRequestContext.execute(new GetCitcallOtp.Param(p0), new Function1<MiscallResponse, Unit>() { // from class: id.dana.onboarding.citcall.CitCallPresenter$getCitCall$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(MiscallResponse miscallResponse) {
                invoke2(miscallResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(MiscallResponse miscallResponse) {
                CitCallContract.View view;
                CitCallContract.View view2;
                TrackOtpModel trackOtpModel;
                Intrinsics.checkNotNullParameter(miscallResponse, "");
                view = CitCallPresenter.this.PlaceComponentResult;
                view.dismissProgress();
                view2 = CitCallPresenter.this.PlaceComponentResult;
                view2.PlaceComponentResult(miscallResponse);
                CitCallPresenter.this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
                trackOtpModel = CitCallPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                EventTracker.PlaceComponentResult(trackOtpModel.BuiltInFictitiousFunctionClassFactory(MixpanelValueUtil.getAuthRequestContext("Misscall"), null));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.onboarding.citcall.CitCallPresenter$getCitCall$2
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
                CitCallContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = CitCallPresenter.this.PlaceComponentResult;
                view.dismissProgress();
                CitCallPresenter.BuiltInFictitiousFunctionClassFactory(CitCallPresenter.this, th);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.getAuthRequestContext.dispose();
        this.MyBillsEntityDataFactory.dispose();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001a, code lost:
    
        if (r0.equals("AE15101858018087") == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0036, code lost:
    
        if (r0.equals(id.dana.riskChallenges.ui.missedCallOtp.CitCallErrorCode.MAX_ATTEMPTS_REACHED) != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
    
        r10.PlaceComponentResult.MyBillsEntityDataFactory();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003d, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(id.dana.onboarding.citcall.CitCallPresenter r10, java.lang.Throwable r11) {
        /*
            boolean r0 = r11 instanceof id.dana.network.exception.NetworkException
            if (r0 == 0) goto L85
            id.dana.network.exception.NetworkException r11 = (id.dana.network.exception.NetworkException) r11
            java.lang.String r0 = r11.getErrorCode()
            if (r0 == 0) goto L7a
            int r1 = r0.hashCode()
            switch(r1) {
                case -1728217259: goto L3e;
                case -1728187469: goto L30;
                case -1728187442: goto L1d;
                case 408588713: goto L14;
                default: goto L13;
            }
        L13:
            goto L7a
        L14:
            java.lang.String r11 = "AE15101858018087"
            boolean r11 = r0.equals(r11)
            if (r11 != 0) goto L38
            goto L7a
        L1d:
            java.lang.String r11 = "AE15112158352730"
            boolean r11 = r0.equals(r11)
            if (r11 == 0) goto L7a
            id.dana.onboarding.citcall.CitCallContract$View r11 = r10.PlaceComponentResult
            r11.KClassImpl$Data$declaredNonStaticMembers$2()
            id.dana.onboarding.citcall.tracker.CitCallTrackerImpl r10 = r10.BuiltInFictitiousFunctionClassFactory
            r10.getAuthRequestContext()
            return
        L30:
            java.lang.String r11 = "AE15112158352724"
            boolean r11 = r0.equals(r11)
            if (r11 == 0) goto L7a
        L38:
            id.dana.onboarding.citcall.CitCallContract$View r10 = r10.PlaceComponentResult
            r10.MyBillsEntityDataFactory()
            return
        L3e:
            java.lang.String r1 = "AE15112158351725"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L7a
            id.dana.onboarding.citcall.CitCallContract$View r0 = r10.PlaceComponentResult
            java.lang.String r2 = r11.getCitcallPrefix()
            int r1 = r11.getCitcallCurrentAttempts()
            int r3 = r11.getCitcallRemainingAttempts()
            int r11 = r11.getTimeUntilNextAttempt()
            id.dana.domain.citcall.model.MiscallResponse r9 = new id.dana.domain.citcall.model.MiscallResponse
            java.lang.Integer r4 = java.lang.Integer.valueOf(r1)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r6 = 0
            r7 = 16
            r8 = 0
            r1 = r9
            r3 = r4
            r4 = r5
            r5 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            r0.PlaceComponentResult(r9)
            id.dana.onboarding.citcall.tracker.CitCallTrackerImpl r10 = r10.BuiltInFictitiousFunctionClassFactory
            r10.PlaceComponentResult()
            return
        L7a:
            id.dana.onboarding.citcall.CitCallContract$View r11 = r10.PlaceComponentResult
            r11.getAuthRequestContext()
            id.dana.onboarding.citcall.tracker.CitCallTrackerImpl r10 = r10.BuiltInFictitiousFunctionClassFactory
            r10.getAuthRequestContext()
            return
        L85:
            id.dana.onboarding.citcall.CitCallContract$View r11 = r10.PlaceComponentResult
            r11.getAuthRequestContext()
            id.dana.onboarding.citcall.tracker.CitCallTrackerImpl r10 = r10.BuiltInFictitiousFunctionClassFactory
            r10.getAuthRequestContext()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.onboarding.citcall.CitCallPresenter.BuiltInFictitiousFunctionClassFactory(id.dana.onboarding.citcall.CitCallPresenter, java.lang.Throwable):void");
    }
}
