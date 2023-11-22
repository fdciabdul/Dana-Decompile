package id.dana.data.homeinfo.model;

import com.alibaba.fastjson.annotation.JSONCreator;
import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.constant.UrlParam;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\u0000\n\u0002\b[\b\u0086\b\u0018\u00002\u00020\u0001B\u00ad\u0003\b\u0007\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010?\u001a\u00020\t\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010F\u001a\u00020\t\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010I\u001a\u00020\t\u0012\u0010\b\u0002\u0010J\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0019\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010N\u001a\u00020\t\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\t¢\u0006\u0006\b±\u0001\u0010²\u0001J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0013\u0010\u000bJ\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0018\u0010\u000bJ\u0018\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0019HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0004J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0004J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0004J\u0010\u0010\u001f\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u001f\u0010\u000bJ\u0012\u0010 \u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u0004J\u0012\u0010\"\u001a\u0004\u0018\u00010!HÆ\u0003¢\u0006\u0004\b\"\u0010#J\u0012\u0010$\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b$\u0010\u0004J\u0012\u0010&\u001a\u0004\u0018\u00010%HÆ\u0003¢\u0006\u0004\b&\u0010'J\u0012\u0010(\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b(\u0010\u0004J\u0012\u0010)\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b)\u0010\u0004J\u0012\u0010*\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b*\u0010+J\u0012\u0010,\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b,\u0010\u0004J\u0012\u0010-\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b-\u0010\u0004J\u0012\u0010.\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b.\u0010\u0004J\u0012\u0010/\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b/\u0010\u0004J\u0012\u00100\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b0\u0010\u0004J\u0012\u00101\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b1\u0010\u0004J²\u0003\u0010U\u001a\u00020\u00002\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010?\u001a\u00020\t2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010F\u001a\u00020\t2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010I\u001a\u00020\t2\u0010\b\u0002\u0010J\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00192\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010N\u001a\u00020\t2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\bU\u0010VJ\u001a\u0010Y\u001a\u00020\t2\b\u0010X\u001a\u0004\u0018\u00010WHÖ\u0003¢\u0006\u0004\bY\u0010ZJ\u0010\u0010[\u001a\u00020!HÖ\u0001¢\u0006\u0004\b[\u0010\\J\u0010\u0010]\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b]\u0010\u0004R$\u00103\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010^\u001a\u0004\b_\u0010\u0004\"\u0004\b`\u0010aR$\u0010T\u001a\u0004\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bT\u0010b\u001a\u0004\bc\u0010+\"\u0004\bd\u0010eR$\u00105\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010^\u001a\u0004\bf\u0010\u0004\"\u0004\bg\u0010aR$\u0010Q\u001a\u0004\u0018\u00010%8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bQ\u0010h\u001a\u0004\bi\u0010'\"\u0004\bj\u0010kR$\u0010L\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bL\u0010^\u001a\u0004\bl\u0010\u0004\"\u0004\bm\u0010aR$\u0010B\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010^\u001a\u0004\bn\u0010\u0004\"\u0004\bo\u0010aR$\u00104\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010^\u001a\u0004\bp\u0010\u0004\"\u0004\bq\u0010aR$\u0010@\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010^\u001a\u0004\br\u0010\u0004\"\u0004\bs\u0010aR$\u0010P\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bP\u0010^\u001a\u0004\bt\u0010\u0004\"\u0004\bu\u0010aR\"\u0010?\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010v\u001a\u0004\bw\u0010\u000b\"\u0004\bx\u0010yR\"\u0010F\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bF\u0010v\u001a\u0004\bz\u0010\u000b\"\u0004\b{\u0010yR$\u0010S\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bS\u0010^\u001a\u0004\b|\u0010\u0004\"\u0004\b}\u0010aR$\u00106\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b6\u0010^\u001a\u0004\b~\u0010\u0004\"\u0004\b\u007f\u0010aR&\u0010R\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bR\u0010^\u001a\u0005\b\u0080\u0001\u0010\u0004\"\u0005\b\u0081\u0001\u0010aR#\u0010N\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0013\n\u0004\bN\u0010v\u001a\u0004\bN\u0010\u000b\"\u0005\b\u0082\u0001\u0010yR&\u00102\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\b2\u0010^\u001a\u0005\b\u0083\u0001\u0010\u0004\"\u0005\b\u0084\u0001\u0010aR&\u0010D\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bD\u0010^\u001a\u0005\b\u0085\u0001\u0010\u0004\"\u0005\b\u0086\u0001\u0010aR&\u00107\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\b7\u0010^\u001a\u0005\b\u0087\u0001\u0010\u0004\"\u0005\b\u0088\u0001\u0010aR&\u00108\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\b8\u0010^\u001a\u0005\b\u0089\u0001\u0010\u0004\"\u0005\b\u008a\u0001\u0010aR&\u00109\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\b9\u0010^\u001a\u0005\b\u008b\u0001\u0010\u0004\"\u0005\b\u008c\u0001\u0010aR&\u0010:\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\b:\u0010^\u001a\u0005\b\u008d\u0001\u0010\u0004\"\u0005\b\u008e\u0001\u0010aR$\u0010I\u001a\u00020\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bI\u0010v\u001a\u0005\b\u008f\u0001\u0010\u000b\"\u0005\b\u0090\u0001\u0010yR&\u0010M\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bM\u0010^\u001a\u0005\b\u0091\u0001\u0010\u0004\"\u0005\b\u0092\u0001\u0010aR&\u0010;\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\b;\u0010^\u001a\u0005\b\u0093\u0001\u0010\u0004\"\u0005\b\u0094\u0001\u0010aR&\u0010<\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\b<\u0010^\u001a\u0005\b\u0095\u0001\u0010\u0004\"\u0005\b\u0096\u0001\u0010aR&\u0010E\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bE\u0010^\u001a\u0005\b\u0097\u0001\u0010\u0004\"\u0005\b\u0098\u0001\u0010aR(\u0010O\u001a\u0004\u0018\u00010!8\u0007@\u0007X\u0087\u000e¢\u0006\u0016\n\u0005\bO\u0010\u0099\u0001\u001a\u0005\b\u009a\u0001\u0010#\"\u0006\b\u009b\u0001\u0010\u009c\u0001R&\u0010=\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\b=\u0010^\u001a\u0005\b\u009d\u0001\u0010\u0004\"\u0005\b\u009e\u0001\u0010aR&\u0010K\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bK\u0010^\u001a\u0005\b\u009f\u0001\u0010\u0004\"\u0005\b \u0001\u0010aR(\u0010H\u001a\u0004\u0018\u00010\u00158\u0007@\u0007X\u0087\u000e¢\u0006\u0016\n\u0005\bH\u0010¡\u0001\u001a\u0005\b¢\u0001\u0010\u0017\"\u0006\b£\u0001\u0010¤\u0001R.\u0010J\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00198\u0007@\u0007X\u0087\u000e¢\u0006\u0016\n\u0005\bJ\u0010¥\u0001\u001a\u0005\b¦\u0001\u0010\u001b\"\u0006\b§\u0001\u0010¨\u0001R&\u0010G\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bG\u0010^\u001a\u0005\b©\u0001\u0010\u0004\"\u0005\bª\u0001\u0010aR&\u0010C\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bC\u0010^\u001a\u0005\b«\u0001\u0010\u0004\"\u0005\b¬\u0001\u0010aR&\u0010A\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bA\u0010^\u001a\u0005\b\u00ad\u0001\u0010\u0004\"\u0005\b®\u0001\u0010aR&\u0010>\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\b>\u0010^\u001a\u0005\b¯\u0001\u0010\u0004\"\u0005\b°\u0001\u0010a"}, d2 = {"Lid/dana/data/homeinfo/model/ThirdPartyEntity;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "component13", "", "component14", "()Z", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "Lid/dana/data/homeinfo/model/SkuAttributeEntity;", "component23", "()Lid/dana/data/homeinfo/model/SkuAttributeEntity;", "component24", "", "component25", "()Ljava/util/List;", "component26", "component27", "component28", "component29", "component3", "", "component30", "()Ljava/lang/Integer;", "component31", "Lid/dana/data/homeinfo/model/BannerLottieEntity;", "component32", "()Lid/dana/data/homeinfo/model/BannerLottieEntity;", "component33", "component34", "component35", "()Ljava/lang/Boolean;", "component4", "component5", "component6", "component7", "component8", "component9", "key", "action", "clientId", "appId", "icon", "link", "name", "nameInd", "nameTag", "operationType", "redirectUrl", "scopes", "userAction", "enable", "description", "subtitleColor", "buttonTitle", "subtitleBorderColor", "keyword", "ribbonText", "hasRedDot", "spmId", "skuAttr", UrlParam.NEED_CONSULT, "spaceCodes", "screenOrientation", "bizType", BranchLinkConstant.MiniAppParams.NEED_OAUTH, "isBiller", "rotationDelayTime", "directOpen", "bannerLottie", "iconLottie", "headerBackgroundColor", "alwaysConsult", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lid/dana/data/homeinfo/model/SkuAttributeEntity;ZLjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/String;Lid/dana/data/homeinfo/model/BannerLottieEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lid/dana/data/homeinfo/model/ThirdPartyEntity;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAction", "setAction", "(Ljava/lang/String;)V", "Ljava/lang/Boolean;", "getAlwaysConsult", "setAlwaysConsult", "(Ljava/lang/Boolean;)V", "getAppId", "setAppId", "Lid/dana/data/homeinfo/model/BannerLottieEntity;", "getBannerLottie", "setBannerLottie", "(Lid/dana/data/homeinfo/model/BannerLottieEntity;)V", "getBizType", "setBizType", "getButtonTitle", "setButtonTitle", "getClientId", "setClientId", "getDescription", "setDescription", "getDirectOpen", "setDirectOpen", "Z", "getEnable", "setEnable", "(Z)V", "getHasRedDot", "setHasRedDot", "getHeaderBackgroundColor", "setHeaderBackgroundColor", "getIcon", "setIcon", "getIconLottie", "setIconLottie", "setBiller", "getKey", "setKey", "getKeyword", "setKeyword", "getLink", "setLink", "getName", "setName", "getNameInd", "setNameInd", "getNameTag", "setNameTag", "getNeedConsult", "setNeedConsult", "getNeedOauth", "setNeedOauth", "getOperationType", "setOperationType", "getRedirectUrl", "setRedirectUrl", "getRibbonText", "setRibbonText", "Ljava/lang/Integer;", "getRotationDelayTime", "setRotationDelayTime", "(Ljava/lang/Integer;)V", "getScopes", "setScopes", "getScreenOrientation", "setScreenOrientation", "Lid/dana/data/homeinfo/model/SkuAttributeEntity;", "getSkuAttr", "setSkuAttr", "(Lid/dana/data/homeinfo/model/SkuAttributeEntity;)V", "Ljava/util/List;", "getSpaceCodes", "setSpaceCodes", "(Ljava/util/List;)V", "getSpmId", "setSpmId", "getSubtitleBorderColor", "setSubtitleBorderColor", "getSubtitleColor", "setSubtitleColor", "getUserAction", "setUserAction", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lid/dana/data/homeinfo/model/SkuAttributeEntity;ZLjava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/String;Lid/dana/data/homeinfo/model/BannerLottieEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ThirdPartyEntity implements Serializable {
    public String action;
    public Boolean alwaysConsult;
    public String appId;
    public BannerLottieEntity bannerLottie;
    public String bizType;
    public String buttonTitle;
    public String clientId;
    public String description;
    public String directOpen;
    public boolean enable;
    public boolean hasRedDot;
    public String headerBackgroundColor;
    public String icon;
    public String iconLottie;
    public boolean isBiller;
    public String key;
    public String keyword;
    public String link;
    public String name;
    public String nameInd;
    public String nameTag;
    public boolean needConsult;
    public String needOauth;
    public String operationType;
    public String redirectUrl;
    public String ribbonText;
    public Integer rotationDelayTime;
    public String scopes;
    public String screenOrientation;
    public SkuAttributeEntity skuAttr;
    public List<String> spaceCodes;
    public String spmId;
    public String subtitleBorderColor;
    public String subtitleColor;
    public String userAction;

    @JSONCreator
    public ThirdPartyEntity() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, false, null, null, false, null, null, null, null, false, null, null, null, null, null, null, -1, 7, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* renamed from: component10  reason: from getter */
    public final String getOperationType() {
        return this.operationType;
    }

    /* renamed from: component11  reason: from getter */
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    /* renamed from: component12  reason: from getter */
    public final String getScopes() {
        return this.scopes;
    }

    /* renamed from: component13  reason: from getter */
    public final String getUserAction() {
        return this.userAction;
    }

    /* renamed from: component14  reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* renamed from: component15  reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component16  reason: from getter */
    public final String getSubtitleColor() {
        return this.subtitleColor;
    }

    /* renamed from: component17  reason: from getter */
    public final String getButtonTitle() {
        return this.buttonTitle;
    }

    /* renamed from: component18  reason: from getter */
    public final String getSubtitleBorderColor() {
        return this.subtitleBorderColor;
    }

    /* renamed from: component19  reason: from getter */
    public final String getKeyword() {
        return this.keyword;
    }

    /* renamed from: component2  reason: from getter */
    public final String getAction() {
        return this.action;
    }

    /* renamed from: component20  reason: from getter */
    public final String getRibbonText() {
        return this.ribbonText;
    }

    /* renamed from: component21  reason: from getter */
    public final boolean getHasRedDot() {
        return this.hasRedDot;
    }

    /* renamed from: component22  reason: from getter */
    public final String getSpmId() {
        return this.spmId;
    }

    /* renamed from: component23  reason: from getter */
    public final SkuAttributeEntity getSkuAttr() {
        return this.skuAttr;
    }

    /* renamed from: component24  reason: from getter */
    public final boolean getNeedConsult() {
        return this.needConsult;
    }

    public final List<String> component25() {
        return this.spaceCodes;
    }

    /* renamed from: component26  reason: from getter */
    public final String getScreenOrientation() {
        return this.screenOrientation;
    }

    /* renamed from: component27  reason: from getter */
    public final String getBizType() {
        return this.bizType;
    }

    /* renamed from: component28  reason: from getter */
    public final String getNeedOauth() {
        return this.needOauth;
    }

    /* renamed from: component29  reason: from getter */
    public final boolean getIsBiller() {
        return this.isBiller;
    }

    /* renamed from: component3  reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* renamed from: component30  reason: from getter */
    public final Integer getRotationDelayTime() {
        return this.rotationDelayTime;
    }

    /* renamed from: component31  reason: from getter */
    public final String getDirectOpen() {
        return this.directOpen;
    }

    /* renamed from: component32  reason: from getter */
    public final BannerLottieEntity getBannerLottie() {
        return this.bannerLottie;
    }

    /* renamed from: component33  reason: from getter */
    public final String getIconLottie() {
        return this.iconLottie;
    }

    /* renamed from: component34  reason: from getter */
    public final String getHeaderBackgroundColor() {
        return this.headerBackgroundColor;
    }

    /* renamed from: component35  reason: from getter */
    public final Boolean getAlwaysConsult() {
        return this.alwaysConsult;
    }

    /* renamed from: component4  reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* renamed from: component5  reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component6  reason: from getter */
    public final String getLink() {
        return this.link;
    }

    /* renamed from: component7  reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component8  reason: from getter */
    public final String getNameInd() {
        return this.nameInd;
    }

    /* renamed from: component9  reason: from getter */
    public final String getNameTag() {
        return this.nameTag;
    }

    public final ThirdPartyEntity copy(String key, String action, String clientId, String appId, String icon, String link, String name, String nameInd, String nameTag, String operationType, String redirectUrl, String scopes, String userAction, boolean enable, String description, String subtitleColor, String buttonTitle, String subtitleBorderColor, String keyword, String ribbonText, boolean hasRedDot, String spmId, SkuAttributeEntity skuAttr, boolean needConsult, List<String> spaceCodes, String screenOrientation, String bizType, String needOauth, boolean isBiller, Integer rotationDelayTime, String directOpen, BannerLottieEntity bannerLottie, String iconLottie, String headerBackgroundColor, Boolean alwaysConsult) {
        return new ThirdPartyEntity(key, action, clientId, appId, icon, link, name, nameInd, nameTag, operationType, redirectUrl, scopes, userAction, enable, description, subtitleColor, buttonTitle, subtitleBorderColor, keyword, ribbonText, hasRedDot, spmId, skuAttr, needConsult, spaceCodes, screenOrientation, bizType, needOauth, isBiller, rotationDelayTime, directOpen, bannerLottie, iconLottie, headerBackgroundColor, alwaysConsult);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ThirdPartyEntity) {
            ThirdPartyEntity thirdPartyEntity = (ThirdPartyEntity) other;
            return Intrinsics.areEqual(this.key, thirdPartyEntity.key) && Intrinsics.areEqual(this.action, thirdPartyEntity.action) && Intrinsics.areEqual(this.clientId, thirdPartyEntity.clientId) && Intrinsics.areEqual(this.appId, thirdPartyEntity.appId) && Intrinsics.areEqual(this.icon, thirdPartyEntity.icon) && Intrinsics.areEqual(this.link, thirdPartyEntity.link) && Intrinsics.areEqual(this.name, thirdPartyEntity.name) && Intrinsics.areEqual(this.nameInd, thirdPartyEntity.nameInd) && Intrinsics.areEqual(this.nameTag, thirdPartyEntity.nameTag) && Intrinsics.areEqual(this.operationType, thirdPartyEntity.operationType) && Intrinsics.areEqual(this.redirectUrl, thirdPartyEntity.redirectUrl) && Intrinsics.areEqual(this.scopes, thirdPartyEntity.scopes) && Intrinsics.areEqual(this.userAction, thirdPartyEntity.userAction) && this.enable == thirdPartyEntity.enable && Intrinsics.areEqual(this.description, thirdPartyEntity.description) && Intrinsics.areEqual(this.subtitleColor, thirdPartyEntity.subtitleColor) && Intrinsics.areEqual(this.buttonTitle, thirdPartyEntity.buttonTitle) && Intrinsics.areEqual(this.subtitleBorderColor, thirdPartyEntity.subtitleBorderColor) && Intrinsics.areEqual(this.keyword, thirdPartyEntity.keyword) && Intrinsics.areEqual(this.ribbonText, thirdPartyEntity.ribbonText) && this.hasRedDot == thirdPartyEntity.hasRedDot && Intrinsics.areEqual(this.spmId, thirdPartyEntity.spmId) && Intrinsics.areEqual(this.skuAttr, thirdPartyEntity.skuAttr) && this.needConsult == thirdPartyEntity.needConsult && Intrinsics.areEqual(this.spaceCodes, thirdPartyEntity.spaceCodes) && Intrinsics.areEqual(this.screenOrientation, thirdPartyEntity.screenOrientation) && Intrinsics.areEqual(this.bizType, thirdPartyEntity.bizType) && Intrinsics.areEqual(this.needOauth, thirdPartyEntity.needOauth) && this.isBiller == thirdPartyEntity.isBiller && Intrinsics.areEqual(this.rotationDelayTime, thirdPartyEntity.rotationDelayTime) && Intrinsics.areEqual(this.directOpen, thirdPartyEntity.directOpen) && Intrinsics.areEqual(this.bannerLottie, thirdPartyEntity.bannerLottie) && Intrinsics.areEqual(this.iconLottie, thirdPartyEntity.iconLottie) && Intrinsics.areEqual(this.headerBackgroundColor, thirdPartyEntity.headerBackgroundColor) && Intrinsics.areEqual(this.alwaysConsult, thirdPartyEntity.alwaysConsult);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        String str = this.key;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.action;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.clientId;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.appId;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.icon;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.link;
        int hashCode6 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.name;
        int hashCode7 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.nameInd;
        int hashCode8 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.nameTag;
        int hashCode9 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.operationType;
        int hashCode10 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.redirectUrl;
        int hashCode11 = str11 == null ? 0 : str11.hashCode();
        String str12 = this.scopes;
        int hashCode12 = str12 == null ? 0 : str12.hashCode();
        String str13 = this.userAction;
        int hashCode13 = str13 == null ? 0 : str13.hashCode();
        boolean z = this.enable;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        String str14 = this.description;
        int hashCode14 = str14 == null ? 0 : str14.hashCode();
        String str15 = this.subtitleColor;
        int hashCode15 = str15 == null ? 0 : str15.hashCode();
        String str16 = this.buttonTitle;
        int hashCode16 = str16 == null ? 0 : str16.hashCode();
        String str17 = this.subtitleBorderColor;
        int hashCode17 = str17 == null ? 0 : str17.hashCode();
        String str18 = this.keyword;
        int hashCode18 = str18 == null ? 0 : str18.hashCode();
        String str19 = this.ribbonText;
        int hashCode19 = str19 == null ? 0 : str19.hashCode();
        boolean z2 = this.hasRedDot;
        int i2 = z2 ? 1 : z2 ? 1 : 0;
        String str20 = this.spmId;
        int hashCode20 = str20 == null ? 0 : str20.hashCode();
        SkuAttributeEntity skuAttributeEntity = this.skuAttr;
        int hashCode21 = skuAttributeEntity == null ? 0 : skuAttributeEntity.hashCode();
        boolean z3 = this.needConsult;
        int i3 = z3 ? 1 : z3 ? 1 : 0;
        List<String> list = this.spaceCodes;
        int hashCode22 = list == null ? 0 : list.hashCode();
        String str21 = this.screenOrientation;
        int hashCode23 = str21 == null ? 0 : str21.hashCode();
        String str22 = this.bizType;
        int hashCode24 = str22 == null ? 0 : str22.hashCode();
        String str23 = this.needOauth;
        int hashCode25 = str23 == null ? 0 : str23.hashCode();
        boolean z4 = this.isBiller;
        int i4 = z4 ? 1 : z4 ? 1 : 0;
        Integer num = this.rotationDelayTime;
        int hashCode26 = num == null ? 0 : num.hashCode();
        String str24 = this.directOpen;
        int hashCode27 = str24 == null ? 0 : str24.hashCode();
        BannerLottieEntity bannerLottieEntity = this.bannerLottie;
        int hashCode28 = bannerLottieEntity == null ? 0 : bannerLottieEntity.hashCode();
        String str25 = this.iconLottie;
        int hashCode29 = str25 == null ? 0 : str25.hashCode();
        String str26 = this.headerBackgroundColor;
        int hashCode30 = str26 == null ? 0 : str26.hashCode();
        Boolean bool = this.alwaysConsult;
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + i) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + hashCode17) * 31) + hashCode18) * 31) + hashCode19) * 31) + i2) * 31) + hashCode20) * 31) + hashCode21) * 31) + i3) * 31) + hashCode22) * 31) + hashCode23) * 31) + hashCode24) * 31) + hashCode25) * 31) + i4) * 31) + hashCode26) * 31) + hashCode27) * 31) + hashCode28) * 31) + hashCode29) * 31) + hashCode30) * 31) + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ThirdPartyEntity(key=");
        sb.append(this.key);
        sb.append(", action=");
        sb.append(this.action);
        sb.append(", clientId=");
        sb.append(this.clientId);
        sb.append(", appId=");
        sb.append(this.appId);
        sb.append(", icon=");
        sb.append(this.icon);
        sb.append(", link=");
        sb.append(this.link);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", nameInd=");
        sb.append(this.nameInd);
        sb.append(", nameTag=");
        sb.append(this.nameTag);
        sb.append(", operationType=");
        sb.append(this.operationType);
        sb.append(", redirectUrl=");
        sb.append(this.redirectUrl);
        sb.append(", scopes=");
        sb.append(this.scopes);
        sb.append(", userAction=");
        sb.append(this.userAction);
        sb.append(", enable=");
        sb.append(this.enable);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", subtitleColor=");
        sb.append(this.subtitleColor);
        sb.append(", buttonTitle=");
        sb.append(this.buttonTitle);
        sb.append(", subtitleBorderColor=");
        sb.append(this.subtitleBorderColor);
        sb.append(", keyword=");
        sb.append(this.keyword);
        sb.append(", ribbonText=");
        sb.append(this.ribbonText);
        sb.append(", hasRedDot=");
        sb.append(this.hasRedDot);
        sb.append(", spmId=");
        sb.append(this.spmId);
        sb.append(", skuAttr=");
        sb.append(this.skuAttr);
        sb.append(", needConsult=");
        sb.append(this.needConsult);
        sb.append(", spaceCodes=");
        sb.append(this.spaceCodes);
        sb.append(", screenOrientation=");
        sb.append(this.screenOrientation);
        sb.append(", bizType=");
        sb.append(this.bizType);
        sb.append(", needOauth=");
        sb.append(this.needOauth);
        sb.append(", isBiller=");
        sb.append(this.isBiller);
        sb.append(", rotationDelayTime=");
        sb.append(this.rotationDelayTime);
        sb.append(", directOpen=");
        sb.append(this.directOpen);
        sb.append(", bannerLottie=");
        sb.append(this.bannerLottie);
        sb.append(", iconLottie=");
        sb.append(this.iconLottie);
        sb.append(", headerBackgroundColor=");
        sb.append(this.headerBackgroundColor);
        sb.append(", alwaysConsult=");
        sb.append(this.alwaysConsult);
        sb.append(')');
        return sb.toString();
    }

    @JSONCreator
    public ThirdPartyEntity(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, boolean z, String str14, String str15, String str16, String str17, String str18, String str19, boolean z2, String str20, SkuAttributeEntity skuAttributeEntity, boolean z3, List<String> list, String str21, String str22, String str23, boolean z4, Integer num, String str24, BannerLottieEntity bannerLottieEntity, String str25, String str26, Boolean bool) {
        this.key = str;
        this.action = str2;
        this.clientId = str3;
        this.appId = str4;
        this.icon = str5;
        this.link = str6;
        this.name = str7;
        this.nameInd = str8;
        this.nameTag = str9;
        this.operationType = str10;
        this.redirectUrl = str11;
        this.scopes = str12;
        this.userAction = str13;
        this.enable = z;
        this.description = str14;
        this.subtitleColor = str15;
        this.buttonTitle = str16;
        this.subtitleBorderColor = str17;
        this.keyword = str18;
        this.ribbonText = str19;
        this.hasRedDot = z2;
        this.spmId = str20;
        this.skuAttr = skuAttributeEntity;
        this.needConsult = z3;
        this.spaceCodes = list;
        this.screenOrientation = str21;
        this.bizType = str22;
        this.needOauth = str23;
        this.isBiller = z4;
        this.rotationDelayTime = num;
        this.directOpen = str24;
        this.bannerLottie = bannerLottieEntity;
        this.iconLottie = str25;
        this.headerBackgroundColor = str26;
        this.alwaysConsult = bool;
    }

    public /* synthetic */ ThirdPartyEntity(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, boolean z, String str14, String str15, String str16, String str17, String str18, String str19, boolean z2, String str20, SkuAttributeEntity skuAttributeEntity, boolean z3, List list, String str21, String str22, String str23, boolean z4, Integer num, String str24, BannerLottieEntity bannerLottieEntity, String str25, String str26, Boolean bool, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? null : str10, (i & 1024) != 0 ? null : str11, (i & 2048) != 0 ? null : str12, (i & 4096) != 0 ? null : str13, (i & 8192) != 0 ? false : z, (i & 16384) != 0 ? null : str14, (i & 32768) != 0 ? null : str15, (i & 65536) != 0 ? null : str16, (i & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? null : str17, (i & 262144) != 0 ? null : str18, (i & 524288) != 0 ? null : str19, (i & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? false : z2, (i & 2097152) != 0 ? null : str20, (i & 4194304) != 0 ? null : skuAttributeEntity, (i & 8388608) != 0 ? false : z3, (i & 16777216) != 0 ? null : list, (i & 33554432) != 0 ? null : str21, (i & 67108864) != 0 ? null : str22, (i & 134217728) != 0 ? null : str23, (i & SQLiteDatabase.CREATE_IF_NECESSARY) == 0 ? z4 : false, (i & 536870912) != 0 ? null : num, (i & 1073741824) != 0 ? null : str24, (i & Integer.MIN_VALUE) != 0 ? null : bannerLottieEntity, (i2 & 1) != 0 ? null : str25, (i2 & 2) != 0 ? null : str26, (i2 & 4) != 0 ? null : bool);
    }

    @JvmName(name = "getKey")
    public final String getKey() {
        return this.key;
    }

    @JvmName(name = "setKey")
    public final void setKey(String str) {
        this.key = str;
    }

    @JvmName(name = "getAction")
    public final String getAction() {
        return this.action;
    }

    @JvmName(name = "setAction")
    public final void setAction(String str) {
        this.action = str;
    }

    @JvmName(name = "getClientId")
    public final String getClientId() {
        return this.clientId;
    }

    @JvmName(name = "setClientId")
    public final void setClientId(String str) {
        this.clientId = str;
    }

    @JvmName(name = "getAppId")
    public final String getAppId() {
        return this.appId;
    }

    @JvmName(name = "setAppId")
    public final void setAppId(String str) {
        this.appId = str;
    }

    @JvmName(name = "getIcon")
    public final String getIcon() {
        return this.icon;
    }

    @JvmName(name = "setIcon")
    public final void setIcon(String str) {
        this.icon = str;
    }

    @JvmName(name = "getLink")
    public final String getLink() {
        return this.link;
    }

    @JvmName(name = "setLink")
    public final void setLink(String str) {
        this.link = str;
    }

    @JvmName(name = "getName")
    public final String getName() {
        return this.name;
    }

    @JvmName(name = "setName")
    public final void setName(String str) {
        this.name = str;
    }

    @JvmName(name = "getNameInd")
    public final String getNameInd() {
        return this.nameInd;
    }

    @JvmName(name = "setNameInd")
    public final void setNameInd(String str) {
        this.nameInd = str;
    }

    @JvmName(name = "getNameTag")
    public final String getNameTag() {
        return this.nameTag;
    }

    @JvmName(name = "setNameTag")
    public final void setNameTag(String str) {
        this.nameTag = str;
    }

    @JvmName(name = "getOperationType")
    public final String getOperationType() {
        return this.operationType;
    }

    @JvmName(name = "setOperationType")
    public final void setOperationType(String str) {
        this.operationType = str;
    }

    @JvmName(name = "getRedirectUrl")
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    @JvmName(name = "setRedirectUrl")
    public final void setRedirectUrl(String str) {
        this.redirectUrl = str;
    }

    @JvmName(name = "getScopes")
    public final String getScopes() {
        return this.scopes;
    }

    @JvmName(name = "setScopes")
    public final void setScopes(String str) {
        this.scopes = str;
    }

    @JvmName(name = "getUserAction")
    public final String getUserAction() {
        return this.userAction;
    }

    @JvmName(name = "setUserAction")
    public final void setUserAction(String str) {
        this.userAction = str;
    }

    @JvmName(name = "getEnable")
    public final boolean getEnable() {
        return this.enable;
    }

    @JvmName(name = "setEnable")
    public final void setEnable(boolean z) {
        this.enable = z;
    }

    @JvmName(name = "getDescription")
    public final String getDescription() {
        return this.description;
    }

    @JvmName(name = "setDescription")
    public final void setDescription(String str) {
        this.description = str;
    }

    @JvmName(name = "getSubtitleColor")
    public final String getSubtitleColor() {
        return this.subtitleColor;
    }

    @JvmName(name = "setSubtitleColor")
    public final void setSubtitleColor(String str) {
        this.subtitleColor = str;
    }

    @JvmName(name = "getButtonTitle")
    public final String getButtonTitle() {
        return this.buttonTitle;
    }

    @JvmName(name = "setButtonTitle")
    public final void setButtonTitle(String str) {
        this.buttonTitle = str;
    }

    @JvmName(name = "getSubtitleBorderColor")
    public final String getSubtitleBorderColor() {
        return this.subtitleBorderColor;
    }

    @JvmName(name = "setSubtitleBorderColor")
    public final void setSubtitleBorderColor(String str) {
        this.subtitleBorderColor = str;
    }

    @JvmName(name = "getKeyword")
    public final String getKeyword() {
        return this.keyword;
    }

    @JvmName(name = "setKeyword")
    public final void setKeyword(String str) {
        this.keyword = str;
    }

    @JvmName(name = "getRibbonText")
    public final String getRibbonText() {
        return this.ribbonText;
    }

    @JvmName(name = "setRibbonText")
    public final void setRibbonText(String str) {
        this.ribbonText = str;
    }

    @JvmName(name = "getHasRedDot")
    public final boolean getHasRedDot() {
        return this.hasRedDot;
    }

    @JvmName(name = "setHasRedDot")
    public final void setHasRedDot(boolean z) {
        this.hasRedDot = z;
    }

    @JvmName(name = "getSpmId")
    public final String getSpmId() {
        return this.spmId;
    }

    @JvmName(name = "setSpmId")
    public final void setSpmId(String str) {
        this.spmId = str;
    }

    @JvmName(name = "getSkuAttr")
    public final SkuAttributeEntity getSkuAttr() {
        return this.skuAttr;
    }

    @JvmName(name = "setSkuAttr")
    public final void setSkuAttr(SkuAttributeEntity skuAttributeEntity) {
        this.skuAttr = skuAttributeEntity;
    }

    @JvmName(name = "getNeedConsult")
    public final boolean getNeedConsult() {
        return this.needConsult;
    }

    @JvmName(name = "setNeedConsult")
    public final void setNeedConsult(boolean z) {
        this.needConsult = z;
    }

    @JvmName(name = "getSpaceCodes")
    public final List<String> getSpaceCodes() {
        return this.spaceCodes;
    }

    @JvmName(name = "setSpaceCodes")
    public final void setSpaceCodes(List<String> list) {
        this.spaceCodes = list;
    }

    @JvmName(name = "getScreenOrientation")
    public final String getScreenOrientation() {
        return this.screenOrientation;
    }

    @JvmName(name = "setScreenOrientation")
    public final void setScreenOrientation(String str) {
        this.screenOrientation = str;
    }

    @JvmName(name = "getBizType")
    public final String getBizType() {
        return this.bizType;
    }

    @JvmName(name = "setBizType")
    public final void setBizType(String str) {
        this.bizType = str;
    }

    @JvmName(name = "getNeedOauth")
    public final String getNeedOauth() {
        return this.needOauth;
    }

    @JvmName(name = "setNeedOauth")
    public final void setNeedOauth(String str) {
        this.needOauth = str;
    }

    @JvmName(name = "isBiller")
    public final boolean isBiller() {
        return this.isBiller;
    }

    @JvmName(name = "setBiller")
    public final void setBiller(boolean z) {
        this.isBiller = z;
    }

    @JvmName(name = "getRotationDelayTime")
    public final Integer getRotationDelayTime() {
        return this.rotationDelayTime;
    }

    @JvmName(name = "setRotationDelayTime")
    public final void setRotationDelayTime(Integer num) {
        this.rotationDelayTime = num;
    }

    @JvmName(name = "getDirectOpen")
    public final String getDirectOpen() {
        return this.directOpen;
    }

    @JvmName(name = "setDirectOpen")
    public final void setDirectOpen(String str) {
        this.directOpen = str;
    }

    @JvmName(name = "getBannerLottie")
    public final BannerLottieEntity getBannerLottie() {
        return this.bannerLottie;
    }

    @JvmName(name = "setBannerLottie")
    public final void setBannerLottie(BannerLottieEntity bannerLottieEntity) {
        this.bannerLottie = bannerLottieEntity;
    }

    @JvmName(name = "getIconLottie")
    public final String getIconLottie() {
        return this.iconLottie;
    }

    @JvmName(name = "setIconLottie")
    public final void setIconLottie(String str) {
        this.iconLottie = str;
    }

    @JvmName(name = "getHeaderBackgroundColor")
    public final String getHeaderBackgroundColor() {
        return this.headerBackgroundColor;
    }

    @JvmName(name = "setHeaderBackgroundColor")
    public final void setHeaderBackgroundColor(String str) {
        this.headerBackgroundColor = str;
    }

    @JvmName(name = "getAlwaysConsult")
    public final Boolean getAlwaysConsult() {
        return this.alwaysConsult;
    }

    @JvmName(name = "setAlwaysConsult")
    public final void setAlwaysConsult(Boolean bool) {
        this.alwaysConsult = bool;
    }
}
