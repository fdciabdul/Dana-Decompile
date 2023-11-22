package id.dana.social.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bumptech.glide.request.BaseRequestOptions;
import com.fullstory.instrumentation.InstrumentInjector;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.feeds.domain.config.model.ProfileCtaConfig;
import id.dana.feeds.ui.enums.FriendshipStatus;
import id.dana.social.model.FeedViewHolderModel;
import id.dana.social.view.ProfileCtaView;
import id.dana.utils.ImageResize;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u0004\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0015\u001a\u00020\f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u0006\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000b\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\u0010X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0014"}, d2 = {"Lid/dana/social/adapter/SocialProfileHeaderViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/social/model/FeedViewHolderModel;", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "", "Lid/dana/feeds/domain/config/model/ProfileCtaConfig;", "(Ljava/util/List;)V", "BuiltInFictitiousFunctionClassFactory", "", "PlaceComponentResult", "Z", "MyBillsEntityDataFactory", "Landroid/view/ViewGroup;", "getAuthRequestContext", "Landroid/view/ViewGroup;", "Lid/dana/social/adapter/SocialFeedClickListener;", "Lid/dana/social/adapter/SocialFeedClickListener;", "p1", "p2", "p3", "<init>", "(Landroid/view/ViewGroup;ZZLid/dana/social/adapter/SocialFeedClickListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SocialProfileHeaderViewHolder extends BaseRecyclerViewHolder<FeedViewHolderModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final SocialFeedClickListener KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final boolean MyBillsEntityDataFactory;
    public final ViewGroup getAuthRequestContext;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[FriendshipStatus.values().length];
            iArr[FriendshipStatus.NOT_AFFILIATED.ordinal()] = 1;
            iArr[FriendshipStatus.CANCELLED.ordinal()] = 2;
            iArr[FriendshipStatus.REJECTED.ordinal()] = 3;
            iArr[FriendshipStatus.PENDING.ordinal()] = 4;
            iArr[FriendshipStatus.PROCESSING.ordinal()] = 5;
            iArr[FriendshipStatus.EMPTY.ordinal()] = 6;
            iArr[FriendshipStatus.CURRENT_USER.ordinal()] = 7;
            iArr[FriendshipStatus.APPROVED.ordinal()] = 8;
            BuiltInFictitiousFunctionClassFactory = iArr;
        }
    }

    public /* synthetic */ SocialProfileHeaderViewHolder(ViewGroup viewGroup, boolean z, boolean z2, SocialFeedClickListener socialFeedClickListener, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewGroup, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? null : socialFeedClickListener);
    }

    /* JADX WARN: Removed duplicated region for block: B:155:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:164:? A[RETURN, SYNTHETIC] */
    @Override // id.dana.base.BaseRecyclerViewHolder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ void bindData(id.dana.social.model.FeedViewHolderModel r13) {
        /*
            Method dump skipped, instructions count: 916
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.adapter.SocialProfileHeaderViewHolder.bindData(java.lang.Object):void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SocialProfileHeaderViewHolder(ViewGroup viewGroup, boolean z, boolean z2, SocialFeedClickListener socialFeedClickListener) {
        super(viewGroup.getContext(), R.layout.viewholder_social_profile_header, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.getAuthRequestContext = viewGroup;
        this.MyBillsEntityDataFactory = z;
        this.BuiltInFictitiousFunctionClassFactory = z2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = socialFeedClickListener;
    }

    private final void BuiltInFictitiousFunctionClassFactory(String p0) {
        AppCompatTextView appCompatTextView;
        String str = p0;
        Unit unit = null;
        if (!(str.length() > 0)) {
            p0 = null;
        }
        if (p0 != null) {
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) this.itemView.findViewById(R.id.getTitleColor);
            if (appCompatTextView2 != null) {
                appCompatTextView2.setText(str);
            }
            AppCompatTextView appCompatTextView3 = (AppCompatTextView) this.itemView.findViewById(R.id.getTitleColor);
            if (appCompatTextView3 != null) {
                Intrinsics.checkNotNullExpressionValue(appCompatTextView3, "");
                appCompatTextView3.setVisibility(0);
            }
            unit = Unit.INSTANCE;
        }
        if (unit != null || (appCompatTextView = (AppCompatTextView) this.itemView.findViewById(R.id.getTitleColor)) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
        appCompatTextView.setVisibility(8);
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        if (p0 != null) {
            GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(p0).BuiltInFictitiousFunctionClassFactory((BaseRequestOptions<?>) ImageResize.getAuthRequestContext()).getErrorConfigVersion((int) R.drawable.ic_avatar_grey_default).PlaceComponentResult((int) R.drawable.ic_avatar_grey_default).MyBillsEntityDataFactory((ImageView) ((CircleImageView) this.itemView.findViewById(R.id.civSocialProfile)));
            return;
        }
        CircleImageView circleImageView = (CircleImageView) this.itemView.findViewById(R.id.civSocialProfile);
        if (circleImageView instanceof ImageView) {
            InstrumentInjector.Resources_setImageResource(circleImageView, R.drawable.ic_avatar_grey_default);
        } else {
            circleImageView.setImageResource(R.drawable.ic_avatar_grey_default);
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(List<ProfileCtaConfig> p0) {
        ProfileCtaView profileCtaView;
        Intrinsics.checkNotNullParameter(p0, "");
        if (!(!p0.isEmpty()) == true || (profileCtaView = (ProfileCtaView) this.itemView.findViewById(R.id.res_0x7f0a1aca_lockbasedstoragemanager_lockbasednotnulllazyvalue)) == null) {
            return;
        }
        profileCtaView.setVisibility(0);
        profileCtaView.updateCtaButtons(p0);
    }

    public static /* synthetic */ void PlaceComponentResult(SocialProfileHeaderViewHolder socialProfileHeaderViewHolder, String str) {
        Intrinsics.checkNotNullParameter(socialProfileHeaderViewHolder, "");
        Intrinsics.checkNotNullParameter(str, "");
        SocialFeedClickListener socialFeedClickListener = socialProfileHeaderViewHolder.KClassImpl$Data$declaredNonStaticMembers$2;
        if (socialFeedClickListener != null) {
            socialFeedClickListener.KClassImpl$Data$declaredNonStaticMembers$2(str);
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(SocialProfileHeaderViewHolder socialProfileHeaderViewHolder) {
        Intrinsics.checkNotNullParameter(socialProfileHeaderViewHolder, "");
        SocialFeedClickListener socialFeedClickListener = socialProfileHeaderViewHolder.KClassImpl$Data$declaredNonStaticMembers$2;
        if (socialFeedClickListener != null) {
            socialFeedClickListener.MyBillsEntityDataFactory();
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(SocialProfileHeaderViewHolder socialProfileHeaderViewHolder, String str) {
        Intrinsics.checkNotNullParameter(socialProfileHeaderViewHolder, "");
        Intrinsics.checkNotNullParameter(str, "");
        SocialFeedClickListener socialFeedClickListener = socialProfileHeaderViewHolder.KClassImpl$Data$declaredNonStaticMembers$2;
        if (socialFeedClickListener != null) {
            socialFeedClickListener.PlaceComponentResult(str);
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(SocialProfileHeaderViewHolder socialProfileHeaderViewHolder, String str) {
        Intrinsics.checkNotNullParameter(socialProfileHeaderViewHolder, "");
        Intrinsics.checkNotNullParameter(str, "");
        SocialFeedClickListener socialFeedClickListener = socialProfileHeaderViewHolder.KClassImpl$Data$declaredNonStaticMembers$2;
        if (socialFeedClickListener != null) {
            socialFeedClickListener.KClassImpl$Data$declaredNonStaticMembers$2(str);
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(SocialProfileHeaderViewHolder socialProfileHeaderViewHolder, String str, String str2) {
        Intrinsics.checkNotNullParameter(socialProfileHeaderViewHolder, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        SocialFeedClickListener socialFeedClickListener = socialProfileHeaderViewHolder.KClassImpl$Data$declaredNonStaticMembers$2;
        if (socialFeedClickListener != null) {
            socialFeedClickListener.getAuthRequestContext(str, str2);
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(SocialProfileHeaderViewHolder socialProfileHeaderViewHolder) {
        Intrinsics.checkNotNullParameter(socialProfileHeaderViewHolder, "");
        SocialFeedClickListener socialFeedClickListener = socialProfileHeaderViewHolder.KClassImpl$Data$declaredNonStaticMembers$2;
        if (socialFeedClickListener != null) {
            socialFeedClickListener.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(SocialProfileHeaderViewHolder socialProfileHeaderViewHolder, String str, String str2) {
        Intrinsics.checkNotNullParameter(socialProfileHeaderViewHolder, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        SocialFeedClickListener socialFeedClickListener = socialProfileHeaderViewHolder.KClassImpl$Data$declaredNonStaticMembers$2;
        if (socialFeedClickListener != null) {
            socialFeedClickListener.PlaceComponentResult(str, str2);
        }
    }
}
