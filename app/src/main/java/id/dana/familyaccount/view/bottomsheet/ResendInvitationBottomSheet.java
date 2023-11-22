package id.dana.familyaccount.view.bottomsheet;

import android.app.Dialog;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment;
import id.dana.databinding.ViewResendBottomSheetBinding;
import id.dana.familyaccount.contract.FamilyDashboardContract;
import id.dana.familyaccount.model.FamilyMemberInfoModel;
import id.dana.familyaccount.model.MemberInfoModel;
import id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0014\u0010\u000eJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0013\u0010\u000e"}, d2 = {"Lid/dana/familyaccount/view/bottomsheet/ResendInvitationBottomSheet;", "Lid/dana/core/ui/BaseViewBindingBottomSheetDialogFragment;", "Lid/dana/databinding/ViewResendBottomSheetBinding;", "", "BuiltInFictitiousFunctionClassFactory", "()F", "Lid/dana/familyaccount/model/FamilyMemberInfoModel;", "moveToNextValue", "()Lid/dana/familyaccount/model/FamilyMemberInfoModel;", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/view/View;", "", "getAuthRequestContext", "()V", "Landroid/os/Bundle;", "p0", "onCreate", "(Landroid/os/Bundle;)V", "MyBillsEntityDataFactory", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ResendInvitationBottomSheet extends BaseViewBindingBottomSheetDialogFragment<ViewResendBottomSheetBinding> {
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();
    public static final byte[] $$a = {111, -54, 77, -36, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 194;
    public static final byte[] PlaceComponentResult = {TarHeader.LF_CHR, -70, 75, 72, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int MyBillsEntityDataFactory = 206;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 15
            int r7 = r7 + 4
            int r8 = r8 + 105
            int r6 = r6 * 4
            int r6 = r6 + 16
            byte[] r0 = id.dana.familyaccount.view.bottomsheet.ResendInvitationBottomSheet.PlaceComponentResult
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r8
            r4 = 0
            r8 = r7
            goto L2c
        L17:
            r3 = 0
            r5 = r8
            r8 = r7
            r7 = r5
        L1b:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            r3 = r0[r8]
        L2c:
            int r3 = -r3
            int r7 = r7 + r3
            int r8 = r8 + 1
            int r7 = r7 + 2
            r3 = r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.view.bottomsheet.ResendInvitationBottomSheet.a(byte, int, short, java.lang.Object[]):void");
    }

    private static void b(int i, byte b, short s, Object[] objArr) {
        int i2 = 42 - (i * 2);
        int i3 = (b * 2) + 75;
        byte[] bArr = $$a;
        int i4 = s + 4;
        byte[] bArr2 = new byte[i2];
        int i5 = -1;
        int i6 = i2 - 1;
        if (bArr == null) {
            i3 = (i4 + (-i3)) - 7;
            i4 = i4;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = -1;
        }
        while (true) {
            int i7 = i5 + 1;
            bArr2[i7] = (byte) i3;
            int i8 = i4 + 1;
            if (i7 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i3 = (i3 + (-bArr[i8])) - 7;
            i4 = i8;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = i7;
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final float BuiltInFictitiousFunctionClassFactory() {
        return 0.5f;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void PlaceComponentResult() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final /* synthetic */ ViewResendBottomSheetBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        ViewResendBottomSheetBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewResendBottomSheetBinding.KClassImpl$Data$declaredNonStaticMembers$2(layoutInflater, viewGroup);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void getAuthRequestContext() {
        MemberInfoModel memberInfoModel;
        MemberInfoModel memberInfoModel2;
        super.getAuthRequestContext();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(true);
        }
        setCancelable(true);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(R.string.family_account_text_desc_resend);
        Intrinsics.checkNotNullExpressionValue(string, "");
        Object[] objArr = new Object[1];
        FamilyMemberInfoModel moveToNextValue = moveToNextValue();
        String str = null;
        objArr[0] = (moveToNextValue == null || (memberInfoModel2 = moveToNextValue.getAuthRequestContext) == null) ? null : memberInfoModel2.PlaceComponentResult;
        String format = String.format(string, Arrays.copyOf(objArr, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String string2 = getString(R.string.family_account_text_dynamic_name_member);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        Object[] objArr2 = new Object[1];
        FamilyMemberInfoModel moveToNextValue2 = moveToNextValue();
        if (moveToNextValue2 != null && (memberInfoModel = moveToNextValue2.getAuthRequestContext) != null) {
            str = memberInfoModel.PlaceComponentResult;
        }
        objArr2[0] = str;
        String format2 = String.format(string2, Arrays.copyOf(objArr2, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "");
        String str2 = format;
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str2, format2, 0, false, 6, (Object) null);
        int length = format2.length();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
        spannableStringBuilder.setSpan(new StyleSpan(1), indexOf$default, length + indexOf$default, 33);
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            ((ViewResendBottomSheetBinding) vb).lookAheadTest.setText(spannableStringBuilder);
            VB vb2 = this.MyBillsEntityDataFactory;
            if (vb2 != 0) {
                ((ViewResendBottomSheetBinding) vb2).PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.bottomsheet.ResendInvitationBottomSheet$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ResendInvitationBottomSheet.BuiltInFictitiousFunctionClassFactory(ResendInvitationBottomSheet.this);
                    }
                });
                VB vb3 = this.MyBillsEntityDataFactory;
                if (vb3 != 0) {
                    ((ViewResendBottomSheetBinding) vb3).getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.bottomsheet.ResendInvitationBottomSheet$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ResendInvitationBottomSheet.MyBillsEntityDataFactory(ResendInvitationBottomSheet.this);
                        }
                    });
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
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
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getSize(0) + 494, TextUtils.getOffsetBefore("", 0) + 4, (char) View.combineMeasuredStates(0, 0));
                    byte b5 = (byte) ($$a[4] - 1);
                    Object[] objArr4 = new Object[1];
                    b(b5, b5, $$a[35], objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + PDF417Common.NUMBER_OF_CODEWORDS, 'S' - AndroidCharacter.getMirror('0'), (char) KeyEvent.getDeadChar(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-315474159, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ViewConfiguration.getScrollBarSize() >> 8), 18 - (ViewConfiguration.getScrollBarSize() >> 8), (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void MyBillsEntityDataFactory() {
        super.MyBillsEntityDataFactory();
        Dialog dialog = getDialog();
        if (dialog != null) {
            a_(PlaceComponentResult(dialog));
        }
        BottomSheetBehavior<View> o_ = o_();
        if (o_ != null) {
            o_.setHideable(true);
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(ResendInvitationBottomSheet resendInvitationBottomSheet) {
        Intrinsics.checkNotNullParameter(resendInvitationBottomSheet, "");
        FragmentActivity activity = resendInvitationBottomSheet.getActivity();
        OrganizerDashboardActivity organizerDashboardActivity = activity instanceof OrganizerDashboardActivity ? (OrganizerDashboardActivity) activity : null;
        if (organizerDashboardActivity != null) {
            organizerDashboardActivity.showResendConfirmationDialog();
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(ResendInvitationBottomSheet resendInvitationBottomSheet) {
        FamilyDashboardContract.Presenter familyDashboardPresenter;
        MemberInfoModel memberInfoModel;
        String str;
        String str2 = "";
        Intrinsics.checkNotNullParameter(resendInvitationBottomSheet, "");
        FragmentActivity activity = resendInvitationBottomSheet.getActivity();
        OrganizerDashboardActivity organizerDashboardActivity = activity instanceof OrganizerDashboardActivity ? (OrganizerDashboardActivity) activity : null;
        if (organizerDashboardActivity == null || (familyDashboardPresenter = organizerDashboardActivity.getFamilyDashboardPresenter()) == null) {
            return;
        }
        FragmentActivity activity2 = resendInvitationBottomSheet.getActivity();
        OrganizerDashboardActivity organizerDashboardActivity2 = activity2 instanceof OrganizerDashboardActivity ? (OrganizerDashboardActivity) activity2 : null;
        FamilyMemberInfoModel familyMemberInfoModelSelected = organizerDashboardActivity2 != null ? organizerDashboardActivity2.getFamilyMemberInfoModelSelected() : null;
        if (familyMemberInfoModelSelected != null && (memberInfoModel = familyMemberInfoModelSelected.getAuthRequestContext) != null && (str = memberInfoModel.getErrorConfigVersion) != null) {
            str2 = str;
        }
        familyDashboardPresenter.getAuthRequestContext(str2);
    }

    private final FamilyMemberInfoModel moveToNextValue() {
        FragmentActivity activity = getActivity();
        OrganizerDashboardActivity organizerDashboardActivity = activity instanceof OrganizerDashboardActivity ? (OrganizerDashboardActivity) activity : null;
        if (organizerDashboardActivity != null) {
            return organizerDashboardActivity.getFamilyMemberInfoModelSelected();
        }
        return null;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final View KClassImpl$Data$declaredNonStaticMembers$2() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            FrameLayout frameLayout = ((ViewResendBottomSheetBinding) vb).BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "");
            return frameLayout;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
