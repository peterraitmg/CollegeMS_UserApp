package com.project.userapp.ui.faculty;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.project.userapp.R;

import java.util.ArrayList;
import java.util.List;

public class FacultyFragment extends Fragment {
    private RecyclerView coDepartment, javaDepartment, dsaDepartment, calDepartment, dbDepartment;
    private LinearLayout coNoData, javaNoData, dsaNoData, calNoData, dbNoData;
    private List<TeacherData> list1, list2, list3, list4, list5;
    private TeacherAdapter adapter;

    private DatabaseReference reference, dbRef;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_faculty, container, false);
        coDepartment = view.findViewById(R.id.coDepartment);
        javaDepartment = view.findViewById(R.id.javaDepartment);
        dsaDepartment = view.findViewById(R.id.dsaDepartment);
        calDepartment = view.findViewById(R.id.calDepartment);
        dbDepartment = view.findViewById(R.id.dbDepartment);


        coNoData = view.findViewById(R.id.coNoData);
        javaNoData = view.findViewById(R.id.javaNoData);
        dsaNoData = view.findViewById(R.id.dsaNoData);
        calNoData = view.findViewById(R.id.calNoData);
        dbNoData = view.findViewById(R.id.dbNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("teacher");

        coDepartment();
        javaDepartment();
        dsaDepartment();
        calDepartment();
        dbDepartment();

        return view;

    }

    private void coDepartment() {
        dbRef = reference.child("COA");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    coNoData.setVisibility(View.VISIBLE);
                    coDepartment.setVisibility(View.GONE);
                } else {
                    coNoData.setVisibility(View.GONE);
                    coDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    coDepartment.setHasFixedSize(true);
                    coDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list1, getContext()); //missing category"COA"
                    coDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void javaDepartment() {
        dbRef = reference.child("Java");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    javaNoData.setVisibility(View.VISIBLE);
                    javaDepartment.setVisibility(View.GONE);
                } else {
                    javaNoData.setVisibility(View.GONE);
                    javaDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    javaDepartment.setHasFixedSize(true);
                    javaDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list2, getContext());
                    javaDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void dsaDepartment() {
        dbRef = reference.child("DSA");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    dsaNoData.setVisibility(View.VISIBLE);
                    dsaDepartment.setVisibility(View.GONE);
                } else {
                    dsaNoData.setVisibility(View.GONE);
                    dsaDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    dsaDepartment.setHasFixedSize(true);
                    dsaDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list3, getContext());
                    dsaDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void calDepartment() {
        dbRef = reference.child("Calculus");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    calNoData.setVisibility(View.VISIBLE);
                    calDepartment.setVisibility(View.GONE);
                } else {
                    calNoData.setVisibility(View.GONE);
                    calDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    calDepartment.setHasFixedSize(true);
                    calDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list4, getContext());
                    calDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void dbDepartment() {
        dbRef = reference.child("DBMS");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 = new ArrayList<>();
                if (!dataSnapshot.exists()) {
                    dbNoData.setVisibility(View.VISIBLE);
                    dbDepartment.setVisibility(View.GONE);
                } else {
                    dbNoData.setVisibility(View.GONE);
                    dbDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list5.add(data);
                    }
                    dbDepartment.setHasFixedSize(true);
                    dbDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list5, getContext());
                    dbDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}