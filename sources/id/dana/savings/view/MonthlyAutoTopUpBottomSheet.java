package id.dana.savings.view;

import android.media.AudioTrack;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.RadioButton;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.gridlayout.widget.GridLayout;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
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

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\u0007¢\u0006\u0004\b\u001d\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\nR\u0012\u0010\u0014\u001a\u00020\u0011X\u0086\"¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0012\u0010\u001c\u001a\u00020\u0005X\u0086\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/savings/view/MonthlyAutoTopUpBottomSheet;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "", "getDimAmount", "()F", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "Landroid/os/Bundle;", "p0", "onCreate", "(Landroid/os/Bundle;)V", "onShow", "onStart", "Lid/dana/savings/view/MonthlyAutoTopUpBottomSheet$MonthlyAutoTopUpListener;", "scheduleImpl", "Lid/dana/savings/view/MonthlyAutoTopUpBottomSheet$MonthlyAutoTopUpListener;", "BuiltInFictitiousFunctionClassFactory", "", "Landroid/widget/RadioButton;", "getErrorConfigVersion", "[Landroid/widget/RadioButton;", "KClassImpl$Data$declaredNonStaticMembers$2", "lookAheadTest", "I", "getAuthRequestContext", "<init>", "Companion", "MonthlyAutoTopUpListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MonthlyAutoTopUpBottomSheet extends BaseBottomSheetDialogFragment {
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public RadioButton[] KClassImpl$Data$declaredNonStaticMembers$2 = new RadioButton[32];

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    int getAuthRequestContext;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public MonthlyAutoTopUpListener BuiltInFictitiousFunctionClassFactory;
    public static final byte[] $$d = {44, 104, -53, -66, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$e = 228;
    public static final byte[] moveToNextValue = {82, -89, -124, -60, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int NetworkUserEntityData$$ExternalSyntheticLambda0 = 247;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/savings/view/MonthlyAutoTopUpBottomSheet$MonthlyAutoTopUpListener;", "", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface MonthlyAutoTopUpListener {
        void KClassImpl$Data$declaredNonStaticMembers$2(int p0);
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

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r7, byte r8, int r9, java.lang.Object[] r10) {
        /*
            int r9 = r9 * 4
            int r9 = r9 + 16
            int r7 = 106 - r7
            byte[] r0 = id.dana.savings.view.MonthlyAutoTopUpBottomSheet.moveToNextValue
            int r8 = r8 * 15
            int r8 = r8 + 4
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L18
            r7 = r8
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L30
        L18:
            r3 = 0
        L19:
            byte r4 = (byte) r7
            int r5 = r3 + 1
            r1[r3] = r4
            if (r5 != r9) goto L28
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L28:
            r3 = r0[r8]
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L30:
            int r8 = r8 + 1
            int r9 = -r9
            int r7 = r7 + r9
            int r7 = r7 + 2
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.savings.view.MonthlyAutoTopUpBottomSheet.c(int, byte, int, java.lang.Object[]):void");
    }

    private static void d(int i, int i2, byte b, Object[] objArr) {
        byte[] bArr = $$d;
        int i3 = i2 + 4;
        int i4 = 75 - (b * 2);
        int i5 = (i * 2) + 42;
        byte[] bArr2 = new byte[i5];
        int i6 = -1;
        int i7 = i5 - 1;
        if (bArr == null) {
            i4 = (i7 + i3) - 7;
            i7 = i7;
            i3 = i3;
        }
        while (true) {
            i6++;
            int i8 = i3 + 1;
            bArr2[i6] = (byte) i4;
            if (i6 == i7) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i4 = (i4 + bArr[i8]) - 7;
            i7 = i7;
            i3 = i8;
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final float getDimAmount() {
        return 0.5f;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final int getLayout() {
        return R.layout.view_monthly_auto_topup_container;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle p0) {
        try {
            byte b = (byte) (moveToNextValue[5] - 1);
            byte b2 = moveToNextValue[5];
            Object[] objArr = new Object[1];
            c(b, b2, (byte) (b2 - 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = moveToNextValue[5];
            byte b4 = (byte) (b3 - 1);
            Object[] objArr2 = new Object[1];
            c(b3, b4, b4, objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getTrimmedLength("") + 494, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 4, (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16));
                    byte b5 = (byte) ($$d[35] - 1);
                    byte b6 = $$d[4];
                    Object[] objArr4 = new Object[1];
                    d(b5, b6, (byte) (b6 + 1), objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 34 - ExpandableListView.getPackedPositionChild(0L), (char) TextUtils.getCapsMode("", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {1777562664, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getTrimmedLength("") + 911, (ViewConfiguration.getTouchSlop() >> 8) + 18, (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        GridLayout.LayoutParams layoutParams;
        super.init();
        for (int i = 1; i < 32; i++) {
            this.KClassImpl$Data$declaredNonStaticMembers$2[i] = new RadioButton(getContext());
            ((android.widget.GridLayout) PlaceComponentResult(R.id.res_0x7f0a07a9_sequenceskt___sequenceskt_filternotnull_1)).addView(this.KClassImpl$Data$declaredNonStaticMembers$2[i]);
            RadioButton radioButton = this.KClassImpl$Data$declaredNonStaticMembers$2[i];
            if (radioButton != null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    layoutParams = new GridLayout.LayoutParams(android.widget.GridLayout.spec(Integer.MIN_VALUE, android.widget.GridLayout.FILL, 1.0f), android.widget.GridLayout.spec(Integer.MIN_VALUE, android.widget.GridLayout.FILL, 1.0f));
                } else {
                    layoutParams = new GridLayout.LayoutParams(androidx.gridlayout.widget.GridLayout.spec(Integer.MIN_VALUE, androidx.gridlayout.widget.GridLayout.FILL, 1.0f), androidx.gridlayout.widget.GridLayout.spec(Integer.MIN_VALUE, androidx.gridlayout.widget.GridLayout.FILL, 1.0f));
                }
                int i2 = radioButton.getContext().getResources().getDisplayMetrics().widthPixels;
                layoutParams.setMargins(14, 14, 14, 14);
                layoutParams.height = (i2 / 7) - 42;
                layoutParams.width = 0;
                radioButton.setLayoutParams(layoutParams);
                radioButton.setGravity(17);
                radioButton.setButtonDrawable(17170445);
                radioButton.setBackgroundResource(R.drawable.radio_month_selector);
                radioButton.setText(String.valueOf(i));
                radioButton.setChecked(false);
                if (Build.VERSION.SDK_INT < 23) {
                    radioButton.setTextAppearance(radioButton.getContext(), R.style.f49602132017405);
                } else {
                    radioButton.setTextAppearance(R.style.f49602132017405);
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    radioButton.setTextColor(radioButton.getResources().getColorStateList(R.color.f26942131100428, null));
                } else {
                    radioButton.setTextColor(AppCompatResources.getAuthRequestContext(radioButton.getContext(), R.color.f26942131100428));
                }
            }
        }
        RadioButton radioButton2 = this.KClassImpl$Data$declaredNonStaticMembers$2[this.getAuthRequestContext];
        if (radioButton2 != null) {
            radioButton2.setChecked(true);
        }
        for (final int i3 = 1; i3 < 32; i3++) {
            RadioButton radioButton3 = this.KClassImpl$Data$declaredNonStaticMembers$2[i3];
            if (radioButton3 != null) {
                radioButton3.setOnClickListener(new View.OnClickListener() { // from class: id.dana.savings.view.MonthlyAutoTopUpBottomSheet$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MonthlyAutoTopUpBottomSheet.getAuthRequestContext(MonthlyAutoTopUpBottomSheet.this, i3);
                    }
                });
            }
        }
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) PlaceComponentResult(R.id.c);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.savings.view.MonthlyAutoTopUpBottomSheet$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MonthlyAutoTopUpBottomSheet.getAuthRequestContext(MonthlyAutoTopUpBottomSheet.this);
                }
            });
        }
    }

    public static /* synthetic */ void getAuthRequestContext(MonthlyAutoTopUpBottomSheet monthlyAutoTopUpBottomSheet) {
        Intrinsics.checkNotNullParameter(monthlyAutoTopUpBottomSheet, "");
        MonthlyAutoTopUpListener monthlyAutoTopUpListener = monthlyAutoTopUpBottomSheet.BuiltInFictitiousFunctionClassFactory;
        if (monthlyAutoTopUpListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            monthlyAutoTopUpListener = null;
        }
        monthlyAutoTopUpListener.KClassImpl$Data$declaredNonStaticMembers$2(monthlyAutoTopUpBottomSheet.getAuthRequestContext);
        monthlyAutoTopUpBottomSheet.dismiss();
    }

    public static /* synthetic */ void getAuthRequestContext(MonthlyAutoTopUpBottomSheet monthlyAutoTopUpBottomSheet, int i) {
        RadioButton radioButton;
        Intrinsics.checkNotNullParameter(monthlyAutoTopUpBottomSheet, "");
        monthlyAutoTopUpBottomSheet.getAuthRequestContext = i;
        for (int i2 = 1; i2 < 32; i2++) {
            if (i2 != i && (radioButton = monthlyAutoTopUpBottomSheet.KClassImpl$Data$declaredNonStaticMembers$2[i2]) != null) {
                radioButton.setChecked(false);
            }
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    /* renamed from: getBottomSheet */
    public final /* synthetic */ View getPlaceComponentResult() {
        return (FrameLayout) PlaceComponentResult(R.id.flBottomSheetMonthlyAutoTopUp);
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
