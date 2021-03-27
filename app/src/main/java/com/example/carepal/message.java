package com.example.carepal;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class message extends AppCompatDialogFragment {
    private messageListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder((getActivity()));
        builder.setIcon(R.drawable.ic_thumb);
        builder.setTitle("INFO")
                .setMessage("***************  GOOD JOB  ***************")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listener.onOkClicked();
                    }
                });

        return builder.create();
    }

    public interface messageListener {
        void onOkClicked();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (messageListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + "Error");
        }
    }
}
