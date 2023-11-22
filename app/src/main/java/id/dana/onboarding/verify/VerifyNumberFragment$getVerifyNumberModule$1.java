package id.dana.onboarding.verify;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import com.alibaba.ariver.kernel.RVEvents;
import com.anggrayudi.storage.permission.FragmentPermissionRequest;
import dagger.Lazy;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.challenge.botprotection.BotProtectionChallenge;
import id.dana.core.ui.dialog.DanaAlertDialog;
import id.dana.core.ui.richview.InputPhoneView;
import id.dana.danah5.DanaH5;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.databinding.FragmentVerifyNumberBinding;
import id.dana.domain.featureconfig.model.EmergencyNotificationConfig;
import id.dana.domain.featureconfig.model.OnboardingWarningTextConfig;
import id.dana.domain.model.rpc.response.CheckRegistrationResponse;
import id.dana.domain.model.rpc.response.LoginAuthenticationOptionResponse;
import id.dana.domain.otp.model.OtpChannel;
import id.dana.maintenance.EmergencyNotifActivity;
import id.dana.model.FaceAuthenticationModel;
import id.dana.model.Trust2RiskLoginModel;
import id.dana.network.exception.NetworkException;
import id.dana.oauth.activity.BlockRegistrationActivity;
import id.dana.onboarding.OnboardingNavigationManagerWithMenu;
import id.dana.onboarding.bottomsheet.DanaConfirmationBottomSheetDialog;
import id.dana.onboarding.citcall.CitCallDialogState;
import id.dana.onboarding.citcall.CitCallErrorDialog;
import id.dana.onboarding.track.OnboardingFirebaseTracker;
import id.dana.onboarding.verify.VerifyNumberContract;
import id.dana.onboarding.verify.devicelimit.DeviceLimitErrorKey;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ7\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b\u000b\u0010\u0012J\u001f\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0005\u0010\u0014J\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u000b\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J1\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0016\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0004J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u0005\u0010\u001aJ\u0019\u0010\u001b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\tJ\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\b\u0010\u0015J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0005\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J9\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0011\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u0016\u0010\u001fJ-\u0010\u0017\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0017\u0010 J=\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00132\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001e\u001a\u00020!H\u0016¢\u0006\u0004\b\u0017\u0010\"J=\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00132\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001e\u001a\u00020#H\u0016¢\u0006\u0004\b\b\u0010$J)\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00132\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\b\u0010%J\u0017\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0015J\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\u0019\u0010\u0016\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\tJ\u0017\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0017\u0010\fJ\u000f\u0010&\u001a\u00020\u0002H\u0016¢\u0006\u0004\b&\u0010\u0004J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0005\u0010\fJ\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\nH\u0016¢\u0006\u0004\b\b\u0010\fJ\u000f\u0010'\u001a\u00020\u0002H\u0016¢\u0006\u0004\b'\u0010\u0004J\u000f\u0010(\u001a\u00020\u0002H\u0016¢\u0006\u0004\b(\u0010\u0004J\u000f\u0010)\u001a\u00020\u0002H\u0016¢\u0006\u0004\b)\u0010\u0004J)\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020*H\u0016¢\u0006\u0004\b\u0016\u0010+J\u0017\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020*H\u0016¢\u0006\u0004\b\u0017\u0010,J\u000f\u0010-\u001a\u00020\u0002H\u0016¢\u0006\u0004\b-\u0010\u0004J\u000f\u0010.\u001a\u00020\u0002H\u0016¢\u0006\u0004\b.\u0010\u0004J\u001f\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020*H\u0016¢\u0006\u0004\b\u000b\u0010/J\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u000200H\u0016¢\u0006\u0004\b\u000b\u00101J\u000f\u00102\u001a\u00020\u0002H\u0016¢\u0006\u0004\b2\u0010\u0004J\u000f\u00103\u001a\u00020\u0002H\u0016¢\u0006\u0004\b3\u0010\u0004J\u000f\u00104\u001a\u00020\u0002H\u0016¢\u0006\u0004\b4\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0005\u0010\t"}, d2 = {"Lid/dana/onboarding/verify/VerifyNumberFragment$getVerifyNumberModule$1;", "Lid/dana/onboarding/verify/VerifyNumberContract$View;", "", "dismissProgress", "()V", "BuiltInFictitiousFunctionClassFactory", "", "p0", "PlaceComponentResult", "(Ljava/lang/String;)V", "Lid/dana/network/exception/NetworkException;", "getAuthRequestContext", "(Lid/dana/network/exception/NetworkException;)V", "p1", "p2", "", "Lid/dana/domain/model/rpc/response/LoginAuthenticationOptionResponse;", "p3", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "", "(ZLjava/lang/String;)V", "(Z)V", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "Lid/dana/domain/featureconfig/model/EmergencyNotificationConfig;", "(Lid/dana/domain/featureconfig/model/EmergencyNotificationConfig;)V", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "Lid/dana/domain/model/rpc/response/CheckRegistrationResponse;", "", "p4", "(Lid/dana/domain/model/rpc/response/CheckRegistrationResponse;ZLjava/lang/String;II)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lid/dana/model/FaceAuthenticationModel;", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/model/FaceAuthenticationModel;)V", "Lid/dana/model/Trust2RiskLoginModel;", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/model/Trust2RiskLoginModel;)V", "(ZLjava/lang/String;Z)V", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda0", "scheduleImpl", "moveToNextValue", "", "(Ljava/lang/String;Lid/dana/network/exception/NetworkException;J)V", "(J)V", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda1", "(Ljava/lang/String;J)V", "Lid/dana/domain/featureconfig/model/OnboardingWarningTextConfig;", "(Lid/dana/domain/featureconfig/model/OnboardingWarningTextConfig;)V", "showProgress", "NetworkUserEntityData$$ExternalSyntheticLambda2", "DatabaseTableConfigUtil"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerifyNumberFragment$getVerifyNumberModule$1 implements VerifyNumberContract.View {
    final /* synthetic */ VerifyNumberFragment MyBillsEntityDataFactory;

    public static /* synthetic */ void initRecordTimeStamp() {
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public final /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public VerifyNumberFragment$getVerifyNumberModule$1(VerifyNumberFragment verifyNumberFragment) {
        this.MyBillsEntityDataFactory = verifyNumberFragment;
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2) {
        FragmentVerifyNumberBinding scheduleImpl = VerifyNumberFragment.scheduleImpl(this.MyBillsEntityDataFactory);
        Button button = scheduleImpl != null ? scheduleImpl.getAuthRequestContext : null;
        if (button != null) {
            button.setEnabled(false);
        }
        this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda6 = p0 == null ? "" : p0;
        VerifyNumberFragment verifyNumberFragment = this.MyBillsEntityDataFactory;
        if (p1 == null) {
            p1 = "";
        }
        verifyNumberFragment.SubSequence = p1;
        if (p0 == null) {
            p0 = "";
        }
        if (p2 == null) {
            p2 = "";
        }
        getAuthRequestContext(p0, p2, "", CollectionsKt.emptyList());
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void MyBillsEntityDataFactory(CheckRegistrationResponse p0, boolean p1, String p2, int p3, int p4) {
        boolean z;
        boolean z2;
        OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu;
        String str;
        Intrinsics.checkNotNullParameter(p0, "");
        z = this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (z) {
            p2 = this.MyBillsEntityDataFactory.VerifyPinStateManager$executeRiskChallenge$2$1;
        }
        String str2 = p2;
        VerifyNumberFragment verifyNumberFragment = this.MyBillsEntityDataFactory;
        String prizeName = p0.getPrizeName();
        if (prizeName == null) {
            prizeName = "";
        }
        verifyNumberFragment.getCallingPid = prizeName;
        this.MyBillsEntityDataFactory.readMicros = p0.getCampaignEnabled();
        VerifyNumberFragment verifyNumberFragment2 = this.MyBillsEntityDataFactory;
        z2 = verifyNumberFragment2.readMicros;
        verifyNumberFragment2.getSupportButtonTintMode = z2;
        onboardingNavigationManagerWithMenu = this.MyBillsEntityDataFactory.PrepareContext;
        if (onboardingNavigationManagerWithMenu == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            onboardingNavigationManagerWithMenu = null;
        }
        onboardingNavigationManagerWithMenu.KClassImpl$Data$declaredNonStaticMembers$2.setMenuRightProgressBar(false);
        this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda4 = p0.getOtpChannel();
        str = this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda4;
        if (Intrinsics.areEqual(str, OtpChannel.WHATSAPP)) {
            VerifyNumberFragment.NetworkUserEntityData$$ExternalSyntheticLambda3(this.MyBillsEntityDataFactory);
        }
        VerifyNumberFragment.PlaceComponentResult(this.MyBillsEntityDataFactory, p0.getLocalPhoneNumber(), p3, p4, str2, p0.getIsFreezeVerifyOtp(), p0.getIsErrorResend());
        VerifyNumberFragment verifyNumberFragment3 = this.MyBillsEntityDataFactory;
        String localPhoneNumber = p0.getLocalPhoneNumber();
        verifyNumberFragment3.NetworkUserEntityData$$ExternalSyntheticLambda3 = 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x007d: IPUT 
              (wrap: id.dana.onboarding.verify.VerifyNumberFragment$ChallengeListener : 0x0002: CONSTRUCTOR 
              (r11v13 'verifyNumberFragment3' id.dana.onboarding.verify.VerifyNumberFragment)
              (r10v0 'p1' boolean)
              (wrap: java.lang.String : ?: TERNARY null = ((r9v1 'localPhoneNumber' java.lang.String) != (null java.lang.String)) ? (r9v1 'localPhoneNumber' java.lang.String) : (""))
             A[MD:(id.dana.onboarding.verify.VerifyNumberFragment, boolean, java.lang.String):void (m), WRAPPED] (LINE:8642) call: id.dana.onboarding.verify.VerifyNumberFragment$activityResultOtpRegister$1.<init>(id.dana.onboarding.verify.VerifyNumberFragment, boolean, java.lang.String):void type: CONSTRUCTOR)
              (r11v13 'verifyNumberFragment3' id.dana.onboarding.verify.VerifyNumberFragment)
             A[MD:(id.dana.onboarding.verify.VerifyNumberFragment, boolean, java.lang.String):void (m)] (LINE:8642) id.dana.onboarding.verify.VerifyNumberFragment.PlaceComponentResult id.dana.onboarding.verify.VerifyNumberFragment$ChallengeListener in method: id.dana.onboarding.verify.VerifyNumberFragment$getVerifyNumberModule$1.MyBillsEntityDataFactory(id.dana.domain.model.rpc.response.CheckRegistrationResponse, boolean, java.lang.String, int, int):void, file: classes5.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
            	at java.base/java.util.ArrayList.forEach(Unknown Source)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: id.dana.onboarding.verify.VerifyNumberFragment$activityResultOtpRegister$1, state: NOT_LOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:307)
            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:769)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:718)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:417)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:486)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
            	... 15 more
            */
        /*
            this = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            id.dana.onboarding.verify.VerifyNumberFragment r1 = r8.MyBillsEntityDataFactory
            boolean r1 = id.dana.onboarding.verify.VerifyNumberFragment.newProxyInstance(r1)
            if (r1 == 0) goto L13
            id.dana.onboarding.verify.VerifyNumberFragment r11 = r8.MyBillsEntityDataFactory
            java.lang.String r11 = id.dana.onboarding.verify.VerifyNumberFragment.NetworkUserEntityData$$ExternalSyntheticLambda7(r11)
        L13:
            r5 = r11
            id.dana.onboarding.verify.VerifyNumberFragment r11 = r8.MyBillsEntityDataFactory
            java.lang.String r1 = r9.getPrizeName()
            if (r1 != 0) goto L1d
            r1 = r0
        L1d:
            id.dana.onboarding.verify.VerifyNumberFragment.MyBillsEntityDataFactory(r11, r1)
            id.dana.onboarding.verify.VerifyNumberFragment r11 = r8.MyBillsEntityDataFactory
            boolean r1 = r9.getCampaignEnabled()
            id.dana.onboarding.verify.VerifyNumberFragment.getErrorConfigVersion(r11, r1)
            id.dana.onboarding.verify.VerifyNumberFragment r11 = r8.MyBillsEntityDataFactory
            boolean r1 = id.dana.onboarding.verify.VerifyNumberFragment.NetworkUserEntityData$$ExternalSyntheticLambda8(r11)
            id.dana.onboarding.verify.VerifyNumberFragment.scheduleImpl(r11, r1)
            id.dana.onboarding.verify.VerifyNumberFragment r11 = r8.MyBillsEntityDataFactory
            id.dana.onboarding.OnboardingNavigationManagerWithMenu r11 = id.dana.onboarding.verify.VerifyNumberFragment.NetworkUserEntityData$$ExternalSyntheticLambda2(r11)
            if (r11 != 0) goto L3e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r11 = 0
        L3e:
            id.dana.base.MenuItemFacade r11 = r11.KClassImpl$Data$declaredNonStaticMembers$2
            r1 = 0
            r11.setMenuRightProgressBar(r1)
            id.dana.onboarding.verify.VerifyNumberFragment r11 = r8.MyBillsEntityDataFactory
            java.lang.String r1 = r9.getOtpChannel()
            id.dana.onboarding.verify.VerifyNumberFragment.PlaceComponentResult(r11, r1)
            id.dana.onboarding.verify.VerifyNumberFragment r11 = r8.MyBillsEntityDataFactory
            java.lang.String r11 = id.dana.onboarding.verify.VerifyNumberFragment.NetworkUserEntityData$$ExternalSyntheticLambda1(r11)
            java.lang.String r1 = "WA_CODE"
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual(r11, r1)
            if (r11 == 0) goto L60
            id.dana.onboarding.verify.VerifyNumberFragment r11 = r8.MyBillsEntityDataFactory
            id.dana.onboarding.verify.VerifyNumberFragment.NetworkUserEntityData$$ExternalSyntheticLambda3(r11)
        L60:
            id.dana.onboarding.verify.VerifyNumberFragment r1 = r8.MyBillsEntityDataFactory
            java.lang.String r2 = r9.getLocalPhoneNumber()
            boolean r6 = r9.getIsFreezeVerifyOtp()
            boolean r7 = r9.getIsErrorResend()
            r3 = r12
            r4 = r13
            id.dana.onboarding.verify.VerifyNumberFragment.PlaceComponentResult(r1, r2, r3, r4, r5, r6, r7)
            id.dana.onboarding.verify.VerifyNumberFragment r11 = r8.MyBillsEntityDataFactory
            java.lang.String r9 = r9.getLocalPhoneNumber()
            if (r9 != 0) goto L7c
            goto L7d
        L7c:
            r0 = r9
        L7d:
            id.dana.onboarding.verify.VerifyNumberFragment.BuiltInFictitiousFunctionClassFactory(r11, r10, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.onboarding.verify.VerifyNumberFragment$getVerifyNumberModule$1.MyBillsEntityDataFactory(id.dana.domain.model.rpc.response.CheckRegistrationResponse, boolean, java.lang.String, int, int):void");
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0, String p1, String p2, String p3, FaceAuthenticationModel p4) {
        Intrinsics.checkNotNullParameter(p4, "");
        FragmentVerifyNumberBinding scheduleImpl = VerifyNumberFragment.scheduleImpl(this.MyBillsEntityDataFactory);
        Button button = scheduleImpl != null ? scheduleImpl.getAuthRequestContext : null;
        if (button != null) {
            button.setEnabled(false);
        }
        this.MyBillsEntityDataFactory.scheduleImpl = p0;
        this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda6 = p1 == null ? "" : p1;
        VerifyNumberFragment verifyNumberFragment = this.MyBillsEntityDataFactory;
        if (p2 == null) {
            p2 = "";
        }
        verifyNumberFragment.SubSequence = p2;
        this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = p4;
        if (p1 == null) {
            p1 = "";
        }
        if (p3 == null) {
            p3 = "";
        }
        getAuthRequestContext(p1, p3, "", CollectionsKt.emptyList());
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void PlaceComponentResult(boolean p0, String p1, String p2, String p3, Trust2RiskLoginModel p4) {
        Intrinsics.checkNotNullParameter(p4, "");
        FragmentVerifyNumberBinding scheduleImpl = VerifyNumberFragment.scheduleImpl(this.MyBillsEntityDataFactory);
        Button button = scheduleImpl != null ? scheduleImpl.getAuthRequestContext : null;
        if (button != null) {
            button.setEnabled(false);
        }
        this.MyBillsEntityDataFactory.scheduleImpl = p0;
        this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda6 = p1 == null ? "" : p1;
        VerifyNumberFragment verifyNumberFragment = this.MyBillsEntityDataFactory;
        if (p2 == null) {
            p2 = "";
        }
        verifyNumberFragment.SubSequence = p2;
        this.MyBillsEntityDataFactory.A = p4;
        if (p1 == null) {
            p1 = "";
        }
        if (p3 == null) {
            p3 = "";
        }
        getAuthRequestContext(p1, p3, "", CollectionsKt.emptyList());
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        VerifyNumberFragment.readMicros(this.MyBillsEntityDataFactory);
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
        VerifyNumberFragment verifyNumberFragment = this.MyBillsEntityDataFactory;
        BlockRegistrationActivity.Companion companion = BlockRegistrationActivity.INSTANCE;
        BaseActivity baseActivity = this.MyBillsEntityDataFactory.getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        verifyNumberFragment.startActivity(BlockRegistrationActivity.Companion.KClassImpl$Data$declaredNonStaticMembers$2(baseActivity, p0));
        dismissProgress();
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void MyBillsEntityDataFactory(String p0) {
        if (this.MyBillsEntityDataFactory.getContext() == null) {
            return;
        }
        String str = p0;
        if (str == null || str.length() == 0) {
            Context context = this.MyBillsEntityDataFactory.getContext();
            p0 = context != null ? context.getString(R.string.res_0x7f13137c_summaryvoucherview_externalsyntheticlambda2) : null;
            if (p0 == null) {
                p0 = "";
            }
        }
        Context requireContext = this.MyBillsEntityDataFactory.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "");
        DanaAlertDialog.Builder builder = new DanaAlertDialog.Builder(requireContext);
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.BuiltInFictitiousFunctionClassFactory_res_0x7f0807f3;
        builder.lookAheadTest = Boolean.FALSE;
        builder.moveToNextValue = p0;
        builder.PrepareContext = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.risk_reject_positive_button_msg);
        DanaAlertDialog BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory();
        FragmentManager parentFragmentManager = this.MyBillsEntityDataFactory.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
        Intrinsics.checkNotNullParameter(parentFragmentManager, "");
        BuiltInFictitiousFunctionClassFactory.show(parentFragmentManager, "DanaAlertDialog");
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void lookAheadTest() {
        OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu;
        InputPhoneView inputPhoneView;
        EditText input;
        Editable text;
        FragmentVerifyNumberBinding scheduleImpl = VerifyNumberFragment.scheduleImpl(this.MyBillsEntityDataFactory);
        if (scheduleImpl != null && (inputPhoneView = scheduleImpl.PlaceComponentResult) != null && (input = inputPhoneView.getInput()) != null && (text = input.getText()) != null) {
            text.clear();
        }
        onboardingNavigationManagerWithMenu = this.MyBillsEntityDataFactory.PrepareContext;
        if (onboardingNavigationManagerWithMenu == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            onboardingNavigationManagerWithMenu = null;
        }
        DeviceLimitErrorKey deviceLimitErrorKey = new DeviceLimitErrorKey();
        Intrinsics.checkNotNullParameter(deviceLimitErrorKey, "");
        onboardingNavigationManagerWithMenu.getAuthRequestContext.goTo(deviceLimitErrorKey);
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void getAuthRequestContext() {
        Lazy<DynamicUrlWrapper> lazy = this.MyBillsEntityDataFactory.dynamicUrlWrapper;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lazy = null;
        }
        String forgotPinUrl = lazy.get().getForgotPinUrl();
        Intrinsics.checkNotNullExpressionValue(forgotPinUrl, "");
        DanaH5.startContainerFullUrl(forgotPinUrl);
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void PlaceComponentResult(boolean p0, String p1, boolean p2) {
        this.MyBillsEntityDataFactory.readMicros = p2;
        VerifyNumberFragment.getAuthRequestContext(this.MyBillsEntityDataFactory, p0, p1);
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void getAuthRequestContext(String p0, String p1, String p2, List<? extends LoginAuthenticationOptionResponse> p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        FragmentVerifyNumberBinding scheduleImpl = VerifyNumberFragment.scheduleImpl(this.MyBillsEntityDataFactory);
        Button button = scheduleImpl != null ? scheduleImpl.getAuthRequestContext : null;
        if (button != null) {
            button.setEnabled(false);
        }
        VerifyNumberFragment.PlaceComponentResult(this.MyBillsEntityDataFactory, p0, p1, p2, p3);
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void getAuthRequestContext(NetworkException p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        VerifyNumberFragment.NetworkUserEntityData$$ExternalSyntheticLambda5(this.MyBillsEntityDataFactory);
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void NetworkUserEntityData$$ExternalSyntheticLambda1() {
        if (this.MyBillsEntityDataFactory.getContext() == null) {
            return;
        }
        Context requireContext = this.MyBillsEntityDataFactory.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "");
        DanaAlertDialog.Builder builder = new DanaAlertDialog.Builder(requireContext);
        final VerifyNumberFragment verifyNumberFragment = this.MyBillsEntityDataFactory;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.account_freeze_dialog_login_title);
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.illustration_account_freeze;
        builder.moveToNextValue = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.account_freeze_dialog_login_desc);
        String string = verifyNumberFragment.getString(R.string.close);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String upperCase = string.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "");
        String str = upperCase;
        Intrinsics.checkNotNullParameter(str, "");
        builder.initRecordTimeStamp = str;
        String string2 = verifyNumberFragment.getString(R.string.account_freeze_dialog_positive_btn);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        String upperCase2 = string2.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase2, "");
        String str2 = upperCase2;
        Intrinsics.checkNotNullParameter(str2, "");
        builder.PrepareContext = str2;
        Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$getVerifyNumberModule$1$showLoginFreezeDialog$dialog$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                VerifyNumberFragment.BuiltInFictitiousFunctionClassFactory(VerifyNumberFragment.this, "https://www.dana.id/contact");
            }
        };
        Intrinsics.checkNotNullParameter(function0, "");
        builder.newProxyInstance = function0;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda1 = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.btn_close_freeze);
        builder.isLayoutRequested = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.btn_contact_us_freeze);
        builder.lookAheadTest = Boolean.FALSE;
        builder.getErrorConfigVersion = false;
        DanaAlertDialog BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory();
        FragmentManager parentFragmentManager = this.MyBillsEntityDataFactory.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
        Intrinsics.checkNotNullParameter(parentFragmentManager, "");
        BuiltInFictitiousFunctionClassFactory.show(parentFragmentManager, "DanaAlertDialog");
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void getAuthRequestContext(final String p0, final long p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (this.MyBillsEntityDataFactory.getContext() == null) {
            return;
        }
        Context requireContext = this.MyBillsEntityDataFactory.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "");
        DanaAlertDialog.Builder builder = new DanaAlertDialog.Builder(requireContext);
        final VerifyNumberFragment verifyNumberFragment = this.MyBillsEntityDataFactory;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.account_freeze_dialog_login_title);
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.illustration_account_freeze;
        builder.moveToNextValue = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.account_freeze_dialog_login_desc);
        String string = verifyNumberFragment.getString(R.string.close);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String upperCase = string.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "");
        String str = upperCase;
        Intrinsics.checkNotNullParameter(str, "");
        builder.initRecordTimeStamp = str;
        String string2 = verifyNumberFragment.getString(R.string.account_freeze_dialog_positive_btn);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        String upperCase2 = string2.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase2, "");
        String str2 = upperCase2;
        Intrinsics.checkNotNullParameter(str2, "");
        builder.PrepareContext = str2;
        Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$getVerifyNumberModule$1$showNewLoginFreezeDialog$dialog$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                VerifyNumberFragment verifyNumberFragment2 = VerifyNumberFragment.this;
                VerifyNumberFragment.BuiltInFictitiousFunctionClassFactory(verifyNumberFragment2, VerifyNumberFragment.getAuthRequestContext(verifyNumberFragment2, p1, p0));
            }
        };
        Intrinsics.checkNotNullParameter(function0, "");
        builder.newProxyInstance = function0;
        builder.lookAheadTest = Boolean.FALSE;
        builder.getErrorConfigVersion = false;
        DanaAlertDialog BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory();
        FragmentManager parentFragmentManager = this.MyBillsEntityDataFactory.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
        Intrinsics.checkNotNullParameter(parentFragmentManager, "");
        BuiltInFictitiousFunctionClassFactory.show(parentFragmentManager, "DanaAlertDialog");
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void PlaceComponentResult(boolean p0) {
        OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
        OnboardingFirebaseTracker.MyBillsEntityDataFactory(p0);
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
        OnboardingFirebaseTracker.PlaceComponentResult(p0);
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void BuiltInFictitiousFunctionClassFactory(boolean p0, String p1) {
        Intrinsics.checkNotNullParameter(p1, "");
        this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
        this.MyBillsEntityDataFactory.lookAheadTest = p1;
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void getAuthRequestContext(boolean p0) {
        this.MyBillsEntityDataFactory.moveToNextValue = p0;
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, boolean p1, String p2, String p3) {
        OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu;
        boolean z;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p3, "");
        onboardingNavigationManagerWithMenu = this.MyBillsEntityDataFactory.PrepareContext;
        if (onboardingNavigationManagerWithMenu == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            onboardingNavigationManagerWithMenu = null;
        }
        OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu2 = onboardingNavigationManagerWithMenu;
        z = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
        onboardingNavigationManagerWithMenu2.MyBillsEntityDataFactory(p0, z, p1, p2 == null ? "" : p2, p3);
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void PlaceComponentResult() {
        BaseActivity baseActivity = this.MyBillsEntityDataFactory.getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        new CitCallErrorDialog(baseActivity, CitCallDialogState.RISK_CONSULT, new View.OnClickListener() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$getVerifyNumberModule$1$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VerifyNumberFragment$getVerifyNumberModule$1.initRecordTimeStamp();
            }
        }).MyBillsEntityDataFactory();
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void BuiltInFictitiousFunctionClassFactory(EmergencyNotificationConfig p0) {
        String str;
        Intrinsics.checkNotNullParameter(p0, "");
        EmergencyNotifActivity.Companion companion = EmergencyNotifActivity.INSTANCE;
        BaseActivity baseActivity = this.MyBillsEntityDataFactory.getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        str = this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda6;
        this.MyBillsEntityDataFactory.getBaseActivity().startActivity(EmergencyNotifActivity.Companion.BuiltInFictitiousFunctionClassFactory(baseActivity, p0, str));
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        this.MyBillsEntityDataFactory.getBaseActivity().showWarningDialog(p0);
        FragmentVerifyNumberBinding scheduleImpl = VerifyNumberFragment.scheduleImpl(this.MyBillsEntityDataFactory);
        Button button = scheduleImpl != null ? scheduleImpl.getAuthRequestContext : null;
        if (button != null) {
            button.setEnabled(true);
        }
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Lazy<BotProtectionChallenge> lazy = this.MyBillsEntityDataFactory.botProtectionChallenge;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lazy = null;
        }
        lazy.get().getAuthRequestContext(this.MyBillsEntityDataFactory.getBaseActivity(), p0, new VerifyNumberFragment$getVerifyNumberModule$1$onAkamaiChallenged$1(this.MyBillsEntityDataFactory));
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void showProgress() {
        FragmentVerifyNumberBinding scheduleImpl = VerifyNumberFragment.scheduleImpl(this.MyBillsEntityDataFactory);
        Button button = scheduleImpl != null ? scheduleImpl.getAuthRequestContext : null;
        if (button != null) {
            button.setEnabled(false);
        }
        VerifyNumberFragment.whenAvailable(this.MyBillsEntityDataFactory);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void dismissProgress() {
        VerifyNumberFragment.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory);
        FragmentVerifyNumberBinding scheduleImpl = VerifyNumberFragment.scheduleImpl(this.MyBillsEntityDataFactory);
        Button button = scheduleImpl != null ? scheduleImpl.getAuthRequestContext : null;
        if (button != null) {
            button.setEnabled(true);
        }
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final void onError(String p0) {
        Lazy<VerifyNumberContract.Presenter> lazy = this.MyBillsEntityDataFactory.verifyPresenter;
        if (lazy == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lazy = null;
        }
        lazy.get().BuiltInFictitiousFunctionClassFactory(p0);
        FragmentVerifyNumberBinding scheduleImpl = VerifyNumberFragment.scheduleImpl(this.MyBillsEntityDataFactory);
        Button button = scheduleImpl != null ? scheduleImpl.getAuthRequestContext : null;
        if (button != null) {
            button.setEnabled(true);
        }
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void scheduleImpl() {
        if (this.MyBillsEntityDataFactory.getContext() == null) {
            return;
        }
        Context requireContext = this.MyBillsEntityDataFactory.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "");
        DanaAlertDialog.Builder builder = new DanaAlertDialog.Builder(requireContext);
        builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.transfer_account_failed_title_dialog);
        builder.moveToNextValue = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.transfer_account_failed_message_dialog);
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.ic_failed_transfer_account;
        builder.PrepareContext = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.transfer_account_call_us);
        final VerifyNumberFragment verifyNumberFragment = this.MyBillsEntityDataFactory;
        Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.onboarding.verify.VerifyNumberFragment$getVerifyNumberModule$1$onTransferAccountError$dialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FragmentPermissionRequest fragmentPermissionRequest;
                fragmentPermissionRequest = VerifyNumberFragment.this.whenAvailable;
                if (fragmentPermissionRequest == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    fragmentPermissionRequest = null;
                }
                fragmentPermissionRequest.check();
            }
        };
        Intrinsics.checkNotNullParameter(function0, "");
        builder.newProxyInstance = function0;
        String string = this.MyBillsEntityDataFactory.getString(R.string.close);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String upperCase = string.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "");
        String str = upperCase;
        Intrinsics.checkNotNullParameter(str, "");
        builder.initRecordTimeStamp = str;
        DanaAlertDialog BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory();
        FragmentManager parentFragmentManager = this.MyBillsEntityDataFactory.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
        Intrinsics.checkNotNullParameter(parentFragmentManager, "");
        BuiltInFictitiousFunctionClassFactory.show(parentFragmentManager, "DanaAlertDialog");
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void moveToNextValue() {
        if (this.MyBillsEntityDataFactory.getContext() == null) {
            return;
        }
        Context requireContext = this.MyBillsEntityDataFactory.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "");
        DanaAlertDialog.Builder builder = new DanaAlertDialog.Builder(requireContext);
        builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.transfer_account_pendding_title_dialog);
        builder.moveToNextValue = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.transfer_account_pendding_message_dialog);
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.ic_pending_transfer_account;
        builder.PrepareContext = builder.BuiltInFictitiousFunctionClassFactory.getString(R.string.transfer_account_understood);
        DanaAlertDialog BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory();
        FragmentManager parentFragmentManager = this.MyBillsEntityDataFactory.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
        Intrinsics.checkNotNullParameter(parentFragmentManager, "");
        BuiltInFictitiousFunctionClassFactory.show(parentFragmentManager, "DanaAlertDialog");
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void MyBillsEntityDataFactory(boolean p0) {
        this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda1 = p0;
        VerifyNumberFragment.PlaceComponentResult(this.MyBillsEntityDataFactory, p0);
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void getErrorConfigVersion() {
        DanaConfirmationBottomSheetDialog lookAheadTest = VerifyNumberFragment.lookAheadTest(this.MyBillsEntityDataFactory);
        FragmentManager supportFragmentManager = this.MyBillsEntityDataFactory.getBaseActivity().getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
        lookAheadTest.getAuthRequestContext(supportFragmentManager);
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        this.MyBillsEntityDataFactory.getErrorConfigVersion();
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void MyBillsEntityDataFactory() {
        VerifyNumberFragment.SubSequence(this.MyBillsEntityDataFactory);
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(long p0) {
        VerifyNumberFragment verifyNumberFragment = this.MyBillsEntityDataFactory;
        VerifyNumberFragment.BuiltInFictitiousFunctionClassFactory(verifyNumberFragment, VerifyNumberFragment.MyBillsEntityDataFactory(verifyNumberFragment, p0));
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void NetworkUserEntityData$$ExternalSyntheticLambda2() {
        VerifyNumberFragment.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory, "https://m.dana.id/m/ipg/securingAccount");
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void DatabaseTableConfigUtil() {
        VerifyNumberFragment.getOnBoardingScenario(this.MyBillsEntityDataFactory);
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(NetworkException p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        VerifyNumberFragment.A(this.MyBillsEntityDataFactory);
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void PlaceComponentResult(NetworkException p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        VerifyNumberFragment.B(this.MyBillsEntityDataFactory);
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void MyBillsEntityDataFactory(NetworkException p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        VerifyNumberFragment.BottomSheetCardBindingView$watcherCardNumberView$1(this.MyBillsEntityDataFactory);
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void BuiltInFictitiousFunctionClassFactory(NetworkException p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        VerifyNumberFragment.C(this.MyBillsEntityDataFactory);
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void getAuthRequestContext(OnboardingWarningTextConfig p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.MyBillsEntityDataFactory.C = p0;
        FragmentVerifyNumberBinding scheduleImpl = VerifyNumberFragment.scheduleImpl(this.MyBillsEntityDataFactory);
        ConstraintLayout constraintLayout = scheduleImpl != null ? scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2 : null;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        VerifyNumberFragment.NetworkUserEntityData$$ExternalSyntheticLambda6(this.MyBillsEntityDataFactory);
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void BuiltInFictitiousFunctionClassFactory() {
        FragmentVerifyNumberBinding scheduleImpl = VerifyNumberFragment.scheduleImpl(this.MyBillsEntityDataFactory);
        ConstraintLayout constraintLayout = scheduleImpl != null ? scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2 : null;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
    }

    @Override // id.dana.onboarding.verify.VerifyNumberContract.View
    public final void MyBillsEntityDataFactory(String p0, NetworkException p1, long p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (p1 != null) {
            VerifyNumberFragment.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory, p0, p1, p2);
        }
    }
}
