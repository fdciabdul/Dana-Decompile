package id.dana.cashier.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
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

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0019\b\u0016\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b'\u0010(B#\b\u0016\u0012\u0006\u0010&\u001a\u00020%\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b'\u0010)B+\b\u0016\u0012\u0006\u0010&\u001a\u00020%\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b'\u0010,J\u000f\u0010\u0004\u001a\u00028\u0000H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H$¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H$¢\u0006\u0004\b\t\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0005@\u0005X\u0084\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0005@\u0005X\u0085\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001d\u001a\u00028\u00008EX\u0085\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0005R\"\u0010\u001f\u001a\u00020\u001e8\u0005@\u0005X\u0085.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$"}, d2 = {"Lid/dana/cashier/view/BaseCustomRadioButton;", "Landroidx/viewbinding/ViewBinding;", "VB", "Landroidx/constraintlayout/widget/ConstraintLayout;", "inflateViewBinding", "()Landroidx/viewbinding/ViewBinding;", "", "initAttributes", "()V", "populateViews", "Landroid/content/res/TypedArray;", "PlaceComponentResult", "Landroid/content/res/TypedArray;", "getA", "()Landroid/content/res/TypedArray;", "setA", "(Landroid/content/res/TypedArray;)V", "a", "Landroid/util/AttributeSet;", "BuiltInFictitiousFunctionClassFactory", "Landroid/util/AttributeSet;", "getAttrs", "()Landroid/util/AttributeSet;", "setAttrs", "(Landroid/util/AttributeSet;)V", "attrs", "MyBillsEntityDataFactory", "Lkotlin/Lazy;", "getBinding", "binding", "", "styleable", "[I", "getStyleable", "()[I", "setStyleable", "([I)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;[I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;[I)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I[I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class BaseCustomRadioButton<VB extends ViewBinding> extends ConstraintLayout {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private AttributeSet attrs;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy binding;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private TypedArray a;
    public Map<Integer, View> _$_findViewCache;
    protected int[] styleable;

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

    protected abstract void initAttributes();

    protected abstract void populateViews();

    @JvmName(name = "getAttrs")
    protected final AttributeSet getAttrs() {
        return this.attrs;
    }

    @JvmName(name = "setAttrs")
    protected final void setAttrs(AttributeSet attributeSet) {
        this.attrs = attributeSet;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "getA")
    public final TypedArray getA() {
        return this.a;
    }

    @JvmName(name = "setA")
    protected final void setA(TypedArray typedArray) {
        this.a = typedArray;
    }

    @JvmName(name = "getStyleable")
    protected final int[] getStyleable() {
        int[] iArr = this.styleable;
        if (iArr != null) {
            return iArr;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setStyleable")
    protected final void setStyleable(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "");
        this.styleable = iArr;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseCustomRadioButton(Context context, int[] iArr) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(iArr, "");
        this._$_findViewCache = new LinkedHashMap();
        this.binding = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<VB>(this) { // from class: id.dana.cashier.view.BaseCustomRadioButton$binding$2
            final /* synthetic */ BaseCustomRadioButton<VB> this$0;

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
        addView(getBinding().KClassImpl$Data$declaredNonStaticMembers$2());
        setStyleable(iArr);
        this.a = getContext().getTheme().obtainStyledAttributes(this.attrs, getStyleable(), 0, 0);
        initAttributes();
        populateViews();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseCustomRadioButton(Context context, AttributeSet attributeSet, int[] iArr) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(iArr, "");
        this._$_findViewCache = new LinkedHashMap();
        this.binding = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<VB>(this) { // from class: id.dana.cashier.view.BaseCustomRadioButton$binding$2
            final /* synthetic */ BaseCustomRadioButton<VB> this$0;

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
        addView(getBinding().KClassImpl$Data$declaredNonStaticMembers$2());
        setStyleable(iArr);
        this.attrs = attributeSet;
        this.a = getContext().getTheme().obtainStyledAttributes(this.attrs, getStyleable(), 0, 0);
        initAttributes();
        populateViews();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseCustomRadioButton(Context context, AttributeSet attributeSet, int i, int[] iArr) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(iArr, "");
        this._$_findViewCache = new LinkedHashMap();
        this.binding = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<VB>(this) { // from class: id.dana.cashier.view.BaseCustomRadioButton$binding$2
            final /* synthetic */ BaseCustomRadioButton<VB> this$0;

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
        addView(getBinding().KClassImpl$Data$declaredNonStaticMembers$2());
        setStyleable(iArr);
        this.attrs = attributeSet;
        this.a = getContext().getTheme().obtainStyledAttributes(this.attrs, getStyleable(), 0, 0);
        initAttributes();
        populateViews();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "getBinding")
    public final VB getBinding() {
        return (VB) this.binding.getValue();
    }
}
