package com.example.test;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.ArrayList;
import java.util.List;


public class QuestionFragmentStateAdapter extends FragmentStateAdapter {
    private List<Question> question;
    public QuestionFragmentStateAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.question = this.intDatas();
    }

    private List<Question> intDatas() {
        Question q1 = new Question(String.valueOf(getItemId(R.string.app_name)), "to'g'ri javob 1", "yolg'on", "noto'g'ri", "bo'lmagan gap");
        Question q2 = new Question("Ikkinchi savol", "to'g'ri javob 2", "yolg'on", "noto'g'ri", "bo'lmagan gap");
        Question q3 = new Question("Uchinchi savol", "to'g'ri javob 3", "yolg'on", "noto'g'ri", "bo'lmagan gap");
        Question q4 = new Question("To'rtinchi savol", "to'g'ri javob 4", "yolg'on", "noto'g'ri", "bo'lmagan gap");

        List<Question> list = new ArrayList<Question>();
        list.add(q1);
        list.add(q2);
        list.add(q3);
        list.add(q4);
        return list;
    }

    public QuestionFragmentStateAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public QuestionFragmentStateAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Question question = this.question.get(position);
        return new QuestionPageFragment(question);
    }

    @Override
    public int getItemCount() {
        return this.question.size();
    }
}
