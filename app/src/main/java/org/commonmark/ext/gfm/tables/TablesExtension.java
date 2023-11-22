package org.commonmark.ext.gfm.tables;

import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.internal.TableBlockParser;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlNodeRendererFactory;
import org.commonmark.renderer.html.HtmlRenderer;
import org.commonmark.renderer.text.TextContentNodeRendererFactory;
import org.commonmark.renderer.text.TextContentRenderer;

/* loaded from: classes6.dex */
public class TablesExtension implements Parser.ParserExtension, HtmlRenderer.HtmlRendererExtension, TextContentRenderer.TextContentRendererExtension {

    /* renamed from: org.commonmark.ext.gfm.tables.TablesExtension$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass1 implements HtmlNodeRendererFactory {
    }

    /* renamed from: org.commonmark.ext.gfm.tables.TablesExtension$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass2 implements TextContentNodeRendererFactory {
    }

    private TablesExtension() {
    }

    public static Extension BuiltInFictitiousFunctionClassFactory() {
        return new TablesExtension();
    }

    @Override // org.commonmark.parser.Parser.ParserExtension
    public final void BuiltInFictitiousFunctionClassFactory(Parser.Builder builder) {
        builder.PlaceComponentResult.add(new TableBlockParser.Factory());
    }
}
