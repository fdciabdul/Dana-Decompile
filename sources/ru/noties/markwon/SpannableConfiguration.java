package ru.noties.markwon;

import android.content.Context;
import ru.noties.markwon.html.api.MarkwonHtmlParser;
import ru.noties.markwon.html.impl.MarkwonHtmlParserImpl;
import ru.noties.markwon.renderer.ImageSizeResolver;
import ru.noties.markwon.renderer.ImageSizeResolverDef;
import ru.noties.markwon.renderer.html2.MarkwonHtmlRenderer;
import ru.noties.markwon.spans.AsyncDrawable;
import ru.noties.markwon.spans.LinkSpan;
import ru.noties.markwon.spans.SpannableTheme;

/* loaded from: classes6.dex */
public class SpannableConfiguration {
    public final MarkwonHtmlRenderer BuiltInFictitiousFunctionClassFactory;
    public final AsyncDrawable.Loader KClassImpl$Data$declaredNonStaticMembers$2;
    public final SpannableFactory MyBillsEntityDataFactory;
    private final boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final boolean NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final ImageSizeResolver PlaceComponentResult;
    public final MarkwonHtmlParser getAuthRequestContext;
    public final SyntaxHighlight getErrorConfigVersion;
    public final UrlProcessor lookAheadTest;
    public final LinkSpan.Resolver moveToNextValue;
    public final SpannableTheme scheduleImpl;

    /* synthetic */ SpannableConfiguration(Builder builder, byte b) {
        this(builder);
    }

    public static SpannableConfiguration BuiltInFictitiousFunctionClassFactory(Context context) {
        return new Builder(context).KClassImpl$Data$declaredNonStaticMembers$2();
    }

    private SpannableConfiguration(Builder builder) {
        this.scheduleImpl = builder.NetworkUserEntityData$$ExternalSyntheticLambda2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = builder.PlaceComponentResult;
        this.getErrorConfigVersion = builder.NetworkUserEntityData$$ExternalSyntheticLambda0;
        this.moveToNextValue = builder.moveToNextValue;
        this.lookAheadTest = builder.NetworkUserEntityData$$ExternalSyntheticLambda1;
        this.PlaceComponentResult = builder.scheduleImpl;
        this.MyBillsEntityDataFactory = builder.MyBillsEntityDataFactory;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = builder.lookAheadTest;
        this.getAuthRequestContext = builder.BuiltInFictitiousFunctionClassFactory;
        this.BuiltInFictitiousFunctionClassFactory = builder.getErrorConfigVersion;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = builder.getAuthRequestContext;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }

    public final boolean PlaceComponentResult() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda0;
    }

    /* loaded from: classes6.dex */
    public static class Builder {
        private MarkwonHtmlParser BuiltInFictitiousFunctionClassFactory;
        private final Context KClassImpl$Data$declaredNonStaticMembers$2;
        private SpannableFactory MyBillsEntityDataFactory;
        private SyntaxHighlight NetworkUserEntityData$$ExternalSyntheticLambda0;
        private UrlProcessor NetworkUserEntityData$$ExternalSyntheticLambda1;
        private SpannableTheme NetworkUserEntityData$$ExternalSyntheticLambda2;
        private AsyncDrawable.Loader PlaceComponentResult;
        private boolean getAuthRequestContext;
        private MarkwonHtmlRenderer getErrorConfigVersion;
        private boolean lookAheadTest;
        private LinkSpan.Resolver moveToNextValue;
        private ImageSizeResolver scheduleImpl;

        Builder(Context context) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        }

        public final SpannableConfiguration KClassImpl$Data$declaredNonStaticMembers$2() {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda2 == null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = SpannableTheme.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2);
            }
            if (this.PlaceComponentResult == null) {
                this.PlaceComponentResult = new AsyncDrawableLoaderNoOp();
            }
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new SyntaxHighlightNoOp();
            }
            if (this.moveToNextValue == null) {
                this.moveToNextValue = new LinkResolverDef();
            }
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda1 == null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new UrlProcessorNoOp();
            }
            if (this.scheduleImpl == null) {
                this.scheduleImpl = new ImageSizeResolverDef();
            }
            if (this.MyBillsEntityDataFactory == null) {
                this.MyBillsEntityDataFactory = SpannableFactoryDef.KClassImpl$Data$declaredNonStaticMembers$2();
            }
            if (this.BuiltInFictitiousFunctionClassFactory == null) {
                try {
                    this.BuiltInFictitiousFunctionClassFactory = MarkwonHtmlParserImpl.PlaceComponentResult();
                } catch (Throwable unused) {
                    this.BuiltInFictitiousFunctionClassFactory = MarkwonHtmlParser.getAuthRequestContext();
                }
            }
            if (this.getErrorConfigVersion == null) {
                this.getErrorConfigVersion = MarkwonHtmlRenderer.KClassImpl$Data$declaredNonStaticMembers$2();
            }
            return new SpannableConfiguration(this, (byte) 0);
        }
    }
}
