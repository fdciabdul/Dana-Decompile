package id.dana.richview.widgetcard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.OnClick;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.base.BaseRichView;
import id.dana.richview.widgetcard.WidgetCardView;
import id.dana.richview.widgetcard.adapter.WidgetAdapter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001-B'\b\u0016\u0012\u0006\u0010%\u001a\u00020$\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u0012\b\b\u0002\u0010(\u001a\u00020\u0002¢\u0006\u0004\b)\u0010*B+\b\u0016\u0012\u0006\u0010%\u001a\u00020$\u0012\b\u0010'\u001a\u0004\u0018\u00010&\u0012\u0006\u0010(\u001a\u00020\u0002\u0012\u0006\u0010+\u001a\u00020\u0002¢\u0006\u0004\b)\u0010,J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0018\u001a\u00020\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b!\u0010\""}, d2 = {"Lid/dana/richview/widgetcard/WidgetCardView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "Landroid/view/View;", "view", "", "onViewAllClicked", "(Landroid/view/View;)V", "Landroid/view/View$OnClickListener;", "clickListener", "setActionButtonListener", "(Landroid/view/View$OnClickListener;)V", "Lid/dana/richview/widgetcard/WidgetCardView$OnItemClickListener;", "clickItemListener", "setOnItemClickListener", "(Lid/dana/richview/widgetcard/WidgetCardView$OnItemClickListener;)V", "visibility", "setVisibility", "(I)V", "", "Lid/dana/richview/widgetcard/WidgetItem;", "widgetList", "setWidgets", "(Ljava/util/List;)V", "setup", "()V", "BuiltInFictitiousFunctionClassFactory", "Landroid/view/View$OnClickListener;", "Lid/dana/richview/widgetcard/adapter/WidgetAdapter;", "PlaceComponentResult", "Lid/dana/richview/widgetcard/adapter/WidgetAdapter;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/List;", "getAuthRequestContext", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "OnItemClickListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class WidgetCardView extends BaseRichView {
    private View.OnClickListener BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private List<WidgetItem> getAuthRequestContext;
    private WidgetAdapter PlaceComponentResult;
    public Map<Integer, View> _$_findViewCache;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/richview/widgetcard/WidgetCardView$OnItemClickListener;", "", "", "p0", "Lid/dana/richview/widgetcard/WidgetItem;", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(ILid/dana/richview/widgetcard/WidgetItem;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public interface OnItemClickListener {
        void KClassImpl$Data$declaredNonStaticMembers$2(int p0, WidgetItem p1);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WidgetCardView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WidgetCardView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_widget;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ WidgetCardView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCardView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public final void setActionButtonListener(View.OnClickListener clickListener) {
        Intrinsics.checkNotNullParameter(clickListener, "");
        this.BuiltInFictitiousFunctionClassFactory = clickListener;
    }

    public final void setOnItemClickListener(final OnItemClickListener clickItemListener) {
        Intrinsics.checkNotNullParameter(clickItemListener, "");
        WidgetAdapter widgetAdapter = this.PlaceComponentResult;
        if (widgetAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            widgetAdapter = null;
        }
        widgetAdapter.setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.richview.widgetcard.WidgetCardView$$ExternalSyntheticLambda0
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                WidgetCardView.$r8$lambda$AKMChdMw0PzJpGrK9kV0ZWSFHo8(WidgetCardView.OnItemClickListener.this, this, i);
            }
        });
    }

    @Override // android.view.View
    public final void setVisibility(int visibility) {
        ((ConstraintLayout) _$_findCachedViewById(R.id.res_0x7f0a10c6_groupdetailactivity_initdeletegroupdialog_2)).setVisibility(visibility);
    }

    public final void setWidgets(List<WidgetItem> widgetList) {
        Intrinsics.checkNotNullParameter(widgetList, "");
        this.getAuthRequestContext = widgetList;
        WidgetAdapter widgetAdapter = this.PlaceComponentResult;
        WidgetAdapter widgetAdapter2 = null;
        if (widgetAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            widgetAdapter = null;
        }
        widgetAdapter.setItems(widgetList);
        WidgetAdapter widgetAdapter3 = this.PlaceComponentResult;
        if (widgetAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            widgetAdapter2 = widgetAdapter3;
        }
        widgetAdapter2.notifyDataSetChanged();
    }

    @OnClick({R.id.btn_widget_view_all})
    public final void onViewAllClicked(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        View.OnClickListener onClickListener = this.BuiltInFictitiousFunctionClassFactory;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public static /* synthetic */ void $r8$lambda$AKMChdMw0PzJpGrK9kV0ZWSFHo8(OnItemClickListener onItemClickListener, WidgetCardView widgetCardView, int i) {
        Intrinsics.checkNotNullParameter(onItemClickListener, "");
        Intrinsics.checkNotNullParameter(widgetCardView, "");
        List<WidgetItem> list = widgetCardView.getAuthRequestContext;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            list = null;
        }
        onItemClickListener.KClassImpl$Data$declaredNonStaticMembers$2(i, list.get(i));
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        new PagerSnapHelper().KClassImpl$Data$declaredNonStaticMembers$2((RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a11a7_daggercontinualbillscomponent_continualbillscomponentimpl_sslpinningrepositoryprovider));
        this.PlaceComponentResult = new WidgetAdapter();
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a11a7_daggercontinualbillscomponent_continualbillscomponentimpl_sslpinningrepositoryprovider);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        recyclerView.setClipToPadding(false);
        WidgetAdapter widgetAdapter = this.PlaceComponentResult;
        if (widgetAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            widgetAdapter = null;
        }
        recyclerView.setAdapter(widgetAdapter);
    }
}
