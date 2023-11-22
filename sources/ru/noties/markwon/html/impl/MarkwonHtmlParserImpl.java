package ru.noties.markwon.html.impl;

import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.remotedebug.utils.TinyAppLogUtil;
import com.google.firebase.messaging.Constants;
import com.huawei.hms.opendevice.i;
import com.iap.ac.android.acs.plugin.downgrade.constant.ApiDowngradeConstant;
import id.dana.animation.HomeTabActivity;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.here.model.HereUrlConstant;
import id.dana.lib.drawbitmap.invoice.InvoiceConstant;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import ru.noties.markwon.html.api.HtmlTag;
import ru.noties.markwon.html.api.MarkwonHtmlParser;
import ru.noties.markwon.html.impl.HtmlTagImpl;
import ru.noties.markwon.html.impl.jsoup.nodes.Attribute;
import ru.noties.markwon.html.impl.jsoup.nodes.Attributes;
import ru.noties.markwon.html.impl.jsoup.parser.Token;

/* loaded from: classes6.dex */
public class MarkwonHtmlParserImpl extends MarkwonHtmlParser {
    private final HtmlEmptyTagReplacement MyBillsEntityDataFactory;
    private final List<HtmlTagImpl.InlineImpl> NetworkUserEntityData$$ExternalSyntheticLambda0 = new ArrayList(0);
    private HtmlTagImpl.BlockImpl getAuthRequestContext = HtmlTagImpl.BlockImpl.GetContactSyncConfig();
    private final TrimmingAppender getErrorConfigVersion;
    private boolean lookAheadTest;
    private boolean moveToNextValue;
    static final Set<String> KClassImpl$Data$declaredNonStaticMembers$2 = Collections.unmodifiableSet(new HashSet(Arrays.asList("a", "abbr", "acronym", "b", "bdo", "big", "br", ApiDowngradeConstant.JsonKeys.BUTTON, "cite", "code", "dfn", "em", i.MyBillsEntityDataFactory, "img", "input", "kbd", Constants.ScionAnalytics.PARAM_LABEL, "map", "object", HereUrlConstant.QUERY, "samp", "script", "select", "small", "span", "strong", "sub", "sup", "textarea", "time", RVParams.TRANSPARENT, "var")));
    private static final Set<String> PlaceComponentResult = Collections.unmodifiableSet(new HashSet(Arrays.asList("area", "base", "br", "col", "embed", "hr", "img", "input", "keygen", "link", "meta", "param", "source", "track", "wbr")));
    private static final Set<String> BuiltInFictitiousFunctionClassFactory = Collections.unmodifiableSet(new HashSet(Arrays.asList("address", "article", "aside", "blockquote", "canvas", "dd", "div", "dl", RVParams.DEFAULT_TITLE, "fieldset", "figcaption", "figure", "footer", "form", "h1", SemanticAttributes.DbSystemValues.H2, "h3", "h4", "h5", "h6", InvoiceConstant.HEADER, "hgroup", "hr", "li", "main", "nav", "noscript", "ol", TinyAppLogUtil.TINY_APP_STANDARD_OUTPUT, BranchLinkConstant.PayloadKey.PROMO_CODE, "pre", HomeTabActivity.WALLET_SECTION, "table", "tfoot", "ul", "video")));

    public static MarkwonHtmlParserImpl PlaceComponentResult() {
        return new MarkwonHtmlParserImpl(HtmlEmptyTagReplacement.getAuthRequestContext(), TrimmingAppender.KClassImpl$Data$declaredNonStaticMembers$2());
    }

    private MarkwonHtmlParserImpl(HtmlEmptyTagReplacement htmlEmptyTagReplacement, TrimmingAppender trimmingAppender) {
        this.MyBillsEntityDataFactory = htmlEmptyTagReplacement;
        this.getErrorConfigVersion = trimmingAppender;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00f7, code lost:
    
        if ("pre".equals(r1) == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00f9, code lost:
    
        r10.moveToNextValue = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00ff, code lost:
    
        if (MyBillsEntityDataFactory(r11, r7) == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0101, code lost:
    
        r12 = ru.noties.markwon.html.impl.HtmlEmptyTagReplacement.MyBillsEntityDataFactory(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0105, code lost:
    
        if (r12 == null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0107, code lost:
    
        ru.noties.markwon.html.impl.AppendableUtils.KClassImpl$Data$declaredNonStaticMembers$2(r11, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x010a, code lost:
    
        r7.MyBillsEntityDataFactory(r11.length());
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0118, code lost:
    
        if (r7.NetworkUserEntityData$$ExternalSyntheticLambda0() != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x011a, code lost:
    
        r10.lookAheadTest = MyBillsEntityDataFactory(r7.PlaceComponentResult);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0126, code lost:
    
        if (id.dana.data.constant.BranchLinkConstant.PayloadKey.PROMO_CODE.equals(r1) == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0128, code lost:
    
        ru.noties.markwon.html.impl.AppendableUtils.PlaceComponentResult(r11, '\n');
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x012b, code lost:
    
        r10.getAuthRequestContext = r7.lookAheadTest;
     */
    @Override // ru.noties.markwon.html.api.MarkwonHtmlParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <T extends java.lang.Appendable & java.lang.CharSequence> void getAuthRequestContext(T r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 560
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.noties.markwon.html.impl.MarkwonHtmlParserImpl.getAuthRequestContext(java.lang.Appendable, java.lang.String):void");
    }

    /* renamed from: ru.noties.markwon.html.impl.MarkwonHtmlParserImpl$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[Token.TokenType.values().length];
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
            try {
                iArr[Token.TokenType.StartTag.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[Token.TokenType.EndTag.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                KClassImpl$Data$declaredNonStaticMembers$2[Token.TokenType.Character.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // ru.noties.markwon.html.api.MarkwonHtmlParser
    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i, MarkwonHtmlParser.FlushAction<HtmlTag.Inline> flushAction) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0.size() > 0) {
            if (i >= 0) {
                for (HtmlTagImpl.InlineImpl inlineImpl : this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                    if (!inlineImpl.KClassImpl$Data$declaredNonStaticMembers$2()) {
                        inlineImpl.MyBillsEntityDataFactory = i;
                    }
                }
            }
            flushAction.KClassImpl$Data$declaredNonStaticMembers$2(Collections.unmodifiableList(this.NetworkUserEntityData$$ExternalSyntheticLambda0));
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.clear();
            return;
        }
        flushAction.KClassImpl$Data$declaredNonStaticMembers$2(Collections.emptyList());
    }

    @Override // ru.noties.markwon.html.api.MarkwonHtmlParser
    public final void getAuthRequestContext(int i, MarkwonHtmlParser.FlushAction<HtmlTag.Block> flushAction) {
        List<HtmlTag.Block> unmodifiableList;
        HtmlTagImpl.BlockImpl blockImpl = this.getAuthRequestContext;
        while (blockImpl.lookAheadTest != null) {
            blockImpl = blockImpl.lookAheadTest;
        }
        if (i >= 0) {
            blockImpl.MyBillsEntityDataFactory(i);
        }
        List<HtmlTagImpl.BlockImpl> list = blockImpl.BuiltInFictitiousFunctionClassFactory;
        if (list == null) {
            unmodifiableList = Collections.emptyList();
        } else {
            unmodifiableList = Collections.unmodifiableList(list);
        }
        if (unmodifiableList.size() > 0) {
            flushAction.KClassImpl$Data$declaredNonStaticMembers$2(unmodifiableList);
        } else {
            flushAction.KClassImpl$Data$declaredNonStaticMembers$2(Collections.emptyList());
        }
        this.getAuthRequestContext = HtmlTagImpl.BlockImpl.GetContactSyncConfig();
    }

    @Override // ru.noties.markwon.html.api.MarkwonHtmlParser
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.clear();
        this.getAuthRequestContext = HtmlTagImpl.BlockImpl.GetContactSyncConfig();
    }

    private static boolean PlaceComponentResult(String str) {
        return KClassImpl$Data$declaredNonStaticMembers$2.contains(str);
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        return PlaceComponentResult.contains(str);
    }

    private static boolean MyBillsEntityDataFactory(String str) {
        return BuiltInFictitiousFunctionClassFactory.contains(str);
    }

    private static <T extends Appendable & CharSequence> void KClassImpl$Data$declaredNonStaticMembers$2(T t) {
        T t2 = t;
        int length = t2.length();
        if (length <= 0 || '\n' == t2.charAt(length - 1)) {
            return;
        }
        AppendableUtils.PlaceComponentResult(t, '\n');
    }

    private static Map<String, String> MyBillsEntityDataFactory(Token.StartTag startTag) {
        Attributes attributes = startTag.PlaceComponentResult;
        int i = attributes.getAuthRequestContext;
        if (i > 0) {
            HashMap hashMap = new HashMap(i);
            Iterator<Attribute> it = attributes.iterator();
            while (it.hasNext()) {
                Attribute next = it.next();
                hashMap.put(next.BuiltInFictitiousFunctionClassFactory.toLowerCase(Locale.US), next.MyBillsEntityDataFactory);
            }
            return Collections.unmodifiableMap(hashMap);
        }
        return Collections.emptyMap();
    }

    private static <T extends Appendable & CharSequence> boolean MyBillsEntityDataFactory(T t, HtmlTagImpl htmlTagImpl) {
        return htmlTagImpl.KClassImpl$Data$declaredNonStaticMembers$2 == t.length();
    }
}
