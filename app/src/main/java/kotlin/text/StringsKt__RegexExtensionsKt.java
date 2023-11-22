package kotlin.text;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\"\u0010\u0002\u001a\u00020\u0001*\u00020\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0086\b¢\u0006\u0004\b\u0002\u0010\u0007\u001a\u001c\u0010\u0002\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0005H\u0086\b¢\u0006\u0004\b\u0002\u0010\t"}, d2 = {"", "Lkotlin/text/Regex;", "toRegex", "(Ljava/lang/String;)Lkotlin/text/Regex;", "", "Lkotlin/text/RegexOption;", SecurityConstants.KEY_OPTIONS, "(Ljava/lang/String;Ljava/util/Set;)Lkotlin/text/Regex;", "option", "(Ljava/lang/String;Lkotlin/text/RegexOption;)Lkotlin/text/Regex;"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes.dex */
class StringsKt__RegexExtensionsKt extends StringsKt__RegexExtensionsJVMKt {
    private static final Regex toRegex(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return new Regex(str);
    }

    private static final Regex toRegex(String str, RegexOption regexOption) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(regexOption, "");
        return new Regex(str, regexOption);
    }

    private static final Regex toRegex(String str, Set<? extends RegexOption> set) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(set, "");
        return new Regex(str, set);
    }
}
