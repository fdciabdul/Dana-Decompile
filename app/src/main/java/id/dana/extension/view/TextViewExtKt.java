package id.dana.extension.view;

import androidx.emoji.widget.EmojiAppCompatTextView;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroidx/emoji/widget/EmojiAppCompatTextView;", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/emoji/widget/EmojiAppCompatTextView;Ljava/lang/String;)V"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TextViewExtKt {
    public static final void KClassImpl$Data$declaredNonStaticMembers$2(EmojiAppCompatTextView emojiAppCompatTextView, String str) {
        Intrinsics.checkNotNullParameter(emojiAppCompatTextView, "");
        if (str == null) {
            return;
        }
        try {
            emojiAppCompatTextView.setText(new StringBuilder().appendCodePoint(Integer.parseInt(StringsKt.removePrefix(str, (CharSequence) "U+"), 16)).toString());
        } catch (Throwable th) {
            String message = th.getMessage();
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.ACTIVITY_REACTIONS, message != null ? message : "", th);
        }
    }
}
