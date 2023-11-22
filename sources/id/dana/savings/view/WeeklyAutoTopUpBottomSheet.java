package id.dana.savings.view;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import id.dana.R;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u0007¢\u0006\u0004\b\u0018\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\nR\u0012\u0010\u0013\u001a\u00020\u0005X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0017\u001a\u00020\u0014X\u0086\"¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/savings/view/WeeklyAutoTopUpBottomSheet;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "", "getDimAmount", "()F", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "Landroid/os/Bundle;", "p0", "onCreate", "(Landroid/os/Bundle;)V", "onShow", "onStart", "NetworkUserEntityData$$ExternalSyntheticLambda0", "I", "getAuthRequestContext", "Lid/dana/savings/view/WeeklyAutoTopUpBottomSheet$WeeklyAutoTopUpListener;", "lookAheadTest", "Lid/dana/savings/view/WeeklyAutoTopUpBottomSheet$WeeklyAutoTopUpListener;", "BuiltInFictitiousFunctionClassFactory", "<init>", "Companion", "WeeklyAutoTopUpListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WeeklyAutoTopUpBottomSheet extends BaseBottomSheetDialogFragment {
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    int getAuthRequestContext = -1;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public WeeklyAutoTopUpListener BuiltInFictitiousFunctionClassFactory;
    public static final byte[] $$d = {77, -56, -115, -110, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$e = 233;
    public static final byte[] moveToNextValue = {86, TarHeader.LF_NORMAL, -68, 79, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int getErrorConfigVersion = 192;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/savings/view/WeeklyAutoTopUpBottomSheet$WeeklyAutoTopUpListener;", "", "", "p0", "", "MyBillsEntityDataFactory", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface WeeklyAutoTopUpListener {
        void MyBillsEntityDataFactory(int p0);
    }

    private View BuiltInFictitiousFunctionClassFactory(int i) {
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

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.savings.view.WeeklyAutoTopUpBottomSheet.moveToNextValue
            int r8 = r8 * 15
            int r8 = 19 - r8
            int r6 = r6 * 4
            int r6 = 16 - r6
            int r7 = 106 - r7
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L35
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            r3 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L35:
            int r6 = -r6
            int r9 = r9 + 1
            int r8 = r8 + r6
            int r6 = r8 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.savings.view.WeeklyAutoTopUpBottomSheet.c(short, short, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(int r7, short r8, short r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 * 2
            int r8 = 75 - r8
            byte[] r0 = id.dana.savings.view.WeeklyAutoTopUpBottomSheet.$$d
            int r9 = r9 * 3
            int r9 = r9 + 4
            int r7 = r7 * 4
            int r7 = r7 + 42
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L32
        L19:
            r3 = 0
        L1a:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r7) goto L29
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L29:
            r3 = r0[r9]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L32:
            int r8 = -r8
            int r9 = r9 + r8
            int r8 = r9 + (-7)
            int r9 = r10 + 1
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.savings.view.WeeklyAutoTopUpBottomSheet.d(int, short, short, java.lang.Object[]):void");
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final float getDimAmount() {
        return 0.5f;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final int getLayout() {
        return R.layout.view_weekly_auto_topup_container;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle p0) {
        try {
            byte b = (byte) (moveToNextValue[5] - 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            c(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (moveToNextValue[5] - 1);
            byte b4 = moveToNextValue[5];
            Object[] objArr2 = new Object[1];
            c(b3, b4, b4, objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 4 - Color.red(0), (char) (ViewConfiguration.getEdgeSlop() >> 16));
                    byte b5 = (byte) ($$d[4] - 1);
                    byte b6 = b5;
                    Object[] objArr4 = new Object[1];
                    d(b5, b6, b6, objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (Process.myTid() >> 22), (-16777181) - Color.rgb(0, 0, 0), (char) ((-1) - MotionEvent.axisFromString("")))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-1353787766, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Gravity.getAbsoluteGravity(0, 0), TextUtils.getOffsetAfter("", 0) + 18, (char) Color.alpha(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void init() {
        super.init();
        switch (this.getAuthRequestContext) {
            case 1:
                ((RadioButton) BuiltInFictitiousFunctionClassFactory(R.id.rbSunday)).setChecked(true);
                break;
            case 2:
                ((RadioButton) BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a101f_kpackageimpl_getlocalproperty_1_1_1)).setChecked(true);
                break;
            case 3:
                ((RadioButton) BuiltInFictitiousFunctionClassFactory(R.id.getInvestmentPresenter)).setChecked(true);
                break;
            case 4:
                ((RadioButton) BuiltInFictitiousFunctionClassFactory(R.id.rbWednesday)).setChecked(true);
                break;
            case 5:
                ((RadioButton) BuiltInFictitiousFunctionClassFactory(R.id.emptyMapField)).setChecked(true);
                break;
            case 6:
                ((RadioButton) BuiltInFictitiousFunctionClassFactory(R.id.KybTieringDetailItemView)).setChecked(true);
                break;
            case 7:
                ((RadioButton) BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a1022_credentialmanager_clearcredentialstate_2_callback_1)).setChecked(true);
                break;
        }
        RadioGroup radioGroup = (RadioGroup) BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a1070_descriptorvisibilities_3);
        if (radioGroup != null) {
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: id.dana.savings.view.WeeklyAutoTopUpBottomSheet$$ExternalSyntheticLambda0
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup2, int i) {
                    WeeklyAutoTopUpBottomSheet.PlaceComponentResult(WeeklyAutoTopUpBottomSheet.this, i);
                }
            });
        }
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) BuiltInFictitiousFunctionClassFactory(R.id.c);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.savings.view.WeeklyAutoTopUpBottomSheet$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WeeklyAutoTopUpBottomSheet.KClassImpl$Data$declaredNonStaticMembers$2(WeeklyAutoTopUpBottomSheet.this);
                }
            });
        }
    }

    public static /* synthetic */ void PlaceComponentResult(WeeklyAutoTopUpBottomSheet weeklyAutoTopUpBottomSheet, int i) {
        Intrinsics.checkNotNullParameter(weeklyAutoTopUpBottomSheet, "");
        switch (i) {
            case R.id.KybTieringDetailItemView /* 2131365917 */:
                weeklyAutoTopUpBottomSheet.getAuthRequestContext = 6;
                return;
            case R.id.WrappedDrawableState_res_0x7f0a101e /* 2131365918 */:
            case R.id.useDaemonThreadFactory_res_0x7f0a1020 /* 2131365920 */:
            case R.id.encodingStream_res_0x7f0a1021 /* 2131365921 */:
            default:
                return;
            case R.id.f4086res_0x7f0a101f_kpackageimpl_getlocalproperty_1_1_1 /* 2131365919 */:
                weeklyAutoTopUpBottomSheet.getAuthRequestContext = 2;
                return;
            case R.id.f4087xa050c54 /* 2131365922 */:
                weeklyAutoTopUpBottomSheet.getAuthRequestContext = 7;
                return;
            case R.id.f4088rbSunday /* 2131365923 */:
                weeklyAutoTopUpBottomSheet.getAuthRequestContext = 1;
                return;
            case R.id.emptyMapField /* 2131365924 */:
                weeklyAutoTopUpBottomSheet.getAuthRequestContext = 5;
                return;
            case R.id.getInvestmentPresenter /* 2131365925 */:
                weeklyAutoTopUpBottomSheet.getAuthRequestContext = 3;
                return;
            case R.id.f4089rbWednesday /* 2131365926 */:
                weeklyAutoTopUpBottomSheet.getAuthRequestContext = 4;
                return;
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(WeeklyAutoTopUpBottomSheet weeklyAutoTopUpBottomSheet) {
        Intrinsics.checkNotNullParameter(weeklyAutoTopUpBottomSheet, "");
        WeeklyAutoTopUpListener weeklyAutoTopUpListener = weeklyAutoTopUpBottomSheet.BuiltInFictitiousFunctionClassFactory;
        if (weeklyAutoTopUpListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            weeklyAutoTopUpListener = null;
        }
        weeklyAutoTopUpListener.MyBillsEntityDataFactory(weeklyAutoTopUpBottomSheet.getAuthRequestContext);
        weeklyAutoTopUpBottomSheet.dismiss();
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    /* renamed from: getBottomSheet */
    public final /* synthetic */ View getPlaceComponentResult() {
        return (FrameLayout) BuiltInFictitiousFunctionClassFactory(R.id.flBottomSheetWeeklyAutoTopUp);
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
