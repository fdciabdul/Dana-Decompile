package id.dana.mybills.ui.v2.addnewbills;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.FlowExtKt;
import androidx.view.HasDefaultViewModelProviderFactory;
import androidx.view.Lifecycle;
import androidx.view.LifecycleOwner;
import androidx.view.LifecycleOwnerKt;
import androidx.view.NavController;
import androidx.view.NavDirections;
import androidx.view.NavOptions;
import androidx.view.ViewModelKt;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import androidx.view.fragment.FragmentKt;
import androidx.view.viewmodel.CreationExtras;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.zoloz.rpc.encryption.EncryptionProxyInvocationHandler;
import id.dana.core.ui.BaseViewBindingFragment;
import id.dana.core.ui.recyclerview.GridItemDecoration;
import id.dana.data.constant.UrlParam;
import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.domain.services.Category;
import id.dana.domain.services.interactor.GetServicesWithCategory;
import id.dana.domain.services.model.ThirdPartyCategoryService;
import id.dana.mybills.R;
import id.dana.mybills.danah5.BillerPortalBridge;
import id.dana.mybills.danah5.DanaUriProvider;
import id.dana.mybills.databinding.FragmentAddNewBillsBinding;
import id.dana.mybills.databinding.MyBillsToolbarLayoutBinding;
import id.dana.mybills.di.component.MyBillsComponent;
import id.dana.mybills.di.module.ViewModelFactory;
import id.dana.mybills.di.provider.MyBillsComponentProvider;
import id.dana.mybills.domain.interactor.GetQuickBuyMyBills;
import id.dana.mybills.domain.model.BizProduct;
import id.dana.mybills.tracker.MyBillsAnalyticTracker;
import id.dana.mybills.tracker.MyBillsTrackerKey;
import id.dana.mybills.ui.adapter.QuickBuyBillsAdapter;
import id.dana.mybills.ui.adapter.ServicesAdapter;
import id.dana.mybills.ui.constant.MyBillsServiceKey;
import id.dana.mybills.ui.mapper.BizProductModelMapperKt;
import id.dana.mybills.ui.model.BizProductModel;
import id.dana.mybills.ui.model.BizProductOrderModel;
import id.dana.mybills.ui.model.MyBillsServiceModel;
import id.dana.mybills.ui.v2.addnewbills.AddNewBillsFragmentDirections;
import id.dana.mybills.ui.v2.addnewbills.AddNewBillsUiState;
import id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment;
import id.dana.mybills.ui.viewholder.QuickBuyBillsViewHolder;
import id.dana.mybills.ui.viewholder.ServiceItemViewHolder;
import id.dana.mybills.utils.SafeNavigationUtilKt;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.utils.danah5.DanaH5Facade;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import o.C;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 72\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b6\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u0005J\u0017\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J-\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00162\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0012\u0010\u001d\u001a\u00020\u001cX\u0087\"¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0012\u0010$\u001a\u00020#X\u0087\"¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010\u001a\u001a\u00020&8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010,\u001a\u00020)8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0012\u00102\u001a\u000201X\u0087\"¢\u0006\u0006\n\u0004\b2\u00103R\u0013\u0010 \u001a\u000204X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u0004\u00105"}, d2 = {"Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsFragment;", "Lid/dana/core/ui/BaseViewBindingFragment;", "Lid/dana/mybills/databinding/FragmentAddNewBillsBinding;", "", "lookAheadTest", "()V", "Lid/dana/mybills/ui/v2/dashboard/MyBillsDashboardFragment$PaymentResultStatusEvent;", "event", "onCashierNativeClosed", "(Lid/dana/mybills/ui/v2/dashboard/MyBillsDashboardFragment$PaymentResultStatusEvent;)V", "Landroid/os/Bundle;", "p0", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "Lid/dana/mybills/danah5/BillerPortalBridge$Event;", "onDigitalVoucherReceived", "(Lid/dana/mybills/danah5/BillerPortalBridge$Event;)V", "Landroid/view/View;", "p1", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "Lkotlin/Pair;", "", "Lid/dana/mybills/ui/model/BizProductModel;", "MyBillsEntityDataFactory", "(ILkotlin/Pair;)V", "Lid/dana/utils/danah5/DanaH5Facade;", "danaH5Facade", "Lid/dana/utils/danah5/DanaH5Facade;", "", "PlaceComponentResult", "Z", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/mybills/tracker/MyBillsAnalyticTracker;", "myBillsAnalyticTracker", "Lid/dana/mybills/tracker/MyBillsAnalyticTracker;", "Lid/dana/mybills/di/component/MyBillsComponent;", "scheduleImpl", "Lid/dana/mybills/di/component/MyBillsComponent;", "Lid/dana/mybills/ui/adapter/QuickBuyBillsAdapter;", "getErrorConfigVersion", "Lid/dana/mybills/ui/adapter/QuickBuyBillsAdapter;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/mybills/ui/adapter/ServicesAdapter;", "moveToNextValue", "Lid/dana/mybills/ui/adapter/ServicesAdapter;", "getAuthRequestContext", "Lid/dana/mybills/di/module/ViewModelFactory;", "viewModelFactory", "Lid/dana/mybills/di/module/ViewModelFactory;", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsViewModel;", "Lkotlin/Lazy;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AddNewBillsFragment extends BaseViewBindingFragment<FragmentAddNewBillsBinding> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;
    @Inject
    public DanaH5Facade danaH5Facade;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final QuickBuyBillsAdapter KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final ServicesAdapter getAuthRequestContext;
    @Inject
    public MyBillsAnalyticTracker myBillsAnalyticTracker;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private MyBillsComponent MyBillsEntityDataFactory;
    @Inject
    public ViewModelFactory viewModelFactory;
    public static final byte[] $$a = {93, 18, 67, -65, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 156;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {120, 42, -65, -64, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int MyBillsEntityDataFactory = 46;

    /* JADX WARN: Removed duplicated region for block: B:20:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0028 -> B:23:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r7, short r8, byte r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = id.dana.mybills.ui.v2.addnewbills.AddNewBillsFragment.KClassImpl$Data$declaredNonStaticMembers$2
            int r8 = r8 * 2
            int r8 = 16 - r8
            int r9 = r9 * 15
            int r9 = 19 - r9
            int r7 = r7 + 105
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r7 = r8
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L36
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r8) goto L28
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L28:
            int r3 = r3 + 1
            r4 = r0[r9]
            r5 = r8
            r8 = r7
            r7 = r5
            r6 = r10
            r10 = r9
            r9 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L36:
            int r8 = r8 + r9
            int r9 = r10 + 1
            int r8 = r8 + 2
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ui.v2.addnewbills.AddNewBillsFragment.a(byte, short, byte, java.lang.Object[]):void");
    }

    private static void b(byte b, int i, byte b2, Object[] objArr) {
        int i2 = (b * 4) + 42;
        int i3 = (b2 * 3) + 75;
        byte[] bArr = $$a;
        int i4 = (i * 2) + 4;
        byte[] bArr2 = new byte[i2];
        int i5 = -1;
        int i6 = i2 - 1;
        if (bArr == null) {
            i4++;
            i3 = (i3 + i4) - 7;
        }
        while (true) {
            i5++;
            bArr2[i5] = (byte) i3;
            if (i5 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            byte b3 = bArr[i4];
            i4++;
            i3 = (i3 + b3) - 7;
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final /* synthetic */ FragmentAddNewBillsBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        FragmentAddNewBillsBinding MyBillsEntityDataFactory2 = FragmentAddNewBillsBinding.MyBillsEntityDataFactory(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory2, "");
        return MyBillsEntityDataFactory2;
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View p0, Bundle p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onViewCreated(p0, p1);
        Context applicationContext = requireActivity().getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.mybills.di.provider.MyBillsComponentProvider");
        }
        MyBillsComponent authRequestContext = ((MyBillsComponentProvider) applicationContext).provideMyBillsComponent().getAuthRequestContext();
        this.MyBillsEntityDataFactory = authRequestContext;
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(this);
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (!arguments.containsKey("IS_FIRST_TIME_USER")) {
                arguments = null;
            }
            if (arguments != null) {
                this.BuiltInFictitiousFunctionClassFactory = arguments.getBoolean("IS_FIRST_TIME_USER");
            }
        }
        VB vb = this.PlaceComponentResult;
        if (vb != 0) {
            MyBillsToolbarLayoutBinding myBillsToolbarLayoutBinding = ((FragmentAddNewBillsBinding) vb).KClassImpl$Data$declaredNonStaticMembers$2;
            AppCompatImageView appCompatImageView = myBillsToolbarLayoutBinding.MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
            appCompatImageView.setVisibility(0);
            myBillsToolbarLayoutBinding.initRecordTimeStamp.setText(getString(R.string.toolbar_title_add_new_bill));
            myBillsToolbarLayoutBinding.MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddNewBillsFragment.KClassImpl$Data$declaredNonStaticMembers$2(AddNewBillsFragment.this);
                }
            });
            Intrinsics.checkNotNullExpressionValue(myBillsToolbarLayoutBinding, "");
            ServicesAdapter servicesAdapter = this.getAuthRequestContext;
            ServiceItemViewHolder.OnServiceClickCallback onServiceClickCallback = new ServiceItemViewHolder.OnServiceClickCallback(this) { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsFragment$initServiceViews$1
                private static int $10 = 0;
                private static int $11 = 1;
                private static char BuiltInFictitiousFunctionClassFactory = 42269;
                private static char KClassImpl$Data$declaredNonStaticMembers$2 = 1762;
                private static char PlaceComponentResult = 53200;
                private static char getAuthRequestContext = 34446;
                private static int getErrorConfigVersion = 1;
                private static int lookAheadTest;
                final /* synthetic */ AddNewBillsFragment MyBillsEntityDataFactory;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    try {
                        this.MyBillsEntityDataFactory = this;
                    } catch (Exception e) {
                        throw e;
                    }
                }

                @Override // id.dana.mybills.ui.viewholder.ServiceItemViewHolder.OnServiceClickCallback
                public final void getAuthRequestContext(MyBillsServiceModel p02) {
                    int i = lookAheadTest + 75;
                    getErrorConfigVersion = i % 128;
                    int i2 = i % 2;
                    Intrinsics.checkNotNullParameter(p02, "");
                    p02.setSource(MyBillsTrackerKey.MyBillsEvent.MY_BILLS_PRODUCT_RESULT);
                    String key = p02.getKey();
                    Object obj = null;
                    switch (key.hashCode()) {
                        case -2061803349:
                            if ((key.equals(MyBillsServiceKey.DIGITAL_VOUCHER) ? ']' : 'b') != 'b') {
                                AddNewBillsFragment.PlaceComponentResult(this.MyBillsEntityDataFactory, p02.getName());
                                DanaH5Facade danaH5Facade = this.MyBillsEntityDataFactory.danaH5Facade;
                                if (danaH5Facade == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("");
                                    int i3 = lookAheadTest + 89;
                                    getErrorConfigVersion = i3 % 128;
                                    int i4 = i3 % 2;
                                    danaH5Facade = null;
                                } else {
                                    int i5 = lookAheadTest + 65;
                                    getErrorConfigVersion = i5 % 128;
                                    int i6 = i5 % 2;
                                }
                                String obj2 = DanaUriProvider.getUri$default(DanaUriProvider.INSTANCE, BillerPortalBridge.Event.BILL_ADD, null, 2, null).toString();
                                Intrinsics.checkNotNullExpressionValue(obj2, "");
                                danaH5Facade.startContainerFullUrl(obj2);
                                return;
                            }
                            return;
                        case -1844295216:
                            if (!key.equals(MyBillsServiceKey.INSURANCE)) {
                                return;
                            }
                            break;
                        case -1720298739:
                            if (!key.equals(MyBillsServiceKey.WATER)) {
                                return;
                            }
                            break;
                        case -1134143750:
                            if (!key.equals(MyBillsServiceKey.TELEPHONE)) {
                                return;
                            }
                            break;
                        case -692436776:
                            if (!key.equals(MyBillsServiceKey.MOBILE_POSTPAID)) {
                                int i7 = lookAheadTest + 115;
                                getErrorConfigVersion = i7 % 128;
                                int i8 = i7 % 2;
                                return;
                            }
                            break;
                        case 359536993:
                            if (!key.equals(MyBillsServiceKey.BPJS)) {
                                return;
                            }
                            break;
                        case 930525159:
                            if (key.equals(MyBillsServiceKey.ELECTRICITY)) {
                                AddNewBillsFragment.PlaceComponentResult(this.MyBillsEntityDataFactory, R.id.action_addNewBillsPage_to_electricityBillsPage, new Pair("BUNDLE_KEY_ELECTRICITY", p02));
                                return;
                            }
                            return;
                        case 1854830795:
                            if (!key.equals(MyBillsServiceKey.INTERNET_CABLE_TV)) {
                                return;
                            }
                            break;
                        case 2038502419:
                            Object[] objArr = new Object[1];
                            a((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 21, new char[]{62192, 45957, 20065, 56692, 35118, 59438, 38570, 12963, 37367, 40133, 23990, 64219, 55188, 41151, 27120, 2596, 18221, 16204, 22983, 5933, 50168, 23452}, objArr);
                            if (key.equals(((String) objArr[0]).intern())) {
                                AddNewBillsFragment.PlaceComponentResult(this.MyBillsEntityDataFactory, R.id.action_addNewBillsPage_to_mobileRechargeBillsPage, new Pair("BUNDLE_KEY_MOBILE_RECHARGE", p02));
                                return;
                            }
                            return;
                        case 2047228072:
                            if (!key.equals(MyBillsServiceKey.GAS_PGN)) {
                                return;
                            }
                            break;
                        case 2116661999:
                            if (!key.equals(MyBillsServiceKey.INSTALLMENT)) {
                                int i9 = lookAheadTest + 47;
                                getErrorConfigVersion = i9 % 128;
                                if ((i9 % 2 == 0 ? ';' : 'O') != 'O') {
                                    obj.hashCode();
                                    return;
                                }
                                return;
                            }
                            break;
                        default:
                            return;
                    }
                    AddNewBillsFragment.PlaceComponentResult(this.MyBillsEntityDataFactory, R.id.action_addNewBillsPage_to_generalBillsPage, new Pair("BUNDLE_KEY_GENERAL_BILL", p02));
                }

                private static void a(int i, char[] cArr, Object[] objArr) {
                    C c = new C();
                    char[] cArr2 = new char[cArr.length];
                    c.BuiltInFictitiousFunctionClassFactory = 0;
                    char[] cArr3 = new char[2];
                    int i2 = $11 + 11;
                    $10 = i2 % 128;
                    int i3 = i2 % 2;
                    while (true) {
                        if ((c.BuiltInFictitiousFunctionClassFactory < cArr.length ? '\b' : (char) 27) == '\b') {
                            cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                            cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
                            int i4 = 58224;
                            int i5 = 0;
                            while (true) {
                                if (i5 >= 16) {
                                    break;
                                }
                                int i6 = $11 + 69;
                                $10 = i6 % 128;
                                int i7 = i6 % 2;
                                cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i4) ^ ((cArr3[0] << 4) + ((char) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (getAuthRequestContext ^ 6353485791441662354L)))));
                                cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i4) ^ ((cArr3[1] << 4) + ((char) (PlaceComponentResult ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (BuiltInFictitiousFunctionClassFactory ^ 6353485791441662354L)))));
                                i4 -= 40503;
                                i5++;
                            }
                            cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
                            cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
                            c.BuiltInFictitiousFunctionClassFactory += 2;
                        } else {
                            objArr[0] = new String(cArr2, 0, i);
                            return;
                        }
                    }
                }
            };
            Intrinsics.checkNotNullParameter(onServiceClickCallback, "");
            servicesAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = onServiceClickCallback;
            VB vb2 = this.PlaceComponentResult;
            if (vb2 != 0) {
                RecyclerView recyclerView = ((FragmentAddNewBillsBinding) vb2).getAuthRequestContext.MyBillsEntityDataFactory;
                recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));
                recyclerView.addItemDecoration(new GridItemDecoration(recyclerView.getContext()));
                recyclerView.setAdapter(this.getAuthRequestContext);
                StateFlow<AddNewBillsUiState> stateFlow = ((AddNewBillsViewModel) this.PlaceComponentResult.getValue()).NetworkUserEntityData$$ExternalSyntheticLambda8;
                Lifecycle lifecycle = getViewLifecycleOwner().getLifecycle();
                Intrinsics.checkNotNullExpressionValue(lifecycle, "");
                Flow onEach = FlowKt.onEach(FlowKt.distinctUntilChanged(FlowExtKt.PlaceComponentResult(stateFlow, lifecycle)), new AddNewBillsFragment$initLifecycleActivity$1(this, null));
                LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "");
                FlowKt.launchIn(onEach, LifecycleOwnerKt.PlaceComponentResult(viewLifecycleOwner));
                final AddNewBillsViewModel addNewBillsViewModel = (AddNewBillsViewModel) this.PlaceComponentResult.getValue();
                addNewBillsViewModel.NetworkUserEntityData$$ExternalSyntheticLambda2.execute(GetServicesWithCategory.Params.INSTANCE.forFilterCategory(CollectionsKt.listOf(Category.CATEGORY_FEATURED_BILLS)), new Function1<List<? extends ThirdPartyCategoryService>, Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsViewModel$getServiceMyBills$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(List<? extends ThirdPartyCategoryService> list) {
                        invoke2(list);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(List<? extends ThirdPartyCategoryService> list) {
                        Intrinsics.checkNotNullParameter(list, "");
                        AddNewBillsViewModel.KClassImpl$Data$declaredNonStaticMembers$2(AddNewBillsViewModel.this, list);
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsViewModel$getServiceMyBills$2
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        Intrinsics.checkNotNullParameter(th, "");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }
                }, new Function0<Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsViewModel$getServiceMyBills$3
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }
                });
                final AddNewBillsViewModel addNewBillsViewModel2 = (AddNewBillsViewModel) this.PlaceComponentResult.getValue();
                Intrinsics.checkNotNullParameter("my_bills", "");
                BaseFlowUseCase.execute$default(addNewBillsViewModel2.NetworkUserEntityData$$ExternalSyntheticLambda0, "my_bills", null, new Function1<Boolean, Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsViewModel$checkIsNeedToShowBottomSheetOnBoarding$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z) {
                        MutableStateFlow mutableStateFlow;
                        Object value;
                        mutableStateFlow = AddNewBillsViewModel.this.getAuthRequestContext;
                        do {
                            value = mutableStateFlow.getValue();
                            AddNewBillsUiState addNewBillsUiState = (AddNewBillsUiState) value;
                        } while (!mutableStateFlow.compareAndSet(value, new AddNewBillsUiState.OnSuccessGetIsNeedToShowBottomSheetOnBoarding(z)));
                    }
                }, new Function1<Throwable, Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsViewModel$checkIsNeedToShowBottomSheetOnBoarding$2
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        Intrinsics.checkNotNullParameter(th, "");
                        StringBuilder sb = new StringBuilder();
                        sb.append(DanaLogConstants.Prefix.GET_ON_BOARDING_PREFIX);
                        sb.append(AddNewBillsViewModel.this.getClass().getName());
                        sb.append(" on Error");
                        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.USER_EDUCATION_TAG, sb.toString(), th);
                    }
                }, null, ViewModelKt.PlaceComponentResult(addNewBillsViewModel2), 18, null);
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle p0) {
        try {
            byte b = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]);
            byte b2 = (byte) (b - 1);
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1);
            Object[] objArr2 = new Object[1];
            a(b3, b3, (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[5]), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(495 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), View.combineMeasuredStates(0, 0) + 4, (char) (TextUtils.lastIndexOf("", '0', 0) + 1));
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
                    long j = ((r1 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.blue(0), 35 - (ViewConfiguration.getTapTimeout() >> 16), (char) ((-1) - MotionEvent.axisFromString("")))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {1726647132, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.makeMeasureSpec(0, 0), 18 - (ViewConfiguration.getLongPressTimeout() >> 16), (char) (ViewConfiguration.getScrollDefaultDelay() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    public final void MyBillsEntityDataFactory(int p0, Pair<String, BizProductModel> p1) {
        if (p1.getSecond() == null) {
            return;
        }
        NavController authRequestContext = FragmentKt.getAuthRequestContext(this);
        int i = R.id.addNewBillsPage;
        String first = p1.getFirst();
        BizProductModel second = p1.getSecond();
        Intrinsics.checkNotNull(second);
        SafeNavigationUtilKt.MyBillsEntityDataFactory(authRequestContext, i, p0, BundleKt.PlaceComponentResult(TuplesKt.to("BUNDLE_KEY_PRODUCT", p1.getSecond()), TuplesKt.to(first, second.getServiceModel())));
    }

    @Subscribe
    public final void onCashierNativeClosed(MyBillsDashboardFragment.PaymentResultStatusEvent event) {
        Intrinsics.checkNotNullParameter(event, "");
        FragmentKt.getAuthRequestContext(this).KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onDigitalVoucherReceived(BillerPortalBridge.Event event) {
        Intrinsics.checkNotNullParameter(event, "");
        if (Intrinsics.areEqual(event.getName(), BillerPortalBridge.Event.BILL_ADD)) {
            final BizProductModel bizProductModel = event.getInfoParsed().toBizProductModel();
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsFragment$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    AddNewBillsFragment.BuiltInFictitiousFunctionClassFactory(AddNewBillsFragment.this, bizProductModel);
                }
            }, 500L);
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final void lookAheadTest() {
        super.lookAheadTest();
        if (this.BuiltInFictitiousFunctionClassFactory) {
            requireActivity().finish();
        } else {
            FragmentKt.getAuthRequestContext(this).moveToNextValue();
        }
    }

    public AddNewBillsFragment() {
        final AddNewBillsFragment addNewBillsFragment = this;
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsFragment$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelFactory viewModelFactory = AddNewBillsFragment.this.viewModelFactory;
                if (viewModelFactory == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    viewModelFactory = null;
                }
                return viewModelFactory;
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsFragment$special$$inlined$viewModels$default$2
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
        this.PlaceComponentResult = FragmentViewModelLazyKt.BuiltInFictitiousFunctionClassFactory(addNewBillsFragment, Reflection.getOrCreateKotlinClass(AddNewBillsViewModel.class), new Function0<ViewModelStore>() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsFragment$special$$inlined$viewModels$default$3
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
        }, new Function0<CreationExtras>() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsFragment$special$$inlined$viewModels$default$4
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
                    ViewModelStoreOwner PlaceComponentResult = FragmentViewModelLazyKt.PlaceComponentResult(lazy);
                    HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = PlaceComponentResult instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) PlaceComponentResult : null;
                    CreationExtras defaultViewModelCreationExtras = hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : null;
                    return defaultViewModelCreationExtras == null ? CreationExtras.Empty.INSTANCE : defaultViewModelCreationExtras;
                }
                return creationExtras;
            }
        }, function0);
        this.getAuthRequestContext = new ServicesAdapter();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new QuickBuyBillsAdapter();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(AddNewBillsFragment addNewBillsFragment) {
        Intrinsics.checkNotNullParameter(addNewBillsFragment, "");
        if (addNewBillsFragment.BuiltInFictitiousFunctionClassFactory) {
            addNewBillsFragment.requireActivity().finish();
        } else {
            FragmentKt.getAuthRequestContext(addNewBillsFragment).moveToNextValue();
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(AddNewBillsFragment addNewBillsFragment, BizProductModel bizProductModel) {
        Object obj;
        Intrinsics.checkNotNullParameter(addNewBillsFragment, "");
        Intrinsics.checkNotNullParameter(bizProductModel, "");
        int i = R.id.action_addNewBillsPage_to_digitalVoucherBillsPage;
        List<MyBillsServiceModel> list = addNewBillsFragment.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(list, "");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((MyBillsServiceModel) obj).isDigitalVoucher()) {
                break;
            }
        }
        bizProductModel.setServiceModel((MyBillsServiceModel) obj);
        Unit unit = Unit.INSTANCE;
        addNewBillsFragment.MyBillsEntityDataFactory(i, new Pair<>("BUNDLE_KEY_DIGITAL_VOUCHER", bizProductModel));
    }

    public static final /* synthetic */ void getAuthRequestContext(AddNewBillsFragment addNewBillsFragment) {
        final AddNewBillsViewModel addNewBillsViewModel = (AddNewBillsViewModel) addNewBillsFragment.PlaceComponentResult.getValue();
        BaseFlowUseCase.execute$default(addNewBillsViewModel.initRecordTimeStamp, new GetQuickBuyMyBills.Params(AddNewBillsViewModel.BuiltInFictitiousFunctionClassFactory()), new Function0<Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsViewModel$getRecentTransactions$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MutableStateFlow mutableStateFlow;
                Object value;
                mutableStateFlow = AddNewBillsViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    AddNewBillsUiState addNewBillsUiState = (AddNewBillsUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new AddNewBillsUiState.OnQuickBuyShimmerLoading(true)));
            }
        }, new Function1<List<? extends BizProduct>, Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsViewModel$getRecentTransactions$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends BizProduct> list) {
                invoke2((List<BizProduct>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<BizProduct> list) {
                MutableStateFlow mutableStateFlow;
                Object value;
                MutableStateFlow mutableStateFlow2;
                Object value2;
                Intrinsics.checkNotNullParameter(list, "");
                mutableStateFlow = AddNewBillsViewModel.this.getAuthRequestContext;
                do {
                    value = mutableStateFlow.getValue();
                    AddNewBillsUiState addNewBillsUiState = (AddNewBillsUiState) value;
                } while (!mutableStateFlow.compareAndSet(value, new AddNewBillsUiState.OnQuickBuyShimmerLoading(false)));
                mutableStateFlow2 = AddNewBillsViewModel.this.getAuthRequestContext;
                do {
                    value2 = mutableStateFlow2.getValue();
                    AddNewBillsUiState addNewBillsUiState2 = (AddNewBillsUiState) value2;
                } while (!mutableStateFlow2.compareAndSet(value2, new AddNewBillsUiState.OnSuccessGetQuickBuyBills(BizProductModelMapperKt.getAuthRequestContext(list))));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsViewModel$getRecentTransactions$3
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }
        }, null, ViewModelKt.PlaceComponentResult(addNewBillsViewModel), 16, null);
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(AddNewBillsFragment addNewBillsFragment, BizProductOrderModel bizProductOrderModel) {
        Context requireContext = addNewBillsFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "");
        String checkoutUrl = bizProductOrderModel.getCheckoutUrl();
        Intent className = new Intent("android.intent.action.VIEW").setClassName(requireContext.getPackageName(), "id.dana.pay.PayActivity");
        Intrinsics.checkNotNullExpressionValue(className, "");
        Bundle bundle = new Bundle();
        bundle.putBoolean("open_cashier", true);
        bundle.putString("redirect_url", checkoutUrl);
        bundle.putBoolean("is_return_home", true);
        bundle.putBoolean("cashier_custom_keyboard", false);
        bundle.putSerializable("natively_decoded_qr", null);
        bundle.putString("qrCode", null);
        bundle.putBoolean("precreateOrder", false);
        bundle.putString(UrlParam.REQUEST_ID, "");
        className.putExtra("source", "Quick Buy");
        className.putExtra("data", bundle);
        requireContext.startActivity(className);
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(final AddNewBillsFragment addNewBillsFragment) {
        AddNewBillsFragment addNewBillsFragment2 = addNewBillsFragment;
        androidx.fragment.app.FragmentKt.PlaceComponentResult(addNewBillsFragment2, EncryptionProxyInvocationHandler.SUCCESS_RET_CODE, new Function2<String, Bundle, Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsFragment$openBottomOnBoardingPageView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* bridge */ /* synthetic */ Unit invoke(String str, Bundle bundle) {
                invoke2(str, bundle);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str, Bundle bundle) {
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullParameter(bundle, "");
                if (bundle.getBoolean("on_success_onboard")) {
                    AddNewBillsFragment.PlaceComponentResult(AddNewBillsFragment.this);
                }
            }
        });
        NavController authRequestContext = FragmentKt.getAuthRequestContext(addNewBillsFragment2);
        AddNewBillsFragmentDirections.Companion companion = AddNewBillsFragmentDirections.INSTANCE;
        NavDirections PlaceComponentResult = AddNewBillsFragmentDirections.Companion.PlaceComponentResult();
        Intrinsics.checkNotNullParameter(PlaceComponentResult, "");
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.getKClassImpl$Data$declaredNonStaticMembers$2(), PlaceComponentResult.getKClassImpl$Data$declaredNonStaticMembers$2(), (NavOptions) null);
    }

    public static final /* synthetic */ void PlaceComponentResult(AddNewBillsFragment addNewBillsFragment, int i, Pair pair) {
        if (pair.getSecond() != null) {
            MyBillsServiceModel myBillsServiceModel = (MyBillsServiceModel) pair.getSecond();
            String name = myBillsServiceModel != null ? myBillsServiceModel.getName() : null;
            MyBillsAnalyticTracker myBillsAnalyticTracker = addNewBillsFragment.myBillsAnalyticTracker;
            if (myBillsAnalyticTracker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                myBillsAnalyticTracker = null;
            }
            if (name == null) {
                name = "";
            }
            myBillsAnalyticTracker.BuiltInFictitiousFunctionClassFactory(name);
            FragmentKt.getAuthRequestContext(addNewBillsFragment).KClassImpl$Data$declaredNonStaticMembers$2(i, BundleKt.PlaceComponentResult(TuplesKt.to(pair.getFirst(), pair.getSecond())), (NavOptions) null);
        }
    }

    public static final /* synthetic */ void PlaceComponentResult(AddNewBillsFragment addNewBillsFragment) {
        final AddNewBillsViewModel addNewBillsViewModel = (AddNewBillsViewModel) addNewBillsFragment.PlaceComponentResult.getValue();
        Intrinsics.checkNotNullParameter("my_bills", "");
        BaseFlowUseCase.execute$default(addNewBillsViewModel.PrepareContext, "my_bills", null, null, new Function1<Throwable, Unit>() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsViewModel$saveDisplayedBottomSheetOnBoarding$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                Intrinsics.checkNotNullParameter(th, "");
                StringBuilder sb = new StringBuilder();
                sb.append(DanaLogConstants.Prefix.SAVE_ON_BOARDING_PREFIX);
                sb.append(AddNewBillsViewModel.this.getClass().getName());
                sb.append(" on Error");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.USER_EDUCATION_TAG, sb.toString(), th);
            }
        }, null, ViewModelKt.PlaceComponentResult(addNewBillsViewModel), 22, null);
    }

    public static final /* synthetic */ void getAuthRequestContext(final AddNewBillsFragment addNewBillsFragment, List list) {
        Object obj;
        VB vb = addNewBillsFragment.PlaceComponentResult;
        if (vb == 0) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        ConstraintLayout constraintLayout = ((FragmentAddNewBillsBinding) vb).BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(list.isEmpty() ^ true ? 0 : 8);
        VB vb2 = addNewBillsFragment.PlaceComponentResult;
        if (vb2 != 0) {
            RecyclerView recyclerView = ((FragmentAddNewBillsBinding) vb2).BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
            QuickBuyBillsAdapter quickBuyBillsAdapter = addNewBillsFragment.KClassImpl$Data$declaredNonStaticMembers$2;
            List<MyBillsServiceModel> list2 = addNewBillsFragment.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory.moveToNextValue;
            Intrinsics.checkNotNullExpressionValue(list2, "");
            List list3 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            Iterator it = list3.iterator();
            while (true) {
                MyBillsServiceModel myBillsServiceModel = null;
                if (!it.hasNext()) {
                    Intrinsics.checkNotNullParameter(list, "");
                    quickBuyBillsAdapter.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(list, null);
                    QuickBuyBillsViewHolder.OnQuickBuyBillsClickCallback onQuickBuyBillsClickCallback = new QuickBuyBillsViewHolder.OnQuickBuyBillsClickCallback() { // from class: id.dana.mybills.ui.v2.addnewbills.AddNewBillsFragment$setupQuickBuy$1$1$1
                        /* JADX WARN: Code restructure failed: missing block: B:10:0x0028, code lost:
                        
                            if (r0.equals(id.dana.mybills.ui.constant.GoodsType.MOBILE_CREDIT) == false) goto L23;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:13:0x0031, code lost:
                        
                            if (r0.equals(id.dana.mybills.ui.constant.GoodsType.MOBILE_DATA) != false) goto L14;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:14:0x0033, code lost:
                        
                            r4.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(id.dana.mybills.R.id.action_addNewBillsPage_to_mobileRechargeBillsPage, new kotlin.Pair("BUNDLE_KEY_MOBILE_RECHARGE", r5));
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:15:0x0041, code lost:
                        
                            return;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:17:0x0048, code lost:
                        
                            if (r0.equals("ELECTRICITY_POST") == false) goto L23;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
                        
                            if (r0.equals("ELECTRICITY") != false) goto L21;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:21:0x0053, code lost:
                        
                            r4.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(id.dana.mybills.R.id.action_addNewBillsPage_to_electricityBillsPage, new kotlin.Pair("BUNDLE_KEY_ELECTRICITY", r5));
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:22:0x0061, code lost:
                        
                            return;
                         */
                        @Override // id.dana.mybills.ui.viewholder.QuickBuyBillsViewHolder.OnQuickBuyBillsClickCallback
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final void MyBillsEntityDataFactory(id.dana.mybills.ui.model.BizProductModel r5) {
                            /*
                                r4 = this;
                                java.lang.String r0 = ""
                                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                                id.dana.mybills.ui.v2.addnewbills.AddNewBillsFragment r0 = id.dana.mybills.ui.v2.addnewbills.AddNewBillsFragment.this
                                id.dana.mybills.ui.model.MyBillsServiceModel r1 = r5.getServiceModel()
                                if (r1 == 0) goto L12
                                java.lang.String r1 = r1.getName()
                                goto L13
                            L12:
                                r1 = 0
                            L13:
                                id.dana.mybills.ui.v2.addnewbills.AddNewBillsFragment.BuiltInFictitiousFunctionClassFactory(r0, r1)
                                java.lang.String r0 = r5.getGoodsType()
                                int r1 = r0.hashCode()
                                switch(r1) {
                                    case -1183873455: goto L4b;
                                    case 216862158: goto L42;
                                    case 868266279: goto L2b;
                                    case 1166867766: goto L22;
                                    default: goto L21;
                                }
                            L21:
                                goto L62
                            L22:
                                java.lang.String r1 = "MOBILE_CREDIT"
                                boolean r0 = r0.equals(r1)
                                if (r0 != 0) goto L33
                                goto L62
                            L2b:
                                java.lang.String r1 = "MOBILE_DATA"
                                boolean r0 = r0.equals(r1)
                                if (r0 == 0) goto L62
                            L33:
                                id.dana.mybills.ui.v2.addnewbills.AddNewBillsFragment r0 = id.dana.mybills.ui.v2.addnewbills.AddNewBillsFragment.this
                                int r1 = id.dana.mybills.R.id.action_addNewBillsPage_to_mobileRechargeBillsPage
                                kotlin.Pair r2 = new kotlin.Pair
                                java.lang.String r3 = "BUNDLE_KEY_MOBILE_RECHARGE"
                                r2.<init>(r3, r5)
                                id.dana.mybills.ui.v2.addnewbills.AddNewBillsFragment.KClassImpl$Data$declaredNonStaticMembers$2(r0, r1, r2)
                                return
                            L42:
                                java.lang.String r1 = "ELECTRICITY_POST"
                                boolean r0 = r0.equals(r1)
                                if (r0 != 0) goto L53
                                goto L62
                            L4b:
                                java.lang.String r1 = "ELECTRICITY"
                                boolean r0 = r0.equals(r1)
                                if (r0 == 0) goto L62
                            L53:
                                id.dana.mybills.ui.v2.addnewbills.AddNewBillsFragment r0 = id.dana.mybills.ui.v2.addnewbills.AddNewBillsFragment.this
                                int r1 = id.dana.mybills.R.id.action_addNewBillsPage_to_electricityBillsPage
                                kotlin.Pair r2 = new kotlin.Pair
                                java.lang.String r3 = "BUNDLE_KEY_ELECTRICITY"
                                r2.<init>(r3, r5)
                                id.dana.mybills.ui.v2.addnewbills.AddNewBillsFragment.KClassImpl$Data$declaredNonStaticMembers$2(r0, r1, r2)
                                return
                            L62:
                                id.dana.mybills.ui.v2.addnewbills.AddNewBillsFragment r0 = id.dana.mybills.ui.v2.addnewbills.AddNewBillsFragment.this
                                int r1 = id.dana.mybills.R.id.action_addNewBillsPage_to_generalBillsPage
                                kotlin.Pair r2 = new kotlin.Pair
                                java.lang.String r3 = "BUNDLE_KEY_GENERAL_BILL"
                                r2.<init>(r3, r5)
                                id.dana.mybills.ui.v2.addnewbills.AddNewBillsFragment.KClassImpl$Data$declaredNonStaticMembers$2(r0, r1, r2)
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ui.v2.addnewbills.AddNewBillsFragment$setupQuickBuy$1$1$1.MyBillsEntityDataFactory(id.dana.mybills.ui.model.BizProductModel):void");
                        }
                    };
                    Intrinsics.checkNotNullParameter(onQuickBuyBillsClickCallback, "");
                    quickBuyBillsAdapter.getAuthRequestContext = onQuickBuyBillsClickCallback;
                    recyclerView.setAdapter(quickBuyBillsAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
                    return;
                }
                BizProductModel bizProductModel = (BizProductModel) it.next();
                Iterator<T> it2 = list2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it2.next();
                    if (ArraysKt.contains(((MyBillsServiceModel) obj).getArrayOfBizType(), bizProductModel.getGoodsType())) {
                        break;
                    }
                }
                MyBillsServiceModel myBillsServiceModel2 = (MyBillsServiceModel) obj;
                if (myBillsServiceModel2 != null) {
                    bizProductModel.setServiceModel(myBillsServiceModel2);
                    myBillsServiceModel = myBillsServiceModel2;
                }
                arrayList.add(myBillsServiceModel);
            }
        } else {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    public static final /* synthetic */ void PlaceComponentResult(AddNewBillsFragment addNewBillsFragment, String str) {
        MyBillsAnalyticTracker myBillsAnalyticTracker = addNewBillsFragment.myBillsAnalyticTracker;
        if (myBillsAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            myBillsAnalyticTracker = null;
        }
        if (str == null) {
            str = "";
        }
        myBillsAnalyticTracker.BuiltInFictitiousFunctionClassFactory(str);
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(AddNewBillsFragment addNewBillsFragment, String str) {
        MyBillsAnalyticTracker myBillsAnalyticTracker = addNewBillsFragment.myBillsAnalyticTracker;
        if (myBillsAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            myBillsAnalyticTracker = null;
        }
        if (str == null) {
            str = "";
        }
        myBillsAnalyticTracker.PlaceComponentResult(str);
    }

    public static final /* synthetic */ void getAuthRequestContext(AddNewBillsFragment addNewBillsFragment, boolean z) {
        AddNewBillsShimmerExt addNewBillsShimmerExt = AddNewBillsShimmerExt.INSTANCE;
        VB vb = addNewBillsFragment.PlaceComponentResult;
        if (vb != 0) {
            FragmentAddNewBillsBinding fragmentAddNewBillsBinding = (FragmentAddNewBillsBinding) vb;
            Intrinsics.checkNotNullParameter(fragmentAddNewBillsBinding, "");
            if (z) {
                AddNewBillsShimmerExt.getAuthRequestContext(fragmentAddNewBillsBinding);
                return;
            } else {
                AddNewBillsShimmerExt.MyBillsEntityDataFactory();
                return;
            }
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
