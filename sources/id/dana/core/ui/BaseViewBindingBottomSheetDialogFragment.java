package id.dana.core.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBinding;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.core.ui.util.ImageResizeUtil;
import id.dana.core.ui.util.WindowManagerUtil;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 0*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u00010B\u0007¢\u0006\u0004\b/\u0010\u0015J\u000f\u0010\u0005\u001a\u00020\u0004H$¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH$¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0005\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0004\b\u0005\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001e\u001a\u00020\u00132\b\u0010\b\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ-\u0010!\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010 \u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0013H\u0016¢\u0006\u0004\b#\u0010\u0015J\u000f\u0010$\u001a\u00020\u0013H\u0014¢\u0006\u0004\b$\u0010\u0015J\u000f\u0010\u0018\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0018\u0010\u0015J!\u0010%\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b%\u0010&R\u0018\u0010\u0018\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010\r\u001a\u0004\u0018\u00010\fX\u0084\u0002¢\u0006\u0006\n\u0004\b)\u0010*R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010+8\u0005X\u0084\u0006¢\u0006\f\n\u0004\b\u0018\u0010,\u001a\u0004\b-\u0010."}, d2 = {"Lid/dana/core/ui/BaseViewBindingBottomSheetDialogFragment;", "Landroidx/viewbinding/ViewBinding;", "VB", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "", "BuiltInFictitiousFunctionClassFactory", "()F", "Landroid/app/Dialog;", "p0", "", "PlaceComponentResult", "(Landroid/app/Dialog;)I", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/view/View;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "p1", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroidx/viewbinding/ViewBinding;", "", "getAuthRequestContext", "()V", "a_", "(I)V", "MyBillsEntityDataFactory", "(Landroid/app/Dialog;)V", "Landroid/content/DialogInterface;", "onCancel", "(Landroid/content/DialogInterface;)V", "Landroid/os/Bundle;", "onCreate", "(Landroid/os/Bundle;)V", "p2", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onDestroyView", "p_", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroidx/viewbinding/ViewBinding;", "scheduleImpl", "Landroid/view/View;", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "o_", "()Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BaseViewBindingBottomSheetDialogFragment<VB extends ViewBinding> extends BottomSheetDialogFragment {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private BottomSheetBehavior<View> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public VB MyBillsEntityDataFactory;
    public Map<Integer, View> getErrorConfigVersion = new LinkedHashMap();

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    protected View KClassImpl$Data$declaredNonStaticMembers$2;
    public static final byte[] $$d = {79, Ascii.DC4, Ascii.EM, -22, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$e = 170;
    public static final byte[] moveToNextValue = {104, -34, -42, -1, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int lookAheadTest = 239;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment.moveToNextValue
            int r8 = r8 + 105
            int r6 = r6 * 15
            int r6 = 18 - r6
            int r7 = r7 * 4
            int r7 = r7 + 16
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L18
            r8 = r7
            r3 = r8
            r4 = 0
            r7 = r6
            goto L30
        L18:
            r3 = 0
        L19:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            int r6 = r6 + 1
            r3 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L30:
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
        throw new UnsupportedOperationException("Method not decompiled: id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment.c(short, byte, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(byte r5, int r6, byte r7, java.lang.Object[] r8) {
        /*
            byte[] r0 = id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment.$$d
            int r6 = r6 * 3
            int r6 = 42 - r6
            int r5 = r5 * 4
            int r5 = r5 + 4
            int r7 = r7 * 4
            int r7 = r7 + 75
            byte[] r1 = new byte[r6]
            r2 = -1
            int r6 = r6 + r2
            if (r0 != 0) goto L18
            r7 = r6
            r3 = r7
            r6 = r5
            goto L2e
        L18:
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
        L1c:
            int r2 = r2 + 1
            byte r3 = (byte) r5
            r1[r2] = r3
            if (r2 != r7) goto L2c
            java.lang.String r5 = new java.lang.String
            r6 = 0
            r5.<init>(r1, r6)
            r8[r6] = r5
            return
        L2c:
            r3 = r0[r6]
        L2e:
            int r3 = -r3
            int r5 = r5 + r3
            int r5 = r5 + (-7)
            int r6 = r6 + 1
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment.d(byte, int, byte, java.lang.Object[]):void");
    }

    protected abstract float BuiltInFictitiousFunctionClassFactory();

    public abstract VB BuiltInFictitiousFunctionClassFactory(LayoutInflater p0, ViewGroup p1);

    public abstract View KClassImpl$Data$declaredNonStaticMembers$2();

    public void PlaceComponentResult() {
        this.getErrorConfigVersion.clear();
    }

    @JvmName(name = "o_")
    public final BottomSheetBehavior<View> o_() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int PlaceComponentResult(Dialog p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (p0.getWindow() != null) {
            WindowManagerUtil windowManagerUtil = WindowManagerUtil.INSTANCE;
            Window window = p0.getWindow();
            WindowManagerUtil.KClassImpl$Data$declaredNonStaticMembers$2(window != null ? window.getWindowManager() : null, displayMetrics);
        }
        int i = displayMetrics.heightPixels;
        ImageResizeUtil imageResizeUtil = ImageResizeUtil.INSTANCE;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "");
        FragmentActivity fragmentActivity = requireActivity;
        Intrinsics.checkNotNullParameter(fragmentActivity, "");
        return i - ImageResizeUtil.BuiltInFictitiousFunctionClassFactory(fragmentActivity);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle p0) {
        try {
            byte b = (byte) (moveToNextValue[5] - 1);
            Object[] objArr = new Object[1];
            c(b, b, moveToNextValue[5], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = moveToNextValue[5];
            byte b3 = (byte) (b2 - 1);
            Object[] objArr2 = new Object[1];
            c(b2, b3, b3, objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + 494, Color.green(0) + 4, (char) TextUtils.getOffsetAfter("", 0));
                    byte b4 = (byte) ($$d[4] - 1);
                    byte b5 = b4;
                    Object[] objArr4 = new Object[1];
                    d(b4, b5, b5, objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf("", "") + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getFadingEdgeLength() >> 16) + 35, (char) (Process.myTid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {1649677314, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getDoubleTapTimeout() >> 16), 18 - Color.blue(0), (char) KeyEvent.getDeadChar(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                setStyle(0, R.style.MyBillsEntityDataFactory);
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

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater p0, ViewGroup p1, Bundle p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        VB BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(p0, p1);
        this.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory;
        if (BuiltInFictitiousFunctionClassFactory != null) {
            return BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View p0, Bundle p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onViewCreated(p0, p1);
        getAuthRequestContext();
    }

    public void getAuthRequestContext() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    BaseViewBindingBottomSheetDialogFragment.BuiltInFictitiousFunctionClassFactory(BaseViewBindingBottomSheetDialogFragment.this);
                }
            });
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    BaseViewBindingBottomSheetDialogFragment.getAuthRequestContext(BaseViewBindingBottomSheetDialogFragment.this);
                }
            });
        }
    }

    public void p_() {
        this.BuiltInFictitiousFunctionClassFactory = null;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onCancel(p0);
        dismiss();
    }

    public final void MyBillsEntityDataFactory(Dialog p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Window window = p0.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            Intrinsics.checkNotNullExpressionValue(attributes, "");
            attributes.dimAmount = BuiltInFictitiousFunctionClassFactory();
            attributes.flags |= 2;
            window.setAttributes(attributes);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.MyBillsEntityDataFactory = null;
        PlaceComponentResult();
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(BaseViewBindingBottomSheetDialogFragment baseViewBindingBottomSheetDialogFragment) {
        Intrinsics.checkNotNullParameter(baseViewBindingBottomSheetDialogFragment, "");
        baseViewBindingBottomSheetDialogFragment.MyBillsEntityDataFactory();
    }

    public static /* synthetic */ void PlaceComponentResult(View view, BaseViewBindingBottomSheetDialogFragment baseViewBindingBottomSheetDialogFragment) {
        Intrinsics.checkNotNullParameter(baseViewBindingBottomSheetDialogFragment, "");
        ViewParent parent = view.getParent();
        if (parent == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        }
        ViewGroup.LayoutParams layoutParams = ((View) parent).getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        }
        BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) ((CoordinatorLayout.LayoutParams) layoutParams).lookAheadTest;
        WindowManagerUtil windowManagerUtil = WindowManagerUtil.INSTANCE;
        FragmentActivity requireActivity = baseViewBindingBottomSheetDialogFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "");
        Point PlaceComponentResult = WindowManagerUtil.PlaceComponentResult(requireActivity);
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setPeekHeight(PlaceComponentResult.y);
        }
    }

    public static /* synthetic */ void getAuthRequestContext(BaseViewBindingBottomSheetDialogFragment baseViewBindingBottomSheetDialogFragment) {
        Intrinsics.checkNotNullParameter(baseViewBindingBottomSheetDialogFragment, "");
        baseViewBindingBottomSheetDialogFragment.p_();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a_(final int i) {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != null) {
            Intrinsics.checkNotNullExpressionValue(vb.KClassImpl$Data$declaredNonStaticMembers$2(), "");
            BottomSheetBehavior<View> bottomSheetBehavior = this.BuiltInFictitiousFunctionClassFactory;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setState(3);
            }
            BottomSheetBehavior<View> bottomSheetBehavior2 = this.BuiltInFictitiousFunctionClassFactory;
            if (bottomSheetBehavior2 != null) {
                bottomSheetBehavior2.setPeekHeight(i);
            }
            BottomSheetBehavior<View> bottomSheetBehavior3 = this.BuiltInFictitiousFunctionClassFactory;
            if (bottomSheetBehavior3 != null) {
                bottomSheetBehavior3.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment$initBottomSheet$1
                    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                    public final void onSlide(View p0, float p1) {
                        Intrinsics.checkNotNullParameter(p0, "");
                    }

                    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                    public final void onStateChanged(View p0, int p1) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        if (p1 == 5 || (p1 == 4 && i == 0)) {
                            this.dismiss();
                        }
                    }
                });
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public void MyBillsEntityDataFactory() {
        View KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2;
        this.BuiltInFictitiousFunctionClassFactory = BottomSheetBehavior.from(KClassImpl$Data$declaredNonStaticMembers$2);
    }
}
