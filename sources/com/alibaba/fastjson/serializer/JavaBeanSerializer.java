package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class JavaBeanSerializer implements ObjectSerializer {
    protected int features;
    private final FieldSerializer[] getters;
    private final FieldSerializer[] sortedGetters;
    protected final String typeKey;
    protected final String typeName;
    private static final char[] true_chars = {'t', 'r', 'u', 'e'};
    private static final char[] false_chars = {'f', 'a', 'l', 's', 'e'};

    public JavaBeanSerializer(Class<?> cls) {
        this(cls, (PropertyNamingStrategy) null);
    }

    public JavaBeanSerializer(Class<?> cls, PropertyNamingStrategy propertyNamingStrategy) {
        this(cls, cls.getModifiers(), null, false, true, true, true, propertyNamingStrategy);
    }

    public JavaBeanSerializer(Class<?> cls, String... strArr) {
        this(cls, cls.getModifiers(), map(strArr), false, true, true, true, null);
    }

    private static Map<String, String> map(String... strArr) {
        HashMap hashMap = new HashMap();
        for (String str : strArr) {
            hashMap.put(str, str);
        }
        return hashMap;
    }

    public JavaBeanSerializer(Class<?> cls, int i, Map<String, String> map, boolean z, boolean z2, boolean z3, boolean z4, PropertyNamingStrategy propertyNamingStrategy) {
        PropertyNamingStrategy propertyNamingStrategy2;
        String str;
        String str2;
        PropertyNamingStrategy naming;
        this.features = 0;
        JSONType jSONType = z2 ? (JSONType) cls.getAnnotation(JSONType.class) : null;
        if (jSONType != null) {
            this.features = SerializerFeature.of(jSONType.serialzeFeatures());
            str = jSONType.typeName();
            if (str.length() == 0) {
                str = null;
                str2 = null;
            } else {
                str2 = null;
                for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null && superclass != Object.class; superclass = superclass.getSuperclass()) {
                    JSONType jSONType2 = (JSONType) superclass.getAnnotation(JSONType.class);
                    if (jSONType2 == null) {
                        break;
                    }
                    str2 = jSONType2.typeKey();
                    if (str2.length() != 0) {
                        break;
                    }
                }
                for (Class<?> cls2 : cls.getInterfaces()) {
                    JSONType jSONType3 = (JSONType) cls2.getAnnotation(JSONType.class);
                    if (jSONType3 != null) {
                        str2 = jSONType3.typeKey();
                        if (str2.length() != 0) {
                            break;
                        }
                    }
                }
                if (str2 != null && str2.length() == 0) {
                    str2 = null;
                }
            }
            propertyNamingStrategy2 = (propertyNamingStrategy != null || (naming = jSONType.naming()) == PropertyNamingStrategy.CamelCase) ? propertyNamingStrategy : naming;
        } else {
            propertyNamingStrategy2 = propertyNamingStrategy;
            str = null;
            str2 = null;
        }
        this.typeName = str;
        this.typeKey = str2;
        List<FieldInfo> computeGetters = TypeUtils.computeGetters(cls, i, z, jSONType, map, false, z3, z4, propertyNamingStrategy2);
        ArrayList arrayList = new ArrayList();
        Iterator<FieldInfo> it = computeGetters.iterator();
        while (it.hasNext()) {
            arrayList.add(new FieldSerializer(it.next()));
        }
        FieldSerializer[] fieldSerializerArr = (FieldSerializer[]) arrayList.toArray(new FieldSerializer[arrayList.size()]);
        this.getters = fieldSerializerArr;
        String[] orders = jSONType != null ? jSONType.orders() : null;
        if (orders != null && orders.length != 0) {
            List<FieldInfo> computeGetters2 = TypeUtils.computeGetters(cls, i, z, jSONType, map, true, z3, z4, propertyNamingStrategy2);
            ArrayList arrayList2 = new ArrayList();
            Iterator<FieldInfo> it2 = computeGetters2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(new FieldSerializer(it2.next()));
            }
            this.sortedGetters = (FieldSerializer[]) arrayList2.toArray(new FieldSerializer[arrayList2.size()]);
            return;
        }
        FieldSerializer[] fieldSerializerArr2 = new FieldSerializer[fieldSerializerArr.length];
        System.arraycopy(fieldSerializerArr, 0, fieldSerializerArr2, 0, fieldSerializerArr.length);
        Arrays.sort(fieldSerializerArr2);
        if (Arrays.equals(fieldSerializerArr2, fieldSerializerArr)) {
            this.sortedGetters = fieldSerializerArr;
        } else {
            this.sortedGetters = fieldSerializerArr2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:577:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:578:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:581:0x011d A[Catch: all -> 0x009f, Exception -> 0x00a3, TRY_ENTER, TryCatch #6 {Exception -> 0x00a3, all -> 0x009f, blocks: (B:534:0x0092, B:536:0x0096, B:537:0x009a, B:545:0x00b2, B:547:0x00bb, B:551:0x00ca, B:554:0x00d5, B:556:0x00de, B:558:0x00e2, B:564:0x00ee, B:566:0x00f4, B:568:0x00f8, B:569:0x00fc, B:571:0x0103, B:572:0x010b, B:581:0x011d, B:582:0x0123, B:584:0x0129, B:592:0x0142), top: B:971:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:587:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:588:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:592:0x0142 A[Catch: all -> 0x009f, Exception -> 0x00a3, TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x00a3, all -> 0x009f, blocks: (B:534:0x0092, B:536:0x0096, B:537:0x009a, B:545:0x00b2, B:547:0x00bb, B:551:0x00ca, B:554:0x00d5, B:556:0x00de, B:558:0x00e2, B:564:0x00ee, B:566:0x00f4, B:568:0x00f8, B:569:0x00fc, B:571:0x0103, B:572:0x010b, B:581:0x011d, B:582:0x0123, B:584:0x0129, B:592:0x0142), top: B:971:0x0092 }] */
    /* JADX WARN: Removed duplicated region for block: B:601:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:602:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:605:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:606:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:652:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:671:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:674:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:782:0x03d5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:809:0x0414 A[Catch: all -> 0x05ac, Exception -> 0x05af, TryCatch #9 {Exception -> 0x05af, all -> 0x05ac, blocks: (B:612:0x0180, B:614:0x019b, B:616:0x019f, B:619:0x01a4, B:621:0x01a8, B:625:0x01b1, B:626:0x01b5, B:628:0x01bb, B:636:0x01d9, B:638:0x01e0, B:640:0x01e4, B:653:0x0233, B:655:0x0239, B:664:0x0254, B:665:0x0258, B:667:0x025e, B:677:0x027e, B:679:0x0282, B:680:0x0287, B:682:0x028b, B:683:0x0290, B:685:0x0294, B:687:0x029a, B:688:0x02a1, B:690:0x02a7, B:695:0x02c1, B:697:0x02c5, B:699:0x02cb, B:701:0x02cf, B:702:0x02d4, B:704:0x02d8, B:706:0x02df, B:707:0x02e6, B:709:0x02ec, B:717:0x030b, B:719:0x0319, B:721:0x0326, B:723:0x032a, B:726:0x0331, B:728:0x0335, B:784:0x03d9, B:786:0x03dd, B:788:0x03e1, B:790:0x03e5, B:792:0x03e9, B:794:0x03ed, B:801:0x0400, B:803:0x0404, B:805:0x0408, B:796:0x03f1, B:798:0x03f5, B:809:0x0414, B:811:0x041d, B:813:0x0421, B:814:0x0425, B:815:0x0429, B:817:0x043c, B:821:0x0446, B:822:0x044a, B:825:0x0453, B:826:0x0456, B:829:0x045f, B:831:0x046a, B:833:0x046e, B:835:0x0473, B:839:0x0493, B:840:0x049d, B:843:0x04a4, B:847:0x04ae, B:852:0x04ba, B:854:0x04c0, B:856:0x04c4, B:857:0x04c6, B:859:0x04ce, B:861:0x04d2, B:862:0x04d6, B:865:0x04e5, B:866:0x04ee, B:867:0x04f1, B:869:0x04f5, B:870:0x04fd, B:873:0x0503, B:874:0x050d, B:879:0x051f, B:881:0x0525, B:883:0x052e, B:886:0x0537, B:887:0x053b, B:888:0x053f, B:890:0x0543, B:891:0x0547, B:892:0x054d, B:895:0x0553, B:897:0x055c, B:902:0x0570, B:903:0x0574, B:904:0x0579, B:905:0x0584, B:906:0x0589, B:907:0x058e, B:730:0x033a, B:733:0x0344, B:735:0x034f, B:737:0x0353, B:740:0x035a, B:742:0x035d, B:745:0x0365, B:747:0x036d, B:749:0x0378, B:751:0x037c, B:754:0x0383, B:756:0x0386, B:758:0x038b, B:759:0x0391, B:761:0x0399, B:763:0x03a4, B:765:0x03a8, B:768:0x03ae, B:770:0x03b1, B:772:0x03b6, B:774:0x03bd, B:776:0x03c1, B:656:0x023e, B:658:0x0242, B:659:0x0247, B:661:0x024b, B:641:0x01f4, B:643:0x01f8, B:644:0x0204, B:646:0x0208, B:647:0x0218, B:648:0x021f, B:920:0x05c1, B:921:0x05c7, B:923:0x05cd, B:928:0x05df, B:930:0x05e8, B:933:0x05f7, B:935:0x05fb, B:936:0x05ff), top: B:966:0x0180 }] */
    /* JADX WARN: Removed duplicated region for block: B:818:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:820:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:823:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:865:0x04e5 A[Catch: all -> 0x05ac, Exception -> 0x05af, TryCatch #9 {Exception -> 0x05af, all -> 0x05ac, blocks: (B:612:0x0180, B:614:0x019b, B:616:0x019f, B:619:0x01a4, B:621:0x01a8, B:625:0x01b1, B:626:0x01b5, B:628:0x01bb, B:636:0x01d9, B:638:0x01e0, B:640:0x01e4, B:653:0x0233, B:655:0x0239, B:664:0x0254, B:665:0x0258, B:667:0x025e, B:677:0x027e, B:679:0x0282, B:680:0x0287, B:682:0x028b, B:683:0x0290, B:685:0x0294, B:687:0x029a, B:688:0x02a1, B:690:0x02a7, B:695:0x02c1, B:697:0x02c5, B:699:0x02cb, B:701:0x02cf, B:702:0x02d4, B:704:0x02d8, B:706:0x02df, B:707:0x02e6, B:709:0x02ec, B:717:0x030b, B:719:0x0319, B:721:0x0326, B:723:0x032a, B:726:0x0331, B:728:0x0335, B:784:0x03d9, B:786:0x03dd, B:788:0x03e1, B:790:0x03e5, B:792:0x03e9, B:794:0x03ed, B:801:0x0400, B:803:0x0404, B:805:0x0408, B:796:0x03f1, B:798:0x03f5, B:809:0x0414, B:811:0x041d, B:813:0x0421, B:814:0x0425, B:815:0x0429, B:817:0x043c, B:821:0x0446, B:822:0x044a, B:825:0x0453, B:826:0x0456, B:829:0x045f, B:831:0x046a, B:833:0x046e, B:835:0x0473, B:839:0x0493, B:840:0x049d, B:843:0x04a4, B:847:0x04ae, B:852:0x04ba, B:854:0x04c0, B:856:0x04c4, B:857:0x04c6, B:859:0x04ce, B:861:0x04d2, B:862:0x04d6, B:865:0x04e5, B:866:0x04ee, B:867:0x04f1, B:869:0x04f5, B:870:0x04fd, B:873:0x0503, B:874:0x050d, B:879:0x051f, B:881:0x0525, B:883:0x052e, B:886:0x0537, B:887:0x053b, B:888:0x053f, B:890:0x0543, B:891:0x0547, B:892:0x054d, B:895:0x0553, B:897:0x055c, B:902:0x0570, B:903:0x0574, B:904:0x0579, B:905:0x0584, B:906:0x0589, B:907:0x058e, B:730:0x033a, B:733:0x0344, B:735:0x034f, B:737:0x0353, B:740:0x035a, B:742:0x035d, B:745:0x0365, B:747:0x036d, B:749:0x0378, B:751:0x037c, B:754:0x0383, B:756:0x0386, B:758:0x038b, B:759:0x0391, B:761:0x0399, B:763:0x03a4, B:765:0x03a8, B:768:0x03ae, B:770:0x03b1, B:772:0x03b6, B:774:0x03bd, B:776:0x03c1, B:656:0x023e, B:658:0x0242, B:659:0x0247, B:661:0x024b, B:641:0x01f4, B:643:0x01f8, B:644:0x0204, B:646:0x0208, B:647:0x0218, B:648:0x021f, B:920:0x05c1, B:921:0x05c7, B:923:0x05cd, B:928:0x05df, B:930:0x05e8, B:933:0x05f7, B:935:0x05fb, B:936:0x05ff), top: B:966:0x0180 }] */
    /* JADX WARN: Removed duplicated region for block: B:917:0x05bb  */
    /* JADX WARN: Removed duplicated region for block: B:928:0x05df A[Catch: all -> 0x05ac, Exception -> 0x05af, TRY_ENTER, TryCatch #9 {Exception -> 0x05af, all -> 0x05ac, blocks: (B:612:0x0180, B:614:0x019b, B:616:0x019f, B:619:0x01a4, B:621:0x01a8, B:625:0x01b1, B:626:0x01b5, B:628:0x01bb, B:636:0x01d9, B:638:0x01e0, B:640:0x01e4, B:653:0x0233, B:655:0x0239, B:664:0x0254, B:665:0x0258, B:667:0x025e, B:677:0x027e, B:679:0x0282, B:680:0x0287, B:682:0x028b, B:683:0x0290, B:685:0x0294, B:687:0x029a, B:688:0x02a1, B:690:0x02a7, B:695:0x02c1, B:697:0x02c5, B:699:0x02cb, B:701:0x02cf, B:702:0x02d4, B:704:0x02d8, B:706:0x02df, B:707:0x02e6, B:709:0x02ec, B:717:0x030b, B:719:0x0319, B:721:0x0326, B:723:0x032a, B:726:0x0331, B:728:0x0335, B:784:0x03d9, B:786:0x03dd, B:788:0x03e1, B:790:0x03e5, B:792:0x03e9, B:794:0x03ed, B:801:0x0400, B:803:0x0404, B:805:0x0408, B:796:0x03f1, B:798:0x03f5, B:809:0x0414, B:811:0x041d, B:813:0x0421, B:814:0x0425, B:815:0x0429, B:817:0x043c, B:821:0x0446, B:822:0x044a, B:825:0x0453, B:826:0x0456, B:829:0x045f, B:831:0x046a, B:833:0x046e, B:835:0x0473, B:839:0x0493, B:840:0x049d, B:843:0x04a4, B:847:0x04ae, B:852:0x04ba, B:854:0x04c0, B:856:0x04c4, B:857:0x04c6, B:859:0x04ce, B:861:0x04d2, B:862:0x04d6, B:865:0x04e5, B:866:0x04ee, B:867:0x04f1, B:869:0x04f5, B:870:0x04fd, B:873:0x0503, B:874:0x050d, B:879:0x051f, B:881:0x0525, B:883:0x052e, B:886:0x0537, B:887:0x053b, B:888:0x053f, B:890:0x0543, B:891:0x0547, B:892:0x054d, B:895:0x0553, B:897:0x055c, B:902:0x0570, B:903:0x0574, B:904:0x0579, B:905:0x0584, B:906:0x0589, B:907:0x058e, B:730:0x033a, B:733:0x0344, B:735:0x034f, B:737:0x0353, B:740:0x035a, B:742:0x035d, B:745:0x0365, B:747:0x036d, B:749:0x0378, B:751:0x037c, B:754:0x0383, B:756:0x0386, B:758:0x038b, B:759:0x0391, B:761:0x0399, B:763:0x03a4, B:765:0x03a8, B:768:0x03ae, B:770:0x03b1, B:772:0x03b6, B:774:0x03bd, B:776:0x03c1, B:656:0x023e, B:658:0x0242, B:659:0x0247, B:661:0x024b, B:641:0x01f4, B:643:0x01f8, B:644:0x0204, B:646:0x0208, B:647:0x0218, B:648:0x021f, B:920:0x05c1, B:921:0x05c7, B:923:0x05cd, B:928:0x05df, B:930:0x05e8, B:933:0x05f7, B:935:0x05fb, B:936:0x05ff), top: B:966:0x0180 }] */
    /* JADX WARN: Removed duplicated region for block: B:933:0x05f7 A[Catch: all -> 0x05ac, Exception -> 0x05af, TRY_ENTER, TryCatch #9 {Exception -> 0x05af, all -> 0x05ac, blocks: (B:612:0x0180, B:614:0x019b, B:616:0x019f, B:619:0x01a4, B:621:0x01a8, B:625:0x01b1, B:626:0x01b5, B:628:0x01bb, B:636:0x01d9, B:638:0x01e0, B:640:0x01e4, B:653:0x0233, B:655:0x0239, B:664:0x0254, B:665:0x0258, B:667:0x025e, B:677:0x027e, B:679:0x0282, B:680:0x0287, B:682:0x028b, B:683:0x0290, B:685:0x0294, B:687:0x029a, B:688:0x02a1, B:690:0x02a7, B:695:0x02c1, B:697:0x02c5, B:699:0x02cb, B:701:0x02cf, B:702:0x02d4, B:704:0x02d8, B:706:0x02df, B:707:0x02e6, B:709:0x02ec, B:717:0x030b, B:719:0x0319, B:721:0x0326, B:723:0x032a, B:726:0x0331, B:728:0x0335, B:784:0x03d9, B:786:0x03dd, B:788:0x03e1, B:790:0x03e5, B:792:0x03e9, B:794:0x03ed, B:801:0x0400, B:803:0x0404, B:805:0x0408, B:796:0x03f1, B:798:0x03f5, B:809:0x0414, B:811:0x041d, B:813:0x0421, B:814:0x0425, B:815:0x0429, B:817:0x043c, B:821:0x0446, B:822:0x044a, B:825:0x0453, B:826:0x0456, B:829:0x045f, B:831:0x046a, B:833:0x046e, B:835:0x0473, B:839:0x0493, B:840:0x049d, B:843:0x04a4, B:847:0x04ae, B:852:0x04ba, B:854:0x04c0, B:856:0x04c4, B:857:0x04c6, B:859:0x04ce, B:861:0x04d2, B:862:0x04d6, B:865:0x04e5, B:866:0x04ee, B:867:0x04f1, B:869:0x04f5, B:870:0x04fd, B:873:0x0503, B:874:0x050d, B:879:0x051f, B:881:0x0525, B:883:0x052e, B:886:0x0537, B:887:0x053b, B:888:0x053f, B:890:0x0543, B:891:0x0547, B:892:0x054d, B:895:0x0553, B:897:0x055c, B:902:0x0570, B:903:0x0574, B:904:0x0579, B:905:0x0584, B:906:0x0589, B:907:0x058e, B:730:0x033a, B:733:0x0344, B:735:0x034f, B:737:0x0353, B:740:0x035a, B:742:0x035d, B:745:0x0365, B:747:0x036d, B:749:0x0378, B:751:0x037c, B:754:0x0383, B:756:0x0386, B:758:0x038b, B:759:0x0391, B:761:0x0399, B:763:0x03a4, B:765:0x03a8, B:768:0x03ae, B:770:0x03b1, B:772:0x03b6, B:774:0x03bd, B:776:0x03c1, B:656:0x023e, B:658:0x0242, B:659:0x0247, B:661:0x024b, B:641:0x01f4, B:643:0x01f8, B:644:0x0204, B:646:0x0208, B:647:0x0218, B:648:0x021f, B:920:0x05c1, B:921:0x05c7, B:923:0x05cd, B:928:0x05df, B:930:0x05e8, B:933:0x05f7, B:935:0x05fb, B:936:0x05ff), top: B:966:0x0180 }] */
    /* JADX WARN: Removed duplicated region for block: B:964:0x0631 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:966:0x0180 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:974:0x05b2 A[EDGE_INSN: B:974:0x05b2->B:914:0x05b2 BREAK  A[LOOP:1: B:609:0x017b->B:909:0x0594], SYNTHETIC] */
    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void write(com.alibaba.fastjson.serializer.JSONSerializer r37, java.lang.Object r38, java.lang.Object r39, java.lang.reflect.Type r40) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1618
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.JavaBeanSerializer.write(com.alibaba.fastjson.serializer.JSONSerializer, java.lang.Object, java.lang.Object, java.lang.reflect.Type):void");
    }

    public Map<String, Object> getFieldValuesMap(Object obj) throws Exception {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            linkedHashMap.put(fieldSerializer.fieldInfo.name, fieldSerializer.getPropertyValue(obj));
        }
        return linkedHashMap;
    }
}
