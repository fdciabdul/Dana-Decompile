package id.dana.nearbyme.merchantdetail.viewcomponent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.bumptech.glide.request.BaseRequestOptions;
import com.ethanhua.skeleton.SkeletonScreen;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.nearbyme.merchantdetail.adapter.MerchantLatestReviewPhotoAdapter;
import id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerModel;
import id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotoViewerDialog;
import id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotoViewerModel;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewModel;
import id.dana.nearbyme.merchantreview.ViewRatingStarBar;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.ImageResize;
import id.dana.utils.ShimmeringUtil;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R.\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b8\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0016"}, d2 = {"Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantYourReviewView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "", "setup", "()V", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;", "value", "MyBillsEntityDataFactory", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;", "getMerchantReview", "()Lid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;", "setMerchantReview", "(Lid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;)V", "merchantReview", "Lcom/ethanhua/skeleton/SkeletonScreen;", "PlaceComponentResult", "Lcom/ethanhua/skeleton/SkeletonScreen;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantYourReviewView extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final RecyclerView.RecycledViewPool KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private MerchantReviewModel merchantReview;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private SkeletonScreen BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> _$_findViewCache;

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
        return R.layout.view_merchant_your_review;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantYourReviewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new RecyclerView.RecycledViewPool();
    }

    public /* synthetic */ MerchantYourReviewView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    @JvmName(name = "getMerchantReview")
    public final MerchantReviewModel getMerchantReview() {
        return this.merchantReview;
    }

    @JvmName(name = "setMerchantReview")
    public final void setMerchantReview(MerchantReviewModel merchantReviewModel) {
        if (merchantReviewModel != null) {
            int i = 1;
            boolean z = false;
            if (!(merchantReviewModel.isLayoutRequested.length() == 0)) {
                SkeletonScreen skeletonScreen = this.BuiltInFictitiousFunctionClassFactory;
                if (skeletonScreen != null) {
                    skeletonScreen.PlaceComponentResult();
                }
                String str = merchantReviewModel.MyBillsEntityDataFactory;
                Context context = getContext();
                if (context != null) {
                    GlideApp.getAuthRequestContext(context).MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory(str).BuiltInFictitiousFunctionClassFactory((BaseRequestOptions<?>) ImageResize.getAuthRequestContext()).PlaceComponentResult((int) R.drawable.avatar_placeholder).MyBillsEntityDataFactory((ImageView) _$_findCachedViewById(R.id.iv_avatar_user));
                }
                String str2 = merchantReviewModel.PrepareContext;
                String str3 = str2;
                if (str3 == null || str3.length() == 0) {
                    TextView textView = (TextView) _$_findCachedViewById(R.id.getSecondaryProgressTintMode);
                    if (textView != null) {
                        textView.setText(getContext().getResources().getString(R.string.user_review_anonymous_label));
                    }
                } else {
                    TextView textView2 = (TextView) _$_findCachedViewById(R.id.getSecondaryProgressTintMode);
                    if (textView2 != null) {
                        if (str2 == null) {
                            str2 = "";
                        }
                        textView2.setText(str2);
                    }
                }
                String str4 = merchantReviewModel.NetworkUserEntityData$$ExternalSyntheticLambda1;
                String str5 = str4;
                if (str5 == null || str5.length() == 0) {
                    TextView textView3 = (TextView) _$_findCachedViewById(R.id.tv_review_description);
                    if (textView3 != null) {
                        textView3.setVisibility(8);
                    }
                } else {
                    TextView textView4 = (TextView) _$_findCachedViewById(R.id.tv_review_description);
                    if (textView4 != null) {
                        if (str4 == null) {
                            str4 = "";
                        }
                        textView4.setText(str4);
                    }
                    TextView textView5 = (TextView) _$_findCachedViewById(R.id.tv_review_description);
                    if (textView5 != null) {
                        textView5.setVisibility(0);
                    }
                }
                Integer valueOf = Integer.valueOf(merchantReviewModel.initRecordTimeStamp);
                ViewRatingStarBar viewRatingStarBar = (ViewRatingStarBar) _$_findCachedViewById(R.id.rating_star_bar);
                if (viewRatingStarBar != null) {
                    viewRatingStarBar.setStarSelected(valueOf != null ? valueOf.intValue() : 0);
                }
                List<MerchantImageModel> list = merchantReviewModel.BuiltInFictitiousFunctionClassFactory;
                MerchantLatestReviewPhotoAdapter merchantLatestReviewPhotoAdapter = new MerchantLatestReviewPhotoAdapter(z, new Function1<MediaViewerModel, Unit>() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantYourReviewView$setPhotoReview$adapter$1
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
                        Intrinsics.checkNotNullParameter(mediaViewerModel, "");
                        MerchantReviewModel merchantReview = MerchantYourReviewView.this.getMerchantReview();
                        String str6 = merchantReview != null ? merchantReview.NetworkUserEntityData$$ExternalSyntheticLambda0 : null;
                        if (str6 == null) {
                            str6 = "";
                        }
                        MerchantReviewModel merchantReview2 = MerchantYourReviewView.this.getMerchantReview();
                        String str7 = merchantReview2 != null ? merchantReview2.scheduleImpl : null;
                        if (str7 == null) {
                            str7 = "";
                        }
                        MerchantPhotoViewerModel merchantPhotoViewerModel = new MerchantPhotoViewerModel(str6, str7, mediaViewerModel);
                        MerchantPhotoViewerDialog.Companion companion = MerchantPhotoViewerDialog.INSTANCE;
                        FragmentManager supportFragmentManager = MerchantYourReviewView.this.getBaseActivity().getSupportFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
                        MerchantPhotoViewerDialog.Companion.BuiltInFictitiousFunctionClassFactory(supportFragmentManager, merchantPhotoViewerModel);
                    }
                }, i, null);
                RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rv_photo_review);
                if (recyclerView != null) {
                    recyclerView.setAdapter(merchantLatestReviewPhotoAdapter);
                }
                RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(R.id.rv_photo_review);
                if (recyclerView2 != null) {
                    recyclerView2.setRecycledViewPool(this.KClassImpl$Data$declaredNonStaticMembers$2);
                }
                merchantLatestReviewPhotoAdapter.setItems(list);
                long j = merchantReviewModel.moveToNextValue;
                TextView textView6 = (TextView) _$_findCachedViewById(R.id.saveMonthOfFetchFreeTransfer);
                String BuiltInFictitiousFunctionClassFactory = DateTimeUtil.BuiltInFictitiousFunctionClassFactory(getContext(), (int) DateTimeUtil.MyBillsEntityDataFactory(new Date(), new Date(j)), new Date(j), Boolean.FALSE);
                textView6.setText(BuiltInFictitiousFunctionClassFactory != null ? BuiltInFictitiousFunctionClassFactory : "");
                this.merchantReview = merchantReviewModel;
            }
        }
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.res_0x7f0a0de3_swipehelper_underlaybuttonclicklistener);
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        this.merchantReview = merchantReviewModel;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        if (this.BuiltInFictitiousFunctionClassFactory == null) {
            this.BuiltInFictitiousFunctionClassFactory = ShimmeringUtil.PlaceComponentResult((LinearLayout) _$_findCachedViewById(R.id.res_0x7f0a0de3_swipehelper_underlaybuttonclicklistener), R.layout.view_skeleton_merchant_latest_view);
        }
    }
}
