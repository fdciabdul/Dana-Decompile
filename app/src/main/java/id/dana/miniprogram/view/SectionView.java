package id.dana.miniprogram.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.common.DividerItemDecoration;
import id.dana.data.config.source.amcs.result.MaintenanceBroadcastResult;
import id.dana.extension.view.ViewExtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00072\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u00072\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n¢\u0006\u0004\b\u000e\u0010\rR(\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/miniprogram/view/SectionView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "", MaintenanceBroadcastResult.KEY_VISIBLE, "", "setTitleVisibility", "(Z)V", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "setupGridRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "setupLinearRecyclerView", "", "title", "getSectionTitle", "()Ljava/lang/CharSequence;", "setSectionTitle", "(Ljava/lang/CharSequence;)V", "sectionTitle", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SectionView extends BaseRichView {
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SectionView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SectionView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_mini_program_section;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ SectionView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @JvmName(name = "getSectionTitle")
    public final CharSequence getSectionTitle() {
        TextView textView = (TextView) findViewById(16908310);
        if (textView != null) {
            return textView.getText();
        }
        return null;
    }

    @JvmName(name = "setSectionTitle")
    public final void setSectionTitle(CharSequence charSequence) {
        TextView textView = (TextView) findViewById(16908310);
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public final void setTitleVisibility(boolean visible) {
        TextView textView = (TextView) _$_findCachedViewById(R.id.onGetNegativeButtonString);
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(visible ? 0 : 8);
    }

    public final void setupGridRecyclerView(RecyclerView.Adapter<?> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "");
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a1050_linkedtreemap_linkedtreemapiterator);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));
        recyclerView.setAdapter(adapter);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "");
        Float valueOf = Float.valueOf(16.0f);
        ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(recyclerView, null, Float.valueOf(12.0f), null, valueOf, 5);
        ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(this, null, null, null, Float.valueOf(8.0f), 7);
        TextView textView = (TextView) _$_findCachedViewById(R.id.onGetNegativeButtonString);
        Intrinsics.checkNotNullExpressionValue(textView, "");
        ViewExtKt.PlaceComponentResult(textView, valueOf, null, valueOf, null, 10);
    }

    public final void setupLinearRecyclerView(RecyclerView.Adapter<?> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "");
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a1050_linkedtreemap_linkedtreemapiterator);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "");
        Float valueOf = Float.valueOf(0.0f);
        ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(recyclerView, null, Float.valueOf(12.0f), null, valueOf, 5);
        ((RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a1050_linkedtreemap_linkedtreemapiterator)).addItemDecoration(new DividerItemDecoration(getContext(), ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f23942131099989), 1.0f));
        View _$_findCachedViewById = _$_findCachedViewById(R.id.AutoFocusManager$2$$ExternalSyntheticLambda0);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "");
        _$_findCachedViewById.setVisibility(8);
        SectionView sectionView = this;
        ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(sectionView, null, null, null, valueOf, 7);
        Float valueOf2 = Float.valueOf(16.0f);
        ViewExtKt.PlaceComponentResult(sectionView, valueOf2, null, valueOf2, null, 10);
    }
}
