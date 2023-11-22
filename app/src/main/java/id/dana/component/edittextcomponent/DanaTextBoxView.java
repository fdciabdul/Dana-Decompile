package id.dana.component.edittextcomponent;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.common.base.Ascii;
import id.dana.component.R;
import id.dana.component.utils.SizeUtil;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\u0011\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001f\u0010\bB#\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010!\u001a\u00020\f¢\u0006\u0004\b\u001f\u0010\"J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\tJ)\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\n¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001d"}, d2 = {"Lid/dana/component/edittextcomponent/DanaTextBoxView;", "Landroidx/appcompat/widget/AppCompatEditText;", "Landroid/content/Context;", "p0", "Landroid/util/AttributeSet;", "p1", "", "MyBillsEntityDataFactory", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "", "focused", "", "direction", "Landroid/graphics/Rect;", "previouslyFocusedRect", "onFocusChanged", "(ZILandroid/graphics/Rect;)V", "", "error", "setError", "(Ljava/lang/CharSequence;)V", "isClearBtnGoneOnFocusRemoved", "setIsClearBtnGoneOnFocusRemoved", "(Z)V", "getAuthRequestContext", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", HummerConstants.CONTEXT, "<init>", "attrs", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes4.dex */
public final class DanaTextBoxView extends AppCompatEditText {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private Drawable MyBillsEntityDataFactory;
    private HashMap MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    public static final byte[] PlaceComponentResult = {120, 42, -65, -64, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int BuiltInFictitiousFunctionClassFactory = 29;

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.MyBillsEntityDataFactory;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i) {
        if (this.MyBillsEntityDataFactory == null) {
            this.MyBillsEntityDataFactory = new HashMap();
        }
        View view = (View) this.MyBillsEntityDataFactory.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            this.MyBillsEntityDataFactory.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaTextBoxView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "");
        MyBillsEntityDataFactory(context, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaTextBoxView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "");
        MyBillsEntityDataFactory(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaTextBoxView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        MyBillsEntityDataFactory(context, attributeSet);
    }

    private final void MyBillsEntityDataFactory(Context p0, AttributeSet p1) {
        if (p1 != null) {
            TypedArray obtainStyledAttributes = p0.getTheme().obtainStyledAttributes(p1, R.styleable.s, 0, 0);
            try {
                this.MyBillsEntityDataFactory = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, R.styleable.r);
                this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getBoolean(R.styleable.SizeSelectors$OrSelector, false);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        setPadding(SizeUtil.PlaceComponentResult(16), SizeUtil.PlaceComponentResult(10), SizeUtil.PlaceComponentResult(8), SizeUtil.PlaceComponentResult(10));
        setBackground(ResourcesCompat.BuiltInFictitiousFunctionClassFactory(getResources(), R.drawable.getErrorConfigVersion, null));
        MyBillsEntityDataFactory(p0);
        setCompoundDrawablesWithIntrinsicBounds(this.MyBillsEntityDataFactory, (Drawable) null, (Drawable) null, (Drawable) null);
        addTextChangedListener(new TextWatcher() { // from class: id.dana.component.edittextcomponent.DanaTextBoxView$setTextChangedListener$1
            @Override // android.text.TextWatcher
            public final void beforeTextChanged(CharSequence p02, int p12, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public final void onTextChanged(CharSequence p02, int p12, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public final void afterTextChanged(Editable p02) {
                Drawable drawable;
                DanaTextBoxView danaTextBoxView = DanaTextBoxView.this;
                drawable = danaTextBoxView.MyBillsEntityDataFactory;
                danaTextBoxView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, ((p02 != null ? p02.length() : 0) > 0 && DanaTextBoxView.this.isClickable() && DanaTextBoxView.this.isEnabled()) ? ResourcesCompat.BuiltInFictitiousFunctionClassFactory(DanaTextBoxView.this.getResources(), R.drawable.initRecordTimeStamp, null) : null, (Drawable) null);
            }
        });
        setOnTouchListener(new View.OnTouchListener() { // from class: id.dana.component.edittextcomponent.DanaTextBoxView$setOnIconTouchListener$1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                Intrinsics.checkNotNullParameter(motionEvent, "");
                if (DanaTextBoxView.this.getCompoundDrawables()[2] == null || motionEvent.getAction() != 1) {
                    return false;
                }
                float rawX = motionEvent.getRawX();
                int right = DanaTextBoxView.this.getRight();
                Intrinsics.checkNotNullExpressionValue(DanaTextBoxView.this.getCompoundDrawables()[2], "");
                if (rawX < right - r1.getBounds().width() || DanaTextBoxView.this.getText() == null) {
                    return false;
                }
                Editable text = DanaTextBoxView.this.getText();
                if (text != null) {
                    text.clear();
                }
                return true;
            }
        });
    }

    private final void MyBillsEntityDataFactory(Context p0) {
        setTypeface(ResourcesCompat.PlaceComponentResult(getContext(), R.font.MyBillsEntityDataFactory));
        setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(p0, R.color.KClassImpl$Data$declaredNonStaticMembers$2));
        setTextSize(2, 16.0f);
    }

    @Override // android.widget.TextView
    public final void setError(CharSequence error) {
        Intrinsics.checkNotNullParameter(error, "");
        setBackground(ResourcesCompat.BuiltInFictitiousFunctionClassFactory(getResources(), R.drawable.lookAheadTest, null));
    }

    public final void setIsClearBtnGoneOnFocusRemoved(boolean isClearBtnGoneOnFocusRemoved) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = isClearBtnGoneOnFocusRemoved;
    }

    @Override // android.widget.TextView, android.view.View
    protected final void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if (focused) {
            setBackground(ResourcesCompat.BuiltInFictitiousFunctionClassFactory(getResources(), R.drawable.NetworkUserEntityData$$ExternalSyntheticLambda0, null));
            Editable text = getText();
            if (text != null) {
                if (text.length() > 0) {
                    setCompoundDrawablesWithIntrinsicBounds(this.MyBillsEntityDataFactory, (Drawable) null, ResourcesCompat.BuiltInFictitiousFunctionClassFactory(getResources(), R.drawable.initRecordTimeStamp, null), (Drawable) null);
                    return;
                }
                return;
            }
            return;
        }
        setBackground(ResourcesCompat.BuiltInFictitiousFunctionClassFactory(getResources(), R.drawable.getErrorConfigVersion, null));
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            setCompoundDrawablesWithIntrinsicBounds(this.MyBillsEntityDataFactory, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x003d -> B:15:0x0046). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray r10, int r11) {
        /*
            byte[] r0 = id.dana.component.edittextcomponent.DanaTextBoxView.PlaceComponentResult
            r1 = 23
            byte[] r1 = new byte[r1]
            r2 = 22
            r3 = 3
            r4 = 0
            if (r0 != 0) goto L15
            r5 = r1
            r6 = 3
            r7 = 0
            r8 = 22
            r1 = r0
            r0 = r11
            r11 = r10
            goto L46
        L15:
            r5 = 97
            r3 = r1
            r6 = 3
            r7 = 0
            r1 = r0
            r0 = r11
            r11 = r10
        L1d:
            byte r8 = (byte) r5
            r3[r7] = r8
            if (r7 != r2) goto L3d
            java.lang.String r1 = new java.lang.String
            r1.<init>(r3, r4)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            boolean r10 = r1.isInstance(r10)
            if (r10 == 0) goto L38
            android.content.Context r11 = (android.content.Context) r11
            android.graphics.drawable.Drawable r10 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r11, r0)
            return r10
        L38:
            android.graphics.drawable.Drawable r10 = r11.getDrawable(r0)
            return r10
        L3d:
            int r7 = r7 + 1
            int r6 = r6 + 1
            r8 = r1[r6]
            r9 = r5
            r5 = r3
            r3 = r9
        L46:
            int r3 = r3 + r8
            int r3 = r3 + (-8)
            r9 = r5
            r5 = r3
            r3 = r9
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.component.edittextcomponent.DanaTextBoxView.__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray, int):android.graphics.drawable.Drawable");
    }
}
