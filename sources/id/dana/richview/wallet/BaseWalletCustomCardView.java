package id.dana.richview.wallet;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.ap.zoloz.hummer.biz.HummerConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aB+\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001cJ!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/richview/wallet/BaseWalletCustomCardView;", "Lid/dana/richview/wallet/BaseWalletCardView;", "Landroid/graphics/ColorFilter;", "filter", "Landroid/view/View;", "view", "", "applyFilter", "(Landroid/graphics/ColorFilter;Landroid/view/View;)V", "", "isUsed", "setToGrayScale", "(Landroid/view/View;Z)V", "Landroid/graphics/Paint;", "filterPaint", "Landroid/graphics/Paint;", "Landroid/graphics/ColorMatrix;", "greyScaleColorMatrix", "Landroid/graphics/ColorMatrix;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class BaseWalletCustomCardView extends BaseWalletCardView {
    public Map<Integer, View> _$_findViewCache;
    private final Paint filterPaint;
    private final ColorMatrix greyScaleColorMatrix;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseWalletCustomCardView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseWalletCustomCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.richview.wallet.BaseWalletCardView
    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.richview.wallet.BaseWalletCardView
    public View _$_findCachedViewById(int i) {
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
    public BaseWalletCustomCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.filterPaint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(new float[]{0.33f, 0.33f, 0.33f, 0.0f, 0.0f, 0.33f, 0.33f, 0.33f, 0.0f, 0.0f, 0.33f, 0.33f, 0.33f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
        this.greyScaleColorMatrix = colorMatrix;
    }

    public /* synthetic */ BaseWalletCustomCardView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseWalletCustomCardView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.filterPaint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(new float[]{0.33f, 0.33f, 0.33f, 0.0f, 0.0f, 0.33f, 0.33f, 0.33f, 0.0f, 0.0f, 0.33f, 0.33f, 0.33f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
        this.greyScaleColorMatrix = colorMatrix;
    }

    public final void setToGrayScale(View view, boolean isUsed) {
        Intrinsics.checkNotNullParameter(view, "");
        if (isUsed) {
            applyFilter(new ColorMatrixColorFilter(this.greyScaleColorMatrix), view);
        } else {
            applyFilter(null, view);
        }
    }

    private final void applyFilter(ColorFilter filter, View view) {
        this.filterPaint.setColorFilter(filter);
        view.setLayerType(2, this.filterPaint);
        view.setLayerPaint(this.filterPaint);
    }
}
