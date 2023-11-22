package id.dana.twilio.identityverification;

import android.content.Context;
import com.google.common.net.HttpHeaders;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContractKt;
import id.dana.domain.twilio.interactor.GetTwilioChallengeDetails;
import id.dana.domain.twilio.interactor.IsTwilioForceLogout;
import id.dana.domain.twilio.interactor.UpdateTwilioChallenge;
import id.dana.pushverify.constant.PushVerifyConstants;
import id.dana.twilio.identityverification.TwilioIdentityVerificationContract;
import id.dana.twilio.tracker.TwilioMixpanelTracker;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 (2\u00020\u0001:\u0001(B9\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0015\u0012\u0006\u0010\u0004\u001a\u00020\"\u0012\u0006\u0010\t\u001a\u00020\u0018\u0012\u0006\u0010\u0011\u001a\u00020 \u0012\u0006\u0010\u0012\u001a\u00020\u001a\u0012\u0006\u0010%\u001a\u00020\u001d¢\u0006\u0004\b&\u0010'J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J9\u0010\u0006\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0016R\u0014\u0010\u0006\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0019R\u0014\u0010\u000f\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001eR\u0014\u0010\u000b\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010!R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010#"}, d2 = {"Lid/dana/twilio/identityverification/TwilioIdentityVerificationPresenter;", "Lid/dana/twilio/identityverification/TwilioIdentityVerificationContract$Presenter;", "", "p0", "p1", "Lid/dana/domain/twilio/interactor/GetTwilioChallengeDetails$Param;", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/twilio/interactor/GetTwilioChallengeDetails$Param;", "", "p2", "Lid/dana/domain/twilio/interactor/UpdateTwilioChallenge$Param;", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;Z)Lid/dana/domain/twilio/interactor/UpdateTwilioChallenge$Param;", "Ljava/util/Date;", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/Date;I)Z", "p3", "p4", "", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/content/Context;", "Landroid/content/Context;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/domain/twilio/interactor/GetTwilioChallengeDetails;", "Lid/dana/domain/twilio/interactor/GetTwilioChallengeDetails;", "Lid/dana/domain/twilio/interactor/IsTwilioForceLogout;", "lookAheadTest", "Lid/dana/domain/twilio/interactor/IsTwilioForceLogout;", "Lid/dana/twilio/tracker/TwilioMixpanelTracker;", "Lid/dana/twilio/tracker/TwilioMixpanelTracker;", "PlaceComponentResult", "Lid/dana/domain/twilio/interactor/UpdateTwilioChallenge;", "Lid/dana/domain/twilio/interactor/UpdateTwilioChallenge;", "Lid/dana/twilio/identityverification/TwilioIdentityVerificationContract$View;", "Lid/dana/twilio/identityverification/TwilioIdentityVerificationContract$View;", "moveToNextValue", "p5", "<init>", "(Landroid/content/Context;Lid/dana/twilio/identityverification/TwilioIdentityVerificationContract$View;Lid/dana/domain/twilio/interactor/GetTwilioChallengeDetails;Lid/dana/domain/twilio/interactor/UpdateTwilioChallenge;Lid/dana/domain/twilio/interactor/IsTwilioForceLogout;Lid/dana/twilio/tracker/TwilioMixpanelTracker;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TwilioIdentityVerificationPresenter implements TwilioIdentityVerificationContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final TwilioIdentityVerificationContract.View moveToNextValue;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final TwilioMixpanelTracker PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final UpdateTwilioChallenge getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final GetTwilioChallengeDetails MyBillsEntityDataFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final IsTwilioForceLogout BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final /* synthetic */ void onDestroy() {
        AbstractContractKt.AbstractPresenter.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Inject
    public TwilioIdentityVerificationPresenter(Context context, TwilioIdentityVerificationContract.View view, GetTwilioChallengeDetails getTwilioChallengeDetails, UpdateTwilioChallenge updateTwilioChallenge, IsTwilioForceLogout isTwilioForceLogout, TwilioMixpanelTracker twilioMixpanelTracker) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getTwilioChallengeDetails, "");
        Intrinsics.checkNotNullParameter(updateTwilioChallenge, "");
        Intrinsics.checkNotNullParameter(isTwilioForceLogout, "");
        Intrinsics.checkNotNullParameter(twilioMixpanelTracker, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.moveToNextValue = view;
        this.MyBillsEntityDataFactory = getTwilioChallengeDetails;
        this.getAuthRequestContext = updateTwilioChallenge;
        this.BuiltInFictitiousFunctionClassFactory = isTwilioForceLogout;
        this.PlaceComponentResult = twilioMixpanelTracker;
    }

    public final void MyBillsEntityDataFactory(boolean p0, String p1, String p2, String p3, String p4) {
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        this.PlaceComponentResult.MyBillsEntityDataFactory(Intrinsics.areEqual(p1, TwilioIdentityVerificationActivity.VERIFICATION_TYPE_IPG_BINDING) ? TrackerKey.SourceType.ACCOUNT_LINKING : "Login", p2, p0 ? HttpHeaders.ACCEPT : PushVerifyConstants.REJECT, p3, p4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GetTwilioChallengeDetails.Param MyBillsEntityDataFactory(String p0, String p1) {
        return new GetTwilioChallengeDetails.Param(p0, p1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static UpdateTwilioChallenge.Param getAuthRequestContext(String p0, String p1, boolean p2) {
        return new UpdateTwilioChallenge.Param(p0, p1, p2 ? "approved" : "denied");
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(Date p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        long time = (p0.getTime() + TimeUnit.MILLISECONDS.convert(p1, TimeUnit.SECONDS)) - System.currentTimeMillis();
        this.moveToNextValue.BuiltInFictitiousFunctionClassFactory(time);
        return time <= 0;
    }
}
