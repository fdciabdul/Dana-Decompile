package id.dana.social.v2.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.PopupMenu;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.material.imageview.ShapeableImageView;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.data.account.repository.AccountEntityRepository;
import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.extension.view.ViewExtKt;
import id.dana.feeds.domain.timeline.enums.FeedActivityState;
import id.dana.feeds.ui.model.ActivityReactionsUserModel;
import id.dana.feeds.ui.model.ActivityWidgetModel;
import id.dana.feeds.ui.model.DealsPayloadModel;
import id.dana.feeds.ui.model.DealsVoucherColor;
import id.dana.feeds.ui.model.DealsVoucherColorKt;
import id.dana.feeds.ui.model.FeedCommentModel;
import id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerModel;
import id.dana.nearbyme.merchantdetail.mediaviewer.MerchantPhotoGalleryActivity;
import id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotoViewerDialog;
import id.dana.nearbyme.merchantdetail.merchantphoto.MerchantPhotoViewerModel;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import id.dana.notification.RedirectType;
import id.dana.social.extension.SocialFeedExtKt;
import id.dana.social.model.FeedModel;
import id.dana.social.model.FeedViewHolderModel;
import id.dana.social.model.OwnReactionModel;
import id.dana.social.model.ReactionCountModel;
import id.dana.social.utils.FeedRegexData;
import id.dana.social.utils.FeedsContentUtils;
import id.dana.social.v2.adapter.FeedNearbyUgcAdapter;
import id.dana.social.view.ReactionSectionView;
import id.dana.utils.SizeUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0083\u0001B(\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010~\u001a\u00020\t¢\u0006\u0005\b\u007f\u0010\u0080\u0001B-\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010~\u001a\u00020\t\u0012\u0007\u0010\u0081\u0001\u001a\u00020\t¢\u0006\u0005\b\u007f\u0010\u0082\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0010\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001e\u001a\u00020\u00062\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\"\u001a\u00020\u00062\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020 ¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b%\u0010\u0018J\u0015\u0010%\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b%\u0010(J;\u0010,\u001a\u00020\u00062,\u0010+\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020)j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002`*0 ¢\u0006\u0004\b,\u0010#J\u001d\u0010/\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u0002¢\u0006\u0004\b/\u00100J)\u00103\u001a\u00020\u00062\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00060\u001c2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00060\u001c¢\u0006\u0004\b3\u00104J\u0015\u00107\u001a\u00020\u00062\u0006\u00106\u001a\u000205¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u0006H\u0016¢\u0006\u0004\b9\u0010:J=\u0010A\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u0004¢\u0006\u0004\bA\u0010BJ/\u0010G\u001a\u00020\u00062\u0018\u0010E\u001a\u0014\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020\t0C2\u0006\u0010F\u001a\u00020D¢\u0006\u0004\bG\u0010HJ\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010IJ\u0017\u0010J\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0004\bJ\u0010IJ\u0015\u0010K\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0016¢\u0006\u0004\bK\u0010\u0018J\u0017\u0010L\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\tH\u0002¢\u0006\u0004\bL\u0010MR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010NR\u0016\u0010J\u001a\u00020O8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010P\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010RR\u0014\u0010L\u001a\u00020\u00048\u0002X\u0082\u0006¢\u0006\u0006\n\u0004\bL\u0010NR\u0016\u0010\u0017\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010SR7\u0010]\u001a\u0017\u0012\u000b\u0012\t\u0018\u00010U¢\u0006\u0002\bV\u0012\u0004\u0012\u00020\u0006\u0018\u00010T8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\RD\u0010f\u001a$\u0012\u000b\u0012\t\u0018\u00010\u0002¢\u0006\u0002\bV\u0012\u000b\u0012\t\u0018\u00010_¢\u0006\u0002\bV\u0012\u0004\u0012\u00020\u0006\u0018\u00010^8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u0018\u0010`\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bh\u0010iR*\u0010@\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u00048\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\bj\u0010N\u001a\u0004\bk\u0010l\"\u0004\bm\u0010IR*\u0010<\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u00048\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\bn\u0010N\u001a\u0004\bo\u0010l\"\u0004\bp\u0010IR*\u0010;\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u00048\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\bq\u0010N\u001a\u0004\br\u0010l\"\u0004\bs\u0010IR\u0014\u0010h\u001a\u00020\u00048\u0002X\u0083\u0006¢\u0006\u0006\n\u0004\bt\u0010NR*\u0010?\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u00048\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\bu\u0010N\u001a\u0004\bv\u0010l\"\u0004\bw\u0010IR*\u0010=\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u00048\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\bx\u0010N\u001a\u0004\by\u0010l\"\u0004\bz\u0010IR*\u0010>\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u00048\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b{\u0010N\u001a\u0004\b|\u0010l\"\u0004\b}\u0010I"}, d2 = {"Lid/dana/social/v2/view/ActivityFeedView;", "Lid/dana/base/BaseRichView;", "", "p0", "", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Z)V", "", "getLayout", "()I", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "activityDate", "responseCount", "setActivityDateAndResponseCount", "(Ljava/lang/String;I)V", "Lid/dana/social/model/FeedModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/social/model/FeedModel;)V", AccountEntityRepository.UpdateType.AVATAR, "setAvatar", "(Ljava/lang/String;)V", "Lkotlin/Function0;", "action", "setAvatarClickAction", "(Lkotlin/jvm/functions/Function0;)V", "", "avatarUrls", "setAvatars", "(Ljava/util/List;)V", "feedModel", "setContent", "Lid/dana/social/utils/FeedRegexData;", "feedRegexData", "(Lid/dana/social/utils/FeedRegexData;)V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "names", "setGroupedName", ExtendInfoUtilKt.DISPLAY_NAME_KEY, "username", "setName", "(Ljava/lang/String;Ljava/lang/String;)V", "onDeleteActivity", "onRetryActivity", "setRetryAndDeleteAction", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "Lid/dana/feeds/domain/timeline/enums/FeedActivityState;", "status", "setStatus", "(Lid/dana/feeds/domain/timeline/enums/FeedActivityState;)V", "setup", "()V", "showAddSaymojiIcon", "showAddCommentIcon", "showReactionSection", "showResponseCount", "showLatestComment", "showActivityInfoView", "setupActivityFeed", "(ZZZZZZ)V", "Lkotlin/Triple;", "Lid/dana/social/model/FeedViewHolderModel;", "value", "data", "showLineConnector", "(Lkotlin/Triple;Lid/dana/social/model/FeedViewHolderModel;)V", "(Z)V", "PlaceComponentResult", "updateCommentCount", "MyBillsEntityDataFactory", "(I)V", "Z", "Lid/dana/social/v2/adapter/FeedNearbyUgcAdapter;", "getAuthRequestContext", "Lid/dana/social/v2/adapter/FeedNearbyUgcAdapter;", "Lid/dana/social/model/FeedModel;", "I", "Lkotlin/Function1;", "Lid/dana/feeds/ui/model/ActivityWidgetModel;", "Lkotlin/ParameterName;", "lookAheadTest", "Lkotlin/jvm/functions/Function1;", "getOnActivityWidgetClicked", "()Lkotlin/jvm/functions/Function1;", "setOnActivityWidgetClicked", "(Lkotlin/jvm/functions/Function1;)V", "onActivityWidgetClicked", "Lkotlin/Function2;", "Lid/dana/feeds/ui/model/DealsPayloadModel;", "moveToNextValue", "Lkotlin/jvm/functions/Function2;", "getOnUniqueDealsWidgetClicked", "()Lkotlin/jvm/functions/Function2;", "setOnUniqueDealsWidgetClicked", "(Lkotlin/jvm/functions/Function2;)V", "onUniqueDealsWidgetClicked", "Landroid/view/View;", "scheduleImpl", "Landroid/view/View;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getShowActivityInfoView", "()Z", "setShowActivityInfoView", "getErrorConfigVersion", "getShowAddCommentIcon", "setShowAddCommentIcon", "initRecordTimeStamp", "getShowAddSaymojiIcon", "setShowAddSaymojiIcon", "NetworkUserEntityData$$ExternalSyntheticLambda1", "GetContactSyncConfig", "getShowLatestComment", "setShowLatestComment", "NetworkUserEntityData$$ExternalSyntheticLambda2", "getShowReactionSection", "setShowReactionSection", "DatabaseTableConfigUtil", "getShowResponseCount", "setShowResponseCount", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "WidgetType"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public class ActivityFeedView extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private FeedModel getAuthRequestContext;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private boolean showResponseCount;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private boolean showLatestComment;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;
    private boolean MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private boolean showActivityInfoView;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private boolean scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private boolean showReactionSection;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private int KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private FeedNearbyUgcAdapter PlaceComponentResult;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private boolean showAddCommentIcon;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private boolean showAddSaymojiIcon;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private Function1<? super ActivityWidgetModel, Unit> onActivityWidgetClicked;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private Function2<? super String, ? super DealsPayloadModel, Unit> onUniqueDealsWidgetClicked;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private View moveToNextValue;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[FeedActivityState.values().length];
            iArr[FeedActivityState.INIT.ordinal()] = 1;
            iArr[FeedActivityState.ERROR.ordinal()] = 2;
            getAuthRequestContext = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006"}, d2 = {"Lid/dana/social/v2/view/ActivityFeedView$WidgetType;", "", "<init>", "(Ljava/lang/String;I)V", "TEXT", "RATING", RedirectType.DEALS}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public enum WidgetType {
        TEXT,
        RATING,
        DEALS
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActivityFeedView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActivityFeedView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public static void __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(AppCompatImageView appCompatImageView, int i) {
        if (appCompatImageView instanceof ImageView) {
            InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
        } else {
            appCompatImageView.setImageResource(i);
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i) {
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
    public int getLayout() {
        return R.layout.view_activity_feed;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityFeedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 2;
        this.showAddSaymojiIcon = true;
        this.showAddCommentIcon = true;
        this.showReactionSection = true;
        this.showResponseCount = true;
        this.showLatestComment = true;
        this.showActivityInfoView = true;
        this.scheduleImpl = true;
    }

    public /* synthetic */ ActivityFeedView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityFeedView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = 2;
        this.showAddSaymojiIcon = true;
        this.showAddCommentIcon = true;
        this.showReactionSection = true;
        this.showResponseCount = true;
        this.showLatestComment = true;
        this.showActivityInfoView = true;
        this.scheduleImpl = true;
    }

    @JvmName(name = "getShowAddSaymojiIcon")
    public final boolean getShowAddSaymojiIcon() {
        return this.showAddSaymojiIcon;
    }

    @JvmName(name = "setShowAddSaymojiIcon")
    public final void setShowAddSaymojiIcon(boolean z) {
        this.showAddSaymojiIcon = z;
        View _$_findCachedViewById = _$_findCachedViewById(R.id.MyBillsEntityDataFactory_res_0x7f0a0069);
        AppCompatImageView appCompatImageView = _$_findCachedViewById != null ? (AppCompatImageView) _$_findCachedViewById.findViewById(R.id.res_0x7f0a0938_activityreactionsbottomsheetdialog_sortreactioncounts_inlined_sortedbydescending_1) : null;
        if (appCompatImageView != null) {
            appCompatImageView.setVisibility(z ? 0 : 8);
        }
    }

    @JvmName(name = "getShowAddCommentIcon")
    public final boolean getShowAddCommentIcon() {
        return this.showAddCommentIcon;
    }

    @JvmName(name = "setShowAddCommentIcon")
    public final void setShowAddCommentIcon(boolean z) {
        this.showAddCommentIcon = z;
        View _$_findCachedViewById = _$_findCachedViewById(R.id.MyBillsEntityDataFactory_res_0x7f0a0069);
        AppCompatImageView appCompatImageView = _$_findCachedViewById != null ? (AppCompatImageView) _$_findCachedViewById.findViewById(R.id.setTrackDrawable) : null;
        if (appCompatImageView != null) {
            appCompatImageView.setVisibility(z ? 0 : 8);
        }
    }

    @JvmName(name = "getShowReactionSection")
    public final boolean getShowReactionSection() {
        return this.showReactionSection;
    }

    @JvmName(name = "setShowReactionSection")
    public final void setShowReactionSection(boolean z) {
        ReactionSectionView reactionSectionView = (ReactionSectionView) _$_findCachedViewById(R.id.reactionSectionView);
        if (reactionSectionView != null) {
            reactionSectionView.setVisibility(z ? 0 : 8);
        }
        this.showReactionSection = z;
    }

    @JvmName(name = "getShowResponseCount")
    public final boolean getShowResponseCount() {
        return this.showResponseCount;
    }

    @JvmName(name = "setShowResponseCount")
    public final void setShowResponseCount(boolean z) {
        this.showResponseCount = z;
        View _$_findCachedViewById = _$_findCachedViewById(R.id.MyBillsEntityDataFactory_res_0x7f0a0069);
        TextView textView = _$_findCachedViewById != null ? (TextView) _$_findCachedViewById.findViewById(R.id.tvResponseCount) : null;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
        }
        View _$_findCachedViewById2 = _$_findCachedViewById(R.id.MyBillsEntityDataFactory_res_0x7f0a0069);
        TextView textView2 = _$_findCachedViewById2 != null ? (TextView) _$_findCachedViewById2.findViewById(R.id.NearbyMerchantLocationSearchView$setup$1$1) : null;
        if (textView2 != null) {
            textView2.setVisibility(z ? 0 : 8);
        }
    }

    @JvmName(name = "getShowLatestComment")
    public final boolean getShowLatestComment() {
        return this.showLatestComment;
    }

    @JvmName(name = "setShowLatestComment")
    public final void setShowLatestComment(boolean z) {
        LatestFeedCommentView latestFeedCommentView = (LatestFeedCommentView) _$_findCachedViewById(R.id.latestFeedCommentView);
        if (latestFeedCommentView != null) {
            latestFeedCommentView.setVisibility(z ? 0 : 8);
        }
        this.showLatestComment = z;
    }

    @JvmName(name = "getShowActivityInfoView")
    public final boolean getShowActivityInfoView() {
        return this.showActivityInfoView;
    }

    @JvmName(name = "setShowActivityInfoView")
    public final void setShowActivityInfoView(boolean z) {
        View _$_findCachedViewById = _$_findCachedViewById(R.id.MyBillsEntityDataFactory_res_0x7f0a0069);
        if (_$_findCachedViewById != null) {
            _$_findCachedViewById.setVisibility(z ? 0 : 8);
        }
        this.showActivityInfoView = z;
    }

    public final void showLineConnector(Triple<FeedViewHolderModel, FeedViewHolderModel, Integer> value, FeedViewHolderModel data) {
        Intrinsics.checkNotNullParameter(value, "");
        Intrinsics.checkNotNullParameter(data, "");
        if (value.getThird().intValue() > 1) {
            return;
        }
        View _$_findCachedViewById = _$_findCachedViewById(R.id.MissingProperty);
        if (_$_findCachedViewById != null) {
            _$_findCachedViewById.setVisibility(Intrinsics.areEqual(value.getFirst(), data) ^ true ? 0 : 8);
        }
        View _$_findCachedViewById2 = _$_findCachedViewById(R.id.res_0x7f0a19ae_tomillis_feature_cashier_productionrelease);
        if (_$_findCachedViewById2 != null) {
            _$_findCachedViewById2.setVisibility(Intrinsics.areEqual(value.getSecond(), data) ^ true ? 0 : 8);
        }
        View _$_findCachedViewById3 = _$_findCachedViewById(R.id.setLastTelemetrySync);
        if (_$_findCachedViewById3 != null) {
            _$_findCachedViewById3.setVisibility(8);
        }
        ShapeableImageView shapeableImageView = (ShapeableImageView) _$_findCachedViewById(R.id.civProfileAvatar);
        if (shapeableImageView != null) {
            ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(shapeableImageView, null, Float.valueOf(16.0f), null, null, 13);
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.doCommonLog);
        if (constraintLayout != null) {
            ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(constraintLayout, null, Float.valueOf(16.0f), null, null, 13);
        }
        ConstraintLayout constraintLayout2 = (ConstraintLayout) _$_findCachedViewById(R.id.allowedTargets);
        if (constraintLayout2 != null) {
            ViewExtKt.PlaceComponentResult(constraintLayout2, null, Float.valueOf(0.0f), null, null, 13);
        }
    }

    public final void setupActivityFeed(boolean showAddSaymojiIcon, boolean showAddCommentIcon, boolean showReactionSection, boolean showResponseCount, boolean showLatestComment, boolean showActivityInfoView) {
        setShowAddSaymojiIcon(showAddSaymojiIcon);
        setShowAddCommentIcon(showAddCommentIcon);
        setShowReactionSection(showReactionSection);
        setShowResponseCount(showResponseCount);
        setShowLatestComment(showLatestComment);
        setShowActivityInfoView(showActivityInfoView);
    }

    @JvmName(name = "getOnActivityWidgetClicked")
    public final Function1<ActivityWidgetModel, Unit> getOnActivityWidgetClicked() {
        return this.onActivityWidgetClicked;
    }

    @JvmName(name = "setOnActivityWidgetClicked")
    public final void setOnActivityWidgetClicked(Function1<? super ActivityWidgetModel, Unit> function1) {
        this.onActivityWidgetClicked = function1;
    }

    @JvmName(name = "getOnUniqueDealsWidgetClicked")
    public final Function2<String, DealsPayloadModel, Unit> getOnUniqueDealsWidgetClicked() {
        return this.onUniqueDealsWidgetClicked;
    }

    @JvmName(name = "setOnUniqueDealsWidgetClicked")
    public final void setOnUniqueDealsWidgetClicked(Function2<? super String, ? super DealsPayloadModel, Unit> function2) {
        this.onUniqueDealsWidgetClicked = function2;
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        this.PlaceComponentResult = new FeedNearbyUgcAdapter(new ActivityFeedView$setup$1(this), new Function0<Unit>() { // from class: id.dana.social.v2.view.ActivityFeedView$setup$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ActivityFeedView.access$handleOpenGallery(ActivityFeedView.this);
            }
        });
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a10fa_descriptorvisibilities_7);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new StaggeredGridLayoutManager());
            recyclerView.setHasFixedSize(true);
            FeedNearbyUgcAdapter feedNearbyUgcAdapter = this.PlaceComponentResult;
            if (feedNearbyUgcAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                feedNearbyUgcAdapter = null;
            }
            recyclerView.setAdapter(feedNearbyUgcAdapter);
        }
    }

    @Override // id.dana.base.BaseRichView
    public void parseAttrs(Context r8, AttributeSet attrs) {
        super.parseAttrs(r8, attrs);
        TypedArray obtainStyledAttributes = r8 != null ? r8.obtainStyledAttributes(attrs, R.styleable.getErrorConfigVersion) : null;
        if (obtainStyledAttributes != null) {
            int i = 0;
            try {
                boolean z = obtainStyledAttributes.getBoolean(0, false);
                this.BuiltInFictitiousFunctionClassFactory = z;
                if (z) {
                    ConstraintSet constraintSet = new ConstraintSet();
                    constraintSet.getAuthRequestContext((ConstraintLayout) _$_findCachedViewById(R.id.allowedTargets));
                    constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(((ConstraintLayout) _$_findCachedViewById(R.id.res_0x7f0a0358_typetoken_typeset)).getId(), 6, ((Barrier) _$_findCachedViewById(R.id.getErrorConfigVersion_res_0x7f0a00c9)).getId(), 6, 0);
                    constraintSet.KClassImpl$Data$declaredNonStaticMembers$2((ConstraintLayout) _$_findCachedViewById(R.id.allowedTargets));
                }
                this.MyBillsEntityDataFactory = obtainStyledAttributes.getBoolean(2, false);
                FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(R.id.res_0x7f0a0715_daggermoreforyoucomponent_moreforyoucomponentimpl_providemoreforyourepositoryprovider);
                int i2 = 4;
                if (frameLayout != null) {
                    frameLayout.setVisibility(this.MyBillsEntityDataFactory ^ true ? 4 : 0);
                }
                ShapeableImageView shapeableImageView = (ShapeableImageView) _$_findCachedViewById(R.id.civProfileAvatar);
                if (shapeableImageView != null) {
                    ShapeableImageView shapeableImageView2 = shapeableImageView;
                    if (!this.MyBillsEntityDataFactory) {
                        i2 = 0;
                    }
                    shapeableImageView2.setVisibility(i2);
                }
                boolean z2 = obtainStyledAttributes.getBoolean(1, true);
                View _$_findCachedViewById = _$_findCachedViewById(R.id.setLastTelemetrySync);
                if (_$_findCachedViewById != null) {
                    if (!z2) {
                        i = 8;
                    }
                    _$_findCachedViewById.setVisibility(i);
                }
                this.scheduleImpl = z2;
            } finally {
                if (obtainStyledAttributes != null) {
                    obtainStyledAttributes.recycle();
                }
            }
        }
    }

    public final void setAvatar(String r2) {
        Intrinsics.checkNotNullParameter(r2, "");
        ShapeableImageView shapeableImageView = (ShapeableImageView) _$_findCachedViewById(R.id.civProfileAvatar);
        if (shapeableImageView != null) {
            SocialFeedExtKt.BuiltInFictitiousFunctionClassFactory(shapeableImageView, r2, R.drawable.avatar_placeholder);
        }
        ShapeableImageView shapeableImageView2 = (ShapeableImageView) _$_findCachedViewById(R.id.civProfileAvatar);
        if (shapeableImageView2 != null) {
            shapeableImageView2.setVisibility(0);
        }
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(R.id.res_0x7f0a0715_daggermoreforyoucomponent_moreforyoucomponentimpl_providemoreforyourepositoryprovider);
        if (frameLayout != null) {
            frameLayout.setVisibility(4);
        }
    }

    public final void setAvatars(List<String> avatarUrls) {
        Intrinsics.checkNotNullParameter(avatarUrls, "");
        ShapeableImageView shapeableImageView = (ShapeableImageView) _$_findCachedViewById(R.id.civProfileAvatar);
        if (shapeableImageView != null) {
            shapeableImageView.setVisibility(4);
        }
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(R.id.res_0x7f0a0715_daggermoreforyoucomponent_moreforyoucomponentimpl_providemoreforyourepositoryprovider);
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        if (avatarUrls.size() > 1) {
            ShapeableImageView shapeableImageView2 = (ShapeableImageView) _$_findCachedViewById(R.id.res_0x7f0a0313_flowkt__reducekt_firstornull_inlined_collectwhile_2_1);
            if (shapeableImageView2 != null) {
                SocialFeedExtKt.BuiltInFictitiousFunctionClassFactory(shapeableImageView2, avatarUrls.get(0), R.drawable.avatar_placeholder);
            }
            ShapeableImageView shapeableImageView3 = (ShapeableImageView) _$_findCachedViewById(R.id.SchedulerPoolFactory_res_0x7f0a0314);
            if (shapeableImageView3 != null) {
                SocialFeedExtKt.BuiltInFictitiousFunctionClassFactory(shapeableImageView3, avatarUrls.get(1), R.drawable.avatar_placeholder);
            }
        } else if (avatarUrls.size() == 1) {
            ShapeableImageView shapeableImageView4 = (ShapeableImageView) _$_findCachedViewById(R.id.res_0x7f0a0313_flowkt__reducekt_firstornull_inlined_collectwhile_2_1);
            if (shapeableImageView4 != null) {
                SocialFeedExtKt.BuiltInFictitiousFunctionClassFactory(shapeableImageView4, avatarUrls.get(0), R.drawable.avatar_placeholder);
            }
            ShapeableImageView shapeableImageView5 = (ShapeableImageView) _$_findCachedViewById(R.id.SchedulerPoolFactory_res_0x7f0a0314);
            if (shapeableImageView5 != null) {
                SocialFeedExtKt.BuiltInFictitiousFunctionClassFactory(shapeableImageView5, avatarUrls.get(0), R.drawable.avatar_placeholder);
            }
        }
    }

    public final void setContent(FeedRegexData feedRegexData) {
        Intrinsics.checkNotNullParameter(feedRegexData, "");
        TextView textView = (TextView) _$_findCachedViewById(R.id.res_0x7f0a1406_r8_lambda_igamusprxlzpm8ju6atxwqx6eok);
        if (textView != null) {
            FeedsContentUtils feedsContentUtils = FeedsContentUtils.MyBillsEntityDataFactory;
            textView.setText(FeedsContentUtils.PlaceComponentResult(feedRegexData, false, false).toString());
        }
    }

    public final void setName(String r2, String username) {
        Intrinsics.checkNotNullParameter(r2, "");
        Intrinsics.checkNotNullParameter(username, "");
        TextView textView = (TextView) _$_findCachedViewById(R.id.GroupSendEditNameDialog$onDismiss$1);
        if (textView != null) {
            textView.setText(r2);
        }
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.getTitleColor);
        if (textView2 != null) {
            FeedsContentUtils feedsContentUtils = FeedsContentUtils.MyBillsEntityDataFactory;
            FeedsContentUtils.KClassImpl$Data$declaredNonStaticMembers$2(textView2, username);
        }
        TextView textView3 = (TextView) _$_findCachedViewById(R.id.tvOthersGroupName);
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
    }

    public final void setGroupedName(List<? extends HashMap<String, String>> names) {
        Intrinsics.checkNotNullParameter(names, "");
        if (names.isEmpty()) {
            BuiltInFictitiousFunctionClassFactory("", false);
        } else if (names.size() == 1) {
            BuiltInFictitiousFunctionClassFactory(ExtendInfoUtilKt.getNickName(names.get(0)), false);
        } else if (names.size() == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append(ExtendInfoUtilKt.getNickName(names.get(0)));
            sb.append(InputCardNumberView.DIVIDER);
            sb.append(getContext().getString(R.string.and_predicate));
            sb.append(InputCardNumberView.DIVIDER);
            sb.append(ExtendInfoUtilKt.getNickName(names.get(1)));
            BuiltInFictitiousFunctionClassFactory(sb.toString(), false);
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(ExtendInfoUtilKt.getNickName(names.get(0)));
            sb2.append(", ");
            sb2.append(ExtendInfoUtilKt.getNickName(names.get(1)));
            BuiltInFictitiousFunctionClassFactory(sb2.toString(), true);
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory(String p0, boolean p1) {
        TextView textView = (TextView) _$_findCachedViewById(R.id.tvOthersGroupName);
        if (textView != null) {
            textView.setVisibility(p1 ? 0 : 8);
        }
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.getTitleColor);
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        TextView textView3 = (TextView) _$_findCachedViewById(R.id.GroupSendEditNameDialog$onDismiss$1);
        if (textView3 != null) {
            textView3.setText(p0);
        }
    }

    public final void setContent(final FeedModel feedModel) {
        Unit unit;
        ViewTreeObserver viewTreeObserver;
        AppCompatImageView appCompatImageView;
        String BuiltInFictitiousFunctionClassFactory;
        final ActivityWidgetModel activityWidgetModel;
        ActivityWidgetView activityWidgetView;
        if (feedModel == null) {
            return;
        }
        this.getAuthRequestContext = feedModel;
        TextView textView = (TextView) _$_findCachedViewById(R.id.res_0x7f0a13f2_daggerreferraltrackercomponent_referraltrackercomponentimpl_providepushverifytrackerprovider);
        if (textView != null) {
            FeedsContentUtils feedsContentUtils = FeedsContentUtils.MyBillsEntityDataFactory;
            String str = feedModel.MyBillsEntityDataFactory;
            if (str == null) {
                str = "";
            }
            FeedsContentUtils.KClassImpl$Data$declaredNonStaticMembers$2(textView, str);
        }
        FeedNearbyUgcAdapter feedNearbyUgcAdapter = null;
        if (feedModel == null || (activityWidgetModel = feedModel.KClassImpl$Data$declaredNonStaticMembers$2) == null || (activityWidgetView = (ActivityWidgetView) _$_findCachedViewById(R.id.PlaceComponentResult_res_0x7f0a006a)) == null) {
            unit = null;
        } else {
            Intrinsics.checkNotNullExpressionValue(activityWidgetView, "");
            if (!activityWidgetModel.KClassImpl$Data$declaredNonStaticMembers$2()) {
                ActivityWidgetView activityWidgetView2 = (ActivityWidgetView) activityWidgetView._$_findCachedViewById(R.id.PlaceComponentResult_res_0x7f0a006a);
                if (activityWidgetView2 != null) {
                    Intrinsics.checkNotNullExpressionValue(activityWidgetView2, "");
                    activityWidgetView2.setVisibility(0);
                }
                DealsVoucherView dealsVoucherView = (DealsVoucherView) activityWidgetView._$_findCachedViewById(R.id.dealsVoucherView);
                if (dealsVoucherView != null) {
                    Intrinsics.checkNotNullExpressionValue(dealsVoucherView, "");
                    dealsVoucherView.setVisibility(8);
                }
                if (Intrinsics.areEqual(activityWidgetModel.NetworkUserEntityData$$ExternalSyntheticLambda0, WidgetType.RATING.name())) {
                    activityWidgetView.setWidgetDataRating(activityWidgetModel.MyBillsEntityDataFactory, activityWidgetModel.lookAheadTest, activityWidgetModel.getErrorConfigVersion.length() == 0 ? 0 : Integer.parseInt(activityWidgetModel.getErrorConfigVersion));
                } else {
                    activityWidgetView.setWidgetDataText(activityWidgetModel.MyBillsEntityDataFactory, activityWidgetModel.lookAheadTest, activityWidgetModel.getErrorConfigVersion);
                }
                activityWidgetView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.v2.view.ActivityFeedView$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ActivityFeedView.$r8$lambda$xtsqt8a8cweJ0SFaXJ5VKHvwAWM(ActivityFeedView.this, activityWidgetModel, view);
                    }
                });
            } else {
                try {
                    Map<String, ? extends Object> map = activityWidgetModel.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (map == null) {
                        throw new ClassCastException("Incompatible class type");
                    }
                    final DealsPayloadModel dealsPayloadModel = new DealsPayloadModel(map);
                    String str2 = (String) MapsKt.getOrImplicitDefaultNullable(dealsPayloadModel.lookAheadTest, DealsPayloadModel.KClassImpl$Data$declaredNonStaticMembers$2[0].getName());
                    if (str2 == null) {
                        str2 = "";
                    }
                    DealsVoucherColor KClassImpl$Data$declaredNonStaticMembers$2 = DealsVoucherColorKt.KClassImpl$Data$declaredNonStaticMembers$2((String) MapsKt.getOrImplicitDefaultNullable(dealsPayloadModel.KClassImpl$Data$declaredNonStaticMembers$2, DealsPayloadModel.KClassImpl$Data$declaredNonStaticMembers$2[3].getName()));
                    String str3 = (String) MapsKt.getOrImplicitDefaultNullable(dealsPayloadModel.NetworkUserEntityData$$ExternalSyntheticLambda0, DealsPayloadModel.KClassImpl$Data$declaredNonStaticMembers$2[4].getName());
                    String str4 = (String) MapsKt.getOrImplicitDefaultNullable(dealsPayloadModel.getAuthRequestContext, DealsPayloadModel.KClassImpl$Data$declaredNonStaticMembers$2[5].getName());
                    final Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.social.v2.view.ActivityFeedView$handleNewDealsContent$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            Function2<String, DealsPayloadModel, Unit> onUniqueDealsWidgetClicked = ActivityFeedView.this.getOnUniqueDealsWidgetClicked();
                            if (onUniqueDealsWidgetClicked != null) {
                                onUniqueDealsWidgetClicked.invoke(activityWidgetModel.BuiltInFictitiousFunctionClassFactory, dealsPayloadModel);
                            }
                        }
                    };
                    ActivityWidgetView activityWidgetView3 = (ActivityWidgetView) _$_findCachedViewById(R.id.PlaceComponentResult_res_0x7f0a006a);
                    if (activityWidgetView3 != null) {
                        activityWidgetView3.setVisibility(8);
                    }
                    DealsVoucherView dealsVoucherView2 = (DealsVoucherView) _$_findCachedViewById(R.id.dealsVoucherView);
                    Intrinsics.checkNotNullExpressionValue(dealsVoucherView2, "");
                    dealsVoucherView2.setVisibility(0);
                    dealsVoucherView2.setImageUrl(str2);
                    dealsVoucherView2.setTitle(str3);
                    dealsVoucherView2.setSubTitle(str4);
                    dealsVoucherView2.setBackgroundColor(KClassImpl$Data$declaredNonStaticMembers$2);
                    dealsVoucherView2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.v2.view.ActivityFeedView$$ExternalSyntheticLambda4
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ActivityFeedView.$r8$lambda$Fp8XqJEYPFakF8gK9x81Qj8APfI(Function0.this, view);
                        }
                    });
                } catch (Exception e) {
                    DanaLog.BuiltInFictitiousFunctionClassFactory("ActivityFeedView", e.getMessage());
                }
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            ActivityWidgetView activityWidgetView4 = (ActivityWidgetView) _$_findCachedViewById(R.id.PlaceComponentResult_res_0x7f0a006a);
            if (activityWidgetView4 != null) {
                Intrinsics.checkNotNullExpressionValue(activityWidgetView4, "");
                activityWidgetView4.setVisibility(8);
            }
            DealsVoucherView dealsVoucherView3 = (DealsVoucherView) _$_findCachedViewById(R.id.dealsVoucherView);
            if (dealsVoucherView3 != null) {
                Intrinsics.checkNotNullExpressionValue(dealsVoucherView3, "");
                dealsVoucherView3.setVisibility(8);
            }
        }
        if (!this.showReactionSection) {
            ReactionSectionView reactionSectionView = (ReactionSectionView) _$_findCachedViewById(R.id.reactionSectionView);
            if (reactionSectionView != null) {
                reactionSectionView.setVisibility(8);
            }
        } else {
            ReactionSectionView reactionSectionView2 = (ReactionSectionView) _$_findCachedViewById(R.id.reactionSectionView);
            if (reactionSectionView2 != null) {
                reactionSectionView2.setVisibility(0);
            }
            ReactionSectionView reactionSectionView3 = (ReactionSectionView) _$_findCachedViewById(R.id.reactionSectionView);
            final View findViewById = reactionSectionView3 != null ? reactionSectionView3.findViewById(R.id.view_reaction_section_rv_ruler) : null;
            this.moveToNextValue = findViewById;
            if (findViewById != null && (viewTreeObserver = findViewById.getViewTreeObserver()) != null) {
                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: id.dana.social.v2.view.ActivityFeedView$calculateReactionContainerThenSetContent$1$1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public final void onGlobalLayout() {
                        int i;
                        ActivityFeedView.this.KClassImpl$Data$declaredNonStaticMembers$2 = MathKt.roundToInt(SizeUtil.PlaceComponentResult(findViewById.getMeasuredWidth()) / 78.0f);
                        ReactionSectionView reactionSectionView4 = (ReactionSectionView) ActivityFeedView.this._$_findCachedViewById(R.id.reactionSectionView);
                        if (reactionSectionView4 != null) {
                            FeedModel feedModel2 = feedModel;
                            i = ActivityFeedView.this.KClassImpl$Data$declaredNonStaticMembers$2;
                            reactionSectionView4.setReactionsContentView(feedModel2, Math.max(2, i));
                        }
                        findViewById.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
            }
            ReactionSectionView reactionSectionView4 = (ReactionSectionView) _$_findCachedViewById(R.id.reactionSectionView);
            if (reactionSectionView4 != null) {
                ReactionSectionView.setReactionsContentView$default(reactionSectionView4, feedModel, 0, 2, null);
            }
        }
        ReactionSectionView reactionSectionView5 = (ReactionSectionView) _$_findCachedViewById(R.id.reactionSectionView);
        if (reactionSectionView5 != null) {
            reactionSectionView5.setOnUpdateReactionCountAndInfo(new Function1<FeedModel, Unit>() { // from class: id.dana.social.v2.view.ActivityFeedView$setReactions$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(FeedModel feedModel2) {
                    invoke2(feedModel2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(FeedModel feedModel2) {
                    FeedModel feedModel3;
                    FeedModel feedModel4;
                    Intrinsics.checkNotNullParameter(feedModel2, "");
                    feedModel3 = ActivityFeedView.this.getAuthRequestContext;
                    if (feedModel3 != null) {
                        List<ReactionCountModel> list = feedModel2.NetworkUserEntityData$$ExternalSyntheticLambda8;
                        Intrinsics.checkNotNullParameter(list, "");
                        feedModel3.NetworkUserEntityData$$ExternalSyntheticLambda8 = list;
                    }
                    feedModel4 = ActivityFeedView.this.getAuthRequestContext;
                    if (feedModel4 != null) {
                        List<OwnReactionModel> list2 = feedModel2.NetworkUserEntityData$$ExternalSyntheticLambda7;
                        Intrinsics.checkNotNullParameter(list2, "");
                        feedModel4.NetworkUserEntityData$$ExternalSyntheticLambda7 = list2;
                    }
                    ActivityFeedView.this.KClassImpl$Data$declaredNonStaticMembers$2(feedModel);
                }
            });
        }
        KClassImpl$Data$declaredNonStaticMembers$2(feedModel);
        FeedCommentModel feedCommentModel = feedModel.DatabaseTableConfigUtil;
        if (this.showLatestComment && feedCommentModel != null) {
            LatestFeedCommentView latestFeedCommentView = (LatestFeedCommentView) _$_findCachedViewById(R.id.latestFeedCommentView);
            if (latestFeedCommentView != null) {
                latestFeedCommentView.setVisibility(0);
            }
            LatestFeedCommentView latestFeedCommentView2 = (LatestFeedCommentView) _$_findCachedViewById(R.id.latestFeedCommentView);
            if (latestFeedCommentView2 != null) {
                String str5 = feedCommentModel.NetworkUserEntityData$$ExternalSyntheticLambda2.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (str5 == null) {
                    str5 = "";
                }
                ActivityReactionsUserModel activityReactionsUserModel = feedCommentModel.NetworkUserEntityData$$ExternalSyntheticLambda2;
                if (feedCommentModel.getGetErrorConfigVersion()) {
                    BuiltInFictitiousFunctionClassFactory = activityReactionsUserModel.MyBillsEntityDataFactory;
                    if (BuiltInFictitiousFunctionClassFactory == null) {
                        BuiltInFictitiousFunctionClassFactory = "";
                    }
                } else {
                    String str6 = activityReactionsUserModel.scheduleImpl;
                    if (!(str6.length() > 0)) {
                        str6 = null;
                    }
                    BuiltInFictitiousFunctionClassFactory = str6 == null ? activityReactionsUserModel.BuiltInFictitiousFunctionClassFactory() : str6;
                }
                latestFeedCommentView2.setCommentInfos(str5, BuiltInFictitiousFunctionClassFactory, feedCommentModel.PlaceComponentResult);
            }
        } else {
            LatestFeedCommentView latestFeedCommentView3 = (LatestFeedCommentView) _$_findCachedViewById(R.id.latestFeedCommentView);
            if (latestFeedCommentView3 != null) {
                latestFeedCommentView3.setVisibility(8);
            }
        }
        List<MerchantImageModel> list = feedModel.GetContactSyncConfig;
        List<MerchantImageModel> list2 = list;
        if (true ^ list2.isEmpty()) {
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a10fa_descriptorvisibilities_7);
            if (recyclerView != null) {
                recyclerView.setVisibility(0);
            }
            FeedNearbyUgcAdapter feedNearbyUgcAdapter2 = this.PlaceComponentResult;
            if (feedNearbyUgcAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                feedNearbyUgcAdapter = feedNearbyUgcAdapter2;
            }
            Intrinsics.checkNotNullParameter(list, "");
            feedNearbyUgcAdapter.BuiltInFictitiousFunctionClassFactory.clear();
            feedNearbyUgcAdapter.BuiltInFictitiousFunctionClassFactory.addAll(list2);
            List take = CollectionsKt.take(feedNearbyUgcAdapter.BuiltInFictitiousFunctionClassFactory, 4);
            if (list.size() > 4) {
                ((MerchantImageModel) CollectionsKt.last(take)).MyBillsEntityDataFactory = 3;
            }
            feedNearbyUgcAdapter.setItems(take);
        } else {
            RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a10fa_descriptorvisibilities_7);
            if (recyclerView2 != null) {
                recyclerView2.setVisibility(8);
            }
        }
        setStatus(feedModel.NetworkUserEntityData$$ExternalSyntheticLambda6);
        View _$_findCachedViewById = _$_findCachedViewById(R.id.MyBillsEntityDataFactory_res_0x7f0a0069);
        if (_$_findCachedViewById == null || (appCompatImageView = (AppCompatImageView) _$_findCachedViewById.findViewById(R.id.res_0x7f0a0938_activityreactionsbottomsheetdialog_sortreactioncounts_inlined_sortedbydescending_1)) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.v2.view.ActivityFeedView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActivityFeedView.m2955$r8$lambda$TopAGtKTFTtFMhMnuAWf4VhDiw(ActivityFeedView.this, feedModel, view);
            }
        });
    }

    public final void setAvatarClickAction(final Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(action, "");
        ShapeableImageView shapeableImageView = (ShapeableImageView) _$_findCachedViewById(R.id.civProfileAvatar);
        if (shapeableImageView != null) {
            shapeableImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.v2.view.ActivityFeedView$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ActivityFeedView.m2956$r8$lambda$VXzbShfvLFxuzU2eGutJia0MoU(Function0.this, view);
                }
            });
        }
    }

    public final void setRetryAndDeleteAction(final Function0<Unit> onDeleteActivity, final Function0<Unit> onRetryActivity) {
        Intrinsics.checkNotNullParameter(onDeleteActivity, "");
        Intrinsics.checkNotNullParameter(onRetryActivity, "");
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.ivThreeDotActivity);
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.v2.view.ActivityFeedView$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ActivityFeedView.$r8$lambda$hkX7ZAhUd_xAR5GBd9PlDmMQF10(ActivityFeedView.this, onDeleteActivity, onRetryActivity, view);
                }
            });
        }
    }

    public static final boolean KClassImpl$Data$declaredNonStaticMembers$2(Function0 function0, Function0 function02, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(function0, "");
        Intrinsics.checkNotNullParameter(function02, "");
        Intrinsics.checkNotNullParameter(menuItem, "");
        int itemId = menuItem.getItemId();
        if (itemId == R.id.option_delete) {
            function02.invoke();
            return true;
        } else if (itemId == R.id.option_retry) {
            function0.invoke();
            return true;
        } else {
            return true;
        }
    }

    public final void setActivityDateAndResponseCount(String activityDate, int responseCount) {
        Intrinsics.checkNotNullParameter(activityDate, "");
        View _$_findCachedViewById = _$_findCachedViewById(R.id.MyBillsEntityDataFactory_res_0x7f0a0069);
        TextView textView = _$_findCachedViewById != null ? (TextView) _$_findCachedViewById.findViewById(R.id.hasOptionsMenu) : null;
        if (textView != null) {
            textView.setText(activityDate);
        }
        MyBillsEntityDataFactory(responseCount);
    }

    private final void MyBillsEntityDataFactory(int p0) {
        String quantityString;
        View _$_findCachedViewById = _$_findCachedViewById(R.id.MyBillsEntityDataFactory_res_0x7f0a0069);
        TextView textView = _$_findCachedViewById != null ? (TextView) _$_findCachedViewById.findViewById(R.id.tvResponseCount) : null;
        if (textView != null) {
            if (p0 == 0) {
                quantityString = getContext().getString(R.string.zero_response);
            } else {
                quantityString = getContext().getResources().getQuantityString(R.plurals.f46742131820560, p0, Integer.valueOf(p0));
            }
            textView.setText(quantityString);
        }
    }

    private final void PlaceComponentResult(boolean p0) {
        AppCompatImageView appCompatImageView;
        View _$_findCachedViewById = _$_findCachedViewById(R.id.MyBillsEntityDataFactory_res_0x7f0a0069);
        if (_$_findCachedViewById == null || (appCompatImageView = (AppCompatImageView) _$_findCachedViewById.findViewById(R.id.res_0x7f0a0938_activityreactionsbottomsheetdialog_sortreactioncounts_inlined_sortedbydescending_1)) == null) {
            return;
        }
        __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(appCompatImageView, p0 ? R.drawable.ic_saymoji_blue : R.drawable.ic_saymoji_grey);
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
        AppCompatImageView appCompatImageView;
        View _$_findCachedViewById = _$_findCachedViewById(R.id.MyBillsEntityDataFactory_res_0x7f0a0069);
        if (_$_findCachedViewById == null || (appCompatImageView = (AppCompatImageView) _$_findCachedViewById.findViewById(R.id.setTrackDrawable)) == null) {
            return;
        }
        __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(appCompatImageView, p0 ? R.drawable.ic_comment_blue : R.drawable.ic_comment);
    }

    public final void setStatus(FeedActivityState status) {
        Intrinsics.checkNotNullParameter(status, "");
        TextView textView = (TextView) _$_findCachedViewById(R.id.AnnotationDescriptorImpl);
        if (textView != null) {
            textView.setVisibility(status != FeedActivityState.SUCCESS ? 0 : 8);
        }
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.hasOptionsMenu);
        if (textView2 != null) {
            textView2.setVisibility(status == FeedActivityState.SUCCESS ? 0 : 8);
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.ivThreeDotActivity);
        if (appCompatImageView != null) {
            appCompatImageView.setVisibility(status == FeedActivityState.ERROR ? 0 : 8);
        }
        if (status == FeedActivityState.SUCCESS) {
            View _$_findCachedViewById = _$_findCachedViewById(R.id.MyBillsEntityDataFactory_res_0x7f0a0069);
            if (_$_findCachedViewById != null) {
                ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(_$_findCachedViewById, null, Float.valueOf(16.0f), null, null, 13);
            }
        } else {
            setShowAddSaymojiIcon(false);
            setShowAddCommentIcon(false);
            setShowReactionSection(false);
            setShowResponseCount(false);
            setShowLatestComment(false);
            View _$_findCachedViewById2 = _$_findCachedViewById(R.id.MyBillsEntityDataFactory_res_0x7f0a0069);
            if (_$_findCachedViewById2 != null) {
                ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(_$_findCachedViewById2, null, Float.valueOf(28.0f), null, null, 13);
            }
        }
        int i = WhenMappings.getAuthRequestContext[status.ordinal()];
        if (i == 1) {
            TextView textView3 = (TextView) _$_findCachedViewById(R.id.AnnotationDescriptorImpl);
            if (textView3 != null) {
                textView3.setText(getContext().getString(R.string.share_activity_loading_description));
            }
            TextView textView4 = (TextView) _$_findCachedViewById(R.id.AnnotationDescriptorImpl);
            if (textView4 != null) {
                textView4.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f23982131099995));
            }
        } else if (i == 2) {
            TextView textView5 = (TextView) _$_findCachedViewById(R.id.AnnotationDescriptorImpl);
            if (textView5 != null) {
                textView5.setText(getContext().getString(R.string.share_activity_error_description));
            }
            TextView textView6 = (TextView) _$_findCachedViewById(R.id.AnnotationDescriptorImpl);
            if (textView6 != null) {
                textView6.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f26712131100373));
            }
        }
    }

    public final void updateCommentCount(FeedModel feedModel) {
        Intrinsics.checkNotNullParameter(feedModel, "");
        MyBillsEntityDataFactory(feedModel.BuiltInFictitiousFunctionClassFactory() + feedModel.getAuthRequestContext);
    }

    public static /* synthetic */ void $r8$lambda$Fp8XqJEYPFakF8gK9x81Qj8APfI(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "");
        function0.invoke();
    }

    /* renamed from: $r8$lambda$TopAGtK-TFTtFMhMnuAWf4VhDiw */
    public static /* synthetic */ void m2955$r8$lambda$TopAGtKTFTtFMhMnuAWf4VhDiw(ActivityFeedView activityFeedView, FeedModel feedModel, View view) {
        Intrinsics.checkNotNullParameter(activityFeedView, "");
        ReactionSectionView reactionSectionView = (ReactionSectionView) activityFeedView._$_findCachedViewById(R.id.reactionSectionView);
        if (reactionSectionView != null) {
            reactionSectionView.addNewReaction(feedModel);
        }
    }

    /* renamed from: $r8$lambda$VXzbShfvLFxuzU2eGutJia0-MoU */
    public static /* synthetic */ void m2956$r8$lambda$VXzbShfvLFxuzU2eGutJia0MoU(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "");
        function0.invoke();
    }

    public static /* synthetic */ void $r8$lambda$hkX7ZAhUd_xAR5GBd9PlDmMQF10(ActivityFeedView activityFeedView, final Function0 function0, final Function0 function02, View view) {
        Intrinsics.checkNotNullParameter(activityFeedView, "");
        Intrinsics.checkNotNullParameter(function0, "");
        Intrinsics.checkNotNullParameter(function02, "");
        Context context = activityFeedView.getContext();
        Intrinsics.checkNotNull(context);
        PopupMenu popupMenu = new PopupMenu(context, (AppCompatImageView) activityFeedView._$_findCachedViewById(R.id.ivThreeDotActivity), 8388613, 0, R.style.f53992132017893);
        new SupportMenuInflater(popupMenu.BuiltInFictitiousFunctionClassFactory).inflate(R.menu.f46572131623942, popupMenu.PlaceComponentResult);
        popupMenu.KClassImpl$Data$declaredNonStaticMembers$2 = new PopupMenu.OnMenuItemClickListener() { // from class: id.dana.social.v2.view.ActivityFeedView$$ExternalSyntheticLambda5
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public final boolean getAuthRequestContext(MenuItem menuItem) {
                boolean KClassImpl$Data$declaredNonStaticMembers$2;
                KClassImpl$Data$declaredNonStaticMembers$2 = ActivityFeedView.KClassImpl$Data$declaredNonStaticMembers$2(Function0.this, function0, menuItem);
                return KClassImpl$Data$declaredNonStaticMembers$2;
            }
        };
        if (!popupMenu.mPopup.MyBillsEntityDataFactory()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public static /* synthetic */ void $r8$lambda$xtsqt8a8cweJ0SFaXJ5VKHvwAWM(ActivityFeedView activityFeedView, ActivityWidgetModel activityWidgetModel, View view) {
        Intrinsics.checkNotNullParameter(activityFeedView, "");
        Intrinsics.checkNotNullParameter(activityWidgetModel, "");
        Function1<? super ActivityWidgetModel, Unit> function1 = activityFeedView.onActivityWidgetClicked;
        if (function1 != null) {
            function1.invoke(activityWidgetModel);
        }
    }

    public static final /* synthetic */ void access$handleOpenGallery(ActivityFeedView activityFeedView) {
        ActivityWidgetModel activityWidgetModel;
        Context context = activityFeedView.getContext();
        MerchantPhotoGalleryActivity.Companion companion = MerchantPhotoGalleryActivity.INSTANCE;
        Context context2 = activityFeedView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "");
        FeedNearbyUgcAdapter feedNearbyUgcAdapter = activityFeedView.PlaceComponentResult;
        String str = null;
        if (feedNearbyUgcAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            feedNearbyUgcAdapter = null;
        }
        List<MerchantImageModel> list = feedNearbyUgcAdapter.BuiltInFictitiousFunctionClassFactory;
        FeedModel feedModel = activityFeedView.getAuthRequestContext;
        if (feedModel != null && (activityWidgetModel = feedModel.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
            str = activityWidgetModel.lookAheadTest;
        }
        context.startActivity(MerchantPhotoGalleryActivity.Companion.PlaceComponentResult(context2, list, str != null ? str : ""));
    }

    public static final /* synthetic */ void access$handleUgcPhotoClick(ActivityFeedView activityFeedView, int i) {
        ActivityWidgetModel activityWidgetModel;
        FeedModel feedModel = activityFeedView.getAuthRequestContext;
        FeedNearbyUgcAdapter feedNearbyUgcAdapter = null;
        String str = (feedModel == null || (activityWidgetModel = feedModel.KClassImpl$Data$declaredNonStaticMembers$2) == null) ? null : activityWidgetModel.lookAheadTest;
        if (str == null) {
            str = "";
        }
        FeedNearbyUgcAdapter feedNearbyUgcAdapter2 = activityFeedView.PlaceComponentResult;
        if (feedNearbyUgcAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            feedNearbyUgcAdapter2 = null;
        }
        int size = feedNearbyUgcAdapter2.BuiltInFictitiousFunctionClassFactory.size();
        FeedNearbyUgcAdapter feedNearbyUgcAdapter3 = activityFeedView.PlaceComponentResult;
        if (feedNearbyUgcAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            feedNearbyUgcAdapter = feedNearbyUgcAdapter3;
        }
        MerchantPhotoViewerModel merchantPhotoViewerModel = new MerchantPhotoViewerModel(str, "", new MediaViewerModel(i, size, 1, 0, false, feedNearbyUgcAdapter.BuiltInFictitiousFunctionClassFactory));
        MerchantPhotoViewerDialog.Companion companion = MerchantPhotoViewerDialog.INSTANCE;
        FragmentManager supportFragmentManager = activityFeedView.getBaseActivity().getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
        MerchantPhotoViewerDialog.Companion.BuiltInFictitiousFunctionClassFactory(supportFragmentManager, merchantPhotoViewerModel);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(FeedModel p0) {
        String str = p0.moveToNextValue;
        if (str == null) {
            str = "";
        }
        setActivityDateAndResponseCount(str, p0.BuiltInFictitiousFunctionClassFactory() + p0.getAuthRequestContext);
        PlaceComponentResult(!p0.NetworkUserEntityData$$ExternalSyntheticLambda7.isEmpty());
        KClassImpl$Data$declaredNonStaticMembers$2(p0.getNetworkUserEntityData$$ExternalSyntheticLambda0());
    }
}
