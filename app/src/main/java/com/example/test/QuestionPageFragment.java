package com.example.test;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class QuestionPageFragment extends Fragment {
    private static final String LOG_TAG = "AndroidExample";
    private Question question;
    private Button buttonTrueAnswer;
    private TextView textViewQuestion;
    private Button buttonFalseAnswer1;
    private Button buttonFalseAnswer2;
    private Button buttonFalseAnswer3;
    int numberOfTrueAnswer;
    private static int counter = 0;

    public QuestionPageFragment() {
    }

    public QuestionPageFragment(Question question) {
        this.question = question;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = (ViewGroup) inflater.inflate(
                R.layout.fragment_question, container, false);

        counter++;
        if (counter % 2 == 0) {
            view.setBackgroundColor(Color.parseColor("#ebdef0"));
        } else {
            view.setBackgroundColor(Color.parseColor("#e8f8f5"));
        }

        this.textViewQuestion = view.findViewById(R.id.textView_question);
        this.buttonTrueAnswer = view.findViewById(R.id.button_true_answer);
        this.buttonFalseAnswer1 = view.findViewById(R.id.button_false_answer1);
        this.buttonFalseAnswer2 = view.findViewById(R.id.button_false_answer2);
        this.buttonFalseAnswer3 = view.findViewById(R.id.button_false_answer3);
        return view;
    }

    public void onSaveInstanceState(@NonNull Bundle outState) {
        Log.i(LOG_TAG, "onSaveInstanceState: save employee data to Bundle");
        // Convert employee object to Bundle.
        Bundle dataBundle = this.questionToBundle(this.question);
        outState.putAll(dataBundle);

        super.onSaveInstanceState(outState);
    }
    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        Log.i(LOG_TAG, "onViewStateRestored");

        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.i(LOG_TAG, "onViewCreated");
        super.onViewCreated(view, savedInstanceState);

        if(this.question == null)  {
            Log.i(LOG_TAG, "Get employee data from savedInstanceState");
            // The state was saved by onSaveInstanceState(Bundle outState) method.
            this.question = this.bundleToQuestion(savedInstanceState);
        }
        this.showInGUI(this.question);
    }

    private void showInGUI(Question question)  {
        this.textViewQuestion.setText(question.getQuestion());
        this.buttonTrueAnswer.setText(question.getTrueAnswer());
        this.buttonFalseAnswer1.setText(question.getFalseAnswer1());
        this.buttonFalseAnswer2.setText(question.getFalseAnswer2());
        this.buttonFalseAnswer3.setText(question.getFalseAnswer3());
    }

    private Bundle questionToBundle(Question question)  {
        Bundle bundle = new Bundle();
        bundle.putString("question", question.getQuestion());
        bundle.putString("trueAnswer", question.getTrueAnswer());
        bundle.putString("falseAnswer1", question.getFalseAnswer1());
        bundle.putString("falseAnswer1", question.getFalseAnswer2());
        bundle.putString("falseAnswer1", question.getFalseAnswer3());
        return bundle;
    }

    private Question bundleToQuestion(Bundle savedInstanceState) {
        String question = savedInstanceState.getString("question");
        String trueAnswer = savedInstanceState.getString("trueAnswer");
        String falseAnswer1 = savedInstanceState.getString("falseAnswer1");
        String falseAnswer2 = savedInstanceState.getString("falseAnswer2");
        String falseAnswer3 = savedInstanceState.getString("falseAnswer3");
        return new Question(question,  trueAnswer,  falseAnswer1, falseAnswer2, falseAnswer3 );
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_true_answer:
                numberOfTrueAnswer++;
                buttonTrueAnswer.setEnabled(false);
                buttonFalseAnswer1.setEnabled(true);
                buttonFalseAnswer2.setEnabled(true);
                buttonFalseAnswer3.setEnabled(true);
                break;
            case R.id.button_false_answer1:
                numberOfTrueAnswer--;
                buttonTrueAnswer.setEnabled(true);
                buttonFalseAnswer1.setEnabled(false);
                buttonFalseAnswer2.setEnabled(true);
                buttonFalseAnswer3.setEnabled(true);
                break;
            case R.id.button_false_answer2:
                numberOfTrueAnswer--;
                buttonTrueAnswer.setEnabled(true);
                buttonFalseAnswer1.setEnabled(true);
                buttonFalseAnswer2.setEnabled(false);
                buttonFalseAnswer3.setEnabled(true);
                break;
            case R.id.button_false_answer3:
                numberOfTrueAnswer--;
                buttonTrueAnswer.setEnabled(true);
                buttonFalseAnswer1.setEnabled(true);
                buttonFalseAnswer2.setEnabled(true);
                buttonFalseAnswer3.setEnabled(false);
                break;
        }
    }

}
