package id.dana.base.viewbinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBinding;
import com.alibaba.griver.api.constants.GriverEvents;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.firebase.perf.util.Constants;
import id.dana.R;
import id.dana.base.DisposableHandler;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004B\u0007¢\u0006\u0004\b?\u0010\fJ\u0017\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u0019\u0010\u0010\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u001bJ\u001f\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0005H\u0002¢\u0006\u0004\b \u0010\u0019J\u001d\u0010\"\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010\u001bJ\u0015\u0010$\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0005¢\u0006\u0004\b$\u0010\u0019J\u0015\u0010%\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b%\u0010&J\u001f\u0010%\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u0005H\u0002¢\u0006\u0004\b%\u0010\u001fJ\u0017\u0010'\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u0005H\u0002¢\u0006\u0004\b'\u0010\u0019J\u0017\u0010(\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b(\u0010\u0016J\u0017\u0010+\u001a\u00020\n2\b\u0010*\u001a\u0004\u0018\u00010)¢\u0006\u0004\b+\u0010,J\u0019\u0010.\u001a\u00020\n2\b\u0010-\u001a\u0004\u0018\u00010\u0013H\u0004¢\u0006\u0004\b.\u0010\u0016J\u0017\u0010/\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0004¢\u0006\u0004\b/\u0010\u0019J\u0017\u00100\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b0\u0010\u0016R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b4\u00103R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00109\u001a\u0002088\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010<\u001a\u00020;8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010>\u001a\u0002018\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b>\u00103"}, d2 = {"Lid/dana/base/viewbinding/ViewBindingToolbarFragment;", "Landroidx/viewbinding/ViewBinding;", "V", "Lid/dana/base/viewbinding/ViewBindingFragment;", "Lid/dana/base/DisposableHandler;", "", "drawableRes", "Landroid/graphics/drawable/Drawable;", "getDrawableFromRes", "(I)Landroid/graphics/drawable/Drawable;", "", IAPSyncCommand.COMMAND_INIT, "()V", "initView", "Landroid/view/View;", "view", "onClickLeftMenuButton", "(Landroid/view/View;)V", "onClickRightMenuButton", "", "contentDescription", "setLeftButtonContentDescription", "(Ljava/lang/String;)V", "icon", "setMenuLeftButton", "(I)V", "marginLeft", "(II)V", "", Constants.ENABLE_DISABLE, "setMenuLeftButtonEnabled", "(ZI)V", "setMenuLeftButtonMarginLeft", "marginRight", "setMenuRightButton", "value", "setMenuRightButtonContentDescription", "setMenuRightButtonEnabled", "(Z)V", "setMenuRightButtonMarginRight", "setRightButtonContentDescription", "Landroid/view/View$OnClickListener;", "onClickListener", "setRightButtonOnClickListener", "(Landroid/view/View$OnClickListener;)V", "title", GriverEvents.EVENT_SET_TITLE, "setToolbarImage", "setToolbarTitleContentDescription", "Landroid/widget/TextView;", "leftButton", "Landroid/widget/TextView;", "rightButton", "Landroid/widget/RelativeLayout;", "rlToolbar", "Landroid/widget/RelativeLayout;", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "Landroid/widget/ImageView;", "toolbarImage", "Landroid/widget/ImageView;", "toolbarTitle", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ViewBindingToolbarFragment<V extends ViewBinding> extends ViewBindingFragment<V> implements DisposableHandler {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private TextView leftButton;
    private TextView rightButton;
    private RelativeLayout rlToolbar;
    private Toolbar toolbar;
    private ImageView toolbarImage;
    private TextView toolbarTitle;

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment
    public View _$_findCachedViewById(int i) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View getAuthRequestContext = getGetAuthRequestContext();
            if (getAuthRequestContext == null || (findViewById = getAuthRequestContext.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    public void onClickLeftMenuButton(View view) {
    }

    public void onClickRightMenuButton(View view) {
    }

    @Override // id.dana.base.viewbinding.ViewBindingFragment, id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // id.dana.base.BaseFragment
    public void init() {
        initView();
    }

    private final void initView() {
        V binding = getBinding();
        if (binding != null) {
            View KClassImpl$Data$declaredNonStaticMembers$2 = binding.KClassImpl$Data$declaredNonStaticMembers$2();
            View findViewById = KClassImpl$Data$declaredNonStaticMembers$2.findViewById(R.id.left_button);
            Intrinsics.checkNotNullExpressionValue(findViewById, "");
            this.leftButton = (TextView) findViewById;
            View findViewById2 = KClassImpl$Data$declaredNonStaticMembers$2.findViewById(R.id.right_button);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "");
            this.rightButton = (TextView) findViewById2;
            View findViewById3 = KClassImpl$Data$declaredNonStaticMembers$2.findViewById(R.id.rl_toolbar);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "");
            this.rlToolbar = (RelativeLayout) findViewById3;
            View findViewById4 = KClassImpl$Data$declaredNonStaticMembers$2.findViewById(R.id.toolbar);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "");
            this.toolbar = (Toolbar) findViewById4;
            View findViewById5 = KClassImpl$Data$declaredNonStaticMembers$2.findViewById(R.id.iv_title_image);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "");
            this.toolbarImage = (ImageView) findViewById5;
            View findViewById6 = KClassImpl$Data$declaredNonStaticMembers$2.findViewById(R.id.toolbar_title);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "");
            this.toolbarTitle = (TextView) findViewById6;
        }
    }

    protected final void setToolbarImage(int drawableRes) {
        View KClassImpl$Data$declaredNonStaticMembers$2;
        View KClassImpl$Data$declaredNonStaticMembers$22;
        TextView textView = this.toolbarTitle;
        ImageView imageView = null;
        if (textView != null) {
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                textView = null;
            }
            textView.setVisibility(8);
        } else {
            V binding = getBinding();
            if (binding != null && (KClassImpl$Data$declaredNonStaticMembers$2 = binding.KClassImpl$Data$declaredNonStaticMembers$2()) != null) {
                View findViewById = KClassImpl$Data$declaredNonStaticMembers$2.findViewById(R.id.toolbar_title);
                Intrinsics.checkNotNullExpressionValue(findViewById, "");
                TextView textView2 = (TextView) findViewById;
                this.toolbarTitle = textView2;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    textView2 = null;
                }
                textView2.setVisibility(8);
            }
        }
        ImageView imageView2 = this.toolbarImage;
        if (imageView2 != null) {
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                imageView2 = null;
            }
            imageView2.setVisibility(0);
            ImageView imageView3 = this.toolbarImage;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                imageView = imageView3;
            }
            imageView.setImageDrawable(getDrawableFromRes(drawableRes));
            return;
        }
        V binding2 = getBinding();
        if (binding2 == null || (KClassImpl$Data$declaredNonStaticMembers$22 = binding2.KClassImpl$Data$declaredNonStaticMembers$2()) == null) {
            return;
        }
        View findViewById2 = KClassImpl$Data$declaredNonStaticMembers$22.findViewById(R.id.iv_title_image);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "");
        ImageView imageView4 = (ImageView) findViewById2;
        this.toolbarImage = imageView4;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            imageView4 = null;
        }
        imageView4.setVisibility(0);
        ImageView imageView5 = this.toolbarImage;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            imageView = imageView5;
        }
        imageView.setImageDrawable(getDrawableFromRes(drawableRes));
    }

    public final Drawable getDrawableFromRes(int drawableRes) {
        if (drawableRes != 0) {
            return ContextCompat.PlaceComponentResult(requireContext(), drawableRes);
        }
        return null;
    }

    public final void setMenuRightButton(int icon, int marginRight) {
        View KClassImpl$Data$declaredNonStaticMembers$2;
        TextView textView = this.rightButton;
        TextView textView2 = null;
        if (textView != null && icon != 0) {
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                textView = null;
            }
            textView.setBackground(getDrawableFromRes(icon));
            setMenuRightButtonEnabled(true, marginRight);
            return;
        }
        V binding = getBinding();
        if (binding == null || (KClassImpl$Data$declaredNonStaticMembers$2 = binding.KClassImpl$Data$declaredNonStaticMembers$2()) == null) {
            return;
        }
        View findViewById = KClassImpl$Data$declaredNonStaticMembers$2.findViewById(R.id.right_button);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        TextView textView3 = (TextView) findViewById;
        this.rightButton = textView3;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            textView3 = null;
        }
        textView3.setBackground(getDrawableFromRes(icon));
        setMenuRightButtonEnabled(true, marginRight);
        TextView textView4 = this.rightButton;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            textView2 = textView4;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.base.viewbinding.ViewBindingToolbarFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewBindingToolbarFragment.m439setMenuRightButton$lambda5$lambda4(ViewBindingToolbarFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setMenuRightButton$lambda-5$lambda-4  reason: not valid java name */
    public static final void m439setMenuRightButton$lambda5$lambda4(ViewBindingToolbarFragment viewBindingToolbarFragment, View view) {
        Intrinsics.checkNotNullParameter(viewBindingToolbarFragment, "");
        viewBindingToolbarFragment.onClickRightMenuButton(view);
    }

    public final void setMenuRightButtonContentDescription(int value) {
        TextView textView = this.rightButton;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            textView = null;
        }
        Context context = getContext();
        textView.setContentDescription(context != null ? context.getString(value) : null);
    }

    private final void setMenuRightButtonEnabled(boolean isEnabled, int marginRight) {
        TextView textView = this.rightButton;
        if (textView != null) {
            TextView textView2 = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                textView = null;
            }
            textView.setEnabled(isEnabled);
            TextView textView3 = this.rightButton;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                textView2 = textView3;
            }
            textView2.setVisibility(0);
            setMenuRightButtonMarginRight(marginRight);
        }
    }

    private final void setMenuRightButtonMarginRight(int marginRight) {
        TextView textView = this.rightButton;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            textView = null;
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.setMargins(0, 0, marginRight, 0);
        TextView textView3 = this.rightButton;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            textView2 = textView3;
        }
        textView2.setLayoutParams(layoutParams2);
    }

    public final void setRightButtonOnClickListener(View.OnClickListener onClickListener) {
        TextView textView = this.rightButton;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            textView = null;
        }
        textView.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setTitle(String title) {
        View KClassImpl$Data$declaredNonStaticMembers$2;
        TextView textView = this.toolbarTitle;
        TextView textView2 = null;
        if (textView != null) {
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                textView = null;
            }
            textView.setText(title);
            return;
        }
        V binding = getBinding();
        if (binding == null || (KClassImpl$Data$declaredNonStaticMembers$2 = binding.KClassImpl$Data$declaredNonStaticMembers$2()) == null) {
            return;
        }
        View findViewById = KClassImpl$Data$declaredNonStaticMembers$2.findViewById(R.id.toolbar_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        TextView textView3 = (TextView) findViewById;
        this.toolbarTitle = textView3;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            textView2 = textView3;
        }
        textView2.setText(title);
    }

    public final void setMenuLeftButton(int icon) {
        if (icon != 0) {
            Toolbar toolbar = this.toolbar;
            TextView textView = null;
            if (toolbar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                toolbar = null;
            }
            toolbar.setNavigationIcon(icon);
            Toolbar toolbar2 = this.toolbar;
            if (toolbar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                toolbar2 = null;
            }
            toolbar2.setNavigationOnClickListener(new View.OnClickListener() { // from class: id.dana.base.viewbinding.ViewBindingToolbarFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ViewBindingToolbarFragment.m437setMenuLeftButton$lambda7(ViewBindingToolbarFragment.this, view);
                }
            });
            TextView textView2 = this.leftButton;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                textView = textView2;
            }
            textView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setMenuLeftButton$lambda-7  reason: not valid java name */
    public static final void m437setMenuLeftButton$lambda7(ViewBindingToolbarFragment viewBindingToolbarFragment, View view) {
        Intrinsics.checkNotNullParameter(viewBindingToolbarFragment, "");
        viewBindingToolbarFragment.onClickLeftMenuButton(view);
    }

    public final void setMenuLeftButton(int icon, int marginLeft) {
        View KClassImpl$Data$declaredNonStaticMembers$2;
        TextView textView = this.leftButton;
        TextView textView2 = null;
        if (textView != null && icon != 0) {
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                textView = null;
            }
            textView.setBackground(getDrawableFromRes(icon));
            setMenuLeftButtonEnabled(true, marginLeft);
            return;
        }
        V binding = getBinding();
        if (binding == null || (KClassImpl$Data$declaredNonStaticMembers$2 = binding.KClassImpl$Data$declaredNonStaticMembers$2()) == null) {
            return;
        }
        View findViewById = KClassImpl$Data$declaredNonStaticMembers$2.findViewById(R.id.left_button);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        TextView textView3 = (TextView) findViewById;
        this.leftButton = textView3;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            textView3 = null;
        }
        textView3.setBackground(getDrawableFromRes(icon));
        setMenuLeftButtonEnabled(true, marginLeft);
        TextView textView4 = this.leftButton;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            textView2 = textView4;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.base.viewbinding.ViewBindingToolbarFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewBindingToolbarFragment.m438setMenuLeftButton$lambda9$lambda8(ViewBindingToolbarFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setMenuLeftButton$lambda-9$lambda-8  reason: not valid java name */
    public static final void m438setMenuLeftButton$lambda9$lambda8(ViewBindingToolbarFragment viewBindingToolbarFragment, View view) {
        Intrinsics.checkNotNullParameter(viewBindingToolbarFragment, "");
        viewBindingToolbarFragment.onClickLeftMenuButton(view);
    }

    private final void setMenuLeftButtonEnabled(boolean isEnabled, int marginLeft) {
        TextView textView = this.leftButton;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            textView = null;
        }
        textView.setEnabled(isEnabled);
        TextView textView3 = this.leftButton;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            textView2 = textView3;
        }
        textView2.setVisibility(0);
        setMenuLeftButtonMarginLeft(marginLeft);
    }

    private final void setMenuLeftButtonMarginLeft(int marginLeft) {
        TextView textView = this.leftButton;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            textView = null;
        }
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.setMargins(marginLeft, 0, 0, 0);
        TextView textView3 = this.leftButton;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            textView2 = textView3;
        }
        textView2.setLayoutParams(layoutParams2);
    }

    public final void setMenuRightButtonEnabled(boolean isEnabled) {
        setMenuRightButtonEnabled(isEnabled, 0);
    }

    public final void setLeftButtonContentDescription(String contentDescription) {
        TextView textView = this.leftButton;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            textView = null;
        }
        textView.setContentDescription(contentDescription);
    }

    public final void setRightButtonContentDescription(String contentDescription) {
        TextView textView = this.rightButton;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            textView = null;
        }
        textView.setContentDescription(contentDescription);
    }

    public final void setToolbarTitleContentDescription(String contentDescription) {
        TextView textView = this.toolbarTitle;
        if (textView != null) {
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                textView = null;
            }
            textView.setContentDescription(contentDescription);
        }
    }
}
