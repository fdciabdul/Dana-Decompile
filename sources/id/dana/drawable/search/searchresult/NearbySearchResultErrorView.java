package id.dana.drawable.search.searchresult;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import com.iap.ac.android.common.container.provider.ui.ContainerUIProvider;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001bB'\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018B+\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0019\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u001aJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ3\u0010\u0010\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00022\u0012\b\u0002\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/nearbyrevamp/search/searchresult/NearbySearchResultErrorView;", "Lid/dana/base/BaseRichView;", "", "getErrorTitle", "()Ljava/lang/String;", "", "getLayout", "()I", "", "setup", "()V", "Lid/dana/nearbyrevamp/search/searchresult/NearbySearchResultErrorView$ErrorType;", "errorType", "keyword", "Lkotlin/Function0;", "onTryAgain", ContainerUIProvider.KEY_SHOW, "(Lid/dana/nearbyrevamp/search/searchresult/NearbySearchResultErrorView$ErrorType;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "ErrorType"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NearbySearchResultErrorView extends BaseRichView {
    public Map<Integer, View> _$_findViewCache;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005"}, d2 = {"Lid/dana/nearbyrevamp/search/searchresult/NearbySearchResultErrorView$ErrorType;", "", "<init>", "(Ljava/lang/String;I)V", "NETWORK_ERROR", "NO_RESULT_ERROR"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public enum ErrorType {
        NETWORK_ERROR,
        NO_RESULT_ERROR
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[ErrorType.values().length];
            iArr[ErrorType.NETWORK_ERROR.ordinal()] = 1;
            iArr[ErrorType.NO_RESULT_ERROR.ordinal()] = 2;
            getAuthRequestContext = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NearbySearchResultErrorView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NearbySearchResultErrorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public static void __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(AppCompatImageView appCompatImageView, int i) {
        if (appCompatImageView instanceof ImageView) {
            InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
        } else {
            appCompatImageView.setImageResource(i);
        }
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
        return R.layout.view_error_search_result;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearbySearchResultErrorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ NearbySearchResultErrorView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearbySearchResultErrorView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void show$default(NearbySearchResultErrorView nearbySearchResultErrorView, ErrorType errorType, String str, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        nearbySearchResultErrorView.show(errorType, str, function0);
    }

    public final void show(ErrorType errorType, String keyword, final Function0<Unit> onTryAgain) {
        Intrinsics.checkNotNullParameter(errorType, "");
        Intrinsics.checkNotNullParameter(keyword, "");
        int i = WhenMappings.getAuthRequestContext[errorType.ordinal()];
        if (i != 1) {
            if (i == 2) {
                AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.GetLeaderboardEntryBanner);
                if (appCompatImageView != null) {
                    __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(appCompatImageView, R.drawable.img_global_search_bottom_sheet_general_error);
                }
                TextView textView = (TextView) _$_findCachedViewById(R.id.getLogSourceName);
                if (textView != null) {
                    textView.setText(getContext().getString(R.string.keyword_empty_nearby_search_title, keyword));
                }
                TextView textView2 = (TextView) _$_findCachedViewById(R.id.isHelperTextDisplayed);
                if (textView2 != null) {
                    textView2.setText(getContext().getString(R.string.keyword_empty_nearby_search_desc));
                }
                DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.QrExpiredActivity);
                if (danaButtonSecondaryView != null) {
                    danaButtonSecondaryView.setVisibility(8);
                }
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) _$_findCachedViewById(R.id.GetLeaderboardEntryBanner);
                if (appCompatImageView2 != null) {
                    appCompatImageView2.setContentDescription(getContext().getString(R.string.imgNotFound));
                }
                TextView textView3 = (TextView) _$_findCachedViewById(R.id.getLogSourceName);
                if (textView3 != null) {
                    textView3.setContentDescription(getContext().getString(R.string.lblNotFound));
                }
                TextView textView4 = (TextView) _$_findCachedViewById(R.id.isHelperTextDisplayed);
                if (textView4 != null) {
                    textView4.setContentDescription(getContext().getString(R.string.lblHintDescription));
                    return;
                }
                return;
            }
            return;
        }
        AppCompatImageView appCompatImageView3 = (AppCompatImageView) _$_findCachedViewById(R.id.GetLeaderboardEntryBanner);
        if (appCompatImageView3 != null) {
            __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(appCompatImageView3, R.drawable.ic_network_error);
        }
        TextView textView5 = (TextView) _$_findCachedViewById(R.id.getLogSourceName);
        if (textView5 != null) {
            textView5.setText(getContext().getString(R.string.network_error_nearby_search_title));
        }
        TextView textView6 = (TextView) _$_findCachedViewById(R.id.isHelperTextDisplayed);
        if (textView6 != null) {
            textView6.setText(getContext().getString(R.string.network_error_nearby_search_desc));
        }
        DanaButtonSecondaryView danaButtonSecondaryView2 = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.QrExpiredActivity);
        if (danaButtonSecondaryView2 != null) {
            danaButtonSecondaryView2.setVisibility(0);
        }
        DanaButtonSecondaryView danaButtonSecondaryView3 = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.QrExpiredActivity);
        if (danaButtonSecondaryView3 != null) {
            danaButtonSecondaryView3.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyrevamp.search.searchresult.NearbySearchResultErrorView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NearbySearchResultErrorView.m2748$r8$lambda$fSo01s2eSuPueBJtNPWjTmVy4k(Function0.this, view);
                }
            });
        }
        AppCompatImageView appCompatImageView4 = (AppCompatImageView) _$_findCachedViewById(R.id.GetLeaderboardEntryBanner);
        if (appCompatImageView4 != null) {
            appCompatImageView4.setContentDescription(getContext().getString(R.string.imgErrorState));
        }
        TextView textView7 = (TextView) _$_findCachedViewById(R.id.getLogSourceName);
        if (textView7 != null) {
            textView7.setContentDescription(getContext().getString(R.string.lblErrorStateTitle));
        }
        TextView textView8 = (TextView) _$_findCachedViewById(R.id.isHelperTextDisplayed);
        if (textView8 != null) {
            textView8.setContentDescription(getContext().getString(R.string.lblErrorDescription));
        }
        DanaButtonSecondaryView danaButtonSecondaryView4 = (DanaButtonSecondaryView) _$_findCachedViewById(R.id.QrExpiredActivity);
        if (danaButtonSecondaryView4 != null) {
            danaButtonSecondaryView4.setContentDescription(getContext().getString(R.string.btnTryAgain));
        }
    }

    public final String getErrorTitle() {
        TextView textView = (TextView) _$_findCachedViewById(R.id.isHelperTextDisplayed);
        return String.valueOf(textView != null ? textView.getText() : null);
    }

    /* renamed from: $r8$lambda$fSo01s2eSuPueBJtNPWjT-mVy4k  reason: not valid java name */
    public static /* synthetic */ void m2748$r8$lambda$fSo01s2eSuPueBJtNPWjTmVy4k(Function0 function0, View view) {
        if (function0 != null) {
            Unit unit = (Unit) function0.invoke();
        }
    }
}
