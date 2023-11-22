package id.dana.kyb.view;

import android.os.Bundle;
import android.view.View;
import com.alibaba.ariver.kernel.RVEvents;
import com.anggrayudi.storage.permission.FragmentPermissionRequest;
import id.dana.R;
import id.dana.challenge.ChallengeControl;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.dialog.TwoButtonWithImageDialog;
import id.dana.switchfaceauth.SwitchFaceAuthContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\f\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0004J\u0019\u0010\u0010\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0004"}, d2 = {"Lid/dana/kyb/view/MyBusinessFragment$getSwitchFaceAuthenticationModule$1;", "Lid/dana/switchfaceauth/SwitchFaceAuthContract$View;", "", "dismissProgress", "()V", "", "p0", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(Ljava/lang/String;)V", "p1", "", "p2", "onFaceSwitchRiskChallenge", "(Ljava/lang/String;Ljava/lang/String;Z)V", "onFailFaceEnroll", "onFailToggle", "onSuccessFaceSwitch", "(Ljava/lang/Boolean;)V", "showProgress", "toKYC"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyBusinessFragment$getSwitchFaceAuthenticationModule$1 implements SwitchFaceAuthContract.View {
    final /* synthetic */ MyBusinessFragment PlaceComponentResult;

    @Override // id.dana.switchfaceauth.SwitchFaceAuthContract.View
    public final void onFailToggle() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MyBusinessFragment$getSwitchFaceAuthenticationModule$1(MyBusinessFragment myBusinessFragment) {
        this.PlaceComponentResult = myBusinessFragment;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v3, types: [kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r6v4 */
    @Override // id.dana.switchfaceauth.SwitchFaceAuthContract.View
    public final void onFaceSwitchRiskChallenge(String p0, String p1, final boolean p2) {
        MyBusinessFragment myBusinessFragment = this.PlaceComponentResult;
        ChallengeControl.Builder builder = new ChallengeControl.Builder(myBusinessFragment);
        builder.scheduleImpl = "face_activation";
        builder.VerifyPinStateManager$executeRiskChallenge$2$1 = "face_activation";
        ChallengeControl.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory(true, p0, p1, p2);
        final MyBusinessFragment myBusinessFragment2 = this.PlaceComponentResult;
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda5 = new ChallengeControl.Listener() { // from class: id.dana.kyb.view.MyBusinessFragment$getSwitchFaceAuthenticationModule$1$onFaceSwitchRiskChallenge$1
            @Override // id.dana.challenge.ChallengeControl.Listener
            public final void getAuthRequestContext() {
                if (MyBusinessFragment.VerifyPinStateManager$executeRiskChallenge$2$2(MyBusinessFragment.this)) {
                    return;
                }
                MyBusinessFragment.M(MyBusinessFragment.this);
                MyBusinessFragment.PlaceComponentResult(MyBusinessFragment.this, Boolean.valueOf(p2));
            }

            @Override // id.dana.challenge.ChallengeControl.Listener
            public final void BuiltInFictitiousFunctionClassFactory(String p02, String p12, Bundle p22) {
                if (Intrinsics.areEqual(p12, ChallengeControl.CancelReason.PIN_TEMPORARY_LOCKED)) {
                    MyBusinessFragment.L(MyBusinessFragment.this);
                } else if (Intrinsics.areEqual(p12, "forgot_pin")) {
                    FragmentPermissionRequest callingPid = MyBusinessFragment.getCallingPid(MyBusinessFragment.this);
                    if (callingPid == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        callingPid = null;
                    }
                    callingPid.check();
                }
            }
        };
        ChallengeControl challengeControl = 0;
        MyBusinessFragment.PlaceComponentResult(myBusinessFragment, new ChallengeControl(MyBillsEntityDataFactory, challengeControl));
        ChallengeControl NetworkUserEntityData$$ExternalSyntheticLambda7 = MyBusinessFragment.NetworkUserEntityData$$ExternalSyntheticLambda7(this.PlaceComponentResult);
        if (NetworkUserEntityData$$ExternalSyntheticLambda7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            challengeControl = NetworkUserEntityData$$ExternalSyntheticLambda7;
        }
        challengeControl.getAuthRequestContext();
    }

    @Override // id.dana.switchfaceauth.SwitchFaceAuthContract.View
    public final void onSuccessFaceSwitch(Boolean p0) {
        MyBusinessFragment.M(this.PlaceComponentResult);
        MyBusinessFragment.PlaceComponentResult(this.PlaceComponentResult, p0);
    }

    @Override // id.dana.switchfaceauth.SwitchFaceAuthContract.View
    public final void onFailFaceEnroll() {
        MyBusinessFragment.getNameOrBuilderList(this.PlaceComponentResult);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, id.dana.dialog.TwoButtonWithImageDialog] */
    @Override // id.dana.switchfaceauth.SwitchFaceAuthContract.View
    public final void toKYC() {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        TwoButtonWithImageDialog.Builder builder = new TwoButtonWithImageDialog.Builder(this.PlaceComponentResult.getContext());
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.ic_premium_feature;
        builder.FragmentBottomSheetPaymentSettingBinding = this.PlaceComponentResult.getResources().getString(R.string.lets_update_to_dana_premium);
        builder.getErrorConfigVersion = this.PlaceComponentResult.getResources().getString(R.string.update_premium_face_login_desc);
        String string = this.PlaceComponentResult.getResources().getString(R.string.upgrade);
        final MyBusinessFragment myBusinessFragment = this.PlaceComponentResult;
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.kyb.view.MyBusinessFragment$getSwitchFaceAuthenticationModule$1$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyBusinessFragment$getSwitchFaceAuthenticationModule$1.PlaceComponentResult(Ref.ObjectRef.this, myBusinessFragment);
            }
        };
        builder.NetworkUserEntityData$$ExternalSyntheticLambda8 = string;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = onClickListener;
        String string2 = this.PlaceComponentResult.getResources().getString(R.string.option_cancel);
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: id.dana.kyb.view.MyBusinessFragment$getSwitchFaceAuthenticationModule$1$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyBusinessFragment$getSwitchFaceAuthenticationModule$1.MyBillsEntityDataFactory(Ref.ObjectRef.this);
            }
        };
        builder.NetworkUserEntityData$$ExternalSyntheticLambda2 = string2;
        builder.DatabaseTableConfigUtil = onClickListener2;
        objectRef.element = builder.KClassImpl$Data$declaredNonStaticMembers$2();
        ((TwoButtonWithImageDialog) objectRef.element).MyBillsEntityDataFactory();
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public final void showProgress() {
        if (this.PlaceComponentResult.getBaseActivity() != null) {
            MyBusinessFragment myBusinessFragment = this.PlaceComponentResult;
            DanaLoadingDialog danaLoadingDialog = new DanaLoadingDialog(myBusinessFragment.getBaseActivity());
            if (!danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
                danaLoadingDialog.MyBillsEntityDataFactory.show();
                danaLoadingDialog.getAuthRequestContext.startRefresh();
            }
            MyBusinessFragment.getAuthRequestContext(myBusinessFragment, danaLoadingDialog);
        }
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public final void dismissProgress() {
        DanaLoadingDialog newProxyInstance = MyBusinessFragment.newProxyInstance(this.PlaceComponentResult);
        if (newProxyInstance == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            newProxyInstance = null;
        }
        newProxyInstance.PlaceComponentResult();
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public final void onError(String p0) {
        MyBusinessFragment.D(this.PlaceComponentResult);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(Ref.ObjectRef objectRef) {
        Intrinsics.checkNotNullParameter(objectRef, "");
        TwoButtonWithImageDialog twoButtonWithImageDialog = (TwoButtonWithImageDialog) objectRef.element;
        if (twoButtonWithImageDialog != null) {
            twoButtonWithImageDialog.getAuthRequestContext();
        }
    }

    public static /* synthetic */ void PlaceComponentResult(Ref.ObjectRef objectRef, MyBusinessFragment myBusinessFragment) {
        Intrinsics.checkNotNullParameter(objectRef, "");
        Intrinsics.checkNotNullParameter(myBusinessFragment, "");
        TwoButtonWithImageDialog twoButtonWithImageDialog = (TwoButtonWithImageDialog) objectRef.element;
        if (twoButtonWithImageDialog != null) {
            twoButtonWithImageDialog.getAuthRequestContext();
        }
        String kycFromProfileUrl = myBusinessFragment.getAuthRequestContext().get().getKycFromProfileUrl();
        Intrinsics.checkNotNullExpressionValue(kycFromProfileUrl, "");
        MyBusinessFragment.BuiltInFictitiousFunctionClassFactory(myBusinessFragment, kycFromProfileUrl);
    }
}
