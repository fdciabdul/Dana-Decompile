package id.dana.riskChallenges.ui.verifypin.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.os.BundleKt;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.core.ui.richview.PinEntryEditText;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.riskChallenges.R;
import id.dana.riskChallenges.databinding.FragmentBottomSheetPinVerifyBinding;
import id.dana.riskChallenges.databinding.LayoutPinVerifyBinding;
import id.dana.riskChallenges.databinding.ViewToolbarBottomSheetBinding;
import id.dana.riskChallenges.ui.util.uicomponent.UiComponent;
import id.dana.riskChallenges.ui.verifypin.shared.VerifyPinShared;
import id.dana.riskChallenges.ui.verifypin.shared.VerifyPinShared$$ExternalSyntheticLambda1;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u001d\u0010\u0012J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ-\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0003\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0013\u0010\u001c\u001a\u00020\u0019X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/riskChallenges/ui/verifypin/dialog/VerifyPinBottomSheetFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Landroid/os/Bundle;", "p0", "", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "p1", "p2", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onDestroyView", "()V", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lid/dana/riskChallenges/databinding/FragmentBottomSheetPinVerifyBinding;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/riskChallenges/databinding/FragmentBottomSheetPinVerifyBinding;", "getAuthRequestContext", "Lid/dana/riskChallenges/ui/verifypin/shared/VerifyPinShared;", "moveToNextValue", "Lkotlin/Lazy;", "BuiltInFictitiousFunctionClassFactory", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerifyPinBottomSheetFragment extends BottomSheetDialogFragment {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private FragmentBottomSheetPinVerifyBinding getAuthRequestContext;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<VerifyPinShared>() { // from class: id.dana.riskChallenges.ui.verifypin.dialog.VerifyPinBottomSheetFragment$verifyPinShared$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final VerifyPinShared invoke() {
            FragmentBottomSheetPinVerifyBinding fragmentBottomSheetPinVerifyBinding;
            FragmentBottomSheetPinVerifyBinding fragmentBottomSheetPinVerifyBinding2;
            VerifyPinBottomSheetFragment verifyPinBottomSheetFragment = VerifyPinBottomSheetFragment.this;
            VerifyPinBottomSheetFragment verifyPinBottomSheetFragment2 = verifyPinBottomSheetFragment;
            fragmentBottomSheetPinVerifyBinding = verifyPinBottomSheetFragment.getAuthRequestContext;
            LayoutPinVerifyBinding layoutPinVerifyBinding = fragmentBottomSheetPinVerifyBinding != null ? fragmentBottomSheetPinVerifyBinding.KClassImpl$Data$declaredNonStaticMembers$2 : null;
            fragmentBottomSheetPinVerifyBinding2 = VerifyPinBottomSheetFragment.this.getAuthRequestContext;
            return new VerifyPinShared(verifyPinBottomSheetFragment2, layoutPinVerifyBinding, fragmentBottomSheetPinVerifyBinding2 != null ? fragmentBottomSheetPinVerifyBinding2.PlaceComponentResult : null);
        }
    });
    public static final byte[] $$a = {1, -107, Ascii.ESC, -41, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 101;
    public static final byte[] PlaceComponentResult = {107, 78, -84, 46, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int MyBillsEntityDataFactory = 238;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX WARN: Removed duplicated region for block: B:20:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0028 -> B:23:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 15
            int r7 = r7 + 4
            byte[] r0 = id.dana.riskChallenges.ui.verifypin.dialog.VerifyPinBottomSheetFragment.PlaceComponentResult
            int r6 = r6 * 4
            int r6 = r6 + 16
            int r8 = r8 + 105
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L18
            r8 = r7
            r3 = r8
            r4 = 0
            r7 = r6
            goto L2e
        L18:
            r3 = 0
        L19:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            r3 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L2e:
            int r8 = r8 + 1
            int r3 = -r3
            int r6 = r6 + r3
            int r6 = r6 + 2
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.riskChallenges.ui.verifypin.dialog.VerifyPinBottomSheetFragment.a(byte, short, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002a -> B:23:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.riskChallenges.ui.verifypin.dialog.VerifyPinBottomSheetFragment.$$a
            int r6 = r6 * 2
            int r6 = 75 - r6
            int r7 = r7 * 2
            int r7 = r7 + 42
            int r8 = r8 * 3
            int r8 = 4 - r8
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1c
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L36
        L1c:
            r3 = 0
        L1d:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r7) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            int r3 = r3 + 1
            r4 = r0[r8]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L36:
            int r7 = -r7
            int r6 = r6 + r7
            int r7 = r9 + 1
            int r6 = r6 + (-7)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.riskChallenges.ui.verifypin.dialog.VerifyPinBottomSheetFragment.b(byte, int, int, java.lang.Object[]):void");
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater p0, ViewGroup p1, Bundle p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        FragmentBottomSheetPinVerifyBinding KClassImpl$Data$declaredNonStaticMembers$2 = FragmentBottomSheetPinVerifyBinding.KClassImpl$Data$declaredNonStaticMembers$2(p0, p1);
        this.getAuthRequestContext = KClassImpl$Data$declaredNonStaticMembers$2;
        return KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle p0) {
        try {
            byte b = (byte) (PlaceComponentResult[5] - 1);
            byte b2 = PlaceComponentResult[5];
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (PlaceComponentResult[5] - 1);
            byte b4 = b3;
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + 494, 3 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) (Process.myPid() >> 22));
                    byte b5 = (byte) ($$a[0] - 1);
                    byte b6 = b5;
                    Object[] objArr4 = new Object[1];
                    b(b5, b6, b6, objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - Process.getGidForName(""), 35 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (char) TextUtils.getOffsetBefore("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {1484663787, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 911, 18 - (ViewConfiguration.getTapTimeout() >> 16), (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                setStyle(0, R.style.PlaceComponentResult);
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

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle p0) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext(), R.style.PlaceComponentResult);
        bottomSheetDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: id.dana.riskChallenges.ui.verifypin.dialog.VerifyPinBottomSheetFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                VerifyPinBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2(dialogInterface);
            }
        });
        return bottomSheetDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View p0, Bundle p1) {
        ViewToolbarBottomSheetBinding viewToolbarBottomSheetBinding;
        UiComponent uiComponent;
        Parcelable parcelable;
        LayoutPinVerifyBinding layoutPinVerifyBinding;
        Intrinsics.checkNotNullParameter(p0, "");
        super.onViewCreated(p0, p1);
        getLifecycle().BuiltInFictitiousFunctionClassFactory((VerifyPinShared) this.BuiltInFictitiousFunctionClassFactory.getValue());
        FragmentBottomSheetPinVerifyBinding fragmentBottomSheetPinVerifyBinding = this.getAuthRequestContext;
        TextView textView = (fragmentBottomSheetPinVerifyBinding == null || (layoutPinVerifyBinding = fragmentBottomSheetPinVerifyBinding.KClassImpl$Data$declaredNonStaticMembers$2) == null) ? null : layoutPinVerifyBinding.KClassImpl$Data$declaredNonStaticMembers$2;
        if (textView != null) {
            textView.setContentDescription(getString(R.string.verify_pin_txt_input_pin_bottomsheet));
        }
        Window window = requireDialog().getWindow();
        if (window != null) {
            window.setSoftInputMode(16);
        }
        FragmentBottomSheetPinVerifyBinding fragmentBottomSheetPinVerifyBinding2 = this.getAuthRequestContext;
        if (fragmentBottomSheetPinVerifyBinding2 != null && (viewToolbarBottomSheetBinding = fragmentBottomSheetPinVerifyBinding2.MyBillsEntityDataFactory) != null) {
            TextView textView2 = viewToolbarBottomSheetBinding.KClassImpl$Data$declaredNonStaticMembers$2;
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
                uiComponent = (UiComponent) parcelable;
            } else {
                uiComponent = null;
            }
            textView2.setText(uiComponent != null ? getString(uiComponent.BuiltInFictitiousFunctionClassFactory) : null);
            AppCompatImageView appCompatImageView = viewToolbarBottomSheetBinding.BuiltInFictitiousFunctionClassFactory;
            int i = R.drawable.MyBillsEntityDataFactory;
            if (appCompatImageView instanceof ImageView) {
                InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
            } else {
                appCompatImageView.setImageResource(i);
            }
            viewToolbarBottomSheetBinding.BuiltInFictitiousFunctionClassFactory.setContentDescription(getString(R.string.verify_pin_btn_close_bottomsheet));
            viewToolbarBottomSheetBinding.BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.riskChallenges.ui.verifypin.dialog.VerifyPinBottomSheetFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VerifyPinBottomSheetFragment.MyBillsEntityDataFactory(VerifyPinBottomSheetFragment.this);
                }
            });
        }
        setCancelable(false);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.getAuthRequestContext = null;
        getLifecycle().KClassImpl$Data$declaredNonStaticMembers$2((VerifyPinShared) this.BuiltInFictitiousFunctionClassFactory.getValue());
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ9\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/riskChallenges/ui/verifypin/dialog/VerifyPinBottomSheetFragment$Companion;", "", "", "p0", "p1", "p2", "p3", "Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;", "p4", "Lid/dana/riskChallenges/ui/verifypin/dialog/VerifyPinBottomSheetFragment;", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/riskChallenges/ui/util/uicomponent/UiComponent;)Lid/dana/riskChallenges/ui/verifypin/dialog/VerifyPinBottomSheetFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static VerifyPinBottomSheetFragment getAuthRequestContext(String p0, String p1, String p2, String p3, UiComponent p4) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intrinsics.checkNotNullParameter(p2, "");
            Intrinsics.checkNotNullParameter(p3, "");
            VerifyPinBottomSheetFragment verifyPinBottomSheetFragment = new VerifyPinBottomSheetFragment();
            verifyPinBottomSheetFragment.setArguments(BundleKt.PlaceComponentResult(TuplesKt.to("KEY_UI_COMPONENT", p4), TuplesKt.to("KEY_STRATEGY", p0), TuplesKt.to("KEY_SCENE", p1), TuplesKt.to("KEY_SECURITY_ID", p2), TuplesKt.to("KEY_PHONE_NUMBER", p3)));
            return verifyPinBottomSheetFragment;
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(DialogInterface dialogInterface) {
        BottomSheetDialog bottomSheetDialog = dialogInterface instanceof BottomSheetDialog ? (BottomSheetDialog) dialogInterface : null;
        if (bottomSheetDialog != null) {
            View findViewById = bottomSheetDialog.findViewById(R.id.GetContactSyncConfig);
            FrameLayout frameLayout = findViewById instanceof FrameLayout ? (FrameLayout) findViewById : null;
            if (frameLayout != null) {
                final BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
                Intrinsics.checkNotNullExpressionValue(from, "");
                from.setPeekHeight(Resources.getSystem().getDisplayMetrics().heightPixels);
                from.setState(3);
                from.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: id.dana.riskChallenges.ui.verifypin.dialog.VerifyPinBottomSheetFragment$onCreateDialog$1$1$1$1
                    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                    public final void onSlide(View p0, float p1) {
                        Intrinsics.checkNotNullParameter(p0, "");
                    }

                    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                    public final void onStateChanged(View p0, int p1) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        if (p1 == 1) {
                            from.setState(3);
                        }
                    }
                });
            }
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(VerifyPinBottomSheetFragment verifyPinBottomSheetFragment) {
        PinEntryEditText pinEntryEditText;
        Intrinsics.checkNotNullParameter(verifyPinBottomSheetFragment, "");
        VerifyPinShared verifyPinShared = (VerifyPinShared) verifyPinBottomSheetFragment.BuiltInFictitiousFunctionClassFactory.getValue();
        LayoutPinVerifyBinding layoutPinVerifyBinding = verifyPinShared.getAuthRequestContext;
        if (layoutPinVerifyBinding != null && (pinEntryEditText = layoutPinVerifyBinding.MyBillsEntityDataFactory) != null) {
            pinEntryEditText.post(new VerifyPinShared$$ExternalSyntheticLambda1(verifyPinShared));
        }
        verifyPinBottomSheetFragment.getParentFragmentManager().setFragmentResult("KEY_RISK_CHALLENGE_FRAGMENT", BundleKt.PlaceComponentResult(TuplesKt.to("KEY_RESULT", 0)));
        verifyPinBottomSheetFragment.dismissNow();
    }
}
