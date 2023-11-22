package id.dana.animation;

import id.dana.DanaApplication;
import id.dana.animation.view.OnboardingState;
import java.util.HashSet;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0013¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0007J\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\t\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\t\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000fR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0012R\u0014\u0010\b\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u0016"}, d2 = {"Lid/dana/home/OnboardingOrchestrator;", "", "Lid/dana/home/view/OnboardingState;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/home/view/OnboardingState;)Z", "()Z", "MyBillsEntityDataFactory", "getAuthRequestContext", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "(Lid/dana/home/view/OnboardingState;)V", "Lid/dana/DanaApplication;", "Lid/dana/DanaApplication;", "PlaceComponentResult", "Ljava/util/HashSet;", "Ljava/util/HashSet;", "Lid/dana/home/OnboardingEvent;", "Lid/dana/home/OnboardingEvent;", "Ljava/util/LinkedList;", "Ljava/util/LinkedList;", "p1", "<init>", "(Lid/dana/DanaApplication;Lid/dana/home/OnboardingEvent;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OnboardingOrchestrator {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final OnboardingEvent MyBillsEntityDataFactory;
    private final HashSet<OnboardingState> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public LinkedList<OnboardingState> getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final DanaApplication PlaceComponentResult;

    public OnboardingOrchestrator(DanaApplication danaApplication, OnboardingEvent onboardingEvent) {
        Intrinsics.checkNotNullParameter(danaApplication, "");
        Intrinsics.checkNotNullParameter(onboardingEvent, "");
        this.PlaceComponentResult = danaApplication;
        this.MyBillsEntityDataFactory = onboardingEvent;
        LinkedList<OnboardingState> linkedList = new LinkedList<>();
        linkedList.addLast(OnboardingState.PinRegularChangesStep.INSTANCE);
        linkedList.addLast(OnboardingState.TncStep.INSTANCE);
        linkedList.addLast(OnboardingState.TiramisuPushNotificationStep.INSTANCE);
        linkedList.addLast(OnboardingState.PaymentSettingStep.INSTANCE);
        linkedList.addLast(OnboardingState.KycRenewalStep.INSTANCE);
        linkedList.addLast(OnboardingState.EddStep.INSTANCE);
        linkedList.addLast(OnboardingState.NormalTooltipStep.INSTANCE);
        linkedList.addLast(OnboardingState.WalletMenuTooltipStep.INSTANCE);
        linkedList.addLast(OnboardingState.LocationPermissionPromptStep.INSTANCE);
        linkedList.addLast(OnboardingState.QcbOnboardingStep.INSTANCE);
        linkedList.addLast(OnboardingState.InterstitialStep.INSTANCE);
        linkedList.addLast(OnboardingState.UgcStep.INSTANCE);
        linkedList.addLast(OnboardingState.ReferralEngagementStep.INSTANCE);
        linkedList.addLast(OnboardingState.RequestUserPermissionStep.INSTANCE);
        this.getAuthRequestContext = linkedList;
        HashSet<OnboardingState> hashSet = new HashSet<>();
        hashSet.add(OnboardingState.PinRegularChangesStep.INSTANCE);
        hashSet.add(OnboardingState.TncStep.INSTANCE);
        hashSet.add(OnboardingState.TiramisuPushNotificationStep.INSTANCE);
        hashSet.add(OnboardingState.KycRenewalStep.INSTANCE);
        hashSet.add(OnboardingState.PaymentSettingStep.INSTANCE);
        hashSet.add(OnboardingState.EddStep.INSTANCE);
        hashSet.add(OnboardingState.ReferralEngagementStep.INSTANCE);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = hashSet;
    }

    private final boolean getAuthRequestContext() {
        return this.PlaceComponentResult.isWarmStart();
    }

    private final boolean MyBillsEntityDataFactory() {
        return this.PlaceComponentResult.isWarmHomeDialogEnable();
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        OnboardingState pollFirst = this.getAuthRequestContext.pollFirst();
        if (pollFirst != null) {
            if (!MyBillsEntityDataFactory() || getAuthRequestContext() || BuiltInFictitiousFunctionClassFactory(pollFirst)) {
                getAuthRequestContext(pollFirst);
            }
        }
    }

    private void getAuthRequestContext(OnboardingState p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (Intrinsics.areEqual(p0, OnboardingState.PinRegularChangesStep.INSTANCE)) {
            this.MyBillsEntityDataFactory.lookAheadTest();
        } else if (Intrinsics.areEqual(p0, OnboardingState.TncStep.INSTANCE)) {
            this.MyBillsEntityDataFactory.DatabaseTableConfigUtil();
        } else if (Intrinsics.areEqual(p0, OnboardingState.TiramisuPushNotificationStep.INSTANCE)) {
            this.MyBillsEntityDataFactory.GetContactSyncConfig();
        } else if (Intrinsics.areEqual(p0, OnboardingState.PaymentSettingStep.INSTANCE)) {
            this.MyBillsEntityDataFactory.moveToNextValue();
        } else if (Intrinsics.areEqual(p0, OnboardingState.KycRenewalStep.INSTANCE)) {
            this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
        } else if (Intrinsics.areEqual(p0, OnboardingState.EddStep.INSTANCE)) {
            this.MyBillsEntityDataFactory.getAuthRequestContext();
        } else if (Intrinsics.areEqual(p0, OnboardingState.NormalTooltipStep.INSTANCE)) {
            this.MyBillsEntityDataFactory.PlaceComponentResult();
        } else if (Intrinsics.areEqual(p0, OnboardingState.WalletMenuTooltipStep.INSTANCE)) {
            this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2();
        } else if (Intrinsics.areEqual(p0, OnboardingState.LocationPermissionPromptStep.INSTANCE)) {
            this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
        } else if (Intrinsics.areEqual(p0, OnboardingState.QcbOnboardingStep.INSTANCE)) {
            this.MyBillsEntityDataFactory.scheduleImpl();
        } else if (Intrinsics.areEqual(p0, OnboardingState.InterstitialStep.INSTANCE)) {
            this.MyBillsEntityDataFactory.MyBillsEntityDataFactory();
        } else if (Intrinsics.areEqual(p0, OnboardingState.UgcStep.INSTANCE)) {
            this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1();
        } else if (Intrinsics.areEqual(p0, OnboardingState.ReferralEngagementStep.INSTANCE)) {
            this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0();
        } else if (Intrinsics.areEqual(p0, OnboardingState.RequestUserPermissionStep.INSTANCE)) {
            this.MyBillsEntityDataFactory.getErrorConfigVersion();
        } else {
            if (Intrinsics.areEqual(p0, OnboardingState.ForTestPurposeStep.INSTANCE) ? true : Intrinsics.areEqual(p0, OnboardingState.FaceLoginStep.INSTANCE)) {
                return;
            }
            Intrinsics.areEqual(p0, OnboardingState.TwilioStep.INSTANCE);
        }
    }

    private final boolean BuiltInFictitiousFunctionClassFactory(OnboardingState p0) {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.contains(p0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.getAuthRequestContext.isEmpty();
    }
}
