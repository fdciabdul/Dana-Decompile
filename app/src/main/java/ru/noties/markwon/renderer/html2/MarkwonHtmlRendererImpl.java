package ru.noties.markwon.renderer.html2;

import java.util.List;
import java.util.Map;
import ru.noties.markwon.SpannableBuilder;
import ru.noties.markwon.SpannableConfiguration;
import ru.noties.markwon.html.api.HtmlTag;
import ru.noties.markwon.html.api.MarkwonHtmlParser;
import ru.noties.markwon.renderer.html2.tag.TagHandler;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class MarkwonHtmlRendererImpl extends MarkwonHtmlRenderer {
    final Map<String, TagHandler> BuiltInFictitiousFunctionClassFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MarkwonHtmlRendererImpl(Map<String, TagHandler> map) {
        this.BuiltInFictitiousFunctionClassFactory = map;
    }

    @Override // ru.noties.markwon.renderer.html2.MarkwonHtmlRenderer
    public final void BuiltInFictitiousFunctionClassFactory(final SpannableConfiguration spannableConfiguration, final SpannableBuilder spannableBuilder, MarkwonHtmlParser markwonHtmlParser) {
        int length = !spannableConfiguration.PlaceComponentResult() ? -1 : spannableBuilder.length();
        markwonHtmlParser.KClassImpl$Data$declaredNonStaticMembers$2(length, new MarkwonHtmlParser.FlushAction<HtmlTag.Inline>() { // from class: ru.noties.markwon.renderer.html2.MarkwonHtmlRendererImpl.1
            @Override // ru.noties.markwon.html.api.MarkwonHtmlParser.FlushAction
            public final void KClassImpl$Data$declaredNonStaticMembers$2(List<HtmlTag.Inline> list) {
                for (HtmlTag.Inline inline : list) {
                    if (inline.KClassImpl$Data$declaredNonStaticMembers$2()) {
                        MarkwonHtmlRendererImpl markwonHtmlRendererImpl = MarkwonHtmlRendererImpl.this;
                        TagHandler tagHandler = markwonHtmlRendererImpl.BuiltInFictitiousFunctionClassFactory.get(inline.getErrorConfigVersion());
                        if (tagHandler != null) {
                            tagHandler.MyBillsEntityDataFactory(spannableConfiguration, spannableBuilder, inline);
                        }
                    }
                }
            }
        });
        markwonHtmlParser.getAuthRequestContext(length, new MarkwonHtmlParser.FlushAction<HtmlTag.Block>() { // from class: ru.noties.markwon.renderer.html2.MarkwonHtmlRendererImpl.2
            @Override // ru.noties.markwon.html.api.MarkwonHtmlParser.FlushAction
            public final void KClassImpl$Data$declaredNonStaticMembers$2(List<HtmlTag.Block> list) {
                for (HtmlTag.Block block : list) {
                    if (block.KClassImpl$Data$declaredNonStaticMembers$2()) {
                        MarkwonHtmlRendererImpl markwonHtmlRendererImpl = MarkwonHtmlRendererImpl.this;
                        TagHandler tagHandler = markwonHtmlRendererImpl.BuiltInFictitiousFunctionClassFactory.get(block.getErrorConfigVersion());
                        if (tagHandler != null) {
                            tagHandler.MyBillsEntityDataFactory(spannableConfiguration, spannableBuilder, block);
                        } else {
                            KClassImpl$Data$declaredNonStaticMembers$2(block.lookAheadTest());
                        }
                    }
                }
            }
        });
        markwonHtmlParser.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // ru.noties.markwon.renderer.html2.MarkwonHtmlRenderer
    public final TagHandler KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        return this.BuiltInFictitiousFunctionClassFactory.get(str);
    }
}
