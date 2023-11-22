package id.dana.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.common.adapter.CheckboxAdapter;
import id.dana.common.model.OptionModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\u000b\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R4\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00050\u00118\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018"}, d2 = {"Lid/dana/common/view/CheckboxView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "", "notifyAdapter", "()V", "", "Lid/dana/common/model/OptionModel;", SecurityConstants.KEY_OPTIONS, "setItems", "(Ljava/util/List;)V", "setup", "Lid/dana/common/adapter/CheckboxAdapter;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/common/adapter/CheckboxAdapter;", "Lkotlin/Function2;", "", "MyBillsEntityDataFactory", "Lkotlin/jvm/functions/Function2;", "getOnCheckBoxClicked", "()Lkotlin/jvm/functions/Function2;", "setOnCheckBoxClicked", "(Lkotlin/jvm/functions/Function2;)V", "onCheckBoxClicked", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CheckboxView extends BaseRichView {
    private final CheckboxAdapter BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private Function2<? super Integer, ? super Boolean, Unit> onCheckBoxClicked;
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CheckboxView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CheckboxView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_checkbox;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckboxView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.onCheckBoxClicked = new Function2<Integer, Boolean, Unit>() { // from class: id.dana.common.view.CheckboxView$onCheckBoxClicked$1
            public final void invoke(int i2, boolean z) {
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* synthetic */ Unit invoke(Integer num, Boolean bool) {
                invoke(num.intValue(), bool.booleanValue());
                return Unit.INSTANCE;
            }
        };
        this.BuiltInFictitiousFunctionClassFactory = new CheckboxAdapter(new Function2<Integer, Boolean, Unit>() { // from class: id.dana.common.view.CheckboxView$adapter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* synthetic */ Unit invoke(Integer num, Boolean bool) {
                invoke(num.intValue(), bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i2, boolean z) {
                CheckboxView.this.getOnCheckBoxClicked().invoke(Integer.valueOf(i2), Boolean.valueOf(z));
            }
        });
    }

    public /* synthetic */ CheckboxView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @JvmName(name = "getOnCheckBoxClicked")
    public final Function2<Integer, Boolean, Unit> getOnCheckBoxClicked() {
        return this.onCheckBoxClicked;
    }

    @JvmName(name = "setOnCheckBoxClicked")
    public final void setOnCheckBoxClicked(Function2<? super Integer, ? super Boolean, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "");
        this.onCheckBoxClicked = function2;
    }

    public final void setItems(List<OptionModel> options) {
        Intrinsics.checkNotNullParameter(options, "");
        ((RecyclerView) _$_findCachedViewById(R.id.getTouchscreenBlocksFocus)).setAdapter(this.BuiltInFictitiousFunctionClassFactory);
        ((RecyclerView) _$_findCachedViewById(R.id.getTouchscreenBlocksFocus)).setLayoutManager(new LinearLayoutManager(getContext()));
        this.BuiltInFictitiousFunctionClassFactory.setItems(options);
    }

    public final void notifyAdapter() {
        this.BuiltInFictitiousFunctionClassFactory.notifyDataSetChanged();
    }
}
