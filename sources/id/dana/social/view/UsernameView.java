package id.dana.social.view;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.social.view.activity.ChangeUsernameActivity;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\u0007J\r\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u0007R\u0016\u0010\u0010\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/social/view/UsernameView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "", "hideUsernameEmptyState", "()V", "", "username", "setUsername", "(Ljava/lang/String;)V", "setup", "showUsernameEmptyState", "getAuthRequestContext", "Ljava/lang/String;", "MyBillsEntityDataFactory", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UsernameView extends BaseRichView {
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private String MyBillsEntityDataFactory;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UsernameView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UsernameView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_username;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UsernameView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.MyBillsEntityDataFactory = "";
    }

    public /* synthetic */ UsernameView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.cl_username);
        if (constraintLayout != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.view.UsernameView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UsernameView.m2966$r8$lambda$mTgJCyrOG6qomks3bFrODaVKzs(UsernameView.this, view);
                }
            });
        }
    }

    public final void setUsername(String username) {
        Intrinsics.checkNotNullParameter(username, "");
        this.MyBillsEntityDataFactory = username;
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.PostalAddressProto);
        if (appCompatTextView != null) {
            appCompatTextView.setText(username);
        }
    }

    public final void showUsernameEmptyState() {
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.iv_view_username_red_dot);
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    public final void hideUsernameEmptyState() {
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.iv_view_username_red_dot);
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    /* renamed from: $r8$lambda$mTgJCyrOG6qomks3bF-rODaVKzs  reason: not valid java name */
    public static /* synthetic */ void m2966$r8$lambda$mTgJCyrOG6qomks3bFrODaVKzs(UsernameView usernameView, View view) {
        Intrinsics.checkNotNullParameter(usernameView, "");
        Intent putExtras = new Intent(usernameView.getContext(), ChangeUsernameActivity.class).putExtras(BundleKt.PlaceComponentResult(TuplesKt.to(ChangeUsernameActivity.PARAM_USERNAME, usernameView.MyBillsEntityDataFactory)));
        Context context = usernameView.getContext();
        if (context != null) {
            context.startActivity(putExtras);
        }
        Intrinsics.checkNotNullExpressionValue(putExtras, "");
    }
}
