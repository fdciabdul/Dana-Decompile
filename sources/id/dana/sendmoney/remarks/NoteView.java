package id.dana.sendmoney.remarks;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.OnClick;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.data.config.source.amcs.result.MaintenanceBroadcastResult;
import id.dana.sendmoney.remarks.NoteBottomSheetDialogFragment;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u0000 22\u00020\u0001:\u000223B'\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010-\u001a\u00020\u0002¢\u0006\u0004\b.\u0010/B+\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010-\u001a\u00020\u0002\u0012\u0006\u00100\u001a\u00020\u0002¢\u0006\u0004\b.\u00101J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0007R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010 \u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004\"\u0004\b\u001e\u0010\u001fR*\u0010)\u001a\u00020!2\u0006\u0010\"\u001a\u00020!8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0016\u0010\u001b\u001a\u00020*8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b+\u0010,"}, d2 = {"Lid/dana/sendmoney/remarks/NoteView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "", "onBtnActionClicked", "()V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", MaintenanceBroadcastResult.KEY_VISIBLE, "setRemarksActionButtonVisible", "(Z)V", "setup", "Lid/dana/sendmoney/remarks/NoteView$Listener;", "getAuthRequestContext", "Lid/dana/sendmoney/remarks/NoteView$Listener;", "getListener", "()Lid/dana/sendmoney/remarks/NoteView$Listener;", "setListener", "(Lid/dana/sendmoney/remarks/NoteView$Listener;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "KClassImpl$Data$declaredNonStaticMembers$2", "I", "getMaxNoteChar", "setMaxNoteChar", "(I)V", "maxNoteChar", "", "value", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "getRemarks", "()Ljava/lang/String;", "setRemarks", "(Ljava/lang/String;)V", "remarks", "", "MyBillsEntityDataFactory", LogConstants.RESULT_FALSE, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "Listener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NoteView extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private String remarks;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private int maxNoteChar;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private float KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private Listener listener;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/sendmoney/remarks/NoteView$Listener;", "", "", "getAuthRequestContext", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Listener {
        void getAuthRequestContext();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NoteView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NoteView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_remarks;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.remarks = "";
        this.maxNoteChar = 50;
    }

    public /* synthetic */ NoteView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoteView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.remarks = "";
        this.maxNoteChar = 50;
    }

    @JvmName(name = "getRemarks")
    public final String getRemarks() {
        return this.remarks;
    }

    @JvmName(name = "setRemarks")
    public final void setRemarks(String str) {
        String str2;
        String string;
        Intrinsics.checkNotNullParameter(str, "");
        if (StringsKt.isBlank(str)) {
            str = "";
        }
        this.remarks = str;
        String str3 = str;
        boolean isBlank = StringsKt.isBlank(str3);
        Button button = (Button) _$_findCachedViewById(R.id.f);
        if (button != null) {
            if (isBlank) {
                string = getContext().getString(R.string.sendmoney_remarks_empty_action);
            } else {
                string = getContext().getString(R.string.fill_note_message_title_option);
            }
            button.setText(string);
        }
        TextView textView = (TextView) _$_findCachedViewById(R.id.setDrawValueAboveBar);
        if (textView != null) {
            if (StringsKt.isBlank(str3)) {
                str2 = getContext().getString(R.string.sendmoney_remarks_add);
            } else {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("\"%s\"", Arrays.copyOf(new Object[]{str}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "");
                str2 = format;
            }
            textView.setText(str2);
        }
        boolean isBlank2 = StringsKt.isBlank(str3);
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.BarLineScatterCandleBubbleRenderer$XBounds);
        if (textView2 != null) {
            textView2.setVisibility(isBlank2 ? 8 : 0);
        }
    }

    @JvmName(name = "getListener")
    public final Listener getListener() {
        return this.listener;
    }

    @JvmName(name = "setListener")
    public final void setListener(Listener listener) {
        this.listener = listener;
    }

    @JvmName(name = "getMaxNoteChar")
    public final int getMaxNoteChar() {
        return this.maxNoteChar;
    }

    @JvmName(name = "setMaxNoteChar")
    public final void setMaxNoteChar(int i) {
        this.maxNoteChar = i;
    }

    @Override // id.dana.base.BaseRichView
    public final void parseAttrs(Context context, AttributeSet attrs) {
        Intrinsics.checkNotNullParameter(context, "");
        if (attrs != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.GetTopUpUserConsult);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "");
            try {
                float dimension = obtainStyledAttributes.getDimension(0, -99.0f);
                obtainStyledAttributes.recycle();
                this.KClassImpl$Data$declaredNonStaticMembers$2 = dimension;
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        }
    }

    @OnClick({R.id.btn_action})
    public final void onBtnActionClicked() {
        NoteBottomSheetDialogFragment PlaceComponentResult;
        Listener listener = this.listener;
        if (listener != null) {
            listener.getAuthRequestContext();
        }
        NoteBottomSheetDialogFragment.Companion companion = NoteBottomSheetDialogFragment.INSTANCE;
        PlaceComponentResult = NoteBottomSheetDialogFragment.Companion.PlaceComponentResult(this.remarks);
        Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: id.dana.sendmoney.remarks.NoteView$showRemarkInputDialog$1$1
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
                NoteView.this.setRemarks(str);
            }
        };
        Intrinsics.checkNotNullParameter(function1, "");
        PlaceComponentResult.BuiltInFictitiousFunctionClassFactory = function1;
        PlaceComponentResult.show(getBaseActivity().getSupportFragmentManager(), "");
    }

    public final void setRemarksActionButtonVisible(boolean visible) {
        Button button = (Button) _$_findCachedViewById(R.id.f);
        if (button != null) {
            button.setVisibility(visible ? 0 : 8);
        }
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        ConstraintLayout constraintLayout;
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 <= 0.0f || (constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.cl_notes_remarks)) == null) {
            return;
        }
        int i = (int) this.KClassImpl$Data$declaredNonStaticMembers$2;
        constraintLayout.setPadding(i, i, i, i);
    }
}
