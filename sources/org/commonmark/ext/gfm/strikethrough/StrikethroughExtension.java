package org.commonmark.ext.gfm.strikethrough;

import org.commonmark.Extension;
import org.commonmark.ext.gfm.strikethrough.internal.StrikethroughDelimiterProcessor;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlNodeRendererFactory;
import org.commonmark.renderer.html.HtmlRenderer;
import org.commonmark.renderer.text.TextContentNodeRendererFactory;
import org.commonmark.renderer.text.TextContentRenderer;

/* loaded from: classes6.dex */
public class StrikethroughExtension implements Parser.ParserExtension, HtmlRenderer.HtmlRendererExtension, TextContentRenderer.TextContentRendererExtension {

    /* renamed from: org.commonmark.ext.gfm.strikethrough.StrikethroughExtension$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass1 implements HtmlNodeRendererFactory {
    }

    /* renamed from: org.commonmark.ext.gfm.strikethrough.StrikethroughExtension$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass2 implements TextContentNodeRendererFactory {
    }

    private StrikethroughExtension() {
    }

    public static Extension BuiltInFictitiousFunctionClassFactory() {
        return new StrikethroughExtension();
    }

    @Override // org.commonmark.parser.Parser.ParserExtension
    public final void BuiltInFictitiousFunctionClassFactory(Parser.Builder builder) {
        builder.MyBillsEntityDataFactory.add(new StrikethroughDelimiterProcessor());
    }
}
