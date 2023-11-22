package id.dana.userpersonalization.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.explore.domain.userpersonalization.model.UserPersonalizationModel;
import id.dana.userpersonalization.adapter.UserPersonalizationViewAdapter;
import id.dana.userpersonalization.view.UserPersonalizationListView;
import id.dana.userpersonalization.view.UserPersonalizationView;
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

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001*B%\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010'\u001a\u00020\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J\u001b\u0010\f\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u0007J\r\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0007R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b!\u0010\""}, d2 = {"Lid/dana/userpersonalization/view/UserPersonalizationView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "", "hideLoadingState", "()V", "setSelectedUserPersonalizationList", "", "Lid/dana/explore/domain/userpersonalization/model/UserPersonalizationModel;", "userPersonalizationList", "setUserPersonalizationList", "(Ljava/util/List;)V", "setup", "showLoadingState", "Lid/dana/userpersonalization/view/UserPersonalizationView$UserPersonalizationViewListener;", "PlaceComponentResult", "Lid/dana/userpersonalization/view/UserPersonalizationView$UserPersonalizationViewListener;", "getListener", "()Lid/dana/userpersonalization/view/UserPersonalizationView$UserPersonalizationViewListener;", "setListener", "(Lid/dana/userpersonalization/view/UserPersonalizationView$UserPersonalizationViewListener;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lid/dana/userpersonalization/view/UserPersonalizationListView$UserPersonalizationItemListener;", "MyBillsEntityDataFactory", "Lid/dana/userpersonalization/view/UserPersonalizationListView$UserPersonalizationItemListener;", "getUserPersonalizationItemListener", "()Lid/dana/userpersonalization/view/UserPersonalizationListView$UserPersonalizationItemListener;", "setUserPersonalizationItemListener", "(Lid/dana/userpersonalization/view/UserPersonalizationListView$UserPersonalizationItemListener;)V", "userPersonalizationItemListener", "Lid/dana/userpersonalization/adapter/UserPersonalizationViewAdapter;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/userpersonalization/adapter/UserPersonalizationViewAdapter;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "UserPersonalizationViewListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UserPersonalizationView extends BaseRichView {
    private UserPersonalizationViewAdapter KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private UserPersonalizationListView.UserPersonalizationItemListener userPersonalizationItemListener;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private UserPersonalizationViewListener com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs.LISTENER java.lang.String;
    public Map<Integer, View> _$_findViewCache;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/userpersonalization/view/UserPersonalizationView$UserPersonalizationViewListener;", "", "", "Lid/dana/explore/domain/userpersonalization/model/UserPersonalizationModel;", "preferences", "", "onGetPreferences", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface UserPersonalizationViewListener {
        void onGetPreferences(List<UserPersonalizationModel> preferences);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UserPersonalizationView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UserPersonalizationView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_user_personalization;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserPersonalizationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ UserPersonalizationView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @JvmName(name = "getListener")
    /* renamed from: getListener  reason: from getter */
    public final UserPersonalizationViewListener getCom.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs.LISTENER java.lang.String() {
        return this.com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs.LISTENER java.lang.String;
    }

    @JvmName(name = "setListener")
    public final void setListener(UserPersonalizationViewListener userPersonalizationViewListener) {
        this.com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs.LISTENER java.lang.String = userPersonalizationViewListener;
    }

    @JvmName(name = "getUserPersonalizationItemListener")
    public final UserPersonalizationListView.UserPersonalizationItemListener getUserPersonalizationItemListener() {
        return this.userPersonalizationItemListener;
    }

    @JvmName(name = "setUserPersonalizationItemListener")
    public final void setUserPersonalizationItemListener(UserPersonalizationListView.UserPersonalizationItemListener userPersonalizationItemListener) {
        this.userPersonalizationItemListener = userPersonalizationItemListener;
    }

    public final void setUserPersonalizationList(final List<UserPersonalizationModel> userPersonalizationList) {
        Intrinsics.checkNotNullParameter(userPersonalizationList, "");
        Function1<UserPersonalizationViewAdapter.UserPersonalizationListViewHolder, Unit> function1 = new Function1<UserPersonalizationViewAdapter.UserPersonalizationListViewHolder, Unit>() { // from class: id.dana.userpersonalization.view.UserPersonalizationView$setUserPersonalizationList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(UserPersonalizationViewAdapter.UserPersonalizationListViewHolder userPersonalizationListViewHolder) {
                invoke2(userPersonalizationListViewHolder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(UserPersonalizationViewAdapter.UserPersonalizationListViewHolder userPersonalizationListViewHolder) {
                Intrinsics.checkNotNullParameter(userPersonalizationListViewHolder, "");
                List<UserPersonalizationModel> list = userPersonalizationList;
                Intrinsics.checkNotNullParameter(list, "");
                UserPersonalizationListView userPersonalizationListView = (UserPersonalizationListView) userPersonalizationListViewHolder.itemView.findViewById(R.id.viewUserPersonalizationList);
                if (userPersonalizationListView != null) {
                    userPersonalizationListView.setUserPersonalizationListItem(list);
                }
            }
        };
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rvUserPersonalizationView);
        if (recyclerView != null) {
            recyclerView.post(new UserPersonalizationView$$ExternalSyntheticLambda0(this, function1));
        }
    }

    public final void setSelectedUserPersonalizationList() {
        Function1<UserPersonalizationViewAdapter.UserPersonalizationListViewHolder, Unit> function1 = new Function1<UserPersonalizationViewAdapter.UserPersonalizationListViewHolder, Unit>() { // from class: id.dana.userpersonalization.view.UserPersonalizationView$setSelectedUserPersonalizationList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(UserPersonalizationViewAdapter.UserPersonalizationListViewHolder userPersonalizationListViewHolder) {
                invoke2(userPersonalizationListViewHolder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(UserPersonalizationViewAdapter.UserPersonalizationListViewHolder userPersonalizationListViewHolder) {
                Intrinsics.checkNotNullParameter(userPersonalizationListViewHolder, "");
                UserPersonalizationView.UserPersonalizationViewListener userPersonalizationViewListener = UserPersonalizationView.this.getCom.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs.LISTENER java.lang.String();
                if (userPersonalizationViewListener != null) {
                    UserPersonalizationListView userPersonalizationListView = (UserPersonalizationListView) userPersonalizationListViewHolder.itemView.findViewById(R.id.viewUserPersonalizationList);
                    List<UserPersonalizationModel> selectedPreferences = userPersonalizationListView != null ? userPersonalizationListView.getSelectedPreferences() : null;
                    if (selectedPreferences == null) {
                        selectedPreferences = CollectionsKt.emptyList();
                    }
                    userPersonalizationViewListener.onGetPreferences(selectedPreferences);
                }
            }
        };
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rvUserPersonalizationView);
        if (recyclerView != null) {
            recyclerView.post(new UserPersonalizationView$$ExternalSyntheticLambda0(this, function1));
        }
    }

    public final void showLoadingState() {
        UserPersonalizationView$showLoadingState$1 userPersonalizationView$showLoadingState$1 = new Function1<UserPersonalizationViewAdapter.UserPersonalizationListViewHolder, Unit>() { // from class: id.dana.userpersonalization.view.UserPersonalizationView$showLoadingState$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(UserPersonalizationViewAdapter.UserPersonalizationListViewHolder userPersonalizationListViewHolder) {
                invoke2(userPersonalizationListViewHolder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(UserPersonalizationViewAdapter.UserPersonalizationListViewHolder userPersonalizationListViewHolder) {
                Intrinsics.checkNotNullParameter(userPersonalizationListViewHolder, "");
                UserPersonalizationListView userPersonalizationListView = (UserPersonalizationListView) userPersonalizationListViewHolder.itemView.findViewById(R.id.viewUserPersonalizationList);
                if (userPersonalizationListView != null) {
                    userPersonalizationListView.showSkeleton();
                }
            }
        };
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rvUserPersonalizationView);
        if (recyclerView != null) {
            recyclerView.post(new UserPersonalizationView$$ExternalSyntheticLambda0(this, userPersonalizationView$showLoadingState$1));
        }
    }

    public final void hideLoadingState() {
        UserPersonalizationView$hideLoadingState$1 userPersonalizationView$hideLoadingState$1 = new Function1<UserPersonalizationViewAdapter.UserPersonalizationListViewHolder, Unit>() { // from class: id.dana.userpersonalization.view.UserPersonalizationView$hideLoadingState$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(UserPersonalizationViewAdapter.UserPersonalizationListViewHolder userPersonalizationListViewHolder) {
                invoke2(userPersonalizationListViewHolder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(UserPersonalizationViewAdapter.UserPersonalizationListViewHolder userPersonalizationListViewHolder) {
                Intrinsics.checkNotNullParameter(userPersonalizationListViewHolder, "");
                UserPersonalizationListView userPersonalizationListView = (UserPersonalizationListView) userPersonalizationListViewHolder.itemView.findViewById(R.id.viewUserPersonalizationList);
                if (userPersonalizationListView != null) {
                    userPersonalizationListView.hideSkeleton();
                }
            }
        };
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rvUserPersonalizationView);
        if (recyclerView != null) {
            recyclerView.post(new UserPersonalizationView$$ExternalSyntheticLambda0(this, userPersonalizationView$hideLoadingState$1));
        }
    }

    public static /* synthetic */ void $r8$lambda$ig06l5pP40xKB0dA24vPBhVgYqo(UserPersonalizationView userPersonalizationView, Function1 function1) {
        Intrinsics.checkNotNullParameter(userPersonalizationView, "");
        Intrinsics.checkNotNullParameter(function1, "");
        RecyclerView recyclerView = (RecyclerView) userPersonalizationView._$_findCachedViewById(R.id.rvUserPersonalizationView);
        UserPersonalizationViewAdapter.UserPersonalizationListViewHolder userPersonalizationListViewHolder = (UserPersonalizationViewAdapter.UserPersonalizationListViewHolder) (recyclerView != null ? recyclerView.findViewHolderForAdapterPosition(1) : null);
        if (userPersonalizationListViewHolder != null) {
            function1.invoke(userPersonalizationListViewHolder);
        }
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rvUserPersonalizationView);
        if (recyclerView != null) {
            UserPersonalizationViewAdapter userPersonalizationViewAdapter = new UserPersonalizationViewAdapter();
            userPersonalizationViewAdapter.PlaceComponentResult = new UserPersonalizationListView.UserPersonalizationItemListener() { // from class: id.dana.userpersonalization.view.UserPersonalizationView$setupUserPersonalizationRecyclerView$1$1$1
                @Override // id.dana.userpersonalization.view.UserPersonalizationListView.UserPersonalizationItemListener
                public final void BuiltInFictitiousFunctionClassFactory() {
                    UserPersonalizationListView.UserPersonalizationItemListener userPersonalizationItemListener = UserPersonalizationView.this.getUserPersonalizationItemListener();
                    if (userPersonalizationItemListener != null) {
                        userPersonalizationItemListener.BuiltInFictitiousFunctionClassFactory();
                    }
                }

                @Override // id.dana.userpersonalization.view.UserPersonalizationListView.UserPersonalizationItemListener
                public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
                    UserPersonalizationListView.UserPersonalizationItemListener userPersonalizationItemListener = UserPersonalizationView.this.getUserPersonalizationItemListener();
                    if (userPersonalizationItemListener != null) {
                        userPersonalizationItemListener.KClassImpl$Data$declaredNonStaticMembers$2(p0);
                    }
                }
            };
            this.KClassImpl$Data$declaredNonStaticMembers$2 = userPersonalizationViewAdapter;
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            UserPersonalizationViewAdapter userPersonalizationViewAdapter2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (userPersonalizationViewAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                userPersonalizationViewAdapter2 = null;
            }
            recyclerView.setAdapter(userPersonalizationViewAdapter2);
        }
    }
}
