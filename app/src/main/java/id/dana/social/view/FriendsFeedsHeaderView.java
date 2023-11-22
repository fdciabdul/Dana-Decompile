package id.dana.social.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.databinding.ViewFriendsFeedsHeaderBinding;
import id.dana.feeds.ui.model.FriendModel;
import id.dana.feeds.ui.model.RelationshipItemModel;
import id.dana.social.ReciprocalBottomSheetDialog;
import id.dana.social.RelationshipBottomSheetDialog;
import id.dana.social.adapter.friendsheader.FriendsFeedsHeaderAdapter;
import id.dana.social.view.activity.SocialProfileActivity;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010&\u001a\u00020%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'¢\u0006\u0004\b)\u0010*J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R5\u0010\u0019\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0017¢\u0006\u0002\b\u0018\u0012\u0004\u0012\u00020\r0\u00168\u0007@\u0007X\u0086.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010$\u001a\u00020\u00178\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#"}, d2 = {"Lid/dana/social/view/FriendsFeedsHeaderView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ViewFriendsFeedsHeaderBinding;", "", "getLayout", "()I", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ViewFriendsFeedsHeaderBinding;", "", "Lid/dana/feeds/ui/model/FriendModel;", FirebaseAnalytics.Param.ITEMS, "", "setItems", "(Ljava/util/List;)V", "setup", "()V", "Lid/dana/social/adapter/friendsheader/FriendsFeedsHeaderAdapter;", "getAuthRequestContext", "Lid/dana/social/adapter/friendsheader/FriendsFeedsHeaderAdapter;", "PlaceComponentResult", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "setEnableRefresh", "Lkotlin/jvm/functions/Function1;", "getSetEnableRefresh", "()Lkotlin/jvm/functions/Function1;", "setSetEnableRefresh", "(Lkotlin/jvm/functions/Function1;)V", "Z", "getShowReciprocalRelationship", "()Z", "setShowReciprocalRelationship", "(Z)V", "showReciprocalRelationship", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FriendsFeedsHeaderView extends ViewBindingRichView<ViewFriendsFeedsHeaderBinding> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean showReciprocalRelationship;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private FriendsFeedsHeaderAdapter PlaceComponentResult;
    public Function1<? super Boolean, Unit> setEnableRefresh;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.util.AttributeSet, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public FriendsFeedsHeaderView(android.content.Context r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            r1 = 2
            r2.<init>(r3, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.view.FriendsFeedsHeaderView.<init>(android.content.Context):void");
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
        return R.layout.view_friends_feeds_header;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendsFeedsHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ FriendsFeedsHeaderView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    @JvmName(name = "getSetEnableRefresh")
    public final Function1<Boolean, Unit> getSetEnableRefresh() {
        Function1 function1 = this.setEnableRefresh;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSetEnableRefresh")
    public final void setSetEnableRefresh(Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        this.setEnableRefresh = function1;
    }

    @JvmName(name = "getShowReciprocalRelationship")
    public final boolean getShowReciprocalRelationship() {
        return this.showReciprocalRelationship;
    }

    @JvmName(name = "setShowReciprocalRelationship")
    public final void setShowReciprocalRelationship(boolean z) {
        this.showReciprocalRelationship = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final ViewFriendsFeedsHeaderBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewFriendsFeedsHeaderBinding BuiltInFictitiousFunctionClassFactory = ViewFriendsFeedsHeaderBinding.BuiltInFictitiousFunctionClassFactory(view);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    public final void setItems(List<FriendModel> items) {
        Intrinsics.checkNotNullParameter(items, "");
        FriendsFeedsHeaderAdapter friendsFeedsHeaderAdapter = this.PlaceComponentResult;
        if (friendsFeedsHeaderAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            friendsFeedsHeaderAdapter = null;
        }
        friendsFeedsHeaderAdapter.setItems(items);
    }

    public static /* synthetic */ void $r8$lambda$9iOIklBi8iLhqM1zT_Yzlh69Xxw(FriendsFeedsHeaderView friendsFeedsHeaderView, int i) {
        RelationshipBottomSheetDialog relationshipBottomSheetDialog;
        FragmentManager supportFragmentManager;
        Intrinsics.checkNotNullParameter(friendsFeedsHeaderView, "");
        if (friendsFeedsHeaderView.showReciprocalRelationship) {
            relationshipBottomSheetDialog = new ReciprocalBottomSheetDialog();
        } else {
            relationshipBottomSheetDialog = new RelationshipBottomSheetDialog();
        }
        BaseActivity baseActivity = friendsFeedsHeaderView.getBaseActivity();
        if (baseActivity == null || (supportFragmentManager = baseActivity.getSupportFragmentManager()) == null) {
            return;
        }
        relationshipBottomSheetDialog.show(supportFragmentManager, "");
    }

    public static final /* synthetic */ void access$openProfileActivity(FriendsFeedsHeaderView friendsFeedsHeaderView, RelationshipItemModel relationshipItemModel) {
        SocialProfileActivity.Companion companion = SocialProfileActivity.INSTANCE;
        Context context = friendsFeedsHeaderView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        SocialProfileActivity.Companion.KClassImpl$Data$declaredNonStaticMembers$2(context, relationshipItemModel);
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        this.PlaceComponentResult = new FriendsFeedsHeaderAdapter(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.social.view.FriendsFeedsHeaderView$$ExternalSyntheticLambda0
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                FriendsFeedsHeaderView.$r8$lambda$9iOIklBi8iLhqM1zT_Yzlh69Xxw(FriendsFeedsHeaderView.this, i);
            }
        }, new FriendsFeedsHeaderView$createFriendsFeeds$2(this));
        RecyclerView recyclerView = getBinding().BuiltInFictitiousFunctionClassFactory;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        FriendsFeedsHeaderAdapter friendsFeedsHeaderAdapter = this.PlaceComponentResult;
        if (friendsFeedsHeaderAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            friendsFeedsHeaderAdapter = null;
        }
        recyclerView.setAdapter(friendsFeedsHeaderAdapter);
        getBinding().BuiltInFictitiousFunctionClassFactory.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() { // from class: id.dana.social.view.FriendsFeedsHeaderView$createFriendsFeeds$4
            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public final void BuiltInFictitiousFunctionClassFactory(RecyclerView p0, MotionEvent p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
            public final boolean MyBillsEntityDataFactory(RecyclerView p0, MotionEvent p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                Function1<Boolean, Unit> setEnableRefresh = FriendsFeedsHeaderView.this.getSetEnableRefresh();
                boolean z = true;
                if (p1.getAction() != 1 && p1.getAction() != 3) {
                    z = false;
                }
                setEnableRefresh.invoke(Boolean.valueOf(z));
                return false;
            }
        });
    }
}
