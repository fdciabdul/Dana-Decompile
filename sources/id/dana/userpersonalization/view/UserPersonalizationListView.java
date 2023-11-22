package id.dana.userpersonalization.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.base.BaseRichView;
import id.dana.base.ThrottledOnExecuteAction;
import id.dana.explore.domain.userpersonalization.model.UserPersonalizationModel;
import id.dana.userpersonalization.adapter.UserPersonalizationAdapter;
import id.dana.userpersonalization.model.UserPersonalizationWrapper;
import id.dana.userpersonalization.view.UserPersonalizationListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 /2\u00020\u0001:\u0002/0B%\u0012\u0006\u0010)\u001a\u00020(\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*\u0012\b\b\u0002\u0010,\u001a\u00020\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0011\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0007J\r\u0010\u0014\u001a\u00020\u0005¢\u0006\u0004\b\u0014\u0010\u0007R(\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u00158\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u0012R\u0013\u0010\u000b\u001a\u00020\u001cX\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001d\u001a\u00020\u001f8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u000b\u0010 R$\u0010'\u001a\u0004\u0018\u00010!8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&"}, d2 = {"Lid/dana/userpersonalization/view/UserPersonalizationListView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "", "hideSkeleton", "()V", "Lid/dana/explore/domain/userpersonalization/model/UserPersonalizationModel;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/explore/domain/userpersonalization/model/UserPersonalizationModel;)Z", "MyBillsEntityDataFactory", "()Z", "", "userPersonalizationList", "setUserPersonalizationListItem", "(Ljava/util/List;)V", "setup", "showSkeleton", "", "getAuthRequestContext", "Ljava/util/List;", "getSelectedPreferences", "()Ljava/util/List;", "setSelectedPreferences", "selectedPreferences", "Lid/dana/base/ThrottledOnExecuteAction;", "PlaceComponentResult", "Lkotlin/Lazy;", "Lid/dana/userpersonalization/adapter/UserPersonalizationAdapter;", "Lid/dana/userpersonalization/adapter/UserPersonalizationAdapter;", "Lid/dana/userpersonalization/view/UserPersonalizationListView$UserPersonalizationItemListener;", "Lid/dana/userpersonalization/view/UserPersonalizationListView$UserPersonalizationItemListener;", "getUserPersonalizationItemListener", "()Lid/dana/userpersonalization/view/UserPersonalizationListView$UserPersonalizationItemListener;", "setUserPersonalizationItemListener", "(Lid/dana/userpersonalization/view/UserPersonalizationListView$UserPersonalizationItemListener;)V", "userPersonalizationItemListener", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "UserPersonalizationItemListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UserPersonalizationListView extends BaseRichView {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private UserPersonalizationAdapter PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private UserPersonalizationItemListener userPersonalizationItemListener;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private List<UserPersonalizationModel> selectedPreferences;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/userpersonalization/view/UserPersonalizationListView$UserPersonalizationItemListener;", "", "", "BuiltInFictitiousFunctionClassFactory", "()V", "", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface UserPersonalizationItemListener {
        void BuiltInFictitiousFunctionClassFactory();

        void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UserPersonalizationListView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UserPersonalizationListView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_user_personalization_list_view;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserPersonalizationListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<ThrottledOnExecuteAction>() { // from class: id.dana.userpersonalization.view.UserPersonalizationListView$throttledOnExecuteAction$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ThrottledOnExecuteAction invoke() {
                return new ThrottledOnExecuteAction();
            }
        });
        this.selectedPreferences = new ArrayList();
    }

    public /* synthetic */ UserPersonalizationListView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @JvmName(name = "getUserPersonalizationItemListener")
    public final UserPersonalizationItemListener getUserPersonalizationItemListener() {
        return this.userPersonalizationItemListener;
    }

    @JvmName(name = "setUserPersonalizationItemListener")
    public final void setUserPersonalizationItemListener(UserPersonalizationItemListener userPersonalizationItemListener) {
        this.userPersonalizationItemListener = userPersonalizationItemListener;
    }

    @JvmName(name = "getSelectedPreferences")
    public final List<UserPersonalizationModel> getSelectedPreferences() {
        return this.selectedPreferences;
    }

    @JvmName(name = "setSelectedPreferences")
    public final void setSelectedPreferences(List<UserPersonalizationModel> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.selectedPreferences = list;
    }

    public final void setUserPersonalizationListItem(List<UserPersonalizationModel> userPersonalizationList) {
        Intrinsics.checkNotNullParameter(userPersonalizationList, "");
        if (userPersonalizationList.isEmpty()) {
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rvUserPersonalization);
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = userPersonalizationList.iterator();
        while (it.hasNext()) {
            arrayList.add(new UserPersonalizationWrapper((UserPersonalizationModel) it.next(), 1));
        }
        UserPersonalizationAdapter userPersonalizationAdapter = this.PlaceComponentResult;
        if (userPersonalizationAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            userPersonalizationAdapter = null;
        }
        userPersonalizationAdapter.setItems(arrayList);
    }

    public final void showSkeleton() {
        UserPersonalizationAdapter userPersonalizationAdapter = this.PlaceComponentResult;
        if (userPersonalizationAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            userPersonalizationAdapter = null;
        }
        userPersonalizationAdapter.setItems(CollectionsKt.mutableListOf(new UserPersonalizationWrapper(new UserPersonalizationModel(null, null, null, null, null, 31, null), 0)));
    }

    public final void hideSkeleton() {
        UserPersonalizationAdapter userPersonalizationAdapter = this.PlaceComponentResult;
        if (userPersonalizationAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            userPersonalizationAdapter = null;
        }
        userPersonalizationAdapter.getItems().clear();
    }

    private final boolean MyBillsEntityDataFactory() {
        return this.selectedPreferences.size() == 3;
    }

    private final boolean KClassImpl$Data$declaredNonStaticMembers$2(UserPersonalizationModel p0) {
        return this.selectedPreferences.contains(p0);
    }

    /* renamed from: $r8$lambda$DVtWA39ON6IOSMKN7p7z-_8HvJc  reason: not valid java name */
    public static /* synthetic */ void m2995$r8$lambda$DVtWA39ON6IOSMKN7p7z_8HvJc(final UserPersonalizationListView userPersonalizationListView, final int i) {
        Intrinsics.checkNotNullParameter(userPersonalizationListView, "");
        UserPersonalizationAdapter userPersonalizationAdapter = userPersonalizationListView.PlaceComponentResult;
        UserPersonalizationAdapter userPersonalizationAdapter2 = null;
        if (userPersonalizationAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            userPersonalizationAdapter = null;
        }
        if (userPersonalizationAdapter.getItemViewType(i) == 1) {
            UserPersonalizationAdapter userPersonalizationAdapter3 = userPersonalizationListView.PlaceComponentResult;
            if (userPersonalizationAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                userPersonalizationAdapter2 = userPersonalizationAdapter3;
            }
            UserPersonalizationModel userPersonalizationModel = userPersonalizationAdapter2.getItems().get(i).MyBillsEntityDataFactory;
            if (userPersonalizationListView.KClassImpl$Data$declaredNonStaticMembers$2(userPersonalizationModel)) {
                userPersonalizationListView.selectedPreferences.remove(userPersonalizationModel);
                final UserPersonalizationListView$onItemUnselectedView$1 userPersonalizationListView$onItemUnselectedView$1 = new Function1<UserPersonalizationAdapter.UserPersonalizationItemViewHolder, Unit>() { // from class: id.dana.userpersonalization.view.UserPersonalizationListView$onItemUnselectedView$1
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(UserPersonalizationAdapter.UserPersonalizationItemViewHolder userPersonalizationItemViewHolder) {
                        invoke2(userPersonalizationItemViewHolder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(UserPersonalizationAdapter.UserPersonalizationItemViewHolder userPersonalizationItemViewHolder) {
                        Intrinsics.checkNotNullParameter(userPersonalizationItemViewHolder, "");
                        View view = userPersonalizationItemViewHolder.itemView;
                        view.setBackgroundResource(R.drawable.bg_default_rounded_rectangle_outline);
                        ImageView imageView = (ImageView) view.findViewById(R.id.icCheckUserPersonalization);
                        if (imageView != null) {
                            InstrumentInjector.Resources_setImageResource(imageView, R.drawable.ic_check_unselected);
                        }
                    }
                };
                RecyclerView recyclerView = (RecyclerView) userPersonalizationListView._$_findCachedViewById(R.id.rvUserPersonalization);
                if (recyclerView != null) {
                    recyclerView.post(new Runnable() { // from class: id.dana.userpersonalization.view.UserPersonalizationListView$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            UserPersonalizationListView.m2996$r8$lambda$YbQL5JgBowmCZjWFMpMlgQWflk(UserPersonalizationListView.this, i, userPersonalizationListView$onItemUnselectedView$1);
                        }
                    });
                }
            } else if (userPersonalizationListView.MyBillsEntityDataFactory()) {
                ((ThrottledOnExecuteAction) userPersonalizationListView.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).KClassImpl$Data$declaredNonStaticMembers$2(117, new Function0<Unit>() { // from class: id.dana.userpersonalization.view.UserPersonalizationListView$addPreferenceId$1
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
                        UserPersonalizationListView.UserPersonalizationItemListener userPersonalizationItemListener = UserPersonalizationListView.this.getUserPersonalizationItemListener();
                        if (userPersonalizationItemListener != null) {
                            userPersonalizationItemListener.BuiltInFictitiousFunctionClassFactory();
                        }
                    }
                }, 2000L);
            } else {
                userPersonalizationListView.selectedPreferences.add(userPersonalizationModel);
                final UserPersonalizationListView$onItemSelectedView$1 userPersonalizationListView$onItemSelectedView$1 = new Function1<UserPersonalizationAdapter.UserPersonalizationItemViewHolder, Unit>() { // from class: id.dana.userpersonalization.view.UserPersonalizationListView$onItemSelectedView$1
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(UserPersonalizationAdapter.UserPersonalizationItemViewHolder userPersonalizationItemViewHolder) {
                        invoke2(userPersonalizationItemViewHolder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(UserPersonalizationAdapter.UserPersonalizationItemViewHolder userPersonalizationItemViewHolder) {
                        Intrinsics.checkNotNullParameter(userPersonalizationItemViewHolder, "");
                        View view = userPersonalizationItemViewHolder.itemView;
                        view.setBackgroundResource(R.drawable.bg_selected_rounded_rectangle_outline);
                        ImageView imageView = (ImageView) view.findViewById(R.id.icCheckUserPersonalization);
                        if (imageView != null) {
                            InstrumentInjector.Resources_setImageResource(imageView, R.drawable.ic_check_selected);
                        }
                    }
                };
                RecyclerView recyclerView2 = (RecyclerView) userPersonalizationListView._$_findCachedViewById(R.id.rvUserPersonalization);
                if (recyclerView2 != null) {
                    recyclerView2.post(new Runnable() { // from class: id.dana.userpersonalization.view.UserPersonalizationListView$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            UserPersonalizationListView.m2996$r8$lambda$YbQL5JgBowmCZjWFMpMlgQWflk(UserPersonalizationListView.this, i, userPersonalizationListView$onItemSelectedView$1);
                        }
                    });
                }
            }
            UserPersonalizationItemListener userPersonalizationItemListener = userPersonalizationListView.userPersonalizationItemListener;
            if (userPersonalizationItemListener != null) {
                userPersonalizationItemListener.KClassImpl$Data$declaredNonStaticMembers$2(userPersonalizationListView.selectedPreferences.size() > 0);
            }
        }
    }

    /* renamed from: $r8$lambda$YbQL5JgBowmCZjWFMpMl-gQWflk  reason: not valid java name */
    public static /* synthetic */ void m2996$r8$lambda$YbQL5JgBowmCZjWFMpMlgQWflk(UserPersonalizationListView userPersonalizationListView, int i, Function1 function1) {
        Intrinsics.checkNotNullParameter(userPersonalizationListView, "");
        Intrinsics.checkNotNullParameter(function1, "");
        RecyclerView recyclerView = (RecyclerView) userPersonalizationListView._$_findCachedViewById(R.id.rvUserPersonalization);
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView != null ? recyclerView.findViewHolderForAdapterPosition(i) : null;
        if (findViewHolderForAdapterPosition == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.userpersonalization.adapter.UserPersonalizationAdapter.UserPersonalizationItemViewHolder");
        }
        function1.invoke((UserPersonalizationAdapter.UserPersonalizationItemViewHolder) findViewHolderForAdapterPosition);
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rvUserPersonalization);
        UserPersonalizationAdapter userPersonalizationAdapter = null;
        if (recyclerView != null) {
            this.PlaceComponentResult = new UserPersonalizationAdapter();
            final GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
            gridLayoutManager.moveToNextValue = new GridLayoutManager.SpanSizeLookup() { // from class: id.dana.userpersonalization.view.UserPersonalizationListView$setLayoutManager$1$1
                @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                public final int PlaceComponentResult(int p0) {
                    UserPersonalizationAdapter userPersonalizationAdapter2;
                    userPersonalizationAdapter2 = UserPersonalizationListView.this.PlaceComponentResult;
                    if (userPersonalizationAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        userPersonalizationAdapter2 = null;
                    }
                    if (userPersonalizationAdapter2.getItemViewType(p0) == 0) {
                        return gridLayoutManager.getErrorConfigVersion;
                    }
                    return 1;
                }
            };
            recyclerView.setLayoutManager(gridLayoutManager);
            UserPersonalizationAdapter userPersonalizationAdapter2 = this.PlaceComponentResult;
            if (userPersonalizationAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                userPersonalizationAdapter2 = null;
            }
            recyclerView.setAdapter(userPersonalizationAdapter2);
        }
        UserPersonalizationAdapter userPersonalizationAdapter3 = this.PlaceComponentResult;
        if (userPersonalizationAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            userPersonalizationAdapter = userPersonalizationAdapter3;
        }
        userPersonalizationAdapter.setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.userpersonalization.view.UserPersonalizationListView$$ExternalSyntheticLambda1
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                UserPersonalizationListView.m2995$r8$lambda$DVtWA39ON6IOSMKN7p7z_8HvJc(UserPersonalizationListView.this, i);
            }
        });
    }
}
