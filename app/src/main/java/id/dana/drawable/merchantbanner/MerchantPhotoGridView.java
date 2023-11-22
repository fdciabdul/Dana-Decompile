package id.dana.drawable.merchantbanner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ethanhua.skeleton.SkeletonScreen;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.base.BaseRichView;
import id.dana.nearbyme.extension.NearbyViewExtKt;
import id.dana.nearbyme.merchantdetail.mediaviewer.MerchantPhotoGalleryActivity;
import id.dana.nearbyme.merchantdetail.mediaviewer.PhotoGalleryAdapter;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import id.dana.nearbyme.model.ShopModel;
import id.dana.utils.ShimmeringUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B'\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\u0002¢\u0006\u0004\b!\u0010\"B+\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0006\u0010#\u001a\u00020\u0002¢\u0006\u0004\b!\u0010$J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0011R\u0016\u0010\u000e\u001a\u00020\u00138\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u001a"}, d2 = {"Lid/dana/nearbyrevamp/merchantbanner/MerchantPhotoGridView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "Lid/dana/nearbyme/model/ShopModel;", "shopModel", "", "Lid/dana/nearbyme/merchantdetail/model/MerchantImageModel;", "merchantImages", "", "setImages", "(Lid/dana/nearbyme/model/ShopModel;Ljava/util/List;)V", "p0", "BuiltInFictitiousFunctionClassFactory", "(I)V", "setup", "()V", "showInitialState", "Lid/dana/nearbyme/merchantdetail/mediaviewer/PhotoGalleryAdapter;", "MyBillsEntityDataFactory", "Lid/dana/nearbyme/merchantdetail/mediaviewer/PhotoGalleryAdapter;", "PlaceComponentResult", "Lid/dana/nearbyme/model/ShopModel;", "getAuthRequestContext", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantPhotoGridView extends BaseRichView {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private PhotoGalleryAdapter BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private ShopModel getAuthRequestContext;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private SkeletonScreen KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MerchantPhotoGridView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MerchantPhotoGridView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_merchant_photo_grid;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantPhotoGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ MerchantPhotoGridView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantPhotoGridView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        this.BuiltInFictitiousFunctionClassFactory = new PhotoGalleryAdapter(new Function1<Integer, Unit>() { // from class: id.dana.nearbyrevamp.merchantbanner.MerchantPhotoGridView$setup$1
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
                PhotoGalleryAdapter photoGalleryAdapter;
                photoGalleryAdapter = MerchantPhotoGridView.this.BuiltInFictitiousFunctionClassFactory;
                if (photoGalleryAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    photoGalleryAdapter = null;
                }
                int i2 = photoGalleryAdapter.getItems().get(i).MyBillsEntityDataFactory;
                if (i2 == 1) {
                    MerchantPhotoGridView.access$openMerchantViewerDialog(MerchantPhotoGridView.this, i);
                } else if (i2 == 2) {
                    MerchantPhotoGridView.access$openGallery(MerchantPhotoGridView.this);
                }
            }
        });
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rvMerchantPhotoGrid);
        if (recyclerView != null) {
            recyclerView.setNestedScrollingEnabled(false);
            PhotoGalleryAdapter photoGalleryAdapter = this.BuiltInFictitiousFunctionClassFactory;
            if (photoGalleryAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                photoGalleryAdapter = null;
            }
            recyclerView.setAdapter(photoGalleryAdapter);
        }
        showInitialState();
    }

    public final void showInitialState() {
        PhotoGalleryAdapter photoGalleryAdapter = this.BuiltInFictitiousFunctionClassFactory;
        Unit unit = null;
        if (photoGalleryAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            photoGalleryAdapter = null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 3; i++) {
            arrayList.add(new MerchantImageModel(null, null, null, null, 1, 15, null));
        }
        photoGalleryAdapter.setItems(arrayList);
        SkeletonScreen skeletonScreen = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
        BuiltInFictitiousFunctionClassFactory(3);
        SkeletonScreen skeletonScreen2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (skeletonScreen2 != null) {
            skeletonScreen2.MyBillsEntityDataFactory();
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = ShimmeringUtil.PlaceComponentResult((RecyclerView) _$_findCachedViewById(R.id.rvMerchantPhotoGrid), R.layout.item_photo_preview_skeleton);
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory(int p0) {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rvMerchantPhotoGrid);
        RecyclerView.LayoutManager layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
        if (layoutManager == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        }
        ((GridLayoutManager) layoutManager).PlaceComponentResult(p0);
    }

    public final void setImages(ShopModel shopModel, List<MerchantImageModel> merchantImages) {
        Intrinsics.checkNotNullParameter(shopModel, "");
        Intrinsics.checkNotNullParameter(merchantImages, "");
        this.getAuthRequestContext = shopModel;
        ArrayList arrayList = new ArrayList();
        if (merchantImages.size() < 3) {
            arrayList.addAll(CollectionsKt.take(merchantImages, 1));
        } else {
            arrayList.addAll(CollectionsKt.take(merchantImages, 3));
        }
        if (arrayList.size() == 3) {
            arrayList.set(2, MerchantImageModel.KClassImpl$Data$declaredNonStaticMembers$2((MerchantImageModel) CollectionsKt.last((List) arrayList)));
        }
        SkeletonScreen skeletonScreen = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
        BuiltInFictitiousFunctionClassFactory(arrayList.size());
        PhotoGalleryAdapter photoGalleryAdapter = this.BuiltInFictitiousFunctionClassFactory;
        if (photoGalleryAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            photoGalleryAdapter = null;
        }
        photoGalleryAdapter.setItems(arrayList);
    }

    public static final /* synthetic */ void access$openGallery(MerchantPhotoGridView merchantPhotoGridView) {
        ShopModel shopModel = merchantPhotoGridView.getAuthRequestContext;
        if (shopModel != null) {
            MerchantPhotoGalleryActivity.Companion companion = MerchantPhotoGalleryActivity.INSTANCE;
            Context context = merchantPhotoGridView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            String str = shopModel.NetworkUserEntityData$$ExternalSyntheticLambda3;
            Intrinsics.checkNotNullExpressionValue(str, "");
            String str2 = shopModel.BottomSheetCardBindingView$watcherCardNumberView$1;
            Intrinsics.checkNotNullExpressionValue(str2, "");
            String str3 = shopModel.newProxyInstance;
            merchantPhotoGridView.getContext().startActivity(MerchantPhotoGalleryActivity.Companion.KClassImpl$Data$declaredNonStaticMembers$2(context, str, str2, str3 != null ? str3 : ""));
        }
    }

    public static final /* synthetic */ void access$openMerchantViewerDialog(MerchantPhotoGridView merchantPhotoGridView, int i) {
        BaseActivity baseActivity;
        if (merchantPhotoGridView.getAuthRequestContext == null || (baseActivity = merchantPhotoGridView.getBaseActivity()) == null) {
            return;
        }
        ShopModel shopModel = merchantPhotoGridView.getAuthRequestContext;
        Intrinsics.checkNotNull(shopModel);
        ShopModel shopModel2 = merchantPhotoGridView.getAuthRequestContext;
        Intrinsics.checkNotNull(shopModel2);
        List<MerchantImageModel> list = shopModel2.NetworkUserEntityData$$ExternalSyntheticLambda4;
        Intrinsics.checkNotNullExpressionValue(list, "");
        NearbyViewExtKt.PlaceComponentResult(baseActivity, shopModel, i, list);
    }
}
