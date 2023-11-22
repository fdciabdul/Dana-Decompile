package id.dana.showcase.view;

import android.content.Context;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.showcase.Content;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/showcase/view/SimpleDismissibleView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "Lid/dana/showcase/Content;", "PlaceComponentResult", "Lid/dana/showcase/Content;", "Lkotlin/Function0;", "", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/jvm/functions/Function0;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "content", "onDismissListener", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILid/dana/showcase/Content;Lkotlin/jvm/functions/Function0;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SimpleDismissibleView extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Function0<Unit> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Content PlaceComponentResult;
    public Map<Integer, View> _$_findViewCache;

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
        return R.layout.view_tooltip_simple_dismissible;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleDismissibleView(Context context, AttributeSet attributeSet, int i, Content content, Function0<Unit> function0) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(function0, "");
        this._$_findViewCache = new LinkedHashMap();
        this.PlaceComponentResult = content;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function0;
        if (content != null) {
            Spannable spannable = content.BuiltInFictitiousFunctionClassFactory;
            if (spannable == null || spannable.length() == 0) {
                TextView textView = (TextView) _$_findCachedViewById(R.id.isHelperTextDisplayed);
                if (textView != null) {
                    textView.setText(this.PlaceComponentResult.getAuthRequestContext);
                }
            } else {
                TextView textView2 = (TextView) _$_findCachedViewById(R.id.isHelperTextDisplayed);
                if (textView2 != null) {
                    textView2.setText(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
                }
            }
        }
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.alertCameraNoPermissionDialog);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.showcase.view.SimpleDismissibleView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SimpleDismissibleView.$r8$lambda$iXEfHnjAJH2EvwNehSDQ0BsqQuU(SimpleDismissibleView.this, view);
                }
            });
        }
    }

    public /* synthetic */ SimpleDismissibleView(Context context, AttributeSet attributeSet, int i, Content content, Function0 function0, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i, content, function0);
    }

    public static /* synthetic */ void $r8$lambda$iXEfHnjAJH2EvwNehSDQ0BsqQuU(SimpleDismissibleView simpleDismissibleView, View view) {
        Intrinsics.checkNotNullParameter(simpleDismissibleView, "");
        simpleDismissibleView.KClassImpl$Data$declaredNonStaticMembers$2.invoke();
    }
}
