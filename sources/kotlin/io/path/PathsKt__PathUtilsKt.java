package kotlin.io.path;

import com.alibaba.exthub.config.ExtHubMetaInfoParser;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.analytics.tracker.TrackerKey;
import java.io.IOException;
import java.net.URI;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0003\u0010\u0004\u001a,\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00002\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0006\"\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0003\u0010\b\u001a?\u0010\r\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00002\u001a\u0010\f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u000b0\u0006\"\u0006\u0012\u0002\b\u00030\u000b¢\u0006\u0004\b\r\u0010\u000e\u001a8\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00002\u001a\u0010\f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u000b0\u0006\"\u0006\u0012\u0002\b\u00030\u000bH\u0086\b¢\u0006\u0004\b\r\u0010\u000f\u001aK\u0010\u0011\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00002\u001a\u0010\f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u000b0\u0006\"\u0006\u0012\u0002\b\u00030\u000b¢\u0006\u0004\b\u0011\u0010\u0012\u001aD\u0010\u0011\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00002\u001a\u0010\f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u000b0\u0006\"\u0006\u0012\u0002\b\u00030\u000bH\u0086\b¢\u0006\u0004\b\u0011\u0010\u0013\u001a#\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0001\u001a\u00020\u00022\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0014\u0010\u0019\u001a\u00020\u0002*\u00020\u0002H\u0086\b¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0014\u0010\u001b\u001a\u00020\u0000*\u00020\u0002H\u0086\b¢\u0006\u0004\b\u001b\u0010\u001c\u001a0\u0010 \u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001e0\u0006\"\u00020\u001eH\u0086\b¢\u0006\u0004\b \u0010!\u001a&\u0010 \u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010#\u001a\u00020\"H\u0086\b¢\u0006\u0004\b \u0010$\u001a0\u0010%\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u000b0\u0006\"\u0006\u0012\u0002\b\u00030\u000bH\u0086\b¢\u0006\u0004\b%\u0010&\u001a0\u0010'\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u000b0\u0006\"\u0006\u0012\u0002\b\u00030\u000bH\u0086\b¢\u0006\u0004\b'\u0010&\u001a0\u0010(\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u000b0\u0006\"\u0006\u0012\u0002\b\u00030\u000bH\u0086\b¢\u0006\u0004\b(\u0010&\u001a\u001c\u0010)\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0002H\u0086\b¢\u0006\u0004\b)\u0010*\u001a8\u0010+\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\u001a\u0010\f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u000b0\u0006\"\u0006\u0012\u0002\b\u00030\u000bH\u0086\b¢\u0006\u0004\b+\u0010,\u001a\u0014\u0010.\u001a\u00020-*\u00020\u0002H\u0086\b¢\u0006\u0004\b.\u0010/\u001a\u0014\u00100\u001a\u00020\"*\u00020\u0002H\u0086\b¢\u0006\u0004\b0\u00101\u001a\u001c\u00103\u001a\u00020\u0002*\u00020\u00022\u0006\u00102\u001a\u00020\u0002H\u0086\n¢\u0006\u0004\b3\u0010*\u001a\u001c\u00103\u001a\u00020\u0002*\u00020\u00022\u0006\u00102\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b3\u00104\u001a(\u00106\u001a\u00020\"*\u00020\u00022\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u0002050\u0006\"\u000205H\u0086\b¢\u0006\u0004\b6\u00107\u001a4\u0010:\u001a\u00028\u0000\"\n\b\u0000\u00109\u0018\u0001*\u000208*\u00020\u00022\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u0002050\u0006\"\u000205H\u0086\b¢\u0006\u0004\b:\u0010;\u001a6\u0010<\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u00109\u0018\u0001*\u000208*\u00020\u00022\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u0002050\u0006\"\u000205H\u0086\b¢\u0006\u0004\b<\u0010;\u001a\u0014\u0010>\u001a\u00020=*\u00020\u0002H\u0086\b¢\u0006\u0004\b>\u0010?\u001a\u0014\u0010A\u001a\u00020@*\u00020\u0002H\u0086\b¢\u0006\u0004\bA\u0010B\u001a5\u0010F\u001a\u00020-*\u00020\u00022\b\b\u0002\u0010C\u001a\u00020\u00002\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020-0DH\u0086\bø\u0001\u0000¢\u0006\u0004\bF\u0010G\u001a2\u0010J\u001a\u0004\u0018\u00010I*\u00020\u00022\u0006\u0010H\u001a\u00020\u00002\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u0002050\u0006\"\u000205H\u0086\b¢\u0006\u0004\bJ\u0010K\u001a(\u0010M\u001a\u00020L*\u00020\u00022\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u0002050\u0006\"\u000205H\u0086\b¢\u0006\u0004\bM\u0010N\u001a*\u0010P\u001a\u0004\u0018\u00010O*\u00020\u00022\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u0002050\u0006\"\u000205H\u0086\b¢\u0006\u0004\bP\u0010Q\u001a.\u0010T\u001a\b\u0012\u0004\u0012\u00020S0R*\u00020\u00022\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u0002050\u0006\"\u000205H\u0086\b¢\u0006\u0004\bT\u0010U\u001a(\u0010V\u001a\u00020\"*\u00020\u00022\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u0002050\u0006\"\u000205H\u0086\b¢\u0006\u0004\bV\u00107\u001a\u0014\u0010W\u001a\u00020\"*\u00020\u0002H\u0086\b¢\u0006\u0004\bW\u00101\u001a\u0014\u0010X\u001a\u00020\"*\u00020\u0002H\u0086\b¢\u0006\u0004\bX\u00101\u001a\u0014\u0010Y\u001a\u00020\"*\u00020\u0002H\u0086\b¢\u0006\u0004\bY\u00101\u001a(\u0010Z\u001a\u00020\"*\u00020\u00022\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u0002050\u0006\"\u000205H\u0086\b¢\u0006\u0004\bZ\u00107\u001a\u001c\u0010[\u001a\u00020\"*\u00020\u00022\u0006\u00102\u001a\u00020\u0002H\u0086\b¢\u0006\u0004\b[\u0010\\\u001a\u0014\u0010]\u001a\u00020\"*\u00020\u0002H\u0086\b¢\u0006\u0004\b]\u00101\u001a\u0014\u0010^\u001a\u00020\"*\u00020\u0002H\u0086\b¢\u0006\u0004\b^\u00101\u001a!\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00020_*\u00020\u00022\b\b\u0002\u0010C\u001a\u00020\u0000¢\u0006\u0004\b`\u0010a\u001a0\u0010b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001e0\u0006\"\u00020\u001eH\u0086\b¢\u0006\u0004\bb\u0010!\u001a&\u0010b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010#\u001a\u00020\"H\u0086\b¢\u0006\u0004\bb\u0010$\u001a(\u0010c\u001a\u00020\"*\u00020\u00022\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u0002050\u0006\"\u000205H\u0086\b¢\u0006\u0004\bc\u00107\u001a4\u0010f\u001a\u00028\u0000\"\n\b\u0000\u0010e\u0018\u0001*\u00020d*\u00020\u00022\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u0002050\u0006\"\u000205H\u0086\b¢\u0006\u0004\bf\u0010g\u001a>\u0010f\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010I0h*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00002\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u0002050\u0006\"\u000205H\u0086\b¢\u0006\u0004\bf\u0010i\u001a\u0014\u0010j\u001a\u00020\u0002*\u00020\u0002H\u0086\b¢\u0006\u0004\bj\u0010\u001a\u001a\u0019\u0010k\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\bk\u0010*\u001a\u001b\u0010l\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\bl\u0010*\u001a\u0019\u0010m\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\bm\u0010*\u001a:\u0010o\u001a\u00020\u0002*\u00020\u00022\u0006\u0010H\u001a\u00020\u00002\b\u0010n\u001a\u0004\u0018\u00010I2\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u0002050\u0006\"\u000205H\u0086\b¢\u0006\u0004\bo\u0010p\u001a\u001c\u0010q\u001a\u00020\u0002*\u00020\u00022\u0006\u0010n\u001a\u00020LH\u0086\b¢\u0006\u0004\bq\u0010r\u001a\u001c\u0010s\u001a\u00020\u0002*\u00020\u00022\u0006\u0010n\u001a\u00020OH\u0086\b¢\u0006\u0004\bs\u0010t\u001a\"\u0010u\u001a\u00020\u0002*\u00020\u00022\f\u0010n\u001a\b\u0012\u0004\u0012\u00020S0RH\u0086\b¢\u0006\u0004\bu\u0010v\u001a\u0014\u0010x\u001a\u00020\u0002*\u00020wH\u0086\b¢\u0006\u0004\bx\u0010y\u001aA\u0010}\u001a\u00028\u0000\"\u0004\b\u0000\u0010z*\u00020\u00022\b\b\u0002\u0010C\u001a\u00020\u00002\u0018\u0010|\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020{\u0012\u0004\u0012\u00028\u00000DH\u0086\bø\u0001\u0000¢\u0006\u0004\b}\u0010~\"\u001d\u0010\u0081\u0001\u001a\u00020\u0000*\u00020\u00028G¢\u0006\r\u0012\u0005\b\u0080\u0001\u0010/\u001a\u0004\b\u007f\u0010\u001c\"\"\u0010\u0084\u0001\u001a\u00020\u0000*\u00020\u00028Ç\u0002X\u0087\u0004¢\u0006\u000e\u0012\u0005\b\u0083\u0001\u0010/\u001a\u0005\b\u0082\u0001\u0010\u001c\"\u001e\u0010\u0087\u0001\u001a\u00020\u0000*\u00020\u00028G¢\u0006\u000e\u0012\u0005\b\u0086\u0001\u0010/\u001a\u0005\b\u0085\u0001\u0010\u001c\"\u001e\u0010\u008a\u0001\u001a\u00020\u0000*\u00020\u00028G¢\u0006\u000e\u0012\u0005\b\u0089\u0001\u0010/\u001a\u0005\b\u0088\u0001\u0010\u001c\"\u001e\u0010\u008d\u0001\u001a\u00020\u0000*\u00020\u00028G¢\u0006\u000e\u0012\u0005\b\u008c\u0001\u0010/\u001a\u0005\b\u008b\u0001\u0010\u001c\"\u001f\u0010\u0090\u0001\u001a\u00020\u0000*\u00020\u00028Ç\u0002¢\u0006\u000e\u0012\u0005\b\u008f\u0001\u0010/\u001a\u0005\b\u008e\u0001\u0010\u001c\u0082\u0002\u0007\n\u0005\b\u009920\u0001"}, d2 = {"", "path", "Ljava/nio/file/Path;", TrackerKey.DeeplinkProperty.PATH, "(Ljava/lang/String;)Ljava/nio/file/Path;", "base", "", "subpaths", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/nio/file/Path;", "directory", "prefix", "Ljava/nio/file/attribute/FileAttribute;", "attributes", "createTempDirectory", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "(Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "suffix", "createTempFile", "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "(Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "Ljava/lang/Class;", "attributeViewClass", "", "fileAttributeViewNotAvailable", "(Ljava/nio/file/Path;Ljava/lang/Class;)Ljava/lang/Void;", "absolute", "(Ljava/nio/file/Path;)Ljava/nio/file/Path;", "absolutePathString", "(Ljava/nio/file/Path;)Ljava/lang/String;", "target", "Ljava/nio/file/CopyOption;", SecurityConstants.KEY_OPTIONS, "copyTo", "(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/CopyOption;)Ljava/nio/file/Path;", "", "overwrite", "(Ljava/nio/file/Path;Ljava/nio/file/Path;Z)Ljava/nio/file/Path;", "createDirectories", "(Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "createDirectory", "createFile", "createLinkPointingTo", "(Ljava/nio/file/Path;Ljava/nio/file/Path;)Ljava/nio/file/Path;", "createSymbolicLinkPointingTo", "(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "", "deleteExisting", "(Ljava/nio/file/Path;)V", "deleteIfExists", "(Ljava/nio/file/Path;)Z", "other", "div", "(Ljava/nio/file/Path;Ljava/lang/String;)Ljava/nio/file/Path;", "Ljava/nio/file/LinkOption;", "exists", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z", "Ljava/nio/file/attribute/FileAttributeView;", "V", "fileAttributesView", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/FileAttributeView;", "fileAttributesViewOrNull", "", "fileSize", "(Ljava/nio/file/Path;)J", "Ljava/nio/file/FileStore;", "fileStore", "(Ljava/nio/file/Path;)Ljava/nio/file/FileStore;", "glob", "Lkotlin/Function1;", "action", "forEachDirectoryEntry", "(Ljava/nio/file/Path;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "attribute", "", "getAttribute", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/LinkOption;)Ljava/lang/Object;", "Ljava/nio/file/attribute/FileTime;", "getLastModifiedTime", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/FileTime;", "Ljava/nio/file/attribute/UserPrincipal;", "getOwner", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/UserPrincipal;", "", "Ljava/nio/file/attribute/PosixFilePermission;", "getPosixFilePermissions", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/util/Set;", "isDirectory", "isExecutable", "isHidden", "isReadable", "isRegularFile", "isSameFileAs", "(Ljava/nio/file/Path;Ljava/nio/file/Path;)Z", "isSymbolicLink", "isWritable", "", "listDirectoryEntries", "(Ljava/nio/file/Path;Ljava/lang/String;)Ljava/util/List;", "moveTo", "notExists", "Ljava/nio/file/attribute/BasicFileAttributes;", "A", "readAttributes", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/BasicFileAttributes;", "", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/LinkOption;)Ljava/util/Map;", "readSymbolicLink", "relativeTo", "relativeToOrNull", "relativeToOrSelf", "value", "setAttribute", "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/Object;[Ljava/nio/file/LinkOption;)Ljava/nio/file/Path;", "setLastModifiedTime", "(Ljava/nio/file/Path;Ljava/nio/file/attribute/FileTime;)Ljava/nio/file/Path;", "setOwner", "(Ljava/nio/file/Path;Ljava/nio/file/attribute/UserPrincipal;)Ljava/nio/file/Path;", "setPosixFilePermissions", "(Ljava/nio/file/Path;Ljava/util/Set;)Ljava/nio/file/Path;", "Ljava/net/URI;", "toPath", "(Ljava/net/URI;)Ljava/nio/file/Path;", "T", "Lkotlin/sequences/Sequence;", "block", "useDirectoryEntries", "(Ljava/nio/file/Path;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getExtension", "getExtension$annotations", ExtHubMetaInfoParser.KEY_EXTENSION_INFO, "getInvariantSeparatorsPath", "getInvariantSeparatorsPath$annotations", "invariantSeparatorsPath", "getInvariantSeparatorsPathString", "getInvariantSeparatorsPathString$annotations", "invariantSeparatorsPathString", "getName", "getName$annotations", "name", "getNameWithoutExtension", "getNameWithoutExtension$annotations", "nameWithoutExtension", "getPathString", "getPathString$annotations", "pathString"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/io/path/PathsKt")
/* loaded from: classes3.dex */
class PathsKt__PathUtilsKt extends PathsKt__PathReadWriteKt {
    public static /* synthetic */ void getExtension$annotations(Path path) {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use invariantSeparatorsPathString property instead.", replaceWith = @ReplaceWith(expression = "invariantSeparatorsPathString", imports = {}))
    public static /* synthetic */ void getInvariantSeparatorsPath$annotations(Path path) {
    }

    public static /* synthetic */ void getInvariantSeparatorsPathString$annotations(Path path) {
    }

    public static /* synthetic */ void getName$annotations(Path path) {
    }

    public static /* synthetic */ void getNameWithoutExtension$annotations(Path path) {
    }

    public static /* synthetic */ void getPathString$annotations(Path path) {
    }

    @JvmName(name = "getName")
    public static final String getName(Path path) {
        Intrinsics.checkNotNullParameter(path, "");
        Path fileName = path.getFileName();
        String obj = fileName != null ? fileName.toString() : null;
        return obj == null ? "" : obj;
    }

    @JvmName(name = "getNameWithoutExtension")
    public static final String getNameWithoutExtension(Path path) {
        String obj;
        String substringBeforeLast$default;
        Intrinsics.checkNotNullParameter(path, "");
        Path fileName = path.getFileName();
        return (fileName == null || (obj = fileName.toString()) == null || (substringBeforeLast$default = StringsKt.substringBeforeLast$default(obj, ".", (String) null, 2, (Object) null)) == null) ? "" : substringBeforeLast$default;
    }

    @JvmName(name = "getExtension")
    public static final String getExtension(Path path) {
        String obj;
        String substringAfterLast;
        Intrinsics.checkNotNullParameter(path, "");
        Path fileName = path.getFileName();
        return (fileName == null || (obj = fileName.toString()) == null || (substringAfterLast = StringsKt.substringAfterLast(obj, '.', "")) == null) ? "" : substringAfterLast;
    }

    @JvmName(name = "getPathString")
    private static final String getPathString(Path path) {
        Intrinsics.checkNotNullParameter(path, "");
        return path.toString();
    }

    @JvmName(name = "getInvariantSeparatorsPathString")
    public static final String getInvariantSeparatorsPathString(Path path) {
        Intrinsics.checkNotNullParameter(path, "");
        String separator = path.getFileSystem().getSeparator();
        if (Intrinsics.areEqual(separator, "/")) {
            return path.toString();
        }
        String obj = path.toString();
        Intrinsics.checkNotNullExpressionValue(separator, "");
        return StringsKt.replace$default(obj, separator, "/", false, 4, (Object) null);
    }

    @JvmName(name = "getInvariantSeparatorsPath")
    private static final String getInvariantSeparatorsPath(Path path) {
        Intrinsics.checkNotNullParameter(path, "");
        return PathsKt.getInvariantSeparatorsPathString(path);
    }

    private static final Path absolute(Path path) {
        Intrinsics.checkNotNullParameter(path, "");
        Path absolutePath = path.toAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "");
        return absolutePath;
    }

    private static final String absolutePathString(Path path) {
        Intrinsics.checkNotNullParameter(path, "");
        return path.toAbsolutePath().toString();
    }

    public static final Path relativeTo(Path path, Path path2) {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(path2, "");
        try {
            return PathRelativizer.INSTANCE.tryRelativeTo(path, path2);
        } catch (IllegalArgumentException e) {
            StringBuilder sb = new StringBuilder();
            sb.append(e.getMessage());
            sb.append("\nthis path: ");
            sb.append(path);
            sb.append("\nbase path: ");
            sb.append(path2);
            throw new IllegalArgumentException(sb.toString(), e);
        }
    }

    public static final Path relativeToOrSelf(Path path, Path path2) {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(path2, "");
        Path relativeToOrNull = PathsKt.relativeToOrNull(path, path2);
        return relativeToOrNull != null ? relativeToOrNull : path;
    }

    public static final Path relativeToOrNull(Path path, Path path2) {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(path2, "");
        try {
            return PathRelativizer.INSTANCE.tryRelativeTo(path, path2);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    static /* synthetic */ Path copyTo$default(Path path, Path path2, boolean z, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(path2, "");
        CopyOption[] copyOptionArr = z ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path copy = Files.copy(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(copy, "");
        return copy;
    }

    private static final Path copyTo(Path path, Path path2, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(path2, "");
        CopyOption[] copyOptionArr = z ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path copy = Files.copy(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(copy, "");
        return copy;
    }

    private static final Path copyTo(Path path, Path path2, CopyOption... copyOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(path2, "");
        Intrinsics.checkNotNullParameter(copyOptionArr, "");
        Path copy = Files.copy(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(copy, "");
        return copy;
    }

    private static final boolean exists(Path path, LinkOption... linkOptionArr) {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(linkOptionArr, "");
        return Files.exists(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    private static final boolean notExists(Path path, LinkOption... linkOptionArr) {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(linkOptionArr, "");
        return Files.notExists(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    private static final boolean isRegularFile(Path path, LinkOption... linkOptionArr) {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(linkOptionArr, "");
        return Files.isRegularFile(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    private static final boolean isDirectory(Path path, LinkOption... linkOptionArr) {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(linkOptionArr, "");
        return Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    private static final boolean isSymbolicLink(Path path) {
        Intrinsics.checkNotNullParameter(path, "");
        return Files.isSymbolicLink(path);
    }

    private static final boolean isExecutable(Path path) {
        Intrinsics.checkNotNullParameter(path, "");
        return Files.isExecutable(path);
    }

    private static final boolean isHidden(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        return Files.isHidden(path);
    }

    private static final boolean isReadable(Path path) {
        Intrinsics.checkNotNullParameter(path, "");
        return Files.isReadable(path);
    }

    private static final boolean isWritable(Path path) {
        Intrinsics.checkNotNullParameter(path, "");
        return Files.isWritable(path);
    }

    private static final boolean isSameFileAs(Path path, Path path2) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(path2, "");
        return Files.isSameFile(path, path2);
    }

    public static /* synthetic */ List listDirectoryEntries$default(Path path, String str, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            str = "*";
        }
        return PathsKt.listDirectoryEntries(path, str);
    }

    public static final List<Path> listDirectoryEntries(Path path, String str) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(str, "");
        DirectoryStream<Path> newDirectoryStream = Files.newDirectoryStream(path, str);
        try {
            DirectoryStream<Path> directoryStream = newDirectoryStream;
            Intrinsics.checkNotNullExpressionValue(directoryStream, "");
            List<Path> list = CollectionsKt.toList(directoryStream);
            CloseableKt.closeFinally(newDirectoryStream, null);
            return list;
        } finally {
        }
    }

    static /* synthetic */ Object useDirectoryEntries$default(Path path, String str, Function1 function1, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            str = "*";
        }
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(function1, "");
        DirectoryStream<Path> newDirectoryStream = Files.newDirectoryStream(path, str);
        try {
            DirectoryStream<Path> directoryStream = newDirectoryStream;
            Intrinsics.checkNotNullExpressionValue(directoryStream, "");
            Object invoke = function1.invoke(CollectionsKt.asSequence(directoryStream));
            InlineMarker.finallyStart(1);
            CloseableKt.closeFinally(newDirectoryStream, null);
            InlineMarker.finallyEnd(1);
            return invoke;
        } finally {
        }
    }

    private static final <T> T useDirectoryEntries(Path path, String str, Function1<? super Sequence<? extends Path>, ? extends T> function1) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(function1, "");
        DirectoryStream<Path> newDirectoryStream = Files.newDirectoryStream(path, str);
        try {
            DirectoryStream<Path> directoryStream = newDirectoryStream;
            Intrinsics.checkNotNullExpressionValue(directoryStream, "");
            T invoke = function1.invoke(CollectionsKt.asSequence(directoryStream));
            InlineMarker.finallyStart(1);
            CloseableKt.closeFinally(newDirectoryStream, null);
            InlineMarker.finallyEnd(1);
            return invoke;
        } finally {
        }
    }

    static /* synthetic */ void forEachDirectoryEntry$default(Path path, String str, Function1 function1, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            str = "*";
        }
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(function1, "");
        DirectoryStream<Path> newDirectoryStream = Files.newDirectoryStream(path, str);
        try {
            DirectoryStream<Path> directoryStream = newDirectoryStream;
            Intrinsics.checkNotNullExpressionValue(directoryStream, "");
            Iterator<Path> it = directoryStream.iterator();
            while (it.hasNext()) {
                function1.invoke(it.next());
            }
            Unit unit = Unit.INSTANCE;
            InlineMarker.finallyStart(1);
            CloseableKt.closeFinally(newDirectoryStream, null);
            InlineMarker.finallyEnd(1);
        } finally {
        }
    }

    private static final void forEachDirectoryEntry(Path path, String str, Function1<? super Path, Unit> function1) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(function1, "");
        DirectoryStream<Path> newDirectoryStream = Files.newDirectoryStream(path, str);
        try {
            DirectoryStream<Path> directoryStream = newDirectoryStream;
            Intrinsics.checkNotNullExpressionValue(directoryStream, "");
            Iterator<Path> it = directoryStream.iterator();
            while (it.hasNext()) {
                function1.invoke(it.next());
            }
            Unit unit = Unit.INSTANCE;
            InlineMarker.finallyStart(1);
            CloseableKt.closeFinally(newDirectoryStream, null);
            InlineMarker.finallyEnd(1);
        } finally {
        }
    }

    private static final long fileSize(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        return Files.size(path);
    }

    private static final void deleteExisting(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Files.delete(path);
    }

    private static final boolean deleteIfExists(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        return Files.deleteIfExists(path);
    }

    private static final Path createDirectory(Path path, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(fileAttributeArr, "");
        Path createDirectory = Files.createDirectory(path, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(createDirectory, "");
        return createDirectory;
    }

    private static final Path createDirectories(Path path, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(fileAttributeArr, "");
        Path createDirectories = Files.createDirectories(path, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(createDirectories, "");
        return createDirectories;
    }

    private static final Path moveTo(Path path, Path path2, CopyOption... copyOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(path2, "");
        Intrinsics.checkNotNullParameter(copyOptionArr, "");
        Path move = Files.move(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(move, "");
        return move;
    }

    static /* synthetic */ Path moveTo$default(Path path, Path path2, boolean z, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(path2, "");
        CopyOption[] copyOptionArr = z ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path move = Files.move(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(move, "");
        return move;
    }

    private static final Path moveTo(Path path, Path path2, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(path2, "");
        CopyOption[] copyOptionArr = z ? new CopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new CopyOption[0];
        Path move = Files.move(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(move, "");
        return move;
    }

    private static final FileStore fileStore(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        FileStore fileStore = Files.getFileStore(path);
        Intrinsics.checkNotNullExpressionValue(fileStore, "");
        return fileStore;
    }

    private static final Object getAttribute(Path path, String str, LinkOption... linkOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(linkOptionArr, "");
        return Files.getAttribute(path, str, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    private static final Path setAttribute(Path path, String str, Object obj, LinkOption... linkOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(linkOptionArr, "");
        Path attribute = Files.setAttribute(path, str, obj, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(attribute, "");
        return attribute;
    }

    private static final /* synthetic */ <V extends FileAttributeView> V fileAttributesViewOrNull(Path path, LinkOption... linkOptionArr) {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(linkOptionArr, "");
        Intrinsics.reifiedOperationMarker(4, "V");
        return (V) Files.getFileAttributeView(path, FileAttributeView.class, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    private static final /* synthetic */ <V extends FileAttributeView> V fileAttributesView(Path path, LinkOption... linkOptionArr) {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(linkOptionArr, "");
        Intrinsics.reifiedOperationMarker(4, "V");
        V v = (V) Files.getFileAttributeView(path, FileAttributeView.class, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        if (v != null) {
            return v;
        }
        Intrinsics.reifiedOperationMarker(4, "V");
        PathsKt.fileAttributeViewNotAvailable(path, FileAttributeView.class);
        throw new KotlinNothingValueException();
    }

    public static final Void fileAttributeViewNotAvailable(Path path, Class<?> cls) {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(cls, "");
        StringBuilder sb = new StringBuilder();
        sb.append("The desired attribute view type ");
        sb.append(cls);
        sb.append(" is not available for the file ");
        sb.append(path);
        sb.append('.');
        throw new UnsupportedOperationException(sb.toString());
    }

    private static final /* synthetic */ <A extends BasicFileAttributes> A readAttributes(Path path, LinkOption... linkOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(linkOptionArr, "");
        Intrinsics.reifiedOperationMarker(4, "A");
        A a2 = (A) Files.readAttributes(path, BasicFileAttributes.class, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(a2, "");
        return a2;
    }

    private static final Map<String, Object> readAttributes(Path path, String str, LinkOption... linkOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(linkOptionArr, "");
        Map<String, Object> readAttributes = Files.readAttributes(path, str, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(readAttributes, "");
        return readAttributes;
    }

    private static final FileTime getLastModifiedTime(Path path, LinkOption... linkOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(linkOptionArr, "");
        FileTime lastModifiedTime = Files.getLastModifiedTime(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(lastModifiedTime, "");
        return lastModifiedTime;
    }

    private static final Path setLastModifiedTime(Path path, FileTime fileTime) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(fileTime, "");
        Path lastModifiedTime = Files.setLastModifiedTime(path, fileTime);
        Intrinsics.checkNotNullExpressionValue(lastModifiedTime, "");
        return lastModifiedTime;
    }

    private static final UserPrincipal getOwner(Path path, LinkOption... linkOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(linkOptionArr, "");
        return Files.getOwner(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
    }

    private static final Path setOwner(Path path, UserPrincipal userPrincipal) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(userPrincipal, "");
        Path owner = Files.setOwner(path, userPrincipal);
        Intrinsics.checkNotNullExpressionValue(owner, "");
        return owner;
    }

    private static final Set<PosixFilePermission> getPosixFilePermissions(Path path, LinkOption... linkOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(linkOptionArr, "");
        Set<PosixFilePermission> posixFilePermissions = Files.getPosixFilePermissions(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(posixFilePermissions, "");
        return posixFilePermissions;
    }

    private static final Path setPosixFilePermissions(Path path, Set<? extends PosixFilePermission> set) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(set, "");
        Path posixFilePermissions = Files.setPosixFilePermissions(path, set);
        Intrinsics.checkNotNullExpressionValue(posixFilePermissions, "");
        return posixFilePermissions;
    }

    private static final Path createLinkPointingTo(Path path, Path path2) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(path2, "");
        Path createLink = Files.createLink(path, path2);
        Intrinsics.checkNotNullExpressionValue(createLink, "");
        return createLink;
    }

    private static final Path createSymbolicLinkPointingTo(Path path, Path path2, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(path2, "");
        Intrinsics.checkNotNullParameter(fileAttributeArr, "");
        Path createSymbolicLink = Files.createSymbolicLink(path, path2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(createSymbolicLink, "");
        return createSymbolicLink;
    }

    private static final Path readSymbolicLink(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Path readSymbolicLink = Files.readSymbolicLink(path);
        Intrinsics.checkNotNullExpressionValue(readSymbolicLink, "");
        return readSymbolicLink;
    }

    private static final Path createFile(Path path, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(fileAttributeArr, "");
        Path createFile = Files.createFile(path, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(createFile, "");
        return createFile;
    }

    static /* synthetic */ Path createTempFile$default(String str, String str2, FileAttribute[] fileAttributeArr, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        Intrinsics.checkNotNullParameter(fileAttributeArr, "");
        Path createTempFile = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(createTempFile, "");
        return createTempFile;
    }

    private static final Path createTempFile(String str, String str2, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter(fileAttributeArr, "");
        Path createTempFile = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(createTempFile, "");
        return createTempFile;
    }

    public static /* synthetic */ Path createTempFile$default(Path path, String str, String str2, FileAttribute[] fileAttributeArr, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        return PathsKt.createTempFile(path, str, str2, fileAttributeArr);
    }

    public static final Path createTempFile(Path path, String str, String str2, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter(fileAttributeArr, "");
        if (path != null) {
            Path createTempFile = Files.createTempFile(path, str, str2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
            Intrinsics.checkNotNullExpressionValue(createTempFile, "");
            return createTempFile;
        }
        Path createTempFile2 = Files.createTempFile(str, str2, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(createTempFile2, "");
        return createTempFile2;
    }

    static /* synthetic */ Path createTempDirectory$default(String str, FileAttribute[] fileAttributeArr, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            str = null;
        }
        Intrinsics.checkNotNullParameter(fileAttributeArr, "");
        Path createTempDirectory = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(createTempDirectory, "");
        return createTempDirectory;
    }

    private static final Path createTempDirectory(String str, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter(fileAttributeArr, "");
        Path createTempDirectory = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(createTempDirectory, "");
        return createTempDirectory;
    }

    public static /* synthetic */ Path createTempDirectory$default(Path path, String str, FileAttribute[] fileAttributeArr, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            str = null;
        }
        return PathsKt.createTempDirectory(path, str, fileAttributeArr);
    }

    public static final Path createTempDirectory(Path path, String str, FileAttribute<?>... fileAttributeArr) throws IOException {
        Intrinsics.checkNotNullParameter(fileAttributeArr, "");
        if (path != null) {
            Path createTempDirectory = Files.createTempDirectory(path, str, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
            Intrinsics.checkNotNullExpressionValue(createTempDirectory, "");
            return createTempDirectory;
        }
        Path createTempDirectory2 = Files.createTempDirectory(str, (FileAttribute[]) Arrays.copyOf(fileAttributeArr, fileAttributeArr.length));
        Intrinsics.checkNotNullExpressionValue(createTempDirectory2, "");
        return createTempDirectory2;
    }

    private static final Path div(Path path, Path path2) {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(path2, "");
        Path resolve = path.resolve(path2);
        Intrinsics.checkNotNullExpressionValue(resolve, "");
        return resolve;
    }

    private static final Path div(Path path, String str) {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(str, "");
        Path resolve = path.resolve(str);
        Intrinsics.checkNotNullExpressionValue(resolve, "");
        return resolve;
    }

    private static final Path Path(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        Path path = Paths.get(str, new String[0]);
        Intrinsics.checkNotNullExpressionValue(path, "");
        return path;
    }

    private static final Path Path(String str, String... strArr) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(strArr, "");
        Path path = Paths.get(str, (String[]) Arrays.copyOf(strArr, strArr.length));
        Intrinsics.checkNotNullExpressionValue(path, "");
        return path;
    }

    private static final Path toPath(URI uri) {
        Intrinsics.checkNotNullParameter(uri, "");
        Path path = Paths.get(uri);
        Intrinsics.checkNotNullExpressionValue(path, "");
        return path;
    }
}
