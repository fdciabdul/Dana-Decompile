package androidx.emoji.text;

import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.core.util.Preconditions;
import androidx.text.emoji.flatbuffer.MetadataList;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public final class MetadataRepo {
    final Node BuiltInFictitiousFunctionClassFactory;
    final MetadataList KClassImpl$Data$declaredNonStaticMembers$2;
    private final char[] MyBillsEntityDataFactory;
    final Typeface getAuthRequestContext;

    MetadataRepo() {
        this.getAuthRequestContext = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.BuiltInFictitiousFunctionClassFactory = new Node(1024);
        this.MyBillsEntityDataFactory = new char[0];
    }

    private MetadataRepo(Typeface typeface, MetadataList metadataList) {
        int i;
        this.getAuthRequestContext = typeface;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = metadataList;
        this.BuiltInFictitiousFunctionClassFactory = new Node(1024);
        this.MyBillsEntityDataFactory = new char[metadataList.BuiltInFictitiousFunctionClassFactory() * 2];
        int BuiltInFictitiousFunctionClassFactory = metadataList.BuiltInFictitiousFunctionClassFactory();
        for (int i2 = 0; i2 < BuiltInFictitiousFunctionClassFactory; i2++) {
            EmojiMetadata emojiMetadata = new EmojiMetadata(this, i2);
            Character.toChars(emojiMetadata.BuiltInFictitiousFunctionClassFactory().MyBillsEntityDataFactory(), this.MyBillsEntityDataFactory, i2 * 2);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(emojiMetadata, "emoji metadata cannot be null");
            Preconditions.MyBillsEntityDataFactory(emojiMetadata.BuiltInFictitiousFunctionClassFactory().KClassImpl$Data$declaredNonStaticMembers$2() > 0, "invalid metadata codepoint length");
            Node node = this.BuiltInFictitiousFunctionClassFactory;
            int KClassImpl$Data$declaredNonStaticMembers$2 = emojiMetadata.BuiltInFictitiousFunctionClassFactory().KClassImpl$Data$declaredNonStaticMembers$2() - 1;
            while (true) {
                int BuiltInFictitiousFunctionClassFactory2 = emojiMetadata.BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory(i);
                SparseArray<Node> sparseArray = node.BuiltInFictitiousFunctionClassFactory;
                Node node2 = sparseArray == null ? null : sparseArray.get(BuiltInFictitiousFunctionClassFactory2);
                if (node2 == null) {
                    node2 = new Node();
                    node.BuiltInFictitiousFunctionClassFactory.put(emojiMetadata.BuiltInFictitiousFunctionClassFactory().BuiltInFictitiousFunctionClassFactory(i), node2);
                }
                node = node2;
                i = KClassImpl$Data$declaredNonStaticMembers$2 > i ? i + 1 : 0;
            }
            node.getAuthRequestContext = emojiMetadata;
        }
    }

    public static MetadataRepo getAuthRequestContext(Typeface typeface, ByteBuffer byteBuffer) throws IOException {
        return new MetadataRepo(typeface, MetadataListReader.PlaceComponentResult(byteBuffer));
    }

    public final char[] MyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    /* loaded from: classes6.dex */
    static class Node {
        final SparseArray<Node> BuiltInFictitiousFunctionClassFactory;
        EmojiMetadata getAuthRequestContext;

        Node() {
            this(1);
        }

        Node(int i) {
            this.BuiltInFictitiousFunctionClassFactory = new SparseArray<>(i);
        }
    }
}
