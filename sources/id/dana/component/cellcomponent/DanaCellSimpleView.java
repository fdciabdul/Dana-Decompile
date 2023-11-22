package id.dana.component.cellcomponent;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.api.constants.GriverEvents;
import com.alipay.mobile.zebra.data.ZebraData;
import com.ap.zoloz.hummer.biz.HummerConstants;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.component.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010)\u001a\u00020(\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*\u0012\b\b\u0002\u0010,\u001a\u00020\u0002¢\u0006\u0004\b-\u0010.J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0012\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\bJ\u001d\u0010\u0014\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\fJ\u0015\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\bJ\u0015\u0010\u001a\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\bJ\u0015\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0015¢\u0006\u0004\b\u001c\u0010\u0018J\u0015\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0015¢\u0006\u0004\b\"\u0010\u0018J\u0015\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u001d¢\u0006\u0004\b$\u0010 J\u0015\u0010%\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0015¢\u0006\u0004\b%\u0010\u0018J\u000f\u0010&\u001a\u00020\u0006H\u0016¢\u0006\u0004\b&\u0010'"}, d2 = {"Lid/dana/component/cellcomponent/DanaCellSimpleView;", "Lid/dana/component/cellcomponent/BaseDanaCell;", "", "getLayout", "()I", "icon", "", "setArrowIcon", "(I)V", ZebraData.ATTR_WIDTH, ZebraData.ATTR_HEIGHT, "setArrowIconSize", "(II)V", "setDrawableBorder", "Landroid/graphics/Typeface;", "typeface", "setFontSubtitle", "(Landroid/graphics/Typeface;)V", "setFontTitle", "setIcon", "setIconSize", "", "elevation", "setParentElevation", "(F)V", "setParentHeight", "setParentWidth", "radius", "setRadius", "", RVParams.LONG_SUB_TITLE, "setSubitle", "(Ljava/lang/String;)V", GriverMonitorConstants.KEY_SIZE, "setSubtitleSize", "title", GriverEvents.EVENT_SET_TITLE, "setTitleSize", "setup", "()V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes8.dex */
public final class DanaCellSimpleView extends BaseDanaCell {
    private HashMap KClassImpl$Data$declaredNonStaticMembers$2;

    public DanaCellSimpleView(Context context) {
        this(context, null, 0, 6, null);
    }

    public DanaCellSimpleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new HashMap();
        }
        View view = (View) this.KClassImpl$Data$declaredNonStaticMembers$2.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            this.KClassImpl$Data$declaredNonStaticMembers$2.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // id.dana.component.BaseRichView
    public final void setup() {
    }

    public /* synthetic */ DanaCellSimpleView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaCellSimpleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.component.BaseRichView
    public final int getLayout() {
        return R.layout.res_0x7f0d04ee_networkuserentitydata_externalsyntheticlambda2;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.AppCompatEmojiTextHelper_res_0x7f0a13ff);
        if (appCompatTextView != null) {
            appCompatTextView.setText(str);
        }
    }

    public final void setTitleSize(float r2) {
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.AppCompatEmojiTextHelper_res_0x7f0a13ff);
        if (appCompatTextView != null) {
            appCompatTextView.setTextSize(r2);
        }
    }

    public final void setFontTitle(Typeface typeface) {
        AppCompatTextView appCompatTextView;
        if (typeface == null || (appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.AppCompatEmojiTextHelper_res_0x7f0a13ff)) == null) {
            return;
        }
        appCompatTextView.setTypeface(typeface);
    }

    public final void setSubitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "");
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.tvCellSubtitle);
        if (appCompatTextView != null) {
            appCompatTextView.setText(r2);
        }
    }

    public final void setSubtitleSize(float r2) {
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.tvCellSubtitle);
        if (appCompatTextView != null) {
            appCompatTextView.setTextSize(r2);
        }
    }

    public final void setFontSubtitle(Typeface typeface) {
        AppCompatTextView appCompatTextView;
        if (typeface == null || (appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.tvCellSubtitle)) == null) {
            return;
        }
        appCompatTextView.setTypeface(typeface);
    }

    public final void setIcon(int icon) {
        CircleImageView circleImageView = (CircleImageView) _$_findCachedViewById(R.id.isLayoutRequested_res_0x7f0a0971);
        if (circleImageView != null) {
            circleImageView.setImageDrawable(icon == 0 ? null : ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(getContext(), icon));
        }
    }

    public final void setIconSize(int r2, int r3) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        CircleImageView circleImageView = (CircleImageView) _$_findCachedViewById(R.id.isLayoutRequested_res_0x7f0a0971);
        if (circleImageView != null && (layoutParams2 = circleImageView.getLayoutParams()) != null) {
            layoutParams2.width = r2;
        }
        CircleImageView circleImageView2 = (CircleImageView) _$_findCachedViewById(R.id.isLayoutRequested_res_0x7f0a0971);
        if (circleImageView2 == null || (layoutParams = circleImageView2.getLayoutParams()) == null) {
            return;
        }
        layoutParams.height = r3;
    }

    public final void setArrowIcon(int icon) {
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.NetworkUserEntityData$$ExternalSyntheticLambda7);
        if (appCompatImageView != null) {
            appCompatImageView.setImageDrawable(icon == 0 ? null : ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(getContext(), icon));
        }
    }

    public final void setArrowIconSize(int r2, int r3) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.NetworkUserEntityData$$ExternalSyntheticLambda7);
        if (appCompatImageView != null && (layoutParams2 = appCompatImageView.getLayoutParams()) != null) {
            layoutParams2.width = r2;
        }
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) _$_findCachedViewById(R.id.NetworkUserEntityData$$ExternalSyntheticLambda7);
        if (appCompatImageView2 == null || (layoutParams = appCompatImageView2.getLayoutParams()) == null) {
            return;
        }
        layoutParams.height = r3;
    }

    public final void setRadius(float radius) {
        CardView cardView = (CardView) _$_findCachedViewById(R.id.PrepareContext_res_0x7f0a056d);
        if (cardView != null) {
            cardView.setRadius(radius);
        }
    }

    public final void setParentWidth(int r2) {
        ViewGroup.LayoutParams layoutParams;
        CardView cardView = (CardView) _$_findCachedViewById(R.id.PrepareContext_res_0x7f0a056d);
        if (cardView == null || (layoutParams = cardView.getLayoutParams()) == null) {
            return;
        }
        layoutParams.width = r2;
    }

    public final void setParentHeight(int r2) {
        ViewGroup.LayoutParams layoutParams;
        CardView cardView = (CardView) _$_findCachedViewById(R.id.PrepareContext_res_0x7f0a056d);
        if (cardView == null || (layoutParams = cardView.getLayoutParams()) == null) {
            return;
        }
        layoutParams.height = r2;
    }

    public final void setParentElevation(float elevation) {
        CardView cardView = (CardView) _$_findCachedViewById(R.id.PrepareContext_res_0x7f0a056d);
        if (cardView != null) {
            cardView.setCardElevation(elevation);
        }
    }

    public final void setDrawableBorder(int icon) {
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.moveToNextValue_res_0x7f0a03c6);
        if (constraintLayout != null) {
            constraintLayout.setBackground(icon == 0 ? null : ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(getContext(), icon));
        }
    }
}
