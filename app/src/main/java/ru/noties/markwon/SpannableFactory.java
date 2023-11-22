package ru.noties.markwon;

import java.util.List;
import ru.noties.markwon.renderer.ImageSize;
import ru.noties.markwon.renderer.ImageSizeResolver;
import ru.noties.markwon.spans.AsyncDrawable;
import ru.noties.markwon.spans.LinkSpan;
import ru.noties.markwon.spans.SpannableTheme;
import ru.noties.markwon.spans.TableRowSpan;

/* loaded from: classes6.dex */
public interface SpannableFactory {
    Object BuiltInFictitiousFunctionClassFactory();

    Object BuiltInFictitiousFunctionClassFactory(SpannableTheme spannableTheme, boolean z);

    Object KClassImpl$Data$declaredNonStaticMembers$2(SpannableTheme spannableTheme);

    Object KClassImpl$Data$declaredNonStaticMembers$2(SpannableTheme spannableTheme, int i);

    Object KClassImpl$Data$declaredNonStaticMembers$2(SpannableTheme spannableTheme, String str, AsyncDrawable.Loader loader, ImageSizeResolver imageSizeResolver, ImageSize imageSize, boolean z);

    Object KClassImpl$Data$declaredNonStaticMembers$2(SpannableTheme spannableTheme, String str, LinkSpan.Resolver resolver);

    Object MyBillsEntityDataFactory();

    Object MyBillsEntityDataFactory(SpannableTheme spannableTheme);

    Object PlaceComponentResult();

    Object PlaceComponentResult(SpannableTheme spannableTheme);

    Object PlaceComponentResult(SpannableTheme spannableTheme, int i);

    Object PlaceComponentResult(SpannableTheme spannableTheme, int i, boolean z);

    Object PlaceComponentResult(SpannableTheme spannableTheme, List<TableRowSpan.Cell> list, boolean z, boolean z2);

    Object getAuthRequestContext();

    Object getAuthRequestContext(SpannableTheme spannableTheme);

    Object getAuthRequestContext(SpannableTheme spannableTheme, int i);
}
