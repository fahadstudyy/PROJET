package com.example.ssvlvotings.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.ssvlvotings.R;
import com.example.ssvlvotings.currentuser;
import com.example.ssvlvotings.signup;
import com.example.ssvlvotings.viewinfo;

public class ProfileFragment extends Fragment {
    Button viewdata;
    TextView mail;
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.activity_fragment_profile,container,false);
        viewdata = (Button) v.findViewById(R.id.viewdata);
        viewdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(getActivity(), viewinfo.class);
                intent.putExtra("data","some data");
                startActivity(intent);
            }
        });

        return v;
    }
}
