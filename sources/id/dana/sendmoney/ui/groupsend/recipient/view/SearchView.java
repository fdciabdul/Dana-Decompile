package id.dana.sendmoney.ui.groupsend.recipient.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.core.ui.util.FlowViewUtil;
import id.dana.core.ui.util.KeyboardHelper;
import id.dana.sendmoney.databinding.ViewSearchDefaultBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B/\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010#\u001a\u00020\n\u0012\b\b\u0002\u0010$\u001a\u00020\n¢\u0006\u0004\b%\u0010&J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00142\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\u0016¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00142\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00030\u0016¢\u0006\u0004\b\u001a\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\n¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001e\u0010\u0005"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/view/SearchView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/sendmoney/databinding/ViewSearchDefaultBinding;", "", "clearEditText", "()V", "clearEditTextFocus", "focusOnEditText", "inflateViewBinding", "()Lid/dana/sendmoney/databinding/ViewSearchDefaultBinding;", "", "x", "y", "", "isClearImageViewRect", "(II)Z", "", "hintText", "setEditTextHint", "(Ljava/lang/String;)V", "Lkotlinx/coroutines/CoroutineScope;", "lifecycleScope", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnFocusSearchListener", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;)V", "setOnSearchListener", "type", "setSearchViewInputType", "(I)V", "setup", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SearchView extends BaseViewBindingRichView<ViewSearchDefaultBinding> {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SearchView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SearchView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public /* synthetic */ SearchView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewSearchDefaultBinding inflateViewBinding() {
        ViewSearchDefaultBinding BuiltInFictitiousFunctionClassFactory = ViewSearchDefaultBinding.BuiltInFictitiousFunctionClassFactory(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setImeOptions(6);
        getBinding().getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.groupsend.recipient.view.SearchView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchView.$r8$lambda$AAsQ7ozNfXgiNEoVXZWZErMxCRk(SearchView.this, view);
            }
        });
    }

    public final void setEditTextHint(String hintText) {
        Intrinsics.checkNotNullParameter(hintText, "");
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setHint(hintText);
    }

    public final void setSearchViewInputType(int type) {
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setInputType(type);
    }

    public final void focusOnEditText() {
        EditText editText = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        editText.requestFocus();
        editText.setFocusableInTouchMode(true);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        KeyboardHelper.getAuthRequestContext(context);
    }

    public final void clearEditText() {
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.getText().clear();
    }

    public final void clearEditTextFocus() {
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.clearFocus();
    }

    public final void setOnSearchListener(CoroutineScope lifecycleScope, Function1<? super String, Unit> listener) {
        Intrinsics.checkNotNullParameter(lifecycleScope, "");
        Intrinsics.checkNotNullParameter(listener, "");
        FlowViewUtil flowViewUtil = FlowViewUtil.INSTANCE;
        EditText editText = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(editText, "");
        FlowKt.launchIn(FlowKt.onEach(FlowKt.debounce(FlowViewUtil.PlaceComponentResult(editText), 500L), new SearchView$setOnSearchListener$1(listener, this, null)), lifecycleScope);
    }

    public final void setOnFocusSearchListener(CoroutineScope lifecycleScope, Function1<? super Boolean, Unit> listener) {
        Intrinsics.checkNotNullParameter(lifecycleScope, "");
        Intrinsics.checkNotNullParameter(listener, "");
        FlowViewUtil flowViewUtil = FlowViewUtil.INSTANCE;
        EditText editText = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(editText, "");
        FlowKt.launchIn(FlowKt.onEach(FlowViewUtil.BuiltInFictitiousFunctionClassFactory(editText), new SearchView$setOnFocusSearchListener$1(listener, null)), lifecycleScope);
    }

    public final boolean isClearImageViewRect(int x, int y) {
        Rect rect = new Rect();
        getBinding().getAuthRequestContext.getGlobalVisibleRect(rect);
        return rect.contains(x, y);
    }

    public static /* synthetic */ void $r8$lambda$AAsQ7ozNfXgiNEoVXZWZErMxCRk(SearchView searchView, View view) {
        Intrinsics.checkNotNullParameter(searchView, "");
        searchView.getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setText("");
    }
}
