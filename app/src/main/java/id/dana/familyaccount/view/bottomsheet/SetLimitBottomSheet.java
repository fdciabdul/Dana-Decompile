package id.dana.familyaccount.view.bottomsheet;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.common.base.Ascii;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment;
import id.dana.core.ui.richview.CurrencyEditText;
import id.dana.core.ui.richview.NumpadView;
import id.dana.databinding.ViewSetMemberLimitSheetBinding;
import id.dana.domain.familyaccount.model.MaxMemberLimitConfig;
import id.dana.familyaccount.view.memberlimit.FamilySetMemberLimitInputAmountView;
import id.dana.familyaccount.view.memberlimit.FamilySetMemberLimitSliderView;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.utils.OSUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u001f\u0010\u000bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0013\u0010\u000bJ\u0017\u0010\u0013\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0013\u0010\u0015R\u0014\u0010\n\u001a\u0004\u0018\u00010\u0016X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\u0017R\u0016\u0010\u0004\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\t0\u001bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e"}, d2 = {"Lid/dana/familyaccount/view/bottomsheet/SetLimitBottomSheet;", "Lid/dana/core/ui/BaseViewBindingBottomSheetDialogFragment;", "Lid/dana/databinding/ViewSetMemberLimitSheetBinding;", "", "BuiltInFictitiousFunctionClassFactory", "()F", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/view/View;", "", "getAuthRequestContext", "()V", "Landroid/os/Bundle;", "p0", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "MyBillsEntityDataFactory", "", "(Z)V", "Lid/dana/domain/familyaccount/model/MaxMemberLimitConfig;", "Lid/dana/domain/familyaccount/model/MaxMemberLimitConfig;", "", "PlaceComponentResult", "J", "Lkotlin/Function1;", "", "initRecordTimeStamp", "Lkotlin/jvm/functions/Function1;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SetLimitBottomSheet extends BaseViewBindingBottomSheetDialogFragment<ViewSetMemberLimitSheetBinding> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public MaxMemberLimitConfig getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public long BuiltInFictitiousFunctionClassFactory;
    public static final byte[] $$a = {63, Ascii.SUB, 111, -17, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 162;
    public static final byte[] NetworkUserEntityData$$ExternalSyntheticLambda1 = {15, -40, -114, -21, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int GetContactSyncConfig = 106;
    public Map<Integer, View> MyBillsEntityDataFactory = new LinkedHashMap();

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public Function1<? super String, Unit> PlaceComponentResult = new Function1<String, Unit>() { // from class: id.dana.familyaccount.view.bottomsheet.SetLimitBottomSheet$onClickMemberLimitSaveChangesListener$1
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics.checkNotNullParameter(str, "");
        }

        @Override // kotlin.jvm.functions.Function1
        public final /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }
    };

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 + 4
            byte[] r0 = id.dana.familyaccount.view.bottomsheet.SetLimitBottomSheet.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r6 = r6 * 3
            int r6 = 16 - r6
            int r8 = r8 + 105
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L18
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L34
        L18:
            r3 = 0
        L19:
            byte r4 = (byte) r8
            int r7 = r7 + 1
            r1[r3] = r4
            if (r3 != r6) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L34:
            int r7 = -r7
            int r9 = r9 + r7
            int r7 = r9 + 2
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.view.bottomsheet.SetLimitBottomSheet.a(int, short, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r7, short r8, byte r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 * 2
            int r8 = r8 + 75
            int r9 = r9 + 4
            byte[] r0 = id.dana.familyaccount.view.bottomsheet.SetLimitBottomSheet.$$a
            int r7 = r7 * 2
            int r7 = 42 - r7
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            goto L35
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
            int r9 = r9 + 1
            r3 = r0[r9]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L35:
            int r7 = -r7
            int r9 = r9 + r7
            int r7 = r9 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r8
            r8 = r7
            r7 = r6
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.view.bottomsheet.SetLimitBottomSheet.b(int, short, byte, java.lang.Object[]):void");
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
    public final /* synthetic */ ViewSetMemberLimitSheetBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        ViewSetMemberLimitSheetBinding PlaceComponentResult = ViewSetMemberLimitSheetBinding.PlaceComponentResult(layoutInflater, viewGroup);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void getAuthRequestContext() {
        super.getAuthRequestContext();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(true);
        }
        setCancelable(true);
        MyBillsEntityDataFactory(false);
        MaxMemberLimitConfig maxMemberLimitConfig = this.getAuthRequestContext;
        if (maxMemberLimitConfig != null) {
            VB vb = this.MyBillsEntityDataFactory;
            if (vb != 0) {
                ((ViewSetMemberLimitSheetBinding) vb).getErrorConfigVersion.setValueTo(Float.parseFloat(maxMemberLimitConfig.getMaxSetMemberLimit()));
                VB vb2 = this.MyBillsEntityDataFactory;
                if (vb2 != 0) {
                    ((ViewSetMemberLimitSheetBinding) vb2).getAuthRequestContext.setMaxAmount(Long.parseLong(maxMemberLimitConfig.getMaxSetMemberLimit()));
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        VB vb3 = this.MyBillsEntityDataFactory;
        if (vb3 != 0) {
            ((ViewSetMemberLimitSheetBinding) vb3).getAuthRequestContext.setListener(new FamilySetMemberLimitInputAmountView.OnAmountChangeListener() { // from class: id.dana.familyaccount.view.bottomsheet.SetLimitBottomSheet$setupViewSheetSetMemberLimitListener$1
                @Override // id.dana.familyaccount.view.memberlimit.FamilySetMemberLimitInputAmountView.OnAmountChangeListener
                public final void PlaceComponentResult(boolean p0) {
                    SetLimitBottomSheet.this.MyBillsEntityDataFactory(p0);
                }

                @Override // id.dana.familyaccount.view.memberlimit.FamilySetMemberLimitInputAmountView.OnAmountChangeListener
                public final void BuiltInFictitiousFunctionClassFactory(long p0) {
                    float f = (float) p0;
                    VB vb4 = SetLimitBottomSheet.this.MyBillsEntityDataFactory;
                    if (vb4 != 0) {
                        float valueTo = ((ViewSetMemberLimitSheetBinding) vb4).getErrorConfigVersion.getValueTo();
                        if (f > valueTo) {
                            VB vb5 = SetLimitBottomSheet.this.MyBillsEntityDataFactory;
                            if (vb5 != 0) {
                                ((ViewSetMemberLimitSheetBinding) vb5).getAuthRequestContext.setEditTextAmount(valueTo);
                                return;
                            }
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        VB vb6 = SetLimitBottomSheet.this.MyBillsEntityDataFactory;
                        if (vb6 != 0) {
                            ((ViewSetMemberLimitSheetBinding) vb6).getErrorConfigVersion.setValue(f);
                            return;
                        }
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            });
            VB vb4 = this.MyBillsEntityDataFactory;
            if (vb4 != 0) {
                ((ViewSetMemberLimitSheetBinding) vb4).getErrorConfigVersion.setListener(new FamilySetMemberLimitSliderView.OnSliderChangeListener() { // from class: id.dana.familyaccount.view.bottomsheet.SetLimitBottomSheet$setupViewSheetSetMemberLimitListener$2
                    @Override // id.dana.familyaccount.view.memberlimit.FamilySetMemberLimitSliderView.OnSliderChangeListener
                    public final void BuiltInFictitiousFunctionClassFactory(long p0) {
                        VB vb5 = SetLimitBottomSheet.this.MyBillsEntityDataFactory;
                        if (vb5 != 0) {
                            ((ViewSetMemberLimitSheetBinding) vb5).getAuthRequestContext.setEditTextAmount(p0);
                            VB vb6 = SetLimitBottomSheet.this.MyBillsEntityDataFactory;
                            if (vb6 != 0) {
                                ((ViewSetMemberLimitSheetBinding) vb6).BuiltInFictitiousFunctionClassFactory.setAmount(String.valueOf(p0));
                                return;
                            }
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                });
                VB vb5 = this.MyBillsEntityDataFactory;
                if (vb5 != 0) {
                    ((ViewSetMemberLimitSheetBinding) vb5).MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.bottomsheet.SetLimitBottomSheet$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            SetLimitBottomSheet.MyBillsEntityDataFactory(SetLimitBottomSheet.this);
                        }
                    });
                    VB vb6 = this.MyBillsEntityDataFactory;
                    if (vb6 != 0) {
                        ((ViewSetMemberLimitSheetBinding) vb6).BuiltInFictitiousFunctionClassFactory.setListener(new NumpadView.NumpadClickListener() { // from class: id.dana.familyaccount.view.bottomsheet.SetLimitBottomSheet$setupCustomKeyboard$1$1
                            @Override // id.dana.core.ui.richview.NumpadView.NumpadClickListener
                            public final void MyBillsEntityDataFactory(String p0) {
                                Intrinsics.checkNotNullParameter(p0, "");
                                if (p0.length() == 0) {
                                    VB vb7 = SetLimitBottomSheet.this.MyBillsEntityDataFactory;
                                    if (vb7 != 0) {
                                        ((ViewSetMemberLimitSheetBinding) vb7).getAuthRequestContext.clear();
                                        return;
                                    }
                                    throw new IllegalArgumentException("Required value was null.".toString());
                                }
                                VB vb8 = SetLimitBottomSheet.this.MyBillsEntityDataFactory;
                                if (vb8 != 0) {
                                    ((ViewSetMemberLimitSheetBinding) vb8).getAuthRequestContext.setEditTextAmount(Long.parseLong(p0));
                                    return;
                                }
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }
                        });
                        VB vb7 = this.MyBillsEntityDataFactory;
                        if (vb7 != 0) {
                            FamilySetMemberLimitInputAmountView familySetMemberLimitInputAmountView = ((ViewSetMemberLimitSheetBinding) vb7).getAuthRequestContext;
                            if (OSUtil.scheduleImpl()) {
                                VB vb8 = this.MyBillsEntityDataFactory;
                                if (vb8 != 0) {
                                    CurrencyEditText etAmount = ((ViewSetMemberLimitSheetBinding) vb8).getAuthRequestContext.getEtAmount();
                                    if (etAmount != null) {
                                        etAmount.setShowSoftInputOnFocus(false);
                                        return;
                                    }
                                    return;
                                }
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }
                            VB vb9 = this.MyBillsEntityDataFactory;
                            if (vb9 != 0) {
                                CurrencyEditText etAmount2 = ((ViewSetMemberLimitSheetBinding) vb9).getAuthRequestContext.getEtAmount();
                                if (etAmount2 != null) {
                                    etAmount2.setTextIsSelectable(true);
                                    return;
                                }
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

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle p0) {
        try {
            byte b = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda1[5] - 1);
            Object[] objArr = new Object[1];
            a(b, (byte) (b | 14), NetworkUserEntityData$$ExternalSyntheticLambda1[5], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda1[5] - 1);
            byte b3 = (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda1[5]);
            Object[] objArr2 = new Object[1];
            a(b2, b3, (byte) (b3 + 1), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + 494, TextUtils.indexOf("", "", 0) + 4, (char) (1 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))));
                    byte b4 = (byte) ($$a[4] - 1);
                    Object[] objArr4 = new Object[1];
                    b(b4, b4, $$a[35], objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.getSize(0), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 35, (char) Color.green(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {1165263148, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getTapTimeout() >> 16) + 911, 17 - TextUtils.indexOf((CharSequence) "", '0'), (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext, theme) { // from class: id.dana.familyaccount.view.bottomsheet.SetLimitBottomSheet$onCreateDialog$dialog$1
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
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            ((ViewSetMemberLimitSheetBinding) vb).getAuthRequestContext.setEditTextAmount(this.BuiltInFictitiousFunctionClassFactory);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(SetLimitBottomSheet setLimitBottomSheet) {
        String str;
        Intrinsics.checkNotNullParameter(setLimitBottomSheet, "");
        VB vb = setLimitBottomSheet.MyBillsEntityDataFactory;
        if (vb != 0) {
            CurrencyEditText etAmount = ((ViewSetMemberLimitSheetBinding) vb).getAuthRequestContext.getEtAmount();
            if (etAmount == null || (str = etAmount.getAmount()) == null) {
                str = "0";
            }
            setLimitBottomSheet.PlaceComponentResult.invoke(str);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void MyBillsEntityDataFactory(boolean p0) {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            DanaButtonPrimaryView danaButtonPrimaryView = ((ViewSetMemberLimitSheetBinding) vb).MyBillsEntityDataFactory;
            danaButtonPrimaryView.setDanaButtonView(p0 ? 1 : 0, getString(R.string.family_member_transaction_limit_save_changes), null, null);
            danaButtonPrimaryView.setEnabled(p0);
            danaButtonPrimaryView.setClickable(p0);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final View KClassImpl$Data$declaredNonStaticMembers$2() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            FrameLayout frameLayout = ((ViewSetMemberLimitSheetBinding) vb).PlaceComponentResult;
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
