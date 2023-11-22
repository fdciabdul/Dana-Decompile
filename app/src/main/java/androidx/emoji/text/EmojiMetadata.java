package androidx.emoji.text;

import androidx.text.emoji.flatbuffer.MetadataItem;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes6.dex */
public class EmojiMetadata {
    private static final ThreadLocal<MetadataItem> KClassImpl$Data$declaredNonStaticMembers$2 = new ThreadLocal<>();
    final MetadataRepo BuiltInFictitiousFunctionClassFactory;
    final int MyBillsEntityDataFactory;
    volatile int PlaceComponentResult = 0;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface HasGlyph {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmojiMetadata(MetadataRepo metadataRepo, int i) {
        this.BuiltInFictitiousFunctionClassFactory = metadataRepo;
        this.MyBillsEntityDataFactory = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MetadataItem BuiltInFictitiousFunctionClassFactory() {
        ThreadLocal<MetadataItem> threadLocal = KClassImpl$Data$declaredNonStaticMembers$2;
        MetadataItem metadataItem = threadLocal.get();
        if (metadataItem == null) {
            metadataItem = new MetadataItem();
            threadLocal.set(metadataItem);
        }
        this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(metadataItem, this.MyBillsEntityDataFactory);
        return metadataItem;
    }

    public final short PlaceComponentResult() {
        return BuiltInFictitiousFunctionClassFactory().NetworkUserEntityData$$ExternalSyntheticLambda0();
    }

    public final short MyBillsEntityDataFactory() {
        return BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory();
    }

    public final short KClassImpl$Data$declaredNonStaticMembers$2() {
        return BuiltInFictitiousFunctionClassFactory().getAuthRequestContext();
    }

    public final boolean getAuthRequestContext() {
        return BuiltInFictitiousFunctionClassFactory().PlaceComponentResult();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        sb.append(Integer.toHexString(BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory()));
        sb.append(", codepoints:");
        int KClassImpl$Data$declaredNonStaticMembers$22 = BuiltInFictitiousFunctionClassFactory().KClassImpl$Data$declaredNonStaticMembers$2();
        for (int i = 0; i < KClassImpl$Data$declaredNonStaticMembers$22; i++) {
            sb.append(Integer.toHexString(BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory(i)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
