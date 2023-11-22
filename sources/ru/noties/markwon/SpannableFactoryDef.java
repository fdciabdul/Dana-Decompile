package ru.noties.markwon;

import android.text.style.StrikethroughSpan;
import android.text.style.UnderlineSpan;
import java.util.List;
import kotlin.text.Typography;
import ru.noties.markwon.renderer.ImageSize;
import ru.noties.markwon.renderer.ImageSizeResolver;
import ru.noties.markwon.spans.AsyncDrawable;
import ru.noties.markwon.spans.AsyncDrawableSpan;
import ru.noties.markwon.spans.BlockQuoteSpan;
import ru.noties.markwon.spans.BulletListItemSpan;
import ru.noties.markwon.spans.CodeSpan;
import ru.noties.markwon.spans.EmphasisSpan;
import ru.noties.markwon.spans.HeadingSpan;
import ru.noties.markwon.spans.LinkSpan;
import ru.noties.markwon.spans.OrderedListItemSpan;
import ru.noties.markwon.spans.SpannableTheme;
import ru.noties.markwon.spans.StrongEmphasisSpan;
import ru.noties.markwon.spans.SubScriptSpan;
import ru.noties.markwon.spans.SuperScriptSpan;
import ru.noties.markwon.spans.TableRowSpan;
import ru.noties.markwon.spans.TaskListSpan;
import ru.noties.markwon.spans.ThematicBreakSpan;

/* loaded from: classes6.dex */
public class SpannableFactoryDef implements SpannableFactory {
    public static SpannableFactoryDef KClassImpl$Data$declaredNonStaticMembers$2() {
        return new SpannableFactoryDef();
    }

    @Override // ru.noties.markwon.SpannableFactory
    public final Object BuiltInFictitiousFunctionClassFactory() {
        return new StrongEmphasisSpan();
    }

    @Override // ru.noties.markwon.SpannableFactory
    public final Object PlaceComponentResult() {
        return new EmphasisSpan();
    }

    @Override // ru.noties.markwon.SpannableFactory
    public final Object PlaceComponentResult(SpannableTheme spannableTheme) {
        return new BlockQuoteSpan(spannableTheme);
    }

    @Override // ru.noties.markwon.SpannableFactory
    public final Object BuiltInFictitiousFunctionClassFactory(SpannableTheme spannableTheme, boolean z) {
        return new CodeSpan(spannableTheme, z);
    }

    @Override // ru.noties.markwon.SpannableFactory
    public final Object PlaceComponentResult(SpannableTheme spannableTheme, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(i));
        sb.append(".");
        sb.append(Typography.nbsp);
        return new OrderedListItemSpan(spannableTheme, sb.toString());
    }

    @Override // ru.noties.markwon.SpannableFactory
    public final Object KClassImpl$Data$declaredNonStaticMembers$2(SpannableTheme spannableTheme, int i) {
        return new BulletListItemSpan(spannableTheme, i);
    }

    @Override // ru.noties.markwon.SpannableFactory
    public final Object MyBillsEntityDataFactory(SpannableTheme spannableTheme) {
        return new ThematicBreakSpan(spannableTheme);
    }

    @Override // ru.noties.markwon.SpannableFactory
    public final Object getAuthRequestContext(SpannableTheme spannableTheme, int i) {
        return new HeadingSpan(spannableTheme, i);
    }

    @Override // ru.noties.markwon.SpannableFactory
    public final Object getAuthRequestContext() {
        return new StrikethroughSpan();
    }

    @Override // ru.noties.markwon.SpannableFactory
    public final Object PlaceComponentResult(SpannableTheme spannableTheme, int i, boolean z) {
        return new TaskListSpan(spannableTheme, i, z);
    }

    @Override // ru.noties.markwon.SpannableFactory
    public final Object PlaceComponentResult(SpannableTheme spannableTheme, List<TableRowSpan.Cell> list, boolean z, boolean z2) {
        return new TableRowSpan(spannableTheme, list, z, z2);
    }

    @Override // ru.noties.markwon.SpannableFactory
    public final Object KClassImpl$Data$declaredNonStaticMembers$2(SpannableTheme spannableTheme, String str, AsyncDrawable.Loader loader, ImageSizeResolver imageSizeResolver, ImageSize imageSize, boolean z) {
        return new AsyncDrawableSpan(spannableTheme, new AsyncDrawable(str, loader, imageSizeResolver, imageSize), z);
    }

    @Override // ru.noties.markwon.SpannableFactory
    public final Object KClassImpl$Data$declaredNonStaticMembers$2(SpannableTheme spannableTheme, String str, LinkSpan.Resolver resolver) {
        return new LinkSpan(spannableTheme, str, resolver);
    }

    @Override // ru.noties.markwon.SpannableFactory
    public final Object getAuthRequestContext(SpannableTheme spannableTheme) {
        return new SuperScriptSpan(spannableTheme);
    }

    @Override // ru.noties.markwon.SpannableFactory
    public final Object KClassImpl$Data$declaredNonStaticMembers$2(SpannableTheme spannableTheme) {
        return new SubScriptSpan(spannableTheme);
    }

    @Override // ru.noties.markwon.SpannableFactory
    public final Object MyBillsEntityDataFactory() {
        return new UnderlineSpan();
    }
}
