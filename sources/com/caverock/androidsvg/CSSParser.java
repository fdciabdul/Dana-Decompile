package com.caverock.androidsvg;

import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParser;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.notification.DanaFirebaseMessagingService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes3.dex */
class CSSParser {
    private static final String CLASS = "class";
    static final String CSS_MIME_TYPE = "text/css";
    private static final String ID = "id";
    private static final int SPECIFICITY_ATTRIBUTE_OR_PSEUDOCLASS = 1000;
    private static final int SPECIFICITY_ELEMENT_OR_PSEUDOELEMENT = 1;
    private static final int SPECIFICITY_ID_ATTRIBUTE = 1000000;
    private static final String TAG = "CSSParser";
    private MediaType deviceMediaType;
    private boolean inMediaRule;
    private Source source;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum AttribOp {
        EXISTS,
        EQUALS,
        INCLUDES,
        DASHMATCH
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum Combinator {
        DESCENDANT,
        CHILD,
        FOLLOWS
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum MediaType {
        all,
        aural,
        braille,
        embossed,
        handheld,
        print,
        projection,
        screen,
        speech,
        tty,
        tv
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface PseudoClass {
        boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum Source {
        Document,
        RenderOptions
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum PseudoClassIdents {
        target,
        root,
        nth_child,
        nth_last_child,
        nth_of_type,
        nth_last_of_type,
        first_child,
        last_child,
        first_of_type,
        last_of_type,
        only_child,
        only_of_type,
        empty,
        not,
        lang,
        link,
        visited,
        hover,
        active,
        focus,
        enabled,
        disabled,
        checked,
        indeterminate,
        UNSUPPORTED;

        private static final Map<String, PseudoClassIdents> cache = new HashMap();

        static {
            for (PseudoClassIdents pseudoClassIdents : values()) {
                if (pseudoClassIdents != UNSUPPORTED) {
                    cache.put(pseudoClassIdents.name().replace('_', '-'), pseudoClassIdents);
                }
            }
        }

        public static PseudoClassIdents fromString(String str) {
            PseudoClassIdents pseudoClassIdents = cache.get(str);
            return pseudoClassIdents != null ? pseudoClassIdents : UNSUPPORTED;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Attrib {
        public final String name;
        final AttribOp operation;
        public final String value;

        Attrib(String str, AttribOp attribOp, String str2) {
            this.name = str;
            this.operation = attribOp;
            this.value = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class SimpleSelector {
        Combinator combinator;
        String tag;
        List<Attrib> attribs = null;
        List<PseudoClass> pseudos = null;

        SimpleSelector(Combinator combinator, String str) {
            this.combinator = null;
            this.tag = null;
            this.combinator = combinator == null ? Combinator.DESCENDANT : combinator;
            this.tag = str;
        }

        void addAttrib(String str, AttribOp attribOp, String str2) {
            if (this.attribs == null) {
                this.attribs = new ArrayList();
            }
            this.attribs.add(new Attrib(str, attribOp, str2));
        }

        void addPseudo(PseudoClass pseudoClass) {
            if (this.pseudos == null) {
                this.pseudos = new ArrayList();
            }
            this.pseudos.add(pseudoClass);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.combinator == Combinator.CHILD) {
                sb.append("> ");
            } else if (this.combinator == Combinator.FOLLOWS) {
                sb.append("+ ");
            }
            String str = this.tag;
            if (str == null) {
                str = "*";
            }
            sb.append(str);
            List<Attrib> list = this.attribs;
            if (list != null) {
                for (Attrib attrib : list) {
                    sb.append('[');
                    sb.append(attrib.name);
                    int i = AnonymousClass1.$SwitchMap$com$caverock$androidsvg$CSSParser$AttribOp[attrib.operation.ordinal()];
                    if (i == 1) {
                        sb.append('=');
                        sb.append(attrib.value);
                    } else if (i == 2) {
                        sb.append("~=");
                        sb.append(attrib.value);
                    } else if (i == 3) {
                        sb.append("|=");
                        sb.append(attrib.value);
                    }
                    sb.append(']');
                }
            }
            List<PseudoClass> list2 = this.pseudos;
            if (list2 != null) {
                for (PseudoClass pseudoClass : list2) {
                    sb.append(':');
                    sb.append(pseudoClass);
                }
            }
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Ruleset {
        private List<Rule> rules = null;

        void add(Rule rule) {
            if (this.rules == null) {
                this.rules = new ArrayList();
            }
            for (int i = 0; i < this.rules.size(); i++) {
                if (this.rules.get(i).selector.specificity > rule.selector.specificity) {
                    this.rules.add(i, rule);
                    return;
                }
            }
            this.rules.add(rule);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void addAll(Ruleset ruleset) {
            if (ruleset.rules == null) {
                return;
            }
            if (this.rules == null) {
                this.rules = new ArrayList(ruleset.rules.size());
            }
            Iterator<Rule> it = ruleset.rules.iterator();
            while (it.hasNext()) {
                add(it.next());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public List<Rule> getRules() {
            return this.rules;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isEmpty() {
            List<Rule> list = this.rules;
            return list == null || list.isEmpty();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int ruleCount() {
            List<Rule> list = this.rules;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void removeFromSource(Source source) {
            List<Rule> list = this.rules;
            if (list == null) {
                return;
            }
            Iterator<Rule> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().source == source) {
                    it.remove();
                }
            }
        }

        public String toString() {
            if (this.rules == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            Iterator<Rule> it = this.rules.iterator();
            while (it.hasNext()) {
                sb.append(it.next().toString());
                sb.append('\n');
            }
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Rule {
        Selector selector;
        Source source;
        SVG.Style style;

        Rule(Selector selector, SVG.Style style, Source source) {
            this.selector = selector;
            this.style = style;
            this.source = source;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(this.selector));
            sb.append(" {...} (src=");
            sb.append(this.source);
            sb.append(")");
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Selector {
        List<SimpleSelector> simpleSelectors;
        int specificity;

        private Selector() {
            this.simpleSelectors = null;
            this.specificity = 0;
        }

        /* synthetic */ Selector(AnonymousClass1 anonymousClass1) {
            this();
        }

        void add(SimpleSelector simpleSelector) {
            if (this.simpleSelectors == null) {
                this.simpleSelectors = new ArrayList();
            }
            this.simpleSelectors.add(simpleSelector);
        }

        int size() {
            List<SimpleSelector> list = this.simpleSelectors;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        SimpleSelector get(int i) {
            return this.simpleSelectors.get(i);
        }

        boolean isEmpty() {
            List<SimpleSelector> list = this.simpleSelectors;
            return list == null || list.isEmpty();
        }

        void addedIdAttribute() {
            this.specificity += 1000000;
        }

        void addedAttributeOrPseudo() {
            this.specificity += 1000;
        }

        void addedElement() {
            this.specificity++;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Iterator<SimpleSelector> it = this.simpleSelectors.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(InputCardNumberView.DIVIDER);
            }
            sb.append('[');
            sb.append(this.specificity);
            sb.append(']');
            return sb.toString();
        }
    }

    CSSParser() {
        this(MediaType.screen, Source.Document);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CSSParser(Source source) {
        this(MediaType.screen, source);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CSSParser(MediaType mediaType, Source source) {
        this.inMediaRule = false;
        this.deviceMediaType = mediaType;
        this.source = source;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ruleset parse(String str) {
        CSSTextScanner cSSTextScanner = new CSSTextScanner(str);
        cSSTextScanner.skipWhitespace();
        return parseRuleset(cSSTextScanner);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean mediaMatches(String str, MediaType mediaType) {
        CSSTextScanner cSSTextScanner = new CSSTextScanner(str);
        cSSTextScanner.skipWhitespace();
        return mediaMatches(parseMediaList(cSSTextScanner), mediaType);
    }

    private static void warn(String str, Object... objArr) {
        InstrumentInjector.log_w(TAG, String.format(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class CSSTextScanner extends SVGParser.TextScanner {
        private int hexChar(int i) {
            if (i < 48 || i > 57) {
                int i2 = 97;
                if (i >= 65 && i <= 70) {
                    i2 = 65;
                } else if (i < 97 || i > 102) {
                    return -1;
                }
                return (i - i2) + 10;
            }
            return i - 48;
        }

        CSSTextScanner(String str) {
            super(str.replaceAll("(?s)/\\*.*?\\*/", ""));
        }

        String nextIdentifier() {
            int scanForIdentifier = scanForIdentifier();
            if (scanForIdentifier == this.position) {
                return null;
            }
            String substring = this.input.substring(this.position, scanForIdentifier);
            this.position = scanForIdentifier;
            return substring;
        }

        private int scanForIdentifier() {
            if (empty()) {
                return this.position;
            }
            int i = this.position;
            int i2 = this.position;
            int charAt = this.input.charAt(this.position);
            if (charAt == 45) {
                charAt = advanceChar();
            }
            if ((charAt >= 65 && charAt <= 90) || ((charAt >= 97 && charAt <= 122) || charAt == 95)) {
                int advanceChar = advanceChar();
                while (true) {
                    if ((advanceChar < 65 || advanceChar > 90) && ((advanceChar < 97 || advanceChar > 122) && !((advanceChar >= 48 && advanceChar <= 57) || advanceChar == 45 || advanceChar == 95))) {
                        break;
                    }
                    advanceChar = advanceChar();
                }
                i2 = this.position;
            }
            this.position = i;
            return i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<Selector> nextSelectorGroup() throws CSSParseException {
            AnonymousClass1 anonymousClass1 = null;
            if (empty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList(1);
            Selector selector = new Selector(anonymousClass1);
            while (!empty() && nextSimpleSelector(selector)) {
                if (skipCommaWhitespace()) {
                    arrayList.add(selector);
                    selector = new Selector(anonymousClass1);
                }
            }
            if (!selector.isEmpty()) {
                arrayList.add(selector);
            }
            return arrayList;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x0130  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x0135  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean nextSimpleSelector(com.caverock.androidsvg.CSSParser.Selector r11) throws com.caverock.androidsvg.CSSParseException {
            /*
                Method dump skipped, instructions count: 312
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.CSSParser.CSSTextScanner.nextSimpleSelector(com.caverock.androidsvg.CSSParser$Selector):boolean");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public static class AnPlusB {

            /* renamed from: a  reason: collision with root package name */
            public int f7418a;
            public int b;

            AnPlusB(int i, int i2) {
                this.f7418a = i;
                this.b = i2;
            }
        }

        private AnPlusB nextAnPlusB() throws CSSParseException {
            IntegerParser integerParser;
            AnPlusB anPlusB;
            if (empty()) {
                return null;
            }
            int i = this.position;
            if (consume('(')) {
                skipWhitespace();
                int i2 = 1;
                if (consume("odd")) {
                    anPlusB = new AnPlusB(2, 1);
                } else {
                    if (consume("even")) {
                        anPlusB = new AnPlusB(2, 0);
                    } else {
                        int i3 = (consume('+') || !consume('-')) ? 1 : -1;
                        IntegerParser parseInt = IntegerParser.parseInt(this.input, this.position, this.inputLength, false);
                        if (parseInt != null) {
                            this.position = parseInt.getEndPos();
                        }
                        if (consume('n') || consume('N')) {
                            if (parseInt == null) {
                                parseInt = new IntegerParser(1L, this.position);
                            }
                            skipWhitespace();
                            boolean consume = consume('+');
                            if (!consume && (consume = consume('-'))) {
                                i2 = -1;
                            }
                            if (consume) {
                                skipWhitespace();
                                integerParser = IntegerParser.parseInt(this.input, this.position, this.inputLength, false);
                                if (integerParser != null) {
                                    this.position = integerParser.getEndPos();
                                } else {
                                    this.position = i;
                                    return null;
                                }
                            } else {
                                integerParser = null;
                            }
                            int i4 = i2;
                            i2 = i3;
                            i3 = i4;
                        } else {
                            integerParser = parseInt;
                            parseInt = null;
                        }
                        anPlusB = new AnPlusB(parseInt == null ? 0 : i2 * parseInt.value(), integerParser != null ? i3 * integerParser.value() : 0);
                    }
                }
                skipWhitespace();
                if (consume(')')) {
                    return anPlusB;
                }
                this.position = i;
                return null;
            }
            return null;
        }

        private List<String> nextIdentListParam() throws CSSParseException {
            if (empty()) {
                return null;
            }
            int i = this.position;
            if (consume('(')) {
                skipWhitespace();
                ArrayList arrayList = null;
                do {
                    String nextIdentifier = nextIdentifier();
                    if (nextIdentifier == null) {
                        this.position = i;
                        return null;
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(nextIdentifier);
                    skipWhitespace();
                } while (skipCommaWhitespace());
                if (consume(')')) {
                    return arrayList;
                }
                this.position = i;
                return null;
            }
            return null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:38:0x002e, code lost:
        
            continue;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private java.util.List<com.caverock.androidsvg.CSSParser.Selector> nextPseudoNotParam() throws com.caverock.androidsvg.CSSParseException {
            /*
                r6 = this;
                boolean r0 = r6.empty()
                r1 = 0
                if (r0 == 0) goto L8
                return r1
            L8:
                int r0 = r6.position
                r2 = 40
                boolean r2 = r6.consume(r2)
                if (r2 != 0) goto L13
                return r1
            L13:
                r6.skipWhitespace()
                java.util.List r2 = r6.nextSelectorGroup()
                if (r2 != 0) goto L1f
                r6.position = r0
                return r1
            L1f:
                r3 = 41
                boolean r3 = r6.consume(r3)
                if (r3 != 0) goto L2a
                r6.position = r0
                return r1
            L2a:
                java.util.Iterator r0 = r2.iterator()
            L2e:
                boolean r3 = r0.hasNext()
                if (r3 == 0) goto L6b
                java.lang.Object r3 = r0.next()
                com.caverock.androidsvg.CSSParser$Selector r3 = (com.caverock.androidsvg.CSSParser.Selector) r3
                java.util.List<com.caverock.androidsvg.CSSParser$SimpleSelector> r4 = r3.simpleSelectors
                if (r4 == 0) goto L6b
                java.util.List<com.caverock.androidsvg.CSSParser$SimpleSelector> r3 = r3.simpleSelectors
                java.util.Iterator r3 = r3.iterator()
            L44:
                boolean r4 = r3.hasNext()
                if (r4 == 0) goto L2e
                java.lang.Object r4 = r3.next()
                com.caverock.androidsvg.CSSParser$SimpleSelector r4 = (com.caverock.androidsvg.CSSParser.SimpleSelector) r4
                java.util.List<com.caverock.androidsvg.CSSParser$PseudoClass> r5 = r4.pseudos
                if (r5 == 0) goto L2e
                java.util.List<com.caverock.androidsvg.CSSParser$PseudoClass> r4 = r4.pseudos
                java.util.Iterator r4 = r4.iterator()
            L5a:
                boolean r5 = r4.hasNext()
                if (r5 == 0) goto L44
                java.lang.Object r5 = r4.next()
                com.caverock.androidsvg.CSSParser$PseudoClass r5 = (com.caverock.androidsvg.CSSParser.PseudoClass) r5
                boolean r5 = r5 instanceof com.caverock.androidsvg.CSSParser.PseudoClassNot
                if (r5 == 0) goto L5a
                return r1
            L6b:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.CSSParser.CSSTextScanner.nextPseudoNotParam():java.util.List");
        }

        private void parsePseudoClass(Selector selector, SimpleSelector simpleSelector) throws CSSParseException {
            PseudoClass pseudoClassAnPlusB;
            PseudoClassNot pseudoClassNot;
            String nextIdentifier = nextIdentifier();
            if (nextIdentifier == null) {
                throw new CSSParseException("Invalid pseudo class");
            }
            PseudoClassIdents fromString = PseudoClassIdents.fromString(nextIdentifier);
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.$SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[fromString.ordinal()]) {
                case 1:
                    pseudoClassAnPlusB = new PseudoClassAnPlusB(0, 1, true, false, null);
                    selector.addedAttributeOrPseudo();
                    break;
                case 2:
                    pseudoClassAnPlusB = new PseudoClassAnPlusB(0, 1, false, false, null);
                    selector.addedAttributeOrPseudo();
                    break;
                case 3:
                    pseudoClassAnPlusB = new PseudoClassOnlyChild(false, null);
                    selector.addedAttributeOrPseudo();
                    break;
                case 4:
                    pseudoClassAnPlusB = new PseudoClassAnPlusB(0, 1, true, true, simpleSelector.tag);
                    selector.addedAttributeOrPseudo();
                    break;
                case 5:
                    pseudoClassAnPlusB = new PseudoClassAnPlusB(0, 1, false, true, simpleSelector.tag);
                    selector.addedAttributeOrPseudo();
                    break;
                case 6:
                    pseudoClassAnPlusB = new PseudoClassOnlyChild(true, simpleSelector.tag);
                    selector.addedAttributeOrPseudo();
                    break;
                case 7:
                    pseudoClassAnPlusB = new PseudoClassRoot(anonymousClass1);
                    selector.addedAttributeOrPseudo();
                    break;
                case 8:
                    pseudoClassAnPlusB = new PseudoClassEmpty(anonymousClass1);
                    selector.addedAttributeOrPseudo();
                    break;
                case 9:
                case 10:
                case 11:
                case 12:
                    boolean z = fromString == PseudoClassIdents.nth_child || fromString == PseudoClassIdents.nth_of_type;
                    boolean z2 = fromString == PseudoClassIdents.nth_of_type || fromString == PseudoClassIdents.nth_last_of_type;
                    AnPlusB nextAnPlusB = nextAnPlusB();
                    if (nextAnPlusB == null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Invalid or missing parameter section for pseudo class: ");
                        sb.append(nextIdentifier);
                        throw new CSSParseException(sb.toString());
                    }
                    PseudoClassAnPlusB pseudoClassAnPlusB2 = new PseudoClassAnPlusB(nextAnPlusB.f7418a, nextAnPlusB.b, z, z2, simpleSelector.tag);
                    selector.addedAttributeOrPseudo();
                    pseudoClassNot = pseudoClassAnPlusB2;
                    pseudoClassAnPlusB = pseudoClassNot;
                    break;
                    break;
                case 13:
                    List<Selector> nextPseudoNotParam = nextPseudoNotParam();
                    if (nextPseudoNotParam == null) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Invalid or missing parameter section for pseudo class: ");
                        sb2.append(nextIdentifier);
                        throw new CSSParseException(sb2.toString());
                    }
                    PseudoClassNot pseudoClassNot2 = new PseudoClassNot(nextPseudoNotParam);
                    selector.specificity = pseudoClassNot2.getSpecificity();
                    pseudoClassNot = pseudoClassNot2;
                    pseudoClassAnPlusB = pseudoClassNot;
                    break;
                case 14:
                    pseudoClassAnPlusB = new PseudoClassTarget(anonymousClass1);
                    selector.addedAttributeOrPseudo();
                    break;
                case 15:
                    nextIdentListParam();
                    pseudoClassAnPlusB = new PseudoClassNotSupported(nextIdentifier);
                    selector.addedAttributeOrPseudo();
                    break;
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                    pseudoClassAnPlusB = new PseudoClassNotSupported(nextIdentifier);
                    selector.addedAttributeOrPseudo();
                    break;
                default:
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Unsupported pseudo class: ");
                    sb3.append(nextIdentifier);
                    throw new CSSParseException(sb3.toString());
            }
            simpleSelector.addPseudo(pseudoClassAnPlusB);
        }

        private String nextAttribValue() {
            if (empty()) {
                return null;
            }
            String nextQuotedString = nextQuotedString();
            return nextQuotedString != null ? nextQuotedString : nextIdentifier();
        }

        String nextPropertyValue() {
            if (empty()) {
                return null;
            }
            int i = this.position;
            int i2 = this.position;
            int charAt = this.input.charAt(this.position);
            while (charAt != -1 && charAt != 59 && charAt != 125 && charAt != 33 && !isEOL(charAt)) {
                if (!isWhitespace(charAt)) {
                    i2 = this.position + 1;
                }
                charAt = advanceChar();
            }
            if (this.position > i) {
                return this.input.substring(i, i2);
            }
            this.position = i;
            return null;
        }

        String nextCSSString() {
            int hexChar;
            if (empty()) {
                return null;
            }
            char charAt = this.input.charAt(this.position);
            if (charAt == '\'' || charAt == '\"') {
                StringBuilder sb = new StringBuilder();
                this.position++;
                int intValue = nextChar().intValue();
                while (intValue != -1 && intValue != charAt) {
                    if (intValue == 92) {
                        intValue = nextChar().intValue();
                        if (intValue != -1) {
                            if (intValue == 10 || intValue == 13 || intValue == 12) {
                                intValue = nextChar().intValue();
                            } else {
                                int hexChar2 = hexChar(intValue);
                                if (hexChar2 != -1) {
                                    for (int i = 1; i <= 5 && (hexChar = hexChar((intValue = nextChar().intValue()))) != -1; i++) {
                                        hexChar2 = (hexChar2 * 16) + hexChar;
                                    }
                                    sb.append((char) hexChar2);
                                }
                            }
                        }
                    }
                    sb.append((char) intValue);
                    intValue = nextChar().intValue();
                }
                return sb.toString();
            }
            return null;
        }

        String nextURL() {
            if (empty()) {
                return null;
            }
            int i = this.position;
            if (consume("url(")) {
                skipWhitespace();
                String nextCSSString = nextCSSString();
                if (nextCSSString == null) {
                    nextCSSString = nextLegacyURL();
                }
                if (nextCSSString == null) {
                    this.position = i;
                    return null;
                }
                skipWhitespace();
                if (empty() || consume(")")) {
                    return nextCSSString;
                }
                this.position = i;
                return null;
            }
            return null;
        }

        String nextLegacyURL() {
            char charAt;
            int hexChar;
            StringBuilder sb = new StringBuilder();
            while (!empty() && (charAt = this.input.charAt(this.position)) != '\'' && charAt != '\"' && charAt != '(' && charAt != ')' && !isWhitespace(charAt) && !Character.isISOControl((int) charAt)) {
                this.position++;
                if (charAt == '\\') {
                    if (!empty()) {
                        String str = this.input;
                        int i = this.position;
                        this.position = i + 1;
                        charAt = str.charAt(i);
                        if (charAt != '\n' && charAt != '\r' && charAt != '\f') {
                            int hexChar2 = hexChar(charAt);
                            if (hexChar2 != -1) {
                                for (int i2 = 1; i2 <= 5 && !empty() && (hexChar = hexChar(this.input.charAt(this.position))) != -1; i2++) {
                                    this.position++;
                                    hexChar2 = (hexChar2 * 16) + hexChar;
                                }
                                sb.append((char) hexChar2);
                            }
                        }
                    }
                }
                sb.append(charAt);
            }
            if (sb.length() == 0) {
                return null;
            }
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.caverock.androidsvg.CSSParser$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$caverock$androidsvg$CSSParser$AttribOp;
        static final /* synthetic */ int[] $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents;

        static {
            int[] iArr = new int[PseudoClassIdents.values().length];
            $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents = iArr;
            try {
                iArr[PseudoClassIdents.first_child.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.last_child.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.only_child.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.first_of_type.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.last_of_type.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.only_of_type.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.root.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.empty.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.nth_child.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.nth_last_child.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.nth_of_type.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.nth_last_of_type.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.not.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.target.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.lang.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.link.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.visited.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.hover.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.active.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.focus.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.enabled.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.disabled.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.checked.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$PseudoClassIdents[PseudoClassIdents.indeterminate.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            int[] iArr2 = new int[AttribOp.values().length];
            $SwitchMap$com$caverock$androidsvg$CSSParser$AttribOp = iArr2;
            try {
                iArr2[AttribOp.EQUALS.ordinal()] = 1;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$AttribOp[AttribOp.INCLUDES.ordinal()] = 2;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$caverock$androidsvg$CSSParser$AttribOp[AttribOp.DASHMATCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    private static boolean mediaMatches(List<MediaType> list, MediaType mediaType) {
        for (MediaType mediaType2 : list) {
            if (mediaType2 == MediaType.all || mediaType2 == mediaType) {
                return true;
            }
        }
        return false;
    }

    private static List<MediaType> parseMediaList(CSSTextScanner cSSTextScanner) {
        String nextWord;
        ArrayList arrayList = new ArrayList();
        while (!cSSTextScanner.empty() && (nextWord = cSSTextScanner.nextWord()) != null) {
            try {
                arrayList.add(MediaType.valueOf(nextWord));
            } catch (IllegalArgumentException unused) {
            }
            if (!cSSTextScanner.skipCommaWhitespace()) {
                break;
            }
        }
        return arrayList;
    }

    private void parseAtRule(Ruleset ruleset, CSSTextScanner cSSTextScanner) throws CSSParseException {
        String nextIdentifier = cSSTextScanner.nextIdentifier();
        cSSTextScanner.skipWhitespace();
        if (nextIdentifier == null) {
            throw new CSSParseException("Invalid '@' rule");
        }
        if (!this.inMediaRule && nextIdentifier.equals(SVGParser.XML_STYLESHEET_ATTR_MEDIA)) {
            List<MediaType> parseMediaList = parseMediaList(cSSTextScanner);
            if (!cSSTextScanner.consume('{')) {
                throw new CSSParseException("Invalid @media rule: missing rule set");
            }
            cSSTextScanner.skipWhitespace();
            if (mediaMatches(parseMediaList, this.deviceMediaType)) {
                this.inMediaRule = true;
                ruleset.addAll(parseRuleset(cSSTextScanner));
                this.inMediaRule = false;
            } else {
                parseRuleset(cSSTextScanner);
            }
            if (!cSSTextScanner.empty() && !cSSTextScanner.consume('}')) {
                throw new CSSParseException("Invalid @media rule: expected '}' at end of rule set");
            }
        } else if (!this.inMediaRule && nextIdentifier.equals("import")) {
            String nextURL = cSSTextScanner.nextURL();
            if (nextURL == null) {
                nextURL = cSSTextScanner.nextCSSString();
            }
            if (nextURL == null) {
                throw new CSSParseException("Invalid @import rule: expected string or url()");
            }
            cSSTextScanner.skipWhitespace();
            List<MediaType> parseMediaList2 = parseMediaList(cSSTextScanner);
            if (!cSSTextScanner.empty() && !cSSTextScanner.consume(';')) {
                throw new CSSParseException("Invalid @media rule: expected '}' at end of rule set");
            }
            if (SVG.getFileResolver() != null && mediaMatches(parseMediaList2, this.deviceMediaType)) {
                String resolveCSSStyleSheet = SVG.getFileResolver().resolveCSSStyleSheet(nextURL);
                if (resolveCSSStyleSheet == null) {
                    return;
                }
                ruleset.addAll(parse(resolveCSSStyleSheet));
            }
        } else {
            warn("Ignoring @%s rule", nextIdentifier);
            skipAtRule(cSSTextScanner);
        }
        cSSTextScanner.skipWhitespace();
    }

    private void skipAtRule(CSSTextScanner cSSTextScanner) {
        int i = 0;
        while (!cSSTextScanner.empty()) {
            int intValue = cSSTextScanner.nextChar().intValue();
            if (intValue == 59 && i == 0) {
                return;
            }
            if (intValue == 123) {
                i++;
            } else if (intValue == 125 && i > 0 && i - 1 == 0) {
                return;
            }
        }
    }

    private Ruleset parseRuleset(CSSTextScanner cSSTextScanner) {
        Ruleset ruleset = new Ruleset();
        while (!cSSTextScanner.empty()) {
            try {
                if (!cSSTextScanner.consume("<!--") && !cSSTextScanner.consume("-->")) {
                    if (cSSTextScanner.consume('@')) {
                        parseAtRule(ruleset, cSSTextScanner);
                    } else if (!parseRule(ruleset, cSSTextScanner)) {
                        break;
                    }
                }
            } catch (CSSParseException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("CSS parser terminated early due to error: ");
                sb.append(e.getMessage());
                InstrumentInjector.log_e(TAG, sb.toString());
            }
        }
        return ruleset;
    }

    private boolean parseRule(Ruleset ruleset, CSSTextScanner cSSTextScanner) throws CSSParseException {
        List nextSelectorGroup = cSSTextScanner.nextSelectorGroup();
        if (nextSelectorGroup == null || nextSelectorGroup.isEmpty()) {
            return false;
        }
        if (!cSSTextScanner.consume('{')) {
            throw new CSSParseException("Malformed rule block: expected '{'");
        }
        cSSTextScanner.skipWhitespace();
        SVG.Style parseDeclarations = parseDeclarations(cSSTextScanner);
        cSSTextScanner.skipWhitespace();
        Iterator it = nextSelectorGroup.iterator();
        while (it.hasNext()) {
            ruleset.add(new Rule((Selector) it.next(), parseDeclarations, this.source));
        }
        return true;
    }

    private SVG.Style parseDeclarations(CSSTextScanner cSSTextScanner) throws CSSParseException {
        SVG.Style style = new SVG.Style();
        do {
            String nextIdentifier = cSSTextScanner.nextIdentifier();
            cSSTextScanner.skipWhitespace();
            if (!cSSTextScanner.consume(':')) {
                throw new CSSParseException("Expected ':'");
            }
            cSSTextScanner.skipWhitespace();
            String nextPropertyValue = cSSTextScanner.nextPropertyValue();
            if (nextPropertyValue == null) {
                throw new CSSParseException("Expected property value");
            }
            cSSTextScanner.skipWhitespace();
            if (cSSTextScanner.consume('!')) {
                cSSTextScanner.skipWhitespace();
                if (!cSSTextScanner.consume("important")) {
                    throw new CSSParseException("Malformed rule set: found unexpected '!'");
                }
                cSSTextScanner.skipWhitespace();
            }
            cSSTextScanner.consume(';');
            SVGParser.processStyleProperty(style, nextIdentifier, nextPropertyValue);
            cSSTextScanner.skipWhitespace();
            if (cSSTextScanner.empty()) {
                break;
            }
        } while (!cSSTextScanner.consume('}'));
        return style;
    }

    public static List<String> parseClassAttribute(String str) {
        CSSTextScanner cSSTextScanner = new CSSTextScanner(str);
        ArrayList arrayList = null;
        while (!cSSTextScanner.empty()) {
            String nextToken = cSSTextScanner.nextToken();
            if (nextToken != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(nextToken);
                cSSTextScanner.skipWhitespace();
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class RuleMatchContext {
        SVG.SvgElementBase targetElement;

        public String toString() {
            SVG.SvgElementBase svgElementBase = this.targetElement;
            return svgElementBase != null ? String.format("<%s id=\"%s\">", svgElementBase.getNodeName(), this.targetElement.f7420id) : "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean ruleMatch(RuleMatchContext ruleMatchContext, Selector selector, SVG.SvgElementBase svgElementBase) {
        ArrayList arrayList = new ArrayList();
        for (SVG.SvgContainer svgContainer = svgElementBase.parent; svgContainer != null; svgContainer = ((SVG.SvgObject) svgContainer).parent) {
            arrayList.add(0, svgContainer);
        }
        int size = arrayList.size() - 1;
        if (selector.size() == 1) {
            return selectorMatch(ruleMatchContext, selector.get(0), arrayList, size, svgElementBase);
        }
        return ruleMatch(ruleMatchContext, selector, selector.size() - 1, arrayList, size, svgElementBase);
    }

    private static boolean ruleMatch(RuleMatchContext ruleMatchContext, Selector selector, int i, List<SVG.SvgContainer> list, int i2, SVG.SvgElementBase svgElementBase) {
        while (true) {
            SimpleSelector simpleSelector = selector.get(i);
            if (!selectorMatch(ruleMatchContext, simpleSelector, list, i2, svgElementBase)) {
                return false;
            }
            if (simpleSelector.combinator == Combinator.DESCENDANT) {
                if (i == 0) {
                    return true;
                }
                while (i2 >= 0) {
                    if (ruleMatchOnAncestors(ruleMatchContext, selector, i - 1, list, i2)) {
                        return true;
                    }
                    i2--;
                }
                return false;
            } else if (simpleSelector.combinator == Combinator.CHILD) {
                return ruleMatchOnAncestors(ruleMatchContext, selector, i - 1, list, i2);
            } else {
                int childPosition = getChildPosition(list, i2, svgElementBase);
                if (childPosition <= 0) {
                    return false;
                }
                svgElementBase = (SVG.SvgElementBase) svgElementBase.parent.getChildren().get(childPosition - 1);
                i--;
            }
        }
    }

    private static boolean ruleMatchOnAncestors(RuleMatchContext ruleMatchContext, Selector selector, int i, List<SVG.SvgContainer> list, int i2) {
        int i3 = i2;
        while (true) {
            SimpleSelector simpleSelector = selector.get(i);
            SVG.SvgElementBase svgElementBase = (SVG.SvgElementBase) list.get(i3);
            if (!selectorMatch(ruleMatchContext, simpleSelector, list, i3, svgElementBase)) {
                return false;
            }
            if (simpleSelector.combinator == Combinator.DESCENDANT) {
                if (i == 0) {
                    return true;
                }
                while (i3 > 0) {
                    i3--;
                    if (ruleMatchOnAncestors(ruleMatchContext, selector, i - 1, list, i3)) {
                        return true;
                    }
                }
                return false;
            } else if (simpleSelector.combinator != Combinator.CHILD) {
                int childPosition = getChildPosition(list, i3, svgElementBase);
                if (childPosition <= 0) {
                    return false;
                }
                return ruleMatch(ruleMatchContext, selector, i - 1, list, i3, (SVG.SvgElementBase) svgElementBase.parent.getChildren().get(childPosition - 1));
            } else {
                i--;
                i3--;
            }
        }
    }

    private static int getChildPosition(List<SVG.SvgContainer> list, int i, SVG.SvgElementBase svgElementBase) {
        int i2 = 0;
        if (i < 0) {
            return 0;
        }
        if (list.get(i) != svgElementBase.parent) {
            return -1;
        }
        Iterator<SVG.SvgObject> it = svgElementBase.parent.getChildren().iterator();
        while (it.hasNext()) {
            if (it.next() == svgElementBase) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    private static boolean selectorMatch(RuleMatchContext ruleMatchContext, SimpleSelector simpleSelector, List<SVG.SvgContainer> list, int i, SVG.SvgElementBase svgElementBase) {
        if (simpleSelector.tag == null || simpleSelector.tag.equals(svgElementBase.getNodeName().toLowerCase(Locale.US))) {
            if (simpleSelector.attribs != null) {
                for (Attrib attrib : simpleSelector.attribs) {
                    String str = attrib.name;
                    str.hashCode();
                    if (str.equals("id")) {
                        if (!attrib.value.equals(svgElementBase.f7420id)) {
                            return false;
                        }
                    } else if (!str.equals(CLASS) || svgElementBase.classNames == null || !svgElementBase.classNames.contains(attrib.value)) {
                        return false;
                    }
                }
            }
            if (simpleSelector.pseudos != null) {
                Iterator<PseudoClass> it = simpleSelector.pseudos.iterator();
                while (it.hasNext()) {
                    if (!it.next().matches(ruleMatchContext, svgElementBase)) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class PseudoClassAnPlusB implements PseudoClass {

        /* renamed from: a  reason: collision with root package name */
        private int f7419a;
        private int b;
        private boolean isFromStart;
        private boolean isOfType;
        private String nodeName;

        PseudoClassAnPlusB(int i, int i2, boolean z, boolean z2, String str) {
            this.f7419a = i;
            this.b = i2;
            this.isFromStart = z;
            this.isOfType = z2;
            this.nodeName = str;
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase) {
            int i;
            int i2;
            String nodeName = (this.isOfType && this.nodeName == null) ? svgElementBase.getNodeName() : this.nodeName;
            if (svgElementBase.parent != null) {
                Iterator<SVG.SvgObject> it = svgElementBase.parent.getChildren().iterator();
                i = 0;
                i2 = 0;
                while (it.hasNext()) {
                    SVG.SvgElementBase svgElementBase2 = (SVG.SvgElementBase) it.next();
                    if (svgElementBase2 == svgElementBase) {
                        i = i2;
                    }
                    if (nodeName == null || svgElementBase2.getNodeName().equals(nodeName)) {
                        i2++;
                    }
                }
            } else {
                i = 0;
                i2 = 1;
            }
            int i3 = this.isFromStart ? i + 1 : i2 - i;
            int i4 = this.f7419a;
            if (i4 == 0) {
                return i3 == this.b;
            }
            int i5 = i3 - this.b;
            return i5 % i4 == 0 && (Integer.signum(i5) == 0 || Integer.signum(i3 - this.b) == Integer.signum(this.f7419a));
        }

        public String toString() {
            String str = this.isFromStart ? "" : "last-";
            return this.isOfType ? String.format("nth-%schild(%dn%+d of type <%s>)", str, Integer.valueOf(this.f7419a), Integer.valueOf(this.b), this.nodeName) : String.format("nth-%schild(%dn%+d)", str, Integer.valueOf(this.f7419a), Integer.valueOf(this.b));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class PseudoClassOnlyChild implements PseudoClass {
        private boolean isOfType;
        private String nodeName;

        public PseudoClassOnlyChild(boolean z, String str) {
            this.isOfType = z;
            this.nodeName = str;
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase) {
            int i;
            String nodeName = (this.isOfType && this.nodeName == null) ? svgElementBase.getNodeName() : this.nodeName;
            if (svgElementBase.parent != null) {
                Iterator<SVG.SvgObject> it = svgElementBase.parent.getChildren().iterator();
                i = 0;
                while (it.hasNext()) {
                    SVG.SvgElementBase svgElementBase2 = (SVG.SvgElementBase) it.next();
                    if (nodeName == null || svgElementBase2.getNodeName().equals(nodeName)) {
                        i++;
                    }
                }
            } else {
                i = 1;
            }
            return i == 1;
        }

        public String toString() {
            return this.isOfType ? String.format("only-of-type <%s>", this.nodeName) : String.format("only-child", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class PseudoClassRoot implements PseudoClass {
        public String toString() {
            return "root";
        }

        private PseudoClassRoot() {
        }

        /* synthetic */ PseudoClassRoot(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase) {
            return svgElementBase.parent == null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class PseudoClassEmpty implements PseudoClass {
        public String toString() {
            return DanaFirebaseMessagingService.EMPTY;
        }

        private PseudoClassEmpty() {
        }

        /* synthetic */ PseudoClassEmpty(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase) {
            return !(svgElementBase instanceof SVG.SvgContainer) || ((SVG.SvgContainer) svgElementBase).getChildren().size() == 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class PseudoClassNot implements PseudoClass {
        private List<Selector> selectorGroup;

        PseudoClassNot(List<Selector> list) {
            this.selectorGroup = list;
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase) {
            Iterator<Selector> it = this.selectorGroup.iterator();
            while (it.hasNext()) {
                if (CSSParser.ruleMatch(ruleMatchContext, it.next(), svgElementBase)) {
                    return false;
                }
            }
            return true;
        }

        int getSpecificity() {
            int i = Integer.MIN_VALUE;
            for (Selector selector : this.selectorGroup) {
                if (selector.specificity > i) {
                    i = selector.specificity;
                }
            }
            return i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("not(");
            sb.append(this.selectorGroup);
            sb.append(")");
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class PseudoClassTarget implements PseudoClass {
        public String toString() {
            return "target";
        }

        private PseudoClassTarget() {
        }

        /* synthetic */ PseudoClassTarget(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase) {
            return ruleMatchContext != null && svgElementBase == ruleMatchContext.targetElement;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class PseudoClassNotSupported implements PseudoClass {
        private String clazz;

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean matches(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase) {
            return false;
        }

        PseudoClassNotSupported(String str) {
            this.clazz = str;
        }

        public String toString() {
            return this.clazz;
        }
    }
}
