package id.dana.service.favorites;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.base.BaseRichView;
import id.dana.common.decoration.DashedGridDivider;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerFavoriteServicesComponent;
import id.dana.dialog.DanaLoadingDialog;
import id.dana.model.ThirdPartyService;
import id.dana.service.adapter.EditServiceAdapter;
import id.dana.service.adapter.ServiceAdapter;
import id.dana.service.favorites.FavoriteServicesContract;
import id.dana.service.favorites.FavoriteServicesView;
import id.dana.utils.CustomToastUtil;
import id.dana.utils.SizeUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001HB'\b\u0016\u0012\u0006\u0010@\u001a\u00020?\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010A\u0012\b\b\u0002\u0010C\u001a\u00020\u0007¢\u0006\u0004\bD\u0010EB+\b\u0016\u0012\u0006\u0010@\u001a\u00020?\u0012\b\u0010B\u001a\u0004\u0018\u00010A\u0012\u0006\u0010C\u001a\u00020\u0007\u0012\u0006\u0010F\u001a\u00020\u0007¢\u0006\u0004\bD\u0010GJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0016\u0010\u0006J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0017\u0010\u0006J\u0015\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u0006J\u001b\u0010\u001c\u001a\u00020\u000f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0004¢\u0006\u0004\b\u001f\u0010\u0014J\u000f\u0010 \u001a\u00020\u000fH\u0016¢\u0006\u0004\b \u0010!R$\u0010(\u001a\u0004\u0018\u00010\"8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b+\u0010,R$\u00104\u001a\u0004\u0018\u00010-8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00106\u001a\u0002058\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0016\u0010.\u001a\u00020<8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b=\u0010>"}, d2 = {"Lid/dana/service/favorites/FavoriteServicesView;", "Lid/dana/base/BaseRichView;", "Lid/dana/model/ThirdPartyService;", "thirdPartyService", "", "containService", "(Lid/dana/model/ThirdPartyService;)Z", "", "position", "getItemViewType", "(I)I", "getLayout", "()I", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "isInjected", "injected", "(Z)V", "p0", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "service", "replaceEmptyItem", "", "featuredServices", "setItems", "(Ljava/util/List;)V", "isEditMode", "setOnEdit", "setup", "()V", "Lid/dana/service/favorites/FavoriteServicesView$FavoriteServiceActionListener;", "Lid/dana/service/favorites/FavoriteServicesView$FavoriteServiceActionListener;", "getFavoriteServiceActionListener", "()Lid/dana/service/favorites/FavoriteServicesView$FavoriteServiceActionListener;", "setFavoriteServiceActionListener", "(Lid/dana/service/favorites/FavoriteServicesView$FavoriteServiceActionListener;)V", "favoriteServiceActionListener", "MyBillsEntityDataFactory", "Lid/dana/model/ThirdPartyService;", "isItemFull", "()Z", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "getOnItemClickListener", "()Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "setOnItemClickListener", "(Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;)V", "onItemClickListener", "Lid/dana/service/favorites/FavoriteServicesContract$Presenter;", "presenter", "Lid/dana/service/favorites/FavoriteServicesContract$Presenter;", "getPresenter", "()Lid/dana/service/favorites/FavoriteServicesContract$Presenter;", "setPresenter", "(Lid/dana/service/favorites/FavoriteServicesContract$Presenter;)V", "Lid/dana/service/adapter/EditServiceAdapter;", "getAuthRequestContext", "Lid/dana/service/adapter/EditServiceAdapter;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "FavoriteServiceActionListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FavoriteServicesView extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private FavoriteServiceActionListener favoriteServiceActionListener;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private BaseRecyclerViewHolder.OnItemClickListener onItemClickListener;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private ThirdPartyService BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private EditServiceAdapter KClassImpl$Data$declaredNonStaticMembers$2;
    @Inject
    public FavoriteServicesContract.Presenter presenter;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/service/favorites/FavoriteServicesView$FavoriteServiceActionListener;", "", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "()V", "", "getAuthRequestContext"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface FavoriteServiceActionListener {
        void BuiltInFictitiousFunctionClassFactory();

        void getAuthRequestContext();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FavoriteServicesView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FavoriteServicesView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_service_edit;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FavoriteServicesView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ FavoriteServicesView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FavoriteServicesView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @JvmName(name = "getPresenter")
    public final FavoriteServicesContract.Presenter getPresenter() {
        FavoriteServicesContract.Presenter presenter = this.presenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(FavoriteServicesContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.presenter = presenter;
    }

    @JvmName(name = "getOnItemClickListener")
    public final BaseRecyclerViewHolder.OnItemClickListener getOnItemClickListener() {
        return this.onItemClickListener;
    }

    @JvmName(name = "setOnItemClickListener")
    public final void setOnItemClickListener(BaseRecyclerViewHolder.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @JvmName(name = "getFavoriteServiceActionListener")
    public final FavoriteServiceActionListener getFavoriteServiceActionListener() {
        return this.favoriteServiceActionListener;
    }

    @JvmName(name = "setFavoriteServiceActionListener")
    public final void setFavoriteServiceActionListener(FavoriteServiceActionListener favoriteServiceActionListener) {
        this.favoriteServiceActionListener = favoriteServiceActionListener;
    }

    @Override // id.dana.base.BaseRichView
    public final void injectComponent(ApplicationComponent applicationComponent) {
        Intrinsics.checkNotNullParameter(applicationComponent, "");
        DaggerFavoriteServicesComponent.Builder MyBillsEntityDataFactory = DaggerFavoriteServicesComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = (FavoriteServicesModule) Preconditions.getAuthRequestContext(new FavoriteServicesModule(new FavoriteServicesContract.View() { // from class: id.dana.service.favorites.FavoriteServicesView$injectComponent$1

            /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
            public DanaLoadingDialog getAuthRequestContext;

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.service.favorites.FavoriteServicesContract.View
            public final void BuiltInFictitiousFunctionClassFactory(List<ThirdPartyService> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                FavoriteServicesView.this.setItems(CollectionsKt.toMutableList((Collection) p0));
            }

            @Override // id.dana.service.favorites.FavoriteServicesContract.View
            public final void PlaceComponentResult(boolean p0) {
                FavoriteServicesView.FavoriteServiceActionListener favoriteServiceActionListener = FavoriteServicesView.this.getFavoriteServiceActionListener();
                if (favoriteServiceActionListener != null) {
                    favoriteServiceActionListener.getAuthRequestContext();
                }
                if (p0) {
                    return;
                }
                FavoriteServicesView.access$showFailSaveServices(FavoriteServicesView.this);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                BaseActivity baseActivity = FavoriteServicesView.this.getBaseActivity();
                if (baseActivity == null) {
                    return;
                }
                DanaLoadingDialog danaLoadingDialog = new DanaLoadingDialog(baseActivity);
                if (!danaLoadingDialog.MyBillsEntityDataFactory.isShowing()) {
                    danaLoadingDialog.MyBillsEntityDataFactory.show();
                    danaLoadingDialog.getAuthRequestContext.startRefresh();
                }
                this.getAuthRequestContext = danaLoadingDialog;
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                DanaLoadingDialog danaLoadingDialog = this.getAuthRequestContext;
                if (danaLoadingDialog != null) {
                    danaLoadingDialog.PlaceComponentResult();
                }
                this.getAuthRequestContext = null;
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, FavoriteServicesModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, ApplicationComponent.class);
        new DaggerFavoriteServicesComponent.FavoriteServicesComponentImpl(MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory, MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0).KClassImpl$Data$declaredNonStaticMembers$2(this);
        registerPresenter(getPresenter());
    }

    @Override // id.dana.base.BaseRichView
    public final void injected(boolean isInjected) {
        if (isInjected) {
            getPresenter().PlaceComponentResult();
        }
    }

    @JvmName(name = "isItemFull")
    public final boolean isItemFull() {
        EditServiceAdapter editServiceAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (editServiceAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            editServiceAdapter = null;
        }
        return editServiceAdapter.getAuthRequestContext();
    }

    public final boolean replaceEmptyItem(ThirdPartyService service) {
        Intrinsics.checkNotNullParameter(service, "");
        if (containService(service)) {
            return false;
        }
        EditServiceAdapter editServiceAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (editServiceAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            editServiceAdapter = null;
        }
        Intrinsics.checkNotNullParameter(service, "");
        List<ThirdPartyService> items = editServiceAdapter.getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        Iterator<T> it = items.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            Object next = it.next();
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (((ThirdPartyService) next).D == 6) {
                editServiceAdapter.getItems().set(i, service);
                editServiceAdapter.notifyItemChanged(i);
                break;
            }
            i++;
        }
        FavoriteServiceActionListener favoriteServiceActionListener = this.favoriteServiceActionListener;
        if (favoriteServiceActionListener != null) {
            favoriteServiceActionListener.BuiltInFictitiousFunctionClassFactory();
        }
        return i >= 0;
    }

    public final int getItemViewType(int position) {
        EditServiceAdapter editServiceAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (editServiceAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            editServiceAdapter = null;
        }
        return editServiceAdapter.getItemViewType(position);
    }

    public final boolean containService(ThirdPartyService thirdPartyService) {
        Intrinsics.checkNotNullParameter(thirdPartyService, "");
        if (!BuiltInFictitiousFunctionClassFactory(thirdPartyService)) {
            EditServiceAdapter editServiceAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (editServiceAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                editServiceAdapter = null;
            }
            if (!editServiceAdapter.MyBillsEntityDataFactory(thirdPartyService)) {
                return false;
            }
        }
        return true;
    }

    private final boolean BuiltInFictitiousFunctionClassFactory(ThirdPartyService p0) {
        return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, p0);
    }

    public final void setOnEdit(boolean isEditMode) {
        setVisibility(isEditMode ? 0 : 8);
        EditServiceAdapter editServiceAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (editServiceAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            editServiceAdapter = null;
        }
        editServiceAdapter.MyBillsEntityDataFactory(isEditMode);
        if (isEditMode) {
            getPresenter().PlaceComponentResult();
        }
    }

    public static /* synthetic */ void $r8$lambda$RMsFEZeqzce_OBiE_3LfkCdTepo(FavoriteServicesView favoriteServicesView, int i) {
        Intrinsics.checkNotNullParameter(favoriteServicesView, "");
        int itemViewType = favoriteServicesView.getItemViewType(i);
        EditServiceAdapter editServiceAdapter = null;
        if (itemViewType == 2) {
            EditServiceAdapter editServiceAdapter2 = favoriteServicesView.KClassImpl$Data$declaredNonStaticMembers$2;
            if (editServiceAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                editServiceAdapter = editServiceAdapter2;
            }
            editServiceAdapter.removeItem(i);
            FavoriteServiceActionListener favoriteServiceActionListener = favoriteServicesView.favoriteServiceActionListener;
            if (favoriteServiceActionListener != null) {
                favoriteServiceActionListener.BuiltInFictitiousFunctionClassFactory();
            }
        } else if (itemViewType == 4) {
            ArrayList arrayList = new ArrayList();
            EditServiceAdapter editServiceAdapter3 = favoriteServicesView.KClassImpl$Data$declaredNonStaticMembers$2;
            if (editServiceAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                editServiceAdapter3 = null;
            }
            List<ThirdPartyService> items = editServiceAdapter3.getItems();
            if (!(items == null || items.isEmpty())) {
                EditServiceAdapter editServiceAdapter4 = favoriteServicesView.KClassImpl$Data$declaredNonStaticMembers$2;
                if (editServiceAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    editServiceAdapter4 = null;
                }
                int size = editServiceAdapter4.getItems().size();
                EditServiceAdapter editServiceAdapter5 = favoriteServicesView.KClassImpl$Data$declaredNonStaticMembers$2;
                if (editServiceAdapter5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    editServiceAdapter = editServiceAdapter5;
                }
                for (ThirdPartyService thirdPartyService : editServiceAdapter.getItems().subList(1, size - 1)) {
                    if (thirdPartyService.D == 6) {
                        arrayList.add("");
                    } else {
                        Intrinsics.checkNotNullExpressionValue(thirdPartyService, "");
                        if (PlaceComponentResult(thirdPartyService)) {
                            arrayList.add(thirdPartyService.NetworkUserEntityData$$ExternalSyntheticLambda8);
                        }
                    }
                }
            }
            favoriteServicesView.getPresenter().getAuthRequestContext(arrayList);
            return;
        }
        BaseRecyclerViewHolder.OnItemClickListener onItemClickListener = favoriteServicesView.onItemClickListener;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(i);
        }
    }

    public static /* synthetic */ int $r8$lambda$YZPc4Ea8Ze3DaTNYzoCvElIaRBE(ThirdPartyService thirdPartyService) {
        return thirdPartyService.D == 0 ? 2 : 0;
    }

    public static final /* synthetic */ void access$showFailSaveServices(FavoriteServicesView favoriteServicesView) {
        BaseActivity baseActivity = favoriteServicesView.getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        CustomToastUtil.PlaceComponentResult(baseActivity, R.drawable.ic_close_red, R.drawable.bg_rounded_toast_payment_auth, favoriteServicesView.getContext().getString(R.string.msg_save_services_fail), 48, 60, false, null, 384);
    }

    private static boolean PlaceComponentResult(ThirdPartyService p0) {
        return p0.D == 2 || p0.D == 0;
    }

    public final void setItems(List<ThirdPartyService> featuredServices) {
        Intrinsics.checkNotNullParameter(featuredServices, "");
        if (featuredServices.size() > 1) {
            this.BuiltInFictitiousFunctionClassFactory = featuredServices.remove(1);
        }
        EditServiceAdapter editServiceAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (editServiceAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            editServiceAdapter = null;
        }
        editServiceAdapter.setItems(featuredServices);
        FavoriteServiceActionListener favoriteServiceActionListener = this.favoriteServiceActionListener;
        if (favoriteServiceActionListener != null) {
            favoriteServiceActionListener.BuiltInFictitiousFunctionClassFactory();
        }
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        EditServiceAdapter editServiceAdapter = new EditServiceAdapter();
        editServiceAdapter.getAuthRequestContext = new ServiceAdapter.EditItemBadgeLookup() { // from class: id.dana.service.favorites.FavoriteServicesView$$ExternalSyntheticLambda1
            @Override // id.dana.service.adapter.ServiceAdapter.EditItemBadgeLookup
            public final int MyBillsEntityDataFactory(ThirdPartyService thirdPartyService) {
                return FavoriteServicesView.$r8$lambda$YZPc4Ea8Ze3DaTNYzoCvElIaRBE(thirdPartyService);
            }
        };
        editServiceAdapter.setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.service.favorites.FavoriteServicesView$$ExternalSyntheticLambda0
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                FavoriteServicesView.$r8$lambda$RMsFEZeqzce_OBiE_3LfkCdTepo(FavoriteServicesView.this, i);
            }
        });
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a1050_linkedtreemap_linkedtreemapiterator);
        final EditServiceAdapter editServiceAdapter2 = editServiceAdapter;
        recyclerView.setAdapter(editServiceAdapter2);
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4);
        gridLayoutManager.moveToNextValue = new GridLayoutManager.SpanSizeLookup() { // from class: id.dana.service.favorites.FavoriteServicesView$getGridLayoutManager$1$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public final int PlaceComponentResult(int p0) {
                if (editServiceAdapter2.getItemViewType(p0) == 1) {
                    return gridLayoutManager.getErrorConfigVersion;
                }
                return 1;
            }
        };
        recyclerView.setLayoutManager(gridLayoutManager);
        DashedGridDivider.Builder builder = new DashedGridDivider.Builder();
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = new boolean[]{true, true, true, true};
        builder.BuiltInFictitiousFunctionClassFactory = new boolean[]{false, false, true, true};
        builder.PlaceComponentResult = ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f27022131100472);
        int authRequestContext = SizeUtil.getAuthRequestContext(2);
        if (authRequestContext <= 0) {
            throw new IllegalArgumentException("Dash gap must be greater than 0.");
        }
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = authRequestContext;
        int authRequestContext2 = SizeUtil.getAuthRequestContext(4);
        if (authRequestContext2 <= 0) {
            throw new IllegalArgumentException("Dash length must be greater than 0.");
        }
        builder.getAuthRequestContext = authRequestContext2;
        int authRequestContext3 = SizeUtil.getAuthRequestContext(1);
        if (authRequestContext3 <= 0) {
            throw new IllegalArgumentException("Dash thickness must be greater than 0.");
        }
        builder.MyBillsEntityDataFactory = authRequestContext3;
        if (builder.KClassImpl$Data$declaredNonStaticMembers$2 <= 0) {
            throw new IllegalArgumentException("Dash gap must be greater than 0.");
        }
        if (builder.getAuthRequestContext <= 0) {
            throw new IllegalArgumentException("Dash length must be greater than 0.");
        }
        if (builder.MyBillsEntityDataFactory <= 0) {
            throw new IllegalArgumentException("Dash thickness must be greater than 0.");
        }
        DashedGridDivider dashedGridDivider = new DashedGridDivider(builder.KClassImpl$Data$declaredNonStaticMembers$2, builder.getAuthRequestContext, builder.MyBillsEntityDataFactory, builder.PlaceComponentResult, builder.BuiltInFictitiousFunctionClassFactory, builder.NetworkUserEntityData$$ExternalSyntheticLambda0, builder.moveToNextValue, (byte) 0);
        Intrinsics.checkNotNullExpressionValue(dashedGridDivider, "");
        recyclerView.addItemDecoration(dashedGridDivider);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = editServiceAdapter;
    }
}
