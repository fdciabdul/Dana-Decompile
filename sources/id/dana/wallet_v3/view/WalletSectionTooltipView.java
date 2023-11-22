package id.dana.wallet_v3.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.databinding.ViewWalletSectionTooltipBinding;
import id.dana.showcase.Content;
import id.dana.wallet_v3.listener.SectionTooltipClickListener;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\b\u0016\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010%\u001a\u00020\u0003¢\u0006\u0004\b&\u0010'B+\b\u0016\u0012\u0006\u0010\"\u001a\u00020!\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\u0006\u0010(\u001a\u00020\u0003¢\u0006\u0004\b&\u0010)J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u001c\u0010\u0013J\u000f\u0010\u001d\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001d\u0010\u000fR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010 "}, d2 = {"Lid/dana/wallet_v3/view/WalletSectionTooltipView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ViewWalletSectionTooltipBinding;", "", "getLayout", "()I", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ViewWalletSectionTooltipBinding;", "value", "", "setCloseButtonContentDescription", "(I)V", "setOnClickCloseListener", "()V", "", "sectionType", "setTooltipCloseContentDescription", "(Ljava/lang/String;)V", "Lid/dana/showcase/Content;", "content", "setTooltipContent", "(Lid/dana/showcase/Content;)V", "Lid/dana/wallet_v3/listener/SectionTooltipClickListener;", "sectionTooltipListener", "setTooltipListener", "(Lid/dana/wallet_v3/listener/SectionTooltipClickListener;)V", "setTooltipView", "setup", "sectionTooltipClickListener", "Lid/dana/wallet_v3/listener/SectionTooltipClickListener;", "Ljava/lang/String;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class WalletSectionTooltipView extends ViewBindingRichView<ViewWalletSectionTooltipBinding> {
    public Map<Integer, View> _$_findViewCache;
    private SectionTooltipClickListener sectionTooltipClickListener;
    private String sectionType;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WalletSectionTooltipView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WalletSectionTooltipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public static void __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(AppCompatImageView appCompatImageView, int i) {
        if (appCompatImageView instanceof ImageView) {
            InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
        } else {
            appCompatImageView.setImageResource(i);
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
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
        return R.layout.view_wallet_section_tooltip;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletSectionTooltipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.sectionType = "";
    }

    public /* synthetic */ WalletSectionTooltipView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WalletSectionTooltipView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.sectionType = "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final ViewWalletSectionTooltipBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewWalletSectionTooltipBinding MyBillsEntityDataFactory = ViewWalletSectionTooltipBinding.MyBillsEntityDataFactory(view);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        setOnClickCloseListener();
    }

    public final void setTooltipListener(SectionTooltipClickListener sectionTooltipListener) {
        Intrinsics.checkNotNullParameter(sectionTooltipListener, "");
        this.sectionTooltipClickListener = sectionTooltipListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void setTooltipView(String sectionType) {
        Content content;
        Intrinsics.checkNotNullParameter(sectionType, "");
        this.sectionType = sectionType;
        switch (sectionType.hashCode()) {
            case -1150817175:
                if (sectionType.equals("FINANCIAL")) {
                    content = new Content(getContext().getString(R.string.financial_tooltip_title), getContext().getString(R.string.financial_tooltip_desc), (int) R.drawable.ic_investment_tooltip);
                    break;
                }
                content = null;
                break;
            case -554006299:
                if (sectionType.equals("VOUCHER_AND_TICKET")) {
                    content = new Content(getContext().getString(R.string.voucher_ticket_tooltip_title), getContext().getString(R.string.voucher_ticket_tooltip_desc), (int) R.drawable.ic_voucher_and_ticket_tooltip);
                    break;
                }
                content = null;
                break;
            case -68698650:
                if (sectionType.equals("PAYMENT")) {
                    content = new Content(getContext().getString(R.string.payment_tooltip_title), getContext().getString(R.string.payment_tooltip_desc), (int) R.drawable.ic_payment_tooltip);
                    break;
                }
                content = null;
                break;
            case 646865086:
                if (sectionType.equals("IDENTITY")) {
                    content = new Content(getContext().getString(R.string.identity_tooltip_title), getContext().getString(R.string.identity_tooltip_desc), (int) R.drawable.ic_identity_tooltip);
                    break;
                }
                content = null;
                break;
            case 1076711462:
                if (sectionType.equals("LOYALTY")) {
                    content = new Content(getContext().getString(R.string.loyalty_tooltip_title), getContext().getString(R.string.loyalty_tooltip_desc), (int) R.drawable.ic_loyalty_tooltip);
                    break;
                }
                content = null;
                break;
            default:
                content = null;
                break;
        }
        setTooltipCloseContentDescription(sectionType);
        setTooltipContent(content);
    }

    private final void setTooltipContent(Content content) {
        if (content != null) {
            getBinding().PlaceComponentResult.setText(content.KClassImpl$Data$declaredNonStaticMembers$2);
            getBinding().MyBillsEntityDataFactory.setText(content.getAuthRequestContext);
            __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(getBinding().BuiltInFictitiousFunctionClassFactory, content.PlaceComponentResult);
        }
    }

    private final void setTooltipCloseContentDescription(String sectionType) {
        switch (sectionType.hashCode()) {
            case -1150817175:
                if (sectionType.equals("FINANCIAL")) {
                    setCloseButtonContentDescription(R.string.wallet_btn_close_tooltip_financial);
                    return;
                }
                return;
            case -554006299:
                if (sectionType.equals("VOUCHER_AND_TICKET")) {
                    setCloseButtonContentDescription(R.string.wallet_btn_close_tooltip_voucher);
                    return;
                }
                return;
            case -68698650:
                if (sectionType.equals("PAYMENT")) {
                    setCloseButtonContentDescription(R.string.wallet_btn_close_tooltip_payment);
                    return;
                }
                return;
            case 646865086:
                if (sectionType.equals("IDENTITY")) {
                    setCloseButtonContentDescription(R.string.wallet_btn_close_tooltip_identity);
                    return;
                }
                return;
            case 1076711462:
                if (sectionType.equals("LOYALTY")) {
                    setCloseButtonContentDescription(R.string.wallet_btn_close_tooltip_loyalty);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private final void setCloseButtonContentDescription(int value) {
        getBinding().getAuthRequestContext.setContentDescription(getContext().getString(value));
    }

    private final void setOnClickCloseListener() {
        getBinding().getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.wallet_v3.view.WalletSectionTooltipView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WalletSectionTooltipView.m3099setOnClickCloseListener$lambda1(WalletSectionTooltipView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setOnClickCloseListener$lambda-1  reason: not valid java name */
    public static final void m3099setOnClickCloseListener$lambda1(WalletSectionTooltipView walletSectionTooltipView, View view) {
        Intrinsics.checkNotNullParameter(walletSectionTooltipView, "");
        SectionTooltipClickListener sectionTooltipClickListener = walletSectionTooltipView.sectionTooltipClickListener;
        if (sectionTooltipClickListener != null) {
            sectionTooltipClickListener.onCloseClicked(walletSectionTooltipView.sectionType);
        }
    }
}
