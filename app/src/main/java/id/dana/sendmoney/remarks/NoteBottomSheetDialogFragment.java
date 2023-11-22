package id.dana.sendmoney.remarks;

import android.content.Context;
import android.graphics.Color;
import android.media.AudioTrack;
import android.os.Bundle;
import android.telephony.cdma.CdmaCellLocation;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.di.ComponentHolder;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerNoteComponent;
import id.dana.di.modules.NoteModule;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.sendmoney.remarks.NoteContract;
import id.dana.utils.KeyboardHelper;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b+\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0012\u0010\rJ\u000f\u0010\u0013\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0013\u0010\rJ\u000f\u0010\u0014\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\rJ\u0013\u0010\u0016\u001a\u00020\u000b*\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0016\u001a\u00020\bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001b\u001a\u00020\bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0019R%\u0010#\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u001f¢\u0006\u0002\b \u0012\u0004\u0012\u00020\u000b0\u001eX\u0086\u0002¢\u0006\u0006\n\u0004\b!\u0010\"R%\u0010%\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u001f¢\u0006\u0002\b \u0012\u0004\u0012\u00020\u000b0\u001eX\u0086\u0002¢\u0006\u0006\n\u0004\b$\u0010\"R\u0012\u0010'\u001a\u00020&X\u0087\"¢\u0006\u0006\n\u0004\b'\u0010(R\u0013\u0010!\u001a\u00020\u001fX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b)\u0010*"}, d2 = {"Lid/dana/sendmoney/remarks/NoteBottomSheetDialogFragment;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "", "getDimAmount", "()F", "Lid/dana/utils/KeyboardHelper$KeyboardVisibilityListener;", "getKeyboardVisibilityListener", "()Lid/dana/utils/KeyboardHelper$KeyboardVisibilityListener;", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "Landroid/os/Bundle;", "p0", "onCreate", "(Landroid/os/Bundle;)V", "onDestroyView", "onShow", "onStart", "Landroid/widget/TextView;", "MyBillsEntityDataFactory", "(Landroid/widget/TextView;)V", "getErrorConfigVersion", "I", "scheduleImpl", "getAuthRequestContext", "DatabaseTableConfigUtil", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "lookAheadTest", "Lkotlin/jvm/functions/Function1;", "PlaceComponentResult", "moveToNextValue", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/sendmoney/remarks/NoteContract$Presenter;", "presenter", "Lid/dana/sendmoney/remarks/NoteContract$Presenter;", "initRecordTimeStamp", "Lkotlin/Lazy;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NoteBottomSheetDialogFragment extends BaseBottomSheetDialogFragment {

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public int MyBillsEntityDataFactory;
    @Inject
    public NoteContract.Presenter presenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public int getAuthRequestContext;
    public static final byte[] $$d = {125, -100, 71, Ascii.FS, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$e = 139;
    public static final byte[] NetworkUserEntityData$$ExternalSyntheticLambda0 = {TarHeader.LF_FIFO, -88, 36, -123, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int GetContactSyncConfig = 119;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public Function1<? super String, Unit> BuiltInFictitiousFunctionClassFactory = new Function1<String, Unit>() { // from class: id.dana.sendmoney.remarks.NoteBottomSheetDialogFragment$onActionPositive$1
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

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public Function1<? super String, Unit> PlaceComponentResult = new Function1<String, Unit>() { // from class: id.dana.sendmoney.remarks.NoteBottomSheetDialogFragment$onActionNegative$1
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

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final Lazy lookAheadTest = LazyKt.lazy(new Function0<String>() { // from class: id.dana.sendmoney.remarks.NoteBottomSheetDialogFragment$remarks$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            String string;
            Bundle arguments = NoteBottomSheetDialogFragment.this.getArguments();
            return (arguments == null || (string = arguments.getString("remarks")) == null) ? "" : string;
        }
    });

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private int KClassImpl$Data$declaredNonStaticMembers$2 = 50;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0027 -> B:11:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r6, int r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 + 105
            int r6 = r6 * 4
            int r6 = 16 - r6
            byte[] r0 = id.dana.sendmoney.remarks.NoteBottomSheetDialogFragment.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r8 = r8 + 4
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L32
        L17:
            r3 = 0
        L18:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r8 = r8 + 1
            if (r3 != r6) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            r4 = r0[r8]
            int r3 = r3 + 1
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L32:
            int r7 = r7 + r8
            int r7 = r7 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.remarks.NoteBottomSheetDialogFragment.c(int, int, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(short r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.sendmoney.remarks.NoteBottomSheetDialogFragment.$$d
            int r7 = r7 * 3
            int r7 = r7 + 4
            int r8 = r8 * 3
            int r8 = 75 - r8
            int r6 = r6 * 3
            int r6 = r6 + 42
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r4 = r8
            r3 = 0
            r8 = r7
            goto L31
        L19:
            r3 = 0
        L1a:
            r5 = r8
            r8 = r7
            r7 = r5
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            r4 = r0[r8]
            int r3 = r3 + 1
            r5 = r8
            r8 = r7
            r7 = r5
        L31:
            int r4 = -r4
            int r7 = r7 + 1
            int r8 = r8 + r4
            int r8 = r8 + (-7)
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.remarks.NoteBottomSheetDialogFragment.d(short, byte, int, java.lang.Object[]):void");
    }

    public final View MyBillsEntityDataFactory(int i) {
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

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final float getDimAmount() {
        return 0.5f;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final int getLayout() {
        return R.layout.view_add_remark_container;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle p0) {
        try {
            Object[] objArr = new Object[1];
            c((byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[5] + 1), (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[5]), 14, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[5] + 1);
            Object[] objArr2 = new Object[1];
            c(b, b, NetworkUserEntityData$$ExternalSyntheticLambda0[5], objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 4 - TextUtils.getOffsetAfter("", 0), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)));
                    byte b2 = (byte) ($$d[4] - 1);
                    byte b3 = b2;
                    Object[] objArr4 = new Object[1];
                    d(b2, b3, b3, objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getCapsMode("", 0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 35, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-1680359431, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getTrimmedLength(""), TextUtils.getOffsetAfter("", 0) + 18, (char) Color.argb(0, 0, 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                Bundle arguments = getArguments();
                this.KClassImpl$Data$declaredNonStaticMembers$2 = arguments != null ? arguments.getInt("maxchar", 50) : 50;
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
        String string;
        super.init();
        Button button = (Button) MyBillsEntityDataFactory(R.id.initAnimators);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.remarks.NoteBottomSheetDialogFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NoteBottomSheetDialogFragment.BuiltInFictitiousFunctionClassFactory(NoteBottomSheetDialogFragment.this);
                }
            });
            button.setEnabled(false);
            int i = this.getAuthRequestContext;
            if (i != 0) {
                string = getString(i);
            } else {
                String string2 = StringsKt.isBlank((String) this.lookAheadTest.getValue()) ? getString(R.string.sendmoney_remarks_add) : getString(R.string.sendmoney_remarks_edit);
                Intrinsics.checkNotNullExpressionValue(string2, "");
                string = string2;
            }
            button.setText(string);
        }
        Button button2 = (Button) MyBillsEntityDataFactory(R.id.TypefaceCompatApi26Impl);
        if (button2 != null && this.MyBillsEntityDataFactory != 0) {
            button2.setVisibility(0);
            button2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.remarks.NoteBottomSheetDialogFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NoteBottomSheetDialogFragment.PlaceComponentResult(NoteBottomSheetDialogFragment.this);
                }
            });
            button2.setText(getString(this.MyBillsEntityDataFactory));
        }
        EditText editText = (EditText) MyBillsEntityDataFactory(R.id.et_remarks);
        if (editText != null) {
            editText.setVerticalScrollBarEnabled(true);
            if (true ^ StringsKt.isBlank((String) this.lookAheadTest.getValue())) {
                editText.setText((String) this.lookAheadTest.getValue());
                editText.setSelection(((String) this.lookAheadTest.getValue()).length());
            }
            editText.addTextChangedListener(new TextWatcher() { // from class: id.dana.sendmoney.remarks.NoteBottomSheetDialogFragment$initEditText$$inlined$addTextChangedListener$default$1
                @Override // android.text.TextWatcher
                public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
                }

                @Override // android.text.TextWatcher
                public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                }

                /* JADX WARN: Code restructure failed: missing block: B:18:0x003a, code lost:
                
                    if ((r5 == null || kotlin.text.StringsKt.isBlank(r5)) == false) goto L21;
                 */
                @Override // android.text.TextWatcher
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void afterTextChanged(android.text.Editable r5) {
                    /*
                        r4 = this;
                        id.dana.sendmoney.remarks.NoteBottomSheetDialogFragment r0 = id.dana.sendmoney.remarks.NoteBottomSheetDialogFragment.this
                        int r1 = id.dana.R.id.initAnimators
                        android.view.View r0 = r0.MyBillsEntityDataFactory(r1)
                        android.widget.Button r0 = (android.widget.Button) r0
                        if (r0 == 0) goto L41
                        java.lang.String r1 = ""
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                        if (r5 == 0) goto L18
                        java.lang.String r1 = r5.toString()
                        goto L19
                    L18:
                        r1 = 0
                    L19:
                        id.dana.sendmoney.remarks.NoteBottomSheetDialogFragment r2 = id.dana.sendmoney.remarks.NoteBottomSheetDialogFragment.this
                        java.lang.String r2 = id.dana.sendmoney.remarks.NoteBottomSheetDialogFragment.getErrorConfigVersion(r2)
                        boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
                        r2 = 1
                        r3 = 0
                        if (r1 == 0) goto L3e
                        boolean r1 = r0.isEnabled()
                        if (r1 != 0) goto L3d
                        java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                        if (r5 == 0) goto L39
                        boolean r5 = kotlin.text.StringsKt.isBlank(r5)
                        if (r5 != 0) goto L39
                        r5 = 0
                        goto L3a
                    L39:
                        r5 = 1
                    L3a:
                        if (r5 != 0) goto L3d
                        goto L3e
                    L3d:
                        r2 = 0
                    L3e:
                        r0.setEnabled(r2)
                    L41:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.remarks.NoteBottomSheetDialogFragment$initEditText$$inlined$addTextChangedListener$default$1.afterTextChanged(android.text.Editable):void");
                }
            });
            editText.setOnTouchListener(new View.OnTouchListener() { // from class: id.dana.sendmoney.remarks.NoteBottomSheetDialogFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean authRequestContext;
                    authRequestContext = NoteBottomSheetDialogFragment.getAuthRequestContext(view, motionEvent);
                    return authRequestContext;
                }
            });
        }
        TextView textView = (TextView) MyBillsEntityDataFactory(R.id.tv_hint);
        if (textView != null) {
            MyBillsEntityDataFactory(textView);
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final KeyboardHelper.KeyboardVisibilityListener getKeyboardVisibilityListener() {
        return new NoteBottomSheetDialogFragment$getKeyboardVisibilityListener$1(this);
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void onShow() {
        super.onShow();
        DaggerNoteComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerNoteComponent.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(ComponentHolder.getAuthRequestContext());
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = (NoteModule) Preconditions.getAuthRequestContext(new NoteModule(new NoteContract.View() { // from class: id.dana.sendmoney.remarks.NoteBottomSheetDialogFragment$getNoteView$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.sendmoney.remarks.NoteContract.View
            public final void BuiltInFictitiousFunctionClassFactory(int p0) {
                NoteBottomSheetDialogFragment.this.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
                EditText editText = (EditText) NoteBottomSheetDialogFragment.this.MyBillsEntityDataFactory(R.id.et_remarks);
                if (editText != null) {
                    NoteBottomSheetDialogFragment.MyBillsEntityDataFactory(NoteBottomSheetDialogFragment.this, editText);
                }
                TextView textView = (TextView) NoteBottomSheetDialogFragment.this.MyBillsEntityDataFactory(R.id.tv_hint);
                if (textView != null) {
                    NoteBottomSheetDialogFragment.this.MyBillsEntityDataFactory(textView);
                }
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, NoteModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, ApplicationComponent.class);
        new DaggerNoteComponent.NoteComponentImpl(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, (byte) 0).PlaceComponentResult(this);
        NoteContract.Presenter presenter = this.presenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.getAuthRequestContext();
        initBottomSheet(getScreenHeight(getDialog()), 3);
        EditText editText = (EditText) MyBillsEntityDataFactory(R.id.et_remarks);
        if (editText != null) {
            editText.post(new Runnable() { // from class: id.dana.sendmoney.remarks.NoteBottomSheetDialogFragment$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    NoteBottomSheetDialogFragment.MyBillsEntityDataFactory(NoteBottomSheetDialogFragment.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void MyBillsEntityDataFactory(TextView textView) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(R.string.sendmoney_remarks_add_hint);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        textView.setText(format);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getAuthRequestContext(View view, MotionEvent motionEvent) {
        view.getParent().requestDisallowInterceptTouchEvent(true);
        if ((motionEvent.getAction() & 255) == 1) {
            view.getParent().requestDisallowInterceptTouchEvent(false);
        }
        return false;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        NoteContract.Presenter presenter = this.presenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.onDestroy();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0086\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lid/dana/sendmoney/remarks/NoteBottomSheetDialogFragment$Companion;", "", "()V", "KEY_MAXCHAR", "", "KEY_REMARKS", "TAG", BridgeDSL.INVOKE, "Lid/dana/sendmoney/remarks/NoteBottomSheetDialogFragment;", "remarks", "maxChar", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static NoteBottomSheetDialogFragment PlaceComponentResult(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            NoteBottomSheetDialogFragment noteBottomSheetDialogFragment = new NoteBottomSheetDialogFragment();
            Bundle arguments = noteBottomSheetDialogFragment.getArguments();
            if (arguments == null) {
                arguments = new Bundle();
            }
            Intrinsics.checkNotNullExpressionValue(arguments, "");
            arguments.putString("remarks", str);
            arguments.putInt("maxchar", 50);
            noteBottomSheetDialogFragment.setArguments(arguments);
            return noteBottomSheetDialogFragment;
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(NoteBottomSheetDialogFragment noteBottomSheetDialogFragment) {
        Editable text;
        Intrinsics.checkNotNullParameter(noteBottomSheetDialogFragment, "");
        Function1<? super String, Unit> function1 = noteBottomSheetDialogFragment.BuiltInFictitiousFunctionClassFactory;
        EditText editText = (EditText) noteBottomSheetDialogFragment.MyBillsEntityDataFactory(R.id.et_remarks);
        String obj = (editText == null || (text = editText.getText()) == null) ? null : text.toString();
        function1.invoke(obj != null ? obj : "");
        noteBottomSheetDialogFragment.dismiss();
    }

    public static /* synthetic */ void PlaceComponentResult(NoteBottomSheetDialogFragment noteBottomSheetDialogFragment) {
        Editable text;
        Intrinsics.checkNotNullParameter(noteBottomSheetDialogFragment, "");
        Function1<? super String, Unit> function1 = noteBottomSheetDialogFragment.PlaceComponentResult;
        EditText editText = (EditText) noteBottomSheetDialogFragment.MyBillsEntityDataFactory(R.id.et_remarks);
        String obj = (editText == null || (text = editText.getText()) == null) ? null : text.toString();
        function1.invoke(obj != null ? obj : "");
        noteBottomSheetDialogFragment.dismiss();
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(NoteBottomSheetDialogFragment noteBottomSheetDialogFragment) {
        Window window;
        Context applicationContext;
        Intrinsics.checkNotNullParameter(noteBottomSheetDialogFragment, "");
        ((EditText) noteBottomSheetDialogFragment.MyBillsEntityDataFactory(R.id.et_remarks)).requestFocus();
        Context context = noteBottomSheetDialogFragment.getContext();
        Object systemService = (context == null || (applicationContext = context.getApplicationContext()) == null) ? null : applicationContext.getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput((EditText) noteBottomSheetDialogFragment.MyBillsEntityDataFactory(R.id.et_remarks), 1);
            FragmentActivity activity = noteBottomSheetDialogFragment.getActivity();
            if (activity == null || (window = activity.getWindow()) == null) {
                return;
            }
            window.setSoftInputMode(48);
        }
    }

    public static final /* synthetic */ String getErrorConfigVersion(NoteBottomSheetDialogFragment noteBottomSheetDialogFragment) {
        return (String) noteBottomSheetDialogFragment.lookAheadTest.getValue();
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(NoteBottomSheetDialogFragment noteBottomSheetDialogFragment, EditText editText) {
        if (noteBottomSheetDialogFragment.KClassImpl$Data$declaredNonStaticMembers$2 > 0) {
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(noteBottomSheetDialogFragment.KClassImpl$Data$declaredNonStaticMembers$2)});
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    /* renamed from: getBottomSheet */
    public final /* synthetic */ View getPlaceComponentResult() {
        FrameLayout frameLayout = (FrameLayout) MyBillsEntityDataFactory(R.id.phoneNumber);
        Intrinsics.checkNotNullExpressionValue(frameLayout, "");
        return frameLayout;
    }
}
