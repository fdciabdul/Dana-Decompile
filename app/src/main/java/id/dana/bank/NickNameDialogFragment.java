package id.dana.bank;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.android.material.textfield.TextInputEditText;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.iap.ac.android.common.container.provider.ui.ContainerUIProvider;
import id.dana.R;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda2;
import id.dana.databinding.BottomSheetNickNameBinding;
import id.dana.databinding.BottomSheetNickNameCoordinatorBinding;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B$\u0012\u001b\b\u0002\u0010\u000e\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0014¢\u0006\u0002\b\u001d\u0012\u0004\u0012\u00020\t0\u001c¢\u0006\u0004\b \u0010!J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0011\u0010\u000bJ\u000f\u0010\u0012\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0012\u0010\u000bJ!\u0010\u0016\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u001a\u001a\u00020\u0019*\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR)\u0010\u0011\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0014¢\u0006\u0002\b\u001d\u0012\u0004\u0012\u00020\t0\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f"}, d2 = {"Lid/dana/bank/NickNameDialogFragment;", "Lid/dana/core/ui/BaseViewBindingBottomSheetDialogFragment;", "Lid/dana/databinding/BottomSheetNickNameCoordinatorBinding;", "", "BuiltInFictitiousFunctionClassFactory", "()F", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/view/View;", "", "getAuthRequestContext", "()V", "moveToNextValue", "Landroid/os/Bundle;", "p0", "onCreate", "(Landroid/os/Bundle;)V", "MyBillsEntityDataFactory", "onStart", "Landroidx/fragment/app/FragmentManager;", "", "p1", ContainerUIProvider.KEY_SHOW, "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V", "", "", "PlaceComponentResult", "(Ljava/lang/CharSequence;)Z", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lkotlin/jvm/functions/Function1;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NickNameDialogFragment extends BaseViewBindingBottomSheetDialogFragment<BottomSheetNickNameCoordinatorBinding> {

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private Function1<? super String, Unit> MyBillsEntityDataFactory;
    public Map<Integer, View> PlaceComponentResult;
    public static final byte[] $$a = {107, -40, -73, 40, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 85;
    public static final byte[] MyBillsEntityDataFactory = {Ascii.US, -80, -88, -103, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 224;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlin.jvm.functions.Function1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public NickNameDialogFragment() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.bank.NickNameDialogFragment.<init>():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.bank.NickNameDialogFragment.MyBillsEntityDataFactory
            int r8 = r8 + 4
            int r7 = r7 * 4
            int r7 = 16 - r7
            int r6 = r6 + 105
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L36
        L17:
            r3 = 0
        L18:
            r5 = r8
            r8 = r6
            r6 = r5
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            int r6 = r6 + 1
            r4 = r0[r6]
            int r3 = r3 + 1
            r5 = r8
            r8 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L36:
            int r6 = -r6
            int r9 = r9 + r6
            int r6 = r9 + 2
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.bank.NickNameDialogFragment.a(int, short, int, java.lang.Object[]):void");
    }

    private static void b(byte b, int i, short s, Object[] objArr) {
        int i2 = 3 - (s * 2);
        byte[] bArr = $$a;
        int i3 = 42 - (b * 3);
        int i4 = 75 - (i * 4);
        byte[] bArr2 = new byte[i3];
        int i5 = -1;
        int i6 = i3 - 1;
        if (bArr == null) {
            i4 = (i6 + i4) - 7;
            i6 = i6;
        }
        while (true) {
            i2++;
            i5++;
            bArr2[i5] = (byte) i4;
            if (i5 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i7 = i4;
            int i8 = i6;
            i4 = (i7 + bArr[i2]) - 7;
            i6 = i8;
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final float BuiltInFictitiousFunctionClassFactory() {
        return 0.48f;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void PlaceComponentResult() {
        this.PlaceComponentResult.clear();
    }

    public NickNameDialogFragment(Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        this.PlaceComponentResult = new LinkedHashMap();
        this.MyBillsEntityDataFactory = function1;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final /* synthetic */ BottomSheetNickNameCoordinatorBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        BottomSheetNickNameCoordinatorBinding PlaceComponentResult = BottomSheetNickNameCoordinatorBinding.PlaceComponentResult(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    public /* synthetic */ NickNameDialogFragment(AnonymousClass1 anonymousClass1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function1<String, Unit>() { // from class: id.dana.bank.NickNameDialogFragment.1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Intrinsics.checkNotNullParameter(str, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }
        } : anonymousClass1);
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void getAuthRequestContext() {
        super.getAuthRequestContext();
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            final BottomSheetNickNameBinding bottomSheetNickNameBinding = ((BottomSheetNickNameCoordinatorBinding) vb).MyBillsEntityDataFactory;
            bottomSheetNickNameBinding.BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.bank.NickNameDialogFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NickNameDialogFragment.MyBillsEntityDataFactory(NickNameDialogFragment.this);
                }
            });
            TextInputEditText textInputEditText = bottomSheetNickNameBinding.getAuthRequestContext;
            textInputEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: id.dana.bank.NickNameDialogFragment$$ExternalSyntheticLambda2
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    boolean BuiltInFictitiousFunctionClassFactory;
                    BuiltInFictitiousFunctionClassFactory = NickNameDialogFragment.BuiltInFictitiousFunctionClassFactory(NickNameDialogFragment.this, i);
                    return BuiltInFictitiousFunctionClassFactory;
                }
            });
            Intrinsics.checkNotNullExpressionValue(textInputEditText, "");
            textInputEditText.addTextChangedListener(new TextWatcher() { // from class: id.dana.bank.NickNameDialogFragment$initViews$lambda-7$lambda-6$$inlined$addTextChangedListener$default$1
                @Override // android.text.TextWatcher
                public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
                }

                @Override // android.text.TextWatcher
                public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                }

                /* JADX WARN: Code restructure failed: missing block: B:10:0x0019, code lost:
                
                    if (r5 != false) goto L13;
                 */
                @Override // android.text.TextWatcher
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void afterTextChanged(android.text.Editable r5) {
                    /*
                        r4 = this;
                        id.dana.databinding.BottomSheetNickNameBinding r0 = id.dana.databinding.BottomSheetNickNameBinding.this
                        androidx.appcompat.widget.AppCompatButton r0 = r0.BuiltInFictitiousFunctionClassFactory
                        java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                        r1 = 1
                        r2 = 0
                        if (r5 == 0) goto L12
                        boolean r3 = kotlin.text.StringsKt.isBlank(r5)
                        if (r3 != 0) goto L12
                        r3 = 0
                        goto L13
                    L12:
                        r3 = 1
                    L13:
                        if (r3 != 0) goto L1c
                        boolean r5 = id.dana.bank.NickNameDialogFragment.BuiltInFictitiousFunctionClassFactory(r5)
                        if (r5 == 0) goto L1c
                        goto L1d
                    L1c:
                        r1 = 0
                    L1d:
                        r0.setEnabled(r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.bank.NickNameDialogFragment$initViews$lambda7$lambda6$$inlined$addTextChangedListener$default$1.afterTextChanged(android.text.Editable):void");
                }
            });
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle p0) {
        try {
            byte b = MyBillsEntityDataFactory[5];
            byte b2 = (byte) (b - 1);
            Object[] objArr = new Object[1];
            a(b, b2, (byte) (b2 | 14), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (MyBillsEntityDataFactory[5] - 1);
            Object[] objArr2 = new Object[1];
            a(b3, b3, (byte) (-MyBillsEntityDataFactory[5]), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 494, ExpandableListView.getPackedPositionChild(0L) + 5, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                    byte b4 = (byte) ($$a[35] - 1);
                    byte b5 = b4;
                    Object[] objArr4 = new Object[1];
                    b(b4, b5, b5, objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), Color.argb(0, 0, 0, 0) + 35, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-1391029049, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getOffsetBefore("", 0), 18 - TextUtils.indexOf("", "", 0, 0), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            View view = getView();
            if (view != null) {
                view.post(new BaseViewBindingBottomSheetDialogFragment$$ExternalSyntheticLambda2(view, this));
            }
            MyBillsEntityDataFactory(dialog);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BuiltInFictitiousFunctionClassFactory(NickNameDialogFragment nickNameDialogFragment, int i) {
        Intrinsics.checkNotNullParameter(nickNameDialogFragment, "");
        if (i == 6) {
            nickNameDialogFragment.moveToNextValue();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean PlaceComponentResult(CharSequence charSequence) {
        return charSequence.length() > 4;
    }

    @Override // androidx.fragment.app.DialogFragment
    public final void show(FragmentManager p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        FragmentTransaction beginTransaction = p0.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "");
        beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2(0, this, "NickNameDialogFragment", 1);
        beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(BottomSheetNickNameBinding bottomSheetNickNameBinding, NickNameDialogFragment nickNameDialogFragment) {
        Window window;
        Context applicationContext;
        Intrinsics.checkNotNullParameter(bottomSheetNickNameBinding, "");
        Intrinsics.checkNotNullParameter(nickNameDialogFragment, "");
        TextInputEditText textInputEditText = bottomSheetNickNameBinding.getAuthRequestContext;
        textInputEditText.requestFocus();
        Context context = textInputEditText.getContext();
        Object systemService = (context == null || (applicationContext = context.getApplicationContext()) == null) ? null : applicationContext.getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(textInputEditText, 1);
            FragmentActivity activity = nickNameDialogFragment.getActivity();
            if (activity == null || (window = activity.getWindow()) == null) {
                return;
            }
            window.setSoftInputMode(48);
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(NickNameDialogFragment nickNameDialogFragment) {
        Intrinsics.checkNotNullParameter(nickNameDialogFragment, "");
        nickNameDialogFragment.moveToNextValue();
    }

    private final void moveToNextValue() {
        String obj;
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            Editable text = ((BottomSheetNickNameCoordinatorBinding) vb).MyBillsEntityDataFactory.getAuthRequestContext.getText();
            if (text == null || (obj = text.toString()) == null) {
                return;
            }
            if (!PlaceComponentResult(obj)) {
                obj = null;
            }
            if (obj != null) {
                this.MyBillsEntityDataFactory.invoke(obj);
                dismiss();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final View KClassImpl$Data$declaredNonStaticMembers$2() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            FrameLayout frameLayout = ((BottomSheetNickNameCoordinatorBinding) vb).MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "");
            return frameLayout;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.PlaceComponentResult.clear();
    }
}
