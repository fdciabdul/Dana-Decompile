package kotlin.text;

import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/text/ScreenFloatValueRegEx;", "", "Lkotlin/text/Regex;", "value", "Lkotlin/text/Regex;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ScreenFloatValueRegEx {
    public static final ScreenFloatValueRegEx INSTANCE = new ScreenFloatValueRegEx();
    public static final Regex value;

    private ScreenFloatValueRegEx() {
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        sb.append("(\\p{Digit}+)");
        sb.append("(\\.)?(");
        sb.append("(\\p{Digit}+)");
        sb.append("?)(");
        sb.append("[eE][+-]?(\\p{Digit}+)");
        sb.append(")?)|(\\.(");
        sb.append("(\\p{Digit}+)");
        sb.append(")(");
        sb.append("[eE][+-]?(\\p{Digit}+)");
        sb.append(")?)|((");
        sb.append("(0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+))");
        sb.append(")[pP][+-]?");
        sb.append("(\\p{Digit}+)");
        sb.append(')');
        String obj = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[\\x00-\\x20]*[+-]?(NaN|Infinity|((");
        sb2.append(obj);
        sb2.append(")[fFdD]?))[\\x00-\\x20]*");
        value = new Regex(sb2.toString());
    }
}
