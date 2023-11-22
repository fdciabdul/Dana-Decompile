package id.dana.richview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.alibaba.griver.api.constants.GriverEvents;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.material.button.MaterialButton;
import id.dana.R;
import id.dana.base.BaseRichView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0016\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u00101\u001a\u00020\u0002¢\u0006\u0004\b2\u00103B+\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u00101\u001a\u00020\u0002\u0012\u0006\u00104\u001a\u00020\u0002¢\u0006\u0004\b2\u00105J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R*\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00128\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00128\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R*\u0010&\u001a\u00020\u001f2\u0006\u0010\u0013\u001a\u00020\u001f8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R*\u0010,\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00028\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\u0004\"\u0004\b*\u0010+R*\u00100\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00128\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0015\u001a\u0004\b.\u0010\u0017\"\u0004\b/\u0010\u0019"}, d2 = {"Lid/dana/richview/EmptyStateView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/view/View$OnClickListener;", "onClickListener", "setOnActionClickListener", "(Landroid/view/View$OnClickListener;)V", "setup", "()V", "", "value", "getAuthRequestContext", "Ljava/lang/String;", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "action", "MyBillsEntityDataFactory", "getDesc", "setDesc", "desc", "", "BuiltInFictitiousFunctionClassFactory", "Z", "getHasAction", "()Z", "setHasAction", "(Z)V", "hasAction", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "getIcon", "setIcon", "(I)V", "icon", "PlaceComponentResult", "getTitle", GriverEvents.EVENT_SET_TITLE, "title", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EmptyStateView extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private boolean hasAction;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private int icon;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private String desc;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private String title;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private String action;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmptyStateView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmptyStateView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_empty_state_small_btn;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyStateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.icon = R.drawable.ic_general_empty_state;
        this.title = "";
        this.desc = "";
        this.action = "";
    }

    public /* synthetic */ EmptyStateView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyStateView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.icon = R.drawable.ic_general_empty_state;
        this.title = "";
        this.desc = "";
        this.action = "";
    }

    @JvmName(name = "getIcon")
    public final int getIcon() {
        return this.icon;
    }

    @JvmName(name = "setIcon")
    public final void setIcon(int i) {
        this.icon = i;
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.GetLeaderboardEntryBanner);
        if (appCompatImageView != null) {
            appCompatImageView.setImageDrawable(ContextCompat.PlaceComponentResult(getContext(), i));
        }
    }

    @JvmName(name = "getTitle")
    public final String getTitle() {
        return this.title;
    }

    @JvmName(name = GriverEvents.EVENT_SET_TITLE)
    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.title = str;
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.getLogSourceName);
        if (appCompatTextView != null) {
            appCompatTextView.setText(str);
        }
    }

    @JvmName(name = "getDesc")
    public final String getDesc() {
        return this.desc;
    }

    @JvmName(name = "setDesc")
    public final void setDesc(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.desc = str;
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.setupWithViewPager);
        if (appCompatTextView != null) {
            appCompatTextView.setText(str);
        }
    }

    @JvmName(name = "getAction")
    public final String getAction() {
        return this.action;
    }

    @JvmName(name = "setAction")
    public final void setAction(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.action = str;
        MaterialButton materialButton = (MaterialButton) _$_findCachedViewById(R.id.PrepareContext_res_0x7f0a011e);
        if (materialButton != null) {
            materialButton.setText(str);
        }
    }

    @JvmName(name = "getHasAction")
    public final boolean getHasAction() {
        return this.hasAction;
    }

    @JvmName(name = "setHasAction")
    public final void setHasAction(boolean z) {
        this.hasAction = z;
        MaterialButton materialButton = (MaterialButton) _$_findCachedViewById(R.id.PrepareContext_res_0x7f0a011e);
        Intrinsics.checkNotNullExpressionValue(materialButton, "");
        materialButton.setVisibility(z ? 0 : 8);
    }

    @Override // id.dana.base.BaseRichView
    public final void parseAttrs(Context context, AttributeSet attrs) {
        if (attrs != null) {
            setStyledAttributes(context, attrs, R.styleable.v);
            try {
                setIcon(getStyledAttributes().getResourceId(5, R.drawable.ic_general_empty_state));
                String string = getStyledAttributes().getString(6);
                String str = "";
                if (string == null) {
                    string = "";
                }
                setTitle(string);
                String string2 = getStyledAttributes().getString(4);
                if (string2 == null) {
                    string2 = "";
                }
                setDesc(string2);
                String string3 = getStyledAttributes().getString(3);
                if (string3 != null) {
                    str = string3;
                }
                setAction(str);
                setHasAction(getStyledAttributes().getBoolean(9, false));
            } finally {
                getStyledAttributes().recycle();
            }
        }
    }

    public final void setOnActionClickListener(View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "");
        MaterialButton materialButton = (MaterialButton) _$_findCachedViewById(R.id.PrepareContext_res_0x7f0a011e);
        if (materialButton != null) {
            materialButton.setOnClickListener(onClickListener);
        }
    }
}
