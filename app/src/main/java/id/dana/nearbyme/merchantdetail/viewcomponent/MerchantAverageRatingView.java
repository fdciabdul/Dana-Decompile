package id.dana.nearbyme.merchantdetail.viewcomponent;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import butterknife.OnClick;
import com.alibaba.griver.api.constants.GriverEvents;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ethanhua.skeleton.SkeletonScreen;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseRichView;
import id.dana.data.auth.face.repository.source.network.NetworkFaceAuthenticationEntityData;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerMerchantAverageRatingComponent;
import id.dana.di.modules.MerchantAverageRatingModule;
import id.dana.domain.account.Account;
import id.dana.nearbyme.merchantdetail.merchantreviewdetail.MerchantReviewDetailActivity;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewSummaryModel;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingContract;
import id.dana.nearbyme.merchantreview.MerchantReviewDialogFragment;
import id.dana.nearbyme.merchantreview.ViewRatingStarBar;
import id.dana.nearbyme.merchantreview.model.MerchantConsultReviewModel;
import id.dana.nearbyme.merchantreview.model.MerchantReviewDialogDismissState;
import id.dana.nearbyme.model.ShopModel;
import id.dana.utils.ShimmeringUtil;
import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010N\u001a\u00020\u0002¢\u0006\u0004\bO\u0010PB+\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\u0006\u0010N\u001a\u00020\u0002\u0012\u0006\u0010Q\u001a\u00020\u0002¢\u0006\u0004\bO\u0010RJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u001b\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0007H\u0016¢\u0006\u0004\b!\u0010\u0016R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\"R\u0016\u0010$\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010&R\u0016\u0010(\u001a\u00020\u000f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010#\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010*R$\u0010,\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u00028\u0002@CX\u0082\u000e¢\u0006\f\n\u0004\b,\u0010-\"\u0004\b#\u0010.R.\u00107\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u00010/8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010?\u001a\u0002088\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010A\u001a\u00020@8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR$\u00109\u001a\u00020G2\u0006\u0010+\u001a\u00020G8\u0002@CX\u0083\u000e¢\u0006\f\n\u0004\bH\u0010I\"\u0004\b\u000b\u0010JR\u0018\u0010L\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bL\u0010M"}, d2 = {"Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantAverageRatingView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "", "BuiltInFictitiousFunctionClassFactory", "()Z", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lid/dana/nearbyme/model/ShopModel;", "shopModel", "canShowOwnReview", "canInputReview", "loadAverageRating", "(Landroidx/fragment/app/FragmentManager;Lid/dana/nearbyme/model/ShopModel;ZZ)V", "onClick", "()V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "title", GriverEvents.EVENT_SET_TITLE, "(Ljava/lang/CharSequence;)V", "setup", "Z", "getAuthRequestContext", "PlaceComponentResult", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewSummaryModel;", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewSummaryModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "Lid/dana/nearbyme/model/ShopModel;", "Landroidx/fragment/app/FragmentManager;", "p0", "lookAheadTest", "I", "(I)V", "Landroid/view/View$OnClickListener;", "value", "scheduleImpl", "Landroid/view/View$OnClickListener;", "getOnSeeAllClickListener", "()Landroid/view/View$OnClickListener;", "setOnSeeAllClickListener", "(Landroid/view/View$OnClickListener;)V", "onSeeAllClickListener", "", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Ljava/lang/String;", "getPageSource", "()Ljava/lang/String;", "setPageSource", "(Ljava/lang/String;)V", NetworkFaceAuthenticationEntityData.PAGE_SOURCE, "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantAverageRatingContract$Presenter;", "presenter", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantAverageRatingContract$Presenter;", "getPresenter", "()Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantAverageRatingContract$Presenter;", "setPresenter", "(Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantAverageRatingContract$Presenter;)V", "", "getErrorConfigVersion", LogConstants.RESULT_FALSE, "(F)V", "Lcom/ethanhua/skeleton/SkeletonScreen;", "moveToNextValue", "Lcom/ethanhua/skeleton/SkeletonScreen;", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantAverageRatingView extends BaseRichView {
    private boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private FragmentManager getAuthRequestContext;
    private ShopModel MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private String pageSource;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private MerchantReviewSummaryModel KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private float NetworkUserEntityData$$ExternalSyntheticLambda0;
    private int lookAheadTest;
    private SkeletonScreen moveToNextValue;
    @Inject
    public MerchantAverageRatingContract.Presenter presenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private View.OnClickListener onSeeAllClickListener;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[MerchantReviewDialogDismissState.values().length];
            iArr[MerchantReviewDialogDismissState.DISMISSED_BY_CANCEL.ordinal()] = 1;
            iArr[MerchantReviewDialogDismissState.DISMISSED_BY_SUBMIT.ordinal()] = 2;
            MyBillsEntityDataFactory = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MerchantAverageRatingView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MerchantAverageRatingView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_merchant_average_rating;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantAverageRatingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.pageSource = "";
    }

    public /* synthetic */ MerchantAverageRatingView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantAverageRatingView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.pageSource = "";
    }

    @JvmName(name = "getPresenter")
    public final MerchantAverageRatingContract.Presenter getPresenter() {
        MerchantAverageRatingContract.Presenter presenter = this.presenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(MerchantAverageRatingContract.Presenter presenter) {
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

    @JvmName(name = "getOnSeeAllClickListener")
    public final View.OnClickListener getOnSeeAllClickListener() {
        return this.onSeeAllClickListener;
    }

    @JvmName(name = "setOnSeeAllClickListener")
    public final void setOnSeeAllClickListener(View.OnClickListener onClickListener) {
        ((TextView) _$_findCachedViewById(R.id.tv_see_all_rating)).setOnClickListener(onClickListener);
        this.onSeeAllClickListener = onClickListener;
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    private final void BuiltInFictitiousFunctionClassFactory(float f) {
        TextView textView = (TextView) _$_findCachedViewById(R.id.tv_rating);
        if (textView != null) {
            String format = new DecimalFormat("##.0").format(Float.valueOf(f));
            Intrinsics.checkNotNullExpressionValue(format, "");
            textView.setText(StringsKt.replace$default(format, ",", ".", false, 4, (Object) null));
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = f;
    }

    @JvmName(name = "getAuthRequestContext")
    private final void getAuthRequestContext(int i) {
        TextView textView = (TextView) _$_findCachedViewById(R.id.res_0x7f0a1803_r8_lambda_bz3pxigslnoepxjsarblztaebgk);
        if (textView != null) {
            textView.setText(getResources().getString(R.string.number_of_rating_review_label, Integer.valueOf(i)));
        }
        this.lookAheadTest = i;
    }

    public final void loadAverageRating(FragmentManager fragmentManager, ShopModel shopModel, boolean canShowOwnReview, boolean canInputReview) {
        Intrinsics.checkNotNullParameter(fragmentManager, "");
        Intrinsics.checkNotNullParameter(shopModel, "");
        this.MyBillsEntityDataFactory = shopModel;
        this.getAuthRequestContext = fragmentManager;
        this.BuiltInFictitiousFunctionClassFactory = canInputReview;
        this.PlaceComponentResult = canShowOwnReview;
        MerchantAverageRatingContract.Presenter presenter = getPresenter();
        ShopModel shopModel2 = this.MyBillsEntityDataFactory;
        ShopModel shopModel3 = null;
        if (shopModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            shopModel2 = null;
        }
        String str = shopModel2.NetworkUserEntityData$$ExternalSyntheticLambda3;
        Intrinsics.checkNotNullExpressionValue(str, "");
        ShopModel shopModel4 = this.MyBillsEntityDataFactory;
        if (shopModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            shopModel3 = shopModel4;
        }
        String str2 = shopModel3.BottomSheetCardBindingView$watcherCardNumberView$1;
        Intrinsics.checkNotNullExpressionValue(str2, "");
        presenter.getAuthRequestContext(str, str2);
    }

    @Override // id.dana.base.BaseRichView
    public final void injectComponent(ApplicationComponent applicationComponent) {
        DaggerMerchantAverageRatingComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerMerchantAverageRatingComponent.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = (MerchantAverageRatingModule) Preconditions.getAuthRequestContext(new MerchantAverageRatingModule(new MerchantAverageRatingContract.View() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingView$injectComponent$1
            @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingContract.View
            public final /* synthetic */ void MyBillsEntityDataFactory(boolean z) {
                MerchantAverageRatingContract.View.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingContract.View
            public final /* synthetic */ void getAuthRequestContext(Account account) {
                MerchantAverageRatingContract.View.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingContract.View
            public final /* synthetic */ void getAuthRequestContext(MerchantConsultReviewModel merchantConsultReviewModel) {
                MerchantAverageRatingContract.View.CC.PlaceComponentResult(merchantConsultReviewModel);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
            }

            @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingContract.View
            public final void BuiltInFictitiousFunctionClassFactory(MerchantReviewSummaryModel p0) {
                boolean z;
                boolean z2;
                ShopModel shopModel;
                MerchantReviewSummaryModel merchantReviewSummaryModel;
                Intrinsics.checkNotNullParameter(p0, "");
                dismissProgress();
                MerchantAverageRatingView.this.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
                MerchantAverageRatingView.access$setupAverageRatingView(MerchantAverageRatingView.this, p0);
                MerchantAverageRatingView.access$toggleWholeSectionWithChecking(MerchantAverageRatingView.this);
                z = MerchantAverageRatingView.this.PlaceComponentResult;
                if (z) {
                    merchantReviewSummaryModel = MerchantAverageRatingView.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (merchantReviewSummaryModel != null && merchantReviewSummaryModel.KClassImpl$Data$declaredNonStaticMembers$2()) {
                        MerchantAverageRatingView.access$setupYourReviewSection(MerchantAverageRatingView.this);
                        LinearLayout linearLayout = (LinearLayout) MerchantAverageRatingView.this._$_findCachedViewById(R.id.user_review_section);
                        if (linearLayout != null) {
                            linearLayout.setVisibility(0);
                        }
                        LinearLayout linearLayout2 = (LinearLayout) MerchantAverageRatingView.this._$_findCachedViewById(R.id.input_review_section);
                        if (linearLayout2 != null) {
                            linearLayout2.setVisibility(8);
                            return;
                        }
                        return;
                    }
                    LinearLayout linearLayout3 = (LinearLayout) MerchantAverageRatingView.this._$_findCachedViewById(R.id.user_review_section);
                    if (linearLayout3 != null) {
                        linearLayout3.setVisibility(8);
                    }
                } else {
                    LinearLayout linearLayout4 = (LinearLayout) MerchantAverageRatingView.this._$_findCachedViewById(R.id.user_review_section);
                    if (linearLayout4 != null) {
                        linearLayout4.setVisibility(8);
                    }
                }
                z2 = MerchantAverageRatingView.this.BuiltInFictitiousFunctionClassFactory;
                if (z2) {
                    MerchantAverageRatingContract.Presenter presenter = MerchantAverageRatingView.this.getPresenter();
                    shopModel = MerchantAverageRatingView.this.MyBillsEntityDataFactory;
                    if (shopModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        shopModel = null;
                    }
                    String str = shopModel.BottomSheetCardBindingView$watcherCardNumberView$1;
                    Intrinsics.checkNotNullExpressionValue(str, "");
                    presenter.BuiltInFictitiousFunctionClassFactory(str);
                    return;
                }
                LinearLayout linearLayout5 = (LinearLayout) MerchantAverageRatingView.this._$_findCachedViewById(R.id.input_review_section);
                if (linearLayout5 != null) {
                    linearLayout5.setVisibility(8);
                }
            }

            @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                dismissProgress();
                MerchantAverageRatingView.access$hideInputRatingSection(MerchantAverageRatingView.this);
                MerchantAverageRatingView.access$toggleWholeSectionWithChecking(MerchantAverageRatingView.this);
            }

            @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(MerchantConsultReviewModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ViewRatingStarBar viewRatingStarBar = (ViewRatingStarBar) MerchantAverageRatingView.this._$_findCachedViewById(R.id.getOnProductFieldClicked);
                if (viewRatingStarBar != null) {
                    viewRatingStarBar.setOnStarClickListener(MerchantAverageRatingView.access$onStarClickListener(MerchantAverageRatingView.this, p0));
                }
                LinearLayout linearLayout = (LinearLayout) MerchantAverageRatingView.this._$_findCachedViewById(R.id.input_review_section);
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                MerchantAverageRatingView.access$toggleWholeSectionWithChecking(MerchantAverageRatingView.this);
            }

            @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingContract.View
            public final void getAuthRequestContext() {
                LinearLayout linearLayout = (LinearLayout) MerchantAverageRatingView.this._$_findCachedViewById(R.id.input_review_section);
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                MerchantAverageRatingView.access$toggleWholeSectionWithChecking(MerchantAverageRatingView.this);
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                SkeletonScreen skeletonScreen;
                skeletonScreen = MerchantAverageRatingView.this.moveToNextValue;
                if (skeletonScreen != null) {
                    skeletonScreen.PlaceComponentResult();
                }
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                SkeletonScreen skeletonScreen;
                skeletonScreen = MerchantAverageRatingView.this.moveToNextValue;
                if (skeletonScreen != null) {
                    skeletonScreen.MyBillsEntityDataFactory();
                }
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, MerchantAverageRatingModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, ApplicationComponent.class);
        new DaggerMerchantAverageRatingComponent.MerchantAverageRatingComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory, KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0).getAuthRequestContext(this);
        registerPresenter(getPresenter());
    }

    @Override // id.dana.base.BaseRichView
    public final void parseAttrs(Context context, AttributeSet attrs) {
        TypedArray obtainStyledAttributes;
        if (context == null || (obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.PrefetchDownloadStatus)) == null) {
            return;
        }
        BuiltInFictitiousFunctionClassFactory(obtainStyledAttributes.getFloat(1, 0.0f));
        getAuthRequestContext(obtainStyledAttributes.getInteger(0, 0));
        CharSequence text = getResources().getText(obtainStyledAttributes.getResourceId(3, R.string.merchant_rating_title));
        Intrinsics.checkNotNullExpressionValue(text, "");
        boolean z = obtainStyledAttributes.getBoolean(2, true);
        setTitle(text);
        TextView textView = (TextView) _$_findCachedViewById(R.id.tv_see_all_rating);
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
        }
        obtainStyledAttributes.recycle();
    }

    @OnClick({R.id.f4500tv_see_all_rating})
    public final void onClick() {
        Intent intent = new Intent(getContext(), MerchantReviewDetailActivity.class);
        ShopModel shopModel = this.MyBillsEntityDataFactory;
        if (shopModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            shopModel = null;
        }
        intent.putExtra("EXTRA_SHOP_MODEL", shopModel);
        intent.putExtra("EXTRA_SOURCE", this.pageSource);
        getContext().startActivity(intent);
    }

    public final void setTitle(CharSequence title) {
        Intrinsics.checkNotNullParameter(title, "");
        TextView textView = (TextView) _$_findCachedViewById(R.id.tv_title_average_rating);
        if (textView != null) {
            textView.setText(title);
        }
    }

    private final boolean BuiltInFictitiousFunctionClassFactory() {
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.ll_all_rating_container);
        if (linearLayout != null && linearLayout.getVisibility() == 8) {
            MerchantYourReviewView merchantYourReviewView = (MerchantYourReviewView) _$_findCachedViewById(R.id.QueryPayMethodModule_ProvidePresenterFactory);
            if (merchantYourReviewView != null && merchantYourReviewView.getVisibility() == 8) {
                LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(R.id.input_review_section);
                return linearLayout2 != null && linearLayout2.getVisibility() == 8;
            }
            return false;
        }
        return false;
    }

    public static final /* synthetic */ void access$handleOnReviewDialogDismiss(MerchantAverageRatingView merchantAverageRatingView, MerchantReviewDialogDismissState merchantReviewDialogDismissState) {
        LinearLayout linearLayout;
        int i = WhenMappings.MyBillsEntityDataFactory[merchantReviewDialogDismissState.ordinal()];
        if (i != 1) {
            if (i != 2 || (linearLayout = (LinearLayout) merchantAverageRatingView._$_findCachedViewById(R.id.input_review_section)) == null) {
                return;
            }
            linearLayout.setVisibility(8);
            return;
        }
        ViewRatingStarBar viewRatingStarBar = (ViewRatingStarBar) merchantAverageRatingView._$_findCachedViewById(R.id.getOnProductFieldClicked);
        if (viewRatingStarBar != null) {
            viewRatingStarBar.setStarSelected(0);
        }
    }

    public static final /* synthetic */ void access$hideInputRatingSection(MerchantAverageRatingView merchantAverageRatingView) {
        LinearLayout linearLayout = (LinearLayout) merchantAverageRatingView._$_findCachedViewById(R.id.your_review_section);
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingView$onStarClickListener$1] */
    public static final /* synthetic */ MerchantAverageRatingView$onStarClickListener$1 access$onStarClickListener(final MerchantAverageRatingView merchantAverageRatingView, final MerchantConsultReviewModel merchantConsultReviewModel) {
        return new ViewRatingStarBar.ClickListener() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingView$onStarClickListener$1
            @Override // id.dana.nearbyme.merchantreview.ViewRatingStarBar.ClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(int p0) {
                FragmentManager fragmentManager;
                fragmentManager = MerchantAverageRatingView.this.getAuthRequestContext;
                if (fragmentManager != null) {
                    MerchantConsultReviewModel merchantConsultReviewModel2 = merchantConsultReviewModel;
                    final MerchantAverageRatingView merchantAverageRatingView2 = MerchantAverageRatingView.this;
                    MerchantReviewDialogFragment.Companion companion = MerchantReviewDialogFragment.KClassImpl$Data$declaredNonStaticMembers$2;
                    merchantConsultReviewModel2.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
                    Intrinsics.checkNotNullParameter(TrackerKey.SourceType.MERCHANT_DETAIL, "");
                    merchantConsultReviewModel2.scheduleImpl = TrackerKey.SourceType.MERCHANT_DETAIL;
                    Unit unit = Unit.INSTANCE;
                    MerchantReviewDialogFragment.Companion.MyBillsEntityDataFactory(fragmentManager, merchantConsultReviewModel2, new Function1<MerchantReviewDialogDismissState, Unit>() { // from class: id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingView$onStarClickListener$1$onStarClick$1$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(MerchantReviewDialogDismissState merchantReviewDialogDismissState) {
                            invoke2(merchantReviewDialogDismissState);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(MerchantReviewDialogDismissState merchantReviewDialogDismissState) {
                            Intrinsics.checkNotNullParameter(merchantReviewDialogDismissState, "");
                            MerchantAverageRatingView.access$handleOnReviewDialogDismiss(MerchantAverageRatingView.this, merchantReviewDialogDismissState);
                        }
                    });
                }
            }
        };
    }

    public static final /* synthetic */ void access$setupAverageRatingView(MerchantAverageRatingView merchantAverageRatingView, MerchantReviewSummaryModel merchantReviewSummaryModel) {
        merchantAverageRatingView.BuiltInFictitiousFunctionClassFactory(merchantReviewSummaryModel.PlaceComponentResult);
        merchantAverageRatingView.getAuthRequestContext(merchantReviewSummaryModel.KClassImpl$Data$declaredNonStaticMembers$2);
        if (merchantAverageRatingView.NetworkUserEntityData$$ExternalSyntheticLambda0 == 0.0f) {
            merchantAverageRatingView._$_findCachedViewById(R.id.view_divider_rating).setVisibility(8);
            ((LinearLayout) merchantAverageRatingView._$_findCachedViewById(R.id.ll_all_rating_container)).setVisibility(8);
        }
    }

    public static final /* synthetic */ void access$setupYourReviewSection(MerchantAverageRatingView merchantAverageRatingView) {
        MerchantYourReviewView merchantYourReviewView = (MerchantYourReviewView) merchantAverageRatingView._$_findCachedViewById(R.id.QueryPayMethodModule_ProvidePresenterFactory);
        if (merchantYourReviewView != null) {
            MerchantReviewSummaryModel merchantReviewSummaryModel = merchantAverageRatingView.KClassImpl$Data$declaredNonStaticMembers$2;
            merchantYourReviewView.setMerchantReview(merchantReviewSummaryModel != null ? merchantReviewSummaryModel.MyBillsEntityDataFactory : null);
        }
    }

    public static final /* synthetic */ void access$toggleWholeSectionWithChecking(MerchantAverageRatingView merchantAverageRatingView) {
        if (merchantAverageRatingView.BuiltInFictitiousFunctionClassFactory()) {
            LinearLayout linearLayout = (LinearLayout) merchantAverageRatingView._$_findCachedViewById(R.id.ll_average_rating_area);
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
                return;
            }
            return;
        }
        LinearLayout linearLayout2 = (LinearLayout) merchantAverageRatingView._$_findCachedViewById(R.id.ll_average_rating_area);
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        if (this.moveToNextValue == null) {
            this.moveToNextValue = ShimmeringUtil.PlaceComponentResult((LinearLayout) _$_findCachedViewById(R.id.ll_average_rating_container), R.layout.view_skeleton_merchant_average_rating);
        }
    }
}
