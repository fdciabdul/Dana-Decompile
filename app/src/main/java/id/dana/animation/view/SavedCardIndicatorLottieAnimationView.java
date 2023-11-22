package id.dana.animation.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B%\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012R*\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/home/view/SavedCardIndicatorLottieAnimationView;", "Lcom/airbnb/lottie/LottieAnimationView;", "", "value", "MyBillsEntityDataFactory", "Z", "getHasSavedCard", "()Z", "setHasSavedCard", "(Z)V", "hasSavedCard", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SavedCardIndicatorLottieAnimationView extends LottieAnimationView {
    public static final String LOTTIE_FILE_HAS_CARD = "json/lottie/balance_pointer_animation.lottie";
    public static final String LOTTIE_FILE_NO_CARD = "json/lottie/balance_no_saved_card_indicator.lottie";

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private boolean hasSavedCard;
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SavedCardIndicatorLottieAnimationView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SavedCardIndicatorLottieAnimationView(Context context, AttributeSet attributeSet) {
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
    public SavedCardIndicatorLottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        setAnimation(LOTTIE_FILE_HAS_CARD);
        this.hasSavedCard = true;
    }

    public /* synthetic */ SavedCardIndicatorLottieAnimationView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @JvmName(name = "getHasSavedCard")
    public final boolean getHasSavedCard() {
        return this.hasSavedCard;
    }

    @JvmName(name = "setHasSavedCard")
    public final void setHasSavedCard(boolean z) {
        if (this.hasSavedCard != z) {
            this.hasSavedCard = z;
            setAnimation(z ? LOTTIE_FILE_HAS_CARD : LOTTIE_FILE_NO_CARD);
            playAnimation();
        }
    }
}
