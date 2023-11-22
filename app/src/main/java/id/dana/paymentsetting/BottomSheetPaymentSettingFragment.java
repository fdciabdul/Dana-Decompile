package id.dana.paymentsetting;

import android.app.Dialog;
import android.content.Context;
import android.media.AudioTrack;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.tabs.TabLayout;
import com.google.common.base.Ascii;
import com.iap.ac.android.common.container.provider.ui.ContainerUIProvider;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.di.ComponentHolder;
import id.dana.di.component.ApplicationComponent;
import id.dana.extension.view.ViewPagerExtKt;
import id.dana.extension.view.ViewPagerExtKt$attachViewPager$1;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.paymentsetting.BottomSheetPaymentSettingFragment;
import id.dana.paymentsetting.adapter.PaymentSettingOnboardingAdapter;
import id.dana.paymentsetting.di.DaggerPaymentSettingComponent;
import id.dana.paymentsetting.di.PaymentSettingAnalyticModule;
import id.dana.paymentsetting.tracker.PaymentSettingAnalyticalTracker;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u001d\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\nJ!\u0010\u0014\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u0016X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0012\u0010\u001b\u001a\u00020\u001aX\u0087\"¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c"}, d2 = {"Lid/dana/paymentsetting/BottomSheetPaymentSettingFragment;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "", "getDimAmount", "()F", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "Landroid/os/Bundle;", "p0", "onCreate", "(Landroid/os/Bundle;)V", "onShow", "onStart", "Landroidx/fragment/app/FragmentManager;", "", "p1", ContainerUIProvider.KEY_SHOW, "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V", "Lid/dana/paymentsetting/BottomSheetPaymentSettingFragment$BottomSheetListener;", "moveToNextValue", "Lid/dana/paymentsetting/BottomSheetPaymentSettingFragment$BottomSheetListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/paymentsetting/tracker/PaymentSettingAnalyticalTracker;", "paymentSettingMixpanelTracker", "Lid/dana/paymentsetting/tracker/PaymentSettingAnalyticalTracker;", "<init>", "BottomSheetListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BottomSheetPaymentSettingFragment extends BaseBottomSheetDialogFragment {
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public BottomSheetListener KClassImpl$Data$declaredNonStaticMembers$2;
    @Inject
    public PaymentSettingAnalyticalTracker paymentSettingMixpanelTracker;
    public static final byte[] $$d = {TarHeader.LF_FIFO, -88, 36, -123, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$e = 72;
    public static final byte[] scheduleImpl = {65, TarHeader.LF_CHR, -100, -34, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int getErrorConfigVersion = 111;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/paymentsetting/BottomSheetPaymentSettingFragment$BottomSheetListener;", "", "", "getAuthRequestContext", "()V", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface BottomSheetListener {
        void BuiltInFictitiousFunctionClassFactory();

        void PlaceComponentResult();

        void getAuthRequestContext();
    }

    private View PlaceComponentResult(int i) {
        View findViewById;
        Map<Integer, View> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 + 4
            int r7 = r7 * 3
            int r7 = 16 - r7
            int r8 = r8 + 105
            byte[] r0 = id.dana.paymentsetting.BottomSheetPaymentSettingFragment.scheduleImpl
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L36
        L19:
            r3 = 0
        L1a:
            int r6 = r6 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            r4 = r0[r6]
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
        L36:
            int r6 = -r6
            int r9 = r9 + r6
            int r6 = r9 + 2
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.paymentsetting.BottomSheetPaymentSettingFragment.c(int, byte, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(byte r7, byte r8, short r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 * 3
            int r8 = 75 - r8
            byte[] r0 = id.dana.paymentsetting.BottomSheetPaymentSettingFragment.$$d
            int r7 = r7 * 4
            int r7 = 4 - r7
            int r9 = r9 * 4
            int r9 = 42 - r9
            byte[] r1 = new byte[r9]
            int r9 = r9 + (-1)
            r2 = 0
            if (r0 != 0) goto L1c
            r8 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L37
        L1c:
            r3 = 0
        L1d:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r9) goto L2c
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2c:
            r3 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r5
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L37:
            int r7 = r7 + r9
            int r7 = r7 + (-7)
            int r8 = r8 + 1
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.paymentsetting.BottomSheetPaymentSettingFragment.d(byte, byte, short, java.lang.Object[]):void");
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final float getDimAmount() {
        return 0.5f;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final int getLayout() {
        return R.layout.fragment_bottom_sheet_payment_setting;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void init() {
        super.init();
        DaggerPaymentSettingComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerPaymentSettingComponent.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(ComponentHolder.getAuthRequestContext());
        if (BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory == null) {
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = new PaymentSettingAnalyticModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, ApplicationComponent.class);
        new DaggerPaymentSettingComponent.PaymentSettingComponentImpl(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, (byte) 0).KClassImpl$Data$declaredNonStaticMembers$2(this);
        ViewPager2 viewPager2 = (ViewPager2) PlaceComponentResult(R.id.getLeaderboards);
        if (viewPager2 != null) {
            Context context = viewPager2.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            viewPager2.setAdapter(new PaymentSettingOnboardingAdapter(context, new BottomSheetPaymentSettingFragment$setupViewPager$1$1(viewPager2)));
        }
        TabLayout tabLayout = (TabLayout) PlaceComponentResult(R.id.tl_indicator);
        if (tabLayout != null) {
            ViewPager2 viewPager22 = (ViewPager2) PlaceComponentResult(R.id.getLeaderboards);
            Intrinsics.checkNotNullExpressionValue(viewPager22, "");
            ViewPagerExtKt.getAuthRequestContext(tabLayout, viewPager22, ViewPagerExtKt$attachViewPager$1.INSTANCE);
            Unit unit = Unit.INSTANCE;
        }
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) PlaceComponentResult(R.id.btn_use_security);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.paymentsetting.BottomSheetPaymentSettingFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BottomSheetPaymentSettingFragment.BuiltInFictitiousFunctionClassFactory(BottomSheetPaymentSettingFragment.this);
                }
            });
        }
        Button button = (Button) PlaceComponentResult(R.id.btn_ask_pin);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: id.dana.paymentsetting.BottomSheetPaymentSettingFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BottomSheetPaymentSettingFragment.PlaceComponentResult(BottomSheetPaymentSettingFragment.this);
                }
            });
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle p0) {
        try {
            Object[] objArr = new Object[1];
            c((byte) (getErrorConfigVersion & 30), (byte) (scheduleImpl[5] - 1), scheduleImpl[5], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b = (byte) (-scheduleImpl[5]);
            byte b2 = (byte) (b + 1);
            Object[] objArr2 = new Object[1];
            c(b, b2, b2, objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(493 - TextUtils.indexOf((CharSequence) "", '0'), TextUtils.getOffsetAfter("", 0) + 4, (char) View.MeasureSpec.makeMeasureSpec(0, 0));
                    byte b3 = (byte) ($$d[35] - 1);
                    byte b4 = b3;
                    Object[] objArr4 = new Object[1];
                    d(b3, b4, b4, objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), 35 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (char) View.MeasureSpec.getSize(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-1821193003, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.resolveSizeAndState(0, 0, 0), View.combineMeasuredStates(0, 0) + 18, (char) TextUtils.getOffsetAfter("", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                setStyle(0, R.style.f50122132017477);
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

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        initMatchParentDialog(getDialog());
        initTransparentDialogDim(getDialog());
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void onShow() {
        super.onShow();
        initBottomSheet(getScreenHeight(getDialog()), 3);
        Dialog dialog = getDialog();
        if (dialog == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        }
        final BottomSheetBehavior<FrameLayout> behavior = ((BottomSheetDialog) dialog).getBehavior();
        Intrinsics.checkNotNullExpressionValue(behavior, "");
        behavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: id.dana.paymentsetting.BottomSheetPaymentSettingFragment$setupBottomSheet$1
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public final void onSlide(View p0, float p1) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public final void onStateChanged(View p0, int p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p1 == 1) {
                    behavior.setState(3);
                } else if (p1 == 5) {
                    BottomSheetPaymentSettingFragment.BottomSheetListener bottomSheetListener = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (bottomSheetListener != null) {
                        bottomSheetListener.getAuthRequestContext();
                    }
                    this.dismissAllowingStateLoss();
                }
            }
        });
        behavior.setDraggable(false);
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void show(FragmentManager p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        FragmentTransaction beginTransaction = p0.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "");
        beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2(0, this, p1, 1);
        beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(BottomSheetPaymentSettingFragment bottomSheetPaymentSettingFragment) {
        Intrinsics.checkNotNullParameter(bottomSheetPaymentSettingFragment, "");
        PaymentSettingAnalyticalTracker paymentSettingAnalyticalTracker = bottomSheetPaymentSettingFragment.paymentSettingMixpanelTracker;
        if (paymentSettingAnalyticalTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            paymentSettingAnalyticalTracker = null;
        }
        paymentSettingAnalyticalTracker.KClassImpl$Data$declaredNonStaticMembers$2(true);
        BottomSheetListener bottomSheetListener = bottomSheetPaymentSettingFragment.KClassImpl$Data$declaredNonStaticMembers$2;
        if (bottomSheetListener != null) {
            bottomSheetListener.BuiltInFictitiousFunctionClassFactory();
        }
    }

    public static /* synthetic */ void PlaceComponentResult(BottomSheetPaymentSettingFragment bottomSheetPaymentSettingFragment) {
        Intrinsics.checkNotNullParameter(bottomSheetPaymentSettingFragment, "");
        PaymentSettingAnalyticalTracker paymentSettingAnalyticalTracker = bottomSheetPaymentSettingFragment.paymentSettingMixpanelTracker;
        if (paymentSettingAnalyticalTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            paymentSettingAnalyticalTracker = null;
        }
        paymentSettingAnalyticalTracker.KClassImpl$Data$declaredNonStaticMembers$2(false);
        BottomSheetListener bottomSheetListener = bottomSheetPaymentSettingFragment.KClassImpl$Data$declaredNonStaticMembers$2;
        if (bottomSheetListener != null) {
            bottomSheetListener.PlaceComponentResult();
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    /* renamed from: getBottomSheet */
    public final /* synthetic */ View getPlaceComponentResult() {
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) PlaceComponentResult(R.id.cl_payment_setting_bottom_sheet_coordinator);
        return coordinatorLayout != null ? (FrameLayout) coordinatorLayout.findViewById(R.id.fl_container) : null;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
