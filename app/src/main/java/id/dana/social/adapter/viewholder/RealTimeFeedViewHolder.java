package id.dana.social.adapter.viewholder;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.airbnb.lottie.LottieAnimationView;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.social.adapter.SocialFeedClickListener;
import id.dana.social.extension.SocialFeedExtKt;
import id.dana.social.model.SocialFeedModel;
import id.dana.social.utils.FeedRegexData;
import id.dana.social.utils.RegexUtils;
import id.dana.utils.DateTimeUtil;
import id.dana.utils.LocaleUtil;
import io.reactivex.disposables.Disposable;
import java.util.Date;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0004\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\nR\u0016\u0010\u0007\u001a\u00020\f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/social/adapter/viewholder/RealTimeFeedViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/social/model/SocialFeedModel;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "", "MyBillsEntityDataFactory", "Z", "Lid/dana/social/adapter/SocialFeedClickListener;", "Lid/dana/social/adapter/SocialFeedClickListener;", "getAuthRequestContext", "Lio/reactivex/disposables/Disposable;", "PlaceComponentResult", "Lio/reactivex/disposables/Disposable;", "p0", "Landroid/content/Context;", "p1", "Landroid/view/ViewGroup;", "p2", "<init>", "(Lid/dana/social/adapter/SocialFeedClickListener;Landroid/content/Context;Landroid/view/ViewGroup;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RealTimeFeedViewHolder extends BaseRecyclerViewHolder<SocialFeedModel> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final SocialFeedClickListener getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public Disposable MyBillsEntityDataFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(SocialFeedModel socialFeedModel) {
        String BuiltInFictitiousFunctionClassFactory;
        SpannableString spannableString;
        HashMap<String, String> hashMap;
        SocialFeedModel socialFeedModel2 = socialFeedModel;
        Intrinsics.checkNotNullParameter(socialFeedModel2, "");
        super.bindData(socialFeedModel2);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        View view = this.itemView;
        HashMap<String, String> hashMap2 = socialFeedModel2.PlaceComponentResult;
        String displayName = hashMap2 != null ? ExtendInfoUtilKt.getDisplayName(hashMap2) : null;
        if (!(displayName == null || displayName.length() == 0) && (hashMap = socialFeedModel2.PlaceComponentResult) != null) {
            ExtendInfoUtilKt.setDisplayName(hashMap, CollectionsKt.joinToString$default(CollectionsKt.take(StringsKt.split$default((CharSequence) ExtendInfoUtilKt.getDisplayName(socialFeedModel2.PlaceComponentResult), new String[]{" "}, false, 0, 6, (Object) null), 2), " ", null, null, 0, null, null, 62, null));
        }
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        FeedRegexData KClassImpl$Data$declaredNonStaticMembers$2 = socialFeedModel2.KClassImpl$Data$declaredNonStaticMembers$2(context, this.getAuthRequestContext);
        TextView textView = (TextView) this.itemView.findViewById(R.id.tv_feed_content);
        if (textView != null) {
            HashMap<String, String> hashMap3 = KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult;
            if (!(hashMap3 == null || hashMap3.isEmpty())) {
                RegexUtils.Companion companion = RegexUtils.INSTANCE;
                spannableString = RegexUtils.Companion.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, Integer.valueOf((int) R.font.f34282131296266), true, false, 8);
            } else {
                spannableString = new SpannableString(KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion);
            }
            textView.setText(spannableString);
        }
        TextView textView2 = (TextView) view.findViewById(R.id.tv_time_stamp);
        if (textView2 != null) {
            Long l = socialFeedModel2.BuiltInFictitiousFunctionClassFactory;
            long longValue = l != null ? l.longValue() : 0L;
            if (DateTimeUtil.MyBillsEntityDataFactory(new Date(), new Date(longValue)) > 0) {
                BuiltInFictitiousFunctionClassFactory = DateTimeUtil.BuiltInFictitiousFunctionClassFactory("dd/MM", LocaleUtil.getAuthRequestContext(), longValue);
                Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
            } else {
                BuiltInFictitiousFunctionClassFactory = DateTimeUtil.BuiltInFictitiousFunctionClassFactory(new Date(longValue));
                Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
            }
            textView2.setText(BuiltInFictitiousFunctionClassFactory);
        }
        CircleImageView circleImageView = (CircleImageView) view.findViewById(R.id.UCropFragment);
        if (circleImageView != null) {
            Intrinsics.checkNotNullExpressionValue(circleImageView, "");
            CircleImageView circleImageView2 = circleImageView;
            HashMap<String, String> hashMap4 = socialFeedModel2.PlaceComponentResult;
            String profileAvatar = hashMap4 != null ? ExtendInfoUtilKt.getProfileAvatar(hashMap4) : null;
            SocialFeedExtKt.BuiltInFictitiousFunctionClassFactory(circleImageView2, profileAvatar != null ? profileAvatar : "", R.drawable.ic_avatar_grey_default);
        }
        setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.social.adapter.viewholder.RealTimeFeedViewHolder$$ExternalSyntheticLambda1
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                RealTimeFeedViewHolder.PlaceComponentResult(RealTimeFeedViewHolder.this);
            }
        });
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealTimeFeedViewHolder(SocialFeedClickListener socialFeedClickListener, Context context, ViewGroup viewGroup) {
        super(context, R.layout.real_time_feed_viewholder, viewGroup);
        Intrinsics.checkNotNullParameter(socialFeedClickListener, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.getAuthRequestContext = socialFeedClickListener;
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        ViewSwitcher viewSwitcher;
        View view = this.itemView;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) view.findViewById(R.id.res_0x7f0a0f22_daggermybillscomponent_mybillscomponentimpl_providefamilyaccountrepositoryprovider);
        if (lottieAnimationView != null) {
            lottieAnimationView.pauseAnimation();
        }
        ViewSwitcher viewSwitcher2 = (ViewSwitcher) view.findViewById(R.id.button_view_switch);
        if (!Intrinsics.areEqual(viewSwitcher2 != null ? viewSwitcher2.getCurrentView() : null, (TextView) view.findViewById(R.id.tv_time_stamp)) && (viewSwitcher = (ViewSwitcher) view.findViewById(R.id.button_view_switch)) != null) {
            viewSwitcher.showNext();
        }
        CircleImageView circleImageView = (CircleImageView) view.findViewById(R.id.UCropFragment);
        if (circleImageView != null) {
            circleImageView.setBorderColor(0);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/social/adapter/viewholder/RealTimeFeedViewHolder$Companion;", "", "Landroid/content/Context;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;)I", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static int KClassImpl$Data$declaredNonStaticMembers$2(Context p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            return p0.getResources().getDimensionPixelSize(R.dimen.f33632131166027) + (p0.getResources().getDimensionPixelSize(R.dimen.f33642131166028) * 2);
        }
    }

    public static /* synthetic */ void PlaceComponentResult(RealTimeFeedViewHolder realTimeFeedViewHolder) {
        Intrinsics.checkNotNullParameter(realTimeFeedViewHolder, "");
        realTimeFeedViewHolder.getAuthRequestContext.MyBillsEntityDataFactory(realTimeFeedViewHolder.getAbsoluteAdapterPosition());
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(RealTimeFeedViewHolder realTimeFeedViewHolder) {
        Intrinsics.checkNotNullParameter(realTimeFeedViewHolder, "");
        Disposable disposable = realTimeFeedViewHolder.MyBillsEntityDataFactory;
        if (disposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            disposable = null;
        }
        disposable.dispose();
        realTimeFeedViewHolder.KClassImpl$Data$declaredNonStaticMembers$2();
    }
}
