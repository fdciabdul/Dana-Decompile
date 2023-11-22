package id.dana.riskChallenges.ui.resetpin.newpin;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
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
import com.google.zxing.pdf417.PDF417Common;
import id.dana.core.ui.BaseViewBindingFragment;
import id.dana.core.ui.constant.BottomInfoSnackbarState;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.core.ui.extension.FragmentExtKt;
import id.dana.core.ui.richview.BottomInfoSnackbar;
import id.dana.core.ui.richview.PinEntryEditText;
import id.dana.core.ui.util.KeyboardHelper;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.riskChallenges.R;
import id.dana.riskChallenges.databinding.FragmentInputNewPinBinding;
import id.dana.riskChallenges.di.component.RiskChallengesComponent;
import id.dana.riskChallenges.di.provider.RiskChallengesProvider;
import id.dana.riskChallenges.ui.resetpin.confirm.InputConfirmPinFragment;
import id.dana.riskChallenges.ui.resetpin.newpin.viewmodel.InputNewPinUiState;
import id.dana.riskChallenges.ui.resetpin.newpin.viewmodel.InputNewPinViewModel;
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
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b!\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\u0005R\u0013\u0010\u0013\u001a\u00020\u0010X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0015R\u0016\u0010\u000e\u001a\u00020\u00178\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u001a8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u001bR\u0013\u0010\u0011\u001a\u00020\u001cX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u001d\u0010\u0012R\u0012\u0010\u001f\u001a\u00020\u001eX\u0087\"¢\u0006\u0006\n\u0004\b\u001f\u0010 "}, d2 = {"Lid/dana/riskChallenges/ui/resetpin/newpin/InputNewPinFragment;", "Lid/dana/core/ui/BaseViewBindingFragment;", "Lid/dana/riskChallenges/databinding/FragmentInputNewPinBinding;", "", "lookAheadTest", "()V", "Landroid/os/Bundle;", "p0", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "p1", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "Lid/dana/core/ui/richview/BottomInfoSnackbar;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/Lazy;", "getAuthRequestContext", "Lid/dana/riskChallenges/ui/resetpin/newpin/InputNewPinFragment$errorSnackbarCallback$1;", "Lid/dana/riskChallenges/ui/resetpin/newpin/InputNewPinFragment$errorSnackbarCallback$1;", "MyBillsEntityDataFactory", "Lid/dana/riskChallenges/di/component/RiskChallengesComponent;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/riskChallenges/di/component/RiskChallengesComponent;", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "()Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "Lid/dana/riskChallenges/ui/resetpin/newpin/viewmodel/InputNewPinViewModel;", "scheduleImpl", "Lid/dana/core/ui/di/module/ViewModelFactory;", "viewModelFactory", "Lid/dana/core/ui/di/module/ViewModelFactory;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InputNewPinFragment extends BaseViewBindingFragment<FragmentInputNewPinBinding> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private RiskChallengesComponent BuiltInFictitiousFunctionClassFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final InputNewPinFragment$errorSnackbarCallback$1 MyBillsEntityDataFactory;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;
    @Inject
    public ViewModelFactory viewModelFactory;
    public static final byte[] $$a = {10, Byte.MIN_VALUE, TarHeader.LF_LINK, 76, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 141;
    public static final byte[] PlaceComponentResult = {116, 39, -17, SignedBytes.MAX_POWER_OF_TWO, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int MyBillsEntityDataFactory = 39;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    private static void a(int i, short s, byte b, Object[] objArr) {
        int i2 = (b * 15) + 4;
        int i3 = (i * 2) + 16;
        int i4 = s + 105;
        byte[] bArr = PlaceComponentResult;
        byte[] bArr2 = new byte[i3];
        int i5 = -1;
        int i6 = i3 - 1;
        if (bArr == null) {
            int i7 = i6 + i2;
            i2++;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = -1;
            i4 = i7 + 2;
            i6 = i6;
        }
        while (true) {
            int i8 = i5 + 1;
            bArr2[i8] = (byte) i4;
            if (i8 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i9 = i4;
            int i10 = i6;
            i2++;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = i8;
            i4 = i9 + bArr[i2] + 2;
            i6 = i10;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002e -> B:23:0x003a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r7, byte r8, short r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 4
            int r7 = 4 - r7
            byte[] r0 = id.dana.riskChallenges.ui.resetpin.newpin.InputNewPinFragment.$$a
            int r9 = r9 * 4
            int r9 = 75 - r9
            int r8 = r8 * 3
            int r8 = r8 + 42
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L1a
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r8
            r8 = r7
            goto L3a
        L1a:
            r3 = 0
            r5 = r8
            r8 = r7
            r7 = r9
            r9 = r5
        L1f:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r9) goto L2e
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2e:
            r4 = r0[r8]
            r5 = r8
            r8 = r7
            r7 = r5
            r6 = r10
            r10 = r9
            r9 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L3a:
            int r9 = -r9
            int r7 = r7 + 1
            int r8 = r8 + r9
            int r8 = r8 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1f
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.riskChallenges.ui.resetpin.newpin.InputNewPinFragment.b(short, byte, short, java.lang.Object[]):void");
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final /* synthetic */ FragmentInputNewPinBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentInputNewPinBinding BuiltInFictitiousFunctionClassFactory = FragmentInputNewPinBinding.BuiltInFictitiousFunctionClassFactory(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    private final UiComponent MyBillsEntityDataFactory() {
        Object obj;
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                obj = (Parcelable) arguments.getParcelable("KEY_UI_COMPONENT", UiComponent.class);
            } else {
                Object parcelable = arguments.getParcelable("KEY_UI_COMPONENT");
                obj = (Parcelable) ((UiComponent) (parcelable instanceof UiComponent ? parcelable : null));
            }
            return (UiComponent) obj;
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle p0) {
        try {
            byte b = (byte) (PlaceComponentResult[5] + 1);
            byte b2 = (byte) (-PlaceComponentResult[5]);
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (PlaceComponentResult[5] + 1);
            byte b4 = b3;
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + 494, Color.blue(0) + 4, (char) Color.alpha(0));
                    byte b5 = (byte) ($$a[4] - 1);
                    byte b6 = b5;
                    Object[] objArr4 = new Object[1];
                    b(b5, b6, b6, objArr4);
                    obj = cls2.getMethod((String) objArr4[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj);
                }
                Object[] objArr5 = (Object[]) ((Method) obj).invoke(null, objArr3);
                int i = ((int[]) objArr5[1])[0];
                if (((int[]) objArr5[0])[0] != i) {
                    long j = ((r1 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + PDF417Common.NUMBER_OF_CODEWORDS, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 34, (char) View.resolveSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {691012067, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.combineMeasuredStates(0, 0), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 17, (char) ((-1) - Process.getGidForName("")))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory;
                BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(this);
                Bundle arguments = getArguments();
                if (arguments != null) {
                    ((InputNewPinViewModel) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).MyBillsEntityDataFactory = arguments.getString("KEY_PHONE_NUMBER");
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
        Intrinsics.checkNotNullParameter(p0, "");
        super.onViewCreated(p0, p1);
        UiComponent MyBillsEntityDataFactory2 = MyBillsEntityDataFactory();
        if (MyBillsEntityDataFactory2 != null) {
            VB vb = this.PlaceComponentResult;
            if (vb != 0) {
                ((FragmentInputNewPinBinding) vb).getAuthRequestContext.setBackgroundColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(requireContext(), MyBillsEntityDataFactory2.MyBillsEntityDataFactory));
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        VB vb2 = this.PlaceComponentResult;
        if (vb2 != 0) {
            ((FragmentInputNewPinBinding) vb2).MyBillsEntityDataFactory.setMaxLength(6);
            VB vb3 = this.PlaceComponentResult;
            if (vb3 != 0) {
                ((FragmentInputNewPinBinding) vb3).MyBillsEntityDataFactory.setOnPinEnteredListener(new PinEntryEditText.OnPinEnteredListener() { // from class: id.dana.riskChallenges.ui.resetpin.newpin.InputNewPinFragment$initView$2
                    @Override // id.dana.core.ui.richview.PinEntryEditText.OnPinEnteredListener
                    public final void getAuthRequestContext(CharSequence p02) {
                        if (p02 != null) {
                            InputNewPinFragment inputNewPinFragment = InputNewPinFragment.this;
                            String obj = p02.toString();
                            InputNewPinViewModel KClassImpl$Data$declaredNonStaticMembers$2 = InputNewPinFragment.KClassImpl$Data$declaredNonStaticMembers$2(inputNewPinFragment);
                            Intrinsics.checkNotNullParameter(obj, "");
                            PinValidator pinValidator = PinValidator.INSTANCE;
                            if (PinValidator.MyBillsEntityDataFactory(obj)) {
                                MutableStateFlow<InputNewPinUiState> mutableStateFlow = KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
                                do {
                                } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), InputNewPinUiState.PinSequential.INSTANCE));
                                return;
                            }
                            PinValidator pinValidator2 = PinValidator.INSTANCE;
                            if (PinValidator.getAuthRequestContext(obj)) {
                                MutableStateFlow<InputNewPinUiState> mutableStateFlow2 = KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
                                do {
                                } while (!mutableStateFlow2.compareAndSet(mutableStateFlow2.getValue(), InputNewPinUiState.PinRepetitive.INSTANCE));
                                return;
                            }
                            MutableStateFlow<InputNewPinUiState> mutableStateFlow3 = KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
                            do {
                            } while (!mutableStateFlow3.compareAndSet(mutableStateFlow3.getValue(), new InputNewPinUiState.PinValid(obj)));
                        }
                    }

                    @Override // id.dana.core.ui.richview.PinEntryEditText.OnPinEnteredListener
                    public final void MyBillsEntityDataFactory() {
                        if (InputNewPinFragment.MyBillsEntityDataFactory(InputNewPinFragment.this).getAuthRequestContext != BottomInfoSnackbarState.ERROR || InputNewPinFragment.MyBillsEntityDataFactory(InputNewPinFragment.this).isShown()) {
                            return;
                        }
                        InputNewPinFragment.this.PlaceComponentResult();
                    }
                });
                VB vb4 = this.PlaceComponentResult;
                if (vb4 != 0) {
                    ((FragmentInputNewPinBinding) vb4).MyBillsEntityDataFactory.focus();
                    PlaceComponentResult();
                    VB vb5 = this.PlaceComponentResult;
                    if (vb5 != 0) {
                        ((FragmentInputNewPinBinding) vb5).BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.riskChallenges.ui.resetpin.newpin.InputNewPinFragment$$ExternalSyntheticLambda1
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                InputNewPinFragment.PlaceComponentResult(InputNewPinFragment.this);
                            }
                        });
                        VB vb6 = this.PlaceComponentResult;
                        if (vb6 != 0) {
                            ((FragmentInputNewPinBinding) vb6).lookAheadTest.PlaceComponentResult.setText(getString(R.string.reset_pin_input_new_pin_toolbar_title));
                            VB vb7 = this.PlaceComponentResult;
                            if (vb7 != 0) {
                                AppCompatImageView appCompatImageView = ((FragmentInputNewPinBinding) vb7).lookAheadTest.BuiltInFictitiousFunctionClassFactory;
                                int i = R.drawable.getAuthRequestContext;
                                if (appCompatImageView instanceof ImageView) {
                                    InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
                                } else {
                                    appCompatImageView.setImageResource(i);
                                }
                                VB vb8 = this.PlaceComponentResult;
                                if (vb8 != 0) {
                                    ((FragmentInputNewPinBinding) vb8).lookAheadTest.BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.riskChallenges.ui.resetpin.newpin.InputNewPinFragment$$ExternalSyntheticLambda2
                                        @Override // android.view.View.OnClickListener
                                        public final void onClick(View view) {
                                            InputNewPinFragment.getAuthRequestContext(InputNewPinFragment.this);
                                        }
                                    });
                                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.PlaceComponentResult(this), Dispatchers.getMain(), null, new InputNewPinFragment$observeUiState$1(this, null), 2, null);
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

    private final void BuiltInFictitiousFunctionClassFactory() {
        if (FragmentExtKt.PlaceComponentResult(this)) {
            getParentFragmentManager().setFragmentResult("KEY_RISK_CHALLENGE_FRAGMENT", BundleKt.PlaceComponentResult(TuplesKt.to("KEY_RESULT", 0)));
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJA\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/riskChallenges/ui/resetpin/newpin/InputNewPinFragment$Companion;", "", "", "p0", "p1", "p2", "p3", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "p4", "p5", "Lid/dana/riskChallenges/ui/resetpin/newpin/InputNewPinFragment;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;Ljava/lang/String;)Lid/dana/riskChallenges/ui/resetpin/newpin/InputNewPinFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static InputNewPinFragment BuiltInFictitiousFunctionClassFactory(String p0, String p1, String p2, String p3, UiComponent p4, String p5) {
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p2, "");
            Intrinsics.checkNotNullParameter(p3, "");
            Intrinsics.checkNotNullParameter(p5, "");
            InputNewPinFragment inputNewPinFragment = new InputNewPinFragment();
            inputNewPinFragment.setArguments(BundleKt.PlaceComponentResult(TuplesKt.to("KEY_PHONE_NUMBER", p0), TuplesKt.to("KEY_SECURITY_ID", p1), TuplesKt.to("KEY_RISK_TOKEN", p2), TuplesKt.to("KEY_SCENE", p3), TuplesKt.to("KEY_UI_COMPONENT", p4), TuplesKt.to("KEY_SOURCE", p5)));
            return inputNewPinFragment;
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [id.dana.riskChallenges.ui.resetpin.newpin.InputNewPinFragment$errorSnackbarCallback$1] */
    public InputNewPinFragment() {
        final InputNewPinFragment inputNewPinFragment = this;
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: id.dana.riskChallenges.ui.resetpin.newpin.InputNewPinFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelFactory viewModelFactory = InputNewPinFragment.this.viewModelFactory;
                if (viewModelFactory == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    viewModelFactory = null;
                }
                return viewModelFactory;
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: id.dana.riskChallenges.ui.resetpin.newpin.InputNewPinFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: id.dana.riskChallenges.ui.resetpin.newpin.InputNewPinFragment$special$$inlined$viewModels$default$2
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
        this.KClassImpl$Data$declaredNonStaticMembers$2 = FragmentViewModelLazyKt.BuiltInFictitiousFunctionClassFactory(inputNewPinFragment, Reflection.getOrCreateKotlinClass(InputNewPinViewModel.class), new Function0<ViewModelStore>() { // from class: id.dana.riskChallenges.ui.resetpin.newpin.InputNewPinFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: id.dana.riskChallenges.ui.resetpin.newpin.InputNewPinFragment$special$$inlined$viewModels$default$4
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
        this.getAuthRequestContext = LazyKt.lazy(new Function0<BottomInfoSnackbar>() { // from class: id.dana.riskChallenges.ui.resetpin.newpin.InputNewPinFragment$bottomInfoSnackbar$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BottomInfoSnackbar invoke() {
                BottomInfoSnackbar.Companion companion = BottomInfoSnackbar.INSTANCE;
                VB vb = InputNewPinFragment.this.PlaceComponentResult;
                if (vb != 0) {
                    ConstraintLayout constraintLayout = ((FragmentInputNewPinBinding) vb).getAuthRequestContext;
                    Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
                    return BottomInfoSnackbar.Companion.getAuthRequestContext(constraintLayout);
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        });
        this.MyBillsEntityDataFactory = new BaseTransientBottomBar.BaseCallback<BottomInfoSnackbar>() { // from class: id.dana.riskChallenges.ui.resetpin.newpin.InputNewPinFragment$errorSnackbarCallback$1
            @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
            public final /* synthetic */ void onDismissed(BottomInfoSnackbar bottomInfoSnackbar, int i) {
                InputNewPinFragment.KClassImpl$Data$declaredNonStaticMembers$2(InputNewPinFragment.this).PlaceComponentResult();
            }
        };
    }

    public static /* synthetic */ void getAuthRequestContext(InputNewPinFragment inputNewPinFragment) {
        Intrinsics.checkNotNullParameter(inputNewPinFragment, "");
        inputNewPinFragment.BuiltInFictitiousFunctionClassFactory();
    }

    public static /* synthetic */ void PlaceComponentResult(InputNewPinFragment inputNewPinFragment) {
        Intrinsics.checkNotNullParameter(inputNewPinFragment, "");
        VB vb = inputNewPinFragment.PlaceComponentResult;
        if (vb != 0) {
            if (Intrinsics.areEqual(((FragmentInputNewPinBinding) vb).BuiltInFictitiousFunctionClassFactory.getText().toString(), inputNewPinFragment.getString(R.string.res_0x7f13157a_summaryvoucherview_externalsyntheticlambda1))) {
                VB vb2 = inputNewPinFragment.PlaceComponentResult;
                if (vb2 != 0) {
                    ((FragmentInputNewPinBinding) vb2).MyBillsEntityDataFactory.showCharacters();
                    VB vb3 = inputNewPinFragment.PlaceComponentResult;
                    if (vb3 != 0) {
                        ((FragmentInputNewPinBinding) vb3).BuiltInFictitiousFunctionClassFactory.setText(inputNewPinFragment.getString(R.string.res_0x7f130a5d_networkuserentitydata_externalsyntheticlambda8));
                        return;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            VB vb4 = inputNewPinFragment.PlaceComponentResult;
            if (vb4 != 0) {
                ((FragmentInputNewPinBinding) vb4).MyBillsEntityDataFactory.hideCharacters();
                VB vb5 = inputNewPinFragment.PlaceComponentResult;
                if (vb5 != 0) {
                    ((FragmentInputNewPinBinding) vb5).BuiltInFictitiousFunctionClassFactory.setText(inputNewPinFragment.getString(R.string.res_0x7f13157a_summaryvoucherview_externalsyntheticlambda1));
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(InputNewPinFragment inputNewPinFragment) {
        Intrinsics.checkNotNullParameter(inputNewPinFragment, "");
        VB vb = inputNewPinFragment.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentInputNewPinBinding) vb).MyBillsEntityDataFactory.clearFocus();
            KeyboardHelper.getAuthRequestContext(inputNewPinFragment.getView());
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ BottomInfoSnackbar MyBillsEntityDataFactory(InputNewPinFragment inputNewPinFragment) {
        return (BottomInfoSnackbar) inputNewPinFragment.getAuthRequestContext.getValue();
    }

    public static final /* synthetic */ InputNewPinViewModel KClassImpl$Data$declaredNonStaticMembers$2(InputNewPinFragment inputNewPinFragment) {
        return (InputNewPinViewModel) inputNewPinFragment.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(InputNewPinFragment inputNewPinFragment, String str, String str2) {
        ((BottomInfoSnackbar) inputNewPinFragment.getAuthRequestContext.getValue()).dismiss();
        FragmentManager parentFragmentManager = inputNewPinFragment.getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "");
        Bundle arguments = inputNewPinFragment.getArguments();
        String string = arguments != null ? arguments.getString("KEY_SECURITY_ID") : null;
        String str3 = string == null ? "" : string;
        Bundle arguments2 = inputNewPinFragment.getArguments();
        String string2 = arguments2 != null ? arguments2.getString("KEY_RISK_TOKEN") : null;
        String str4 = string2 == null ? "" : string2;
        Bundle arguments3 = inputNewPinFragment.getArguments();
        String string3 = arguments3 != null ? arguments3.getString("KEY_SCENE") : null;
        String str5 = string3 == null ? "" : string3;
        Bundle arguments4 = inputNewPinFragment.getArguments();
        String string4 = arguments4 != null ? arguments4.getString("KEY_SOURCE") : null;
        String str6 = string4 == null ? "" : string4;
        InputConfirmPinFragment.Companion companion = InputConfirmPinFragment.INSTANCE;
        InputConfirmPinFragment BuiltInFictitiousFunctionClassFactory = InputConfirmPinFragment.Companion.BuiltInFictitiousFunctionClassFactory(str, str2, str3, str4, str5, inputNewPinFragment.MyBillsEntityDataFactory(), str6);
        FragmentTransaction beginTransaction = parentFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "");
        FragmentExtKt.BuiltInFictitiousFunctionClassFactory(beginTransaction);
        beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2(R.id.initRecordTimeStamp, BuiltInFictitiousFunctionClassFactory, null, 1);
        if (!beginTransaction.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        beginTransaction.scheduleImpl = true;
        beginTransaction.NetworkUserEntityData$$ExternalSyntheticLambda8 = "new_fragment";
        beginTransaction.getAuthRequestContext();
    }

    public static final /* synthetic */ void moveToNextValue(InputNewPinFragment inputNewPinFragment) {
        BottomInfoSnackbar bottomInfoSnackbar = (BottomInfoSnackbar) inputNewPinFragment.getAuthRequestContext.getValue();
        bottomInfoSnackbar.KClassImpl$Data$declaredNonStaticMembers$2(BottomInfoSnackbarState.ERROR);
        String string = inputNewPinFragment.getString(R.string.reset_pin_input_new_pin_error_repetitive_pin);
        Intrinsics.checkNotNullExpressionValue(string, "");
        Intrinsics.checkNotNullParameter(string, "");
        bottomInfoSnackbar.MyBillsEntityDataFactory.MyBillsEntityDataFactory.setText(string);
        bottomInfoSnackbar.addCallback(inputNewPinFragment.MyBillsEntityDataFactory);
        bottomInfoSnackbar.setDuration(-1);
        bottomInfoSnackbar.show();
    }

    public static final /* synthetic */ void lookAheadTest(InputNewPinFragment inputNewPinFragment) {
        BottomInfoSnackbar bottomInfoSnackbar = (BottomInfoSnackbar) inputNewPinFragment.getAuthRequestContext.getValue();
        bottomInfoSnackbar.KClassImpl$Data$declaredNonStaticMembers$2(BottomInfoSnackbarState.ERROR);
        String string = inputNewPinFragment.getString(R.string.reset_pin_input_new_pin_error_sequential_pin);
        Intrinsics.checkNotNullExpressionValue(string, "");
        Intrinsics.checkNotNullParameter(string, "");
        bottomInfoSnackbar.MyBillsEntityDataFactory.MyBillsEntityDataFactory.setText(string);
        bottomInfoSnackbar.addCallback(inputNewPinFragment.MyBillsEntityDataFactory);
        bottomInfoSnackbar.setDuration(-1);
        bottomInfoSnackbar.show();
    }

    public final void PlaceComponentResult() {
        BottomInfoSnackbar bottomInfoSnackbar = (BottomInfoSnackbar) this.getAuthRequestContext.getValue();
        bottomInfoSnackbar.KClassImpl$Data$declaredNonStaticMembers$2(BottomInfoSnackbarState.NORMAL);
        String string = getString(R.string.reset_pin_input_new_pin_birth_date_warning);
        Intrinsics.checkNotNullExpressionValue(string, "");
        Intrinsics.checkNotNullParameter(string, "");
        bottomInfoSnackbar.MyBillsEntityDataFactory.MyBillsEntityDataFactory.setText(string);
        bottomInfoSnackbar.setDuration(0);
        bottomInfoSnackbar.show();
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final void lookAheadTest() {
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            ((FragmentInputNewPinBinding) vb).MyBillsEntityDataFactory.post(new Runnable() { // from class: id.dana.riskChallenges.ui.resetpin.newpin.InputNewPinFragment$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    InputNewPinFragment.BuiltInFictitiousFunctionClassFactory(InputNewPinFragment.this);
                }
            });
            BuiltInFictitiousFunctionClassFactory();
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
