package id.dana.cardbinding.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import id.dana.cardbinding.model.SupportedCardModel;
import id.dana.cardbinding.model.SupportedCardsConfigModel;
import id.dana.cardbinding.view.SupportedCardsAdapter;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.databinding.ViewSupportedCardsBinding;
import id.dana.lib.gcontainer.app.bridge.logging.H5GetLogInfoBridge;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B'\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"B+\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010#\u001a\u00020\u001f¢\u0006\u0004\b!\u0010$J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0005¢\u0006\u0004\b\u0014\u0010\tR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a"}, d2 = {"Lid/dana/cardbinding/view/SupportedCardsView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ViewSupportedCardsBinding;", "inflateViewBinding", "()Lid/dana/databinding/ViewSupportedCardsBinding;", "", "isVertical", "", "initRvAdapter", "(Z)V", "Lid/dana/cardbinding/view/SupportedCardsView$OnClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setSupportedCardsDialogOnClickListener", "(Lid/dana/cardbinding/view/SupportedCardsView$OnClickListener;)V", "Lid/dana/cardbinding/model/SupportedCardsConfigModel;", H5GetLogInfoBridge.RESULT_MODEL, "isDialog", "setupDataFromSplit", "(Lid/dana/cardbinding/model/SupportedCardsConfigModel;Z)V", "isShow", "showSupportedCardsView", "MyBillsEntityDataFactory", "Lid/dana/cardbinding/view/SupportedCardsView$OnClickListener;", "getAuthRequestContext", "Lid/dana/cardbinding/view/SupportedCardsAdapter;", "PlaceComponentResult", "Lid/dana/cardbinding/view/SupportedCardsAdapter;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "OnClickListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SupportedCardsView extends BaseViewBindingRichView<ViewSupportedCardsBinding> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private OnClickListener getAuthRequestContext;
    private SupportedCardsAdapter PlaceComponentResult;
    public Map<Integer, View> _$_findViewCache;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/cardbinding/view/SupportedCardsView$OnClickListener;", "", "", "getAuthRequestContext", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface OnClickListener {
        void getAuthRequestContext();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SupportedCardsView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SupportedCardsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
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
    public SupportedCardsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ SupportedCardsView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SupportedCardsView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewSupportedCardsBinding inflateViewBinding() {
        ViewSupportedCardsBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewSupportedCardsBinding.KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final void setupDataFromSplit(SupportedCardsConfigModel model, boolean isDialog) {
        if (model != null) {
            SupportedCardsAdapter supportedCardsAdapter = this.PlaceComponentResult;
            if (supportedCardsAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                supportedCardsAdapter = null;
            }
            List<SupportedCardModel> list = model.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullParameter(list, "");
            supportedCardsAdapter.BuiltInFictitiousFunctionClassFactory.clear();
            ArrayList<SupportedCardModel> arrayList = supportedCardsAdapter.BuiltInFictitiousFunctionClassFactory;
            ArrayList<SupportedCardModel> arrayList2 = list;
            if (arrayList2.isEmpty()) {
                arrayList2 = supportedCardsAdapter.KClassImpl$Data$declaredNonStaticMembers$2();
            }
            arrayList.addAll(arrayList2);
            supportedCardsAdapter.notifyDataSetChanged();
            TextView textView = getBinding().PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(textView, "");
            String str = model.getAuthRequestContext;
            if (str.length() > 0) {
                textView.setText(str);
            }
            TextView textView2 = getBinding().getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(textView2, "");
            String str2 = model.PlaceComponentResult;
            if (str2.length() > 0) {
                textView2.setText(str2);
            }
            TextView textView3 = getBinding().BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(textView3, "");
            String str3 = model.KClassImpl$Data$declaredNonStaticMembers$2;
            if (str3.length() > 0) {
                textView3.setText(str3);
            }
            if (model.MyBillsEntityDataFactory.length() > 0) {
                getBinding().MyBillsEntityDataFactory.setActiveButton(model.MyBillsEntityDataFactory, null);
            }
        }
        getBinding().MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cardbinding.view.SupportedCardsView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SupportedCardsView.m483$r8$lambda$toUwKpv5c23FuAy8t6reXoSCkQ(SupportedCardsView.this, view);
            }
        });
        TextView textView4 = getBinding().BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(textView4, "");
        textView4.setVisibility(isDialog ? 0 : 8);
        DanaButtonPrimaryView danaButtonPrimaryView = getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView, "");
        danaButtonPrimaryView.setVisibility(isDialog ? 0 : 8);
    }

    public final void setSupportedCardsDialogOnClickListener(OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "");
        this.getAuthRequestContext = listener;
    }

    public final void initRvAdapter(boolean isVertical) {
        LinearLayoutManager linearLayoutManager;
        Context context = getContext();
        if (context == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        }
        this.PlaceComponentResult = new SupportedCardsAdapter((Activity) context);
        RecyclerView recyclerView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        SupportedCardsAdapter supportedCardsAdapter = this.PlaceComponentResult;
        if (supportedCardsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            supportedCardsAdapter = null;
        }
        recyclerView.setAdapter(supportedCardsAdapter);
        SupportedCardsAdapter.Companion companion = SupportedCardsAdapter.INSTANCE;
        Context context2 = recyclerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "");
        recyclerView.addItemDecoration(SupportedCardsAdapter.Companion.KClassImpl$Data$declaredNonStaticMembers$2(context2, isVertical));
        if (isVertical) {
            linearLayoutManager = new LinearLayoutManager(recyclerView.getContext(), 1, false);
        } else {
            linearLayoutManager = new LinearLayoutManager(recyclerView.getContext(), 0, false);
        }
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    public final void showSupportedCardsView(boolean isShow) {
        TextView textView = getBinding().PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(isShow ? 0 : 8);
        TextView textView2 = getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(textView2, "");
        textView2.setVisibility(isShow ? 0 : 8);
        RecyclerView recyclerView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "");
        recyclerView.setVisibility(isShow ? 0 : 8);
    }

    /* renamed from: $r8$lambda$to-UwKpv5c23FuAy8t6reXoSCkQ  reason: not valid java name */
    public static /* synthetic */ void m483$r8$lambda$toUwKpv5c23FuAy8t6reXoSCkQ(SupportedCardsView supportedCardsView, View view) {
        Intrinsics.checkNotNullParameter(supportedCardsView, "");
        OnClickListener onClickListener = supportedCardsView.getAuthRequestContext;
        if (onClickListener != null) {
            onClickListener.getAuthRequestContext();
        }
    }
}
