package id.dana.bottomsheet;

import android.app.Dialog;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen;
import com.ethanhua.skeleton.Skeleton;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.bottomsheet.ServicesBottomSheetDialog$bottomSheetCallback$2;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.FeatureModule;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.danah5.DanaH5;
import id.dana.danah5.DanaH5Key;
import id.dana.data.config.DeviceInformationProvider;
import id.dana.di.ComponentHolder;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerBottomSheetServiceComponent;
import id.dana.di.modules.OauthModule;
import id.dana.mapper.ThirdPartyServicesUrlMapper;
import id.dana.model.ThirdPartyService;
import id.dana.tracker.spm.ServicesTracker;
import id.dana.utils.UrlUtil;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.whenAvailable;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 R2\u00020\u0001:\u0002SRB\u000f\u0012\u0006\u0010\u0011\u001a\u00020=¢\u0006\u0004\bP\u0010QJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0010\u0010\u0004J\u001f\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u000f\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002¢\u0006\u0004\b\u000f\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0019\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001b\u001a\u00020\u001aH\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001e\u001a\u00020\u001a2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00160\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010 \u001a\u00020\u001a2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00160\u001dH\u0002¢\u0006\u0004\b \u0010\u001fJ\u001d\u0010!\u001a\u00020\u001a2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00160\u001dH\u0002¢\u0006\u0004\b!\u0010\u001fJ\u000f\u0010\"\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\"\u0010\u0004J\u0017\u0010 \u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020#H\u0002¢\u0006\u0004\b \u0010$J\u0017\u0010!\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\fH\u0002¢\u0006\u0004\b!\u0010%J\u000f\u0010&\u001a\u00020\u0002H\u0014¢\u0006\u0004\b&\u0010\u0004J\u0017\u0010!\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0016H\u0002¢\u0006\u0004\b!\u0010'J\u000f\u0010(\u001a\u00020\u0002H\u0016¢\u0006\u0004\b(\u0010\u0004J\u0019\u0010\u001e\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0004\b\u001e\u0010$J3\u0010+\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020#2\b\u0010)\u001a\u0004\u0018\u00010#2\b\u0010*\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001e\u0010'J\u0017\u0010+\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020#H\u0002¢\u0006\u0004\b+\u0010$J\u000f\u0010-\u001a\u00020\u0002H\u0002¢\u0006\u0004\b-\u0010\u0004J\u000f\u0010.\u001a\u00020\u0002H\u0002¢\u0006\u0004\b.\u0010\u0004J\u000f\u0010/\u001a\u00020\u0002H\u0002¢\u0006\u0004\b/\u0010\u0004J\r\u0010+\u001a\u00020\u0002¢\u0006\u0004\b+\u0010\u0004R\u001b\u0010\u000f\u001a\u0002008CX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001a\u00106\u001a\u0002058\u0007X\u0087&¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b\u001e\u00108R\u001a\u0010:\u001a\u0002098\u0007X\u0087&¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b \u0010<R\u0014\u0010!\u001a\u00020=8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010>R\u001a\u0010@\u001a\u00020?8\u0007X\u0087&¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u001a\u0010E\u001a\u00020D8\u0007X\u0087&¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\b!\u0010GR\u0016\u0010+\u001a\u00020H8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b3\u0010IR\u0014\u0010 \u001a\u00020J8CX\u0082\u0004¢\u0006\u0006\u001a\u0004\bK\u0010LR\u001d\u0010\u001e\u001a\u0004\u0018\u00010M8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u00102\u001a\u0004\bN\u0010O"}, d2 = {"Lid/dana/bottomsheet/ServicesBottomSheetDialog;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "", "getErrorConfigVersion", "()V", "lookAheadTest", "Landroid/widget/FrameLayout;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "()Landroid/widget/FrameLayout;", "", "getDimAmount", "()F", "", "getLayout", "()I", "KClassImpl$Data$declaredNonStaticMembers$2", IAPSyncCommand.COMMAND_INIT, "p0", "p1", "initBottomSheet", "(II)V", "", "Lid/dana/model/ThirdPartyService;", "(Ljava/util/List;)V", "NetworkUserEntityData$$ExternalSyntheticLambda2", "GetContactSyncConfig", "", "isFullDialogHeightRequired", "()Z", "", "PlaceComponentResult", "(Ljava/util/List;)Z", "MyBillsEntityDataFactory", "getAuthRequestContext", "onDismiss", "", "(Ljava/lang/String;)V", "(I)V", "onShow", "(Lid/dana/model/ThirdPartyService;)V", "onStart", "p2", "p3", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/model/ThirdPartyService;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "DatabaseTableConfigUtil", "NetworkUserEntityData$$ExternalSyntheticLambda1", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lid/dana/bottomsheet/ServicesBottomSheetDialog$bottomSheetCallback$2$1;", "scheduleImpl", "Lkotlin/Lazy;", "moveToNextValue", "()Lid/dana/bottomsheet/ServicesBottomSheetDialog$bottomSheetCallback$2$1;", "Lid/dana/data/config/DeviceInformationProvider;", "deviceInformationProvider", "Lid/dana/data/config/DeviceInformationProvider;", "()Lid/dana/data/config/DeviceInformationProvider;", "Lid/dana/contract/deeplink/path/FeatureContract$Presenter;", "featurePresenter", "Lid/dana/contract/deeplink/path/FeatureContract$Presenter;", "()Lid/dana/contract/deeplink/path/FeatureContract$Presenter;", "Lid/dana/bottomsheet/ServicesBottomSheetDialog$Builder;", "Lid/dana/bottomsheet/ServicesBottomSheetDialog$Builder;", "Lid/dana/contract/services/ServicesContract$Presenter;", "presenter", "Lid/dana/contract/services/ServicesContract$Presenter;", "newProxyInstance", "()Lid/dana/contract/services/ServicesContract$Presenter;", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "readLinkPropertiesPresenter", "Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "()Lid/dana/contract/deeplink/ReadLinkPropertiesContract$Presenter;", "Lid/dana/bottomsheet/ServicesBottomSheetListAdapter;", "Lid/dana/bottomsheet/ServicesBottomSheetListAdapter;", "Lid/dana/contract/services/ServicesContract$View;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "()Lid/dana/contract/services/ServicesContract$View;", "Lcom/ethanhua/skeleton/RecyclerViewSkeletonScreen;", "initRecordTimeStamp", "()Lcom/ethanhua/skeleton/RecyclerViewSkeletonScreen;", "<init>", "(Lid/dana/bottomsheet/ServicesBottomSheetDialog$Builder;)V", "Companion", "Builder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ServicesBottomSheetDialog extends BaseBottomSheetDialogFragment {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int GetContactSyncConfig = 0;
    private static char[] NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
    private static long NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
    private static int initRecordTimeStamp = 1;
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2;
    @Inject
    public DeviceInformationProvider deviceInformationProvider;
    @Inject
    public FeatureContract.Presenter featurePresenter;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final Builder getAuthRequestContext;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private ServicesBottomSheetListAdapter BuiltInFictitiousFunctionClassFactory;
    @Inject
    public ServicesContract.Presenter presenter;
    @Inject
    public ReadLinkPropertiesContract.Presenter readLinkPropertiesPresenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker] */
    static {
        scheduleImpl();
        ?? r1 = 0;
        INSTANCE = new Companion(r1);
        int i = GetContactSyncConfig + 79;
        initRecordTimeStamp = i % 128;
        if ((i % 2 == 0 ? Typography.quote : (char) 14) != 14) {
            int length = r1.length;
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(ServicesBottomSheetDialog servicesBottomSheetDialog) {
        try {
            int i = initRecordTimeStamp + 123;
            GetContactSyncConfig = i % 128;
            if ((i % 2 != 0 ? Typography.less : (char) 19) != 19) {
                try {
                    lookAheadTest(servicesBottomSheetDialog);
                    Object obj = null;
                    obj.hashCode();
                } catch (Exception e) {
                    throw e;
                }
            } else {
                lookAheadTest(servicesBottomSheetDialog);
            }
            int i2 = initRecordTimeStamp + 99;
            GetContactSyncConfig = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(ServicesBottomSheetDialog servicesBottomSheetDialog) {
        int i = GetContactSyncConfig + 5;
        initRecordTimeStamp = i % 128;
        boolean z = i % 2 != 0;
        GetContactSyncConfig(servicesBottomSheetDialog);
        if (z) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(View view, View view2) {
        try {
            int i = GetContactSyncConfig + 75;
            initRecordTimeStamp = i % 128;
            int i2 = i % 2;
            getAuthRequestContext(view, view2);
            int i3 = GetContactSyncConfig + 93;
            initRecordTimeStamp = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(ServicesBottomSheetDialog servicesBottomSheetDialog) {
        int i = initRecordTimeStamp + 17;
        GetContactSyncConfig = i % 128;
        boolean z = i % 2 == 0;
        moveToNextValue(servicesBottomSheetDialog);
        if (z) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(ServicesBottomSheetDialog servicesBottomSheetDialog, int i) {
        int i2 = GetContactSyncConfig + 107;
        initRecordTimeStamp = i2 % 128;
        int i3 = i2 % 2;
        KClassImpl$Data$declaredNonStaticMembers$2(servicesBottomSheetDialog, i);
        try {
            int i4 = initRecordTimeStamp + 77;
            GetContactSyncConfig = i4 % 128;
            if ((i4 % 2 != 0 ? (char) 1 : 'V') != 1) {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void PlaceComponentResult(ServicesBottomSheetDialog servicesBottomSheetDialog) {
        int i = initRecordTimeStamp + 69;
        GetContactSyncConfig = i % 128;
        int i2 = i % 2;
        NetworkUserEntityData$$ExternalSyntheticLambda0(servicesBottomSheetDialog);
        try {
            int i3 = GetContactSyncConfig + 1;
            try {
                initRecordTimeStamp = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static /* synthetic */ void PlaceComponentResult(ServicesBottomSheetDialog servicesBottomSheetDialog, String str) {
        int i = GetContactSyncConfig + 53;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        BuiltInFictitiousFunctionClassFactory(servicesBottomSheetDialog, str);
        int i3 = initRecordTimeStamp + 37;
        GetContactSyncConfig = i3 % 128;
        int i4 = i3 % 2;
    }

    private void PrepareContext() {
        try {
            int i = GetContactSyncConfig + 5;
            initRecordTimeStamp = i % 128;
            if ((i % 2 == 0 ? (char) 27 : 'V') != 'V') {
                this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
                int i2 = 2 / 0;
            } else {
                this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
            }
            int i3 = initRecordTimeStamp + 15;
            GetContactSyncConfig = i3 % 128;
            if ((i3 % 2 != 0 ? '_' : (char) 19) != 19) {
                int i4 = 34 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void getAuthRequestContext(ServicesBottomSheetDialog servicesBottomSheetDialog) {
        int i = initRecordTimeStamp + 123;
        GetContactSyncConfig = i % 128;
        if (!(i % 2 != 0)) {
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda1(servicesBottomSheetDialog);
                return;
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            NetworkUserEntityData$$ExternalSyntheticLambda1(servicesBottomSheetDialog);
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e2) {
            throw e2;
        }
    }

    static void scheduleImpl() {
        NetworkUserEntityData$$ExternalSyntheticLambda0 = new char[]{12222, 44421, 11141, 43452, 10160, 42447, 9158, 41413};
        NetworkUserEntityData$$ExternalSyntheticLambda2 = 4841636895040827715L;
    }

    public final View MyBillsEntityDataFactory(int i) {
        try {
            Map<Integer, View> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
            try {
                View view = map.get(Integer.valueOf(i));
                if ((view == null ? '=' : 'C') != '=') {
                    return view;
                }
                View view2 = getView();
                if (view2 != null) {
                    int i2 = GetContactSyncConfig + 115;
                    initRecordTimeStamp = i2 % 128;
                    int i3 = i2 % 2;
                    View findViewById = view2.findViewById(i);
                    if (findViewById != null) {
                        map.put(Integer.valueOf(i), findViewById);
                        int i4 = GetContactSyncConfig + 85;
                        initRecordTimeStamp = i4 % 128;
                        int i5 = i4 % 2;
                        return findViewById;
                    }
                }
                return null;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final float getDimAmount() {
        int i = GetContactSyncConfig + 81;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        int i3 = initRecordTimeStamp + 95;
        GetContactSyncConfig = i3 % 128;
        int i4 = i3 % 2;
        return 0.5f;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final int getLayout() {
        int i = initRecordTimeStamp + 67;
        GetContactSyncConfig = i % 128;
        Object obj = null;
        if ((i % 2 != 0 ? '3' : '\n') == '3') {
            obj.hashCode();
        }
        int i2 = initRecordTimeStamp + 5;
        GetContactSyncConfig = i2 % 128;
        if (i2 % 2 == 0) {
            return R.layout.view_bottom_sheet_list;
        }
        obj.hashCode();
        return R.layout.view_bottom_sheet_list;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final boolean isFullDialogHeightRequired() {
        int i = GetContactSyncConfig + 63;
        initRecordTimeStamp = i % 128;
        if (i % 2 == 0) {
        }
        return false;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        try {
            int i = GetContactSyncConfig + 119;
            try {
                initRecordTimeStamp = i % 128;
                boolean z = i % 2 != 0;
                super.onDestroyView();
                PrepareContext();
                if (!z) {
                    Object[] objArr = null;
                    int length = objArr.length;
                }
                int i2 = initRecordTimeStamp + 5;
                GetContactSyncConfig = i2 % 128;
                int i3 = i2 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public ServicesBottomSheetDialog(Builder builder) {
        try {
            Intrinsics.checkNotNullParameter(builder, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();
            this.getAuthRequestContext = builder;
            this.PlaceComponentResult = LazyKt.lazy(new Function0<RecyclerViewSkeletonScreen>() { // from class: id.dana.bottomsheet.ServicesBottomSheetDialog$skeletonShimmering$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final RecyclerViewSkeletonScreen invoke() {
                    RecyclerView recyclerView = (RecyclerView) ServicesBottomSheetDialog.this.MyBillsEntityDataFactory(R.id.rv_bottom_sheet);
                    ServicesBottomSheetListAdapter servicesBottomSheetListAdapter = null;
                    if (recyclerView != null) {
                        ServicesBottomSheetDialog servicesBottomSheetDialog = ServicesBottomSheetDialog.this;
                        RecyclerViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(recyclerView);
                        ServicesBottomSheetListAdapter errorConfigVersion = ServicesBottomSheetDialog.getErrorConfigVersion(servicesBottomSheetDialog);
                        if (errorConfigVersion == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                        } else {
                            servicesBottomSheetListAdapter = errorConfigVersion;
                        }
                        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = servicesBottomSheetListAdapter;
                        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = R.layout.viewholder_bottomsheet_space_item;
                        BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = 2500;
                        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = 8;
                        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = true;
                        BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.getContext(), R.color.f27082131100491);
                        BuiltInFictitiousFunctionClassFactory.lookAheadTest = 20;
                        RecyclerViewSkeletonScreen recyclerViewSkeletonScreen = new RecyclerViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
                        recyclerViewSkeletonScreen.MyBillsEntityDataFactory();
                        return recyclerViewSkeletonScreen;
                    }
                    return null;
                }
            });
            this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<ServicesBottomSheetDialog$bottomSheetCallback$2.AnonymousClass1>() { // from class: id.dana.bottomsheet.ServicesBottomSheetDialog$bottomSheetCallback$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.bottomsheet.ServicesBottomSheetDialog$bottomSheetCallback$2$1] */
                @Override // kotlin.jvm.functions.Function0
                public final AnonymousClass1 invoke() {
                    final ServicesBottomSheetDialog servicesBottomSheetDialog = ServicesBottomSheetDialog.this;
                    return new BottomSheetBehavior.BottomSheetCallback() { // from class: id.dana.bottomsheet.ServicesBottomSheetDialog$bottomSheetCallback$2.1
                        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                        public final void onSlide(View p0, float p1) {
                            Intrinsics.checkNotNullParameter(p0, "");
                        }

                        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                        public final void onStateChanged(View p0, int p1) {
                            Intrinsics.checkNotNullParameter(p0, "");
                            if (5 == p1) {
                                Function0<Unit> function0 = ServicesBottomSheetDialog.scheduleImpl(ServicesBottomSheetDialog.this).PlaceComponentResult;
                                if (function0 != null) {
                                    function0.invoke();
                                }
                                ServicesBottomSheetDialog.this.dismissAllowingStateLoss();
                            }
                        }
                    };
                }
            });
            AppCompatDelegate.BuiltInFictitiousFunctionClassFactory(true);
        } catch (Exception e) {
            throw e;
        }
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(ServicesBottomSheetDialog servicesBottomSheetDialog, ThirdPartyService thirdPartyService, String str, String str2, String str3) {
        try {
            int i = initRecordTimeStamp + 57;
            try {
                GetContactSyncConfig = i % 128;
                int i2 = i % 2;
                servicesBottomSheetDialog.BuiltInFictitiousFunctionClassFactory(thirdPartyService, str, str2, str3);
                int i3 = GetContactSyncConfig + 43;
                initRecordTimeStamp = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(ServicesBottomSheetDialog servicesBottomSheetDialog, String str) {
        int i = GetContactSyncConfig + 67;
        initRecordTimeStamp = i % 128;
        if (!(i % 2 == 0)) {
            servicesBottomSheetDialog.PlaceComponentResult(str);
            return;
        }
        servicesBottomSheetDialog.PlaceComponentResult(str);
        int i2 = 87 / 0;
    }

    public static final /* synthetic */ void PlaceComponentResult(ServicesBottomSheetDialog servicesBottomSheetDialog, List list) {
        int i = GetContactSyncConfig + 43;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        servicesBottomSheetDialog.KClassImpl$Data$declaredNonStaticMembers$2(list);
        int i3 = GetContactSyncConfig + 31;
        initRecordTimeStamp = i3 % 128;
        int i4 = i3 % 2;
    }

    public static final /* synthetic */ void getAuthRequestContext(ServicesBottomSheetDialog servicesBottomSheetDialog, String str) {
        int i = initRecordTimeStamp + 35;
        GetContactSyncConfig = i % 128;
        int i2 = i % 2;
        servicesBottomSheetDialog.MyBillsEntityDataFactory(str);
        int i3 = initRecordTimeStamp + 123;
        GetContactSyncConfig = i3 % 128;
        if (i3 % 2 != 0) {
            int i4 = 57 / 0;
        }
    }

    public static final /* synthetic */ ServicesBottomSheetListAdapter getErrorConfigVersion(ServicesBottomSheetDialog servicesBottomSheetDialog) {
        try {
            int i = initRecordTimeStamp + 59;
            try {
                GetContactSyncConfig = i % 128;
                if (!(i % 2 != 0)) {
                    return servicesBottomSheetDialog.BuiltInFictitiousFunctionClassFactory;
                }
                ServicesBottomSheetListAdapter servicesBottomSheetListAdapter = servicesBottomSheetDialog.BuiltInFictitiousFunctionClassFactory;
                Object[] objArr = null;
                int length = objArr.length;
                return servicesBottomSheetListAdapter;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static final /* synthetic */ Builder scheduleImpl(ServicesBottomSheetDialog servicesBottomSheetDialog) {
        int i = GetContactSyncConfig + 81;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        try {
            Builder builder = servicesBottomSheetDialog.getAuthRequestContext;
            try {
                int i3 = initRecordTimeStamp + 41;
                GetContactSyncConfig = i3 % 128;
                if ((i3 % 2 != 0 ? '2' : '4') != '2') {
                    return builder;
                }
                int i4 = 43 / 0;
                return builder;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    /* renamed from: getBottomSheet */
    public final /* synthetic */ View getPlaceComponentResult() {
        int i = GetContactSyncConfig + 79;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        try {
            FrameLayout NetworkUserEntityData$$ExternalSyntheticLambda8 = NetworkUserEntityData$$ExternalSyntheticLambda8();
            int i3 = GetContactSyncConfig + 119;
            initRecordTimeStamp = i3 % 128;
            int i4 = i3 % 2;
            return NetworkUserEntityData$$ExternalSyntheticLambda8;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "newProxyInstance")
    private ServicesContract.Presenter newProxyInstance() {
        int i = initRecordTimeStamp + 55;
        GetContactSyncConfig = i % 128;
        int i2 = i % 2;
        ServicesContract.Presenter presenter = this.presenter;
        Object obj = null;
        if ((presenter != null ? '2' : '#') != '2') {
            try {
                Intrinsics.throwUninitializedPropertyAccessException("");
                return null;
            } catch (Exception e) {
                throw e;
            }
        }
        int i3 = initRecordTimeStamp + 113;
        GetContactSyncConfig = i3 % 128;
        int i4 = i3 % 2;
        int i5 = initRecordTimeStamp + 103;
        GetContactSyncConfig = i5 % 128;
        if (i5 % 2 == 0) {
            return presenter;
        }
        obj.hashCode();
        return presenter;
    }

    @JvmName(name = "PlaceComponentResult")
    public final DeviceInformationProvider PlaceComponentResult() {
        int i = GetContactSyncConfig + 7;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        DeviceInformationProvider deviceInformationProvider = this.deviceInformationProvider;
        if (deviceInformationProvider != null) {
            int i3 = initRecordTimeStamp + 123;
            GetContactSyncConfig = i3 % 128;
            int i4 = i3 % 2;
            return deviceInformationProvider;
        }
        try {
            Intrinsics.throwUninitializedPropertyAccessException("");
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0012, code lost:
    
        if (r0 != null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0022, code lost:
    
        if ((r0 != null ? '*' : 'M') != '*') goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0024, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0029, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x002b, code lost:
    
        r1 = id.dana.bottomsheet.ServicesBottomSheetDialog.GetContactSyncConfig + 125;
        id.dana.bottomsheet.ServicesBottomSheetDialog.initRecordTimeStamp = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0037, code lost:
    
        if ((r1 % 2) != 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0039, code lost:
    
        r1 = '\r';
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x003c, code lost:
    
        r1 = ')';
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x003e, code lost:
    
        if (r1 == ')') goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0042, code lost:
    
        r1 = 94 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0044, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0047, code lost:
    
        return r0;
     */
    @kotlin.jvm.JvmName(name = "getAuthRequestContext")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final id.dana.contract.deeplink.ReadLinkPropertiesContract.Presenter getAuthRequestContext() {
        /*
            r3 = this;
            int r0 = id.dana.bottomsheet.ServicesBottomSheetDialog.GetContactSyncConfig     // Catch: java.lang.Exception -> L48
            int r0 = r0 + 113
            int r1 = r0 % 128
            id.dana.bottomsheet.ServicesBottomSheetDialog.initRecordTimeStamp = r1     // Catch: java.lang.Exception -> L48
            int r0 = r0 % 2
            if (r0 != 0) goto L17
            id.dana.contract.deeplink.ReadLinkPropertiesContract$Presenter r0 = r3.readLinkPropertiesPresenter
            r1 = 56
            int r1 = r1 / 0
            if (r0 == 0) goto L24
            goto L2b
        L15:
            r0 = move-exception
            throw r0
        L17:
            id.dana.contract.deeplink.ReadLinkPropertiesContract$Presenter r0 = r3.readLinkPropertiesPresenter
            r1 = 42
            if (r0 == 0) goto L20
            r2 = 42
            goto L22
        L20:
            r2 = 77
        L22:
            if (r2 == r1) goto L2b
        L24:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)     // Catch: java.lang.Exception -> L48
            r0 = 0
            return r0
        L2b:
            int r1 = id.dana.bottomsheet.ServicesBottomSheetDialog.GetContactSyncConfig
            int r1 = r1 + 125
            int r2 = r1 % 128
            id.dana.bottomsheet.ServicesBottomSheetDialog.initRecordTimeStamp = r2
            int r1 = r1 % 2
            r2 = 41
            if (r1 != 0) goto L3c
            r1 = 13
            goto L3e
        L3c:
            r1 = 41
        L3e:
            if (r1 == r2) goto L47
            r1 = 94
            int r1 = r1 / 0
            return r0
        L45:
            r0 = move-exception
            throw r0
        L47:
            return r0
        L48:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.bottomsheet.ServicesBottomSheetDialog.getAuthRequestContext():id.dana.contract.deeplink.ReadLinkPropertiesContract$Presenter");
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    public final FeatureContract.Presenter MyBillsEntityDataFactory() {
        int i = GetContactSyncConfig + 7;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        FeatureContract.Presenter presenter = this.featurePresenter;
        if (!(presenter != null)) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            return null;
        }
        try {
            int i3 = GetContactSyncConfig + 33;
            initRecordTimeStamp = i3 % 128;
            int i4 = i3 % 2;
            return presenter;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "initRecordTimeStamp")
    private final RecyclerViewSkeletonScreen initRecordTimeStamp() {
        int i = GetContactSyncConfig + 57;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        try {
            RecyclerViewSkeletonScreen recyclerViewSkeletonScreen = (RecyclerViewSkeletonScreen) this.PlaceComponentResult.getValue();
            int i3 = initRecordTimeStamp + 99;
            GetContactSyncConfig = i3 % 128;
            int i4 = i3 % 2;
            return recyclerViewSkeletonScreen;
        } catch (Exception e) {
            throw e;
        }
    }

    @JvmName(name = "moveToNextValue")
    private final ServicesBottomSheetDialog$bottomSheetCallback$2.AnonymousClass1 moveToNextValue() {
        ServicesBottomSheetDialog$bottomSheetCallback$2.AnonymousClass1 anonymousClass1;
        int i = initRecordTimeStamp + 125;
        GetContactSyncConfig = i % 128;
        Object[] objArr = null;
        if ((i % 2 != 0 ? (char) 22 : (char) 19) != 22) {
            anonymousClass1 = (ServicesBottomSheetDialog$bottomSheetCallback$2.AnonymousClass1) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
        } else {
            anonymousClass1 = (ServicesBottomSheetDialog$bottomSheetCallback$2.AnonymousClass1) this.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
            int length = objArr.length;
        }
        try {
            int i2 = GetContactSyncConfig + 15;
            initRecordTimeStamp = i2 % 128;
            if ((i2 % 2 == 0 ? 'L' : (char) 15) != 15) {
                objArr.hashCode();
                return anonymousClass1;
            }
            return anonymousClass1;
        } catch (Exception e) {
            throw e;
        }
    }

    private FrameLayout NetworkUserEntityData$$ExternalSyntheticLambda8() {
        int i = GetContactSyncConfig + 79;
        initRecordTimeStamp = i % 128;
        if ((i % 2 == 0 ? '5' : '_') != '5') {
            return (FrameLayout) MyBillsEntityDataFactory(R.id.res_0x7f0a0742_flowablesequenceequal_equalcoordinator);
        }
        FrameLayout frameLayout = (FrameLayout) MyBillsEntityDataFactory(R.id.res_0x7f0a0742_flowablesequenceequal_equalcoordinator);
        Object obj = null;
        obj.hashCode();
        return frameLayout;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        int i = GetContactSyncConfig + 67;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        super.onStart();
        lookAheadTest();
        int i3 = initRecordTimeStamp + 81;
        GetContactSyncConfig = i3 % 128;
        if ((i3 % 2 != 0 ? '0' : (char) 19) != 19) {
            int i4 = 41 / 0;
        }
    }

    private final void lookAheadTest() {
        final View view;
        int i = initRecordTimeStamp + 55;
        GetContactSyncConfig = i % 128;
        int i2 = i % 2;
        Dialog dialog = getDialog();
        Object obj = null;
        if (dialog != null) {
            int i3 = initRecordTimeStamp + 41;
            GetContactSyncConfig = i3 % 128;
            int i4 = i3 % 2;
            view = dialog.findViewById(R.id.design_bottom_sheet);
        } else {
            view = null;
        }
        ViewGroup.LayoutParams layoutParams = (view != null ? (char) 21 : '_') != 21 ? null : view.getLayoutParams();
        if (!(layoutParams == null)) {
            int i5 = GetContactSyncConfig + 77;
            initRecordTimeStamp = i5 % 128;
            int i6 = i5 % 2;
            layoutParams.height = -1;
            if (i6 == 0) {
                obj.hashCode();
            }
        }
        final View view2 = getView();
        if (view2 != null) {
            view2.post(new Runnable() { // from class: id.dana.bottomsheet.ServicesBottomSheetDialog$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    ServicesBottomSheetDialog.MyBillsEntityDataFactory(view2, view);
                }
            });
            int i7 = initRecordTimeStamp + 91;
            GetContactSyncConfig = i7 % 128;
            int i8 = i7 % 2;
        }
    }

    private static final void getAuthRequestContext(View view, View view2) {
        int i = initRecordTimeStamp + 37;
        GetContactSyncConfig = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(view, "");
        ViewParent parent = view.getParent();
        if (parent == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        }
        int i3 = initRecordTimeStamp + 115;
        GetContactSyncConfig = i3 % 128;
        int i4 = i3 % 2;
        ViewGroup.LayoutParams layoutParams = ((View) parent).getLayoutParams();
        if (!(layoutParams != null)) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        }
        try {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).lookAheadTest;
            if (behavior == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetBehavior<@[FlexibleNullability] android.view.View?>");
            }
            ((BottomSheetBehavior) behavior).setPeekHeight(view.getMeasuredHeight());
            ViewParent parent2 = view2 != null ? view2.getParent() : null;
            try {
                if (parent2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.View");
                }
                int i5 = GetContactSyncConfig + 67;
                initRecordTimeStamp = i5 % 128;
                int i6 = i5 % 2;
                ((View) parent2).setBackgroundColor(0);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void init() {
        try {
            int i = initRecordTimeStamp + 53;
            GetContactSyncConfig = i % 128;
            if (i % 2 == 0) {
                super.init();
                GetContactSyncConfig();
                return;
            }
            super.init();
            GetContactSyncConfig();
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void initBottomSheet(int p0, int p1) {
        try {
            requireActivity().getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
            super.initBottomSheet(p0, p1);
            int i = initRecordTimeStamp + 107;
            GetContactSyncConfig = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private static boolean PlaceComponentResult(List<ThirdPartyService> p0) {
        int i = GetContactSyncConfig + 45;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        try {
            if (p0.size() != 2) {
                return false;
            }
            if ((MyBillsEntityDataFactory(p0) ? JSONLexer.EOI : Typography.amp) != '&') {
                int i3 = initRecordTimeStamp + 7;
                try {
                    GetContactSyncConfig = i3 % 128;
                    int i4 = i3 % 2;
                    return true;
                } catch (Exception e) {
                    throw e;
                }
            }
            return false;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static boolean MyBillsEntityDataFactory(List<ThirdPartyService> p0) {
        try {
            int i = initRecordTimeStamp + 37;
            GetContactSyncConfig = i % 128;
            int i2 = i % 2;
            String str = p0.get(p0.size() - 1).newProxyInstance;
            if (!(str == null)) {
                int i3 = GetContactSyncConfig + 115;
                initRecordTimeStamp = i3 % 128;
                if (i3 % 2 == 0) {
                    int length = str.length();
                    Object obj = null;
                    obj.hashCode();
                    if (!(length != 0)) {
                        return true;
                    }
                } else if (str.length() == 0) {
                    return true;
                }
                int i4 = initRecordTimeStamp + 61;
                GetContactSyncConfig = i4 % 128;
                int i5 = i4 % 2;
                return false;
            }
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0038 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean getAuthRequestContext(java.util.List<id.dana.model.ThirdPartyService> r3) {
        /*
            int r0 = r3.size()
            r1 = 0
            r2 = 1
            if (r0 == r2) goto La
            r0 = 1
            goto Lb
        La:
            r0 = 0
        Lb:
            if (r0 == r2) goto Lf
        Ld:
            r1 = 1
            goto L25
        Lf:
            boolean r3 = PlaceComponentResult(r3)
            if (r3 == 0) goto L17
            r3 = 0
            goto L18
        L17:
            r3 = 1
        L18:
            if (r3 == r2) goto L1b
            goto Ld
        L1b:
            int r3 = id.dana.bottomsheet.ServicesBottomSheetDialog.GetContactSyncConfig
            int r3 = r3 + 85
            int r0 = r3 % 128
            id.dana.bottomsheet.ServicesBottomSheetDialog.initRecordTimeStamp = r0
            int r3 = r3 % 2
        L25:
            int r3 = id.dana.bottomsheet.ServicesBottomSheetDialog.initRecordTimeStamp
            int r3 = r3 + 113
            int r0 = r3 % 128
            id.dana.bottomsheet.ServicesBottomSheetDialog.GetContactSyncConfig = r0
            int r3 = r3 % 2
            if (r3 == 0) goto L38
            r3 = 0
            r3.hashCode()     // Catch: java.lang.Throwable -> L36
            return r1
        L36:
            r3 = move-exception
            throw r3
        L38:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.bottomsheet.ServicesBottomSheetDialog.getAuthRequestContext(java.util.List):boolean");
    }

    private final void getErrorConfigVersion() {
        int i = GetContactSyncConfig + 79;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        ServicesBottomSheetListAdapter servicesBottomSheetListAdapter = this.BuiltInFictitiousFunctionClassFactory;
        if ((servicesBottomSheetListAdapter == null ? (char) 16 : (char) 4) != 4) {
            int i3 = initRecordTimeStamp + 109;
            GetContactSyncConfig = i3 % 128;
            if (i3 % 2 != 0) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                int i4 = 85 / 0;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            servicesBottomSheetListAdapter = null;
        }
        List<ThirdPartyService> items = servicesBottomSheetListAdapter.getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        if (!getAuthRequestContext(items)) {
            return;
        }
        try {
            ThirdPartyService thirdPartyService = items.get(0);
            try {
                Intrinsics.checkNotNullExpressionValue(thirdPartyService, "");
                getAuthRequestContext(thirdPartyService);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x001a, code lost:
    
        if ((r0 == null) != true) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0023, code lost:
    
        if (r0 != null) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0029, code lost:
    
        if (r0.length() == 0) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x002c, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0031, code lost:
    
        if ((!r1) == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0033, code lost:
    
        r0 = ':';
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0036, code lost:
    
        r0 = 14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0038, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0039, code lost:
    
        if (r0 == ':') goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x003c, code lost:
    
        r0 = id.dana.bottomsheet.ServicesBottomSheetDialog.GetContactSyncConfig + 37;
        id.dana.bottomsheet.ServicesBottomSheetDialog.initRecordTimeStamp = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0048, code lost:
    
        if ((r0 % 2) != 0) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x004a, code lost:
    
        r0 = 25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x004d, code lost:
    
        r0 = '`';
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x004f, code lost:
    
        if (r0 == 25) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0052, code lost:
    
        r2.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0055, code lost:
    
        r2 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0056, code lost:
    
        if (r2 == null) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0058, code lost:
    
        r0 = id.dana.bottomsheet.ServicesBottomSheetDialog.initRecordTimeStamp + 125;
        id.dana.bottomsheet.ServicesBottomSheetDialog.GetContactSyncConfig = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0062, code lost:
    
        PlaceComponentResult(r5);
        ((androidx.coordinatorlayout.widget.CoordinatorLayout) MyBillsEntityDataFactory(id.dana.R.id.layout_coordinator)).setVisibility(8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0073, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0074, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0075, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void getAuthRequestContext(id.dana.model.ThirdPartyService r5) {
        /*
            r4 = this;
            int r0 = id.dana.bottomsheet.ServicesBottomSheetDialog.initRecordTimeStamp     // Catch: java.lang.Exception -> L78
            int r0 = r0 + 123
            int r1 = r0 % 128
            id.dana.bottomsheet.ServicesBottomSheetDialog.GetContactSyncConfig = r1     // Catch: java.lang.Exception -> L78
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L1f
            java.lang.String r0 = r5.NetworkUserEntityData$$ExternalSyntheticLambda8
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r3 = 24
            int r3 = r3 / r1
            if (r0 == 0) goto L19
            r3 = 0
            goto L1a
        L19:
            r3 = 1
        L1a:
            if (r3 == r2) goto L2c
            goto L25
        L1d:
            r5 = move-exception
            throw r5
        L1f:
            java.lang.String r0 = r5.NetworkUserEntityData$$ExternalSyntheticLambda8
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L2c
        L25:
            int r0 = r0.length()
            if (r0 == 0) goto L2c
            goto L2d
        L2c:
            r1 = 1
        L2d:
            r0 = r1 ^ 1
            r1 = 58
            if (r0 == 0) goto L36
            r0 = 58
            goto L38
        L36:
            r0 = 14
        L38:
            r2 = 0
            if (r0 == r1) goto L3c
            goto L56
        L3c:
            int r0 = id.dana.bottomsheet.ServicesBottomSheetDialog.GetContactSyncConfig
            int r0 = r0 + 37
            int r1 = r0 % 128
            id.dana.bottomsheet.ServicesBottomSheetDialog.initRecordTimeStamp = r1
            int r0 = r0 % 2
            r1 = 25
            if (r0 != 0) goto L4d
            r0 = 25
            goto L4f
        L4d:
            r0 = 96
        L4f:
            if (r0 == r1) goto L52
            goto L55
        L52:
            r2.hashCode()     // Catch: java.lang.Throwable -> L76
        L55:
            r2 = r5
        L56:
            if (r2 == 0) goto L75
            int r0 = id.dana.bottomsheet.ServicesBottomSheetDialog.initRecordTimeStamp     // Catch: java.lang.Exception -> L73
            int r0 = r0 + 125
            int r1 = r0 % 128
            id.dana.bottomsheet.ServicesBottomSheetDialog.GetContactSyncConfig = r1     // Catch: java.lang.Exception -> L73
            int r0 = r0 % 2
            r4.PlaceComponentResult(r5)
            int r5 = id.dana.R.id.layout_coordinator
            android.view.View r5 = r4.MyBillsEntityDataFactory(r5)
            androidx.coordinatorlayout.widget.CoordinatorLayout r5 = (androidx.coordinatorlayout.widget.CoordinatorLayout) r5
            r0 = 8
            r5.setVisibility(r0)
            goto L75
        L73:
            r5 = move-exception
            throw r5
        L75:
            return
        L76:
            r5 = move-exception
            throw r5
        L78:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.bottomsheet.ServicesBottomSheetDialog.getAuthRequestContext(id.dana.model.ThirdPartyService):void");
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void onShow() {
        int i = initRecordTimeStamp + 123;
        GetContactSyncConfig = i % 128;
        int i2 = i % 2;
        super.onShow();
        DatabaseTableConfigUtil();
        NetworkUserEntityData$$ExternalSyntheticLambda7();
        NetworkUserEntityData$$ExternalSyntheticLambda1();
        NetworkUserEntityData$$ExternalSyntheticLambda2();
        int i3 = initRecordTimeStamp + 117;
        GetContactSyncConfig = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void onDismiss() {
        int i = GetContactSyncConfig + 9;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        newProxyInstance().onDestroy();
        getAuthRequestContext().onDestroy();
        DanaH5.dispose();
        super.onDismiss();
        int i3 = initRecordTimeStamp + 99;
        GetContactSyncConfig = i3 % 128;
        if (i3 % 2 != 0) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x002a, code lost:
    
        if ((r0 != null) != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0042, code lost:
    
        if ((r0 == null) != true) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0044, code lost:
    
        r1 = id.dana.bottomsheet.ServicesBottomSheetDialog.initRecordTimeStamp + 83;
        id.dana.bottomsheet.ServicesBottomSheetDialog.GetContactSyncConfig = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x004e, code lost:
    
        if ((r1 % 2) == 0) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0051, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0052, code lost:
    
        r0.setBottomSheetCallback(moveToNextValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x005b, code lost:
    
        if (r3 == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x005f, code lost:
    
        r0 = 63 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0063, code lost:
    
        r0 = (android.widget.FrameLayout) MyBillsEntityDataFactory(id.dana.R.id.res_0x7f0a0742_flowablesequenceequal_equalcoordinator);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x006b, code lost:
    
        if (r0 == null) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0072, code lost:
    
        r0.setOnClickListener(new id.dana.bottomsheet.ServicesBottomSheetDialog$$ExternalSyntheticLambda3(r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0075, code lost:
    
        r0 = id.dana.bottomsheet.ServicesBottomSheetDialog.GetContactSyncConfig + 115;
        id.dana.bottomsheet.ServicesBottomSheetDialog.initRecordTimeStamp = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0080, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0081, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0082, code lost:
    
        r0 = getDialog();
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0086, code lost:
    
        if (r0 == null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0088, code lost:
    
        r0.setOnCancelListener(new id.dana.bottomsheet.ServicesBottomSheetDialog$$ExternalSyntheticLambda4(r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0090, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void DatabaseTableConfigUtil() {
        /*
            r5 = this;
            int r0 = id.dana.bottomsheet.ServicesBottomSheetDialog.initRecordTimeStamp
            int r0 = r0 + 75
            int r1 = r0 % 128
            id.dana.bottomsheet.ServicesBottomSheetDialog.GetContactSyncConfig = r1
            int r0 = r0 % 2
            r1 = 16
            if (r0 == 0) goto L11
            r0 = 52
            goto L13
        L11:
            r0 = 16
        L13:
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L2f
            android.app.Dialog r0 = r5.getDialog()     // Catch: java.lang.Exception -> L2d
            int r0 = r5.getScreenHeight(r0)     // Catch: java.lang.Exception -> L2d
            r1 = 4
            r5.initBottomSheet(r0, r1)     // Catch: java.lang.Exception -> L2d
            com.google.android.material.bottomsheet.BottomSheetBehavior<android.view.View> r0 = r5.bottomSheetBehavior     // Catch: java.lang.Exception -> L2d
            if (r0 == 0) goto L29
            r1 = 1
            goto L2a
        L29:
            r1 = 0
        L2a:
            if (r1 == 0) goto L63
            goto L44
        L2d:
            r0 = move-exception
            throw r0
        L2f:
            android.app.Dialog r0 = r5.getDialog()
            int r0 = r5.getScreenHeight(r0)
            r1 = 3
            r5.initBottomSheet(r0, r1)
            com.google.android.material.bottomsheet.BottomSheetBehavior<android.view.View> r0 = r5.bottomSheetBehavior
            if (r0 == 0) goto L41
            r1 = 0
            goto L42
        L41:
            r1 = 1
        L42:
            if (r1 == r3) goto L63
        L44:
            int r1 = id.dana.bottomsheet.ServicesBottomSheetDialog.initRecordTimeStamp
            int r1 = r1 + 83
            int r4 = r1 % 128
            id.dana.bottomsheet.ServicesBottomSheetDialog.GetContactSyncConfig = r4
            int r1 = r1 % 2
            if (r1 == 0) goto L51
            goto L52
        L51:
            r3 = 0
        L52:
            id.dana.bottomsheet.ServicesBottomSheetDialog$bottomSheetCallback$2$1 r1 = r5.moveToNextValue()
            com.google.android.material.bottomsheet.BottomSheetBehavior$BottomSheetCallback r1 = (com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback) r1
            r0.setBottomSheetCallback(r1)
            if (r3 == 0) goto L63
            r0 = 63
            int r0 = r0 / r2
            goto L63
        L61:
            r0 = move-exception
            throw r0
        L63:
            int r0 = id.dana.R.id.res_0x7f0a0742_flowablesequenceequal_equalcoordinator
            android.view.View r0 = r5.MyBillsEntityDataFactory(r0)
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            if (r0 == 0) goto L82
            id.dana.bottomsheet.ServicesBottomSheetDialog$$ExternalSyntheticLambda3 r1 = new id.dana.bottomsheet.ServicesBottomSheetDialog$$ExternalSyntheticLambda3
            r1.<init>()
            r0.setOnClickListener(r1)     // Catch: java.lang.Exception -> L80
            int r0 = id.dana.bottomsheet.ServicesBottomSheetDialog.GetContactSyncConfig
            int r0 = r0 + 115
            int r1 = r0 % 128
            id.dana.bottomsheet.ServicesBottomSheetDialog.initRecordTimeStamp = r1
            int r0 = r0 % 2
            goto L82
        L80:
            r0 = move-exception
            throw r0
        L82:
            android.app.Dialog r0 = r5.getDialog()
            if (r0 == 0) goto L90
            id.dana.bottomsheet.ServicesBottomSheetDialog$$ExternalSyntheticLambda4 r1 = new id.dana.bottomsheet.ServicesBottomSheetDialog$$ExternalSyntheticLambda4
            r1.<init>()
            r0.setOnCancelListener(r1)
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.bottomsheet.ServicesBottomSheetDialog.DatabaseTableConfigUtil():void");
    }

    private static final void NetworkUserEntityData$$ExternalSyntheticLambda0(ServicesBottomSheetDialog servicesBottomSheetDialog) {
        int i = GetContactSyncConfig + 23;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        try {
            Intrinsics.checkNotNullParameter(servicesBottomSheetDialog, "");
            Function0<Unit> function0 = servicesBottomSheetDialog.getAuthRequestContext.PlaceComponentResult;
            if (function0 != null) {
                function0.invoke();
                int i3 = GetContactSyncConfig + 27;
                initRecordTimeStamp = i3 % 128;
                int i4 = i3 % 2;
            }
            try {
                servicesBottomSheetDialog.dismissAllowingStateLoss();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static final void moveToNextValue(ServicesBottomSheetDialog servicesBottomSheetDialog) {
        try {
            int i = initRecordTimeStamp + 63;
            GetContactSyncConfig = i % 128;
            int i2 = i % 2;
            Intrinsics.checkNotNullParameter(servicesBottomSheetDialog, "");
            Function0<Unit> function0 = servicesBottomSheetDialog.getAuthRequestContext.PlaceComponentResult;
            if ((function0 != null ? 'X' : '7') != '7') {
                function0.invoke();
                int i3 = initRecordTimeStamp + 37;
                GetContactSyncConfig = i3 % 128;
                int i4 = i3 % 2;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda7() {
        ServicesBottomSheetListAdapter servicesBottomSheetListAdapter = new ServicesBottomSheetListAdapter();
        servicesBottomSheetListAdapter.setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.bottomsheet.ServicesBottomSheetDialog$$ExternalSyntheticLambda1
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                ServicesBottomSheetDialog.MyBillsEntityDataFactory(ServicesBottomSheetDialog.this, i);
            }
        });
        this.BuiltInFictitiousFunctionClassFactory = servicesBottomSheetListAdapter;
        RecyclerView recyclerView = (RecyclerView) MyBillsEntityDataFactory(R.id.rv_bottom_sheet);
        if (recyclerView != null) {
            recyclerView.post(new Runnable() { // from class: id.dana.bottomsheet.ServicesBottomSheetDialog$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    ServicesBottomSheetDialog.KClassImpl$Data$declaredNonStaticMembers$2(ServicesBottomSheetDialog.this);
                }
            });
            int i = GetContactSyncConfig + 117;
            initRecordTimeStamp = i % 128;
            int i2 = i % 2;
        }
        int i3 = GetContactSyncConfig + 43;
        initRecordTimeStamp = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    private static final void KClassImpl$Data$declaredNonStaticMembers$2(ServicesBottomSheetDialog servicesBottomSheetDialog, int i) {
        int i2 = initRecordTimeStamp + 73;
        GetContactSyncConfig = i2 % 128;
        int i3 = i2 % 2;
        Intrinsics.checkNotNullParameter(servicesBottomSheetDialog, "");
        servicesBottomSheetDialog.getAuthRequestContext(i);
        int i4 = initRecordTimeStamp + 71;
        GetContactSyncConfig = i4 % 128;
        int i5 = i4 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0025, code lost:
    
        if (r1 == null) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0028, code lost:
    
        r2 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0040, code lost:
    
        if ((r1 != null) != true) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0042, code lost:
    
        r1 = id.dana.bottomsheet.ServicesBottomSheetDialog.GetContactSyncConfig + 45;
        id.dana.bottomsheet.ServicesBottomSheetDialog.initRecordTimeStamp = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x004e, code lost:
    
        if ((r1 % 2) != 0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0050, code lost:
    
        r1 = '4';
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0053, code lost:
    
        r1 = 25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0055, code lost:
    
        if (r1 == '4') goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0057, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x005b, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x005e, code lost:
    
        r1 = r2.length;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void GetContactSyncConfig(final id.dana.bottomsheet.ServicesBottomSheetDialog r6) {
        /*
            int r0 = id.dana.bottomsheet.ServicesBottomSheetDialog.GetContactSyncConfig
            int r0 = r0 + 21
            int r1 = r0 % 128
            id.dana.bottomsheet.ServicesBottomSheetDialog.initRecordTimeStamp = r1
            int r0 = r0 % 2
            r1 = 8
            if (r0 != 0) goto L11
            r0 = 8
            goto L13
        L11:
            r0 = 69
        L13:
            r2 = 0
            java.lang.String r3 = ""
            if (r0 == r1) goto L2a
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r3)
            int r0 = id.dana.R.id.rv_bottom_sheet
            android.view.View r0 = r6.MyBillsEntityDataFactory(r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            id.dana.bottomsheet.ServicesBottomSheetListAdapter r1 = r6.BuiltInFictitiousFunctionClassFactory
            if (r1 != 0) goto L28
            goto L42
        L28:
            r2 = r1
            goto L62
        L2a:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r3)     // Catch: java.lang.Exception -> L8a
            int r0 = id.dana.R.id.rv_bottom_sheet     // Catch: java.lang.Exception -> L8a
            android.view.View r0 = r6.MyBillsEntityDataFactory(r0)     // Catch: java.lang.Exception -> L8a
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0     // Catch: java.lang.Exception -> L8a
            id.dana.bottomsheet.ServicesBottomSheetListAdapter r1 = r6.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L8a
            r4 = 37
            r5 = 0
            int r4 = r4 / r5
            r4 = 1
            if (r1 != 0) goto L3f
            goto L40
        L3f:
            r5 = 1
        L40:
            if (r5 == r4) goto L28
        L42:
            int r1 = id.dana.bottomsheet.ServicesBottomSheetDialog.GetContactSyncConfig
            int r1 = r1 + 45
            int r4 = r1 % 128
            id.dana.bottomsheet.ServicesBottomSheetDialog.initRecordTimeStamp = r4
            int r1 = r1 % 2
            r4 = 52
            if (r1 != 0) goto L53
            r1 = 52
            goto L55
        L53:
            r1 = 25
        L55:
            if (r1 == r4) goto L5b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            goto L62
        L5b:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            int r1 = r2.length     // Catch: java.lang.Throwable -> L60
            goto L62
        L60:
            r6 = move-exception
            throw r6
        L62:
            androidx.recyclerview.widget.RecyclerView$Adapter r2 = (androidx.recyclerview.widget.RecyclerView.Adapter) r2
            r0.setAdapter(r2)
            int r0 = id.dana.R.id.rv_bottom_sheet
            android.view.View r0 = r6.MyBillsEntityDataFactory(r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            androidx.recyclerview.widget.GridLayoutManager r1 = new androidx.recyclerview.widget.GridLayoutManager
            android.content.Context r2 = r6.requireContext()
            r3 = 4
            r1.<init>(r2, r3)
            id.dana.bottomsheet.ServicesBottomSheetDialog$setupListView$2$1$1 r2 = new id.dana.bottomsheet.ServicesBottomSheetDialog$setupListView$2$1$1
            r2.<init>()
            androidx.recyclerview.widget.GridLayoutManager$SpanSizeLookup r2 = (androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup) r2
            r1.moveToNextValue = r2
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r1
            r0.setLayoutManager(r1)
            return
        L88:
            r6 = move-exception
            throw r6
        L8a:
            r6 = move-exception
            goto L8d
        L8c:
            throw r6
        L8d:
            goto L8c
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.bottomsheet.ServicesBottomSheetDialog.GetContactSyncConfig(id.dana.bottomsheet.ServicesBottomSheetDialog):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x001a, code lost:
    
        if (r0 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0029, code lost:
    
        if (r0 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x002b, code lost:
    
        r0.post(new id.dana.bottomsheet.ServicesBottomSheetDialog$$ExternalSyntheticLambda6(r2));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void NetworkUserEntityData$$ExternalSyntheticLambda1() {
        /*
            r2 = this;
            int r0 = id.dana.bottomsheet.ServicesBottomSheetDialog.GetContactSyncConfig
            int r0 = r0 + 17
            int r1 = r0 % 128
            id.dana.bottomsheet.ServicesBottomSheetDialog.initRecordTimeStamp = r1
            int r0 = r0 % 2
            r1 = 1
            if (r0 != 0) goto Lf
            r0 = 1
            goto L10
        Lf:
            r0 = 0
        L10:
            if (r0 == r1) goto L1d
            int r0 = id.dana.R.id.RecurringAnnouncementEntity
            android.view.View r0 = r2.MyBillsEntityDataFactory(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            if (r0 == 0) goto L33
            goto L2b
        L1d:
            int r0 = id.dana.R.id.RecurringAnnouncementEntity
            android.view.View r0 = r2.MyBillsEntityDataFactory(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r1 = 0
            r1.hashCode()     // Catch: java.lang.Throwable -> L3e
            if (r0 == 0) goto L33
        L2b:
            id.dana.bottomsheet.ServicesBottomSheetDialog$$ExternalSyntheticLambda6 r1 = new id.dana.bottomsheet.ServicesBottomSheetDialog$$ExternalSyntheticLambda6
            r1.<init>()
            r0.post(r1)
        L33:
            int r0 = id.dana.bottomsheet.ServicesBottomSheetDialog.GetContactSyncConfig
            int r0 = r0 + 107
            int r1 = r0 % 128
            id.dana.bottomsheet.ServicesBottomSheetDialog.initRecordTimeStamp = r1
            int r0 = r0 % 2
            return
        L3e:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.bottomsheet.ServicesBottomSheetDialog.NetworkUserEntityData$$ExternalSyntheticLambda1():void");
    }

    private static final void lookAheadTest(final ServicesBottomSheetDialog servicesBottomSheetDialog) {
        Intrinsics.checkNotNullParameter(servicesBottomSheetDialog, "");
        ((ImageView) servicesBottomSheetDialog.MyBillsEntityDataFactory(R.id.RecurringAnnouncementEntity)).setImageDrawable(ContextCompat.PlaceComponentResult(servicesBottomSheetDialog.requireContext(), (int) R.drawable.MyBillsEntityDataFactory));
        ((ImageView) servicesBottomSheetDialog.MyBillsEntityDataFactory(R.id.RecurringAnnouncementEntity)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.bottomsheet.ServicesBottomSheetDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ServicesBottomSheetDialog.getAuthRequestContext(ServicesBottomSheetDialog.this);
            }
        });
        int i = initRecordTimeStamp + 15;
        GetContactSyncConfig = i % 128;
        if ((i % 2 != 0 ? 'K' : (char) 29) != 29) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0020, code lost:
    
        if ((r2 != null ? 'G' : 'C') != 'G') goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0034, code lost:
    
        if ((r2 != null) != true) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0037, code lost:
    
        r0 = id.dana.bottomsheet.ServicesBottomSheetDialog.initRecordTimeStamp + 105;
        id.dana.bottomsheet.ServicesBottomSheetDialog.GetContactSyncConfig = r0 % 128;
        r0 = r0 % 2;
        r2.invoke();
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0044, code lost:
    
        r2 = id.dana.bottomsheet.ServicesBottomSheetDialog.initRecordTimeStamp + 55;
        id.dana.bottomsheet.ServicesBottomSheetDialog.GetContactSyncConfig = r2 % 128;
        r2 = r2 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x004e, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x004f, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0050, code lost:
    
        throw r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void NetworkUserEntityData$$ExternalSyntheticLambda1(id.dana.bottomsheet.ServicesBottomSheetDialog r2) {
        /*
            int r0 = id.dana.bottomsheet.ServicesBottomSheetDialog.initRecordTimeStamp
            int r0 = r0 + 47
            int r1 = r0 % 128
            id.dana.bottomsheet.ServicesBottomSheetDialog.GetContactSyncConfig = r1
            int r0 = r0 % 2
            java.lang.String r1 = ""
            if (r0 == 0) goto L27
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)     // Catch: java.lang.Exception -> L25
            id.dana.bottomsheet.ServicesBottomSheetDialog$Builder r2 = r2.getAuthRequestContext     // Catch: java.lang.Exception -> L25
            kotlin.jvm.functions.Function0<kotlin.Unit> r2 = r2.PlaceComponentResult     // Catch: java.lang.Exception -> L25
            r0 = 0
            int r0 = r0.length     // Catch: java.lang.Throwable -> L23
            r0 = 71
            if (r2 == 0) goto L1e
            r1 = 71
            goto L20
        L1e:
            r1 = 67
        L20:
            if (r1 == r0) goto L37
            goto L44
        L23:
            r2 = move-exception
            throw r2
        L25:
            r2 = move-exception
            throw r2
        L27:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            id.dana.bottomsheet.ServicesBottomSheetDialog$Builder r2 = r2.getAuthRequestContext
            kotlin.jvm.functions.Function0<kotlin.Unit> r2 = r2.PlaceComponentResult
            r0 = 1
            if (r2 == 0) goto L33
            r1 = 1
            goto L34
        L33:
            r1 = 0
        L34:
            if (r1 == r0) goto L37
            goto L44
        L37:
            int r0 = id.dana.bottomsheet.ServicesBottomSheetDialog.initRecordTimeStamp
            int r0 = r0 + 105
            int r1 = r0 % 128
            id.dana.bottomsheet.ServicesBottomSheetDialog.GetContactSyncConfig = r1
            int r0 = r0 % 2
            r2.invoke()
        L44:
            int r2 = id.dana.bottomsheet.ServicesBottomSheetDialog.initRecordTimeStamp     // Catch: java.lang.Exception -> L4f
            int r2 = r2 + 55
            int r0 = r2 % 128
            id.dana.bottomsheet.ServicesBottomSheetDialog.GetContactSyncConfig = r0     // Catch: java.lang.Exception -> L4f
            int r2 = r2 % 2
            return
        L4f:
            r2 = move-exception
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.bottomsheet.ServicesBottomSheetDialog.NetworkUserEntityData$$ExternalSyntheticLambda1(id.dana.bottomsheet.ServicesBottomSheetDialog):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x001b, code lost:
    
        if (r0 != null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x002a, code lost:
    
        if ((r0 != null) != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x002c, code lost:
    
        r0.MyBillsEntityDataFactory();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x002f, code lost:
    
        r0 = id.dana.bottomsheet.ServicesBottomSheetDialog.initRecordTimeStamp + 105;
        id.dana.bottomsheet.ServicesBottomSheetDialog.GetContactSyncConfig = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0039, code lost:
    
        if ((r0 % 2) == 0) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x003c, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x003d, code lost:
    
        if (r2 == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x003f, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0040, code lost:
    
        r0.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0043, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0046, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void BuiltInFictitiousFunctionClassFactory() {
        /*
            r4 = this;
            int r0 = id.dana.bottomsheet.ServicesBottomSheetDialog.GetContactSyncConfig     // Catch: java.lang.Exception -> L49
            int r0 = r0 + 113
            int r1 = r0 % 128
            id.dana.bottomsheet.ServicesBottomSheetDialog.initRecordTimeStamp = r1     // Catch: java.lang.Exception -> L49
            int r0 = r0 % 2
            r1 = 63
            if (r0 != 0) goto L11
            r0 = 63
            goto L13
        L11:
            r0 = 32
        L13:
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L1e
            com.ethanhua.skeleton.RecyclerViewSkeletonScreen r0 = r4.initRecordTimeStamp()
            if (r0 == 0) goto L2f
            goto L2c
        L1e:
            com.ethanhua.skeleton.RecyclerViewSkeletonScreen r0 = r4.initRecordTimeStamp()
            r1 = 89
            int r1 = r1 / r3
            if (r0 == 0) goto L29
            r1 = 1
            goto L2a
        L29:
            r1 = 0
        L2a:
            if (r1 == 0) goto L2f
        L2c:
            r0.MyBillsEntityDataFactory()     // Catch: java.lang.Exception -> L49
        L2f:
            int r0 = id.dana.bottomsheet.ServicesBottomSheetDialog.initRecordTimeStamp
            int r0 = r0 + 105
            int r1 = r0 % 128
            id.dana.bottomsheet.ServicesBottomSheetDialog.GetContactSyncConfig = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L3c
            goto L3d
        L3c:
            r2 = 0
        L3d:
            if (r2 == 0) goto L46
            r0 = 0
            r0.hashCode()     // Catch: java.lang.Throwable -> L44
            return
        L44:
            r0 = move-exception
            throw r0
        L46:
            return
        L47:
            r0 = move-exception
            throw r0
        L49:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.bottomsheet.ServicesBottomSheetDialog.BuiltInFictitiousFunctionClassFactory():void");
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        int i = GetContactSyncConfig + 69;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        RecyclerViewSkeletonScreen initRecordTimeStamp2 = initRecordTimeStamp();
        if ((initRecordTimeStamp2 != null ? (char) 4 : 'D') != 'D') {
            initRecordTimeStamp2.MyBillsEntityDataFactory.setAdapter(initRecordTimeStamp2.getAuthRequestContext);
            try {
                int i3 = initRecordTimeStamp + 123;
                GetContactSyncConfig = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x004e, code lost:
    
        if (r3 == null) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0064, code lost:
    
        if ((r3 == null ? '\'' : '(') != '\'') goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0067, code lost:
    
        r1 = id.dana.bottomsheet.ServicesBottomSheetDialog.GetContactSyncConfig + 23;
        id.dana.bottomsheet.ServicesBottomSheetDialog.initRecordTimeStamp = r1 % 128;
        r1 = r1 % 2;
        r3 = kotlin.collections.CollectionsKt.emptyList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0075, code lost:
    
        r0.BuiltInFictitiousFunctionClassFactory(r3);
        r0 = id.dana.bottomsheet.ServicesBottomSheetDialog.initRecordTimeStamp + 113;
        id.dana.bottomsheet.ServicesBottomSheetDialog.GetContactSyncConfig = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void NetworkUserEntityData$$ExternalSyntheticLambda2() {
        /*
            r5 = this;
            int r0 = id.dana.bottomsheet.ServicesBottomSheetDialog.GetContactSyncConfig
            int r0 = r0 + 89
            int r1 = r0 % 128
            id.dana.bottomsheet.ServicesBottomSheetDialog.initRecordTimeStamp = r1
            int r0 = r0 % 2
            id.dana.bottomsheet.ServicesBottomSheetDialog$Builder r0 = r5.getAuthRequestContext
            java.lang.String r0 = r0.lookAheadTest
            r5.BuiltInFictitiousFunctionClassFactory(r0)
            id.dana.bottomsheet.ServicesBottomSheetDialog$Builder r0 = r5.getAuthRequestContext
            java.lang.String r0 = r0.MyBillsEntityDataFactory
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L9c
            java.lang.String r3 = "SERVICE_KEY"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            r4 = 0
            if (r3 == 0) goto L24
            r3 = 0
            goto L25
        L24:
            r3 = 1
        L25:
            if (r3 == 0) goto L83
            java.lang.String r3 = "CATEGORY_SERVICE"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r3)
            r3 = 99
            if (r0 == 0) goto L34
            r0 = 99
            goto L36
        L34:
            r0 = 93
        L36:
            if (r0 == r3) goto L39
            goto L9a
        L39:
            int r0 = id.dana.bottomsheet.ServicesBottomSheetDialog.GetContactSyncConfig
            int r0 = r0 + 5
            int r3 = r0 % 128
            id.dana.bottomsheet.ServicesBottomSheetDialog.initRecordTimeStamp = r3
            int r0 = r0 % 2
            if (r0 != 0) goto L53
            id.dana.contract.services.ServicesContract$Presenter r0 = r5.newProxyInstance()
            id.dana.bottomsheet.ServicesBottomSheetDialog$Builder r3 = r5.getAuthRequestContext
            java.util.List<java.lang.String> r3 = r3.moveToNextValue
            int r1 = r1.length     // Catch: java.lang.Throwable -> L51
            if (r3 != 0) goto L75
            goto L67
        L51:
            r0 = move-exception
            throw r0
        L53:
            id.dana.contract.services.ServicesContract$Presenter r0 = r5.newProxyInstance()
            id.dana.bottomsheet.ServicesBottomSheetDialog$Builder r1 = r5.getAuthRequestContext
            java.util.List<java.lang.String> r3 = r1.moveToNextValue
            r1 = 39
            if (r3 != 0) goto L62
            r4 = 39
            goto L64
        L62:
            r4 = 40
        L64:
            if (r4 == r1) goto L67
            goto L75
        L67:
            int r1 = id.dana.bottomsheet.ServicesBottomSheetDialog.GetContactSyncConfig
            int r1 = r1 + 23
            int r3 = r1 % 128
            id.dana.bottomsheet.ServicesBottomSheetDialog.initRecordTimeStamp = r3
            int r1 = r1 % 2
            java.util.List r3 = kotlin.collections.CollectionsKt.emptyList()
        L75:
            r0.BuiltInFictitiousFunctionClassFactory(r3)
            int r0 = id.dana.bottomsheet.ServicesBottomSheetDialog.initRecordTimeStamp
            int r0 = r0 + 113
            int r1 = r0 % 128
            id.dana.bottomsheet.ServicesBottomSheetDialog.GetContactSyncConfig = r1
            int r0 = r0 % 2
            goto L9a
        L83:
            id.dana.contract.services.ServicesContract$Presenter r0 = r5.newProxyInstance()
            id.dana.bottomsheet.ServicesBottomSheetDialog$Builder r1 = r5.getAuthRequestContext
            java.util.List<java.lang.String> r1 = r1.moveToNextValue
            if (r1 != 0) goto L8e
            r4 = 1
        L8e:
            if (r4 == r2) goto L91
            goto L95
        L91:
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
        L95:
            java.lang.String r3 = "key"
            r0.BuiltInFictitiousFunctionClassFactory(r1, r3, r2)
        L9a:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch: java.lang.Exception -> Lb3
        L9c:
            if (r1 != 0) goto Lb5
            int r0 = id.dana.bottomsheet.ServicesBottomSheetDialog.initRecordTimeStamp     // Catch: java.lang.Exception -> Lb3
            int r0 = r0 + 107
            int r1 = r0 % 128
            id.dana.bottomsheet.ServicesBottomSheetDialog.GetContactSyncConfig = r1
            int r0 = r0 % 2
            r0 = r5
            id.dana.bottomsheet.ServicesBottomSheetDialog r0 = (id.dana.bottomsheet.ServicesBottomSheetDialog) r0     // Catch: java.lang.Exception -> Lb3
            id.dana.contract.services.ServicesContract$Presenter r0 = r5.newProxyInstance()     // Catch: java.lang.Exception -> Lb3
            r0.PlaceComponentResult(r2)     // Catch: java.lang.Exception -> Lb3
            goto Lb5
        Lb3:
            r0 = move-exception
            throw r0
        Lb5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.bottomsheet.ServicesBottomSheetDialog.NetworkUserEntityData$$ExternalSyntheticLambda2():void");
    }

    @JvmName(name = "NetworkUserEntityData$$ExternalSyntheticLambda0")
    private final ServicesContract.View NetworkUserEntityData$$ExternalSyntheticLambda0() {
        ServicesContract.View view = new ServicesContract.View() { // from class: id.dana.bottomsheet.ServicesBottomSheetDialog$servicesContractView$1
            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onActionMiniApp(ThirdPartyService thirdPartyService) {
                ServicesContract.View.CC.PlaceComponentResult(thirdPartyService);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onCheckFavoriteServicesFeature(boolean z) {
                ServicesContract.View.CC.PlaceComponentResult();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onEmptySearchService() {
                ServicesContract.View.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onFeatureServices(List list) {
                ServicesContract.View.CC.PlaceComponentResult(list);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onGetInitThirdPartyServices(List list) {
                Intrinsics.checkNotNullParameter(list, "");
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onMaintenanceAction(ThirdPartyService thirdPartyService) {
                ServicesContract.View.CC.BuiltInFictitiousFunctionClassFactory(thirdPartyService);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final /* synthetic */ void onShowTooltip(boolean z) {
                ServicesContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
                ServicesBottomSheetDialog.getAuthRequestContext(ServicesBottomSheetDialog.this, "FAIL_FETCH_SERVICES");
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                ServicesBottomSheetDialog.this.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                ServicesBottomSheetDialog.this.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onGetThirdPartyServices(List<ThirdPartyService> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0.isEmpty()) {
                    ServicesBottomSheetDialog.getAuthRequestContext(ServicesBottomSheetDialog.this, "FAIL_EMPTY_SERVICE");
                } else {
                    ServicesBottomSheetDialog.PlaceComponentResult(ServicesBottomSheetDialog.this, p0);
                }
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onActionPost(ThirdPartyService p0, String p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                ServicesBottomSheetDialog servicesBottomSheetDialog = ServicesBottomSheetDialog.this;
                String str = p0.getCallingPid;
                ServicesBottomSheetDialog.KClassImpl$Data$declaredNonStaticMembers$2(servicesBottomSheetDialog, p0, str != null ? str : "", p1, ServicesBottomSheetDialog.this.PlaceComponentResult().getDeviceUUID());
                ServicesBottomSheetDialog.MyBillsEntityDataFactory(ServicesBottomSheetDialog.this, p0.NetworkUserEntityData$$ExternalSyntheticLambda8);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onActionFailed(String p0) {
                ServicesBottomSheetDialog.getAuthRequestContext(ServicesBottomSheetDialog.this, "FAIL_DO_ACTION");
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onGetFilteredThirdPartyServices(List<ThirdPartyService> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0.isEmpty()) {
                    ServicesBottomSheetDialog.getAuthRequestContext(ServicesBottomSheetDialog.this, "FAIL_EMPTY_SERVICE");
                } else {
                    ServicesBottomSheetDialog.PlaceComponentResult(ServicesBottomSheetDialog.this, p0);
                }
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onActionGet(ThirdPartyService p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (UrlUtil.getErrorConfigVersion(p0.NetworkUserEntityData$$ExternalSyntheticLambda6)) {
                    ReadLinkPropertiesContract.Presenter authRequestContext = ServicesBottomSheetDialog.this.getAuthRequestContext();
                    String str = p0.NetworkUserEntityData$$ExternalSyntheticLambda6;
                    authRequestContext.MyBillsEntityDataFactory(str != null ? str : "");
                } else {
                    ServicesBottomSheetDialog servicesBottomSheetDialog = ServicesBottomSheetDialog.this;
                    String authRequestContext2 = UrlUtil.getAuthRequestContext(p0.NetworkUserEntityData$$ExternalSyntheticLambda6);
                    Intrinsics.checkNotNullExpressionValue(authRequestContext2, "");
                    ServicesBottomSheetDialog.KClassImpl$Data$declaredNonStaticMembers$2(servicesBottomSheetDialog, p0, authRequestContext2, null, null);
                }
                ServicesBottomSheetDialog.MyBillsEntityDataFactory(ServicesBottomSheetDialog.this, p0.NetworkUserEntityData$$ExternalSyntheticLambda8);
            }

            @Override // id.dana.contract.services.ServicesContract.View
            public final void onDirectOpen(ThirdPartyService p0, Map<String, String> p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                String str = p0.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (str != null) {
                    ServicesBottomSheetDialog.this.MyBillsEntityDataFactory().getAuthRequestContext(str, p1);
                }
            }
        };
        try {
            int i = initRecordTimeStamp + 87;
            GetContactSyncConfig = i % 128;
            int i2 = i % 2;
            return view;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void PlaceComponentResult(String p0) {
        int i = initRecordTimeStamp + 57;
        GetContactSyncConfig = i % 128;
        int i2 = i % 2;
        Function1<? super String, Unit> function1 = this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory;
        if ((function1 != null ? Typography.quote : 'L') != 'L') {
            int i3 = GetContactSyncConfig + 117;
            initRecordTimeStamp = i3 % 128;
            if ((i3 % 2 == 0 ? 'R' : Typography.dollar) != 'R') {
                try {
                    Intrinsics.checkNotNull(p0);
                    function1.invoke(p0);
                } catch (Exception e) {
                    throw e;
                }
            } else {
                Intrinsics.checkNotNull(p0);
                function1.invoke(p0);
                int i4 = 40 / 0;
            }
            int i5 = GetContactSyncConfig + 31;
            initRecordTimeStamp = i5 % 128;
            int i6 = i5 % 2;
        }
    }

    private final void MyBillsEntityDataFactory(String p0) {
        int i = GetContactSyncConfig + 21;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        Function1<? super String, Unit> function1 = this.getAuthRequestContext.getAuthRequestContext;
        if ((function1 != null ? 'M' : (char) 0) == 'M') {
            int i3 = GetContactSyncConfig + 21;
            initRecordTimeStamp = i3 % 128;
            int i4 = i3 % 2;
            function1.invoke(p0);
        }
        int i5 = GetContactSyncConfig + 31;
        initRecordTimeStamp = i5 % 128;
        int i6 = i5 % 2;
    }

    private final void GetContactSyncConfig() {
        DaggerBottomSheetServiceComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerBottomSheetServiceComponent.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(ComponentHolder.getAuthRequestContext());
        DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$22 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory = requireActivity();
        byte b = 0;
        Object[] objArr = new Object[1];
        c(Color.argb(0, 0, 0, 0), 8 - Color.green(0), (char) (56482 - TextUtils.indexOf((CharSequence) "", '0')), objArr);
        KClassImpl$Data$declaredNonStaticMembers$22.getAuthRequestContext = ((String) objArr[0]).intern();
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = (DeepLinkModule) Preconditions.getAuthRequestContext(new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$22, b));
        ScanQrModule.Builder authRequestContext = ScanQrModule.getAuthRequestContext();
        authRequestContext.MyBillsEntityDataFactory = requireActivity();
        KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0 = (ScanQrModule) Preconditions.getAuthRequestContext(new ScanQrModule(authRequestContext, b));
        RestoreUrlModule.Builder KClassImpl$Data$declaredNonStaticMembers$23 = RestoreUrlModule.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$23.getAuthRequestContext = requireActivity();
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = (RestoreUrlModule) Preconditions.getAuthRequestContext(new RestoreUrlModule(KClassImpl$Data$declaredNonStaticMembers$23, b));
        FeatureModule.Builder MyBillsEntityDataFactory = FeatureModule.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = requireActivity();
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = (FeatureModule) Preconditions.getAuthRequestContext(new FeatureModule(MyBillsEntityDataFactory, b));
        OauthModule.Builder BuiltInFictitiousFunctionClassFactory = OauthModule.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = requireActivity();
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = (OauthModule) Preconditions.getAuthRequestContext(new OauthModule(BuiltInFictitiousFunctionClassFactory, b));
        KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion = (ServicesModule) Preconditions.getAuthRequestContext(new ServicesModule(NetworkUserEntityData$$ExternalSyntheticLambda0()));
        if (KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion == null) {
            KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion = new ServicesModule();
            int i = initRecordTimeStamp + 17;
            GetContactSyncConfig = i % 128;
            int i2 = i % 2;
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, DeepLinkModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0, ScanQrModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, RestoreUrlModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, FeatureModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, OauthModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
        new DaggerBottomSheetServiceComponent.BottomSheetServiceComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion, KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0, KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory, (byte) 0).KClassImpl$Data$declaredNonStaticMembers$2(this);
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(List<ThirdPartyService> p0) {
        ServicesBottomSheetListAdapter servicesBottomSheetListAdapter = this.BuiltInFictitiousFunctionClassFactory;
        if (servicesBottomSheetListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            servicesBottomSheetListAdapter = null;
            int i = initRecordTimeStamp + 3;
            GetContactSyncConfig = i % 128;
            int i2 = i % 2;
        }
        servicesBottomSheetListAdapter.setItems(p0);
        getErrorConfigVersion();
        int i3 = initRecordTimeStamp + 61;
        GetContactSyncConfig = i3 % 128;
        int i4 = i3 % 2;
    }

    private final void BuiltInFictitiousFunctionClassFactory(final String p0) {
        TextView textView;
        int i = initRecordTimeStamp + 59;
        GetContactSyncConfig = i % 128;
        if (!(i % 2 == 0)) {
            textView = (TextView) MyBillsEntityDataFactory(R.id.title_bottom_sheet);
            int i2 = 21 / 0;
            if (textView == null) {
                return;
            }
        } else {
            textView = (TextView) MyBillsEntityDataFactory(R.id.title_bottom_sheet);
            if (textView == null) {
                return;
            }
        }
        textView.post(new Runnable() { // from class: id.dana.bottomsheet.ServicesBottomSheetDialog$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                ServicesBottomSheetDialog.PlaceComponentResult(ServicesBottomSheetDialog.this, p0);
            }
        });
        int i3 = initRecordTimeStamp + 73;
        GetContactSyncConfig = i3 % 128;
        int i4 = i3 % 2;
    }

    private static final void BuiltInFictitiousFunctionClassFactory(ServicesBottomSheetDialog servicesBottomSheetDialog, String str) {
        int i = initRecordTimeStamp + 107;
        GetContactSyncConfig = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(servicesBottomSheetDialog, "");
        Intrinsics.checkNotNullParameter(str, "");
        ((TextView) servicesBottomSheetDialog.MyBillsEntityDataFactory(R.id.title_bottom_sheet)).setText(str);
        int i3 = initRecordTimeStamp + 117;
        GetContactSyncConfig = i3 % 128;
        int i4 = i3 % 2;
    }

    private final void BuiltInFictitiousFunctionClassFactory(ThirdPartyService p0, String p1, String p2, String p3) {
        String KClassImpl$Data$declaredNonStaticMembers$2 = ThirdPartyServicesUrlMapper.KClassImpl$Data$declaredNonStaticMembers$2(p1, p2, p3, p0);
        Bundle bundle = new Bundle();
        bundle.putString(DanaH5.SERVICE_KEY, p0.NetworkUserEntityData$$ExternalSyntheticLambda8);
        if ((Intrinsics.areEqual(p0.NetworkUserEntityData$$ExternalSyntheticLambda8, "service_akulaku") ? '6' : Typography.quote) == '6') {
            int i = initRecordTimeStamp + 121;
            GetContactSyncConfig = i % 128;
            int i2 = i % 2;
            bundle.putString("url", Uri.parse(KClassImpl$Data$declaredNonStaticMembers$2).buildUpon().appendQueryParameter("entryPoint", this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2).build().toString());
            bundle.putString(DanaH5Key.Param.ADJUSTRESIZE, "YES");
            DanaH5.startContainerFullUrlWithSendCredentials$default(null, null, bundle, null, 11, null);
            return;
        }
        DanaH5.startContainerFullUrlWithSendCredentials$default(KClassImpl$Data$declaredNonStaticMembers$2, null, bundle, null, 10, null);
        int i3 = GetContactSyncConfig + 39;
        initRecordTimeStamp = i3 % 128;
        if ((i3 % 2 == 0 ? 'J' : 'F') != 'J') {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    private final void getAuthRequestContext(int p0) {
        int i = GetContactSyncConfig + 63;
        initRecordTimeStamp = i % 128;
        int i2 = i % 2;
        ServicesBottomSheetListAdapter servicesBottomSheetListAdapter = this.BuiltInFictitiousFunctionClassFactory;
        Object[] objArr = null;
        if ((servicesBottomSheetListAdapter == null ? '\t' : 'V') != 'V') {
            int i3 = GetContactSyncConfig + 61;
            initRecordTimeStamp = i3 % 128;
            if (i3 % 2 != 0) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
                objArr.hashCode();
            }
            servicesBottomSheetListAdapter = null;
        }
        ThirdPartyService item = servicesBottomSheetListAdapter.getItem(p0);
        if (!(item == null)) {
            try {
                int i4 = initRecordTimeStamp + 59;
                GetContactSyncConfig = i4 % 128;
                if ((i4 % 2 != 0 ? '3' : (char) 14) != '3') {
                    PlaceComponentResult(item);
                    return;
                }
                PlaceComponentResult(item);
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        }
    }

    private final void PlaceComponentResult(ThirdPartyService p0) {
        int i = initRecordTimeStamp + 15;
        GetContactSyncConfig = i % 128;
        if ((i % 2 != 0 ? (char) 19 : (char) 18) != 19) {
            ServicesTracker.KClassImpl$Data$declaredNonStaticMembers$2(getContext(), p0.NetworkUserEntityData$$ExternalSyntheticLambda8, p0.newProxyInstance, p0.NetworkUserEntityData$$ExternalSyntheticLambda6, p0.NetworkUserEntityData$$ExternalSyntheticLambda0);
            newProxyInstance().MyBillsEntityDataFactory(p0, (Map<String, String>) null);
            return;
        }
        ServicesTracker.KClassImpl$Data$declaredNonStaticMembers$2(getContext(), p0.NetworkUserEntityData$$ExternalSyntheticLambda8, p0.newProxyInstance, p0.NetworkUserEntityData$$ExternalSyntheticLambda6, p0.NetworkUserEntityData$$ExternalSyntheticLambda0);
        newProxyInstance().MyBillsEntityDataFactory(p0, (Map<String, String>) null);
        Object obj = null;
        obj.hashCode();
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\f\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0011\u0012\u001d\b\u0002\u0010\u0018\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010\u0007¢\u0006\u0002\b\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u001d\b\u0002\u0010\u001a\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010\u0007¢\u0006\u0002\b\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R'\u0010\u000b\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010\u0007¢\u0006\u0002\b\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006X\u0086\u0002¢\u0006\u0006\n\u0004\b\t\u0010\nR'\u0010\r\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010\u0007¢\u0006\u0002\b\b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006X\u0086\u0002¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0086\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010\u000eR\u0012\u0010\f\u001a\u00020\u0007X\u0086\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0011\u0010\u0010\u001a\u00020\u0007X\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u001a\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0011X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/bottomsheet/ServicesBottomSheetDialog$Builder;", "", "Lkotlin/Function0;", "", "PlaceComponentResult", "Lkotlin/jvm/functions/Function0;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "MyBillsEntityDataFactory", "Lkotlin/jvm/functions/Function1;", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "lookAheadTest", "", "scheduleImpl", "Ljava/util/List;", "moveToNextValue", "p0", "p1", "p2", "p3", "p4", "p5", "p6", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Builder {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public String KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public Function1<? super String, Unit> BuiltInFictitiousFunctionClassFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public Function1<? super String, Unit> getAuthRequestContext;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
        public final String lookAheadTest;
        public Function0<Unit> PlaceComponentResult;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public String MyBillsEntityDataFactory;

        /* renamed from: scheduleImpl  reason: from kotlin metadata */
        public List<String> moveToNextValue;

        private Builder(String str, String str2, List<String> list, Function1<? super String, Unit> function1, Function0<Unit> function0, Function1<? super String, Unit> function12, String str3) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str3, "");
            this.lookAheadTest = str;
            this.MyBillsEntityDataFactory = str2;
            this.moveToNextValue = list;
            this.BuiltInFictitiousFunctionClassFactory = function1;
            this.PlaceComponentResult = function0;
            this.getAuthRequestContext = function12;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str3;
        }

        public /* synthetic */ Builder(String str, String str2, List list, Function1 function1, Function0 function0, Function1 function12, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : function1, (i & 16) != 0 ? null : function0, (i & 32) == 0 ? function12 : null, (i & 64) != 0 ? "" : str3);
        }
    }

    private static void c(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (true) {
            if (!(whenavailable.BuiltInFictitiousFunctionClassFactory < i2)) {
                break;
            }
            int i3 = $11 + 57;
            $10 = i3 % 128;
            int i4 = i3 % 2;
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (NetworkUserEntityData$$ExternalSyntheticLambda0[whenavailable.BuiltInFictitiousFunctionClassFactory + i] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ NetworkUserEntityData$$ExternalSyntheticLambda2))) ^ c;
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
        }
        char[] cArr = new char[i2];
        try {
            whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
            int i5 = $11 + 35;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            while (whenavailable.BuiltInFictitiousFunctionClassFactory < i2) {
                cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
                whenavailable.BuiltInFictitiousFunctionClassFactory++;
            }
            objArr[0] = new String(cArr);
        } catch (Exception e) {
            throw e;
        }
    }
}
