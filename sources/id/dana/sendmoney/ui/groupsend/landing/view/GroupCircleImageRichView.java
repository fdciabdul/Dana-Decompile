package id.dana.sendmoney.ui.groupsend.landing.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.ViewGroupCircleImageBinding;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&B/\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\"\u001a\u00020\u0003\u0012\b\b\u0002\u0010#\u001a\u00020\u0003¢\u0006\u0004\b$\u0010%J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0014\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0004\b\u0014\u0010\u0015R*\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00038\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u001f\u0010 "}, d2 = {"Lid/dana/sendmoney/ui/groupsend/landing/view/GroupCircleImageRichView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/sendmoney/databinding/ViewGroupCircleImageBinding;", "", "p0", "Lde/hdodenhof/circleimageview/CircleImageView;", "getAuthRequestContext", "(I)Lde/hdodenhof/circleimageview/CircleImageView;", "inflateViewBinding", "()Lid/dana/sendmoney/databinding/ViewGroupCircleImageBinding;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "", "avatarUrlList", "setGroupImages", "(Ljava/util/List;)V", "value", "BuiltInFictitiousFunctionClassFactory", "I", "getImageSize", "()I", "setImageSize", "(I)V", "imageSize", "Landroid/content/res/TypedArray;", "PlaceComponentResult", "Landroid/content/res/TypedArray;", "MyBillsEntityDataFactory", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GroupCircleImageRichView extends BaseViewBindingRichView<ViewGroupCircleImageBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private int imageSize;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private TypedArray MyBillsEntityDataFactory;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GroupCircleImageRichView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GroupCircleImageRichView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GroupCircleImageRichView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public /* synthetic */ GroupCircleImageRichView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupCircleImageRichView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @JvmName(name = "getImageSize")
    public final int getImageSize() {
        return this.imageSize;
    }

    @JvmName(name = "setImageSize")
    public final void setImageSize(int i) {
        this.imageSize = i;
        if (i == 1) {
            ViewGroupCircleImageBinding binding = getBinding();
            for (int i2 = 0; i2 < 5; i2++) {
                ViewGroup.LayoutParams layoutParams = getAuthRequestContext(i2).getLayoutParams();
                layoutParams.width = getResources().getDimensionPixelSize(R.dimen.PlaceComponentResult_res_0x7f070059);
                layoutParams.height = getResources().getDimensionPixelSize(R.dimen.PlaceComponentResult_res_0x7f070059);
            }
            ViewGroup.LayoutParams layoutParams2 = binding.getAuthRequestContext.getLayoutParams();
            layoutParams2.width = getResources().getDimensionPixelSize(R.dimen.PlaceComponentResult_res_0x7f070059);
            layoutParams2.height = getResources().getDimensionPixelSize(R.dimen.PlaceComponentResult_res_0x7f070059);
            binding.moveToNextValue.setTextSize(2, 12.0f);
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewGroupCircleImageBinding inflateViewBinding() {
        ViewGroupCircleImageBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewGroupCircleImageBinding.KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void parseAttrs(Context context, AttributeSet attrs) {
        if (attrs != null) {
            int[] iArr = R.styleable.verifyNotNull;
            Intrinsics.checkNotNullExpressionValue(iArr, "");
            if (context != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, iArr, 0, 0);
                Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "");
                this.MyBillsEntityDataFactory = obtainStyledAttributes;
            }
            TypedArray typedArray = null;
            try {
                TypedArray typedArray2 = this.MyBillsEntityDataFactory;
                if (typedArray2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    typedArray2 = null;
                }
                setImageSize(typedArray2.getInt(R.styleable.FlowableReduce$ReduceSubscriber, 0));
            } finally {
                TypedArray typedArray3 = this.MyBillsEntityDataFactory;
                if (typedArray3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    typedArray = typedArray3;
                }
                typedArray.recycle();
            }
        }
    }

    private final CircleImageView getAuthRequestContext(int p0) {
        if (p0 == 0) {
            CircleImageView circleImageView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(circleImageView, "");
            return circleImageView;
        } else if (p0 == 1) {
            CircleImageView circleImageView2 = getBinding().BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(circleImageView2, "");
            return circleImageView2;
        } else if (p0 == 2) {
            CircleImageView circleImageView3 = getBinding().scheduleImpl;
            Intrinsics.checkNotNullExpressionValue(circleImageView3, "");
            return circleImageView3;
        } else if (p0 == 3) {
            CircleImageView circleImageView4 = getBinding().PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(circleImageView4, "");
            return circleImageView4;
        } else if (p0 == 4) {
            CircleImageView circleImageView5 = getBinding().MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(circleImageView5, "");
            return circleImageView5;
        } else {
            throw new IllegalArgumentException("Index out of bound");
        }
    }

    public final void setGroupImages(List<String> avatarUrlList) {
        Intrinsics.checkNotNullParameter(avatarUrlList, "");
        for (int i = 0; i < 5; i++) {
            getAuthRequestContext(i).setVisibility(8);
        }
        FrameLayout frameLayout = getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "");
        frameLayout.setVisibility(8);
        getBinding();
        int size = avatarUrlList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 == 5) {
                int size2 = avatarUrlList.size();
                FrameLayout frameLayout2 = getBinding().getAuthRequestContext;
                Intrinsics.checkNotNullExpressionValue(frameLayout2, "");
                frameLayout2.setVisibility(0);
                TextView textView = getBinding().moveToNextValue;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = getContext().getString(R.string.more_than_avatars);
                Intrinsics.checkNotNullExpressionValue(string, "");
                String format = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(size2 - 5)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "");
                textView.setText(format);
                return;
            }
            getAuthRequestContext(i2).setVisibility(0);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            GlideApp.getAuthRequestContext(context).PlaceComponentResult(avatarUrlList.get(i2)).getErrorConfigVersion(R.drawable.ic_user_default_placeholder).PlaceComponentResult(R.drawable.ic_user_default_placeholder).MyBillsEntityDataFactory((ImageView) getAuthRequestContext(i2));
        }
    }
}
