package id.dana.component.cellcomponent;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.alibaba.griver.core.GriverParams;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.bumptech.glide.Glide;
import id.dana.component.R;
import id.dana.component.utils.SizeUtil;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010@\u001a\u00020\u0002¢\u0006\u0004\bA\u0010BJ\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0014\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u0014\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0016J!\u0010\u0017\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0017\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0019J;\u0010\u001c\u001a\u00020\f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u001c\u0010\u001eJQ\u0010 \u001a\u00020\f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b \u0010!J5\u0010 \u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b \u0010\"J;\u0010#\u001a\u00020\f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b#\u0010\u001dJ\u001f\u0010#\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b#\u0010\u001eJ\u0015\u0010%\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010%\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b%\u0010'J)\u0010*\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u00022\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b*\u0010+J-\u0010*\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010,\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b*\u0010-J\u000f\u0010.\u001a\u00020\fH\u0016¢\u0006\u0004\b.\u0010/R\u0016\u0010\u0004\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00103\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u00102R\u0013\u00107\u001a\u0004\u0018\u0001048G¢\u0006\u0006\u001a\u0004\b5\u00106R\u0013\u00109\u001a\u0004\u0018\u0001048G¢\u0006\u0006\u001a\u0004\b8\u00106R\u0016\u0010;\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b:\u00101R\u0016\u00100\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b;\u00101R\u0016\u0010:\u001a\u00020<8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010=\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b?\u00102"}, d2 = {"Lid/dana/component/cellcomponent/DanaCellLeftView;", "Lid/dana/component/cellcomponent/BaseDanaCell;", "", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/Integer;)Ljava/lang/Integer;", "getLayout", "()I", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "labelText", "description", "Landroid/graphics/drawable/Drawable;", "icon", "setCellLabelDescIcon", "(Ljava/lang/String;Ljava/lang/String;Landroid/graphics/drawable/Drawable;)V", "(Ljava/lang/String;Ljava/lang/String;I)V", "setCellLabelIcon", "(Ljava/lang/String;Landroid/graphics/drawable/Drawable;)V", "(Ljava/lang/String;I)V", GriverParams.ShareParams.IMAGE_URL, "imagePlaceHolder", "setCellLeftIconLabel", "(Landroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "(ILjava/lang/String;)V", "textDescriptionColor", "setCellLeftIconLabelDesc", "(Landroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "setCellLeftIconLabelIndent", "labelRes", "setCellLeftLabel", "(I)V", "(Ljava/lang/String;)V", "descRes", "descColorRes", "setCellLeftLabelDesc", "(IILjava/lang/Integer;)V", "descText", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "setup", "()V", "MyBillsEntityDataFactory", "I", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Landroid/widget/ImageView;", "getIconCell", "()Landroid/widget/ImageView;", "iconCell", "getIconCellRight", "iconCellRight", "getAuthRequestContext", "PlaceComponentResult", "", "moveToNextValue", "Z", "lookAheadTest", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes4.dex */
public final class DanaCellLeftView extends BaseDanaCell {
    private HashMap BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private int KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private int MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private int PlaceComponentResult;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private String moveToNextValue;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private boolean getAuthRequestContext;

    public DanaCellLeftView(Context context) {
        this(context, null, 0, 6, null);
    }

    public DanaCellLeftView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.BuiltInFictitiousFunctionClassFactory;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i) {
        if (this.BuiltInFictitiousFunctionClassFactory == null) {
            this.BuiltInFictitiousFunctionClassFactory = new HashMap();
        }
        View view = (View) this.BuiltInFictitiousFunctionClassFactory.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            this.BuiltInFictitiousFunctionClassFactory.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    public /* synthetic */ DanaCellLeftView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaCellLeftView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @JvmName(name = "getIconCell")
    public final ImageView getIconCell() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == 0) {
            return null;
        }
        return (ImageView) findViewById(R.id.getSupportButtonTintMode);
    }

    @JvmName(name = "getIconCellRight")
    public final ImageView getIconCellRight() {
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i == 7 || i == 8) {
            return (ImageView) findViewById(R.id.iv_icon_right);
        }
        return null;
    }

    @Override // id.dana.component.BaseRichView
    public final int getLayout() {
        int i = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i == 5 || i == 6) {
            return R.layout.view_dana_cell_left_circle_logo;
        }
        return R.layout.view_dana_cell_left;
    }

    @Override // id.dana.component.BaseRichView
    public final void parseAttrs(Context context, AttributeSet attrs) {
        Intrinsics.checkNotNullParameter(context, "");
        Resources.Theme theme = context.getTheme();
        if (attrs != null) {
            TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attrs, R.styleable.shouldRecycleViewType, 0, 0);
            try {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getInt(R.styleable.QrExpiredActivity, 0);
                this.PlaceComponentResult = obtainStyledAttributes.getResourceId(R.styleable.Z, 0);
                this.moveToNextValue = obtainStyledAttributes.getString(R.styleable.d);
                this.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getString(R.styleable.isAuto);
                this.getAuthRequestContext = obtainStyledAttributes.getBoolean(R.styleable.b, false);
                this.MyBillsEntityDataFactory = obtainStyledAttributes.getResourceId(R.styleable.Y, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public final void setCellLeftLabel(int labelRes) {
        setCellLeftLabel(getContext().getString(labelRes));
    }

    public final void setCellLeftLabel(String labelText) {
        setPaddingCell((ConstraintLayout) _$_findCachedViewById(R.id.res_0x7f0a0421_networkuserentitydata_externalsyntheticlambda8), 0);
        TextView textView = (TextView) _$_findCachedViewById(R.id.J);
        if (textView != null) {
            textView.setText(labelText);
            textView.setVisibility(0);
        }
    }

    public static /* synthetic */ void setCellLeftLabelDesc$default(DanaCellLeftView danaCellLeftView, int i, int i2, Integer num, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            num = null;
        }
        danaCellLeftView.setCellLeftLabelDesc(i, i2, num);
    }

    public final void setCellLeftLabelDesc(int labelRes, int descRes, Integer descColorRes) {
        setCellLeftLabelDesc(getContext().getString(labelRes), getContext().getString(descRes), descColorRes);
    }

    public static /* synthetic */ void setCellLeftLabelDesc$default(DanaCellLeftView danaCellLeftView, String str, String str2, Integer num, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        danaCellLeftView.setCellLeftLabelDesc(str, str2, num);
    }

    public final void setCellLeftLabelDesc(String labelText, String descText, Integer descColorRes) {
        setPaddingCell((ConstraintLayout) _$_findCachedViewById(R.id.res_0x7f0a0421_networkuserentitydata_externalsyntheticlambda8), 0);
        TextView textView = (TextView) _$_findCachedViewById(R.id.J);
        if (textView != null) {
            textView.setText(labelText);
            textView.setVisibility(0);
        }
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.M);
        if (textView2 != null) {
            Integer KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(descColorRes);
            if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                textView2.setTextColor(KClassImpl$Data$declaredNonStaticMembers$2.intValue());
            }
            textView2.setText(descText);
            textView2.setVisibility(0);
        }
    }

    public final void setCellLeftIconLabel(int icon, String labelText) {
        Integer valueOf = Integer.valueOf(icon);
        setCellLeftIconLabel$default(this, (valueOf == null || valueOf.intValue() == 0) ? null : ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(getContext(), valueOf.intValue()), null, null, labelText, 6, null);
    }

    public static /* synthetic */ void setCellLeftIconLabel$default(DanaCellLeftView danaCellLeftView, Drawable drawable, String str, Integer num, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            drawable = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        danaCellLeftView.setCellLeftIconLabel(drawable, str, num, str2);
    }

    public final void setCellLeftIconLabel(Drawable icon, String imageUrl, Integer imagePlaceHolder, String labelText) {
        ImageView iconCell = getIconCell();
        if (iconCell != null) {
            if (icon != null) {
                iconCell.setImageDrawable(icon);
            } else {
                String str = imageUrl;
                if (!(str == null || str.length() == 0)) {
                    Glide.KClassImpl$Data$declaredNonStaticMembers$2(getContext()).getAuthRequestContext(imageUrl).KClassImpl$Data$declaredNonStaticMembers$2((imagePlaceHolder == null || imagePlaceHolder.intValue() == 0) ? null : ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(getContext(), imagePlaceHolder.intValue())).MyBillsEntityDataFactory(iconCell);
                }
            }
            iconCell.setVisibility(0);
        }
        TextView textView = (TextView) _$_findCachedViewById(R.id.J);
        if (textView != null) {
            textView.setText(labelText);
            textView.setVisibility(0);
        }
    }

    public final void setCellLeftIconLabelIndent(int icon, String labelText) {
        Integer valueOf = Integer.valueOf(icon);
        setCellLeftIconLabelIndent$default(this, (valueOf == null || valueOf.intValue() == 0) ? null : ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(getContext(), valueOf.intValue()), null, null, labelText, 6, null);
    }

    public static /* synthetic */ void setCellLeftIconLabelIndent$default(DanaCellLeftView danaCellLeftView, Drawable drawable, String str, Integer num, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            drawable = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        danaCellLeftView.setCellLeftIconLabelIndent(drawable, str, num, str2);
    }

    public final void setCellLeftIconLabelIndent(Drawable icon, String imageUrl, Integer imagePlaceHolder, String labelText) {
        ImageView iconCell = getIconCell();
        if (iconCell != null) {
            if (icon != null) {
                iconCell.setImageDrawable(icon);
            } else {
                String str = imageUrl;
                if (!(str == null || str.length() == 0)) {
                    Glide.KClassImpl$Data$declaredNonStaticMembers$2(getContext()).getAuthRequestContext(imageUrl).KClassImpl$Data$declaredNonStaticMembers$2((imagePlaceHolder == null || imagePlaceHolder.intValue() == 0) ? null : ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(getContext(), imagePlaceHolder.intValue())).MyBillsEntityDataFactory(iconCell);
                }
            }
            iconCell.setVisibility(0);
        }
        TextView textView = (TextView) _$_findCachedViewById(R.id.J);
        if (textView != null) {
            textView.setText(labelText);
            textView.setVisibility(0);
        }
        setPaddingCell((ConstraintLayout) _$_findCachedViewById(R.id.res_0x7f0a0421_networkuserentitydata_externalsyntheticlambda8), SizeUtil.PlaceComponentResult(32));
    }

    public static /* synthetic */ void setCellLeftIconLabelDesc$default(DanaCellLeftView danaCellLeftView, int i, String str, String str2, Integer num, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            num = null;
        }
        danaCellLeftView.setCellLeftIconLabelDesc(i, str, str2, num);
    }

    public final void setCellLeftIconLabelDesc(int icon, String labelText, String description, Integer textDescriptionColor) {
        Integer valueOf = Integer.valueOf(icon);
        setCellLeftIconLabelDesc$default(this, (valueOf == null || valueOf.intValue() == 0) ? null : ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(getContext(), valueOf.intValue()), null, null, labelText, description, textDescriptionColor, 6, null);
    }

    public static /* synthetic */ void setCellLeftIconLabelDesc$default(DanaCellLeftView danaCellLeftView, Drawable drawable, String str, Integer num, String str2, String str3, Integer num2, int i, Object obj) {
        danaCellLeftView.setCellLeftIconLabelDesc((i & 1) != 0 ? null : drawable, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num, str2, str3, (i & 32) != 0 ? null : num2);
    }

    public final void setCellLeftIconLabelDesc(Drawable icon, String imageUrl, Integer imagePlaceHolder, String labelText, String description, Integer textDescriptionColor) {
        ImageView iconCell = getIconCell();
        if (iconCell != null) {
            if (icon != null) {
                iconCell.setImageDrawable(icon);
            } else {
                String str = imageUrl;
                if (!(str == null || str.length() == 0)) {
                    Glide.KClassImpl$Data$declaredNonStaticMembers$2(getContext()).getAuthRequestContext(imageUrl).KClassImpl$Data$declaredNonStaticMembers$2((imagePlaceHolder == null || imagePlaceHolder.intValue() == 0) ? null : ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(getContext(), imagePlaceHolder.intValue())).MyBillsEntityDataFactory(iconCell);
                }
            }
            iconCell.setVisibility(0);
        }
        TextView textView = (TextView) _$_findCachedViewById(R.id.J);
        if (textView != null) {
            textView.setText(labelText);
            textView.setVisibility(0);
        }
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.M);
        if (textView2 != null) {
            Integer KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(textDescriptionColor);
            if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                textView2.setTextColor(KClassImpl$Data$declaredNonStaticMembers$2.intValue());
            }
            textView2.setText(description);
            textView2.setVisibility(0);
        }
    }

    public final void setCellLabelIcon(String labelText, int icon) {
        Integer valueOf = Integer.valueOf(icon);
        setCellLabelIcon(labelText, (valueOf == null || valueOf.intValue() == 0) ? null : ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(getContext(), valueOf.intValue()));
    }

    public final void setCellLabelIcon(String labelText, Drawable icon) {
        setPaddingCell((ConstraintLayout) _$_findCachedViewById(R.id.res_0x7f0a0421_networkuserentitydata_externalsyntheticlambda8), 0);
        TextView textView = (TextView) _$_findCachedViewById(R.id.J);
        if (textView != null) {
            textView.setText(labelText);
            textView.setVisibility(0);
        }
        ImageView iconCellRight = getIconCellRight();
        if (iconCellRight != null) {
            iconCellRight.setImageDrawable(icon);
            iconCellRight.setVisibility(0);
        }
    }

    public final void setCellLabelDescIcon(String labelText, String description, int icon) {
        Integer valueOf = Integer.valueOf(icon);
        setCellLabelDescIcon(labelText, description, (valueOf == null || valueOf.intValue() == 0) ? null : ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(getContext(), valueOf.intValue()));
    }

    public final void setCellLabelDescIcon(String labelText, String description, Drawable icon) {
        setPaddingCell((ConstraintLayout) _$_findCachedViewById(R.id.res_0x7f0a0421_networkuserentitydata_externalsyntheticlambda8), 0);
        TextView textView = (TextView) _$_findCachedViewById(R.id.J);
        if (textView != null) {
            textView.setText(labelText);
            textView.setVisibility(0);
        }
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.M);
        if (textView2 != null) {
            textView2.setText(description);
            textView2.setVisibility(0);
        }
        ImageView iconCellRight = getIconCellRight();
        if (iconCellRight != null) {
            iconCellRight.setImageDrawable(icon);
            iconCellRight.setVisibility(0);
        }
    }

    private final Integer KClassImpl$Data$declaredNonStaticMembers$2(Integer p0) {
        if (p0 == null || p0.intValue() == 0) {
            return null;
        }
        return Integer.valueOf(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), p0.intValue()));
    }

    @Override // id.dana.component.BaseRichView
    public final void setup() {
        switch (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            case 0:
                setCellLeftLabel(this.moveToNextValue);
                break;
            case 1:
                setCellLeftLabelDesc$default(this, this.moveToNextValue, this.BuiltInFictitiousFunctionClassFactory, (Integer) null, 4, (Object) null);
                break;
            case 2:
            case 5:
                setCellLeftIconLabel(this.PlaceComponentResult, this.moveToNextValue);
                break;
            case 3:
                setCellLeftIconLabelIndent(this.PlaceComponentResult, this.moveToNextValue);
                break;
            case 4:
            case 6:
                setCellLeftIconLabelDesc$default(this, this.PlaceComponentResult, this.moveToNextValue, this.BuiltInFictitiousFunctionClassFactory, null, 8, null);
                break;
            case 7:
                setCellLabelIcon(this.moveToNextValue, this.MyBillsEntityDataFactory);
                break;
            case 8:
                setCellLabelDescIcon(this.moveToNextValue, this.BuiltInFictitiousFunctionClassFactory, this.MyBillsEntityDataFactory);
                break;
        }
        vallidateSmallCell((ConstraintLayout) _$_findCachedViewById(R.id.res_0x7f0a0421_networkuserentitydata_externalsyntheticlambda8), this.getAuthRequestContext);
    }
}
