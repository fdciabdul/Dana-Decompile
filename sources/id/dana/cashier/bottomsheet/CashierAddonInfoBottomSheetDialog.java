package id.dana.cashier.bottomsheet;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.common.base.Ascii;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.cashier.adapter.AddonImportantInfoAdapter;
import id.dana.cashier.adapter.BenefitAdapter;
import id.dana.cashier.model.CashierAddOnModalContentModel;
import id.dana.cashier.model.CashierAddOnModalTooltipModel;
import id.dana.core.ui.glide.GlideApp;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b+\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0012\u0010\nJ\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\nR\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\r\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0012\u0010%\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b#\u0010$R\u0012\u0010 \u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b&\u0010$R\u0012\u0010#\u001a\u00020\u000bX\u0086\u0002¢\u0006\u0006\n\u0004\b'\u0010$R\u0012\u0010\u001d\u001a\u00020(X\u0086\u0002¢\u0006\u0006\n\u0004\b)\u0010*"}, d2 = {"Lid/dana/cashier/bottomsheet/CashierAddonInfoBottomSheetDialog;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "", "getDimAmount", "()F", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "", "p0", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "onCreate", "(Landroid/os/Bundle;)V", "onShow", "onStart", "Lid/dana/cashier/adapter/AddonImportantInfoAdapter;", "initRecordTimeStamp", "Lid/dana/cashier/adapter/AddonImportantInfoAdapter;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/cashier/adapter/BenefitAdapter;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/cashier/adapter/BenefitAdapter;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/cashier/model/CashierAddOnModalContentModel;", "getErrorConfigVersion", "Lid/dana/cashier/model/CashierAddOnModalContentModel;", "Lid/dana/cashier/model/CashierAddOnModalTooltipModel;", "lookAheadTest", "Lid/dana/cashier/model/CashierAddOnModalTooltipModel;", "getAuthRequestContext", "scheduleImpl", "Ljava/lang/String;", "PlaceComponentResult", "NetworkUserEntityData$$ExternalSyntheticLambda0", "moveToNextValue", "", "DatabaseTableConfigUtil", "Z", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierAddonInfoBottomSheetDialog extends BaseBottomSheetDialogFragment {

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    public boolean getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private BenefitAdapter KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public CashierAddOnModalContentModel MyBillsEntityDataFactory;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private AddonImportantInfoAdapter BuiltInFictitiousFunctionClassFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public CashierAddOnModalTooltipModel getAuthRequestContext;
    public static final byte[] $$d = {22, 66, -65, -82, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$e = 134;
    public static final byte[] NetworkUserEntityData$$ExternalSyntheticLambda2 = {117, -10, 119, -11, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int GetContactSyncConfig = 216;
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public String PlaceComponentResult = "";

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public String scheduleImpl = "";

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public String lookAheadTest = "";

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

    private static void c(short s, int i, short s2, Object[] objArr) {
        int i2 = 19 - (s * 15);
        int i3 = (s2 * 2) + 16;
        int i4 = i + 105;
        byte[] bArr = NetworkUserEntityData$$ExternalSyntheticLambda2;
        byte[] bArr2 = new byte[i3];
        int i5 = -1;
        int i6 = i3 - 1;
        if (bArr == null) {
            int i7 = i6 + i2 + 2;
            i6 = i6;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = -1;
            i4 = i7;
            i2++;
        }
        while (true) {
            int i8 = i5 + 1;
            bArr2[i8] = (byte) i4;
            if (i8 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            byte b = bArr[i2];
            int i9 = i4;
            int i10 = i2 + 1;
            i6 = i6;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i5 = i8;
            i4 = i9 + b + 2;
            i2 = i10;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(short r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 + 4
            int r6 = r6 * 2
            int r6 = r6 + 75
            byte[] r0 = id.dana.cashier.bottomsheet.CashierAddonInfoBottomSheetDialog.$$d
            int r8 = r8 * 2
            int r8 = r8 + 42
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r6 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L37
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            int r7 = r7 + 1
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L37:
            int r7 = -r7
            int r8 = r8 + r7
            int r7 = r8 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.bottomsheet.CashierAddonInfoBottomSheetDialog.d(short, short, int, java.lang.Object[]):void");
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final float getDimAmount() {
        return 0.5f;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final int getLayout() {
        return R.layout.bottom_sheet_cashier_add_on_info_coordinator;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle p0) {
        try {
            byte b = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda2[5] + 1);
            byte b2 = (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda2[5]);
            Object[] objArr = new Object[1];
            c(b, b2, (byte) (b2 - 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda2[5]);
            byte b4 = (byte) (b3 - 1);
            Object[] objArr2 = new Object[1];
            c(b3, b4, b4, objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getMode(0) + 494, Drawable.resolveOpacity(0, 0) + 4, (char) Color.red(0));
                    byte b5 = (byte) ($$d[4] - 1);
                    byte b6 = $$d[35];
                    Object[] objArr4 = new Object[1];
                    d(b5, b6, (byte) (b6 + 1), objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 34 - TextUtils.lastIndexOf("", '0'), (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {534640706, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.getDefaultSize(0, 0) + 911, 19 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    /* JADX WARN: Code restructure failed: missing block: B:140:0x01df, code lost:
    
        if (((r6 == null || (r6 = r6.KClassImpl$Data$declaredNonStaticMembers$2) == null || (r6 = r6.NetworkUserEntityData$$ExternalSyntheticLambda1) == null || !r6.isEmpty()) ? false : true) == false) goto L143;
     */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:187:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ce  */
    @Override // id.dana.base.BaseBottomSheetDialogFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void init() {
        /*
            Method dump skipped, instructions count: 680
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.bottomsheet.CashierAddonInfoBottomSheetDialog.init():void");
    }

    private final void MyBillsEntityDataFactory(String p0) {
        Context context;
        CircleImageView circleImageView = (CircleImageView) PlaceComponentResult(R.id.JvmProtoBuf$JvmPropertySignature$Builder);
        if (circleImageView == null || (context = getContext()) == null) {
            return;
        }
        GlideApp.getAuthRequestContext(context).PlaceComponentResult(p0).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext).getErrorConfigVersion((int) R.drawable.ic_no_image_state).PlaceComponentResult((int) R.drawable.ic_no_image_state).MyBillsEntityDataFactory((ImageView) circleImageView);
    }

    public static /* synthetic */ void getAuthRequestContext(CashierAddonInfoBottomSheetDialog cashierAddonInfoBottomSheetDialog) {
        Intrinsics.checkNotNullParameter(cashierAddonInfoBottomSheetDialog, "");
        cashierAddonInfoBottomSheetDialog.dismiss();
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    /* renamed from: getBottomSheet */
    public final /* synthetic */ View getPlaceComponentResult() {
        return (FrameLayout) PlaceComponentResult(R.id.flCashierAddonInfo);
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
