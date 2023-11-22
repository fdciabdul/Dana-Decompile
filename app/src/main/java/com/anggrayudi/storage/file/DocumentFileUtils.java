package com.anggrayudi.storage.file;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import androidx.core.content.MimeTypeFilter;
import androidx.documentfile.provider.DocumentFile;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.exthub.config.ExtHubMetaInfoParser;
import com.alipay.mobile.zebra.ZebraLoader;
import com.anggrayudi.storage.SimpleStorage;
import com.anggrayudi.storage.callback.BaseFileCallback;
import com.anggrayudi.storage.callback.FileCallback;
import com.anggrayudi.storage.callback.FolderCallback;
import com.anggrayudi.storage.callback.MultipleFileCallback;
import com.anggrayudi.storage.extension.ContextUtils;
import com.anggrayudi.storage.extension.CoroutineExtKt;
import com.anggrayudi.storage.extension.IOUtils;
import com.anggrayudi.storage.extension.TextUtils;
import com.anggrayudi.storage.extension.UriUtils;
import com.anggrayudi.storage.media.MediaFile;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import id.dana.promocenter.model.PromoActionType;
import java.io.File;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u009e\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aV\u0010\u0019\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00022\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u0002H\u001b\u0012\u0002\b\u0003\u0012\u0002\b\u00030!2\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u001a0#H\u0002\u001aC\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020&2\u0006\u0010 \u001a\u00020'2\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u001a0#H\u0082\b\u001a<\u0010(\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u00012\u0006\u0010+\u001a\u00020,2\u0006\u0010 \u001a\u00020'H\u0002\u001a(\u0010-\u001a\u00020.2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u00012\u0006\u0010 \u001a\u00020'H\u0002\u001a(\u00100\u001a\u0002012\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u00012\u0006\u0010 \u001a\u000204H\u0002\u001a\u0010\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020\u0001H\u0002\u001a\u001c\u00107\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00108\u001a\u00020\u0001H\u0007\u001a\u0012\u00109\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d\u001a$\u0010:\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020\f2\u0006\u0010<\u001a\u00020\fH\u0007\u001a(\u0010=\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010>\u001a\u00020\u00012\b\b\u0002\u0010;\u001a\u00020\fH\u0007\u001a\u001a\u0010?\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010@\u001a\u00020\u0002\u001a:\u0010A\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020\u00020B2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020\u00022\b\b\u0002\u0010D\u001a\u00020\f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020EH\u0007\u001aD\u0010F\u001a\u00020\u001a*\u00020\u00022\u0006\u0010G\u001a\u00020$2\u0006\u0010H\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020I2\u0006\u0010J\u001a\u00020\f2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\f2\u0006\u0010 \u001a\u00020'H\u0002\u001a0\u0010N\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u00022\n\b\u0002\u0010O\u001a\u0004\u0018\u00010P2\u0006\u0010 \u001a\u00020'H\u0007\u001a8\u0010N\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u00022\b\u0010*\u001a\u0004\u0018\u00010\u00012\b\u0010Q\u001a\u0004\u0018\u00010\u00012\u0006\u0010 \u001a\u00020'H\u0002\u001a$\u0010N\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020&2\u0006\u0010 \u001a\u00020'H\u0007\u001a,\u0010N\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020&2\u0006\u0010M\u001a\u00020\f2\u0006\u0010 \u001a\u00020'H\u0002\u001a0\u0010N\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020R2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010P2\u0006\u0010 \u001a\u00020'H\u0007\u001a0\u0010N\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010S\u001a\u00020\u00012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010P2\u0006\u0010 \u001a\u00020'H\u0007\u001a.\u0010T\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010O\u001a\u00020P2\u0006\u0010 \u001a\u00020'2\b\b\u0002\u0010+\u001a\u00020,H\u0007\u001a<\u0010U\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010O\u001a\u00020P2\u0006\u0010 \u001a\u00020'2\u0006\u0010V\u001a\u00020W2\u0006\u0010M\u001a\u00020\f2\u0006\u0010+\u001a\u00020,H\u0002\u001a.\u0010X\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010O\u001a\u00020P2\u0006\u0010 \u001a\u00020'2\b\b\u0002\u0010+\u001a\u00020,H\u0007\u001a:\u0010Y\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u00022\b\b\u0002\u0010Z\u001a\u00020\f2\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u00012\u0006\u0010 \u001a\u000204H\u0007\u001aB\u0010Y\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u00022\b\b\u0002\u0010Z\u001a\u00020\f2\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u00012\u0006\u0010D\u001a\u00020\f2\u0006\u0010 \u001a\u000204H\u0002\u001a4\u0010\\\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020\u00020B2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u00022\b\b\u0002\u0010Z\u001a\u00020\f2\u0006\u0010 \u001a\u00020]H\u0007\u001a<\u0010\\\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020\u00020B2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u00022\b\b\u0002\u0010Z\u001a\u00020\f2\u0006\u0010D\u001a\u00020\f2\u0006\u0010 \u001a\u00020]H\u0002\u001a(\u0010^\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010_\u001a\u00020\u00012\b\b\u0002\u0010+\u001a\u00020,H\u0007\u001a*\u0010`\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u00022\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020aH\u0007\u001a\u0012\u0010b\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d\u001a\u001e\u0010c\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010d\u001a\u00020\fH\u0007\u001a0\u0010e\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u00022\b\u0010*\u001a\u0004\u0018\u00010\u00012\u0006\u0010 \u001a\u00020'H\u0002\u001a0\u0010e\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u00022\b\u0010[\u001a\u0004\u0018\u00010\u00012\u0006\u0010 \u001a\u000204H\u0002\u001a>\u0010e\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020g\u0018\u00010f*\b\u0012\u0004\u0012\u00020\u00020B2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u00022\u0006\u0010 \u001a\u00020]H\u0002\u001a\u0014\u0010h\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010_\u001a\u00020\u0001\u001a-\u0010i\u001a\b\u0012\u0004\u0012\u00020\u00020B*\u00020\u00022\f\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00010k2\b\b\u0002\u0010l\u001a\u00020m¢\u0006\u0002\u0010n\u001a\u0014\u0010o\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010_\u001a\u00020\u0001\u001a \u0010p\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010;\u001a\u00020\fH\u0007\u001a\u001e\u0010q\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010d\u001a\u00020\fH\u0007\u001a\u0012\u0010r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d\u001a\u0012\u0010s\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d\u001a\u0012\u0010t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d\u001a\u001c\u0010u\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020vH\u0007\u001a\u0012\u0010w\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d\u001a \u0010x\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010;\u001a\u00020\fH\u0007\u001a\u0012\u0010y\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d\u001a\u0012\u0010z\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d\u001a\u0012\u0010{\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d\u001a\u0012\u0010|\u001a\u00020}*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d\u001a\u001e\u0010~\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u007f\u001a\u00020\u0001H\u0002\u001a3\u00100\u001a\u000b\u0012\u0005\u0012\u00030\u0080\u0001\u0018\u00010B*\b\u0012\u0004\u0012\u00020\u00020B2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u00022\u0006\u0010 \u001a\u00020]H\u0002\u001a\u001b\u0010\u0081\u0001\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010@\u001a\u00020\u0002\u001a\u0013\u0010\u0082\u0001\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d\u001a\u0012\u00105\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d\u001a\u0013\u0010\u0083\u0001\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d\u001a\u001c\u0010\u0084\u0001\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0007\u0010\u0085\u0001\u001a\u00020\u0002\u001a\u0013\u0010\u0086\u0001\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d\u001a\u0015\u0010\u0087\u0001\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001dH\u0007\u001a\u0013\u0010\u0088\u0001\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d\u001a\u0013\u0010\u0089\u0001\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d\u001a\u0013\u0010\u008a\u0001\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d\u001a\u0013\u0010\u008b\u0001\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d\u001a5\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010_\u001a\u00020\u00012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010+\u001a\u00020,H\u0007\u001a)\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010_\u001a\u00020\u00012\b\b\u0002\u0010+\u001a\u00020,H\u0007\u001a\"\u0010\u008e\u0001\u001a\u00020\f*\u00020\u00022\r\u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u00020\u00010kH\u0002¢\u0006\u0003\u0010\u0090\u0001\u001a1\u0010\u0091\u0001\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u00022\n\b\u0002\u0010O\u001a\u0004\u0018\u00010P2\u0006\u0010 \u001a\u00020'H\u0007\u001a9\u0010\u0091\u0001\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020\u00022\b\u0010*\u001a\u0004\u0018\u00010\u00012\b\u0010Q\u001a\u0004\u0018\u00010\u00012\u0006\u0010 \u001a\u00020'H\u0002\u001a%\u0010\u0091\u0001\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020&2\u0006\u0010 \u001a\u00020'H\u0007\u001a1\u0010\u0091\u0001\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010)\u001a\u00020R2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010P2\u0006\u0010 \u001a\u00020'H\u0007\u001a1\u0010\u0091\u0001\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010S\u001a\u00020\u00012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010P2\u0006\u0010 \u001a\u00020'H\u0007\u001a/\u0010\u0092\u0001\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010O\u001a\u00020P2\u0006\u0010 \u001a\u00020'2\b\b\u0002\u0010+\u001a\u00020,H\u0007\u001a/\u0010\u0093\u0001\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010O\u001a\u00020P2\u0006\u0010 \u001a\u00020'2\b\b\u0002\u0010+\u001a\u00020,H\u0007\u001a;\u0010\u0094\u0001\u001a\u00020\u001a*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u00022\b\b\u0002\u0010Z\u001a\u00020\f2\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u00012\u0006\u0010 \u001a\u000204H\u0007\u001a5\u0010\u0095\u0001\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020\u00020B2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u00022\b\b\u0002\u0010Z\u001a\u00020\f2\u0006\u0010 \u001a\u00020]H\u0007\u001a\u001f\u0010\u0096\u0001\u001a\u00030\u0097\u0001*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0007\u0010\u0098\u0001\u001a\u00020\u0001H\u0007\u001a\u0017\u0010\u0099\u0001\u001a\u0004\u0018\u00010$*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001dH\u0007\u001a\"\u0010\u009a\u0001\u001a\u0004\u0018\u00010%*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\t\b\u0002\u0010\u009b\u0001\u001a\u00020\fH\u0007\u001a\u0017\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010_\u001a\u00020\u0001H\u0007\u001a)\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u009e\u0001\u001a\u00030\u009f\u00012\u0006\u0010_\u001a\u00020\u0001H\u0007\u001a\u0015\u0010 \u0001\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d\u001aY\u0010¡\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020B*\u00020\u00022\t\b\u0002\u0010¢\u0001\u001a\u00020\f2\b\b\u0002\u0010l\u001a\u00020m2\u0011\b\u0002\u0010£\u0001\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010k2\b\b\u0002\u0010_\u001a\u00020\u00012\f\b\u0002\u0010¤\u0001\u001a\u0005\u0018\u00010¥\u0001H\u0007¢\u0006\u0003\u0010¦\u0001\u001a\u001d\u0010§\u0001\u001a\u00020\f*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020\fH\u0007\u001a\u0015\u0010¨\u0001\u001a\u00020\f*\u00020\u00022\u0006\u0010 \u001a\u00020'H\u0002\u001a\u001f\u0010©\u0001\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010;\u001a\u00020\fH\u0007\u001a\u0014\u0010ª\u0001\u001a\u00030«\u0001*\b0¬\u0001j\u0003`\u00ad\u0001H\u0000\u001a\u0014\u0010®\u0001\u001a\u00030¯\u0001*\b0¬\u0001j\u0003`\u00ad\u0001H\u0002\u001a\u0015\u0010°\u0001\u001a\u0004\u0018\u00010&*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d\u001a\u0014\u0010±\u0001\u001a\u00030²\u0001*\b0¬\u0001j\u0003`\u00ad\u0001H\u0002\u001a\u0015\u0010³\u0001\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d\u001a\u0015\u0010´\u0001\u001a\u0004\u0018\u00010R*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d\u001a\u0015\u0010µ\u0001\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d\u001a\u0017\u0010¶\u0001\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001dH\u0007\u001aC\u0010·\u0001\u001a\u0004\u0018\u00010I*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0007\u0010¸\u0001\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u00012\u0006\u0010Z\u001a\u00020\f2\b\u0010[\u001a\u0004\u0018\u00010\u00012\u0007\u0010¹\u0001\u001a\u000201H\u0002\u001a\u001b\u0010º\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020B*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001dH\u0002\u001a\u0013\u0010»\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020B*\u00020\u0002H\u0002\u001a\u0013\u0010¼\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020B*\u00020\u0002H\u0002\u001a\u0013\u0010½\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020B*\u00020\u0002H\u0002\u001a\u0013\u0010¾\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020B*\u00020\u0002H\u0002\u001a!\u0010¿\u0001\u001a\u00020\u001a*\u00020\u00022\b\u0010À\u0001\u001a\u00030Á\u00012\b\u0010Â\u0001\u001a\u00030Ã\u0001H\u0002\u001aO\u0010Ä\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020B*\u00020\u00022\u0006\u0010l\u001a\u00020m2\r\u0010£\u0001\u001a\b\u0012\u0004\u0012\u00020\u00010k2\u0007\u0010Å\u0001\u001a\u00020\u00012\n\u0010¤\u0001\u001a\u0005\u0018\u00010¥\u00012\b\u0010Â\u0001\u001a\u00030Ã\u0001H\u0002¢\u0006\u0003\u0010Æ\u0001\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004\"\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004\"\u0015\u0010\u000b\u001a\u00020\f*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\r\"\u0015\u0010\u000e\u001a\u00020\f*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\r\"\u0015\u0010\u000f\u001a\u00020\f*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r\"\u0015\u0010\u0010\u001a\u00020\f*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\r\"\u0015\u0010\u0011\u001a\u00020\f*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\r\"\u0015\u0010\u0012\u001a\u00020\f*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\r\"\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0004\"\u0017\u0010\u0015\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0004\"\u0015\u0010\u0017\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0004¨\u0006Ç\u0001"}, d2 = {"baseName", "", "Landroidx/documentfile/provider/DocumentFile;", "getBaseName", "(Landroidx/documentfile/provider/DocumentFile;)Ljava/lang/String;", ExtHubMetaInfoParser.KEY_EXTENSION_INFO, "getExtension", "fullName", "getFullName", "id", "getId", "isDocumentsDocument", "", "(Landroidx/documentfile/provider/DocumentFile;)Z", "isDownloadsDocument", "isExternalStorageDocument", "isMediaDocument", "isRawFile", "isTreeDocumentFile", "mimeType", "getMimeType", "mimeTypeByFileName", "getMimeTypeByFileName", "rootId", "getRootId", "createFileStreams", "", "Enum", HummerConstants.CONTEXT, "Landroid/content/Context;", "sourceFile", "targetFile", "callback", "Lcom/anggrayudi/storage/callback/BaseFileCallback;", "onStreamsReady", "Lkotlin/Function2;", "Ljava/io/InputStream;", "Ljava/io/OutputStream;", "Lcom/anggrayudi/storage/media/MediaFile;", "Lcom/anggrayudi/storage/callback/FileCallback;", "createTargetFile", "targetFolder", "newFilenameInTargetPath", "mode", "Lcom/anggrayudi/storage/file/CreateMode;", "handleFileConflict", "Lcom/anggrayudi/storage/callback/FileCallback$ConflictResolution;", "targetFileName", "handleParentFolderConflict", "Lcom/anggrayudi/storage/callback/FolderCallback$ConflictResolution;", "targetParentFolder", "targetFolderParentName", "Lcom/anggrayudi/storage/callback/FolderCallback;", "inInternalStorage", "storageId", "autoIncrementFileName", "filename", "canModify", "checkRequirements", "requiresWriteAccess", "considerRawFile", "child", "path", "childOf", "parent", "compressToZip", "", "targetZipFile", "deleteSourceWhenComplete", "Lcom/anggrayudi/storage/callback/ZipCompressionCallback;", "copyFileStream", "inputStream", "outputStream", "", "watchProgress", "reportInterval", "", "deleteSourceFileWhenComplete", "copyFileTo", "fileDescription", "Lcom/anggrayudi/storage/media/FileDescription;", "newMimeTypeInTargetPath", "Ljava/io/File;", "targetFolderAbsolutePath", "copyFileToDownloadMedia", "copyFileToMedia", "publicDirectory", "Lcom/anggrayudi/storage/file/PublicDirectory;", "copyFileToPictureMedia", "copyFolderTo", "skipEmptyFiles", "newFolderNameInTargetPath", "copyTo", "Lcom/anggrayudi/storage/callback/MultipleFileCallback;", "createBinaryFile", "name", "decompressZip", "Lcom/anggrayudi/storage/callback/ZipDecompressionCallback;", "deleteEmptyFolders", "deleteRecursively", "childrenOnly", "doesMeetCopyRequirements", "Lkotlin/Pair;", "", "findFileLiterally", "findFiles", "names", "", "documentType", "Lcom/anggrayudi/storage/file/DocumentFileType;", "(Landroidx/documentfile/provider/DocumentFile;[Ljava/lang/String;Lcom/anggrayudi/storage/file/DocumentFileType;)Ljava/util/List;", "findFolder", "findParent", "forceDelete", "getAbsolutePath", "getBasePath", "getFormattedSize", "getProperties", "Lcom/anggrayudi/storage/file/FileProperties$CalculationCallback;", "getRelativePath", "getRootDocumentFile", "getRootPath", "getSimplePath", "getStorageId", "getStorageType", "Lcom/anggrayudi/storage/file/StorageType;", "getSubPath", "otherFolderAbsolutePath", "Lcom/anggrayudi/storage/callback/MultipleFileCallback$ParentConflict;", "hasParent", "inDataStorage", "inPrimaryStorage", "inSameMountPointWith", "file", "inSdCardStorage", "isEmpty", "isExternalStorageManager", "isReadOnly", "isRootUriPermissionGranted", "isWritable", "makeFile", "makeFolder", "matchesMimeTypes", "filterMimeTypes", "(Landroidx/documentfile/provider/DocumentFile;[Ljava/lang/String;)Z", "moveFileTo", "moveFileToDownloadMedia", "moveFileToPictureMedia", "moveFolderTo", "moveTo", "openFileIntent", "Landroid/content/Intent;", "authority", "openInputStream", "openOutputStream", "append", "quickFindRawFile", "quickFindTreeFile", "resolver", "Landroid/content/ContentResolver;", "recreateFile", "search", "recursive", "mimeTypes", "regex", "Lkotlin/text/Regex;", "(Landroidx/documentfile/provider/DocumentFile;ZLcom/anggrayudi/storage/file/DocumentFileType;[Ljava/lang/String;Ljava/lang/String;Lkotlin/text/Regex;)Ljava/util/List;", "shouldWritable", "simpleCheckSourceFile", "takeIfWritable", "toFileCallbackErrorCode", "Lcom/anggrayudi/storage/callback/FileCallback$ErrorCode;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "toFolderCallbackErrorCode", "Lcom/anggrayudi/storage/callback/FolderCallback$ErrorCode;", "toMediaFile", "toMultipleFileCallbackErrorCode", "Lcom/anggrayudi/storage/callback/MultipleFileCallback$ErrorCode;", "toRawDocumentFile", "toRawFile", "toTreeDocumentFile", "toWritableDownloadsDocumentFile", "tryMoveFolderByRenamingPath", "writableTargetParentFolder", "conflictResolution", "walkFileTree", "walkFileTreeAndDeleteEmptyFolders", "walkFileTreeAndGetFilesOnly", "walkFileTreeAndSkipEmptyFiles", "walkFileTreeForDeletion", "walkFileTreeForInfo", "properties", "Lcom/anggrayudi/storage/file/FileProperties;", "thread", "Ljava/lang/Thread;", "walkFileTreeForSearch", "nameFilter", "(Landroidx/documentfile/provider/DocumentFile;Lcom/anggrayudi/storage/file/DocumentFileType;[Ljava/lang/String;Ljava/lang/String;Lkotlin/text/Regex;Ljava/lang/Thread;)Ljava/util/List;", "storage_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class DocumentFileUtils {
    public static final byte[] getAuthRequestContext = {18, -87, -121, -123, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 37;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;
        public static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;
        public static final /* synthetic */ int[] MyBillsEntityDataFactory;

        static {
            int[] iArr = new int[DocumentFileType.values().length];
            iArr[DocumentFileType.FILE.ordinal()] = 1;
            iArr[DocumentFileType.FOLDER.ordinal()] = 2;
            BuiltInFictitiousFunctionClassFactory = iArr;
            int[] iArr2 = new int[FolderCallback.ErrorCode.values().length];
            iArr2[FolderCallback.ErrorCode.INVALID_TARGET_FOLDER.ordinal()] = 1;
            iArr2[FolderCallback.ErrorCode.STORAGE_PERMISSION_DENIED.ordinal()] = 2;
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr2;
            int[] iArr3 = new int[FolderCallback.ConflictResolution.values().length];
            iArr3[FolderCallback.ConflictResolution.REPLACE.ordinal()] = 1;
            iArr3[FolderCallback.ConflictResolution.MERGE.ordinal()] = 2;
            MyBillsEntityDataFactory = iArr3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x002a -> B:35:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 7
            int r6 = 106 - r6
            byte[] r0 = com.anggrayudi.storage.file.DocumentFileUtils.getAuthRequestContext
            int r7 = r7 * 3
            int r7 = r7 + 13
            int r8 = r8 + 4
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r6 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L36
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            int r8 = r8 + 1
            r3 = r0[r8]
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L36:
            int r7 = -r7
            int r8 = r8 + r7
            int r7 = r8 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileUtils.a(int, short, short, java.lang.Object[]):void");
    }

    @JvmName(name = "isTreeDocumentFile")
    private static boolean PlaceComponentResult(DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, "");
        Uri errorConfigVersion = documentFile.getErrorConfigVersion();
        Intrinsics.checkNotNullExpressionValue(errorConfigVersion, "");
        return UriUtils.MyBillsEntityDataFactory(errorConfigVersion);
    }

    @JvmName(name = "isExternalStorageDocument")
    private static boolean getAuthRequestContext(DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, "");
        Uri errorConfigVersion = documentFile.getErrorConfigVersion();
        Intrinsics.checkNotNullExpressionValue(errorConfigVersion, "");
        return UriUtils.BuiltInFictitiousFunctionClassFactory(errorConfigVersion);
    }

    @JvmName(name = "isDownloadsDocument")
    public static final boolean BuiltInFictitiousFunctionClassFactory(DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, "");
        Uri errorConfigVersion = documentFile.getErrorConfigVersion();
        Intrinsics.checkNotNullExpressionValue(errorConfigVersion, "");
        return UriUtils.getAuthRequestContext(errorConfigVersion);
    }

    @JvmName(name = "isDocumentsDocument")
    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, "");
        Uri errorConfigVersion = documentFile.getErrorConfigVersion();
        Intrinsics.checkNotNullExpressionValue(errorConfigVersion, "");
        return UriUtils.KClassImpl$Data$declaredNonStaticMembers$2(errorConfigVersion);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0027, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(com.anggrayudi.storage.extension.UriUtils.KClassImpl$Data$declaredNonStaticMembers$2(r1, r4), id.dana.promocenter.model.PromoActionType.PRIMARY) == false) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean lookAheadTest(androidx.documentfile.provider.DocumentFile r3, android.content.Context r4) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            boolean r1 = PlaceComponentResult(r3)
            r2 = 0
            if (r1 == 0) goto L29
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.net.Uri r1 = r3.getErrorConfigVersion()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            java.lang.String r4 = com.anggrayudi.storage.extension.UriUtils.KClassImpl$Data$declaredNonStaticMembers$2(r1, r4)
            java.lang.String r1 = "primary"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r1)
            if (r4 != 0) goto L49
        L29:
            boolean r4 = MyBillsEntityDataFactory(r3)
            if (r4 == 0) goto L4a
            android.net.Uri r3 = r3.getErrorConfigVersion()
            java.lang.String r3 = r3.getPath()
            if (r3 != 0) goto L3a
            goto L3b
        L3a:
            r0 = r3
        L3b:
            com.anggrayudi.storage.SimpleStorage$Companion r3 = com.anggrayudi.storage.SimpleStorage.INSTANCE
            java.lang.String r3 = com.anggrayudi.storage.SimpleStorage.Companion.KClassImpl$Data$declaredNonStaticMembers$2()
            r4 = 2
            r1 = 0
            boolean r3 = kotlin.text.StringsKt.startsWith$default(r0, r3, r2, r4, r1)
            if (r3 == 0) goto L4a
        L49:
            r2 = 1
        L4a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileUtils.lookAheadTest(androidx.documentfile.provider.DocumentFile, android.content.Context):boolean");
    }

    @JvmName(name = "isRawFile")
    public static final boolean MyBillsEntityDataFactory(DocumentFile documentFile) {
        Intrinsics.checkNotNullParameter(documentFile, "");
        Uri errorConfigVersion = documentFile.getErrorConfigVersion();
        Intrinsics.checkNotNullExpressionValue(errorConfigVersion, "");
        return UriUtils.PlaceComponentResult(errorConfigVersion);
    }

    private static File scheduleImpl(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "");
        Intrinsics.checkNotNullParameter(context, "");
        if (MyBillsEntityDataFactory(documentFile)) {
            String path = documentFile.getErrorConfigVersion().getPath();
            if (path == null) {
                return null;
            }
            return new File(path);
        } else if (lookAheadTest(documentFile, context)) {
            StringBuilder sb = new StringBuilder();
            SimpleStorage.Companion companion = SimpleStorage.INSTANCE;
            sb.append(SimpleStorage.Companion.KClassImpl$Data$declaredNonStaticMembers$2());
            sb.append('/');
            sb.append(MyBillsEntityDataFactory(documentFile, context));
            return new File(sb.toString());
        } else {
            Intrinsics.checkNotNullParameter(documentFile, "");
            Intrinsics.checkNotNullParameter(context, "");
            Uri errorConfigVersion = documentFile.getErrorConfigVersion();
            Intrinsics.checkNotNullExpressionValue(errorConfigVersion, "");
            if (UriUtils.KClassImpl$Data$declaredNonStaticMembers$2(errorConfigVersion, context).length() > 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("/storage/");
                Intrinsics.checkNotNullParameter(documentFile, "");
                Intrinsics.checkNotNullParameter(context, "");
                Uri errorConfigVersion2 = documentFile.getErrorConfigVersion();
                Intrinsics.checkNotNullExpressionValue(errorConfigVersion2, "");
                sb2.append(UriUtils.KClassImpl$Data$declaredNonStaticMembers$2(errorConfigVersion2, context));
                sb2.append('/');
                sb2.append(MyBillsEntityDataFactory(documentFile, context));
                return new File(sb2.toString());
            }
            return null;
        }
    }

    public static final DocumentFile BuiltInFictitiousFunctionClassFactory(DocumentFile documentFile, Context context, String str, boolean z) {
        Intrinsics.checkNotNullParameter(documentFile, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(str, "");
        if (str.length() == 0) {
            return documentFile;
        }
        if (documentFile.lookAheadTest()) {
            if (MyBillsEntityDataFactory(documentFile)) {
                Intrinsics.checkNotNullParameter(documentFile, "");
                Intrinsics.checkNotNullParameter(str, "");
                String path = documentFile.getErrorConfigVersion().getPath();
                Intrinsics.checkNotNull(path);
                documentFile = DocumentFile.KClassImpl$Data$declaredNonStaticMembers$2(new File(path, str));
                if (!documentFile.BuiltInFictitiousFunctionClassFactory()) {
                    documentFile = null;
                }
            } else {
                ContentResolver contentResolver = context.getContentResolver();
                DocumentFileCompat documentFileCompat = DocumentFileCompat.KClassImpl$Data$declaredNonStaticMembers$2;
                for (String str2 : DocumentFileCompat.PlaceComponentResult(str)) {
                    Intrinsics.checkNotNullExpressionValue(contentResolver, "");
                    documentFile = MyBillsEntityDataFactory(documentFile, context, contentResolver, str2);
                    if (documentFile == null || !documentFile.BuiltInFictitiousFunctionClassFactory()) {
                        return null;
                    }
                }
            }
            if (documentFile != null) {
                Intrinsics.checkNotNullParameter(documentFile, "");
                Intrinsics.checkNotNullParameter(context, "");
                if (PlaceComponentResult(documentFile, context, z)) {
                    return documentFile;
                }
            }
        }
        return null;
    }

    private static DocumentFile MyBillsEntityDataFactory(DocumentFile documentFile, Context context, ContentResolver contentResolver, String str) {
        Intrinsics.checkNotNullParameter(documentFile, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(contentResolver, "");
        Intrinsics.checkNotNullParameter(str, "");
        try {
            Uri errorConfigVersion = documentFile.getErrorConfigVersion();
            Intrinsics.checkNotNullParameter(documentFile, "");
            String documentId = DocumentsContract.getDocumentId(documentFile.getErrorConfigVersion());
            Intrinsics.checkNotNullExpressionValue(documentId, "");
            Cursor query = contentResolver.query(DocumentsContract.buildChildDocumentsUriUsingTree(errorConfigVersion, documentId), new String[]{"document_id"}, null, null, null);
            if (query == null) {
                return null;
            }
            Cursor cursor = query;
            try {
                Cursor cursor2 = cursor;
                String[] strArr = {"_display_name"};
                while (cursor2.moveToNext()) {
                    try {
                        Uri buildDocumentUriUsingTree = DocumentsContract.buildDocumentUriUsingTree(documentFile.getErrorConfigVersion(), cursor2.getString(0));
                        Cursor query2 = contentResolver.query(buildDocumentUriUsingTree, strArr, null, null, null);
                        if (query2 != null) {
                            cursor = query2;
                            try {
                                Cursor cursor3 = cursor;
                                if (cursor3.moveToFirst() && Intrinsics.areEqual(str, cursor3.getString(0))) {
                                    Intrinsics.checkNotNullExpressionValue(buildDocumentUriUsingTree, "");
                                    DocumentFile MyBillsEntityDataFactory = ContextUtils.MyBillsEntityDataFactory(context, buildDocumentUriUsingTree);
                                    CloseableKt.closeFinally(cursor, null);
                                    CloseableKt.closeFinally(cursor, null);
                                    return MyBillsEntityDataFactory;
                                }
                                Unit unit = Unit.INSTANCE;
                                CloseableKt.closeFinally(cursor, null);
                            } catch (Throwable th) {
                                try {
                                    throw th;
                                } finally {
                                }
                            }
                        } else {
                            continue;
                        }
                    } catch (Exception unused) {
                    }
                }
                Unit unit2 = Unit.INSTANCE;
                CloseableKt.closeFinally(cursor, null);
                return null;
            } finally {
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    private static boolean PlaceComponentResult(DocumentFile documentFile, Context context, boolean z) {
        Intrinsics.checkNotNullParameter(documentFile, "");
        Intrinsics.checkNotNullParameter(context, "");
        return (z && getErrorConfigVersion(documentFile, context)) || !z;
    }

    public static final String MyBillsEntityDataFactory(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "");
        Intrinsics.checkNotNullParameter(context, "");
        String path = documentFile.getErrorConfigVersion().getPath();
        if (path == null) {
            path = "";
        }
        Intrinsics.checkNotNullParameter(documentFile, "");
        Intrinsics.checkNotNullParameter(context, "");
        Uri errorConfigVersion = documentFile.getErrorConfigVersion();
        Intrinsics.checkNotNullExpressionValue(errorConfigVersion, "");
        String KClassImpl$Data$declaredNonStaticMembers$22 = UriUtils.KClassImpl$Data$declaredNonStaticMembers$2(errorConfigVersion, context);
        if (MyBillsEntityDataFactory(documentFile)) {
            return FileUtils.KClassImpl$Data$declaredNonStaticMembers$2(new File(path), context);
        }
        if (KClassImpl$Data$declaredNonStaticMembers$2(documentFile)) {
            return StringsKt.trimEnd(Intrinsics.stringPlus("Documents/", StringsKt.substringAfterLast(path, "/document/home:", "")), '/');
        }
        if (getAuthRequestContext(documentFile)) {
            StringBuilder sb = new StringBuilder();
            sb.append("/document/");
            sb.append(KClassImpl$Data$declaredNonStaticMembers$22);
            sb.append(':');
            if (StringsKt.contains$default((CharSequence) path, (CharSequence) sb.toString(), false, 2, (Object) null)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("/document/");
                sb2.append(KClassImpl$Data$declaredNonStaticMembers$22);
                sb2.append(':');
                return TextUtils.BuiltInFictitiousFunctionClassFactory(StringsKt.substringAfterLast(path, sb2.toString(), ""));
            }
        }
        if (!BuiltInFictitiousFunctionClassFactory(documentFile)) {
            return "";
        }
        if (Build.VERSION.SDK_INT < 28 && new Regex("/document/\\d+").matches(path)) {
            Uri errorConfigVersion2 = documentFile.getErrorConfigVersion();
            Intrinsics.checkNotNullExpressionValue(errorConfigVersion2, "");
            String PlaceComponentResult = new MediaFile(context, errorConfigVersion2).PlaceComponentResult();
            if (PlaceComponentResult == null) {
                return "";
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append((Object) Environment.DIRECTORY_DOWNLOADS);
            sb3.append('/');
            sb3.append(PlaceComponentResult);
            return sb3.toString();
        } else if (Build.VERSION.SDK_INT >= 29 && new Regex("(.*?)/ms[f,d]:\\d+(.*?)").matches(path)) {
            if (!PlaceComponentResult(documentFile)) {
                return "";
            }
            String[] strArr = new String[1];
            String KClassImpl$Data$declaredNonStaticMembers$23 = documentFile.KClassImpl$Data$declaredNonStaticMembers$2();
            if (KClassImpl$Data$declaredNonStaticMembers$23 == null) {
                KClassImpl$Data$declaredNonStaticMembers$23 = "";
            }
            strArr[0] = KClassImpl$Data$declaredNonStaticMembers$23;
            List mutableListOf = CollectionsKt.mutableListOf(strArr);
            while (true) {
                DocumentFile documentFile2 = documentFile.mParent;
                if (documentFile2 == null) {
                    documentFile2 = null;
                } else {
                    documentFile = documentFile2;
                }
                if (documentFile2 != null) {
                    String KClassImpl$Data$declaredNonStaticMembers$24 = documentFile.KClassImpl$Data$declaredNonStaticMembers$2();
                    if (KClassImpl$Data$declaredNonStaticMembers$24 == null) {
                        KClassImpl$Data$declaredNonStaticMembers$24 = "";
                    }
                    mutableListOf.add(KClassImpl$Data$declaredNonStaticMembers$24);
                } else {
                    return CollectionsKt.joinToString$default(CollectionsKt.reversed(mutableListOf), "/", null, null, 0, null, null, 62, null);
                }
            }
        } else {
            SimpleStorage.Companion companion = SimpleStorage.INSTANCE;
            return TextUtils.BuiltInFictitiousFunctionClassFactory(StringsKt.substringAfterLast(path, SimpleStorage.Companion.KClassImpl$Data$declaredNonStaticMembers$2(), ""));
        }
    }

    public static final String KClassImpl$Data$declaredNonStaticMembers$2(DocumentFile documentFile, Context context) {
        String trimEnd;
        DocumentFile documentFile2 = documentFile;
        Intrinsics.checkNotNullParameter(documentFile2, "");
        Intrinsics.checkNotNullParameter(context, "");
        String path = documentFile.getErrorConfigVersion().getPath();
        if (path == null) {
            path = "";
        }
        Intrinsics.checkNotNullParameter(documentFile2, "");
        Intrinsics.checkNotNullParameter(context, "");
        Uri errorConfigVersion = documentFile.getErrorConfigVersion();
        Intrinsics.checkNotNullExpressionValue(errorConfigVersion, "");
        String KClassImpl$Data$declaredNonStaticMembers$22 = UriUtils.KClassImpl$Data$declaredNonStaticMembers$2(errorConfigVersion, context);
        if (MyBillsEntityDataFactory(documentFile)) {
            return path;
        }
        if (KClassImpl$Data$declaredNonStaticMembers$2(documentFile)) {
            String BuiltInFictitiousFunctionClassFactory = TextUtils.BuiltInFictitiousFunctionClassFactory(StringsKt.substringAfterLast(path, "/document/home:", ""));
            StringBuilder sb = new StringBuilder();
            sb.append(PublicDirectory.DOCUMENTS.getAbsolutePath());
            sb.append('/');
            sb.append(BuiltInFictitiousFunctionClassFactory);
            return StringsKt.trimEnd(sb.toString(), '/');
        }
        if (getAuthRequestContext(documentFile)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("/document/");
            sb2.append(KClassImpl$Data$declaredNonStaticMembers$22);
            sb2.append(':');
            if (StringsKt.contains$default((CharSequence) path, (CharSequence) sb2.toString(), false, 2, (Object) null)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("/document/");
                sb3.append(KClassImpl$Data$declaredNonStaticMembers$22);
                sb3.append(':');
                String BuiltInFictitiousFunctionClassFactory2 = TextUtils.BuiltInFictitiousFunctionClassFactory(StringsKt.substringAfterLast(path, sb3.toString(), ""));
                if (Intrinsics.areEqual(KClassImpl$Data$declaredNonStaticMembers$22, PromoActionType.PRIMARY)) {
                    StringBuilder sb4 = new StringBuilder();
                    SimpleStorage.Companion companion = SimpleStorage.INSTANCE;
                    sb4.append(SimpleStorage.Companion.KClassImpl$Data$declaredNonStaticMembers$2());
                    sb4.append('/');
                    sb4.append(BuiltInFictitiousFunctionClassFactory2);
                    return StringsKt.trimEnd(sb4.toString(), '/');
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("/storage/");
                sb5.append(KClassImpl$Data$declaredNonStaticMembers$22);
                sb5.append('/');
                sb5.append(BuiltInFictitiousFunctionClassFactory2);
                return StringsKt.trimEnd(sb5.toString(), '/');
            }
        }
        String obj = documentFile.getErrorConfigVersion().toString();
        if (Intrinsics.areEqual(obj, "content://com.android.providers.downloads.documents/tree/downloads") || Intrinsics.areEqual(obj, "content://com.android.providers.downloads.documents/tree/downloads/document/downloads")) {
            return PublicDirectory.DOWNLOADS.getAbsolutePath();
        }
        if (BuiltInFictitiousFunctionClassFactory(documentFile)) {
            if (Build.VERSION.SDK_INT < 28 && new Regex("/document/\\d+").matches(path)) {
                Uri errorConfigVersion2 = documentFile.getErrorConfigVersion();
                Intrinsics.checkNotNullExpressionValue(errorConfigVersion2, "");
                String PlaceComponentResult = new MediaFile(context, errorConfigVersion2).PlaceComponentResult();
                if (PlaceComponentResult == null) {
                    return "";
                }
                trimEnd = new File(PublicDirectory.DOWNLOADS.getFile(), PlaceComponentResult).getAbsolutePath();
            } else if (Build.VERSION.SDK_INT >= 29 && new Regex("(.*?)/ms[f,d]:\\d+(.*?)").matches(path)) {
                if (PlaceComponentResult(documentFile)) {
                    String[] strArr = new String[1];
                    String KClassImpl$Data$declaredNonStaticMembers$23 = documentFile.KClassImpl$Data$declaredNonStaticMembers$2();
                    if (KClassImpl$Data$declaredNonStaticMembers$23 == null) {
                        KClassImpl$Data$declaredNonStaticMembers$23 = "";
                    }
                    strArr[0] = KClassImpl$Data$declaredNonStaticMembers$23;
                    List mutableListOf = CollectionsKt.mutableListOf(strArr);
                    while (true) {
                        DocumentFile documentFile3 = documentFile2.mParent;
                        if (documentFile3 == null) {
                            documentFile3 = null;
                        } else {
                            documentFile2 = documentFile3;
                        }
                        if (documentFile3 == null) {
                            break;
                        }
                        String KClassImpl$Data$declaredNonStaticMembers$24 = documentFile2.KClassImpl$Data$declaredNonStaticMembers$2();
                        if (KClassImpl$Data$declaredNonStaticMembers$24 == null) {
                            KClassImpl$Data$declaredNonStaticMembers$24 = "";
                        }
                        mutableListOf.add(KClassImpl$Data$declaredNonStaticMembers$24);
                    }
                    StringBuilder sb6 = new StringBuilder();
                    SimpleStorage.Companion companion2 = SimpleStorage.INSTANCE;
                    sb6.append(SimpleStorage.Companion.KClassImpl$Data$declaredNonStaticMembers$2());
                    sb6.append('/');
                    sb6.append(CollectionsKt.joinToString$default(CollectionsKt.reversed(mutableListOf), "/", null, null, 0, null, null, 62, null));
                    trimEnd = StringsKt.trimEnd(sb6.toString(), '/');
                } else {
                    trimEnd = "";
                }
            } else {
                trimEnd = StringsKt.trimEnd(StringsKt.substringAfterLast(path, "/document/raw:", ""), '/');
            }
            Intrinsics.checkNotNullExpressionValue(trimEnd, "");
            return trimEnd;
        } else if (PlaceComponentResult(documentFile)) {
            if (lookAheadTest(documentFile, context)) {
                StringBuilder sb7 = new StringBuilder();
                SimpleStorage.Companion companion3 = SimpleStorage.INSTANCE;
                sb7.append(SimpleStorage.Companion.KClassImpl$Data$declaredNonStaticMembers$2());
                sb7.append('/');
                sb7.append(MyBillsEntityDataFactory(documentFile, context));
                return StringsKt.trimEnd(sb7.toString(), '/');
            }
            StringBuilder sb8 = new StringBuilder();
            sb8.append("/storage/");
            sb8.append(KClassImpl$Data$declaredNonStaticMembers$22);
            sb8.append('/');
            sb8.append(MyBillsEntityDataFactory(documentFile, context));
            return StringsKt.trimEnd(sb8.toString(), '/');
        } else {
            return "";
        }
    }

    public static final boolean BuiltInFictitiousFunctionClassFactory(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "");
        Intrinsics.checkNotNullParameter(context, "");
        return documentFile.BuiltInFictitiousFunctionClassFactory() && getErrorConfigVersion(documentFile, context);
    }

    public static final boolean getErrorConfigVersion(DocumentFile documentFile, Context context) {
        Intrinsics.checkNotNullParameter(documentFile, "");
        Intrinsics.checkNotNullParameter(context, "");
        if (MyBillsEntityDataFactory(documentFile)) {
            String path = documentFile.getErrorConfigVersion().getPath();
            Intrinsics.checkNotNull(path);
            return FileUtils.BuiltInFictitiousFunctionClassFactory(new File(path), context);
        }
        return documentFile.PlaceComponentResult();
    }

    public static DocumentFile MyBillsEntityDataFactory(DocumentFile documentFile, Context context, String str, String str2, CreateMode createMode) {
        DocumentFile MyBillsEntityDataFactory;
        DocumentFile BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(documentFile, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(createMode, "");
        if (documentFile.lookAheadTest() && getErrorConfigVersion(documentFile, context)) {
            DocumentFileCompat documentFileCompat = DocumentFileCompat.KClassImpl$Data$declaredNonStaticMembers$2;
            String BuiltInFictitiousFunctionClassFactory2 = TextUtils.BuiltInFictitiousFunctionClassFactory(DocumentFileCompat.KClassImpl$Data$declaredNonStaticMembers$2(str));
            String substringBeforeLast = StringsKt.substringBeforeLast(BuiltInFictitiousFunctionClassFactory2, '/', "");
            if (substringBeforeLast.length() == 0) {
                MyBillsEntityDataFactory = documentFile;
            } else {
                MyBillsEntityDataFactory = MyBillsEntityDataFactory(documentFile, context, substringBeforeLast, createMode);
                if (MyBillsEntityDataFactory == null) {
                    return null;
                }
            }
            String substringAfterLast$default = StringsKt.substringAfterLast$default(BuiltInFictitiousFunctionClassFactory2, '/', (String) null, 2, (Object) null);
            String MyBillsEntityDataFactory2 = MimeType.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory2);
            if (!(MyBillsEntityDataFactory2.length() > 0) || (str2 != null && !Intrinsics.areEqual(str2, "*/*") && !Intrinsics.areEqual(str2, ZebraLoader.MIME_TYPE_STREAM))) {
                MyBillsEntityDataFactory2 = MimeType.KClassImpl$Data$declaredNonStaticMembers$2(str2, BuiltInFictitiousFunctionClassFactory2);
            }
            String removeSuffix = StringsKt.removeSuffix(substringAfterLast$default, (CharSequence) Intrinsics.stringPlus(".", MyBillsEntityDataFactory2));
            StringBuilder sb = new StringBuilder();
            sb.append(removeSuffix);
            sb.append('.');
            sb.append(MyBillsEntityDataFactory2);
            String trimEnd = StringsKt.trimEnd(sb.toString(), '.');
            if (createMode != CreateMode.CREATE_NEW && (BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(MyBillsEntityDataFactory, context, trimEnd, false)) != null) {
                if (!BuiltInFictitiousFunctionClassFactory.getAuthRequestContext()) {
                    BuiltInFictitiousFunctionClassFactory = null;
                }
                if (BuiltInFictitiousFunctionClassFactory != null) {
                    if (createMode != CreateMode.REPLACE) {
                        if (BuiltInFictitiousFunctionClassFactory.scheduleImpl()) {
                            return BuiltInFictitiousFunctionClassFactory;
                        }
                    } else {
                        Intrinsics.checkNotNullParameter(BuiltInFictitiousFunctionClassFactory, "");
                        Intrinsics.checkNotNullParameter(context, "");
                        if (BuiltInFictitiousFunctionClassFactory.getAuthRequestContext() && (MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory) || getAuthRequestContext(BuiltInFictitiousFunctionClassFactory))) {
                            String KClassImpl$Data$declaredNonStaticMembers$22 = BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2();
                            String str3 = KClassImpl$Data$declaredNonStaticMembers$22 != null ? KClassImpl$Data$declaredNonStaticMembers$22 : "";
                            DocumentFile moveToNextValue = moveToNextValue(BuiltInFictitiousFunctionClassFactory, context);
                            if (moveToNextValue != null && getErrorConfigVersion(moveToNextValue, context)) {
                                String NetworkUserEntityData$$ExternalSyntheticLambda0 = BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0();
                                KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory, context, false);
                                return MyBillsEntityDataFactory(moveToNextValue, context, str3, NetworkUserEntityData$$ExternalSyntheticLambda0, CreateMode.CREATE_NEW);
                            }
                        }
                    }
                    return null;
                }
            }
            if (MyBillsEntityDataFactory(documentFile)) {
                File scheduleImpl = scheduleImpl(documentFile, context);
                File authRequestContext = scheduleImpl == null ? null : FileUtils.getAuthRequestContext(scheduleImpl, context, BuiltInFictitiousFunctionClassFactory2, str2, createMode);
                if (authRequestContext == null) {
                    return null;
                }
                return DocumentFile.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext);
            }
            String KClassImpl$Data$declaredNonStaticMembers$23 = MimeType.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory2);
            if (Intrinsics.areEqual(KClassImpl$Data$declaredNonStaticMembers$23, "*/*")) {
                KClassImpl$Data$declaredNonStaticMembers$23 = ZebraLoader.MIME_TYPE_STREAM;
            }
            if (Build.VERSION.SDK_INT > 28) {
                DocumentFile BuiltInFictitiousFunctionClassFactory3 = MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$23, removeSuffix);
                if (BuiltInFictitiousFunctionClassFactory3 == null) {
                    return null;
                }
                if (Intrinsics.areEqual(KClassImpl$Data$declaredNonStaticMembers$23, ZebraLoader.MIME_TYPE_STREAM) && !Intrinsics.areEqual(BuiltInFictitiousFunctionClassFactory3.KClassImpl$Data$declaredNonStaticMembers$2(), trimEnd)) {
                    BuiltInFictitiousFunctionClassFactory3.KClassImpl$Data$declaredNonStaticMembers$2(trimEnd);
                }
                return BuiltInFictitiousFunctionClassFactory3;
            }
            return MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$23, trimEnd);
        }
        return null;
    }

    private static DocumentFile MyBillsEntityDataFactory(DocumentFile documentFile, Context context, String str, CreateMode createMode) {
        DocumentFile MyBillsEntityDataFactory;
        Intrinsics.checkNotNullParameter(documentFile, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(createMode, "");
        if (documentFile.lookAheadTest() && getErrorConfigVersion(documentFile, context)) {
            if (MyBillsEntityDataFactory(documentFile)) {
                File scheduleImpl = scheduleImpl(documentFile, context);
                File BuiltInFictitiousFunctionClassFactory = scheduleImpl == null ? null : FileUtils.BuiltInFictitiousFunctionClassFactory(scheduleImpl, context, str, createMode);
                if (BuiltInFictitiousFunctionClassFactory == null) {
                    return null;
                }
                return DocumentFile.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory);
            }
            DocumentFileCompat documentFileCompat = DocumentFileCompat.KClassImpl$Data$declaredNonStaticMembers$2;
            DocumentFileCompat documentFileCompat2 = DocumentFileCompat.KClassImpl$Data$declaredNonStaticMembers$2;
            List<String> mutableList = CollectionsKt.toMutableList((Collection) DocumentFileCompat.PlaceComponentResult(DocumentFileCompat.KClassImpl$Data$declaredNonStaticMembers$2(str)));
            String str2 = (String) CollectionsKt.removeFirstOrNull(mutableList);
            if (str2 == null) {
                return null;
            }
            if (BuiltInFictitiousFunctionClassFactory(documentFile) && PlaceComponentResult(documentFile) && (documentFile = NetworkUserEntityData$$ExternalSyntheticLambda0(documentFile, context)) == null) {
                return null;
            }
            DocumentFile BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(documentFile, context, str2, false);
            if (BuiltInFictitiousFunctionClassFactory2 == null || createMode == CreateMode.CREATE_NEW) {
                BuiltInFictitiousFunctionClassFactory2 = documentFile.getAuthRequestContext(str2);
                if (BuiltInFictitiousFunctionClassFactory2 == null) {
                    return null;
                }
            } else if (createMode == CreateMode.REPLACE) {
                KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory2, context, true);
                if (!BuiltInFictitiousFunctionClassFactory2.lookAheadTest() && (BuiltInFictitiousFunctionClassFactory2 = documentFile.getAuthRequestContext(str2)) == null) {
                    return null;
                }
            } else if (!BuiltInFictitiousFunctionClassFactory2.lookAheadTest() || !BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory()) {
                return null;
            }
            ContentResolver contentResolver = context.getContentResolver();
            for (String str3 : mutableList) {
                try {
                    Intrinsics.checkNotNullExpressionValue(contentResolver, "");
                    MyBillsEntityDataFactory = MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory2, context, contentResolver, str3);
                } catch (Exception unused) {
                }
                if (MyBillsEntityDataFactory == null) {
                    BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory2.getAuthRequestContext(str3);
                    if (BuiltInFictitiousFunctionClassFactory2 == null) {
                        return null;
                    }
                } else {
                    if (MyBillsEntityDataFactory.lookAheadTest() && MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory()) {
                        BuiltInFictitiousFunctionClassFactory2 = MyBillsEntityDataFactory;
                    }
                    return null;
                }
            }
            return BuiltInFictitiousFunctionClassFactory2;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:128:0x009e, code lost:
    
        if (new kotlin.text.Regex("/tree/downloads/document/ms[f,d]:\\d+").matches(r1) == false) goto L129;
     */
    /* JADX WARN: Removed duplicated region for block: B:146:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final androidx.documentfile.provider.DocumentFile NetworkUserEntityData$$ExternalSyntheticLambda0(androidx.documentfile.provider.DocumentFile r11, android.content.Context r12) {
        /*
            java.lang.String r6 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r6)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r6)
            boolean r1 = BuiltInFictitiousFunctionClassFactory(r11)
            r7 = 0
            if (r1 == 0) goto Lc8
            android.net.Uri r1 = r11.getErrorConfigVersion()
            java.lang.String r1 = r1.getPath()
            if (r1 != 0) goto L1b
            r8 = r6
            goto L1c
        L1b:
            r8 = r1
        L1c:
            android.net.Uri r1 = r11.getErrorConfigVersion()
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "content://com.android.providers.downloads.documents/tree/downloads/document/downloads"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r2)
            if (r1 == 0) goto L34
            boolean r1 = getErrorConfigVersion(r11, r12)
            if (r1 == 0) goto Lc8
            goto Lc7
        L34:
            int r1 = android.os.Build.VERSION.SDK_INT
            java.lang.String r2 = "/tree/downloads/document/raw:"
            r3 = 29
            r4 = 0
            r9 = 2
            if (r1 < r3) goto L72
            boolean r1 = kotlin.text.StringsKt.startsWith$default(r8, r2, r4, r9, r7)
            java.lang.String r10 = "/document/raw:"
            if (r1 != 0) goto L4c
            boolean r1 = kotlin.text.StringsKt.startsWith$default(r8, r10, r4, r9, r7)
            if (r1 == 0) goto L72
        L4c:
            com.anggrayudi.storage.file.PublicDirectory r1 = com.anggrayudi.storage.file.PublicDirectory.DOWNLOADS
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 12
            r0 = r12
            androidx.documentfile.provider.DocumentFile r0 = com.anggrayudi.storage.file.DocumentFileCompat.KClassImpl$Data$declaredNonStaticMembers$2(r0, r1, r2, r3, r4, r5)
            if (r0 != 0) goto L5b
            return r7
        L5b:
            java.lang.String r1 = kotlin.text.StringsKt.substringAfterLast$default(r8, r10, r7, r9, r7)
            java.lang.String r2 = android.os.Environment.DIRECTORY_DOWNLOADS
            java.lang.String r3 = "/"
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r2)
            java.lang.String r1 = kotlin.text.StringsKt.substringAfter(r1, r2, r6)
            r2 = 1
            androidx.documentfile.provider.DocumentFile r0 = BuiltInFictitiousFunctionClassFactory(r0, r12, r1, r2)
            r7 = r0
            goto Lc8
        L72:
            int r1 = android.os.Build.VERSION.SDK_INT
            if (r1 < r3) goto La0
            r1 = r8
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            kotlin.text.Regex r5 = new kotlin.text.Regex
            java.lang.String r6 = "/document/ms[f,d]:\\d+"
            r5.<init>(r6)
            boolean r5 = r5.matches(r1)
            if (r5 != 0) goto Lc1
            kotlin.text.Regex r5 = new kotlin.text.Regex
            java.lang.String r6 = "/tree/ms[f,d]:\\d+(.*?)"
            r5.<init>(r6)
            boolean r5 = r5.matches(r1)
            if (r5 != 0) goto Lc1
            kotlin.text.Regex r5 = new kotlin.text.Regex
            java.lang.String r6 = "/tree/downloads/document/ms[f,d]:\\d+"
            r5.<init>(r6)
            boolean r1 = r5.matches(r1)
            if (r1 != 0) goto Lc1
        La0:
            int r1 = android.os.Build.VERSION.SDK_INT
            if (r1 >= r3) goto Lc8
            java.lang.String r1 = "/tree/raw:"
            boolean r1 = kotlin.text.StringsKt.startsWith$default(r8, r1, r4, r9, r7)
            if (r1 != 0) goto Lc1
            boolean r1 = kotlin.text.StringsKt.startsWith$default(r8, r2, r4, r9, r7)
            if (r1 != 0) goto Lc1
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            kotlin.text.Regex r1 = new kotlin.text.Regex
            java.lang.String r2 = "/document/\\d+"
            r1.<init>(r2)
            boolean r1 = r1.matches(r8)
            if (r1 == 0) goto Lc8
        Lc1:
            boolean r1 = getErrorConfigVersion(r11, r12)
            if (r1 == 0) goto Lc8
        Lc7:
            r7 = r11
        Lc8:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileUtils.NetworkUserEntityData$$ExternalSyntheticLambda0(androidx.documentfile.provider.DocumentFile, android.content.Context):androidx.documentfile.provider.DocumentFile");
    }

    /* JADX WARN: Removed duplicated region for block: B:94:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<androidx.documentfile.provider.DocumentFile> KClassImpl$Data$declaredNonStaticMembers$2(androidx.documentfile.provider.DocumentFile r10, com.anggrayudi.storage.file.DocumentFileType r11, java.lang.String[] r12, java.lang.String r13, kotlin.text.Regex r14) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            boolean r1 = r10.lookAheadTest()
            if (r1 == 0) goto Lac
            boolean r1 = r10.BuiltInFictitiousFunctionClassFactory()
            if (r1 == 0) goto Lac
            byte[] r1 = com.anggrayudi.storage.file.DocumentFileUtils.getAuthRequestContext     // Catch: java.lang.Throwable -> La3
            r2 = 15
            r1 = r1[r2]     // Catch: java.lang.Throwable -> La3
            r3 = 1
            int r1 = r1 + r3
            byte r1 = (byte) r1     // Catch: java.lang.Throwable -> La3
            byte[] r4 = com.anggrayudi.storage.file.DocumentFileUtils.getAuthRequestContext     // Catch: java.lang.Throwable -> La3
            r4 = r4[r2]     // Catch: java.lang.Throwable -> La3
            int r4 = -r4
            byte r4 = (byte) r4     // Catch: java.lang.Throwable -> La3
            byte[] r5 = com.anggrayudi.storage.file.DocumentFileUtils.getAuthRequestContext     // Catch: java.lang.Throwable -> La3
            r6 = 16
            r5 = r5[r6]     // Catch: java.lang.Throwable -> La3
            byte r5 = (byte) r5     // Catch: java.lang.Throwable -> La3
            java.lang.Object[] r6 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> La3
            a(r1, r4, r5, r6)     // Catch: java.lang.Throwable -> La3
            r1 = 0
            r4 = r6[r1]     // Catch: java.lang.Throwable -> La3
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> La3
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch: java.lang.Throwable -> La3
            byte[] r5 = com.anggrayudi.storage.file.DocumentFileUtils.getAuthRequestContext     // Catch: java.lang.Throwable -> La3
            r5 = r5[r2]     // Catch: java.lang.Throwable -> La3
            int r5 = -r5
            byte r5 = (byte) r5     // Catch: java.lang.Throwable -> La3
            int r6 = r5 + (-1)
            byte r6 = (byte) r6     // Catch: java.lang.Throwable -> La3
            byte[] r7 = com.anggrayudi.storage.file.DocumentFileUtils.getAuthRequestContext     // Catch: java.lang.Throwable -> La3
            r2 = r7[r2]     // Catch: java.lang.Throwable -> La3
            byte r2 = (byte) r2     // Catch: java.lang.Throwable -> La3
            java.lang.Object[] r7 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> La3
            a(r5, r6, r2, r7)     // Catch: java.lang.Throwable -> La3
            r2 = r7[r1]     // Catch: java.lang.Throwable -> La3
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> La3
            r5 = 0
            java.lang.reflect.Method r2 = r4.getMethod(r2, r5)     // Catch: java.lang.Throwable -> La3
            java.lang.Object r2 = r2.invoke(r5, r5)     // Catch: java.lang.Throwable -> La3
            r9 = r2
            java.lang.Thread r9 = (java.lang.Thread) r9     // Catch: java.lang.Throwable -> La3
            if (r12 == 0) goto L6a
            int r2 = r12.length
            if (r2 != 0) goto L65
            r2 = 1
            goto L66
        L65:
            r2 = 0
        L66:
            if (r2 != 0) goto L6a
            r2 = 0
            goto L6b
        L6a:
            r2 = 1
        L6b:
            if (r2 != 0) goto L90
            int r2 = r12.length
            r4 = 0
        L6f:
            if (r4 >= r2) goto L7f
            r5 = r12[r4]
        */
        //  java.lang.String r6 = "*/*"
        /*
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
            if (r5 == 0) goto L7c
            goto L80
        L7c:
            int r4 = r4 + 1
            goto L6f
        L7f:
            r3 = 0
        L80:
            if (r3 != 0) goto L90
            com.anggrayudi.storage.file.DocumentFileType r5 = com.anggrayudi.storage.file.DocumentFileType.FILE
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)
            r4 = r10
            r6 = r12
            r7 = r13
            r8 = r14
            java.util.List r10 = MyBillsEntityDataFactory(r4, r5, r6, r7, r8, r9)
            goto Lb0
        L90:
            java.lang.String[] r12 = new java.lang.String[r1]
            java.lang.Object[] r12 = (java.lang.Object[]) r12
            r6 = r12
            java.lang.String[] r6 = (java.lang.String[]) r6
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)
            r4 = r10
            r5 = r11
            r7 = r13
            r8 = r14
            java.util.List r10 = MyBillsEntityDataFactory(r4, r5, r6, r7, r8, r9)
            goto Lb0
        La3:
            r10 = move-exception
            java.lang.Throwable r11 = r10.getCause()
            if (r11 == 0) goto Lab
            throw r11
        Lab:
            throw r10
        Lac:
            java.util.List r10 = kotlin.collections.CollectionsKt.emptyList()
        Lb0:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anggrayudi.storage.file.DocumentFileUtils.KClassImpl$Data$declaredNonStaticMembers$2(androidx.documentfile.provider.DocumentFile, com.anggrayudi.storage.file.DocumentFileType, java.lang.String[], java.lang.String, kotlin.text.Regex):java.util.List");
    }

    public static final boolean MyBillsEntityDataFactory(DocumentFile documentFile, String[] strArr) {
        String NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (!(strArr.length == 0)) {
            Intrinsics.checkNotNullParameter(documentFile, "");
            if (documentFile.lookAheadTest()) {
                NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
            } else {
                String KClassImpl$Data$declaredNonStaticMembers$22 = MimeType.KClassImpl$Data$declaredNonStaticMembers$2(MimeType.MyBillsEntityDataFactory(documentFile.KClassImpl$Data$declaredNonStaticMembers$2()));
                NetworkUserEntityData$$ExternalSyntheticLambda0 = Intrinsics.areEqual(KClassImpl$Data$declaredNonStaticMembers$22, "*/*") ? documentFile.NetworkUserEntityData$$ExternalSyntheticLambda0() : KClassImpl$Data$declaredNonStaticMembers$22;
            }
            String PlaceComponentResult = MimeTypeFilter.PlaceComponentResult(NetworkUserEntityData$$ExternalSyntheticLambda0, strArr);
            if (PlaceComponentResult == null || PlaceComponentResult.length() == 0) {
                return false;
            }
        }
        return true;
    }

    private static final List<DocumentFile> MyBillsEntityDataFactory(DocumentFile documentFile, DocumentFileType documentFileType, String[] strArr, String str, Regex regex, Thread thread) {
        ArrayList arrayList = new ArrayList();
        DocumentFile[] DatabaseTableConfigUtil = documentFile.DatabaseTableConfigUtil();
        Intrinsics.checkNotNullExpressionValue(DatabaseTableConfigUtil, "");
        for (DocumentFile documentFile2 : DatabaseTableConfigUtil) {
            if (thread.isInterrupted()) {
                break;
            }
            if (documentFile.BuiltInFictitiousFunctionClassFactory()) {
                if (documentFile2.scheduleImpl()) {
                    if (documentFileType != DocumentFileType.FOLDER) {
                        String KClassImpl$Data$declaredNonStaticMembers$22 = documentFile2.KClassImpl$Data$declaredNonStaticMembers$2();
                        if (KClassImpl$Data$declaredNonStaticMembers$22 == null) {
                            KClassImpl$Data$declaredNonStaticMembers$22 = "";
                        }
                        if (((str.length() == 0) || Intrinsics.areEqual(KClassImpl$Data$declaredNonStaticMembers$22, str)) && (regex == null || regex.matches(KClassImpl$Data$declaredNonStaticMembers$22))) {
                            Intrinsics.checkNotNullExpressionValue(documentFile2, "");
                            if (MyBillsEntityDataFactory(documentFile2, strArr)) {
                                arrayList.add(documentFile2);
                            }
                        }
                    }
                } else {
                    if (documentFileType != DocumentFileType.FILE) {
                        String KClassImpl$Data$declaredNonStaticMembers$23 = documentFile2.KClassImpl$Data$declaredNonStaticMembers$2();
                        if (KClassImpl$Data$declaredNonStaticMembers$23 == null) {
                            KClassImpl$Data$declaredNonStaticMembers$23 = "";
                        }
                        if (((str.length() == 0) || Intrinsics.areEqual(KClassImpl$Data$declaredNonStaticMembers$23, str)) && (regex == null || regex.matches(KClassImpl$Data$declaredNonStaticMembers$23))) {
                            Intrinsics.checkNotNullExpressionValue(documentFile2, "");
                            arrayList.add(documentFile2);
                        }
                    }
                    Intrinsics.checkNotNullExpressionValue(documentFile2, "");
                    arrayList.addAll(MyBillsEntityDataFactory(documentFile2, documentFileType, strArr, str, regex, thread));
                }
            }
        }
        return arrayList;
    }

    public static boolean getAuthRequestContext(DocumentFile documentFile, Context context, boolean z) {
        List<DocumentFile> scheduleImpl;
        Intrinsics.checkNotNullParameter(documentFile, "");
        Intrinsics.checkNotNullParameter(context, "");
        if (documentFile.lookAheadTest() && documentFile.BuiltInFictitiousFunctionClassFactory()) {
            if (BuiltInFictitiousFunctionClassFactory(documentFile)) {
                DocumentFile NetworkUserEntityData$$ExternalSyntheticLambda0 = NetworkUserEntityData$$ExternalSyntheticLambda0(documentFile, context);
                if (NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                    return false;
                }
                scheduleImpl = scheduleImpl(NetworkUserEntityData$$ExternalSyntheticLambda0);
            } else {
                scheduleImpl = scheduleImpl(documentFile);
            }
            int size = scheduleImpl.size();
            int size2 = scheduleImpl.size() - 1;
            if (size2 >= 0) {
                while (true) {
                    int i = size2 - 1;
                    if (scheduleImpl.get(size2).MyBillsEntityDataFactory()) {
                        size--;
                    }
                    if (i < 0) {
                        break;
                    }
                    size2 = i;
                }
            }
            if (size == 0) {
                return z || documentFile.MyBillsEntityDataFactory() || !documentFile.getAuthRequestContext();
            }
            return false;
        }
        return false;
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(DocumentFile documentFile, Context context, boolean z) {
        Intrinsics.checkNotNullParameter(documentFile, "");
        Intrinsics.checkNotNullParameter(context, "");
        if (documentFile.lookAheadTest()) {
            return getAuthRequestContext(documentFile, context, z);
        }
        return documentFile.MyBillsEntityDataFactory() || !documentFile.getAuthRequestContext();
    }

    private static final List<DocumentFile> scheduleImpl(DocumentFile documentFile) {
        ArrayList arrayList = new ArrayList();
        DocumentFile[] DatabaseTableConfigUtil = documentFile.DatabaseTableConfigUtil();
        Intrinsics.checkNotNullExpressionValue(DatabaseTableConfigUtil, "");
        for (DocumentFile documentFile2 : DatabaseTableConfigUtil) {
            if (!documentFile2.MyBillsEntityDataFactory()) {
                Intrinsics.checkNotNullExpressionValue(documentFile2, "");
                arrayList.add(documentFile2);
            }
            if (documentFile2.lookAheadTest()) {
                Intrinsics.checkNotNullExpressionValue(documentFile2, "");
                arrayList.addAll(scheduleImpl(documentFile2));
            }
        }
        return arrayList;
    }

    public static final OutputStream BuiltInFictitiousFunctionClassFactory(DocumentFile documentFile, Context context, boolean z) {
        Intrinsics.checkNotNullParameter(documentFile, "");
        Intrinsics.checkNotNullParameter(context, "");
        Uri errorConfigVersion = documentFile.getErrorConfigVersion();
        Intrinsics.checkNotNullExpressionValue(errorConfigVersion, "");
        return UriUtils.getAuthRequestContext(errorConfigVersion, context, true);
    }

    public static final FileCallback.ErrorCode MyBillsEntityDataFactory(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "");
        if (exc instanceof SecurityException) {
            return FileCallback.ErrorCode.STORAGE_PERMISSION_DENIED;
        }
        return exc instanceof InterruptedIOException ? true : exc instanceof InterruptedException ? FileCallback.ErrorCode.CANCELED : FileCallback.ErrorCode.UNKNOWN_IO_ERROR;
    }

    public static final /* synthetic */ void PlaceComponentResult(DocumentFile documentFile, InputStream inputStream, OutputStream outputStream, Object obj, boolean z, long j, boolean z2, final FileCallback fileCallback) {
        Job job;
        try {
            final Ref.LongRef longRef = new Ref.LongRef();
            final Ref.IntRef intRef = new Ref.IntRef();
            final long moveToNextValue = documentFile.moveToNextValue();
            job = (!z || moveToNextValue <= 10485760) ? null : CoroutineExtKt.getAuthRequestContext(j, new Function0<Unit>() { // from class: com.anggrayudi.storage.file.DocumentFileUtils$copyFileStream$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FileCallback.Report report = new FileCallback.Report((((float) Ref.LongRef.this.element) * 100.0f) / ((float) moveToNextValue), Ref.LongRef.this.element, intRef.element);
                    BuildersKt__Builders_commonKt.launch$default(fileCallback.PlaceComponentResult, Dispatchers.getMain(), null, new DocumentFileUtils$copyFileStream$1$invoke$$inlined$postToUi$1(null, fileCallback, report), 2, null);
                    intRef.element = 0;
                }
            });
            try {
                byte[] bArr = new byte[8192];
                int read = inputStream.read(bArr);
                while (read != -1) {
                    try {
                        outputStream.write(bArr, 0, read);
                        longRef.element += read;
                        intRef.element += read;
                        read = inputStream.read(bArr);
                    } catch (Throwable th) {
                        th = th;
                        if (job != null) {
                            Job.DefaultImpls.cancel$default(job, null, 1, null);
                        }
                        IOUtils.KClassImpl$Data$declaredNonStaticMembers$2(inputStream);
                        IOUtils.KClassImpl$Data$declaredNonStaticMembers$2(outputStream);
                        throw th;
                    }
                }
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, null, 1, null);
                }
                if (z2) {
                    documentFile.MyBillsEntityDataFactory();
                }
                BuildersKt__Builders_commonKt.launch$default(fileCallback.PlaceComponentResult, Dispatchers.getMain(), null, new DocumentFileUtils$copyFileStream$$inlined$postToUi$1(null, fileCallback, obj), 2, null);
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, null, 1, null);
                }
                IOUtils.KClassImpl$Data$declaredNonStaticMembers$2(inputStream);
                IOUtils.KClassImpl$Data$declaredNonStaticMembers$2(outputStream);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            job = null;
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(Context context, DocumentFile documentFile, DocumentFile documentFile2, BaseFileCallback baseFileCallback, Function2 function2) {
        FileCallback.ErrorCode errorCode;
        FileCallback.ErrorCode errorCode2;
        OutputStream BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(documentFile2, context, true);
        if (BuiltInFictitiousFunctionClassFactory == null) {
            if (baseFileCallback instanceof MultipleFileCallback) {
                errorCode2 = MultipleFileCallback.ErrorCode.CANNOT_CREATE_FILE_IN_TARGET;
            } else {
                errorCode2 = baseFileCallback instanceof FolderCallback ? FolderCallback.ErrorCode.CANNOT_CREATE_FILE_IN_TARGET : FileCallback.ErrorCode.TARGET_FILE_NOT_FOUND;
            }
            BuildersKt__Builders_commonKt.launch$default(baseFileCallback.PlaceComponentResult, Dispatchers.getMain(), null, new DocumentFileUtils$createFileStreams$$inlined$postToUi$1(null, baseFileCallback, errorCode2), 2, null);
            return;
        }
        Intrinsics.checkNotNullParameter(documentFile, "");
        Intrinsics.checkNotNullParameter(context, "");
        Uri errorConfigVersion = documentFile.getErrorConfigVersion();
        Intrinsics.checkNotNullExpressionValue(errorConfigVersion, "");
        InputStream BuiltInFictitiousFunctionClassFactory2 = UriUtils.BuiltInFictitiousFunctionClassFactory(errorConfigVersion, context);
        if (BuiltInFictitiousFunctionClassFactory2 == null) {
            IOUtils.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory);
            if (baseFileCallback instanceof MultipleFileCallback) {
                errorCode = MultipleFileCallback.ErrorCode.SOURCE_FILE_NOT_FOUND;
            } else {
                errorCode = baseFileCallback instanceof FolderCallback ? FolderCallback.ErrorCode.SOURCE_FILE_NOT_FOUND : FileCallback.ErrorCode.SOURCE_FILE_NOT_FOUND;
            }
            BuildersKt__Builders_commonKt.launch$default(baseFileCallback.PlaceComponentResult, Dispatchers.getMain(), null, new DocumentFileUtils$createFileStreams$$inlined$postToUi$2(null, baseFileCallback, errorCode), 2, null);
            return;
        }
        function2.invoke(BuiltInFictitiousFunctionClassFactory2, BuiltInFictitiousFunctionClassFactory);
    }

    public static final /* synthetic */ FolderCallback.ErrorCode KClassImpl$Data$declaredNonStaticMembers$2(Exception exc) {
        if (exc instanceof SecurityException) {
            return FolderCallback.ErrorCode.STORAGE_PERMISSION_DENIED;
        }
        return exc instanceof InterruptedIOException ? true : exc instanceof InterruptedException ? FolderCallback.ErrorCode.CANCELED : FolderCallback.ErrorCode.UNKNOWN_IO_ERROR;
    }

    public static final /* synthetic */ MultipleFileCallback.ErrorCode BuiltInFictitiousFunctionClassFactory(Exception exc) {
        if (exc instanceof SecurityException) {
            return MultipleFileCallback.ErrorCode.STORAGE_PERMISSION_DENIED;
        }
        return exc instanceof InterruptedIOException ? true : exc instanceof InterruptedException ? MultipleFileCallback.ErrorCode.CANCELED : MultipleFileCallback.ErrorCode.UNKNOWN_IO_ERROR;
    }

    private static DocumentFile moveToNextValue(DocumentFile documentFile, Context context) {
        DocumentFile MyBillsEntityDataFactory;
        Intrinsics.checkNotNullParameter(documentFile, "");
        Intrinsics.checkNotNullParameter(context, "");
        DocumentFile documentFile2 = documentFile.mParent;
        if (documentFile2 == null) {
            if (PlaceComponentResult(documentFile) || MyBillsEntityDataFactory(documentFile)) {
                String PlaceComponentResult = TextUtils.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2(documentFile, context));
                if (!(PlaceComponentResult.length() == 0) && (MyBillsEntityDataFactory = DocumentFileCompat.MyBillsEntityDataFactory(context, PlaceComponentResult, null, true, false, 20)) != null) {
                    try {
                        Field declaredField = DocumentFile.class.getDeclaredField("mParent");
                        declaredField.setAccessible(true);
                        declaredField.set(documentFile, MyBillsEntityDataFactory);
                        return MyBillsEntityDataFactory;
                    } catch (Exception e) {
                        InstrumentInjector.log_w("DocumentFileUtils", "Cannot modify field mParent in androidx.documentfile.provider.DocumentFile. Please exclude DocumentFile from obfuscation.", e);
                        return MyBillsEntityDataFactory;
                    }
                }
            }
            return null;
        }
        return documentFile2;
    }
}
