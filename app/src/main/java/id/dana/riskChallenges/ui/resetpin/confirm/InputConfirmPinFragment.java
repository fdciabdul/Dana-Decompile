package id.dana.riskChallenges.ui.resetpin.confirm;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.view.HasDefaultViewModelProviderFactory;
import androidx.view.LifecycleOwnerKt;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import androidx.view.viewmodel.CreationExtras;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.analytics.tracker.createpin.InputConfirmPinTrackerImpl;
import id.dana.core.ui.BaseViewBindingFragment;
import id.dana.core.ui.constant.BottomInfoSnackbarState;
import id.dana.core.ui.constant.DialogType;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.core.ui.dialog.CommonDialog;
import id.dana.core.ui.dialog.DanaLoadingDialogFragment;
import id.dana.core.ui.dialog.DanaSuccessDialogFragment;
import id.dana.core.ui.extension.FragmentExtKt;
import id.dana.core.ui.richview.BottomInfoSnackbar;
import id.dana.core.ui.richview.PinEntryEditText;
import id.dana.core.ui.util.KeyboardHelper;
import id.dana.domain.resetpin.interactor.SelfUnfreeze;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.riskChallenges.R;
import id.dana.riskChallenges.databinding.FragmentInputConfirmPinBinding;
import id.dana.riskChallenges.di.component.RiskChallengesComponent;
import id.dana.riskChallenges.di.provider.RiskChallengesProvider;
import id.dana.riskChallenges.ui.resetpin.confirm.InputConfirmPinFragment$snackbarErrorCallback$2;
import id.dana.riskChallenges.ui.resetpin.confirm.viewmodel.InputConfirmPinUiState;
import id.dana.riskChallenges.ui.resetpin.confirm.viewmodel.InputConfirmPinViewModel;
import id.dana.riskChallenges.ui.util.PinValidator;
import id.dana.riskChallenges.ui.util.uicomponent.UiComponent;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\"\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\f\u0010\rR\u0013\u0010\u0011\u001a\u00020\u000eX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0013\u0010\u000f\u001a\u00020\u0012X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\u0013\u0010\u0015\u001a\u00020\u0014X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0004\u0010\u0010R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0013\u0010\u001c\u001a\u00020\u001aX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010\u0010R\u0013\u0010\u0013\u001a\u00020\u001dX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u001e\u0010\u0010R\u0012\u0010 \u001a\u00020\u001fX\u0087\"¢\u0006\u0006\n\u0004\b \u0010!"}, d2 = {"Lid/dana/riskChallenges/ui/resetpin/confirm/InputConfirmPinFragment;", "Lid/dana/core/ui/BaseViewBindingFragment;", "Lid/dana/riskChallenges/databinding/FragmentInputConfirmPinBinding;", "", "lookAheadTest", "()V", "Landroid/os/Bundle;", "p0", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "p1", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lid/dana/core/ui/richview/BottomInfoSnackbar;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/Lazy;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/core/ui/dialog/DanaLoadingDialogFragment;", "getErrorConfigVersion", "Lid/dana/core/ui/dialog/DanaSuccessDialogFragment;", "getAuthRequestContext", "Lid/dana/riskChallenges/di/component/RiskChallengesComponent;", "scheduleImpl", "Lid/dana/riskChallenges/di/component/RiskChallengesComponent;", "PlaceComponentResult", "Lid/dana/riskChallenges/ui/resetpin/confirm/InputConfirmPinFragment$snackbarErrorCallback$2$1;", "moveToNextValue", "MyBillsEntityDataFactory", "Lid/dana/riskChallenges/ui/resetpin/confirm/viewmodel/InputConfirmPinViewModel;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/core/ui/di/module/ViewModelFactory;", "viewModelFactory", "Lid/dana/core/ui/di/module/ViewModelFactory;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InputConfirmPinFragment extends BaseViewBindingFragment<FragmentInputConfirmPinBinding> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Lazy getErrorConfigVersion;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private RiskChallengesComponent PlaceComponentResult;
    @Inject
    public ViewModelFactory viewModelFactory;
    public static final byte[] $$a = {68, -4, -93, 76, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 252;
    public static final byte[] MyBillsEntityDataFactory = {SignedBytes.MAX_POWER_OF_TWO, 34, -50, 73, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int PlaceComponentResult = 125;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX WARN: Removed duplicated region for block: B:20:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0028 -> B:23:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.riskChallenges.ui.resetpin.confirm.InputConfirmPinFragment.MyBillsEntityDataFactory
            int r8 = r8 * 15
            int r8 = r8 + 4
            int r6 = 106 - r6
            int r7 = r7 * 2
            int r7 = 16 - r7
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L35
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r7) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            r4 = r0[r8]
            int r3 = r3 + 1
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L35:
            int r6 = -r6
            int r9 = r9 + 1
            int r7 = r7 + r6
            int r6 = r7 + 2
            r7 = r8
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.riskChallenges.ui.resetpin.confirm.InputConfirmPinFragment.a(short, int, byte, java.lang.Object[]):void");
    }

    private static void b(byte b, int i, byte b2, Object[] objArr) {
        int i2 = 75 - (i * 2);
        int i3 = 3 - (b2 * 4);
        int i4 = 42 - (b * 4);
        byte[] bArr = $$a;
        byte[] bArr2 = new byte[i4];
        int i5 = -1;
        int i6 = i4 - 1;
        if (bArr == null) {
            i3 = i3;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = -1;
            i2 = (i2 + i6) - 7;
            i6 = i6;
        }
        while (true) {
            int i7 = i5 + 1;
            bArr2[i7] = (byte) i2;
            int i8 = i3 + 1;
            if (i7 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i9 = i2;
            int i10 = i6;
            i3 = i8;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = i7;
            i2 = (i9 + bArr[i8]) - 7;
            i6 = i10;
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final /* synthetic */ FragmentInputConfirmPinBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentInputConfirmPinBinding KClassImpl$Data$declaredNonStaticMembers$2 = FragmentInputConfirmPinBinding.KClassImpl$Data$declaredNonStaticMembers$2(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle p0) {
        try {
            byte b = (byte) (MyBillsEntityDataFactory[5] - 1);
            Object[] objArr = new Object[1];
            a(b, b, MyBillsEntityDataFactory[5], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = MyBillsEntityDataFactory[5];
            byte b3 = (byte) (b2 - 1);
            Object[] objArr2 = new Object[1];
            a(b2, b3, b3, objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - View.combineMeasuredStates(0, 0), 3 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)));
                    byte b4 = (byte) ($$a[35] - 1);
                    byte b5 = b4;
                    Object[] objArr4 = new Object[1];
                    b(b4, b5, b5, objArr4);
                    obj = cls2.getMethod((String) objArr4[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj);
                }
                Object[] objArr5 = (Object[]) ((Method) obj).invoke(null, objArr3);
                int i = ((int[]) objArr5[1])[0];
                if (((int[]) objArr5[0])[0] != i) {
                    long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 35, (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-1391961340, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), TextUtils.lastIndexOf("", '0', 0, 0) + 19, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj3);
                            }
                            ((Method) obj3).invoke(invoke, objArr6);
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 == null) {
                            throw th2;
                        }
                        throw cause2;
                    }
                }
                super.onCreate(p0);
                Context applicationContext = requireActivity().getApplicationContext();
                if (applicationContext == null) {
                    throw new NullPointerException("null cannot be cast to non-null type id.dana.riskChallenges.di.provider.RiskChallengesProvider");
                }
                RiskChallengesComponent BuiltInFictitiousFunctionClassFactory = ((RiskChallengesProvider) applicationContext).provideRiskChallengesComponent().BuiltInFictitiousFunctionClassFactory();
                this.PlaceComponentResult = BuiltInFictitiousFunctionClassFactory;
                BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(this);
                Bundle arguments = getArguments();
                if (arguments != null) {
                    ((InputConfirmPinViewModel) this.getErrorConfigVersion.getValue()).getAuthRequestContext = arguments.getString("KEY_PHONE_NUMBER");
                    ((InputConfirmPinViewModel) this.getErrorConfigVersion.getValue()).PlaceComponentResult = arguments.getString("KEY_CREATED_PIN");
                    ((InputConfirmPinViewModel) this.getErrorConfigVersion.getValue()).BuiltInFictitiousFunctionClassFactory = arguments.getString("KEY_SCENE");
                }
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 == null) {
                    throw th3;
                }
                throw cause3;
            }
        } catch (Throwable th4) {
            Throwable cause4 = th4.getCause();
            if (cause4 == null) {
                throw th4;
            }
            throw cause4;
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View p0, Bundle p1) {
        Parcelable parcelable;
        Intrinsics.checkNotNullParameter(p0, "");
        super.onViewCreated(p0, p1);
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentInputConfirmPinBinding) vb).getErrorConfigVersion.PlaceComponentResult.setText(getString(R.string.reset_pin_input_new_pin_toolbar_title));
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                AppCompatImageView appCompatImageView = ((FragmentInputConfirmPinBinding) vb2).getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory;
                int i = R.drawable.getAuthRequestContext;
                if (appCompatImageView instanceof ImageView) {
                    InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
                } else {
                    appCompatImageView.setImageResource(i);
                }
                Bundle arguments = getArguments();
                if (arguments != null) {
                    if (Build.VERSION.SDK_INT >= 33) {
                        parcelable = (Parcelable) arguments.getParcelable("KEY_UI_COMPONENT", UiComponent.class);
                    } else {
                        Parcelable parcelable2 = arguments.getParcelable("KEY_UI_COMPONENT");
                        if (!(parcelable2 instanceof UiComponent)) {
                            parcelable2 = null;
                        }
                        parcelable = (UiComponent) parcelable2;
                    }
                    UiComponent uiComponent = (UiComponent) parcelable;
                    if (uiComponent != null) {
                        VB vb3 = this.PlaceComponentResult;
                        if (vb3 != 0) {
                            ((FragmentInputConfirmPinBinding) vb3).getAuthRequestContext.setBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(requireContext(), uiComponent.MyBillsEntityDataFactory));
                        } else {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                    }
                }
                VB vb4 = this.PlaceComponentResult;
                if (vb4 != 0) {
                    ((FragmentInputConfirmPinBinding) vb4).KClassImpl$Data$declaredNonStaticMembers$2.setMaxLength(6);
                    VB vb5 = this.PlaceComponentResult;
                    if (vb5 != 0) {
                        ((FragmentInputConfirmPinBinding) vb5).KClassImpl$Data$declaredNonStaticMembers$2.setOnPinEnteredListener(new PinEntryEditText.OnPinEnteredListener() { // from class: id.dana.riskChallenges.ui.resetpin.confirm.InputConfirmPinFragment$initView$2
                            @Override // id.dana.core.ui.richview.PinEntryEditText.OnPinEnteredListener
                            public final void MyBillsEntityDataFactory() {
                            }

                            @Override // id.dana.core.ui.richview.PinEntryEditText.OnPinEnteredListener
                            public final void getAuthRequestContext(CharSequence p02) {
                                if (p02 != null) {
                                    InputConfirmPinFragment inputConfirmPinFragment = InputConfirmPinFragment.this;
                                    InputConfirmPinFragment.getErrorConfigVersion(inputConfirmPinFragment).dismiss();
                                    String obj = p02.toString();
                                    Bundle arguments2 = inputConfirmPinFragment.getArguments();
                                    final String string = arguments2 != null ? arguments2.getString("KEY_SECURITY_ID") : null;
                                    if (string == null) {
                                        string = "";
                                    }
                                    Bundle arguments3 = inputConfirmPinFragment.getArguments();
                                    final String string2 = arguments3 != null ? arguments3.getString("KEY_RISK_TOKEN") : null;
                                    if (string2 == null) {
                                        string2 = "";
                                    }
                                    Bundle arguments4 = inputConfirmPinFragment.getArguments();
                                    String string3 = arguments4 != null ? arguments4.getString("KEY_SOURCE") : null;
                                    if (string3 == null) {
                                        string3 = "";
                                    }
                                    final InputConfirmPinViewModel lookAheadTest = InputConfirmPinFragment.lookAheadTest(inputConfirmPinFragment);
                                    Intrinsics.checkNotNullParameter(obj, "");
                                    Intrinsics.checkNotNullParameter(string2, "");
                                    Intrinsics.checkNotNullParameter(string, "");
                                    Intrinsics.checkNotNullParameter(string3, "");
                                    PinValidator pinValidator = PinValidator.INSTANCE;
                                    String str = lookAheadTest.PlaceComponentResult;
                                    if (str == null) {
                                        str = "";
                                    }
                                    if (PinValidator.KClassImpl$Data$declaredNonStaticMembers$2(obj, str)) {
                                        PinValidator pinValidator2 = PinValidator.INSTANCE;
                                        String str2 = lookAheadTest.PlaceComponentResult;
                                        if (str2 == null) {
                                            str2 = "";
                                        }
                                        if (!PinValidator.getAuthRequestContext(obj, str2)) {
                                            MutableStateFlow<InputConfirmPinUiState> mutableStateFlow = lookAheadTest.MyBillsEntityDataFactory;
                                            do {
                                            } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), InputConfirmPinUiState.PinNotMatched.INSTANCE));
                                            return;
                                        }
                                        InputConfirmPinTrackerImpl inputConfirmPinTrackerImpl = lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2;
                                        Intrinsics.checkNotNullParameter(string3, "");
                                        inputConfirmPinTrackerImpl.BuiltInFictitiousFunctionClassFactory = string3;
                                        if (!Intrinsics.areEqual(string3, TrackerKey.RiskChallenge.Source.SELF_UNFREEZE)) {
                                            lookAheadTest.KClassImpl$Data$declaredNonStaticMembers$2(string2, string);
                                        } else {
                                            lookAheadTest.moveToNextValue.get().execute(new SelfUnfreeze.Params(string), new Function1<Boolean, Unit>() { // from class: id.dana.riskChallenges.ui.resetpin.confirm.viewmodel.InputConfirmPinViewModel$selfUnfreeze$1
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
                                                    if (z) {
                                                        InputConfirmPinViewModel.this.KClassImpl$Data$declaredNonStaticMembers$2(string2, string);
                                                    } else {
                                                        InputConfirmPinViewModel.MyBillsEntityDataFactory(InputConfirmPinViewModel.this, new Throwable());
                                                    }
                                                }
                                            }, new Function1<Throwable, Unit>() { // from class: id.dana.riskChallenges.ui.resetpin.confirm.viewmodel.InputConfirmPinViewModel$selfUnfreeze$2
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
                                                    Intrinsics.checkNotNullParameter(th, "");
                                                    InputConfirmPinViewModel.MyBillsEntityDataFactory(InputConfirmPinViewModel.this, th);
                                                }
                                            });
                                        }
                                    }
                                }
                            }
                        });
                        VB vb6 = this.PlaceComponentResult;
                        if (vb6 != 0) {
                            ((FragmentInputConfirmPinBinding) vb6).KClassImpl$Data$declaredNonStaticMembers$2.focus();
                            VB vb7 = this.PlaceComponentResult;
                            if (vb7 != 0) {
                                ((FragmentInputConfirmPinBinding) vb7).getErrorConfigVersion.BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.riskChallenges.ui.resetpin.confirm.InputConfirmPinFragment$$ExternalSyntheticLambda2
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view) {
                                        InputConfirmPinFragment.BuiltInFictitiousFunctionClassFactory(InputConfirmPinFragment.this);
                                    }
                                });
                                ((BottomInfoSnackbar) this.BuiltInFictitiousFunctionClassFactory.getValue()).dismiss();
                                VB vb8 = this.PlaceComponentResult;
                                if (vb8 != 0) {
                                    ((FragmentInputConfirmPinBinding) vb8).PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.riskChallenges.ui.resetpin.confirm.InputConfirmPinFragment$$ExternalSyntheticLambda3
                                        @Override // android.view.View.OnClickListener
                                        public final void onClick(View view) {
                                            InputConfirmPinFragment.MyBillsEntityDataFactory(InputConfirmPinFragment.this);
                                        }
                                    });
                                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.PlaceComponentResult(this), Dispatchers.getMain(), null, new InputConfirmPinFragment$observeUiState$1(this, null), 2, null);
                                    return;
                                }
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final void lookAheadTest() {
        if (getParentFragmentManager().getBackStackEntryCount() > 0) {
            getParentFragmentManager().popBackStack();
            return;
        }
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentInputConfirmPinBinding) vb).KClassImpl$Data$declaredNonStaticMembers$2.post(new Runnable() { // from class: id.dana.riskChallenges.ui.resetpin.confirm.InputConfirmPinFragment$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    InputConfirmPinFragment.PlaceComponentResult(InputConfirmPinFragment.this);
                }
            });
            if (FragmentExtKt.PlaceComponentResult(this)) {
                getParentFragmentManager().setFragmentResult("KEY_RISK_CHALLENGE_FRAGMENT", BundleKt.PlaceComponentResult(TuplesKt.to("KEY_RESULT", 0)));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJK\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/riskChallenges/ui/resetpin/confirm/InputConfirmPinFragment$Companion;", "", "", "p0", "p1", "p2", "p3", "p4", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "p5", "p6", "Lid/dana/riskChallenges/ui/resetpin/confirm/InputConfirmPinFragment;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;Ljava/lang/String;)Lid/dana/riskChallenges/ui/resetpin/confirm/InputConfirmPinFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static InputConfirmPinFragment BuiltInFictitiousFunctionClassFactory(String p0, String p1, String p2, String p3, String p4, UiComponent p5, String p6) {
            Intrinsics.checkNotNullParameter(p2, "");
            Intrinsics.checkNotNullParameter(p3, "");
            Intrinsics.checkNotNullParameter(p4, "");
            Intrinsics.checkNotNullParameter(p6, "");
            InputConfirmPinFragment inputConfirmPinFragment = new InputConfirmPinFragment();
            inputConfirmPinFragment.setArguments(BundleKt.PlaceComponentResult(TuplesKt.to("KEY_PHONE_NUMBER", p0), TuplesKt.to("KEY_CREATED_PIN", p1), TuplesKt.to("KEY_SECURITY_ID", p2), TuplesKt.to("KEY_RISK_TOKEN", p3), TuplesKt.to("KEY_SCENE", p4), TuplesKt.to("KEY_UI_COMPONENT", p5), TuplesKt.to("KEY_SOURCE", p6)));
            return inputConfirmPinFragment;
        }
    }

    public InputConfirmPinFragment() {
        final InputConfirmPinFragment inputConfirmPinFragment = this;
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: id.dana.riskChallenges.ui.resetpin.confirm.InputConfirmPinFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelFactory viewModelFactory = InputConfirmPinFragment.this.viewModelFactory;
                if (viewModelFactory == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    viewModelFactory = null;
                }
                return viewModelFactory;
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: id.dana.riskChallenges.ui.resetpin.confirm.InputConfirmPinFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: id.dana.riskChallenges.ui.resetpin.confirm.InputConfirmPinFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) Function0.this.invoke();
            }
        });
        final Function0 function03 = null;
        this.getErrorConfigVersion = FragmentViewModelLazyKt.BuiltInFictitiousFunctionClassFactory(inputConfirmPinFragment, Reflection.getOrCreateKotlinClass(InputConfirmPinViewModel.class), new Function0<ViewModelStore>() { // from class: id.dana.riskChallenges.ui.resetpin.confirm.InputConfirmPinFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = FragmentViewModelLazyKt.PlaceComponentResult(Lazy.this).getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: id.dana.riskChallenges.ui.resetpin.confirm.InputConfirmPinFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function04 = Function0.this;
                if (function04 == null || (creationExtras = (CreationExtras) function04.invoke()) == null) {
                    ViewModelStoreOwner PlaceComponentResult2 = FragmentViewModelLazyKt.PlaceComponentResult(lazy);
                    HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = PlaceComponentResult2 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) PlaceComponentResult2 : null;
                    CreationExtras defaultViewModelCreationExtras = hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : null;
                    return defaultViewModelCreationExtras == null ? CreationExtras.Empty.INSTANCE : defaultViewModelCreationExtras;
                }
                return creationExtras;
            }
        }, function0);
        this.BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<BottomInfoSnackbar>() { // from class: id.dana.riskChallenges.ui.resetpin.confirm.InputConfirmPinFragment$bottomInfoSnackbar$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BottomInfoSnackbar invoke() {
                BottomInfoSnackbar.Companion companion = BottomInfoSnackbar.INSTANCE;
                VB vb = InputConfirmPinFragment.this.PlaceComponentResult;
                if (vb != 0) {
                    ConstraintLayout constraintLayout = ((FragmentInputConfirmPinBinding) vb).getAuthRequestContext;
                    Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
                    return BottomInfoSnackbar.Companion.getAuthRequestContext(constraintLayout);
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        });
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<DanaLoadingDialogFragment>() { // from class: id.dana.riskChallenges.ui.resetpin.confirm.InputConfirmPinFragment$danaLoading$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DanaLoadingDialogFragment invoke() {
                DanaLoadingDialogFragment.Companion companion = DanaLoadingDialogFragment.INSTANCE;
                return DanaLoadingDialogFragment.Companion.BuiltInFictitiousFunctionClassFactory();
            }
        });
        this.getAuthRequestContext = LazyKt.lazy(new Function0<DanaSuccessDialogFragment>() { // from class: id.dana.riskChallenges.ui.resetpin.confirm.InputConfirmPinFragment$danaSuccess$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DanaSuccessDialogFragment invoke() {
                DanaSuccessDialogFragment.Companion companion = DanaSuccessDialogFragment.INSTANCE;
                return DanaSuccessDialogFragment.Companion.MyBillsEntityDataFactory();
            }
        });
        this.MyBillsEntityDataFactory = LazyKt.lazy(new Function0<InputConfirmPinFragment$snackbarErrorCallback$2.AnonymousClass1>() { // from class: id.dana.riskChallenges.ui.resetpin.confirm.InputConfirmPinFragment$snackbarErrorCallback$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.riskChallenges.ui.resetpin.confirm.InputConfirmPinFragment$snackbarErrorCallback$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                final InputConfirmPinFragment inputConfirmPinFragment2 = InputConfirmPinFragment.this;
                return new BaseTransientBottomBar.BaseCallback<BottomInfoSnackbar>() { // from class: id.dana.riskChallenges.ui.resetpin.confirm.InputConfirmPinFragment$snackbarErrorCallback$2.1
                    @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
                    public final /* synthetic */ void onDismissed(BottomInfoSnackbar bottomInfoSnackbar, int i) {
                        if (FragmentExtKt.PlaceComponentResult(InputConfirmPinFragment.this)) {
                            Context context = InputConfirmPinFragment.this.getContext();
                            if (context != null) {
                                VB vb = InputConfirmPinFragment.this.PlaceComponentResult;
                                if (vb != 0) {
                                    ((FragmentInputConfirmPinBinding) vb).KClassImpl$Data$declaredNonStaticMembers$2.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(context, R.color.BuiltInFictitiousFunctionClassFactory));
                                } else {
                                    throw new IllegalArgumentException("Required value was null.".toString());
                                }
                            }
                            VB vb2 = InputConfirmPinFragment.this.PlaceComponentResult;
                            if (vb2 != 0) {
                                ((FragmentInputConfirmPinBinding) vb2).KClassImpl$Data$declaredNonStaticMembers$2.setText("");
                                return;
                            }
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                    }
                };
            }
        });
    }

    public static /* synthetic */ void PlaceComponentResult(InputConfirmPinFragment inputConfirmPinFragment) {
        Intrinsics.checkNotNullParameter(inputConfirmPinFragment, "");
        VB vb = inputConfirmPinFragment.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentInputConfirmPinBinding) vb).KClassImpl$Data$declaredNonStaticMembers$2.clearFocus();
            KeyboardHelper.getAuthRequestContext(inputConfirmPinFragment.getGetAuthRequestContext());
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(InputConfirmPinFragment inputConfirmPinFragment) {
        Intrinsics.checkNotNullParameter(inputConfirmPinFragment, "");
        VB vb = inputConfirmPinFragment.PlaceComponentResult;
        if (vb != 0) {
            if (Intrinsics.areEqual(((FragmentInputConfirmPinBinding) vb).PlaceComponentResult.getText().toString(), inputConfirmPinFragment.getString(R.string.res_0x7f13157a_summaryvoucherview_externalsyntheticlambda1))) {
                VB vb2 = inputConfirmPinFragment.PlaceComponentResult;
                if (vb2 != 0) {
                    ((FragmentInputConfirmPinBinding) vb2).KClassImpl$Data$declaredNonStaticMembers$2.showCharacters();
                    VB vb3 = inputConfirmPinFragment.PlaceComponentResult;
                    if (vb3 != 0) {
                        ((FragmentInputConfirmPinBinding) vb3).PlaceComponentResult.setText(inputConfirmPinFragment.getString(R.string.res_0x7f130a5d_networkuserentitydata_externalsyntheticlambda8));
                        return;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            VB vb4 = inputConfirmPinFragment.PlaceComponentResult;
            if (vb4 != 0) {
                ((FragmentInputConfirmPinBinding) vb4).KClassImpl$Data$declaredNonStaticMembers$2.hideCharacters();
                VB vb5 = inputConfirmPinFragment.PlaceComponentResult;
                if (vb5 != 0) {
                    ((FragmentInputConfirmPinBinding) vb5).PlaceComponentResult.setText(inputConfirmPinFragment.getString(R.string.res_0x7f13157a_summaryvoucherview_externalsyntheticlambda1));
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(PinEntryEditText pinEntryEditText, InputConfirmPinFragment inputConfirmPinFragment, Function0 function0) {
        Intrinsics.checkNotNullParameter(pinEntryEditText, "");
        Intrinsics.checkNotNullParameter(inputConfirmPinFragment, "");
        Intrinsics.checkNotNullParameter(function0, "");
        pinEntryEditText.requestFocus();
        FragmentActivity activity = inputConfirmPinFragment.getActivity();
        if (activity != null) {
            KeyboardHelper.getAuthRequestContext((Activity) activity);
            function0.invoke();
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(InputConfirmPinFragment inputConfirmPinFragment) {
        Intrinsics.checkNotNullParameter(inputConfirmPinFragment, "");
        inputConfirmPinFragment.lookAheadTest();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(InputConfirmPinFragment inputConfirmPinFragment) {
        Intrinsics.checkNotNullParameter(inputConfirmPinFragment, "");
        inputConfirmPinFragment.getParentFragmentManager().setFragmentResult("KEY_RISK_CHALLENGE_FRAGMENT", BundleKt.PlaceComponentResult(TuplesKt.to("KEY_RESULT", 0), TuplesKt.to("KEY_IS_ERROR", Boolean.TRUE)));
    }

    public static final /* synthetic */ void getAuthRequestContext(InputConfirmPinFragment inputConfirmPinFragment) {
        if (((DanaLoadingDialogFragment) inputConfirmPinFragment.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).getHost() == null || !((DanaLoadingDialogFragment) inputConfirmPinFragment.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).isAdded()) {
            return;
        }
        ((DanaLoadingDialogFragment) inputConfirmPinFragment.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).dismissAllowingStateLoss();
    }

    public static final /* synthetic */ BottomInfoSnackbar getErrorConfigVersion(InputConfirmPinFragment inputConfirmPinFragment) {
        return (BottomInfoSnackbar) inputConfirmPinFragment.BuiltInFictitiousFunctionClassFactory.getValue();
    }

    public static final /* synthetic */ InputConfirmPinViewModel lookAheadTest(InputConfirmPinFragment inputConfirmPinFragment) {
        return (InputConfirmPinViewModel) inputConfirmPinFragment.getErrorConfigVersion.getValue();
    }

    public static final /* synthetic */ void scheduleImpl(InputConfirmPinFragment inputConfirmPinFragment) {
        KeyboardHelper.PlaceComponentResult(inputConfirmPinFragment.getActivity());
        inputConfirmPinFragment.getParentFragmentManager().setFragmentResult("KEY_RISK_CHALLENGE_FRAGMENT", BundleKt.PlaceComponentResult(TuplesKt.to("KEY_RESULT", -1)));
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(InputConfirmPinFragment inputConfirmPinFragment, String str) {
        ((BottomInfoSnackbar) inputConfirmPinFragment.BuiltInFictitiousFunctionClassFactory.getValue()).KClassImpl$Data$declaredNonStaticMembers$2(BottomInfoSnackbarState.ERROR);
        BottomInfoSnackbar bottomInfoSnackbar = (BottomInfoSnackbar) inputConfirmPinFragment.BuiltInFictitiousFunctionClassFactory.getValue();
        Intrinsics.checkNotNullParameter(str, "");
        bottomInfoSnackbar.MyBillsEntityDataFactory.MyBillsEntityDataFactory.setText(str);
        ((BottomInfoSnackbar) inputConfirmPinFragment.BuiltInFictitiousFunctionClassFactory.getValue()).show();
    }

    public static final /* synthetic */ void moveToNextValue(InputConfirmPinFragment inputConfirmPinFragment) {
        ((BottomInfoSnackbar) inputConfirmPinFragment.BuiltInFictitiousFunctionClassFactory.getValue()).KClassImpl$Data$declaredNonStaticMembers$2(BottomInfoSnackbarState.ERROR);
        ((BottomInfoSnackbar) inputConfirmPinFragment.BuiltInFictitiousFunctionClassFactory.getValue()).addCallback((InputConfirmPinFragment$snackbarErrorCallback$2.AnonymousClass1) inputConfirmPinFragment.MyBillsEntityDataFactory.getValue());
        BottomInfoSnackbar bottomInfoSnackbar = (BottomInfoSnackbar) inputConfirmPinFragment.BuiltInFictitiousFunctionClassFactory.getValue();
        String string = inputConfirmPinFragment.getString(R.string.reset_pin_input_new_pin_error_not_match_pin);
        Intrinsics.checkNotNullExpressionValue(string, "");
        Intrinsics.checkNotNullParameter(string, "");
        bottomInfoSnackbar.MyBillsEntityDataFactory.MyBillsEntityDataFactory.setText(string);
        ((BottomInfoSnackbar) inputConfirmPinFragment.BuiltInFictitiousFunctionClassFactory.getValue()).show();
    }

    public static final /* synthetic */ void PlaceComponentResult(final InputConfirmPinFragment inputConfirmPinFragment, final Function0 function0) {
        VB vb = inputConfirmPinFragment.PlaceComponentResult;
        if (vb != 0) {
            final PinEntryEditText pinEntryEditText = ((FragmentInputConfirmPinBinding) vb).KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(pinEntryEditText, "");
            pinEntryEditText.post(new Runnable() { // from class: id.dana.riskChallenges.ui.resetpin.confirm.InputConfirmPinFragment$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    InputConfirmPinFragment.MyBillsEntityDataFactory(PinEntryEditText.this, inputConfirmPinFragment, function0);
                }
            });
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda2(InputConfirmPinFragment inputConfirmPinFragment) {
        DanaLoadingDialogFragment danaLoadingDialogFragment = (DanaLoadingDialogFragment) inputConfirmPinFragment.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
        FragmentManager parentFragmentManager = inputConfirmPinFragment.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
        danaLoadingDialogFragment.show(parentFragmentManager, "FullDanaLoading");
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(final InputConfirmPinFragment inputConfirmPinFragment, String str) {
        CommonDialog.Builder builder;
        Context context = inputConfirmPinFragment.getContext();
        if (context != null) {
            builder = new CommonDialog.Builder(context);
            builder.lookAheadTest = str;
            DialogType dialogType = DialogType.WARNING;
            Intrinsics.checkNotNullParameter(dialogType, "");
            builder.DatabaseTableConfigUtil = dialogType;
            builder.getAuthRequestContext = true;
            builder.BuiltInFictitiousFunctionClassFactory = new DialogInterface.OnDismissListener() { // from class: id.dana.riskChallenges.ui.resetpin.confirm.InputConfirmPinFragment$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    InputConfirmPinFragment.KClassImpl$Data$declaredNonStaticMembers$2(InputConfirmPinFragment.this);
                }
            };
        } else {
            builder = null;
        }
        if (builder != null) {
            new CommonDialog(builder.PlaceComponentResult, builder.BuiltInFictitiousFunctionClassFactory, builder.MyBillsEntityDataFactory, builder).moveToNextValue();
        }
    }
}
