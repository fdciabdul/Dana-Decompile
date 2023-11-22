package id.dana.ocr.preview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.iap.ac.android.common.container.provider.ui.ContainerUIProvider;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.base.LockableBaseBottomSheetBehavior;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.BottomSheetPromptComponent;
import id.dana.di.component.DaggerBottomSheetPromptComponent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u000201B'\b\u0016\u0012\u0006\u0010(\u001a\u00020'\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)\u0012\b\b\u0002\u0010+\u001a\u00020\u0002¢\u0006\u0004\b,\u0010-B+\b\u0016\u0012\u0006\u0010(\u001a\u00020'\u0012\b\u0010*\u001a\u0004\u0018\u00010)\u0012\u0006\u0010+\u001a\u00020\u0002\u0012\u0006\u0010.\u001a\u00020\u0002¢\u0006\u0004\b,\u0010/J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\u0007J\u0019\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u000e¢\u0006\u0004\b\u0017\u0010\u0011J\u0015\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u000e¢\u0006\u0004\b\u0019\u0010\u0011J\u000f\u0010\u001a\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u0007J\r\u0010\u001b\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u0007R\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010!\u001a\u00020$8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b%\u0010&"}, d2 = {"Lid/dana/ocr/preview/BottomSheetPromptView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "", "hide", "()V", "initBottomSheet", "initViews", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "", "headerText", "setHeader", "(Ljava/lang/String;)V", "Lid/dana/ocr/preview/BottomSheetPromptView$BottomSheetPromptCallback;", "bottomSheetPromptCallback", "setListener", "(Lid/dana/ocr/preview/BottomSheetPromptView$BottomSheetPromptCallback;)V", "negativeButtonMessage", "setNegativeButtonText", "positiveButtonMessage", "setPositiveButtonText", "setup", ContainerUIProvider.KEY_SHOW, "Lid/dana/base/LockableBaseBottomSheetBehavior;", "Landroidx/cardview/widget/CardView;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/base/LockableBaseBottomSheetBehavior;", "MyBillsEntityDataFactory", "PlaceComponentResult", "Lid/dana/ocr/preview/BottomSheetPromptView$BottomSheetPromptCallback;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/di/component/BottomSheetPromptComponent;", "getAuthRequestContext", "Lid/dana/di/component/BottomSheetPromptComponent;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "BottomSheetPromptCallback", "Result"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BottomSheetPromptView extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private LockableBaseBottomSheetBehavior<CardView> MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private BottomSheetPromptCallback KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private BottomSheetPromptComponent PlaceComponentResult;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/ocr/preview/BottomSheetPromptView$BottomSheetPromptCallback;", "", "", "p0", "", "getAuthRequestContext", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public interface BottomSheetPromptCallback {
        void getAuthRequestContext(String p0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BottomSheetPromptView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BottomSheetPromptView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_bottomsheet_prompt;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetPromptView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ BottomSheetPromptView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomSheetPromptView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        initBottomSheet();
        initViews();
    }

    @Override // id.dana.base.BaseRichView
    public final void injectComponent(ApplicationComponent applicationComponent) {
        super.injectComponent(applicationComponent);
        if (this.PlaceComponentResult == null) {
            DaggerBottomSheetPromptComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerBottomSheetPromptComponent.BuiltInFictitiousFunctionClassFactory();
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, ApplicationComponent.class);
            ApplicationComponent applicationComponent2 = BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
            DaggerBottomSheetPromptComponent.BottomSheetPromptComponentImpl bottomSheetPromptComponentImpl = new DaggerBottomSheetPromptComponent.BottomSheetPromptComponentImpl();
            Intrinsics.checkNotNullExpressionValue(bottomSheetPromptComponentImpl, "");
            this.PlaceComponentResult = bottomSheetPromptComponentImpl;
        }
        if (this.PlaceComponentResult == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
    }

    public final void initBottomSheet() {
        this.MyBillsEntityDataFactory = (LockableBaseBottomSheetBehavior) LockableBaseBottomSheetBehavior.from((CardView) _$_findCachedViewById(R.id.res_0x7f0a0588_nearbysearchpresenter_getnearbytrendingkeyword_1));
        hide();
        LockableBaseBottomSheetBehavior<CardView> lockableBaseBottomSheetBehavior = this.MyBillsEntityDataFactory;
        if (lockableBaseBottomSheetBehavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lockableBaseBottomSheetBehavior = null;
        }
        lockableBaseBottomSheetBehavior.MyBillsEntityDataFactory = true;
    }

    public final void initViews() {
        ((Button) _$_findCachedViewById(R.id.initAnimators)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.ocr.preview.BottomSheetPromptView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomSheetPromptView.$r8$lambda$wbRSKA9O3LR2V5Bx2E8waswZYRM(BottomSheetPromptView.this, view);
            }
        });
        ((Button) _$_findCachedViewById(R.id.TypefaceCompatApi26Impl)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.ocr.preview.BottomSheetPromptView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomSheetPromptView.$r8$lambda$eVS6TtZNo0yZw1akh8AezwLV_uw(BottomSheetPromptView.this, view);
            }
        });
    }

    public final void show() {
        LockableBaseBottomSheetBehavior<CardView> lockableBaseBottomSheetBehavior = this.MyBillsEntityDataFactory;
        if (lockableBaseBottomSheetBehavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lockableBaseBottomSheetBehavior = null;
        }
        lockableBaseBottomSheetBehavior.setState(3);
    }

    public final void hide() {
        LockableBaseBottomSheetBehavior<CardView> lockableBaseBottomSheetBehavior = this.MyBillsEntityDataFactory;
        if (lockableBaseBottomSheetBehavior == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            lockableBaseBottomSheetBehavior = null;
        }
        lockableBaseBottomSheetBehavior.setState(5);
    }

    public final void setListener(BottomSheetPromptCallback bottomSheetPromptCallback) {
        Intrinsics.checkNotNullParameter(bottomSheetPromptCallback, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = bottomSheetPromptCallback;
    }

    public final void setHeader(String headerText) {
        Intrinsics.checkNotNullParameter(headerText, "");
        TextView textView = (TextView) _$_findCachedViewById(R.id.header_prompt);
        if (textView != null) {
            textView.setText(headerText);
        }
    }

    public final void setPositiveButtonText(String positiveButtonMessage) {
        Intrinsics.checkNotNullParameter(positiveButtonMessage, "");
        Button button = (Button) _$_findCachedViewById(R.id.initAnimators);
        if (button != null) {
            button.setText(positiveButtonMessage);
        }
    }

    public final void setNegativeButtonText(String negativeButtonMessage) {
        Intrinsics.checkNotNullParameter(negativeButtonMessage, "");
        Button button = (Button) _$_findCachedViewById(R.id.TypefaceCompatApi26Impl);
        if (button != null) {
            button.setText(negativeButtonMessage);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/ocr/preview/BottomSheetPromptView$Result;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes2.dex */
    public @interface Result {
        public static final String CANCEL = "CANCEL";

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.PlaceComponentResult;
        public static final String NEGATIVE_BUTTON_CLICKED = "NEGATIVE_BUTTON_CLICKED";
        public static final String POSITIVE_BUTTON_CLICKED = "POSITIVE_BUTTON_CLICKED";

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/ocr/preview/BottomSheetPromptView$Result$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            static final /* synthetic */ Companion PlaceComponentResult = new Companion();

            private Companion() {
            }
        }
    }

    public static /* synthetic */ void $r8$lambda$eVS6TtZNo0yZw1akh8AezwLV_uw(BottomSheetPromptView bottomSheetPromptView, View view) {
        Intrinsics.checkNotNullParameter(bottomSheetPromptView, "");
        bottomSheetPromptView.hide();
        BottomSheetPromptCallback bottomSheetPromptCallback = bottomSheetPromptView.KClassImpl$Data$declaredNonStaticMembers$2;
        if (bottomSheetPromptCallback != null) {
            bottomSheetPromptCallback.getAuthRequestContext(Result.NEGATIVE_BUTTON_CLICKED);
        }
    }

    public static /* synthetic */ void $r8$lambda$wbRSKA9O3LR2V5Bx2E8waswZYRM(BottomSheetPromptView bottomSheetPromptView, View view) {
        Intrinsics.checkNotNullParameter(bottomSheetPromptView, "");
        bottomSheetPromptView.hide();
        BottomSheetPromptCallback bottomSheetPromptCallback = bottomSheetPromptView.KClassImpl$Data$declaredNonStaticMembers$2;
        if (bottomSheetPromptCallback != null) {
            bottomSheetPromptCallback.getAuthRequestContext(Result.POSITIVE_BUTTON_CLICKED);
        }
    }
}
