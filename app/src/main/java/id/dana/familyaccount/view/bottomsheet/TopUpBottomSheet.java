package id.dana.familyaccount.view.bottomsheet;

import android.app.Dialog;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment;
import id.dana.core.ui.model.CurrencyAmountModel;
import id.dana.core.ui.richview.CurrencyEditText;
import id.dana.core.ui.richview.NumpadView;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.data.util.NumberUtils;
import id.dana.databinding.BaseFamilyTopupBottomSheetBinding;
import id.dana.domain.expresspurchase.interaction.SaveLastActionToPreference;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.familyaccount.contract.FamilyDashboardContract;
import id.dana.familyaccount.model.TopUpUserConsultModel;
import id.dana.familyaccount.tracker.FamilyAccountAnalyticalTracker;
import id.dana.familyaccount.util.TopUpUserConsultManager;
import id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity;
import id.dana.lib.gcontainer.extension.NumberExtKt;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0018\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\f\u0010\u0005J\u0019\u0010\u000f\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0014\u0010\u0005R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/familyaccount/view/bottomsheet/TopUpBottomSheet;", "Lid/dana/core/ui/BaseViewBindingBottomSheetDialogFragment;", "Lid/dana/databinding/BaseFamilyTopupBottomSheetBinding;", "", SaveLastActionToPreference.DISMISS_EP, "()V", "", "BuiltInFictitiousFunctionClassFactory", "()F", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/view/View;", "getAuthRequestContext", "Landroid/os/Bundle;", "p0", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "MyBillsEntityDataFactory", "Lid/dana/familyaccount/model/TopUpUserConsultModel;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/familyaccount/model/TopUpUserConsultModel;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TopUpBottomSheet extends BaseViewBindingBottomSheetDialogFragment<BaseFamilyTopupBottomSheetBinding> {
    public Map<Integer, View> MyBillsEntityDataFactory = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private TopUpUserConsultModel getAuthRequestContext;
    public static final byte[] $$a = {63, Ascii.SUB, 111, -17, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 8;
    public static final byte[] PlaceComponentResult = {Ascii.US, -80, -88, -103, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 232;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = 106 - r6
            byte[] r0 = id.dana.familyaccount.view.bottomsheet.TopUpBottomSheet.PlaceComponentResult
            int r8 = r8 * 2
            int r8 = 16 - r8
            int r7 = r7 * 15
            int r7 = 19 - r7
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L32
        L19:
            r3 = 0
        L1a:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            r4 = r0[r7]
            int r3 = r3 + 1
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L32:
            int r7 = r7 + 1
            int r6 = r6 + r8
            int r6 = r6 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.view.bottomsheet.TopUpBottomSheet.a(int, byte, byte, java.lang.Object[]):void");
    }

    private static void b(short s, short s2, short s3, Object[] objArr) {
        int i = 75 - (s2 * 3);
        int i2 = s + 4;
        int i3 = (s3 * 2) + 42;
        byte[] bArr = $$a;
        byte[] bArr2 = new byte[i3];
        int i4 = -1;
        int i5 = i3 - 1;
        if (bArr == null) {
            i = (i5 + (-i)) - 7;
            i5 = i5;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = -1;
        }
        while (true) {
            int i6 = i4 + 1;
            bArr2[i6] = (byte) i;
            i2++;
            if (i6 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i7 = i5;
            i = (i + (-bArr[i2])) - 7;
            i5 = i7;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = i6;
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final float BuiltInFictitiousFunctionClassFactory() {
        return 0.5f;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void PlaceComponentResult() {
        this.MyBillsEntityDataFactory.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final /* synthetic */ BaseFamilyTopupBottomSheetBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        BaseFamilyTopupBottomSheetBinding BuiltInFictitiousFunctionClassFactory = BaseFamilyTopupBottomSheetBinding.BuiltInFictitiousFunctionClassFactory(layoutInflater, viewGroup);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void getAuthRequestContext() {
        FamilyAccountAnalyticalTracker familyAccountAnalyticalTracker;
        super.getAuthRequestContext();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(true);
        }
        setCancelable(true);
        String tag = getTag();
        if (tag != null) {
            int hashCode = tag.hashCode();
            if (hashCode != -1767171378) {
                if (hashCode == 923302343 && tag.equals(OrganizerDashboardActivity.FIRST_TIMER_TOPUP)) {
                    VB vb = this.MyBillsEntityDataFactory;
                    if (vb != 0) {
                        ((BaseFamilyTopupBottomSheetBinding) vb).PlaceComponentResult.MyBillsEntityDataFactory.setVisibility(0);
                        VB vb2 = this.MyBillsEntityDataFactory;
                        if (vb2 != 0) {
                            ((BaseFamilyTopupBottomSheetBinding) vb2).getAuthRequestContext.getAuthRequestContext.setVisibility(8);
                        } else {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                }
            } else if (tag.equals(OrganizerDashboardActivity.SHOW_TOPUP)) {
                VB vb3 = this.MyBillsEntityDataFactory;
                if (vb3 != 0) {
                    ((BaseFamilyTopupBottomSheetBinding) vb3).getAuthRequestContext.getAuthRequestContext.setVisibility(0);
                    VB vb4 = this.MyBillsEntityDataFactory;
                    if (vb4 != 0) {
                        ((BaseFamilyTopupBottomSheetBinding) vb4).PlaceComponentResult.MyBillsEntityDataFactory.setVisibility(8);
                        VB vb5 = this.MyBillsEntityDataFactory;
                        if (vb5 != 0) {
                            ((BaseFamilyTopupBottomSheetBinding) vb5).getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.bottomsheet.TopUpBottomSheet$$ExternalSyntheticLambda0
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    TopUpBottomSheet.PlaceComponentResult(TopUpBottomSheet.this);
                                }
                            });
                            this.getAuthRequestContext = TopUpUserConsultManager.BuiltInFictitiousFunctionClassFactory();
                            FragmentActivity activity = getActivity();
                            OrganizerDashboardActivity organizerDashboardActivity = activity instanceof OrganizerDashboardActivity ? (OrganizerDashboardActivity) activity : null;
                            if (organizerDashboardActivity != null && (familyAccountAnalyticalTracker = organizerDashboardActivity.getFamilyAccountAnalyticalTracker()) != null) {
                                familyAccountAnalyticalTracker.MyBillsEntityDataFactory();
                            }
                        } else {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }
        }
        VB vb6 = this.MyBillsEntityDataFactory;
        if (vb6 != 0) {
            ((BaseFamilyTopupBottomSheetBinding) vb6).PlaceComponentResult.PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.bottomsheet.TopUpBottomSheet$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TopUpBottomSheet.KClassImpl$Data$declaredNonStaticMembers$2(TopUpBottomSheet.this);
                }
            });
            VB vb7 = this.MyBillsEntityDataFactory;
            if (vb7 != 0) {
                CurrencyEditText currencyEditText = ((BaseFamilyTopupBottomSheetBinding) vb7).getAuthRequestContext.PlaceComponentResult;
                currencyEditText.setText("Rp0");
                VB vb8 = this.MyBillsEntityDataFactory;
                if (vb8 != 0) {
                    ((BaseFamilyTopupBottomSheetBinding) vb8).getAuthRequestContext.PlaceComponentResult.setOnTouchListener(new View.OnTouchListener() { // from class: id.dana.familyaccount.view.bottomsheet.TopUpBottomSheet$$ExternalSyntheticLambda2
                        @Override // android.view.View.OnTouchListener
                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            boolean authRequestContext;
                            authRequestContext = TopUpBottomSheet.getAuthRequestContext(TopUpBottomSheet.this, motionEvent);
                            return authRequestContext;
                        }
                    });
                    currencyEditText.disableSoftKeyboard();
                    currencyEditText.clearFocus();
                    Intrinsics.checkNotNullExpressionValue(currencyEditText, "");
                    currencyEditText.addTextChangedListener(new TextWatcher() { // from class: id.dana.familyaccount.view.bottomsheet.TopUpBottomSheet$initViews$lambda-7$$inlined$addTextChangedListener$default$1
                        @Override // android.text.TextWatcher
                        public final void afterTextChanged(Editable p0) {
                        }

                        @Override // android.text.TextWatcher
                        public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
                            FragmentActivity activity2 = TopUpBottomSheet.this.getActivity();
                            if (activity2 != null) {
                                VB vb9 = TopUpBottomSheet.this.MyBillsEntityDataFactory;
                                if (vb9 != 0) {
                                    Drawable background = ((BaseFamilyTopupBottomSheetBinding) vb9).getAuthRequestContext.PlaceComponentResult.getBackground();
                                    if (background != null) {
                                        background.setColorFilter(ContextCompat.BuiltInFictitiousFunctionClassFactory(activity2, R.color.getErrorConfigVersion_res_0x7f060305), PorterDuff.Mode.SRC_IN);
                                        return;
                                    }
                                    return;
                                }
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }
                        }

                        @Override // android.text.TextWatcher
                        public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                            String replace$default;
                            replace$default = StringsKt.replace$default(String.valueOf(p0), "Rp", "", false, 4, (Object) null);
                            if (replace$default.length() == 0) {
                                replace$default = "0";
                            }
                            TopUpBottomSheet topUpBottomSheet = TopUpBottomSheet.this;
                            String str = replace$default;
                            StringBuilder sb = new StringBuilder();
                            int length = str.length();
                            for (int i = 0; i < length; i++) {
                                char charAt = str.charAt(i);
                                if (Character.isDigit(charAt)) {
                                    sb.append(charAt);
                                }
                            }
                            String obj = sb.toString();
                            Intrinsics.checkNotNullExpressionValue(obj, "");
                            TopUpBottomSheet.getAuthRequestContext(topUpBottomSheet, obj);
                            TopUpBottomSheet.MyBillsEntityDataFactory(TopUpBottomSheet.this, replace$default);
                        }
                    });
                    VB vb9 = this.MyBillsEntityDataFactory;
                    if (vb9 != 0) {
                        ((BaseFamilyTopupBottomSheetBinding) vb9).getAuthRequestContext.MyBillsEntityDataFactory.setListener(new NumpadView.NumpadClickListener() { // from class: id.dana.familyaccount.view.bottomsheet.TopUpBottomSheet$setupCustomKeyboard$1
                            @Override // id.dana.core.ui.richview.NumpadView.NumpadClickListener
                            public final void MyBillsEntityDataFactory(String p0) {
                                Intrinsics.checkNotNullParameter(p0, "");
                                if (p0.length() == 0) {
                                    VB vb10 = TopUpBottomSheet.this.MyBillsEntityDataFactory;
                                    if (vb10 != 0) {
                                        ((BaseFamilyTopupBottomSheetBinding) vb10).getAuthRequestContext.PlaceComponentResult.setPrefixedAmount(0L);
                                        return;
                                    }
                                    throw new IllegalArgumentException("Required value was null.".toString());
                                }
                                VB vb11 = TopUpBottomSheet.this.MyBillsEntityDataFactory;
                                if (vb11 != 0) {
                                    ((BaseFamilyTopupBottomSheetBinding) vb11).getAuthRequestContext.PlaceComponentResult.setPrefixedAmount(Long.parseLong(p0));
                                    return;
                                }
                                throw new IllegalArgumentException("Required value was null.".toString());
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
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle p0) {
        try {
            byte b = (byte) (PlaceComponentResult[5] + 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (-PlaceComponentResult[5]);
            byte b4 = b3;
            Object[] objArr2 = new Object[1];
            a(b3, b4, (byte) (b4 - 1), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 495, 4 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (KeyEvent.getMaxKeyCode() >> 16));
                    byte b5 = $$a[35];
                    byte b6 = (byte) (b5 + 1);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.getOffsetBefore("", 0) + 35, (char) (TextUtils.lastIndexOf("", '0') + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-1864784891, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + 912, (ViewConfiguration.getKeyRepeatDelay() >> 16) + 18, (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle p0) {
        final Context requireContext = requireContext();
        final int theme = getTheme();
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext, theme) { // from class: id.dana.familyaccount.view.bottomsheet.TopUpBottomSheet$onCreateDialog$dialog$1
            @Override // androidx.view.ComponentDialog, android.app.Dialog
            public final void onBackPressed() {
                cancel();
            }
        };
        Window window = bottomSheetDialog.getWindow();
        if (window != null) {
            window.setSoftInputMode(3);
        }
        return bottomSheetDialog;
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

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public final void dismiss() {
        super.dismiss();
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            ((BaseFamilyTopupBottomSheetBinding) vb).getAuthRequestContext.PlaceComponentResult.setText("Rp0");
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(TopUpBottomSheet topUpBottomSheet) {
        FamilyDashboardContract.Presenter familyDashboardPresenter;
        Intrinsics.checkNotNullParameter(topUpBottomSheet, "");
        topUpBottomSheet.dismiss();
        FragmentActivity activity = topUpBottomSheet.getActivity();
        OrganizerDashboardActivity organizerDashboardActivity = activity instanceof OrganizerDashboardActivity ? (OrganizerDashboardActivity) activity : null;
        if (organizerDashboardActivity == null || (familyDashboardPresenter = organizerDashboardActivity.getFamilyDashboardPresenter()) == null) {
            return;
        }
        familyDashboardPresenter.scheduleImpl();
    }

    public static /* synthetic */ void PlaceComponentResult(TopUpBottomSheet topUpBottomSheet) {
        FamilyDashboardContract.Presenter familyDashboardPresenter;
        Intrinsics.checkNotNullParameter(topUpBottomSheet, "");
        VB vb = topUpBottomSheet.MyBillsEntityDataFactory;
        if (vb != 0) {
            CurrencyAmountModel amountModel = ((BaseFamilyTopupBottomSheetBinding) vb).getAuthRequestContext.PlaceComponentResult.getAmountModel();
            FragmentActivity activity = topUpBottomSheet.getActivity();
            OrganizerDashboardActivity organizerDashboardActivity = activity instanceof OrganizerDashboardActivity ? (OrganizerDashboardActivity) activity : null;
            if (organizerDashboardActivity == null || (familyDashboardPresenter = organizerDashboardActivity.getFamilyDashboardPresenter()) == null) {
                return;
            }
            familyDashboardPresenter.PlaceComponentResult(new MoneyView(amountModel.getAmount(), amountModel.getCurrency(), null, 4, null));
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(TopUpBottomSheet topUpBottomSheet, String str) {
        VB vb = topUpBottomSheet.MyBillsEntityDataFactory;
        if (vb != 0) {
            ((BaseFamilyTopupBottomSheetBinding) vb).getAuthRequestContext.PlaceComponentResult.setCompoundDrawablesWithIntrinsicBounds(0, 0, (!(str.length() > 0) || str.contentEquals("0")) ? 0 : R.drawable.ic_close_filled_grey, 0);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void getAuthRequestContext(TopUpBottomSheet topUpBottomSheet, String str) {
        MoneyViewModel moneyViewModel;
        id.dana.model.CurrencyAmountModel currencyAmountModel;
        String format;
        long safeLong = NumberExtKt.toSafeLong(str, 0L);
        TopUpUserConsultModel topUpUserConsultModel = topUpBottomSheet.getAuthRequestContext;
        if (topUpUserConsultModel == null || (moneyViewModel = topUpUserConsultModel.BuiltInFictitiousFunctionClassFactory) == null) {
            moneyViewModel = new MoneyViewModel(null, null, null, 7, null);
        }
        TopUpUserConsultModel topUpUserConsultModel2 = topUpBottomSheet.getAuthRequestContext;
        if (topUpUserConsultModel2 == null || (currencyAmountModel = topUpUserConsultModel2.PlaceComponentResult) == null) {
            currencyAmountModel = new id.dana.model.CurrencyAmountModel("", "");
        }
        if (Intrinsics.areEqual(String.valueOf(safeLong), "0")) {
            VB vb = topUpBottomSheet.MyBillsEntityDataFactory;
            if (vb != 0) {
                DanaButtonPrimaryView danaButtonPrimaryView = ((BaseFamilyTopupBottomSheetBinding) vb).getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
                danaButtonPrimaryView.setDisabled(topUpBottomSheet.getString(R.string.family_account_text_continue));
                danaButtonPrimaryView.setEnabled(false);
                VB vb2 = topUpBottomSheet.MyBillsEntityDataFactory;
                if (vb2 != 0) {
                    TextView textView = ((BaseFamilyTopupBottomSheetBinding) vb2).getAuthRequestContext.getErrorConfigVersion;
                    Intrinsics.checkNotNullExpressionValue(textView, "");
                    textView.setVisibility(4);
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        String cleanAll = NumberUtils.getCleanAll(moneyViewModel.PlaceComponentResult);
        Long longOrNull = StringsKt.toLongOrNull(cleanAll != null ? cleanAll : "0");
        if (safeLong <= (longOrNull != null ? longOrNull.longValue() : 0L)) {
            if (currencyAmountModel.KClassImpl$Data$declaredNonStaticMembers$2(new id.dana.model.CurrencyAmountModel(String.valueOf(safeLong)))) {
                VB vb3 = topUpBottomSheet.MyBillsEntityDataFactory;
                if (vb3 != 0) {
                    DanaButtonPrimaryView danaButtonPrimaryView2 = ((BaseFamilyTopupBottomSheetBinding) vb3).getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
                    danaButtonPrimaryView2.setDisabled(topUpBottomSheet.getString(R.string.family_account_text_continue));
                    danaButtonPrimaryView2.setEnabled(false);
                    VB vb4 = topUpBottomSheet.MyBillsEntityDataFactory;
                    if (vb4 != 0) {
                        TextView textView2 = ((BaseFamilyTopupBottomSheetBinding) vb4).getAuthRequestContext.getErrorConfigVersion;
                        textView2.setText(topUpBottomSheet.getString(R.string.family_account_text_top_up_not_enough));
                        Intrinsics.checkNotNullExpressionValue(textView2, "");
                        textView2.setVisibility(0);
                        textView2.setContentDescription(topUpBottomSheet.getString(R.string.lbl_error_balance));
                        return;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            VB vb5 = topUpBottomSheet.MyBillsEntityDataFactory;
            if (vb5 != 0) {
                DanaButtonPrimaryView danaButtonPrimaryView3 = ((BaseFamilyTopupBottomSheetBinding) vb5).getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
                danaButtonPrimaryView3.setActiveButton(topUpBottomSheet.getString(R.string.family_account_text_continue), null);
                danaButtonPrimaryView3.setEnabled(true);
                VB vb6 = topUpBottomSheet.MyBillsEntityDataFactory;
                if (vb6 != 0) {
                    TextView textView3 = ((BaseFamilyTopupBottomSheetBinding) vb6).getAuthRequestContext.getErrorConfigVersion;
                    Intrinsics.checkNotNullExpressionValue(textView3, "");
                    textView3.setVisibility(4);
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        VB vb7 = topUpBottomSheet.MyBillsEntityDataFactory;
        if (vb7 != 0) {
            DanaButtonPrimaryView danaButtonPrimaryView4 = ((BaseFamilyTopupBottomSheetBinding) vb7).getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
            danaButtonPrimaryView4.setDisabled(topUpBottomSheet.getString(R.string.family_account_text_continue));
            danaButtonPrimaryView4.setEnabled(false);
            VB vb8 = topUpBottomSheet.MyBillsEntityDataFactory;
            if (vb8 != 0) {
                TextView textView4 = ((BaseFamilyTopupBottomSheetBinding) vb8).getAuthRequestContext.getErrorConfigVersion;
                String string = topUpBottomSheet.getString(R.string.family_account_text_top_up_max_balance);
                Intrinsics.checkNotNullExpressionValue(string, "");
                Object[] objArr = new Object[1];
                StringBuilder sb = new StringBuilder();
                sb.append(moneyViewModel.KClassImpl$Data$declaredNonStaticMembers$2);
                format = NumberFormat.getNumberInstance(LocaleUtil.BuiltInFictitiousFunctionClassFactory()).format(moneyViewModel.MyBillsEntityDataFactory());
                if (format == null) {
                    format = "";
                }
                sb.append(format);
                objArr[0] = sb.toString();
                String format2 = String.format(string, Arrays.copyOf(objArr, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "");
                textView4.setText(format2);
                Intrinsics.checkNotNullExpressionValue(textView4, "");
                textView4.setVisibility(0);
                textView4.setContentDescription(topUpBottomSheet.getString(R.string.lbl_error_limit));
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getAuthRequestContext(TopUpBottomSheet topUpBottomSheet, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(topUpBottomSheet, "");
        Intrinsics.checkNotNullParameter(motionEvent, "");
        VB vb = topUpBottomSheet.MyBillsEntityDataFactory;
        if (vb != 0) {
            if (((BaseFamilyTopupBottomSheetBinding) vb).getAuthRequestContext.PlaceComponentResult.getCompoundDrawables()[2] != null) {
                float rawX = motionEvent.getRawX();
                VB vb2 = topUpBottomSheet.MyBillsEntityDataFactory;
                if (vb2 != 0) {
                    int right = ((BaseFamilyTopupBottomSheetBinding) vb2).getAuthRequestContext.PlaceComponentResult.getRight();
                    if (topUpBottomSheet.MyBillsEntityDataFactory != 0) {
                        if (rawX >= right - ((BaseFamilyTopupBottomSheetBinding) r3).getAuthRequestContext.PlaceComponentResult.getCompoundDrawables()[2].getBounds().width()) {
                            VB vb3 = topUpBottomSheet.MyBillsEntityDataFactory;
                            if (vb3 != 0) {
                                if (((BaseFamilyTopupBottomSheetBinding) vb3).getAuthRequestContext.PlaceComponentResult.getText() != null) {
                                    VB vb4 = topUpBottomSheet.MyBillsEntityDataFactory;
                                    if (vb4 != 0) {
                                        ((BaseFamilyTopupBottomSheetBinding) vb4).getAuthRequestContext.PlaceComponentResult.setText("Rp0");
                                        VB vb5 = topUpBottomSheet.MyBillsEntityDataFactory;
                                        if (vb5 != 0) {
                                            ((BaseFamilyTopupBottomSheetBinding) vb5).getAuthRequestContext.MyBillsEntityDataFactory.clearAmount();
                                            return true;
                                        }
                                        throw new IllegalArgumentException("Required value was null.".toString());
                                    }
                                    throw new IllegalArgumentException("Required value was null.".toString());
                                }
                                return false;
                            }
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        return false;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            return false;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final View KClassImpl$Data$declaredNonStaticMembers$2() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            FrameLayout frameLayout = ((BaseFamilyTopupBottomSheetBinding) vb).BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "");
            return frameLayout;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.MyBillsEntityDataFactory.clear();
    }
}
