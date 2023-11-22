package id.dana.nearbyme.merchantdetail.viewcomponent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ethanhua.skeleton.SkeletonScreen;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseRichView;
import id.dana.data.auth.face.repository.source.network.NetworkFaceAuthenticationEntityData;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerMerchantLatestReviewComponent;
import id.dana.di.modules.MerchantLatestReviewModule;
import id.dana.nearbyme.merchantdetail.adapter.MerchantLatestReviewAdapter;
import id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerModel;
import id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotoViewerDialog;
import id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotoViewerModel;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewModel;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantLatestReviewContract;
import id.dana.nearbyme.model.ShopModel;
import id.dana.utils.ShimmeringUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010)\u001a\u00020(\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*\u0012\b\b\u0002\u0010,\u001a\u00020\u0002¢\u0006\u0004\b-\u0010.B+\b\u0016\u0012\u0006\u0010)\u001a\u00020(\u0012\b\u0010+\u001a\u0004\u0018\u00010*\u0012\u0006\u0010,\u001a\u00020\u0002\u0012\u0006\u0010/\u001a\u00020\u0002¢\u0006\u0004\b-\u00100J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00168\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001f\u001a\u00020\u001e8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b&\u0010'"}, d2 = {"Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantLatestReviewView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "Lid/dana/nearbyme/model/ShopModel;", "shopModel", "loadLatestReview", "(Lid/dana/nearbyme/model/ShopModel;)V", "setup", "()V", "Lid/dana/nearbyme/merchantdetail/adapter/MerchantLatestReviewAdapter;", "getAuthRequestContext", "Lid/dana/nearbyme/merchantdetail/adapter/MerchantLatestReviewAdapter;", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "Lid/dana/nearbyme/model/ShopModel;", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "getPageSource", "()Ljava/lang/String;", "setPageSource", "(Ljava/lang/String;)V", NetworkFaceAuthenticationEntityData.PAGE_SOURCE, "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantLatestReviewContract$Presenter;", "presenter", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantLatestReviewContract$Presenter;", "getPresenter", "()Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantLatestReviewContract$Presenter;", "setPresenter", "(Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantLatestReviewContract$Presenter;)V", "Lcom/ethanhua/skeleton/SkeletonScreen;", "PlaceComponentResult", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantLatestReviewView extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private String pageSource;
    private ShopModel MyBillsEntityDataFactory;
    private SkeletonScreen PlaceComponentResult;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private MerchantLatestReviewAdapter KClassImpl$Data$declaredNonStaticMembers$2;
    @Inject
    public MerchantLatestReviewContract.Presenter presenter;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MerchantLatestReviewView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MerchantLatestReviewView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_merchant_latest_review;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantLatestReviewView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.MyBillsEntityDataFactory = new ShopModel();
        this.pageSource = "";
    }

    public /* synthetic */ MerchantLatestReviewView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantLatestReviewView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.MyBillsEntityDataFactory = new ShopModel();
        this.pageSource = "";
    }

    @JvmName(name = "getPresenter")
    public final MerchantLatestReviewContract.Presenter getPresenter() {
        MerchantLatestReviewContract.Presenter presenter = this.presenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(MerchantLatestReviewContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.presenter = presenter;
    }

    @JvmName(name = "getPageSource")
    public final String getPageSource() {
        return this.pageSource;
    }

    @JvmName(name = "setPageSource")
    public final void setPageSource(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.pageSource = str;
    }

    public final void loadLatestReview(ShopModel shopModel) {
        Intrinsics.checkNotNullParameter(shopModel, "");
        this.MyBillsEntityDataFactory = shopModel;
        SkeletonScreen skeletonScreen = this.PlaceComponentResult;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
        MerchantLatestReviewAdapter merchantLatestReviewAdapter = new MerchantLatestReviewAdapter(this.MyBillsEntityDataFactory, new Function1<MediaViewerModel, Unit>() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantLatestReviewView$initRecyclerView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(MediaViewerModel mediaViewerModel) {
                invoke2(mediaViewerModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(MediaViewerModel mediaViewerModel) {
                ShopModel shopModel2;
                ShopModel shopModel3;
                Intrinsics.checkNotNullParameter(mediaViewerModel, "");
                shopModel2 = MerchantLatestReviewView.this.MyBillsEntityDataFactory;
                String str = shopModel2.newProxyInstance;
                Intrinsics.checkNotNullExpressionValue(str, "");
                shopModel3 = MerchantLatestReviewView.this.MyBillsEntityDataFactory;
                String str2 = shopModel3.NetworkUserEntityData$$ExternalSyntheticLambda3;
                Intrinsics.checkNotNullExpressionValue(str2, "");
                MerchantPhotoViewerModel merchantPhotoViewerModel = new MerchantPhotoViewerModel(str, str2, mediaViewerModel);
                MerchantPhotoViewerDialog.Companion companion = MerchantPhotoViewerDialog.Companion;
                FragmentManager supportFragmentManager = MerchantLatestReviewView.this.getBaseActivity().getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
                MerchantPhotoViewerDialog.Companion.BuiltInFictitiousFunctionClassFactory(supportFragmentManager, merchantPhotoViewerModel);
            }
        });
        this.KClassImpl$Data$declaredNonStaticMembers$2 = merchantLatestReviewAdapter;
        String str = this.pageSource;
        Intrinsics.checkNotNullParameter(str, "");
        merchantLatestReviewAdapter.MyBillsEntityDataFactory = str;
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.ItemSplitBillPayerBinding);
        MerchantLatestReviewAdapter merchantLatestReviewAdapter2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (merchantLatestReviewAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantLatestReviewAdapter2 = null;
        }
        recyclerView.setAdapter(merchantLatestReviewAdapter2);
        ((RecyclerView) _$_findCachedViewById(R.id.ItemSplitBillPayerBinding)).setNestedScrollingEnabled(false);
        ShopModel shopModel2 = this.MyBillsEntityDataFactory;
        MerchantLatestReviewContract.Presenter presenter = getPresenter();
        String str2 = shopModel2.NetworkUserEntityData$$ExternalSyntheticLambda3;
        Intrinsics.checkNotNullExpressionValue(str2, "");
        String str3 = shopModel2.BottomSheetCardBindingView$watcherCardNumberView$1;
        Intrinsics.checkNotNullExpressionValue(str3, "");
        presenter.BuiltInFictitiousFunctionClassFactory(str2, str3);
    }

    @Override // id.dana.base.BaseRichView
    public final void injectComponent(ApplicationComponent applicationComponent) {
        DaggerMerchantLatestReviewComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerMerchantLatestReviewComponent.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (MerchantLatestReviewModule) Preconditions.getAuthRequestContext(new MerchantLatestReviewModule(new MerchantLatestReviewContract.View() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantLatestReviewView$injectComponent$1
            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantLatestReviewContract.View
            public final void BuiltInFictitiousFunctionClassFactory(List<MerchantReviewModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                dismissProgress();
                if (!p0.isEmpty()) {
                    MerchantLatestReviewView.access$setupMerchantReviewList(MerchantLatestReviewView.this, p0);
                } else {
                    ((ConstraintLayout) MerchantLatestReviewView.this._$_findCachedViewById(R.id.cl_merchant_latest_review)).setVisibility(8);
                }
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                SkeletonScreen skeletonScreen;
                skeletonScreen = MerchantLatestReviewView.this.PlaceComponentResult;
                if (skeletonScreen != null) {
                    skeletonScreen.PlaceComponentResult();
                }
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                dismissProgress();
                ((ConstraintLayout) MerchantLatestReviewView.this._$_findCachedViewById(R.id.cl_merchant_latest_review)).setVisibility(8);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                SkeletonScreen skeletonScreen;
                skeletonScreen = MerchantLatestReviewView.this.PlaceComponentResult;
                if (skeletonScreen != null) {
                    skeletonScreen.MyBillsEntityDataFactory();
                }
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, MerchantLatestReviewModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, ApplicationComponent.class);
        new DaggerMerchantLatestReviewComponent.MerchantLatestReviewComponentImpl(BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, (byte) 0).KClassImpl$Data$declaredNonStaticMembers$2(this);
        registerPresenter(getPresenter());
    }

    public static final /* synthetic */ void access$setupMerchantReviewList(MerchantLatestReviewView merchantLatestReviewView, List list) {
        List<MerchantReviewModel> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (MerchantReviewModel merchantReviewModel : list2) {
            MerchantReviewModel.Companion companion = MerchantReviewModel.INSTANCE;
            arrayList.add(MerchantReviewModel.Companion.getAuthRequestContext(merchantReviewModel));
        }
        ArrayList arrayList2 = arrayList;
        MerchantLatestReviewAdapter merchantLatestReviewAdapter = merchantLatestReviewView.KClassImpl$Data$declaredNonStaticMembers$2;
        MerchantLatestReviewAdapter merchantLatestReviewAdapter2 = null;
        if (merchantLatestReviewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantLatestReviewAdapter = null;
        }
        merchantLatestReviewAdapter.PlaceComponentResult = arrayList2.size() > 3;
        MerchantLatestReviewAdapter merchantLatestReviewAdapter3 = merchantLatestReviewView.KClassImpl$Data$declaredNonStaticMembers$2;
        if (merchantLatestReviewAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            merchantLatestReviewAdapter2 = merchantLatestReviewAdapter3;
        }
        merchantLatestReviewAdapter2.setItems(CollectionsKt.take(arrayList2, 3));
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        if (this.PlaceComponentResult == null) {
            this.PlaceComponentResult = ShimmeringUtil.PlaceComponentResult((RecyclerView) _$_findCachedViewById(R.id.ItemSplitBillPayerBinding), R.layout.view_skeleton_merchant_latest_view);
        }
    }
}
