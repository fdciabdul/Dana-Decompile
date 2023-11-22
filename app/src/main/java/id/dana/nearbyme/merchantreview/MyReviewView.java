package id.dana.nearbyme.merchantreview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.bumptech.glide.request.BaseRequestOptions;
import id.dana.R;
import id.dana.animation.HorizontalEvenlyItemDecoration;
import id.dana.base.BaseActivity;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.databinding.ViewMyReviewBinding;
import id.dana.drawable.view.RatingStarView;
import id.dana.nearbyme.merchantdetail.adapter.MerchantLatestReviewPhotoAdapter;
import id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerModel;
import id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotoViewerDialog;
import id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotoViewerModel;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewModel;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewViewModel;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.ImageResize;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010!\u001a\u00020\u0003¢\u0006\u0004\b\"\u0010#B+\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010$\u001a\u00020\u0003¢\u0006\u0004\b\"\u0010%J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0012\u001a\u00020\f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f0\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/nearbyme/merchantreview/MyReviewView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ViewMyReviewBinding;", "", "getLayout", "()I", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ViewMyReviewBinding;", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewViewModel;", "merchantReviewViewModel", "", "setData", "(Lid/dana/nearbyme/merchantdetail/model/MerchantReviewViewModel;)V", "Lkotlin/Function1;", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;", "onClickEditReview", "setEditReviewListener", "(Lkotlin/jvm/functions/Function1;)V", "setup", "()V", "MyBillsEntityDataFactory", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;", "getAuthRequestContext", "Lid/dana/nearbyme/merchantdetail/adapter/MerchantLatestReviewPhotoAdapter;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/nearbyme/merchantdetail/adapter/MerchantLatestReviewPhotoAdapter;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyReviewView extends ViewBindingRichView<ViewMyReviewBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private MerchantLatestReviewPhotoAdapter KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private MerchantReviewModel getAuthRequestContext;
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MyReviewView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MyReviewView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
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
        return R.layout.view_my_review;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyReviewView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ MyReviewView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyReviewView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final ViewMyReviewBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewMyReviewBinding MyBillsEntityDataFactory = ViewMyReviewBinding.MyBillsEntityDataFactory(view);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new MerchantLatestReviewPhotoAdapter(true, new Function1<MediaViewerModel, Unit>() { // from class: id.dana.nearbyme.merchantreview.MyReviewView$setup$1
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
                MerchantReviewModel merchantReviewModel;
                Intrinsics.checkNotNullParameter(mediaViewerModel, "");
                merchantReviewModel = MyReviewView.this.getAuthRequestContext;
                if (merchantReviewModel != null) {
                    MyReviewView myReviewView = MyReviewView.this;
                    MerchantPhotoViewerModel merchantPhotoViewerModel = new MerchantPhotoViewerModel(merchantReviewModel.getErrorConfigVersion, merchantReviewModel.scheduleImpl, mediaViewerModel);
                    BaseActivity baseActivity = myReviewView.getBaseActivity();
                    if (baseActivity != null) {
                        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
                        MerchantPhotoViewerDialog.Companion companion = MerchantPhotoViewerDialog.INSTANCE;
                        FragmentManager supportFragmentManager = baseActivity.getSupportFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
                        MerchantPhotoViewerDialog.Companion.BuiltInFictitiousFunctionClassFactory(supportFragmentManager, merchantPhotoViewerModel);
                    }
                }
            }
        });
        RecyclerView recyclerView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        MerchantLatestReviewPhotoAdapter merchantLatestReviewPhotoAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (merchantLatestReviewPhotoAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantLatestReviewPhotoAdapter = null;
        }
        recyclerView.setAdapter(merchantLatestReviewPhotoAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        recyclerView.addItemDecoration(new HorizontalEvenlyItemDecoration());
        ViewCompat.BuiltInFictitiousFunctionClassFactory((View) recyclerView, false);
        recyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
    }

    public final void setEditReviewListener(final Function1<? super MerchantReviewModel, Unit> onClickEditReview) {
        Intrinsics.checkNotNullParameter(onClickEditReview, "");
        getBinding().MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.merchantreview.MyReviewView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyReviewView.$r8$lambda$_z8DVwOKFdpYiPNFRwYJlDgOAY8(MyReviewView.this, onClickEditReview, view);
            }
        });
    }

    public static /* synthetic */ void $r8$lambda$_z8DVwOKFdpYiPNFRwYJlDgOAY8(MyReviewView myReviewView, Function1 function1, View view) {
        Intrinsics.checkNotNullParameter(myReviewView, "");
        Intrinsics.checkNotNullParameter(function1, "");
        MerchantReviewModel merchantReviewModel = myReviewView.getAuthRequestContext;
        if (merchantReviewModel != null) {
            function1.invoke(merchantReviewModel);
        }
    }

    public final void setData(MerchantReviewViewModel merchantReviewViewModel) {
        MerchantReviewModel merchantReviewModel;
        if (merchantReviewViewModel != null && (merchantReviewModel = merchantReviewViewModel.BuiltInFictitiousFunctionClassFactory) != null) {
            this.getAuthRequestContext = merchantReviewModel;
            String str = merchantReviewModel.getAuthRequestContext;
            Context context = getContext();
            if (context != null) {
                GlideApp.getAuthRequestContext(context).MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory(str).BuiltInFictitiousFunctionClassFactory((BaseRequestOptions<?>) ImageResize.getAuthRequestContext()).PlaceComponentResult((int) R.drawable.ic_merchant_logo_placeholder).MyBillsEntityDataFactory((ImageView) getBinding().getAuthRequestContext);
            }
            getBinding().lookAheadTest.setText(merchantReviewModel.getErrorConfigVersion);
            String str2 = merchantReviewModel.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (str2.length() == 0) {
                AppCompatTextView appCompatTextView = getBinding().scheduleImpl;
                Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
                appCompatTextView.setVisibility(8);
            } else {
                AppCompatTextView appCompatTextView2 = getBinding().scheduleImpl;
                Intrinsics.checkNotNullExpressionValue(appCompatTextView2, "");
                appCompatTextView2.setVisibility(0);
                getBinding().scheduleImpl.setText(str2);
            }
            int i = merchantReviewModel.initRecordTimeStamp;
            if (i == 0) {
                RatingStarView ratingStarView = getBinding().getErrorConfigVersion;
                Intrinsics.checkNotNullExpressionValue(ratingStarView, "");
                ratingStarView.setVisibility(8);
            } else {
                RatingStarView ratingStarView2 = getBinding().getErrorConfigVersion;
                Intrinsics.checkNotNullExpressionValue(ratingStarView2, "");
                ratingStarView2.setVisibility(0);
                getBinding().getErrorConfigVersion.setRating(i);
            }
            getBinding().moveToNextValue.setText(DateTimeUtil.MyBillsEntityDataFactory(getContext(), Long.valueOf(merchantReviewModel.moveToNextValue)));
            List take = CollectionsKt.take(merchantReviewModel.BuiltInFictitiousFunctionClassFactory, 10);
            MerchantLatestReviewPhotoAdapter merchantLatestReviewPhotoAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (merchantLatestReviewPhotoAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                merchantLatestReviewPhotoAdapter = null;
            }
            merchantLatestReviewPhotoAdapter.setItems(take);
        }
        boolean z = !(merchantReviewViewModel != null && merchantReviewViewModel.MyBillsEntityDataFactory == 6);
        View view = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0;
        Intrinsics.checkNotNullExpressionValue(view, "");
        view.setVisibility(z ? 0 : 8);
    }
}
