package io.split.android.client.utils;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import io.split.android.client.utils.logger.Logger;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import o.C;

/* loaded from: classes6.dex */
public class BCrypt {
    private static int $10 = 0;
    private static int $11 = 1;
    public static final int BCRYPT_SALT_LEN = 16;
    private static final int BLOWFISH_NUM_ROUNDS = 16;
    private static char BuiltInFictitiousFunctionClassFactory = 0;
    private static final int GENSALT_DEFAULT_LOG2_ROUNDS = 10;
    private static char KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static char MyBillsEntityDataFactory = 0;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
    private static final int[] P_orig;
    private static char PlaceComponentResult;
    private static final int[] S_orig;
    private static final char[] base64_code;
    private static final int[] bf_crypt_ciphertext;
    private static int getAuthRequestContext;
    private static final byte[] index_64;
    private int[] P;
    private int[] S;

    static void BuiltInFictitiousFunctionClassFactory() {
        PlaceComponentResult = (char) 61839;
        KClassImpl$Data$declaredNonStaticMembers$2 = (char) 23622;
        MyBillsEntityDataFactory = (char) 42796;
        BuiltInFictitiousFunctionClassFactory = (char) 16283;
    }

    static {
        BuiltInFictitiousFunctionClassFactory();
        P_orig = new int[]{608135816, -2052912941, 320440878, 57701188, -1542899678, 698298832, 137296536, -330404727, 1160258022, 953160567, -1101764913, 887688300, -1062458953, -914599715, 1065670069, -1253635817, -1843997223, -1988494565};
        int[] iArr = new int[1024];
        int[] iArr2 = new int[1024];
        ByteBuffer.wrap("Ñ1\u000b¦\u0098ßµ¬/ýrÛÐ\u001aß·¸á¯íj&~\u0096º|\u0090Eñ,\u007f\u0099$¡\u0099G³\u0091l÷\b\u0001òâ\u0085\u008eü\u0016ci ØqWNi¤Xþ£ô\u0093=~\r\u0095t\u008fr\u008e¶Xq\u008bÍX\u0082\u0015Jî{T¤\u001dÂZYµ\u009c0Õ9*ò`\u0013ÅÑ°#(`\u0085ðÊAy\u0018¸Û8ï\u008eyÜ°`:\u0018\u000el\u009e\u000e\u008b°\u001e\u008a>×\u0015wÁ½1K'x¯/ÚU`\\`æU%óªU«\u0094WH\u0098bcè\u0014@UÊ9j*«\u0010¶´Ì\\4\u0011AèÎ¡T\u0086¯|ré\u0093³î\u0014\u0011co¼*+©Å]t\u00181öÎ\\>\u0016\u009b\u0087\u0093\u001e¯Öº3l$Ï\\z2S\u0081(\u0095\u0086w;\u008fH\u0098kK¹¯Ä¿è\u001bf(!\u0093aØ\tÌû!©\u0091H|¬`]ì\u00802ï\u0084]]é\u0085u±Ü&#\u0002ëe\u001b\u0088#\u0089>\u0081Ó\u0096¬Å\u000fmoó\u0083ôB9.\u000bD\u0082¤\u0084 \u0004iÈðJ\u009e\u001f\u009b^!ÆhBöél\u009ag\f\u009ca«Ó\u0088ðjQ ÒØT/h\u0096\u000f§(«Q3£nï\u000bl\u0013z;äº;ðP~û*\u0098¡ñe\u001d9¯\u0001vfÊY>\u0082C\u000e\u0088\u008cî\u0086\u0019Eo\u009f´}\u0084¥Ã;\u008b^¾àouØ\u0085Á s@\u001aD\u009fVÁj¦NÓªb6?w\u0006\u001bþßrB\u009b\u0002=7Ð×$Ð\n\u0012HÛ\u000fêÓIñÀ\u009b\u0007SrÉ\u0080\u0099\u001b{%ÔyØöèÞ÷ãþP\u001a¶yL;\u0097là½\u0004À\u0006ºÁ©O¶@\u009f`Ä^\\\u009eÂ\u0019j$chûo¯>lSµ\u00139²ë;RìomüQ\u001f\u009b0\u0095,Ì\u0081ED¯^½\t¾ãÐ\u0004Þ3Jýf\u000f(\u0007\u0019.K³ÀË¨WEÈt\u000fÒ\u000b_9¹ÓûÛUyÀ½\u001a`2\nÖ¡\u0000Æ@,ryg\u009f%þû\u001f£Ì\u008e¥éøÛ2\"ø<u\u0016ßýak\u0015/P\u001eÈ\u00ad\u0005R«2=µúý#\u0087`S1{H>\u0000ß\u0082\u009e\\W»Êo\u008c \u001a\u0087V.ß\u0017iÛÕB¨ö(~ÿÃ¬g2Æ\u008cOUsi['°»ÊXÈáÿ£]¸ð\u0011 \u0010ú=\u0098ý!\u0083¸Jüµl-ÑÓ[\u009aSäy¶øEeÒ\u008eI¼Kû\u0097\u0090áÝòÚ¤Ë~3bû\u0013AÎäÆèï ÊÚ6wL\u0001Ð~\u009eþ+ñ\u001f´\u0095ÛÚM®\u0090\u0091\u0098ê\u00ad\u008eqk\u0093Õ Ð\u008eÑÐ¯Ç%à\u008e<[/\u008eu\u0094·\u008föâûò\u0012+d\u0088\u0088¸\u0012\u0090\rð\u001cO\u00ad^ h\u008fÃ\u001cÑÏñ\u0091³¨Á\u00ad//\"\u0018¾\u000e\u0017wêu-þ\u008b\u0002\u001f¡å Ì\u000fµotè\u0018¬óÖÎ\u0089â\u0099´¨Oàý\u0013à·|Ä;\u0081Ò\u00ad¨Ù\u0016_¢f\u0080\u0095w\u0005\u0093Ìs\u0014!\u001a\u0014wæ\u00ad ewµú\u0086ÇTBõû\u009d5ÏëÍ¯\f{>\u0089 ÖA\u001bÓ®\u001e~I\u0000%\u000e- q³^\"h\u0000»W¸à¯$d6\u009bð\t¹\u001eUc\u0091\u001dYß¦ªxÁC\u0089ÙZS\u007f }[¢\u0002å¹Å\u0083&\u0003vb\u0095Ï©\u0011È\u0019hNsJA³G-Ê{\u0014©J\u001bQ\u0000R\u009aS)\u0015Ö\u000fW?¼\u009bÆä+`¤v\u0081æt\u0000\bºoµW\u001bé\u001fò\u0096ìk*\rÙ\u0015¶ce!ç¹ù¶ÿ4\u0005.Å\u0085VdS°-]©\u009f\u008f¡\bºG\u0099n\u0085\u0007jKzpéµ³)DÛu\t.Ä\u0019&#\u00adn¦°I§ß}\u009cî`¸\u008fí²fìª\u008cqi\u009a\u0017ÿVdRlÂ±\u009eá\u00196\u0002¥u\tL) Y\u0013@ä\u0018:>?T\u0098\u009a[B\u009dek\u008fäÖ\u0099÷?Ö¡Ò\u009c\u0007ïè0õM-8æð%]ÁLÝ \u0086\u0084pë&c\u0082éÆ\u0002\u001eÌ^\thk?>ºïÉ<\u0097\u0018\u0014kjp¡h\u007f5\u0084R â\u0086·\u009cS\u0005ªP\u00077>\u0007\u0084\u001c\u007fÞ®\\\u008e}DìW\u0016ò¸°:Ú7ðP\f\rð\u001c\u001f\u0004\u0002\u0000³ÿ®\fõ\u001a<µt²%\u0083zXÜ\t!½Ñ\u0091\u0013ù|©/ö\u00942Gs\"õG\u0001:åå\u00817ÂÚÜÈµv4\u009aóÝ§©DaF\u000fÐ\u0003\u000eìÈÇ>¤u\u001eAâ8Í\u0099;ê\u000e/2\u0080»¡\u0018>³1NT\u008b8Om¹\boB\r\u0003ö\n\u0004¿,¸\u0012\u0090$\u0097|yVy°r¼¯\u0089¯Þ\u009aw\u001fÙ\u0093\b\u0010³\u008b®\u0012ÜÏ?.U\u0012r\u001f.kq$P\u001aÝæ\u009f\u0084Í\u0087zXG\u0018t\bÚ\u0017¼\u009f\u009a¼éK}\u008cìzì:Û\u0085\u001dúc\tCfÄdÃÒï\u001c\u0018G2\u0015Ù\bÝC;7$Âº\u0016\u0012¡MC*eÄQP\u0094\u0000\u0002\u0013:äÝqßø\u009e\u00101NU\u0081¬wÖ_\u0011\u0019\u009b\u00045Vñ×£Çk<\u0011\u0018;Y$¥\tò\u008fæí\u0097ñûú\u009eº¿,\u001e\u0015<n\u0086ãEpêéo±\u0086\u000e^\nZ>*³w\u001fç\u001cN=\u0006ú)eÜ¹\u0099ç\u001d\u000f\u0080>\u0089ÖRfÈ%.LÉx\u009c\u0010³jÆ\u0015\u000eº\u0094âêx¥ü<S\u001e\n-ôò÷N§6\u001d+=\u00199&\u000f\u0019Ây`R#§\b÷\u0013\u0012¶ë\u00adþnêÃ\u001ffã¼E\u0095¦{È\u0083±\u007f7Ñ\u0001\u008cÿ(Ã2Ýï¾lZ¥eX!\u0085h«\u0098\u0002îÎ¥\u000fÛ/\u0095;*ï}\u00ad[n/\u0084\u0015!¶()\u0007apìÝGua\u009f\u0015\u0010\u0013Ì¨0ëa½\u0096\u00034þ\u001eª\u0003cÏµs\\\u0090Lp¢9Õ\u009e\u009e\u000bËªÞ\u0014îÌ\u0086¼`b,§\u009c«\\«²ó\u0084nd\u008b\u001e¯\u0019½ðÊ #i¹eZ»P@hZ2<*´³1\u009eéÕÀ!¸÷\u009bT\u000b\u0019\u0087_ \u0099\u0095÷\u0099~b=}¨ø7\u0088\u009a\u0097ã-w\u0011í\u0093_\u0016h\u0012\u0081\u000e5\u0088)Çæ\u001fÖ\u0096Þß¡xXº\u0099Wõ\u0084¥\u001b\"rc\u009b\u0083Ãÿ\u001aÂF\u0096Í³\nëS.0T\u008fÙHäm¼1(Xëòï4Æÿêþ(íaî|<s]J\u0014Ùèd·ãB\u0010]\u0014 >\u0013àEîâ¶£ª«êÛlO\u0015úËOÐÇBôBïj»µeO;\u001dAÍ!\u0005Ø\u001ey\u009e\u0086\u0085MÇäKGj=\u0081bPÏb¡ò[\u008d&Fü\u0088\u0083 ÁÇ¶£\u007f\u0015$ÃiËt\u0092G\u0084\u008a\u000bV\u0092²\u0085\t[¿\u0000\u00ad\u0019H\u009d\u0014b±t#\u0082\u000e\u0000XB\u008d*\fUõê\u001d\u00adô>#?pa3rð\u0092\u008d\u0093~AÖ_ìñl\";Û|Þ7YËît`@\u0085ò§Îw2n¦\u0007\u0080\u0084\u0019øP\u009eèïØUaÙ\u00975©i§ªÅ\f\u0006ÂZ\u0004«ü\u0080\u000bÊÜ\u009eDz.ÃE4\u0084ýÕg\u0005\u000e\u001e\u009eÉÛsÛÓ\u0010U\u0088Íg_ÚyãgC@ÅÄ4eq>8Ø=(ø\u009eñmÿ \u0015>!ç\u008f°=Jæã\u009f+Û\u0083\u00ad÷é=Zh\u0094\u0081@÷öL&\u001c\u0094i)4A\u0015 ÷v\u0002Ô÷¼ôk.Ô¢\u0000hÔ\b$q3 ôjC·Ô·P\u0000a¯\u001e9ö.\u0097$EF\u0014!Ot¿\u008b\u0088@M\u0095ü\u001d\u0096µ\u0091¯pôÝÓf /E¿¼\tì\u0003½\u0097\u0085\u007f¬mÐ1Ë\u0085\u0004\u0096ë'³Uý9AÚ%Gæ«Ê\n\u009a(Px%S\u0004)ô\n,\u0086Úé¶mûhÜ\u0014b×Hi\u0000h\u000eÀ¤'¡\u008dîO?þ¢è\u0087\u00ad\u008cµ\u008cà\u0006zôÖ¶ªÎ\u001e|Ó7_ìÎx£\u0099@k*B þ\u009e5Ùó\u0085¹î9×«;\u0012N\u008b\u001dÉú÷Km\u0018V&£f1êã\u0097²:nútÝ[C2hAç÷Êx ûû\nõNØþ³\u0097E@V¬ºH\u0095'US:: \u0083\u008d\u0087þk©·Ð\u0096\u0095KU¨g¼¡\u0015\u009aXÌ©)c\u0099áÛ3¦*JV?1%ù^ô~\u001c\u0090)1|ýøè\u0002\u0004'/p\u0080»\u0015\\\u0005(,ã\u0095Á\u0015HäÆm\"HÁ\u0013?Ç\u000f\u0086Ü\u0007ùÉîA\u0004\u001f\u000f@Gy¤]\u0088n\u00172_QëÕ\u009bÀÑò¼Á\u008fA\u00115d%{x4`*\u009c`ßøè£\u001fcl\u001b\u000e\u0012´Â\u0002á2\u009e¯fOÑÊÑ\u0081\u0015k#\u0095à3>\u0092á;$\u000bbî¾¹\"\u0085²¢\u000eæº\r\u0099Þr\f\u008c-¢÷(Ð\u0012xE\u0095·\u0094ýd}\bbçÌõðTI£o\u0087}HúÃ\u009dý'ó>\u008d\u001e\nGcA\u0099.ÿt:on«ôøý7¨\u0012Ü`¡ëÝø\u0099\u001báLÛnk\rÆ{U\u0010mg,7'eÔ;ÜÐè\u0004ñ)\rÇÌ\u0000ÿ£µ9\u000f\u0092i\u000fí\u000bf{\u009fûÎÛ}\u009c \u0091Ï\u000bÙ\u0015^£»\u0013/\u0088Q[\u00ad${\u0094y¿v;Öë79.³Ì\u0011Yy\u0080&â\u0097ô.1-hB\u00ad§Æj+;\u0012uLÌx.ñ\u001cj\u0012B7·\u0092Qç\u0006¡»æKûcP\u001ak\u0010\u0018\u0011Êíú=%½ØâáÃÉDB\u0016Y\n\u0012\u0013\u0086Ù\fìnÕ«ê*d¯gNÚ\u0086¨_¾¿é\u0088däÃþ\u009d¼\u0080Wð÷À\u0086`x{ø`\u0003`MÑý\u0083Fö8\u001f°wE®\u0004×6üÌ\u0083Bk3ð\u001e«q°\u0080A\u0087<\u0000^_w W¾½è®$UFB\u0099¿X.aNXô\u008fòÝý¢ôtï8\u0087\u0089½ÂSfùÃÈ³\u008et´uòUFüÙ¹zë&a\u008b\u001dß\u0084\u0084j\u000ey\u0091_\u0095âFnY\u008e ´Wp\u008cÕU\u0091É\u0002ÞL¹\u000b¬á»\u0082\u0005Ð\u0011¨bHut©\u009e·\u007f\u0019¶à©Ü\tf-\t¡Ä2F3èZ\u001f\u0002\tð¾\u008cJ\u0099 %\u001dnþ\u0010\u001a¹=\u001d\u000b¥¤ß¡\u0086ò\u000f(hñiÜ·Ú\u0083W9\u0006þ¡âÎ\u009bOÍ\u007fRP\u0011^\u0001§\u0006\u0083ú \u0002µÄ\ræÐ'\u009aø\u008c'w?\u0086AÃ`L\u0006a¨\u0006µð\u0017z(Àõ\u0086à\u0000`Xª0Ü}b\u0011æ\u009e×#8êcSÂÝ\u0094ÂÂ\u00164»ËîV\u0090¼¶Þëü}¡ÎY\u001dvo\u0005ä\tK|\u0001\u00889r\n=|\u0092|$\u0086ãr_rM\u009d¹\u001aÁ[´Ó\u009e¸üíTUx\bü¥µØ=|ÓM\u00ad\u000fÄ\u001ePï^±aæø¢\u0085\u0014ÙlQ\u0013<oÕÇçVáNÄ6*¿ÎÝÆÈ7×\u009a24\u0092c\u0082\u0012g\u000eú\u008e@`\u0000à:9Î7ÓúõÏ«Âw7ZÅ-\u001b\\°g\u009eO£7BÓ\u0082'@\u0099¼\u009b¾Õ\u0011\u008e\u009d¿\u000fs\u0015Ö-\u001c~Ç\u0000Ä{·\u008c\u001bk!¡\u0090E²n±¾j6n´WH«/¼\u0094nyÆ£vÒeIÂÈS\u000føîF\u008dÞ}Õs\n\u001dLÐMÆ)9»Û©ºFP¬\u0095&è¾^ã\u0004¡úÕðj-Q\u009acï\u008câ\u009a\u0086î\"À\u0089Â¸C$.ö¥\u001e\u0003ª\u009còÐ¤\u0083Àaº\u009béjM\u008få\u0015Pºd[Ö(&¢ù§::áK©\u0095\u0086ïUbéÇ/ïÓ÷R÷Ú?\u0004oiwú\nY\u0080ä©\u0015\u0087°\u0086\u0001\u009b\tæ\u00ad;>å\u0093é\u0090ýZ\u009e4×\u0097,ð·Ù\u0002+\u008bQ\u0096Õ¬:\u0001}¦}ÑÏ>Ö|}-(\u001f\u009f%Ï\u00adò¸\u009bZÖ´rZ\u0088õLà)¬qà\u0019¥æG°¬ýí\u0093ú\u009bèÓÄ\u008d(;WÌøÕf)y\u0013.(x_\u0001\u0091íu`U÷\u0096\u000eDãÓ^\u008c\u0015\u0005mÔ\u0088ômº\u0003¡a%\u0005dð½Ãë\u009e\u0015<\u0090W¢\u0097'\u001aì©:\u0007*\u001b?m\u009b\u001ec!õõ\u009cfû&Üó\u0019u3Ù(±Uýõ\u0003V4\u0082\u008aº<»(Qw\u0011Â\nÙø«ÌQgÌ\u00ad\u0092_Mè\u0017Q80Ü\u008e7\u009dXb\u0093 ù\u0091êz\u0090Âû>{ÎQ!ÎdwO¾2¨¶ã~Ã)=FHÞSid\u0013æ\u0080¢®\b\u0010Ým²$i\u0085-ý\t\u0007!f³\u009aF\ndEÀÝXlÞÏ\u001c È®[¾÷Ý\u001bX\u008d@ÌÒ\u0001\u007fk´ã»Ý¢j~:YÿE>5\nD¼´ÍÕrêÎ¨úd\u0084»\u008df\u0012®¿<oGÒ\u009bäcT/]\u009e®Âw\u001böNcpt\u000e\r\u008dç[\u0013Wør\u0016q¯S}]@@Ë\bN´âÌ4ÒFj\u0001\u0015¯\u0084á°\u0004(\u0095\u0098:\u001d\u0006¸\u009f´În Ho?;\u00825 «\u0082\u0001\u001a\u001dK'r'øa\u0015`±ç\u0093?Ü»:y+4E%½ \u00889áQÎyK/2É· \u001fºÉà\u001cÈ~¼ÇÑöÏ\u0001\u0011Ã¡èªÇ\u001a\u0090\u0087IÔO½\u009aÐÚÞËÕ\nÚ8\u00039Ã*Æ\u00916g\u008dù1|à±+O÷\u009eY·Cõ»:òÕ\u0019ÿ'ÙE\u009c¿\u0097\",\u0015æü*\u000f\u0091üq\u009b\u0094\u0015%úå\u0093aÎ¶\u009cëÂ¨dY\u0012º¨Ñ¶Á\u0007^ã\u0005j\f\u0010ÒPeË\u0003¤Bàìn\u000e\u0016\u0098Û;L\u0098 ¾2xéd\u009f\u001f\u00952àÓ\u0092ßÓ 4+\u0089qò\u001e\u001b\ntAK£4\u008cÅ¾q Ãv2Øß5\u009f\u008d\u009b\u0099/.æ\u000boG\u000fãñ\u001dåLÚT\u001eÚØ\u0091ÎbyÏÍ>~o\u0016\u0018±fý,\u001d\u0005\u0084\u008fÒÅöû\"\u0099õ#óW¦2v#\u0093¨51VÌÍ\u0002¬ð\u0081bZuëµn\u00166\u0097\u0088ÒsÌÞ\u0096b\u0092\u0081¹IÐLP\u0090\u001bqÆV\u0014æÆÇ½2z\u0014\nEáÐ\u0006Ãò{\u009aÉªSýb¨\u000f\u0000»%¿â5½Òöq\u0012i\u0005²\u0004\u0002\"¶ËÏ|Ív\u009c+S\u0011>À\u0016@ãÓ8«½`%G\u00adðº8 \u009c÷FÎvw¯¡Å u``\u0085ËþN\u008aè\u008dØzªù°Lùª~\u0019HÂ\\\u0002û\u008a\u008c\u0001ÃjäÖëáù\u0090Ôøi¦\\Þ ?\t%-Â\bæ\u009f·Na2Îwâ[W\u008fßã:Ãræ".getBytes("ISO-8859-1")).asIntBuffer().get(iArr2, 0, 1024);
        System.arraycopy(iArr2, 0, iArr, 0, 1024);
        S_orig = iArr;
        bf_crypt_ciphertext = new int[]{1332899944, 1700884034, 1701343084, 1684370003, 1668446532, 1869963892};
        base64_code = new char[]{'.', '/', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        index_64 = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, TarHeader.LF_FIFO, TarHeader.LF_CONTIG, 56, 57, 58, 59, 60, 61, 62, 63, -1, -1, -1, -1, -1, -1, -1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, Ascii.DC4, Ascii.NAK, 22, Ascii.ETB, Ascii.CAN, Ascii.EM, Ascii.SUB, Ascii.ESC, -1, -1, -1, -1, -1, -1, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, TarHeader.LF_NORMAL, TarHeader.LF_LINK, TarHeader.LF_SYMLINK, TarHeader.LF_CHR, TarHeader.LF_BLK, TarHeader.LF_DIR, -1, -1, -1, -1, -1};
        int i = getAuthRequestContext + 19;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        if (!(i % 2 != 0)) {
            int i2 = 83 / 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
    
        if (r7 <= r6.length) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0036, code lost:
    
        if ((r7 <= r6.length ? 'P' : 'W') != 'W') goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0038, code lost:
    
        r1 = io.split.android.client.utils.BCrypt.NetworkUserEntityData$$ExternalSyntheticLambda0 + 75;
        io.split.android.client.utils.BCrypt.getAuthRequestContext = r1 % 128;
        r1 = r1 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0042, code lost:
    
        if (r3 >= r7) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0044, code lost:
    
        r1 = r3 + 1;
        r2 = r6[r3] & 255;
        r3 = io.split.android.client.utils.BCrypt.base64_code;
        r0.append(r3[(r2 >> 2) & 63]);
        r2 = (r2 & 3) << 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0059, code lost:
    
        if (r1 < r7) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005b, code lost:
    
        r6 = io.split.android.client.utils.BCrypt.NetworkUserEntityData$$ExternalSyntheticLambda0 + 123;
        io.split.android.client.utils.BCrypt.getAuthRequestContext = r6 % 128;
        r6 = r6 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0069, code lost:
    
        r0.append(r3[r2 & 63]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006d, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006e, code lost:
    
        throw r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006f, code lost:
    
        r4 = r1 + 1;
        r1 = r6[r1] & 255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007e, code lost:
    
        r0.append(r3[(r2 | ((r1 >> 4) & 15)) & 63]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0081, code lost:
    
        r1 = (r1 & 15) << 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0085, code lost:
    
        if (r4 < r7) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0087, code lost:
    
        r0.append(r3[r1 & 63]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008f, code lost:
    
        r2 = r6[r4] & 255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x009c, code lost:
    
        r0.append(r3[(r1 | ((r2 >> 6) & 3)) & 63]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a3, code lost:
    
        r0.append(r3[r2 & 63]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a6, code lost:
    
        r3 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a9, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00aa, code lost:
    
        throw r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00af, code lost:
    
        return r0.toString();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String encode_base64(byte[] r6, int r7) {
        /*
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            r1 = 5
            if (r7 <= 0) goto La
            r2 = 1
            goto Lb
        La:
            r2 = 5
        Lb:
            if (r2 == r1) goto Lb0
            int r1 = io.split.android.client.utils.BCrypt.getAuthRequestContext
            int r1 = r1 + 47
            int r2 = r1 % 128
            io.split.android.client.utils.BCrypt.NetworkUserEntityData$$ExternalSyntheticLambda0 = r2
            int r1 = r1 % 2
            r2 = 67
            if (r1 != 0) goto L1e
            r1 = 70
            goto L20
        L1e:
            r1 = 67
        L20:
            r3 = 0
            if (r1 == r2) goto L2c
            int r1 = r6.length
            r2 = 32
            int r2 = r2 / r3
            if (r7 > r1) goto Lb0
            goto L38
        L2a:
            r6 = move-exception
            throw r6
        L2c:
            int r1 = r6.length
            r2 = 87
            if (r7 > r1) goto L34
            r1 = 80
            goto L36
        L34:
            r1 = 87
        L36:
            if (r1 == r2) goto Lb0
        L38:
            int r1 = io.split.android.client.utils.BCrypt.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r1 = r1 + 75
            int r2 = r1 % 128
            io.split.android.client.utils.BCrypt.getAuthRequestContext = r2
            int r1 = r1 % 2
        L42:
            if (r3 >= r7) goto Lab
            int r1 = r3 + 1
            r2 = r6[r3]
            r2 = r2 & 255(0xff, float:3.57E-43)
            char[] r3 = io.split.android.client.utils.BCrypt.base64_code
            int r4 = r2 >> 2
            r4 = r4 & 63
            char r4 = r3[r4]
            r0.append(r4)
            r2 = r2 & 3
            int r2 = r2 << 4
            if (r1 < r7) goto L6f
            int r6 = io.split.android.client.utils.BCrypt.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r6 = r6 + 123
            int r7 = r6 % 128
            io.split.android.client.utils.BCrypt.getAuthRequestContext = r7
            int r6 = r6 % 2
            r6 = r2 & 63
            char r6 = r3[r6]
            r0.append(r6)     // Catch: java.lang.Exception -> L6d
            goto Lab
        L6d:
            r6 = move-exception
            throw r6
        L6f:
            int r4 = r1 + 1
            r1 = r6[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r5 = r1 >> 4
            r5 = r5 & 15
            r2 = r2 | r5
            r2 = r2 & 63
            char r2 = r3[r2]
            r0.append(r2)     // Catch: java.lang.Exception -> La9
            r1 = r1 & 15
            int r1 = r1 << 2
            if (r4 < r7) goto L8f
            r6 = r1 & 63
            char r6 = r3[r6]
            r0.append(r6)
            goto Lab
        L8f:
            r2 = r6[r4]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r5 = r2 >> 6
            r5 = r5 & 3
            r1 = r1 | r5
            r1 = r1 & 63
            char r1 = r3[r1]
            r0.append(r1)     // Catch: java.lang.Exception -> La9
            r1 = r2 & 63
            char r1 = r3[r1]
            r0.append(r1)     // Catch: java.lang.Exception -> La9
            int r3 = r4 + 1
            goto L42
        La9:
            r6 = move-exception
            throw r6
        Lab:
            java.lang.String r6 = r0.toString()
            return r6
        Lb0:
            java.lang.String r6 = "Invalid len when encoding base64"
            log(r6)
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.split.android.client.utils.BCrypt.encode_base64(byte[], int):java.lang.String");
    }

    private static byte char64(char c) {
        if (c >= 0) {
            int i = getAuthRequestContext + 59;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            int i2 = i % 2;
            try {
                byte[] bArr = index_64;
                if ((c <= bArr.length ? '*' : '\'') != '*') {
                    return (byte) -1;
                }
                int i3 = getAuthRequestContext + 17;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i3 % 128;
                if ((i3 % 2 == 0 ? 'I' : '@') != 'I') {
                    return bArr[c];
                }
                byte b = bArr[c];
                Object[] objArr = null;
                int length = objArr.length;
                return b;
            } catch (Exception e) {
                throw e;
            }
        }
        return (byte) -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0083 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] decode_base64(java.lang.String r11, int r12) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.split.android.client.utils.BCrypt.decode_base64(java.lang.String, int):byte[]");
    }

    private final void encipher(int[] iArr, int i) {
        int i2 = getAuthRequestContext + 97;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
        int i3 = i2 % 2;
        int i4 = iArr[i];
        int i5 = i + 1;
        int i6 = iArr[i5];
        int i7 = this.P[0];
        int i8 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 89;
        getAuthRequestContext = i8 % 128;
        int i9 = i8 % 2;
        int i10 = 0;
        while (true) {
            i4 ^= i7;
            if (!(i10 > 14)) {
                int[] iArr2 = this.S;
                int i11 = iArr2[(i4 >> 24) & 255];
                int i12 = iArr2[((i4 >> 16) & 255) | 256];
                int i13 = iArr2[((i4 >> 8) & 255) | 512];
                int i14 = iArr2[(i4 & 255) | 768];
                int[] iArr3 = this.P;
                int i15 = i10 + 1;
                i6 ^= (((i11 + i12) ^ i13) + i14) ^ iArr3[i15];
                int i16 = iArr2[(i6 >> 24) & 255];
                int i17 = iArr2[((i6 >> 16) & 255) | 256];
                i10 = i15 + 1;
                i7 = iArr3[i10] ^ (((i16 + i17) ^ iArr2[((i6 >> 8) & 255) | 512]) + iArr2[(i6 & 255) | 768]);
            } else {
                try {
                    iArr[i] = i6 ^ this.P[17];
                    iArr[i5] = i4;
                    return;
                } catch (Exception e) {
                    throw e;
                }
            }
        }
    }

    private static int streamtoword(byte[] bArr, int[] iArr) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 119;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            int i3 = iArr[0];
            int i4 = 0;
            int i5 = 0;
            while (true) {
                if (i4 >= 4) {
                    break;
                }
                i5 = (i5 << 8) | (bArr[i3] & 255);
                i3 = (i3 + 1) % bArr.length;
                i4++;
            }
            iArr[0] = i3;
            int i6 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 99;
            getAuthRequestContext = i6 % 128;
            if ((i6 % 2 != 0 ? (char) 15 : '@') != '@') {
                Object[] objArr = null;
                int length = objArr.length;
                return i5;
            }
            return i5;
        } catch (Exception e) {
            throw e;
        }
    }

    private void init_key() {
        try {
            int i = getAuthRequestContext + 41;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            Object obj = null;
            if ((i % 2 == 0 ? 'F' : (char) 6) != 6) {
                this.P = (int[]) P_orig.clone();
                this.S = (int[]) S_orig.clone();
                obj.hashCode();
            } else {
                this.P = (int[]) P_orig.clone();
                this.S = (int[]) S_orig.clone();
            }
            int i2 = getAuthRequestContext + 71;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
            if (!(i2 % 2 == 0)) {
                return;
            }
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    private void key(byte[] bArr) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 49;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        int[] iArr = {0};
        int[] iArr2 = {0, 0};
        int length = this.P.length;
        int length2 = this.S.length;
        int i3 = 0;
        while (true) {
            if ((i3 < length ? 'L' : (char) 2) != 'L') {
                break;
            }
            int i4 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 111;
            getAuthRequestContext = i4 % 128;
            if (i4 % 2 != 0) {
                int[] iArr3 = this.P;
                iArr3[i3] = iArr3[i3] & streamtoword(bArr, iArr);
                i3 += 119;
            } else {
                int[] iArr4 = this.P;
                iArr4[i3] = iArr4[i3] ^ streamtoword(bArr, iArr);
                i3++;
            }
        }
        int i5 = 0;
        while (true) {
            if ((i5 < length ? '[' : (char) 18) != '[') {
                break;
            }
            encipher(iArr2, 0);
            int[] iArr5 = this.P;
            iArr5[i5] = iArr2[0];
            iArr5[i5 + 1] = iArr2[1];
            i5 += 2;
        }
        int i6 = getAuthRequestContext + 119;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i6 % 128;
        int i7 = i6 % 2;
        int i8 = 0;
        while (i8 < length2) {
            encipher(iArr2, 0);
            int[] iArr6 = this.S;
            iArr6[i8] = iArr2[0];
            iArr6[i8 + 1] = iArr2[1];
            i8 += 2;
            int i9 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 49;
            getAuthRequestContext = i9 % 128;
            int i10 = i9 % 2;
        }
    }

    private void ekskey(byte[] bArr, byte[] bArr2) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int length;
        int length2;
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 61;
        getAuthRequestContext = i % 128;
        if (i % 2 != 0) {
            iArr = new int[0];
            iArr[0] = 1;
            iArr2 = new int[1];
            iArr2[1] = 0;
            iArr3 = new int[]{0, 0};
            length = this.P.length;
            length2 = this.S.length;
        } else {
            iArr = new int[]{0};
            iArr2 = new int[]{0};
            iArr3 = new int[]{0, 0};
            length = this.P.length;
            length2 = this.S.length;
        }
        int i2 = 0;
        while (true) {
            if (!(i2 < length)) {
                break;
            }
            int[] iArr4 = this.P;
            iArr4[i2] = iArr4[i2] ^ streamtoword(bArr2, iArr);
            i2++;
        }
        int i3 = 0;
        while (true) {
            if (!(i3 < length)) {
                break;
            }
            int i4 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 7;
            getAuthRequestContext = i4 % 128;
            int i5 = i4 % 2;
            iArr3[0] = iArr3[0] ^ streamtoword(bArr, iArr2);
            iArr3[1] = iArr3[1] ^ streamtoword(bArr, iArr2);
            encipher(iArr3, 0);
            int[] iArr5 = this.P;
            iArr5[i3] = iArr3[0];
            iArr5[i3 + 1] = iArr3[1];
            i3 += 2;
        }
        for (int i6 = 0; i6 < length2; i6 += 2) {
            iArr3[0] = iArr3[0] ^ streamtoword(bArr, iArr2);
            iArr3[1] = iArr3[1] ^ streamtoword(bArr, iArr2);
            encipher(iArr3, 0);
            int[] iArr6 = this.S;
            iArr6[i6] = iArr3[0];
            iArr6[i6 + 1] = iArr3[1];
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0026, code lost:
    
        if ((r9.length != 39) != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0035, code lost:
    
        if ((r9.length != 16 ? 19 : '*') != '*') goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0037, code lost:
    
        log("Bad salt length");
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003c, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003d, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003e, code lost:
    
        throw r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003f, code lost:
    
        init_key();
        ekskey(r9, r8);
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0048, code lost:
    
        if (r1 >= (1 << r10)) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004a, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x004c, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004d, code lost:
    
        if (r2 == false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004f, code lost:
    
        r8 = io.split.android.client.utils.BCrypt.NetworkUserEntityData$$ExternalSyntheticLambda0 + 67;
        io.split.android.client.utils.BCrypt.getAuthRequestContext = r8 % 128;
        r8 = r8 % 2;
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x005e, code lost:
    
        if (r8 >= 64) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0060, code lost:
    
        r9 = 11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0063, code lost:
    
        r9 = kotlin.text.Typography.dollar;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0065, code lost:
    
        if (r9 == '$') goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0067, code lost:
    
        r9 = io.split.android.client.utils.BCrypt.getAuthRequestContext + 119;
        io.split.android.client.utils.BCrypt.NetworkUserEntityData$$ExternalSyntheticLambda0 = r9 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0073, code lost:
    
        if ((r9 % 2) != 0) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0075, code lost:
    
        r9 = '\t';
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0078, code lost:
    
        r9 = 22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007a, code lost:
    
        if (r9 == 22) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007c, code lost:
    
        r9 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x007e, code lost:
    
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0081, code lost:
    
        if (r9 >= (r0 >> 1)) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0083, code lost:
    
        encipher(r11, r9 << 1);
        r9 = r9 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x008b, code lost:
    
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008e, code lost:
    
        r8 = new byte[r0 * 4];
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0093, code lost:
    
        if (r3 >= r0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0095, code lost:
    
        r10 = io.split.android.client.utils.BCrypt.getAuthRequestContext + 99;
        io.split.android.client.utils.BCrypt.NetworkUserEntityData$$ExternalSyntheticLambda0 = r10 % 128;
        r10 = r10 % 2;
        r10 = r9 + 1;
        r1 = r11[r3];
        r8[r9] = (byte) ((r1 >> 24) & 255);
        r9 = r10 + 1;
        r8[r10] = (byte) ((r1 >> 16) & 255);
        r10 = r9 + 1;
        r8[r9] = (byte) ((r1 >> 8) & 255);
        r9 = r10 + 1;
        r8[r10] = (byte) (r1 & 255);
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00c6, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00c7, code lost:
    
        key(r8);
        key(r9);
        r1 = r1 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] crypt_raw(byte[] r8, byte[] r9, int r10, int[] r11) {
        /*
            Method dump skipped, instructions count: 215
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.split.android.client.utils.BCrypt.crypt_raw(byte[], byte[], int, int[]):byte[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0034, code lost:
    
        if (r6 == 'T') goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0041, code lost:
    
        if ((r6 == 'a' ? 3 : 'A') != 3) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0048, code lost:
    
        if (r14.charAt(3) != '$') goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004a, code lost:
    
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004c, code lost:
    
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:
    
        if (r10 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004f, code lost:
    
        r10 = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0051, code lost:
    
        log("Invalid salt revision");
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0056, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String hashpw(java.lang.String r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 363
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.split.android.client.utils.BCrypt.hashpw(java.lang.String, java.lang.String):java.lang.String");
    }

    public static String gensalt(int i, SecureRandom secureRandom) {
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bArr = new byte[16];
        secureRandom.nextBytes(bArr);
        stringBuffer.append("$2a$");
        if (i < 10) {
            try {
                int i2 = getAuthRequestContext + 17;
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i2 % 128;
                boolean z = i2 % 2 != 0;
                stringBuffer.append("0");
                if (!z) {
                    int i3 = 79 / 0;
                }
            } catch (Exception e) {
                throw e;
            }
        }
        stringBuffer.append(Integer.toString(i));
        stringBuffer.append("$");
        stringBuffer.append(encode_base64(bArr, 16));
        return stringBuffer.toString();
    }

    public static String gensalt(int i) {
        String gensalt = gensalt(i, new SecureRandom());
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 7;
        getAuthRequestContext = i2 % 128;
        int i3 = i2 % 2;
        return gensalt;
    }

    public static String gensalt() {
        int i = getAuthRequestContext + 103;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        return gensalt((i % 2 == 0 ? 'R' : 'J') != 'R' ? 10 : 13);
    }

    private static void log(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("BCrypt ");
        sb.append(str);
        Logger.e(sb.toString());
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 113;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        C c = new C();
        char[] cArr2 = new char[cArr.length];
        c.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        while (true) {
            if ((c.BuiltInFictitiousFunctionClassFactory < cArr.length ? 'Y' : (char) 16) == 16) {
                break;
            }
            cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
            cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
            int i2 = 58224;
            int i3 = $11 + 51;
            $10 = i3 % 128;
            int i4 = i3 % 2;
            int i5 = 0;
            while (true) {
                if ((i5 < 16 ? '5' : 'S') != '5') {
                    break;
                }
                int i6 = $10 + 73;
                $11 = i6 % 128;
                int i7 = i6 % 2;
                cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i2) ^ ((cArr3[0] << 4) + ((char) (BuiltInFictitiousFunctionClassFactory ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (MyBillsEntityDataFactory ^ 6353485791441662354L)))));
                cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i2) ^ ((cArr3[1] << 4) + ((char) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (PlaceComponentResult ^ 6353485791441662354L)))));
                i2 -= 40503;
                i5++;
            }
            cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
            cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
            c.BuiltInFictitiousFunctionClassFactory += 2;
        }
        String str = new String(cArr2, 0, i);
        int i8 = $10 + 31;
        $11 = i8 % 128;
        if (!(i8 % 2 == 0)) {
            objArr[0] = str;
            return;
        }
        int i9 = 53 / 0;
        objArr[0] = str;
    }
}
