package id.dana.onboarding.createpin;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.metrics.Trace;
import com.zhuinden.simplestack.History;
import id.dana.R;
import id.dana.analytics.firebase.FirebasePerformanceMonitor;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.BaseActivity;
import id.dana.base.KeyBaseActivity;
import id.dana.base.KeyBaseFragment;
import id.dana.base.MenuItemButtonListener;
import id.dana.core.ui.richview.PinEntryEditText;
import id.dana.databinding.FragmentCreatePinBinding;
import id.dana.onboarding.OnboardingActivity;
import id.dana.onboarding.OnboardingNavigationManagerWithMenu;
import id.dana.onboarding.track.OnboardingFirebaseTracker;
import id.dana.onboarding.verify.VerifyNumberKey;
import id.dana.performancetracker.AppReadyMixpanelTracker;
import id.dana.textbehavior.OnValidatedListener;
import id.dana.textbehavior.TextBehavior;
import id.dana.textbehavior.validate.OrderedAscendingValidator;
import id.dana.textbehavior.validate.OrderedDescendingValidator;
import id.dana.textbehavior.validate.RepeatedStringValidator;
import id.dana.textbehavior.validate.Validator;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.measureloadscreen.FirstDrawListener;
import id.dana.utils.measureloadscreen.MeasureLoadAndRenderingScreen;
import id.dana.utils.measureloadscreen.MeasureLoadAndRenderingScreen$stopTracking$1;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 *2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001*B\u0007¢\u0006\u0004\b)\u0010\u0007J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000b\u0010\u0007J\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0013\u0010\u0007J\u000f\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0007R\u0016\u0010\u0013\u001a\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0006\u001a\u00020\u001cX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0016\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010 R\u0016\u0010\u001f\u001a\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b#\u0010\u0017R\u0018\u0010\u001d\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010\u0019\u001a\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b'\u0010\u0017R\u0016\u0010!\u001a\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b(\u0010\u0017"}, d2 = {"Lid/dana/onboarding/createpin/CreatePinFragment;", "Lid/dana/base/KeyBaseFragment;", "Lid/dana/onboarding/OnboardingActivity;", "Lid/dana/onboarding/createpin/CreatePinKey;", "Lid/dana/databinding/FragmentCreatePinBinding;", "", "getAuthRequestContext", "()V", "", "getLayout", "()I", IAPSyncCommand.COMMAND_INIT, "Landroid/content/Context;", "p0", "onAttach", "(Landroid/content/Context;)V", "", "onBackPressed", "()Z", "BuiltInFictitiousFunctionClassFactory", "onStart", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "Lid/dana/utils/measureloadscreen/MeasureLoadAndRenderingScreen;", "moveToNextValue", "Lid/dana/utils/measureloadscreen/MeasureLoadAndRenderingScreen;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/analytics/firebase/FirebasePerformanceMonitor;", "getErrorConfigVersion", "Lkotlin/Lazy;", "lookAheadTest", "Z", "NetworkUserEntityData$$ExternalSyntheticLambda0", "PlaceComponentResult", "scheduleImpl", "Lid/dana/onboarding/OnboardingNavigationManagerWithMenu;", "GetContactSyncConfig", "Lid/dana/onboarding/OnboardingNavigationManagerWithMenu;", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda2", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CreatePinFragment extends KeyBaseFragment<OnboardingActivity, CreatePinKey, FragmentCreatePinBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private OnboardingNavigationManagerWithMenu getErrorConfigVersion;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private String moveToNextValue;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private String lookAheadTest;
    public Map<Integer, View> PlaceComponentResult = new LinkedHashMap();

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext = LazyKt.lazy(new Function0<FirebasePerformanceMonitor>() { // from class: id.dana.onboarding.createpin.CreatePinFragment$firebasePerformanceMonitor$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FirebasePerformanceMonitor invoke() {
            return FirebasePerformanceMonitor.INSTANCE.MyBillsEntityDataFactory();
        }
    });

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final MeasureLoadAndRenderingScreen KClassImpl$Data$declaredNonStaticMembers$2 = new MeasureLoadAndRenderingScreen();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private boolean PlaceComponentResult = true;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory = true;

    @Override // id.dana.base.KeyBaseFragment, id.dana.base.viewbinding.ViewBindingFragment
    public final void _$_clearFindViewByIdCache() {
        this.PlaceComponentResult.clear();
    }

    @Override // id.dana.base.KeyBaseFragment, id.dana.base.viewbinding.ViewBindingFragment
    public final View _$_findCachedViewById(int i) {
        View findViewById;
        Map<Integer, View> map = this.PlaceComponentResult;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View getAuthRequestContext = getGetAuthRequestContext();
            if (getAuthRequestContext == null || (findViewById = getAuthRequestContext.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // id.dana.base.BaseFragment
    public final int getLayout() {
        return R.layout.fragment_create_pin;
    }

    @Override // id.dana.base.KeyBaseFragment, id.dana.base.viewbinding.ViewBindingFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public static final /* synthetic */ FragmentCreatePinBinding PlaceComponentResult(CreatePinFragment createPinFragment) {
        return (FragmentCreatePinBinding) createPinFragment.getBinding();
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public final /* synthetic */ ViewBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        FragmentCreatePinBinding authRequestContext = FragmentCreatePinBinding.getAuthRequestContext(view);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        PinEntryEditText pinEntryEditText;
        super.onStart();
        OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
        OnboardingFirebaseTracker.KClassImpl$Data$declaredNonStaticMembers$2("idle_registration_create_pin_screen");
        FragmentCreatePinBinding fragmentCreatePinBinding = (FragmentCreatePinBinding) getBinding();
        if (fragmentCreatePinBinding != null && (pinEntryEditText = fragmentCreatePinBinding.MyBillsEntityDataFactory) != null) {
            pinEntryEditText.requestFocus();
        }
        BaseActivity baseActivity = getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        KeyboardHelper.KClassImpl$Data$declaredNonStaticMembers$2((Activity) baseActivity);
    }

    @Override // id.dana.base.BaseFragment
    public final void init() {
        AppCompatTextView appCompatTextView;
        PinEntryEditText pinEntryEditText;
        PinEntryEditText pinEntryEditText2;
        PinEntryEditText pinEntryEditText3;
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("phoneNumber");
            if (string == null) {
                string = "";
            }
            this.moveToNextValue = string;
            String string2 = arguments.getString("nickname");
            if (string2 == null) {
                string2 = "";
            }
            this.lookAheadTest = string2;
            String string3 = arguments.getString("avatarUri");
            if (string3 == null) {
                string3 = "";
            }
            this.BuiltInFictitiousFunctionClassFactory = string3;
            String string4 = arguments.getString("referralCode");
            if (string4 == null) {
                string4 = "";
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = string4;
        }
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null) {
            OnboardingNavigationManagerWithMenu navigationManager = ((OnboardingActivity) ((KeyBaseActivity) baseActivity)).getNavigationManager();
            this.getErrorConfigVersion = navigationManager;
            if (navigationManager != null) {
                navigationManager.KClassImpl$Data$declaredNonStaticMembers$2.setMenuLeftButton(R.drawable.ic_left_white);
                navigationManager.PlaceComponentResult = new MenuItemButtonListener() { // from class: id.dana.onboarding.createpin.CreatePinFragment$$ExternalSyntheticLambda3
                    @Override // id.dana.base.MenuItemButtonListener
                    public final void PlaceComponentResult() {
                        CreatePinFragment.MyBillsEntityDataFactory(CreatePinFragment.this);
                    }
                };
                navigationManager.KClassImpl$Data$declaredNonStaticMembers$2.setMenuRightButton((String) null);
                String string5 = getString(R.string.btnBack);
                Intrinsics.checkNotNullExpressionValue(string5, "");
                Intrinsics.checkNotNullParameter(string5, "");
                navigationManager.KClassImpl$Data$declaredNonStaticMembers$2.setMenuLeftContentDescription(string5);
            }
            FragmentCreatePinBinding fragmentCreatePinBinding = (FragmentCreatePinBinding) getBinding();
            if (fragmentCreatePinBinding != null && (pinEntryEditText3 = fragmentCreatePinBinding.MyBillsEntityDataFactory) != null) {
                pinEntryEditText3.addTextChangedListener(new TextWatcher() { // from class: id.dana.onboarding.createpin.CreatePinFragment$setInputPinTextChangedListener$$inlined$addTextChangedListener$default$1
                    @Override // android.text.TextWatcher
                    public final void afterTextChanged(Editable p0) {
                    }

                    @Override // android.text.TextWatcher
                    public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
                    }

                    @Override // android.text.TextWatcher
                    public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                        PinEntryEditText pinEntryEditText4;
                        CreatePinFragment.lookAheadTest(CreatePinFragment.this);
                        FragmentCreatePinBinding PlaceComponentResult = CreatePinFragment.PlaceComponentResult(CreatePinFragment.this);
                        boolean z = false;
                        if (PlaceComponentResult != null && (pinEntryEditText4 = PlaceComponentResult.MyBillsEntityDataFactory) != null && String.valueOf(p0).length() == pinEntryEditText4.getMaxLength()) {
                            z = true;
                        }
                        if (z) {
                            FirebasePerformanceMonitor NetworkUserEntityData$$ExternalSyntheticLambda0 = CreatePinFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(CreatePinFragment.this);
                            Intrinsics.checkNotNullParameter(TrackerKey.Event.USER_INTERACTION_REGISTRATION_PIN_CREATION, "");
                            Trace trace = NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2.get(TrackerKey.Event.USER_INTERACTION_REGISTRATION_PIN_CREATION);
                            if (trace != null) {
                                trace.stop();
                            }
                        }
                    }
                });
            }
            FragmentCreatePinBinding fragmentCreatePinBinding2 = (FragmentCreatePinBinding) getBinding();
            TextBehavior.EditTextBehaviorBuilder PlaceComponentResult = TextBehavior.Builder.PlaceComponentResult(fragmentCreatePinBinding2 != null ? fragmentCreatePinBinding2.MyBillsEntityDataFactory : null);
            OrderedAscendingValidator orderedAscendingValidator = new OrderedAscendingValidator();
            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == null) {
                PlaceComponentResult.BuiltInFictitiousFunctionClassFactory = new ArrayList();
            }
            PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.add(orderedAscendingValidator);
            OrderedDescendingValidator orderedDescendingValidator = new OrderedDescendingValidator();
            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == null) {
                PlaceComponentResult.BuiltInFictitiousFunctionClassFactory = new ArrayList();
            }
            PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.add(orderedDescendingValidator);
            RepeatedStringValidator repeatedStringValidator = new RepeatedStringValidator();
            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == null) {
                PlaceComponentResult.BuiltInFictitiousFunctionClassFactory = new ArrayList();
            }
            PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.add(repeatedStringValidator);
            Validator validator = new Validator() { // from class: id.dana.onboarding.createpin.CreatePinFragment$createInputValidator$1
                @Override // id.dana.textbehavior.validate.Validator
                public final boolean MyBillsEntityDataFactory(String p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    return p0.length() >= 6;
                }

                @Override // id.dana.textbehavior.validate.Validator
                public final String KClassImpl$Data$declaredNonStaticMembers$2() {
                    String string6 = CreatePinFragment.this.getString(R.string.msg_pin_less_than6_error);
                    Intrinsics.checkNotNullExpressionValue(string6, "");
                    return string6;
                }
            };
            if (PlaceComponentResult.BuiltInFictitiousFunctionClassFactory == null) {
                PlaceComponentResult.BuiltInFictitiousFunctionClassFactory = new ArrayList();
            }
            PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.add(validator);
            PlaceComponentResult.MyBillsEntityDataFactory = new OnValidatedListener() { // from class: id.dana.onboarding.createpin.CreatePinFragment$createOnInputValidatedListener$1
                @Override // id.dana.textbehavior.OnValidatedListener
                public final void getAuthRequestContext(String p0) {
                    OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu;
                    Intrinsics.checkNotNullParameter(p0, "");
                    onboardingNavigationManagerWithMenu = CreatePinFragment.this.getErrorConfigVersion;
                    if (onboardingNavigationManagerWithMenu != null) {
                        onboardingNavigationManagerWithMenu.KClassImpl$Data$declaredNonStaticMembers$2.setMenuRightButtonEnabled(true);
                    }
                    CreatePinFragment.this.BuiltInFictitiousFunctionClassFactory();
                }

                /* JADX WARN: Code restructure failed: missing block: B:16:0x0040, code lost:
                
                    if (r4.equals("Text cannot use ascending sequence character") == false) goto L26;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:23:0x0056, code lost:
                
                    if (r4.equals("Text cannot use descending sequence number") == false) goto L26;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:25:0x0059, code lost:
                
                    r3 = id.dana.R.string.consist_of_consecutive_numbers;
                 */
                @Override // id.dana.textbehavior.OnValidatedListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void MyBillsEntityDataFactory(java.lang.String r8, java.util.List<? extends id.dana.textbehavior.InvalidReason> r9) {
                    /*
                        r7 = this;
                        java.lang.String r0 = ""
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                        int r8 = r8.length()
                        r1 = 0
                        r2 = 6
                        if (r8 < r2) goto L80
                        int r8 = r9.size()
                        r2 = 0
                        r3 = 0
                    L16:
                        if (r2 >= r8) goto L80
                        java.lang.Object r4 = r9.get(r2)
                        id.dana.textbehavior.InvalidReason r4 = (id.dana.textbehavior.InvalidReason) r4
                        id.dana.textbehavior.validate.Validator r4 = r4.KClassImpl$Data$declaredNonStaticMembers$2
                        java.lang.String r4 = r4.KClassImpl$Data$declaredNonStaticMembers$2()
                        if (r4 == 0) goto L5c
                        int r5 = r4.hashCode()
                        r6 = -390363197(0xffffffffe8bb87c3, float:-7.084695E24)
                        if (r5 == r6) goto L50
                        r6 = 66515302(0x3f6f166, float:1.4514003E-36)
                        if (r5 == r6) goto L43
                        r6 = 742963061(0x2c48b775, float:2.8523549E-12)
                        if (r5 == r6) goto L3a
                        goto L5c
                    L3a:
                        java.lang.String r5 = "Text cannot use ascending sequence character"
                        boolean r4 = r4.equals(r5)
                        if (r4 != 0) goto L59
                        goto L5c
                    L43:
                        java.lang.String r5 = "Text cannot use repeated character"
                        boolean r4 = r4.equals(r5)
                        if (r4 != 0) goto L4c
                        goto L5c
                    L4c:
                        r3 = 2131951855(0x7f1300ef, float:1.9540136E38)
                        goto L5c
                    L50:
                        java.lang.String r5 = "Text cannot use descending sequence number"
                        boolean r4 = r4.equals(r5)
                        if (r4 != 0) goto L59
                        goto L5c
                    L59:
                        r3 = 2131952904(0x7f130508, float:1.9542264E38)
                    L5c:
                        id.dana.onboarding.createpin.CreatePinFragment r4 = id.dana.onboarding.createpin.CreatePinFragment.this
                        id.dana.databinding.FragmentCreatePinBinding r4 = id.dana.onboarding.createpin.CreatePinFragment.PlaceComponentResult(r4)
                        if (r4 == 0) goto L6e
                        id.dana.core.ui.richview.PinEntryEditText r4 = r4.MyBillsEntityDataFactory
                        if (r4 == 0) goto L6e
                        r5 = r0
                        java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                        r4.setText(r5)
                    L6e:
                        id.dana.onboarding.createpin.CreatePinFragment r4 = id.dana.onboarding.createpin.CreatePinFragment.this
                        id.dana.base.BaseActivity r4 = r4.getBaseActivity()
                        id.dana.onboarding.createpin.CreatePinFragment r5 = id.dana.onboarding.createpin.CreatePinFragment.this
                        java.lang.String r5 = r5.getString(r3)
                        r4.showWarningDialog(r5)
                        int r2 = r2 + 1
                        goto L16
                    L80:
                        id.dana.onboarding.createpin.CreatePinFragment r8 = id.dana.onboarding.createpin.CreatePinFragment.this
                        id.dana.onboarding.OnboardingNavigationManagerWithMenu r8 = id.dana.onboarding.createpin.CreatePinFragment.getErrorConfigVersion(r8)
                        if (r8 == 0) goto L8d
                        id.dana.base.MenuItemFacade r8 = r8.KClassImpl$Data$declaredNonStaticMembers$2
                        r8.setMenuRightButtonEnabled(r1)
                    L8d:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.onboarding.createpin.CreatePinFragment$createOnInputValidatedListener$1.MyBillsEntityDataFactory(java.lang.String, java.util.List):void");
                }
            };
            PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
            FragmentCreatePinBinding fragmentCreatePinBinding3 = (FragmentCreatePinBinding) getBinding();
            if (fragmentCreatePinBinding3 != null && (pinEntryEditText2 = fragmentCreatePinBinding3.MyBillsEntityDataFactory) != null) {
                pinEntryEditText2.focus();
            }
            AppReadyMixpanelTracker appReadyMixpanelTracker = AppReadyMixpanelTracker.BuiltInFictitiousFunctionClassFactory;
            AppReadyMixpanelTracker.newProxyInstance();
            FragmentCreatePinBinding fragmentCreatePinBinding4 = (FragmentCreatePinBinding) getBinding();
            if (fragmentCreatePinBinding4 != null && (pinEntryEditText = fragmentCreatePinBinding4.MyBillsEntityDataFactory) != null) {
                pinEntryEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: id.dana.onboarding.createpin.CreatePinFragment$$ExternalSyntheticLambda4
                    @Override // android.widget.TextView.OnEditorActionListener
                    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                        boolean PlaceComponentResult2;
                        PlaceComponentResult2 = CreatePinFragment.PlaceComponentResult(CreatePinFragment.this, i);
                        return PlaceComponentResult2;
                    }
                });
            }
            KeyboardHelper.PlaceComponentResult(getBaseActivity().getWindow().getDecorView(), new KeyboardHelper.KeyboardVisibilityListener() { // from class: id.dana.onboarding.createpin.CreatePinFragment$getKeyboardVisibilityListener$1
                @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
                public final void MyBillsEntityDataFactory() {
                }

                @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    CreatePinFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(CreatePinFragment.this).KClassImpl$Data$declaredNonStaticMembers$2(TrackerKey.Event.USER_INTERACTION_REGISTRATION_PIN_CREATION);
                    CreatePinFragment.this.MyBillsEntityDataFactory = false;
                }
            });
            BaseActivity baseActivity2 = getBaseActivity();
            Intrinsics.checkNotNullExpressionValue(baseActivity2, "");
            KeyboardHelper.KClassImpl$Data$declaredNonStaticMembers$2((Context) baseActivity2);
            FragmentCreatePinBinding fragmentCreatePinBinding5 = (FragmentCreatePinBinding) getBinding();
            if (fragmentCreatePinBinding5 != null && (appCompatTextView = fragmentCreatePinBinding5.PlaceComponentResult) != null) {
                appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.onboarding.createpin.CreatePinFragment$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CreatePinFragment.KClassImpl$Data$declaredNonStaticMembers$2(CreatePinFragment.this);
                    }
                });
            }
            View getAuthRequestContext = getGetAuthRequestContext();
            if (getAuthRequestContext != null) {
                MeasureLoadAndRenderingScreen measureLoadAndRenderingScreen = this.KClassImpl$Data$declaredNonStaticMembers$2;
                Intrinsics.checkNotNullParameter(getAuthRequestContext, "");
                FirstDrawListener.Companion companion = FirstDrawListener.INSTANCE;
                FirstDrawListener.Companion.MyBillsEntityDataFactory(getAuthRequestContext, new MeasureLoadAndRenderingScreen$stopTracking$1(measureLoadAndRenderingScreen));
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of id.dana.base.KeyBaseFragment");
    }

    public static final boolean PlaceComponentResult(CreatePinFragment createPinFragment, int i) {
        PinEntryEditText pinEntryEditText;
        PinEntryEditText pinEntryEditText2;
        Intrinsics.checkNotNullParameter(createPinFragment, "");
        if (i == 6) {
            FragmentCreatePinBinding fragmentCreatePinBinding = (FragmentCreatePinBinding) createPinFragment.getBinding();
            if (String.valueOf((fragmentCreatePinBinding == null || (pinEntryEditText2 = fragmentCreatePinBinding.MyBillsEntityDataFactory) == null) ? null : pinEntryEditText2.getText()).length() >= 6) {
                createPinFragment.BuiltInFictitiousFunctionClassFactory();
                return true;
            }
            FragmentCreatePinBinding fragmentCreatePinBinding2 = (FragmentCreatePinBinding) createPinFragment.getBinding();
            if (fragmentCreatePinBinding2 != null && (pinEntryEditText = fragmentCreatePinBinding2.MyBillsEntityDataFactory) != null) {
                pinEntryEditText.setText("");
            }
            createPinFragment.showToast(createPinFragment.getString(R.string.msg_pin_less_than6_error));
        }
        return false;
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onAttach(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onAttach(p0);
        MeasureLoadAndRenderingScreen measureLoadAndRenderingScreen = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullParameter("create_pin_screen_render", "");
        measureLoadAndRenderingScreen.BuiltInFictitiousFunctionClassFactory = FirebasePerformance.startTrace("create_pin_screen_render");
        OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
        OnboardingFirebaseTracker.KClassImpl$Data$declaredNonStaticMembers$2("create_pin_flow_loadtime");
    }

    public final void BuiltInFictitiousFunctionClassFactory() {
        String str;
        String str2;
        String str3;
        String str4;
        PinEntryEditText pinEntryEditText;
        PinEntryEditText pinEntryEditText2;
        FragmentCreatePinBinding fragmentCreatePinBinding = (FragmentCreatePinBinding) getBinding();
        String valueOf = String.valueOf((fragmentCreatePinBinding == null || (pinEntryEditText2 = fragmentCreatePinBinding.MyBillsEntityDataFactory) == null) ? null : pinEntryEditText2.getText());
        FragmentCreatePinBinding fragmentCreatePinBinding2 = (FragmentCreatePinBinding) getBinding();
        if (fragmentCreatePinBinding2 != null && (pinEntryEditText = fragmentCreatePinBinding2.MyBillsEntityDataFactory) != null) {
            pinEntryEditText.setText("");
        }
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(getContext());
        builder.MyBillsEntityDataFactory = TrackerKey.Event.REGISTRATION_PIN_CREATE;
        builder.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(builder, (byte) 0));
        OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu = this.getErrorConfigVersion;
        if (onboardingNavigationManagerWithMenu != null) {
            String str5 = this.moveToNextValue;
            if (str5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                str = null;
            } else {
                str = str5;
            }
            String str6 = this.lookAheadTest;
            if (str6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                str2 = null;
            } else {
                str2 = str6;
            }
            String str7 = this.BuiltInFictitiousFunctionClassFactory;
            if (str7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                str3 = null;
            } else {
                str3 = str7;
            }
            String str8 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (str8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                str4 = null;
            } else {
                str4 = str8;
            }
            onboardingNavigationManagerWithMenu.KClassImpl$Data$declaredNonStaticMembers$2(str, str2, str3, valueOf, str4);
        }
        OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
        Intrinsics.checkNotNullParameter("create_pin_flow_loadtime", "");
        OnboardingFirebaseTracker.BuiltInFictitiousFunctionClassFactory(null, "create_pin_flow_loadtime");
    }

    private final void getAuthRequestContext() {
        new AlertDialog.Builder(getContext()).setTitle(R.string.cancel_process_question).setPositiveButton(R.string.option_register, new DialogInterface.OnClickListener() { // from class: id.dana.onboarding.createpin.CreatePinFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                CreatePinFragment.getAuthRequestContext(CreatePinFragment.this);
            }
        }).setNegativeButton(R.string.option_cancel, new DialogInterface.OnClickListener() { // from class: id.dana.onboarding.createpin.CreatePinFragment$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                CreatePinFragment.BuiltInFictitiousFunctionClassFactory(CreatePinFragment.this);
            }
        }).create().show();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ7\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/onboarding/createpin/CreatePinFragment$Companion;", "", "", "p0", "p1", "p2", "p3", "Lid/dana/onboarding/createpin/CreatePinFragment;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/onboarding/createpin/CreatePinFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static CreatePinFragment KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2, String p3) {
            Bundle bundle = new Bundle();
            bundle.putString("phoneNumber", p0);
            bundle.putString("nickname", p1);
            bundle.putString("avatarUri", p2);
            bundle.putString("referralCode", p3);
            CreatePinFragment createPinFragment = new CreatePinFragment();
            createPinFragment.setArguments(bundle);
            return createPinFragment;
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(CreatePinFragment createPinFragment) {
        Intrinsics.checkNotNullParameter(createPinFragment, "");
        OnboardingNavigationManagerWithMenu onboardingNavigationManagerWithMenu = createPinFragment.getErrorConfigVersion;
        if (onboardingNavigationManagerWithMenu != null) {
            VerifyNumberKey.Companion companion = VerifyNumberKey.INSTANCE;
            VerifyNumberKey PlaceComponentResult = VerifyNumberKey.Companion.BuiltInFictitiousFunctionClassFactory().PlaceComponentResult();
            Intrinsics.checkNotNullParameter(PlaceComponentResult, "");
            onboardingNavigationManagerWithMenu.getAuthRequestContext.setHistory(History.single(PlaceComponentResult), 0);
        }
    }

    public static /* synthetic */ void getAuthRequestContext(CreatePinFragment createPinFragment) {
        Intrinsics.checkNotNullParameter(createPinFragment, "");
        createPinFragment.dispose();
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(CreatePinFragment createPinFragment) {
        Intrinsics.checkNotNullParameter(createPinFragment, "");
        createPinFragment.getAuthRequestContext();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(CreatePinFragment createPinFragment) {
        AppCompatTextView appCompatTextView;
        PinEntryEditText pinEntryEditText;
        PinEntryEditText pinEntryEditText2;
        AppCompatTextView appCompatTextView2;
        Intrinsics.checkNotNullParameter(createPinFragment, "");
        FragmentCreatePinBinding fragmentCreatePinBinding = (FragmentCreatePinBinding) createPinFragment.getBinding();
        if (Intrinsics.areEqual(String.valueOf((fragmentCreatePinBinding == null || (appCompatTextView2 = fragmentCreatePinBinding.PlaceComponentResult) == null) ? null : appCompatTextView2.getText()), createPinFragment.getString(R.string.show_pin))) {
            FragmentCreatePinBinding fragmentCreatePinBinding2 = (FragmentCreatePinBinding) createPinFragment.getBinding();
            if (fragmentCreatePinBinding2 != null && (pinEntryEditText2 = fragmentCreatePinBinding2.MyBillsEntityDataFactory) != null) {
                pinEntryEditText2.showCharacters();
            }
            FragmentCreatePinBinding fragmentCreatePinBinding3 = (FragmentCreatePinBinding) createPinFragment.getBinding();
            appCompatTextView = fragmentCreatePinBinding3 != null ? fragmentCreatePinBinding3.PlaceComponentResult : null;
            if (appCompatTextView != null) {
                appCompatTextView.setText(createPinFragment.getString(R.string.hide_pin));
                return;
            }
            return;
        }
        FragmentCreatePinBinding fragmentCreatePinBinding4 = (FragmentCreatePinBinding) createPinFragment.getBinding();
        if (fragmentCreatePinBinding4 != null && (pinEntryEditText = fragmentCreatePinBinding4.MyBillsEntityDataFactory) != null) {
            pinEntryEditText.hideCharacters();
        }
        FragmentCreatePinBinding fragmentCreatePinBinding5 = (FragmentCreatePinBinding) createPinFragment.getBinding();
        appCompatTextView = fragmentCreatePinBinding5 != null ? fragmentCreatePinBinding5.PlaceComponentResult : null;
        if (appCompatTextView != null) {
            appCompatTextView.setText(createPinFragment.getString(R.string.show_pin));
        }
    }

    public static final /* synthetic */ FirebasePerformanceMonitor NetworkUserEntityData$$ExternalSyntheticLambda0(CreatePinFragment createPinFragment) {
        return (FirebasePerformanceMonitor) createPinFragment.getAuthRequestContext.getValue();
    }

    public static final /* synthetic */ void lookAheadTest(CreatePinFragment createPinFragment) {
        if (createPinFragment.PlaceComponentResult) {
            OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
            Intrinsics.checkNotNullParameter("idle_registration_create_pin_screen", "");
            OnboardingFirebaseTracker.BuiltInFictitiousFunctionClassFactory(null, "idle_registration_create_pin_screen");
            createPinFragment.PlaceComponentResult = false;
        }
    }

    @Override // id.dana.base.BaseFragment
    public final boolean onBackPressed() {
        if (this.PlaceComponentResult) {
            OnboardingFirebaseTracker onboardingFirebaseTracker = OnboardingFirebaseTracker.INSTANCE;
            Intrinsics.checkNotNullParameter("idle_registration_create_pin_screen", "");
            OnboardingFirebaseTracker.BuiltInFictitiousFunctionClassFactory(null, "idle_registration_create_pin_screen");
            this.PlaceComponentResult = false;
        }
        getAuthRequestContext();
        return true;
    }
}
