package id.dana.danapoly.ui.board.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.common.base.Ascii;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.danapoly.R;
import id.dana.danapoly.databinding.ViewDanapolyBoardInfoBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001c¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R(\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u00128\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/danapoly/ui/board/view/DanapolyPromptInfoView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/danapoly/databinding/ViewDanapolyBoardInfoBinding;", "inflateViewBinding", "()Lid/dana/danapoly/databinding/ViewDanapolyBoardInfoBinding;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "setup", "()V", "Landroid/graphics/drawable/Drawable;", "MyBillsEntityDataFactory", "Landroid/graphics/drawable/Drawable;", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "getOnCloseIconClicked", "()Lkotlin/jvm/functions/Function0;", "setOnCloseIconClicked", "(Lkotlin/jvm/functions/Function0;)V", "onCloseIconClicked", "", "PlaceComponentResult", "Ljava/lang/String;", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanapolyPromptInfoView extends BaseViewBindingRichView<ViewDanapolyBoardInfoBinding> {
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {95, 85, -94, TarHeader.LF_SYMLINK, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int getAuthRequestContext = 97;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private Function0<Unit> onCloseIconClicked;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private Drawable BuiltInFictitiousFunctionClassFactory;
    private String PlaceComponentResult;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DanapolyPromptInfoView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DanapolyPromptInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DanapolyPromptInfoView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public /* synthetic */ DanapolyPromptInfoView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanapolyPromptInfoView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this.PlaceComponentResult = "";
        this.onCloseIconClicked = new Function0<Unit>() { // from class: id.dana.danapoly.ui.board.view.DanapolyPromptInfoView$onCloseIconClicked$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
    }

    @JvmName(name = "getOnCloseIconClicked")
    public final Function0<Unit> getOnCloseIconClicked() {
        return this.onCloseIconClicked;
    }

    @JvmName(name = "setOnCloseIconClicked")
    public final void setOnCloseIconClicked(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        this.onCloseIconClicked = function0;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewDanapolyBoardInfoBinding inflateViewBinding() {
        ViewDanapolyBoardInfoBinding authRequestContext = ViewDanapolyBoardInfoBinding.getAuthRequestContext(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        Unit unit;
        getBinding().PlaceComponentResult.setText(this.PlaceComponentResult);
        getBinding().MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.danapoly.ui.board.view.DanapolyPromptInfoView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DanapolyPromptInfoView.$r8$lambda$e0tybCRlDk6w5ISBIvcSGx8LPdo(DanapolyPromptInfoView.this, view);
            }
        });
        Drawable drawable = this.BuiltInFictitiousFunctionClassFactory;
        if (drawable != null) {
            AppCompatImageView appCompatImageView = getBinding().getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
            appCompatImageView.setVisibility(0);
            getBinding().getAuthRequestContext.setImageDrawable(drawable);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            AppCompatImageView appCompatImageView2 = getBinding().getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
            appCompatImageView2.setVisibility(8);
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void parseAttrs(Context context, AttributeSet attrs) {
        TypedArray obtainStyledAttributes = context != null ? context.obtainStyledAttributes(attrs, R.styleable.W) : null;
        if (obtainStyledAttributes != null) {
            try {
                String string = obtainStyledAttributes.getString(R.styleable.Z);
                if (string == null) {
                    string = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(string, "");
                }
                this.PlaceComponentResult = string;
                this.BuiltInFictitiousFunctionClassFactory = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, R.styleable.flip);
            } finally {
                if (obtainStyledAttributes != null) {
                    obtainStyledAttributes.recycle();
                }
            }
        }
    }

    public static /* synthetic */ void $r8$lambda$e0tybCRlDk6w5ISBIvcSGx8LPdo(DanapolyPromptInfoView danapolyPromptInfoView, View view) {
        Intrinsics.checkNotNullParameter(danapolyPromptInfoView, "");
        danapolyPromptInfoView.onCloseIconClicked.invoke();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x003f -> B:15:0x0048). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray r11, int r12) {
        /*
            byte[] r0 = id.dana.danapoly.ui.board.view.DanapolyPromptInfoView.KClassImpl$Data$declaredNonStaticMembers$2
            r1 = 23
            byte[] r2 = new byte[r1]
            r3 = 0
            r4 = 3
            if (r0 != 0) goto L13
            r5 = r2
            r6 = 3
            r7 = 23
            r9 = 0
            r2 = r0
            r0 = r12
            r12 = r11
            goto L48
        L13:
            r5 = 97
            r4 = r2
            r5 = 3
            r6 = 97
            r7 = 0
            r2 = r0
            r0 = r12
            r12 = r11
        L1d:
            byte r8 = (byte) r6
            int r9 = r7 + 1
            r4[r7] = r8
            if (r9 != r1) goto L3f
            java.lang.String r1 = new java.lang.String
            r1.<init>(r4, r3)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            boolean r11 = r1.isInstance(r11)
            if (r11 == 0) goto L3a
            android.content.Context r12 = (android.content.Context) r12
            android.graphics.drawable.Drawable r11 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r12, r0)
            return r11
        L3a:
            android.graphics.drawable.Drawable r11 = r12.getDrawable(r0)
            return r11
        L3f:
            int r5 = r5 + 1
            r7 = r2[r5]
            r10 = r5
            r5 = r4
            r4 = r7
            r7 = r6
            r6 = r10
        L48:
            int r7 = r7 + r4
            int r4 = r7 + (-8)
            r7 = r9
            r10 = r6
            r6 = r4
            r4 = r5
            r5 = r10
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danapoly.ui.board.view.DanapolyPromptInfoView.__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray, int):android.graphics.drawable.Drawable");
    }
}
