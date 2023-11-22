package id.dana.drawable.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.core.ui.glide.GlideApp;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B'\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002¢\u0006\u0004\b \u0010!B+\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020\u0002¢\u0006\u0004\b \u0010#J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R*\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f8\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u001aR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001e"}, d2 = {"Lid/dana/nearbyrevamp/view/RatingStarView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "p0", "MyBillsEntityDataFactory", "(F)V", "setup", "()V", "value", "PlaceComponentResult", LogConstants.RESULT_FALSE, "getRating", "()F", "setRating", "rating", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "getAuthRequestContext", "", "Landroidx/appcompat/widget/AppCompatImageView;", "Ljava/util/List;", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RatingStarView extends BaseRichView {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private int PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private int getAuthRequestContext;

    /* renamed from: PlaceComponentResult */
    private float rating;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private List<? extends AppCompatImageView> MyBillsEntityDataFactory;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RatingStarView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RatingStarView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_rating_star;
    }

    @JvmName(name = "getRating")
    public final float getRating() {
        return this.rating;
    }

    @JvmName(name = "setRating")
    public final void setRating(float f) {
        double ceil;
        this.rating = f;
        double d = f;
        if (d > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && d < 0.5d) {
            MyBillsEntityDataFactory(f);
            return;
        }
        String format = new DecimalFormat("#.#").format(Float.valueOf(f % 1.0f));
        Intrinsics.checkNotNullExpressionValue(format, "");
        double parseFloat = Float.parseFloat(StringsKt.replace$default(format, ",", ".", false, 4, (Object) null));
        if (parseFloat < 0.3d) {
            ceil = Math.floor(d);
        } else {
            if (0.3d <= parseFloat && parseFloat <= 0.7d) {
                f = ((float) Math.floor(d)) + 0.5f;
            } else if (parseFloat > 0.7d) {
                ceil = Math.ceil(d);
            }
            MyBillsEntityDataFactory(f);
        }
        f = (float) ceil;
        MyBillsEntityDataFactory(f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RatingStarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.getAuthRequestContext = 16;
        this.PlaceComponentResult = 16;
    }

    public /* synthetic */ RatingStarView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RatingStarView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.getAuthRequestContext = 16;
        this.PlaceComponentResult = 16;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        List<? extends AppCompatImageView> listOf = CollectionsKt.listOf((Object[]) new AppCompatImageView[]{(AppCompatImageView) _$_findCachedViewById(R.id.res_0x7f0a09ba_getjson_key_auth_data_credentials_play_services_auth_release), (AppCompatImageView) _$_findCachedViewById(R.id.OptimizedMessage), (AppCompatImageView) _$_findCachedViewById(R.id.res_0x7f0a0a4c_abstractcontract_abstractview), (AppCompatImageView) _$_findCachedViewById(R.id.GetFeatureSendMoneyCashierNative), (AppCompatImageView) _$_findCachedViewById(R.id.setLastImpressionCountSync)});
        this.MyBillsEntityDataFactory = listOf;
        if (listOf == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            listOf = null;
        }
        Iterator<T> it = listOf.iterator();
        while (it.hasNext()) {
            ViewGroup.LayoutParams layoutParams = ((AppCompatImageView) it.next()).getLayoutParams();
            Intrinsics.checkNotNullExpressionValue(layoutParams, "");
            int i = this.getAuthRequestContext;
            if (i != 16 && this.PlaceComponentResult != 16) {
                layoutParams.width = i;
                layoutParams.height = this.PlaceComponentResult;
            }
        }
    }

    @Override // id.dana.base.BaseRichView
    public final void parseAttrs(Context r2, AttributeSet attrs) {
        TypedArray obtainStyledAttributes = r2 != null ? r2.obtainStyledAttributes(attrs, R.styleable.FamilyManageAvailableServicesAdapter) : null;
        if (obtainStyledAttributes != null) {
            try {
                this.getAuthRequestContext = (int) obtainStyledAttributes.getDimension(1, 16.0f);
                this.PlaceComponentResult = (int) obtainStyledAttributes.getDimension(0, 16.0f);
            } finally {
                if (obtainStyledAttributes != null) {
                    obtainStyledAttributes.recycle();
                }
            }
        }
    }

    private final void MyBillsEntityDataFactory(float p0) {
        List<? extends AppCompatImageView> list;
        int i = 1;
        int i2 = 0;
        while (true) {
            list = null;
            if (i >= 6) {
                break;
            }
            if (i <= p0) {
                i2++;
                List<? extends AppCompatImageView> list2 = this.MyBillsEntityDataFactory;
                if (list2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    list = list2;
                }
                GlideApp.getAuthRequestContext(this).MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2(Integer.valueOf((int) R.drawable.ic_star_24dp_filled)).MyBillsEntityDataFactory((ImageView) list.get(i - 1));
            } else {
                List<? extends AppCompatImageView> list3 = this.MyBillsEntityDataFactory;
                if (list3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    list = list3;
                }
                GlideApp.getAuthRequestContext(this).MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2(Integer.valueOf((int) R.drawable.ic_star_24dp_blank)).MyBillsEntityDataFactory((ImageView) list.get(i - 1));
            }
            i++;
        }
        if (i2 < 5) {
            float f = p0 - i2;
            if (f == 0.5f) {
                List<? extends AppCompatImageView> list4 = this.MyBillsEntityDataFactory;
                if (list4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    list = list4;
                }
                GlideApp.getAuthRequestContext(this).MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2(Integer.valueOf((int) R.drawable.ic_star_24dp_half_filled)).MyBillsEntityDataFactory((ImageView) list.get(i2));
                return;
            }
            if (f == 1.0f) {
                List<? extends AppCompatImageView> list5 = this.MyBillsEntityDataFactory;
                if (list5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    list = list5;
                }
                GlideApp.getAuthRequestContext(this).MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2(Integer.valueOf((int) R.drawable.ic_star_24dp_filled)).MyBillsEntityDataFactory((ImageView) list.get(i2));
                return;
            }
            List<? extends AppCompatImageView> list6 = this.MyBillsEntityDataFactory;
            if (list6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                list = list6;
            }
            GlideApp.getAuthRequestContext(this).MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2(Integer.valueOf((int) R.drawable.ic_star_24dp_blank)).MyBillsEntityDataFactory((ImageView) list.get(i2));
        }
    }
}
