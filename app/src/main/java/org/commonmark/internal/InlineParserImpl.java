package org.commonmark.internal;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.commonmark.internal.inline.AsteriskDelimiterProcessor;
import org.commonmark.internal.inline.UnderscoreDelimiterProcessor;
import org.commonmark.internal.util.Escaping;
import org.commonmark.internal.util.Html5Entities;
import org.commonmark.node.Code;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.HtmlInline;
import org.commonmark.node.Link;
import org.commonmark.node.Node;
import org.commonmark.node.Text;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.delimiter.DelimiterProcessor;

/* loaded from: classes6.dex */
public class InlineParserImpl implements InlineParser, ReferenceParser {
    private Bracket FragmentBottomSheetPaymentSettingBinding;
    private Delimiter NetworkUserEntityData$$ExternalSyntheticLambda3;
    private Map<String, Link> NetworkUserEntityData$$ExternalSyntheticLambda4 = new HashMap();
    private String NetworkUserEntityData$$ExternalSyntheticLambda5;
    private final BitSet NetworkUserEntityData$$ExternalSyntheticLambda6;
    private int NetworkUserEntityData$$ExternalSyntheticLambda7;
    private Node PrepareContext;
    private final BitSet isLayoutRequested;
    private final Map<Character, DelimiterProcessor> newProxyInstance;
    private static final Pattern NetworkUserEntityData$$ExternalSyntheticLambda2 = Pattern.compile("^[!\"#\\$%&'\\(\\)\\*\\+,\\-\\./:;<=>\\?@\\[\\\\\\]\\^_`\\{\\|\\}~\\p{Pc}\\p{Pd}\\p{Pe}\\p{Pf}\\p{Pi}\\p{Po}\\p{Ps}]");
    private static final Pattern NetworkUserEntityData$$ExternalSyntheticLambda0 = Pattern.compile("^(?:<[A-Za-z][A-Za-z0-9-]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>`\\x00-\\x20]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>|</[A-Za-z][A-Za-z0-9-]*\\s*[>]|<!---->|<!--(?:-?[^>-])(?:-?[^-])*-->|[<][?].*?[?][>]|<![A-Z]+\\s+[^>]*>|<!\\[CDATA\\[[\\s\\S]*?\\]\\]>)", 2);
    private static final Pattern moveToNextValue = Pattern.compile("^(?:\"(\\\\[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]|[^\"\\x00])*\"|'(\\\\[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]|[^'\\x00])*'|\\((\\\\[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]|[^)\\x00])*\\))");
    private static final Pattern scheduleImpl = Pattern.compile("^(?:[<](?:[^<> \\t\\n\\\\]|\\\\.)*[>])");
    private static final Pattern lookAheadTest = Pattern.compile("^\\[(?:[^\\\\\\[\\]]|\\\\.)*\\]");
    private static final Pattern PlaceComponentResult = Pattern.compile("^[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]");
    private static final Pattern BuiltInFictitiousFunctionClassFactory = Pattern.compile("^&(?:#x[a-f0-9]{1,8}|#[0-9]{1,8}|[a-z][a-z0-9]{1,31});", 2);
    private static final Pattern NetworkUserEntityData$$ExternalSyntheticLambda1 = Pattern.compile("`+");
    private static final Pattern GetContactSyncConfig = Pattern.compile("^`+");
    private static final Pattern KClassImpl$Data$declaredNonStaticMembers$2 = Pattern.compile("^<([a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*)>");
    private static final Pattern getAuthRequestContext = Pattern.compile("^<[a-zA-Z][a-zA-Z0-9.+-]{1,31}:[^<>\u0000- ]*>");
    private static final Pattern DatabaseTableConfigUtil = Pattern.compile("^ *(?:\n *)?");
    private static final Pattern initRecordTimeStamp = Pattern.compile("^[\\p{Zs}\t\r\n\f]");
    private static final Pattern NetworkUserEntityData$$ExternalSyntheticLambda8 = Pattern.compile("\\s+");
    private static final Pattern MyBillsEntityDataFactory = Pattern.compile(" *$");
    private static final Pattern getErrorConfigVersion = Pattern.compile("^ *(?:\n|$)");

    public InlineParserImpl(List<DelimiterProcessor> list) {
        HashMap hashMap = new HashMap();
        getAuthRequestContext(Arrays.asList(new AsteriskDelimiterProcessor(), new UnderscoreDelimiterProcessor()), hashMap);
        getAuthRequestContext(list, hashMap);
        this.newProxyInstance = hashMap;
        Set keySet = hashMap.keySet();
        BitSet bitSet = new BitSet();
        Iterator it = keySet.iterator();
        while (it.hasNext()) {
            bitSet.set(((Character) it.next()).charValue());
        }
        this.isLayoutRequested = bitSet;
        BitSet bitSet2 = new BitSet();
        bitSet2.or(bitSet);
        bitSet2.set(10);
        bitSet2.set(96);
        bitSet2.set(91);
        bitSet2.set(93);
        bitSet2.set(92);
        bitSet2.set(33);
        bitSet2.set(60);
        bitSet2.set(38);
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = bitSet2;
    }

    private static void getAuthRequestContext(Iterable<DelimiterProcessor> iterable, Map<Character, DelimiterProcessor> map) {
        StaggeredDelimiterProcessor staggeredDelimiterProcessor;
        for (DelimiterProcessor delimiterProcessor : iterable) {
            char MyBillsEntityDataFactory2 = delimiterProcessor.MyBillsEntityDataFactory();
            char PlaceComponentResult2 = delimiterProcessor.PlaceComponentResult();
            if (MyBillsEntityDataFactory2 == PlaceComponentResult2) {
                DelimiterProcessor delimiterProcessor2 = map.get(Character.valueOf(MyBillsEntityDataFactory2));
                if (delimiterProcessor2 != null && delimiterProcessor2.MyBillsEntityDataFactory() == delimiterProcessor2.PlaceComponentResult()) {
                    if (delimiterProcessor2 instanceof StaggeredDelimiterProcessor) {
                        staggeredDelimiterProcessor = (StaggeredDelimiterProcessor) delimiterProcessor2;
                    } else {
                        StaggeredDelimiterProcessor staggeredDelimiterProcessor2 = new StaggeredDelimiterProcessor(MyBillsEntityDataFactory2);
                        staggeredDelimiterProcessor2.getAuthRequestContext(delimiterProcessor2);
                        staggeredDelimiterProcessor = staggeredDelimiterProcessor2;
                    }
                    staggeredDelimiterProcessor.getAuthRequestContext(delimiterProcessor);
                    map.put(Character.valueOf(MyBillsEntityDataFactory2), staggeredDelimiterProcessor);
                } else {
                    getAuthRequestContext(MyBillsEntityDataFactory2, delimiterProcessor, map);
                }
            } else {
                getAuthRequestContext(MyBillsEntityDataFactory2, delimiterProcessor, map);
                getAuthRequestContext(PlaceComponentResult2, delimiterProcessor, map);
            }
        }
    }

    private static void getAuthRequestContext(char c, DelimiterProcessor delimiterProcessor, Map<Character, DelimiterProcessor> map) {
        if (map.put(Character.valueOf(c), delimiterProcessor) == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Delimiter processor conflict with delimiter char '");
        sb.append(c);
        sb.append("'");
        throw new IllegalArgumentException(sb.toString());
    }

    @Override // org.commonmark.parser.InlineParser
    public final void MyBillsEntityDataFactory(String str, Node node) {
        this.PrepareContext = node;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = str.trim();
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = 0;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = null;
        this.FragmentBottomSheetPaymentSettingBinding = null;
        do {
        } while (lookAheadTest());
        KClassImpl$Data$declaredNonStaticMembers$2(null);
        if (node.getErrorConfigVersion != node.scheduleImpl) {
            getAuthRequestContext(node.getErrorConfigVersion, node.scheduleImpl);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x007f, code lost:
    
        if (MyBillsEntityDataFactory(r6) != null) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0087 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0088  */
    @Override // org.commonmark.internal.ReferenceParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int getAuthRequestContext(java.lang.String r9) {
        /*
            r8 = this;
            r8.NetworkUserEntityData$$ExternalSyntheticLambda5 = r9
            r9 = 0
            r8.NetworkUserEntityData$$ExternalSyntheticLambda7 = r9
            java.util.regex.Pattern r0 = org.commonmark.internal.InlineParserImpl.lookAheadTest
            java.lang.String r0 = r8.MyBillsEntityDataFactory(r0)
            if (r0 == 0) goto L1a
            int r1 = r0.length()
            r2 = 1001(0x3e9, float:1.403E-42)
            if (r1 > r2) goto L1a
            int r0 = r0.length()
            goto L1b
        L1a:
            r0 = 0
        L1b:
            if (r0 != 0) goto L1e
            return r9
        L1e:
            java.lang.String r1 = r8.NetworkUserEntityData$$ExternalSyntheticLambda5
            java.lang.String r0 = r1.substring(r9, r0)
            char r1 = r8.NetworkUserEntityData$$ExternalSyntheticLambda1()
            r2 = 58
            if (r1 == r2) goto L2d
            return r9
        L2d:
            int r1 = r8.NetworkUserEntityData$$ExternalSyntheticLambda7
            r2 = 1
            int r1 = r1 + r2
            r8.NetworkUserEntityData$$ExternalSyntheticLambda7 = r1
            r8.DatabaseTableConfigUtil()
            java.lang.String r1 = r8.NetworkUserEntityData$$ExternalSyntheticLambda0()
            if (r1 == 0) goto La9
            int r3 = r1.length()
            if (r3 == 0) goto La9
            int r3 = r8.NetworkUserEntityData$$ExternalSyntheticLambda7
            r8.DatabaseTableConfigUtil()
            java.util.regex.Pattern r4 = org.commonmark.internal.InlineParserImpl.moveToNextValue
            java.lang.String r4 = r8.MyBillsEntityDataFactory(r4)
            r5 = 0
            if (r4 == 0) goto L5e
            int r6 = r4.length()
            int r6 = r6 - r2
            java.lang.String r4 = r4.substring(r2, r6)
            java.lang.String r4 = org.commonmark.internal.util.Escaping.MyBillsEntityDataFactory(r4)
            goto L5f
        L5e:
            r4 = r5
        L5f:
            if (r4 != 0) goto L63
            r8.NetworkUserEntityData$$ExternalSyntheticLambda7 = r3
        L63:
            int r6 = r8.NetworkUserEntityData$$ExternalSyntheticLambda7
            java.lang.String r7 = r8.NetworkUserEntityData$$ExternalSyntheticLambda5
            int r7 = r7.length()
            if (r6 == r7) goto L84
            java.util.regex.Pattern r6 = org.commonmark.internal.InlineParserImpl.getErrorConfigVersion
            java.lang.String r7 = r8.MyBillsEntityDataFactory(r6)
            if (r7 != 0) goto L84
            if (r4 != 0) goto L79
            r5 = r4
            goto L82
        L79:
            r8.NetworkUserEntityData$$ExternalSyntheticLambda7 = r3
            java.lang.String r3 = r8.MyBillsEntityDataFactory(r6)
            if (r3 == 0) goto L82
            goto L85
        L82:
            r2 = 0
            goto L85
        L84:
            r5 = r4
        L85:
            if (r2 != 0) goto L88
            return r9
        L88:
            java.lang.String r0 = org.commonmark.internal.util.Escaping.PlaceComponentResult(r0)
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L93
            return r9
        L93:
            java.util.Map<java.lang.String, org.commonmark.node.Link> r2 = r8.NetworkUserEntityData$$ExternalSyntheticLambda4
            boolean r2 = r2.containsKey(r0)
            if (r2 != 0) goto La5
            org.commonmark.node.Link r2 = new org.commonmark.node.Link
            r2.<init>(r1, r5)
            java.util.Map<java.lang.String, org.commonmark.node.Link> r1 = r8.NetworkUserEntityData$$ExternalSyntheticLambda4
            r1.put(r0, r2)
        La5:
            int r0 = r8.NetworkUserEntityData$$ExternalSyntheticLambda7
            int r0 = r0 - r9
            return r0
        La9:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.commonmark.internal.InlineParserImpl.getAuthRequestContext(java.lang.String):int");
    }

    private Text getAuthRequestContext(CharSequence charSequence, int i, int i2) {
        Text text = new Text(charSequence.subSequence(i, i2).toString());
        this.PrepareContext.KClassImpl$Data$declaredNonStaticMembers$2(text);
        return text;
    }

    private boolean lookAheadTest() {
        char NetworkUserEntityData$$ExternalSyntheticLambda12 = NetworkUserEntityData$$ExternalSyntheticLambda1();
        boolean z = false;
        if (NetworkUserEntityData$$ExternalSyntheticLambda12 == 0) {
            return false;
        }
        if (NetworkUserEntityData$$ExternalSyntheticLambda12 == '\n') {
            z = initRecordTimeStamp();
        } else if (NetworkUserEntityData$$ExternalSyntheticLambda12 == '!') {
            z = getAuthRequestContext();
        } else if (NetworkUserEntityData$$ExternalSyntheticLambda12 == '&') {
            z = getErrorConfigVersion();
        } else if (NetworkUserEntityData$$ExternalSyntheticLambda12 != '<') {
            if (NetworkUserEntityData$$ExternalSyntheticLambda12 == '`') {
                z = PlaceComponentResult();
            } else {
                switch (NetworkUserEntityData$$ExternalSyntheticLambda12) {
                    case '[':
                        z = GetContactSyncConfig();
                        break;
                    case '\\':
                        z = KClassImpl$Data$declaredNonStaticMembers$2();
                        break;
                    case ']':
                        z = MyBillsEntityDataFactory();
                        break;
                    default:
                        if (this.isLayoutRequested.get(NetworkUserEntityData$$ExternalSyntheticLambda12)) {
                            z = getAuthRequestContext(this.newProxyInstance.get(Character.valueOf(NetworkUserEntityData$$ExternalSyntheticLambda12)), NetworkUserEntityData$$ExternalSyntheticLambda12);
                            break;
                        } else {
                            z = NetworkUserEntityData$$ExternalSyntheticLambda2();
                            break;
                        }
                }
            }
        } else if (BuiltInFictitiousFunctionClassFactory() || scheduleImpl()) {
            z = true;
        }
        if (!z) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda7++;
            this.PrepareContext.KClassImpl$Data$declaredNonStaticMembers$2(new Text(String.valueOf(NetworkUserEntityData$$ExternalSyntheticLambda12).toString()));
        }
        return true;
    }

    private String MyBillsEntityDataFactory(Pattern pattern) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7 >= this.NetworkUserEntityData$$ExternalSyntheticLambda5.length()) {
            return null;
        }
        Matcher matcher = pattern.matcher(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
        matcher.region(this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.NetworkUserEntityData$$ExternalSyntheticLambda5.length());
        if (matcher.find()) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = matcher.end();
            return matcher.group();
        }
        return null;
    }

    private char NetworkUserEntityData$$ExternalSyntheticLambda1() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda7 < this.NetworkUserEntityData$$ExternalSyntheticLambda5.length()) {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda5.charAt(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        }
        return (char) 0;
    }

    private boolean DatabaseTableConfigUtil() {
        MyBillsEntityDataFactory(DatabaseTableConfigUtil);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0069 A[LOOP:0: B:20:0x0061->B:22:0x0069, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean initRecordTimeStamp() {
        /*
            r6 = this;
            int r0 = r6.NetworkUserEntityData$$ExternalSyntheticLambda7
            r1 = 1
            int r0 = r0 + r1
            r6.NetworkUserEntityData$$ExternalSyntheticLambda7 = r0
            org.commonmark.node.Node r0 = r6.PrepareContext
            org.commonmark.node.Node r0 = r0.scheduleImpl
            if (r0 == 0) goto L57
            boolean r2 = r0 instanceof org.commonmark.node.Text
            if (r2 == 0) goto L57
            org.commonmark.node.Text r0 = (org.commonmark.node.Text) r0
            java.lang.String r2 = r0.PlaceComponentResult
            java.lang.String r3 = " "
            boolean r2 = r2.endsWith(r3)
            if (r2 == 0) goto L57
            java.lang.String r2 = r0.PlaceComponentResult
            java.util.regex.Pattern r3 = org.commonmark.internal.InlineParserImpl.MyBillsEntityDataFactory
            java.util.regex.Matcher r3 = r3.matcher(r2)
            boolean r4 = r3.find()
            r5 = 0
            if (r4 == 0) goto L35
            int r4 = r3.end()
            int r3 = r3.start()
            int r4 = r4 - r3
            goto L36
        L35:
            r4 = 0
        L36:
            if (r4 <= 0) goto L43
            int r3 = r2.length()
            int r3 = r3 - r4
            java.lang.String r2 = r2.substring(r5, r3)
            r0.PlaceComponentResult = r2
        L43:
            r0 = 2
            if (r4 < r0) goto L4c
            org.commonmark.node.HardLineBreak r0 = new org.commonmark.node.HardLineBreak
            r0.<init>()
            goto L51
        L4c:
            org.commonmark.node.SoftLineBreak r0 = new org.commonmark.node.SoftLineBreak
            r0.<init>()
        L51:
            org.commonmark.node.Node r2 = r6.PrepareContext
            r2.KClassImpl$Data$declaredNonStaticMembers$2(r0)
            goto L61
        L57:
            org.commonmark.node.SoftLineBreak r0 = new org.commonmark.node.SoftLineBreak
            r0.<init>()
            org.commonmark.node.Node r2 = r6.PrepareContext
            r2.KClassImpl$Data$declaredNonStaticMembers$2(r0)
        L61:
            char r0 = r6.NetworkUserEntityData$$ExternalSyntheticLambda1()
            r2 = 32
            if (r0 != r2) goto L6f
            int r0 = r6.NetworkUserEntityData$$ExternalSyntheticLambda7
            int r0 = r0 + r1
            r6.NetworkUserEntityData$$ExternalSyntheticLambda7 = r0
            goto L61
        L6f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.commonmark.internal.InlineParserImpl.initRecordTimeStamp():boolean");
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7++;
        if (NetworkUserEntityData$$ExternalSyntheticLambda1() == '\n') {
            this.PrepareContext.KClassImpl$Data$declaredNonStaticMembers$2(new HardLineBreak());
            this.NetworkUserEntityData$$ExternalSyntheticLambda7++;
        } else {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda7 < this.NetworkUserEntityData$$ExternalSyntheticLambda5.length()) {
                Pattern pattern = PlaceComponentResult;
                String str = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                int i = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                if (pattern.matcher(str.substring(i, i + 1)).matches()) {
                    String str2 = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
                    int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                    getAuthRequestContext(str2, i2, i2 + 1);
                    this.NetworkUserEntityData$$ExternalSyntheticLambda7++;
                }
            }
            this.PrepareContext.KClassImpl$Data$declaredNonStaticMembers$2(new Text("\\".toString()));
        }
        return true;
    }

    private boolean PlaceComponentResult() {
        String MyBillsEntityDataFactory2;
        String MyBillsEntityDataFactory3 = MyBillsEntityDataFactory(GetContactSyncConfig);
        if (MyBillsEntityDataFactory3 == null) {
            return false;
        }
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        do {
            MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(NetworkUserEntityData$$ExternalSyntheticLambda1);
            if (MyBillsEntityDataFactory2 == null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda7 = i;
                this.PrepareContext.KClassImpl$Data$declaredNonStaticMembers$2(new Text(MyBillsEntityDataFactory3.toString()));
                return true;
            }
        } while (!MyBillsEntityDataFactory2.equals(MyBillsEntityDataFactory3));
        Code code = new Code();
        code.MyBillsEntityDataFactory = NetworkUserEntityData$$ExternalSyntheticLambda8.matcher(this.NetworkUserEntityData$$ExternalSyntheticLambda5.substring(i, this.NetworkUserEntityData$$ExternalSyntheticLambda7 - MyBillsEntityDataFactory3.length()).trim()).replaceAll(" ");
        this.PrepareContext.KClassImpl$Data$declaredNonStaticMembers$2(code);
        return true;
    }

    private boolean GetContactSyncConfig() {
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = i + 1;
        Text text = new Text("[".toString());
        this.PrepareContext.KClassImpl$Data$declaredNonStaticMembers$2(text);
        Bracket MyBillsEntityDataFactory2 = Bracket.MyBillsEntityDataFactory(text, i, this.FragmentBottomSheetPaymentSettingBinding, this.NetworkUserEntityData$$ExternalSyntheticLambda3);
        Bracket bracket = this.FragmentBottomSheetPaymentSettingBinding;
        if (bracket != null) {
            bracket.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        }
        this.FragmentBottomSheetPaymentSettingBinding = MyBillsEntityDataFactory2;
        return true;
    }

    private boolean getAuthRequestContext() {
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda7 + 1;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = i;
        if (NetworkUserEntityData$$ExternalSyntheticLambda1() == '[') {
            this.NetworkUserEntityData$$ExternalSyntheticLambda7++;
            Text text = new Text("![".toString());
            this.PrepareContext.KClassImpl$Data$declaredNonStaticMembers$2(text);
            Bracket KClassImpl$Data$declaredNonStaticMembers$22 = Bracket.KClassImpl$Data$declaredNonStaticMembers$2(text, i, this.FragmentBottomSheetPaymentSettingBinding, this.NetworkUserEntityData$$ExternalSyntheticLambda3);
            Bracket bracket = this.FragmentBottomSheetPaymentSettingBinding;
            if (bracket != null) {
                bracket.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            }
            this.FragmentBottomSheetPaymentSettingBinding = KClassImpl$Data$declaredNonStaticMembers$22;
        } else {
            this.PrepareContext.KClassImpl$Data$declaredNonStaticMembers$2(new Text("!".toString()));
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0130  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean MyBillsEntityDataFactory() {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.commonmark.internal.InlineParserImpl.MyBillsEntityDataFactory():boolean");
    }

    private String NetworkUserEntityData$$ExternalSyntheticLambda0() {
        String MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(scheduleImpl);
        if (MyBillsEntityDataFactory2 != null) {
            return MyBillsEntityDataFactory2.length() == 2 ? "" : Escaping.MyBillsEntityDataFactory(MyBillsEntityDataFactory2.substring(1, MyBillsEntityDataFactory2.length() - 1));
        }
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        moveToNextValue();
        return Escaping.MyBillsEntityDataFactory(this.NetworkUserEntityData$$ExternalSyntheticLambda5.substring(i, this.NetworkUserEntityData$$ExternalSyntheticLambda7));
    }

    private void moveToNextValue() {
        int i = 0;
        while (true) {
            char NetworkUserEntityData$$ExternalSyntheticLambda12 = NetworkUserEntityData$$ExternalSyntheticLambda1();
            if (NetworkUserEntityData$$ExternalSyntheticLambda12 == 0 || NetworkUserEntityData$$ExternalSyntheticLambda12 == ' ') {
                return;
            }
            if (NetworkUserEntityData$$ExternalSyntheticLambda12 == '\\') {
                this.NetworkUserEntityData$$ExternalSyntheticLambda7++;
                if (NetworkUserEntityData$$ExternalSyntheticLambda1() == 0) {
                    return;
                }
            } else if (NetworkUserEntityData$$ExternalSyntheticLambda12 == '(') {
                i++;
            } else if (NetworkUserEntityData$$ExternalSyntheticLambda12 != ')') {
                if (Character.isISOControl(NetworkUserEntityData$$ExternalSyntheticLambda12)) {
                    return;
                }
            } else if (i == 0) {
                return;
            } else {
                i--;
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda7++;
        }
    }

    private boolean BuiltInFictitiousFunctionClassFactory() {
        String MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2);
        if (MyBillsEntityDataFactory2 != null) {
            String substring = MyBillsEntityDataFactory2.substring(1, MyBillsEntityDataFactory2.length() - 1);
            StringBuilder sb = new StringBuilder();
            sb.append("mailto:");
            sb.append(substring);
            Link link = new Link(sb.toString(), null);
            link.KClassImpl$Data$declaredNonStaticMembers$2(new Text(substring));
            this.PrepareContext.KClassImpl$Data$declaredNonStaticMembers$2(link);
            return true;
        }
        String MyBillsEntityDataFactory3 = MyBillsEntityDataFactory(getAuthRequestContext);
        if (MyBillsEntityDataFactory3 != null) {
            String substring2 = MyBillsEntityDataFactory3.substring(1, MyBillsEntityDataFactory3.length() - 1);
            Link link2 = new Link(substring2, null);
            link2.KClassImpl$Data$declaredNonStaticMembers$2(new Text(substring2));
            this.PrepareContext.KClassImpl$Data$declaredNonStaticMembers$2(link2);
            return true;
        }
        return false;
    }

    private boolean scheduleImpl() {
        String MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(NetworkUserEntityData$$ExternalSyntheticLambda0);
        if (MyBillsEntityDataFactory2 != null) {
            HtmlInline htmlInline = new HtmlInline();
            htmlInline.KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory2;
            this.PrepareContext.KClassImpl$Data$declaredNonStaticMembers$2(htmlInline);
            return true;
        }
        return false;
    }

    private boolean getErrorConfigVersion() {
        String MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
        if (MyBillsEntityDataFactory2 != null) {
            this.PrepareContext.KClassImpl$Data$declaredNonStaticMembers$2(new Text(Html5Entities.getAuthRequestContext(MyBillsEntityDataFactory2).toString()));
            return true;
        }
        return false;
    }

    private boolean NetworkUserEntityData$$ExternalSyntheticLambda2() {
        int i = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        int length = this.NetworkUserEntityData$$ExternalSyntheticLambda5.length();
        while (true) {
            int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
            if (i2 == length || this.NetworkUserEntityData$$ExternalSyntheticLambda6.get(this.NetworkUserEntityData$$ExternalSyntheticLambda5.charAt(i2))) {
                break;
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda7++;
        }
        int i3 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        if (i != i3) {
            getAuthRequestContext(this.NetworkUserEntityData$$ExternalSyntheticLambda5, i, i3);
            return true;
        }
        return false;
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(Delimiter delimiter) {
        boolean z;
        HashMap hashMap = new HashMap();
        Delimiter delimiter2 = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
        while (delimiter2 != null && delimiter2.getErrorConfigVersion != delimiter) {
            delimiter2 = delimiter2.getErrorConfigVersion;
        }
        while (delimiter2 != null) {
            char c = delimiter2.PlaceComponentResult;
            DelimiterProcessor delimiterProcessor = this.newProxyInstance.get(Character.valueOf(c));
            if (!delimiter2.BuiltInFictitiousFunctionClassFactory || delimiterProcessor == null) {
                delimiter2 = delimiter2.MyBillsEntityDataFactory;
            } else {
                char MyBillsEntityDataFactory2 = delimiterProcessor.MyBillsEntityDataFactory();
                Delimiter delimiter3 = delimiter2.getErrorConfigVersion;
                int i = 0;
                boolean z2 = false;
                while (true) {
                    z = true;
                    if (delimiter3 == null || delimiter3 == delimiter || delimiter3 == hashMap.get(Character.valueOf(c))) {
                        break;
                    }
                    if (delimiter3.KClassImpl$Data$declaredNonStaticMembers$2 && delimiter3.PlaceComponentResult == MyBillsEntityDataFactory2) {
                        i = delimiterProcessor.getAuthRequestContext(delimiter3, delimiter2);
                        z2 = true;
                        if (i > 0) {
                            break;
                        }
                    }
                    delimiter3 = delimiter3.getErrorConfigVersion;
                }
                z = false;
                if (!z) {
                    if (!z2) {
                        hashMap.put(Character.valueOf(c), delimiter2.getErrorConfigVersion);
                        if (!delimiter2.KClassImpl$Data$declaredNonStaticMembers$2) {
                            PlaceComponentResult(delimiter2);
                        }
                    }
                    delimiter2 = delimiter2.MyBillsEntityDataFactory;
                } else {
                    Text text = delimiter3.lookAheadTest;
                    Text text2 = delimiter2.lookAheadTest;
                    delimiter3.getAuthRequestContext -= i;
                    delimiter2.getAuthRequestContext -= i;
                    text.PlaceComponentResult = text.PlaceComponentResult.substring(0, text.PlaceComponentResult.length() - i);
                    text2.PlaceComponentResult = text2.PlaceComponentResult.substring(0, text2.PlaceComponentResult.length() - i);
                    Delimiter delimiter4 = delimiter2.getErrorConfigVersion;
                    while (delimiter4 != null && delimiter4 != delimiter3) {
                        Delimiter delimiter5 = delimiter4.getErrorConfigVersion;
                        PlaceComponentResult(delimiter4);
                        delimiter4 = delimiter5;
                    }
                    if (text != text2 && text.NetworkUserEntityData$$ExternalSyntheticLambda0 != text2) {
                        getAuthRequestContext(text.NetworkUserEntityData$$ExternalSyntheticLambda0, text2.moveToNextValue);
                    }
                    delimiterProcessor.KClassImpl$Data$declaredNonStaticMembers$2(text, text2, i);
                    if (delimiter3.getAuthRequestContext == 0) {
                        delimiter3.lookAheadTest.NetworkUserEntityData$$ExternalSyntheticLambda0();
                        PlaceComponentResult(delimiter3);
                    }
                    if (delimiter2.getAuthRequestContext == 0) {
                        Delimiter delimiter6 = delimiter2.MyBillsEntityDataFactory;
                        delimiter2.lookAheadTest.NetworkUserEntityData$$ExternalSyntheticLambda0();
                        PlaceComponentResult(delimiter2);
                        delimiter2 = delimiter6;
                    }
                }
            }
        }
        while (true) {
            Delimiter delimiter7 = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
            if (delimiter7 == null || delimiter7 == delimiter) {
                return;
            }
            PlaceComponentResult(delimiter7);
        }
    }

    private void PlaceComponentResult(Delimiter delimiter) {
        if (delimiter.getErrorConfigVersion != null) {
            delimiter.getErrorConfigVersion.MyBillsEntityDataFactory = delimiter.MyBillsEntityDataFactory;
        }
        if (delimiter.MyBillsEntityDataFactory == null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = delimiter.getErrorConfigVersion;
            return;
        }
        delimiter.MyBillsEntityDataFactory.getErrorConfigVersion = delimiter.getErrorConfigVersion;
    }

    private static void getAuthRequestContext(Node node, Node node2) {
        Text text = null;
        Text text2 = null;
        int i = 0;
        while (node != null) {
            if (node instanceof Text) {
                text2 = (Text) node;
                if (text == null) {
                    text = text2;
                }
                i += text2.PlaceComponentResult.length();
            } else {
                PlaceComponentResult(text, text2, i);
                text = null;
                text2 = null;
                i = 0;
            }
            if (node == node2) {
                break;
            }
            node = node.NetworkUserEntityData$$ExternalSyntheticLambda0;
        }
        PlaceComponentResult(text, text2, i);
    }

    private static void PlaceComponentResult(Text text, Text text2, int i) {
        if (text == null || text2 == null || text == text2) {
            return;
        }
        StringBuilder sb = new StringBuilder(i);
        sb.append(text.PlaceComponentResult);
        Node node = text.NetworkUserEntityData$$ExternalSyntheticLambda0;
        Node node2 = text2.NetworkUserEntityData$$ExternalSyntheticLambda0;
        while (node != node2) {
            sb.append(((Text) node).PlaceComponentResult);
            Node node3 = node.NetworkUserEntityData$$ExternalSyntheticLambda0;
            node.NetworkUserEntityData$$ExternalSyntheticLambda0();
            node = node3;
        }
        text.PlaceComponentResult = sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class DelimiterData {
        final boolean BuiltInFictitiousFunctionClassFactory;
        final boolean KClassImpl$Data$declaredNonStaticMembers$2;
        final int getAuthRequestContext;

        DelimiterData(int i, boolean z, boolean z2) {
            this.getAuthRequestContext = i;
            this.BuiltInFictitiousFunctionClassFactory = z;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = z2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0081, code lost:
    
        if (r6 != false) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean getAuthRequestContext(org.commonmark.parser.delimiter.DelimiterProcessor r12, char r13) {
        /*
            Method dump skipped, instructions count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.commonmark.internal.InlineParserImpl.getAuthRequestContext(org.commonmark.parser.delimiter.DelimiterProcessor, char):boolean");
    }
}
