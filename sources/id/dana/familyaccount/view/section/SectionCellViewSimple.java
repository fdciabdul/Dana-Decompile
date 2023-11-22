package id.dana.familyaccount.view.section;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.databinding.ItemListAvailableServiceMemberFamilyAccountBinding;
import id.dana.extension.view.ViewExtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\tJ\u0015\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\t"}, d2 = {"Lid/dana/familyaccount/view/section/SectionCellViewSimple;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ItemListAvailableServiceMemberFamilyAccountBinding;", "inflateViewBinding", "()Lid/dana/databinding/ItemListAvailableServiceMemberFamilyAccountBinding;", "", "available", "", "initHistorySection", "(Z)V", "initOrganizerDashboardLimitSection", "", "contentDescription", "setContentDescription", "(Ljava/lang/String;)V", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SectionCellViewSimple extends BaseViewBindingRichView<ItemListAvailableServiceMemberFamilyAccountBinding> {
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SectionCellViewSimple(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SectionCellViewSimple(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SectionCellViewSimple(Context context, AttributeSet attributeSet, int i) {
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
    public SectionCellViewSimple(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ SectionCellViewSimple(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ItemListAvailableServiceMemberFamilyAccountBinding inflateViewBinding() {
        ItemListAvailableServiceMemberFamilyAccountBinding BuiltInFictitiousFunctionClassFactory = ItemListAvailableServiceMemberFamilyAccountBinding.BuiltInFictitiousFunctionClassFactory(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    public final void initOrganizerDashboardLimitSection(boolean available) {
        getBinding().BuiltInFictitiousFunctionClassFactory.setText(getResources().getText(R.string.family_account_text_month_transaction_limit_title));
        getBinding().MyBillsEntityDataFactory.setImageDrawable(ContextCompat.PlaceComponentResult(getContext(), (int) R.drawable.ic_limit));
        KClassImpl$Data$declaredNonStaticMembers$2(available);
    }

    public final void initHistorySection(boolean available) {
        getBinding().BuiltInFictitiousFunctionClassFactory.setText(getResources().getText(R.string.family_text_member_transaction_history));
        getBinding().MyBillsEntityDataFactory.setImageDrawable(ContextCompat.PlaceComponentResult(getContext(), (int) R.drawable.ic_transaction_limit));
        KClassImpl$Data$declaredNonStaticMembers$2(available);
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
        AppCompatImageView appCompatImageView = getBinding().PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(p0 ? 0 : 8);
        getBinding().BuiltInFictitiousFunctionClassFactory.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), p0 ? R.color.f24002131099997 : R.color.f23962131099992));
        AppCompatImageView appCompatImageView2 = getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
        ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(appCompatImageView2, !p0);
    }

    public final void setContentDescription(String contentDescription) {
        Intrinsics.checkNotNullParameter(contentDescription, "");
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setContentDescription(contentDescription);
    }
}
