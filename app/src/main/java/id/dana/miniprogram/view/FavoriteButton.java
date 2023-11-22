package id.dana.miniprogram.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.ResourceManagerInternal;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00028G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\r\"\u0004\b\u000e\u0010\u0006R$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/miniprogram/view/FavoriteButton;", "Landroidx/appcompat/widget/AppCompatImageView;", "", TrackerKey.SendMoneyProperties.IS_FAVORITE, "", "setState", "(Z)V", "toggle", "()V", "BuiltInFictitiousFunctionClassFactory", "Z", "getAuthRequestContext", "checked", "()Z", "setFavorite", "Lid/dana/miniprogram/view/OnCheckedChangeListener;", "MyBillsEntityDataFactory", "Lid/dana/miniprogram/view/OnCheckedChangeListener;", "getOnCheckedChangeListener", "()Lid/dana/miniprogram/view/OnCheckedChangeListener;", "setOnCheckedChangeListener", "(Lid/dana/miniprogram/view/OnCheckedChangeListener;)V", "onCheckedChangeListener", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FavoriteButton extends AppCompatImageView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private boolean getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private OnCheckedChangeListener onCheckedChangeListener;
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FavoriteButton(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FavoriteButton(Context context, AttributeSet attributeSet) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FavoriteButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        setState(false);
        setOnClickListener(new View.OnClickListener() { // from class: id.dana.miniprogram.view.FavoriteButton$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FavoriteButton.$r8$lambda$86NOmRlbSag48oMLHjHN4KM_RgY(FavoriteButton.this, view);
            }
        });
    }

    public /* synthetic */ FavoriteButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @JvmName(name = "getOnCheckedChangeListener")
    public final OnCheckedChangeListener getOnCheckedChangeListener() {
        return this.onCheckedChangeListener;
    }

    @JvmName(name = "setOnCheckedChangeListener")
    public final void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListener = onCheckedChangeListener;
    }

    @JvmName(name = TrackerKey.SendMoneyProperties.IS_FAVORITE)
    /* renamed from: isFavorite  reason: from getter */
    public final boolean getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @JvmName(name = "setFavorite")
    public final void setFavorite(boolean z) {
        if (z != this.getAuthRequestContext) {
            setState(z);
            OnCheckedChangeListener onCheckedChangeListener = this.onCheckedChangeListener;
            if (onCheckedChangeListener != null) {
                onCheckedChangeListener.MyBillsEntityDataFactory(z);
            }
        }
    }

    public final void setState(boolean isFavorite) {
        Drawable BuiltInFictitiousFunctionClassFactory;
        this.getAuthRequestContext = isFavorite;
        BuiltInFictitiousFunctionClassFactory = ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(getContext(), isFavorite ? R.drawable.ic_star_filled : R.drawable.ic_star);
        setImageDrawable(BuiltInFictitiousFunctionClassFactory);
    }

    public final void toggle() {
        setFavorite(!this.getAuthRequestContext);
    }

    public static /* synthetic */ void $r8$lambda$86NOmRlbSag48oMLHjHN4KM_RgY(FavoriteButton favoriteButton, View view) {
        Intrinsics.checkNotNullParameter(favoriteButton, "");
        favoriteButton.toggle();
    }
}
