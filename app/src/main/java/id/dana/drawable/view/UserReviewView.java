package id.dana.drawable.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.bumptech.glide.request.BaseRequestOptions;
import id.dana.R;
import id.dana.animation.HorizontalEvenlyItemDecoration;
import id.dana.base.BaseActivity;
import id.dana.base.BaseRichView;
import id.dana.component.buttoncomponent.DanaButtonGhostView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.drawable.merchantdetail.adapter.MerchantUserReviewAdapter;
import id.dana.nearbyme.merchantdetail.adapter.MerchantLatestReviewPhotoAdapter;
import id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerModel;
import id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotoViewerDialog;
import id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotoViewerModel;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewModel;
import id.dana.nearbyme.model.ShopModel;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.ImageResize;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010#\u001a\u00020\u0002¢\u0006\u0004\b$\u0010%B+\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\b\u0010\"\u001a\u0004\u0018\u00010!\u0012\u0006\u0010#\u001a\u00020\u0002\u0012\u0006\u0010&\u001a\u00020\u0002¢\u0006\u0004\b$\u0010'J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u001e"}, d2 = {"Lid/dana/nearbyrevamp/view/UserReviewView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;", "merchantReviewModel", "", "setData", "(Lid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;)V", "Lid/dana/nearbyme/model/ShopModel;", "shopModel", "setShopModel", "(Lid/dana/nearbyme/model/ShopModel;)V", "setup", "()V", "Lid/dana/nearbyme/merchantdetail/adapter/MerchantLatestReviewPhotoAdapter;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/nearbyme/merchantdetail/adapter/MerchantLatestReviewPhotoAdapter;", "getAuthRequestContext", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;", "MyBillsEntityDataFactory", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantUserReviewAdapter$RatingSectionListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantUserReviewAdapter$RatingSectionListener;", "getRatingListener", "()Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantUserReviewAdapter$RatingSectionListener;", "setRatingListener", "(Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantUserReviewAdapter$RatingSectionListener;)V", "ratingListener", "Lid/dana/nearbyme/model/ShopModel;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UserReviewView extends BaseRichView {
    private MerchantLatestReviewPhotoAdapter BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private MerchantUserReviewAdapter.RatingSectionListener ratingListener;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private ShopModel getAuthRequestContext;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private MerchantReviewModel MyBillsEntityDataFactory;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UserReviewView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UserReviewView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_user_review;
    }

    @JvmName(name = "getRatingListener")
    public final MerchantUserReviewAdapter.RatingSectionListener getRatingListener() {
        return this.ratingListener;
    }

    @JvmName(name = "setRatingListener")
    public final void setRatingListener(MerchantUserReviewAdapter.RatingSectionListener ratingSectionListener) {
        this.ratingListener = ratingSectionListener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserReviewView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ UserReviewView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserReviewView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [id.dana.nearbyme.merchantdetail.adapter.MerchantLatestReviewPhotoAdapter] */
    @Override // id.dana.base.BaseRichView
    public final void setup() {
        DefaultConstructorMarker defaultConstructorMarker = null;
        this.BuiltInFictitiousFunctionClassFactory = new MerchantLatestReviewPhotoAdapter(false, new Function1<MediaViewerModel, Unit>() { // from class: id.dana.nearbyrevamp.view.UserReviewView$setup$1
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
                ShopModel shopModel;
                Intrinsics.checkNotNullParameter(mediaViewerModel, "");
                merchantReviewModel = UserReviewView.this.MyBillsEntityDataFactory;
                if (merchantReviewModel != null) {
                    UserReviewView userReviewView = UserReviewView.this;
                    shopModel = userReviewView.getAuthRequestContext;
                    String str = shopModel != null ? shopModel.newProxyInstance : null;
                    if (str == null) {
                        str = "";
                    }
                    MerchantPhotoViewerModel merchantPhotoViewerModel = new MerchantPhotoViewerModel(str, merchantReviewModel.scheduleImpl, mediaViewerModel);
                    BaseActivity baseActivity = userReviewView.getBaseActivity();
                    if (baseActivity != null) {
                        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
                        MerchantPhotoViewerDialog.Companion companion = MerchantPhotoViewerDialog.INSTANCE;
                        FragmentManager supportFragmentManager = baseActivity.getSupportFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
                        MerchantPhotoViewerDialog.Companion.BuiltInFictitiousFunctionClassFactory(supportFragmentManager, merchantPhotoViewerModel);
                    }
                }
            }
        }, 1, defaultConstructorMarker);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.PathRelativizer);
        if (recyclerView != null) {
            ?? r1 = this.BuiltInFictitiousFunctionClassFactory;
            if (r1 == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                defaultConstructorMarker = r1;
            }
            recyclerView.setAdapter((RecyclerView.Adapter) defaultConstructorMarker);
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
            recyclerView.addItemDecoration(new HorizontalEvenlyItemDecoration());
            ViewCompat.BuiltInFictitiousFunctionClassFactory((View) recyclerView, false);
            recyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        }
        DanaButtonGhostView danaButtonGhostView = (DanaButtonGhostView) _$_findCachedViewById(R.id.VerifyPinStateManager$executeRiskChallenge$2$2);
        if (danaButtonGhostView != null) {
            danaButtonGhostView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyrevamp.view.UserReviewView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserReviewView.$r8$lambda$SNJIFip399_jljHDtBRkCUhVezk(UserReviewView.this, view);
                }
            });
        }
    }

    public final void setData(MerchantReviewModel merchantReviewModel) {
        if (merchantReviewModel != null) {
            this.MyBillsEntityDataFactory = merchantReviewModel;
            String str = merchantReviewModel.MyBillsEntityDataFactory;
            Context context = getContext();
            if (context != null) {
                GlideApp.getAuthRequestContext(context).MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory(str).BuiltInFictitiousFunctionClassFactory((BaseRequestOptions<?>) ImageResize.getAuthRequestContext()).PlaceComponentResult((int) R.drawable.avatar_placeholder).MyBillsEntityDataFactory((ImageView) ((AppCompatImageView) _$_findCachedViewById(R.id.res_0x7f0a0a5c_nearbyplaceentityrepository_externalsyntheticlambda0)));
            }
            String str2 = merchantReviewModel.PrepareContext;
            TextView textView = (TextView) _$_findCachedViewById(R.id.tvUserName);
            if (textView != null) {
                String str3 = str2;
                if (str3.length() == 0) {
                    str3 = getContext().getString(R.string.user_review_anonymous_label);
                }
                textView.setText(str3);
            }
            String str4 = merchantReviewModel.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (str4.length() == 0) {
                TextView textView2 = (TextView) _$_findCachedViewById(R.id.onBluetoothCharacteristicValueChange);
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
            } else {
                TextView textView3 = (TextView) _$_findCachedViewById(R.id.onBluetoothCharacteristicValueChange);
                if (textView3 != null) {
                    textView3.setVisibility(0);
                }
                TextView textView4 = (TextView) _$_findCachedViewById(R.id.onBluetoothCharacteristicValueChange);
                if (textView4 != null) {
                    textView4.setText(str4);
                }
            }
            int i = merchantReviewModel.initRecordTimeStamp;
            if (i == 0) {
                RatingStarView ratingStarView = (RatingStarView) _$_findCachedViewById(R.id.DanapolyRewardsEntityRepository_Factory);
                if (ratingStarView != null) {
                    ratingStarView.setVisibility(8);
                }
            } else {
                RatingStarView ratingStarView2 = (RatingStarView) _$_findCachedViewById(R.id.DanapolyRewardsEntityRepository_Factory);
                if (ratingStarView2 != null) {
                    ratingStarView2.setVisibility(0);
                }
                RatingStarView ratingStarView3 = (RatingStarView) _$_findCachedViewById(R.id.DanapolyRewardsEntityRepository_Factory);
                if (ratingStarView3 != null) {
                    ratingStarView3.setRating(i);
                }
            }
            long j = merchantReviewModel.moveToNextValue;
            TextView textView5 = (TextView) _$_findCachedViewById(R.id.res_0x7f0a1549_newwalletpresenter_getinvestmentcardassets_2);
            if (textView5 != null) {
                textView5.setText(DateTimeUtil.MyBillsEntityDataFactory(getContext(), Long.valueOf(j)));
            }
            List<MerchantImageModel> list = merchantReviewModel.BuiltInFictitiousFunctionClassFactory;
            MerchantLatestReviewPhotoAdapter merchantLatestReviewPhotoAdapter = this.BuiltInFictitiousFunctionClassFactory;
            if (merchantLatestReviewPhotoAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                merchantLatestReviewPhotoAdapter = null;
            }
            merchantLatestReviewPhotoAdapter.setItems(CollectionsKt.take(list, 10));
            boolean kClassImpl$Data$declaredNonStaticMembers$2 = merchantReviewModel.getKClassImpl$Data$declaredNonStaticMembers$2();
            DanaButtonGhostView danaButtonGhostView = (DanaButtonGhostView) _$_findCachedViewById(R.id.VerifyPinStateManager$executeRiskChallenge$2$2);
            if (danaButtonGhostView != null) {
                danaButtonGhostView.setVisibility(kClassImpl$Data$declaredNonStaticMembers$2 ? 0 : 8);
            }
        }
    }

    public final void setShopModel(ShopModel shopModel) {
        this.getAuthRequestContext = shopModel;
    }

    public static /* synthetic */ void $r8$lambda$SNJIFip399_jljHDtBRkCUhVezk(UserReviewView userReviewView, View view) {
        MerchantUserReviewAdapter.RatingSectionListener ratingSectionListener;
        Intrinsics.checkNotNullParameter(userReviewView, "");
        MerchantReviewModel merchantReviewModel = userReviewView.MyBillsEntityDataFactory;
        if (merchantReviewModel == null || (ratingSectionListener = userReviewView.ratingListener) == null) {
            return;
        }
        ratingSectionListener.getAuthRequestContext(merchantReviewModel);
    }
}
