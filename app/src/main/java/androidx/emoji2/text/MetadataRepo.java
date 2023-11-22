package androidx.emoji2.text;

import android.graphics.Typeface;
import android.util.SparseArray;
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public final class MetadataRepo {
    final Typeface BuiltInFictitiousFunctionClassFactory;
    final Node MyBillsEntityDataFactory = new Node(1024);
    private final char[] PlaceComponentResult;
    final MetadataList getAuthRequestContext;

    private MetadataRepo(Typeface typeface, MetadataList metadataList) {
        int i;
        this.BuiltInFictitiousFunctionClassFactory = typeface;
        this.getAuthRequestContext = metadataList;
        this.PlaceComponentResult = new char[metadataList.BuiltInFictitiousFunctionClassFactory() * 2];
        int BuiltInFictitiousFunctionClassFactory = metadataList.BuiltInFictitiousFunctionClassFactory();
        for (int i2 = 0; i2 < BuiltInFictitiousFunctionClassFactory; i2++) {
            EmojiMetadata emojiMetadata = new EmojiMetadata(this, i2);
            Character.toChars(emojiMetadata.MyBillsEntityDataFactory().MyBillsEntityDataFactory(), this.PlaceComponentResult, i2 * 2);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(emojiMetadata, "emoji metadata cannot be null");
            Preconditions.MyBillsEntityDataFactory(emojiMetadata.MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory() > 0, "invalid metadata codepoint length");
            Node node = this.MyBillsEntityDataFactory;
            int BuiltInFictitiousFunctionClassFactory2 = emojiMetadata.MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory() - 1;
            while (true) {
                int MyBillsEntityDataFactory = emojiMetadata.MyBillsEntityDataFactory().MyBillsEntityDataFactory(i);
                SparseArray<Node> sparseArray = node.PlaceComponentResult;
                Node node2 = sparseArray == null ? null : sparseArray.get(MyBillsEntityDataFactory);
                if (node2 == null) {
                    node2 = new Node();
                    node.PlaceComponentResult.put(emojiMetadata.MyBillsEntityDataFactory().MyBillsEntityDataFactory(i), node2);
                }
                node = node2;
                i = BuiltInFictitiousFunctionClassFactory2 > i ? i + 1 : 0;
            }
            node.MyBillsEntityDataFactory = emojiMetadata;
        }
    }

    public static MetadataRepo BuiltInFictitiousFunctionClassFactory(Typeface typeface, ByteBuffer byteBuffer) throws IOException {
        try {
            TraceCompat.BuiltInFictitiousFunctionClassFactory("EmojiCompat.MetadataRepo.create");
            return new MetadataRepo(typeface, MetadataListReader.getAuthRequestContext(byteBuffer));
        } finally {
            TraceCompat.BuiltInFictitiousFunctionClassFactory();
        }
    }

    public final char[] MyBillsEntityDataFactory() {
        return this.PlaceComponentResult;
    }

    /* loaded from: classes6.dex */
    static class Node {
        EmojiMetadata MyBillsEntityDataFactory;
        final SparseArray<Node> PlaceComponentResult;

        Node() {
            this(1);
        }

        Node(int i) {
            this.PlaceComponentResult = new SparseArray<>(i);
        }
    }
}
