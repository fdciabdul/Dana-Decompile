package id.dana.social.view.fragment;

import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.common.base.Ascii;
import id.dana.R;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.social.view.fragment.ContactPermissionBottomSheetDialogFragment;
import id.dana.social.view.fragment.ContactPermissionBottomSheetDialogFragment$bottomSheetCallback$2;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0019\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\nR\u0013\u0010\u0014\u001a\u00020\u0011X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u0015X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/social/view/fragment/ContactPermissionBottomSheetDialogFragment;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "", "getDimAmount", "()F", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "Landroid/os/Bundle;", "p0", "onCreate", "(Landroid/os/Bundle;)V", "onShow", "onStart", "Lid/dana/social/view/fragment/ContactPermissionBottomSheetDialogFragment$bottomSheetCallback$2$1;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lkotlin/Lazy;", "getAuthRequestContext", "Lid/dana/social/view/fragment/ContactPermissionBottomSheetDialogFragment$BottomSheetListener;", "moveToNextValue", "Lid/dana/social/view/fragment/ContactPermissionBottomSheetDialogFragment$BottomSheetListener;", "MyBillsEntityDataFactory", "<init>", "BottomSheetListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ContactPermissionBottomSheetDialogFragment extends BaseBottomSheetDialogFragment {
    public static final byte[] $$d = {56, -119, 46, TarHeader.LF_CONTIG, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$e = 249;
    public static final byte[] getErrorConfigVersion = {Ascii.DC4, -68, -64, 70, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int scheduleImpl = 33;
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext = LazyKt.lazy(new Function0<ContactPermissionBottomSheetDialogFragment$bottomSheetCallback$2.AnonymousClass1>() { // from class: id.dana.social.view.fragment.ContactPermissionBottomSheetDialogFragment$bottomSheetCallback$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.social.view.fragment.ContactPermissionBottomSheetDialogFragment$bottomSheetCallback$2$1] */
        @Override // kotlin.jvm.functions.Function0
        public final AnonymousClass1 invoke() {
            final ContactPermissionBottomSheetDialogFragment contactPermissionBottomSheetDialogFragment = ContactPermissionBottomSheetDialogFragment.this;
            return new BottomSheetBehavior.BottomSheetCallback() { // from class: id.dana.social.view.fragment.ContactPermissionBottomSheetDialogFragment$bottomSheetCallback$2.1
                @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                public final void onSlide(View p0, float p1) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                public final void onStateChanged(View p0, int p1) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    if (5 == p1) {
                        ContactPermissionBottomSheetDialogFragment.BottomSheetListener bottomSheetListener = ContactPermissionBottomSheetDialogFragment.this.MyBillsEntityDataFactory;
                        if (bottomSheetListener != null) {
                            bottomSheetListener.getAuthRequestContext();
                        }
                        ContactPermissionBottomSheetDialogFragment.this.dismissAllowingStateLoss();
                    }
                }
            };
        }
    });

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public BottomSheetListener MyBillsEntityDataFactory;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/view/fragment/ContactPermissionBottomSheetDialogFragment$BottomSheetListener;", "", "", "getAuthRequestContext", "()V", "PlaceComponentResult", "MyBillsEntityDataFactory"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface BottomSheetListener {
        void MyBillsEntityDataFactory();

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

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 3
            int r7 = r7 + 16
            byte[] r0 = id.dana.social.view.fragment.ContactPermissionBottomSheetDialogFragment.getErrorConfigVersion
            int r8 = r8 + 105
            int r6 = r6 * 15
            int r6 = 19 - r6
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L19
            r8 = r7
            r3 = r1
            r4 = 0
            r7 = r6
            r1 = r0
            r0 = r9
            r9 = r8
            goto L37
        L19:
            r3 = 0
            r5 = r8
            r8 = r7
            r7 = r5
        L1d:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r8) goto L2c
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2c:
            r4 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L37:
            int r8 = r8 + r6
            int r6 = r8 + 2
            int r7 = r7 + 1
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.view.fragment.ContactPermissionBottomSheetDialogFragment.c(short, int, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002e -> B:11:0x0039). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(int r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 3
            int r6 = 4 - r6
            byte[] r0 = id.dana.social.view.fragment.ContactPermissionBottomSheetDialogFragment.$$d
            int r8 = r8 * 2
            int r8 = r8 + 75
            int r7 = r7 * 3
            int r7 = 42 - r7
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1c
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r7
            r7 = r6
            goto L39
        L1c:
            r3 = 0
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L21:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L2e
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2e:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L39:
            int r8 = -r8
            int r6 = r6 + r8
            int r6 = r6 + (-7)
            int r7 = r7 + 1
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L21
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.view.fragment.ContactPermissionBottomSheetDialogFragment.d(int, short, byte, java.lang.Object[]):void");
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final float getDimAmount() {
        return 0.5f;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final int getLayout() {
        return R.layout.view_contact_permission_container;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle p0) {
        try {
            byte b = (byte) (getErrorConfigVersion[5] + 1);
            Object[] objArr = new Object[1];
            c(b, b, (byte) (-getErrorConfigVersion[5]), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) (-getErrorConfigVersion[5]);
            byte b3 = (byte) (b2 - 1);
            Object[] objArr2 = new Object[1];
            c(b2, b3, b3, objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionChild(0L) + 495, ExpandableListView.getPackedPositionGroup(0L) + 4, (char) TextUtils.getTrimmedLength(""));
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 930, 35 - View.combineMeasuredStates(0, 0), (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-320327500, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getLongPressTimeout() >> 16) + 911, 17 - Process.getGidForName(""), (char) View.combineMeasuredStates(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
    public final void init() {
        super.init();
        ((Button) PlaceComponentResult(R.id.btn_allow)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.view.fragment.ContactPermissionBottomSheetDialogFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ContactPermissionBottomSheetDialogFragment.MyBillsEntityDataFactory(ContactPermissionBottomSheetDialogFragment.this);
            }
        });
        ((Button) PlaceComponentResult(R.id.btn_later)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.view.fragment.ContactPermissionBottomSheetDialogFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ContactPermissionBottomSheetDialogFragment.getAuthRequestContext(ContactPermissionBottomSheetDialogFragment.this);
            }
        });
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void onShow() {
        super.onShow();
        initBottomSheet(getScreenHeight(getDialog()), 3);
        BottomSheetBehavior<View> bottomSheetBehavior = this.bottomSheetBehavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setBottomSheetCallback((ContactPermissionBottomSheetDialogFragment$bottomSheetCallback$2.AnonymousClass1) this.getAuthRequestContext.getValue());
        }
    }

    public static /* synthetic */ void getAuthRequestContext(ContactPermissionBottomSheetDialogFragment contactPermissionBottomSheetDialogFragment) {
        Intrinsics.checkNotNullParameter(contactPermissionBottomSheetDialogFragment, "");
        contactPermissionBottomSheetDialogFragment.dismiss();
        BottomSheetListener bottomSheetListener = contactPermissionBottomSheetDialogFragment.MyBillsEntityDataFactory;
        if (bottomSheetListener != null) {
            bottomSheetListener.PlaceComponentResult();
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(ContactPermissionBottomSheetDialogFragment contactPermissionBottomSheetDialogFragment) {
        Intrinsics.checkNotNullParameter(contactPermissionBottomSheetDialogFragment, "");
        BottomSheetListener bottomSheetListener = contactPermissionBottomSheetDialogFragment.MyBillsEntityDataFactory;
        if (bottomSheetListener != null) {
            bottomSheetListener.MyBillsEntityDataFactory();
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final /* synthetic */ View getBottomSheet() {
        FrameLayout frameLayout = (FrameLayout) PlaceComponentResult(R.id.phoneNumber);
        Intrinsics.checkNotNullExpressionValue(frameLayout, "");
        return frameLayout;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
