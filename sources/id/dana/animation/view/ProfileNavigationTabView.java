package id.dana.animation.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.bumptech.glide.Glide;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.data.account.repository.AccountEntityRepository;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015B+\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0017J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/home/view/ProfileNavigationTabView;", "Lid/dana/home/view/NavigationTabView;", "", "getLayout", "()I", "Landroid/widget/TextView;", "getTabTextView", "()Landroid/widget/TextView;", "", AccountEntityRepository.UpdateType.AVATAR, "", "verifiedUser", "", "setupUserTabIcon", "(Ljava/lang/String;Z)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProfileNavigationTabView extends NavigationTabView {
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProfileNavigationTabView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProfileNavigationTabView(Context context, AttributeSet attributeSet) {
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

    @Override // id.dana.animation.view.NavigationTabView, id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.view_nav_tab_profile;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileNavigationTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ ProfileNavigationTabView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileNavigationTabView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @Override // id.dana.animation.view.NavigationTabView
    public final TextView getTabTextView() {
        View view = getView();
        TextView textView = view != null ? (TextView) view.findViewById(R.id.CashierGeneralProcessingFragment$cashierRequestId$2) : null;
        if (textView == null) {
            TextView tabTextView = super.getTabTextView();
            Intrinsics.checkNotNullExpressionValue(tabTextView, "");
            return tabTextView;
        }
        return textView;
    }

    public final void setupUserTabIcon(String r7, boolean verifiedUser) {
        boolean z;
        View view;
        CircleImageView circleImageView;
        int i;
        Intrinsics.checkNotNullParameter(r7, "");
        View view2 = getView();
        AppCompatImageView appCompatImageView = view2 != null ? (AppCompatImageView) view2.findViewById(R.id.setPhpNamespaceBytes) : null;
        if (appCompatImageView != null) {
            if (verifiedUser) {
                if (!(r7.length() == 0)) {
                    i = 4;
                    appCompatImageView.setVisibility(i);
                }
            }
            i = 0;
            appCompatImageView.setVisibility(i);
        }
        View view3 = getView();
        AppCompatImageView appCompatImageView2 = view3 != null ? (AppCompatImageView) view3.findViewById(R.id.nav_tab_user_verified_indicator) : null;
        if (appCompatImageView2 != null) {
            appCompatImageView2.setVisibility(verifiedUser ? 0 : 8);
        }
        if (getContext() instanceof Activity) {
            Context context = getContext();
            if (context == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            }
            if (!((Activity) context).isDestroyed()) {
                z = true;
                if (verifiedUser || !z || (view = getView()) == null || (circleImageView = (CircleImageView) view.findViewById(R.id.nav_tab_user_avatar)) == null) {
                    return;
                }
                circleImageView.setVisibility(r7.length() > 0 ? 0 : 4);
                Glide.KClassImpl$Data$declaredNonStaticMembers$2(circleImageView.getContext()).getAuthRequestContext(r7).MyBillsEntityDataFactory((int) R.drawable.avatar_placeholder).BuiltInFictitiousFunctionClassFactory(R.drawable.avatar_placeholder).MyBillsEntityDataFactory((ImageView) circleImageView);
                return;
            }
        }
        z = false;
        if (verifiedUser) {
        }
    }
}
