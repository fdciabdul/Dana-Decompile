package androidx.core.text;

import android.text.SpannableStringBuilder;
import java.util.Locale;
import kotlin.text.Typography;

/* loaded from: classes3.dex */
public final class BidiFormatter {
    static final BidiFormatter BuiltInFictitiousFunctionClassFactory;
    static final BidiFormatter KClassImpl$Data$declaredNonStaticMembers$2;
    private static final String NetworkUserEntityData$$ExternalSyntheticLambda0;
    static final TextDirectionHeuristicCompat PlaceComponentResult;
    private static final String getAuthRequestContext;
    public final TextDirectionHeuristicCompat MyBillsEntityDataFactory;
    private final int lookAheadTest;
    private final boolean moveToNextValue;

    static {
        TextDirectionHeuristicCompat textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.PlaceComponentResult;
        PlaceComponentResult = textDirectionHeuristicCompat;
        getAuthRequestContext = Character.toString((char) 8206);
        NetworkUserEntityData$$ExternalSyntheticLambda0 = Character.toString((char) 8207);
        BuiltInFictitiousFunctionClassFactory = new BidiFormatter(false, 2, textDirectionHeuristicCompat);
        KClassImpl$Data$declaredNonStaticMembers$2 = new BidiFormatter(true, 2, textDirectionHeuristicCompat);
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        boolean MyBillsEntityDataFactory = BidiFormatter.PlaceComponentResult(Locale.getDefault());
        TextDirectionHeuristicCompat KClassImpl$Data$declaredNonStaticMembers$2 = BidiFormatter.PlaceComponentResult;
        int getAuthRequestContext = 2;

        static BidiFormatter BuiltInFictitiousFunctionClassFactory(boolean z) {
            return z ? BidiFormatter.KClassImpl$Data$declaredNonStaticMembers$2 : BidiFormatter.BuiltInFictitiousFunctionClassFactory;
        }
    }

    public static BidiFormatter MyBillsEntityDataFactory() {
        Builder builder = new Builder();
        if (builder.getAuthRequestContext == 2 && builder.KClassImpl$Data$declaredNonStaticMembers$2 == PlaceComponentResult) {
            return Builder.BuiltInFictitiousFunctionClassFactory(builder.MyBillsEntityDataFactory);
        }
        return new BidiFormatter(builder.MyBillsEntityDataFactory, builder.getAuthRequestContext, builder.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    private BidiFormatter(boolean z, int i, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        this.moveToNextValue = z;
        this.lookAheadTest = i;
        this.MyBillsEntityDataFactory = textDirectionHeuristicCompat;
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return (this.lookAheadTest & 2) != 0;
    }

    private String getAuthRequestContext(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean authRequestContext = textDirectionHeuristicCompat.getAuthRequestContext(charSequence, 0, charSequence.length());
        if (this.moveToNextValue || !(authRequestContext || KClassImpl$Data$declaredNonStaticMembers$2(charSequence) == 1)) {
            return this.moveToNextValue ? (!authRequestContext || KClassImpl$Data$declaredNonStaticMembers$2(charSequence) == -1) ? NetworkUserEntityData$$ExternalSyntheticLambda0 : "" : "";
        }
        return getAuthRequestContext;
    }

    private String PlaceComponentResult(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean authRequestContext = textDirectionHeuristicCompat.getAuthRequestContext(charSequence, 0, charSequence.length());
        if (this.moveToNextValue || !(authRequestContext || getAuthRequestContext(charSequence) == 1)) {
            return this.moveToNextValue ? (!authRequestContext || getAuthRequestContext(charSequence) == -1) ? NetworkUserEntityData$$ExternalSyntheticLambda0 : "" : "";
        }
        return getAuthRequestContext;
    }

    public final CharSequence MyBillsEntityDataFactory(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        if (charSequence == null) {
            return null;
        }
        boolean authRequestContext = textDirectionHeuristicCompat.getAuthRequestContext(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (KClassImpl$Data$declaredNonStaticMembers$2()) {
            spannableStringBuilder.append((CharSequence) PlaceComponentResult(charSequence, authRequestContext ? TextDirectionHeuristicsCompat.NetworkUserEntityData$$ExternalSyntheticLambda0 : TextDirectionHeuristicsCompat.MyBillsEntityDataFactory));
        }
        if (authRequestContext != this.moveToNextValue) {
            spannableStringBuilder.append(authRequestContext ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        spannableStringBuilder.append((CharSequence) getAuthRequestContext(charSequence, authRequestContext ? TextDirectionHeuristicsCompat.NetworkUserEntityData$$ExternalSyntheticLambda0 : TextDirectionHeuristicsCompat.MyBillsEntityDataFactory));
        return spannableStringBuilder;
    }

    static boolean PlaceComponentResult(Locale locale) {
        return TextUtilsCompat.PlaceComponentResult(locale) == 1;
    }

    private static int KClassImpl$Data$declaredNonStaticMembers$2(CharSequence charSequence) {
        DirectionalityEstimator directionalityEstimator = new DirectionalityEstimator(charSequence);
        directionalityEstimator.BuiltInFictitiousFunctionClassFactory = directionalityEstimator.KClassImpl$Data$declaredNonStaticMembers$2;
        int i = 0;
        int i2 = 0;
        while (directionalityEstimator.BuiltInFictitiousFunctionClassFactory > 0) {
            byte KClassImpl$Data$declaredNonStaticMembers$22 = directionalityEstimator.KClassImpl$Data$declaredNonStaticMembers$2();
            if (KClassImpl$Data$declaredNonStaticMembers$22 != 0) {
                if (KClassImpl$Data$declaredNonStaticMembers$22 == 1 || KClassImpl$Data$declaredNonStaticMembers$22 == 2) {
                    if (i == 0) {
                        return 1;
                    }
                    if (i2 == 0) {
                        i2 = i;
                    }
                } else if (KClassImpl$Data$declaredNonStaticMembers$22 != 9) {
                    switch (KClassImpl$Data$declaredNonStaticMembers$22) {
                        case 14:
                        case 15:
                            if (i2 == i) {
                                return -1;
                            }
                            i--;
                            break;
                        case 16:
                        case 17:
                            if (i2 == i) {
                                return 1;
                            }
                            i--;
                            break;
                        case 18:
                            i++;
                            break;
                        default:
                            if (i2 != 0) {
                                break;
                            } else {
                                i2 = i;
                                break;
                            }
                    }
                } else {
                    continue;
                }
            } else if (i == 0) {
                return -1;
            } else {
                if (i2 == 0) {
                    i2 = i;
                }
            }
        }
        return 0;
    }

    private static int getAuthRequestContext(CharSequence charSequence) {
        DirectionalityEstimator directionalityEstimator = new DirectionalityEstimator(charSequence);
        directionalityEstimator.BuiltInFictitiousFunctionClassFactory = 0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (directionalityEstimator.BuiltInFictitiousFunctionClassFactory < directionalityEstimator.KClassImpl$Data$declaredNonStaticMembers$2 && i == 0) {
            byte BuiltInFictitiousFunctionClassFactory2 = directionalityEstimator.BuiltInFictitiousFunctionClassFactory();
            if (BuiltInFictitiousFunctionClassFactory2 != 0) {
                if (BuiltInFictitiousFunctionClassFactory2 == 1 || BuiltInFictitiousFunctionClassFactory2 == 2) {
                    if (i3 == 0) {
                        return 1;
                    }
                } else if (BuiltInFictitiousFunctionClassFactory2 != 9) {
                    switch (BuiltInFictitiousFunctionClassFactory2) {
                        case 14:
                        case 15:
                            i3++;
                            i2 = -1;
                            break;
                        case 16:
                        case 17:
                            i3++;
                            i2 = 1;
                            break;
                        case 18:
                            i3--;
                            i2 = 0;
                            break;
                    }
                }
            } else if (i3 == 0) {
                return -1;
            }
            i = i3;
        }
        if (i != 0) {
            if (i2 != 0) {
                return i2;
            }
            while (directionalityEstimator.BuiltInFictitiousFunctionClassFactory > 0) {
                switch (directionalityEstimator.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    case 14:
                    case 15:
                        if (i == i3) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i == i3) {
                            return 1;
                        }
                        break;
                    case 18:
                        i3++;
                        continue;
                }
                i3--;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class DirectionalityEstimator {
        private static final byte[] getAuthRequestContext = new byte[1792];
        int BuiltInFictitiousFunctionClassFactory;
        final int KClassImpl$Data$declaredNonStaticMembers$2;
        private char MyBillsEntityDataFactory;
        private final CharSequence NetworkUserEntityData$$ExternalSyntheticLambda0;
        private final boolean PlaceComponentResult = false;

        static {
            for (int i = 0; i < 1792; i++) {
                getAuthRequestContext[i] = Character.getDirectionality(i);
            }
        }

        DirectionalityEstimator(CharSequence charSequence) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = charSequence;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = charSequence.length();
        }

        private static byte getAuthRequestContext(char c) {
            return c < 1792 ? getAuthRequestContext[c] : Character.getDirectionality(c);
        }

        final byte BuiltInFictitiousFunctionClassFactory() {
            char charAt = this.NetworkUserEntityData$$ExternalSyntheticLambda0.charAt(this.BuiltInFictitiousFunctionClassFactory);
            this.MyBillsEntityDataFactory = charAt;
            if (Character.isHighSurrogate(charAt)) {
                int codePointAt = Character.codePointAt(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.BuiltInFictitiousFunctionClassFactory);
                this.BuiltInFictitiousFunctionClassFactory += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.BuiltInFictitiousFunctionClassFactory++;
            byte authRequestContext = getAuthRequestContext(this.MyBillsEntityDataFactory);
            if (this.PlaceComponentResult) {
                char c = this.MyBillsEntityDataFactory;
                if (c == '<') {
                    return lookAheadTest();
                }
                return c == '&' ? MyBillsEntityDataFactory() : authRequestContext;
            }
            return authRequestContext;
        }

        final byte KClassImpl$Data$declaredNonStaticMembers$2() {
            char charAt = this.NetworkUserEntityData$$ExternalSyntheticLambda0.charAt(this.BuiltInFictitiousFunctionClassFactory - 1);
            this.MyBillsEntityDataFactory = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.BuiltInFictitiousFunctionClassFactory);
                this.BuiltInFictitiousFunctionClassFactory -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.BuiltInFictitiousFunctionClassFactory--;
            byte authRequestContext = getAuthRequestContext(this.MyBillsEntityDataFactory);
            if (this.PlaceComponentResult) {
                char c = this.MyBillsEntityDataFactory;
                if (c == '>') {
                    return PlaceComponentResult();
                }
                return c == ';' ? getAuthRequestContext() : authRequestContext;
            }
            return authRequestContext;
        }

        private byte lookAheadTest() {
            char charAt;
            int i = this.BuiltInFictitiousFunctionClassFactory;
            while (true) {
                int i2 = this.BuiltInFictitiousFunctionClassFactory;
                if (i2 < this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    CharSequence charSequence = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    this.BuiltInFictitiousFunctionClassFactory = i2 + 1;
                    char charAt2 = charSequence.charAt(i2);
                    this.MyBillsEntityDataFactory = charAt2;
                    if (charAt2 == '>') {
                        return (byte) 12;
                    }
                    if (charAt2 == '\"' || charAt2 == '\'') {
                        do {
                            int i3 = this.BuiltInFictitiousFunctionClassFactory;
                            if (i3 < this.KClassImpl$Data$declaredNonStaticMembers$2) {
                                CharSequence charSequence2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                                this.BuiltInFictitiousFunctionClassFactory = i3 + 1;
                                charAt = charSequence2.charAt(i3);
                                this.MyBillsEntityDataFactory = charAt;
                            }
                        } while (charAt != charAt2);
                    }
                } else {
                    this.BuiltInFictitiousFunctionClassFactory = i;
                    this.MyBillsEntityDataFactory = Typography.less;
                    return (byte) 13;
                }
            }
        }

        private byte PlaceComponentResult() {
            char charAt;
            int i = this.BuiltInFictitiousFunctionClassFactory;
            while (true) {
                int i2 = this.BuiltInFictitiousFunctionClassFactory;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                int i3 = i2 - 1;
                this.BuiltInFictitiousFunctionClassFactory = i3;
                char charAt2 = charSequence.charAt(i3);
                this.MyBillsEntityDataFactory = charAt2;
                if (charAt2 != '<') {
                    if (charAt2 == '>') {
                        break;
                    } else if (charAt2 == '\"' || charAt2 == '\'') {
                        do {
                            int i4 = this.BuiltInFictitiousFunctionClassFactory;
                            if (i4 > 0) {
                                CharSequence charSequence2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                                int i5 = i4 - 1;
                                this.BuiltInFictitiousFunctionClassFactory = i5;
                                charAt = charSequence2.charAt(i5);
                                this.MyBillsEntityDataFactory = charAt;
                            }
                        } while (charAt != charAt2);
                    }
                } else {
                    return (byte) 12;
                }
            }
            this.BuiltInFictitiousFunctionClassFactory = i;
            this.MyBillsEntityDataFactory = Typography.greater;
            return (byte) 13;
        }

        private byte MyBillsEntityDataFactory() {
            char charAt;
            do {
                int i = this.BuiltInFictitiousFunctionClassFactory;
                if (i >= this.KClassImpl$Data$declaredNonStaticMembers$2) {
                    return (byte) 12;
                }
                CharSequence charSequence = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                this.BuiltInFictitiousFunctionClassFactory = i + 1;
                charAt = charSequence.charAt(i);
                this.MyBillsEntityDataFactory = charAt;
            } while (charAt != ';');
            return (byte) 12;
        }

        private byte getAuthRequestContext() {
            char charAt;
            int i = this.BuiltInFictitiousFunctionClassFactory;
            do {
                int i2 = this.BuiltInFictitiousFunctionClassFactory;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                int i3 = i2 - 1;
                this.BuiltInFictitiousFunctionClassFactory = i3;
                charAt = charSequence.charAt(i3);
                this.MyBillsEntityDataFactory = charAt;
                if (charAt == '&') {
                    return (byte) 12;
                }
            } while (charAt != ';');
            this.BuiltInFictitiousFunctionClassFactory = i;
            this.MyBillsEntityDataFactory = ';';
            return (byte) 13;
        }
    }
}
