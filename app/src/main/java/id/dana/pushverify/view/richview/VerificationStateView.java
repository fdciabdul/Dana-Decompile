package id.dana.pushverify.view.richview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import com.iap.ac.android.common.container.provider.ui.ContainerUIProvider;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.databinding.ViewVerificationListStateBinding;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\f\u0012\b\b\u0002\u0010\u001b\u001a\u00020\f¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u0006\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u0013R\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/pushverify/view/richview/VerificationStateView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ViewVerificationListStateBinding;", "Lkotlin/Function0;", "", "callback", "addOnActionClickCallback", "(Lkotlin/jvm/functions/Function0;)V", "inflateViewBinding", "()Lid/dana/databinding/ViewVerificationListStateBinding;", "setup", "()V", "", "type", ContainerUIProvider.KEY_SHOW, "(I)V", "title", "message", "imageResource", "(III)V", "getAuthRequestContext", "Lkotlin/jvm/functions/Function0;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerificationStateView extends BaseViewBindingRichView<ViewVerificationListStateBinding> {
    public Map<Integer, View> _$_findViewCache;
    private Function0<Unit> getAuthRequestContext;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VerificationStateView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VerificationStateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VerificationStateView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public static void __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(AppCompatImageView appCompatImageView, int i) {
        if (appCompatImageView instanceof ImageView) {
            InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
        } else {
            appCompatImageView.setImageResource(i);
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerificationStateView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ VerificationStateView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewVerificationListStateBinding inflateViewBinding() {
        ViewVerificationListStateBinding PlaceComponentResult = ViewVerificationListStateBinding.PlaceComponentResult(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        getBinding().MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.pushverify.view.richview.VerificationStateView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VerificationStateView.$r8$lambda$I7VaadxQHL99XJF52Zcf4vxXkYM(VerificationStateView.this, view);
            }
        });
    }

    public final void show(int type) {
        if (type == 0) {
            show(R.string.pushverify_list_empty_title, R.string.pushverify_list_active_empty_message, R.drawable.ic_verification_list_empty);
        } else if (type == 1) {
            show(R.string.pushverify_list_empty_title, R.string.pushverify_list_history_empty_message, R.drawable.ic_verification_list_empty);
        } else if (type == 99) {
            show(R.string.pushverify_list_error_title, R.string.pushverify_list_error_message, R.drawable.ic_verification_list_error);
            View view = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(view, "");
            view.setVisibility(8);
            DanaButtonPrimaryView danaButtonPrimaryView = getBinding().MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView, "");
            danaButtonPrimaryView.setVisibility(8);
        }
    }

    public final void show(int title, int message, int imageResource) {
        ViewVerificationListStateBinding binding = getBinding();
        binding.getAuthRequestContext.setText(getContext().getString(title));
        binding.BuiltInFictitiousFunctionClassFactory.setText(getContext().getString(message));
        __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(binding.PlaceComponentResult, imageResource);
    }

    public final void addOnActionClickCallback(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "");
        this.getAuthRequestContext = callback;
    }

    public static /* synthetic */ void $r8$lambda$I7VaadxQHL99XJF52Zcf4vxXkYM(VerificationStateView verificationStateView, View view) {
        Intrinsics.checkNotNullParameter(verificationStateView, "");
        Function0<Unit> function0 = verificationStateView.getAuthRequestContext;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
