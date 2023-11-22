package id.dana.social.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.databinding.ViewProfileCtaBinding;
import id.dana.feeds.domain.config.model.ProfileCtaConfig;
import id.dana.feeds.ui.model.RelationshipItemModel;
import id.dana.social.adapter.ProfileCtaAdapter;
import id.dana.social.adapter.SocialFeedClickListener;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010&\u001a\u00020%\u0012\b\b\u0002\u0010'\u001a\u00020%¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0013\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\u00158\u0007@\u0007X\u0086.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f"}, d2 = {"Lid/dana/social/view/ProfileCtaView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ViewProfileCtaBinding;", "inflateViewBinding", "()Lid/dana/databinding/ViewProfileCtaBinding;", "Lid/dana/social/adapter/SocialFeedClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "setListener", "(Lid/dana/social/adapter/SocialFeedClickListener;)V", "Lid/dana/feeds/ui/model/RelationshipItemModel;", "profile", "setProfile", "(Lid/dana/feeds/ui/model/RelationshipItemModel;)V", "setup", "()V", "", "Lid/dana/feeds/domain/config/model/ProfileCtaConfig;", "ctaButtons", "updateCtaButtons", "(Ljava/util/List;)V", "Lid/dana/social/adapter/ProfileCtaAdapter;", "ctaAdapter", "Lid/dana/social/adapter/ProfileCtaAdapter;", "getCtaAdapter", "()Lid/dana/social/adapter/ProfileCtaAdapter;", "setCtaAdapter", "(Lid/dana/social/adapter/ProfileCtaAdapter;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/feeds/ui/model/RelationshipItemModel;", "MyBillsEntityDataFactory", "Lid/dana/social/adapter/SocialFeedClickListener;", "PlaceComponentResult", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProfileCtaView extends BaseViewBindingRichView<ViewProfileCtaBinding> {
    private RelationshipItemModel KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private SocialFeedClickListener PlaceComponentResult;
    public Map<Integer, View> _$_findViewCache;
    public ProfileCtaAdapter ctaAdapter;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProfileCtaView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProfileCtaView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProfileCtaView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileCtaView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ ProfileCtaView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    @JvmName(name = "getCtaAdapter")
    public final ProfileCtaAdapter getCtaAdapter() {
        ProfileCtaAdapter profileCtaAdapter = this.ctaAdapter;
        if (profileCtaAdapter != null) {
            return profileCtaAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setCtaAdapter")
    public final void setCtaAdapter(ProfileCtaAdapter profileCtaAdapter) {
        Intrinsics.checkNotNullParameter(profileCtaAdapter, "");
        this.ctaAdapter = profileCtaAdapter;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewProfileCtaBinding inflateViewBinding() {
        ViewProfileCtaBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewProfileCtaBinding.KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [id.dana.feeds.ui.model.RelationshipItemModel, kotlin.jvm.internal.DefaultConstructorMarker] */
    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        super.setup();
        ?? r1 = 0;
        setCtaAdapter(new ProfileCtaAdapter(r1, 1, r1));
        RecyclerView recyclerView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        recyclerView.setAdapter(getCtaAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        getCtaAdapter().setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.social.view.ProfileCtaView$$ExternalSyntheticLambda0
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                ProfileCtaView.m2965$r8$lambda$oZWbKnIZmd8qzqy_O66HZ6JLpA(ProfileCtaView.this, i);
            }
        });
    }

    public final void updateCtaButtons(List<ProfileCtaConfig> ctaButtons) {
        Intrinsics.checkNotNullParameter(ctaButtons, "");
        getCtaAdapter().setItems(ctaButtons);
        if (ctaButtons.size() > 1) {
            RecyclerView recyclerView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
            recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), ctaButtons.size(), (byte) 0));
        }
    }

    public final void setProfile(RelationshipItemModel profile) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = profile;
        ProfileCtaAdapter ctaAdapter = getCtaAdapter();
        ctaAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = profile;
        if (ctaAdapter.getPlaceComponentResult() == 1) {
            ctaAdapter.notifyItemChanged(0);
        }
    }

    public final void setListener(SocialFeedClickListener r1) {
        this.PlaceComponentResult = r1;
    }

    /* renamed from: $r8$lambda$oZWbKnIZmd8qzqy_O-66HZ6JLpA */
    public static /* synthetic */ void m2965$r8$lambda$oZWbKnIZmd8qzqy_O66HZ6JLpA(ProfileCtaView profileCtaView, int i) {
        Intrinsics.checkNotNullParameter(profileCtaView, "");
        SocialFeedClickListener socialFeedClickListener = profileCtaView.PlaceComponentResult;
        if (socialFeedClickListener != null) {
            ProfileCtaConfig item = profileCtaView.getCtaAdapter().getItem(i);
            Intrinsics.checkNotNullExpressionValue(item, "");
            ProfileCtaConfig profileCtaConfig = item;
            RelationshipItemModel relationshipItemModel = profileCtaView.KClassImpl$Data$declaredNonStaticMembers$2;
            String str = relationshipItemModel != null ? relationshipItemModel.moveToNextValue : null;
            if (str == null) {
                str = "";
            }
            RelationshipItemModel relationshipItemModel2 = profileCtaView.KClassImpl$Data$declaredNonStaticMembers$2;
            String str2 = relationshipItemModel2 != null ? relationshipItemModel2.GetContactSyncConfig : null;
            socialFeedClickListener.KClassImpl$Data$declaredNonStaticMembers$2(profileCtaConfig, str, str2 != null ? str2 : "");
        }
    }
}
