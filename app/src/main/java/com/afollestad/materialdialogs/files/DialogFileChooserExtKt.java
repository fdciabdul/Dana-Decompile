package com.afollestad.materialdialogs.files;

import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.WhichButton;
import com.afollestad.materialdialogs.actions.DialogActionExtKt;
import com.afollestad.materialdialogs.customview.DialogCustomViewExtKt;
import com.afollestad.materialdialogs.files.util.FilesUtilExtKt;
import com.afollestad.materialdialogs.input.DialogInputExtKt;
import com.afollestad.materialdialogs.internal.list.DialogRecyclerView;
import com.afollestad.materialdialogs.utils.MDUtil;
import com.ap.zoloz.hummer.biz.HummerConstants;
import java.io.File;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u009f\u0001\u0010\u0016\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0004\u0018\u0001`\u000b2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e20\b\u0002\u0010\u0015\u001a*\u0012\u000b\u0012\t\u0018\u00010\u0004¢\u0006\u0002\b\u0013\u0012\u000b\u0012\t\u0018\u00010\u0007¢\u0006\u0002\b\u0013\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012j\u0004\u0018\u0001`\u0014¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0007*\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0019\u001a3\u0010\u001d\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u001bH\u0000¢\u0006\u0004\b\u001d\u0010\u001e*N\u0010\u001f\"$\u0012\u000b\u0012\t\u0018\u00010\u0004¢\u0006\u0002\b\u0013\u0012\u000b\u0012\t\u0018\u00010\u0007¢\u0006\u0002\b\u0013\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00122$\u0012\u000b\u0012\t\u0018\u00010\u0004¢\u0006\u0002\b\u0013\u0012\u000b\u0012\t\u0018\u00010\u0007¢\u0006\u0002\b\u0013\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012*&\u0010 \"\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\t"}, d2 = {"Landroid/widget/EditText;", "", "blockReservedCharacters", "(Landroid/widget/EditText;)V", "Lcom/afollestad/materialdialogs/MaterialDialog;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Ljava/io/File;", "initialDirectory", "Lkotlin/Function1;", "", "Lcom/afollestad/materialdialogs/files/FileFilter;", "filter", "waitForPositiveButton", "", "emptyTextRes", "allowFolderCreation", "folderCreationLabel", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "Lcom/afollestad/materialdialogs/files/FileCallback;", "selection", "fileChooser", "(Lcom/afollestad/materialdialogs/MaterialDialog;Landroid/content/Context;Ljava/io/File;Lkotlin/jvm/functions/Function1;ZIZLjava/lang/Integer;Lkotlin/jvm/functions/Function2;)Lcom/afollestad/materialdialogs/MaterialDialog;", "selectedFile", "(Lcom/afollestad/materialdialogs/MaterialDialog;)Ljava/io/File;", "parent", "Lkotlin/Function0;", "onCreation", "showNewFolderCreator", "(Lcom/afollestad/materialdialogs/MaterialDialog;Ljava/io/File;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)V", "FileCallback", "FileFilter"}, k = 2, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class DialogFileChooserExtKt {
    public static final File selectedFile(MaterialDialog materialDialog) {
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

    public static final MaterialDialog fileChooser(final MaterialDialog materialDialog, Context context, File file, Function1<? super File, Boolean> function1, boolean z, int i, boolean z2, Integer num, final Function2<? super MaterialDialog, ? super File, Unit> function2) {
        DialogFileChooserExtKt$fileChooser$4 dialogFileChooserExtKt$fileChooser$4;
        Function1<? super File, Boolean> function12;
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        Intrinsics.checkParameterIsNotNull(context, "");
        if (z2) {
            if (!FilesUtilExtKt.hasWriteStoragePermission(materialDialog)) {
                throw new IllegalStateException("You must have the WRITE_EXTERNAL_STORAGE permission first.".toString());
            }
            if (function1 == null) {
                dialogFileChooserExtKt$fileChooser$4 = new Function1<File, Boolean>() { // from class: com.afollestad.materialdialogs.files.DialogFileChooserExtKt$fileChooser$2
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
                function12 = dialogFileChooserExtKt$fileChooser$4;
            }
            function12 = function1;
        } else if (!FilesUtilExtKt.hasReadStoragePermission(materialDialog)) {
            throw new IllegalStateException("You must have the READ_EXTERNAL_STORAGE permission first.".toString());
        } else {
            if (function1 == null) {
                dialogFileChooserExtKt$fileChooser$4 = new Function1<File, Boolean>() { // from class: com.afollestad.materialdialogs.files.DialogFileChooserExtKt$fileChooser$4
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
                function12 = dialogFileChooserExtKt$fileChooser$4;
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
        final FileChooserAdapter fileChooserAdapter = new FileChooserAdapter(materialDialog, file, z, textView, false, function12, z2, num, function2);
        dialogRecyclerView.setAdapter(fileChooserAdapter);
        if (z && function2 != null) {
            DialogActionExtKt.setActionButtonEnabled(materialDialog, WhichButton.POSITIVE, false);
            MaterialDialog.positiveButton$default(materialDialog, null, null, new Function1<MaterialDialog, Unit>() { // from class: com.afollestad.materialdialogs.files.DialogFileChooserExtKt$fileChooser$6
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

    /* JADX WARN: Type inference failed for: r6v0, types: [com.afollestad.materialdialogs.DialogBehavior, kotlin.jvm.internal.DefaultConstructorMarker] */
    public static final void showNewFolderCreator(MaterialDialog materialDialog, final File file, final Integer num, final Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        Intrinsics.checkParameterIsNotNull(file, "");
        Intrinsics.checkParameterIsNotNull(function0, "");
        ?? r6 = 0;
        MaterialDialog materialDialog2 = new MaterialDialog(materialDialog.getWindowContext(), r6, 2, r6);
        MaterialDialog.title$default(materialDialog2, num != null ? num : Integer.valueOf(R.string.files_new_folder), null, 2, null);
        DialogInputExtKt.input$default(materialDialog2, null, Integer.valueOf(R.string.files_new_folder_hint), null, null, 0, null, false, false, new Function2<MaterialDialog, CharSequence, Unit>() { // from class: com.afollestad.materialdialogs.files.DialogFileChooserExtKt$showNewFolderCreator$$inlined$show$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* bridge */ /* synthetic */ Unit invoke(MaterialDialog materialDialog3, CharSequence charSequence) {
                invoke2(materialDialog3, charSequence);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(MaterialDialog materialDialog3, CharSequence charSequence) {
                Intrinsics.checkParameterIsNotNull(materialDialog3, "");
                Intrinsics.checkParameterIsNotNull(charSequence, "");
                File file2 = file;
                String obj = charSequence.toString();
                if (obj == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                new File(file2, StringsKt.trim((CharSequence) obj).toString()).mkdir();
                function0.invoke();
            }
        }, 253, null);
        materialDialog2.show();
        blockReservedCharacters(DialogInputExtKt.getInputField(materialDialog2));
    }

    private static final void blockReservedCharacters(EditText editText) {
        editText.setFilters((InputFilter[]) ArraysKt.plus((DialogFileChooserExtKt$blockReservedCharacters$1[]) editText.getFilters(), new InputFilter() { // from class: com.afollestad.materialdialogs.files.DialogFileChooserExtKt$blockReservedCharacters$1
            @Override // android.text.InputFilter
            public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                Intrinsics.checkExpressionValueIsNotNull(charSequence, "");
                if (charSequence.length() == 0) {
                    return null;
                }
                if (StringsKt.indexOf$default((CharSequence) "?:\"*|/\\<>", charSequence.charAt(charSequence.length() - 1), 0, false, 6, (Object) null) >= 0) {
                    return charSequence.subSequence(0, charSequence.length() - 1);
                }
                return null;
            }
        }));
    }
}
