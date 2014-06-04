package com.example.whatisthis_mac.whatisthis;

/**
 * Created by oppakub on 6/4/14 AD.
 */
public class Question {
    private int intQuestion;

    public interface OnQuestionChangeListener {
        void onQuestionChangeListener(Question question);
    }

    private OnQuestionChangeListener onQuestionChangeListener;

    public void setOnQuestionChangeListener(OnQuestionChangeListener onQuestionChangeListener) {
        this.onQuestionChangeListener = onQuestionChangeListener;
    }

    public int getIntQuestion() {
        return intQuestion;
    }

    public void setIntQuestion(int intQuestion) {
        this.intQuestion = intQuestion;
        if(this.onQuestionChangeListener != null) {
            this.onQuestionChangeListener.onQuestionChangeListener(this);
        }
    }
}
