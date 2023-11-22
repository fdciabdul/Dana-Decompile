package id.dana.nearbyme.merchantdetail.merchantphoto;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.OnClick;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ethanhua.skeleton.SkeletonScreen;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerMerchantPhotoComponent;
import id.dana.di.component.MerchantPhotoModule;
import id.dana.domain.nearbyme.interactor.GetMerchantImage;
import id.dana.domain.nearbyme.model.MerchantImage;
import id.dana.nearbyme.extension.NearbyExtensionKt;
import id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerModel;
import id.dana.nearbyme.merchantdetail.mediaviewer.MerchantPhotoGalleryActivity;
import id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotoContract;
import id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotoViewerDialog;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import id.dana.nearbyme.model.ShopModel;
import id.dana.utils.ShimmeringUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&B\u001b\b\u0016\u0012\u0006\u0010$\u001a\u00020#\u0012\b\u0010(\u001a\u0004\u0018\u00010'¢\u0006\u0004\b%\u0010)B#\b\u0016\u0012\u0006\u0010$\u001a\u00020#\u0012\b\u0010(\u001a\u0004\u0018\u00010'\u0012\u0006\u0010*\u001a\u00020\u0002¢\u0006\u0004\b%\u0010+J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0019\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b!\u0010\""}, d2 = {"Lid/dana/nearbyme/merchantdetail/merchantphoto/MerchantPhotosView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "loadImages", "()V", "onClick", "setup", "Lid/dana/nearbyme/merchantdetail/merchantphoto/MerchantPhotoAdapter;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/nearbyme/merchantdetail/merchantphoto/MerchantPhotoAdapter;", "Lid/dana/nearbyme/merchantdetail/merchantphoto/MerchantPhotosPresenter;", "merchantPhotosPresenter", "Lid/dana/nearbyme/merchantdetail/merchantphoto/MerchantPhotosPresenter;", "getMerchantPhotosPresenter", "()Lid/dana/nearbyme/merchantdetail/merchantphoto/MerchantPhotosPresenter;", "setMerchantPhotosPresenter", "(Lid/dana/nearbyme/merchantdetail/merchantphoto/MerchantPhotosPresenter;)V", "Lid/dana/nearbyme/model/ShopModel;", "getAuthRequestContext", "Lid/dana/nearbyme/model/ShopModel;", "getShopModel", "()Lid/dana/nearbyme/model/ShopModel;", "setShopModel", "(Lid/dana/nearbyme/model/ShopModel;)V", "shopModel", "Lcom/ethanhua/skeleton/SkeletonScreen;", "BuiltInFictitiousFunctionClassFactory", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantPhotosView extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private SkeletonScreen getAuthRequestContext;
    private MerchantPhotoAdapter KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private ShopModel shopModel;
    @Inject
    public MerchantPhotosPresenter merchantPhotosPresenter;

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
        return R.layout.view_merchant_photos;
    }

    @JvmName(name = "getMerchantPhotosPresenter")
    public final MerchantPhotosPresenter getMerchantPhotosPresenter() {
        MerchantPhotosPresenter merchantPhotosPresenter = this.merchantPhotosPresenter;
        if (merchantPhotosPresenter != null) {
            return merchantPhotosPresenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setMerchantPhotosPresenter")
    public final void setMerchantPhotosPresenter(MerchantPhotosPresenter merchantPhotosPresenter) {
        Intrinsics.checkNotNullParameter(merchantPhotosPresenter, "");
        this.merchantPhotosPresenter = merchantPhotosPresenter;
    }

    @JvmName(name = "getShopModel")
    public final ShopModel getShopModel() {
        return this.shopModel;
    }

    @JvmName(name = "setShopModel")
    public final void setShopModel(ShopModel shopModel) {
        this.shopModel = shopModel;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantPhotosView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantPhotosView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantPhotosView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public final void loadImages() {
        ShopModel shopModel = this.shopModel;
        if (shopModel != null) {
            final MerchantPhotosPresenter merchantPhotosPresenter = getMerchantPhotosPresenter();
            String str = shopModel.NetworkUserEntityData$$ExternalSyntheticLambda3;
            Intrinsics.checkNotNullExpressionValue(str, "");
            String str2 = shopModel.BottomSheetCardBindingView$watcherCardNumberView$1;
            Intrinsics.checkNotNullExpressionValue(str2, "");
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            merchantPhotosPresenter.MyBillsEntityDataFactory.showProgress();
            merchantPhotosPresenter.PlaceComponentResult.invoke(new GetMerchantImage.Param(str, str2, 1, 10, false, 16, null), new Function1<List<? extends MerchantImage>, Unit>() { // from class: id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotosPresenter$loadMerchantImage$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(List<? extends MerchantImage> list) {
                    invoke2((List<MerchantImage>) list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(List<MerchantImage> list) {
                    List<MerchantImageModel> authRequestContext;
                    Intrinsics.checkNotNullParameter(list, "");
                    MerchantPhotoContract.View view = MerchantPhotosPresenter.this.MyBillsEntityDataFactory;
                    authRequestContext = NearbyExtensionKt.getAuthRequestContext(list, 0);
                    view.PlaceComponentResult(authRequestContext);
                }
            }, new Function1<Exception, Unit>() { // from class: id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotosPresenter$loadMerchantImage$2
                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                    invoke2(exc);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Exception exc) {
                    Intrinsics.checkNotNullParameter(exc, "");
                    DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.NEARBY_EXCEPTION, exc.getMessage(), exc);
                }
            });
        }
    }

    @Override // id.dana.base.BaseRichView
    public final void injectComponent(ApplicationComponent applicationComponent) {
        DaggerMerchantPhotoComponent.Builder MyBillsEntityDataFactory = DaggerMerchantPhotoComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        MyBillsEntityDataFactory.getAuthRequestContext = (MerchantPhotoModule) Preconditions.getAuthRequestContext(new MerchantPhotoModule(new MerchantPhotoContract.View() { // from class: id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotosView$injectComponent$1
            @Override // id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotoContract.View
            public final void PlaceComponentResult(List<MerchantImageModel> p0) {
                MerchantPhotoAdapter merchantPhotoAdapter;
                Intrinsics.checkNotNullParameter(p0, "");
                dismissProgress();
                if ((!p0.isEmpty()) != false) {
                    merchantPhotoAdapter = MerchantPhotosView.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (merchantPhotoAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        merchantPhotoAdapter = null;
                    }
                    merchantPhotoAdapter.setItems(p0);
                    MerchantPhotosView.this.setVisibility(0);
                }
                MerchantPhotosView.access$provideHeaderImageToDetailActivity(MerchantPhotosView.this, p0);
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                SkeletonScreen skeletonScreen;
                skeletonScreen = MerchantPhotosView.this.getAuthRequestContext;
                if (skeletonScreen != null) {
                    skeletonScreen.PlaceComponentResult();
                }
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                dismissProgress();
                MerchantPhotosView.access$provideHeaderImageToDetailActivity(MerchantPhotosView.this, new ArrayList());
                MerchantPhotosView.this.setVisibility(8);
            }

            @Override // id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                SkeletonScreen skeletonScreen;
                skeletonScreen = MerchantPhotosView.this.getAuthRequestContext;
                if (skeletonScreen != null) {
                    skeletonScreen.MyBillsEntityDataFactory();
                }
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.getAuthRequestContext, MerchantPhotoModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, ApplicationComponent.class);
        new DaggerMerchantPhotoComponent.MerchantPhotoComponentImpl(MyBillsEntityDataFactory.getAuthRequestContext, MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0).PlaceComponentResult(this);
    }

    public static final /* synthetic */ MediaViewerModel access$createMediaViewerModel(MerchantPhotosView merchantPhotosView, int i) {
        MerchantPhotoAdapter merchantPhotoAdapter = merchantPhotosView.KClassImpl$Data$declaredNonStaticMembers$2;
        if (merchantPhotoAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantPhotoAdapter = null;
        }
        List<MerchantImageModel> items = merchantPhotoAdapter.getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        return new MediaViewerModel(i, 50, 0, 0, false, items);
    }

    public static final /* synthetic */ MerchantPhotoViewerModel access$createMerchantPhotoViewerModel(MerchantPhotosView merchantPhotosView, MediaViewerModel mediaViewerModel) {
        ShopModel shopModel = merchantPhotosView.shopModel;
        String str = shopModel != null ? shopModel.newProxyInstance : null;
        if (str == null) {
            str = "";
        }
        ShopModel shopModel2 = merchantPhotosView.shopModel;
        String str2 = shopModel2 != null ? shopModel2.NetworkUserEntityData$$ExternalSyntheticLambda3 : null;
        return new MerchantPhotoViewerModel(str, str2 != null ? str2 : "", mediaViewerModel);
    }

    public static final /* synthetic */ void access$provideHeaderImageToDetailActivity(MerchantPhotosView merchantPhotosView, List list) {
        for (Context context = merchantPhotosView.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof MerchantDetailInteraction) {
                ((MerchantDetailInteraction) context).onImageLoaded(list);
            }
        }
        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.NEARBY_EXCEPTION, "Parent must implement MerchantDetailInteraction");
    }

    @OnClick({R.id.tv_see_all_photos})
    public final void onClick() {
        Context context = getContext();
        Intent intent = new Intent(getContext(), MerchantPhotoGalleryActivity.class);
        ShopModel shopModel = this.shopModel;
        String str = shopModel != null ? shopModel.newProxyInstance : null;
        if (str == null) {
            str = "";
        }
        intent.putExtra(MerchantPhotoGalleryActivity.EXTRA_MERCHANT_NAME, str);
        ShopModel shopModel2 = this.shopModel;
        String str2 = shopModel2 != null ? shopModel2.NetworkUserEntityData$$ExternalSyntheticLambda3 : null;
        if (str2 == null) {
            str2 = "";
        }
        intent.putExtra("EXTRA_MERCHANT_ID", str2);
        ShopModel shopModel3 = this.shopModel;
        String str3 = shopModel3 != null ? shopModel3.BottomSheetCardBindingView$watcherCardNumberView$1 : null;
        intent.putExtra("EXTRA_SHOP_ID", str3 != null ? str3 : "");
        context.startActivity(intent);
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new MerchantPhotoAdapter(new Function1<Integer, Unit>() { // from class: id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotosView$initRecyclerView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                MerchantPhotoViewerModel access$createMerchantPhotoViewerModel = MerchantPhotosView.access$createMerchantPhotoViewerModel(MerchantPhotosView.this, MerchantPhotosView.access$createMediaViewerModel(MerchantPhotosView.this, i));
                MerchantPhotoViewerDialog.Companion companion = MerchantPhotoViewerDialog.INSTANCE;
                FragmentManager supportFragmentManager = MerchantPhotosView.this.getBaseActivity().getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
                MerchantPhotoViewerDialog.Companion.BuiltInFictitiousFunctionClassFactory(supportFragmentManager, access$createMerchantPhotoViewerModel);
            }
        });
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rv_merchant_photos);
        MerchantPhotoAdapter merchantPhotoAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (merchantPhotoAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantPhotoAdapter = null;
        }
        recyclerView.setAdapter(merchantPhotoAdapter);
        ((RecyclerView) _$_findCachedViewById(R.id.rv_merchant_photos)).setNestedScrollingEnabled(false);
        if (this.getAuthRequestContext == null) {
            this.getAuthRequestContext = ShimmeringUtil.PlaceComponentResult((ConstraintLayout) _$_findCachedViewById(R.id.cl_merchant_photo_container), R.layout.view_merchant_photos_skeleton);
        }
    }
}
