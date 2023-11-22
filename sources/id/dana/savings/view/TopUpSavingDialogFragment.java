package id.dana.savings.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.inputmethod.InputMethodManager;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import id.dana.R;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.richview.CurrencyEditText;
import id.dana.data.util.NumberUtils;
import id.dana.lib.gcontainer.extension.NumberExtKt;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.savings.model.SavingTopUpInitModel;
import id.dana.utils.KeyboardHelper;
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

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0002%&B\u0007¢\u0006\u0004\b$\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0011\u0010\u0004J\u0019\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0018\u0010\u0004J\r\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u001dX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0012\u0010#\u001a\u00020 X\u0086\"¢\u0006\u0006\n\u0004\b!\u0010\""}, d2 = {"Lid/dana/savings/view/TopUpSavingDialogFragment;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "", "getAuthRequestContext", "()V", "", "getDimAmount", "()F", "Lid/dana/utils/KeyboardHelper$KeyboardVisibilityListener;", "getKeyboardVisibilityListener", "()Lid/dana/utils/KeyboardHelper$KeyboardVisibilityListener;", "", "getLayout", "()I", "", "MyBillsEntityDataFactory", "()Ljava/lang/String;", IAPSyncCommand.COMMAND_INIT, "Landroid/os/Bundle;", "p0", "onCreate", "(Landroid/os/Bundle;)V", "onShow", "onStart", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "", "moveToNextValue", "Z", "Lid/dana/savings/model/SavingTopUpInitModel;", "scheduleImpl", "Lid/dana/savings/model/SavingTopUpInitModel;", "Lid/dana/savings/view/TopUpSavingDialogFragment$TopUpListener;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/savings/view/TopUpSavingDialogFragment$TopUpListener;", "BuiltInFictitiousFunctionClassFactory", "<init>", "Companion", "TopUpListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TopUpSavingDialogFragment extends BaseBottomSheetDialogFragment {

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public TopUpListener BuiltInFictitiousFunctionClassFactory;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public SavingTopUpInitModel getAuthRequestContext;
    public static final byte[] $$d = {63, Ascii.SUB, 111, -17, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$e = 161;
    public static final byte[] lookAheadTest = {Ascii.RS, 119, -63, 113, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int getErrorConfigVersion = 106;
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory = true;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/savings/view/TopUpSavingDialogFragment$TopUpListener;", "", "", "p0", "", "PlaceComponentResult", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface TopUpListener {
        void PlaceComponentResult(String p0);
    }

    public static final /* synthetic */ int MyBillsEntityDataFactory(long j, long j2) {
        return (j < j2 || j2 == 0) ? 0 : 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r7, byte r8, byte r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 15
            int r7 = r7 + 4
            int r8 = r8 * 3
            int r8 = 16 - r8
            int r9 = 106 - r9
            byte[] r0 = id.dana.savings.view.TopUpSavingDialogFragment.lookAheadTest
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            goto L33
        L19:
            r3 = 0
        L1a:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r8) goto L29
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L29:
            r3 = r0[r7]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L33:
            int r7 = -r7
            int r10 = r10 + r7
            int r7 = r10 + 2
            int r8 = r8 + 1
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r9
            r9 = r7
            r7 = r8
            r8 = r6
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.savings.view.TopUpSavingDialogFragment.c(byte, byte, byte, java.lang.Object[]):void");
    }

    private static void d(int i, short s, byte b, Object[] objArr) {
        int i2 = (b * 2) + 75;
        int i3 = i + 4;
        byte[] bArr = $$d;
        int i4 = (s * 4) + 42;
        byte[] bArr2 = new byte[i4];
        int i5 = -1;
        int i6 = i4 - 1;
        if (bArr == null) {
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = -1;
            i2 = (i2 + i3) - 7;
            i3 = i3;
            i6 = i6;
        }
        while (true) {
            int i7 = i5 + 1;
            bArr2[i7] = (byte) i2;
            int i8 = i3 + 1;
            if (i7 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            byte b2 = bArr[i8];
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = i7;
            i2 = (i2 + b2) - 7;
            i3 = i8;
            i6 = i6;
        }
    }

    public final View PlaceComponentResult(int i) {
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
        return R.layout.view_top_up_container;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle p0) {
        try {
            byte b = lookAheadTest[5];
            byte b2 = (byte) (b - 1);
            Object[] objArr = new Object[1];
            c(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (lookAheadTest[5] - 1);
            Object[] objArr2 = new Object[1];
            c(b3, b3, lookAheadTest[5], objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 494, 3 - TextUtils.indexOf((CharSequence) "", '0'), (char) (Process.myPid() >> 22));
                    byte b4 = $$d[4];
                    byte b5 = (byte) (b4 + 1);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(930 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), 35 - (ViewConfiguration.getEdgeSlop() >> 16), (char) ExpandableListView.getPackedPositionType(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {592180726, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), Color.red(0) + 18, (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        PlaceComponentResult();
        final CurrencyEditText currencyEditText = (CurrencyEditText) PlaceComponentResult(R.id.res_0x7f0a068e_abstractmapbasedmultimap_asmap);
        if (currencyEditText != null) {
            currencyEditText.setText("Rp0");
            currencyEditText.setListener(new CurrencyEditText.Listener() { // from class: id.dana.savings.view.TopUpSavingDialogFragment$initViews$1
                @Override // id.dana.core.ui.richview.CurrencyEditText.Listener
                public final void PlaceComponentResult() {
                    CurrencyEditText.this.clearFocus();
                    this.dismissAllowingStateLoss();
                }
            });
            PlaceComponentResult();
            CurrencyEditText currencyEditText2 = (CurrencyEditText) PlaceComponentResult(R.id.res_0x7f0a068e_abstractmapbasedmultimap_asmap);
            if (currencyEditText2 != null) {
                currencyEditText2.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: id.dana.savings.view.TopUpSavingDialogFragment$$ExternalSyntheticLambda2
                    @Override // android.widget.TextView.OnEditorActionListener
                    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                        boolean KClassImpl$Data$declaredNonStaticMembers$2;
                        KClassImpl$Data$declaredNonStaticMembers$2 = TopUpSavingDialogFragment.KClassImpl$Data$declaredNonStaticMembers$2(TopUpSavingDialogFragment.this, i, keyEvent);
                        return KClassImpl$Data$declaredNonStaticMembers$2;
                    }
                });
            }
            CurrencyEditText currencyEditText3 = (CurrencyEditText) PlaceComponentResult(R.id.res_0x7f0a068e_abstractmapbasedmultimap_asmap);
            if (currencyEditText3 != null) {
                currencyEditText3.setOnTouchListener(new View.OnTouchListener() { // from class: id.dana.savings.view.TopUpSavingDialogFragment$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        boolean PlaceComponentResult;
                        PlaceComponentResult = TopUpSavingDialogFragment.PlaceComponentResult(TopUpSavingDialogFragment.this, motionEvent);
                        return PlaceComponentResult;
                    }
                });
            }
        }
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) PlaceComponentResult(R.id.f);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setEnabled(false);
            danaButtonPrimaryView.setDanaButtonView(0, getString(R.string.top_up), "", null);
        }
        final CurrencyEditText currencyEditText4 = (CurrencyEditText) PlaceComponentResult(R.id.res_0x7f0a068e_abstractmapbasedmultimap_asmap);
        if (currencyEditText4 != null) {
            currencyEditText4.addTextChangedListener(new TextWatcher() { // from class: id.dana.savings.view.TopUpSavingDialogFragment$addTextListener$lambda-2$$inlined$addTextChangedListener$default$1
                @Override // android.text.TextWatcher
                public final void afterTextChanged(Editable p0) {
                }

                @Override // android.text.TextWatcher
                public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
                    Drawable background;
                    CurrencyEditText currencyEditText5 = (CurrencyEditText) TopUpSavingDialogFragment.this.PlaceComponentResult(R.id.res_0x7f0a068e_abstractmapbasedmultimap_asmap);
                    if (currencyEditText5 == null || (background = currencyEditText5.getBackground()) == null) {
                        return;
                    }
                    background.setColorFilter(ContextCompat.BuiltInFictitiousFunctionClassFactory(TopUpSavingDialogFragment.this.getBaseActivity(), R.color.getErrorConfigVersion_res_0x7f060305), PorterDuff.Mode.SRC_IN);
                }

                @Override // android.text.TextWatcher
                public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                    String replace$default;
                    long safeLong;
                    String MyBillsEntityDataFactory;
                    replace$default = StringsKt.replace$default(String.valueOf(p0), "Rp", "", false, 4, (Object) null);
                    if (replace$default.length() == 0) {
                        currencyEditText4.setText("Rp0");
                        replace$default = "0";
                    }
                    safeLong = NumberExtKt.toSafeLong(NumberUtils.getCleanAll(replace$default), 0L);
                    MyBillsEntityDataFactory = TopUpSavingDialogFragment.this.MyBillsEntityDataFactory();
                    String cleanAll = NumberUtils.getCleanAll(MyBillsEntityDataFactory);
                    Intrinsics.checkNotNullExpressionValue(cleanAll, "");
                    long parseLong = Long.parseLong(cleanAll);
                    ((CurrencyEditText) TopUpSavingDialogFragment.this.PlaceComponentResult(R.id.res_0x7f0a068e_abstractmapbasedmultimap_asmap)).setCompoundDrawablesWithIntrinsicBounds(0, 0, (!(r3.length() > 0) || r3.contentEquals("0")) ? 0 : R.drawable.ic_close_filled_grey, 0);
                    TopUpSavingDialogFragment.BuiltInFictitiousFunctionClassFactory(TopUpSavingDialogFragment.this, TopUpSavingDialogFragment.MyBillsEntityDataFactory(parseLong, safeLong));
                    TopUpSavingDialogFragment.this.MyBillsEntityDataFactory = true;
                    if (TopUpSavingDialogFragment.MyBillsEntityDataFactory(parseLong, safeLong) == 1) {
                        TopUpSavingDialogFragment.this.MyBillsEntityDataFactory = false;
                        DanaButtonPrimaryView danaButtonPrimaryView2 = (DanaButtonPrimaryView) TopUpSavingDialogFragment.this.PlaceComponentResult(R.id.f);
                        if (danaButtonPrimaryView2 != null) {
                            danaButtonPrimaryView2.setEnabled(true);
                        }
                        TopUpSavingDialogFragment.this.PlaceComponentResult();
                    } else if (parseLong < safeLong) {
                        DanaButtonPrimaryView danaButtonPrimaryView3 = (DanaButtonPrimaryView) TopUpSavingDialogFragment.this.PlaceComponentResult(R.id.f);
                        if (danaButtonPrimaryView3 != null) {
                            danaButtonPrimaryView3.setEnabled(false);
                        }
                        TopUpSavingDialogFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(TopUpSavingDialogFragment.this);
                    } else {
                        DanaButtonPrimaryView danaButtonPrimaryView4 = (DanaButtonPrimaryView) TopUpSavingDialogFragment.this.PlaceComponentResult(R.id.f);
                        if (danaButtonPrimaryView4 != null) {
                            danaButtonPrimaryView4.setEnabled(false);
                        }
                        TopUpSavingDialogFragment.this.PlaceComponentResult();
                    }
                }
            });
        }
        DanaButtonPrimaryView danaButtonPrimaryView2 = (DanaButtonPrimaryView) PlaceComponentResult(R.id.f);
        if (danaButtonPrimaryView2 != null) {
            danaButtonPrimaryView2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.savings.view.TopUpSavingDialogFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TopUpSavingDialogFragment.getAuthRequestContext(TopUpSavingDialogFragment.this);
                }
            });
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        TextView textView = (TextView) PlaceComponentResult(R.id.tv_warning_note);
        if (textView != null) {
            TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(textView, (int) R.style.f49812132017435);
        }
        TextView textView2 = (TextView) PlaceComponentResult(R.id.tv_warning_note);
        if (textView2 != null) {
            textView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_warning_14, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean KClassImpl$Data$declaredNonStaticMembers$2(TopUpSavingDialogFragment topUpSavingDialogFragment, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(topUpSavingDialogFragment, "");
        if ((keyEvent == null || keyEvent.getKeyCode() != 66) && (i != 6 || topUpSavingDialogFragment.MyBillsEntityDataFactory)) {
            return false;
        }
        topUpSavingDialogFragment.getAuthRequestContext();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PlaceComponentResult(TopUpSavingDialogFragment topUpSavingDialogFragment, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(topUpSavingDialogFragment, "");
        Intrinsics.checkNotNullParameter(motionEvent, "");
        if (((CurrencyEditText) topUpSavingDialogFragment.PlaceComponentResult(R.id.res_0x7f0a068e_abstractmapbasedmultimap_asmap)).getCompoundDrawables()[2] == null || motionEvent.getRawX() < ((CurrencyEditText) topUpSavingDialogFragment.PlaceComponentResult(R.id.res_0x7f0a068e_abstractmapbasedmultimap_asmap)).getRight() - ((CurrencyEditText) topUpSavingDialogFragment.PlaceComponentResult(R.id.res_0x7f0a068e_abstractmapbasedmultimap_asmap)).getCompoundDrawables()[2].getBounds().width() || ((CurrencyEditText) topUpSavingDialogFragment.PlaceComponentResult(R.id.res_0x7f0a068e_abstractmapbasedmultimap_asmap)).getText() == null) {
            return false;
        }
        CurrencyEditText currencyEditText = (CurrencyEditText) topUpSavingDialogFragment.PlaceComponentResult(R.id.res_0x7f0a068e_abstractmapbasedmultimap_asmap);
        if (currencyEditText != null) {
            currencyEditText.setText("Rp0");
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void PlaceComponentResult() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(R.string.top_up_dialog_note_helper);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String format = String.format(string, Arrays.copyOf(new Object[]{MyBillsEntityDataFactory()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        TextView textView = (TextView) PlaceComponentResult(R.id.tv_warning_note);
        if (textView != null) {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        TextView textView2 = (TextView) PlaceComponentResult(R.id.tv_warning_note);
        if (textView2 != null) {
            textView2.setText(format);
        }
        TextView textView3 = (TextView) PlaceComponentResult(R.id.tv_warning_note);
        if (textView3 != null) {
            TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(textView3, (int) R.style.f49862132017440);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String MyBillsEntityDataFactory() {
        MoneyViewModel moneyViewModel;
        String str;
        SavingTopUpInitModel savingTopUpInitModel = this.getAuthRequestContext;
        return (savingTopUpInitModel == null || (moneyViewModel = savingTopUpInitModel.MyBillsEntityDataFactory) == null || (str = moneyViewModel.PlaceComponentResult) == null) ? "0" : str;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final KeyboardHelper.KeyboardVisibilityListener getKeyboardVisibilityListener() {
        return new TopUpSavingDialogFragment$getKeyboardVisibilityListener$1(this);
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void onShow() {
        super.onShow();
        initBottomSheet(getScreenHeight(getDialog()), 3);
        CurrencyEditText currencyEditText = (CurrencyEditText) PlaceComponentResult(R.id.res_0x7f0a068e_abstractmapbasedmultimap_asmap);
        if (currencyEditText != null) {
            currencyEditText.post(new Runnable() { // from class: id.dana.savings.view.TopUpSavingDialogFragment$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    TopUpSavingDialogFragment.MyBillsEntityDataFactory(TopUpSavingDialogFragment.this);
                }
            });
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(TopUpSavingDialogFragment topUpSavingDialogFragment) {
        Context applicationContext;
        Intrinsics.checkNotNullParameter(topUpSavingDialogFragment, "");
        CurrencyEditText currencyEditText = (CurrencyEditText) topUpSavingDialogFragment.PlaceComponentResult(R.id.res_0x7f0a068e_abstractmapbasedmultimap_asmap);
        if (currencyEditText != null) {
            currencyEditText.requestFocus();
        }
        CurrencyEditText currencyEditText2 = (CurrencyEditText) topUpSavingDialogFragment.PlaceComponentResult(R.id.res_0x7f0a068e_abstractmapbasedmultimap_asmap);
        if (currencyEditText2 != null) {
            currencyEditText2.setInputType(2);
        }
        CurrencyEditText currencyEditText3 = (CurrencyEditText) topUpSavingDialogFragment.PlaceComponentResult(R.id.res_0x7f0a068e_abstractmapbasedmultimap_asmap);
        if (currencyEditText3 != null) {
            currencyEditText3.setTransformationMethod(null);
        }
        CurrencyEditText currencyEditText4 = (CurrencyEditText) topUpSavingDialogFragment.PlaceComponentResult(R.id.res_0x7f0a068e_abstractmapbasedmultimap_asmap);
        if (currencyEditText4 != null) {
            TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(currencyEditText4, (int) R.style.f54412132017956);
        }
        CurrencyEditText currencyEditText5 = (CurrencyEditText) topUpSavingDialogFragment.PlaceComponentResult(R.id.res_0x7f0a068e_abstractmapbasedmultimap_asmap);
        if (currencyEditText5 != null) {
            currencyEditText5.getText();
        }
        Context context = topUpSavingDialogFragment.getContext();
        Object systemService = (context == null || (applicationContext = context.getApplicationContext()) == null) ? null : applicationContext.getSystemService("input_method");
        InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput((CurrencyEditText) topUpSavingDialogFragment.PlaceComponentResult(R.id.res_0x7f0a068e_abstractmapbasedmultimap_asmap), 1);
        }
    }

    public static /* synthetic */ void getAuthRequestContext(TopUpSavingDialogFragment topUpSavingDialogFragment) {
        Intrinsics.checkNotNullParameter(topUpSavingDialogFragment, "");
        topUpSavingDialogFragment.getAuthRequestContext();
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(TopUpSavingDialogFragment topUpSavingDialogFragment, int i) {
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) topUpSavingDialogFragment.PlaceComponentResult(R.id.f);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setDanaButtonView(i, topUpSavingDialogFragment.getString(R.string.top_up), "", null);
        }
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda0(TopUpSavingDialogFragment topUpSavingDialogFragment) {
        TextView textView = (TextView) topUpSavingDialogFragment.PlaceComponentResult(R.id.tv_warning_note);
        if (textView != null) {
            textView.setText(topUpSavingDialogFragment.getString(R.string.top_up_dialog_error));
        }
        topUpSavingDialogFragment.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    private final void getAuthRequestContext() {
        TopUpListener topUpListener = this.BuiltInFictitiousFunctionClassFactory;
        if (topUpListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            topUpListener = null;
        }
        topUpListener.PlaceComponentResult(((CurrencyEditText) PlaceComponentResult(R.id.res_0x7f0a068e_abstractmapbasedmultimap_asmap)).getAmount());
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) PlaceComponentResult(R.id.f);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setEnabled(false);
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    /* renamed from: getBottomSheet */
    public final /* synthetic */ View getPlaceComponentResult() {
        return (FrameLayout) PlaceComponentResult(R.id.phoneNumber);
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
