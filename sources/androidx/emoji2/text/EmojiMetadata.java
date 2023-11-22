package androidx.emoji2.text;

import androidx.emoji2.text.flatbuffer.MetadataItem;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public class EmojiMetadata {
    private static final ThreadLocal<MetadataItem> PlaceComponentResult = new ThreadLocal<>();
    volatile int BuiltInFictitiousFunctionClassFactory = 0;
    final MetadataRepo KClassImpl$Data$declaredNonStaticMembers$2;
    final int getAuthRequestContext;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface HasGlyph {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmojiMetadata(MetadataRepo metadataRepo, int i) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = metadataRepo;
        this.getAuthRequestContext = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MetadataItem MyBillsEntityDataFactory() {
        ThreadLocal<MetadataItem> threadLocal = PlaceComponentResult;
        MetadataItem metadataItem = threadLocal.get();
        if (metadataItem == null) {
            metadataItem = new MetadataItem();
            threadLocal.set(metadataItem);
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(metadataItem, this.getAuthRequestContext);
        return metadataItem;
    }

    public final short KClassImpl$Data$declaredNonStaticMembers$2() {
        return MyBillsEntityDataFactory().moveToNextValue();
    }

    public final short PlaceComponentResult() {
        return MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public final short BuiltInFictitiousFunctionClassFactory() {
        return MyBillsEntityDataFactory().PlaceComponentResult();
    }

    public final boolean getAuthRequestContext() {
        return MyBillsEntityDataFactory().getAuthRequestContext();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        sb.append(Integer.toHexString(MyBillsEntityDataFactory().MyBillsEntityDataFactory()));
        sb.append(", codepoints:");
        int BuiltInFictitiousFunctionClassFactory = MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory();
        for (int i = 0; i < BuiltInFictitiousFunctionClassFactory; i++) {
            sb.append(Integer.toHexString(MyBillsEntityDataFactory().MyBillsEntityDataFactory(i)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
