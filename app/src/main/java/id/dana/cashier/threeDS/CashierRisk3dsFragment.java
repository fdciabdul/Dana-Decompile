package id.dana.cashier.threeDS;

import android.app.Application;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.remotedebug.RDConstant;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import com.huawei.hms.framework.common.ContainerUtils;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.cashier.CashierRisk3dsActivity;
import id.dana.cashier.ThreeDsLoadingHandler;
import id.dana.cashier.model.Risk3dsAdditionalDataModel;
import id.dana.core.ui.BaseViewBindingFragment;
import id.dana.data.config.source.sharedpreference.SharedPrefCashierConfig;
import id.dana.databinding.FragmentCashierRisk3dsBinding;
import id.dana.databinding.ViewCashierToolbarBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerCashierRisk3dsComponent;
import id.dana.pay.PayActivity;
import id.dana.richview.LogoProgressView;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.utils.OSUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ?2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001?B\u0007¢\u0006\u0004\b>\u0010\tJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\u0007J\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\tJ\u000f\u0010\r\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\tJ)\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0010J!\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0015\u0010\tJ\u000f\u0010\u0016\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0016\u0010\tJ\u000f\u0010\u0017\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0017\u0010\tJ\u0019\u0010\u0013\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0013\u0010\u0007J\u0019\u0010\u0019\u001a\u00020\u00182\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001e\u0010\tJ7\u0010\u0013\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0013\u0010 J\u000f\u0010\u0019\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\tJ\u000f\u0010!\u001a\u00020\u0005H\u0016¢\u0006\u0004\b!\u0010\tJ\u000f\u0010\"\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\"\u0010\tJ\u000f\u0010#\u001a\u00020\u0005H\u0002¢\u0006\u0004\b#\u0010\tJ\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010$\u001a\u00020\u0005H\u0002¢\u0006\u0004\b$\u0010\tJ\u000f\u0010%\u001a\u00020\u0005H\u0002¢\u0006\u0004\b%\u0010\tJ\u000f\u0010&\u001a\u00020\u0005H\u0002¢\u0006\u0004\b&\u0010\tJ\u000f\u0010'\u001a\u00020\u0005H\u0002¢\u0006\u0004\b'\u0010\tJ\u000f\u0010(\u001a\u00020\u0005H\u0002¢\u0006\u0004\b(\u0010\tJ\u0017\u0010)\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b)\u0010\u0007J\u0013\u0010\n\u001a\u00020\u0003*\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010*J\u0013\u0010+\u001a\u00020\u0003*\u00020\u0003H\u0002¢\u0006\u0004\b+\u0010*J\u0013\u0010\f\u001a\u00020\u0018*\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\u001aJ\u0013\u0010\r\u001a\u00020\u0018*\u00020\u0003H\u0002¢\u0006\u0004\b\r\u0010\u001aJ\u001b\u0010\n\u001a\u00020\u0005*\u00020,2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010-J\u001f\u0010\u000b\u001a\u00020\u0003*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030.H\u0002¢\u0006\u0004\b\u000b\u0010/R\u001b\u0010\n\u001a\u00020\u00188CX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u00100\u001a\u0004\b1\u00102R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u000204038\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b)\u00105R\u001a\u00107\u001a\u0002068\u0007X\u0087&¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0016\u0010\u000b\u001a\u00020\u00188\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\f\u0010;R\u0018\u0010+\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\r\u0010="}, d2 = {"Lid/dana/cashier/threeDS/CashierRisk3dsFragment;", "Lid/dana/core/ui/BaseViewBindingFragment;", "Lid/dana/databinding/FragmentCashierRisk3dsBinding;", "", "p0", "", "PlaceComponentResult", "(Ljava/lang/String;)V", "getErrorConfigVersion", "()V", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda0", "p1", "p2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "BuiltInFictitiousFunctionClassFactory", "(Landroid/view/LayoutInflater;)Lid/dana/databinding/FragmentCashierRisk3dsBinding;", "FragmentBottomSheetPaymentSettingBinding", "NetworkUserEntityData$$ExternalSyntheticLambda2", "GetContactSyncConfig", "", "lookAheadTest", "(Ljava/lang/String;)Z", "NetworkUserEntityData$$ExternalSyntheticLambda1", "()Ljava/lang/String;", "DatabaseTableConfigUtil", "newProxyInstance", "p3", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "onDestroy", "onDestroyView", "NetworkUserEntityData$$ExternalSyntheticLambda8", "PrepareContext", "NetworkUserEntityData$$ExternalSyntheticLambda7", "isLayoutRequested", "NetworkUserEntityData$$ExternalSyntheticLambda6", "NetworkUserEntityData$$ExternalSyntheticLambda3", "scheduleImpl", "(Ljava/lang/String;)Ljava/lang/String;", "MyBillsEntityDataFactory", "Landroid/webkit/WebView;", "(Landroid/webkit/WebView;Ljava/lang/String;)V", "", "(Ljava/util/Map;)Ljava/lang/String;", "Lkotlin/Lazy;", "initRecordTimeStamp", "()Z", "", "Lid/dana/cashier/model/Risk3dsAdditionalDataModel;", "Ljava/util/List;", "Lid/dana/data/config/source/sharedpreference/SharedPrefCashierConfig;", "sharedPrefCashierConfig", "Lid/dana/data/config/source/sharedpreference/SharedPrefCashierConfig;", "NetworkUserEntityData$$ExternalSyntheticLambda4", "()Lid/dana/data/config/source/sharedpreference/SharedPrefCashierConfig;", "Z", "Lid/dana/cashier/ThreeDsLoadingHandler;", "Lid/dana/cashier/ThreeDsLoadingHandler;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierRisk3dsFragment extends BaseViewBindingFragment<FragmentCashierRisk3dsBinding> {
    private static int $10 = 0;
    private static int $11 = 1;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static boolean GetContactSyncConfig = false;
    private static boolean NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda2 = 1;
    private static final String PlaceComponentResult;
    private static int getErrorConfigVersion;
    private static int initRecordTimeStamp;
    private static char[] lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private ThreeDsLoadingHandler MyBillsEntityDataFactory;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private List<Risk3dsAdditionalDataModel> BuiltInFictitiousFunctionClassFactory;
    @Inject
    public SharedPrefCashierConfig sharedPrefCashierConfig;
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<Boolean>() { // from class: id.dana.cashier.threeDS.CashierRisk3dsFragment$isCardBinding$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            Bundle arguments = CashierRisk3dsFragment.this.getArguments();
            return Boolean.valueOf(arguments != null ? arguments.getBoolean(CashierRisk3dsActivity.IS_CARD_BINDING) : false);
        }
    });

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private boolean getAuthRequestContext = true;

    static {
        scheduleImpl();
        Object[] objArr = new Object[1];
        a(TextUtils.getTrimmedLength("") + 127, new byte[]{-123, -124, -125, -126, -127}, null, null, objArr);
        PlaceComponentResult = ((String) objArr[0]).intern();
        INSTANCE = new Companion(null);
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 7;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory() {
        try {
            int i = initRecordTimeStamp + 121;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
            if ((i % 2 == 0 ? '\r' : 'U') != 'U') {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private static String DatabaseTableConfigUtil() {
        int i = initRecordTimeStamp + 37;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        if ((i % 2 == 0 ? '4' : (char) 4) != 4) {
            Object[] objArr = null;
            int length = objArr.length;
            return "(function() {\n    var inputFields = document.getElementsByTagName('input');\n    for (var i = 0; i < inputFields.length; i++) {\n        var field = inputFields[i];\n        if ((field.type === 'text' || field.type === 'number' || field.type === 'tel') && (field.offsetWidth > 0 || field.offsetHeight > 0)) {\n            field.focus();\n            break;\n        }\n    }\n})()";
        }
        return "(function() {\n    var inputFields = document.getElementsByTagName('input');\n    for (var i = 0; i < inputFields.length; i++) {\n        var field = inputFields[i];\n        if ((field.type === 'text' || field.type === 'number' || field.type === 'tel') && (field.offsetWidth > 0 || field.offsetHeight > 0)) {\n            field.focus();\n            break;\n        }\n    }\n})()";
    }

    private static String NetworkUserEntityData$$ExternalSyntheticLambda1() {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 73;
            initRecordTimeStamp = i % 128;
            int i2 = i % 2;
            int i3 = initRecordTimeStamp + 57;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
            if ((i3 % 2 == 0 ? 'Y' : 'X') != 'Y') {
                return "(function() {\n    try{\n        document.head.innerHTML += '<meta name=\"viewport\" id=\"web-viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, viewport-fit=cover\" />';\n    }catch(e){}\n})()";
            }
            int i4 = 46 / 0;
            return "(function() {\n    try{\n        document.head.innerHTML += '<meta name=\"viewport\" id=\"web-viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, viewport-fit=cover\" />';\n    }catch(e){}\n})()";
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void getAuthRequestContext(CashierRisk3dsFragment cashierRisk3dsFragment) {
        try {
            int i = initRecordTimeStamp + 73;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
            try {
                if (i % 2 != 0) {
                    lookAheadTest(cashierRisk3dsFragment);
                    return;
                }
                lookAheadTest(cashierRisk3dsFragment);
                int i2 = 25 / 0;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    static void scheduleImpl() {
        lookAheadTest = new char[]{39540, 39543, 39429, 39452, 39443};
        GetContactSyncConfig = true;
        NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
        getErrorConfigVersion = 909155275;
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final View getAuthRequestContext(int i) {
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 7;
        initRecordTimeStamp = i2 % 128;
        int i3 = i2 % 2;
        try {
            Map<Integer, View> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
            View view = map.get(Integer.valueOf(i));
            if (!(view != null)) {
                View view2 = getView();
                if (view2 != null) {
                    view = view2.findViewById(i);
                    if (!(view == null)) {
                        int i4 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 55;
                        initRecordTimeStamp = i4 % 128;
                        boolean z = i4 % 2 != 0;
                        map.put(Integer.valueOf(i), view);
                        if (z) {
                            int i5 = 92 / 0;
                        }
                    }
                }
                view = null;
            }
            int i6 = initRecordTimeStamp + 69;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i6 % 128;
            int i7 = i6 % 2;
            return view;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final void getAuthRequestContext() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 49;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        try {
            try {
                this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 95;
                initRecordTimeStamp = i3 % 128;
                if ((i3 % 2 != 0 ? '\'' : 'W') != '\'') {
                    return;
                }
                Object[] objArr = null;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ ThreeDsLoadingHandler BuiltInFictitiousFunctionClassFactory(CashierRisk3dsFragment cashierRisk3dsFragment) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 77;
            initRecordTimeStamp = i % 128;
            boolean z = i % 2 == 0;
            ThreeDsLoadingHandler threeDsLoadingHandler = cashierRisk3dsFragment.MyBillsEntityDataFactory;
            if (!z) {
                Object obj = null;
                obj.hashCode();
            }
            return threeDsLoadingHandler;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(WebView webView, String str) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 75;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        KClassImpl$Data$declaredNonStaticMembers$2(webView, str);
        int i3 = initRecordTimeStamp + 65;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(CashierRisk3dsFragment cashierRisk3dsFragment) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 15;
            initRecordTimeStamp = i % 128;
            boolean z = i % 2 != 0;
            cashierRisk3dsFragment.moveToNextValue();
            if (z) {
                Object obj = null;
                obj.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(CashierRisk3dsFragment cashierRisk3dsFragment, String str) {
        try {
            int i = initRecordTimeStamp + 121;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
            if ((i % 2 == 0 ? (char) 31 : 'L') != 31) {
                cashierRisk3dsFragment.BuiltInFictitiousFunctionClassFactory(str);
                return;
            }
            cashierRisk3dsFragment.BuiltInFictitiousFunctionClassFactory(str);
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ String MyBillsEntityDataFactory() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 123;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        String NetworkUserEntityData$$ExternalSyntheticLambda12 = NetworkUserEntityData$$ExternalSyntheticLambda1();
        try {
            int i3 = initRecordTimeStamp + 65;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
            int i4 = i3 % 2;
            return NetworkUserEntityData$$ExternalSyntheticLambda12;
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(CashierRisk3dsFragment cashierRisk3dsFragment) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 57;
            initRecordTimeStamp = i % 128;
            boolean z = i % 2 == 0;
            cashierRisk3dsFragment.PrepareContext();
            if (!z) {
                Object obj = null;
                obj.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ String PlaceComponentResult() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 117;
        initRecordTimeStamp = i % 128;
        if (i % 2 != 0) {
            int i2 = 49 / 0;
            return DatabaseTableConfigUtil();
        }
        try {
            return DatabaseTableConfigUtil();
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void PlaceComponentResult(CashierRisk3dsFragment cashierRisk3dsFragment) {
        int i = initRecordTimeStamp + 15;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        int i2 = i % 2;
        cashierRisk3dsFragment.NetworkUserEntityData$$ExternalSyntheticLambda0();
        try {
            int i3 = initRecordTimeStamp + 9;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ void PlaceComponentResult(CashierRisk3dsFragment cashierRisk3dsFragment, boolean z) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 39;
            initRecordTimeStamp = i % 128;
            int i2 = i % 2;
            cashierRisk3dsFragment.getAuthRequestContext = z;
            int i3 = initRecordTimeStamp + 33;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
            if ((i3 % 2 == 0 ? '#' : (char) 5) != '#') {
                return;
            }
            int i4 = 17 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final /* synthetic */ FragmentCashierRisk3dsBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        int i = initRecordTimeStamp + 19;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        int i2 = i % 2;
        try {
            FragmentCashierRisk3dsBinding BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(layoutInflater);
            int i3 = initRecordTimeStamp + 55;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
            int i4 = i3 % 2;
            return BuiltInFictitiousFunctionClassFactory;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x001a, code lost:
    
        if ((r0 == null) != false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0021, code lost:
    
        if (r0 != null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0023, code lost:
    
        r1 = id.dana.cashier.threeDS.CashierRisk3dsFragment.NetworkUserEntityData$$ExternalSyntheticLambda2 + 41;
        id.dana.cashier.threeDS.CashierRisk3dsFragment.initRecordTimeStamp = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x002d, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x002e, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0033, code lost:
    
        return null;
     */
    @kotlin.jvm.JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private id.dana.data.config.source.sharedpreference.SharedPrefCashierConfig NetworkUserEntityData$$ExternalSyntheticLambda4() {
        /*
            r5 = this;
            int r0 = id.dana.cashier.threeDS.CashierRisk3dsFragment.initRecordTimeStamp
            int r0 = r0 + 9
            int r1 = r0 % 128
            id.dana.cashier.threeDS.CashierRisk3dsFragment.NetworkUserEntityData$$ExternalSyntheticLambda2 = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            r3 = 0
            if (r0 == 0) goto L1f
            id.dana.data.config.source.sharedpreference.SharedPrefCashierConfig r0 = r5.sharedPrefCashierConfig
            int r4 = r3.length     // Catch: java.lang.Throwable -> L1d
            if (r0 == 0) goto L1a
            r1 = 0
        L1a:
            if (r1 == 0) goto L23
            goto L2e
        L1d:
            r0 = move-exception
            throw r0
        L1f:
            id.dana.data.config.source.sharedpreference.SharedPrefCashierConfig r0 = r5.sharedPrefCashierConfig
            if (r0 == 0) goto L2e
        L23:
            int r1 = id.dana.cashier.threeDS.CashierRisk3dsFragment.NetworkUserEntityData$$ExternalSyntheticLambda2
            int r1 = r1 + 41
            int r2 = r1 % 128
            id.dana.cashier.threeDS.CashierRisk3dsFragment.initRecordTimeStamp = r2
            int r1 = r1 % 2
            return r0
        L2e:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.threeDS.CashierRisk3dsFragment.NetworkUserEntityData$$ExternalSyntheticLambda4():id.dana.data.config.source.sharedpreference.SharedPrefCashierConfig");
    }

    @JvmName(name = "initRecordTimeStamp")
    private final boolean initRecordTimeStamp() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 77;
        initRecordTimeStamp = i % 128;
        if (i % 2 == 0) {
            return ((Boolean) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).booleanValue();
        }
        int i2 = 10 / 0;
        return ((Boolean) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).booleanValue();
    }

    private static FragmentCashierRisk3dsBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 73;
            initRecordTimeStamp = i % 128;
            if ((i % 2 != 0 ? '#' : (char) 16) == 16) {
                Intrinsics.checkNotNullParameter(layoutInflater, "");
                FragmentCashierRisk3dsBinding BuiltInFictitiousFunctionClassFactory = FragmentCashierRisk3dsBinding.BuiltInFictitiousFunctionClassFactory(layoutInflater);
                Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
                return BuiltInFictitiousFunctionClassFactory;
            }
            Intrinsics.checkNotNullParameter(layoutInflater, "");
            FragmentCashierRisk3dsBinding BuiltInFictitiousFunctionClassFactory2 = FragmentCashierRisk3dsBinding.BuiltInFictitiousFunctionClassFactory(layoutInflater);
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory2, "");
            Object[] objArr = null;
            int length = objArr.length;
            return BuiltInFictitiousFunctionClassFactory2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:138:0x0057, code lost:
    
        if ((r4 != null ? 'T' : 30) != 'T') goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0060, code lost:
    
        if (r4 != null) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0062, code lost:
    
        r4 = KClassImpl$Data$declaredNonStaticMembers$2(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0097, code lost:
    
        if (r7 == null) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x00a0, code lost:
    
        if (r7 == null) goto L169;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x00cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r2v7 */
    @Override // id.dana.core.ui.BaseViewBindingFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void FragmentBottomSheetPaymentSettingBinding() {
        /*
            Method dump skipped, instructions count: 317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.threeDS.CashierRisk3dsFragment.FragmentBottomSheetPaymentSettingBinding():void");
    }

    private final void GetContactSyncConfig() {
        Application application;
        try {
            int i = initRecordTimeStamp + 57;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
            int i2 = i % 2;
            DaggerCashierRisk3dsComponent.Builder PlaceComponentResult2 = DaggerCashierRisk3dsComponent.PlaceComponentResult();
            FragmentActivity activity = getActivity();
            if ((activity != null ? (char) 24 : 'I') != 24) {
                application = null;
            } else {
                application = activity.getApplication();
                int i3 = initRecordTimeStamp + 59;
                NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
                int i4 = i3 % 2;
            }
            if (application == null) {
                throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
            }
            PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) application).getApplicationComponent());
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
            new DaggerCashierRisk3dsComponent.CashierRisk3dsComponentImpl(PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory, (byte) 0).MyBillsEntityDataFactory(this);
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:109:0x001e, code lost:
    
        if (r0 != null) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0026, code lost:
    
        if (r0 != null) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x002c, code lost:
    
        if (r0.length() == 0) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x002e, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0030, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0035, code lost:
    
        if (r0 == false) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0037, code lost:
    
        r11 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0039, code lost:
    
        r0 = new java.lang.StringBuilder();
        r0.append("enctype='");
        r0.append(r11);
        r0.append('\'');
        r11 = r0.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0055, code lost:
    
        if (id.dana.utils.UrlUtil.DatabaseTableConfigUtil(r8).isEmpty() == false) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0057, code lost:
    
        r0 = new java.lang.StringBuilder();
        r0.append(r8);
        r6 = '?';
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0062, code lost:
    
        r0 = new java.lang.StringBuilder();
        r0.append(r8);
        r6 = kotlin.text.Typography.amp;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x006c, code lost:
    
        r0.append(r6);
        r0.append(r10);
        r10 = r0.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0078, code lost:
    
        if (r9 == null) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x007a, code lost:
    
        r6 = '_';
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x007d, code lost:
    
        r6 = '!';
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x007f, code lost:
    
        if (r6 == '_') goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0081, code lost:
    
        r9 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0083, code lost:
    
        r0 = java.util.Locale.ROOT;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "");
        r9 = r9.toLowerCase(r0);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0097, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r9, "post") == false) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0099, code lost:
    
        r9 = id.dana.cashier.threeDS.CashierRisk3dsFragment.initRecordTimeStamp + 49;
        id.dana.cashier.threeDS.CashierRisk3dsFragment.NetworkUserEntityData$$ExternalSyntheticLambda2 = r9 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x00a6, code lost:
    
        if ((r9 % 2) != 0) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x00a8, code lost:
    
        r9 = 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x00aa, code lost:
    
        r9 = 'T';
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x00ac, code lost:
    
        if (r9 == 'T') goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x00ae, code lost:
    
        r9 = id.dana.utils.UrlUtil.DatabaseTableConfigUtil(r10);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, "");
        r9 = getAuthRequestContext(r9);
        r10 = r7.PlaceComponentResult;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x00bb, code lost:
    
        r4.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x00be, code lost:
    
        if (r10 == null) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x00c3, code lost:
    
        r9 = id.dana.utils.UrlUtil.DatabaseTableConfigUtil(r10);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, "");
        r9 = getAuthRequestContext(r9);
        r10 = r7.PlaceComponentResult;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x00d0, code lost:
    
        if (r10 == null) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x00d2, code lost:
    
        r0 = id.dana.cashier.threeDS.CashierRisk3dsFragment.initRecordTimeStamp + 5;
        id.dana.cashier.threeDS.CashierRisk3dsFragment.NetworkUserEntityData$$ExternalSyntheticLambda2 = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x00db, code lost:
    
        if ((r0 % 2) != 0) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x00dd, code lost:
    
        r10 = ((id.dana.databinding.FragmentCashierRisk3dsBinding) r10).lookAheadTest.getWebView();
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x00e5, code lost:
    
        r0 = r4.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x00e6, code lost:
    
        if (r10 == null) goto L194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x00eb, code lost:
    
        r10 = ((id.dana.databinding.FragmentCashierRisk3dsBinding) r10).lookAheadTest.getWebView();
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x00f3, code lost:
    
        if (r10 == null) goto L195;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x00f5, code lost:
    
        r8 = PlaceComponentResult(r8, r9, r11);
        com.fullstory.instrumentation.InstrumentInjector.trackWebView(r10);
        r0 = new java.lang.Object[1];
        a((android.view.ViewConfiguration.getEdgeSlop() >> 16) + 127, new byte[]{-123, -124, -125, -126, -127}, null, null, r0);
        r10.loadData(r8, "text/html", ((java.lang.String) r0[0]).intern());
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x011b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0125, code lost:
    
        throw new java.lang.IllegalArgumentException("Required value was null.".toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0126, code lost:
    
        r8 = r7.PlaceComponentResult;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x012a, code lost:
    
        if (r8 == 0) goto L166;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x012c, code lost:
    
        r11 = 'L';
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x012f, code lost:
    
        r11 = 11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0131, code lost:
    
        if (r11 == 11) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0133, code lost:
    
        r11 = id.dana.cashier.threeDS.CashierRisk3dsFragment.initRecordTimeStamp + 11;
        id.dana.cashier.threeDS.CashierRisk3dsFragment.NetworkUserEntityData$$ExternalSyntheticLambda2 = r11 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x013c, code lost:
    
        if ((r11 % 2) != 0) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x013e, code lost:
    
        r8 = ((id.dana.databinding.FragmentCashierRisk3dsBinding) r8).lookAheadTest.getWebView();
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0146, code lost:
    
        r4.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x014b, code lost:
    
        if (r8 == null) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x014d, code lost:
    
        r11 = 'Y';
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x0150, code lost:
    
        r11 = 'O';
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0152, code lost:
    
        if (r11 == 'O') goto L196;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0157, code lost:
    
        r8 = ((id.dana.databinding.FragmentCashierRisk3dsBinding) r8).lookAheadTest.getWebView();
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x015f, code lost:
    
        if (r8 == null) goto L197;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x0161, code lost:
    
        r9 = id.dana.cashier.threeDS.CashierRisk3dsFragment.NetworkUserEntityData$$ExternalSyntheticLambda2 + 39;
        id.dana.cashier.threeDS.CashierRisk3dsFragment.initRecordTimeStamp = r9 % 128;
        r9 = r9 % 2;
        com.fullstory.instrumentation.InstrumentInjector.trackWebView(r8);
        r8.loadUrl(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0170, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x017a, code lost:
    
        throw new java.lang.IllegalArgumentException("Required value was null.".toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void BuiltInFictitiousFunctionClassFactory(java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 387
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.threeDS.CashierRisk3dsFragment.BuiltInFictitiousFunctionClassFactory(java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    private static final void lookAheadTest(CashierRisk3dsFragment cashierRisk3dsFragment) {
        try {
            int i = initRecordTimeStamp + 9;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
            if (i % 2 != 0) {
                try {
                    Intrinsics.checkNotNullParameter(cashierRisk3dsFragment, "");
                    cashierRisk3dsFragment.lookAheadTest();
                } catch (Exception e) {
                    throw e;
                }
            } else {
                Intrinsics.checkNotNullParameter(cashierRisk3dsFragment, "");
                cashierRisk3dsFragment.lookAheadTest();
                Object[] objArr = null;
                int length = objArr.length;
            }
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 119;
            initRecordTimeStamp = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final void lookAheadTest() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 69;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        NetworkUserEntityData$$ExternalSyntheticLambda8();
        int i3 = initRecordTimeStamp + 59;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
        if (!(i3 % 2 != 0)) {
            int i4 = 33 / 0;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        try {
            ThreeDsLoadingHandler threeDsLoadingHandler = this.MyBillsEntityDataFactory;
            if ((threeDsLoadingHandler != null ? (char) 30 : (char) 3) != 3) {
                int i = initRecordTimeStamp + 15;
                NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
                if ((i % 2 == 0 ? 'a' : 'X') != 'a') {
                    ((CountDownTimer) threeDsLoadingHandler.getAuthRequestContext.getValue()).cancel();
                } else {
                    ((CountDownTimer) threeDsLoadingHandler.getAuthRequestContext.getValue()).cancel();
                    int i2 = 13 / 0;
                }
            }
            this.MyBillsEntityDataFactory = null;
            super.onDestroy();
            int i3 = initRecordTimeStamp + 123;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(WebView webView, String str) {
        if (OSUtil.getErrorConfigVersion()) {
            webView.evaluateJavascript(str, new ValueCallback() { // from class: id.dana.cashier.threeDS.CashierRisk3dsFragment$$ExternalSyntheticLambda1
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    String str2 = (String) obj;
                    CashierRisk3dsFragment.BuiltInFictitiousFunctionClassFactory();
                }
            });
            try {
                int i = initRecordTimeStamp + 117;
                NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
                int i2 = i % 2;
                return;
            } catch (Exception e) {
                throw e;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(RDConstant.JAVASCRIPT_SCHEME);
        sb.append(str);
        String obj = sb.toString();
        InstrumentInjector.trackWebView(webView);
        webView.loadUrl(obj);
        int i3 = initRecordTimeStamp + 85;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
        int i4 = i3 % 2;
    }

    private final void PlaceComponentResult(String p0) {
        try {
            ThreeDsLoadingHandler threeDsLoadingHandler = this.MyBillsEntityDataFactory;
            if ((threeDsLoadingHandler != null ? (char) 2 : (char) 19) == 2) {
                threeDsLoadingHandler.getErrorConfigVersion = lookAheadTest(p0);
                int i = initRecordTimeStamp + 123;
                NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
                int i2 = i % 2;
            }
            ThreeDsLoadingHandler threeDsLoadingHandler2 = this.MyBillsEntityDataFactory;
            if (!(threeDsLoadingHandler2 != null)) {
                return;
            }
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 111;
            initRecordTimeStamp = i3 % 128;
            int i4 = i3 % 2;
            threeDsLoadingHandler2.PlaceComponentResult.setVisibility(0);
            threeDsLoadingHandler2.MyBillsEntityDataFactory(!threeDsLoadingHandler2.getErrorConfigVersion);
            threeDsLoadingHandler2.KClassImpl$Data$declaredNonStaticMembers$2(threeDsLoadingHandler2.getErrorConfigVersion);
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x006b, code lost:
    
        if ((r0 instanceof java.util.Collection) != false) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x007a, code lost:
    
        if ((r0 instanceof java.util.Collection) != false) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0083, code lost:
    
        if (r0.isEmpty() != false) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0085, code lost:
    
        r0 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x008f, code lost:
    
        if (r0.hasNext() == false) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0091, code lost:
    
        r1 = '\f';
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0094, code lost:
    
        r1 = '\\';
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0096, code lost:
    
        if (r1 == '\\') goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0098, code lost:
    
        r1 = id.dana.cashier.threeDS.CashierRisk3dsFragment.initRecordTimeStamp + 49;
        id.dana.cashier.threeDS.CashierRisk3dsFragment.NetworkUserEntityData$$ExternalSyntheticLambda2 = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x00a2, code lost:
    
        if ((r1 % 2) != 0) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x00b0, code lost:
    
        if (kotlin.text.StringsKt.contains((java.lang.CharSequence) r7, (java.lang.CharSequence) ((java.lang.String) r0.next()), true) == false) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x00bf, code lost:
    
        if (kotlin.text.StringsKt.contains((java.lang.CharSequence) r7, (java.lang.CharSequence) ((java.lang.String) r0.next()), true) == false) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x00c1, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:?, code lost:
    
        return false;
     */
    /* JADX WARN: Removed duplicated region for block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean lookAheadTest(java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 200
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.threeDS.CashierRisk3dsFragment.lookAheadTest(java.lang.String):boolean");
    }

    private final void moveToNextValue() {
        try {
            int i = initRecordTimeStamp + 89;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
            int i2 = i % 2;
            ThreeDsLoadingHandler threeDsLoadingHandler = this.MyBillsEntityDataFactory;
            if (threeDsLoadingHandler == null) {
                return;
            }
            threeDsLoadingHandler.PlaceComponentResult();
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 93;
            initRecordTimeStamp = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x0029, code lost:
    
        if (moveToNextValue(r5) == true) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0030, code lost:
    
        if (moveToNextValue(r5) == true) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0032, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x005d, code lost:
    
        if (NetworkUserEntityData$$ExternalSyntheticLambda0(r5) == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0069, code lost:
    
        if ((NetworkUserEntityData$$ExternalSyntheticLambda0(r5)) != false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x006b, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void BuiltInFictitiousFunctionClassFactory(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = id.dana.cashier.threeDS.CashierRisk3dsFragment.NetworkUserEntityData$$ExternalSyntheticLambda2
            int r0 = r0 + 55
            int r1 = r0 % 128
            id.dana.cashier.threeDS.CashierRisk3dsFragment.initRecordTimeStamp = r1
            int r0 = r0 % 2
            r0 = 0
            r1 = 1
            if (r5 == 0) goto L10
            r2 = 1
            goto L11
        L10:
            r2 = 0
        L11:
            if (r2 == r1) goto L14
            goto L34
        L14:
            int r2 = id.dana.cashier.threeDS.CashierRisk3dsFragment.initRecordTimeStamp
            int r2 = r2 + 107
            int r3 = r2 % 128
            id.dana.cashier.threeDS.CashierRisk3dsFragment.NetworkUserEntityData$$ExternalSyntheticLambda2 = r3
            int r2 = r2 % 2
            if (r2 != 0) goto L22
            r2 = 1
            goto L23
        L22:
            r2 = 0
        L23:
            if (r2 == 0) goto L2c
            boolean r2 = moveToNextValue(r5)
            if (r2 != r1) goto L34
            goto L32
        L2c:
            boolean r2 = moveToNextValue(r5)     // Catch: java.lang.Exception -> L72
            if (r2 != r1) goto L34
        L32:
            r2 = 1
            goto L35
        L34:
            r2 = 0
        L35:
            if (r2 == 0) goto L4b
            int r2 = id.dana.cashier.threeDS.CashierRisk3dsFragment.NetworkUserEntityData$$ExternalSyntheticLambda2
            int r2 = r2 + 23
            int r3 = r2 % 128
            id.dana.cashier.threeDS.CashierRisk3dsFragment.initRecordTimeStamp = r3
            int r2 = r2 % 2
            r4.getAuthRequestContext(r5)
            if (r2 == 0) goto L4b
            r2 = 0
            int r2 = r2.length     // Catch: java.lang.Throwable -> L49
            goto L4b
        L49:
            r5 = move-exception
            throw r5
        L4b:
            if (r5 == 0) goto L6c
            int r2 = id.dana.cashier.threeDS.CashierRisk3dsFragment.initRecordTimeStamp
            int r2 = r2 + 47
            int r3 = r2 % 128
            id.dana.cashier.threeDS.CashierRisk3dsFragment.NetworkUserEntityData$$ExternalSyntheticLambda2 = r3
            int r2 = r2 % 2
            if (r2 != 0) goto L60
            boolean r5 = NetworkUserEntityData$$ExternalSyntheticLambda0(r5)
            if (r5 != 0) goto L6c
            goto L6b
        L60:
            boolean r5 = NetworkUserEntityData$$ExternalSyntheticLambda0(r5)
            if (r5 != r1) goto L68
            r5 = 1
            goto L69
        L68:
            r5 = 0
        L69:
            if (r5 == 0) goto L6c
        L6b:
            r0 = 1
        L6c:
            if (r0 == 0) goto L71
            r4.newProxyInstance()
        L71:
            return
        L72:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.threeDS.CashierRisk3dsFragment.BuiltInFictitiousFunctionClassFactory(java.lang.String):void");
    }

    private final void getAuthRequestContext(String p0) {
        int i = initRecordTimeStamp + 115;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        int i2 = i % 2;
        try {
            try {
                getErrorConfigVersion(MyBillsEntityDataFactory(p0));
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 45;
                initRecordTimeStamp = i3 % 128;
                if (!(i3 % 2 != 0)) {
                    return;
                }
                Object[] objArr = null;
                int length = objArr.length;
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("constructCashier3dsResultQuery : cashier_native_fail ");
                sb.append(e.getMessage());
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.CASHIER_NATIVE, sb.toString());
                getErrorConfigVersion("");
            }
        } catch (Throwable th) {
            getErrorConfigVersion("");
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v4 */
    private final void newProxyInstance() {
        List<Risk3dsAdditionalDataModel> list = this.BuiltInFictitiousFunctionClassFactory;
        ?? r1 = 0;
        r1 = 0;
        if (list == null) {
            int i = initRecordTimeStamp + 105;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
            if (i % 2 == 0) {
                try {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    int length = r1.length;
                } catch (Exception e) {
                    throw e;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            list = null;
        }
        Risk3dsAdditionalDataModel risk3dsAdditionalDataModel = (Risk3dsAdditionalDataModel) CollectionsKt.firstOrNull((List) list);
        if ((risk3dsAdditionalDataModel != null ? '(' : '/') == '(') {
            BuiltInFictitiousFunctionClassFactory(risk3dsAdditionalDataModel.PlaceComponentResult, risk3dsAdditionalDataModel.MyBillsEntityDataFactory, risk3dsAdditionalDataModel.KClassImpl$Data$declaredNonStaticMembers$2, risk3dsAdditionalDataModel.BuiltInFictitiousFunctionClassFactory);
            List<Risk3dsAdditionalDataModel> list2 = this.BuiltInFictitiousFunctionClassFactory;
            if (list2 == null) {
                int i2 = initRecordTimeStamp + 17;
                NetworkUserEntityData$$ExternalSyntheticLambda2 = i2 % 128;
                boolean z = i2 % 2 == 0;
                Intrinsics.throwUninitializedPropertyAccessException("");
                if (z) {
                    int i3 = 22 / 0;
                }
            } else {
                r1 = list2;
            }
            try {
                Risk3dsAdditionalDataModel risk3dsAdditionalDataModel2 = (Risk3dsAdditionalDataModel) CollectionsKt.removeFirst(r1);
            } catch (Exception e2) {
                throw e2;
            }
        }
        int i4 = initRecordTimeStamp + 7;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i4 % 128;
        int i5 = i4 % 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String MyBillsEntityDataFactory(java.lang.String r4) {
        /*
            java.net.URL r0 = new java.net.URL
            r0.<init>(r4)
            java.util.Map r4 = id.dana.utils.UrlUtil.PlaceComponentResult(r0)
            r0 = 0
            r1 = 1
            if (r4 == 0) goto Lf
            r2 = 1
            goto L10
        Lf:
            r2 = 0
        L10:
            if (r2 == r1) goto L13
            goto L47
        L13:
            int r2 = id.dana.cashier.threeDS.CashierRisk3dsFragment.initRecordTimeStamp     // Catch: java.lang.Exception -> L5b
            int r2 = r2 + 109
            int r3 = r2 % 128
            id.dana.cashier.threeDS.CashierRisk3dsFragment.NetworkUserEntityData$$ExternalSyntheticLambda2 = r3     // Catch: java.lang.Exception -> L5b
            int r2 = r2 % 2
            java.lang.String r2 = "method"
            java.lang.Object r4 = r4.get(r2)
            java.util.List r4 = (java.util.List) r4
            if (r4 == 0) goto L29
            r2 = 0
            goto L2a
        L29:
            r2 = 1
        L2a:
            if (r2 == r1) goto L47
            int r2 = id.dana.cashier.threeDS.CashierRisk3dsFragment.initRecordTimeStamp
            int r2 = r2 + 121
            int r3 = r2 % 128
            id.dana.cashier.threeDS.CashierRisk3dsFragment.NetworkUserEntityData$$ExternalSyntheticLambda2 = r3
            int r2 = r2 % 2
            java.lang.Object r4 = kotlin.collections.CollectionsKt.firstOrNull(r4)
            java.lang.String r4 = (java.lang.String) r4
            int r2 = id.dana.cashier.threeDS.CashierRisk3dsFragment.initRecordTimeStamp
            int r2 = r2 + 47
            int r3 = r2 % 128
            id.dana.cashier.threeDS.CashierRisk3dsFragment.NetworkUserEntityData$$ExternalSyntheticLambda2 = r3
            int r2 = r2 % 2
            goto L48
        L47:
            r4 = 0
        L48:
            if (r4 != 0) goto L4b
            goto L4c
        L4b:
            r0 = 1
        L4c:
            if (r0 == r1) goto L5a
            int r4 = id.dana.cashier.threeDS.CashierRisk3dsFragment.initRecordTimeStamp
            int r4 = r4 + 33
            int r0 = r4 % 128
            id.dana.cashier.threeDS.CashierRisk3dsFragment.NetworkUserEntityData$$ExternalSyntheticLambda2 = r0
            int r4 = r4 % 2
            java.lang.String r4 = ""
        L5a:
            return r4
        L5b:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.threeDS.CashierRisk3dsFragment.MyBillsEntityDataFactory(java.lang.String):java.lang.String");
    }

    private static boolean moveToNextValue(String str) {
        try {
            int i = initRecordTimeStamp + 41;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
            Object obj = null;
            boolean startsWith$default = i % 2 != 0 ? StringsKt.startsWith$default(str, "https://m.dana.id/m/portal/cashier/result", false, 2, (Object) null) : StringsKt.startsWith$default(str, "https://m.dana.id/m/portal/cashier/result", true, 2, (Object) null);
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 65;
            initRecordTimeStamp = i2 % 128;
            if (i2 % 2 == 0) {
                return startsWith$default;
            }
            obj.hashCode();
            return startsWith$default;
        } catch (Exception e) {
            throw e;
        }
    }

    private static boolean NetworkUserEntityData$$ExternalSyntheticLambda0(String str) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 119;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        boolean contains$default = StringsKt.contains$default((CharSequence) str, (CharSequence) "callbackInterface/gateway", false, 2, (Object) null);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 41;
        initRecordTimeStamp = i3 % 128;
        if ((i3 % 2 != 0 ? 'W' : '1') != '1') {
            int i4 = 36 / 0;
            return contains$default;
        }
        return contains$default;
    }

    private static String KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        int i = initRecordTimeStamp + 75;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        int i2 = i % 2;
        String replace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(str, "%26", ContainerUtils.FIELD_DELIMITER, false, 4, (Object) null), "%3D", "=", false, 4, (Object) null), "https%3A%2F%2F", "https://", false, 4, (Object) null), "%2F", "/", false, 4, (Object) null), "%2B", "+", false, 4, (Object) null);
        int i3 = initRecordTimeStamp + 125;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
        if ((i3 % 2 == 0 ? '8' : (char) 17) != '8') {
            return replace$default;
        }
        Object obj = null;
        obj.hashCode();
        return replace$default;
    }

    private static String PlaceComponentResult(String p0, String p1, String p2) {
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html><html><body onload='document.frm1.submit()'><form action='");
        sb.append(p0);
        sb.append("' method='post' name='frm1' ");
        sb.append(p2);
        sb.append(Typography.greater);
        sb.append(p1);
        sb.append("</form></body></html>");
        String obj = sb.toString();
        try {
            int i = initRecordTimeStamp + 77;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
            int i2 = i % 2;
            return obj;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void getErrorConfigVersion(String p0) {
        try {
            int i = initRecordTimeStamp + 59;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
            int i2 = i % 2;
            getParentFragmentManager().setFragmentResult("3ds_request_key", BundleKt.PlaceComponentResult(TuplesKt.to("3ds_result_key", -1), TuplesKt.to(CashierRisk3dsActivity.URL_PARAMS, p0)));
            getErrorConfigVersion();
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 105;
            initRecordTimeStamp = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda8() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 81;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        getParentFragmentManager().setFragmentResult("3ds_request_key", BundleKt.PlaceComponentResult(TuplesKt.to("3ds_result_key", 0)));
        getErrorConfigVersion();
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 61;
        initRecordTimeStamp = i3 % 128;
        int i4 = i3 % 2;
    }

    private final void scheduleImpl(String p0) {
        int i = initRecordTimeStamp + 23;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        int i2 = i % 2;
        byte b = 0;
        if (!initRecordTimeStamp()) {
            EventTrackerModel.Builder builder = new EventTrackerModel.Builder(requireContext());
            builder.MyBillsEntityDataFactory = TrackerKey.Event.PAYMENT_THIRD_PARTY_RISK_CHALLENGE;
            EventTrackerModel.Builder MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory("App Name", TrackerKey.DanaBalanceRecipientTypeProperty.DANA).MyBillsEntityDataFactory(TrackerKey.CashierProperties.CASHIER_ORDER_ID, p0);
            MyBillsEntityDataFactory.PlaceComponentResult();
            EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory, b));
        }
        int i3 = initRecordTimeStamp + 43;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
        if (!(i3 % 2 != 0)) {
            int i4 = 67 / 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x0029, code lost:
    
        if (r0 != null) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x003b, code lost:
    
        if ((r0 != null ? kotlin.text.Typography.dollar : 'L') != '$') goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x003e, code lost:
    
        r3 = r0.getDecorView();
     */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0069 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void isLayoutRequested() {
        /*
            r5 = this;
            androidx.fragment.app.FragmentActivity r0 = r5.getActivity()
            r1 = 0
            if (r0 == 0) goto L9
            r2 = 1
            goto La
        L9:
            r2 = 0
        La:
            r3 = 0
            if (r2 == 0) goto L43
            int r2 = id.dana.cashier.threeDS.CashierRisk3dsFragment.initRecordTimeStamp
            int r2 = r2 + 113
            int r4 = r2 % 128
            id.dana.cashier.threeDS.CashierRisk3dsFragment.NetworkUserEntityData$$ExternalSyntheticLambda2 = r4
            int r2 = r2 % 2
            r4 = 15
            if (r2 != 0) goto L1e
            r2 = 96
            goto L20
        L1e:
            r2 = 15
        L20:
            if (r2 == r4) goto L2e
            android.view.Window r0 = r0.getWindow()
            r3.hashCode()     // Catch: java.lang.Throwable -> L2c
            if (r0 == 0) goto L43
            goto L3e
        L2c:
            r0 = move-exception
            throw r0
        L2e:
            android.view.Window r0 = r0.getWindow()
            r2 = 36
            if (r0 == 0) goto L39
            r4 = 36
            goto L3b
        L39:
            r4 = 76
        L3b:
            if (r4 == r2) goto L3e
            goto L43
        L3e:
            android.view.View r3 = r0.getDecorView()
            goto L4d
        L43:
            int r0 = id.dana.cashier.threeDS.CashierRisk3dsFragment.NetworkUserEntityData$$ExternalSyntheticLambda2
            int r0 = r0 + 71
            int r2 = r0 % 128
            id.dana.cashier.threeDS.CashierRisk3dsFragment.initRecordTimeStamp = r2
            int r0 = r0 % 2
        L4d:
            id.dana.cashier.threeDS.CashierRisk3dsFragment$setupKeyboardListener$1 r0 = new id.dana.cashier.threeDS.CashierRisk3dsFragment$setupKeyboardListener$1
            r0.<init>()
            id.dana.utils.KeyboardHelper$KeyboardVisibilityListener r0 = (id.dana.utils.KeyboardHelper.KeyboardVisibilityListener) r0     // Catch: java.lang.Exception -> L6a
            id.dana.utils.KeyboardHelper.PlaceComponentResult(r3, r0)     // Catch: java.lang.Exception -> L6a
            int r0 = id.dana.cashier.threeDS.CashierRisk3dsFragment.NetworkUserEntityData$$ExternalSyntheticLambda2
            int r0 = r0 + 25
            int r2 = r0 % 128
            id.dana.cashier.threeDS.CashierRisk3dsFragment.initRecordTimeStamp = r2
            int r0 = r0 % 2
            if (r0 == 0) goto L69
            r0 = 48
            int r0 = r0 / r1
            return
        L67:
            r0 = move-exception
            throw r0
        L69:
            return
        L6a:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.threeDS.CashierRisk3dsFragment.isLayoutRequested():void");
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda3() {
        FragmentActivity activity;
        try {
            if (!(getActivity() instanceof PayActivity) || (activity = getActivity()) == null) {
                return;
            }
            Window window = activity.getWindow();
            if (!(window != null)) {
                return;
            }
            int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 35;
            initRecordTimeStamp = i % 128;
            if ((i % 2 != 0 ? Typography.less : 'S') != '<') {
                window.setSoftInputMode(16);
            } else {
                try {
                    window.setSoftInputMode(83);
                } catch (Exception e) {
                    throw e;
                }
            }
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 79;
            initRecordTimeStamp = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 9;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        if ((getActivity() instanceof PayActivity ? (char) 24 : 'O') != 24) {
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 75;
            initRecordTimeStamp = i3 % 128;
            if (i3 % 2 != 0) {
                int i4 = 8 / 0;
                return;
            }
            return;
        }
        FragmentActivity activity = getActivity();
        if ((activity != null ? '+' : (char) 20) == 20) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.pay.PayActivity");
        }
        int i5 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 89;
        initRecordTimeStamp = i5 % 128;
        if ((i5 % 2 != 0 ? 'W' : '(') != 'W') {
            ((PayActivity) activity).expandBottomSheet();
            return;
        }
        ((PayActivity) activity).expandBottomSheet();
        Object[] objArr = null;
        int length = objArr.length;
    }

    private final void PrepareContext() {
        PayActivity payActivity;
        FragmentActivity activity = getActivity();
        if (activity instanceof PayActivity) {
            try {
                int i = initRecordTimeStamp + 69;
                try {
                    NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
                    if (!(i % 2 == 0)) {
                        payActivity = (PayActivity) activity;
                    } else {
                        payActivity = (PayActivity) activity;
                        int i2 = 95 / 0;
                    }
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            payActivity = null;
        }
        if ((payActivity != null ? ':' : '0') != '0') {
            payActivity.setHalfScreenBottomSheet();
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 87;
            initRecordTimeStamp = i3 % 128;
            int i4 = i3 % 2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x003d, code lost:
    
        if ((r0 > 0 ? '\n' : 20) != 20) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void getErrorConfigVersion() {
        /*
            r2 = this;
            int r0 = id.dana.cashier.threeDS.CashierRisk3dsFragment.initRecordTimeStamp
            int r0 = r0 + 93
            int r1 = r0 % 128
            id.dana.cashier.threeDS.CashierRisk3dsFragment.NetworkUserEntityData$$ExternalSyntheticLambda2 = r1
            int r0 = r0 % 2
            r1 = 1
            if (r0 != 0) goto Lf
            r0 = 1
            goto L10
        Lf:
            r0 = 0
        L10:
            if (r0 == r1) goto L28
            androidx.fragment.app.FragmentManager r0 = r2.getParentFragmentManager()     // Catch: java.lang.Exception -> L26
            int r0 = r0.getBackStackEntryCount()     // Catch: java.lang.Exception -> L26
            r1 = 86
            if (r0 <= 0) goto L21
            r0 = 94
            goto L23
        L21:
            r0 = 86
        L23:
            if (r0 == r1) goto L46
            goto L3f
        L26:
            r0 = move-exception
            goto L53
        L28:
            androidx.fragment.app.FragmentManager r0 = r2.getParentFragmentManager()     // Catch: java.lang.Exception -> L26
            int r0 = r0.getBackStackEntryCount()     // Catch: java.lang.Exception -> L26
            r1 = 0
            r1.hashCode()     // Catch: java.lang.Throwable -> L51
            r1 = 20
            if (r0 <= 0) goto L3b
            r0 = 10
            goto L3d
        L3b:
            r0 = 20
        L3d:
            if (r0 == r1) goto L46
        L3f:
            androidx.fragment.app.FragmentManager r0 = r2.getParentFragmentManager()     // Catch: java.lang.Exception -> L26
            r0.popBackStackImmediate()     // Catch: java.lang.Exception -> L26
        L46:
            int r0 = id.dana.cashier.threeDS.CashierRisk3dsFragment.NetworkUserEntityData$$ExternalSyntheticLambda2
            int r0 = r0 + 105
            int r1 = r0 % 128
            id.dana.cashier.threeDS.CashierRisk3dsFragment.initRecordTimeStamp = r1
            int r0 = r0 % 2
            return
        L51:
            r0 = move-exception
            throw r0
        L53:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.threeDS.CashierRisk3dsFragment.getErrorConfigVersion():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0018, code lost:
    
        if (r0 != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x002b, code lost:
    
        if ((!(getActivity() instanceof id.dana.pay.PayActivity)) != true) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x002d, code lost:
    
        r0 = getActivity();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0031, code lost:
    
        if (r0 == null) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0035, code lost:
    
        r4 = id.dana.cashier.threeDS.CashierRisk3dsFragment.initRecordTimeStamp + 59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0039, code lost:
    
        id.dana.cashier.threeDS.CashierRisk3dsFragment.NetworkUserEntityData$$ExternalSyntheticLambda2 = r4 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x003d, code lost:
    
        if ((r4 % 2) != 0) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0040, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0041, code lost:
    
        if (r1 == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0043, code lost:
    
        r0 = r0.getWindow();
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0047, code lost:
    
        r1 = r3.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0048, code lost:
    
        if (r0 == null) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x004d, code lost:
    
        r0 = r0.getWindow();
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0051, code lost:
    
        if (r0 == null) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0053, code lost:
    
        r0.setSoftInputMode(32);
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0059, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x005a, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x005b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x005c, code lost:
    
        throw r0;
     */
    @Override // id.dana.core.ui.BaseViewBindingFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onDestroyView() {
        /*
            r6 = this;
            int r0 = id.dana.cashier.threeDS.CashierRisk3dsFragment.initRecordTimeStamp
            r1 = 1
            int r0 = r0 + r1
            int r2 = r0 % 128
            id.dana.cashier.threeDS.CashierRisk3dsFragment.NetworkUserEntityData$$ExternalSyntheticLambda2 = r2
            int r0 = r0 % 2
            r2 = 0
            r3 = 0
            if (r0 != 0) goto L1d
            super.onDestroyView()
            androidx.fragment.app.FragmentActivity r0 = r6.getActivity()
            boolean r0 = r0 instanceof id.dana.pay.PayActivity
            int r4 = r3.length     // Catch: java.lang.Throwable -> L1b
            if (r0 == 0) goto L5d
            goto L2d
        L1b:
            r0 = move-exception
            throw r0
        L1d:
            super.onDestroyView()
            androidx.fragment.app.FragmentActivity r0 = r6.getActivity()
            boolean r0 = r0 instanceof id.dana.pay.PayActivity
            if (r0 == 0) goto L2a
            r0 = 0
            goto L2b
        L2a:
            r0 = 1
        L2b:
            if (r0 == r1) goto L5d
        L2d:
            androidx.fragment.app.FragmentActivity r0 = r6.getActivity()
            if (r0 == 0) goto L5d
            int r4 = id.dana.cashier.threeDS.CashierRisk3dsFragment.initRecordTimeStamp     // Catch: java.lang.Exception -> L5b
            int r4 = r4 + 59
            int r5 = r4 % 128
            id.dana.cashier.threeDS.CashierRisk3dsFragment.NetworkUserEntityData$$ExternalSyntheticLambda2 = r5     // Catch: java.lang.Exception -> L5b
            int r4 = r4 % 2
            if (r4 != 0) goto L40
            goto L41
        L40:
            r1 = 0
        L41:
            if (r1 == 0) goto L4d
            android.view.Window r0 = r0.getWindow()
            int r1 = r3.length     // Catch: java.lang.Throwable -> L4b
            if (r0 == 0) goto L5d
            goto L53
        L4b:
            r0 = move-exception
            throw r0
        L4d:
            android.view.Window r0 = r0.getWindow()     // Catch: java.lang.Exception -> L59
            if (r0 == 0) goto L5d
        L53:
            r1 = 32
            r0.setSoftInputMode(r1)     // Catch: java.lang.Exception -> L59
            goto L5d
        L59:
            r0 = move-exception
            throw r0
        L5b:
            r0 = move-exception
            throw r0
        L5d:
            r6.getAuthRequestContext()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.threeDS.CashierRisk3dsFragment.onDestroyView():void");
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lid/dana/cashier/threeDS/CashierRisk3dsFragment$Companion;", "", "()V", "CASHIER_3DS_PREFIX_RESULT", "", "DEFAULT_FONT_SIZE", "", "ENCODING_TYPE", "HTTP_METHOD_POST", "IS_CARD_BINDING", "MASTER_CARD_3DS_CALLBACK", "META_3DS", "MIME_TYPE", "QUERY_METHOD", "REQUEST_KEY", "RESULT_KEY", "URL_PARAMS", "newInstance", "Lid/dana/cashier/threeDS/CashierRisk3dsFragment;", HummerConstants.BUNDLE, "Landroid/os/Bundle;", "showToolbar", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ CashierRisk3dsFragment KClassImpl$Data$declaredNonStaticMembers$2(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "");
            CashierRisk3dsFragment cashierRisk3dsFragment = new CashierRisk3dsFragment();
            cashierRisk3dsFragment.setArguments(bundle);
            CashierRisk3dsFragment.PlaceComponentResult(cashierRisk3dsFragment, true);
            return cashierRisk3dsFragment;
        }

        @JvmStatic
        public static CashierRisk3dsFragment getAuthRequestContext(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "");
            CashierRisk3dsFragment cashierRisk3dsFragment = new CashierRisk3dsFragment();
            cashierRisk3dsFragment.setArguments(bundle);
            CashierRisk3dsFragment.PlaceComponentResult(cashierRisk3dsFragment, false);
            return cashierRisk3dsFragment;
        }
    }

    private static String getAuthRequestContext(Map<String, String> map) {
        Iterator<Map.Entry<String, String>> it;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 47;
        initRecordTimeStamp = i % 128;
        if (!(i % 2 == 0)) {
            it = map.entrySet().iterator();
            Object obj = null;
            obj.hashCode();
        } else {
            it = map.entrySet().iterator();
        }
        String str = "";
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("<input type='hidden' name='");
            sb.append(next.getKey());
            sb.append("' value='");
            sb.append(StringsKt.replace$default(next.getValue(), " ", "+", false, 4, (Object) null));
            sb.append("'><br>");
            str = sb.toString();
            try {
                int i2 = initRecordTimeStamp + 3;
                try {
                    NetworkUserEntityData$$ExternalSyntheticLambda2 = i2 % 128;
                    int i3 = i2 % 2;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        return str;
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda2() {
        VB vb = this.PlaceComponentResult;
        if (vb == 0) {
            try {
                throw new IllegalArgumentException("Required value was null.".toString());
            } catch (Exception e) {
                throw e;
            }
        }
        FrameLayout frameLayout = ((FragmentCashierRisk3dsBinding) vb).BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "");
        VB vb2 = this.PlaceComponentResult;
        if (!(vb2 == 0)) {
            int i = initRecordTimeStamp + 81;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
            int i2 = i % 2;
            LogoProgressView logoProgressView = ((FragmentCashierRisk3dsBinding) vb2).getErrorConfigVersion;
            Intrinsics.checkNotNullExpressionValue(logoProgressView, "");
            VB vb3 = this.PlaceComponentResult;
            if ((vb3 == 0 ? '!' : (char) 1) == '!') {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            try {
                ConstraintLayout constraintLayout = ((FragmentCashierRisk3dsBinding) vb3).MyBillsEntityDataFactory;
                Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
                this.MyBillsEntityDataFactory = new ThreeDsLoadingHandler(frameLayout, logoProgressView, constraintLayout);
                int i3 = initRecordTimeStamp + 43;
                NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
                int i4 = i3 % 2;
                return;
            } catch (Exception e2) {
                throw e2;
            }
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:62:0x004e
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private final void NetworkUserEntityData$$ExternalSyntheticLambda7() {
        /*
            r4 = this;
            int r0 = id.dana.cashier.threeDS.CashierRisk3dsFragment.initRecordTimeStamp
            int r0 = r0 + 21
            int r1 = r0 % 128
            id.dana.cashier.threeDS.CashierRisk3dsFragment.NetworkUserEntityData$$ExternalSyntheticLambda2 = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            if (r0 == 0) goto L1f
            VB extends androidx.viewbinding.ViewBinding r0 = r4.PlaceComponentResult
            r3 = 0
            int r3 = r3.length     // Catch: java.lang.Throwable -> L1d
            if (r0 == 0) goto L1a
            r1 = 1
        L1a:
            if (r1 != r2) goto L42
            goto L23
        L1d:
            r0 = move-exception
            throw r0
        L1f:
            VB extends androidx.viewbinding.ViewBinding r0 = r4.PlaceComponentResult     // Catch: java.lang.Exception -> L50
            if (r0 == 0) goto L42
        L23:
            id.dana.databinding.FragmentCashierRisk3dsBinding r0 = (id.dana.databinding.FragmentCashierRisk3dsBinding) r0
            id.dana.richview.WebProgressView r0 = r0.lookAheadTest
            android.webkit.WebView r0 = r0.getWebView()
            if (r0 == 0) goto L37
            id.dana.cashier.threeDS.CashierRisk3dsFragment$setWebViewListener$1 r1 = new id.dana.cashier.threeDS.CashierRisk3dsFragment$setWebViewListener$1
            r1.<init>()
            android.webkit.WebViewClient r1 = (android.webkit.WebViewClient) r1
            com.fullstory.instrumentation.InstrumentInjector.setWebViewClient(r0, r1)
        L37:
            int r0 = id.dana.cashier.threeDS.CashierRisk3dsFragment.initRecordTimeStamp
            int r0 = r0 + 13
            int r1 = r0 % 128
            id.dana.cashier.threeDS.CashierRisk3dsFragment.NetworkUserEntityData$$ExternalSyntheticLambda2 = r1
            int r0 = r0 % 2
            return
        L42:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Required value was null."
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L50
            r0.<init>(r1)
            throw r0
        L4e:
            r0 = move-exception
            throw r0
        L50:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.threeDS.CashierRisk3dsFragment.NetworkUserEntityData$$ExternalSyntheticLambda7():void");
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda6() {
        VB vb = this.PlaceComponentResult;
        if ((vb != 0 ? (char) 29 : (char) 28) != 29) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 9;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        try {
            WebView webView = ((FragmentCashierRisk3dsBinding) vb).lookAheadTest.getWebView();
            if ((webView != null ? '\'' : (char) 19) != '\'') {
                return;
            }
            int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 61;
            initRecordTimeStamp = i3 % 128;
            int i4 = i3 % 2;
            WebSettings settings = webView.getSettings();
            settings.setDefaultFontSize(16);
            settings.setUseWideViewPort(true);
            settings.setSupportZoom(false);
            settings.setDisplayZoomControls(false);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingFragment
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        VB vb = this.PlaceComponentResult;
        if ((vb != 0 ? '%' : (char) 0) == 0) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        int i = initRecordTimeStamp + 75;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        if (i % 2 == 0) {
            Object obj = null;
            obj.hashCode();
        }
        ViewCashierToolbarBinding viewCashierToolbarBinding = ((FragmentCashierRisk3dsBinding) vb).moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(viewCashierToolbarBinding, "");
        if ((!this.getAuthRequestContext ? ')' : 'J') == 'J') {
            viewCashierToolbarBinding.PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.threeDS.CashierRisk3dsFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CashierRisk3dsFragment.getAuthRequestContext(CashierRisk3dsFragment.this);
                }
            });
            viewCashierToolbarBinding.MyBillsEntityDataFactory.setText(getString(R.string.card_verification));
            return;
        }
        ConstraintLayout constraintLayout = viewCashierToolbarBinding.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(8);
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 9;
        initRecordTimeStamp = i2 % 128;
        if (!(i2 % 2 != 0)) {
            return;
        }
        int i3 = 8 / 0;
    }

    private static void a(int i, byte[] bArr, char[] cArr, int[] iArr, Object[] objArr) {
        int i2;
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr2 = lookAheadTest;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i3 = 0;
            while (true) {
                if ((i3 < length ? '6' : '0') != '6') {
                    break;
                }
                cArr3[i3] = (char) (cArr2[i3] ^ 4571606982258105150L);
                i3++;
            }
            int i4 = $11 + 21;
            $10 = i4 % 128;
            int i5 = i4 % 2;
            cArr2 = cArr3;
        }
        int i6 = (int) (4571606982258105150L ^ getErrorConfigVersion);
        if (NetworkUserEntityData$$ExternalSyntheticLambda1) {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
            char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i6);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr4);
            return;
        }
        try {
            if (GetContactSyncConfig) {
                int i7 = $10 + 59;
                $11 = i7 % 128;
                int i8 = i7 % 2;
                bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
                char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                    cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i6);
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
                }
                objArr[0] = new String(cArr5);
                return;
            }
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
            try {
                char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
                while (true) {
                    if (!(bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult)) {
                        objArr[0] = new String(cArr6);
                        return;
                    }
                    int i9 = $11 + 113;
                    $10 = i9 % 128;
                    if (i9 % 2 != 0) {
                        cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 0) + bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] >> i6);
                        i2 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory + 0;
                    } else {
                        cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i6);
                        i2 = bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory + 1;
                    }
                    bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = i2;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
