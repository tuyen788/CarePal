package com.example.carepal;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class warning extends AppCompatDialogFragment {
    private warningListener listener;
    @NonNull
    @Override
    //this makes the dialog for warning, if medicine not taken
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setIcon(R.drawable.ic_warning);
        builder.setTitle("WARNING");
        builder.setMessage("Please take your medicine. Not taking prescribed medicine could cause deadly complications");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.clicked();
            }
        });
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener = (warningListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "something went wrong");
        }
    }

    public interface warningListener {
        void clicked();
    }
}
