package id.dana.merchantmanagement.view.richview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.databinding.ViewErrorMerchantListBinding;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B'\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016B+\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0017\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0018J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/merchantmanagement/view/richview/ErrorLinkedMerchantListView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ViewErrorMerchantListBinding;", "inflateViewBinding", "()Lid/dana/databinding/ViewErrorMerchantListBinding;", "Lid/dana/merchantmanagement/view/richview/ErrorLinkedMerchantListView$OnTryAgainClickListener;", "onTryAgainClickListener", "", "setOnTryAgainClickListener", "(Lid/dana/merchantmanagement/view/richview/ErrorLinkedMerchantListView$OnTryAgainClickListener;)V", "setup", "()V", "PlaceComponentResult", "Lid/dana/merchantmanagement/view/richview/ErrorLinkedMerchantListView$OnTryAgainClickListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "OnTryAgainClickListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ErrorLinkedMerchantListView extends BaseViewBindingRichView<ViewErrorMerchantListBinding> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private OnTryAgainClickListener KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> _$_findViewCache;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/merchantmanagement/view/richview/ErrorLinkedMerchantListView$OnTryAgainClickListener;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface OnTryAgainClickListener {
        void KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ErrorLinkedMerchantListView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ErrorLinkedMerchantListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
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
    public ErrorLinkedMerchantListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ ErrorLinkedMerchantListView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ErrorLinkedMerchantListView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewErrorMerchantListBinding inflateViewBinding() {
        ViewErrorMerchantListBinding MyBillsEntityDataFactory = ViewErrorMerchantListBinding.MyBillsEntityDataFactory(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.merchantmanagement.view.richview.ErrorLinkedMerchantListView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ErrorLinkedMerchantListView.$r8$lambda$OAgvMMYZO9R2YXSnzkDXn1NjG2s(ErrorLinkedMerchantListView.this, view);
            }
        });
    }

    public final void setOnTryAgainClickListener(OnTryAgainClickListener onTryAgainClickListener) {
        Intrinsics.checkNotNullParameter(onTryAgainClickListener, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = onTryAgainClickListener;
    }

    public static /* synthetic */ void $r8$lambda$OAgvMMYZO9R2YXSnzkDXn1NjG2s(ErrorLinkedMerchantListView errorLinkedMerchantListView, View view) {
        Intrinsics.checkNotNullParameter(errorLinkedMerchantListView, "");
        OnTryAgainClickListener onTryAgainClickListener = errorLinkedMerchantListView.KClassImpl$Data$declaredNonStaticMembers$2;
        if (onTryAgainClickListener != null) {
            onTryAgainClickListener.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }
}
