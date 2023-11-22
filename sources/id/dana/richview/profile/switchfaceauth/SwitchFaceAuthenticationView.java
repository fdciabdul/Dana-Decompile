package id.dana.richview.profile.switchfaceauth;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.afollestad.materialdialogs.MaterialDialog;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import com.ap.zoloz.hummer.biz.HummerConstants;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.base.BaseRichView;
import id.dana.challenge.ChallengeControl;
import id.dana.component.cellcomponent.DanaCellLeftView;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.danah5.DanaH5;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerSwitchFaceAuthComponent;
import id.dana.di.modules.SwitchFaceAuthenticationModule;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.dialog.DialogWithImage;
import id.dana.dialog.TwoButtonWithImageDialog;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.myprofile.SettingMoreProfileActivity;
import id.dana.richview.BlueSwitchView;
import id.dana.switchfaceauth.SwitchFaceAuthContract;
import id.dana.switchfaceauth.SwitchFaceAuthPresenter;
import id.dana.utils.CustomToastUtil;
import id.dana.utils.UrlUtil;
import id.dana.utils.danah5.DanaH5Listener;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0002RSB'\b\u0016\u0012\u0006\u0010J\u001a\u00020I\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010K\u0012\b\b\u0002\u0010M\u001a\u00020\u0006¢\u0006\u0004\bN\u0010OB+\b\u0016\u0012\u0006\u0010J\u001a\u00020I\u0012\b\u0010L\u001a\u0004\u0018\u00010K\u0012\u0006\u0010M\u001a\u00020\u0006\u0012\u0006\u0010P\u001a\u00020\u0006¢\u0006\u0004\bN\u0010QJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J+\u0010\u001b\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001a\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001d\u0010\u0005J\u000f\u0010\u001e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001e\u0010\u0005J\u000f\u0010\u001f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001f\u0010\u0005J\u0019\u0010 \u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\"\u0010\u0005J\u0015\u0010%\u001a\u00020\u00032\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0003H\u0016¢\u0006\u0004\b'\u0010\u0005J\u000f\u0010(\u001a\u00020\u0003H\u0016¢\u0006\u0004\b(\u0010\u0005J\u000f\u0010)\u001a\u00020\u0003H\u0002¢\u0006\u0004\b)\u0010\u0005J\u000f\u0010*\u001a\u00020\u0003H\u0016¢\u0006\u0004\b*\u0010\u0005J\u000f\u0010+\u001a\u00020\u0003H\u0002¢\u0006\u0004\b+\u0010\u0005J\u0019\u0010+\u001a\u00020\u00032\b\u0010,\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b+\u0010!J\u000f\u0010-\u001a\u00020\u0003H\u0016¢\u0006\u0004\b-\u0010\u0005J\u0017\u0010\"\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\rH\u0002¢\u0006\u0004\b\"\u0010.R\u0016\u00101\u001a\u00020/8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\"\u00100R\"\u00103\u001a\u0002028\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0013\u0010:\u001a\u000209X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010+\u001a\u00020<8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b+\u0010=R\u0016\u0010)\u001a\u00020\r8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b)\u0010>R\u0016\u0010\"\u001a\u00020#8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b1\u0010?R\u0016\u0010A\u001a\u00020<8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b@\u0010=R\u0016\u0010@\u001a\u00020<8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bA\u0010=R\"\u0010C\u001a\u00020B8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H"}, d2 = {"Lid/dana/richview/profile/switchfaceauth/SwitchFaceAuthenticationView;", "Lid/dana/base/BaseRichView;", "Lid/dana/switchfaceauth/SwitchFaceAuthContract$View;", "", "dismissProgress", "()V", "", "getLayout", "()I", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "", "isForRecyclerViewholder", "()Z", "Lid/dana/domain/profilemenu/model/SettingModel;", "data", "onBind", "(Lid/dana/domain/profilemenu/model/SettingModel;)V", "", "errorMessage", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(Ljava/lang/String;)V", BioUtilityBridge.SECURITY_ID, RecordError.KEY_PUB_KEY, "faceAuthNew", "onFaceSwitchRiskChallenge", "(Ljava/lang/String;Ljava/lang/String;Z)V", "onFailFaceEnroll", "onFailFaceQuery", "onFailToggle", "onSuccessFaceSwitch", "(Ljava/lang/Boolean;)V", "PlaceComponentResult", "Lid/dana/richview/profile/switchfaceauth/SwitchFaceAuthenticationView$AuthFaceListener;", "authFaceListener", "setAuthListener", "(Lid/dana/richview/profile/switchfaceauth/SwitchFaceAuthenticationView$AuthFaceListener;)V", "setFaceAuthSwitchOn", "setup", "BuiltInFictitiousFunctionClassFactory", "showProgress", "MyBillsEntityDataFactory", "p0", "toKYC", "(Z)V", "Lid/dana/dialog/DanaLoadingDialog;", "Lid/dana/dialog/DanaLoadingDialog;", "getAuthRequestContext", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "dynamicUrlWrapper", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "getDynamicUrlWrapper", "()Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "setDynamicUrlWrapper", "(Lid/dana/data/dynamicurl/DynamicUrlWrapper;)V", "Lcom/afollestad/materialdialogs/MaterialDialog;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/Lazy;", "Lid/dana/dialog/TwoButtonWithImageDialog;", "Lid/dana/dialog/TwoButtonWithImageDialog;", "Z", "Lid/dana/richview/profile/switchfaceauth/SwitchFaceAuthenticationView$AuthFaceListener;", "scheduleImpl", "moveToNextValue", "Lid/dana/switchfaceauth/SwitchFaceAuthPresenter;", "switchFaceAuthPresenter", "Lid/dana/switchfaceauth/SwitchFaceAuthPresenter;", "getSwitchFaceAuthPresenter", "()Lid/dana/switchfaceauth/SwitchFaceAuthPresenter;", "setSwitchFaceAuthPresenter", "(Lid/dana/switchfaceauth/SwitchFaceAuthPresenter;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "AuthFaceListener", "PhonePermission"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SwitchFaceAuthenticationView extends BaseRichView implements SwitchFaceAuthContract.View {
    private boolean BuiltInFictitiousFunctionClassFactory;
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;
    private TwoButtonWithImageDialog MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private DanaLoadingDialog getAuthRequestContext;
    public Map<Integer, View> _$_findViewCache;
    @Inject
    public DynamicUrlWrapper dynamicUrlWrapper;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private AuthFaceListener PlaceComponentResult;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private TwoButtonWithImageDialog scheduleImpl;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private TwoButtonWithImageDialog moveToNextValue;
    @Inject
    public SwitchFaceAuthPresenter switchFaceAuthPresenter;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/richview/profile/switchfaceauth/SwitchFaceAuthenticationView$AuthFaceListener;", "", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface AuthFaceListener {
        void KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwitchFaceAuthenticationView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwitchFaceAuthenticationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.item_menu_settings_face_auth;
    }

    @Override // id.dana.base.BaseRichView
    public final boolean isForRecyclerViewholder() {
        return true;
    }

    public final void onBind(SettingModel data) {
    }

    public final void setFaceAuthSwitchOn() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchFaceAuthenticationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<MaterialDialog>() { // from class: id.dana.richview.profile.switchfaceauth.SwitchFaceAuthenticationView$faceVerificationInfoDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MaterialDialog invoke() {
                Context context2 = SwitchFaceAuthenticationView.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "");
                CustomDialog.Builder builder = new CustomDialog.Builder(context2);
                builder.DatabaseTableConfigUtil = R.drawable.ic_illustration_general_selfie;
                builder.SubSequence = SwitchFaceAuthenticationView.this.getResources().getString(R.string.face_verification_info_title);
                builder.GetContactSyncConfig = SwitchFaceAuthenticationView.this.getResources().getString(R.string.face_verification_info_message);
                String string = SwitchFaceAuthenticationView.this.getResources().getString(R.string.face_verification_info_button);
                final SwitchFaceAuthenticationView switchFaceAuthenticationView = SwitchFaceAuthenticationView.this;
                return builder.BuiltInFictitiousFunctionClassFactory(string, new Function1<View, Unit>() { // from class: id.dana.richview.profile.switchfaceauth.SwitchFaceAuthenticationView$faceVerificationInfoDialog$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(View view) {
                        Intrinsics.checkNotNullParameter(view, "");
                        SwitchFaceAuthenticationView.access$getFaceVerificationInfoDialog(SwitchFaceAuthenticationView.this).dismiss();
                    }
                }).KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false).BuiltInFictitiousFunctionClassFactory();
            }
        });
    }

    public /* synthetic */ SwitchFaceAuthenticationView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwitchFaceAuthenticationView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<MaterialDialog>() { // from class: id.dana.richview.profile.switchfaceauth.SwitchFaceAuthenticationView$faceVerificationInfoDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MaterialDialog invoke() {
                Context context2 = SwitchFaceAuthenticationView.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "");
                CustomDialog.Builder builder = new CustomDialog.Builder(context2);
                builder.DatabaseTableConfigUtil = R.drawable.ic_illustration_general_selfie;
                builder.SubSequence = SwitchFaceAuthenticationView.this.getResources().getString(R.string.face_verification_info_title);
                builder.GetContactSyncConfig = SwitchFaceAuthenticationView.this.getResources().getString(R.string.face_verification_info_message);
                String string = SwitchFaceAuthenticationView.this.getResources().getString(R.string.face_verification_info_button);
                final SwitchFaceAuthenticationView switchFaceAuthenticationView = SwitchFaceAuthenticationView.this;
                return builder.BuiltInFictitiousFunctionClassFactory(string, new Function1<View, Unit>() { // from class: id.dana.richview.profile.switchfaceauth.SwitchFaceAuthenticationView$faceVerificationInfoDialog$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(View view) {
                        Intrinsics.checkNotNullParameter(view, "");
                        SwitchFaceAuthenticationView.access$getFaceVerificationInfoDialog(SwitchFaceAuthenticationView.this).dismiss();
                    }
                }).KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false).BuiltInFictitiousFunctionClassFactory();
            }
        });
    }

    @JvmName(name = "getSwitchFaceAuthPresenter")
    public final SwitchFaceAuthPresenter getSwitchFaceAuthPresenter() {
        SwitchFaceAuthPresenter switchFaceAuthPresenter = this.switchFaceAuthPresenter;
        if (switchFaceAuthPresenter != null) {
            return switchFaceAuthPresenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSwitchFaceAuthPresenter")
    public final void setSwitchFaceAuthPresenter(SwitchFaceAuthPresenter switchFaceAuthPresenter) {
        Intrinsics.checkNotNullParameter(switchFaceAuthPresenter, "");
        this.switchFaceAuthPresenter = switchFaceAuthPresenter;
    }

    @JvmName(name = "getDynamicUrlWrapper")
    public final DynamicUrlWrapper getDynamicUrlWrapper() {
        DynamicUrlWrapper dynamicUrlWrapper = this.dynamicUrlWrapper;
        if (dynamicUrlWrapper != null) {
            return dynamicUrlWrapper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setDynamicUrlWrapper")
    public final void setDynamicUrlWrapper(DynamicUrlWrapper dynamicUrlWrapper) {
        Intrinsics.checkNotNullParameter(dynamicUrlWrapper, "");
        this.dynamicUrlWrapper = dynamicUrlWrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getAuthRequestContext(SwitchFaceAuthenticationView switchFaceAuthenticationView) {
        Intrinsics.checkNotNullParameter(switchFaceAuthenticationView, "");
        switchFaceAuthenticationView.BuiltInFictitiousFunctionClassFactory = true;
        return false;
    }

    private final void PlaceComponentResult(boolean p0) {
        if (p0) {
            ((BlueSwitchView) _$_findCachedViewById(R.id.sv_enable_face_auth)).setTrackTintList(getResources().getColorStateList(R.color.azure));
        } else {
            ((BlueSwitchView) _$_findCachedViewById(R.id.sv_enable_face_auth)).setTrackTintList(getResources().getColorStateList(R.color.f27012131100470));
        }
    }

    @Override // id.dana.base.BaseRichView
    public final void injectComponent(ApplicationComponent applicationComponent) {
        DaggerSwitchFaceAuthComponent.Builder authRequestContext = DaggerSwitchFaceAuthComponent.getAuthRequestContext();
        authRequestContext.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        authRequestContext.PlaceComponentResult = (SwitchFaceAuthenticationModule) Preconditions.getAuthRequestContext(new SwitchFaceAuthenticationModule(this));
        authRequestContext.BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory(this);
        registerPresenter(getSwitchFaceAuthPresenter());
    }

    @Override // id.dana.switchfaceauth.SwitchFaceAuthContract.View
    public final void onFaceSwitchRiskChallenge(String securityId, String pubKey, boolean faceAuthNew) {
        BaseActivity baseActivity = getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        ChallengeControl.Builder builder = new ChallengeControl.Builder(baseActivity);
        builder.scheduleImpl = "face_activation";
        builder.VerifyPinStateManager$executeRiskChallenge$2$1 = ChallengeControl.Key.FACE_ACTIVATION_SMART_PAY;
        new ChallengeControl(builder.MyBillsEntityDataFactory(((BlueSwitchView) _$_findCachedViewById(R.id.sv_enable_face_auth)).isChecked(), securityId, pubKey, faceAuthNew), null).getAuthRequestContext();
    }

    @Override // id.dana.switchfaceauth.SwitchFaceAuthContract.View
    public final void onSuccessFaceSwitch(Boolean faceAuthNew) {
        MyBillsEntityDataFactory();
        MyBillsEntityDataFactory(faceAuthNew);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void MyBillsEntityDataFactory() {
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.btn_activate);
        if (linearLayout != null && linearLayout.getVisibility() == 0) {
            TwoButtonWithImageDialog.Builder builder = new TwoButtonWithImageDialog.Builder(getContext());
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.ic_faceenrol_verify;
            builder.FragmentBottomSheetPaymentSettingBinding = getResources().getString(R.string.login_face_success_title);
            builder.getErrorConfigVersion = getResources().getString(R.string.login_face_success_desc);
            TwoButtonWithImageDialog.Builder MyBillsEntityDataFactory = builder.PlaceComponentResult(false).MyBillsEntityDataFactory(false);
            String string = getResources().getString(R.string.res_0x7f130923_otpregistrationpresenter_input_2);
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.richview.profile.switchfaceauth.SwitchFaceAuthenticationView$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SwitchFaceAuthenticationView.m2851$r8$lambda$g86N7SzuiVDcP34OI6LHjr7aiM(SwitchFaceAuthenticationView.this, view);
                }
            };
            MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda8 = string;
            MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda4 = onClickListener;
            TwoButtonWithImageDialog KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
            Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
            this.moveToNextValue = KClassImpl$Data$declaredNonStaticMembers$2;
            KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void MyBillsEntityDataFactory(Boolean p0) {
        if (((BlueSwitchView) _$_findCachedViewById(R.id.sv_enable_face_auth)).getVisibility() == 0) {
            AuthFaceListener authFaceListener = null;
            if (Intrinsics.areEqual(p0, Boolean.TRUE)) {
                BaseActivity baseActivity = getBaseActivity();
                Intrinsics.checkNotNullExpressionValue(baseActivity, "");
                CustomToastUtil.PlaceComponentResult(baseActivity, R.drawable.ic_success, R.drawable.bg_rounded_toast_success, getResources().getString(R.string.enabled_face_verification), 48, 60, false, null, 384);
                AuthFaceListener authFaceListener2 = this.PlaceComponentResult;
                if (authFaceListener2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    authFaceListener = authFaceListener2;
                }
                authFaceListener.KClassImpl$Data$declaredNonStaticMembers$2();
                return;
            }
            BaseActivity baseActivity2 = getBaseActivity();
            Intrinsics.checkNotNullExpressionValue(baseActivity2, "");
            CustomToastUtil.PlaceComponentResult(baseActivity2, R.drawable.ic_success, R.drawable.bg_rounded_toast_success, getResources().getString(R.string.disabled_face_verification), 48, 60, false, null, 384);
            AuthFaceListener authFaceListener3 = this.PlaceComponentResult;
            if (authFaceListener3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                authFaceListener = authFaceListener3;
            }
            authFaceListener.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    public final void setAuthListener(AuthFaceListener authFaceListener) {
        Intrinsics.checkNotNullParameter(authFaceListener, "");
        this.PlaceComponentResult = authFaceListener;
    }

    public final void onFailFaceQuery() {
        BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.switchfaceauth.SwitchFaceAuthContract.View
    public final void onFailFaceEnroll() {
        BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.switchfaceauth.SwitchFaceAuthContract.View
    public final void onFailToggle() {
        PlaceComponentResult();
    }

    @Override // id.dana.switchfaceauth.SwitchFaceAuthContract.View
    public final void toKYC() {
        TwoButtonWithImageDialog.Builder builder = new TwoButtonWithImageDialog.Builder(getContext());
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.ic_premium_feature;
        builder.FragmentBottomSheetPaymentSettingBinding = getResources().getString(R.string.lets_update_to_dana_premium);
        builder.getErrorConfigVersion = getResources().getString(R.string.update_premium_face_login_desc);
        String string = getResources().getString(R.string.upgrade);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.richview.profile.switchfaceauth.SwitchFaceAuthenticationView$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SwitchFaceAuthenticationView.$r8$lambda$KUBv572EHXSBfXeqW8PvJ_nM3PQ(SwitchFaceAuthenticationView.this, view);
            }
        };
        builder.NetworkUserEntityData$$ExternalSyntheticLambda8 = string;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = onClickListener;
        String string2 = getResources().getString(R.string.option_cancel);
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: id.dana.richview.profile.switchfaceauth.SwitchFaceAuthenticationView$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SwitchFaceAuthenticationView.$r8$lambda$Y72VjEFrXnk3hbiJjq7Y_lCiqzw(SwitchFaceAuthenticationView.this, view);
            }
        };
        builder.NetworkUserEntityData$$ExternalSyntheticLambda2 = string2;
        builder.DatabaseTableConfigUtil = onClickListener2;
        TwoButtonWithImageDialog KClassImpl$Data$declaredNonStaticMembers$2 = builder.KClassImpl$Data$declaredNonStaticMembers$2();
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        this.scheduleImpl = KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void PlaceComponentResult() {
        if (((BlueSwitchView) _$_findCachedViewById(R.id.sv_enable_face_auth)).getVisibility() == 0) {
            ((BlueSwitchView) _$_findCachedViewById(R.id.sv_enable_face_auth)).setChecked(!((BlueSwitchView) _$_findCachedViewById(R.id.sv_enable_face_auth)).isChecked());
            PlaceComponentResult(((BlueSwitchView) _$_findCachedViewById(R.id.sv_enable_face_auth)).isChecked());
        }
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public final void showProgress() {
        if (getBaseActivity() != null) {
            DanaLoadingDialog danaLoadingDialog = new DanaLoadingDialog(getBaseActivity());
            if (!danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
                danaLoadingDialog.MyBillsEntityDataFactory.show();
                danaLoadingDialog.getAuthRequestContext.startRefresh();
            }
            this.getAuthRequestContext = danaLoadingDialog;
        }
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public final void dismissProgress() {
        DanaLoadingDialog danaLoadingDialog = this.getAuthRequestContext;
        if (danaLoadingDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            danaLoadingDialog = null;
        }
        danaLoadingDialog.PlaceComponentResult();
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        TwoButtonWithImageDialog.Builder builder = new TwoButtonWithImageDialog.Builder(getContext());
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.ic_faceenrol_invalid;
        builder.FragmentBottomSheetPaymentSettingBinding = getResources().getString(R.string.login_face_fail_title);
        builder.getErrorConfigVersion = getResources().getString(R.string.login_face_fail_desc);
        TwoButtonWithImageDialog.Builder MyBillsEntityDataFactory = builder.PlaceComponentResult(false).MyBillsEntityDataFactory(false);
        String string = getResources().getString(R.string.try_again);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.richview.profile.switchfaceauth.SwitchFaceAuthenticationView$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SwitchFaceAuthenticationView.$r8$lambda$z20nUu44J1TDMO_e8kWF1kgrbsQ(SwitchFaceAuthenticationView.this, view);
            }
        };
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda8 = string;
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda4 = onClickListener;
        String string2 = getResources().getString(R.string.later);
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: id.dana.richview.profile.switchfaceauth.SwitchFaceAuthenticationView$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SwitchFaceAuthenticationView.$r8$lambda$zM04zBkDxYIn1EyuQGSeJ0kMw9s(SwitchFaceAuthenticationView.this, view);
            }
        };
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 = string2;
        MyBillsEntityDataFactory.DatabaseTableConfigUtil = onClickListener2;
        TwoButtonWithImageDialog KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        this.MyBillsEntityDataFactory = KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/richview/profile/switchfaceauth/SwitchFaceAuthenticationView$PhonePermission;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class PhonePermission {
        public static final PhonePermission INSTANCE = new PhonePermission();

        private PhonePermission() {
        }
    }

    public static /* synthetic */ void $r8$lambda$BiehNM0uVWFZ6CXXJw7uX96blO8(SwitchFaceAuthenticationView switchFaceAuthenticationView, View view) {
        Intrinsics.checkNotNullParameter(switchFaceAuthenticationView, "");
        SwitchFaceAuthPresenter switchFaceAuthPresenter = switchFaceAuthenticationView.getSwitchFaceAuthPresenter();
        BaseActivity baseActivity = switchFaceAuthenticationView.getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        switchFaceAuthPresenter.MyBillsEntityDataFactory(true, null, baseActivity);
    }

    public static /* synthetic */ void $r8$lambda$KUBv572EHXSBfXeqW8PvJ_nM3PQ(SwitchFaceAuthenticationView switchFaceAuthenticationView, View view) {
        Intrinsics.checkNotNullParameter(switchFaceAuthenticationView, "");
        TwoButtonWithImageDialog twoButtonWithImageDialog = switchFaceAuthenticationView.scheduleImpl;
        if (twoButtonWithImageDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            twoButtonWithImageDialog = null;
        }
        twoButtonWithImageDialog.getAuthRequestContext();
        String kycFromProfileUrl = switchFaceAuthenticationView.getDynamicUrlWrapper().getKycFromProfileUrl();
        Intrinsics.checkNotNullExpressionValue(kycFromProfileUrl, "");
        String authRequestContext = UrlUtil.getAuthRequestContext(kycFromProfileUrl);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        DanaH5.startContainerFullUrl(authRequestContext, new DanaH5Listener() { // from class: id.dana.richview.profile.switchfaceauth.SwitchFaceAuthenticationView$openH5Container$$inlined$withDanaH5Callback$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerCreated(Bundle p0) {
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle p0) {
            }
        });
    }

    public static /* synthetic */ void $r8$lambda$NT7dhHEP5HD5JsFZ08rKFvskNsM(SwitchFaceAuthenticationView switchFaceAuthenticationView, View view) {
        Intrinsics.checkNotNullParameter(switchFaceAuthenticationView, "");
        ((MaterialDialog) switchFaceAuthenticationView.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).show();
    }

    public static /* synthetic */ void $r8$lambda$TUuCVi70Z8ZCANgrzgIa5_Dg1A8(SwitchFaceAuthenticationView switchFaceAuthenticationView, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(switchFaceAuthenticationView, "");
        if (switchFaceAuthenticationView.BuiltInFictitiousFunctionClassFactory) {
            switchFaceAuthenticationView.BuiltInFictitiousFunctionClassFactory = false;
            SwitchFaceAuthPresenter switchFaceAuthPresenter = switchFaceAuthenticationView.getSwitchFaceAuthPresenter();
            BaseActivity baseActivity = switchFaceAuthenticationView.getBaseActivity();
            Intrinsics.checkNotNullExpressionValue(baseActivity, "");
            switchFaceAuthPresenter.MyBillsEntityDataFactory(z, null, baseActivity);
        }
        switchFaceAuthenticationView.PlaceComponentResult(z);
    }

    public static /* synthetic */ void $r8$lambda$V65TBC8AwlUXZmd_4aBb2M2vZts(SwitchFaceAuthenticationView switchFaceAuthenticationView, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(switchFaceAuthenticationView, "");
        Intrinsics.checkNotNullParameter(dialogInterface, "");
        if (-1 == i) {
            BaseActivity baseActivity = switchFaceAuthenticationView.getBaseActivity();
            if (baseActivity != null) {
                ((SettingMoreProfileActivity) baseActivity).getPhonePermission().check();
                dialogInterface.dismiss();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type id.dana.myprofile.SettingMoreProfileActivity");
        }
    }

    public static /* synthetic */ void $r8$lambda$Y72VjEFrXnk3hbiJjq7Y_lCiqzw(SwitchFaceAuthenticationView switchFaceAuthenticationView, View view) {
        Intrinsics.checkNotNullParameter(switchFaceAuthenticationView, "");
        TwoButtonWithImageDialog twoButtonWithImageDialog = switchFaceAuthenticationView.scheduleImpl;
        if (twoButtonWithImageDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            twoButtonWithImageDialog = null;
        }
        twoButtonWithImageDialog.getAuthRequestContext();
    }

    /* renamed from: $r8$lambda$bD2YO-56sSnen_N5Jbl4G0bOEhM  reason: not valid java name */
    public static /* synthetic */ void m2850$r8$lambda$bD2YO56sSnen_N5Jbl4G0bOEhM(SwitchFaceAuthenticationView switchFaceAuthenticationView, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(switchFaceAuthenticationView, "");
        Intrinsics.checkNotNullParameter(dialogInterface, "");
        if (i != -2) {
            if (i != -1) {
                return;
            }
            BaseActivity baseActivity = switchFaceAuthenticationView.getBaseActivity();
            if (baseActivity != null) {
                ((SettingMoreProfileActivity) baseActivity).getPhonePermission().check();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type id.dana.myprofile.SettingMoreProfileActivity");
            }
        }
        dialogInterface.dismiss();
    }

    /* renamed from: $r8$lambda$g86N7SzuiVDcP34OI6LHj-r7aiM  reason: not valid java name */
    public static /* synthetic */ void m2851$r8$lambda$g86N7SzuiVDcP34OI6LHjr7aiM(SwitchFaceAuthenticationView switchFaceAuthenticationView, View view) {
        Intrinsics.checkNotNullParameter(switchFaceAuthenticationView, "");
        TwoButtonWithImageDialog twoButtonWithImageDialog = switchFaceAuthenticationView.moveToNextValue;
        if (twoButtonWithImageDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            twoButtonWithImageDialog = null;
        }
        twoButtonWithImageDialog.getAuthRequestContext();
    }

    public static /* synthetic */ void $r8$lambda$z20nUu44J1TDMO_e8kWF1kgrbsQ(SwitchFaceAuthenticationView switchFaceAuthenticationView, View view) {
        Intrinsics.checkNotNullParameter(switchFaceAuthenticationView, "");
        SwitchFaceAuthPresenter switchFaceAuthPresenter = switchFaceAuthenticationView.getSwitchFaceAuthPresenter();
        BaseActivity baseActivity = switchFaceAuthenticationView.getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        switchFaceAuthPresenter.MyBillsEntityDataFactory(true, null, baseActivity);
    }

    public static /* synthetic */ void $r8$lambda$zM04zBkDxYIn1EyuQGSeJ0kMw9s(SwitchFaceAuthenticationView switchFaceAuthenticationView, View view) {
        Intrinsics.checkNotNullParameter(switchFaceAuthenticationView, "");
        TwoButtonWithImageDialog twoButtonWithImageDialog = switchFaceAuthenticationView.MyBillsEntityDataFactory;
        if (twoButtonWithImageDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            twoButtonWithImageDialog = null;
        }
        twoButtonWithImageDialog.getAuthRequestContext();
    }

    public static final /* synthetic */ MaterialDialog access$getFaceVerificationInfoDialog(SwitchFaceAuthenticationView switchFaceAuthenticationView) {
        return (MaterialDialog) switchFaceAuthenticationView.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
    }

    public static final /* synthetic */ SettingMoreProfileActivity access$getSettingMoreProfileActivity(SwitchFaceAuthenticationView switchFaceAuthenticationView) {
        BaseActivity baseActivity = switchFaceAuthenticationView.getBaseActivity();
        if (baseActivity != null) {
            return (SettingMoreProfileActivity) baseActivity;
        }
        throw new NullPointerException("null cannot be cast to non-null type id.dana.myprofile.SettingMoreProfileActivity");
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public final void onError(String errorMessage) {
        DialogWithImage.Builder builder = new DialogWithImage.Builder();
        builder.BuiltInFictitiousFunctionClassFactory = new DialogInterface.OnClickListener() { // from class: id.dana.richview.profile.switchfaceauth.SwitchFaceAuthenticationView$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                SwitchFaceAuthenticationView.$r8$lambda$V65TBC8AwlUXZmd_4aBb2M2vZts(SwitchFaceAuthenticationView.this, dialogInterface, i);
            }
        };
        builder.MyBillsEntityDataFactory = R.drawable.BuiltInFictitiousFunctionClassFactory_res_0x7f0807f3;
        builder.moveToNextValue = getResources().getString(R.string.risk_reject_dialog_title);
        builder.PlaceComponentResult = getResources().getString(R.string.face_login_failed_cs);
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = getResources().getString(R.string.risk_reject_positive_button_msg);
        new DialogWithImage(getBaseActivity(), builder.lookAheadTest, builder, (byte) 0).MyBillsEntityDataFactory();
        PlaceComponentResult();
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        ImageView iconCellRight;
        ((LinearLayout) _$_findCachedViewById(R.id.btn_activate)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.richview.profile.switchfaceauth.SwitchFaceAuthenticationView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SwitchFaceAuthenticationView.$r8$lambda$BiehNM0uVWFZ6CXXJw7uX96blO8(SwitchFaceAuthenticationView.this, view);
            }
        });
        ((BlueSwitchView) _$_findCachedViewById(R.id.sv_enable_face_auth)).setOnTouchListener(new View.OnTouchListener() { // from class: id.dana.richview.profile.switchfaceauth.SwitchFaceAuthenticationView$$ExternalSyntheticLambda7
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean authRequestContext;
                authRequestContext = SwitchFaceAuthenticationView.getAuthRequestContext(SwitchFaceAuthenticationView.this);
                return authRequestContext;
            }
        });
        ((BlueSwitchView) _$_findCachedViewById(R.id.sv_enable_face_auth)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.richview.profile.switchfaceauth.SwitchFaceAuthenticationView$$ExternalSyntheticLambda1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                SwitchFaceAuthenticationView.$r8$lambda$TUuCVi70Z8ZCANgrzgIa5_Dg1A8(SwitchFaceAuthenticationView.this, compoundButton, z);
            }
        });
        DanaCellLeftView danaCellLeftView = (DanaCellLeftView) _$_findCachedViewById(R.id.setDrawValueAboveBar);
        if (danaCellLeftView != null && (iconCellRight = danaCellLeftView.getIconCellRight()) != null) {
            iconCellRight.setOnClickListener(new View.OnClickListener() { // from class: id.dana.richview.profile.switchfaceauth.SwitchFaceAuthenticationView$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SwitchFaceAuthenticationView.$r8$lambda$NT7dhHEP5HD5JsFZ08rKFvskNsM(SwitchFaceAuthenticationView.this, view);
                }
            });
        }
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null) {
            ((SettingMoreProfileActivity) baseActivity).setFaceAuthListener(new SettingMoreProfileActivity.Listener() { // from class: id.dana.richview.profile.switchfaceauth.SwitchFaceAuthenticationView$activityResultRendering$1
                @Override // id.dana.myprofile.SettingMoreProfileActivity.Listener
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    SwitchFaceAuthenticationView.this.MyBillsEntityDataFactory();
                    SwitchFaceAuthenticationView.this.MyBillsEntityDataFactory(Boolean.valueOf(!((BlueSwitchView) r0._$_findCachedViewById(R.id.sv_enable_face_auth)).isChecked()));
                }

                @Override // id.dana.myprofile.SettingMoreProfileActivity.Listener
                public final void BuiltInFictitiousFunctionClassFactory(String p0) {
                    if (!Intrinsics.areEqual(ChallengeControl.CancelReason.PIN_TEMPORARY_LOCKED, p0)) {
                        if (Intrinsics.areEqual("forgot_pin", p0)) {
                            SwitchFaceAuthenticationView.access$getSettingMoreProfileActivity(SwitchFaceAuthenticationView.this).getPhonePermission().check();
                        }
                    } else {
                        DialogWithImage.BuiltInFictitiousFunctionClassFactory(r2.getBaseActivity(), new DialogInterface.OnClickListener() { // from class: id.dana.richview.profile.switchfaceauth.SwitchFaceAuthenticationView$$ExternalSyntheticLambda8
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                SwitchFaceAuthenticationView.m2850$r8$lambda$bD2YO56sSnen_N5Jbl4G0bOEhM(SwitchFaceAuthenticationView.this, dialogInterface, i);
                            }
                        }).MyBillsEntityDataFactory();
                    }
                    SwitchFaceAuthenticationView.this.PlaceComponentResult();
                }
            });
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type id.dana.myprofile.SettingMoreProfileActivity");
    }
}
