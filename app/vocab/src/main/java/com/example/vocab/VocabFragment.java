package com.example.vocab;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

public class VocabFragment  extends DialogFragment {

    private Button saveButton;
    private VocabDatabase db;
    private VocabDao vocabDao;
    Vocab vocab;
    VocabFragment(Vocab vocab){
        this.vocab = vocab;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.vocab_layout, container, false);
        TextView defTextView = rootView.findViewById(R.id.defTextView);
        defTextView.setText(vocab.def);
        TextView ipaTextView = rootView.findViewById(R.id.ipaTextView);
        ipaTextView.setText(vocab.ipa);

        saveButton = rootView.findViewById(R.id.saveButton);
        db = Room.databaseBuilder(getActivity().getApplicationContext(),
                VocabDatabase.class, "vocab_database").build();
        vocabDao = db.vocabDao();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        VocabEntity vocabEntity = new VocabEntity(0, vocab.term, vocab.def, vocab.ipa);
                        vocabDao.insert(vocabEntity);
                        // update UI on the main thread
                    }
                }).start();
            }
        });

        return rootView;
    }
}


