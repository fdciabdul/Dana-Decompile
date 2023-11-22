package id.dana.danapoly.ui.board.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.core.ui.extension.ViewExtKt;
import id.dana.core.ui.richview.DanaNavigationTabView;
import id.dana.danapoly.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B!\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eB\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000fB\u001b\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\r\u0010\u0012B#\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u0014B+\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u0016J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/danapoly/ui/board/view/DanapolyNavTabView;", "Lid/dana/core/ui/richview/DanaNavigationTabView;", "", "selected", "", "setSelected", "(Z)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "", "drawableRes", "", "title", "<init>", "(Landroid/content/Context;ILjava/lang/String;)V", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanapolyNavTabView extends DanaNavigationTabView {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DanapolyNavTabView(Context context, int i, String str) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(str, "");
        setIcon(i);
        setTitle(str);
        TextView textView = getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        Float valueOf = Float.valueOf(0.0f);
        ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(textView, Float.valueOf(20.0f), Float.valueOf(5.0f), valueOf, valueOf);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanapolyNavTabView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanapolyNavTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanapolyNavTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanapolyNavTabView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.core.ui.richview.DanaNavigationTabView, android.view.View
    public final void setSelected(boolean selected) {
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setSelected(selected);
        getBinding().getAuthRequestContext.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.getAuthRequestContext_res_0x7f060068));
        if (selected) {
            getBinding().getAuthRequestContext.setTypeface(ResourcesCompat.PlaceComponentResult(getContext(), R.font.getAuthRequestContext));
        } else {
            getBinding().getAuthRequestContext.setTypeface(ResourcesCompat.PlaceComponentResult(getContext(), R.font.PlaceComponentResult));
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006"}, d2 = {"Lid/dana/danapoly/ui/board/view/DanapolyNavTabView$Companion;", "", "Landroid/content/Context;", "p0", "Lid/dana/danapoly/ui/board/view/DanapolyNavTabView;", "getAuthRequestContext", "(Landroid/content/Context;)Lid/dana/danapoly/ui/board/view/DanapolyNavTabView;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static DanapolyNavTabView getAuthRequestContext(Context p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            int i = R.drawable.ic_nav_cards_danapoly;
            String string = p0.getString(R.string.res_0x7f130456_networkuserentitydata_externalsyntheticlambda1);
            Intrinsics.checkNotNullExpressionValue(string, "");
            return new DanapolyNavTabView(p0, i, string);
        }

        public static DanapolyNavTabView KClassImpl$Data$declaredNonStaticMembers$2(Context p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            int i = R.drawable.ic_nav_leaderboard;
            String string = p0.getString(R.string.leaderboard_tab);
            Intrinsics.checkNotNullExpressionValue(string, "");
            return new DanapolyNavTabView(p0, i, string);
        }
    }
}
