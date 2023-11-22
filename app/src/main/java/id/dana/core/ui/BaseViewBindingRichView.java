package id.dana.core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ap.zoloz.hummer.biz.HummerConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001eB\u001b\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001d\u0010\fB#\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b\u001d\u0010!B+\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\"\u001a\u00020\u001f¢\u0006\u0004\b\u001d\u0010#J\u000f\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0015\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\u0015\u0010\fJ\u000f\u0010\u0016\u001a\u00020\nH\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0018\u0010\u0017R\u001b\u0010\u001c\u001a\u00028\u00008EX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0005"}, d2 = {"Lid/dana/core/ui/BaseViewBindingRichView;", "Landroidx/viewbinding/ViewBinding;", "VB", "Landroid/widget/FrameLayout;", "inflateViewBinding", "()Landroidx/viewbinding/ViewBinding;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", IAPSyncCommand.COMMAND_INIT, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "isInjected", "injected", "(Z)V", "Landroid/view/View;", "view", "onInjectedView", "(Landroid/view/View;)V", "parseAttrs", "setSingleClick", "()V", "setup", "getAuthRequestContext", "Lkotlin/Lazy;", "getBinding", "binding", "<init>", "(Landroid/content/Context;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BaseViewBindingRichView<VB extends ViewBinding> extends FrameLayout {
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy binding;

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

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

    public abstract VB inflateViewBinding();

    protected void injected(boolean isInjected) {
    }

    protected void onInjectedView(View view) {
    }

    public void parseAttrs(Context context, AttributeSet attrs) {
    }

    protected void setSingleClick() {
    }

    public void setup() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseViewBindingRichView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.binding = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<VB>(this) { // from class: id.dana.core.ui.BaseViewBindingRichView$binding$2
            final /* synthetic */ BaseViewBindingRichView<VB> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Incorrect return type in method signature: ()TVB; */
            /* JADX WARN: Type inference failed for: r0v1, types: [androidx.viewbinding.ViewBinding] */
            @Override // kotlin.jvm.functions.Function0
            public final ViewBinding invoke() {
                return this.this$0.inflateViewBinding();
            }
        });
        init(context, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseViewBindingRichView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.binding = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<VB>(this) { // from class: id.dana.core.ui.BaseViewBindingRichView$binding$2
            final /* synthetic */ BaseViewBindingRichView<VB> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Incorrect return type in method signature: ()TVB; */
            /* JADX WARN: Type inference failed for: r0v1, types: [androidx.viewbinding.ViewBinding] */
            @Override // kotlin.jvm.functions.Function0
            public final ViewBinding invoke() {
                return this.this$0.inflateViewBinding();
            }
        });
        init(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseViewBindingRichView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.binding = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<VB>(this) { // from class: id.dana.core.ui.BaseViewBindingRichView$binding$2
            final /* synthetic */ BaseViewBindingRichView<VB> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Incorrect return type in method signature: ()TVB; */
            /* JADX WARN: Type inference failed for: r0v1, types: [androidx.viewbinding.ViewBinding] */
            @Override // kotlin.jvm.functions.Function0
            public final ViewBinding invoke() {
                return this.this$0.inflateViewBinding();
            }
        });
        init(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseViewBindingRichView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.binding = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<VB>(this) { // from class: id.dana.core.ui.BaseViewBindingRichView$binding$2
            final /* synthetic */ BaseViewBindingRichView<VB> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Incorrect return type in method signature: ()TVB; */
            /* JADX WARN: Type inference failed for: r0v1, types: [androidx.viewbinding.ViewBinding] */
            @Override // kotlin.jvm.functions.Function0
            public final ViewBinding invoke() {
                return this.this$0.inflateViewBinding();
            }
        });
        init(context, attributeSet);
    }

    @JvmName(name = "getBinding")
    public final VB getBinding() {
        return (VB) this.binding.getValue();
    }

    protected final void init(Context context, AttributeSet attrs) {
        Intrinsics.checkNotNullParameter(context, "");
        addView(getBinding().KClassImpl$Data$declaredNonStaticMembers$2());
        initEvent$default(this, context, attrs, false, 4, null);
    }

    static /* synthetic */ void initEvent$default(BaseViewBindingRichView baseViewBindingRichView, Context context, AttributeSet attributeSet, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initEvent");
        }
        if ((i & 4) != 0) {
            z = false;
        }
        baseViewBindingRichView.onInjectedView(baseViewBindingRichView.getBinding().KClassImpl$Data$declaredNonStaticMembers$2());
        baseViewBindingRichView.parseAttrs(context, attributeSet);
        baseViewBindingRichView.setup();
        if (!baseViewBindingRichView.isInEditMode()) {
            baseViewBindingRichView.injected(z);
        }
        baseViewBindingRichView.setSingleClick();
    }
}
