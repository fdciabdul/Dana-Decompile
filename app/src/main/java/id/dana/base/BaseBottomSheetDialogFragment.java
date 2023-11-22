package id.dana.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Bundle;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import butterknife.Unbinder;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import id.dana.R;
import id.dana.base.AbstractContract;
import id.dana.base.BaseButterKnife;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.utils.ImageResize;
import id.dana.utils.KeyboardHelper;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.functions.Function1;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes4.dex */
public abstract class BaseBottomSheetDialogFragment extends BottomSheetDialogFragment implements PresenterHandler, BaseViewBinding<ViewBinding>, BaseButterKnife {
    private static final int RESIZE_HEIGHT = 56;
    private ViewBinding _binding;
    private BaseActivity baseActivity;
    public View bottomSheet;
    public BottomSheetBehavior<View> bottomSheetBehavior;
    private final List<AbstractContract.AbstractPresenter> presenters = new ArrayList();
    private Unbinder unbinder;
    public static final byte[] $$a = {44, -51, -23, -10, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 109;
    public static final byte[] PlaceComponentResult = {116, 39, -17, SignedBytes.MAX_POWER_OF_TWO, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int MyBillsEntityDataFactory = 24;

    /* JADX WARN: Removed duplicated region for block: B:44:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x002b -> B:47:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r7, int r8, int r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 * 15
            int r9 = 19 - r9
            int r8 = r8 * 2
            int r8 = r8 + 16
            byte[] r0 = id.dana.base.BaseBottomSheetDialogFragment.PlaceComponentResult
            int r7 = 106 - r7
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L18
            r7 = r8
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L33
        L18:
            r3 = 0
            r6 = r8
            r8 = r7
            r7 = r6
        L1c:
            byte r4 = (byte) r8
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r7) goto L2b
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2b:
            r3 = r0[r9]
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L33:
            int r8 = r8 + r9
            int r8 = r8 + 2
            int r9 = r10 + 1
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.base.BaseBottomSheetDialogFragment.a(int, int, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0029 -> B:47:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r7, short r8, int r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 3
            int r7 = 75 - r7
            int r9 = r9 + 4
            int r8 = r8 * 4
            int r8 = r8 + 42
            byte[] r0 = id.dana.base.BaseBottomSheetDialogFragment.$$a
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L31
        L17:
            r3 = 0
        L18:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            int r9 = r9 + 1
            if (r4 != r8) goto L29
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L29:
            r3 = r0[r9]
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L31:
            int r7 = r7 + r9
            int r7 = r7 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.base.BaseBottomSheetDialogFragment.b(int, short, int, java.lang.Object[]):void");
    }

    public static /* synthetic */ ViewBinding lambda$getBindingInflater$0(LayoutInflater layoutInflater) {
        return null;
    }

    public /* synthetic */ void bind(Activity activity) {
        BaseButterKnife.CC.MyBillsEntityDataFactory(this, activity);
    }

    public /* synthetic */ void bind(Object obj, View view) {
        BaseButterKnife.CC.BuiltInFictitiousFunctionClassFactory(this, obj, view);
    }

    public ViewBinding getBinding() {
        return null;
    }

    /* renamed from: getBottomSheet */
    protected abstract View getPlaceComponentResult();

    protected abstract float getDimAmount();

    protected KeyboardHelper.KeyboardVisibilityListener getKeyboardVisibilityListener() {
        return null;
    }

    @Deprecated
    protected int getLayout() {
        return 0;
    }

    protected int getResizeHeight() {
        return 56;
    }

    public /* synthetic */ boolean isViewBinded() {
        return BaseButterKnife.CC.PlaceComponentResult(this);
    }

    public /* synthetic */ void tryUnbind() {
        BaseButterKnife.CC.BuiltInFictitiousFunctionClassFactory(this);
    }

    public BaseActivity getBaseActivity() {
        return this.baseActivity;
    }

    @Override // id.dana.base.BaseButterKnife
    public Unbinder getUnbinder() {
        return this.unbinder;
    }

    @Override // id.dana.base.BaseButterKnife
    public void setUnbinder(Unbinder unbinder) {
        this.unbinder = unbinder;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() instanceof BaseActivity) {
            this.baseActivity = (BaseActivity) getActivity();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        try {
            byte b = (byte) (PlaceComponentResult[5] + 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (-PlaceComponentResult[5]);
            Object[] objArr2 = new Object[1];
            a(b3, (byte) (b3 - 1), (byte) (-PlaceComponentResult[5]), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - TextUtils.getCapsMode("", 0, 0), 4 - TextUtils.indexOf("", "", 0, 0), (char) ('0' - AndroidCharacter.getMirror('0')));
                    byte b4 = (byte) ($$a[35] - 1);
                    Object[] objArr4 = new Object[1];
                    b(b4, b4, $$a[4], objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 35, (char) TextUtils.getOffsetBefore("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {181520075, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(((byte) KeyEvent.getModifierMetaStateMask()) + 912, 18 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                super.onCreate(bundle);
                setStyle(0, R.style.f50012132017464);
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

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        tryUnbind();
        disposePresenter();
        super.onDestroyView();
    }

    public void registerPresenter(AbstractContract.AbstractPresenter... abstractPresenterArr) {
        this.presenters.addAll(Arrays.asList(abstractPresenterArr));
    }

    public void disposePresenter() {
        for (AbstractContract.AbstractPresenter abstractPresenter : this.presenters) {
            if (abstractPresenter != null) {
                abstractPresenter.onDestroy();
            }
        }
        this.presenters.clear();
    }

    public void dismissOnTouchOutsideDialog(boolean z) {
        setCancelable(z);
    }

    public void initBottomSheet(int i, int i2) {
        initKeyboardListener(getGetAuthRequestContext());
        this.bottomSheetBehavior.setState(i2);
        this.bottomSheetBehavior.setPeekHeight(i);
        this.bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: id.dana.base.BaseBottomSheetDialogFragment.1
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onSlide(View view, float f) {
            }

            {
                BaseBottomSheetDialogFragment.this = this;
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onStateChanged(View view, int i3) {
                if (i3 == 5) {
                    BaseBottomSheetDialogFragment.this.dismiss();
                }
            }
        });
    }

    private void initKeyboardListener(View view) {
        if (getKeyboardVisibilityListener() != null) {
            KeyboardHelper.PlaceComponentResult(view, getKeyboardVisibilityListener());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewBinding invoke = getBindingInflater().invoke(layoutInflater);
        this._binding = invoke;
        if (invoke != null) {
            return invoke.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        if (getLayout() != 0) {
            return inflateView(layoutInflater, viewGroup);
        }
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public Function1<LayoutInflater, ViewBinding> getBindingInflater() {
        return new Function1() { // from class: id.dana.base.BaseBottomSheetDialogFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BaseBottomSheetDialogFragment.lambda$getBindingInflater$0((LayoutInflater) obj);
            }
        };
    }

    public ViewBinding getViewBinding() {
        return this._binding;
    }

    public void setViewBinding(ViewBinding viewBinding) {
        this._binding = viewBinding;
    }

    @Deprecated
    private View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(getLayout(), viewGroup, false);
        bind(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        init();
    }

    public void init() {
        if (getDialog() != null) {
            getDialog().setOnShowListener(new DialogInterface.OnShowListener() { // from class: id.dana.base.BaseBottomSheetDialogFragment$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    BaseBottomSheetDialogFragment.this.m428lambda$init$1$iddanabaseBaseBottomSheetDialogFragment(dialogInterface);
                }
            });
            getDialog().setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: id.dana.base.BaseBottomSheetDialogFragment$$ExternalSyntheticLambda3
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    BaseBottomSheetDialogFragment.this.m429lambda$init$2$iddanabaseBaseBottomSheetDialogFragment(dialogInterface);
                }
            });
        }
    }

    /* renamed from: lambda$init$1$id-dana-base-BaseBottomSheetDialogFragment */
    public /* synthetic */ void m428lambda$init$1$iddanabaseBaseBottomSheetDialogFragment(DialogInterface dialogInterface) {
        onShow();
    }

    /* renamed from: lambda$init$2$id-dana-base-BaseBottomSheetDialogFragment */
    public /* synthetic */ void m429lambda$init$2$iddanabaseBaseBottomSheetDialogFragment(DialogInterface dialogInterface) {
        onDismiss();
    }

    public void onShow() {
        setBottomSheet();
    }

    public void onDismiss() {
        this.bottomSheetBehavior = null;
    }

    private void setBottomSheet() {
        if (getPlaceComponentResult() != null) {
            View placeComponentResult = getPlaceComponentResult();
            this.bottomSheet = placeComponentResult;
            this.bottomSheetBehavior = BottomSheetBehavior.from(placeComponentResult);
        }
    }

    public void initTransparentDialogDim(Dialog dialog) {
        Window window = dialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = getDimAmount();
            attributes.flags |= 2;
            window.setAttributes(attributes);
        }
    }

    public void initMatchParentDialog(Dialog dialog) {
        if (dialog != null && isFullDialogHeightRequired()) {
            dialog.findViewById(R.id.design_bottom_sheet).getLayoutParams().height = getScreenHeight(dialog);
        }
        configPeekHeight();
    }

    protected boolean isFullDialogHeightRequired() {
        return getResizeHeight() == 0;
    }

    public int getScreenHeight(Dialog dialog) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (dialog.getWindow() != null) {
            dialog.getWindow().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels - ImageResize.PlaceComponentResult((Activity) requireActivity(), getResizeHeight());
    }

    private void configPeekHeight() {
        final View getAuthRequestContext = getGetAuthRequestContext();
        if (getAuthRequestContext != null) {
            getAuthRequestContext.post(new Runnable() { // from class: id.dana.base.BaseBottomSheetDialogFragment$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    BaseBottomSheetDialogFragment.this.m427xd95cae7e(getAuthRequestContext);
                }
            });
        }
    }

    /* renamed from: lambda$configPeekHeight$3$id-dana-base-BaseBottomSheetDialogFragment */
    public /* synthetic */ void m427xd95cae7e(View view) {
        BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) ((CoordinatorLayout.LayoutParams) ((View) view.getParent()).getLayoutParams()).lookAheadTest;
        Display defaultDisplay = requireActivity().getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setPeekHeight(point.y);
        }
    }

    public String getShownErrorMessage() {
        try {
            TextView textView = (TextView) getGetAuthRequestContext().findViewWithTag(getResources().getString(R.string.error_message_tag));
            if (textView.getVisibility() == 0) {
                return textView.getText().toString();
            }
        } catch (Exception unused) {
        }
        return "";
    }
}
