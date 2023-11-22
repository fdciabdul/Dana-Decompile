package id.dana.nearbyme.merchantdetail.viewcomponent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.LiveData;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.flexbox.FlexboxLayoutManager;
import dagger.internal.Preconditions;
import id.dana.H5Launcher;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseRichView;
import id.dana.data.social.common.PhoneNumberUtilKt;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerMerchantDetailMenuComponent;
import id.dana.di.component.MerchantDetailMenuComponent;
import id.dana.di.modules.MerchantDetailConfigModule;
import id.dana.di.modules.MerchantDetailMenuModule;
import id.dana.domain.nearbyme.model.MerchantDetailConfig;
import id.dana.extension.ContextExtKt;
import id.dana.extension.view.ViewExtKt;
import id.dana.nearbyme.merchantdetail.MerchantDetailConfigContract;
import id.dana.nearbyme.merchantdetail.MerchantDetailContract;
import id.dana.nearbyme.merchantdetail.adapter.MerchantMenuAdapter;
import id.dana.nearbyme.merchantdetail.enums.MerchantMenu;
import id.dana.nearbyme.merchantdetail.model.MerchantDetailPromoConfigModel;
import id.dana.nearbyme.merchantdetail.model.MerchantDetailViewState;
import id.dana.nearbyme.merchantdetail.model.MerchantInfoModel;
import id.dana.nearbyme.merchantdetail.model.MerchantMenuModel;
import id.dana.nearbyme.model.ShopModel;
import id.dana.tracker.mixpanel.TopupSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 D2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002EDB'\b\u0016\u0012\u0006\u0010<\u001a\u00020;\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010=\u0012\b\b\u0002\u0010?\u001a\u00020\t¢\u0006\u0004\b@\u0010AB+\b\u0016\u0012\u0006\u0010<\u001a\u00020;\u0012\b\u0010>\u001a\u0004\u0018\u00010=\u0012\u0006\u0010?\u001a\u00020\t\u0012\u0006\u0010B\u001a\u00020\t¢\u0006\u0004\b@\u0010CJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0006H\u0016¢\u0006\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u001c8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010%\u001a\u00020(8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b'\u0010)R\"\u0010+\u001a\u00020*8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00102\u001a\u0002018\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\u00048\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b8\u00109"}, d2 = {"Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDetailMenuView;", "Lid/dana/base/BaseRichView;", "Lid/dana/nearbyme/merchantdetail/MerchantDetailContract;", "Lid/dana/nearbyme/merchantdetail/MerchantDetailConfigContract$View;", "Lid/dana/nearbyme/merchantdetail/model/MerchantDetailViewState;", "merchantDetailViewState", "", "bindViewState", "(Lid/dana/nearbyme/merchantdetail/model/MerchantDetailViewState;)V", "", "getLayout", "()I", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "Lid/dana/domain/nearbyme/model/MerchantDetailConfig;", "merchantDetailConfig", "onGetActionConfig", "(Lid/dana/domain/nearbyme/model/MerchantDetailConfig;)V", "Lid/dana/nearbyme/merchantdetail/model/MerchantDetailPromoConfigModel;", "config", "onGetMerchantDetailPromoConfig", "(Lid/dana/nearbyme/merchantdetail/model/MerchantDetailPromoConfigModel;)V", "Lid/dana/nearbyme/merchantdetail/model/MerchantInfoModel;", "merchantInfo", "renderMenu", "(Lid/dana/nearbyme/merchantdetail/model/MerchantInfoModel;)V", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDetailMenuView$ActionListener;", "actionListener", "setActionListener", "(Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDetailMenuView$ActionListener;)V", "setup", "()V", "getAuthRequestContext", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDetailMenuView$ActionListener;", "Lid/dana/nearbyme/merchantdetail/adapter/MerchantMenuAdapter;", "PlaceComponentResult", "Lid/dana/nearbyme/merchantdetail/adapter/MerchantMenuAdapter;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/di/component/MerchantDetailMenuComponent;", "Lid/dana/di/component/MerchantDetailMenuComponent;", "Lid/dana/nearbyme/merchantdetail/MerchantDetailConfigContract$Presenter;", "configPresenter", "Lid/dana/nearbyme/merchantdetail/MerchantDetailConfigContract$Presenter;", "getConfigPresenter", "()Lid/dana/nearbyme/merchantdetail/MerchantDetailConfigContract$Presenter;", "setConfigPresenter", "(Lid/dana/nearbyme/merchantdetail/MerchantDetailConfigContract$Presenter;)V", "Lid/dana/H5Launcher;", "h5Launcher", "Lid/dana/H5Launcher;", "getH5Launcher", "()Lid/dana/H5Launcher;", "setH5Launcher", "(Lid/dana/H5Launcher;)V", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/nearbyme/merchantdetail/model/MerchantDetailViewState;", "MyBillsEntityDataFactory", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "ActionListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantDetailMenuView extends BaseRichView implements MerchantDetailContract, MerchantDetailConfigContract.View {
    public static final float MENU_VIEW_ELEVATION = 2.0f;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private MerchantDetailViewState MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private MerchantDetailMenuComponent PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private MerchantMenuAdapter KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> _$_findViewCache;
    @Inject
    public MerchantDetailConfigContract.Presenter configPresenter;
    private ActionListener getAuthRequestContext;
    @Inject
    public H5Launcher h5Launcher;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDetailMenuView$ActionListener;", "", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "BuiltInFictitiousFunctionClassFactory", "()V", "MyBillsEntityDataFactory"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface ActionListener {
        void BuiltInFictitiousFunctionClassFactory();

        void KClassImpl$Data$declaredNonStaticMembers$2(String p0);

        void MyBillsEntityDataFactory();
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[MerchantMenu.values().length];
            iArr[MerchantMenu.RESERVE.ordinal()] = 1;
            iArr[MerchantMenu.PICK_UP.ordinal()] = 2;
            iArr[MerchantMenu.CONTACT_US.ordinal()] = 3;
            iArr[MerchantMenu.DIRECTION.ordinal()] = 4;
            iArr[MerchantMenu.TOP_UP.ordinal()] = 5;
            iArr[MerchantMenu.HOME_SHOPPING.ordinal()] = 6;
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MerchantDetailMenuView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MerchantDetailMenuView(Context context, AttributeSet attributeSet) {
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

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void dismissProgress() {
        AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public final /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.view_merchant_detail_menu;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void onError(String str) {
        AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.nearbyme.merchantdetail.MerchantDetailConfigContract.View
    public final void onGetMerchantDetailPromoConfig(MerchantDetailPromoConfigModel config) {
        Intrinsics.checkNotNullParameter(config, "");
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void showProgress() {
        AbstractContractKt.AbstractView.CC.PlaceComponentResult();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantDetailMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ MerchantDetailMenuView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantDetailMenuView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @JvmName(name = "getH5Launcher")
    public final H5Launcher getH5Launcher() {
        H5Launcher h5Launcher = this.h5Launcher;
        if (h5Launcher != null) {
            return h5Launcher;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setH5Launcher")
    public final void setH5Launcher(H5Launcher h5Launcher) {
        Intrinsics.checkNotNullParameter(h5Launcher, "");
        this.h5Launcher = h5Launcher;
    }

    @JvmName(name = "getConfigPresenter")
    public final MerchantDetailConfigContract.Presenter getConfigPresenter() {
        MerchantDetailConfigContract.Presenter presenter = this.configPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setConfigPresenter")
    public final void setConfigPresenter(MerchantDetailConfigContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.configPresenter = presenter;
    }

    public final void setActionListener(ActionListener actionListener) {
        Intrinsics.checkNotNullParameter(actionListener, "");
        this.getAuthRequestContext = actionListener;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.IMediaControllerCallback);
        if (recyclerView != null) {
            FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(getContext());
            flexboxLayoutManager.setFlexDirection(0);
            flexboxLayoutManager.setFlexWrap(1);
            flexboxLayoutManager.setJustifyContent(4);
            recyclerView.setLayoutManager(flexboxLayoutManager);
        }
        ViewExtKt.PlaceComponentResult(this, 2.0f);
    }

    @Override // id.dana.base.BaseRichView
    public final void injectComponent(ApplicationComponent applicationComponent) {
        byte b = 0;
        if (this.PlaceComponentResult == null && applicationComponent != null) {
            DaggerMerchantDetailMenuComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerMerchantDetailMenuComponent.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
            KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = (MerchantDetailConfigModule) Preconditions.getAuthRequestContext(new MerchantDetailConfigModule(this));
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = (MerchantDetailMenuModule) Preconditions.getAuthRequestContext(new MerchantDetailMenuModule());
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, MerchantDetailConfigModule.class);
            if (KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult == null) {
                KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = new MerchantDetailMenuModule();
            }
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, ApplicationComponent.class);
            DaggerMerchantDetailMenuComponent.MerchantDetailMenuComponentImpl merchantDetailMenuComponentImpl = new DaggerMerchantDetailMenuComponent.MerchantDetailMenuComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, b);
            Intrinsics.checkNotNullExpressionValue(merchantDetailMenuComponentImpl, "");
            this.PlaceComponentResult = merchantDetailMenuComponentImpl;
        }
        MerchantDetailMenuComponent merchantDetailMenuComponent = this.PlaceComponentResult;
        if (merchantDetailMenuComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantDetailMenuComponent = null;
        }
        merchantDetailMenuComponent.MyBillsEntityDataFactory(this);
        registerPresenter(getConfigPresenter());
    }

    public final void bindViewState(MerchantDetailViewState merchantDetailViewState) {
        Intrinsics.checkNotNullParameter(merchantDetailViewState, "");
        this.MyBillsEntityDataFactory = merchantDetailViewState;
        MerchantDetailConfigContract.Presenter configPresenter = getConfigPresenter();
        registerPresenter(configPresenter);
        configPresenter.PlaceComponentResult(false);
        configPresenter.BuiltInFictitiousFunctionClassFactory();
    }

    public final void renderMenu(MerchantInfoModel merchantInfo) {
        Intrinsics.checkNotNullParameter(merchantInfo, "");
        Unit unit = null;
        MerchantMenuAdapter merchantMenuAdapter = null;
        if (merchantInfo.getAuthRequestContext().length() > 0) {
            MerchantMenuAdapter merchantMenuAdapter2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (merchantMenuAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                merchantMenuAdapter = merchantMenuAdapter2;
            }
            List<MerchantMenuModel> items = merchantMenuAdapter.getItems();
            if (items != null) {
                Iterator<MerchantMenuModel> it = items.iterator();
                int i = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i = -1;
                        break;
                    }
                    if (it.next().MyBillsEntityDataFactory == MerchantMenu.CONTACT_US) {
                        break;
                    }
                    i++;
                }
                merchantMenuAdapter.getItem(i).KClassImpl$Data$declaredNonStaticMembers$2 = true;
                merchantMenuAdapter.notifyItemChanged(i);
                Unit unit2 = Unit.INSTANCE;
            }
        } else {
            MerchantMenuAdapter merchantMenuAdapter3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (merchantMenuAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                merchantMenuAdapter3 = null;
            }
            Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDetailMenuView$renderMenu$1
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
                    MerchantDetailMenuView.this.setVisibility(8);
                }
            };
            Intrinsics.checkNotNullParameter(function0, "");
            List<MerchantMenuModel> items2 = merchantMenuAdapter3.getItems();
            Intrinsics.checkNotNullExpressionValue(items2, "");
            ArrayList arrayList = new ArrayList();
            for (Object obj : items2) {
                if (((MerchantMenuModel) obj).getKClassImpl$Data$declaredNonStaticMembers$2()) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = arrayList;
            if (!(true ^ arrayList2.isEmpty())) {
                arrayList2 = null;
            }
            if (arrayList2 != null) {
                merchantMenuAdapter3.setItems(arrayList2);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                function0.invoke();
            }
        }
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.IMediaControllerCallback);
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
    }

    public static final /* synthetic */ void access$onMenuClick(MerchantDetailMenuView merchantDetailMenuView, MerchantMenu merchantMenu) {
        ActionListener actionListener = null;
        ActionListener actionListener2 = null;
        MerchantDetailViewState merchantDetailViewState = null;
        MerchantDetailViewState merchantDetailViewState2 = null;
        switch (WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[merchantMenu.ordinal()]) {
            case 1:
                Unit unit = Unit.INSTANCE;
                return;
            case 2:
                Unit unit2 = Unit.INSTANCE;
                return;
            case 3:
                MerchantDetailViewState merchantDetailViewState3 = merchantDetailMenuView.MyBillsEntityDataFactory;
                if (merchantDetailViewState3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    merchantDetailViewState3 = null;
                }
                Object obj = merchantDetailViewState3.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory;
                if (obj == LiveData.MyBillsEntityDataFactory) {
                    obj = null;
                }
                MerchantInfoModel merchantInfoModel = (MerchantInfoModel) obj;
                if (merchantInfoModel != null) {
                    String replaceIndoRegionDashWithPhonePrefix = PhoneNumberUtilKt.replaceIndoRegionDashWithPhonePrefix(merchantInfoModel.getAuthRequestContext());
                    if (!(replaceIndoRegionDashWithPhonePrefix.length() > 0)) {
                        replaceIndoRegionDashWithPhonePrefix = null;
                    }
                    if (replaceIndoRegionDashWithPhonePrefix != null) {
                        ActionListener actionListener3 = merchantDetailMenuView.getAuthRequestContext;
                        if (actionListener3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                        } else {
                            actionListener = actionListener3;
                        }
                        actionListener.KClassImpl$Data$declaredNonStaticMembers$2(replaceIndoRegionDashWithPhonePrefix);
                        Unit unit3 = Unit.INSTANCE;
                        return;
                    }
                    return;
                }
                return;
            case 4:
                Context context = merchantDetailMenuView.getContext();
                if (context != null) {
                    MerchantDetailViewState merchantDetailViewState4 = merchantDetailMenuView.MyBillsEntityDataFactory;
                    if (merchantDetailViewState4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        merchantDetailViewState2 = merchantDetailViewState4;
                    }
                    ShopModel shopModel = merchantDetailViewState2.PlaceComponentResult;
                    ContextExtKt.BuiltInFictitiousFunctionClassFactory(context, shopModel.DatabaseTableConfigUtil, shopModel.PrepareContext);
                    Unit unit4 = Unit.INSTANCE;
                    return;
                }
                return;
            case 5:
                merchantDetailMenuView.getH5Launcher();
                Pair[] pairArr = new Pair[2];
                pairArr[0] = TuplesKt.to("entryPoint", TopupSource.NEARBY);
                MerchantDetailViewState merchantDetailViewState5 = merchantDetailMenuView.MyBillsEntityDataFactory;
                if (merchantDetailViewState5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    merchantDetailViewState = merchantDetailViewState5;
                }
                String str = merchantDetailViewState.PlaceComponentResult.GetContactSyncConfig;
                pairArr[1] = TuplesKt.to("instId", str != null ? str : "");
                H5Launcher.KClassImpl$Data$declaredNonStaticMembers$2("https://m.dana.id/m/portal/topup?entryPoint={entryPoint}&payMethod=OTC&instId={instId}&fromSKW=true", MapsKt.mapOf(pairArr));
                Unit unit5 = Unit.INSTANCE;
                return;
            case 6:
                ActionListener actionListener4 = merchantDetailMenuView.getAuthRequestContext;
                if (actionListener4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    actionListener2 = actionListener4;
                }
                actionListener2.MyBillsEntityDataFactory();
                Unit unit6 = Unit.INSTANCE;
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.internal.DefaultConstructorMarker] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDetailMenuView$ActionListener] */
    @Override // id.dana.nearbyme.merchantdetail.MerchantDetailConfigContract.View
    public final void onGetActionConfig(MerchantDetailConfig merchantDetailConfig) {
        Intrinsics.checkNotNullParameter(merchantDetailConfig, "");
        MerchantDetailViewState merchantDetailViewState = this.MyBillsEntityDataFactory;
        ?? r2 = 0;
        if (merchantDetailViewState == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantDetailViewState = null;
        }
        ShopModel shopModel = merchantDetailViewState.PlaceComponentResult;
        ArrayList arrayList = new ArrayList();
        merchantDetailConfig.getReserveEnabled();
        merchantDetailConfig.getPickupEnabled();
        boolean z = false;
        if (merchantDetailConfig.getCallEnabled()) {
            arrayList.add(new MerchantMenuModel(MerchantMenu.CONTACT_US, false));
        }
        int i = 2;
        if (merchantDetailConfig.getDirectionEnabled()) {
            arrayList.add(new MerchantMenuModel(MerchantMenu.DIRECTION, z, i, r2));
        }
        if (merchantDetailConfig.getTopupEnabled() && shopModel.newProxyInstance()) {
            arrayList.add(new MerchantMenuModel(MerchantMenu.TOP_UP, true));
        }
        if (shopModel.initRecordTimeStamp()) {
            arrayList.add(new MerchantMenuModel(MerchantMenu.HOME_SHOPPING, z, i, r2));
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new MerchantMenuAdapter(new MerchantDetailMenuView$setupAdapter$2(this));
        }
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.IMediaControllerCallback);
        if (recyclerView != null) {
            MerchantMenuAdapter merchantMenuAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (merchantMenuAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                merchantMenuAdapter = null;
            }
            recyclerView.setAdapter(merchantMenuAdapter);
        }
        MerchantMenuAdapter merchantMenuAdapter2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (merchantMenuAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantMenuAdapter2 = null;
        }
        merchantMenuAdapter2.setItems(arrayList);
        ActionListener actionListener = this.getAuthRequestContext;
        if (actionListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            r2 = actionListener;
        }
        r2.BuiltInFictitiousFunctionClassFactory();
        setVisibility(0);
    }
}
