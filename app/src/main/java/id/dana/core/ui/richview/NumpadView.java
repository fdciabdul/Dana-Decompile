package id.dana.core.ui.richview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.core.ui.adapter.NumpadAdapter;
import id.dana.core.ui.databinding.ViewNumpadBinding;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000201B/\u0012\u0006\u0010)\u001a\u00020(\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*\u0012\b\b\u0002\u0010,\u001a\u00020$\u0012\b\b\u0002\u0010-\u001a\u00020$¢\u0006\u0004\b.\u0010/J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\u0005J\u0015\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001a\u0010\u0005J\u0013\u0010\u001b\u001a\u00020\u0006*\u00020\nH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u0007\u001a\u00020\u0006*\u00020\nH\u0002¢\u0006\u0004\b\u0007\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u0006*\u00020\nH\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ\u0013\u0010\u000b\u001a\u00020\u0006*\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\u001cJ\u0013\u0010\u000f\u001a\u00020\u0006*\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\u001cJ\u0013\u0010\u001e\u001a\u00020\u0006*\u00020\nH\u0002¢\u0006\u0004\b\u001e\u0010\u001cJ\u0013\u0010\u001f\u001a\u00020\u0006*\u00020\nH\u0002¢\u0006\u0004\b\u001f\u0010\u001cJ\u0013\u0010 \u001a\u00020\u0006*\u00020\nH\u0002¢\u0006\u0004\b \u0010\u001cR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010!R\u0016\u0010\u000f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\"R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010#R\u0016\u0010\u001b\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010%R\u0016\u0010\u0007\u001a\u00020&8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000b\u0010'"}, d2 = {"Lid/dana/core/ui/richview/NumpadView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/core/ui/databinding/ViewNumpadBinding;", "", "clearAmount", "()V", "", "MyBillsEntityDataFactory", "()Z", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Ljava/util/List;", "inflateViewBinding", "()Lid/dana/core/ui/databinding/ViewNumpadBinding;", "PlaceComponentResult", "currentAmount", "setAmount", "(Ljava/lang/String;)V", "isEnable", "setDecimalPointEnabled", "(Z)V", "Lid/dana/core/ui/richview/NumpadView$NumpadClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setListener", "(Lid/dana/core/ui/richview/NumpadView$NumpadClickListener;)V", "setup", "getAuthRequestContext", "(Ljava/lang/String;)Z", "BuiltInFictitiousFunctionClassFactory", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getErrorConfigVersion", "Ljava/lang/String;", "Z", "Lid/dana/core/ui/richview/NumpadView$NumpadClickListener;", "", "I", "Lid/dana/core/ui/adapter/NumpadAdapter;", "Lid/dana/core/ui/adapter/NumpadAdapter;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "NumpadClickListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NumpadView extends BaseViewBindingRichView<ViewNumpadBinding> {
    public static final String NUMPAD_DELETE = "delete";

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private NumpadAdapter MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private int getAuthRequestContext;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private NumpadClickListener BuiltInFictitiousFunctionClassFactory;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/core/ui/richview/NumpadView$NumpadClickListener;", "", "", "p0", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface NumpadClickListener {
        void MyBillsEntityDataFactory(String p0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NumpadView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NumpadView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NumpadView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
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
    public NumpadView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = "";
        this.getAuthRequestContext = 8;
    }

    public /* synthetic */ NumpadView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        PlaceComponentResult();
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewNumpadBinding inflateViewBinding() {
        ViewNumpadBinding authRequestContext = ViewNumpadBinding.getAuthRequestContext(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    public final void setListener(NumpadClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "");
        this.BuiltInFictitiousFunctionClassFactory = listener;
    }

    public final void clearAmount() {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = "";
    }

    public final void setAmount(String currentAmount) {
        Intrinsics.checkNotNullParameter(currentAmount, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = currentAmount;
    }

    public final void setDecimalPointEnabled(boolean isEnable) {
        this.PlaceComponentResult = isEnable;
        PlaceComponentResult();
    }

    private final void PlaceComponentResult() {
        this.MyBillsEntityDataFactory = new NumpadAdapter(KClassImpl$Data$declaredNonStaticMembers$2(), new Function1<String, Unit>() { // from class: id.dana.core.ui.richview.NumpadView$initRecyclerView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                NumpadView.access$onItemClicked(NumpadView.this, str);
            }
        });
        RecyclerView recyclerView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        NumpadAdapter numpadAdapter = this.MyBillsEntityDataFactory;
        if (numpadAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            numpadAdapter = null;
        }
        recyclerView.setAdapter(numpadAdapter);
    }

    private static boolean getErrorConfigVersion(String str) {
        return Intrinsics.areEqual(str, "0") || Intrinsics.areEqual(str, "000");
    }

    private static boolean MyBillsEntityDataFactory(String str) {
        return Intrinsics.areEqual(str, ",");
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(String str) {
        return StringsKt.contains$default((CharSequence) str, (CharSequence) ".", false, 2, (Object) null);
    }

    private static boolean getAuthRequestContext(String str) {
        return BuiltInFictitiousFunctionClassFactory(str) && StringsKt.substringAfter$default(str, ".", (String) null, 2, (Object) null).length() == 2;
    }

    private static boolean PlaceComponentResult(String str) {
        Character lastOrNull = StringsKt.lastOrNull(str);
        return lastOrNull != null && lastOrNull.charValue() == '.';
    }

    private final boolean moveToNextValue(String str) {
        return StringsKt.replace$default(str, ".", "", false, 4, (Object) null).length() <= this.getAuthRequestContext;
    }

    private final boolean MyBillsEntityDataFactory() {
        return this.getAuthRequestContext - StringsKt.replace$default(this.KClassImpl$Data$declaredNonStaticMembers$2, ".", "", false, 4, (Object) null).length() < 3;
    }

    private final List<String> KClassImpl$Data$declaredNonStaticMembers$2() {
        ArrayList arrayList = new ArrayList();
        for (int i = 1; i < 10; i++) {
            arrayList.add(String.valueOf(i));
        }
        if (!this.PlaceComponentResult) {
            arrayList.add("0");
            arrayList.add("000");
        } else {
            arrayList.add(",");
            arrayList.add("0");
        }
        arrayList.add("delete");
        return arrayList;
    }

    public static final /* synthetic */ void access$onItemClicked(NumpadView numpadView, String str) {
        if (!Intrinsics.areEqual(str, "delete")) {
            if ((numpadView.KClassImpl$Data$declaredNonStaticMembers$2.length() == 0) && getErrorConfigVersion(str)) {
                NumpadClickListener numpadClickListener = numpadView.BuiltInFictitiousFunctionClassFactory;
                if (numpadClickListener != null) {
                    numpadClickListener.MyBillsEntityDataFactory("0");
                    return;
                }
                return;
            }
            if ((numpadView.KClassImpl$Data$declaredNonStaticMembers$2.length() == 0) && MyBillsEntityDataFactory(str)) {
                numpadView.KClassImpl$Data$declaredNonStaticMembers$2 = "0.";
                NumpadClickListener numpadClickListener2 = numpadView.BuiltInFictitiousFunctionClassFactory;
                if (numpadClickListener2 != null) {
                    numpadClickListener2.MyBillsEntityDataFactory("0.");
                    return;
                }
                return;
            } else if (PlaceComponentResult(numpadView.KClassImpl$Data$declaredNonStaticMembers$2) && MyBillsEntityDataFactory(str)) {
                NumpadClickListener numpadClickListener3 = numpadView.BuiltInFictitiousFunctionClassFactory;
                if (numpadClickListener3 != null) {
                    numpadClickListener3.MyBillsEntityDataFactory(numpadView.KClassImpl$Data$declaredNonStaticMembers$2);
                    return;
                }
                return;
            } else if (!getAuthRequestContext(numpadView.KClassImpl$Data$declaredNonStaticMembers$2)) {
                if (Intrinsics.areEqual(str, "000") && numpadView.MyBillsEntityDataFactory()) {
                    str = StringsKt.dropLast("000", 3 - (numpadView.getAuthRequestContext - numpadView.KClassImpl$Data$declaredNonStaticMembers$2.length()));
                }
                String str2 = str;
                StringBuilder sb = new StringBuilder();
                sb.append(numpadView.KClassImpl$Data$declaredNonStaticMembers$2);
                sb.append(StringsKt.replace$default(str2, ",", ".", false, 4, (Object) null));
                String obj = sb.toString();
                if (numpadView.moveToNextValue(obj)) {
                    numpadView.KClassImpl$Data$declaredNonStaticMembers$2 = obj;
                    NumpadClickListener numpadClickListener4 = numpadView.BuiltInFictitiousFunctionClassFactory;
                    if (numpadClickListener4 != null) {
                        numpadClickListener4.MyBillsEntityDataFactory(obj);
                        return;
                    }
                    return;
                }
                return;
            } else {
                NumpadClickListener numpadClickListener5 = numpadView.BuiltInFictitiousFunctionClassFactory;
                if (numpadClickListener5 != null) {
                    numpadClickListener5.MyBillsEntityDataFactory(numpadView.KClassImpl$Data$declaredNonStaticMembers$2);
                    return;
                }
                return;
            }
        }
        String dropLast = StringsKt.dropLast(numpadView.KClassImpl$Data$declaredNonStaticMembers$2, 1);
        numpadView.KClassImpl$Data$declaredNonStaticMembers$2 = dropLast;
        NumpadClickListener numpadClickListener6 = numpadView.BuiltInFictitiousFunctionClassFactory;
        if (numpadClickListener6 != null) {
            numpadClickListener6.MyBillsEntityDataFactory(dropLast);
        }
    }
}
