package id.dana.social.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.databinding.ViewFeedInputCommentBinding;
import id.dana.extension.lang.StringExtKt;
import id.dana.extension.view.InputExtKt;
import id.dana.feeds.ui.model.FeedCommentModel;
import id.dana.social.common.FeedInputCommentListener;
import id.dana.utils.KeyboardHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"B\u001b\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\b\u0010$\u001a\u0004\u0018\u00010#¢\u0006\u0004\b!\u0010%J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0015\u0010\u0010R(\u0010\u0017\u001a\u0004\u0018\u00010\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\n8\u0002@CX\u0082\u000e¢\u0006\f\n\u0004\b\u0015\u0010\u0016\"\u0004\b\u0015\u0010\u000eR\"\u0010\u0019\u001a\u00020\u00188\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e"}, d2 = {"Lid/dana/social/view/FeedInputCommentView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ViewFeedInputCommentBinding;", "", "getLayout", "()I", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ViewFeedInputCommentBinding;", "Lid/dana/feeds/ui/model/FeedCommentModel;", "commentToReply", "", "setReplyComment", "(Lid/dana/feeds/ui/model/FeedCommentModel;)V", "setup", "()V", "", "p0", "BuiltInFictitiousFunctionClassFactory", "(Z)V", "getAuthRequestContext", "Lid/dana/feeds/ui/model/FeedCommentModel;", "MyBillsEntityDataFactory", "Lid/dana/social/common/FeedInputCommentListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lid/dana/social/common/FeedInputCommentListener;", "getListener", "()Lid/dana/social/common/FeedInputCommentListener;", "setListener", "(Lid/dana/social/common/FeedInputCommentListener;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedInputCommentView extends ViewBindingRichView<ViewFeedInputCommentBinding> {
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private FeedCommentModel MyBillsEntityDataFactory;
    public FeedInputCommentListener listener;

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
        return R.layout.view_feed_input_comment;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedInputCommentView(Context context) {
        super(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedInputCommentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @JvmName(name = "getListener")
    public final FeedInputCommentListener getListener() {
        FeedInputCommentListener feedInputCommentListener = this.listener;
        if (feedInputCommentListener != null) {
            return feedInputCommentListener;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setListener")
    public final void setListener(FeedInputCommentListener feedInputCommentListener) {
        Intrinsics.checkNotNullParameter(feedInputCommentListener, "");
        this.listener = feedInputCommentListener;
    }

    @JvmName(name = "getAuthRequestContext")
    private final void getAuthRequestContext(FeedCommentModel feedCommentModel) {
        this.MyBillsEntityDataFactory = feedCommentModel;
        if (feedCommentModel != null) {
            ViewFeedInputCommentBinding binding = getBinding();
            binding.moveToNextValue.setText(feedCommentModel.NetworkUserEntityData$$ExternalSyntheticLambda2.BuiltInFictitiousFunctionClassFactory);
            binding.NetworkUserEntityData$$ExternalSyntheticLambda0.setText(StringExtKt.MyBillsEntityDataFactory(feedCommentModel.PlaceComponentResult));
            ConstraintLayout constraintLayout = binding.BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
            constraintLayout.setVisibility(0);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            AppCompatEditText appCompatEditText = binding.KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(appCompatEditText, "");
            KeyboardHelper.BuiltInFictitiousFunctionClassFactory(context, appCompatEditText);
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final ViewFeedInputCommentBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewFeedInputCommentBinding authRequestContext = ViewFeedInputCommentBinding.getAuthRequestContext(view);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        AppCompatImageView appCompatImageView = getBinding().lookAheadTest;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(p0 ? 0 : 8);
    }

    private final void getAuthRequestContext() {
        ViewFeedInputCommentBinding binding = getBinding();
        AppCompatTextView appCompatTextView = binding.moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
        InputExtKt.MyBillsEntityDataFactory(appCompatTextView);
        AppCompatTextView appCompatTextView2 = binding.NetworkUserEntityData$$ExternalSyntheticLambda0;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView2, "");
        InputExtKt.MyBillsEntityDataFactory(appCompatTextView2);
        ConstraintLayout constraintLayout = binding.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(8);
        getAuthRequestContext(null);
    }

    public final void setReplyComment(FeedCommentModel commentToReply) {
        Intrinsics.checkNotNullParameter(commentToReply, "");
        getAuthRequestContext(commentToReply);
    }

    /* renamed from: $r8$lambda$WLgzoc9nXgrq-ginvyDQYS5vaoo */
    public static /* synthetic */ void m2960$r8$lambda$WLgzoc9nXgrqginvyDQYS5vaoo(FeedInputCommentView feedInputCommentView, View view) {
        Intrinsics.checkNotNullParameter(feedInputCommentView, "");
        feedInputCommentView.getAuthRequestContext();
    }

    public static /* synthetic */ void $r8$lambda$fzp0NvuGZMc3kkid9ON94n1ec_Y(FeedInputCommentView feedInputCommentView, View view) {
        String str;
        Intrinsics.checkNotNullParameter(feedInputCommentView, "");
        String obj = StringsKt.trim((CharSequence) String.valueOf(feedInputCommentView.getBinding().KClassImpl$Data$declaredNonStaticMembers$2.getText())).toString();
        if ((!StringsKt.isBlank(obj)) == true) {
            FeedInputCommentListener listener = feedInputCommentView.getListener();
            FeedCommentModel feedCommentModel = feedInputCommentView.MyBillsEntityDataFactory;
            if (feedCommentModel == null) {
                str = null;
            } else if (feedCommentModel.MyBillsEntityDataFactory()) {
                str = feedCommentModel.moveToNextValue;
            } else {
                str = feedCommentModel.BuiltInFictitiousFunctionClassFactory;
            }
            if (str == null) {
                str = "";
            }
            listener.MyBillsEntityDataFactory(obj, str);
            feedInputCommentView.getAuthRequestContext();
            KeyboardHelper.BuiltInFictitiousFunctionClassFactory(view);
            AppCompatEditText appCompatEditText = feedInputCommentView.getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(appCompatEditText, "");
            InputExtKt.MyBillsEntityDataFactory(appCompatEditText);
            feedInputCommentView.getBinding().KClassImpl$Data$declaredNonStaticMembers$2.clearFocus();
            feedInputCommentView.BuiltInFictitiousFunctionClassFactory(false);
        }
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        AppCompatEditText appCompatEditText = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(appCompatEditText, "");
        appCompatEditText.addTextChangedListener(new TextWatcher() { // from class: id.dana.social.view.FeedInputCommentView$initInputComment$lambda-1$$inlined$onTextChanged$1
            @Override // android.text.TextWatcher
            public final void afterTextChanged(Editable p0) {
            }

            @Override // android.text.TextWatcher
            public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
            }

            @Override // android.text.TextWatcher
            public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                String obj = p0 != null ? p0.toString() : null;
                if (obj == null) {
                    obj = "";
                }
                if ((!StringsKt.isBlank(obj)) != false) {
                    FeedInputCommentView.this.BuiltInFictitiousFunctionClassFactory(true);
                } else {
                    FeedInputCommentView.this.BuiltInFictitiousFunctionClassFactory(false);
                }
            }
        });
        getBinding().lookAheadTest.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.view.FeedInputCommentView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedInputCommentView.$r8$lambda$fzp0NvuGZMc3kkid9ON94n1ec_Y(FeedInputCommentView.this, view);
            }
        });
        getBinding().getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.view.FeedInputCommentView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedInputCommentView.m2960$r8$lambda$WLgzoc9nXgrqginvyDQYS5vaoo(FeedInputCommentView.this, view);
            }
        });
        KeyboardHelper.PlaceComponentResult(getView(), new KeyboardHelper.KeyboardVisibilityListener() { // from class: id.dana.social.view.FeedInputCommentView$setupKeyboardListener$1
            @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            }

            @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
            public final void MyBillsEntityDataFactory() {
                ViewFeedInputCommentBinding binding;
                binding = FeedInputCommentView.this.getBinding();
                binding.KClassImpl$Data$declaredNonStaticMembers$2.clearFocus();
            }
        });
    }
}
