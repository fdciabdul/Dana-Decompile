package id.dana.sendmoney_v2.recipient.view;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentManager;
import androidx.paging.AsyncPagedListDiffer;
import androidx.paging.PagedList;
import androidx.paging.RxPagedListBuilder;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.ComponentActivity;
import com.afollestad.materialdialogs.MaterialDialog;
import com.anggrayudi.storage.permission.ActivityPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionReport;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ethanhua.skeleton.SkeletonScreen;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.ThrottledOnExecuteAction;
import id.dana.base.ThrottledOnItemClickListener;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.common.RecyclerViewSectionDecorator;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.contract.contact.DanaContactContract;
import id.dana.contract.sendmoney.bank.SavedBankCardContract;
import id.dana.contract.sendmoney.v2.SortingSendMoneyContract;
import id.dana.contract.sendmoney.v2.SortingSendMoneyPresenter;
import id.dana.core.ui.util.ShimmeringUtil;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.util.NumberUtils;
import id.dana.databinding.ViewRecipientV2Binding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerRecipientComponentV2;
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.di.modules.DanaContactModule;
import id.dana.di.modules.SavedBankModule;
import id.dana.di.modules.SortingSendMoneyModule;
import id.dana.extension.view.ViewExtKt;
import id.dana.richview.SearchView;
import id.dana.scanner.ScannerActivity;
import id.dana.scanner.handler.ScannerActionFactory;
import id.dana.sendmoney.model.RecentBankModel;
import id.dana.sendmoney.model.RecentRecipientModel;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.model.RecipientViewModel;
import id.dana.sendmoney.recipient.recent.RecentRecipientContract;
import id.dana.sendmoney.recipient.recent.RecentRecipientModule;
import id.dana.sendmoney.ui.groupsend.summary.activity.GroupSendSummaryActivity;
import id.dana.sendmoney.ui.groupsend.summary.model.GroupSendIntentModel;
import id.dana.sendmoney.view.BaseRecipientListener;
import id.dana.sendmoney.view.RecipientSelectedListener;
import id.dana.sendmoney_v2.constants.SortingByConst;
import id.dana.sendmoney_v2.landing.SendMoneyActivity;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule;
import id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity;
import id.dana.sendmoney_v2.recipient.activity.SearchRecipientActivity;
import id.dana.sendmoney_v2.recipient.activity.SortBankAccountBottomSheetActivity;
import id.dana.sendmoney_v2.recipient.adapter.RecipientAdapter;
import id.dana.sendmoney_v2.recipient.datasource.BankDataSourceFactory;
import id.dana.sendmoney_v2.recipient.datasource.NewContactDataSourceFactory;
import id.dana.sendmoney_v2.recipient.datasource.NewSearchDataSourceFactory;
import id.dana.sendmoney_v2.recipient.datasource.RecipientDataSourceFactory;
import id.dana.sendmoney_v2.recipient.view.RecipientSourceType;
import id.dana.sendmoney_v2.tracker.SendMoneyAnalyticTracker;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import id.dana.utils.KeyboardHelper;
import id.dana.utils.permission.PermissionHelper;
import io.reactivex.BackpressureStrategy;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.operators.flowable.FlowableInternalHelper;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u009c\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 È\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002È\u0001B.\b\u0016\u0012\b\u0010À\u0001\u001a\u00030¿\u0001\u0012\f\b\u0002\u0010Â\u0001\u001a\u0005\u0018\u00010Á\u0001\u0012\t\b\u0002\u0010Ã\u0001\u001a\u00020\u0013¢\u0006\u0006\bÄ\u0001\u0010Å\u0001B3\b\u0016\u0012\b\u0010À\u0001\u001a\u00030¿\u0001\u0012\n\u0010Â\u0001\u001a\u0005\u0018\u00010Á\u0001\u0012\u0007\u0010Ã\u0001\u001a\u00020\u0013\u0012\u0007\u0010Æ\u0001\u001a\u00020\u0013¢\u0006\u0006\bÄ\u0001\u0010Ç\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\n\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\n\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0016\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u0016\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010 \u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\"\u0010\rJ\r\u0010#\u001a\u00020\u0005¢\u0006\u0004\b#\u0010\tJ\u0017\u0010$\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u0013H\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b,\u0010-J\u0017\u0010\u0016\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0016\u0010\u0012J\u0015\u0010/\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u000b¢\u0006\u0004\b/\u0010-J\u0017\u0010\"\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\"\u0010+J\u000f\u0010,\u001a\u00020\u0005H\u0002¢\u0006\u0004\b,\u0010\tJ\u000f\u0010*\u001a\u00020\u0005H\u0002¢\u0006\u0004\b*\u0010\tJ\u0015\u00101\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u000b¢\u0006\u0004\b1\u0010\rJ\u000f\u00102\u001a\u00020\u0005H\u0002¢\u0006\u0004\b2\u0010\tJ\u0015\u00104\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u0013¢\u0006\u0004\b4\u00105J\u0015\u00107\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u000b¢\u0006\u0004\b7\u0010\rJ\u000f\u00108\u001a\u00020\u0005H\u0016¢\u0006\u0004\b8\u0010\tJ\u0013\u0010:\u001a\u0006*\u00020909H\u0002¢\u0006\u0004\b:\u0010;J\u001b\u0010?\u001a\u00020\u00052\f\u0010>\u001a\b\u0012\u0004\u0012\u00020=0<¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\u0005H\u0002¢\u0006\u0004\bA\u0010\tJ\u0013\u0010\n\u001a\u00020\u0010*\u00020BH\u0002¢\u0006\u0004\b\n\u0010CR\u0013\u0010\n\u001a\u00020DX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\n\u0010ER\u001e\u0010\"\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010HR\"\u0010J\u001a\u00020I8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR*\u0010V\u001a\u00020\u00102\u0006\u0010P\u001a\u00020\u00108\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR*\u0010Y\u001a\u00020\u00102\u0006\u0010P\u001a\u00020\u00108\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010Q\u001a\u0004\bW\u0010S\"\u0004\bX\u0010UR$\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8\u0002@CX\u0083\u000e¢\u0006\f\n\u0004\b*\u0010Z\"\u0004\b*\u0010\rR\u0016\u0010,\u001a\u00020\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b:\u0010QR\u0016\u0010*\u001a\u00020\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b2\u0010QR\u0014\u0010:\u001a\u00020\u00108CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010SR\"\u0010[\u001a\u00020\u00108\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bA\u0010Q\u001a\u0004\b[\u0010S\"\u0004\b\\\u0010UR\u0014\u0010^\u001a\u00020\u00108\u0002X\u0083\u0006¢\u0006\u0006\n\u0004\b]\u0010QR\u0014\u0010A\u001a\u00020\u00108\u0002X\u0083\u0006¢\u0006\u0006\n\u0004\b^\u0010QR\u0016\u00102\u001a\u00020\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b_\u0010QR\u0016\u0010]\u001a\u00020\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010e\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010f\u001a\u00020\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bf\u0010QR*\u0010i\u001a\u00020\u00102\u0006\u0010P\u001a\u00020\u00108\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\be\u0010Q\u001a\u0004\bg\u0010S\"\u0004\bh\u0010UR*\u0010m\u001a\u00020\u00102\u0006\u0010P\u001a\u00020\u00108\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\bj\u0010Q\u001a\u0004\bk\u0010S\"\u0004\bl\u0010UR\"\u0010o\u001a\u00020n8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bo\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR(\u0010|\u001a\b\u0012\u0004\u0012\u00020\u00050u8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bv\u0010w\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R\u0014\u0010c\u001a\u00020}8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u001a\u0010_\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0019\u0010`\u001a\u00030\u0082\u00018\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001d\u0010~\u001a\b\u0012\u0004\u0012\u00020=0F8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010HR\u001e\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020=0F8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010HR\u001f\u0010\u0083\u0001\u001a\t\u0012\u0005\u0012\u00030\u0087\u00010F8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b\u0088\u0001\u0010HR\u001e\u0010j\u001a\t\u0012\u0005\u0012\u00030\u0087\u00010F8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b\u0089\u0001\u0010HR\u001e\u0010v\u001a\t\u0012\u0005\u0012\u00030\u0087\u00010F8\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b\u008a\u0001\u0010HR*\u0010\u008c\u0001\u001a\u00030\u008b\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u008c\u0001\u0010\u008d\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001a\u0010\u008a\u0001\u001a\u00030\u0092\u00018\u0002@\u0002X\u0083.¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001a\u0010\u0088\u0001\u001a\u00030\u0095\u00018\u0002@\u0002X\u0083.¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R,\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u0098\u00018\u0007@\u0007X\u0087\u000e¢\u0006\u0018\n\u0006\b\u0099\u0001\u0010\u009a\u0001\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001\"\u0006\b\u009d\u0001\u0010\u009e\u0001R*\u0010¡\u0001\u001a\u00030 \u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b¡\u0001\u0010¢\u0001\u001a\u0006\b£\u0001\u0010¤\u0001\"\u0006\b¥\u0001\u0010¦\u0001R\u0018\u0010\u0086\u0001\u001a\u00020\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b§\u0001\u0010QR*\u0010©\u0001\u001a\u00030¨\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b©\u0001\u0010ª\u0001\u001a\u0006\b«\u0001\u0010¬\u0001\"\u0006\b\u00ad\u0001\u0010®\u0001R\u0018\u0010\u0089\u0001\u001a\u00020\u00108\u0002@\u0002X\u0083\u000e¢\u0006\u0007\n\u0005\b¯\u0001\u0010QR*\u0010±\u0001\u001a\u00030°\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b±\u0001\u0010²\u0001\u001a\u0006\b³\u0001\u0010´\u0001\"\u0006\bµ\u0001\u0010¶\u0001R\u0016\u0010\u0085\u0001\u001a\u00030·\u0001X\u0083\u0080\u0002¢\u0006\u0007\n\u0005\b¸\u0001\u0010ER\u001c\u0010¯\u0001\u001a\u0005\u0018\u00010¹\u00018\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bº\u0001\u0010»\u0001R\u001a\u0010\u0099\u0001\u001a\u00030¼\u00018\u0002@\u0002X\u0083.¢\u0006\b\n\u0006\b½\u0001\u0010¾\u0001"}, d2 = {"Lid/dana/sendmoney_v2/recipient/view/RecipientView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ViewRecipientV2Binding;", "Landroid/view/View;", "view", "", "bindView", "(Landroid/view/View;)V", "checkContactSyncState", "()V", "PlaceComponentResult", "", "p0", "(Ljava/lang/String;)V", "Landroid/view/MotionEvent;", "event", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "", "(I)Ljava/lang/String;", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)C", "Lid/dana/common/RecyclerViewSectionDecorator;", "()Lid/dana/common/RecyclerViewSectionDecorator;", "getLayout", "()I", "Ljava/util/ArrayList;", "getRecentBank", "()Ljava/util/ArrayList;", "Lid/dana/richview/SearchView;", "getViewSearch", "()Lid/dana/richview/SearchView;", "BuiltInFictitiousFunctionClassFactory", "initRecipientView", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ViewRecipientV2Binding;", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "getAuthRequestContext", "(I)Z", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Z", "number", "isNumberInRecentContact", "action", "redirectDeeplink", "scheduleImpl", "recipientType", "setRecipientContactType", "(I)V", "contentDescription", "setSearchViewContentDescription", "setup", "Lio/reactivex/disposables/Disposable;", "getErrorConfigVersion", "()Lio/reactivex/disposables/Disposable;", "", "Lid/dana/sendmoney/model/RecentBankModel;", "newRecentBankModels", "updateRecentBank", "(Ljava/util/List;)V", "moveToNextValue", "Landroidx/recyclerview/widget/RecyclerView;", "(Landroidx/recyclerview/widget/RecyclerView;)Z", "Lid/dana/sendmoney/bank/AddReceiverDialogFragment;", "Lkotlin/Lazy;", "", "Lid/dana/sendmoney/model/RecipientViewModel;", "Ljava/util/List;", "Lid/dana/contract/contact/DanaContactContract$Presenter;", "danaContactPresenter", "Lid/dana/contract/contact/DanaContactContract$Presenter;", "getDanaContactPresenter", "()Lid/dana/contract/contact/DanaContactContract$Presenter;", "setDanaContactPresenter", "(Lid/dana/contract/contact/DanaContactContract$Presenter;)V", "value", "Z", "getEnableInvite", "()Z", "setEnableInvite", "(Z)V", "enableInvite", "getEnableViewSection", "setEnableViewSection", "enableViewSection", "Ljava/lang/String;", "isFirstTime", "setFirstTime", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda0", "NetworkUserEntityData$$ExternalSyntheticLambda1", "NetworkUserEntityData$$ExternalSyntheticLambda2", "I", "Lcom/afollestad/materialdialogs/MaterialDialog;", "initRecordTimeStamp", "Lcom/afollestad/materialdialogs/MaterialDialog;", "GetContactSyncConfig", "DatabaseTableConfigUtil", "getNotBankListRecent", "setNotBankListRecent", "notBankListRecent", "newProxyInstance", "getNotContactListRecent", "setNotContactListRecent", "notContactListRecent", "Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;", "onBoardingPresenter", "Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;", "getOnBoardingPresenter", "()Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;", "setOnBoardingPresenter", "(Lid/dana/usereducation/BottomSheetOnBoardingContract$Presenter;)V", "Lkotlin/Function0;", "isLayoutRequested", "Lkotlin/jvm/functions/Function0;", "getOnContactSyncEnabled", "()Lkotlin/jvm/functions/Function0;", "setOnContactSyncEnabled", "(Lkotlin/jvm/functions/Function0;)V", "onContactSyncEnabled", "Landroidx/paging/PagedList$Config;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Landroidx/paging/PagedList$Config;", "PrepareContext", "Lio/reactivex/disposables/Disposable;", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "NetworkUserEntityData$$ExternalSyntheticLambda3", "NetworkUserEntityData$$ExternalSyntheticLambda4", "Lid/dana/sendmoney/model/RecentRecipientModel;", "NetworkUserEntityData$$ExternalSyntheticLambda6", "NetworkUserEntityData$$ExternalSyntheticLambda5", "FragmentBottomSheetPaymentSettingBinding", "Lid/dana/sendmoney/recipient/recent/RecentRecipientContract$Presenter;", "recentRecipientPresenter", "Lid/dana/sendmoney/recipient/recent/RecentRecipientContract$Presenter;", "getRecentRecipientPresenter", "()Lid/dana/sendmoney/recipient/recent/RecentRecipientContract$Presenter;", "setRecentRecipientPresenter", "(Lid/dana/sendmoney/recipient/recent/RecentRecipientContract$Presenter;)V", "Lid/dana/sendmoney_v2/recipient/adapter/RecipientAdapter;", "readMicros", "Lid/dana/sendmoney_v2/recipient/adapter/RecipientAdapter;", "Lid/dana/sendmoney_v2/recipient/datasource/RecipientDataSourceFactory;", "whenAvailable", "Lid/dana/sendmoney_v2/recipient/datasource/RecipientDataSourceFactory;", "Lid/dana/sendmoney/view/BaseRecipientListener;", "getSupportButtonTintMode", "Lid/dana/sendmoney/view/BaseRecipientListener;", "getRecipientSelectedListener", "()Lid/dana/sendmoney/view/BaseRecipientListener;", "setRecipientSelectedListener", "(Lid/dana/sendmoney/view/BaseRecipientListener;)V", "recipientSelectedListener", "Lid/dana/contract/sendmoney/bank/SavedBankCardContract$Presenter;", "savedBankPresenter", "Lid/dana/contract/sendmoney/bank/SavedBankCardContract$Presenter;", "getSavedBankPresenter", "()Lid/dana/contract/sendmoney/bank/SavedBankCardContract$Presenter;", "setSavedBankPresenter", "(Lid/dana/contract/sendmoney/bank/SavedBankCardContract$Presenter;)V", "SubSequence", "Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "sendMoneyAnalyticTracker", "Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "getSendMoneyAnalyticTracker", "()Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;", "setSendMoneyAnalyticTracker", "(Lid/dana/sendmoney_v2/tracker/SendMoneyAnalyticTracker;)V", "getCallingPid", "Lid/dana/contract/sendmoney/v2/SortingSendMoneyPresenter;", "sortingSendMoneyPresenter", "Lid/dana/contract/sendmoney/v2/SortingSendMoneyPresenter;", "getSortingSendMoneyPresenter", "()Lid/dana/contract/sendmoney/v2/SortingSendMoneyPresenter;", "setSortingSendMoneyPresenter", "(Lid/dana/contract/sendmoney/v2/SortingSendMoneyPresenter;)V", "Lid/dana/base/ThrottledOnExecuteAction;", "A", "Lcom/ethanhua/skeleton/SkeletonScreen;", "C", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lid/dana/sendmoney_v2/recipient/view/RecipientViewState;", "BottomSheetCardBindingView$watcherCardNumberView$1", "Lid/dana/sendmoney_v2/recipient/view/RecipientViewState;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RecipientView extends ViewBindingRichView<ViewRecipientV2Binding> {

    /* renamed from: A  reason: from kotlin metadata */
    private final Lazy NetworkUserEntityData$$ExternalSyntheticLambda3;

    /* renamed from: BottomSheetCardBindingView$watcherCardNumberView$1  reason: from kotlin metadata */
    private RecipientViewState getSupportButtonTintMode;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private boolean enableInvite;

    /* renamed from: C  reason: from kotlin metadata */
    private SkeletonScreen getCallingPid;
    private boolean DatabaseTableConfigUtil;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private List<RecentRecipientModel> isLayoutRequested;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private boolean notBankListRecent;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private List<RecipientViewModel> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private boolean enableViewSection;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private boolean moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private boolean scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private int lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private List<RecentBankModel> NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private List<RecentBankModel> PrepareContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private List<RecentRecipientModel> newProxyInstance;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private List<RecentRecipientModel> NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private ActivityPermissionRequest NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private final PagedList.Config initRecordTimeStamp;
    private final Lazy PlaceComponentResult;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private Disposable NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: SubSequence  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda4;
    public Map<Integer, View> _$_findViewCache;
    @Inject
    public DanaContactContract.Presenter danaContactPresenter;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private String MyBillsEntityDataFactory;

    /* renamed from: getCallingPid  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda5;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getSupportButtonTintMode  reason: from kotlin metadata */
    private BaseRecipientListener recipientSelectedListener;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private MaterialDialog GetContactSyncConfig;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private Function0<Unit> onContactSyncEnabled;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private boolean isFirstTime;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private boolean notContactListRecent;
    @Inject
    public BottomSheetOnBoardingContract.Presenter onBoardingPresenter;

    /* renamed from: readMicros  reason: from kotlin metadata */
    private RecipientAdapter FragmentBottomSheetPaymentSettingBinding;
    @Inject
    public RecentRecipientContract.Presenter recentRecipientPresenter;
    @Inject
    public SavedBankCardContract.Presenter savedBankPresenter;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private boolean getAuthRequestContext;
    @Inject
    public SendMoneyAnalyticTracker sendMoneyAnalyticTracker;
    @Inject
    public SortingSendMoneyPresenter sortingSendMoneyPresenter;

    /* renamed from: whenAvailable  reason: from kotlin metadata */
    private RecipientDataSourceFactory NetworkUserEntityData$$ExternalSyntheticLambda6;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecipientView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RecipientView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.view_recipient_v2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecipientView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = LazyKt.lazy(RecipientView$throttledOnExecuteAction$2.INSTANCE);
        this.onContactSyncEnabled = RecipientView$onContactSyncEnabled$1.INSTANCE;
        this.isFirstTime = true;
        this.lookAheadTest = 30;
        this.PrepareContext = new ArrayList();
        this.isLayoutRequested = new ArrayList();
        this.newProxyInstance = new ArrayList();
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = true;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new ArrayList();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new ArrayList();
        this.enableViewSection = true;
        this.MyBillsEntityDataFactory = "";
        BaseActivity baseActivity = getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        ActivityPermissionRequest.Builder builder = new ActivityPermissionRequest.Builder((ComponentActivity) baseActivity);
        String[] strArr = {"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS"};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.PlaceComponentResult = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.sendmoney_v2.recipient.view.RecipientView$permission$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p0, boolean p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0.MyBillsEntityDataFactory()) {
                    RecipientView.this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                    RecipientView.this.getDanaContactPresenter().PlaceComponentResult();
                    RecipientView.this.getDanaContactPresenter().getAuthRequestContext();
                    RecipientView.this.getDanaContactPresenter().BuiltInFictitiousFunctionClassFactory();
                    return;
                }
                RecipientView.this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
                RecipientView.this.getOnBoardingPresenter().KClassImpl$Data$declaredNonStaticMembers$2("send_money_contact_permission");
                RecipientView.this.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onDisplayConsentDialog(PermissionRequest p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                p0.continueToPermissionRequest();
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onShouldRedirectToSystemSettings(List<PermissionReport> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                RecipientView.access$redirectToSystemSetting(RecipientView.this);
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.getAuthRequestContext = permissionCallback;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = builder.PlaceComponentResult();
        this.PlaceComponentResult = LazyKt.lazy(new RecipientView$addReceiverDialogFragment$2(this));
        PagedList.Config.Builder builder2 = new PagedList.Config.Builder();
        builder2.getAuthRequestContext = 20;
        builder2.MyBillsEntityDataFactory = 10;
        builder2.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        this.initRecordTimeStamp = builder2.PlaceComponentResult();
    }

    public /* synthetic */ RecipientView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecipientView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = LazyKt.lazy(RecipientView$throttledOnExecuteAction$2.INSTANCE);
        this.onContactSyncEnabled = RecipientView$onContactSyncEnabled$1.INSTANCE;
        this.isFirstTime = true;
        this.lookAheadTest = 30;
        this.PrepareContext = new ArrayList();
        this.isLayoutRequested = new ArrayList();
        this.newProxyInstance = new ArrayList();
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = true;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = new ArrayList();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new ArrayList();
        this.enableViewSection = true;
        this.MyBillsEntityDataFactory = "";
        BaseActivity baseActivity = getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        ActivityPermissionRequest.Builder builder = new ActivityPermissionRequest.Builder((ComponentActivity) baseActivity);
        String[] strArr = {"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS"};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.PlaceComponentResult = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.sendmoney_v2.recipient.view.RecipientView$permission$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult p0, boolean p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0.MyBillsEntityDataFactory()) {
                    RecipientView.this.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                    RecipientView.this.getDanaContactPresenter().PlaceComponentResult();
                    RecipientView.this.getDanaContactPresenter().getAuthRequestContext();
                    RecipientView.this.getDanaContactPresenter().BuiltInFictitiousFunctionClassFactory();
                    return;
                }
                RecipientView.this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
                RecipientView.this.getOnBoardingPresenter().KClassImpl$Data$declaredNonStaticMembers$2("send_money_contact_permission");
                RecipientView.this.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onDisplayConsentDialog(PermissionRequest p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                p0.continueToPermissionRequest();
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onShouldRedirectToSystemSettings(List<PermissionReport> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                RecipientView.access$redirectToSystemSetting(RecipientView.this);
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.getAuthRequestContext = permissionCallback;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = builder.PlaceComponentResult();
        this.PlaceComponentResult = LazyKt.lazy(new RecipientView$addReceiverDialogFragment$2(this));
        PagedList.Config.Builder builder2 = new PagedList.Config.Builder();
        builder2.getAuthRequestContext = 20;
        builder2.MyBillsEntityDataFactory = 10;
        builder2.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        this.initRecordTimeStamp = builder2.PlaceComponentResult();
    }

    @JvmName(name = "getDanaContactPresenter")
    public final DanaContactContract.Presenter getDanaContactPresenter() {
        DanaContactContract.Presenter presenter = this.danaContactPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setDanaContactPresenter")
    public final void setDanaContactPresenter(DanaContactContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.danaContactPresenter = presenter;
    }

    @JvmName(name = "getSavedBankPresenter")
    public final SavedBankCardContract.Presenter getSavedBankPresenter() {
        SavedBankCardContract.Presenter presenter = this.savedBankPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSavedBankPresenter")
    public final void setSavedBankPresenter(SavedBankCardContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.savedBankPresenter = presenter;
    }

    @JvmName(name = "getOnBoardingPresenter")
    public final BottomSheetOnBoardingContract.Presenter getOnBoardingPresenter() {
        BottomSheetOnBoardingContract.Presenter presenter = this.onBoardingPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setOnBoardingPresenter")
    public final void setOnBoardingPresenter(BottomSheetOnBoardingContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.onBoardingPresenter = presenter;
    }

    @JvmName(name = "getSortingSendMoneyPresenter")
    public final SortingSendMoneyPresenter getSortingSendMoneyPresenter() {
        SortingSendMoneyPresenter sortingSendMoneyPresenter = this.sortingSendMoneyPresenter;
        if (sortingSendMoneyPresenter != null) {
            return sortingSendMoneyPresenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSortingSendMoneyPresenter")
    public final void setSortingSendMoneyPresenter(SortingSendMoneyPresenter sortingSendMoneyPresenter) {
        Intrinsics.checkNotNullParameter(sortingSendMoneyPresenter, "");
        this.sortingSendMoneyPresenter = sortingSendMoneyPresenter;
    }

    @JvmName(name = "getRecentRecipientPresenter")
    public final RecentRecipientContract.Presenter getRecentRecipientPresenter() {
        RecentRecipientContract.Presenter presenter = this.recentRecipientPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setRecentRecipientPresenter")
    public final void setRecentRecipientPresenter(RecentRecipientContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.recentRecipientPresenter = presenter;
    }

    @JvmName(name = "getSendMoneyAnalyticTracker")
    public final SendMoneyAnalyticTracker getSendMoneyAnalyticTracker() {
        SendMoneyAnalyticTracker sendMoneyAnalyticTracker = this.sendMoneyAnalyticTracker;
        if (sendMoneyAnalyticTracker != null) {
            return sendMoneyAnalyticTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSendMoneyAnalyticTracker")
    public final void setSendMoneyAnalyticTracker(SendMoneyAnalyticTracker sendMoneyAnalyticTracker) {
        Intrinsics.checkNotNullParameter(sendMoneyAnalyticTracker, "");
        this.sendMoneyAnalyticTracker = sendMoneyAnalyticTracker;
    }

    @JvmName(name = "getRecipientSelectedListener")
    public final BaseRecipientListener getRecipientSelectedListener() {
        return this.recipientSelectedListener;
    }

    @JvmName(name = "setRecipientSelectedListener")
    public final void setRecipientSelectedListener(BaseRecipientListener baseRecipientListener) {
        this.recipientSelectedListener = baseRecipientListener;
    }

    @JvmName(name = "getOnContactSyncEnabled")
    public final Function0<Unit> getOnContactSyncEnabled() {
        return this.onContactSyncEnabled;
    }

    @JvmName(name = "setOnContactSyncEnabled")
    public final void setOnContactSyncEnabled(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        this.onContactSyncEnabled = function0;
    }

    @JvmName(name = "isFirstTime")
    /* renamed from: isFirstTime  reason: from getter */
    public final boolean getIsFirstTime() {
        return this.isFirstTime;
    }

    @JvmName(name = "setFirstTime")
    public final void setFirstTime(boolean z) {
        this.isFirstTime = z;
    }

    @JvmName(name = "getEnableViewSection")
    public final boolean getEnableViewSection() {
        return this.enableViewSection;
    }

    @JvmName(name = "setEnableViewSection")
    public final void setEnableViewSection(boolean z) {
        this.enableViewSection = z;
        if (z && getBinding().BuiltInFictitiousFunctionClassFactory.getItemDecorationCount() == 0) {
            getBinding().BuiltInFictitiousFunctionClassFactory.addItemDecoration(MyBillsEntityDataFactory());
        } else {
            getBinding().BuiltInFictitiousFunctionClassFactory.removeItemDecoration(MyBillsEntityDataFactory());
        }
    }

    @JvmName(name = "getEnableInvite")
    public final boolean getEnableInvite() {
        return this.enableInvite;
    }

    @JvmName(name = "setEnableInvite")
    public final void setEnableInvite(boolean z) {
        this.enableInvite = z;
        RecipientAdapter recipientAdapter = this.FragmentBottomSheetPaymentSettingBinding;
        if (recipientAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recipientAdapter = null;
        }
        recipientAdapter.getAuthRequestContext = this.enableInvite;
    }

    @JvmName(name = "getNotBankListRecent")
    public final boolean getNotBankListRecent() {
        return this.notBankListRecent;
    }

    @JvmName(name = "setNotBankListRecent")
    public final void setNotBankListRecent(boolean z) {
        this.notBankListRecent = z;
        RecipientAdapter recipientAdapter = this.FragmentBottomSheetPaymentSettingBinding;
        if (recipientAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recipientAdapter = null;
        }
        recipientAdapter.MyBillsEntityDataFactory = this.notBankListRecent;
    }

    @JvmName(name = "getNotContactListRecent")
    public final boolean getNotContactListRecent() {
        return this.notContactListRecent;
    }

    @JvmName(name = "setNotContactListRecent")
    public final void setNotContactListRecent(boolean z) {
        this.notContactListRecent = z;
        RecipientAdapter recipientAdapter = this.FragmentBottomSheetPaymentSettingBinding;
        if (recipientAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recipientAdapter = null;
        }
        recipientAdapter.BuiltInFictitiousFunctionClassFactory = this.notContactListRecent;
    }

    @JvmName(name = "getAuthRequestContext")
    private final void getAuthRequestContext(String str) {
        this.MyBillsEntityDataFactory = str;
        if (!this.moveToNextValue && (!StringsKt.isBlank(str)) != false && !this.moveToNextValue) {
            this.moveToNextValue = true;
            post(new RecipientView$$ExternalSyntheticLambda7(this));
        }
        if (this.moveToNextValue) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
            this.DatabaseTableConfigUtil = false;
            RecipientViewState recipientViewState = this.getSupportButtonTintMode;
            if (recipientViewState == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                recipientViewState = null;
            }
            RecipientSourceType recipientSourceType = recipientViewState.KClassImpl$Data$declaredNonStaticMembers$2;
            if (Intrinsics.areEqual(recipientSourceType, RecipientSourceType.All.INSTANCE)) {
                getSavedBankPresenter().MyBillsEntityDataFactory(this.MyBillsEntityDataFactory);
                getRecentRecipientPresenter().getAuthRequestContext(this.MyBillsEntityDataFactory);
                getRecentRecipientPresenter().KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory);
            } else if (Intrinsics.areEqual(recipientSourceType, RecipientSourceType.Bank.INSTANCE)) {
                getSavedBankPresenter().MyBillsEntityDataFactory(this.MyBillsEntityDataFactory);
            } else if (Intrinsics.areEqual(recipientSourceType, RecipientSourceType.Contact.INSTANCE)) {
                BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory);
            }
        }
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    private final boolean BuiltInFictitiousFunctionClassFactory() {
        return this.moveToNextValue && this.PrepareContext.isEmpty();
    }

    private final RecyclerViewSectionDecorator MyBillsEntityDataFactory() {
        return new RecyclerViewSectionDecorator(getBinding().BuiltInFictitiousFunctionClassFactory, getContext().getResources().getDimensionPixelSize(R.dimen.res_0x7f07034d_kclassimpl_data_declarednonstaticmembers_2), new RecyclerViewSectionDecorator.SectionCallback() { // from class: id.dana.sendmoney_v2.recipient.view.RecipientView$getSectionCallback$1
            @Override // id.dana.common.RecyclerViewSectionDecorator.SectionCallback
            public final boolean PlaceComponentResult(int p0) {
                boolean BuiltInFictitiousFunctionClassFactory;
                boolean authRequestContext;
                BuiltInFictitiousFunctionClassFactory = RecipientView.this.BuiltInFictitiousFunctionClassFactory(p0);
                if (BuiltInFictitiousFunctionClassFactory) {
                    authRequestContext = RecipientView.this.getAuthRequestContext(p0);
                    if (authRequestContext) {
                        return true;
                    }
                }
                return false;
            }

            @Override // id.dana.common.RecyclerViewSectionDecorator.SectionCallback
            public final /* synthetic */ CharSequence BuiltInFictitiousFunctionClassFactory(int i) {
                boolean BuiltInFictitiousFunctionClassFactory;
                String str;
                String PlaceComponentResult;
                char MyBillsEntityDataFactory;
                BuiltInFictitiousFunctionClassFactory = RecipientView.this.BuiltInFictitiousFunctionClassFactory(i);
                if (BuiltInFictitiousFunctionClassFactory) {
                    PlaceComponentResult = RecipientView.this.PlaceComponentResult(i);
                    MyBillsEntityDataFactory = RecipientView.MyBillsEntityDataFactory(PlaceComponentResult);
                    str = String.valueOf(MyBillsEntityDataFactory);
                } else {
                    str = null;
                }
                return str;
            }
        });
    }

    public final void setRecipientContactType(int recipientType) {
        RecipientViewState recipientViewState = new RecipientViewState(recipientType);
        RecipientSourceType recipientSourceType = recipientViewState.KClassImpl$Data$declaredNonStaticMembers$2;
        ContentResolver contentResolver = getContext().getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = recipientSourceType.MyBillsEntityDataFactory(contentResolver);
        AppCompatImageView appCompatImageView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(recipientViewState.KClassImpl$Data$declaredNonStaticMembers$2() ? 0 : 8);
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion.setSearchHint(getContext().getString(recipientViewState.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2));
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue.setText(getContext().getString(recipientViewState.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory));
        if (recipientType == 3) {
            Group group = getBinding().KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(group, "");
            group.setVisibility(8);
            TextView textView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0;
            Intrinsics.checkNotNullExpressionValue(textView, "");
            textView.setVisibility(0);
        }
        this.getSupportButtonTintMode = recipientViewState;
    }

    @Override // id.dana.base.BaseRichView
    public final void injectComponent(ApplicationComponent applicationComponent) {
        Intrinsics.checkNotNullParameter(applicationComponent, "");
        DaggerRecipientComponentV2.Builder BuiltInFictitiousFunctionClassFactory = DaggerRecipientComponentV2.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = (DanaContactModule) Preconditions.getAuthRequestContext(new DanaContactModule(new RecipientView$danaContactModule$1(this)));
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = (SavedBankModule) Preconditions.getAuthRequestContext(new SavedBankModule(new SavedBankCardContract.View() { // from class: id.dana.sendmoney_v2.recipient.view.RecipientView$savedBankModule$1
            @Override // id.dana.contract.sendmoney.bank.SavedBankCardContract.View
            public final void BuiltInFictitiousFunctionClassFactory(List<RecentBankModel> p0) {
                List list;
                Intrinsics.checkNotNullParameter(p0, "");
                list = RecipientView.this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                list.addAll(p0);
                RecipientView.this.updateRecentBank(p0);
            }

            @Override // id.dana.contract.sendmoney.bank.SavedBankCardContract.View
            public final void getAuthRequestContext(List<RecentBankModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                RecipientView.this.updateRecentBank(p0);
            }

            @Override // id.dana.contract.sendmoney.bank.SavedBankCardContract.View
            public final void PlaceComponentResult(List<RecentBankModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                RecipientView.this.updateRecentBank(p0);
                BaseActivity baseActivity = RecipientView.this.getBaseActivity();
                if (baseActivity == null) {
                    throw new NullPointerException("null cannot be cast to non-null type id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity");
                }
                ((BankRecipientActivity) baseActivity).showSnackbarRemoved();
            }

            @Override // id.dana.contract.sendmoney.bank.SavedBankCardContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                RecipientView.this.updateRecentBank(CollectionsKt.emptyList());
                BaseActivity baseActivity = RecipientView.this.getBaseActivity();
                if (baseActivity == null) {
                    throw new NullPointerException("null cannot be cast to non-null type id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity");
                }
                ((BankRecipientActivity) baseActivity).showSnackbarRemoved();
            }

            @Override // id.dana.contract.sendmoney.bank.SavedBankCardContract.View
            public final void BuiltInFictitiousFunctionClassFactory() {
                RecipientView.this.updateRecentBank(CollectionsKt.emptyList());
            }

            @Override // id.dana.contract.sendmoney.bank.SavedBankCardContract.View
            public final void getAuthRequestContext() {
                RecipientView.this.updateRecentBank(CollectionsKt.emptyList());
            }

            @Override // id.dana.contract.sendmoney.bank.SavedBankCardContract.View
            public final void getAuthRequestContext(int p0) {
                RecipientView.this.lookAheadTest = p0;
            }
        }));
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = (BottomSheetOnBoardingModule) Preconditions.getAuthRequestContext(new BottomSheetOnBoardingModule(new BottomSheetOnBoardingContract.View() { // from class: id.dana.sendmoney_v2.recipient.view.RecipientView$bottomSheetOnBoardingModule$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.usereducation.BottomSheetOnBoardingContract.View
            public final /* synthetic */ void onGetBottomSheetOnBoardingAvailability(boolean z, String str, String str2) {
                BottomSheetOnBoardingContract.View.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.usereducation.BottomSheetOnBoardingContract.View
            public final void onGetBottomSheetOnBoardingAvailability(boolean p0, String p1) {
                boolean z;
                z = RecipientView.this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (z || !p0) {
                    return;
                }
                RecipientView.access$showRequestContactPermissionDialog(RecipientView.this);
            }
        }));
        BuiltInFictitiousFunctionClassFactory.scheduleImpl = (SortingSendMoneyModule) Preconditions.getAuthRequestContext(new SortingSendMoneyModule(new SortingSendMoneyContract.View() { // from class: id.dana.sendmoney_v2.recipient.view.RecipientView$sortingSendMoneyModule$1
            @Override // id.dana.contract.sendmoney.v2.SortingSendMoneyContract.View
            public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory() {
                SortingSendMoneyContract.View.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.contract.sendmoney.v2.SortingSendMoneyContract.View
            public final /* synthetic */ void PlaceComponentResult() {
                SortingSendMoneyContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.contract.sendmoney.v2.SortingSendMoneyContract.View
            public final void getAuthRequestContext(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                RecipientView.access$setSortingSection(RecipientView.this, p0);
            }
        }));
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (RecentRecipientModule) Preconditions.getAuthRequestContext(new RecentRecipientModule(new RecentRecipientContract.View() { // from class: id.dana.sendmoney_v2.recipient.view.RecipientView$recentRecipientModule$1
            @Override // id.dana.sendmoney.recipient.recent.RecentRecipientContract.View
            public final void PlaceComponentResult(boolean p0) {
            }

            @Override // id.dana.sendmoney.recipient.recent.RecentRecipientContract.View
            public final void getAuthRequestContext(List<RecentRecipientModel> p0) {
                List list;
                if (p0 != null) {
                    list = RecipientView.this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                    list.addAll(p0);
                }
            }

            @Override // id.dana.sendmoney.recipient.recent.RecentRecipientContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(List<RecentRecipientModel> p0) {
                RecipientView.access$updateRecentRecipient(RecipientView.this, p0);
            }

            @Override // id.dana.sendmoney.recipient.recent.RecentRecipientContract.View
            public final void MyBillsEntityDataFactory(List<RecentRecipientModel> p0) {
                RecipientView.access$updateRecentGroupSendRecipient(RecipientView.this, p0);
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, DanaContactModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, SavedBankModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, BottomSheetOnBoardingModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.scheduleImpl, SortingSendMoneyModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, RecentRecipientModule.class);
        if (BuiltInFictitiousFunctionClassFactory.lookAheadTest == null) {
            BuiltInFictitiousFunctionClassFactory.lookAheadTest = new SendMoneyTrackerModule();
        }
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, ApplicationComponent.class);
        new DaggerRecipientComponentV2.RecipientComponentV2Impl(BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory.scheduleImpl, BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, BuiltInFictitiousFunctionClassFactory.lookAheadTest, BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, (byte) 0).KClassImpl$Data$declaredNonStaticMembers$2(this);
        registerPresenter(getDanaContactPresenter(), getSavedBankPresenter(), getOnBoardingPresenter(), getSortingSendMoneyPresenter(), getRecentRecipientPresenter());
    }

    private final void scheduleImpl() {
        RecyclerView.LayoutManager layoutManager = getBinding().BuiltInFictitiousFunctionClassFactory.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if ((linearLayoutManager != null ? linearLayoutManager.findLastVisibleItemPosition() : 0) < 20) {
            getBinding().BuiltInFictitiousFunctionClassFactory.smoothScrollToPosition(0);
        } else {
            getBinding().BuiltInFictitiousFunctionClassFactory.scrollToPosition(0);
        }
        ExtendedFloatingActionButton extendedFloatingActionButton = getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(extendedFloatingActionButton, "");
        extendedFloatingActionButton.setVisibility(8);
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final ViewRecipientV2Binding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewRecipientV2Binding MyBillsEntityDataFactory = ViewRecipientV2Binding.MyBillsEntityDataFactory(view);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView, id.dana.base.BaseRichView
    public final void bindView(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        if (view.findViewById(R.id.shimmerContent) != null) {
            return;
        }
        super.bindView(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "");
        if (MyBillsEntityDataFactory(event)) {
            View findFocus = findFocus();
            EditText editText = findFocus instanceof EditText ? (EditText) findFocus : null;
            if (editText != null) {
                Rect rect = new Rect();
                editText.getGlobalVisibleRect(rect);
                if (!rect.contains((int) event.getRawX(), (int) event.getRawY())) {
                    editText.clearFocus();
                    KeyboardHelper.BuiltInFictitiousFunctionClassFactory(this);
                }
            }
        }
        return super.dispatchTouchEvent(event);
    }

    private final boolean MyBillsEntityDataFactory(MotionEvent p0) {
        return this.scheduleImpl && getBinding().KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion.isClearImageViewRect((int) p0.getRawX(), (int) p0.getRawY()) && p0.getAction() == 0;
    }

    public final void initRecipientView() {
        RecipientViewState recipientViewState = this.getSupportButtonTintMode;
        RecipientViewState recipientViewState2 = null;
        if (recipientViewState == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recipientViewState = null;
        }
        RecipientSourceType recipientSourceType = recipientViewState.KClassImpl$Data$declaredNonStaticMembers$2;
        if (!Intrinsics.areEqual(recipientSourceType, RecipientSourceType.Contact.INSTANCE)) {
            if (!Intrinsics.areEqual(recipientSourceType, RecipientSourceType.Bank.INSTANCE)) {
                if (Intrinsics.areEqual(recipientSourceType, RecipientSourceType.All.INSTANCE)) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda2.check();
                    getRecentRecipientPresenter().PlaceComponentResult();
                    getSavedBankPresenter().PlaceComponentResult();
                    getSavedBankPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
                    getRecentRecipientPresenter().getAuthRequestContext("");
                    getRecentRecipientPresenter().KClassImpl$Data$declaredNonStaticMembers$2("");
                    SearchView searchView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion;
                    searchView.setSearchViewType(RecipientSourceType.All.INSTANCE);
                    searchView.enableNewNumberFormat(true);
                }
            } else {
                RelativeLayout relativeLayout = getBinding().MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
                Intrinsics.checkNotNullExpressionValue(relativeLayout, "");
                relativeLayout.setVisibility(0);
                getBinding().MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0.setText(R.string.sendmoney_bank_title);
                getBinding().MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.recipient.view.RecipientView$$ExternalSyntheticLambda5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        RecipientView.$r8$lambda$uAhnhBxYSLuv0J7Ft3TygVV5BJM(RecipientView.this, view);
                    }
                });
                getSavedBankPresenter().PlaceComponentResult();
                getSavedBankPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
                SearchView searchView2 = getBinding().KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion;
                searchView2.setContentDescription(searchView2.getContext().getString(R.string.txtSearchBank));
                searchView2.setSearchViewType(RecipientSourceType.Bank.INSTANCE);
                searchView2.enableNewNumberFormat(true);
                getBinding().KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.setContentDescription(getContext().getString(R.string.btnAddNewBank));
            }
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda2.check();
            getRecentRecipientPresenter().PlaceComponentResult();
            SearchView searchView3 = getBinding().KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion;
            searchView3.setContentDescription(searchView3.getContext().getString(R.string.txtSearchPhoneNumber));
            searchView3.setSearchViewType(RecipientSourceType.Contact.INSTANCE);
            searchView3.enableNewNumberFormat(true);
            getBinding().KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.setContentDescription(getContext().getString(R.string.btnInputNumber));
        }
        final SearchView searchView4 = getBinding().KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion;
        Context context = getContext();
        RecipientViewState recipientViewState3 = this.getSupportButtonTintMode;
        if (recipientViewState3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            recipientViewState2 = recipientViewState3;
        }
        String string = context.getString(recipientViewState2.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2);
        Intrinsics.checkNotNullExpressionValue(string, "");
        searchView4.setSearchHint(string);
        Intrinsics.checkNotNullExpressionValue(searchView4, "");
        searchView4.addDisposable(searchView4.getOnSearchClickedEvent().subscribe(new Consumer() { // from class: id.dana.sendmoney_v2.recipient.view.RecipientView$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RecipientView.$r8$lambda$Ivjj9tYl4G61SzAGqoj8JfLk59Y(RecipientView.this, searchView4, (Boolean) obj);
            }
        }));
        searchView4.addDisposable(searchView4.getKeyword().debounce(500L, TimeUnit.MILLISECONDS).subscribe(new Consumer() { // from class: id.dana.sendmoney_v2.recipient.view.RecipientView$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RecipientView.$r8$lambda$WbKhWBKQYV9yE4bjxF0f1byT5ZE(RecipientView.this, (String) obj);
            }
        }));
        KeyboardHelper.PlaceComponentResult(this, new KeyboardHelper.KeyboardVisibilityListener() { // from class: id.dana.sendmoney_v2.recipient.view.RecipientView$setupKeyboardListener$1
            @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                RecipientView.this.scheduleImpl = true;
            }

            @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
            public final void MyBillsEntityDataFactory() {
                RecipientView.this.scheduleImpl = false;
            }
        });
    }

    public final void updateRecentBank(List<RecentBankModel> newRecentBankModels) {
        Intrinsics.checkNotNullParameter(newRecentBankModels, "");
        this.PrepareContext.clear();
        this.PrepareContext.addAll(newRecentBankModels);
        RecipientViewState recipientViewState = this.getSupportButtonTintMode;
        if (recipientViewState == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recipientViewState = null;
        }
        if (Intrinsics.areEqual(recipientViewState.KClassImpl$Data$declaredNonStaticMembers$2, RecipientSourceType.Bank.INSTANCE)) {
            if (newRecentBankModels.isEmpty()) {
                LinearLayout linearLayout = getBinding().MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullExpressionValue(linearLayout, "");
                linearLayout.setVisibility(8);
            } else {
                LinearLayout linearLayout2 = getBinding().MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkNotNullExpressionValue(linearLayout2, "");
                linearLayout2.setVisibility(0);
                if (this.MyBillsEntityDataFactory.length() == 0) {
                    getBinding().MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0.setText(R.string.sendmoney_bank_title);
                    LinearLayout linearLayout3 = getBinding().MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory;
                    Intrinsics.checkNotNullExpressionValue(linearLayout3, "");
                    linearLayout3.setVisibility(0);
                } else {
                    getBinding().MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda0.setText(R.string.containsObjectForKey);
                    LinearLayout linearLayout4 = getBinding().MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory;
                    Intrinsics.checkNotNullExpressionValue(linearLayout4, "");
                    linearLayout4.setVisibility(8);
                }
            }
        }
        KClassImpl$Data$declaredNonStaticMembers$2();
        PlaceComponentResult();
    }

    public final void PlaceComponentResult() {
        if (this.isFirstTime) {
            if (this.PrepareContext.isEmpty()) {
                addNewBankRecipient$default(this, null, null, 3, null);
            }
            this.isFirstTime = false;
        }
    }

    public final void setSearchViewContentDescription(String contentDescription) {
        Intrinsics.checkNotNullParameter(contentDescription, "");
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion.setSearchViewContentDescription(contentDescription);
    }

    public final boolean getAuthRequestContext(int p0) {
        return MyBillsEntityDataFactory(PlaceComponentResult(p0)) != MyBillsEntityDataFactory(PlaceComponentResult(p0 - 1));
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        moveToNextValue();
        Disposable disposable = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable errorConfigVersion = getErrorConfigVersion();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = errorConfigVersion;
        addDisposable(errorConfigVersion);
        getBinding().BuiltInFictitiousFunctionClassFactory.postDelayed(new Runnable() { // from class: id.dana.sendmoney_v2.recipient.view.RecipientView$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                RecipientView.m2937$r8$lambda$2NZLMGSdEof71jI6f7sA82FiO8(RecipientView.this);
            }
        }, 1500L);
    }

    private final Disposable getErrorConfigVersion() {
        RecipientDataSourceFactory recipientDataSourceFactory = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
        if (recipientDataSourceFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recipientDataSourceFactory = null;
        }
        return new RxPagedListBuilder(recipientDataSourceFactory, this.initRecordTimeStamp).BuiltInFictitiousFunctionClassFactory(BackpressureStrategy.LATEST).BuiltInFictitiousFunctionClassFactory(new Consumer() { // from class: id.dana.sendmoney_v2.recipient.view.RecipientView$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RecipientView.$r8$lambda$EMTjICfgd7guO1xMbQ6xJ6fSx78(RecipientView.this, (PagedList) obj);
            }
        }, Functions.DatabaseTableConfigUtil, Functions.KClassImpl$Data$declaredNonStaticMembers$2, FlowableInternalHelper.RequestMax.INSTANCE);
    }

    private final void moveToNextValue() {
        RecipientDataSourceFactory recipientDataSourceFactory = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
        if (recipientDataSourceFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recipientDataSourceFactory = null;
        }
        if (recipientDataSourceFactory instanceof BankDataSourceFactory) {
            BankDataSourceFactory bankDataSourceFactory = (BankDataSourceFactory) recipientDataSourceFactory;
            List<RecentBankModel> list = this.PrepareContext;
            Intrinsics.checkNotNullParameter(list, "");
            bankDataSourceFactory.getAuthRequestContext = list;
            bankDataSourceFactory.PlaceComponentResult = BuiltInFictitiousFunctionClassFactory();
        }
        if (recipientDataSourceFactory instanceof NewContactDataSourceFactory) {
            NewContactDataSourceFactory newContactDataSourceFactory = (NewContactDataSourceFactory) recipientDataSourceFactory;
            newContactDataSourceFactory.MyBillsEntityDataFactory = this.KClassImpl$Data$declaredNonStaticMembers$2;
            newContactDataSourceFactory.getAuthRequestContext = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            recipientDataSourceFactory.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory);
        }
        if (recipientDataSourceFactory instanceof NewSearchDataSourceFactory) {
            NewSearchDataSourceFactory newSearchDataSourceFactory = (NewSearchDataSourceFactory) recipientDataSourceFactory;
            newSearchDataSourceFactory.PlaceComponentResult = this.KClassImpl$Data$declaredNonStaticMembers$2;
            List<RecentBankModel> list2 = this.PrepareContext;
            Intrinsics.checkNotNullParameter(list2, "");
            newSearchDataSourceFactory.MyBillsEntityDataFactory = list2;
            List<RecentRecipientModel> list3 = this.isLayoutRequested;
            Intrinsics.checkNotNullParameter(list3, "");
            newSearchDataSourceFactory.lookAheadTest = list3;
            List<RecentRecipientModel> list4 = this.newProxyInstance;
            Intrinsics.checkNotNullParameter(list4, "");
            newSearchDataSourceFactory.KClassImpl$Data$declaredNonStaticMembers$2 = list4;
            recipientDataSourceFactory.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory);
        }
        recipientDataSourceFactory.MyBillsEntityDataFactory = this.moveToNextValue;
        String str = this.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullParameter(str, "");
        recipientDataSourceFactory.getAuthRequestContext = str;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(int p0) {
        RecipientAdapter recipientAdapter = this.FragmentBottomSheetPaymentSettingBinding;
        if (recipientAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recipientAdapter = null;
        }
        return recipientAdapter.getItemViewType(p0) == 3;
    }

    public static char MyBillsEntityDataFactory(String p0) {
        return p0.length() == 0 ? InputCardNumberView.DIVIDER : p0.charAt(0);
    }

    public final String PlaceComponentResult(int p0) {
        String PlaceComponentResult;
        RecipientAdapter recipientAdapter = this.FragmentBottomSheetPaymentSettingBinding;
        String str = null;
        if (recipientAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recipientAdapter = null;
        }
        if (p0 < 0) {
            p0 = 0;
        }
        AsyncPagedListDiffer<T> asyncPagedListDiffer = recipientAdapter.KClassImpl$Data$declaredNonStaticMembers$2;
        AbstractList abstractList = asyncPagedListDiffer.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (abstractList == null) {
            abstractList = asyncPagedListDiffer.moveToNextValue;
        }
        RecipientViewModel recipientViewModel = (RecipientViewModel) abstractList.get(p0);
        if (recipientViewModel != null && (PlaceComponentResult = recipientViewModel.PlaceComponentResult()) != null) {
            Locale locale = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(locale, "");
            str = PlaceComponentResult.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(str, "");
        }
        return str == null ? "" : str;
    }

    public static boolean PlaceComponentResult(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        return linearLayoutManager != null && linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0;
    }

    public final void redirectDeeplink(String action) {
        Intrinsics.checkNotNullParameter(action, "");
        if (Intrinsics.areEqual(BranchLinkConstant.ActionTarget.SEND_MONEY_BANK, action)) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: id.dana.sendmoney_v2.recipient.view.RecipientView$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    RecipientView.this.PlaceComponentResult();
                }
            }, 2000L);
        }
    }

    public final void checkContactSyncState() {
        getDanaContactPresenter().MyBillsEntityDataFactory();
    }

    private final void BuiltInFictitiousFunctionClassFactory(String p0) {
        String str = p0;
        if (str.length() > 0) {
            if (TextUtils.isDigitsOnly(str)) {
                PlaceComponentResult(p0);
            } else if (StringsKt.startsWith$default(p0, "+", false, 2, (Object) null)) {
                PlaceComponentResult(p0);
            } else {
                this.NetworkUserEntityData$$ExternalSyntheticLambda4 = false;
                KClassImpl$Data$declaredNonStaticMembers$2();
            }
        } else if (this.NetworkUserEntityData$$ExternalSyntheticLambda4) {
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = true;
            getAuthRequestContext("");
            KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    private final void PlaceComponentResult(String p0) {
        if (KClassImpl$Data$declaredNonStaticMembers$2(p0)) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = false;
            KClassImpl$Data$declaredNonStaticMembers$2();
        } else if (this.NetworkUserEntityData$$ExternalSyntheticLambda4) {
        } else {
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = true;
            getAuthRequestContext("");
            KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    public final boolean isNumberInRecentContact(String number) {
        Intrinsics.checkNotNullParameter(number, "");
        Iterator<T> it = this.NetworkUserEntityData$$ExternalSyntheticLambda7.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(NumberUtils.getIndoPhoneNumber(((RecentRecipientModel) it.next()).getErrorConfigVersion), number)) {
                return true;
            }
        }
        return false;
    }

    public final ArrayList<String> getRecentBank() {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<T> it = this.NetworkUserEntityData$$ExternalSyntheticLambda8.iterator();
        while (it.hasNext()) {
            String str = ((RecentBankModel) it.next()).KClassImpl$Data$declaredNonStaticMembers$2;
            if (str == null) {
                str = "";
            }
            arrayList.add(str);
        }
        return arrayList;
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        return p0.length() >= 3;
    }

    public final SearchView getViewSearch() {
        SearchView searchView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion;
        Intrinsics.checkNotNullExpressionValue(searchView, "");
        return searchView;
    }

    /* renamed from: $r8$lambda$0Ve4mp-t1NH6BmfTuXHDCFFfxbQ */
    public static /* synthetic */ void m2936$r8$lambda$0Ve4mpt1NH6BmfTuXHDCFFfxbQ(RecipientView recipientView) {
        Intrinsics.checkNotNullParameter(recipientView, "");
        boolean z = recipientView.moveToNextValue;
        Group group = recipientView.getBinding().KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(group, "");
        group.setVisibility(z ^ true ? 0 : 8);
        AppCompatImageView appCompatImageView = recipientView.getBinding().KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        AppCompatImageView appCompatImageView2 = appCompatImageView;
        RecipientViewState recipientViewState = recipientView.getSupportButtonTintMode;
        if (recipientViewState == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recipientViewState = null;
        }
        appCompatImageView2.setVisibility(recipientViewState.KClassImpl$Data$declaredNonStaticMembers$2() && !z ? 0 : 8);
        TextView textView = recipientView.getBinding().KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(z ? 0 : 8);
        if (!recipientView.moveToNextValue) {
            recipientView.getAuthRequestContext();
        } else {
            recipientView.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        }
    }

    /* renamed from: $r8$lambda$2NZLMGSdEof71jI6f7-sA82FiO8 */
    public static /* synthetic */ void m2937$r8$lambda$2NZLMGSdEof71jI6f7sA82FiO8(RecipientView recipientView) {
        Intrinsics.checkNotNullParameter(recipientView, "");
        recipientView.scheduleImpl();
    }

    public static /* synthetic */ void $r8$lambda$4whfPzuFSlZsFc1ALcmbKAfz5_U(RecipientView recipientView, View view) {
        Intrinsics.checkNotNullParameter(recipientView, "");
        RecipientViewState recipientViewState = recipientView.getSupportButtonTintMode;
        if (recipientViewState == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recipientViewState = null;
        }
        if (Intrinsics.areEqual(recipientViewState.KClassImpl$Data$declaredNonStaticMembers$2, RecipientSourceType.Contact.INSTANCE)) {
            if (!recipientView.moveToNextValue) {
                recipientView.moveToNextValue = true;
                recipientView.post(new RecipientView$$ExternalSyntheticLambda7(recipientView));
            }
            recipientView.DatabaseTableConfigUtil = true;
            recipientView.getBinding().KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion.focusEtSearchContact();
        } else if (recipientView.PrepareContext.size() < recipientView.lookAheadTest) {
            addNewBankRecipient$default(recipientView, null, null, 3, null);
        } else {
            BaseActivity baseActivity = recipientView.getBaseActivity();
            if (baseActivity != null) {
                BaseActivity baseActivity2 = recipientView.getBaseActivity();
                Intrinsics.checkNotNullExpressionValue(baseActivity2, "");
                CustomDialog.Builder builder = new CustomDialog.Builder(baseActivity2);
                builder.SubSequence = baseActivity.getString(R.string.sendmoney_max_bank_dialog_title);
                builder.GetContactSyncConfig = baseActivity.getString(R.string.sendmoney_max_bank_dialog_description, Integer.valueOf(recipientView.lookAheadTest));
                builder.DatabaseTableConfigUtil = R.drawable.ic_max_saved_bank;
                builder.KClassImpl$Data$declaredNonStaticMembers$2(false);
                builder.PlaceComponentResult(false);
                builder.BuiltInFictitiousFunctionClassFactory(baseActivity.getString(R.string.sendmoney_max_bank_dialog_positive_button), new Function1<View, Unit>() { // from class: id.dana.sendmoney_v2.recipient.view.RecipientView$showMaximumBankAccountDialog$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(View view2) {
                        invoke2(view2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(View view2) {
                        MaterialDialog materialDialog;
                        Intrinsics.checkNotNullParameter(view2, "");
                        materialDialog = RecipientView.this.GetContactSyncConfig;
                        if (materialDialog != null) {
                            materialDialog.dismiss();
                        }
                        RecipientView.addNewBankRecipient$default(RecipientView.this, null, null, 3, null);
                    }
                });
                builder.KClassImpl$Data$declaredNonStaticMembers$2(baseActivity.getString(R.string.sendmoney_max_bank_dialog_negative_button), new Function1<View, Unit>() { // from class: id.dana.sendmoney_v2.recipient.view.RecipientView$showMaximumBankAccountDialog$1$1$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(View view2) {
                        invoke2(view2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(View view2) {
                        MaterialDialog materialDialog;
                        Intrinsics.checkNotNullParameter(view2, "");
                        materialDialog = RecipientView.this.GetContactSyncConfig;
                        if (materialDialog != null) {
                            materialDialog.dismiss();
                        }
                    }
                });
                MaterialDialog BuiltInFictitiousFunctionClassFactory = builder.BuiltInFictitiousFunctionClassFactory();
                recipientView.GetContactSyncConfig = BuiltInFictitiousFunctionClassFactory;
                if (BuiltInFictitiousFunctionClassFactory != null) {
                    BuiltInFictitiousFunctionClassFactory.show();
                }
            }
        }
    }

    public static /* synthetic */ void $r8$lambda$EMTjICfgd7guO1xMbQ6xJ6fSx78(RecipientView recipientView, PagedList pagedList) {
        Intrinsics.checkNotNullParameter(recipientView, "");
        RecipientAdapter recipientAdapter = recipientView.FragmentBottomSheetPaymentSettingBinding;
        RecipientAdapter recipientAdapter2 = null;
        if (recipientAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recipientAdapter = null;
        }
        recipientAdapter.PlaceComponentResult = recipientView.MyBillsEntityDataFactory;
        RecipientAdapter recipientAdapter3 = recipientView.FragmentBottomSheetPaymentSettingBinding;
        if (recipientAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            recipientAdapter2 = recipientAdapter3;
        }
        recipientAdapter2.KClassImpl$Data$declaredNonStaticMembers$2(pagedList);
    }

    public static /* synthetic */ void $r8$lambda$Ivjj9tYl4G61SzAGqoj8JfLk59Y(RecipientView recipientView, SearchView searchView, Boolean bool) {
        Intrinsics.checkNotNullParameter(recipientView, "");
        Intrinsics.checkNotNullParameter(searchView, "");
        Intrinsics.checkNotNullExpressionValue(bool, "");
        if (bool.booleanValue()) {
            if (!recipientView.moveToNextValue) {
                recipientView.moveToNextValue = true;
                recipientView.post(new RecipientView$$ExternalSyntheticLambda7(recipientView));
            }
            if (recipientView.DatabaseTableConfigUtil) {
                searchView.setSearchViewInputType(3);
            } else {
                searchView.setSearchViewInputType(144);
            }
        }
    }

    /* renamed from: $r8$lambda$SyTZIehxBiayit6tum_DS-DbEBA */
    public static /* synthetic */ void m2938$r8$lambda$SyTZIehxBiayit6tum_DSDbEBA(RecipientView recipientView, View view) {
        Intrinsics.checkNotNullParameter(recipientView, "");
        RecipientViewState recipientViewState = recipientView.getSupportButtonTintMode;
        RecipientViewState recipientViewState2 = null;
        if (recipientViewState == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recipientViewState = null;
        }
        if (!Intrinsics.areEqual(recipientViewState.KClassImpl$Data$declaredNonStaticMembers$2, RecipientSourceType.Contact.INSTANCE)) {
            RecipientViewState recipientViewState3 = recipientView.getSupportButtonTintMode;
            if (recipientViewState3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                recipientViewState3 = null;
            }
            if (!Intrinsics.areEqual(recipientViewState3.KClassImpl$Data$declaredNonStaticMembers$2, RecipientSourceType.Bank.INSTANCE)) {
                RecipientViewState recipientViewState4 = recipientView.getSupportButtonTintMode;
                if (recipientViewState4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    recipientViewState2 = recipientViewState4;
                }
                if (Intrinsics.areEqual(recipientViewState2.KClassImpl$Data$declaredNonStaticMembers$2, RecipientSourceType.All.INSTANCE)) {
                    recipientView.getBaseActivity().finish();
                    return;
                }
                return;
            }
        }
        recipientView.getAuthRequestContext();
    }

    public static /* synthetic */ void $r8$lambda$WbKhWBKQYV9yE4bjxF0f1byT5ZE(RecipientView recipientView, String str) {
        Intrinsics.checkNotNullParameter(recipientView, "");
        Intrinsics.checkNotNullExpressionValue(str, "");
        recipientView.getAuthRequestContext(StringsKt.trim((CharSequence) str).toString());
    }

    public static /* synthetic */ void $r8$lambda$bw6TrQyiqoT2Jo_SWtvAwZWF7ZU(RecipientView recipientView, View view) {
        Intrinsics.checkNotNullParameter(recipientView, "");
        recipientView.scheduleImpl();
    }

    public static /* synthetic */ void $r8$lambda$k2O0AOg2v8dc_2EMtHLJUjhGWEE(RecipientView recipientView, View view) {
        Intrinsics.checkNotNullParameter(recipientView, "");
        Context context = recipientView.getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            Intent intent = new Intent(activity, ScannerActivity.class);
            intent.putExtra("source", "Send Money");
            activity.startActivityForResult(intent, ScannerActionFactory.BuiltInFictitiousFunctionClassFactory);
        }
    }

    public static /* synthetic */ void $r8$lambda$uAhnhBxYSLuv0J7Ft3TygVV5BJM(RecipientView recipientView, View view) {
        Intrinsics.checkNotNullParameter(recipientView, "");
        Context context = recipientView.getContext();
        if (context == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        }
        Activity activity = (Activity) context;
        activity.startActivityForResult(new Intent(activity, SortBankAccountBottomSheetActivity.class), 69);
    }

    public static final /* synthetic */ void access$dismissShimmer(RecipientView recipientView) {
        recipientView.getAuthRequestContext = true;
        SkeletonScreen skeletonScreen = recipientView.getCallingPid;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
        recipientView.getCallingPid = null;
    }

    public static final /* synthetic */ ThrottledOnExecuteAction access$getThrottledOnExecuteAction(RecipientView recipientView) {
        return (ThrottledOnExecuteAction) recipientView.NetworkUserEntityData$$ExternalSyntheticLambda3.getValue();
    }

    public static final /* synthetic */ void access$notifyListener(RecipientView recipientView, RecipientModel recipientModel) {
        BaseRecipientListener baseRecipientListener = recipientView.recipientSelectedListener;
        if (baseRecipientListener != null) {
            baseRecipientListener.onRecipientSelected(recipientModel);
        }
    }

    public static final /* synthetic */ void access$onItemClick(RecipientView recipientView, int i) {
        RecipientAdapter recipientAdapter = recipientView.FragmentBottomSheetPaymentSettingBinding;
        RecipientAdapter recipientAdapter2 = null;
        if (recipientAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recipientAdapter = null;
        }
        int itemViewType = recipientAdapter.getItemViewType(i);
        if (itemViewType == 2 || itemViewType == 3) {
            KeyboardHelper.BuiltInFictitiousFunctionClassFactory(recipientView);
        } else if (itemViewType == 5) {
            recipientView.NetworkUserEntityData$$ExternalSyntheticLambda2.check();
        } else if (itemViewType != 11) {
            if (itemViewType != 17) {
                if (itemViewType == 25) {
                    RecipientAdapter recipientAdapter3 = recipientView.FragmentBottomSheetPaymentSettingBinding;
                    if (recipientAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        recipientAdapter2 = recipientAdapter3;
                    }
                    if (i < 0) {
                        i = 0;
                    }
                    AsyncPagedListDiffer<T> asyncPagedListDiffer = recipientAdapter2.KClassImpl$Data$declaredNonStaticMembers$2;
                    AbstractList abstractList = asyncPagedListDiffer.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    if (abstractList == null) {
                        abstractList = asyncPagedListDiffer.moveToNextValue;
                    }
                    String KClassImpl$Data$declaredNonStaticMembers$2 = ((RecipientViewModel) abstractList.get(i)).KClassImpl$Data$declaredNonStaticMembers$2();
                    Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
                    String name = SendMoneyActivity.class.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "");
                    GroupSendIntentModel groupSendIntentModel = new GroupSendIntentModel(name, null, null, KClassImpl$Data$declaredNonStaticMembers$2, null, null, null, false, 246, null);
                    Context context = recipientView.getContext();
                    GroupSendSummaryActivity.Companion companion = GroupSendSummaryActivity.INSTANCE;
                    context.startActivity(GroupSendSummaryActivity.Companion.getAuthRequestContext(groupSendIntentModel, "Quick Send", recipientView.getContext()));
                    return;
                } else if (itemViewType == 8) {
                    KeyboardHelper.BuiltInFictitiousFunctionClassFactory(recipientView);
                    if (!recipientView.moveToNextValue) {
                        recipientView.moveToNextValue = true;
                        recipientView.post(new RecipientView$$ExternalSyntheticLambda7(recipientView));
                        return;
                    }
                    return;
                } else if (itemViewType != 9) {
                    return;
                }
            }
            addNewBankRecipient$default(recipientView, null, null, 3, null);
        } else {
            if (!recipientView.moveToNextValue) {
                recipientView.moveToNextValue = true;
                recipientView.post(new RecipientView$$ExternalSyntheticLambda7(recipientView));
            }
            recipientView.DatabaseTableConfigUtil = true;
            recipientView.getBinding().KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion.focusEtSearchContact();
        }
    }

    public static final /* synthetic */ void access$redirectToSystemSetting(RecipientView recipientView) {
        if (recipientView.getBaseActivity().isActivityAvailable()) {
            Context context = recipientView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            PermissionHelper.getAuthRequestContext(context, (int) R.string.permission_title_contact);
        }
    }

    public static final /* synthetic */ void access$setSortingSection(RecipientView recipientView, String str) {
        String str2;
        LinearLayout linearLayout = recipientView.getBinding().MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "");
        linearLayout.setVisibility(0);
        TextView textView = recipientView.getBinding().MyBillsEntityDataFactory.moveToNextValue;
        if (str.length() == 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = recipientView.getResources().getString(R.string.sendmoney_sortby, SortingByConst.FREQUENT);
            Intrinsics.checkNotNullExpressionValue(string, "");
            String format = String.format(string, Arrays.copyOf(new Object[0], 0));
            Intrinsics.checkNotNullExpressionValue(format, "");
            str2 = format;
        } else {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String string2 = recipientView.getResources().getString(R.string.sendmoney_sortby, str);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            String format2 = String.format(string2, Arrays.copyOf(new Object[0], 0));
            Intrinsics.checkNotNullExpressionValue(format2, "");
            str2 = format2;
        }
        textView.setText(str2);
    }

    public static final /* synthetic */ void access$showFabBackToTop(RecipientView recipientView, boolean z) {
        if (recipientView.NetworkUserEntityData$$ExternalSyntheticLambda5 != z) {
            recipientView.NetworkUserEntityData$$ExternalSyntheticLambda5 = z;
            if (z) {
                recipientView.getBinding().getAuthRequestContext.show();
            } else {
                recipientView.getBinding().getAuthRequestContext.hide();
            }
        }
    }

    public static final /* synthetic */ void access$showRequestContactPermissionDialog(RecipientView recipientView) {
        FragmentManager supportFragmentManager;
        BaseActivity baseActivity = recipientView.getBaseActivity();
        boolean z = false;
        if (baseActivity != null && !baseActivity.isActivityAvailable()) {
            z = true;
        }
        if (z) {
            return;
        }
        BaseActivity baseActivity2 = recipientView.getBaseActivity();
        if (baseActivity2 != null && (supportFragmentManager = baseActivity2.getSupportFragmentManager()) != null) {
            new ContactPermissionDialogFragment(new Function0<Unit>() { // from class: id.dana.sendmoney_v2.recipient.view.RecipientView$showRequestContactPermissionDialog$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    RecipientView.this.NetworkUserEntityData$$ExternalSyntheticLambda2.check();
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, null, new Function0<Unit>() { // from class: id.dana.sendmoney_v2.recipient.view.RecipientView$showRequestContactPermissionDialog$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    RecipientView.this.getOnBoardingPresenter().MyBillsEntityDataFactory("send_money_contact_permission");
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }, 2, null).MyBillsEntityDataFactory(supportFragmentManager);
        }
        recipientView.getOnBoardingPresenter().MyBillsEntityDataFactory("send_money_contact_permission");
    }

    public static final /* synthetic */ void access$showShimmer(RecipientView recipientView) {
        if (!recipientView.isBindingInitialized() || recipientView.getAuthRequestContext) {
            return;
        }
        SkeletonScreen skeletonScreen = recipientView.getCallingPid;
        if (skeletonScreen == null) {
            ShimmeringUtil shimmeringUtil = ShimmeringUtil.INSTANCE;
            recipientView.getCallingPid = ShimmeringUtil.getAuthRequestContext(recipientView.getBinding().lookAheadTest, R.layout.view_recipient_skeleton);
        } else if (skeletonScreen != null) {
            skeletonScreen.MyBillsEntityDataFactory();
        }
    }

    public static final /* synthetic */ void access$updateRecentGroupSendRecipient(RecipientView recipientView, List list) {
        if (list != null) {
            recipientView.newProxyInstance.clear();
            recipientView.newProxyInstance.addAll(list);
            recipientView.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    public static final /* synthetic */ void access$updateRecentRecipient(RecipientView recipientView, List list) {
        if (list != null) {
            recipientView.isLayoutRequested.clear();
            recipientView.isLayoutRequested.addAll(list);
            recipientView.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    public static /* synthetic */ void addNewBankRecipient$default(RecipientView recipientView, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        if ((i & 2) != 0) {
            str2 = NumberUtils.isValidShowAccountNumber(recipientView.MyBillsEntityDataFactory) ? recipientView.MyBillsEntityDataFactory : "";
        }
        BaseActivity baseActivity = recipientView.getBaseActivity();
        BankRecipientActivity bankRecipientActivity = baseActivity instanceof BankRecipientActivity ? (BankRecipientActivity) baseActivity : null;
        if (bankRecipientActivity != null) {
            bankRecipientActivity.startAddBankAccountActivity(str, str2, recipientView.isFirstTime);
            if (recipientView.PrepareContext.isEmpty() && recipientView.isFirstTime) {
                bankRecipientActivity.finish();
            }
        }
        BaseActivity baseActivity2 = recipientView.getBaseActivity();
        SearchRecipientActivity searchRecipientActivity = baseActivity2 instanceof SearchRecipientActivity ? (SearchRecipientActivity) baseActivity2 : null;
        if (searchRecipientActivity == null || !recipientView.PrepareContext.isEmpty() || recipientView.isFirstTime) {
            return;
        }
        searchRecipientActivity.startAddBankAccountActivity(str, str2);
        SendMoneyAnalyticTracker.CC.MyBillsEntityDataFactory(recipientView.getSendMoneyAnalyticTracker(), "BANK", false, null, true, 4);
    }

    private final void getAuthRequestContext() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        this.DatabaseTableConfigUtil = false;
        SearchView searchView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion;
        searchView.clearKeyword();
        searchView.clearSearchFocus();
        KeyboardHelper.BuiltInFictitiousFunctionClassFactory(searchView.getBaseActivity());
        if (!this.NetworkUserEntityData$$ExternalSyntheticLambda4) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = true;
            getAuthRequestContext("");
            KClassImpl$Data$declaredNonStaticMembers$2();
        }
        if (this.moveToNextValue) {
            this.moveToNextValue = false;
            post(new RecipientView$$ExternalSyntheticLambda7(this));
        }
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        RecyclerView recyclerView = getBinding().BuiltInFictitiousFunctionClassFactory;
        DiffUtil.ItemCallback<RecipientViewModel> itemCallback = RecipientViewModel.newProxyInstance;
        Intrinsics.checkNotNullExpressionValue(itemCallback, "");
        RecipientAdapter recipientAdapter = new RecipientAdapter(itemCallback);
        recipientAdapter.getAuthRequestContext = this.enableInvite;
        recipientAdapter.MyBillsEntityDataFactory = this.notBankListRecent;
        recipientAdapter.BuiltInFictitiousFunctionClassFactory = this.notContactListRecent;
        recipientAdapter.MyBillsEntityDataFactory = new ThrottledOnItemClickListener(0L, new RecipientView$setupRecyclerView$1$1$1(this), 1, null);
        recipientAdapter.scheduleImpl = new RecipientSelectedListener() { // from class: id.dana.sendmoney_v2.recipient.view.RecipientView$getRecipientSelectedListener$1
            @Override // id.dana.sendmoney.view.BaseRecipientListener
            public final void onRecipientSelected(final RecipientModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                ThrottledOnExecuteAction access$getThrottledOnExecuteAction = RecipientView.access$getThrottledOnExecuteAction(RecipientView.this);
                final RecipientView recipientView = RecipientView.this;
                access$getThrottledOnExecuteAction.KClassImpl$Data$declaredNonStaticMembers$2(1, new Function0<Unit>() { // from class: id.dana.sendmoney_v2.recipient.view.RecipientView$getRecipientSelectedListener$1$onRecipientSelected$1
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
                        RecipientView.access$notifyListener(RecipientView.this, p0);
                    }
                }, 1000L);
            }

            @Override // id.dana.sendmoney.view.RecipientSelectedListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                ThrottledOnExecuteAction access$getThrottledOnExecuteAction = RecipientView.access$getThrottledOnExecuteAction(RecipientView.this);
                final RecipientView recipientView = RecipientView.this;
                access$getThrottledOnExecuteAction.KClassImpl$Data$declaredNonStaticMembers$2(2, new Function0<Unit>() { // from class: id.dana.sendmoney_v2.recipient.view.RecipientView$getRecipientSelectedListener$1$showBottomSheetBankRecipient$1
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        RecipientView.addNewBankRecipient$default(RecipientView.this, null, null, 3, null);
                    }
                }, 1000L);
            }
        };
        recipientAdapter.lookAheadTest = new RecipientMoreActionListener() { // from class: id.dana.sendmoney_v2.recipient.view.RecipientView$getRecipientMoreSelectedListener$1
            @Override // id.dana.sendmoney_v2.recipient.view.RecipientMoreActionListener
            public final void BuiltInFictitiousFunctionClassFactory(RecipientModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                BaseActivity baseActivity = RecipientView.this.getBaseActivity();
                BankRecipientActivity bankRecipientActivity = baseActivity instanceof BankRecipientActivity ? (BankRecipientActivity) baseActivity : null;
                if (bankRecipientActivity != null) {
                    bankRecipientActivity.showManageAccountBottomSheet(p0);
                }
            }
        };
        recipientAdapter.PlaceComponentResult = this.MyBillsEntityDataFactory;
        this.FragmentBottomSheetPaymentSettingBinding = recipientAdapter;
        recyclerView.setAdapter(recipientAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        if (this.enableViewSection && recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(MyBillsEntityDataFactory());
        }
        ViewCompat.BuiltInFictitiousFunctionClassFactory((View) recyclerView, true);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: id.dana.sendmoney_v2.recipient.view.RecipientView$getOnScrollListener$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void onScrolled(RecyclerView p0, int p1, int p2) {
                RecipientAdapter recipientAdapter2;
                boolean z;
                boolean PlaceComponentResult;
                Intrinsics.checkNotNullParameter(p0, "");
                RecipientView recipientView = RecipientView.this;
                recipientAdapter2 = recipientView.FragmentBottomSheetPaymentSettingBinding;
                if (recipientAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    recipientAdapter2 = null;
                }
                if (recipientAdapter2.getPlaceComponentResult() > 2) {
                    RecipientView recipientView2 = RecipientView.this;
                    PlaceComponentResult = RecipientView.PlaceComponentResult(p0);
                    if (!PlaceComponentResult) {
                        z = true;
                        RecipientView.access$showFabBackToTop(recipientView, z);
                    }
                }
                z = false;
                RecipientView.access$showFabBackToTop(recipientView, z);
            }
        });
        Group group = getBinding().KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(group, "");
        ViewExtKt.getAuthRequestContext(group, new View.OnClickListener() { // from class: id.dana.sendmoney_v2.recipient.view.RecipientView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecipientView.$r8$lambda$4whfPzuFSlZsFc1ALcmbKAfz5_U(RecipientView.this, view);
            }
        });
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.recipient.view.RecipientView$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecipientView.$r8$lambda$k2O0AOg2v8dc_2EMtHLJUjhGWEE(RecipientView.this, view);
            }
        });
        getBinding().getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.recipient.view.RecipientView$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecipientView.$r8$lambda$bw6TrQyiqoT2Jo_SWtvAwZWF7ZU(RecipientView.this, view);
            }
        });
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.recipient.view.RecipientView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecipientView.m2938$r8$lambda$SyTZIehxBiayit6tum_DSDbEBA(RecipientView.this, view);
            }
        });
        getSortingSendMoneyPresenter().getAuthRequestContext();
    }
}
