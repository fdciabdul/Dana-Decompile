package com.afollestad.materialdialogs.files;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.WhichButton;
import com.afollestad.materialdialogs.actions.DialogActionExtKt;
import com.afollestad.materialdialogs.customview.DialogCustomViewExtKt;
import com.afollestad.materialdialogs.files.util.FilesUtilExtKt;
import com.afollestad.materialdialogs.internal.list.DialogRecyclerView;
import com.afollestad.materialdialogs.utils.MDUtil;
import com.ap.zoloz.hummer.biz.HummerConstants;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u009f\u0001\u0010\u0013\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u00072\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n20\b\u0002\u0010\u0012\u001a*\u0012\u000b\u0012\t\u0018\u00010\u0000¢\u0006\u0002\b\u000f\u0012\u000b\u0012\t\u0018\u00010\u0003¢\u0006\u0002\b\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000ej\u0004\u0018\u0001`\u0011¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003*\u00020\u0000¢\u0006\u0004\b\u0015\u0010\u0016"}, d2 = {"Lcom/afollestad/materialdialogs/MaterialDialog;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Ljava/io/File;", "initialDirectory", "Lkotlin/Function1;", "", "Lcom/afollestad/materialdialogs/files/FileFilter;", "filter", "waitForPositiveButton", "", "emptyTextRes", "allowFolderCreation", "folderCreationLabel", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "", "Lcom/afollestad/materialdialogs/files/FileCallback;", "selection", "folderChooser", "(Lcom/afollestad/materialdialogs/MaterialDialog;Landroid/content/Context;Ljava/io/File;Lkotlin/jvm/functions/Function1;ZIZLjava/lang/Integer;Lkotlin/jvm/functions/Function2;)Lcom/afollestad/materialdialogs/MaterialDialog;", "selectedFolder", "(Lcom/afollestad/materialdialogs/MaterialDialog;)Ljava/io/File;"}, k = 2, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class DialogFolderChooserExtKt {
    public static final File selectedFolder(MaterialDialog materialDialog) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        View findViewById = DialogCustomViewExtKt.getCustomView(materialDialog).findViewById(R.id.list);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "");
        RecyclerView.Adapter adapter = ((DialogRecyclerView) findViewById).getAdapter();
        if (!(adapter instanceof FileChooserAdapter)) {
            adapter = null;
        }
        FileChooserAdapter fileChooserAdapter = (FileChooserAdapter) adapter;
        if (fileChooserAdapter != null) {
            return fileChooserAdapter.getSelectedFile();
        }
        return null;
    }

    public static final MaterialDialog folderChooser(final MaterialDialog materialDialog, Context context, File file, Function1<? super File, Boolean> function1, boolean z, int i, boolean z2, Integer num, final Function2<? super MaterialDialog, ? super File, Unit> function2) {
        DialogFolderChooserExtKt$folderChooser$4 dialogFolderChooserExtKt$folderChooser$4;
        Function1<? super File, Boolean> function12;
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        Intrinsics.checkParameterIsNotNull(context, "");
        if (z2) {
            if (!FilesUtilExtKt.hasWriteStoragePermission(materialDialog)) {
                throw new IllegalStateException("You must have the WRITE_EXTERNAL_STORAGE permission first.".toString());
            }
            if (function1 == null) {
                dialogFolderChooserExtKt$folderChooser$4 = new Function1<File, Boolean>() { // from class: com.afollestad.materialdialogs.files.DialogFolderChooserExtKt$folderChooser$2
                    @Override // kotlin.jvm.functions.Function1
                    public final /* synthetic */ Boolean invoke(File file2) {
                        return Boolean.valueOf(invoke2(file2));
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final boolean invoke2(File file2) {
                        Intrinsics.checkParameterIsNotNull(file2, "");
                        return !file2.isHidden() && file2.canWrite();
                    }
                };
                function12 = dialogFolderChooserExtKt$folderChooser$4;
            }
            function12 = function1;
        } else if (!FilesUtilExtKt.hasReadStoragePermission(materialDialog)) {
            throw new IllegalStateException("You must have the READ_EXTERNAL_STORAGE permission first.".toString());
        } else {
            if (function1 == null) {
                dialogFolderChooserExtKt$folderChooser$4 = new Function1<File, Boolean>() { // from class: com.afollestad.materialdialogs.files.DialogFolderChooserExtKt$folderChooser$4
                    @Override // kotlin.jvm.functions.Function1
                    public final /* synthetic */ Boolean invoke(File file2) {
                        return Boolean.valueOf(invoke2(file2));
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final boolean invoke2(File file2) {
                        Intrinsics.checkParameterIsNotNull(file2, "");
                        return !file2.isHidden() && file2.canRead();
                    }
                };
                function12 = dialogFolderChooserExtKt$folderChooser$4;
            }
            function12 = function1;
        }
        if (!(file != null)) {
            throw new IllegalStateException("The initial directory is null.".toString());
        }
        DialogCustomViewExtKt.customView$default(materialDialog, Integer.valueOf(R.layout.md_file_chooser_base), null, false, true, false, false, 54, null);
        DialogActionExtKt.setActionButtonEnabled(materialDialog, WhichButton.POSITIVE, false);
        View customView = DialogCustomViewExtKt.getCustomView(materialDialog);
        View findViewById = customView.findViewById(R.id.list);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "");
        DialogRecyclerView dialogRecyclerView = (DialogRecyclerView) findViewById;
        View findViewById2 = customView.findViewById(R.id.empty_text);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "");
        TextView textView = (TextView) findViewById2;
        textView.setText(i);
        MDUtil.maybeSetTextColor$default(MDUtil.INSTANCE, textView, materialDialog.getWindowContext(), Integer.valueOf(R.attr.md_color_content), null, 4, null);
        dialogRecyclerView.attach(materialDialog);
        dialogRecyclerView.setLayoutManager(new LinearLayoutManager(materialDialog.getWindowContext()));
        final FileChooserAdapter fileChooserAdapter = new FileChooserAdapter(materialDialog, file, z, textView, true, function12, z2, num, function2);
        dialogRecyclerView.setAdapter(fileChooserAdapter);
        if (z && function2 != null) {
            MaterialDialog.positiveButton$default(materialDialog, null, null, new Function1<MaterialDialog, Unit>() { // from class: com.afollestad.materialdialogs.files.DialogFolderChooserExtKt$folderChooser$6
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(MaterialDialog materialDialog2) {
                    invoke2(materialDialog2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(MaterialDialog materialDialog2) {
                    Intrinsics.checkParameterIsNotNull(materialDialog2, "");
                    File selectedFile = fileChooserAdapter.getSelectedFile();
                    if (selectedFile != null) {
                        function2.invoke(MaterialDialog.this, selectedFile);
                    }
                }
            }, 3, null);
        }
        return materialDialog;
    }
}
