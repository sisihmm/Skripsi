package com.anas.skripsi;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class AccountFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;

    public AccountFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AccountFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AccountFragment newInstance(String param1, String param2) {
        AccountFragment fragment = new AccountFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

            private FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup vgroup  = (ViewGroup) inflater.inflate(R.layout.fragment_account, null);
        TextView hmail = (TextView) vgroup.findViewById(R.id.tvcallemail);
        CardView cvEmail = (CardView) vgroup.findViewById(R.id.cvCemail);
        CardView cvPass = (CardView) vgroup.findViewById(R.id.cvCpassw);
        CardView cvLogout = (CardView) vgroup.findViewById(R.id.cvLogout);


        cvEmail.setOnClickListener(v -> {
            Intent i = new Intent(getActivity().getApplication(),change_email.class);
            startActivity(i);
        });

        cvLogout.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            Intent i = new Intent(getActivity().getApplication(),Login.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        });

        cvPass.setOnClickListener(v -> {
            Intent i = new Intent(getActivity().getApplication(),change_password.class);
            startActivity(i);
        });

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser userDb = mAuth.getCurrentUser();
        FirebaseFirestore dbActivity = FirebaseFirestore.getInstance();

        dbActivity.collection("users").document(userDb.getUid()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                Log.d("USERS", "onComplete: " + task.getResult().getString("email"));
                hmail.setText(task.getResult().getString("email"));

            }


        });
        return vgroup;
    }
}