package id.dana.drawable.merchantdetail;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.Slide;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import androidx.view.LiveData;
import androidx.view.Observer;
import androidx.work.WorkInfo;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.iap.ac.android.common.container.provider.ui.ContainerUIProvider;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.base.BaseRichView;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.DanaUrl;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerMerchantDetailViewComponent;
import id.dana.di.modules.MerchantAverageRatingModule;
import id.dana.di.modules.MerchantDanaDealsModule;
import id.dana.di.modules.MerchantDetailConfigModule;
import id.dana.di.modules.MerchantDetailReviewModule;
import id.dana.domain.account.Account;
import id.dana.domain.nearbyme.model.MerchantDetailConfig;
import id.dana.drawable.merchantbanner.MerchantBannerView;
import id.dana.drawable.merchantbanner.MerchantPhotoGridView;
import id.dana.drawable.merchantdetail.MerchantDetailView;
import id.dana.drawable.merchantdetail.adapter.MerchantActionInfoAdapter;
import id.dana.drawable.merchantdetail.adapter.MerchantContactInfoAdapter;
import id.dana.drawable.merchantdetail.adapter.MerchantDetailPhotoAdapter;
import id.dana.drawable.merchantdetail.adapter.MerchantHeaderInfoAdapter;
import id.dana.drawable.merchantdetail.adapter.MerchantPromoDealsInfoAdapter;
import id.dana.drawable.merchantdetail.adapter.MerchantQrisInfoAdapter;
import id.dana.drawable.merchantdetail.adapter.MerchantReviewsInfoAdapter;
import id.dana.drawable.merchantdetail.adapter.MerchantSpecialDealsSectionAdapter;
import id.dana.drawable.merchantdetail.adapter.MerchantUserReviewAdapter;
import id.dana.drawable.model.MerchantBannerItemModel;
import id.dana.drawable.model.MerchantDetailInfoModel;
import id.dana.drawable.model.MerchantPromoDealsViewHolderModel;
import id.dana.drawable.model.RatingViewHolderModel;
import id.dana.extension.view.ViewExtKt;
import id.dana.model.DisplayedErrorModel;
import id.dana.nearbyme.extension.NearbyExtensionKt;
import id.dana.nearbyme.merchantdetail.MerchantDetailConfigContract;
import id.dana.nearbyme.merchantdetail.merchantphoto.MerchantDetailInteraction;
import id.dana.nearbyme.merchantdetail.model.MerchantDetailPromoConfigModel;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import id.dana.nearbyme.merchantdetail.model.MerchantProductInfoModel;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewModel;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewResultModel;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewSummaryModel;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewViewModel;
import id.dana.nearbyme.merchantdetail.model.ProductOrderModel;
import id.dana.nearbyme.merchantdetail.tracker.MerchantDetailAnalyticTracker;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingContract;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsContract;
import id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDetailReviewContract;
import id.dana.nearbyme.merchantreview.CreateReviewWorker;
import id.dana.nearbyme.merchantreview.MerchantReviewDialogFragment;
import id.dana.nearbyme.merchantreview.ViewRatingStarBar;
import id.dana.nearbyme.merchantreview.model.MerchantConsultReviewModel;
import id.dana.nearbyme.merchantreview.model.MerchantReviewDialogDismissState;
import id.dana.nearbyme.merchantreview.model.MerchantReviewTagModel;
import id.dana.nearbyme.model.NearbyDealsSectionModel;
import id.dana.nearbyme.model.NearbySpecialDealsItemWrapper;
import id.dana.nearbyme.model.ShopModel;
import id.dana.scanner.ScannerActivity;
import id.dana.tracker.mixpanel.MixPanelTracker;
import id.dana.utils.UrlUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.showcase.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u009a\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ³\u00012\u00020\u0001:\u0006³\u0001´\u0001µ\u0001B.\b\u0016\u0012\b\u0010«\u0001\u001a\u00030ª\u0001\u0012\f\b\u0002\u0010\u00ad\u0001\u001a\u0005\u0018\u00010¬\u0001\u0012\t\b\u0002\u0010®\u0001\u001a\u00020\u0002¢\u0006\u0006\b¯\u0001\u0010°\u0001B3\b\u0016\u0012\b\u0010«\u0001\u001a\u00030ª\u0001\u0012\n\u0010\u00ad\u0001\u001a\u0005\u0018\u00010¬\u0001\u0012\u0007\u0010®\u0001\u001a\u00020\u0002\u0012\u0007\u0010±\u0001\u001a\u00020\u0002¢\u0006\u0006\b¯\u0001\u0010²\u0001J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0019\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001b\u0010\bJ\r\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\bJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\bJ#\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0004\b\u0014\u0010!J\r\u0010\"\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010\bJ\u0015\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\r\u0010'\u001a\u00020\u0006¢\u0006\u0004\b'\u0010\bJ\r\u0010(\u001a\u00020\u0006¢\u0006\u0004\b(\u0010\bJ\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0012\u0010\u001aJ\u001b\u0010+\u001a\u00020\u00062\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060)¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0006H\u0016¢\u0006\u0004\b-\u0010\bJ-\u00101\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010/\u001a\u00020.2\u000e\b\u0002\u00100\u001a\b\u0012\u0004\u0012\u00020\u00060)¢\u0006\u0004\b1\u00102J\u0015\u00104\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u000e¢\u0006\u0004\b4\u0010\u0011J\u0015\u00106\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u000e¢\u0006\u0004\b6\u0010\u0011J\u001d\u00107\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b7\u00108J\r\u00109\u001a\u00020\u0006¢\u0006\u0004\b9\u0010\bJ\u001f\u0010=\u001a\u00020\u00062\b\u0010;\u001a\u0004\u0018\u00010:2\u0006\u0010<\u001a\u00020.¢\u0006\u0004\b=\u0010>J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020.H\u0002¢\u0006\u0004\b\u0014\u0010?J\u0015\u0010@\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b@\u0010\u001aR\u0016\u0010\u0007\u001a\u00020A8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0012\u0010BR\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u000e0C8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010DR\u0016\u0010\u001d\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010ER\u0016\u0010\u0014\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010FR\u0016\u0010\u0012\u001a\u00020G8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001d\u0010HR\u0018\u0010K\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010N\u001a\u00020L8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bK\u0010MR\"\u0010P\u001a\u00020O8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0016\u0010W\u001a\u00020V8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bW\u0010XR\"\u0010`\u001a\u00020Y8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R.\u0010h\u001a\u0004\u0018\u00010a2\b\u0010b\u001a\u0004\u0018\u00010a8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\bN\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u0016\u0010I\u001a\u00020i8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010Z\u001a\u00020l8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010r\u001a\u00020o8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010p\u001a\u00020s8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010t\u001a\u00020v8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\br\u0010wR\u0016\u0010j\u001a\u00020x8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\by\u0010zRX\u0010\u0083\u0001\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010\u0017¢\u0006\u0002\b|\u0012\u0004\u0012\u00020\u0006\u0018\u00010{2\u001b\u0010b\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010\u0017¢\u0006\u0002\b|\u0012\u0004\u0012\u00020\u0006\u0018\u00010{8\u0007@GX\u0087\u000e¢\u0006\u0015\n\u0004\b}\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R*\u0010\u0085\u0001\u001a\u00030\u0084\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001R*\u0010\u008c\u0001\u001a\u00030\u008b\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u008c\u0001\u0010\u008d\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R*\u0010\u0093\u0001\u001a\u00030\u0092\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001a\u0010m\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R*\u0010\u009c\u0001\u001a\u00030\u009b\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u009c\u0001\u0010\u009d\u0001\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001\"\u0006\b \u0001\u0010¡\u0001R%\u0010\u0099\u0001\u001a\u0011\u0012\f\u0012\n\u0012\u0005\u0012\u00030¤\u00010£\u00010¢\u0001X\u0083\u0080\u0002¢\u0006\b\n\u0006\b¥\u0001\u0010¦\u0001R)\u0010}\u001a\u0013\u0012\f\u0012\n\u0012\u0005\u0012\u00030¤\u00010£\u0001\u0018\u00010§\u00018\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/MerchantDetailView;", "Lid/dana/base/BaseRichView;", "", "getHeaderInfoViewBottom", "()I", "getLayout", "", "getAuthRequestContext", "()V", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "", "isInjected", "injected", "(Z)V", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "PlaceComponentResult", "p0", "(I)Z", "Lid/dana/nearbyme/model/ShopModel;", "shopModel", "loadCompleteMerchantDetailInfo", "(Lid/dana/nearbyme/model/ShopModel;)V", "onDetachedFromWindow", "onMerchantDetailReset", "MyBillsEntityDataFactory", "Lid/dana/nearbyme/merchantreview/model/MerchantConsultReviewModel;", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;", "p1", "(Lid/dana/nearbyme/merchantreview/model/MerchantConsultReviewModel;Lid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;)V", "scrollToTop", "", "slideOffset", "setOnBottomsheetDragged", "(F)V", "setOnCollapsed", "setOnFull", "Lkotlin/Function0;", "onTryAgainClicked", "setTryAgainListener", "(Lkotlin/jvm/functions/Function0;)V", "setup", "", "source", "onPreviewDataShown", "showCompleteShopDataWithPreviewFirst", "(Lid/dana/nearbyme/model/ShopModel;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "fullState", "showComponentWhenFullState", ContainerUIProvider.KEY_SHOW, "showErrorState", "showPreviewShopData", "(Lid/dana/nearbyme/model/ShopModel;Ljava/lang/String;)V", "smoothScrollToTop", "", "throwable", "operationType", "trackDisplayedErrorMessage", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "(Ljava/lang/String;)V", "updateImages", "Landroidx/recyclerview/widget/ConcatAdapter;", "Landroidx/recyclerview/widget/ConcatAdapter;", "Lkotlin/Pair;", "Lkotlin/Pair;", "Z", "Ljava/lang/String;", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantActionInfoAdapter;", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantActionInfoAdapter;", "getErrorConfigVersion", "Lid/dana/nearbyme/merchantreview/model/MerchantConsultReviewModel;", "lookAheadTest", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantContactInfoAdapter;", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantContactInfoAdapter;", "moveToNextValue", "Lid/dana/nearbyme/merchantdetail/MerchantDetailConfigContract$Presenter;", "merchantDetailConfigPresenter", "Lid/dana/nearbyme/merchantdetail/MerchantDetailConfigContract$Presenter;", "getMerchantDetailConfigPresenter", "()Lid/dana/nearbyme/merchantdetail/MerchantDetailConfigContract$Presenter;", "setMerchantDetailConfigPresenter", "(Lid/dana/nearbyme/merchantdetail/MerchantDetailConfigContract$Presenter;)V", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantDetailPhotoAdapter;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantDetailPhotoAdapter;", "Lid/dana/nearbyrevamp/merchantdetail/MerchantDetailView$MerchantDetailState;", "scheduleImpl", "Lid/dana/nearbyrevamp/merchantdetail/MerchantDetailView$MerchantDetailState;", "getMerchantDetailState", "()Lid/dana/nearbyrevamp/merchantdetail/MerchantDetailView$MerchantDetailState;", "setMerchantDetailState", "(Lid/dana/nearbyrevamp/merchantdetail/MerchantDetailView$MerchantDetailState;)V", "merchantDetailState", "Lid/dana/nearbyrevamp/merchantdetail/MerchantDetailView$MerchantDetailViewListener;", "value", "Lid/dana/nearbyrevamp/merchantdetail/MerchantDetailView$MerchantDetailViewListener;", "getMerchantDetailViewListener", "()Lid/dana/nearbyrevamp/merchantdetail/MerchantDetailView$MerchantDetailViewListener;", "setMerchantDetailViewListener", "(Lid/dana/nearbyrevamp/merchantdetail/MerchantDetailView$MerchantDetailViewListener;)V", "merchantDetailViewListener", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantHeaderInfoAdapter;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantHeaderInfoAdapter;", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantPromoDealsInfoAdapter;", "DatabaseTableConfigUtil", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantPromoDealsInfoAdapter;", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantQrisInfoAdapter;", "initRecordTimeStamp", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantQrisInfoAdapter;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantReviewsInfoAdapter;", "GetContactSyncConfig", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantReviewsInfoAdapter;", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantSpecialDealsSectionAdapter;", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantSpecialDealsSectionAdapter;", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantUserReviewAdapter;", "newProxyInstance", "Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantUserReviewAdapter;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "isLayoutRequested", "Lkotlin/jvm/functions/Function1;", "getOnOtherStoreClicked", "()Lkotlin/jvm/functions/Function1;", "setOnOtherStoreClicked", "(Lkotlin/jvm/functions/Function1;)V", "onOtherStoreClicked", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDanaDealsContract$Presenter;", "promoDealsPresenter", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDanaDealsContract$Presenter;", "getPromoDealsPresenter", "()Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDanaDealsContract$Presenter;", "setPromoDealsPresenter", "(Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDanaDealsContract$Presenter;)V", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantAverageRatingContract$Presenter;", "ratingPresenter", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantAverageRatingContract$Presenter;", "getRatingPresenter", "()Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantAverageRatingContract$Presenter;", "setRatingPresenter", "(Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantAverageRatingContract$Presenter;)V", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDetailReviewContract$Presenter;", "reviewPresenter", "Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDetailReviewContract$Presenter;", "getReviewPresenter", "()Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDetailReviewContract$Presenter;", "setReviewPresenter", "(Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantDetailReviewContract$Presenter;)V", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lid/dana/nearbyme/model/ShopModel;", "Lid/dana/nearbyme/merchantdetail/tracker/MerchantDetailAnalyticTracker;", "tracker", "Lid/dana/nearbyme/merchantdetail/tracker/MerchantDetailAnalyticTracker;", "getTracker", "()Lid/dana/nearbyme/merchantdetail/tracker/MerchantDetailAnalyticTracker;", "setTracker", "(Lid/dana/nearbyme/merchantdetail/tracker/MerchantDetailAnalyticTracker;)V", "Landroidx/lifecycle/Observer;", "", "Landroidx/work/WorkInfo;", "PrepareContext", "Lkotlin/Lazy;", "Landroidx/lifecycle/LiveData;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Landroidx/lifecycle/LiveData;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "MerchantDetailState", "MerchantDetailViewListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantDetailView extends BaseRichView {
    public static final double MIN_SLIDE_OFFSE_ANIMATION = 0.1d;
    public static final String NEARBY_DETAIL_PAGE_SOURCE = "Nearby (Shop) Detail Page";
    public static final int SEE_MORE_BUTTON_POSITION = 1;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private MerchantPromoDealsInfoAdapter scheduleImpl;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private MerchantReviewsInfoAdapter initRecordTimeStamp;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private ConcatAdapter getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private MerchantActionInfoAdapter KClassImpl$Data$declaredNonStaticMembers$2;
    private MerchantDetailPhotoAdapter NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private MerchantSpecialDealsSectionAdapter GetContactSyncConfig;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private MerchantHeaderInfoAdapter getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private LiveData<List<WorkInfo>> isLayoutRequested;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private ShopModel DatabaseTableConfigUtil;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private Pair<String, Boolean> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda8;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private String PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private MerchantConsultReviewModel lookAheadTest;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private MerchantQrisInfoAdapter NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private Function1<? super ShopModel, Unit> onOtherStoreClicked;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private MerchantContactInfoAdapter moveToNextValue;
    @Inject
    public MerchantDetailConfigContract.Presenter merchantDetailConfigPresenter;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private MerchantDetailViewListener merchantDetailViewListener;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private MerchantUserReviewAdapter NetworkUserEntityData$$ExternalSyntheticLambda2;
    @Inject
    public MerchantDanaDealsContract.Presenter promoDealsPresenter;
    @Inject
    public MerchantAverageRatingContract.Presenter ratingPresenter;
    @Inject
    public MerchantDetailReviewContract.Presenter reviewPresenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private MerchantDetailState merchantDetailState;
    @Inject
    public MerchantDetailAnalyticTracker tracker;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/MerchantDetailView$MerchantDetailState;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "ERROR"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public enum MerchantDetailState {
        DEFAULT,
        ERROR
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0003\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/MerchantDetailView$MerchantDetailViewListener;", "", "", "BuiltInFictitiousFunctionClassFactory", "()V", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "", "p0", "(Z)V", "getAuthRequestContext"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface MerchantDetailViewListener {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(boolean p0);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory();

        void getAuthRequestContext();
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[MerchantReviewDialogDismissState.values().length];
            iArr[MerchantReviewDialogDismissState.DISMISSED_BY_CANCEL.ordinal()] = 1;
            iArr[MerchantReviewDialogDismissState.DISMISSED_BY_SUBMIT.ordinal()] = 2;
            BuiltInFictitiousFunctionClassFactory = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MerchantDetailView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MerchantDetailView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_merchant_detail;
    }

    @JvmName(name = "getMerchantDetailConfigPresenter")
    public final MerchantDetailConfigContract.Presenter getMerchantDetailConfigPresenter() {
        MerchantDetailConfigContract.Presenter presenter = this.merchantDetailConfigPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setMerchantDetailConfigPresenter")
    public final void setMerchantDetailConfigPresenter(MerchantDetailConfigContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.merchantDetailConfigPresenter = presenter;
    }

    @JvmName(name = "getRatingPresenter")
    public final MerchantAverageRatingContract.Presenter getRatingPresenter() {
        MerchantAverageRatingContract.Presenter presenter = this.ratingPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setRatingPresenter")
    public final void setRatingPresenter(MerchantAverageRatingContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.ratingPresenter = presenter;
    }

    @JvmName(name = "getPromoDealsPresenter")
    public final MerchantDanaDealsContract.Presenter getPromoDealsPresenter() {
        MerchantDanaDealsContract.Presenter presenter = this.promoDealsPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPromoDealsPresenter")
    public final void setPromoDealsPresenter(MerchantDanaDealsContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.promoDealsPresenter = presenter;
    }

    @JvmName(name = "getReviewPresenter")
    public final MerchantDetailReviewContract.Presenter getReviewPresenter() {
        MerchantDetailReviewContract.Presenter presenter = this.reviewPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setReviewPresenter")
    public final void setReviewPresenter(MerchantDetailReviewContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.reviewPresenter = presenter;
    }

    @JvmName(name = "getTracker")
    public final MerchantDetailAnalyticTracker getTracker() {
        MerchantDetailAnalyticTracker merchantDetailAnalyticTracker = this.tracker;
        if (merchantDetailAnalyticTracker != null) {
            return merchantDetailAnalyticTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setTracker")
    public final void setTracker(MerchantDetailAnalyticTracker merchantDetailAnalyticTracker) {
        Intrinsics.checkNotNullParameter(merchantDetailAnalyticTracker, "");
        this.tracker = merchantDetailAnalyticTracker;
    }

    @JvmName(name = "getMerchantDetailState")
    public final MerchantDetailState getMerchantDetailState() {
        return this.merchantDetailState;
    }

    @JvmName(name = "setMerchantDetailState")
    public final void setMerchantDetailState(MerchantDetailState merchantDetailState) {
        Intrinsics.checkNotNullParameter(merchantDetailState, "");
        this.merchantDetailState = merchantDetailState;
    }

    @JvmName(name = "getMerchantDetailViewListener")
    public final MerchantDetailViewListener getMerchantDetailViewListener() {
        return this.merchantDetailViewListener;
    }

    @JvmName(name = "setMerchantDetailViewListener")
    public final void setMerchantDetailViewListener(MerchantDetailViewListener merchantDetailViewListener) {
        this.merchantDetailViewListener = merchantDetailViewListener;
        MerchantHeaderInfoAdapter merchantHeaderInfoAdapter = this.getErrorConfigVersion;
        if (merchantHeaderInfoAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantHeaderInfoAdapter = null;
        }
        merchantHeaderInfoAdapter.getAuthRequestContext = this.merchantDetailViewListener;
    }

    @JvmName(name = "getOnOtherStoreClicked")
    public final Function1<ShopModel, Unit> getOnOtherStoreClicked() {
        return this.onOtherStoreClicked;
    }

    @JvmName(name = "setOnOtherStoreClicked")
    public final void setOnOtherStoreClicked(Function1<? super ShopModel, Unit> function1) {
        this.onOtherStoreClicked = function1;
        MerchantContactInfoAdapter merchantContactInfoAdapter = this.moveToNextValue;
        if (merchantContactInfoAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantContactInfoAdapter = null;
        }
        merchantContactInfoAdapter.BuiltInFictitiousFunctionClassFactory = function1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantDetailView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.merchantDetailState = MerchantDetailState.DEFAULT;
        this.BuiltInFictitiousFunctionClassFactory = new Pair<>("", Boolean.FALSE);
        this.PlaceComponentResult = "";
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = LazyKt.lazy(new Function0<Observer<List<? extends WorkInfo>>>() { // from class: id.dana.nearbyrevamp.merchantdetail.MerchantDetailView$userCreatedReviewLiveDataObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Observer<List<? extends WorkInfo>> invoke() {
                return MerchantDetailView.access$getReviewWorkManagerObserver(MerchantDetailView.this);
            }
        });
    }

    public /* synthetic */ MerchantDetailView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantDetailView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.merchantDetailState = MerchantDetailState.DEFAULT;
        this.BuiltInFictitiousFunctionClassFactory = new Pair<>("", Boolean.FALSE);
        this.PlaceComponentResult = "";
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = LazyKt.lazy(new Function0<Observer<List<? extends WorkInfo>>>() { // from class: id.dana.nearbyrevamp.merchantdetail.MerchantDetailView$userCreatedReviewLiveDataObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Observer<List<? extends WorkInfo>> invoke() {
                return MerchantDetailView.access$getReviewWorkManagerObserver(MerchantDetailView.this);
            }
        });
    }

    private final void PlaceComponentResult(String p0) {
        MerchantDetailAnalyticTracker tracker = getTracker();
        ShopModel shopModel = this.DatabaseTableConfigUtil;
        String str = shopModel != null ? shopModel.NetworkUserEntityData$$ExternalSyntheticLambda6 : null;
        if (str == null) {
            str = "";
        }
        ShopModel shopModel2 = this.DatabaseTableConfigUtil;
        String str2 = shopModel2 != null ? shopModel2.newProxyInstance : null;
        if (str2 == null) {
            str2 = "";
        }
        ShopModel shopModel3 = this.DatabaseTableConfigUtil;
        String authRequestContext = shopModel3 != null ? shopModel3.getAuthRequestContext(false, ",") : null;
        tracker.KClassImpl$Data$declaredNonStaticMembers$2(p0, str, str2, authRequestContext != null ? authRequestContext : "");
    }

    @Override // id.dana.base.BaseRichView
    public final void injectComponent(ApplicationComponent applicationComponent) {
        DaggerMerchantDetailViewComponent.Builder PlaceComponentResult = DaggerMerchantDetailViewComponent.PlaceComponentResult();
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        PlaceComponentResult.MyBillsEntityDataFactory = (MerchantDetailConfigModule) Preconditions.getAuthRequestContext(new MerchantDetailConfigModule(new MerchantDetailConfigContract.View() { // from class: id.dana.nearbyrevamp.merchantdetail.MerchantDetailView$getMerchantDetailConfigModule$1
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

            @Override // id.dana.nearbyme.merchantdetail.MerchantDetailConfigContract.View
            public final void onGetActionConfig(MerchantDetailConfig p0) {
                MerchantActionInfoAdapter merchantActionInfoAdapter;
                Intrinsics.checkNotNullParameter(p0, "");
                merchantActionInfoAdapter = MerchantDetailView.this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (merchantActionInfoAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    merchantActionInfoAdapter = null;
                }
                merchantActionInfoAdapter.getItems().get(0).PlaceComponentResult = p0;
                merchantActionInfoAdapter.notifyItemChanged(0);
            }

            /* JADX WARN: Type inference failed for: r4v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker] */
            @Override // id.dana.nearbyme.merchantdetail.MerchantDetailConfigContract.View
            public final void onGetMerchantDetailPromoConfig(MerchantDetailPromoConfigModel p0) {
                ShopModel shopModel;
                MerchantSpecialDealsSectionAdapter merchantSpecialDealsSectionAdapter;
                Intrinsics.checkNotNullParameter(p0, "");
                shopModel = MerchantDetailView.this.DatabaseTableConfigUtil;
                if (shopModel != null) {
                    MerchantDetailView merchantDetailView = MerchantDetailView.this;
                    if (p0.getDealsSectionEnable()) {
                        merchantSpecialDealsSectionAdapter = merchantDetailView.GetContactSyncConfig;
                        ?? r4 = 0;
                        if (merchantSpecialDealsSectionAdapter == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            merchantSpecialDealsSectionAdapter = null;
                        }
                        merchantSpecialDealsSectionAdapter.setItems(CollectionsKt.listOf(new NearbyDealsSectionModel(NearbyDealsSectionModel.SectionState.LOADING, r4, 2, r4)));
                        MerchantDanaDealsContract.Presenter promoDealsPresenter = merchantDetailView.getPromoDealsPresenter();
                        String str = shopModel.NetworkUserEntityData$$ExternalSyntheticLambda3;
                        Intrinsics.checkNotNullExpressionValue(str, "");
                        String str2 = shopModel.BottomSheetCardBindingView$watcherCardNumberView$1;
                        Intrinsics.checkNotNullExpressionValue(str2, "");
                        promoDealsPresenter.BuiltInFictitiousFunctionClassFactory(str, str2, p0.getDealsLimit() + 1, !shopModel.NetworkUserEntityData$$ExternalSyntheticLambda2());
                        return;
                    }
                    MerchantDanaDealsContract.Presenter promoDealsPresenter2 = merchantDetailView.getPromoDealsPresenter();
                    String str3 = shopModel.NetworkUserEntityData$$ExternalSyntheticLambda3;
                    Intrinsics.checkNotNullExpressionValue(str3, "");
                    String str4 = shopModel.BottomSheetCardBindingView$watcherCardNumberView$1;
                    Intrinsics.checkNotNullExpressionValue(str4, "");
                    promoDealsPresenter2.BuiltInFictitiousFunctionClassFactory(str3, str4, 10, !shopModel.NetworkUserEntityData$$ExternalSyntheticLambda2());
                }
            }
        }));
        PlaceComponentResult.BuiltInFictitiousFunctionClassFactory = (MerchantAverageRatingModule) Preconditions.getAuthRequestContext(new MerchantAverageRatingModule(new MerchantAverageRatingContract.View() { // from class: id.dana.nearbyrevamp.merchantdetail.MerchantDetailView$getMerchantAverageRatingModule$1
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

            @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingContract.View
            public final void BuiltInFictitiousFunctionClassFactory(MerchantReviewSummaryModel p0) {
                ShopModel shopModel;
                MerchantUserReviewAdapter merchantUserReviewAdapter;
                Intrinsics.checkNotNullParameter(p0, "");
                shopModel = MerchantDetailView.this.DatabaseTableConfigUtil;
                if (shopModel != null) {
                    MerchantDetailView merchantDetailView = MerchantDetailView.this;
                    shopModel.readMicros = p0.PlaceComponentResult;
                    shopModel.SubSequence = p0.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (!p0.KClassImpl$Data$declaredNonStaticMembers$2()) {
                        MerchantAverageRatingContract.Presenter ratingPresenter = merchantDetailView.getRatingPresenter();
                        String str = shopModel.BottomSheetCardBindingView$watcherCardNumberView$1;
                        Intrinsics.checkNotNullExpressionValue(str, "");
                        ratingPresenter.BuiltInFictitiousFunctionClassFactory(str);
                        return;
                    }
                    MerchantReviewModel merchantReviewModel = p0.MyBillsEntityDataFactory;
                    if (merchantReviewModel != null) {
                        merchantReviewModel.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                    }
                    merchantUserReviewAdapter = merchantDetailView.NetworkUserEntityData$$ExternalSyntheticLambda2;
                    if (merchantUserReviewAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        merchantUserReviewAdapter = null;
                    }
                    MerchantReviewModel merchantReviewModel2 = p0.MyBillsEntityDataFactory;
                    Intrinsics.checkNotNull(merchantReviewModel2);
                    Intrinsics.checkNotNullParameter(shopModel, "");
                    Intrinsics.checkNotNullParameter(merchantReviewModel2, "");
                    List<RatingViewHolderModel> KClassImpl$Data$declaredNonStaticMembers$2 = merchantUserReviewAdapter.KClassImpl$Data$declaredNonStaticMembers$2(shopModel);
                    RatingViewHolderModel.Companion companion = RatingViewHolderModel.INSTANCE;
                    KClassImpl$Data$declaredNonStaticMembers$2.add(RatingViewHolderModel.Companion.KClassImpl$Data$declaredNonStaticMembers$2(merchantReviewModel2));
                    merchantUserReviewAdapter.setItems(KClassImpl$Data$declaredNonStaticMembers$2);
                    MerchantAverageRatingContract.Presenter ratingPresenter2 = merchantDetailView.getRatingPresenter();
                    String str2 = shopModel.BottomSheetCardBindingView$watcherCardNumberView$1;
                    Intrinsics.checkNotNullExpressionValue(str2, "");
                    ratingPresenter2.getAuthRequestContext(str2);
                }
            }

            @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                MerchantDetailView.access$setRatingStateOnError(MerchantDetailView.this);
            }

            @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(MerchantConsultReviewModel p0) {
                ShopModel shopModel;
                MerchantUserReviewAdapter merchantUserReviewAdapter;
                Intrinsics.checkNotNullParameter(p0, "");
                shopModel = MerchantDetailView.this.DatabaseTableConfigUtil;
                if (shopModel != null) {
                    merchantUserReviewAdapter = MerchantDetailView.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                    if (merchantUserReviewAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        merchantUserReviewAdapter = null;
                    }
                    Intrinsics.checkNotNullParameter(shopModel, "");
                    Intrinsics.checkNotNullParameter(p0, "");
                    List<RatingViewHolderModel> KClassImpl$Data$declaredNonStaticMembers$2 = merchantUserReviewAdapter.KClassImpl$Data$declaredNonStaticMembers$2(shopModel);
                    RatingViewHolderModel.Companion companion = RatingViewHolderModel.INSTANCE;
                    KClassImpl$Data$declaredNonStaticMembers$2.add(RatingViewHolderModel.Companion.MyBillsEntityDataFactory(p0));
                    merchantUserReviewAdapter.setItems(KClassImpl$Data$declaredNonStaticMembers$2);
                }
            }

            @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingContract.View
            public final void getAuthRequestContext() {
                MerchantDetailView.access$setRatingStateOnError(MerchantDetailView.this);
            }

            @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingContract.View
            public final void MyBillsEntityDataFactory(boolean p0) {
                MerchantUserReviewAdapter merchantUserReviewAdapter;
                merchantUserReviewAdapter = MerchantDetailView.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                if (merchantUserReviewAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    merchantUserReviewAdapter = null;
                }
                merchantUserReviewAdapter.PlaceComponentResult = p0;
            }

            @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingContract.View
            public final void getAuthRequestContext(Account p0) {
                MerchantUserReviewAdapter merchantUserReviewAdapter;
                merchantUserReviewAdapter = MerchantDetailView.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                if (merchantUserReviewAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    merchantUserReviewAdapter = null;
                }
                merchantUserReviewAdapter.MyBillsEntityDataFactory = p0;
            }

            @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantAverageRatingContract.View
            public final void getAuthRequestContext(MerchantConsultReviewModel p0) {
                ShopModel shopModel;
                Intrinsics.checkNotNullParameter(p0, "");
                shopModel = MerchantDetailView.this.DatabaseTableConfigUtil;
                if (shopModel != null) {
                    MerchantDetailView merchantDetailView = MerchantDetailView.this;
                    List<MerchantReviewTagModel> list = p0.BuiltInFictitiousFunctionClassFactory;
                    List<MerchantReviewTagModel> list2 = p0.PlaceComponentResult;
                    String str = shopModel.NetworkUserEntityData$$ExternalSyntheticLambda3;
                    Intrinsics.checkNotNullExpressionValue(str, "");
                    merchantDetailView.lookAheadTest = new MerchantConsultReviewModel(shopModel, list, list2, TrackerKey.SourceType.MERCHANT_DETAIL, str, 0, 32, null);
                }
            }
        }));
        PlaceComponentResult.getAuthRequestContext = (MerchantDetailReviewModule) Preconditions.getAuthRequestContext(new MerchantDetailReviewModule(new MerchantDetailReviewContract.View() { // from class: id.dana.nearbyrevamp.merchantdetail.MerchantDetailView$getMerchantReviewDetailModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDetailReviewContract.View
            public final void onSuccessGetReviewList(MerchantReviewResultModel p0) {
                MerchantReviewsInfoAdapter merchantReviewsInfoAdapter;
                Intrinsics.checkNotNullParameter(p0, "");
                MerchantDetailView.this.MyBillsEntityDataFactory = false;
                merchantReviewsInfoAdapter = MerchantDetailView.this.initRecordTimeStamp;
                if (merchantReviewsInfoAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    merchantReviewsInfoAdapter = null;
                }
                merchantReviewsInfoAdapter.setItems(NearbyExtensionKt.PlaceComponentResult(p0));
            }

            @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDetailReviewContract.View
            public final void onSuccessLoadMoreReview(MerchantReviewResultModel p0) {
                MerchantReviewsInfoAdapter merchantReviewsInfoAdapter;
                MerchantReviewsInfoAdapter merchantReviewsInfoAdapter2;
                Intrinsics.checkNotNullParameter(p0, "");
                MerchantDetailView.this.MyBillsEntityDataFactory = false;
                merchantReviewsInfoAdapter = MerchantDetailView.this.initRecordTimeStamp;
                MerchantReviewsInfoAdapter merchantReviewsInfoAdapter3 = null;
                if (merchantReviewsInfoAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    merchantReviewsInfoAdapter = null;
                }
                merchantReviewsInfoAdapter.KClassImpl$Data$declaredNonStaticMembers$2();
                merchantReviewsInfoAdapter2 = MerchantDetailView.this.initRecordTimeStamp;
                if (merchantReviewsInfoAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    merchantReviewsInfoAdapter3 = merchantReviewsInfoAdapter2;
                }
                merchantReviewsInfoAdapter3.appendItems(NearbyExtensionKt.PlaceComponentResult(p0));
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void onError(String p0) {
                MerchantReviewsInfoAdapter merchantReviewsInfoAdapter;
                MerchantReviewsInfoAdapter merchantReviewsInfoAdapter2;
                MerchantReviewsInfoAdapter merchantReviewsInfoAdapter3;
                MerchantDetailView.this.MyBillsEntityDataFactory = false;
                MerchantReviewsInfoAdapter merchantReviewsInfoAdapter4 = null;
                if (MerchantDetailView.this.getReviewPresenter().getKClassImpl$Data$declaredNonStaticMembers$2() == 1) {
                    merchantReviewsInfoAdapter3 = MerchantDetailView.this.initRecordTimeStamp;
                    if (merchantReviewsInfoAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        merchantReviewsInfoAdapter4 = merchantReviewsInfoAdapter3;
                    }
                    merchantReviewsInfoAdapter4.setItems(CollectionsKt.emptyList());
                    return;
                }
                merchantReviewsInfoAdapter = MerchantDetailView.this.initRecordTimeStamp;
                if (merchantReviewsInfoAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    merchantReviewsInfoAdapter = null;
                }
                merchantReviewsInfoAdapter.KClassImpl$Data$declaredNonStaticMembers$2();
                merchantReviewsInfoAdapter2 = MerchantDetailView.this.initRecordTimeStamp;
                if (merchantReviewsInfoAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    merchantReviewsInfoAdapter4 = merchantReviewsInfoAdapter2;
                }
                List<MerchantReviewViewModel> items = merchantReviewsInfoAdapter4.getItems();
                MerchantReviewModel.Companion companion = MerchantReviewModel.INSTANCE;
                items.add(MerchantReviewModel.Companion.getAuthRequestContext());
                merchantReviewsInfoAdapter4.notifyItemInserted(merchantReviewsInfoAdapter4.getItems().size() - 1);
            }
        }));
        PlaceComponentResult.PlaceComponentResult = (MerchantDanaDealsModule) Preconditions.getAuthRequestContext(new MerchantDanaDealsModule(new MerchantDanaDealsContract.View() { // from class: id.dana.nearbyrevamp.merchantdetail.MerchantDetailView$getMerchantDanaDealsModule$1
            @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsContract.View
            public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(List list) {
                Intrinsics.checkNotNullParameter(list, "");
            }

            @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsContract.View
            public final /* synthetic */ void MyBillsEntityDataFactory() {
                MerchantDanaDealsContract.View.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsContract.View
            public final /* synthetic */ void PlaceComponentResult() {
                MerchantDanaDealsContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsContract.View
            public final /* synthetic */ void PlaceComponentResult(ProductOrderModel productOrderModel) {
                Intrinsics.checkNotNullParameter(productOrderModel, "");
            }

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

            /* JADX WARN: Code restructure failed: missing block: B:15:0x003d, code lost:
            
                if (r1 == null) goto L16;
             */
            @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsContract.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void getAuthRequestContext() {
                /*
                    r5 = this;
                    id.dana.nearbyrevamp.merchantdetail.MerchantDetailView r0 = id.dana.drawable.merchantdetail.MerchantDetailView.this
                    id.dana.nearbyrevamp.merchantdetail.adapter.MerchantSpecialDealsSectionAdapter r0 = id.dana.drawable.merchantdetail.MerchantDetailView.access$getMerchantSpecialDealsSectionAdapter$p(r0)
                    r1 = 0
                    java.lang.String r2 = ""
                    if (r0 != 0) goto Lf
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
                    r0 = r1
                Lf:
                    java.util.List r3 = kotlin.collections.CollectionsKt.emptyList()
                    r0.setItems(r3)
                    id.dana.nearbyrevamp.merchantdetail.MerchantDetailView r0 = id.dana.drawable.merchantdetail.MerchantDetailView.this
                    id.dana.nearbyme.model.ShopModel r0 = id.dana.drawable.merchantdetail.MerchantDetailView.access$getShopModel$p(r0)
                    if (r0 == 0) goto L4a
                    id.dana.nearbyrevamp.merchantdetail.MerchantDetailView r3 = id.dana.drawable.merchantdetail.MerchantDetailView.this
                    id.dana.nearbyrevamp.merchantdetail.adapter.MerchantPromoDealsInfoAdapter r3 = id.dana.drawable.merchantdetail.MerchantDetailView.access$getMerchantPromoDealsInfoAdapter$p(r3)
                    if (r3 != 0) goto L2a
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
                    r3 = r1
                L2a:
                    java.util.List<id.dana.nearbyme.model.PromoInfoModel> r4 = r0.getCallingPid
                    if (r4 == 0) goto L3f
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)
                    r2 = r4
                    java.util.Collection r2 = (java.util.Collection) r2
                    boolean r2 = r2.isEmpty()
                    r2 = r2 ^ 1
                    if (r2 == 0) goto L3d
                    r1 = r4
                L3d:
                    if (r1 != 0) goto L43
                L3f:
                    java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
                L43:
                    java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
                    r3.MyBillsEntityDataFactory(r1, r2, r0)
                L4a:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: id.dana.drawable.merchantdetail.MerchantDetailView$getMerchantDanaDealsModule$1.getAuthRequestContext():void");
            }

            /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
            
                if ((r3 == null || r3.isEmpty()) != false) goto L13;
             */
            @Override // id.dana.nearbyme.merchantdetail.viewcomponent.MerchantDanaDealsContract.View
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void PlaceComponentResult(boolean r7, java.util.List<? extends id.dana.nearbyme.model.PromoInfoModel> r8, java.util.List<id.dana.nearbyme.merchantdetail.model.MerchantProductInfoModel> r9) {
                /*
                    r6 = this;
                    java.lang.String r0 = ""
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                    id.dana.nearbyrevamp.merchantdetail.MerchantDetailView r1 = id.dana.drawable.merchantdetail.MerchantDetailView.this
                    id.dana.nearbyme.model.ShopModel r1 = id.dana.drawable.merchantdetail.MerchantDetailView.access$getShopModel$p(r1)
                    if (r1 == 0) goto L8d
                    id.dana.nearbyrevamp.merchantdetail.MerchantDetailView r2 = id.dana.drawable.merchantdetail.MerchantDetailView.this
                    boolean r3 = r1.NetworkUserEntityData$$ExternalSyntheticLambda2()
                    r4 = 1
                    r5 = 0
                    if (r3 == 0) goto L2b
                    java.util.List<id.dana.nearbyme.model.PromoInfoModel> r3 = r1.getCallingPid
                    java.util.Collection r3 = (java.util.Collection) r3
                    if (r3 == 0) goto L28
                    boolean r3 = r3.isEmpty()
                    if (r3 != 0) goto L28
                    r3 = 0
                    goto L29
                L28:
                    r3 = 1
                L29:
                    if (r3 == 0) goto L76
                L2b:
                    r3 = r8
                    java.util.Collection r3 = (java.util.Collection) r3
                    boolean r3 = r3.isEmpty()
                    r3 = r3 ^ r4
                    if (r3 == 0) goto L76
                    r1.MyBillsEntityDataFactory(r8)
                    id.dana.nearbyrevamp.merchantdetail.adapter.MerchantHeaderInfoAdapter r8 = id.dana.drawable.merchantdetail.MerchantDetailView.access$getMerchantHeaderInfoAdapter$p(r2)
                    if (r8 != 0) goto L42
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
                    r8 = 0
                L42:
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
                    java.util.List r3 = r8.getItems()
                    java.util.Collection r3 = (java.util.Collection) r3
                    if (r3 == 0) goto L54
                    boolean r3 = r3.isEmpty()
                    if (r3 != 0) goto L54
                    r4 = 0
                L54:
                    if (r4 != 0) goto L76
                    java.util.List r3 = r8.getItems()
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
                    java.lang.Object r0 = kotlin.collections.CollectionsKt.first(r3)
                    id.dana.nearbyrevamp.model.MerchantDetailInfoModel r0 = (id.dana.drawable.model.MerchantDetailInfoModel) r0
                    int r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2
                    if (r0 != 0) goto L76
                    java.util.List r0 = r8.getItems()
                    java.lang.Object r0 = r0.get(r5)
                    id.dana.nearbyrevamp.model.MerchantDetailInfoModel r0 = (id.dana.drawable.model.MerchantDetailInfoModel) r0
                    r0.BuiltInFictitiousFunctionClassFactory = r1
                    r8.notifyItemChanged(r5)
                L76:
                    java.util.List<id.dana.nearbyme.model.PromoInfoModel> r8 = r1.getCallingPid
                    if (r8 != 0) goto L7e
                    java.util.List r8 = kotlin.collections.CollectionsKt.emptyList()
                L7e:
                    id.dana.drawable.merchantdetail.MerchantDetailView.access$updatePromoAndDealsInfo(r2, r9, r8)
                    if (r7 == 0) goto L8d
                    id.dana.nearbyrevamp.merchantdetail.MerchantDetailView$getMerchantDanaDealsModule$1$onSuccessGetMerchantPromoAndDeals$1$1 r7 = new id.dana.nearbyrevamp.merchantdetail.MerchantDetailView$getMerchantDanaDealsModule$1$onSuccessGetMerchantPromoAndDeals$1$1
                    r7.<init>()
                    kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
                    id.dana.drawable.merchantdetail.MerchantDetailView.access$doOnMerchantDetailInteractionImplemented(r2, r7)
                L8d:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: id.dana.drawable.merchantdetail.MerchantDetailView$getMerchantDanaDealsModule$1.PlaceComponentResult(boolean, java.util.List, java.util.List):void");
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.PlaceComponentResult, MerchantDanaDealsModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.BuiltInFictitiousFunctionClassFactory, MerchantAverageRatingModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.MyBillsEntityDataFactory, MerchantDetailConfigModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.getAuthRequestContext, MerchantDetailReviewModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2, ApplicationComponent.class);
        new DaggerMerchantDetailViewComponent.MerchantDetailViewComponentImpl(PlaceComponentResult.PlaceComponentResult, PlaceComponentResult.BuiltInFictitiousFunctionClassFactory, PlaceComponentResult.MyBillsEntityDataFactory, PlaceComponentResult.getAuthRequestContext, PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0).KClassImpl$Data$declaredNonStaticMembers$2(this);
        registerPresenter(getMerchantDetailConfigPresenter(), getPromoDealsPresenter(), getRatingPresenter(), getReviewPresenter());
    }

    @Override // id.dana.base.BaseRichView
    public final void injected(boolean isInjected) {
        if (isInjected) {
            getMerchantDetailConfigPresenter().PlaceComponentResult(true);
            getRatingPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
            getRatingPresenter().PlaceComponentResult();
        }
    }

    private final boolean PlaceComponentResult() {
        ShopModel shopModel = this.DatabaseTableConfigUtil;
        if (shopModel != null) {
            Intrinsics.checkNotNull(shopModel);
            List<MerchantImageModel> list = shopModel.NetworkUserEntityData$$ExternalSyntheticLambda4;
            if (list == null || list.isEmpty()) {
                MerchantDetailPhotoAdapter merchantDetailPhotoAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (merchantDetailPhotoAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    merchantDetailPhotoAdapter = null;
                }
                if (merchantDetailPhotoAdapter.getItems().get(0).PlaceComponentResult == MerchantBannerItemModel.State.LOADED) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean getAuthRequestContext(int p0) {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a110a_daggermerchantdetailreviewcomponent_merchantdetailreviewcomponentimpl_merchantinforepositoryprovider);
        RecyclerView.ViewHolder findViewHolderForLayoutPosition = recyclerView != null ? recyclerView.findViewHolderForLayoutPosition(p0) : null;
        return findViewHolderForLayoutPosition != null && ((findViewHolderForLayoutPosition.getBindingAdapter() instanceof MerchantUserReviewAdapter) || (findViewHolderForLayoutPosition.getBindingAdapter() instanceof MerchantReviewsInfoAdapter));
    }

    public final void MyBillsEntityDataFactory() {
        MerchantReviewsInfoAdapter merchantReviewsInfoAdapter = this.initRecordTimeStamp;
        MerchantReviewsInfoAdapter merchantReviewsInfoAdapter2 = null;
        if (merchantReviewsInfoAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantReviewsInfoAdapter = null;
        }
        Intrinsics.checkNotNullExpressionValue(merchantReviewsInfoAdapter.getItems(), "");
        if ((!r0.isEmpty()) == true && !this.MyBillsEntityDataFactory && getReviewPresenter().getGetAuthRequestContext() && KClassImpl$Data$declaredNonStaticMembers$2()) {
            MerchantReviewsInfoAdapter merchantReviewsInfoAdapter3 = this.initRecordTimeStamp;
            if (merchantReviewsInfoAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                merchantReviewsInfoAdapter2 = merchantReviewsInfoAdapter3;
            }
            merchantReviewsInfoAdapter2.MyBillsEntityDataFactory();
            BuiltInFictitiousFunctionClassFactory();
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        ShopModel shopModel = this.DatabaseTableConfigUtil;
        if (shopModel != null) {
            this.MyBillsEntityDataFactory = true;
            MerchantDetailReviewContract.Presenter reviewPresenter = getReviewPresenter();
            String str = shopModel.NetworkUserEntityData$$ExternalSyntheticLambda3;
            Intrinsics.checkNotNullExpressionValue(str, "");
            String str2 = shopModel.BottomSheetCardBindingView$watcherCardNumberView$1;
            Intrinsics.checkNotNullExpressionValue(str2, "");
            reviewPresenter.PlaceComponentResult(str, str2);
        }
    }

    private final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        MerchantReviewsInfoAdapter merchantReviewsInfoAdapter = this.initRecordTimeStamp;
        MerchantReviewsInfoAdapter merchantReviewsInfoAdapter2 = null;
        if (merchantReviewsInfoAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantReviewsInfoAdapter = null;
        }
        MerchantReviewsInfoAdapter merchantReviewsInfoAdapter3 = this.initRecordTimeStamp;
        if (merchantReviewsInfoAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            merchantReviewsInfoAdapter2 = merchantReviewsInfoAdapter3;
        }
        return merchantReviewsInfoAdapter.getItem(merchantReviewsInfoAdapter2.getPlaceComponentResult() - 1).MyBillsEntityDataFactory == 0;
    }

    public final void smoothScrollToTop() {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a110a_daggermerchantdetailreviewcomponent_merchantdetailreviewcomponentimpl_merchantinforepositoryprovider);
        if (recyclerView != null) {
            recyclerView.smoothScrollToPosition(0);
        }
    }

    public final void scrollToTop() {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a110a_daggermerchantdetailreviewcomponent_merchantdetailreviewcomponentimpl_merchantinforepositoryprovider);
        if (recyclerView != null) {
            recyclerView.scrollToPosition(0);
        }
    }

    public static /* synthetic */ void PlaceComponentResult$default(MerchantDetailView merchantDetailView, MerchantConsultReviewModel merchantConsultReviewModel, MerchantReviewModel merchantReviewModel, int i, Object obj) {
        if ((i & 2) != 0) {
            merchantReviewModel = null;
        }
        merchantDetailView.PlaceComponentResult(merchantConsultReviewModel, merchantReviewModel);
    }

    public final void PlaceComponentResult(MerchantConsultReviewModel p0, MerchantReviewModel p1) {
        FragmentManager supportFragmentManager;
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null || (supportFragmentManager = baseActivity.getSupportFragmentManager()) == null) {
            return;
        }
        MerchantReviewDialogFragment.Companion companion = MerchantReviewDialogFragment.KClassImpl$Data$declaredNonStaticMembers$2;
        MerchantReviewDialogFragment.Companion.PlaceComponentResult(supportFragmentManager, p0, p1, new Function2<String, String, Unit>() { // from class: id.dana.nearbyrevamp.merchantdetail.MerchantDetailView$openMerchantFormDialog$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
                invoke2(str, str2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str, String str2) {
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullParameter(str2, "");
                MerchantDetailView.this.PlaceComponentResult = str2;
                MerchantDetailView.access$removeUserCreatedReviewWorkerObserver(MerchantDetailView.this);
                MerchantDetailView.access$observeUserCreateReviewWorkManager(MerchantDetailView.this);
            }
        }, new Function1<MerchantReviewDialogDismissState, Unit>() { // from class: id.dana.nearbyrevamp.merchantdetail.MerchantDetailView$openMerchantFormDialog$1$2
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
                MerchantDetailView.access$handleOnReviewDialogDismiss(MerchantDetailView.this, merchantReviewDialogDismissState);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showCompleteShopDataWithPreviewFirst$default(MerchantDetailView merchantDetailView, ShopModel shopModel, String str, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = new Function0<Unit>() { // from class: id.dana.nearbyrevamp.merchantdetail.MerchantDetailView$showCompleteShopDataWithPreviewFirst$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        merchantDetailView.showCompleteShopDataWithPreviewFirst(shopModel, str, function0);
    }

    public final void showCompleteShopDataWithPreviewFirst(ShopModel shopModel, String source, Function0<Unit> onPreviewDataShown) {
        Intrinsics.checkNotNullParameter(shopModel, "");
        Intrinsics.checkNotNullParameter(source, "");
        Intrinsics.checkNotNullParameter(onPreviewDataShown, "");
        MerchantDetailPhotoAdapter merchantDetailPhotoAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (merchantDetailPhotoAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantDetailPhotoAdapter = null;
        }
        if (merchantDetailPhotoAdapter.PlaceComponentResult) {
            merchantDetailPhotoAdapter.PlaceComponentResult = false;
            merchantDetailPhotoAdapter.BuiltInFictitiousFunctionClassFactory = 0;
            merchantDetailPhotoAdapter.notifyItemChanged(0);
        }
        KClassImpl$Data$declaredNonStaticMembers$2(shopModel);
        onPreviewDataShown.invoke();
        loadCompleteMerchantDetailInfo(shopModel);
        PlaceComponentResult(source);
    }

    public final void showPreviewShopData(ShopModel shopModel, String source) {
        Intrinsics.checkNotNullParameter(shopModel, "");
        Intrinsics.checkNotNullParameter(source, "");
        MerchantDetailPhotoAdapter merchantDetailPhotoAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (merchantDetailPhotoAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantDetailPhotoAdapter = null;
        }
        if (!merchantDetailPhotoAdapter.PlaceComponentResult) {
            merchantDetailPhotoAdapter.PlaceComponentResult = true;
            merchantDetailPhotoAdapter.notifyItemChanged(0);
        }
        KClassImpl$Data$declaredNonStaticMembers$2(shopModel);
        PlaceComponentResult(source);
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(ShopModel p0) {
        this.DatabaseTableConfigUtil = p0;
        this.BuiltInFictitiousFunctionClassFactory = new Pair<>(p0.BottomSheetCardBindingView$watcherCardNumberView$1, Boolean.FALSE);
        showErrorState(false);
        MerchantHeaderInfoAdapter merchantHeaderInfoAdapter = this.getErrorConfigVersion;
        MerchantReviewsInfoAdapter merchantReviewsInfoAdapter = null;
        if (merchantHeaderInfoAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantHeaderInfoAdapter = null;
        }
        Intrinsics.checkNotNullParameter(p0, "");
        List<MerchantDetailInfoModel> items = merchantHeaderInfoAdapter.getItems();
        MerchantDetailInfoModel.Companion companion = MerchantDetailInfoModel.INSTANCE;
        items.set(0, MerchantDetailInfoModel.Companion.getAuthRequestContext(p0));
        merchantHeaderInfoAdapter.notifyItemChanged(0);
        MerchantActionInfoAdapter merchantActionInfoAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (merchantActionInfoAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantActionInfoAdapter = null;
        }
        Intrinsics.checkNotNullParameter(p0, "");
        merchantActionInfoAdapter.getItems().get(0).BuiltInFictitiousFunctionClassFactory = p0;
        merchantActionInfoAdapter.notifyItemChanged(0);
        MerchantContactInfoAdapter merchantContactInfoAdapter = this.moveToNextValue;
        if (merchantContactInfoAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantContactInfoAdapter = null;
        }
        Intrinsics.checkNotNullParameter(p0, "");
        MerchantDetailInfoModel.Companion companion2 = MerchantDetailInfoModel.INSTANCE;
        merchantContactInfoAdapter.setItems(CollectionsKt.mutableListOf(MerchantDetailInfoModel.Companion.getAuthRequestContext(p0)));
        MerchantUserReviewAdapter merchantUserReviewAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (merchantUserReviewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantUserReviewAdapter = null;
        }
        Intrinsics.checkNotNullParameter(p0, "");
        merchantUserReviewAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
        MerchantReviewsInfoAdapter merchantReviewsInfoAdapter2 = this.initRecordTimeStamp;
        if (merchantReviewsInfoAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            merchantReviewsInfoAdapter = merchantReviewsInfoAdapter2;
        }
        Intrinsics.checkNotNullParameter(p0, "");
        merchantReviewsInfoAdapter.PlaceComponentResult = p0;
    }

    public final void updateImages(ShopModel shopModel) {
        Intrinsics.checkNotNullParameter(shopModel, "");
        MerchantDetailPhotoAdapter merchantDetailPhotoAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (merchantDetailPhotoAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantDetailPhotoAdapter = null;
        }
        Intrinsics.checkNotNullParameter(shopModel, "");
        merchantDetailPhotoAdapter.getAuthRequestContext = shopModel;
        MerchantBannerItemModel merchantBannerItemModel = merchantDetailPhotoAdapter.getItems().get(0);
        MerchantBannerItemModel.State state = MerchantBannerItemModel.State.LOADED;
        Intrinsics.checkNotNullParameter(state, "");
        merchantBannerItemModel.PlaceComponentResult = state;
        merchantDetailPhotoAdapter.notifyItemChanged(0);
        MerchantDetailViewListener merchantDetailViewListener = this.merchantDetailViewListener;
        if (merchantDetailViewListener != null) {
            merchantDetailViewListener.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    public final void loadCompleteMerchantDetailInfo(ShopModel shopModel) {
        Intrinsics.checkNotNullParameter(shopModel, "");
        showComponentWhenFullState(true);
        if (Intrinsics.areEqual(this.DatabaseTableConfigUtil, shopModel) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory.getFirst(), shopModel.BottomSheetCardBindingView$watcherCardNumberView$1) && !this.BuiltInFictitiousFunctionClassFactory.getSecond().booleanValue()) {
            this.BuiltInFictitiousFunctionClassFactory = Pair.copy$default(this.BuiltInFictitiousFunctionClassFactory, null, Boolean.TRUE, 1, null);
            getMerchantDetailConfigPresenter().BuiltInFictitiousFunctionClassFactory();
            getAuthRequestContext();
            BuiltInFictitiousFunctionClassFactory();
        }
    }

    private final void getAuthRequestContext() {
        ShopModel shopModel = this.DatabaseTableConfigUtil;
        if (shopModel != null) {
            MerchantAverageRatingContract.Presenter ratingPresenter = getRatingPresenter();
            String str = shopModel.NetworkUserEntityData$$ExternalSyntheticLambda3;
            Intrinsics.checkNotNullExpressionValue(str, "");
            String str2 = shopModel.BottomSheetCardBindingView$watcherCardNumberView$1;
            Intrinsics.checkNotNullExpressionValue(str2, "");
            ratingPresenter.getAuthRequestContext(str, str2);
        }
    }

    public final int getHeaderInfoViewBottom() {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a110a_daggermerchantdetailreviewcomponent_merchantdetailreviewcomponentimpl_merchantinforepositoryprovider);
        RecyclerView.ViewHolder findViewHolderForLayoutPosition = recyclerView != null ? recyclerView.findViewHolderForLayoutPosition(1) : null;
        if (findViewHolderForLayoutPosition != null && (findViewHolderForLayoutPosition instanceof MerchantHeaderInfoAdapter.MerchantDetailSeeMoreViewHolder)) {
            ConstraintLayout constraintLayout = (ConstraintLayout) ((MerchantHeaderInfoAdapter.MerchantDetailSeeMoreViewHolder) findViewHolderForLayoutPosition).itemView.findViewById(R.id.roundToPowerOfTwo);
            if (constraintLayout != null) {
                return constraintLayout.getBottom();
            }
            return 0;
        }
        ConstraintLayout constraintLayout2 = (ConstraintLayout) _$_findCachedViewById(R.id.roundToPowerOfTwo);
        if (constraintLayout2 != null) {
            return constraintLayout2.getBottom();
        }
        return 0;
    }

    public final void setTryAgainListener(final Function0<Unit> onTryAgainClicked) {
        Intrinsics.checkNotNullParameter(onTryAgainClicked, "");
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.QrExpiredActivity);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyrevamp.merchantdetail.MerchantDetailView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MerchantDetailView.$r8$lambda$uE8pPJxRPZ2SZ0Zo9uUWSU0rPds(MerchantDetailView.this, onTryAgainClicked, view);
                }
            });
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.nearbyrevamp.model.MerchantBannerItemModel$State, kotlin.jvm.internal.DefaultConstructorMarker] */
    public final void onMerchantDetailReset() {
        ?? r0 = 0;
        this.DatabaseTableConfigUtil = null;
        this.BuiltInFictitiousFunctionClassFactory = new Pair<>("", Boolean.FALSE);
        getRatingPresenter().BuiltInFictitiousFunctionClassFactory();
        getReviewPresenter().BuiltInFictitiousFunctionClassFactory();
        getPromoDealsPresenter().getAuthRequestContext();
        MerchantDetailPhotoAdapter merchantDetailPhotoAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (merchantDetailPhotoAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantDetailPhotoAdapter = null;
        }
        merchantDetailPhotoAdapter.getAuthRequestContext = new ShopModel();
        merchantDetailPhotoAdapter.BuiltInFictitiousFunctionClassFactory = 0;
        int i = 1;
        if (!merchantDetailPhotoAdapter.PlaceComponentResult) {
            merchantDetailPhotoAdapter.PlaceComponentResult = true;
            merchantDetailPhotoAdapter.notifyItemChanged(0);
        }
        merchantDetailPhotoAdapter.setItems(CollectionsKt.mutableListOf(new MerchantBannerItemModel(r0, i, r0)));
        merchantDetailPhotoAdapter.notifyItemChanged(0);
        MerchantHeaderInfoAdapter merchantHeaderInfoAdapter = this.getErrorConfigVersion;
        if (merchantHeaderInfoAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantHeaderInfoAdapter = null;
        }
        merchantHeaderInfoAdapter.BuiltInFictitiousFunctionClassFactory();
        MerchantPromoDealsInfoAdapter merchantPromoDealsInfoAdapter = this.scheduleImpl;
        if (merchantPromoDealsInfoAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantPromoDealsInfoAdapter = null;
        }
        MerchantPromoDealsViewHolderModel.Companion companion = MerchantPromoDealsViewHolderModel.INSTANCE;
        merchantPromoDealsInfoAdapter.setItems(CollectionsKt.mutableListOf(MerchantPromoDealsViewHolderModel.Companion.KClassImpl$Data$declaredNonStaticMembers$2()));
        MerchantContactInfoAdapter merchantContactInfoAdapter = this.moveToNextValue;
        if (merchantContactInfoAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantContactInfoAdapter = null;
        }
        merchantContactInfoAdapter.MyBillsEntityDataFactory();
        MerchantUserReviewAdapter merchantUserReviewAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (merchantUserReviewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantUserReviewAdapter = null;
        }
        merchantUserReviewAdapter.getAuthRequestContext();
        MerchantReviewsInfoAdapter merchantReviewsInfoAdapter = this.initRecordTimeStamp;
        if (merchantReviewsInfoAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantReviewsInfoAdapter = null;
        }
        merchantReviewsInfoAdapter.BuiltInFictitiousFunctionClassFactory();
        showComponentWhenFullState(false);
        LiveData<List<WorkInfo>> liveData = this.isLayoutRequested;
        if (liveData != null) {
            liveData.BuiltInFictitiousFunctionClassFactory((Observer) this.NetworkUserEntityData$$ExternalSyntheticLambda8.getValue());
        }
        this.isLayoutRequested = null;
    }

    public final void showErrorState(boolean r5) {
        this.merchantDetailState = r5 ? MerchantDetailState.ERROR : MerchantDetailState.DEFAULT;
        View _$_findCachedViewById = _$_findCachedViewById(R.id.FamilyDashboardPresenter_Factory_res_0x7f0a0376);
        if (_$_findCachedViewById != null) {
            _$_findCachedViewById.setVisibility(r5 ? 0 : 8);
        }
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a110a_daggermerchantdetailreviewcomponent_merchantdetailreviewcomponentimpl_merchantinforepositoryprovider);
        if (recyclerView != null) {
            recyclerView.setVisibility(r5 ^ true ? 0 : 8);
        }
    }

    public final void trackDisplayedErrorMessage(Throwable throwable, String operationType) {
        TextView textView;
        CharSequence text;
        Intrinsics.checkNotNullParameter(operationType, "");
        if (throwable == null) {
            return;
        }
        Context context = getContext();
        View _$_findCachedViewById = _$_findCachedViewById(R.id.FamilyDashboardPresenter_Factory_res_0x7f0a0376);
        String obj = (_$_findCachedViewById == null || (textView = (TextView) _$_findCachedViewById.findViewById(R.id.tv_error_message_nearby_detail)) == null || (text = textView.getText()) == null) ? null : text.toString();
        String str = obj != null ? obj : "";
        DisplayedErrorModel.Companion companion = DisplayedErrorModel.INSTANCE;
        MixPanelTracker.getAuthRequestContext(context, str, NEARBY_DETAIL_PAGE_SOURCE, DisplayedErrorModel.Companion.BuiltInFictitiousFunctionClassFactory(throwable, operationType));
    }

    public final void showComponentWhenFullState(boolean fullState) {
        MerchantHeaderInfoAdapter merchantHeaderInfoAdapter = this.getErrorConfigVersion;
        MerchantHeaderInfoAdapter merchantHeaderInfoAdapter2 = null;
        if (merchantHeaderInfoAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantHeaderInfoAdapter = null;
        }
        merchantHeaderInfoAdapter.MyBillsEntityDataFactory = !fullState;
        merchantHeaderInfoAdapter.notifyItemChanged(1);
        MerchantHeaderInfoAdapter merchantHeaderInfoAdapter3 = this.getErrorConfigVersion;
        if (merchantHeaderInfoAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            merchantHeaderInfoAdapter2 = merchantHeaderInfoAdapter3;
        }
        merchantHeaderInfoAdapter2.KClassImpl$Data$declaredNonStaticMembers$2 = fullState;
        merchantHeaderInfoAdapter2.notifyItemChanged(0);
    }

    public final void setOnCollapsed() {
        MerchantDetailPhotoAdapter merchantDetailPhotoAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (merchantDetailPhotoAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantDetailPhotoAdapter = null;
        }
        if (!merchantDetailPhotoAdapter.PlaceComponentResult) {
            merchantDetailPhotoAdapter.PlaceComponentResult = true;
            merchantDetailPhotoAdapter.notifyItemChanged(0);
        }
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a110a_daggermerchantdetailreviewcomponent_merchantdetailreviewcomponentimpl_merchantinforepositoryprovider);
        if (recyclerView != null) {
            recyclerView.smoothScrollToPosition(0);
        }
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a110a_daggermerchantdetailreviewcomponent_merchantdetailreviewcomponentimpl_merchantinforepositoryprovider);
        if (recyclerView2 != null) {
            recyclerView2.setNestedScrollingEnabled(false);
        }
    }

    public final void setOnFull() {
        MerchantDetailPhotoAdapter merchantDetailPhotoAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (merchantDetailPhotoAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantDetailPhotoAdapter = null;
        }
        if (merchantDetailPhotoAdapter.PlaceComponentResult) {
            merchantDetailPhotoAdapter.PlaceComponentResult = false;
            merchantDetailPhotoAdapter.BuiltInFictitiousFunctionClassFactory = 0;
            merchantDetailPhotoAdapter.notifyItemChanged(0);
        }
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a110a_daggermerchantdetailreviewcomponent_merchantdetailreviewcomponentimpl_merchantinforepositoryprovider);
        if (recyclerView != null) {
            recyclerView.setNestedScrollingEnabled(true);
        }
    }

    public final void setOnBottomsheetDragged(float slideOffset) {
        View view;
        MerchantBannerView merchantBannerView;
        ConstraintLayout constraintLayout;
        View view2;
        MerchantPhotoGridView merchantPhotoGridView;
        ConstraintLayout constraintLayout2;
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a110a_daggermerchantdetailreviewcomponent_merchantdetailreviewcomponentimpl_merchantinforepositoryprovider);
        if (recyclerView != null) {
            RecyclerView.ViewHolder findViewHolderForLayoutPosition = recyclerView.findViewHolderForLayoutPosition(0);
            if (findViewHolderForLayoutPosition != null && (view2 = findViewHolderForLayoutPosition.itemView) != null && (merchantPhotoGridView = (MerchantPhotoGridView) view2.findViewById(R.id.mpgMerchantPhotoGrid)) != null && (constraintLayout2 = (ConstraintLayout) merchantPhotoGridView._$_findCachedViewById(R.id.allowedTargets)) != null) {
                Intrinsics.checkNotNullExpressionValue(constraintLayout2, "");
                if (!PlaceComponentResult()) {
                    constraintLayout2.setVisibility(0);
                    constraintLayout2.setAlpha(1.0f - slideOffset);
                }
            }
            if (findViewHolderForLayoutPosition == null || (view = findViewHolderForLayoutPosition.itemView) == null || (merchantBannerView = (MerchantBannerView) view.findViewById(R.id.tryNextTokenChar)) == null || (constraintLayout = (ConstraintLayout) merchantBannerView._$_findCachedViewById(R.id.allowedTargets)) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
            if (slideOffset < 0.1d) {
                constraintLayout.setVisibility(8);
                constraintLayout.setAlpha(1.0f);
                return;
            }
            constraintLayout.setVisibility(0);
            constraintLayout.setAlpha(slideOffset);
        }
    }

    @Override // id.dana.base.BaseRichView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LiveData<List<WorkInfo>> liveData = this.isLayoutRequested;
        if (liveData != null) {
            liveData.BuiltInFictitiousFunctionClassFactory((Observer) this.NetworkUserEntityData$$ExternalSyntheticLambda8.getValue());
        }
        this.isLayoutRequested = null;
    }

    public static /* synthetic */ void $r8$lambda$KLcZiOMEbOMdrDJ8RpKUHGyvH_4(MerchantDetailView merchantDetailView, int i) {
        Intrinsics.checkNotNullParameter(merchantDetailView, "");
        merchantDetailView.getBaseActivity().startActivity(new Intent(merchantDetailView.getBaseActivity(), ScannerActivity.class));
    }

    /* renamed from: $r8$lambda$aw1-Wt5RfOuUjAxFLbI4Bu0O-Ac */
    public static /* synthetic */ void m2747$r8$lambda$aw1Wt5RfOuUjAxFLbI4Bu0OAc(MerchantDetailView merchantDetailView, List list) {
        Intrinsics.checkNotNullParameter(merchantDetailView, "");
        if (list != null) {
            try {
                WorkInfo workInfo = (WorkInfo) CollectionsKt.firstOrNull(list);
                if (workInfo != null) {
                    Set<String> set = workInfo.PlaceComponentResult;
                    StringBuilder sb = new StringBuilder();
                    sb.append("merchantReviewWorkId_");
                    sb.append(merchantDetailView.PlaceComponentResult);
                    if (set.contains(sb.toString()) && workInfo.KClassImpl$Data$declaredNonStaticMembers$2.isFinished()) {
                        merchantDetailView.getAuthRequestContext();
                        LiveData<List<WorkInfo>> liveData = merchantDetailView.isLayoutRequested;
                        if (liveData != null) {
                            liveData.BuiltInFictitiousFunctionClassFactory((Observer) merchantDetailView.NetworkUserEntityData$$ExternalSyntheticLambda8.getValue());
                        }
                        merchantDetailView.isLayoutRequested = null;
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static /* synthetic */ void $r8$lambda$raZqINnQ5qYb_KZLsWUNEao0XUI(MerchantDetailView merchantDetailView, View view) {
        Intrinsics.checkNotNullParameter(merchantDetailView, "");
        merchantDetailView.smoothScrollToTop();
        MerchantDetailViewListener merchantDetailViewListener = merchantDetailView.merchantDetailViewListener;
        if (merchantDetailViewListener != null) {
            merchantDetailViewListener.BuiltInFictitiousFunctionClassFactory();
        }
    }

    public static /* synthetic */ void $r8$lambda$uE8pPJxRPZ2SZ0Zo9uUWSU0rPds(MerchantDetailView merchantDetailView, Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(merchantDetailView, "");
        Intrinsics.checkNotNullParameter(function0, "");
        merchantDetailView.smoothScrollToTop();
        merchantDetailView.showErrorState(false);
        function0.invoke();
    }

    public static final /* synthetic */ void access$checkIsMerchantPhotoShown(MerchantDetailView merchantDetailView, RecyclerView.ViewHolder viewHolder) {
        if (viewHolder != null && (viewHolder instanceof MerchantDetailPhotoAdapter.MerchantCarouselPhotoViewHolder)) {
            MerchantDetailViewListener merchantDetailViewListener = merchantDetailView.merchantDetailViewListener;
            if (merchantDetailViewListener != null) {
                merchantDetailViewListener.BuiltInFictitiousFunctionClassFactory(false);
                return;
            }
            return;
        }
        if (merchantDetailView.PlaceComponentResult()) {
            MerchantDetailPhotoAdapter merchantDetailPhotoAdapter = merchantDetailView.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (merchantDetailPhotoAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                merchantDetailPhotoAdapter = null;
            }
            if (merchantDetailPhotoAdapter.getPlaceComponentResult()) {
                MerchantDetailViewListener merchantDetailViewListener2 = merchantDetailView.merchantDetailViewListener;
                if (merchantDetailViewListener2 != null) {
                    merchantDetailViewListener2.BuiltInFictitiousFunctionClassFactory(false);
                    return;
                }
                return;
            }
        }
        MerchantDetailViewListener merchantDetailViewListener3 = merchantDetailView.merchantDetailViewListener;
        if (merchantDetailViewListener3 != null) {
            merchantDetailViewListener3.BuiltInFictitiousFunctionClassFactory(true);
        }
    }

    public static final /* synthetic */ void access$doOnMerchantDetailInteractionImplemented(MerchantDetailView merchantDetailView, Function1 function1) {
        for (Context context = merchantDetailView.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof MerchantDetailInteraction) {
                function1.invoke(context);
            }
        }
        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.ExceptionType.NEARBY_EXCEPTION, "Parent must implement MerchantDetailInteraction");
    }

    public static final /* synthetic */ Observer access$getReviewWorkManagerObserver(final MerchantDetailView merchantDetailView) {
        return new Observer() { // from class: id.dana.nearbyrevamp.merchantdetail.MerchantDetailView$$ExternalSyntheticLambda2
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                MerchantDetailView.m2747$r8$lambda$aw1Wt5RfOuUjAxFLbI4Bu0OAc(MerchantDetailView.this, (List) obj);
            }
        };
    }

    public static final /* synthetic */ void access$handleOnReviewDialogDismiss(MerchantDetailView merchantDetailView, MerchantReviewDialogDismissState merchantReviewDialogDismissState) {
        int i = WhenMappings.BuiltInFictitiousFunctionClassFactory[merchantReviewDialogDismissState.ordinal()];
        MerchantUserReviewAdapter merchantUserReviewAdapter = null;
        if (i != 1) {
            if (i == 2) {
                MerchantUserReviewAdapter merchantUserReviewAdapter2 = merchantDetailView.NetworkUserEntityData$$ExternalSyntheticLambda2;
                if (merchantUserReviewAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    merchantUserReviewAdapter = merchantUserReviewAdapter2;
                }
                merchantUserReviewAdapter.getAuthRequestContext();
                return;
            }
            return;
        }
        ViewRatingStarBar viewRatingStarBar = (ViewRatingStarBar) merchantDetailView._$_findCachedViewById(R.id.parsePerformanceSetDataSize);
        if (viewRatingStarBar != null) {
            viewRatingStarBar.setStarSelected(0);
        }
        LiveData<List<WorkInfo>> liveData = merchantDetailView.isLayoutRequested;
        if (liveData != null) {
            liveData.BuiltInFictitiousFunctionClassFactory((Observer) merchantDetailView.NetworkUserEntityData$$ExternalSyntheticLambda8.getValue());
        }
        merchantDetailView.isLayoutRequested = null;
    }

    public static final /* synthetic */ void access$observeUserCreateReviewWorkManager(MerchantDetailView merchantDetailView) {
        if (merchantDetailView.getBaseActivity() != null) {
            if (merchantDetailView.isLayoutRequested == null) {
                CreateReviewWorker.Companion companion = CreateReviewWorker.INSTANCE;
                Context applicationContext = merchantDetailView.getBaseActivity().getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "");
                merchantDetailView.isLayoutRequested = CreateReviewWorker.Companion.BuiltInFictitiousFunctionClassFactory(applicationContext, merchantDetailView.PlaceComponentResult);
            }
            LiveData<List<WorkInfo>> liveData = merchantDetailView.isLayoutRequested;
            if (liveData != null) {
                liveData.PlaceComponentResult(merchantDetailView.getBaseActivity(), (Observer) merchantDetailView.NetworkUserEntityData$$ExternalSyntheticLambda8.getValue());
            }
        }
    }

    public static final /* synthetic */ void access$onLoadMoreReviewClicked(MerchantDetailView merchantDetailView) {
        MerchantReviewsInfoAdapter merchantReviewsInfoAdapter = merchantDetailView.initRecordTimeStamp;
        if (merchantReviewsInfoAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantReviewsInfoAdapter = null;
        }
        List<MerchantReviewViewModel> items = merchantReviewsInfoAdapter.getItems();
        if (!(items == null || items.isEmpty())) {
            List<MerchantReviewViewModel> items2 = merchantReviewsInfoAdapter.getItems();
            Intrinsics.checkNotNullExpressionValue(items2, "");
            if (((MerchantReviewViewModel) CollectionsKt.last((List) items2)).MyBillsEntityDataFactory == 3) {
                List<MerchantReviewViewModel> items3 = merchantReviewsInfoAdapter.getItems();
                Intrinsics.checkNotNullExpressionValue(items3, "");
                merchantReviewsInfoAdapter.removeItem(CollectionsKt.getLastIndex(items3));
            }
        }
        merchantDetailView.MyBillsEntityDataFactory();
    }

    public static final /* synthetic */ void access$removeUserCreatedReviewWorkerObserver(MerchantDetailView merchantDetailView) {
        LiveData<List<WorkInfo>> liveData = merchantDetailView.isLayoutRequested;
        if (liveData != null) {
            liveData.BuiltInFictitiousFunctionClassFactory((Observer) merchantDetailView.NetworkUserEntityData$$ExternalSyntheticLambda8.getValue());
        }
        merchantDetailView.isLayoutRequested = null;
    }

    public static final /* synthetic */ void access$setCvBackToTopVisibility(MerchantDetailView merchantDetailView, boolean z) {
        Transition addTarget = new Slide((byte) 0).setDuration(600L).addTarget((CardView) merchantDetailView._$_findCachedViewById(R.id.ViewPayConfirmationAddOnBinding_res_0x7f0a0572));
        Intrinsics.checkNotNullExpressionValue(addTarget, "");
        TransitionManager.getAuthRequestContext(merchantDetailView, addTarget);
        CardView cardView = (CardView) merchantDetailView._$_findCachedViewById(R.id.ViewPayConfirmationAddOnBinding_res_0x7f0a0572);
        if (cardView != null) {
            cardView.setVisibility(z ? 0 : 8);
        }
    }

    public static final /* synthetic */ void access$setRatingStateOnError(MerchantDetailView merchantDetailView) {
        ShopModel shopModel = merchantDetailView.DatabaseTableConfigUtil;
        if (shopModel != null) {
            MerchantUserReviewAdapter merchantUserReviewAdapter = null;
            if (!NearbyExtensionKt.KClassImpl$Data$declaredNonStaticMembers$2(shopModel)) {
                MerchantUserReviewAdapter merchantUserReviewAdapter2 = merchantDetailView.NetworkUserEntityData$$ExternalSyntheticLambda2;
                if (merchantUserReviewAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    merchantUserReviewAdapter = merchantUserReviewAdapter2;
                }
                ArrayList arrayList = new ArrayList();
                RatingViewHolderModel.Companion companion = RatingViewHolderModel.INSTANCE;
                arrayList.add(RatingViewHolderModel.Companion.BuiltInFictitiousFunctionClassFactory());
                merchantUserReviewAdapter.setItems(arrayList);
                return;
            }
            MerchantUserReviewAdapter merchantUserReviewAdapter3 = merchantDetailView.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (merchantUserReviewAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                merchantUserReviewAdapter = merchantUserReviewAdapter3;
            }
            Intrinsics.checkNotNullParameter(shopModel, "");
            merchantUserReviewAdapter.setItems(merchantUserReviewAdapter.KClassImpl$Data$declaredNonStaticMembers$2(shopModel));
        }
    }

    public static final /* synthetic */ void access$updatePromoAndDealsInfo(MerchantDetailView merchantDetailView, List list, List list2) {
        Unit unit;
        Unit unit2;
        ShopModel shopModel = merchantDetailView.DatabaseTableConfigUtil;
        if (shopModel != null) {
            MerchantDetailPromoConfigModel kClassImpl$Data$declaredNonStaticMembers$2 = merchantDetailView.getMerchantDetailConfigPresenter().getKClassImpl$Data$declaredNonStaticMembers$2();
            MerchantPromoDealsInfoAdapter merchantPromoDealsInfoAdapter = null;
            if (kClassImpl$Data$declaredNonStaticMembers$2 != null) {
                if (kClassImpl$Data$declaredNonStaticMembers$2.getDealsSectionEnable()) {
                    List list3 = list;
                    if ((list3.isEmpty() ^ true ? list : null) != null) {
                        int dealsLimit = kClassImpl$Data$declaredNonStaticMembers$2.getDealsLimit();
                        NearbySpecialDealsItemWrapper.Companion companion = NearbySpecialDealsItemWrapper.INSTANCE;
                        List mutableListOf = CollectionsKt.mutableListOf(NearbySpecialDealsItemWrapper.Companion.PlaceComponentResult());
                        List list4 = mutableListOf;
                        List<MerchantProductInfoModel> list5 = list;
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list5, 10));
                        for (MerchantProductInfoModel merchantProductInfoModel : list5) {
                            NearbySpecialDealsItemWrapper.Companion companion2 = NearbySpecialDealsItemWrapper.INSTANCE;
                            arrayList.add(NearbySpecialDealsItemWrapper.Companion.BuiltInFictitiousFunctionClassFactory(merchantProductInfoModel));
                        }
                        CollectionsKt.addAll(list4, CollectionsKt.take(arrayList, dealsLimit));
                        if (list3.size() > dealsLimit) {
                            NearbySpecialDealsItemWrapper.Companion companion3 = NearbySpecialDealsItemWrapper.INSTANCE;
                            list4.add(NearbySpecialDealsItemWrapper.Companion.BuiltInFictitiousFunctionClassFactory());
                        }
                        MerchantSpecialDealsSectionAdapter merchantSpecialDealsSectionAdapter = merchantDetailView.GetContactSyncConfig;
                        if (merchantSpecialDealsSectionAdapter == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            merchantSpecialDealsSectionAdapter = null;
                        }
                        merchantSpecialDealsSectionAdapter.setItems(CollectionsKt.listOf(new NearbyDealsSectionModel(NearbyDealsSectionModel.SectionState.ACTIVE, mutableListOf)));
                        unit2 = Unit.INSTANCE;
                    } else {
                        unit2 = null;
                    }
                    if (unit2 == null) {
                        MerchantSpecialDealsSectionAdapter merchantSpecialDealsSectionAdapter2 = merchantDetailView.GetContactSyncConfig;
                        if (merchantSpecialDealsSectionAdapter2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                            merchantSpecialDealsSectionAdapter2 = null;
                        }
                        merchantSpecialDealsSectionAdapter2.setItems(CollectionsKt.emptyList());
                    }
                    MerchantPromoDealsInfoAdapter merchantPromoDealsInfoAdapter2 = merchantDetailView.scheduleImpl;
                    if (merchantPromoDealsInfoAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        merchantPromoDealsInfoAdapter2 = null;
                    }
                    merchantPromoDealsInfoAdapter2.MyBillsEntityDataFactory(list2, CollectionsKt.emptyList(), shopModel);
                } else {
                    MerchantSpecialDealsSectionAdapter merchantSpecialDealsSectionAdapter3 = merchantDetailView.GetContactSyncConfig;
                    if (merchantSpecialDealsSectionAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        merchantSpecialDealsSectionAdapter3 = null;
                    }
                    merchantSpecialDealsSectionAdapter3.setItems(CollectionsKt.emptyList());
                    MerchantPromoDealsInfoAdapter merchantPromoDealsInfoAdapter3 = merchantDetailView.scheduleImpl;
                    if (merchantPromoDealsInfoAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        merchantPromoDealsInfoAdapter3 = null;
                    }
                    merchantPromoDealsInfoAdapter3.MyBillsEntityDataFactory(list2, list, shopModel);
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                MerchantSpecialDealsSectionAdapter merchantSpecialDealsSectionAdapter4 = merchantDetailView.GetContactSyncConfig;
                if (merchantSpecialDealsSectionAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    merchantSpecialDealsSectionAdapter4 = null;
                }
                merchantSpecialDealsSectionAdapter4.setItems(CollectionsKt.emptyList());
                MerchantPromoDealsInfoAdapter merchantPromoDealsInfoAdapter4 = merchantDetailView.scheduleImpl;
                if (merchantPromoDealsInfoAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    merchantPromoDealsInfoAdapter = merchantPromoDealsInfoAdapter4;
                }
                merchantPromoDealsInfoAdapter.MyBillsEntityDataFactory(list2, list, shopModel);
            }
        }
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        MerchantHeaderInfoAdapter merchantHeaderInfoAdapter = new MerchantHeaderInfoAdapter(Utils.getAuthRequestContext(getContext()));
        merchantHeaderInfoAdapter.getAuthRequestContext = this.merchantDetailViewListener;
        this.getErrorConfigVersion = merchantHeaderInfoAdapter;
        MerchantDetailPhotoAdapter merchantDetailPhotoAdapter = new MerchantDetailPhotoAdapter();
        merchantDetailPhotoAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = new MerchantDetailPhotoAdapter.Listener() { // from class: id.dana.nearbyrevamp.merchantdetail.MerchantDetailView$getMerchantDetailPhotoAdapter$1$1
            @Override // id.dana.nearbyrevamp.merchantdetail.adapter.MerchantDetailPhotoAdapter.Listener
            public final void BuiltInFictitiousFunctionClassFactory() {
                MerchantDetailView.MerchantDetailViewListener merchantDetailViewListener = MerchantDetailView.this.getMerchantDetailViewListener();
                if (merchantDetailViewListener != null) {
                    merchantDetailViewListener.MyBillsEntityDataFactory();
                }
            }
        };
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = merchantDetailPhotoAdapter;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new MerchantActionInfoAdapter();
        this.moveToNextValue = new MerchantContactInfoAdapter();
        this.GetContactSyncConfig = new MerchantSpecialDealsSectionAdapter(new Function1<MerchantProductInfoModel, Unit>() { // from class: id.dana.nearbyrevamp.merchantdetail.MerchantDetailView$setupSpecialDealsAdapter$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(MerchantProductInfoModel merchantProductInfoModel) {
                invoke2(merchantProductInfoModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(MerchantProductInfoModel merchantProductInfoModel) {
                Intrinsics.checkNotNullParameter(merchantProductInfoModel, "");
                StringBuilder sb = new StringBuilder();
                sb.append("goodsId=");
                sb.append(merchantProductInfoModel.KClassImpl$Data$declaredNonStaticMembers$2);
                sb.append("&voucherV2=true");
                String PlaceComponentResult = UrlUtil.PlaceComponentResult(DanaUrl.DANA_DEALS_DETAIL, sb.toString());
                Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
                DanaH5.startContainerFullUrl(PlaceComponentResult);
            }
        }, new Function0<Unit>() { // from class: id.dana.nearbyrevamp.merchantdetail.MerchantDetailView$setupSpecialDealsAdapter$2
            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                DanaH5.startContainerFullUrl(DanaUrl.VOUCHER_LIST);
            }
        });
        this.scheduleImpl = new MerchantPromoDealsInfoAdapter();
        MerchantUserReviewAdapter merchantUserReviewAdapter = new MerchantUserReviewAdapter();
        merchantUserReviewAdapter.BuiltInFictitiousFunctionClassFactory = new MerchantUserReviewAdapter.RatingSectionListener() { // from class: id.dana.nearbyrevamp.merchantdetail.MerchantDetailView$getMerchantUserReviewAdapter$1$1
            @Override // id.dana.nearbyrevamp.merchantdetail.adapter.MerchantUserReviewAdapter.RatingSectionListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(int p0, MerchantConsultReviewModel p1) {
                Intrinsics.checkNotNullParameter(p1, "");
                MerchantDetailView merchantDetailView = MerchantDetailView.this;
                p1.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
                Intrinsics.checkNotNullParameter(TrackerKey.SourceType.MERCHANT_DETAIL, "");
                p1.scheduleImpl = TrackerKey.SourceType.MERCHANT_DETAIL;
                MerchantDetailView.PlaceComponentResult$default(merchantDetailView, p1, null, 2, null);
            }

            @Override // id.dana.nearbyrevamp.merchantdetail.adapter.MerchantUserReviewAdapter.RatingSectionListener
            public final void getAuthRequestContext() {
                MerchantUserReviewAdapter merchantUserReviewAdapter2;
                MerchantDetailView.this.getRatingPresenter().MyBillsEntityDataFactory();
                merchantUserReviewAdapter2 = MerchantDetailView.this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                if (merchantUserReviewAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    merchantUserReviewAdapter2 = null;
                }
                Intrinsics.checkNotNullExpressionValue(merchantUserReviewAdapter2.getItems(), "");
                if ((!r2.isEmpty()) == true) {
                    List<RatingViewHolderModel> items = merchantUserReviewAdapter2.getItems();
                    Intrinsics.checkNotNullExpressionValue(items, "");
                    Iterator<RatingViewHolderModel> it = items.iterator();
                    int i = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i = -1;
                            break;
                        }
                        if (it.next().MyBillsEntityDataFactory == 3) {
                            break;
                        }
                        i++;
                    }
                    if (i != -1) {
                        merchantUserReviewAdapter2.removeItem(i);
                        merchantUserReviewAdapter2.PlaceComponentResult = false;
                    }
                }
            }

            @Override // id.dana.nearbyrevamp.merchantdetail.adapter.MerchantUserReviewAdapter.RatingSectionListener
            public final void getAuthRequestContext(MerchantReviewModel p0) {
                MerchantConsultReviewModel merchantConsultReviewModel;
                Intrinsics.checkNotNullParameter(p0, "");
                merchantConsultReviewModel = MerchantDetailView.this.lookAheadTest;
                if (merchantConsultReviewModel != null) {
                    MerchantDetailView merchantDetailView = MerchantDetailView.this;
                    merchantConsultReviewModel.KClassImpl$Data$declaredNonStaticMembers$2 = p0.initRecordTimeStamp;
                    merchantConsultReviewModel.MyBillsEntityDataFactory.VerifyPinStateManager$executeRiskChallenge$2$2 = Long.valueOf(p0.moveToNextValue);
                    merchantDetailView.PlaceComponentResult(merchantConsultReviewModel, p0);
                }
            }
        };
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = merchantUserReviewAdapter;
        this.initRecordTimeStamp = new MerchantReviewsInfoAdapter(new MerchantDetailView$setupAdapter$1(this));
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new MerchantQrisInfoAdapter(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.nearbyrevamp.merchantdetail.MerchantDetailView$$ExternalSyntheticLambda3
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                MerchantDetailView.$r8$lambda$KLcZiOMEbOMdrDJ8RpKUHGyvH_4(MerchantDetailView.this, i);
            }
        });
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[9];
        MerchantDetailPhotoAdapter merchantDetailPhotoAdapter2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        ConcatAdapter concatAdapter = null;
        if (merchantDetailPhotoAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantDetailPhotoAdapter2 = null;
        }
        adapterArr[0] = merchantDetailPhotoAdapter2;
        MerchantHeaderInfoAdapter merchantHeaderInfoAdapter2 = this.getErrorConfigVersion;
        if (merchantHeaderInfoAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantHeaderInfoAdapter2 = null;
        }
        adapterArr[1] = merchantHeaderInfoAdapter2;
        MerchantActionInfoAdapter merchantActionInfoAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (merchantActionInfoAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantActionInfoAdapter = null;
        }
        adapterArr[2] = merchantActionInfoAdapter;
        MerchantSpecialDealsSectionAdapter merchantSpecialDealsSectionAdapter = this.GetContactSyncConfig;
        if (merchantSpecialDealsSectionAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantSpecialDealsSectionAdapter = null;
        }
        adapterArr[3] = merchantSpecialDealsSectionAdapter;
        MerchantPromoDealsInfoAdapter merchantPromoDealsInfoAdapter = this.scheduleImpl;
        if (merchantPromoDealsInfoAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantPromoDealsInfoAdapter = null;
        }
        adapterArr[4] = merchantPromoDealsInfoAdapter;
        MerchantContactInfoAdapter merchantContactInfoAdapter = this.moveToNextValue;
        if (merchantContactInfoAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantContactInfoAdapter = null;
        }
        adapterArr[5] = merchantContactInfoAdapter;
        MerchantQrisInfoAdapter merchantQrisInfoAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (merchantQrisInfoAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantQrisInfoAdapter = null;
        }
        adapterArr[6] = merchantQrisInfoAdapter;
        MerchantUserReviewAdapter merchantUserReviewAdapter2 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (merchantUserReviewAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantUserReviewAdapter2 = null;
        }
        adapterArr[7] = merchantUserReviewAdapter2;
        MerchantReviewsInfoAdapter merchantReviewsInfoAdapter = this.initRecordTimeStamp;
        if (merchantReviewsInfoAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantReviewsInfoAdapter = null;
        }
        adapterArr[8] = merchantReviewsInfoAdapter;
        this.getAuthRequestContext = new ConcatAdapter(adapterArr);
        final RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a110a_daggermerchantdetailreviewcomponent_merchantdetailreviewcomponentimpl_merchantinforepositoryprovider);
        if (recyclerView != null) {
            recyclerView.setItemAnimator(null);
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: id.dana.nearbyrevamp.merchantdetail.MerchantDetailView$setupRecyclerView$1$1
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public final void onScrolled(RecyclerView p0, int p1, int p2) {
                    boolean authRequestContext;
                    Intrinsics.checkNotNullParameter(p0, "");
                    RecyclerView recyclerView2 = (RecyclerView) RecyclerView.this.findViewById(R.id.res_0x7f0a110a_daggermerchantdetailreviewcomponent_merchantdetailreviewcomponentimpl_merchantinforepositoryprovider);
                    RecyclerView.LayoutManager layoutManager = recyclerView2 != null ? recyclerView2.getLayoutManager() : null;
                    if (layoutManager == null) {
                        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                    }
                    int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
                    RecyclerView recyclerView3 = (RecyclerView) RecyclerView.this.findViewById(R.id.res_0x7f0a110a_daggermerchantdetailreviewcomponent_merchantdetailreviewcomponentimpl_merchantinforepositoryprovider);
                    RecyclerView.ViewHolder findViewHolderForLayoutPosition = recyclerView3 != null ? recyclerView3.findViewHolderForLayoutPosition(findFirstVisibleItemPosition) : null;
                    MerchantDetailView merchantDetailView = this;
                    authRequestContext = merchantDetailView.getAuthRequestContext(findFirstVisibleItemPosition);
                    MerchantDetailView.access$setCvBackToTopVisibility(merchantDetailView, authRequestContext);
                    MerchantDetailView.access$checkIsMerchantPhotoShown(this, findViewHolderForLayoutPosition);
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public final void onScrollStateChanged(RecyclerView p0, int p1) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    super.onScrollStateChanged(p0, p1);
                    if (p0.canScrollVertically(130)) {
                        return;
                    }
                    this.MyBillsEntityDataFactory();
                }
            });
            ConcatAdapter concatAdapter2 = this.getAuthRequestContext;
            if (concatAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                concatAdapter = concatAdapter2;
            }
            recyclerView.setAdapter(concatAdapter);
        }
        CardView cardView = (CardView) _$_findCachedViewById(R.id.ViewPayConfirmationAddOnBinding_res_0x7f0a0572);
        if (cardView != null) {
            cardView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyrevamp.merchantdetail.MerchantDetailView$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MerchantDetailView.$r8$lambda$raZqINnQ5qYb_KZLsWUNEao0XUI(MerchantDetailView.this, view);
                }
            });
        }
        CardView cardView2 = (CardView) _$_findCachedViewById(R.id.ViewPayConfirmationAddOnBinding_res_0x7f0a0572);
        if (cardView2 != null) {
            ViewExtKt.MyBillsEntityDataFactory(cardView2, null, null, null, Integer.valueOf(Utils.getAuthRequestContext(getContext())), 7);
        }
    }
}
