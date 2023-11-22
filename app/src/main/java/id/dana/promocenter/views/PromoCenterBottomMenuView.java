package id.dana.promocenter.views;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.view.ComponentActivity;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.anggrayudi.storage.permission.ActivityPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionReport;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.location.LocationSettingsResult;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.base.BaseRichView;
import id.dana.common.model.OptionModel;
import id.dana.common.view.CheckboxView;
import id.dana.dialog.DialogPermission;
import id.dana.richview.category.model.CategoryModel;
import id.dana.utils.ConstraintUtils;
import id.dana.utils.LocationUtil;
import id.dana.utils.permission.ManifestPermission;
import id.dana.utils.permission.PermissionHelper;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u00109\u001a\u000208\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010:\u0012\b\b\u0002\u0010<\u001a\u00020\u0005¢\u0006\u0004\b=\u0010>J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0004J\u0019\u0010\u0011\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0011\u0010\u0015J\u000f\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\nJ\r\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0004J\u0017\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0002H\u0016¢\u0006\u0004\b \u0010\u0004J\r\u0010!\u001a\u00020\u0002¢\u0006\u0004\b!\u0010\u0004R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010#R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002X\u0082\u0006¢\u0006\u0006\n\u0004\b\u001e\u0010$R\u0018\u0010\u001e\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010&R\u0018\u0010\u0011\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010(R4\u0010/\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020)8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R4\u00103\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020)8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010*\u001a\u0004\b1\u0010,\"\u0004\b2\u0010.R\u0016\u0010\t\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002X\u0083\u0006¢\u0006\u0006\n\u0004\b6\u0010$"}, d2 = {"Lid/dana/promocenter/views/PromoCenterBottomMenuView;", "Lid/dana/base/BaseRichView;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "", "getLayout", "()I", "", "MyBillsEntityDataFactory", "()Z", "Lid/dana/richview/category/model/CategoryModel;", "p0", "PlaceComponentResult", "(Lid/dana/richview/category/model/CategoryModel;)Z", "", "Lid/dana/common/model/OptionModel;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/List;)Z", "hideMenu", "", "(Ljava/lang/String;)Z", "setDefault", "categoryModel", "setOnCategoryChange", "(Lid/dana/richview/category/model/CategoryModel;)V", "sortOption", "setSelectedSort", "(Ljava/lang/String;)V", "p1", "getAuthRequestContext", "(IZ)V", "setup", SecurityConstants.KEY_SHOW_MENU, "Lid/dana/dialog/DialogPermission;", "Lid/dana/dialog/DialogPermission;", "Ljava/util/List;", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/Disposable;", "Lkotlin/Function2;", "Lkotlin/jvm/functions/Function2;", "getOnSubmitFilterClicked", "()Lkotlin/jvm/functions/Function2;", "setOnSubmitFilterClicked", "(Lkotlin/jvm/functions/Function2;)V", "onSubmitFilterClicked", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getOnSubmitSortClicked", "setOnSubmitSortClicked", "onSubmitSortClicked", "getErrorConfigVersion", "I", "lookAheadTest", "scheduleImpl", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PromoCenterBottomMenuView extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private ActivityPermissionRequest getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private Function2<? super String, ? super Boolean, Unit> onSubmitFilterClicked;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private Disposable BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private Function2<? super String, ? super Boolean, Unit> onSubmitSortClicked;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private DialogPermission KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private List<OptionModel> PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private int MyBillsEntityDataFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private List<OptionModel> scheduleImpl;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PromoCenterBottomMenuView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PromoCenterBottomMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.view_promocenter_bottom_menu;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromoCenterBottomMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.MyBillsEntityDataFactory = -1;
        this.scheduleImpl = CollectionsKt.emptyList();
        this.PlaceComponentResult = CollectionsKt.emptyList();
        this.onSubmitSortClicked = new Function2<String, Boolean, Unit>() { // from class: id.dana.promocenter.views.PromoCenterBottomMenuView$onSubmitSortClicked$1
            public final void invoke(String str, boolean z) {
                Intrinsics.checkNotNullParameter(str, "");
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* synthetic */ Unit invoke(String str, Boolean bool) {
                invoke(str, bool.booleanValue());
                return Unit.INSTANCE;
            }
        };
        this.onSubmitFilterClicked = new Function2<String, Boolean, Unit>() { // from class: id.dana.promocenter.views.PromoCenterBottomMenuView$onSubmitFilterClicked$1
            public final void invoke(String str, boolean z) {
                Intrinsics.checkNotNullParameter(str, "");
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* synthetic */ Unit invoke(String str, Boolean bool) {
                invoke(str, bool.booleanValue());
                return Unit.INSTANCE;
            }
        };
    }

    public /* synthetic */ PromoCenterBottomMenuView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @JvmName(name = "getOnSubmitSortClicked")
    public final Function2<String, Boolean, Unit> getOnSubmitSortClicked() {
        return this.onSubmitSortClicked;
    }

    @JvmName(name = "setOnSubmitSortClicked")
    public final void setOnSubmitSortClicked(Function2<? super String, ? super Boolean, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "");
        this.onSubmitSortClicked = function2;
    }

    @JvmName(name = "getOnSubmitFilterClicked")
    public final Function2<String, Boolean, Unit> getOnSubmitFilterClicked() {
        return this.onSubmitFilterClicked;
    }

    @JvmName(name = "setOnSubmitFilterClicked")
    public final void setOnSubmitFilterClicked(Function2<? super String, ? super Boolean, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "");
        this.onSubmitFilterClicked = function2;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        ((LinearLayout) _$_findCachedViewById(R.id.res_0x7f0a0d60_animatorkt_addlistener_1)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.promocenter.views.PromoCenterBottomMenuView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PromoCenterBottomMenuView.$r8$lambda$pQsi9NgXXyQvgjWcYytKaC8zjos(PromoCenterBottomMenuView.this, view);
            }
        });
        ((LinearLayout) _$_findCachedViewById(R.id.res_0x7f0a0d40_treerangeset_complement)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.promocenter.views.PromoCenterBottomMenuView$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PromoCenterBottomMenuView.$r8$lambda$YIQMQbW4pHsCQgH9lY6RG1k7rMw(PromoCenterBottomMenuView.this, view);
            }
        });
        BaseActivity baseActivity = getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        ActivityPermissionRequest.Builder builder = new ActivityPermissionRequest.Builder((ComponentActivity) baseActivity);
        String[] strArr = {"android.permission.ACCESS_FINE_LOCATION", ManifestPermission.ACCESS_COARSE_LOCATION};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.PlaceComponentResult = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.promocenter.views.PromoCenterBottomMenuView$createLocationPermission$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                PermissionCallback.CC.getAuthRequestContext(permissionRequest);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p0, boolean p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                PromoCenterBottomMenuView.access$checkLocationPermissionResult(PromoCenterBottomMenuView.this, p0);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onShouldRedirectToSystemSettings(List<PermissionReport> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                BaseActivity baseActivity2 = PromoCenterBottomMenuView.this.getBaseActivity();
                Intrinsics.checkNotNullExpressionValue(baseActivity2, "");
                PermissionHelper.MyBillsEntityDataFactory(baseActivity2);
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.getAuthRequestContext = permissionCallback;
        this.getAuthRequestContext = builder.PlaceComponentResult();
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(String p0) {
        return !TextUtils.isEmpty(p0) && StringsKt.equals("NEAREST_LOCATION", p0, true);
    }

    private final boolean MyBillsEntityDataFactory() {
        return LocationUtil.BuiltInFictitiousFunctionClassFactory(getContext());
    }

    private final boolean PlaceComponentResult() {
        return LocationUtil.getAuthRequestContext(getContext());
    }

    public final void setSelectedSort(String sortOption) {
        Object obj;
        Intrinsics.checkNotNullParameter(sortOption, "");
        Iterator<T> it = this.scheduleImpl.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((OptionModel) obj).getAuthRequestContext, sortOption)) {
                break;
            }
        }
        OptionModel optionModel = (OptionModel) obj;
        if (optionModel != null) {
            this.MyBillsEntityDataFactory = this.scheduleImpl.indexOf(optionModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getAuthRequestContext(int p0, boolean p1) {
        PromoCenterBottomMenuView promoCenterBottomMenuView = p0 >= 0 && this.scheduleImpl.size() > p0 ? this : null;
        if (promoCenterBottomMenuView != null) {
            promoCenterBottomMenuView.MyBillsEntityDataFactory = p0;
            promoCenterBottomMenuView.onSubmitSortClicked.invoke(promoCenterBottomMenuView.scheduleImpl.get(p0).getAuthRequestContext, Boolean.valueOf(p1));
        }
    }

    public final void showMenu() {
        ((ConstraintLayout) _$_findCachedViewById(R.id.getChipStrokeWidth)).setVisibility(((this.scheduleImpl.isEmpty() ^ true) || (this.PlaceComponentResult.isEmpty() ^ true)) ? 0 : 8);
    }

    public final void hideMenu() {
        ((ConstraintLayout) _$_findCachedViewById(R.id.getChipStrokeWidth)).setVisibility(8);
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(List<OptionModel> p0) {
        return p0 != null && (p0.isEmpty() ^ true);
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        if (PlaceComponentResult()) {
            return;
        }
        Disposable disposable = this.BuiltInFictitiousFunctionClassFactory;
        if (disposable != null) {
            disposable.dispose();
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        LocationUtil.LocationRequestBuilder locationRequestBuilder = new LocationUtil.LocationRequestBuilder((Application) getBaseActivity().getDanaApplication());
        locationRequestBuilder.MyBillsEntityDataFactory.setAlwaysShow(true);
        locationRequestBuilder.MyBillsEntityDataFactory.addLocationRequest(LocationUtil.LocationRequestBuilder.PlaceComponentResult());
        Disposable subscribe = locationRequestBuilder.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(locationRequestBuilder.MyBillsEntityDataFactory.build()).subscribe(new Consumer() { // from class: id.dana.promocenter.views.PromoCenterBottomMenuView$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PromoCenterBottomMenuView.m2781$r8$lambda$QT2V906oKgxxEFj53tNAR6asUk(PromoCenterBottomMenuView.this, (LocationSettingsResult) obj);
            }
        });
        this.BuiltInFictitiousFunctionClassFactory = subscribe;
        addDisposable(subscribe);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        if (r1 != 8502) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0053  */
    /* renamed from: $r8$lambda$QT2V906oKgxxEFj53tNAR6as-Uk  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void m2781$r8$lambda$QT2V906oKgxxEFj53tNAR6asUk(id.dana.promocenter.views.PromoCenterBottomMenuView r3, com.google.android.gms.location.LocationSettingsResult r4) {
        /*
            r0 = 0
            if (r4 == 0) goto L48
            com.google.android.gms.common.api.Status r1 = r4.getStatus()
            if (r1 == 0) goto L48
            com.google.android.gms.common.api.Status r4 = r4.getStatus()
            java.lang.String r1 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            int r1 = r4.getStatusCode()
            r2 = 6
            if (r1 == r2) goto L1e
            r4 = 8502(0x2136, float:1.1914E-41)
            if (r1 == r4) goto L4f
            goto L48
        L1e:
            android.app.PendingIntent r1 = r4.getResolution()
            if (r1 == 0) goto L29
            android.content.IntentSender r1 = r1.getIntentSender()
            goto L2a
        L29:
            r1 = r0
        L2a:
            if (r1 == 0) goto L40
            id.dana.base.BaseActivity r1 = r3.getBaseActivity()
            android.app.PendingIntent r4 = r4.getResolution()
            if (r4 == 0) goto L3b
            android.content.IntentSender r4 = r4.getIntentSender()
            goto L3c
        L3b:
            r4 = r0
        L3c:
            id.dana.utils.LocationUtil.MyBillsEntityDataFactory(r1, r4)
            goto L4f
        L40:
            android.content.Context r4 = r3.getContext()
            id.dana.utils.showcase.Utils.PlaceComponentResult(r4)
            goto L4f
        L48:
            android.content.Context r4 = r3.getContext()
            id.dana.utils.showcase.Utils.PlaceComponentResult(r4)
        L4f:
            io.reactivex.disposables.Disposable r4 = r3.BuiltInFictitiousFunctionClassFactory
            if (r4 == 0) goto L56
            r4.dispose()
        L56:
            r3.BuiltInFictitiousFunctionClassFactory = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.promocenter.views.PromoCenterBottomMenuView.m2781$r8$lambda$QT2V906oKgxxEFj53tNAR6asUk(id.dana.promocenter.views.PromoCenterBottomMenuView, com.google.android.gms.location.LocationSettingsResult):void");
    }

    public static /* synthetic */ void $r8$lambda$XAzekkwWlSIBpKMP6tqWYm03eHE(PromoCenterBottomMenuView promoCenterBottomMenuView, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(promoCenterBottomMenuView, "");
        promoCenterBottomMenuView.KClassImpl$Data$declaredNonStaticMembers$2 = null;
    }

    public static /* synthetic */ void $r8$lambda$YIQMQbW4pHsCQgH9lY6RG1k7rMw(final PromoCenterBottomMenuView promoCenterBottomMenuView, View view) {
        Intrinsics.checkNotNullParameter(promoCenterBottomMenuView, "");
        FragmentManager supportFragmentManager = promoCenterBottomMenuView.getBaseActivity().getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
        final BottomSheetFilter bottomSheetFilter = new BottomSheetFilter(supportFragmentManager, promoCenterBottomMenuView.PlaceComponentResult);
        Function2<Integer, Boolean, Unit> function2 = new Function2<Integer, Boolean, Unit>() { // from class: id.dana.promocenter.views.PromoCenterBottomMenuView$showFilterBottomSheet$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* synthetic */ Unit invoke(Integer num, Boolean bool) {
                invoke(num.intValue(), bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i, boolean z) {
                List list;
                list = PromoCenterBottomMenuView.this.PlaceComponentResult;
                if (list.size() > i) {
                    PromoCenterBottomMenuView.access$onFilterChecked(PromoCenterBottomMenuView.this, i, z, bottomSheetFilter);
                }
            }
        };
        Intrinsics.checkNotNullParameter(function2, "");
        bottomSheetFilter.getAuthRequestContext = function2;
        Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.promocenter.views.PromoCenterBottomMenuView$showFilterBottomSheet$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                List list;
                list = PromoCenterBottomMenuView.this.PlaceComponentResult;
                String str = "";
                int i = 0;
                for (Object obj : list) {
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    OptionModel optionModel = (OptionModel) obj;
                    if (optionModel.getKClassImpl$Data$declaredNonStaticMembers$2()) {
                        if (i > 0) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(str);
                            sb.append(',');
                            str = sb.toString();
                        }
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str);
                        sb2.append(optionModel.getAuthRequestContext);
                        str = sb2.toString();
                    }
                    i++;
                }
                PromoCenterBottomMenuView.access$onFilterChange(PromoCenterBottomMenuView.this);
                PromoCenterBottomMenuView.this.getOnSubmitFilterClicked().invoke(str, Boolean.TRUE);
                bottomSheetFilter.dismiss();
            }
        };
        Intrinsics.checkNotNullParameter(function0, "");
        bottomSheetFilter.BuiltInFictitiousFunctionClassFactory = function0;
        Function0<Unit> function02 = new Function0<Unit>() { // from class: id.dana.promocenter.views.PromoCenterBottomMenuView$showFilterBottomSheet$1$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                List list;
                list = PromoCenterBottomMenuView.this.PlaceComponentResult;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((OptionModel) it.next()).KClassImpl$Data$declaredNonStaticMembers$2 = false;
                }
                ((AppCompatImageView) PromoCenterBottomMenuView.this._$_findCachedViewById(R.id.onLoadingGetInvestmentCardAssets)).setVisibility(8);
                ((CheckboxView) bottomSheetFilter.getAuthRequestContext(R.id.onSuccessLoadMoreReview_res_0x7f0a0566)).notifyAdapter();
            }
        };
        Intrinsics.checkNotNullParameter(function02, "");
        bottomSheetFilter.MyBillsEntityDataFactory = function02;
        bottomSheetFilter.show(bottomSheetFilter.PlaceComponentResult, "Filter Bottom Sheet");
    }

    public static /* synthetic */ void $r8$lambda$pQsi9NgXXyQvgjWcYytKaC8zjos(final PromoCenterBottomMenuView promoCenterBottomMenuView, View view) {
        Intrinsics.checkNotNullParameter(promoCenterBottomMenuView, "");
        FragmentManager supportFragmentManager = promoCenterBottomMenuView.getBaseActivity().getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
        final BottomSheetSort bottomSheetSort = new BottomSheetSort(supportFragmentManager, promoCenterBottomMenuView.scheduleImpl);
        bottomSheetSort.PlaceComponentResult = promoCenterBottomMenuView.MyBillsEntityDataFactory;
        Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: id.dana.promocenter.views.PromoCenterBottomMenuView$showSortBottomSheet$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                if (i >= 0) {
                    PromoCenterBottomMenuView.this.getAuthRequestContext(i, true);
                    bottomSheetSort.dismiss();
                }
            }
        };
        Intrinsics.checkNotNullParameter(function1, "");
        bottomSheetSort.KClassImpl$Data$declaredNonStaticMembers$2 = function1;
        bottomSheetSort.show(bottomSheetSort.getAuthRequestContext, "Radio Button Bottom Sheet");
    }

    public static final /* synthetic */ void access$checkLocationPermission(PromoCenterBottomMenuView promoCenterBottomMenuView) {
        if (!promoCenterBottomMenuView.MyBillsEntityDataFactory()) {
            ActivityPermissionRequest activityPermissionRequest = promoCenterBottomMenuView.getAuthRequestContext;
            if (activityPermissionRequest != null) {
                activityPermissionRequest.check();
                return;
            }
            return;
        }
        promoCenterBottomMenuView.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static final /* synthetic */ void access$checkLocationPermissionResult(PromoCenterBottomMenuView promoCenterBottomMenuView, PermissionResult permissionResult) {
        if (permissionResult.MyBillsEntityDataFactory()) {
            promoCenterBottomMenuView.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    public static final /* synthetic */ void access$onFilterChange(PromoCenterBottomMenuView promoCenterBottomMenuView) {
        List<OptionModel> list = promoCenterBottomMenuView.PlaceComponentResult;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((OptionModel) obj).getKClassImpl$Data$declaredNonStaticMembers$2()) {
                arrayList.add(obj);
            }
        }
        if ((!arrayList.isEmpty()) != false) {
            ((AppCompatImageView) promoCenterBottomMenuView._$_findCachedViewById(R.id.onLoadingGetInvestmentCardAssets)).setVisibility(0);
        } else {
            ((AppCompatImageView) promoCenterBottomMenuView._$_findCachedViewById(R.id.onLoadingGetInvestmentCardAssets)).setVisibility(8);
        }
    }

    public static final /* synthetic */ void access$onFilterChecked(final PromoCenterBottomMenuView promoCenterBottomMenuView, int i, boolean z, BottomSheetFilter bottomSheetFilter) {
        if (BuiltInFictitiousFunctionClassFactory(promoCenterBottomMenuView.PlaceComponentResult.get(i).getAuthRequestContext) && z) {
            if (promoCenterBottomMenuView.MyBillsEntityDataFactory() && promoCenterBottomMenuView.PlaceComponentResult()) {
                promoCenterBottomMenuView.PlaceComponentResult.get(i).KClassImpl$Data$declaredNonStaticMembers$2 = true;
                return;
            }
            DialogPermission.Builder builder = new DialogPermission.Builder(promoCenterBottomMenuView.getBaseActivity(), new DialogInterface.OnDismissListener() { // from class: id.dana.promocenter.views.PromoCenterBottomMenuView$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    PromoCenterBottomMenuView.$r8$lambda$XAzekkwWlSIBpKMP6tqWYm03eHE(PromoCenterBottomMenuView.this, dialogInterface);
                }
            });
            builder.scheduleImpl = R.drawable.ic_location_graphic;
            builder.lookAheadTest = promoCenterBottomMenuView.getContext().getString(R.string.popup_location_desc);
            builder.NetworkUserEntityData$$ExternalSyntheticLambda1 = promoCenterBottomMenuView.getContext().getString(R.string.popup_location_title);
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = promoCenterBottomMenuView.getContext().getString(R.string.popup_location_positive_button);
            builder.PlaceComponentResult = promoCenterBottomMenuView.getContext().getString(R.string.popup_location_negative_button);
            builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = new DialogPermission.DialogListener() { // from class: id.dana.promocenter.views.PromoCenterBottomMenuView$showPopUpLocationPermission$2
                @Override // id.dana.dialog.DialogPermission.DialogListener
                public final void onDialogDismissed() {
                }

                @Override // id.dana.dialog.DialogPermission.DialogListener
                public final void onPositiveButtonClicked() {
                    DialogPermission dialogPermission;
                    PromoCenterBottomMenuView.access$checkLocationPermission(PromoCenterBottomMenuView.this);
                    dialogPermission = PromoCenterBottomMenuView.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (dialogPermission != null) {
                        dialogPermission.getAuthRequestContext();
                    }
                }

                @Override // id.dana.dialog.DialogPermission.DialogListener
                public final void onNegativeButtonClicked() {
                    DialogPermission dialogPermission;
                    dialogPermission = PromoCenterBottomMenuView.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (dialogPermission != null) {
                        dialogPermission.getAuthRequestContext();
                    }
                }
            };
            DialogPermission dialogPermission = new DialogPermission(builder.BuiltInFictitiousFunctionClassFactory, builder.moveToNextValue, builder, (byte) 0);
            promoCenterBottomMenuView.KClassImpl$Data$declaredNonStaticMembers$2 = dialogPermission;
            dialogPermission.MyBillsEntityDataFactory();
            bottomSheetFilter.dismiss();
            return;
        }
        promoCenterBottomMenuView.PlaceComponentResult.get(i).KClassImpl$Data$declaredNonStaticMembers$2 = z;
    }

    private static boolean PlaceComponentResult(CategoryModel p0) {
        return !BuiltInFictitiousFunctionClassFactory(p0.getAuthRequestContext) || BuiltInFictitiousFunctionClassFactory(p0.getErrorConfigVersion);
    }

    public final void setDefault() {
        ((AppCompatImageView) _$_findCachedViewById(R.id.onLoadingGetInvestmentCardAssets)).setVisibility(8);
        Iterator<T> it = this.PlaceComponentResult.iterator();
        while (it.hasNext()) {
            ((OptionModel) it.next()).KClassImpl$Data$declaredNonStaticMembers$2 = false;
        }
        Iterator<T> it2 = this.scheduleImpl.iterator();
        while (it2.hasNext()) {
            ((OptionModel) it2.next()).KClassImpl$Data$declaredNonStaticMembers$2 = false;
        }
        this.MyBillsEntityDataFactory = -1;
    }

    public final void setOnCategoryChange(CategoryModel categoryModel) {
        if (categoryModel != null) {
            List<OptionModel> list = categoryModel.getAuthRequestContext;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if ((!TextUtils.isEmpty(((OptionModel) obj).PlaceComponentResult)) != false) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = arrayList;
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                ((OptionModel) it.next()).KClassImpl$Data$declaredNonStaticMembers$2 = false;
            }
            this.PlaceComponentResult = arrayList2;
            List<OptionModel> list2 = categoryModel.getErrorConfigVersion;
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : list2) {
                if ((!TextUtils.isEmpty(((OptionModel) obj2).PlaceComponentResult)) != false) {
                    arrayList3.add(obj2);
                }
            }
            ArrayList arrayList4 = arrayList3;
            int i = 0;
            for (Object obj3 : arrayList4) {
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (((OptionModel) obj3).getKClassImpl$Data$declaredNonStaticMembers$2()) {
                    this.MyBillsEntityDataFactory = i;
                }
                i++;
            }
            this.scheduleImpl = arrayList4;
            getAuthRequestContext(this.MyBillsEntityDataFactory, false);
        }
        if (categoryModel == null || !PlaceComponentResult(categoryModel)) {
            hideMenu();
            return;
        }
        showMenu();
        if (BuiltInFictitiousFunctionClassFactory(categoryModel.getAuthRequestContext) && BuiltInFictitiousFunctionClassFactory(categoryModel.getErrorConfigVersion)) {
            ConstraintUtils.getErrorConfigVersion(_$_findCachedViewById(R.id.mergeArrayDelayError), (ConstraintLayout) _$_findCachedViewById(R.id.getChipStrokeWidth));
            ConstraintUtils.NetworkUserEntityData$$ExternalSyntheticLambda0(_$_findCachedViewById(R.id.mergeArrayDelayError), (ConstraintLayout) _$_findCachedViewById(R.id.getChipStrokeWidth));
            ((LinearLayout) _$_findCachedViewById(R.id.res_0x7f0a0d40_treerangeset_complement)).setVisibility(0);
            _$_findCachedViewById(R.id.mergeArrayDelayError).setVisibility(0);
            ((LinearLayout) _$_findCachedViewById(R.id.res_0x7f0a0d60_animatorkt_addlistener_1)).setVisibility(0);
        } else if (BuiltInFictitiousFunctionClassFactory(categoryModel.getAuthRequestContext)) {
            ((LinearLayout) _$_findCachedViewById(R.id.res_0x7f0a0d60_animatorkt_addlistener_1)).setVisibility(8);
            _$_findCachedViewById(R.id.mergeArrayDelayError).setVisibility(8);
            ConstraintUtils.PlaceComponentResult(_$_findCachedViewById(R.id.mergeArrayDelayError), (ConstraintLayout) _$_findCachedViewById(R.id.getChipStrokeWidth));
            ((LinearLayout) _$_findCachedViewById(R.id.res_0x7f0a0d40_treerangeset_complement)).setVisibility(0);
        } else {
            _$_findCachedViewById(R.id.mergeArrayDelayError).setVisibility(8);
            ((LinearLayout) _$_findCachedViewById(R.id.res_0x7f0a0d40_treerangeset_complement)).setVisibility(8);
            ConstraintUtils.MyBillsEntityDataFactory(_$_findCachedViewById(R.id.mergeArrayDelayError), (ConstraintLayout) _$_findCachedViewById(R.id.getChipStrokeWidth));
            ((LinearLayout) _$_findCachedViewById(R.id.res_0x7f0a0d60_animatorkt_addlistener_1)).setVisibility(0);
        }
    }
}
