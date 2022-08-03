package com.project.userapp.ui.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.project.userapp.R;

import java.util.ArrayList;
import java.util.List;

public class AboutFragment extends Fragment {
    private ViewPager viewPager;
    private CourseAdapter adapter;
    private List<CourseModel> list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        list = new ArrayList<>();
        list.add(new CourseModel(R.drawable.ic_coa, "Computer Organization and Arch.", "Computer Organization and Architecture Tutorial provides in-depth knowledge of internal working, structuring, and implementation of a computer system. Whereas, Organization defines the way the system is structured so that all those catalogued tools can be used properly.Our Computer Organization and Architecture Tutorial includes all topics of such as introduction, ER model, keys, relational model, join operation, SQL, functional dependency, transaction, concurrency control, etc."));
        list.add(new CourseModel(R.drawable.ic_java, "OOP in C++,Java,Python", "The Java programming language was developed by Sun Microsystems in the early 1990s. Although it is primarily used for Internet-based applications, Java is a simple, efficient, general-purpose language. Java was originally designed for embedded network applications running on multiple platforms. It is a portable, object-oriented, interpreted language.Java is extremely portable. "));
      list.add(new CourseModel(R.drawable.ic_java, "Data Structure and Algorithm", "Data Structures are the programmatic way of storing data so that data can be used efficiently. Almost every enterprise application uses various types of data structures in one or the other way. This tutorial will give you a great understanding on Data Structures needed to understand the complexity of enterprise level applications and need of algorithms, and data structures."));
      list.add(new CourseModel(R.drawable.ic_java, "Calculus", "Calculus is the branch of mathematics that deals with continuous change. Calculus is also called infinitesimal calculus or “the calculus of infinitesimals”. The meaning of classical calculus is the study of continuous change of functions. the prerequisite for Calculus is to have an overall comfort with algebra, geometry, and trigonometry. "));
      list.add(new CourseModel(R.drawable.ic_java, "DBMS", "Database Management System or DBMS in short refers to the technology of storing and retrieving usersí data with utmost efficiency along with appropriate security measures. This tutorial explains the basics of DBMS such as its architecture, data models, data schemas, data independence, E-R model, relation model, relational database design, and storage and file structure and much more."));

        adapter = new CourseAdapter(getContext(),list);

        viewPager = view.findViewById(R.id.viewPager);

        viewPager.setAdapter(adapter);

        ImageView imageView = view.findViewById(R.id.college_image);
        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/my-college-app-85291.appspot.com/o/Gallery%2F%5BB%40e864028jpg?alt=media&token=cb26c715-5628-480f-93ad-c04427f6bd06")
                .into(imageView);
        return view;
    }
}