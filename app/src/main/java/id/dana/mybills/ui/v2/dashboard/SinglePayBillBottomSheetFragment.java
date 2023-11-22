package id.dana.mybills.ui.v2.dashboard;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroupKt;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.view.HasDefaultViewModelProviderFactory;
import androidx.view.NavController;
import androidx.view.NavDirections;
import androidx.view.NavOptions;
import androidx.view.ViewModelKt;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import androidx.view.fragment.FragmentKt;
import androidx.view.viewmodel.CreationExtras;
import androidx.viewbinding.ViewBinding;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.mobile.rome.syncsdk.transport.connection.d;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.customtoastcomponent.CustomToast;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.data.util.DateTimeUtil;
import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.mybills.R;
import id.dana.mybills.danah5.BillerPortalBridge;
import id.dana.mybills.data.model.request.UpdateSubscriptionRequest;
import id.dana.mybills.data.model.response.DeleteSubscriptionResult;
import id.dana.mybills.data.model.response.ExtInfo;
import id.dana.mybills.databinding.FragmentSinglePayBillBottomSheetBinding;
import id.dana.mybills.databinding.ViewHeaderDetailBillsBinding;
import id.dana.mybills.di.component.MyBillsComponent;
import id.dana.mybills.di.module.ViewModelFactory;
import id.dana.mybills.domain.interactor.DeleteSubscriptionBill;
import id.dana.mybills.domain.interactor.GetHighlightPayTransaction;
import id.dana.mybills.domain.model.BizProductDestination;
import id.dana.mybills.domain.model.HighlightTransactionPay;
import id.dana.mybills.domain.model.HighlightTransactionPayKt;
import id.dana.mybills.tracker.MyBillsAnalyticTracker;
import id.dana.mybills.ui.constant.GoodsType;
import id.dana.mybills.ui.constant.MyBillsPurposeAction;
import id.dana.mybills.ui.customview.BodySinglePayView;
import id.dana.mybills.ui.customview.CustomBillDetailTextView;
import id.dana.mybills.ui.customview.CustomDropdownView;
import id.dana.mybills.ui.customview.MyBillsToolbarView;
import id.dana.mybills.ui.model.BillPaymentStatusModel;
import id.dana.mybills.ui.model.BillPaymentStatusModelKt;
import id.dana.mybills.ui.model.BizProductModel;
import id.dana.mybills.ui.model.DropdownOptionsModel;
import id.dana.mybills.ui.model.HighlightTransactionPayRequestModel;
import id.dana.mybills.ui.model.HighlightTransactionPayRequestModelKt;
import id.dana.mybills.ui.model.MoneyViewModel;
import id.dana.mybills.ui.v2.MyBillsHomeActivity;
import id.dana.mybills.ui.v2.MyBillsUiState;
import id.dana.mybills.ui.v2.MyBillsViewModel;
import id.dana.mybills.ui.v2.addnewbills.AddNewBillsViewModel;
import id.dana.mybills.ui.v2.addnewbills.services.BaseMyBillsBottomSheet;
import id.dana.mybills.ui.v2.dashboard.SinglePayBillBottomSheetFragmentDirections;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.utils.danah5.DanaH5Facade;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 A2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001AB\u0007¢\u0006\u0004\b@\u0010\u0014J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0019\u0010\u0017J\u0019\u0010\u001c\u001a\u00020\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001e\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001f\u0010\u0014J\u0017\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020 H\u0007¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0015H\u0002¢\u0006\u0004\b%\u0010&J\u0015\u0010\u0010\u001a\u00020(*\u0004\u0018\u00010'H\u0002¢\u0006\u0004\b\u0010\u0010)R\u0018\u0010+\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0012\u0010.\u001a\u00020-X\u0087\"¢\u0006\u0006\n\u0004\b.\u0010/R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u000201008\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0019\u00102R\u0012\u00104\u001a\u000203X\u0087\"¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010\u0010\u001a\u0002068\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u0018\u00107R\u0012\u00109\u001a\u000208X\u0087\"¢\u0006\u0006\n\u0004\b9\u0010:R\u0013\u0010\u0013\u001a\u00020;X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010<R\u0013\u0010?\u001a\u00020=X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b>\u0010<"}, d2 = {"Lid/dana/mybills/ui/v2/dashboard/SinglePayBillBottomSheetFragment;", "Lid/dana/mybills/ui/v2/addnewbills/services/BaseMyBillsBottomSheet;", "Lid/dana/mybills/databinding/FragmentSinglePayBillBottomSheetBinding;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "scheduleImpl", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "Lid/dana/mybills/databinding/ViewHeaderDetailBillsBinding;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "()Lid/dana/mybills/databinding/ViewHeaderDetailBillsBinding;", "Landroidx/core/widget/NestedScrollView;", "moveToNextValue", "()Landroidx/core/widget/NestedScrollView;", "Lid/dana/mybills/ui/customview/MyBillsToolbarView;", "GetContactSyncConfig", "()Lid/dana/mybills/ui/customview/MyBillsToolbarView;", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/view/View;", "", "getAuthRequestContext", "()V", "", "NetworkUserEntityData$$ExternalSyntheticLambda1", "()Z", "DatabaseTableConfigUtil", "initRecordTimeStamp", "Landroid/os/Bundle;", "p0", "onActivityCreated", "(Landroid/os/Bundle;)V", "onCreate", "onDestroy", "Lid/dana/mybills/danah5/BillerPortalBridge$Event;", "event", "", "onDigitalVoucherReceived", "(Lid/dana/mybills/danah5/BillerPortalBridge$Event;)Ljava/lang/Object;", "BuiltInFictitiousFunctionClassFactory", "(Z)V", "Lid/dana/domain/nearbyme/model/MoneyView;", "Lid/dana/mybills/ui/model/MoneyViewModel;", "(Lid/dana/domain/nearbyme/model/MoneyView;)Lid/dana/mybills/ui/model/MoneyViewModel;", "Lid/dana/mybills/ui/model/BillPaymentStatusModel;", "MyBillsEntityDataFactory", "Lid/dana/mybills/ui/model/BillPaymentStatusModel;", "Lid/dana/utils/danah5/DanaH5Facade;", "danaH5Facade", "Lid/dana/utils/danah5/DanaH5Facade;", "", "Lid/dana/mybills/ui/model/DropdownOptionsModel;", "Ljava/util/List;", "Lid/dana/mybills/tracker/MyBillsAnalyticTracker;", "myBillsAnalyticTracker", "Lid/dana/mybills/tracker/MyBillsAnalyticTracker;", "Lid/dana/mybills/di/component/MyBillsComponent;", "Lid/dana/mybills/di/component/MyBillsComponent;", "Lid/dana/mybills/di/module/ViewModelFactory;", "viewModelFactory", "Lid/dana/mybills/di/module/ViewModelFactory;", "Lid/dana/mybills/ui/v2/MyBillsViewModel;", "Lkotlin/Lazy;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsViewModel;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "PlaceComponentResult", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SinglePayBillBottomSheetFragment extends BaseMyBillsBottomSheet<FragmentSinglePayBillBottomSheetBinding> {

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private MyBillsComponent KClassImpl$Data$declaredNonStaticMembers$2;
    private BillPaymentStatusModel MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult;
    @Inject
    public DanaH5Facade danaH5Facade;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private List<DropdownOptionsModel> BuiltInFictitiousFunctionClassFactory;
    @Inject
    public MyBillsAnalyticTracker myBillsAnalyticTracker;
    @Inject
    public ViewModelFactory viewModelFactory;
    public static final byte[] $$a = {75, -23, 102, -23, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 43;
    public static final byte[] PlaceComponentResult = {10, Byte.MIN_VALUE, TarHeader.LF_LINK, 76, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 122;

    private static void a(byte b, int i, short s, Object[] objArr) {
        int i2 = 19 - (b * 15);
        int i3 = (s * 4) + 16;
        byte[] bArr = PlaceComponentResult;
        int i4 = 106 - i;
        byte[] bArr2 = new byte[i3];
        int i5 = i3 - 1;
        int i6 = 0;
        if (bArr == null) {
            i2++;
            i4 = i4 + i2 + 2;
        }
        while (true) {
            bArr2[i6] = (byte) i4;
            if (i6 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i6++;
            byte b2 = bArr[i2];
            i2++;
            i4 = i4 + b2 + 2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002a -> B:23:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r6, int r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 2
            int r6 = 75 - r6
            int r7 = r7 * 3
            int r7 = r7 + 42
            byte[] r0 = id.dana.mybills.ui.v2.dashboard.SinglePayBillBottomSheetFragment.$$a
            int r8 = r8 * 3
            int r8 = r8 + 4
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1c
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L37
        L1c:
            r3 = 0
        L1d:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r7) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            r4 = r0[r8]
            int r3 = r3 + 1
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
            int r9 = r9 + 1
            int r7 = r7 + r6
            int r6 = r7 + (-7)
            r7 = r8
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ui.v2.dashboard.SinglePayBillBottomSheetFragment.b(byte, int, byte, java.lang.Object[]):void");
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(SinglePayBillBottomSheetFragment singlePayBillBottomSheetFragment, String str) {
        Intrinsics.checkNotNullParameter(str, "");
        CustomToast customToast = CustomToast.MyBillsEntityDataFactory;
        FragmentActivity requireActivity = singlePayBillBottomSheetFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "");
        CustomToast.MyBillsEntityDataFactory(requireActivity, R.drawable.NetworkUserEntityData$$ExternalSyntheticLambda0, R.drawable.PlaceComponentResult, str);
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final /* synthetic */ ViewBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentSinglePayBillBottomSheetBinding MyBillsEntityDataFactory = FragmentSinglePayBillBottomSheetBinding.MyBillsEntityDataFactory(getLayoutInflater(), viewGroup);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    /* JADX WARN: Code restructure failed: missing block: B:316:0x0321, code lost:
    
        if (r7 != null) goto L318;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:333:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x0371  */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v7, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v9, types: [id.dana.mybills.tracker.MyBillsAnalyticTracker] */
    @Override // id.dana.mybills.ui.v2.addnewbills.services.BaseMyBillsBottomSheet, id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getAuthRequestContext() {
        /*
            Method dump skipped, instructions count: 1268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ui.v2.dashboard.SinglePayBillBottomSheetFragment.getAuthRequestContext():void");
    }

    private static MoneyViewModel KClassImpl$Data$declaredNonStaticMembers$2(MoneyView moneyView) {
        MoneyViewModel moneyViewModel;
        return (moneyView == null || (moneyViewModel = BillPaymentStatusModelKt.toMoneyViewModel(moneyView)) == null) ? new MoneyViewModel("0", "Rp.", null, 4, null) : moneyViewModel;
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
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getFadingEdgeLength() >> 16), (ViewConfiguration.getWindowTouchSlop() >> 8) + 4, (char) TextUtils.indexOf("", ""));
                    byte b5 = (byte) ($$a[35] - 1);
                    byte b6 = b5;
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + PDF417Common.NUMBER_OF_CODEWORDS, 36 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) (Process.getGidForName("") + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-1455439369, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0', 0), 18 - TextUtils.indexOf("", "", 0), (char) Color.red(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                if (EventBus.getDefault().isRegistered(this)) {
                    return;
                }
                EventBus.getDefault().register(this);
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

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final Object onDigitalVoucherReceived(BillerPortalBridge.Event event) {
        BillPaymentStatusModel billPaymentStatusModel;
        ExtInfo extInfo;
        ExtInfo extInfo2;
        Intrinsics.checkNotNullParameter(event, "");
        if (Intrinsics.areEqual(event.getName(), BillerPortalBridge.Event.BILL_EDIT)) {
            BizProductModel bizProductModel = event.getInfoParsed().toBizProductModel();
            BillPaymentStatusModel billPaymentStatusModel2 = this.MyBillsEntityDataFactory;
            String str = null;
            ExtInfo extInfo3 = billPaymentStatusModel2 != null ? billPaymentStatusModel2.getExtInfo() : null;
            BillPaymentStatusModel billPaymentStatusModel3 = this.MyBillsEntityDataFactory;
            if (billPaymentStatusModel3 != null) {
                String goodsId = bizProductModel.getGoodsId();
                String goodsType = bizProductModel.getGoodsType();
                if (extInfo3 == null || (extInfo2 = ExtInfo.copy$default(extInfo3, null, null, null, String.valueOf(bizProductModel.getExtendInfo().get(BillerPortalBridge.Event.Info.KEY_QUERY_URL_PROVIDER)), String.valueOf(bizProductModel.getExtendInfo().get(BillerPortalBridge.Event.Info.KEY_BILLER_DENOM_TEXT)), 7, null)) == null) {
                    extInfo2 = new ExtInfo(null, null, null, null, null, 31, null);
                }
                billPaymentStatusModel = billPaymentStatusModel3.copy((r43 & 1) != 0 ? billPaymentStatusModel3.subscriptionId : null, (r43 & 2) != 0 ? billPaymentStatusModel3.actionRedirectUrl : null, (r43 & 4) != 0 ? billPaymentStatusModel3.billId : null, (r43 & 8) != 0 ? billPaymentStatusModel3.canBePaid : null, (r43 & 16) != 0 ? billPaymentStatusModel3.goodsType : goodsType, (r43 & 32) != 0 ? billPaymentStatusModel3.iconUrl : null, (r43 & 64) != 0 ? billPaymentStatusModel3.nextScheduleTime : null, (r43 & 128) != 0 ? billPaymentStatusModel3.nextScheduleDaysCount : null, (r43 & 256) != 0 ? billPaymentStatusModel3.subscriptionTitle : null, (r43 & 512) != 0 ? billPaymentStatusModel3.totalAmount : null, (r43 & 1024) != 0 ? billPaymentStatusModel3.paidAmount : null, (r43 & 2048) != 0 ? billPaymentStatusModel3.recurringType : null, (r43 & 4096) != 0 ? billPaymentStatusModel3.goodsId : goodsId, (r43 & 8192) != 0 ? billPaymentStatusModel3.canInquiry : null, (r43 & 16384) != 0 ? billPaymentStatusModel3.payStatus : null, (r43 & 32768) != 0 ? billPaymentStatusModel3.section : null, (r43 & 65536) != 0 ? billPaymentStatusModel3.bizProductDestination : null, (r43 & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? billPaymentStatusModel3.gmtDueDate : null, (r43 & 262144) != 0 ? billPaymentStatusModel3.paidStatus : null, (r43 & 524288) != 0 ? billPaymentStatusModel3.status : null, (r43 & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? billPaymentStatusModel3.extInfo : extInfo2, (r43 & 2097152) != 0 ? billPaymentStatusModel3.paymentMethod : null, (r43 & 4194304) != 0 ? billPaymentStatusModel3.isSelected : false, (r43 & 8388608) != 0 ? billPaymentStatusModel3.viewType : 0, (r43 & 16777216) != 0 ? billPaymentStatusModel3.lastPayStatus : null);
            } else {
                billPaymentStatusModel = null;
            }
            this.MyBillsEntityDataFactory = billPaymentStatusModel;
            VB vb = this.MyBillsEntityDataFactory;
            if (vb != 0) {
                BodySinglePayView bodySinglePayView = ((FragmentSinglePayBillBottomSheetBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda1;
                bodySinglePayView.getDropdownBillAmount().setHintDropdown(bizProductModel.getDenom().getDisplayAmount());
                CustomDropdownView dropdownProduct = bodySinglePayView.getDropdownProduct();
                BillPaymentStatusModel billPaymentStatusModel4 = this.MyBillsEntityDataFactory;
                if (billPaymentStatusModel4 != null && billPaymentStatusModel4.isDigitalVoucher()) {
                    BillPaymentStatusModel billPaymentStatusModel5 = this.MyBillsEntityDataFactory;
                    if (billPaymentStatusModel5 != null && (extInfo = billPaymentStatusModel5.getExtInfo()) != null) {
                        str = extInfo.getBillerDenomText();
                    }
                } else {
                    str = bizProductModel.getGoodsTitle();
                }
                dropdownProduct.resetDropdown();
                List<DropdownOptionsModel> listOf = CollectionsKt.listOf(new DropdownOptionsModel(str, bizProductModel.getDenom().getDisplayAmount(), bizProductModel.getGoodsId(), bizProductModel.getDenom(), null, 16, null));
                dropdownProduct.setOptions(listOf);
                dropdownProduct.setSelected((DropdownOptionsModel) CollectionsKt.first((List) listOf));
                CustomBillDetailTextView customBillDetailTextView = (CustomBillDetailTextView) SequencesKt.firstOrNull(SequencesKt.map(SequencesKt.filterIndexed(ViewGroupKt.BuiltInFictitiousFunctionClassFactory(bodySinglePayView.getLlBillDetail()), new Function2<Integer, View, Boolean>() { // from class: id.dana.mybills.ui.v2.dashboard.SinglePayBillBottomSheetFragment$onDigitalVoucherReceived$1$1$2
                    public static final byte[] $$a = {2, -87, 98, TarHeader.LF_FIFO, 4, TarHeader.LF_DIR, -55, 2, -14, 12, TarHeader.LF_SYMLINK, -64, -13, 22, -8, -4, -1, -8, 68, -72, 11, 58, -54, -19, 1, -2, 4, 1, -10, 12, 3, -19, 72, -22, -51, 1, -2, 4, 1, 42, -40, -4, -1, 39, -34, -16, 18, -9, -4, Ascii.ETB, -18, -20, 3, Ascii.GS, -20, 3, -19};
                    public static final int $$b = 192;

                    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
                    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002e -> B:11:0x0039). Please submit an issue!!! */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    private static void a(short r6, short r7, short r8, java.lang.Object[] r9) {
                        /*
                            int r6 = r6 + 4
                            int r7 = r7 * 4
                            int r7 = r7 + 54
                            byte[] r0 = id.dana.mybills.ui.v2.dashboard.SinglePayBillBottomSheetFragment$onDigitalVoucherReceived$1$1$2.$$a
                            int r8 = r8 * 2
                            int r8 = r8 + 105
                            byte[] r1 = new byte[r7]
                            int r7 = r7 + (-1)
                            r2 = 0
                            if (r0 != 0) goto L1a
                            r3 = r1
                            r4 = 0
                            r1 = r0
                            r0 = r9
                            r9 = r7
                            r7 = r6
                            goto L39
                        L1a:
                            r3 = 0
                            r5 = r7
                            r7 = r6
                            r6 = r8
                            r8 = r5
                        L1f:
                            byte r4 = (byte) r6
                            r1[r3] = r4
                            int r7 = r7 + 1
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
                            int r6 = r6 + (-1)
                            r8 = r9
                            r9 = r0
                            r0 = r1
                            r1 = r3
                            r3 = r4
                            goto L1f
                        */
                        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ui.v2.dashboard.SinglePayBillBottomSheetFragment$onDigitalVoucherReceived$1$1$2.a(short, short, short, java.lang.Object[]):void");
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final /* synthetic */ Boolean invoke(Integer num, View view) {
                        return invoke(num.intValue(), view);
                    }

                    public final Boolean invoke(int i, View view) {
                        Intrinsics.checkNotNullParameter(view, "");
                        boolean z = false;
                        if (i == 4) {
                            byte b = $$a[16];
                            byte b2 = (byte) (b + 1);
                            Object[] objArr = new Object[1];
                            a(b, b2, b2, objArr);
                            if (Class.forName((String) objArr[0]).isInstance(view)) {
                                z = true;
                            }
                        }
                        return Boolean.valueOf(z);
                    }
                }), new Function1<View, CustomBillDetailTextView>() { // from class: id.dana.mybills.ui.v2.dashboard.SinglePayBillBottomSheetFragment$onDigitalVoucherReceived$1$1$3
                    @Override // kotlin.jvm.functions.Function1
                    public final CustomBillDetailTextView invoke(View view) {
                        Intrinsics.checkNotNullParameter(view, "");
                        return (CustomBillDetailTextView) view;
                    }
                }));
                if (customBillDetailTextView != null) {
                    customBillDetailTextView.setDesc(bizProductModel.getDenom().getDisplayAmount());
                }
                Intrinsics.checkNotNullExpressionValue(bodySinglePayView, "");
                return bodySinglePayView;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    @Deprecated(message = "Deprecated in Java")
    public final void onActivityCreated(Bundle p0) {
        ViewParent parent;
        ViewParent parent2;
        super.onActivityCreated(p0);
        View getAuthRequestContext = getGetAuthRequestContext();
        View view = (View) ((getAuthRequestContext == null || (parent = getAuthRequestContext.getParent()) == null || (parent2 = parent.getParent()) == null) ? null : parent2.getParent());
        if (view != null) {
            view.setFitsSystemWindows(false);
        }
    }

    private final boolean DatabaseTableConfigUtil() {
        ExtInfo extInfo;
        BillPaymentStatusModel billPaymentStatusModel = this.MyBillsEntityDataFactory;
        return Intrinsics.areEqual((billPaymentStatusModel == null || (extInfo = billPaymentStatusModel.getExtInfo()) == null) ? null : extInfo.getType(), GoodsType.MOBILE_DATA);
    }

    private final boolean NetworkUserEntityData$$ExternalSyntheticLambda1() {
        BillPaymentStatusModel billPaymentStatusModel = this.MyBillsEntityDataFactory;
        if (!Intrinsics.areEqual(billPaymentStatusModel != null ? billPaymentStatusModel.getGoodsType() : null, "GN_MERCHANT")) {
            BillPaymentStatusModel billPaymentStatusModel2 = this.MyBillsEntityDataFactory;
            if (!Intrinsics.areEqual(billPaymentStatusModel2 != null ? billPaymentStatusModel2.getGoodsType() : null, "EXTERNAL_MERCHANT")) {
                return false;
            }
        }
        return true;
    }

    public final boolean initRecordTimeStamp() {
        ExtInfo extInfo;
        ExtInfo extInfo2;
        BillPaymentStatusModel billPaymentStatusModel = this.MyBillsEntityDataFactory;
        String str = null;
        if (!Intrinsics.areEqual(billPaymentStatusModel != null ? billPaymentStatusModel.getGoodsType() : null, "ELECTRICITY")) {
            BillPaymentStatusModel billPaymentStatusModel2 = this.MyBillsEntityDataFactory;
            if (!Intrinsics.areEqual((billPaymentStatusModel2 == null || (extInfo2 = billPaymentStatusModel2.getExtInfo()) == null) ? null : extInfo2.getType(), GoodsType.MOBILE_CREDIT)) {
                BillPaymentStatusModel billPaymentStatusModel3 = this.MyBillsEntityDataFactory;
                if (billPaymentStatusModel3 != null && (extInfo = billPaymentStatusModel3.getExtInfo()) != null) {
                    str = extInfo.getType();
                }
                if (!Intrinsics.areEqual(str, GoodsType.MOBILE_DATA)) {
                    return false;
                }
            }
        }
        return true;
    }

    public SinglePayBillBottomSheetFragment() {
        final SinglePayBillBottomSheetFragment singlePayBillBottomSheetFragment = this;
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: id.dana.mybills.ui.v2.dashboard.SinglePayBillBottomSheetFragment$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelFactory viewModelFactory = SinglePayBillBottomSheetFragment.this.viewModelFactory;
                if (viewModelFactory == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    viewModelFactory = null;
                }
                return viewModelFactory;
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: id.dana.mybills.ui.v2.dashboard.SinglePayBillBottomSheetFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: id.dana.mybills.ui.v2.dashboard.SinglePayBillBottomSheetFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) Function0.this.invoke();
            }
        });
        final Function0 function03 = null;
        this.getAuthRequestContext = FragmentViewModelLazyKt.BuiltInFictitiousFunctionClassFactory(singlePayBillBottomSheetFragment, Reflection.getOrCreateKotlinClass(MyBillsViewModel.class), new Function0<ViewModelStore>() { // from class: id.dana.mybills.ui.v2.dashboard.SinglePayBillBottomSheetFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = FragmentViewModelLazyKt.PlaceComponentResult(Lazy.this).getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: id.dana.mybills.ui.v2.dashboard.SinglePayBillBottomSheetFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function04 = Function0.this;
                if (function04 == null || (creationExtras = (CreationExtras) function04.invoke()) == null) {
                    ViewModelStoreOwner PlaceComponentResult2 = FragmentViewModelLazyKt.PlaceComponentResult(lazy);
                    HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = PlaceComponentResult2 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) PlaceComponentResult2 : null;
                    CreationExtras defaultViewModelCreationExtras = hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : null;
                    return defaultViewModelCreationExtras == null ? CreationExtras.Empty.INSTANCE : defaultViewModelCreationExtras;
                }
                return creationExtras;
            }
        }, function0);
        Function0<ViewModelProvider.Factory> function04 = new Function0<ViewModelProvider.Factory>() { // from class: id.dana.mybills.ui.v2.dashboard.SinglePayBillBottomSheetFragment$vmAddNewBills$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelFactory viewModelFactory = SinglePayBillBottomSheetFragment.this.viewModelFactory;
                if (viewModelFactory == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    viewModelFactory = null;
                }
                return viewModelFactory;
            }
        };
        final Function0<Fragment> function05 = new Function0<Fragment>() { // from class: id.dana.mybills.ui.v2.dashboard.SinglePayBillBottomSheetFragment$special$$inlined$viewModels$default$6
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Lazy lazy2 = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: id.dana.mybills.ui.v2.dashboard.SinglePayBillBottomSheetFragment$special$$inlined$viewModels$default$7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) Function0.this.invoke();
            }
        });
        this.PlaceComponentResult = FragmentViewModelLazyKt.BuiltInFictitiousFunctionClassFactory(singlePayBillBottomSheetFragment, Reflection.getOrCreateKotlinClass(AddNewBillsViewModel.class), new Function0<ViewModelStore>() { // from class: id.dana.mybills.ui.v2.dashboard.SinglePayBillBottomSheetFragment$special$$inlined$viewModels$default$8
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = FragmentViewModelLazyKt.PlaceComponentResult(Lazy.this).getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: id.dana.mybills.ui.v2.dashboard.SinglePayBillBottomSheetFragment$special$$inlined$viewModels$default$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function06 = Function0.this;
                if (function06 == null || (creationExtras = (CreationExtras) function06.invoke()) == null) {
                    ViewModelStoreOwner PlaceComponentResult2 = FragmentViewModelLazyKt.PlaceComponentResult(lazy2);
                    HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = PlaceComponentResult2 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) PlaceComponentResult2 : null;
                    CreationExtras defaultViewModelCreationExtras = hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : null;
                    return defaultViewModelCreationExtras == null ? CreationExtras.Empty.INSTANCE : defaultViewModelCreationExtras;
                }
                return creationExtras;
            }
        }, function04);
        this.BuiltInFictitiousFunctionClassFactory = CollectionsKt.emptyList();
    }

    public static /* synthetic */ void getAuthRequestContext(SinglePayBillBottomSheetFragment singlePayBillBottomSheetFragment) {
        Intrinsics.checkNotNullParameter(singlePayBillBottomSheetFragment, "");
        FragmentKt.getAuthRequestContext(singlePayBillBottomSheetFragment).moveToNextValue();
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(final SinglePayBillBottomSheetFragment singlePayBillBottomSheetFragment) {
        Intrinsics.checkNotNullParameter(singlePayBillBottomSheetFragment, "");
        Context requireContext = singlePayBillBottomSheetFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "");
        CustomDialog.Builder builder = new CustomDialog.Builder(requireContext);
        builder.SubSequence = singlePayBillBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda1() ? singlePayBillBottomSheetFragment.getString(R.string.my_bills_delete_bills_dialog_confirmation_title_gn) : singlePayBillBottomSheetFragment.getString(R.string.my_bills_delete_bills_dialog_confirmation_title);
        builder.GetContactSyncConfig = singlePayBillBottomSheetFragment.NetworkUserEntityData$$ExternalSyntheticLambda1() ? singlePayBillBottomSheetFragment.getString(R.string.my_bills_delete_bills_dialog_confirmation_title_description_gn) : singlePayBillBottomSheetFragment.getString(R.string.my_bills_delete_bills_dialog_confirmation_title_description);
        CustomDialog.Builder PlaceComponentResult2 = builder.KClassImpl$Data$declaredNonStaticMembers$2(singlePayBillBottomSheetFragment.getString(R.string.my_bills_delete_bills_dialog_confirmation_title_left_btn), new Function1<View, Unit>() { // from class: id.dana.mybills.ui.v2.dashboard.SinglePayBillBottomSheetFragment$initButtonDeleteClickListener$1$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }
        }).BuiltInFictitiousFunctionClassFactory(singlePayBillBottomSheetFragment.getString(R.string.my_bills_delete_bills_dialog_confirmation_title_right_btn), new Function1<View, Unit>() { // from class: id.dana.mybills.ui.v2.dashboard.SinglePayBillBottomSheetFragment$initButtonDeleteClickListener$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                BillPaymentStatusModel billPaymentStatusModel;
                Intrinsics.checkNotNullParameter(view, "");
                final MyBillsViewModel moveToNextValue = SinglePayBillBottomSheetFragment.moveToNextValue(SinglePayBillBottomSheetFragment.this);
                billPaymentStatusModel = SinglePayBillBottomSheetFragment.this.MyBillsEntityDataFactory;
                String subscriptionId = billPaymentStatusModel != null ? billPaymentStatusModel.getSubscriptionId() : null;
                if (subscriptionId == null) {
                    subscriptionId = "";
                }
                Intrinsics.checkNotNullParameter(subscriptionId, "");
                Intrinsics.checkNotNullParameter("", "");
                MutableStateFlow<MyBillsUiState> mutableStateFlow = moveToNextValue.scheduleImpl;
                do {
                } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), MyBillsUiState.Loading.INSTANCE));
                BaseFlowUseCase.execute$default(moveToNextValue.lookAheadTest, new DeleteSubscriptionBill.Params(subscriptionId, ""), null, new Function1<DeleteSubscriptionResult, Unit>() { // from class: id.dana.mybills.ui.v2.MyBillsViewModel$deleteSubscription$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(DeleteSubscriptionResult deleteSubscriptionResult) {
                        invoke2(deleteSubscriptionResult);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(DeleteSubscriptionResult deleteSubscriptionResult) {
                        MutableStateFlow mutableStateFlow2;
                        Object value;
                        MutableStateFlow mutableStateFlow3;
                        Object value2;
                        Intrinsics.checkNotNullParameter(deleteSubscriptionResult, "");
                        mutableStateFlow2 = MyBillsViewModel.this.scheduleImpl;
                        do {
                            value = mutableStateFlow2.getValue();
                            MyBillsUiState myBillsUiState = (MyBillsUiState) value;
                        } while (!mutableStateFlow2.compareAndSet(value, MyBillsUiState.None.INSTANCE));
                        mutableStateFlow3 = MyBillsViewModel.this.scheduleImpl;
                        do {
                            value2 = mutableStateFlow3.getValue();
                            MyBillsUiState myBillsUiState2 = (MyBillsUiState) value2;
                        } while (!mutableStateFlow3.compareAndSet(value2, new MyBillsUiState.OnSuccessDeleteSubscriptionBill(deleteSubscriptionResult)));
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.mybills.ui.v2.MyBillsViewModel$deleteSubscription$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        MutableStateFlow mutableStateFlow2;
                        Object value;
                        Intrinsics.checkNotNullParameter(th, "");
                        mutableStateFlow2 = MyBillsViewModel.this.scheduleImpl;
                        do {
                            value = mutableStateFlow2.getValue();
                            MyBillsUiState myBillsUiState = (MyBillsUiState) value;
                        } while (!mutableStateFlow2.compareAndSet(value, MyBillsUiState.None.INSTANCE));
                    }
                }, null, ViewModelKt.PlaceComponentResult(moveToNextValue), 18, null);
                SinglePayBillBottomSheetFragment.getAuthRequestContext(SinglePayBillBottomSheetFragment.this, MyBillsPurposeAction.DELETE);
            }
        }).KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false);
        PlaceComponentResult2.moveToNextValue = 0L;
        PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory().show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r3v1, types: [id.dana.mybills.tracker.MyBillsAnalyticTracker] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public static /* synthetic */ void PlaceComponentResult(SinglePayBillBottomSheetFragment singlePayBillBottomSheetFragment) {
        HighlightTransactionPayRequestModel highlightTransactionPayRequestModel;
        MoneyViewModel moneyViewModel;
        MoneyView baseAmount;
        MoneyView adminFee;
        Intrinsics.checkNotNullParameter(singlePayBillBottomSheetFragment, "");
        BillPaymentStatusModel billPaymentStatusModel = singlePayBillBottomSheetFragment.MyBillsEntityDataFactory;
        boolean z = false;
        ?? r3 = 0;
        if (billPaymentStatusModel != null) {
            String subscriptionId = billPaymentStatusModel.getSubscriptionId();
            String str = subscriptionId == null ? "" : subscriptionId;
            if (billPaymentStatusModel.getTotalAmount() != null) {
                if (billPaymentStatusModel.getTotalAmount().getAmount().length() > 0) {
                    moneyViewModel = billPaymentStatusModel.getTotalAmount();
                    BizProductDestination bizProductDestination = billPaymentStatusModel.getBizProductDestination();
                    MoneyViewModel KClassImpl$Data$declaredNonStaticMembers$22 = (bizProductDestination != null || (adminFee = bizProductDestination.getAdminFee()) == null) ? null : KClassImpl$Data$declaredNonStaticMembers$2(adminFee);
                    BizProductDestination bizProductDestination2 = billPaymentStatusModel.getBizProductDestination();
                    highlightTransactionPayRequestModel = new HighlightTransactionPayRequestModel(str, moneyViewModel, "DIRECT", KClassImpl$Data$declaredNonStaticMembers$22, (bizProductDestination2 != null || (baseAmount = bizProductDestination2.getBaseAmount()) == null) ? null : KClassImpl$Data$declaredNonStaticMembers$2(baseAmount));
                }
            }
            moneyViewModel = new MoneyViewModel("0", "Rp", null, 4, null);
            BizProductDestination bizProductDestination3 = billPaymentStatusModel.getBizProductDestination();
            if (bizProductDestination3 != null) {
            }
            BizProductDestination bizProductDestination22 = billPaymentStatusModel.getBizProductDestination();
            highlightTransactionPayRequestModel = new HighlightTransactionPayRequestModel(str, moneyViewModel, "DIRECT", KClassImpl$Data$declaredNonStaticMembers$22, (bizProductDestination22 != null || (baseAmount = bizProductDestination22.getBaseAmount()) == null) ? null : KClassImpl$Data$declaredNonStaticMembers$2(baseAmount));
        } else {
            highlightTransactionPayRequestModel = null;
        }
        if (highlightTransactionPayRequestModel != null) {
            final MyBillsViewModel myBillsViewModel = (MyBillsViewModel) singlePayBillBottomSheetFragment.getAuthRequestContext.getValue();
            Intrinsics.checkNotNullParameter(highlightTransactionPayRequestModel, "");
            BaseFlowUseCase.execute$default(myBillsViewModel.GetContactSyncConfig, new GetHighlightPayTransaction.Params(CollectionsKt.listOf(HighlightTransactionPayRequestModelKt.toHighlightTransactionPayRequest(highlightTransactionPayRequestModel)), z, 2, r3), null, new Function1<List<? extends HighlightTransactionPay>, Unit>() { // from class: id.dana.mybills.ui.v2.MyBillsViewModel$getHighlightPayTransaction$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(List<? extends HighlightTransactionPay> list) {
                    invoke2((List<HighlightTransactionPay>) list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(List<HighlightTransactionPay> list) {
                    MutableStateFlow mutableStateFlow;
                    Object value;
                    Intrinsics.checkNotNullParameter(list, "");
                    mutableStateFlow = MyBillsViewModel.this.scheduleImpl;
                    do {
                        value = mutableStateFlow.getValue();
                        MyBillsUiState myBillsUiState = (MyBillsUiState) value;
                    } while (!mutableStateFlow.compareAndSet(value, new MyBillsUiState.OnSuccessGetPayTransaction(HighlightTransactionPayKt.toHighlighTransactionPayModel((HighlightTransactionPay) CollectionsKt.first((List) list)))));
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.mybills.ui.v2.MyBillsViewModel$getHighlightPayTransaction$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    MutableStateFlow mutableStateFlow;
                    Object value;
                    Intrinsics.checkNotNullParameter(th, "");
                    mutableStateFlow = MyBillsViewModel.this.scheduleImpl;
                    do {
                        value = mutableStateFlow.getValue();
                        MyBillsUiState myBillsUiState = (MyBillsUiState) value;
                    } while (!mutableStateFlow.compareAndSet(value, MyBillsUiState.OnErrorGetPayTransaction.INSTANCE));
                }
            }, null, ViewModelKt.PlaceComponentResult(myBillsViewModel), 18, null);
            MyBillsAnalyticTracker myBillsAnalyticTracker = singlePayBillBottomSheetFragment.myBillsAnalyticTracker;
            if (myBillsAnalyticTracker != null) {
                r3 = myBillsAnalyticTracker;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            r3.MyBillsEntityDataFactory(MyBillsPurposeAction.PAY);
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(SinglePayBillBottomSheetFragment singlePayBillBottomSheetFragment) {
        Intrinsics.checkNotNullParameter(singlePayBillBottomSheetFragment, "");
        FragmentKt.getAuthRequestContext(singlePayBillBottomSheetFragment).KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(FragmentSinglePayBillBottomSheetBinding fragmentSinglePayBillBottomSheetBinding, NestedScrollView nestedScrollView) {
        Intrinsics.checkNotNullParameter(fragmentSinglePayBillBottomSheetBinding, "");
        Intrinsics.checkNotNullParameter(nestedScrollView, "");
        fragmentSinglePayBillBottomSheetBinding.NetworkUserEntityData$$ExternalSyntheticLambda1.getDropdownProduct().closeDropDownButton();
        fragmentSinglePayBillBottomSheetBinding.NetworkUserEntityData$$ExternalSyntheticLambda1.getDropdownBillType().closeDropDownButton();
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(final SinglePayBillBottomSheetFragment singlePayBillBottomSheetFragment) {
        Intrinsics.checkNotNullParameter(singlePayBillBottomSheetFragment, "");
        Context requireContext = singlePayBillBottomSheetFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "");
        CustomDialog.Builder builder = new CustomDialog.Builder(requireContext);
        builder.SubSequence = singlePayBillBottomSheetFragment.getString(R.string.my_bills_edit_bills_save_changes_dialog_confirmation_title);
        builder.GetContactSyncConfig = singlePayBillBottomSheetFragment.getString(R.string.my_bills_edit_bills_save_changes_dialog_confirmation_description);
        CustomDialog.Builder PlaceComponentResult2 = builder.KClassImpl$Data$declaredNonStaticMembers$2(singlePayBillBottomSheetFragment.getString(R.string.my_bills_edit_bills_save_changes_dialog_confirmation_left_btn), new Function1<View, Unit>() { // from class: id.dana.mybills.ui.v2.dashboard.SinglePayBillBottomSheetFragment$initButtonUpdateClickListener$1$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }
        }).BuiltInFictitiousFunctionClassFactory(singlePayBillBottomSheetFragment.getString(R.string.my_bills_edit_bills_save_changes_dialog_confirmation_right_btn), new Function1<View, Unit>() { // from class: id.dana.mybills.ui.v2.dashboard.SinglePayBillBottomSheetFragment$initButtonUpdateClickListener$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                BillPaymentStatusModel billPaymentStatusModel;
                UpdateSubscriptionRequest copy;
                Intrinsics.checkNotNullParameter(view, "");
                VB vb = SinglePayBillBottomSheetFragment.this.MyBillsEntityDataFactory;
                if (vb != 0) {
                    String placeComponentResult = ((FragmentSinglePayBillBottomSheetBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda1.getPlaceComponentResult();
                    VB vb2 = SinglePayBillBottomSheetFragment.this.MyBillsEntityDataFactory;
                    if (vb2 != 0) {
                        String databaseTableConfigUtil = ((FragmentSinglePayBillBottomSheetBinding) vb2).NetworkUserEntityData$$ExternalSyntheticLambda1.getDatabaseTableConfigUtil();
                        VB vb3 = SinglePayBillBottomSheetFragment.this.MyBillsEntityDataFactory;
                        if (vb3 != 0) {
                            int kClassImpl$Data$declaredNonStaticMembers$2 = ((FragmentSinglePayBillBottomSheetBinding) vb3).NetworkUserEntityData$$ExternalSyntheticLambda1.getKClassImpl$Data$declaredNonStaticMembers$2();
                            VB vb4 = SinglePayBillBottomSheetFragment.this.MyBillsEntityDataFactory;
                            if (vb4 != 0) {
                                String scheduleImpl = ((FragmentSinglePayBillBottomSheetBinding) vb4).NetworkUserEntityData$$ExternalSyntheticLambda1.getScheduleImpl();
                                VB vb5 = SinglePayBillBottomSheetFragment.this.MyBillsEntityDataFactory;
                                if (vb5 != 0) {
                                    MoneyViewModel getAuthRequestContext = ((FragmentSinglePayBillBottomSheetBinding) vb5).NetworkUserEntityData$$ExternalSyntheticLambda1.getGetAuthRequestContext();
                                    VB vb6 = SinglePayBillBottomSheetFragment.this.MyBillsEntityDataFactory;
                                    if (vb6 != 0) {
                                        String builtInFictitiousFunctionClassFactory = ((FragmentSinglePayBillBottomSheetBinding) vb6).NetworkUserEntityData$$ExternalSyntheticLambda1.getBuiltInFictitiousFunctionClassFactory();
                                        VB vb7 = SinglePayBillBottomSheetFragment.this.MyBillsEntityDataFactory;
                                        if (vb7 != 0) {
                                            UpdateSubscriptionRequest KClassImpl$Data$declaredNonStaticMembers$22 = SinglePayBillBottomSheetFragment.KClassImpl$Data$declaredNonStaticMembers$2(SinglePayBillBottomSheetFragment.this, placeComponentResult, databaseTableConfigUtil, Integer.valueOf(kClassImpl$Data$declaredNonStaticMembers$2), Integer.valueOf(((FragmentSinglePayBillBottomSheetBinding) vb7).NetworkUserEntityData$$ExternalSyntheticLambda1.getMyBillsEntityDataFactory()), scheduleImpl, getAuthRequestContext, builtInFictitiousFunctionClassFactory);
                                            if (KClassImpl$Data$declaredNonStaticMembers$22 != null) {
                                                SinglePayBillBottomSheetFragment singlePayBillBottomSheetFragment2 = SinglePayBillBottomSheetFragment.this;
                                                billPaymentStatusModel = singlePayBillBottomSheetFragment2.MyBillsEntityDataFactory;
                                                if (Intrinsics.areEqual(billPaymentStatusModel != null ? billPaymentStatusModel.getGoodsType() : null, "GAME_VOUCHER")) {
                                                    MyBillsViewModel moveToNextValue = SinglePayBillBottomSheetFragment.moveToNextValue(singlePayBillBottomSheetFragment2);
                                                    copy = KClassImpl$Data$declaredNonStaticMembers$22.copy((r22 & 1) != 0 ? KClassImpl$Data$declaredNonStaticMembers$22.billerId : null, (r22 & 2) != 0 ? KClassImpl$Data$declaredNonStaticMembers$22.goodsId : null, (r22 & 4) != 0 ? KClassImpl$Data$declaredNonStaticMembers$22.message : null, (r22 & 8) != 0 ? KClassImpl$Data$declaredNonStaticMembers$22.recurringType : null, (r22 & 16) != 0 ? KClassImpl$Data$declaredNonStaticMembers$22.subscriptionDayOfMonth : 0, (r22 & 32) != 0 ? KClassImpl$Data$declaredNonStaticMembers$22.subscriptionHourOfDay : 0, (r22 & 64) != 0 ? KClassImpl$Data$declaredNonStaticMembers$22.subscriptionMonthOfYear : 0, (r22 & 128) != 0 ? KClassImpl$Data$declaredNonStaticMembers$22.subscriptionId : null, (r22 & 256) != 0 ? KClassImpl$Data$declaredNonStaticMembers$22.title : null, (r22 & 512) != 0 ? KClassImpl$Data$declaredNonStaticMembers$22.extendInfo : MapsKt.plus(KClassImpl$Data$declaredNonStaticMembers$22.getExtendInfo(), MapsKt.emptyMap()));
                                                    moveToNextValue.PlaceComponentResult(copy);
                                                } else {
                                                    SinglePayBillBottomSheetFragment.moveToNextValue(singlePayBillBottomSheetFragment2).PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$22);
                                                }
                                                SinglePayBillBottomSheetFragment.getAuthRequestContext(singlePayBillBottomSheetFragment2, MyBillsPurposeAction.SAVE);
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
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }).KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false);
        PlaceComponentResult2.moveToNextValue = 0L;
        PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory().show();
    }

    public static final /* synthetic */ void lookAheadTest(SinglePayBillBottomSheetFragment singlePayBillBottomSheetFragment) {
        VB vb = singlePayBillBottomSheetFragment.MyBillsEntityDataFactory;
        if (vb != 0) {
            BodySinglePayView bodySinglePayView = ((FragmentSinglePayBillBottomSheetBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda1;
            bodySinglePayView.getDropdownProduct().closeDropDownButton();
            bodySinglePayView.getDropdownBillType().closeDropDownButton();
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ UpdateSubscriptionRequest KClassImpl$Data$declaredNonStaticMembers$2(SinglePayBillBottomSheetFragment singlePayBillBottomSheetFragment, String str, String str2, Integer num, Integer num2, String str3, MoneyViewModel moneyViewModel, String str4) {
        String str5;
        String str6;
        String str7;
        BillPaymentStatusModel billPaymentStatusModel = singlePayBillBottomSheetFragment.MyBillsEntityDataFactory;
        if (billPaymentStatusModel != null) {
            DateTimeUtil dateTimeUtil = DateTimeUtil.INSTANCE;
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "");
            Long gmtDueDate = billPaymentStatusModel.getGmtDueDate();
            String dateTimeString = dateTimeUtil.getDateTimeString(d.f7256a, locale, gmtDueDate != null ? gmtDueDate.longValue() : -1L);
            Calendar calendar = Calendar.getInstance();
            Long gmtDueDate2 = billPaymentStatusModel.getGmtDueDate();
            calendar.setTimeInMillis(gmtDueDate2 != null ? gmtDueDate2.longValue() : -1L);
            String billId = billPaymentStatusModel.getBillId();
            String str8 = billId == null ? "" : billId;
            String str9 = str3 == null ? "" : str3;
            if (str == null) {
                String subscriptionTitle = billPaymentStatusModel.getSubscriptionTitle();
                str5 = subscriptionTitle == null ? "" : subscriptionTitle;
            } else {
                str5 = str;
            }
            if (str2 == null) {
                String recurringType = billPaymentStatusModel.getRecurringType();
                str6 = recurringType == null ? "" : recurringType;
            } else {
                str6 = str2;
            }
            int intValue = num != null ? num.intValue() : Integer.parseInt(dateTimeString);
            int intValue2 = num2 != null ? num2.intValue() : calendar.get(2);
            int i = calendar.get(11);
            String subscriptionId = billPaymentStatusModel.getSubscriptionId();
            String str10 = subscriptionId == null ? "" : subscriptionId;
            if (str == null) {
                String subscriptionTitle2 = billPaymentStatusModel.getSubscriptionTitle();
                str7 = subscriptionTitle2 == null ? "" : subscriptionTitle2;
            } else {
                str7 = str;
            }
            Map mutableMap = MapsKt.toMutableMap(BillPaymentStatusModelKt.toMap(billPaymentStatusModel.getExtInfo()));
            MoneyViewModel totalAmount = moneyViewModel == null ? billPaymentStatusModel.getTotalAmount() : moneyViewModel;
            if (totalAmount != null) {
                mutableMap.put(UpdateSubscriptionRequest.KEY_EXTEND_INFO_TOTAL_AMOUNT, totalAmount);
            }
            if (str4 != null) {
                mutableMap.put(UpdateSubscriptionRequest.KEY_EXTEND_INFO_DENOM, new MoneyViewModel(str4, "Rp", null, 4, null));
            }
            return new UpdateSubscriptionRequest(str8, str9, str5, str6, intValue, i, intValue2, str10, str7, mutableMap);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ java.util.List getAuthRequestContext(id.dana.mybills.ui.v2.dashboard.SinglePayBillBottomSheetFragment r14, id.dana.mybills.ui.model.MobileRechargeProductModel r15) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r15 = r15.getPackages()
            if (r15 == 0) goto Le6
            java.lang.Iterable r15 = (java.lang.Iterable) r15
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r15 = r15.iterator()
        L18:
            boolean r2 = r15.hasNext()
            r3 = 0
            if (r2 == 0) goto L42
            java.lang.Object r2 = r15.next()
            r4 = r2
            id.dana.mybills.ui.model.ProviderPackageModel r4 = (id.dana.mybills.ui.model.ProviderPackageModel) r4
            java.lang.String r4 = r4.getType()
            id.dana.mybills.ui.model.BillPaymentStatusModel r5 = r14.MyBillsEntityDataFactory
            if (r5 == 0) goto L38
            id.dana.mybills.data.model.response.ExtInfo r5 = r5.getExtInfo()
            if (r5 == 0) goto L38
            java.lang.String r3 = r5.getType()
        L38:
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r3)
            if (r3 == 0) goto L18
            r1.add(r2)
            goto L18
        L42:
            java.util.List r1 = (java.util.List) r1
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r15 = r1.iterator()
        L4a:
            boolean r1 = r15.hasNext()
            if (r1 == 0) goto Le6
            java.lang.Object r1 = r15.next()
            id.dana.mybills.ui.model.ProviderPackageModel r1 = (id.dana.mybills.ui.model.ProviderPackageModel) r1
            java.util.List r1 = r1.getGoods()
            if (r1 == 0) goto L4a
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r1 = r1.iterator()
        L69:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L86
            java.lang.Object r4 = r1.next()
            r5 = r4
            id.dana.mybills.ui.model.ProductGoodsModel r5 = (id.dana.mybills.ui.model.ProductGoodsModel) r5
            java.lang.Boolean r5 = r5.getAvailable()
            java.lang.Boolean r6 = java.lang.Boolean.TRUE
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
            if (r5 == 0) goto L69
            r2.add(r4)
            goto L69
        L86:
            java.util.List r2 = (java.util.List) r2
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r2 = r2.iterator()
        L95:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto Le2
            java.lang.Object r4 = r2.next()
            id.dana.mybills.ui.model.ProductGoodsModel r4 = (id.dana.mybills.ui.model.ProductGoodsModel) r4
            boolean r5 = r14.DatabaseTableConfigUtil()
            if (r5 == 0) goto Lad
            java.lang.String r5 = r4.getGoodsTitle()
        Lab:
            r7 = r5
            goto Lb9
        Lad:
            id.dana.mybills.ui.model.MoneyViewModel r5 = r4.getDenom()
            if (r5 == 0) goto Lb8
            java.lang.String r5 = r5.getDisplayAmount()
            goto Lab
        Lb8:
            r7 = r3
        Lb9:
            id.dana.mybills.ui.model.MoneyViewModel r5 = r4.getPrice()
            if (r5 == 0) goto Lc5
            java.lang.String r5 = r5.getDisplayAmount()
            r8 = r5
            goto Lc6
        Lc5:
            r8 = r3
        Lc6:
            java.lang.String r9 = r4.getGoodsId()
            id.dana.mybills.ui.model.MoneyViewModel r10 = r4.getPrice()
            id.dana.mybills.ui.model.DropdownOptionsModel r4 = new id.dana.mybills.ui.model.DropdownOptionsModel
            r11 = 0
            r12 = 16
            r13 = 0
            r6 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
            r0.add(r4)
            r4 = r0
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            kotlin.collections.CollectionsKt.addAll(r1, r4)
            goto L95
        Le2:
            java.util.List r1 = (java.util.List) r1
            goto L4a
        Le6:
            java.util.List r0 = (java.util.List) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ui.v2.dashboard.SinglePayBillBottomSheetFragment.getAuthRequestContext(id.dana.mybills.ui.v2.dashboard.SinglePayBillBottomSheetFragment, id.dana.mybills.ui.model.MobileRechargeProductModel):java.util.List");
    }

    public static final /* synthetic */ MyBillsViewModel moveToNextValue(SinglePayBillBottomSheetFragment singlePayBillBottomSheetFragment) {
        return (MyBillsViewModel) singlePayBillBottomSheetFragment.getAuthRequestContext.getValue();
    }

    public static final /* synthetic */ void getErrorConfigVersion(SinglePayBillBottomSheetFragment singlePayBillBottomSheetFragment) {
        FragmentActivity requireActivity = singlePayBillBottomSheetFragment.requireActivity();
        MyBillsHomeActivity myBillsHomeActivity = requireActivity instanceof MyBillsHomeActivity ? (MyBillsHomeActivity) requireActivity : null;
        if (myBillsHomeActivity != null) {
            myBillsHomeActivity.hideBlockerLoading();
        }
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda2(SinglePayBillBottomSheetFragment singlePayBillBottomSheetFragment) {
        VB vb = singlePayBillBottomSheetFragment.MyBillsEntityDataFactory;
        if (vb != 0) {
            ((FragmentSinglePayBillBottomSheetBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda1.mapProducts(singlePayBillBottomSheetFragment.BuiltInFictitiousFunctionClassFactory);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static final /* synthetic */ void PlaceComponentResult(SinglePayBillBottomSheetFragment singlePayBillBottomSheetFragment, String str) {
        SinglePayBillBottomSheetFragment singlePayBillBottomSheetFragment2 = singlePayBillBottomSheetFragment;
        Bundle bundle = new Bundle();
        bundle.putBoolean("need_refresh", true);
        Unit unit = Unit.INSTANCE;
        androidx.fragment.app.FragmentKt.KClassImpl$Data$declaredNonStaticMembers$2(singlePayBillBottomSheetFragment2, str, bundle);
        NavController authRequestContext = FragmentKt.getAuthRequestContext(singlePayBillBottomSheetFragment2);
        SinglePayBillBottomSheetFragmentDirections.Companion companion = SinglePayBillBottomSheetFragmentDirections.INSTANCE;
        NavDirections KClassImpl$Data$declaredNonStaticMembers$22 = SinglePayBillBottomSheetFragmentDirections.Companion.KClassImpl$Data$declaredNonStaticMembers$2();
        Intrinsics.checkNotNullParameter(KClassImpl$Data$declaredNonStaticMembers$22, "");
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$22.getKClassImpl$Data$declaredNonStaticMembers$2(), KClassImpl$Data$declaredNonStaticMembers$22.getKClassImpl$Data$declaredNonStaticMembers$2(), (NavOptions) null);
    }

    public static final /* synthetic */ void initRecordTimeStamp(SinglePayBillBottomSheetFragment singlePayBillBottomSheetFragment) {
        FragmentActivity requireActivity = singlePayBillBottomSheetFragment.requireActivity();
        MyBillsHomeActivity myBillsHomeActivity = requireActivity instanceof MyBillsHomeActivity ? (MyBillsHomeActivity) requireActivity : null;
        if (myBillsHomeActivity != null) {
            myBillsHomeActivity.showBlockerLoading();
        }
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(SinglePayBillBottomSheetFragment singlePayBillBottomSheetFragment, String str) {
        MyBillsAnalyticTracker myBillsAnalyticTracker = singlePayBillBottomSheetFragment.myBillsAnalyticTracker;
        if (myBillsAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            myBillsAnalyticTracker = null;
        }
        myBillsAnalyticTracker.MyBillsEntityDataFactory(str);
    }

    public static final /* synthetic */ void getAuthRequestContext(SinglePayBillBottomSheetFragment singlePayBillBottomSheetFragment, String str) {
        MyBillsAnalyticTracker myBillsAnalyticTracker = singlePayBillBottomSheetFragment.myBillsAnalyticTracker;
        if (myBillsAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            myBillsAnalyticTracker = null;
        }
        myBillsAnalyticTracker.getAuthRequestContext(str);
    }

    public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            TextView textView = ((FragmentSinglePayBillBottomSheetBinding) vb).initRecordTimeStamp;
            Intrinsics.checkNotNullExpressionValue(textView, "");
            textView.setVisibility(p0 ? 0 : 8);
            VB vb2 = this.MyBillsEntityDataFactory;
            if (vb2 != 0) {
                ImageView imageView = ((FragmentSinglePayBillBottomSheetBinding) vb2).getErrorConfigVersion;
                Intrinsics.checkNotNullExpressionValue(imageView, "");
                imageView.setVisibility(p0 ? 0 : 8);
                VB vb3 = this.MyBillsEntityDataFactory;
                if (vb3 != 0) {
                    LinearLayoutCompat linearLayoutCompat = ((FragmentSinglePayBillBottomSheetBinding) vb3).NetworkUserEntityData$$ExternalSyntheticLambda0;
                    Intrinsics.checkNotNullExpressionValue(linearLayoutCompat, "");
                    linearLayoutCompat.setVisibility(p0 ? 0 : 8);
                    if (NetworkUserEntityData$$ExternalSyntheticLambda1()) {
                        VB vb4 = this.MyBillsEntityDataFactory;
                        if (vb4 != 0) {
                            DanaButtonPrimaryView danaButtonPrimaryView = ((FragmentSinglePayBillBottomSheetBinding) vb4).KClassImpl$Data$declaredNonStaticMembers$2;
                            Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView, "");
                            danaButtonPrimaryView.setVisibility(8);
                            return;
                        }
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    VB vb5 = this.MyBillsEntityDataFactory;
                    if (vb5 != 0) {
                        DanaButtonPrimaryView danaButtonPrimaryView2 = ((FragmentSinglePayBillBottomSheetBinding) vb5).KClassImpl$Data$declaredNonStaticMembers$2;
                        Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView2, "");
                        danaButtonPrimaryView2.setVisibility(p0 ^ true ? 0 : 8);
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

    @Override // id.dana.mybills.ui.v2.addnewbills.services.BaseMyBillsBottomSheet
    public final ConstraintLayout scheduleImpl() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            ConstraintLayout constraintLayout = ((FragmentSinglePayBillBottomSheetBinding) vb).MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
            return constraintLayout;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.mybills.ui.v2.addnewbills.services.BaseMyBillsBottomSheet
    public final ViewHeaderDetailBillsBinding NetworkUserEntityData$$ExternalSyntheticLambda0() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            return ((FragmentSinglePayBillBottomSheetBinding) vb).NetworkUserEntityData$$ExternalSyntheticLambda1.getHeader();
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.mybills.ui.v2.addnewbills.services.BaseMyBillsBottomSheet
    public final NestedScrollView moveToNextValue() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            NestedScrollView nestedScrollView = ((FragmentSinglePayBillBottomSheetBinding) vb).lookAheadTest;
            Intrinsics.checkNotNullExpressionValue(nestedScrollView, "");
            return nestedScrollView;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.mybills.ui.v2.addnewbills.services.BaseMyBillsBottomSheet
    public final MyBillsToolbarView GetContactSyncConfig() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            MyBillsToolbarView myBillsToolbarView = ((FragmentSinglePayBillBottomSheetBinding) vb).moveToNextValue;
            Intrinsics.checkNotNullExpressionValue(myBillsToolbarView, "");
            return myBillsToolbarView;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final View KClassImpl$Data$declaredNonStaticMembers$2() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            RelativeLayout relativeLayout = ((FragmentSinglePayBillBottomSheetBinding) vb).scheduleImpl;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "");
            return relativeLayout;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
