package com.example.ajuste.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ajuste.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View root;

        if (this.pageViewModel.getIndex() == 1) {
            root = inflater.inflate(R.layout.conexao, container, false);

        } else if (this.pageViewModel.getIndex() == 2) {
            root = inflater.inflate(R.layout.ajuste, container, false);

        } else if (this.pageViewModel.getIndex() == 3) {
            root = inflater.inflate(R.layout.producao, container, false);

        } else if (this.pageViewModel.getIndex() == 4) {
            root = inflater.inflate(R.layout.mensagem, container, false);

        } else if (this.pageViewModel.getIndex() == 5) {
            root = inflater.inflate(R.layout.configuracao, container, false);

        } else if (this.pageViewModel.getIndex() == 6) {
            root = inflater.inflate(R.layout.estatistica, container, false);
        }

        else {
            root = inflater.inflate(R.layout.fragment_main, container, false);
            final TextView textView = root.findViewById(R.id.section_label);
            pageViewModel.getText().observe(this, new Observer<String>() {
                @Override
                public void onChanged(@Nullable String s) {
                    textView.setText(s);
                }
            });
        }
        return root;
    }
}