package com.anggrayudi.storage.file;

import android.content.Context;
import android.os.Build;
import com.alipay.mobile.zebra.ZebraLoader;
import com.anggrayudi.storage.SimpleStorage;
import com.anggrayudi.storage.callback.FileCallback;
import com.anggrayudi.storage.extension.TextUtils;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.promocenter.model.PromoActionType;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0012\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u000b\u001a\u0012\u0010\u0014\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a$\u0010\u0016\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0007\u001a\u0012\u0010\u0019\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u000b\u001a\n\u0010\u001b\u001a\u00020\u0006*\u00020\u0001\u001a\u0012\u0010\u001c\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0016\u0010\u001d\u001a\u00020\u0006*\u00020\u00012\b\b\u0002\u0010\u001e\u001a\u00020\u0006H\u0007\u001a\u0012\u0010\u001f\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010 \u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a \u0010!\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u0006H\u0007\u001a\u0012\u0010\"\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010#\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010$\u001a\u00020%*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010&\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u001a\u0010'\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0001\u001a\u0012\u0010)\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010*\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010+\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010,\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a4\u0010-\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u000b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010/\u001a\u000200H\u0007\u001a(\u00101\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u000200H\u0007\u001a4\u00102\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u00012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u00105\u001a\u000206H\u0007\u001a4\u00102\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u000b2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u00105\u001a\u000206H\u0007\u001a\n\u00107\u001a\u00020\u0006*\u00020\u0001\u001a\u001c\u00108\u001a\u00020\u0006*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0006H\u0007\u001a\u001e\u00109\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0006H\u0007\u001a\u0014\u0010:\u001a\u0004\u0018\u00010;*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0002\u001a\n\u0010<\u001a\u00020\u0006*\u00020\u0001\u001a\u0012\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00010>*\u00020\u0001H\u0002\u001a\u001c\u0010?\u001a\u00020@*\u00020\u00012\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\u000bH\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\t\u0010\b\"\u0017\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u001b\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006C"}, d2 = {"dataDirectory", "Ljava/io/File;", "Landroid/content/Context;", "getDataDirectory", "(Landroid/content/Context;)Ljava/io/File;", "inPrimaryStorage", "", "getInPrimaryStorage", "(Ljava/io/File;)Z", "isEmpty", "mimeType", "", "getMimeType", "(Ljava/io/File;)Ljava/lang/String;", "writableDirs", "", "getWritableDirs", "(Landroid/content/Context;)Ljava/util/Set;", "autoIncrementFileName", "filename", "canModify", HummerConstants.CONTEXT, "checkRequirements", "requiresWriteAccess", "considerRawFile", "child", "path", "createNewFileIfPossible", "deleteEmptyFolders", "forceDelete", "childrenOnly", "getBasePath", "getRootPath", "getRootRawFile", "getSimplePath", "getStorageId", "getStorageType", "Lcom/anggrayudi/storage/file/StorageType;", "inDataStorage", "inSameMountPointWith", "file", "inSdCardStorage", "isExternalStorageManager", "isReadOnly", "isWritable", "makeFile", "name", "mode", "Lcom/anggrayudi/storage/file/CreateMode;", "makeFolder", "moveTo", "targetFolder", "newFileNameInTarget", "conflictResolution", "Lcom/anggrayudi/storage/callback/FileCallback$ConflictResolution;", "recreateFile", "shouldWritable", "takeIfWritable", "toDocumentFile", "Landroidx/documentfile/provider/DocumentFile;", "tryCreateNewFile", "walkFileTreeAndDeleteEmptyFolders", "", "walkFileTreeForMove", "", "srcPath", "destFolderPath", "storage_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class FileUtils {
    private static long BuiltInFictitiousFunctionClassFactory;
    private static char[] getAuthRequestContext;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] PlaceComponentResult;

        static {
            int[] iArr = new int[FileCallback.ConflictResolution.values().length];
            iArr[FileCallback.ConflictResolution.SKIP.ordinal()] = 1;
            iArr[FileCallback.ConflictResolution.REPLACE.ordinal()] = 2;
            iArr[FileCallback.ConflictResolution.CREATE_NEW.ordinal()] = 3;
            PlaceComponentResult = iArr;
        }
    }

    static {
        char[] cArr = new char[2469];
        ByteBuffer.wrap("x¹«¾Þk\u0001\u00045\u0089X\u008d\u008b1¿îâ\u0092\u0015\\8\u0007l¡\u009fnÂ\u0015öß\u0019\u0086L2pè£«ÖAù\u0015-õPm\u00832·×Ú\u0099\rKóa fU³\u008aÜ¾QÓU\u0000é46iJ\u009e\u0084³ßçy\u0014¶IÍ}\u0016\u0092SÇþû'(I]\u008erÎ¦\u0000Û¥\bî<\noÔ¼ÓÉ\u0006\u0016i\"äOà\u009c\\¨\u0083õÿ\u00021/j{Ì\u0088\u0003Õxá \u000eö[Ug\u0094\n\u009fÙ\u008f¬Qs'G¯*¡ù\u0017ÍÀ\u0090¥gpJ-\u001eÛíG°\u0003\u0084ôk >\u0016\u0002ÕÑ\u009b¤|\u008b\u001f_î\"Yñ\u0010Åä¨¹\u007fzCÍó\" cU\u008e\u008aå¾DÓs\u0000´46iq\u009e\u008e³\u008cçU\u0014¨Iê}\\\u0092bÇÑû.(n]ÒrÌ¦%Û\u0089\bÍ<!Q\u001a\u0086Óº2ïl\u001c óx cUâ\u008aå¾)Óm\u0000¾4,io\u009e\u009a³\u0084çx\u0014\u0086I·}\\\u0092Vóa gU¢\u008aÉ¾QÓV\u0000á4ti^\u009e\u0090³Ùçz\u0084àWæ\"#ýHÉÐ¤ÀwnC¶\u001e\u0081é\u0013ÄE\u0090äc/óa qU²\u008aÉ¾\u001fÓ@\u0000â4ui|\u009e¤³ûçe\u0014¨I÷}\"\u0092[Çúû#y¸ª\u0081ß\u0000\u0000q4»Yý\u008a\t¾¢ã\u00ad\u0014\r9wmÑ\u009e\u0005Ã]÷°\u0018¿MvqÍ¢\u0095×eøe,\u009dQ\u0007\u0082[ó/ ZU\u008e\u008aý¾[Ós\u0000£4bi\u0014\u009eØ³\u008eç/\u0014¦Ià}R\u0092eÇÑû\u001as\n \u001aÕÄ\n²>aS<\u0080\u0080´\u001eé)\u001eà3¿gN\u0094ÙÉ\u0090ýo\u0012?G\u0087{\u0007¨\u000eÝîT\u0082\u0087Åò\u001f-j\u0019¿tä^w\u008d&óa qU¯\u008aÙ¾\nÓW\u0000ë4uiL\u009e\u008b³Øç%\u0014°I÷}\u000b\u0092OÇØû\u000f(;]\u0084rÛ¦\u001fÛ³\b·<\rQM\u0086\u0098º>ïl\u001c½1Êóa qU¯\u008aÙ¾\nÓW\u0000ë4uiL\u009e\u008b³Øç%\u0014°I÷}\u000b\u0092OÇØû\u000f(;]\u009arÌ¦\u001dÛ¶ô´'¤Rz\u008d\f¹ßÔ\u0082\u0007>3 n\u0097\u0099^´\u0001àð\u0013gN.zÑ\u0095\u0081À>üú/¶Ziu&¡×Üa\u000f ;ËVÙ\u0081P½ðóa fU³\u008aÜ¾QÓ\\\u0000ã47i[\u009e\u0085³Ãço\u0014\u00adIæ?ýì¬\u00999F\trÊ\u001f\u009aÌ+øÿ¥ÁRK\u007f\u0018+¸Øk]Ì\u008e\u008bû[$5\u0010÷}ð®\u0004\u009aÓÇ¶óa rU¤\u008aÅ¾\u001dÓ\u001d\u0000à43iB\u009e\u0087³Åçs\u0014\u00adIæ}\u0003\u0092WÇýó  gU»\u008aß¾\rÓT°Ic\u001c\u0016\u008aÉôýj\u0090bC\u0081w\u0019*pÝ¶ðõ¤VWï\n«>vÑ\u0003\u0084Ò¸Hk\u001c\u001e¶1ìåK\u0098ÖKÈ\u007fz\u00126Å¦ùswï¤\u0094Ñ\u0013\u000er:¤W¾\u0084)°\u008eí\u0099\u001a47lc\u0086\u0090\u0006Í*ùç\u0016\u009bC1\u007f\u0096¬ÓÙ]óz zU\u0099\u008aå¾\u0012ÓD\u0000°4\"iB\u009eØ³Àç>\u0014¬IÍ}>\u0092bÇøûvó< mUø\u008aÚ¾\fÓ]\u0000â4/iM\u009e\u0096³\u0098çg\u0014¿Iü}\u0013\u0092\\Çïû!(b]\u009frÌ¦\u0017Û´\u0002ÏÑï¤5{GOË\"´ñmÅ·\u0098ÁoZB.\u0016éåk¸9\u008c\u008bc¼6\u0018\níÙõ¬\u0005\u0083\u0006W\u008eó\t gU¸\u008aÓ¾\u0013Ó]\u0000ò43iA\u009e\u008cgt´#Áò\u001e\u008b*^G\n\u0094§Â\f\u0011Kd\u0085»ä\u008f2âz1Ò\u0005\u0016Üª\u000fûzn¥L\u0091\u009aüË/t\u001b¹FÛ±\u0000\u009c\u000eÈø;-frR\u0099½Ïè}ÐÃ\u0003\u009bvB©)\u009d½ðÿ#\r`E³\u000bÆÔ\u0019£-`@7\u0093\u0089ó) gU¸\u008aÏ¾\fÓ[\u0000å4\u0005iV\u009eÚ³\u0080A\u0017\u0092Yç\u00868ñ\f2ae²Û\u0086;Ûh,ä\u0001¾Uk¦Öû\u0098ó< mUø\u008aÚ¾\fÓ]\u0000â4/iM\u009e\u0096³\u0098çg\u0014±Iö}\u0003\u0092Vó= fU½ó+ oU£\u008aÆ¾\u001fÓF\u0000é4(ó\u000f rU¦\u008a\u008a¾,ÓG\u0000è4.iG\u009e\u008f³Óç*\u0014¸Iý}\u0014\u0092\u001aÇÍû*(d]\u0085rÓ¦\u0017E=\u0096^ã\u0080<ê\b#ei¶Ð\u0082HßO(\u0094\u0005ÏQ\u0018¢\u008eÿÕË=$dqÈMP\u009eBë·Äþ\u0010`m\u008c¾\u0090\u008ajó\u000f lU²\u008aØ¾\u0011Ó[\u0000â4zi}\u009e¦³ýç*\u0014¼Iç}\u000f\u0092VÇúûb(p]\u0085rÌ¦RÛ¾\b¢<XQ}\u0086Àº~ó< mUø\u008aÂ¾\u001fÓ@\u0000â4-iO\u009e\u0090³Óó) mUº\u008aÎ¾\u0018Ó[\u0000õ42\u0082ÙQ\u0081$Xû3Ï§¢å\u001b¨È÷½,b]V\u0082;Ó\u0084\u000fW^\"ËýéÉ?¤nwÑC\u001c\u001e~é¥Ä«\u0090[c\u009f>À\n;åmó< mUø\u008aÁ¾\u001bÓ@\u0000è4?iB\u009eÌ³Çço\u0014³Içó\u007fó< mUø\u008aÙ¾\u001bÓQ\u0000ó4(iKó~Ó*\u0000{uîªÞ\u009e\u001dóM ü\u0014(I\u0016¾\u0084\u0093ÒÇs4¬iñ]\u0013²Xó( wUº\u008aÆ¾!ÓJ\u0000¾4lÄÍ\u0017\u009cb\t½9\u0089úäª7\u001b\u0003Ï^ñ©u\u0084.Ð\u0095#H~\u0006Jå¥»ð\rÌÚ\u001f\u0089joó) gU¸\u008aÏ¾\fÓ[\u0000å4ui]\u009e\u0086³Ýç%\u0014¹I÷}\b\u0092_Çüû+(uØ\u0010\u000b^~\u0081¡ö\u00955øb+Ü\u001f<Boµã\u0098¹Ì\u001c?\u0094bÏV4¹\\ìÏÐC\u0003\u0019vüYà\u008d.ð\u0091#Æ\u0017%zr\u00ad¬\u0091,Ä_7Ó\u001a©ó) gU¸\u008aÏ¾\fÓ[\u0000å4uiI\u009e\u008d³Ùçm\u0014²I÷}9\u0092IÇêû)(9]\u008drÛ¦\u001cÛ£\bè<\u0007QAAª\u0092äç;8L\f\u008faØ²f\u0086öÛÛ,\u0003\u0001ZUñ¦eû'Ï\u0095 \u0096u{I£\u009aúï\u0011À\u0005\u0014Çi50\u0001ãE\u0096\u0091Iå}:\u0010\u007fÃ\u0081÷\u0001ªb]¡pÁ$E×\u0086\u008aÒ¾!Q|\u0004Ã85ëF\u009eú± eu\u0018\u0089Ë×ÿ(\u0092oE¬y\u000b,Uß¥òö¦jYÐó< mUø\u008aÈ¾\u0011Ó]\u0000ò46iA\u009e\u0083³Òço\u0014¬ó< mUø\u008aÈ¾\u0011Ó]\u0000ò43iC\u009e\u0083³Ñço\u0014ðIð}\u0013\u0092SÇâû&(8]\u008cr×¦\u001cÛ¡\bÿ<\u001cQR\u0086\u0084º#ïp\u001c¦ûº(Ù]\u0007\u0082m¶¤Ûî\bW<Âaã\u0096o»5\u009e±Mà8uçEÓ\u0086¾ÖmgY³\u0004\u008dó\u000bÞR\u008aôy#$s\u0010\u008aÿÎª-\u0096¦Eÿ\u009f\u0017LJ9\u0088æóÒ~(¶ûý\u008e.QOeÁ\bÐÛaï¨²\u0091E\u0002hB<öÏ:\u0092.¦\u0087IÙ\u001cp £óôé¯:÷O+\u0090O¤ÀÉÊ\u001aa.äsÓ\u0084\u0013©Oýô\u000e%Sgg\u008f\u0088Ùó? gU»\u008aß¾PÓA\u0000à4tiH\u009e\u0083³Ýço\u0014\u0081Iñ}\u0007\u0092WÇëû0(w\\î\u008f¶új%\u000e\u0011\u0081|\u0090¯1\u009b¥Æ\u00931P\u001c\u0003H\u0084»kæ&ÒÙ=\u0098h6Tç\u0087¾ù9*h_ý\u0080Ä´\u001eÙE\ní>:cG\u0094É¹Òía\u001e¿Cåw\f\u0098VÍïñi\"bW\u008axÖ¬\u0002Ñ§ó< mUø\u008aÈ¾\u0011Ó]\u0000ò4ti_\u009e\u0087³Ûç\u007f\u0014ðIó}\u0010\u0092^ÇÑû,(w]\u0087rÛó< mUø\u008aÅ¾\u001aÓ_\u0000¨48i[\u009e\u008b³Úçn\u0014ðIô}\u000f\u0092TÇéû'(d]\u009arÌ¦\u001bÛ¨\bîó< mUø\u008aÚ¾\fÓ]\u0000â4/iM\u009e\u0096³\u0098çh\u0014«Iû}\n\u0092^Ç û$(\u007f]\u0084rÙ¦\u0017Û´\bê<\u001cQK\u0086\u0098º>ó< mUø\u008aÙ¾\u0007ÓA\u0000ò4?iC\u009eÌ³Ôç\u007f\u0014·Iþ}\u0002\u0092\u0014Çèû+(x]\u008drÛ¦\u0000Û¶\bè<\u0007QL\u0086\u00829\u0003êR\u009fÇ@æt8\u0019~ÊÍþ\u0000£|T\u0082yì-MÞ\u0095\u0083\u0083·;Xp\rØ1\u0011âM\u0097û¸çl$\u0011\u0097ÂÂö4\u009boL¹p\u0007%HÖ\u0083ûíó< mUø\u008aÜ¾\u001bÓ\\\u0000â45i\\\u009eÌ³Ôç\u007f\u0014·Iþ}\u0002\u0092\u0014Çèû+(x]\u008drÛ¦\u0000Û¶\bè<\u0007QL\u0086\u0082\u0091XB\t7\u009cè¸Ü\u007f±8b\u0086VQ\u000b8üÙÑ¶\u0085\u0002vÑ+\u009b\u001f,ð<¥\u009f\u0099OJ\u001e?ê\u0010ôÄp¹Ëj\u0090^m3#äàØ^\u008d\b~ßS¬\u0007jó\u0019 CUà\u008aÜ¾!Óe\u0000þ4\ri\u0018\u009eÚ³ÄçR\u0014¬Iä}\u0010\u0092\fx?ó/ lU²\u008aØ¾\u0011Ó[\u0000â4ti^\u009e\u0087³Äçg\u0014·Iá}\u0015\u0092SÇáû,(8]¸rû¦3Û\u0082\bÅ<>Qj\u0086¹º\u0004ï[\u001c\u008d1õe.\u009a\u008fÏÖã\u0013ó/ lU²\u008aØ¾\u0011Ó[\u0000â4tiO\u009e\u0092³Æç$\u0014\u009fIñ}\u0012\u0092SÇøû+(b]\u0093rê¦\u001aÛ´\bÿ<\u000fQF\u0088Ï[\u0095.Fñ:Åù¨¾{\u0010Où\u0012¼åpÈ8\u009c\u0081o_2\u0011\u0006ðé±¼\u0003\u0080Îó/ lU²\u008aØ¾\u0011Ó[\u0000â4tiM\u009e\u008d³Øç~\u0014»Iü}\u0012\u0092\u0014ÇÍû-(x]\u009erÛ¦\nÛ²ó- jU³\u008aÉ¾\u0015Óq\u0000ç46iB\u009e\u008b³Øçm\u0014\u0091Ià}5\u0092_Çâû$(F]\u008frÌ¦\u001fÛ¯\bé<\u001dQK\u0086\u0099º$ó/ lU²\u008aØ¾\u0011Ó[\u0000â4ti^\u009e\u0087³Äçg\u0014·Iá}\u0015\u0092SÇáû,(8]¸rû¦3Û\u0082\bÅ<>Qj\u0086¹º\u0004ï[\u001c\u008d1èe/\u009a\u0083ÏÀã\u0013\u0010xE\u00adæ¹5¼@!\u009ff«ªÆþ\u0015J!ó|\u0090\u008b\u000b¦\u0019ò¥\u0001\u001d\\\u007fh¥\u0087þÒyîµó) gU¢\u008aæ¾\u0017Ó\\\u0000ã4ki`\u009e\u0097³Ûçh\u0014»IàÚÒ\t\u009a|N£2\u0097æú\u00ad)\u001a\u001dÂ@¶·z\u009a/\f\u008aßÂª\u0016ujA¾,õÿBË\u009a\u0096îa\"Lu\u009cWO\u001f:Ëå·Ñc¼(o\u009f[G\u00063ñÿÜ¦_\u0089\u008cÁù\u0015&i\u0012½\u007fö¬A\u0098\u0099Åí2\"\u001fp¡-re\u0007±ØÍì\u0019\u0081RRåf=;IÌ\u0086áÖó\u007f 7Uã\u008a\u009f¾KÓ\u0000\u0000·4oi\u001b\u009eÔ³\u0082ÄÊ\u0017\u0082bV½*\u0089þäµ7\u0002\u0003Ú^®©a\u00845ó\u007f 7Uã\u008a\u009f¾KÓ\u0000\u0000·4oi\u001b\u009eÔ³\u008e\u001aºÉò¼&cZW\u008e:ÅérÝª\u0080Þw\u0010ZC5Mæ\u0005\u0093ÑL\u00adxy\u00152Æ\u0085ò]¯)Xçu¶d\u001d·UÂ\u0081\u001dý))Db\u0097Õ£\rþy\t·$àPC\u0083\u000böß)£\u001dwp<£\u008b\u0097SÊ'=é\u0010¼%>öv\u0083¢\\Þh\n\u0005AÖöâ.¿ZH\u0094eÏó\u007f 7Uã\u008a\u009f¾KÓ\u0000\u0000·4oi\u001b\u009eÚ³\u0086}B®\nÛÞ\u0004¢0v]=\u008e\u008aºRç&\u0010ç=¹ËN\u0018\u0006mÒ²®\u0086zë18\u0086\f^Q*¦ë\u008b³&\rõC\u0080\u0086_Àk?\u0006bÕÕá\u0011¼xK\u00adfÝ2^Á\u009f\u009cÄ¨#Gj\u0012Å.\u0014ý|\u0088¯§÷s3ó\u000f lU²\u008aØ¾\u0011Ó[\u0000âó) gU¢\u008aù¾\u0017Ó_\u0000Õ4?i\\\u009e\u008b³×çf\u0014\u0090Iç}\u000b\u0092XÇëû0W®\u0084ãñ>.C\u001a\u0092wÛ¤n\u0090±ÍÄ:\u000b\u0017_Cã°7írÙ\u008b6Ócf_\u00ad\u008cüù\u0002ó) gU¢\u008aù¾\u000bÓP\u0000õ49i\\\u009e\u008b³Ôço\u0014¬IÛ}\u0002Cß\u0090\u0091åD::\u000eêc °\u0014\u0084ÈÙ¼.p\u0003$W\u0098¤Lù\u0000Íô-åþ«\u008bnT\"`×\r\u0088Þ#êõ·\u0087@gm\u001eó~ 2Uæ\u008a\u009a¾NÓ\u0002\u0000¶4ji\u001e\u009eÒ³\u0086ç:\u0014îI¢}Vó+ 0Uç\u008a\u0092¾MÓ\u0001\u0000´4ii\u001b\u009e\u0080³\u0080ço\u0014»Iô}W\u0092\nó~ 3Uä\u008a\u0099¾JÓ\u0007\u0000°4mi\u0016\u009eÛ³\u0087ç8\u0014íI¦}Só> jU¹\u008aÄ¾\u001bó) gU¢\u008aù¾\u0007ÓA\u0000ò4?iC\u009e±³Óçx\u0014¨Iû}\u0005\u0092_óa fU³\u008aÜ¾QÓC\u0000ã47i[\u009e½³Æçc\u0014®I÷óa fU³\u008aÜ¾QÓA\u0000é49iE\u009e\u0087³Âç%\u0014¼Ió}\u0015\u0092_Çìû#(x]\u008erá¦\u0015Û£\bô<\u0017QFóa fU³\u008aÜ¾QÓA\u0000é49iE\u009e\u0087³Âç%\u0014¹I÷}\b\u0092CÇêóa fU³\u008aÜ¾QÓA\u0000é49iE\u009e\u0087³Âç%\u0014¯I÷}\u000b\u0092OÇê\u0012ûÁë´5kC_Ë2ÙáyÕ\u00ad\u0088Á\u007f'RX\u0006âõ%¨k\u009c\u0099óa qU¯\u008aÙ¾\nÓW\u0000ë4uiB\u009e\u008b³Ôç%\u0014²Iû}\u0004\u0092YÇÑû/(w]\u0086rÒ¦\u001dÛ¥\bÅ<\nQG\u0086\u0094º?ïy\u001c\u008d1×e\u001f\u009a£Ï÷ãx\u0010YE\u0091RÖ\u0081Ñô\u0004+k\u001færç¡B\u0095\u0099ÈÆ?2\u0012qFÎ[Ü\u0088Ûý\u000e\"a\u0016ì{í¨H\u009c\u0093ÁÌ6+\u001bbOÚ¼\u0006án2iG¼\u0098Ó¬^ÁN\u0012æ&6{J\u008c\u0088¡Íõ*\u0006³[îo\u001d\u0080SÕîé!:}O\u0080`Ã´\u0019óa qU¯\u008aÙ¾\nÓW\u0000ë4uiB\u009e\u008b³Ôç%\u0014²Iû}\u0004\u0092XÇýû6(p]\u0085rÒ¦\u0016Û£\bè<1QH\u0086\u0098º#ï0\u001c¡1Éóa fU³\u008aÜ¾QÓP\u0000õ4.iO\u009e\u0081³Õçoóa fU³\u008aÜ¾QÓP\u0000õ4.iI\u009e\u009b³Äçe%\u0090ö\u0097\u0083B\\-h \u0005¡Ö\u0004âß¿²Hve 1\u0095¡ÉrÎ\u0007\u001bØtìù\u0081øR]f\u0086;éÌ8áwµÇ|\u008f¯\u0088Ú]\u000521¿\\¾\u008f\u001b»Àæ¶\u0011a<+h\u0083MÊ\u009eÍë\u00184w\u0000úmû¾^\u008a\u0085×õ .\r|YÈª\u0005÷ZqR¢U×\u0080\bï<bQc\u0082Æ¶\u001dëB\u001c¸1èe\\fAµFÀ\u0097\u001fþ+?F=\u0095Â¡\u0015üy\u000b¬&úrE\u0081\u009fÜÖè5\u00075R\u0080n\u001a½TÈåçü3!N\u0092\u009dÑóa oU¸\u008aÞ¾QÓE\u0000ï44iJ\u009e\u008d³Áçy\u0014ñIÐ}\u0015\u0092NÇÝû*(w]\u0098rÛ¦\u0016Û\u0080\bõ<\u0002QF\u0086\u0093º8ÿ',8Yâ\u0086Ô²mß1\fð8neZ\u0092ï¿\u0088ët\u0018¨E¨q\u0012\u009eDË\u0083÷Y$nQÔ~Àª\u001b×¾\u0004\u0081(pûc\u008eµQÔe\f\b\fÛþï$²OE\u009chÕ<oÏ¼£øpâ\u00056Ú\fîÂóa rU¤\u008aÅ¾\u001dÓ\u001d\u0000õ4?iB\u009e\u0084³\u0099çg\u0014¿Iâ}\u0015ó) pU·\u008aÆ¾\u0012Ó]\u0000å4tiI\u009e\u008d³Úçn\u0014¸Iû}\u0015\u0092RÇ û1(yA\u0004\u0092Mç\u00928Ë\f\u0014aQ²ó\u0086#Ûj,·\u0001äU\u0002¦\u008bûÛMÇ\u009eÁë\u00044o\u0000÷mù¾E\u008a\u0098×á %\rOYÏª\u0017÷PÃ¥,ÿy[EÊ\u0096Èã!Ìtó, nU£\u008aÏ¾\rÓF\u0000ç49iE\u009e\u0091\u008e\u009f]\u0099(\\÷7Ã¯®¡}\u0017IÑ\u0014¾ãhÎ;\u008f[\\\u0003)Úö±Ân¯7óa fU·\u008aÞ¾\u001fÓ\u001d\u0000â45iY\u009e\u008c³Úçe\u0014¿Iö}\u0015\u0092\u0015Ç û&(f]Årß¦\u0002Û¶\bé<@QZ\u0086\u009bº&óa rU¤\u008aÅ¾\u001dÓ\u001d\u0000å4*i[\u009e\u008b³Øçl\u0014±ºÁi¥\u001crÃ\u0006÷Ð\u009a\u0093I=}úóa rU¤\u008aÅ¾\u001dÓ\u001d\u0000ë45iJ\u009e\u0097³Úço\u0014\u00ad\u0013åÀ½µdj\u000f^Ä3\u009aà>Ôô\u0089\u0087hÅ»ÂÎ\u0013\u0011z%»H¹\u009bO¯\u0097òù\u0005%(=|Þ\u008f\bÒYæ¤\t÷\\F`\u0083³ÁÆaéy=£@\u0010\u0093\u0011§úÊ©\u001d1!\u0081t×\u0087Xªoþ·\u0001\tTTx\u009d\u008bøÞ3ád5ÖXPkg¿£Âÿ\u0015[9\u0093LÛ\u009f'".getBytes("ISO-8859-1")).asCharBuffer().get(cArr, 0, 2469);
        getAuthRequestContext = cArr;
        BuiltInFictitiousFunctionClassFactory = 4239718878839447554L;
    }

    public static final String getAuthRequestContext(File file, Context context) {
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(context, "");
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "");
        SimpleStorage.Companion companion = SimpleStorage.INSTANCE;
        if (StringsKt.startsWith$default(path, SimpleStorage.Companion.KClassImpl$Data$declaredNonStaticMembers$2(), false, 2, (Object) null)) {
            return PromoActionType.PRIMARY;
        }
        String path2 = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path2, "");
        String path3 = MyBillsEntityDataFactory(context).getPath();
        Intrinsics.checkNotNullExpressionValue(path3, "");
        if (StringsKt.startsWith$default(path2, path3, false, 2, (Object) null)) {
            return "data";
        }
        String path4 = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path4, "");
        return StringsKt.substringBefore$default(StringsKt.substringAfter(path4, "/storage/", ""), '/', (String) null, 2, (Object) null);
    }

    public static final File MyBillsEntityDataFactory(File file, String str) {
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(str, "");
        return new File(file, str);
    }

    @JvmName(name = "getDataDirectory")
    public static final File MyBillsEntityDataFactory(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        if (Build.VERSION.SDK_INT > 23) {
            File dataDir = context.getDataDir();
            Intrinsics.checkNotNullExpressionValue(dataDir, "");
            return dataDir;
        }
        File parentFile = context.getFilesDir().getParentFile();
        Intrinsics.checkNotNull(parentFile);
        return parentFile;
    }

    public static final String KClassImpl$Data$declaredNonStaticMembers$2(File file, Context context) {
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(context, "");
        SimpleStorage.Companion companion = SimpleStorage.INSTANCE;
        String KClassImpl$Data$declaredNonStaticMembers$2 = SimpleStorage.Companion.KClassImpl$Data$declaredNonStaticMembers$2();
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "");
        if (StringsKt.startsWith$default(path, KClassImpl$Data$declaredNonStaticMembers$2, false, 2, (Object) null)) {
            String path2 = file.getPath();
            Intrinsics.checkNotNullExpressionValue(path2, "");
            return TextUtils.BuiltInFictitiousFunctionClassFactory(StringsKt.substringAfter(path2, KClassImpl$Data$declaredNonStaticMembers$2, ""));
        }
        String path3 = MyBillsEntityDataFactory(context).getPath();
        String path4 = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path4, "");
        Intrinsics.checkNotNullExpressionValue(path3, "");
        if (StringsKt.startsWith$default(path4, path3, false, 2, (Object) null)) {
            String path5 = file.getPath();
            Intrinsics.checkNotNullExpressionValue(path5, "");
            return TextUtils.BuiltInFictitiousFunctionClassFactory(StringsKt.substringAfter(path5, path3, ""));
        }
        String authRequestContext = getAuthRequestContext(file, context);
        String path6 = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path6, "");
        return TextUtils.BuiltInFictitiousFunctionClassFactory(StringsKt.substringAfter(path6, Intrinsics.stringPlus("/storage/", authRequestContext), ""));
    }

    public static final boolean MyBillsEntityDataFactory(File file, Context context) {
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(context, "");
        return file.canRead() && BuiltInFictitiousFunctionClassFactory(file, context);
    }

    public static final boolean PlaceComponentResult(File file, Context context, boolean z) {
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(context, "");
        return (z && BuiltInFictitiousFunctionClassFactory(file, context)) || !z;
    }

    public static final boolean getAuthRequestContext(File file, Context context, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(context, "");
        return file.canRead() && PlaceComponentResult(file, context, z) && (z2 || PlaceComponentResult(file, context));
    }

    public static final boolean PlaceComponentResult(File file) {
        Intrinsics.checkNotNullParameter(file, "");
        if (!file.isFile()) {
            if (!file.createNewFile()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean BuiltInFictitiousFunctionClassFactory(File file, Context context) {
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(context, "");
        return file.canWrite() && (file.isFile() || PlaceComponentResult(file, context));
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0039, code lost:
    
        if (com.anggrayudi.storage.SimpleStorage.Companion.getAuthRequestContext(r11) == false) goto L59;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean PlaceComponentResult(java.io.File r10, android.content.Context r11) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 29
            r3 = 0
            r4 = 1
            if (r1 <= r2) goto L1a
            boolean r1 = android.os.Environment.isExternalStorageManager(r10)
            if (r1 != 0) goto L17
            goto L1a
        L17:
            r3 = 1
            goto Lc6
        L1a:
            int r1 = android.os.Build.VERSION.SDK_INT
            r5 = 2
            r6 = 0
            if (r1 >= r2) goto L3b
            java.lang.String r1 = r10.getPath()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            com.anggrayudi.storage.SimpleStorage$Companion r2 = com.anggrayudi.storage.SimpleStorage.INSTANCE
            java.lang.String r2 = com.anggrayudi.storage.SimpleStorage.Companion.KClassImpl$Data$declaredNonStaticMembers$2()
            boolean r1 = kotlin.text.StringsKt.startsWith$default(r1, r2, r3, r5, r6)
            if (r1 == 0) goto L3b
            com.anggrayudi.storage.SimpleStorage$Companion r1 = com.anggrayudi.storage.SimpleStorage.INSTANCE
            boolean r1 = com.anggrayudi.storage.SimpleStorage.Companion.getAuthRequestContext(r11)
            if (r1 != 0) goto L17
        L3b:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.io.File[] r1 = new java.io.File[r4]
            java.io.File r2 = MyBillsEntityDataFactory(r11)
            r1[r3] = r2
            java.util.Set r1 = kotlin.collections.SetsKt.mutableSetOf(r1)
            java.io.File[] r2 = androidx.core.content.ContextCompat.MyBillsEntityDataFactory(r11)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            java.lang.Object[] r2 = (java.lang.Object[]) r2
            java.util.List r2 = kotlin.collections.ArraysKt.filterNotNull(r2)
            java.util.Collection r2 = (java.util.Collection) r2
            r1.addAll(r2)
            java.io.File[] r11 = androidx.core.content.ContextCompat.getAuthRequestContext(r11, r6)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)
            java.lang.Object[] r11 = (java.lang.Object[]) r11
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            int r7 = r11.length
            r8 = 0
        L6e:
            if (r8 >= r7) goto L84
            r9 = r11[r8]
            java.io.File r9 = (java.io.File) r9
            if (r9 != 0) goto L78
            r9 = r6
            goto L7c
        L78:
            java.io.File r9 = r9.getParentFile()
        L7c:
            if (r9 == 0) goto L81
            r2.add(r9)
        L81:
            int r8 = r8 + 1
            goto L6e
        L84:
            java.util.List r2 = (java.util.List) r2
            java.util.Collection r2 = (java.util.Collection) r2
            r1.addAll(r2)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            boolean r11 = r1 instanceof java.util.Collection
            if (r11 == 0) goto L9b
            r11 = r1
            java.util.Collection r11 = (java.util.Collection) r11
            boolean r11 = r11.isEmpty()
            if (r11 == 0) goto L9b
            goto Lc1
        L9b:
            java.util.Iterator r11 = r1.iterator()
        L9f:
            boolean r1 = r11.hasNext()
            if (r1 == 0) goto Lc1
            java.lang.Object r1 = r11.next()
            java.io.File r1 = (java.io.File) r1
            java.lang.String r2 = r10.getPath()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            java.lang.String r1 = r1.getPath()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            boolean r1 = kotlin.text.StringsKt.startsWith$default(r2, r1, r3, r5, r6)
            if (r1 == 0) goto L9f
            r10 = 1
            goto Lc2
        Lc1:
            r10 = 0
        Lc2:
            if (r10 == 0) goto Lc6
            goto L17
        Lc6:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.FileUtils.PlaceComponentResult(java.io.File, android.content.Context):boolean");
    }

    public static final File getAuthRequestContext(File file, Context context, String str, String str2, CreateMode createMode) {
        File file2;
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(createMode, "");
        if (file.isDirectory() && BuiltInFictitiousFunctionClassFactory(file, context)) {
            DocumentFileCompat documentFileCompat = DocumentFileCompat.KClassImpl$Data$declaredNonStaticMembers$2;
            String BuiltInFictitiousFunctionClassFactory2 = TextUtils.BuiltInFictitiousFunctionClassFactory(DocumentFileCompat.KClassImpl$Data$declaredNonStaticMembers$2(str));
            String substringBeforeLast = StringsKt.substringBeforeLast(BuiltInFictitiousFunctionClassFactory2, '/', "");
            if (substringBeforeLast.length() == 0) {
                file2 = file;
            } else {
                file2 = new File(file, substringBeforeLast);
                file2.mkdirs();
            }
            String substringAfterLast$default = StringsKt.substringAfterLast$default(BuiltInFictitiousFunctionClassFactory2, '/', (String) null, 2, (Object) null);
            String MyBillsEntityDataFactory = MimeType.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory2);
            if (!(MyBillsEntityDataFactory.length() > 0) || (str2 != null && !Intrinsics.areEqual(str2, "*/*") && !Intrinsics.areEqual(str2, ZebraLoader.MIME_TYPE_STREAM))) {
                MyBillsEntityDataFactory = MimeType.KClassImpl$Data$declaredNonStaticMembers$2(str2, BuiltInFictitiousFunctionClassFactory2);
            }
            String removeSuffix = StringsKt.removeSuffix(substringAfterLast$default, (CharSequence) Intrinsics.stringPlus(".", MyBillsEntityDataFactory));
            StringBuilder sb = new StringBuilder();
            sb.append(removeSuffix);
            sb.append('.');
            sb.append(MyBillsEntityDataFactory);
            String trimEnd = StringsKt.trimEnd(sb.toString(), '.');
            if (createMode != CreateMode.CREATE_NEW) {
                File file3 = new File(file2, trimEnd);
                if (!file3.exists()) {
                    file3 = null;
                }
                if (file3 != null) {
                    if (createMode == CreateMode.REPLACE) {
                        if (!BuiltInFictitiousFunctionClassFactory(file3)) {
                            return null;
                        }
                    } else if (!file3.isFile()) {
                        return null;
                    }
                    return file3;
                }
            }
            try {
                File file4 = new File(file2, KClassImpl$Data$declaredNonStaticMembers$2(file, trimEnd));
                if (file4.createNewFile()) {
                    return file4;
                }
                return null;
            } catch (IOException unused) {
                return null;
            }
        }
        return null;
    }

    public static final File BuiltInFictitiousFunctionClassFactory(File file, Context context, String str, CreateMode createMode) {
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(createMode, "");
        if (file.isDirectory() && BuiltInFictitiousFunctionClassFactory(file, context)) {
            DocumentFileCompat documentFileCompat = DocumentFileCompat.KClassImpl$Data$declaredNonStaticMembers$2;
            DocumentFileCompat documentFileCompat2 = DocumentFileCompat.KClassImpl$Data$declaredNonStaticMembers$2;
            List mutableList = CollectionsKt.toMutableList((Collection) DocumentFileCompat.PlaceComponentResult(DocumentFileCompat.KClassImpl$Data$declaredNonStaticMembers$2(str)));
            String str2 = (String) CollectionsKt.removeFirstOrNull(mutableList);
            if (str2 == null) {
                return null;
            }
            if (createMode == CreateMode.CREATE_NEW) {
                str2 = KClassImpl$Data$declaredNonStaticMembers$2(file, str2);
            }
            Intrinsics.checkNotNullParameter(file, "");
            Intrinsics.checkNotNullParameter(str2, "");
            File file2 = new File(file, str2);
            if (createMode == CreateMode.REPLACE) {
                MyBillsEntityDataFactory(file2, true);
            }
            file2.mkdir();
            if (!mutableList.isEmpty()) {
                String joinToString$default = CollectionsKt.joinToString$default(mutableList, "/", null, null, 0, null, null, 62, null);
                Intrinsics.checkNotNullParameter(file2, "");
                Intrinsics.checkNotNullParameter(joinToString$default, "");
                File file3 = new File(file2, joinToString$default);
                file3.mkdirs();
                file2 = file3;
            }
            if (file2.isDirectory()) {
                return file2;
            }
            return null;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean MyBillsEntityDataFactory(java.io.File r3, boolean r4) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            boolean r0 = r3.isDirectory()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L32
            boolean r0 = kotlin.io.FilesKt.deleteRecursively(r3)
            if (r4 == 0) goto L30
            r3.mkdir()
            boolean r4 = r3.isDirectory()
            if (r4 == 0) goto L3f
            java.lang.String[] r3 = r3.list()
            if (r3 == 0) goto L2c
            int r3 = r3.length
            if (r3 != 0) goto L27
            r3 = 1
            goto L28
        L27:
            r3 = 0
        L28:
            if (r3 != 0) goto L2c
            r3 = 0
            goto L2d
        L2c:
            r3 = 1
        L2d:
            if (r3 == 0) goto L3f
            goto L40
        L30:
            r1 = r0
            goto L40
        L32:
            boolean r4 = r3.delete()
            if (r4 != 0) goto L40
            boolean r3 = r3.exists()
            if (r3 != 0) goto L3f
            goto L40
        L3f:
            r1 = 0
        L40:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.FileUtils.MyBillsEntityDataFactory(java.io.File, boolean):boolean");
    }

    public static final boolean BuiltInFictitiousFunctionClassFactory(File file) {
        Intrinsics.checkNotNullParameter(file, "");
        MyBillsEntityDataFactory(file, false);
        return MyBillsEntityDataFactory(file);
    }

    private static boolean MyBillsEntityDataFactory(File file) {
        Intrinsics.checkNotNullParameter(file, "");
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0062, code lost:
    
        if (com.anggrayudi.storage.file.DocumentFileCompat.BuiltInFictitiousFunctionClassFactory().matches(r11) != false) goto L69;
     */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x006b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String KClassImpl$Data$declaredNonStaticMembers$2(java.io.File r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.FileUtils.KClassImpl$Data$declaredNonStaticMembers$2(java.io.File, java.lang.String):java.lang.String");
    }
}
