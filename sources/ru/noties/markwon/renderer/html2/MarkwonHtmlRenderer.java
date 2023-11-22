package ru.noties.markwon.renderer.html2;

import com.huawei.hms.opendevice.i;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import ru.noties.markwon.SpannableBuilder;
import ru.noties.markwon.SpannableConfiguration;
import ru.noties.markwon.html.api.MarkwonHtmlParser;
import ru.noties.markwon.renderer.html2.tag.BlockquoteHandler;
import ru.noties.markwon.renderer.html2.tag.EmphasisHandler;
import ru.noties.markwon.renderer.html2.tag.HeadingHandler;
import ru.noties.markwon.renderer.html2.tag.ImageHandler;
import ru.noties.markwon.renderer.html2.tag.LinkHandler;
import ru.noties.markwon.renderer.html2.tag.ListHandler;
import ru.noties.markwon.renderer.html2.tag.StrikeHandler;
import ru.noties.markwon.renderer.html2.tag.StrongEmphasisHandler;
import ru.noties.markwon.renderer.html2.tag.SubScriptHandler;
import ru.noties.markwon.renderer.html2.tag.SuperScriptHandler;
import ru.noties.markwon.renderer.html2.tag.TagHandler;
import ru.noties.markwon.renderer.html2.tag.UnderlineHandler;

/* loaded from: classes6.dex */
public abstract class MarkwonHtmlRenderer {

    /* loaded from: classes6.dex */
    public static class Builder {
        final Map<String, TagHandler> getAuthRequestContext = new HashMap(2);
    }

    public abstract void BuiltInFictitiousFunctionClassFactory(SpannableConfiguration spannableConfiguration, SpannableBuilder spannableBuilder, MarkwonHtmlParser markwonHtmlParser);

    public abstract TagHandler KClassImpl$Data$declaredNonStaticMembers$2(String str);

    public static MarkwonHtmlRenderer KClassImpl$Data$declaredNonStaticMembers$2() {
        EmphasisHandler emphasisHandler = new EmphasisHandler();
        StrongEmphasisHandler strongEmphasisHandler = new StrongEmphasisHandler();
        StrikeHandler strikeHandler = new StrikeHandler();
        UnderlineHandler underlineHandler = new UnderlineHandler();
        ListHandler listHandler = new ListHandler();
        Builder builder = new Builder();
        builder.getAuthRequestContext.put(i.MyBillsEntityDataFactory.toLowerCase(Locale.US), emphasisHandler);
        builder.getAuthRequestContext.put("em".toLowerCase(Locale.US), emphasisHandler);
        builder.getAuthRequestContext.put("cite".toLowerCase(Locale.US), emphasisHandler);
        builder.getAuthRequestContext.put("dfn".toLowerCase(Locale.US), emphasisHandler);
        builder.getAuthRequestContext.put("b".toLowerCase(Locale.US), strongEmphasisHandler);
        builder.getAuthRequestContext.put("strong".toLowerCase(Locale.US), strongEmphasisHandler);
        builder.getAuthRequestContext.put("sup".toLowerCase(Locale.US), new SuperScriptHandler());
        builder.getAuthRequestContext.put("sub".toLowerCase(Locale.US), new SubScriptHandler());
        builder.getAuthRequestContext.put("u".toLowerCase(Locale.US), underlineHandler);
        builder.getAuthRequestContext.put("ins".toLowerCase(Locale.US), underlineHandler);
        builder.getAuthRequestContext.put("del".toLowerCase(Locale.US), strikeHandler);
        builder.getAuthRequestContext.put("s".toLowerCase(Locale.US), strikeHandler);
        builder.getAuthRequestContext.put("strike".toLowerCase(Locale.US), strikeHandler);
        builder.getAuthRequestContext.put("a".toLowerCase(Locale.US), new LinkHandler());
        builder.getAuthRequestContext.put("ul".toLowerCase(Locale.US), listHandler);
        builder.getAuthRequestContext.put("ol".toLowerCase(Locale.US), listHandler);
        builder.getAuthRequestContext.put("img".toLowerCase(Locale.US), ImageHandler.MyBillsEntityDataFactory());
        builder.getAuthRequestContext.put("blockquote".toLowerCase(Locale.US), new BlockquoteHandler());
        builder.getAuthRequestContext.put("h1".toLowerCase(Locale.US), new HeadingHandler(1));
        builder.getAuthRequestContext.put(SemanticAttributes.DbSystemValues.H2.toLowerCase(Locale.US), new HeadingHandler(2));
        builder.getAuthRequestContext.put("h3".toLowerCase(Locale.US), new HeadingHandler(3));
        builder.getAuthRequestContext.put("h4".toLowerCase(Locale.US), new HeadingHandler(4));
        builder.getAuthRequestContext.put("h5".toLowerCase(Locale.US), new HeadingHandler(5));
        builder.getAuthRequestContext.put("h6".toLowerCase(Locale.US), new HeadingHandler(6));
        return new MarkwonHtmlRendererImpl(Collections.unmodifiableMap(builder.getAuthRequestContext));
    }
}
