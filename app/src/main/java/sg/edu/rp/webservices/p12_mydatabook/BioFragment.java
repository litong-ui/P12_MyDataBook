package sg.edu.rp.webservices.p12_mydatabook;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BioFragment extends Fragment {

    TextView tvBio;
    Button btnEdit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bio, container, false);

        tvBio = view.findViewById(R.id.textView3);
        btnEdit = view.findViewById(R.id.btnEdit);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater1 = (LayoutInflater) getActivity().getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater1.inflate(R.layout.input, null);

                final EditText etInput = viewDialog.findViewById(R.id.editText);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(getActivity());
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Edit Bio");
                myBuilder.setCancelable(true);
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String message = etInput.getText().toString();
                        tvBio.setText(message);
                    }
                });
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        return view;
    }
}