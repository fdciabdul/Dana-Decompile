package id.dana.domain.homeinfo;

import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.constant.UrlParam;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0003\b\u0093\u0001\b\u0086\b\u0018\u00002\u00020\u0001:\u0002¼\u0001BÁ\u0003\u0012\b\b\u0002\u00106\u001a\u00020\u0002\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010:\u001a\u00020\u0011\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010J\u001a\u00020\u0011\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010L\u001a\u00020\u0011\u0012\u0010\b\u0002\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0018\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u001b\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010T\u001a\u00020\u0011\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010W\u001a\u0004\u0018\u00010)\u0012\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\u0011¢\u0006\u0006\bº\u0001\u0010»\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0013J\u0018\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0004J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0004J\u0012\u0010 \u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u0004J\u0012\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u0004J\u0012\u0010\"\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010\u0004J\u0012\u0010$\u001a\u0004\u0018\u00010#HÆ\u0003¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b&\u0010\u0013J\u0012\u0010'\u001a\u0004\u0018\u00010#HÆ\u0003¢\u0006\u0004\b'\u0010%J\u0012\u0010(\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b(\u0010\u0004J\u0012\u0010*\u001a\u0004\u0018\u00010)HÆ\u0003¢\u0006\u0004\b*\u0010+J\u0012\u0010,\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b,\u0010\u0004J\u0012\u0010-\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b-\u0010\u0004J\u0012\u0010.\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b.\u0010/J\u0012\u00100\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b0\u0010\u0004J\u0010\u00101\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b1\u0010\u0013J\u0012\u00102\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b2\u0010\u0004J\u0012\u00103\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b3\u0010\u0004J\u0012\u00104\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b4\u0010\u0004J\u0012\u00105\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b5\u0010\u0004JÈ\u0003\u0010[\u001a\u00020\u00002\b\b\u0002\u00106\u001a\u00020\u00022\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010:\u001a\u00020\u00112\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010J\u001a\u00020\u00112\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010L\u001a\u00020\u00112\u0010\b\u0002\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00182\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010S\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010T\u001a\u00020\u00112\n\b\u0002\u0010U\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010W\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0004\b[\u0010\\J\u001a\u0010^\u001a\u00020\u00112\b\u0010]\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b^\u0010_J\u000f\u0010`\u001a\u00020#H\u0016¢\u0006\u0004\b`\u0010aJ\u0010\u0010b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bb\u0010\u0004R$\u00107\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010c\u001a\u0004\bd\u0010\u0004\"\u0004\be\u0010fR$\u0010Z\u001a\u0004\u0018\u00010\u00118\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bZ\u0010g\u001a\u0004\bh\u0010/\"\u0004\bi\u0010jR$\u00109\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010c\u001a\u0004\bk\u0010\u0004\"\u0004\bl\u0010fR$\u0010W\u001a\u0004\u0018\u00010)8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bW\u0010m\u001a\u0004\bn\u0010+\"\u0004\bo\u0010pR$\u0010Q\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bQ\u0010c\u001a\u0004\bq\u0010\u0004\"\u0004\br\u0010fR$\u0010F\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bF\u0010c\u001a\u0004\bs\u0010\u0004\"\u0004\bt\u0010fR$\u00108\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u0010c\u001a\u0004\bu\u0010\u0004\"\u0004\bv\u0010fR$\u0010D\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bD\u0010c\u001a\u0004\bw\u0010\u0004\"\u0004\bx\u0010fR$\u0010V\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bV\u0010c\u001a\u0004\by\u0010\u0004\"\u0004\bz\u0010fR$\u0010Y\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bY\u0010c\u001a\u0004\b{\u0010\u0004\"\u0004\b|\u0010fR$\u0010;\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010c\u001a\u0004\b}\u0010\u0004\"\u0004\b~\u0010fR%\u0010X\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0013\n\u0004\bX\u0010c\u001a\u0004\b\u007f\u0010\u0004\"\u0005\b\u0080\u0001\u0010fR(\u0010S\u001a\u0004\u0018\u00010#8\u0007@\u0007X\u0087\u000e¢\u0006\u0016\n\u0005\bS\u0010\u0081\u0001\u001a\u0005\b\u0082\u0001\u0010%\"\u0006\b\u0083\u0001\u0010\u0084\u0001R%\u0010T\u001a\u00020\u00118\u0007@\u0007X\u0087\u000e¢\u0006\u0015\n\u0005\bT\u0010\u0085\u0001\u001a\u0004\bT\u0010\u0013\"\u0006\b\u0086\u0001\u0010\u0087\u0001R%\u0010:\u001a\u00020\u00118\u0007@\u0007X\u0087\u000e¢\u0006\u0015\n\u0005\b:\u0010\u0085\u0001\u001a\u0004\b:\u0010\u0013\"\u0006\b\u0088\u0001\u0010\u0087\u0001R%\u0010J\u001a\u00020\u00118\u0007@\u0007X\u0087\u000e¢\u0006\u0015\n\u0005\bJ\u0010\u0085\u0001\u001a\u0004\bJ\u0010\u0013\"\u0006\b\u0089\u0001\u0010\u0087\u0001R$\u00106\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\b6\u0010c\u001a\u0005\b\u008a\u0001\u0010\u0004\"\u0005\b\u008b\u0001\u0010fR&\u0010H\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bH\u0010c\u001a\u0005\b\u008c\u0001\u0010\u0004\"\u0005\b\u008d\u0001\u0010fR&\u0010<\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\b<\u0010c\u001a\u0005\b\u008e\u0001\u0010\u0004\"\u0005\b\u008f\u0001\u0010fR&\u0010=\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\b=\u0010c\u001a\u0005\b\u0090\u0001\u0010\u0004\"\u0005\b\u0091\u0001\u0010fR&\u0010>\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\b>\u0010c\u001a\u0005\b\u0092\u0001\u0010\u0004\"\u0005\b\u0093\u0001\u0010fR&\u0010?\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\b?\u0010c\u001a\u0005\b\u0094\u0001\u0010\u0004\"\u0005\b\u0095\u0001\u0010fR&\u0010L\u001a\u00020\u00118\u0007@\u0007X\u0087\u000e¢\u0006\u0016\n\u0005\bL\u0010\u0085\u0001\u001a\u0005\b\u0096\u0001\u0010\u0013\"\u0006\b\u0097\u0001\u0010\u0087\u0001R&\u0010R\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bR\u0010c\u001a\u0005\b\u0098\u0001\u0010\u0004\"\u0005\b\u0099\u0001\u0010fR&\u0010@\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\b@\u0010c\u001a\u0005\b\u009a\u0001\u0010\u0004\"\u0005\b\u009b\u0001\u0010fR&\u0010A\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bA\u0010c\u001a\u0005\b\u009c\u0001\u0010\u0004\"\u0005\b\u009d\u0001\u0010fR&\u0010I\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bI\u0010c\u001a\u0005\b\u009e\u0001\u0010\u0004\"\u0005\b\u009f\u0001\u0010fR(\u0010U\u001a\u0004\u0018\u00010#8\u0007@\u0007X\u0087\u000e¢\u0006\u0016\n\u0005\bU\u0010\u0081\u0001\u001a\u0005\b \u0001\u0010%\"\u0006\b¡\u0001\u0010\u0084\u0001R&\u0010B\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bB\u0010c\u001a\u0005\b¢\u0001\u0010\u0004\"\u0005\b£\u0001\u0010fR&\u0010P\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bP\u0010c\u001a\u0005\b¤\u0001\u0010\u0004\"\u0005\b¥\u0001\u0010fR(\u0010N\u001a\u0004\u0018\u00010\u001b8\u0007@\u0007X\u0087\u000e¢\u0006\u0016\n\u0005\bN\u0010¦\u0001\u001a\u0005\b§\u0001\u0010\u001d\"\u0006\b¨\u0001\u0010©\u0001R&\u0010O\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bO\u0010c\u001a\u0005\bª\u0001\u0010\u0004\"\u0005\b«\u0001\u0010fR.\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00188\u0007@\u0007X\u0087\u000e¢\u0006\u0016\n\u0005\bM\u0010¬\u0001\u001a\u0005\b\u00ad\u0001\u0010\u001a\"\u0006\b®\u0001\u0010¯\u0001R(\u0010K\u001a\u0004\u0018\u00010\u00148\u0007@\u0007X\u0087\u000e¢\u0006\u0016\n\u0005\bK\u0010°\u0001\u001a\u0005\b±\u0001\u0010\u0016\"\u0006\b²\u0001\u0010³\u0001R&\u0010G\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bG\u0010c\u001a\u0005\b´\u0001\u0010\u0004\"\u0005\bµ\u0001\u0010fR&\u0010E\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bE\u0010c\u001a\u0005\b¶\u0001\u0010\u0004\"\u0005\b·\u0001\u0010fR&\u0010C\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bC\u0010c\u001a\u0005\b¸\u0001\u0010\u0004\"\u0005\b¹\u0001\u0010f"}, d2 = {"Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;", "", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "", "component21", "()Z", "Lid/dana/domain/homeinfo/ThirdPartyServiceResponse$SpmId;", "component22", "()Lid/dana/domain/homeinfo/ThirdPartyServiceResponse$SpmId;", "component23", "", "component24", "()Ljava/util/List;", "Lid/dana/domain/homeinfo/SkuAttribute;", "component25", "()Lid/dana/domain/homeinfo/SkuAttribute;", "component26", "component27", "component28", "component29", "component3", "", "component30", "()Ljava/lang/Integer;", "component31", "component32", "component33", "Lid/dana/domain/homeinfo/BannerLottie;", "component34", "()Lid/dana/domain/homeinfo/BannerLottie;", "component35", "component36", "component37", "()Ljava/lang/Boolean;", "component4", "component5", "component6", "component7", "component8", "component9", "key", "action", "clientId", "appId", "isEnable", "icon", "link", "name", "nameInd", "nameTag", "operationType", "redirectUrl", "scopes", "userAction", "description", "subtitleColor", "buttonTitle", "subtitleBorderColor", "keyword", "ribbonText", "isHasRedDot", "spmId", UrlParam.NEED_CONSULT, "spaceCodes", "skuAttr", "skuConfigId", "screenOrientation", "bizType", BranchLinkConstant.MiniAppParams.NEED_OAUTH, "indexOfHighlighted", "isBiller", "rotationDelayTime", "directOpen", "bannerLottie", "iconLottie", "headerBackgroundColor", "alwaysConsult", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLid/dana/domain/homeinfo/ThirdPartyServiceResponse$SpmId;ZLjava/util/List;Lid/dana/domain/homeinfo/SkuAttribute;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZLjava/lang/Integer;Ljava/lang/String;Lid/dana/domain/homeinfo/BannerLottie;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lid/dana/domain/homeinfo/ThirdPartyServiceResponse;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAction", "setAction", "(Ljava/lang/String;)V", "Ljava/lang/Boolean;", "getAlwaysConsult", "setAlwaysConsult", "(Ljava/lang/Boolean;)V", "getAppId", "setAppId", "Lid/dana/domain/homeinfo/BannerLottie;", "getBannerLottie", "setBannerLottie", "(Lid/dana/domain/homeinfo/BannerLottie;)V", "getBizType", "setBizType", "getButtonTitle", "setButtonTitle", "getClientId", "setClientId", "getDescription", "setDescription", "getDirectOpen", "setDirectOpen", "getHeaderBackgroundColor", "setHeaderBackgroundColor", "getIcon", "setIcon", "getIconLottie", "setIconLottie", "Ljava/lang/Integer;", "getIndexOfHighlighted", "setIndexOfHighlighted", "(Ljava/lang/Integer;)V", "Z", "setBiller", "(Z)V", "setEnable", "setHasRedDot", "getKey", "setKey", "getKeyword", "setKeyword", "getLink", "setLink", "getName", "setName", "getNameInd", "setNameInd", "getNameTag", "setNameTag", "getNeedConsult", "setNeedConsult", "getNeedOauth", "setNeedOauth", "getOperationType", "setOperationType", "getRedirectUrl", "setRedirectUrl", "getRibbonText", "setRibbonText", "getRotationDelayTime", "setRotationDelayTime", "getScopes", "setScopes", "getScreenOrientation", "setScreenOrientation", "Lid/dana/domain/homeinfo/SkuAttribute;", "getSkuAttr", "setSkuAttr", "(Lid/dana/domain/homeinfo/SkuAttribute;)V", "getSkuConfigId", "setSkuConfigId", "Ljava/util/List;", "getSpaceCodes", "setSpaceCodes", "(Ljava/util/List;)V", "Lid/dana/domain/homeinfo/ThirdPartyServiceResponse$SpmId;", "getSpmId", "setSpmId", "(Lid/dana/domain/homeinfo/ThirdPartyServiceResponse$SpmId;)V", "getSubtitleBorderColor", "setSubtitleBorderColor", "getSubtitleColor", "setSubtitleColor", "getUserAction", "setUserAction", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLid/dana/domain/homeinfo/ThirdPartyServiceResponse$SpmId;ZLjava/util/List;Lid/dana/domain/homeinfo/SkuAttribute;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZLjava/lang/Integer;Ljava/lang/String;Lid/dana/domain/homeinfo/BannerLottie;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "SpmId"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ThirdPartyServiceResponse {
    private String action;
    private Boolean alwaysConsult;
    private String appId;
    private BannerLottie bannerLottie;
    private String bizType;
    private String buttonTitle;
    private String clientId;
    private String description;
    private String directOpen;
    private String headerBackgroundColor;
    private String icon;
    private String iconLottie;
    private Integer indexOfHighlighted;
    private boolean isBiller;
    private boolean isEnable;
    private boolean isHasRedDot;
    private String key;
    private String keyword;
    private String link;
    private String name;
    private String nameInd;
    private String nameTag;
    private boolean needConsult;
    private String needOauth;
    private String operationType;
    private String redirectUrl;
    private String ribbonText;
    private Integer rotationDelayTime;
    private String scopes;
    private String screenOrientation;
    private SkuAttribute skuAttr;
    private String skuConfigId;
    private List<String> spaceCodes;
    private SpmId spmId;
    private String subtitleBorderColor;
    private String subtitleColor;
    private String userAction;

    public ThirdPartyServiceResponse() {
        this(null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, false, null, null, null, null, null, null, null, false, null, null, null, null, null, null, -1, 31, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* renamed from: component10  reason: from getter */
    public final String getNameTag() {
        return this.nameTag;
    }

    /* renamed from: component11  reason: from getter */
    public final String getOperationType() {
        return this.operationType;
    }

    /* renamed from: component12  reason: from getter */
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    /* renamed from: component13  reason: from getter */
    public final String getScopes() {
        return this.scopes;
    }

    /* renamed from: component14  reason: from getter */
    public final String getUserAction() {
        return this.userAction;
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
    public final boolean getIsHasRedDot() {
        return this.isHasRedDot;
    }

    /* renamed from: component22  reason: from getter */
    public final SpmId getSpmId() {
        return this.spmId;
    }

    /* renamed from: component23  reason: from getter */
    public final boolean getNeedConsult() {
        return this.needConsult;
    }

    public final List<String> component24() {
        return this.spaceCodes;
    }

    /* renamed from: component25  reason: from getter */
    public final SkuAttribute getSkuAttr() {
        return this.skuAttr;
    }

    /* renamed from: component26  reason: from getter */
    public final String getSkuConfigId() {
        return this.skuConfigId;
    }

    /* renamed from: component27  reason: from getter */
    public final String getScreenOrientation() {
        return this.screenOrientation;
    }

    /* renamed from: component28  reason: from getter */
    public final String getBizType() {
        return this.bizType;
    }

    /* renamed from: component29  reason: from getter */
    public final String getNeedOauth() {
        return this.needOauth;
    }

    /* renamed from: component3  reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* renamed from: component30  reason: from getter */
    public final Integer getIndexOfHighlighted() {
        return this.indexOfHighlighted;
    }

    /* renamed from: component31  reason: from getter */
    public final boolean getIsBiller() {
        return this.isBiller;
    }

    /* renamed from: component32  reason: from getter */
    public final Integer getRotationDelayTime() {
        return this.rotationDelayTime;
    }

    /* renamed from: component33  reason: from getter */
    public final String getDirectOpen() {
        return this.directOpen;
    }

    /* renamed from: component34  reason: from getter */
    public final BannerLottie getBannerLottie() {
        return this.bannerLottie;
    }

    /* renamed from: component35  reason: from getter */
    public final String getIconLottie() {
        return this.iconLottie;
    }

    /* renamed from: component36  reason: from getter */
    public final String getHeaderBackgroundColor() {
        return this.headerBackgroundColor;
    }

    /* renamed from: component37  reason: from getter */
    public final Boolean getAlwaysConsult() {
        return this.alwaysConsult;
    }

    /* renamed from: component4  reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* renamed from: component5  reason: from getter */
    public final boolean getIsEnable() {
        return this.isEnable;
    }

    /* renamed from: component6  reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component7  reason: from getter */
    public final String getLink() {
        return this.link;
    }

    /* renamed from: component8  reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component9  reason: from getter */
    public final String getNameInd() {
        return this.nameInd;
    }

    public final ThirdPartyServiceResponse copy(String key, String action, String clientId, String appId, boolean isEnable, String icon, String link, String name, String nameInd, String nameTag, String operationType, String redirectUrl, String scopes, String userAction, String description, String subtitleColor, String buttonTitle, String subtitleBorderColor, String keyword, String ribbonText, boolean isHasRedDot, SpmId spmId, boolean needConsult, List<String> spaceCodes, SkuAttribute skuAttr, String skuConfigId, String screenOrientation, String bizType, String needOauth, Integer indexOfHighlighted, boolean isBiller, Integer rotationDelayTime, String directOpen, BannerLottie bannerLottie, String iconLottie, String headerBackgroundColor, Boolean alwaysConsult) {
        Intrinsics.checkNotNullParameter(key, "");
        return new ThirdPartyServiceResponse(key, action, clientId, appId, isEnable, icon, link, name, nameInd, nameTag, operationType, redirectUrl, scopes, userAction, description, subtitleColor, buttonTitle, subtitleBorderColor, keyword, ribbonText, isHasRedDot, spmId, needConsult, spaceCodes, skuAttr, skuConfigId, screenOrientation, bizType, needOauth, indexOfHighlighted, isBiller, rotationDelayTime, directOpen, bannerLottie, iconLottie, headerBackgroundColor, alwaysConsult);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ThirdPartyServiceResponse(key=");
        sb.append(this.key);
        sb.append(", action=");
        sb.append(this.action);
        sb.append(", clientId=");
        sb.append(this.clientId);
        sb.append(", appId=");
        sb.append(this.appId);
        sb.append(", isEnable=");
        sb.append(this.isEnable);
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
        sb.append(", isHasRedDot=");
        sb.append(this.isHasRedDot);
        sb.append(", spmId=");
        sb.append(this.spmId);
        sb.append(", needConsult=");
        sb.append(this.needConsult);
        sb.append(", spaceCodes=");
        sb.append(this.spaceCodes);
        sb.append(", skuAttr=");
        sb.append(this.skuAttr);
        sb.append(", skuConfigId=");
        sb.append(this.skuConfigId);
        sb.append(", screenOrientation=");
        sb.append(this.screenOrientation);
        sb.append(", bizType=");
        sb.append(this.bizType);
        sb.append(", needOauth=");
        sb.append(this.needOauth);
        sb.append(", indexOfHighlighted=");
        sb.append(this.indexOfHighlighted);
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

    public ThirdPartyServiceResponse(String str, String str2, String str3, String str4, boolean z, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, boolean z2, SpmId spmId, boolean z3, List<String> list, SkuAttribute skuAttribute, String str20, String str21, String str22, String str23, Integer num, boolean z4, Integer num2, String str24, BannerLottie bannerLottie, String str25, String str26, Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "");
        this.key = str;
        this.action = str2;
        this.clientId = str3;
        this.appId = str4;
        this.isEnable = z;
        this.icon = str5;
        this.link = str6;
        this.name = str7;
        this.nameInd = str8;
        this.nameTag = str9;
        this.operationType = str10;
        this.redirectUrl = str11;
        this.scopes = str12;
        this.userAction = str13;
        this.description = str14;
        this.subtitleColor = str15;
        this.buttonTitle = str16;
        this.subtitleBorderColor = str17;
        this.keyword = str18;
        this.ribbonText = str19;
        this.isHasRedDot = z2;
        this.spmId = spmId;
        this.needConsult = z3;
        this.spaceCodes = list;
        this.skuAttr = skuAttribute;
        this.skuConfigId = str20;
        this.screenOrientation = str21;
        this.bizType = str22;
        this.needOauth = str23;
        this.indexOfHighlighted = num;
        this.isBiller = z4;
        this.rotationDelayTime = num2;
        this.directOpen = str24;
        this.bannerLottie = bannerLottie;
        this.iconLottie = str25;
        this.headerBackgroundColor = str26;
        this.alwaysConsult = bool;
    }

    @JvmName(name = "getKey")
    public final String getKey() {
        return this.key;
    }

    @JvmName(name = "setKey")
    public final void setKey(String str) {
        Intrinsics.checkNotNullParameter(str, "");
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

    @JvmName(name = "isEnable")
    public final boolean isEnable() {
        return this.isEnable;
    }

    @JvmName(name = "setEnable")
    public final void setEnable(boolean z) {
        this.isEnable = z;
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

    @JvmName(name = "isHasRedDot")
    public final boolean isHasRedDot() {
        return this.isHasRedDot;
    }

    @JvmName(name = "setHasRedDot")
    public final void setHasRedDot(boolean z) {
        this.isHasRedDot = z;
    }

    @JvmName(name = "getSpmId")
    public final SpmId getSpmId() {
        return this.spmId;
    }

    @JvmName(name = "setSpmId")
    public final void setSpmId(SpmId spmId) {
        this.spmId = spmId;
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

    @JvmName(name = "getSkuAttr")
    public final SkuAttribute getSkuAttr() {
        return this.skuAttr;
    }

    @JvmName(name = "setSkuAttr")
    public final void setSkuAttr(SkuAttribute skuAttribute) {
        this.skuAttr = skuAttribute;
    }

    @JvmName(name = "getSkuConfigId")
    public final String getSkuConfigId() {
        return this.skuConfigId;
    }

    @JvmName(name = "setSkuConfigId")
    public final void setSkuConfigId(String str) {
        this.skuConfigId = str;
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

    @JvmName(name = "getIndexOfHighlighted")
    public final Integer getIndexOfHighlighted() {
        return this.indexOfHighlighted;
    }

    @JvmName(name = "setIndexOfHighlighted")
    public final void setIndexOfHighlighted(Integer num) {
        this.indexOfHighlighted = num;
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
    public final BannerLottie getBannerLottie() {
        return this.bannerLottie;
    }

    @JvmName(name = "setBannerLottie")
    public final void setBannerLottie(BannerLottie bannerLottie) {
        this.bannerLottie = bannerLottie;
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

    public /* synthetic */ ThirdPartyServiceResponse(String str, String str2, String str3, String str4, boolean z, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, boolean z2, SpmId spmId, boolean z3, List list, SkuAttribute skuAttribute, String str20, String str21, String str22, String str23, Integer num, boolean z4, Integer num2, String str24, BannerLottie bannerLottie, String str25, String str26, Boolean bool, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? false : z, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : str9, (i & 1024) != 0 ? null : str10, (i & 2048) != 0 ? null : str11, (i & 4096) != 0 ? null : str12, (i & 8192) != 0 ? null : str13, (i & 16384) != 0 ? null : str14, (i & 32768) != 0 ? null : str15, (i & 65536) != 0 ? null : str16, (i & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? null : str17, (i & 262144) != 0 ? null : str18, (i & 524288) != 0 ? null : str19, (i & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? false : z2, (i & 2097152) != 0 ? null : spmId, (i & 4194304) != 0 ? false : z3, (i & 8388608) != 0 ? null : list, (i & 16777216) != 0 ? null : skuAttribute, (i & 33554432) != 0 ? null : str20, (i & 67108864) != 0 ? null : str21, (i & 134217728) != 0 ? null : str22, (i & SQLiteDatabase.CREATE_IF_NECESSARY) != 0 ? null : str23, (i & 536870912) != 0 ? null : num, (i & 1073741824) != 0 ? false : z4, (i & Integer.MIN_VALUE) != 0 ? null : num2, (i2 & 1) != 0 ? null : str24, (i2 & 2) != 0 ? null : bannerLottie, (i2 & 4) != 0 ? null : str25, (i2 & 8) != 0 ? null : str26, (i2 & 16) != 0 ? Boolean.FALSE : bool);
    }

    @JvmName(name = "getAlwaysConsult")
    public final Boolean getAlwaysConsult() {
        return this.alwaysConsult;
    }

    @JvmName(name = "setAlwaysConsult")
    public final void setAlwaysConsult(Boolean bool) {
        this.alwaysConsult = bool;
    }

    public final int hashCode() {
        return this.key.hashCode();
    }

    public final boolean equals(Object other) {
        return this == other || ((other instanceof ThirdPartyServiceResponse) && Intrinsics.areEqual(this.key, ((ThirdPartyServiceResponse) other).key));
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J(\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004R$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004\"\u0004\b\u0014\u0010\u0015R$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0016\u0010\u0004\"\u0004\b\u0017\u0010\u0015"}, d2 = {"Lid/dana/domain/homeinfo/ThirdPartyServiceResponse$SpmId;", "", "", "component1", "()Ljava/lang/String;", "component2", "home", "all", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/homeinfo/ThirdPartyServiceResponse$SpmId;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAll", "setAll", "(Ljava/lang/String;)V", "getHome", "setHome", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class SpmId {
        private String all;
        private String home;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public SpmId() {
            /*
                r2 = this;
                r0 = 0
                r1 = 3
                r2.<init>(r0, r0, r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.homeinfo.ThirdPartyServiceResponse.SpmId.<init>():void");
        }

        public static /* synthetic */ SpmId copy$default(SpmId spmId, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = spmId.home;
            }
            if ((i & 2) != 0) {
                str2 = spmId.all;
            }
            return spmId.copy(str, str2);
        }

        /* renamed from: component1  reason: from getter */
        public final String getHome() {
            return this.home;
        }

        /* renamed from: component2  reason: from getter */
        public final String getAll() {
            return this.all;
        }

        public final SpmId copy(String home, String all) {
            return new SpmId(home, all);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof SpmId) {
                SpmId spmId = (SpmId) other;
                return Intrinsics.areEqual(this.home, spmId.home) && Intrinsics.areEqual(this.all, spmId.all);
            }
            return false;
        }

        public final int hashCode() {
            String str = this.home;
            int hashCode = str == null ? 0 : str.hashCode();
            String str2 = this.all;
            return (hashCode * 31) + (str2 != null ? str2.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SpmId(home=");
            sb.append(this.home);
            sb.append(", all=");
            sb.append(this.all);
            sb.append(')');
            return sb.toString();
        }

        public SpmId(String str, String str2) {
            this.home = str;
            this.all = str2;
        }

        public /* synthetic */ SpmId(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        @JvmName(name = "getAll")
        public final String getAll() {
            return this.all;
        }

        @JvmName(name = "getHome")
        public final String getHome() {
            return this.home;
        }

        @JvmName(name = "setAll")
        public final void setAll(String str) {
            this.all = str;
        }

        @JvmName(name = "setHome")
        public final void setHome(String str) {
            this.home = str;
        }
    }
}
