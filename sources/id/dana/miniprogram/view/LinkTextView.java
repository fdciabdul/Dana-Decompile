package id.dana.miniprogram.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.engineer.linktextview.Linker;
import com.engineer.linktextview.internal.OnLinkClickListener;
import com.engineer.linktextview.internal.TextViewLinkMovementMethod;
import id.dana.R;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006R$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/miniprogram/view/LinkTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "plainText", "", "applyLinkText", "(Ljava/lang/String;)V", "Lcom/engineer/linktextview/internal/OnLinkClickListener;", "MyBillsEntityDataFactory", "Lcom/engineer/linktextview/internal/OnLinkClickListener;", "getOnLinkClickListener", "()Lcom/engineer/linktextview/internal/OnLinkClickListener;", "setOnLinkClickListener", "(Lcom/engineer/linktextview/internal/OnLinkClickListener;)V", "onLinkClickListener", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LinkTextView extends AppCompatTextView {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private OnLinkClickListener onLinkClickListener;
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LinkTextView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LinkTextView(Context context, AttributeSet attributeSet) {
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

    public final void applyLinkText() {
        applyLinkText$default(this, null, 1, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        applyLinkText$default(this, null, 1, null);
    }

    public /* synthetic */ LinkTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @JvmName(name = "getOnLinkClickListener")
    public final OnLinkClickListener getOnLinkClickListener() {
        return this.onLinkClickListener;
    }

    @JvmName(name = "setOnLinkClickListener")
    public final void setOnLinkClickListener(OnLinkClickListener onLinkClickListener) {
        this.onLinkClickListener = onLinkClickListener;
    }

    public static /* synthetic */ void applyLinkText$default(LinkTextView linkTextView, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            CharSequence text = linkTextView.getText();
            str = text != null ? text.toString() : null;
        }
        linkTextView.applyLinkText(str);
    }

    public final void applyLinkText(String plainText) {
        String replace$default;
        String replace$default2;
        ArrayList emptyList;
        int indexOf$default;
        if (plainText == null || (replace$default = StringsKt.replace$default(plainText, "{", "", false, 4, (Object) null)) == null || (replace$default2 = StringsKt.replace$default(replace$default, "}", "", false, 4, (Object) null)) == null) {
            return;
        }
        Linker.Builder builder = new Linker.Builder();
        LinkTextView linkTextView = this;
        Intrinsics.checkParameterIsNotNull(linkTextView, "");
        builder.moveToNextValue = linkTextView;
        Intrinsics.checkParameterIsNotNull(replace$default2, "");
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = replace$default2;
        if (plainText != null) {
            String str = plainText;
            int indexOf$default2 = StringsKt.indexOf$default((CharSequence) str, '{', 0, false, 6, (Object) null);
            emptyList = new ArrayList();
            while (indexOf$default2 >= 0) {
                int i = indexOf$default2 + 1;
                int indexOf$default3 = StringsKt.indexOf$default((CharSequence) str, '}', i, false, 4, (Object) null);
                if (indexOf$default3 <= 0) {
                    break;
                }
                String substring = plainText.substring(i, indexOf$default3);
                Intrinsics.checkNotNullExpressionValue(substring, "");
                if ((!StringsKt.isBlank(substring)) != false) {
                    emptyList.add(substring);
                }
                indexOf$default2 = StringsKt.indexOf$default((CharSequence) str, '{', indexOf$default3, false, 4, (Object) null);
            }
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        Intrinsics.checkParameterIsNotNull(emptyList, "");
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = emptyList;
        builder.PlaceComponentResult = ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f22912131099753);
        OnLinkClickListener onLinkClickListener = new OnLinkClickListener() { // from class: id.dana.miniprogram.view.LinkTextView$applyLinkText$1
            @Override // com.engineer.linktextview.internal.OnLinkClickListener
            public final void PlaceComponentResult(View p0, String p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                OnLinkClickListener onLinkClickListener2 = LinkTextView.this.getOnLinkClickListener();
                if (onLinkClickListener2 != null) {
                    onLinkClickListener2.PlaceComponentResult(p0, p1);
                }
            }
        };
        Intrinsics.checkParameterIsNotNull(onLinkClickListener, "");
        builder.MyBillsEntityDataFactory = onLinkClickListener;
        Linker linker = Linker.INSTANCE;
        TextView textView = builder.moveToNextValue;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        String str2 = builder.KClassImpl$Data$declaredNonStaticMembers$2;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        List<String> list = builder.NetworkUserEntityData$$ExternalSyntheticLambda0;
        final int i2 = builder.PlaceComponentResult;
        final boolean z = builder.getErrorConfigVersion;
        final OnLinkClickListener onLinkClickListener2 = builder.MyBillsEntityDataFactory;
        if (onLinkClickListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        LinkMovementMethod linkMovementMethod = builder.getAuthRequestContext;
        List<Pair<String, Integer>> list2 = builder.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkParameterIsNotNull(str2, "");
        Intrinsics.checkParameterIsNotNull(onLinkClickListener2, "");
        if (textView == null) {
            throw new IllegalStateException("the TextView must not null");
        }
        if ((list == null || list.isEmpty()) && (list2 == null || list2.isEmpty())) {
            textView.setText(str2);
        } else if (list2 == null || (!list2.isEmpty()) == false) {
            if (list == null || !(!list.isEmpty()) == true) {
                return;
            }
            String str3 = str2;
            SpannableString spannableString = new SpannableString(str3);
            for (final String str4 : list) {
                if (!TextUtils.isEmpty(str4)) {
                    Matcher matcher = Pattern.compile(str4).matcher(str3);
                    while (matcher.find()) {
                        spannableString.setSpan(new ClickableSpan() { // from class: com.engineer.linktextview.Linker$applyLinkInternal$1
                            @Override // android.text.style.ClickableSpan
                            public final void onClick(View p0) {
                                Intrinsics.checkParameterIsNotNull(p0, "");
                                OnLinkClickListener onLinkClickListener3 = OnLinkClickListener.this;
                                if (onLinkClickListener3 != null) {
                                    onLinkClickListener3.PlaceComponentResult(p0, str4);
                                }
                            }

                            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                            public final void updateDrawState(TextPaint p0) {
                                Intrinsics.checkParameterIsNotNull(p0, "");
                                p0.setColor(i2);
                                p0.setUnderlineText(z);
                            }
                        }, matcher.start(), matcher.end(), 33);
                    }
                }
            }
            textView.setText(spannableString);
            if (linkMovementMethod != null) {
                textView.setMovementMethod(linkMovementMethod);
            } else {
                textView.setMovementMethod(new TextViewLinkMovementMethod().MyBillsEntityDataFactory());
            }
        } else {
            String str5 = str2;
            SpannableString spannableString2 = new SpannableString(str5);
            for (final Pair<String, Integer> pair : list2) {
                if (!TextUtils.isEmpty(pair.getFirst()) && (indexOf$default = StringsKt.indexOf$default((CharSequence) str5, pair.getFirst(), 0, false, 6, (Object) null)) >= 0) {
                    spannableString2.setSpan(new ClickableSpan() { // from class: com.engineer.linktextview.Linker$applyLinkInternal$clickableSpan$1
                        @Override // android.text.style.ClickableSpan
                        public final void onClick(View p0) {
                            Intrinsics.checkParameterIsNotNull(p0, "");
                            OnLinkClickListener onLinkClickListener3 = OnLinkClickListener.this;
                            if (onLinkClickListener3 != null) {
                                onLinkClickListener3.PlaceComponentResult(p0, (String) pair.getFirst());
                            }
                        }

                        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                        public final void updateDrawState(TextPaint p0) {
                            Intrinsics.checkParameterIsNotNull(p0, "");
                            p0.setColor(((Number) pair.getSecond()).intValue());
                            p0.setUnderlineText(z);
                        }
                    }, indexOf$default, pair.getFirst().length() + indexOf$default, 33);
                }
            }
            textView.setText(spannableString2);
            if (linkMovementMethod != null) {
                textView.setMovementMethod(linkMovementMethod);
            } else {
                textView.setMovementMethod(new TextViewLinkMovementMethod().MyBillsEntityDataFactory());
            }
        }
    }
}
