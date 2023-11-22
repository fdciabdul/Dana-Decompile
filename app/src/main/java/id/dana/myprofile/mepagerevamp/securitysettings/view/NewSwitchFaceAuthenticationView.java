package id.dana.myprofile.mepagerevamp.securitysettings.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.afollestad.materialdialogs.MaterialDialog;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.challenge.ChallengeControl;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.core.ui.glide.GlideApp;
import id.dana.danah5.DanaH5;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.databinding.NewItemMenuSettingsFaceAuthBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerSwitchFaceAuthComponent;
import id.dana.di.modules.SwitchFaceAuthenticationModule;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.dialog.DialogWithImage;
import id.dana.dialog.TwoButtonWithImageDialog;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.myprofile.MyProfileBundleKey;
import id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity;
import id.dana.richview.BlueSwitchView;
import id.dana.riskChallenges.di.module.FaceAuthenticationModule;
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
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 _2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002`_B'\b\u0016\u0012\u0006\u0010W\u001a\u00020V\u0012\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010X\u0012\b\b\u0002\u0010Z\u001a\u00020\u0007¢\u0006\u0004\b[\u0010\\B+\b\u0016\u0012\u0006\u0010W\u001a\u00020V\u0012\b\u0010Y\u001a\u0004\u0018\u00010X\u0012\u0006\u0010Z\u001a\u00020\u0007\u0012\u0006\u0010]\u001a\u00020\u0007¢\u0006\u0004\b[\u0010^J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ+\u0010!\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001a2\u0006\u0010 \u001a\u00020\u0013H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0004H\u0016¢\u0006\u0004\b#\u0010\u0006J\u000f\u0010$\u001a\u00020\u0004H\u0016¢\u0006\u0004\b$\u0010\u0006J\u000f\u0010%\u001a\u00020\u0004H\u0016¢\u0006\u0004\b%\u0010\u0006J\u0019\u0010&\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0004H\u0002¢\u0006\u0004\b(\u0010\u0006J\u0015\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0004H\u0016¢\u0006\u0004\b-\u0010\u0006J\u000f\u0010.\u001a\u00020\u0004H\u0016¢\u0006\u0004\b.\u0010\u0006J\u000f\u0010/\u001a\u00020\u0004H\u0002¢\u0006\u0004\b/\u0010\u0006J\u000f\u00100\u001a\u00020\u0004H\u0016¢\u0006\u0004\b0\u0010\u0006J\u000f\u00101\u001a\u00020\u0004H\u0002¢\u0006\u0004\b1\u0010\u0006J\u0019\u00103\u001a\u00020\u00042\b\u00102\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b3\u0010'J\u000f\u00103\u001a\u00020\u0004H\u0002¢\u0006\u0004\b3\u0010\u0006J\u000f\u00104\u001a\u00020\u0004H\u0016¢\u0006\u0004\b4\u0010\u0006J\u0017\u0010/\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u0013H\u0002¢\u0006\u0004\b/\u00105R\u0016\u0010\n\u001a\u0002068\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b/\u00107R\"\u00109\u001a\u0002088\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0013\u00101\u001a\u00020?X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\n\u0010@R\u0016\u00103\u001a\u00020A8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b1\u0010BR*\u0010E\u001a\u00020\u00132\u0006\u0010C\u001a\u00020\u00138\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010D\u001a\u0004\bE\u0010\u0015\"\u0004\bF\u00105R\u0016\u0010(\u001a\u00020\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b(\u0010DR\u0016\u0010/\u001a\u00020)8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010N\u001a\u00020A8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bM\u0010BR\u0016\u0010M\u001a\u00020A8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bL\u0010BR\"\u0010P\u001a\u00020O8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010U"}, d2 = {"Lid/dana/myprofile/mepagerevamp/securitysettings/view/NewSwitchFaceAuthenticationView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/NewItemMenuSettingsFaceAuthBinding;", "Lid/dana/switchfaceauth/SwitchFaceAuthContract$View;", "", "dismissProgress", "()V", "", "getLayout", "()I", "getAuthRequestContext", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/NewItemMenuSettingsFaceAuthBinding;", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "", "isForRecyclerViewholder", "()Z", "Lid/dana/domain/profilemenu/model/SettingModel;", "data", "onBind", "(Lid/dana/domain/profilemenu/model/SettingModel;)V", "", "errorMessage", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(Ljava/lang/String;)V", BioUtilityBridge.SECURITY_ID, RecordError.KEY_PUB_KEY, "faceAuthNew", "onFaceSwitchRiskChallenge", "(Ljava/lang/String;Ljava/lang/String;Z)V", "onFailFaceEnroll", "onFailFaceQuery", "onFailToggle", "onSuccessFaceSwitch", "(Ljava/lang/Boolean;)V", "PlaceComponentResult", "Lid/dana/myprofile/mepagerevamp/securitysettings/view/NewSwitchFaceAuthenticationView$AuthFaceListener;", "authFaceListener", "setAuthListener", "(Lid/dana/myprofile/mepagerevamp/securitysettings/view/NewSwitchFaceAuthenticationView$AuthFaceListener;)V", "setFaceAuthSwitchOn", "setup", "KClassImpl$Data$declaredNonStaticMembers$2", "showProgress", "BuiltInFictitiousFunctionClassFactory", "p0", "MyBillsEntityDataFactory", "toKYC", "(Z)V", "Lid/dana/dialog/DanaLoadingDialog;", "Lid/dana/dialog/DanaLoadingDialog;", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "dynamicUrlWrapper", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "getDynamicUrlWrapper", "()Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "setDynamicUrlWrapper", "(Lid/dana/data/dynamicurl/DynamicUrlWrapper;)V", "Lcom/afollestad/materialdialogs/MaterialDialog;", "Lkotlin/Lazy;", "Lid/dana/dialog/TwoButtonWithImageDialog;", "Lid/dana/dialog/TwoButtonWithImageDialog;", "value", "Z", "isFaceLoginEnabled", "setFaceLoginEnabled", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/myprofile/mepagerevamp/securitysettings/view/NewSwitchFaceAuthenticationView$AuthFaceListener;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "lookAheadTest", "Lcom/ethanhua/skeleton/SkeletonScreen;", "getErrorConfigVersion", "scheduleImpl", "moveToNextValue", "Lid/dana/switchfaceauth/SwitchFaceAuthPresenter;", "switchFaceAuthPresenter", "Lid/dana/switchfaceauth/SwitchFaceAuthPresenter;", "getSwitchFaceAuthPresenter", "()Lid/dana/switchfaceauth/SwitchFaceAuthPresenter;", "setSwitchFaceAuthPresenter", "(Lid/dana/switchfaceauth/SwitchFaceAuthPresenter;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "AuthFaceListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewSwitchFaceAuthenticationView extends ViewBindingRichView<NewItemMenuSettingsFaceAuthBinding> implements SwitchFaceAuthContract.View {
    public static final String DISABLED = "DISABLED";
    public static final String ENROLLED = "ENROLLED";
    public static final String ERROR_FETCH = "ERROR_FETCH";
    public static final String FETCHING = "FETCHING";
    public static final String NETWORK_EXCEPTION = "The network is not available";
    public static final String NOT_ENROLLED = "NOT_ENROLLED";

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private TwoButtonWithImageDialog MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private DanaLoadingDialog getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private boolean isFaceLoginEnabled;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private AuthFaceListener KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean PlaceComponentResult;
    public Map<Integer, View> _$_findViewCache;
    @Inject
    public DynamicUrlWrapper dynamicUrlWrapper;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private TwoButtonWithImageDialog scheduleImpl;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private SkeletonScreen getErrorConfigVersion;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private TwoButtonWithImageDialog moveToNextValue;
    @Inject
    public SwitchFaceAuthPresenter switchFaceAuthPresenter;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/myprofile/mepagerevamp/securitysettings/view/NewSwitchFaceAuthenticationView$AuthFaceListener;", "", "", "p0", "", "getAuthRequestContext", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface AuthFaceListener {
        void getAuthRequestContext();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewSwitchFaceAuthenticationView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewSwitchFaceAuthenticationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
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
        return R.layout.new_item_menu_settings_face_auth;
    }

    @Override // id.dana.base.BaseRichView
    public final boolean isForRecyclerViewholder() {
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewSwitchFaceAuthenticationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<MaterialDialog>() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.view.NewSwitchFaceAuthenticationView$faceVerificationInfoDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MaterialDialog invoke() {
                Context context2 = NewSwitchFaceAuthenticationView.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "");
                CustomDialog.Builder builder = new CustomDialog.Builder(context2);
                builder.DatabaseTableConfigUtil = R.drawable.ic_illustration_general_selfie;
                builder.SubSequence = NewSwitchFaceAuthenticationView.this.getResources().getString(R.string.face_verification_info_title);
                builder.GetContactSyncConfig = NewSwitchFaceAuthenticationView.this.getResources().getString(R.string.face_verification_info_message);
                String string = NewSwitchFaceAuthenticationView.this.getResources().getString(R.string.face_verification_info_button);
                final NewSwitchFaceAuthenticationView newSwitchFaceAuthenticationView = NewSwitchFaceAuthenticationView.this;
                return builder.BuiltInFictitiousFunctionClassFactory(string, new Function1<View, Unit>() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.view.NewSwitchFaceAuthenticationView$faceVerificationInfoDialog$2.1
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
                        NewSwitchFaceAuthenticationView.access$getFaceVerificationInfoDialog(NewSwitchFaceAuthenticationView.this).dismiss();
                    }
                }).KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false).BuiltInFictitiousFunctionClassFactory();
            }
        });
    }

    public /* synthetic */ NewSwitchFaceAuthenticationView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewSwitchFaceAuthenticationView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<MaterialDialog>() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.view.NewSwitchFaceAuthenticationView$faceVerificationInfoDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MaterialDialog invoke() {
                Context context2 = NewSwitchFaceAuthenticationView.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "");
                CustomDialog.Builder builder = new CustomDialog.Builder(context2);
                builder.DatabaseTableConfigUtil = R.drawable.ic_illustration_general_selfie;
                builder.SubSequence = NewSwitchFaceAuthenticationView.this.getResources().getString(R.string.face_verification_info_title);
                builder.GetContactSyncConfig = NewSwitchFaceAuthenticationView.this.getResources().getString(R.string.face_verification_info_message);
                String string = NewSwitchFaceAuthenticationView.this.getResources().getString(R.string.face_verification_info_button);
                final NewSwitchFaceAuthenticationView newSwitchFaceAuthenticationView = NewSwitchFaceAuthenticationView.this;
                return builder.BuiltInFictitiousFunctionClassFactory(string, new Function1<View, Unit>() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.view.NewSwitchFaceAuthenticationView$faceVerificationInfoDialog$2.1
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
                        NewSwitchFaceAuthenticationView.access$getFaceVerificationInfoDialog(NewSwitchFaceAuthenticationView.this).dismiss();
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

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final NewItemMenuSettingsFaceAuthBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        NewItemMenuSettingsFaceAuthBinding BuiltInFictitiousFunctionClassFactory = NewItemMenuSettingsFaceAuthBinding.BuiltInFictitiousFunctionClassFactory(view);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    public static final boolean getAuthRequestContext(NewSwitchFaceAuthenticationView newSwitchFaceAuthenticationView) {
        Intrinsics.checkNotNullParameter(newSwitchFaceAuthenticationView, "");
        newSwitchFaceAuthenticationView.PlaceComponentResult = true;
        return false;
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
        ColorStateList KClassImpl$Data$declaredNonStaticMembers$2;
        ColorStateList KClassImpl$Data$declaredNonStaticMembers$22;
        if (p0) {
            BlueSwitchView blueSwitchView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
            KClassImpl$Data$declaredNonStaticMembers$22 = ResourcesCompat.KClassImpl$Data$declaredNonStaticMembers$2(r0.getResources(), R.color.azure, getContext().getTheme());
            blueSwitchView.setTrackTintList(KClassImpl$Data$declaredNonStaticMembers$22);
            return;
        }
        BlueSwitchView blueSwitchView2 = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2 = ResourcesCompat.KClassImpl$Data$declaredNonStaticMembers$2(r0.getResources(), R.color.f27012131100470, getContext().getTheme());
        blueSwitchView2.setTrackTintList(KClassImpl$Data$declaredNonStaticMembers$2);
    }

    @Override // id.dana.base.BaseRichView
    public final void injectComponent(ApplicationComponent applicationComponent) {
        DaggerSwitchFaceAuthComponent.Builder authRequestContext = DaggerSwitchFaceAuthComponent.getAuthRequestContext();
        authRequestContext.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        authRequestContext.PlaceComponentResult = (SwitchFaceAuthenticationModule) Preconditions.getAuthRequestContext(new SwitchFaceAuthenticationModule(this));
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = (FaceAuthenticationModule) Preconditions.getAuthRequestContext(new FaceAuthenticationModule());
        authRequestContext.BuiltInFictitiousFunctionClassFactory().KClassImpl$Data$declaredNonStaticMembers$2(this);
        registerPresenter(getSwitchFaceAuthPresenter());
    }

    public final void onBind(SettingModel data) {
        AppCompatImageView appCompatImageView;
        if (data == null || !isBindingInitialized()) {
            return;
        }
        String iconUrl = data.getIconUrl();
        if (iconUrl == null) {
            iconUrl = "";
        }
        if ((iconUrl.length() > 0) && (appCompatImageView = getBinding().PlaceComponentResult) != null) {
            GlideApp.getAuthRequestContext(appCompatImageView.getContext()).PlaceComponentResult(iconUrl).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).getErrorConfigVersion((int) R.drawable.res_0x7f080633_networkuserentitydata_externalsyntheticlambda2).PlaceComponentResult((int) R.drawable.res_0x7f080633_networkuserentitydata_externalsyntheticlambda2).MyBillsEntityDataFactory((ImageView) appCompatImageView);
            appCompatImageView.setVisibility(0);
        }
        getBinding().getErrorConfigVersion.setCellLabelIcon(data.getTitle(), R.drawable.ic_info_blue);
        String enrolmentState = data.getEnrolmentState();
        String str = enrolmentState != null ? enrolmentState : "";
        SkeletonScreen skeletonScreen = this.getErrorConfigVersion;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
        this.getErrorConfigVersion = null;
        int hashCode = str.hashCode();
        if (hashCode != -2056700541) {
            if (hashCode != -1371440187) {
                if (hashCode == 1053567612 && str.equals(DISABLED)) {
                    getBinding().MyBillsEntityDataFactory.setVisibility(8);
                    getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(0);
                    getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setChecked(false);
                    getBinding().BuiltInFictitiousFunctionClassFactory.setVisibility(8);
                    return;
                }
            } else if (str.equals(ENROLLED)) {
                getBinding().MyBillsEntityDataFactory.setVisibility(8);
                getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(0);
                getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setChecked(true);
                getBinding().BuiltInFictitiousFunctionClassFactory.setVisibility(8);
                return;
            }
        } else if (str.equals(ERROR_FETCH)) {
            getBinding().MyBillsEntityDataFactory.setVisibility(8);
            getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(8);
            getBinding().BuiltInFictitiousFunctionClassFactory.setVisibility(8);
            return;
        }
        getBinding().MyBillsEntityDataFactory.setVisibility(0);
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(8);
        getBinding().BuiltInFictitiousFunctionClassFactory.setVisibility(8);
        if (Intrinsics.areEqual(str, FETCHING)) {
            MyBillsEntityDataFactory();
        }
    }

    @Override // id.dana.switchfaceauth.SwitchFaceAuthContract.View
    public final void onFaceSwitchRiskChallenge(String r3, String r4, boolean faceAuthNew) {
        BaseActivity baseActivity = getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        ChallengeControl.Builder builder = new ChallengeControl.Builder(baseActivity);
        builder.scheduleImpl = "face_activation";
        builder.VerifyPinStateManager$executeRiskChallenge$2$1 = ChallengeControl.Key.FACE_ACTIVATION_SMART_PAY;
        new ChallengeControl(builder.MyBillsEntityDataFactory(getBinding().KClassImpl$Data$declaredNonStaticMembers$2.isChecked(), r3, r4, faceAuthNew), null).getAuthRequestContext();
    }

    @Override // id.dana.switchfaceauth.SwitchFaceAuthContract.View
    public final void onSuccessFaceSwitch(Boolean faceAuthNew) {
        BuiltInFictitiousFunctionClassFactory();
        MyBillsEntityDataFactory(faceAuthNew);
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        if (getBinding().MyBillsEntityDataFactory.getVisibility() == 0) {
            TwoButtonWithImageDialog.Builder builder = new TwoButtonWithImageDialog.Builder(getContext());
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.ic_faceenrol_verify;
            builder.FragmentBottomSheetPaymentSettingBinding = getResources().getString(R.string.login_face_success_title);
            builder.getErrorConfigVersion = getResources().getString(R.string.login_face_success_desc);
            TwoButtonWithImageDialog.Builder MyBillsEntityDataFactory = builder.PlaceComponentResult(false).MyBillsEntityDataFactory(false);
            String string = getResources().getString(R.string.res_0x7f130923_otpregistrationpresenter_input_2);
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.view.NewSwitchFaceAuthenticationView$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NewSwitchFaceAuthenticationView.$r8$lambda$MVQdlFXCVlaUVORoBp0l1O0B444(NewSwitchFaceAuthenticationView.this, view);
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

    public final void MyBillsEntityDataFactory(Boolean p0) {
        if (getBinding().KClassImpl$Data$declaredNonStaticMembers$2.getVisibility() == 0) {
            if (Intrinsics.areEqual(p0, Boolean.TRUE)) {
                BaseActivity baseActivity = getBaseActivity();
                Intrinsics.checkNotNullExpressionValue(baseActivity, "");
                CustomToastUtil.PlaceComponentResult(baseActivity, R.drawable.ic_success, R.drawable.bg_rounded_toast_success, getResources().getString(R.string.enabled_face_verification), 48, 60, false, null, 384);
                AuthFaceListener authFaceListener = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (authFaceListener == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    authFaceListener = null;
                }
                authFaceListener.getAuthRequestContext();
                return;
            }
            BaseActivity baseActivity2 = getBaseActivity();
            Intrinsics.checkNotNullExpressionValue(baseActivity2, "");
            CustomToastUtil.PlaceComponentResult(baseActivity2, R.drawable.ic_success, R.drawable.bg_rounded_toast_success, getResources().getString(R.string.disabled_face_verification), 48, 60, false, null, 384);
            getAuthRequestContext();
        }
    }

    private final void getAuthRequestContext() {
        Intent intent = new Intent(getBaseActivity(), SecuritySettingsActivity.class);
        intent.putExtra(MyProfileBundleKey.SETTING_MODEL, new SettingModel());
        getBaseActivity().startActivity(intent);
    }

    public final void setAuthListener(AuthFaceListener authFaceListener) {
        Intrinsics.checkNotNullParameter(authFaceListener, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = authFaceListener;
    }

    public final void onFailFaceQuery() {
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.switchfaceauth.SwitchFaceAuthContract.View
    public final void onFailFaceEnroll() {
        KClassImpl$Data$declaredNonStaticMembers$2();
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
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.view.NewSwitchFaceAuthenticationView$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewSwitchFaceAuthenticationView.m2697$r8$lambda$VrBrTlnSxq1Bacnnvw6zX94KVM(NewSwitchFaceAuthenticationView.this, view);
            }
        };
        builder.NetworkUserEntityData$$ExternalSyntheticLambda8 = string;
        builder.NetworkUserEntityData$$ExternalSyntheticLambda4 = onClickListener;
        String string2 = getResources().getString(R.string.option_cancel);
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.view.NewSwitchFaceAuthenticationView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewSwitchFaceAuthenticationView.m2696$r8$lambda$Dw4gONKkezaB0XUhOxRHKWYSnE(NewSwitchFaceAuthenticationView.this, view);
            }
        };
        builder.NetworkUserEntityData$$ExternalSyntheticLambda2 = string2;
        builder.DatabaseTableConfigUtil = onClickListener2;
        TwoButtonWithImageDialog KClassImpl$Data$declaredNonStaticMembers$2 = builder.KClassImpl$Data$declaredNonStaticMembers$2();
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        this.scheduleImpl = KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
    }

    public final void setFaceAuthSwitchOn() {
        SwitchFaceAuthPresenter switchFaceAuthPresenter = getSwitchFaceAuthPresenter();
        BaseActivity baseActivity = getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        switchFaceAuthPresenter.MyBillsEntityDataFactory(true, null, baseActivity);
    }

    public final void PlaceComponentResult() {
        if (getBinding().KClassImpl$Data$declaredNonStaticMembers$2.getVisibility() == 0) {
            getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setChecked(!getBinding().KClassImpl$Data$declaredNonStaticMembers$2.isChecked());
            KClassImpl$Data$declaredNonStaticMembers$2(getBinding().KClassImpl$Data$declaredNonStaticMembers$2.isChecked());
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

    @Override // id.dana.base.AbstractContract.AbstractView
    public final void onError(String str) {
        byte b = 0;
        if (str != null && StringsKt.contains$default((CharSequence) str, (CharSequence) NETWORK_EXCEPTION, false, 2, (Object) null)) {
            KClassImpl$Data$declaredNonStaticMembers$2();
        } else {
            DialogWithImage.Builder builder = new DialogWithImage.Builder();
            builder.BuiltInFictitiousFunctionClassFactory = new DialogInterface.OnClickListener() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.view.NewSwitchFaceAuthenticationView$$ExternalSyntheticLambda8
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    NewSwitchFaceAuthenticationView.$r8$lambda$AEiUcaRjV82LCvzrW0S_gsSdBl0(NewSwitchFaceAuthenticationView.this, dialogInterface, i);
                }
            };
            builder.MyBillsEntityDataFactory = R.drawable.BuiltInFictitiousFunctionClassFactory_res_0x7f0807f3;
            builder.moveToNextValue = getResources().getString(R.string.risk_reject_dialog_title);
            builder.PlaceComponentResult = getResources().getString(R.string.face_login_failed_cs);
            builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = getResources().getString(R.string.risk_reject_positive_button_msg);
            new DialogWithImage(getBaseActivity(), builder.lookAheadTest, builder, b).MyBillsEntityDataFactory();
        }
        PlaceComponentResult();
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        TwoButtonWithImageDialog.Builder builder = new TwoButtonWithImageDialog.Builder(getContext());
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.ic_faceenrol_invalid;
        builder.FragmentBottomSheetPaymentSettingBinding = getResources().getString(R.string.login_face_fail_title);
        builder.getErrorConfigVersion = getResources().getString(R.string.login_face_fail_desc);
        TwoButtonWithImageDialog.Builder MyBillsEntityDataFactory = builder.PlaceComponentResult(false).MyBillsEntityDataFactory(false);
        String string = getResources().getString(R.string.try_again);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.view.NewSwitchFaceAuthenticationView$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewSwitchFaceAuthenticationView.$r8$lambda$PjW1BIjMhU3S_gzY7GY9bTjaIxI(NewSwitchFaceAuthenticationView.this, view);
            }
        };
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda8 = string;
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda4 = onClickListener;
        String string2 = getResources().getString(R.string.later);
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.view.NewSwitchFaceAuthenticationView$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewSwitchFaceAuthenticationView.$r8$lambda$tWI2aqCSizIrZs49wvcO0MZgvL0(NewSwitchFaceAuthenticationView.this, view);
            }
        };
        MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2 = string2;
        MyBillsEntityDataFactory.DatabaseTableConfigUtil = onClickListener2;
        TwoButtonWithImageDialog KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        this.MyBillsEntityDataFactory = KClassImpl$Data$declaredNonStaticMembers$2;
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
    }

    @JvmName(name = "isFaceLoginEnabled")
    /* renamed from: isFaceLoginEnabled  reason: from getter */
    public final boolean getIsFaceLoginEnabled() {
        return this.isFaceLoginEnabled;
    }

    @JvmName(name = "setFaceLoginEnabled")
    public final void setFaceLoginEnabled(boolean z) {
        this.isFaceLoginEnabled = z;
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setChecked(z);
    }

    public static /* synthetic */ void $r8$lambda$AEiUcaRjV82LCvzrW0S_gsSdBl0(NewSwitchFaceAuthenticationView newSwitchFaceAuthenticationView, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(newSwitchFaceAuthenticationView, "");
        Intrinsics.checkNotNullParameter(dialogInterface, "");
        if (-1 == i) {
            BaseActivity baseActivity = newSwitchFaceAuthenticationView.getBaseActivity();
            if (baseActivity != null) {
                ((SecuritySettingsActivity) baseActivity).getPhonePermission().check();
                dialogInterface.dismiss();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity");
        }
    }

    /* renamed from: $r8$lambda$Dw4gO-NKkezaB0XUhOxRHKWYSnE */
    public static /* synthetic */ void m2696$r8$lambda$Dw4gONKkezaB0XUhOxRHKWYSnE(NewSwitchFaceAuthenticationView newSwitchFaceAuthenticationView, View view) {
        Intrinsics.checkNotNullParameter(newSwitchFaceAuthenticationView, "");
        TwoButtonWithImageDialog twoButtonWithImageDialog = newSwitchFaceAuthenticationView.scheduleImpl;
        if (twoButtonWithImageDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            twoButtonWithImageDialog = null;
        }
        twoButtonWithImageDialog.getAuthRequestContext();
    }

    public static /* synthetic */ void $r8$lambda$MVQdlFXCVlaUVORoBp0l1O0B444(NewSwitchFaceAuthenticationView newSwitchFaceAuthenticationView, View view) {
        Intrinsics.checkNotNullParameter(newSwitchFaceAuthenticationView, "");
        TwoButtonWithImageDialog twoButtonWithImageDialog = newSwitchFaceAuthenticationView.moveToNextValue;
        if (twoButtonWithImageDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            twoButtonWithImageDialog = null;
        }
        twoButtonWithImageDialog.getAuthRequestContext();
    }

    public static /* synthetic */ void $r8$lambda$PZerMJNtom74uqC7zDNRjkRXgJ0(NewSwitchFaceAuthenticationView newSwitchFaceAuthenticationView, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(newSwitchFaceAuthenticationView, "");
        Intrinsics.checkNotNullParameter(dialogInterface, "");
        if (i != -2) {
            if (i != -1) {
                return;
            }
            BaseActivity baseActivity = newSwitchFaceAuthenticationView.getBaseActivity();
            if (baseActivity != null) {
                ((SecuritySettingsActivity) baseActivity).getPhonePermission().check();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity");
            }
        }
        dialogInterface.dismiss();
    }

    public static /* synthetic */ void $r8$lambda$PjW1BIjMhU3S_gzY7GY9bTjaIxI(NewSwitchFaceAuthenticationView newSwitchFaceAuthenticationView, View view) {
        Intrinsics.checkNotNullParameter(newSwitchFaceAuthenticationView, "");
        SwitchFaceAuthPresenter switchFaceAuthPresenter = newSwitchFaceAuthenticationView.getSwitchFaceAuthPresenter();
        BaseActivity baseActivity = newSwitchFaceAuthenticationView.getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        switchFaceAuthPresenter.MyBillsEntityDataFactory(true, null, baseActivity);
    }

    public static /* synthetic */ void $r8$lambda$RsycWnGmPCywDjwPjW_4qbapqJc(NewSwitchFaceAuthenticationView newSwitchFaceAuthenticationView, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(newSwitchFaceAuthenticationView, "");
        if (newSwitchFaceAuthenticationView.PlaceComponentResult) {
            newSwitchFaceAuthenticationView.PlaceComponentResult = false;
            SwitchFaceAuthPresenter switchFaceAuthPresenter = newSwitchFaceAuthenticationView.getSwitchFaceAuthPresenter();
            BaseActivity baseActivity = newSwitchFaceAuthenticationView.getBaseActivity();
            Intrinsics.checkNotNullExpressionValue(baseActivity, "");
            switchFaceAuthPresenter.MyBillsEntityDataFactory(z, null, baseActivity);
        }
        newSwitchFaceAuthenticationView.KClassImpl$Data$declaredNonStaticMembers$2(z);
    }

    public static /* synthetic */ void $r8$lambda$SGrr9bL3hSfGAvTloUIgwr14J5w(NewSwitchFaceAuthenticationView newSwitchFaceAuthenticationView, View view) {
        Intrinsics.checkNotNullParameter(newSwitchFaceAuthenticationView, "");
        ((MaterialDialog) newSwitchFaceAuthenticationView.BuiltInFictitiousFunctionClassFactory.getValue()).show();
    }

    /* renamed from: $r8$lambda$VrBrT-lnSxq1Bacnnvw6zX94KVM */
    public static /* synthetic */ void m2697$r8$lambda$VrBrTlnSxq1Bacnnvw6zX94KVM(NewSwitchFaceAuthenticationView newSwitchFaceAuthenticationView, View view) {
        Intrinsics.checkNotNullParameter(newSwitchFaceAuthenticationView, "");
        TwoButtonWithImageDialog twoButtonWithImageDialog = newSwitchFaceAuthenticationView.scheduleImpl;
        if (twoButtonWithImageDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            twoButtonWithImageDialog = null;
        }
        twoButtonWithImageDialog.getAuthRequestContext();
        String kycFromProfileUrl = newSwitchFaceAuthenticationView.getDynamicUrlWrapper().getKycFromProfileUrl();
        Intrinsics.checkNotNullExpressionValue(kycFromProfileUrl, "");
        String authRequestContext = UrlUtil.getAuthRequestContext(kycFromProfileUrl);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        DanaH5.startContainerFullUrl(authRequestContext, new DanaH5Listener() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.view.NewSwitchFaceAuthenticationView$openH5Container$$inlined$withDanaH5Callback$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerCreated(Bundle p0) {
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public final void onContainerDestroyed(Bundle p0) {
            }
        });
    }

    /* renamed from: $r8$lambda$jD-VvHmRsapFIffHSZQT-MCGPt8 */
    public static /* synthetic */ void m2698$r8$lambda$jDVvHmRsapFIffHSZQTMCGPt8(NewSwitchFaceAuthenticationView newSwitchFaceAuthenticationView, View view) {
        Intrinsics.checkNotNullParameter(newSwitchFaceAuthenticationView, "");
        SwitchFaceAuthPresenter switchFaceAuthPresenter = newSwitchFaceAuthenticationView.getSwitchFaceAuthPresenter();
        BaseActivity baseActivity = newSwitchFaceAuthenticationView.getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        switchFaceAuthPresenter.MyBillsEntityDataFactory(true, null, baseActivity);
    }

    public static /* synthetic */ void $r8$lambda$tWI2aqCSizIrZs49wvcO0MZgvL0(NewSwitchFaceAuthenticationView newSwitchFaceAuthenticationView, View view) {
        Intrinsics.checkNotNullParameter(newSwitchFaceAuthenticationView, "");
        TwoButtonWithImageDialog twoButtonWithImageDialog = newSwitchFaceAuthenticationView.MyBillsEntityDataFactory;
        if (twoButtonWithImageDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            twoButtonWithImageDialog = null;
        }
        twoButtonWithImageDialog.getAuthRequestContext();
    }

    public static final /* synthetic */ MaterialDialog access$getFaceVerificationInfoDialog(NewSwitchFaceAuthenticationView newSwitchFaceAuthenticationView) {
        return (MaterialDialog) newSwitchFaceAuthenticationView.BuiltInFictitiousFunctionClassFactory.getValue();
    }

    public static final /* synthetic */ SecuritySettingsActivity access$getSecuritySettingsActivity(NewSwitchFaceAuthenticationView newSwitchFaceAuthenticationView) {
        BaseActivity baseActivity = newSwitchFaceAuthenticationView.getBaseActivity();
        if (baseActivity != null) {
            return (SecuritySettingsActivity) baseActivity;
        }
        throw new NullPointerException("null cannot be cast to non-null type id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity");
    }

    private final void MyBillsEntityDataFactory() {
        SkeletonScreen skeletonScreen = this.getErrorConfigVersion;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
        this.getErrorConfigVersion = null;
        ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(getBinding().MyBillsEntityDataFactory);
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.view_subtitle_me_page_skeleton;
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 20;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = 1500;
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.f27082131100491);
        ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
        viewSkeletonScreen.MyBillsEntityDataFactory();
        this.getErrorConfigVersion = viewSkeletonScreen;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        getBinding().MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.view.NewSwitchFaceAuthenticationView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewSwitchFaceAuthenticationView.m2698$r8$lambda$jDVvHmRsapFIffHSZQTMCGPt8(NewSwitchFaceAuthenticationView.this, view);
            }
        });
        MyBillsEntityDataFactory();
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setOnTouchListener(new View.OnTouchListener() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.view.NewSwitchFaceAuthenticationView$$ExternalSyntheticLambda9
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean authRequestContext;
                authRequestContext = NewSwitchFaceAuthenticationView.getAuthRequestContext(NewSwitchFaceAuthenticationView.this);
                return authRequestContext;
            }
        });
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.view.NewSwitchFaceAuthenticationView$$ExternalSyntheticLambda2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                NewSwitchFaceAuthenticationView.$r8$lambda$RsycWnGmPCywDjwPjW_4qbapqJc(NewSwitchFaceAuthenticationView.this, compoundButton, z);
            }
        });
        ImageView iconCellRight = getBinding().getErrorConfigVersion.getIconCellRight();
        if (iconCellRight != null) {
            iconCellRight.setOnClickListener(new View.OnClickListener() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.view.NewSwitchFaceAuthenticationView$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NewSwitchFaceAuthenticationView.$r8$lambda$SGrr9bL3hSfGAvTloUIgwr14J5w(NewSwitchFaceAuthenticationView.this, view);
                }
            });
        }
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null) {
            ((SecuritySettingsActivity) baseActivity).setFaceAuthListener(new SecuritySettingsActivity.Listener() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.view.NewSwitchFaceAuthenticationView$activityResultRendering$1
                @Override // id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity.Listener
                public final void MyBillsEntityDataFactory() {
                    NewItemMenuSettingsFaceAuthBinding binding;
                    NewSwitchFaceAuthenticationView.this.BuiltInFictitiousFunctionClassFactory();
                    NewSwitchFaceAuthenticationView newSwitchFaceAuthenticationView = NewSwitchFaceAuthenticationView.this;
                    binding = newSwitchFaceAuthenticationView.getBinding();
                    newSwitchFaceAuthenticationView.MyBillsEntityDataFactory(Boolean.valueOf(binding.KClassImpl$Data$declaredNonStaticMembers$2.isChecked()));
                }

                @Override // id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity.Listener
                public final void BuiltInFictitiousFunctionClassFactory(String p0) {
                    if (!Intrinsics.areEqual(ChallengeControl.CancelReason.PIN_TEMPORARY_LOCKED, p0)) {
                        if (Intrinsics.areEqual("forgot_pin", p0)) {
                            NewSwitchFaceAuthenticationView.access$getSecuritySettingsActivity(NewSwitchFaceAuthenticationView.this).getPhonePermission().check();
                        }
                    } else {
                        DialogWithImage.BuiltInFictitiousFunctionClassFactory(r2.getBaseActivity(), new DialogInterface.OnClickListener() { // from class: id.dana.myprofile.mepagerevamp.securitysettings.view.NewSwitchFaceAuthenticationView$$ExternalSyntheticLambda3
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                NewSwitchFaceAuthenticationView.$r8$lambda$PZerMJNtom74uqC7zDNRjkRXgJ0(NewSwitchFaceAuthenticationView.this, dialogInterface, i);
                            }
                        }).MyBillsEntityDataFactory();
                    }
                    NewSwitchFaceAuthenticationView.this.PlaceComponentResult();
                }

                @Override // id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity.Listener
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    NewSwitchFaceAuthenticationView.this.KClassImpl$Data$declaredNonStaticMembers$2();
                }
            });
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type id.dana.myprofile.mepagerevamp.securitysettings.SecuritySettingsActivity");
    }
}
