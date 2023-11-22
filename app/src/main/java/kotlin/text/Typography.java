package kotlin.text;

import com.alibaba.ariver.kernel.RVParams;
import id.dana.animation.HomeTabActivity;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\f\n\u0002\b0\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b2\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u001a\u0010\u0014\u001a\u00020\u00028\u0006X\u0086T¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u0012\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0087T¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u0012\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0004R\u0014\u0010\u001a\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0004R\u0014\u0010\u001b\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0004R\u0014\u0010\u001c\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0004R\u0014\u0010\u001d\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0004R\u0014\u0010\u001e\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0004R\u0014\u0010\u001f\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0004R\u0014\u0010 \u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b \u0010\u0004R\u0014\u0010!\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b!\u0010\u0004R\u0014\u0010\"\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\"\u0010\u0004R\u0014\u0010#\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b#\u0010\u0004R\u0014\u0010$\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b$\u0010\u0004R\u0014\u0010%\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b%\u0010\u0004R\u0014\u0010&\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b&\u0010\u0004R\u0014\u0010'\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b'\u0010\u0004R\u0014\u0010(\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b(\u0010\u0004R\u0014\u0010)\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b)\u0010\u0004R\u001a\u0010*\u001a\u00020\u00028\u0006X\u0086T¢\u0006\f\n\u0004\b*\u0010\u0004\u0012\u0004\b+\u0010\u0016R\u001a\u0010,\u001a\u00020\u00028\u0006X\u0087T¢\u0006\f\n\u0004\b,\u0010\u0004\u0012\u0004\b-\u0010\u0016R\u0014\u0010.\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b.\u0010\u0004R\u0014\u0010/\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b/\u0010\u0004R\u0014\u00100\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b0\u0010\u0004R\u0014\u00101\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b1\u0010\u0004"}, d2 = {"Lkotlin/text/Typography;", "", "", "almostEqual", "C", "amp", "bullet", "cent", "copyright", "dagger", "degree", "dollar", "doubleDagger", "doublePrime", "ellipsis", "euro", "greater", "greaterOrEqual", "half", "leftDoubleQuote", "leftGuillemet", "getLeftGuillemet$annotations", "()V", "leftGuillemete", "getLeftGuillemete$annotations", "leftSingleQuote", "less", "lessOrEqual", "lowDoubleQuote", "lowSingleQuote", "mdash", "middleDot", "nbsp", "ndash", "notEqual", "paragraph", "plusMinus", "pound", "prime", "quote", "registered", "rightDoubleQuote", "rightGuillemet", "getRightGuillemet$annotations", "rightGuillemete", "getRightGuillemete$annotations", "rightSingleQuote", HomeTabActivity.WALLET_SECTION, "times", RVParams.TOOLBAR_MENU, "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Typography {
    public static final Typography INSTANCE = new Typography();
    public static final char almostEqual = 8776;
    public static final char amp = '&';
    public static final char bullet = 8226;
    public static final char cent = 162;
    public static final char copyright = 169;
    public static final char dagger = 8224;
    public static final char degree = 176;
    public static final char dollar = '$';
    public static final char doubleDagger = 8225;
    public static final char doublePrime = 8243;
    public static final char ellipsis = 8230;
    public static final char euro = 8364;
    public static final char greater = '>';
    public static final char greaterOrEqual = 8805;
    public static final char half = 189;
    public static final char leftDoubleQuote = 8220;
    public static final char leftGuillemet = 171;
    public static final char leftGuillemete = 171;
    public static final char leftSingleQuote = 8216;
    public static final char less = '<';
    public static final char lessOrEqual = 8804;
    public static final char lowDoubleQuote = 8222;
    public static final char lowSingleQuote = 8218;
    public static final char mdash = 8212;
    public static final char middleDot = 183;
    public static final char nbsp = 160;
    public static final char ndash = 8211;
    public static final char notEqual = 8800;
    public static final char paragraph = 182;
    public static final char plusMinus = 177;
    public static final char pound = 163;
    public static final char prime = 8242;
    public static final char quote = '\"';
    public static final char registered = 174;
    public static final char rightDoubleQuote = 8221;
    public static final char rightGuillemet = 187;
    public static final char rightGuillemete = 187;
    public static final char rightSingleQuote = 8217;
    public static final char section = 167;
    public static final char times = 215;
    public static final char tm = 8482;

    public static /* synthetic */ void getLeftGuillemet$annotations() {
    }

    @Deprecated(message = "This constant has a typo in the name. Use leftGuillemet instead.", replaceWith = @ReplaceWith(expression = "Typography.leftGuillemet", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.6")
    public static /* synthetic */ void getLeftGuillemete$annotations() {
    }

    public static /* synthetic */ void getRightGuillemet$annotations() {
    }

    @Deprecated(message = "This constant has a typo in the name. Use rightGuillemet instead.", replaceWith = @ReplaceWith(expression = "Typography.rightGuillemet", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.6")
    public static /* synthetic */ void getRightGuillemete$annotations() {
    }

    private Typography() {
    }
}
