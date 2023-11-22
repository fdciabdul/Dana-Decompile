package id.dana.globalsearch.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.extension.ContextExtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0011\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/globalsearch/view/widget/GlobalSearchErrorStateView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "p0", "p1", "p2", "", "BuiltInFictitiousFunctionClassFactory", "(III)V", "", "errCode", "setErrorState", "(Ljava/lang/String;)V", "Lkotlin/Function0;", "tryAgainClickListener", "setTryAgainClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setup", "()V", "PlaceComponentResult", "Lkotlin/jvm/functions/Function0;", "getAuthRequestContext", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GlobalSearchErrorStateView extends BaseRichView {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private Function0<Unit> getAuthRequestContext;
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GlobalSearchErrorStateView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GlobalSearchErrorStateView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_global_search_error_state;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobalSearchErrorStateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ GlobalSearchErrorStateView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) _$_findCachedViewById(R.id.btnTryAgainGlobalSearch);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.globalsearch.view.widget.GlobalSearchErrorStateView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GlobalSearchErrorStateView.m2612$r8$lambda$Kv2dPqpWdW5eOPH03EIig8Sxg(GlobalSearchErrorStateView.this, view);
                }
            });
        }
    }

    public final void setTryAgainClickListener(Function0<Unit> tryAgainClickListener) {
        Intrinsics.checkNotNullParameter(tryAgainClickListener, "");
        this.getAuthRequestContext = tryAgainClickListener;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0093, code lost:
    
        if (r5.equals("success") != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0095, code lost:
    
        setVisibility(8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0098, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0017, code lost:
    
        if (r5.equals(id.dana.globalsearch.constants.GlobalSearchErrorCode.LOADING) == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
    
        if (r5.equals(id.dana.globalsearch.constants.GlobalSearchErrorCode.INITIAL_STATE) == false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setErrorState(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            int r0 = r5.hashCode()
            r1 = 8
            r2 = 0
            switch(r0) {
                case -1867169789: goto L8d;
                case -222831384: goto L6a;
                case 47666: goto L47;
                case 47667: goto L24;
                case 189987798: goto L1b;
                case 336650556: goto L11;
                default: goto Lf;
            }
        Lf:
            goto L99
        L11:
            java.lang.String r0 = "loading"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L95
            goto L99
        L1b:
            java.lang.String r0 = "initial_state"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L95
            goto L99
        L24:
            java.lang.String r0 = "003"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L99
            r5 = 2131233926(0x7f080c86, float:1.8084003E38)
            r0 = 2131953892(0x7f1308e4, float:1.9544268E38)
            r3 = 2131953891(0x7f1308e3, float:1.9544266E38)
            r4.BuiltInFictitiousFunctionClassFactory(r5, r0, r3)
            int r5 = id.dana.R.id.btnTryAgainGlobalSearch
            android.view.View r5 = r4._$_findCachedViewById(r5)
            id.dana.component.buttoncomponent.DanaButtonPrimaryView r5 = (id.dana.component.buttoncomponent.DanaButtonPrimaryView) r5
            r5.setVisibility(r1)
            r4.setVisibility(r2)
            return
        L47:
            java.lang.String r0 = "002"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L99
            r5 = 2131233431(0x7f080a97, float:1.8083E38)
            r0 = 2131953895(0x7f1308e7, float:1.9544274E38)
            r1 = 2131953894(0x7f1308e6, float:1.9544272E38)
            r4.BuiltInFictitiousFunctionClassFactory(r5, r0, r1)
            int r5 = id.dana.R.id.btnTryAgainGlobalSearch
            android.view.View r5 = r4._$_findCachedViewById(r5)
            id.dana.component.buttoncomponent.DanaButtonPrimaryView r5 = (id.dana.component.buttoncomponent.DanaButtonPrimaryView) r5
            r5.setVisibility(r2)
            r4.setVisibility(r2)
            return
        L6a:
            java.lang.String r0 = "noKeyword"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L99
            r5 = 2131233080(0x7f080938, float:1.8082287E38)
            r0 = 2131957350(0x7f131666, float:1.9551281E38)
            r3 = 2131957327(0x7f13164f, float:1.9551235E38)
            r4.BuiltInFictitiousFunctionClassFactory(r5, r0, r3)
            int r5 = id.dana.R.id.btnTryAgainGlobalSearch
            android.view.View r5 = r4._$_findCachedViewById(r5)
            id.dana.component.buttoncomponent.DanaButtonPrimaryView r5 = (id.dana.component.buttoncomponent.DanaButtonPrimaryView) r5
            r5.setVisibility(r1)
            r4.setVisibility(r2)
            return
        L8d:
            java.lang.String r0 = "success"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L99
        L95:
            r4.setVisibility(r1)
            return
        L99:
            r5 = 2131233745(0x7f080bd1, float:1.8083636E38)
            r0 = 2131953898(0x7f1308ea, float:1.954428E38)
            r1 = 2131953897(0x7f1308e9, float:1.9544278E38)
            r4.BuiltInFictitiousFunctionClassFactory(r5, r0, r1)
            int r5 = id.dana.R.id.btnTryAgainGlobalSearch
            android.view.View r5 = r4._$_findCachedViewById(r5)
            id.dana.component.buttoncomponent.DanaButtonPrimaryView r5 = (id.dana.component.buttoncomponent.DanaButtonPrimaryView) r5
            r5.setVisibility(r2)
            r4.setVisibility(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.globalsearch.view.widget.GlobalSearchErrorStateView.setErrorState(java.lang.String):void");
    }

    private final void BuiltInFictitiousFunctionClassFactory(int p0, int p1, int p2) {
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.res_0x7f0a09ae_contactscontract_datacolumnswithjoins);
        if (appCompatImageView != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            appCompatImageView.setImageDrawable(ContextExtKt.PlaceComponentResult(context, p0));
        }
        TextView textView = (TextView) _$_findCachedViewById(R.id.tvErrorTitleGlobalSearch);
        if (textView != null) {
            textView.setText(getContext().getString(p1));
        }
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.res_0x7f0a1459_getcashieraddon_lambda_2);
        if (textView2 != null) {
            textView2.setText(getContext().getString(p2));
        }
    }

    /* renamed from: $r8$lambda$Kv2-dPqpWd-W5eOPH03EIig8Sxg  reason: not valid java name */
    public static /* synthetic */ void m2612$r8$lambda$Kv2dPqpWdW5eOPH03EIig8Sxg(GlobalSearchErrorStateView globalSearchErrorStateView, View view) {
        Intrinsics.checkNotNullParameter(globalSearchErrorStateView, "");
        Function0<Unit> function0 = globalSearchErrorStateView.getAuthRequestContext;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
