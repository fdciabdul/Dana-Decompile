package id.dana.danapoly.ui.board.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintSet;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.material.imageview.ShapeableImageView;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.danapoly.databinding.ViewDanapolyColorPickerBinding;
import id.dana.danapoly.ui.model.BackgroundColorType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001d¢\u0006\u0004\b \u0010!J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\u000bR5\u0010\u0015\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0005¢\u0006\u0002\b\u000e\u0012\u0004\u0012\u00020\u00070\r8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\f\u001a\u00020\u00168\u0002X\u0083\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018"}, d2 = {"Lid/dana/danapoly/ui/board/view/DanapolyColorPickerView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/danapoly/databinding/ViewDanapolyColorPickerBinding;", "inflateViewBinding", "()Lid/dana/danapoly/databinding/ViewDanapolyColorPickerBinding;", "Lid/dana/danapoly/ui/model/BackgroundColorType;", "backgroundColorType", "", "setSelectedColor", "(Lid/dana/danapoly/ui/model/BackgroundColorType;)V", "setup", "()V", "MyBillsEntityDataFactory", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "getAuthRequestContext", "Lkotlin/jvm/functions/Function1;", "getOnChangeColor", "()Lkotlin/jvm/functions/Function1;", "setOnChangeColor", "(Lkotlin/jvm/functions/Function1;)V", "onChangeColor", "Landroid/view/View;", "BuiltInFictitiousFunctionClassFactory", "Landroid/view/View;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanapolyColorPickerView extends BaseViewBindingRichView<ViewDanapolyColorPickerBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private View MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private Function1<? super BackgroundColorType, Unit> onChangeColor;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[BackgroundColorType.values().length];
            iArr[BackgroundColorType.BLUE.ordinal()] = 1;
            iArr[BackgroundColorType.GREEN.ordinal()] = 2;
            iArr[BackgroundColorType.PURPLE.ordinal()] = 3;
            iArr[BackgroundColorType.ORANGE.ordinal()] = 4;
            iArr[BackgroundColorType.PINK.ordinal()] = 5;
            BuiltInFictitiousFunctionClassFactory = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DanapolyColorPickerView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DanapolyColorPickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DanapolyColorPickerView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public /* synthetic */ DanapolyColorPickerView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanapolyColorPickerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        View view = getBinding().scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(view, "");
        this.MyBillsEntityDataFactory = view;
        this.onChangeColor = new Function1<BackgroundColorType, Unit>() { // from class: id.dana.danapoly.ui.board.view.DanapolyColorPickerView$onChangeColor$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(BackgroundColorType backgroundColorType) {
                Intrinsics.checkNotNullParameter(backgroundColorType, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(BackgroundColorType backgroundColorType) {
                invoke2(backgroundColorType);
                return Unit.INSTANCE;
            }
        };
    }

    @JvmName(name = "getOnChangeColor")
    public final Function1<BackgroundColorType, Unit> getOnChangeColor() {
        return this.onChangeColor;
    }

    @JvmName(name = "setOnChangeColor")
    public final void setOnChangeColor(Function1<? super BackgroundColorType, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        this.onChangeColor = function1;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewDanapolyColorPickerBinding inflateViewBinding() {
        ViewDanapolyColorPickerBinding MyBillsEntityDataFactory = ViewDanapolyColorPickerBinding.MyBillsEntityDataFactory(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    private final void MyBillsEntityDataFactory() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.getAuthRequestContext(getBinding().PlaceComponentResult);
        constraintSet.BuiltInFictitiousFunctionClassFactory(getBinding().MyBillsEntityDataFactory.getId(), 3, this.MyBillsEntityDataFactory.getId(), 3);
        constraintSet.BuiltInFictitiousFunctionClassFactory(getBinding().MyBillsEntityDataFactory.getId(), 4, this.MyBillsEntityDataFactory.getId(), 4);
        constraintSet.BuiltInFictitiousFunctionClassFactory(getBinding().MyBillsEntityDataFactory.getId(), 6, this.MyBillsEntityDataFactory.getId(), 6);
        constraintSet.BuiltInFictitiousFunctionClassFactory(getBinding().MyBillsEntityDataFactory.getId(), 7, this.MyBillsEntityDataFactory.getId(), 7);
        constraintSet.KClassImpl$Data$declaredNonStaticMembers$2(getBinding().PlaceComponentResult);
        AppCompatImageView appCompatImageView = getBinding().MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(0);
    }

    public final void setSelectedColor(BackgroundColorType backgroundColorType) {
        ShapeableImageView shapeableImageView;
        Intrinsics.checkNotNullParameter(backgroundColorType, "");
        int i = WhenMappings.BuiltInFictitiousFunctionClassFactory[backgroundColorType.ordinal()];
        if (i == 1) {
            ShapeableImageView shapeableImageView2 = getBinding().BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(shapeableImageView2, "");
            shapeableImageView = shapeableImageView2;
        } else if (i == 2) {
            ShapeableImageView shapeableImageView3 = getBinding().getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(shapeableImageView3, "");
            shapeableImageView = shapeableImageView3;
        } else if (i == 3) {
            ShapeableImageView shapeableImageView4 = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0;
            Intrinsics.checkNotNullExpressionValue(shapeableImageView4, "");
            shapeableImageView = shapeableImageView4;
        } else if (i == 4) {
            ShapeableImageView shapeableImageView5 = getBinding().moveToNextValue;
            Intrinsics.checkNotNullExpressionValue(shapeableImageView5, "");
            shapeableImageView = shapeableImageView5;
        } else if (i != 5) {
            throw new NoWhenBranchMatchedException();
        } else {
            ShapeableImageView shapeableImageView6 = getBinding().lookAheadTest;
            Intrinsics.checkNotNullExpressionValue(shapeableImageView6, "");
            shapeableImageView = shapeableImageView6;
        }
        if (Intrinsics.areEqual(shapeableImageView, getBinding().scheduleImpl)) {
            return;
        }
        this.MyBillsEntityDataFactory = shapeableImageView;
        MyBillsEntityDataFactory();
    }

    public static /* synthetic */ void $r8$lambda$82bIApyZwVrDR77lOsaj1Xv_WUI(DanapolyColorPickerView danapolyColorPickerView, View view) {
        Intrinsics.checkNotNullParameter(danapolyColorPickerView, "");
        ShapeableImageView shapeableImageView = danapolyColorPickerView.getBinding().moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(shapeableImageView, "");
        ShapeableImageView shapeableImageView2 = shapeableImageView;
        if (!Intrinsics.areEqual(shapeableImageView2, danapolyColorPickerView.getBinding().scheduleImpl)) {
            danapolyColorPickerView.MyBillsEntityDataFactory = shapeableImageView2;
            danapolyColorPickerView.MyBillsEntityDataFactory();
        }
        danapolyColorPickerView.onChangeColor.invoke(BackgroundColorType.ORANGE);
    }

    public static /* synthetic */ void $r8$lambda$E0VYAKgesLqDs1r6kBeahtbzu9o(DanapolyColorPickerView danapolyColorPickerView, View view) {
        Intrinsics.checkNotNullParameter(danapolyColorPickerView, "");
        ShapeableImageView shapeableImageView = danapolyColorPickerView.getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(shapeableImageView, "");
        ShapeableImageView shapeableImageView2 = shapeableImageView;
        if (!Intrinsics.areEqual(shapeableImageView2, danapolyColorPickerView.getBinding().scheduleImpl)) {
            danapolyColorPickerView.MyBillsEntityDataFactory = shapeableImageView2;
            danapolyColorPickerView.MyBillsEntityDataFactory();
        }
        danapolyColorPickerView.onChangeColor.invoke(BackgroundColorType.GREEN);
    }

    /* renamed from: $r8$lambda$HOiA4ZjMf6Y2DkJoIN5oImyRv-g */
    public static /* synthetic */ void m730$r8$lambda$HOiA4ZjMf6Y2DkJoIN5oImyRvg(DanapolyColorPickerView danapolyColorPickerView, View view) {
        Intrinsics.checkNotNullParameter(danapolyColorPickerView, "");
        ShapeableImageView shapeableImageView = danapolyColorPickerView.getBinding().BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(shapeableImageView, "");
        ShapeableImageView shapeableImageView2 = shapeableImageView;
        if (!Intrinsics.areEqual(shapeableImageView2, danapolyColorPickerView.getBinding().scheduleImpl)) {
            danapolyColorPickerView.MyBillsEntityDataFactory = shapeableImageView2;
            danapolyColorPickerView.MyBillsEntityDataFactory();
        }
        danapolyColorPickerView.onChangeColor.invoke(BackgroundColorType.BLUE);
    }

    public static /* synthetic */ void $r8$lambda$_u60L8CXsrn2JNsh6WmKFy3CLYg(DanapolyColorPickerView danapolyColorPickerView, View view) {
        Intrinsics.checkNotNullParameter(danapolyColorPickerView, "");
        ShapeableImageView shapeableImageView = danapolyColorPickerView.getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0;
        Intrinsics.checkNotNullExpressionValue(shapeableImageView, "");
        ShapeableImageView shapeableImageView2 = shapeableImageView;
        if (!Intrinsics.areEqual(shapeableImageView2, danapolyColorPickerView.getBinding().scheduleImpl)) {
            danapolyColorPickerView.MyBillsEntityDataFactory = shapeableImageView2;
            danapolyColorPickerView.MyBillsEntityDataFactory();
        }
        danapolyColorPickerView.onChangeColor.invoke(BackgroundColorType.PURPLE);
    }

    public static /* synthetic */ void $r8$lambda$m9plM9wsnvyIqF0Iy59Wqe8zHqA(DanapolyColorPickerView danapolyColorPickerView, View view) {
        Intrinsics.checkNotNullParameter(danapolyColorPickerView, "");
        ShapeableImageView shapeableImageView = danapolyColorPickerView.getBinding().lookAheadTest;
        Intrinsics.checkNotNullExpressionValue(shapeableImageView, "");
        ShapeableImageView shapeableImageView2 = shapeableImageView;
        if (!Intrinsics.areEqual(shapeableImageView2, danapolyColorPickerView.getBinding().scheduleImpl)) {
            danapolyColorPickerView.MyBillsEntityDataFactory = shapeableImageView2;
            danapolyColorPickerView.MyBillsEntityDataFactory();
        }
        danapolyColorPickerView.onChangeColor.invoke(BackgroundColorType.PINK);
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        getBinding().BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.danapoly.ui.board.view.DanapolyColorPickerView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DanapolyColorPickerView.m730$r8$lambda$HOiA4ZjMf6Y2DkJoIN5oImyRvg(DanapolyColorPickerView.this, view);
            }
        });
        getBinding().getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.danapoly.ui.board.view.DanapolyColorPickerView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DanapolyColorPickerView.$r8$lambda$E0VYAKgesLqDs1r6kBeahtbzu9o(DanapolyColorPickerView.this, view);
            }
        });
        getBinding().lookAheadTest.setOnClickListener(new View.OnClickListener() { // from class: id.dana.danapoly.ui.board.view.DanapolyColorPickerView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DanapolyColorPickerView.$r8$lambda$m9plM9wsnvyIqF0Iy59Wqe8zHqA(DanapolyColorPickerView.this, view);
            }
        });
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setOnClickListener(new View.OnClickListener() { // from class: id.dana.danapoly.ui.board.view.DanapolyColorPickerView$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DanapolyColorPickerView.$r8$lambda$_u60L8CXsrn2JNsh6WmKFy3CLYg(DanapolyColorPickerView.this, view);
            }
        });
        getBinding().moveToNextValue.setOnClickListener(new View.OnClickListener() { // from class: id.dana.danapoly.ui.board.view.DanapolyColorPickerView$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DanapolyColorPickerView.$r8$lambda$82bIApyZwVrDR77lOsaj1Xv_WUI(DanapolyColorPickerView.this, view);
            }
        });
    }
}
