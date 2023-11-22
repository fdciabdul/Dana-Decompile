package id.dana.richview.servicescard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.ap.zoloz.hummer.biz.HummerConstants;
import dagger.internal.Preconditions;
import id.dana.base.AbstractContractKt;
import id.dana.contract.services.ServiceCategoryContract;
import id.dana.contract.services.ServiceCategoryModule;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerServiceCategoryComponent;
import id.dana.richview.category.CategoryView;
import id.dana.richview.category.model.CategoryModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000e\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u000e\u0010\u000fR$\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00028\u0007@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\u00158\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/richview/servicescard/ServiceCategoryView;", "Lid/dana/richview/category/CategoryView;", "", "onHide", "", "hideFavoriteCategory", "(Z)V", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "", "", "includedCategories", "onlyGetIncludedCategories", "(Ljava/util/List;)V", "p0", "BuiltInFictitiousFunctionClassFactory", "Z", "isFavoriteCategoryOnHide", "()Z", "Lid/dana/contract/services/ServiceCategoryContract$Presenter;", "serviceCategoryPresenter", "Lid/dana/contract/services/ServiceCategoryContract$Presenter;", "getServiceCategoryPresenter", "()Lid/dana/contract/services/ServiceCategoryContract$Presenter;", "setServiceCategoryPresenter", "(Lid/dana/contract/services/ServiceCategoryContract$Presenter;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ServiceCategoryView extends CategoryView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private boolean isFavoriteCategoryOnHide;
    public Map<Integer, View> _$_findViewCache;
    @Inject
    public ServiceCategoryContract.Presenter serviceCategoryPresenter;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ServiceCategoryView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ServiceCategoryView(Context context, AttributeSet attributeSet) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServiceCategoryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ ServiceCategoryView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @JvmName(name = "isFavoriteCategoryOnHide")
    /* renamed from: isFavoriteCategoryOnHide  reason: from getter */
    public final boolean getIsFavoriteCategoryOnHide() {
        return this.isFavoriteCategoryOnHide;
    }

    @JvmName(name = "getServiceCategoryPresenter")
    public final ServiceCategoryContract.Presenter getServiceCategoryPresenter() {
        ServiceCategoryContract.Presenter presenter = this.serviceCategoryPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setServiceCategoryPresenter")
    public final void setServiceCategoryPresenter(ServiceCategoryContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.serviceCategoryPresenter = presenter;
    }

    @Override // id.dana.base.BaseRichView
    public final void injectComponent(ApplicationComponent applicationComponent) {
        Intrinsics.checkNotNullParameter(applicationComponent, "");
        DaggerServiceCategoryComponent.Builder authRequestContext = DaggerServiceCategoryComponent.getAuthRequestContext();
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        authRequestContext.getAuthRequestContext = (ServiceCategoryModule) Preconditions.getAuthRequestContext(new ServiceCategoryModule(new ServiceCategoryContract.View() { // from class: id.dana.richview.servicescard.ServiceCategoryView$injectComponent$1
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

            @Override // id.dana.contract.services.ServiceCategoryContract.View
            public final void PlaceComponentResult(List<CategoryModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ServiceCategoryView serviceCategoryView = ServiceCategoryView.this;
                serviceCategoryView.setData(p0, serviceCategoryView.getIsFavoriteCategoryOnHide());
            }

            @Override // id.dana.contract.services.ServiceCategoryContract.View
            public final void BuiltInFictitiousFunctionClassFactory(List<CategoryModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ServiceCategoryView serviceCategoryView = ServiceCategoryView.this;
                serviceCategoryView.setData(p0, serviceCategoryView.getIsFavoriteCategoryOnHide());
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.getAuthRequestContext, ServiceCategoryModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2, ApplicationComponent.class);
        new DaggerServiceCategoryComponent.ServiceCategoryComponentImpl(authRequestContext.getAuthRequestContext, authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0).MyBillsEntityDataFactory(this);
        registerPresenter(getServiceCategoryPresenter());
    }

    public final void onlyGetIncludedCategories(List<String> includedCategories) {
        Intrinsics.checkNotNullParameter(includedCategories, "");
        getServiceCategoryPresenter().MyBillsEntityDataFactory(includedCategories);
    }

    public final void hideFavoriteCategory(boolean onHide) {
        if (this.isFavoriteCategoryOnHide != onHide) {
            this.isFavoriteCategoryOnHide = onHide;
        }
    }
}
