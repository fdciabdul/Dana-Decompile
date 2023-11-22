package androidx.core.text;

import java.util.Locale;

/* loaded from: classes3.dex */
public final class TextDirectionHeuristicsCompat {
    public static final TextDirectionHeuristicCompat MyBillsEntityDataFactory = new TextDirectionHeuristicInternal(null, false);
    public static final TextDirectionHeuristicCompat NetworkUserEntityData$$ExternalSyntheticLambda0 = new TextDirectionHeuristicInternal(null, true);
    public static final TextDirectionHeuristicCompat PlaceComponentResult = new TextDirectionHeuristicInternal(FirstStrong.KClassImpl$Data$declaredNonStaticMembers$2, false);
    public static final TextDirectionHeuristicCompat KClassImpl$Data$declaredNonStaticMembers$2 = new TextDirectionHeuristicInternal(FirstStrong.KClassImpl$Data$declaredNonStaticMembers$2, true);
    public static final TextDirectionHeuristicCompat BuiltInFictitiousFunctionClassFactory = new TextDirectionHeuristicInternal(AnyStrong.BuiltInFictitiousFunctionClassFactory, false);
    public static final TextDirectionHeuristicCompat getAuthRequestContext = TextDirectionHeuristicLocale.BuiltInFictitiousFunctionClassFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface TextDirectionAlgorithm {
        int KClassImpl$Data$declaredNonStaticMembers$2(CharSequence charSequence, int i, int i2);
    }

    static int KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        if (i != 0) {
            return (i == 1 || i == 2) ? 0 : 2;
        }
        return 1;
    }

    static int MyBillsEntityDataFactory(int i) {
        if (i != 0) {
            if (i == 1 || i == 2) {
                return 0;
            }
            switch (i) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }

    /* loaded from: classes3.dex */
    static abstract class TextDirectionHeuristicImpl implements TextDirectionHeuristicCompat {
        private final TextDirectionAlgorithm PlaceComponentResult;

        protected abstract boolean KClassImpl$Data$declaredNonStaticMembers$2();

        TextDirectionHeuristicImpl(TextDirectionAlgorithm textDirectionAlgorithm) {
            this.PlaceComponentResult = textDirectionAlgorithm;
        }

        @Override // androidx.core.text.TextDirectionHeuristicCompat
        public boolean getAuthRequestContext(CharSequence charSequence, int i, int i2) {
            if (charSequence == null || i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
                throw new IllegalArgumentException();
            }
            if (this.PlaceComponentResult == null) {
                return KClassImpl$Data$declaredNonStaticMembers$2();
            }
            return MyBillsEntityDataFactory(charSequence, i, i2);
        }

        private boolean MyBillsEntityDataFactory(CharSequence charSequence, int i, int i2) {
            int KClassImpl$Data$declaredNonStaticMembers$2 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(charSequence, i, i2);
            if (KClassImpl$Data$declaredNonStaticMembers$2 != 0) {
                if (KClassImpl$Data$declaredNonStaticMembers$2 != 1) {
                    return KClassImpl$Data$declaredNonStaticMembers$2();
                }
                return false;
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    static class TextDirectionHeuristicInternal extends TextDirectionHeuristicImpl {
        private final boolean getAuthRequestContext;

        TextDirectionHeuristicInternal(TextDirectionAlgorithm textDirectionAlgorithm, boolean z) {
            super(textDirectionAlgorithm);
            this.getAuthRequestContext = z;
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
        protected boolean KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.getAuthRequestContext;
        }
    }

    /* loaded from: classes3.dex */
    static class FirstStrong implements TextDirectionAlgorithm {
        static final FirstStrong KClassImpl$Data$declaredNonStaticMembers$2 = new FirstStrong();

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm
        public int KClassImpl$Data$declaredNonStaticMembers$2(CharSequence charSequence, int i, int i2) {
            int i3 = 2;
            for (int i4 = i; i4 < i2 + i && i3 == 2; i4++) {
                i3 = TextDirectionHeuristicsCompat.MyBillsEntityDataFactory(Character.getDirectionality(charSequence.charAt(i4)));
            }
            return i3;
        }

        private FirstStrong() {
        }
    }

    /* loaded from: classes3.dex */
    static class AnyStrong implements TextDirectionAlgorithm {
        static final AnyStrong BuiltInFictitiousFunctionClassFactory = new AnyStrong(true);
        private final boolean PlaceComponentResult;

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm
        public int KClassImpl$Data$declaredNonStaticMembers$2(CharSequence charSequence, int i, int i2) {
            boolean z = false;
            for (int i3 = i; i3 < i2 + i; i3++) {
                int KClassImpl$Data$declaredNonStaticMembers$2 = TextDirectionHeuristicsCompat.KClassImpl$Data$declaredNonStaticMembers$2(Character.getDirectionality(charSequence.charAt(i3)));
                if (KClassImpl$Data$declaredNonStaticMembers$2 != 0) {
                    if (KClassImpl$Data$declaredNonStaticMembers$2 != 1) {
                        continue;
                    } else if (!this.PlaceComponentResult) {
                        return 1;
                    }
                } else if (this.PlaceComponentResult) {
                    return 0;
                }
                z = true;
            }
            if (z) {
                return this.PlaceComponentResult ? 1 : 0;
            }
            return 2;
        }

        private AnyStrong(boolean z) {
            this.PlaceComponentResult = z;
        }
    }

    /* loaded from: classes3.dex */
    static class TextDirectionHeuristicLocale extends TextDirectionHeuristicImpl {
        static final TextDirectionHeuristicLocale BuiltInFictitiousFunctionClassFactory = new TextDirectionHeuristicLocale();

        TextDirectionHeuristicLocale() {
            super(null);
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
        protected boolean KClassImpl$Data$declaredNonStaticMembers$2() {
            return TextUtilsCompat.PlaceComponentResult(Locale.getDefault()) == 1;
        }
    }

    private TextDirectionHeuristicsCompat() {
    }
}
